/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.policies;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.BorderLayoutData;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.LayoutData;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.graphdef.editor.edit.parts.AbstractFigureEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

public class BorderLayoutEditPolicy extends ConstrainedLayoutEditPolicy {

	private static final Color FEEDBACK_COLOR = ColorConstants.lightBlue;

	private RoundedRectangle myFeedbackFigure;

	private BorderLayoutHelper myFeedbackBoundsHelper;

	@Override
	protected void showLayoutTargetFeedback(Request request) {
		if (RequestConstants.REQ_CREATE.equals(request.getType()) || RequestConstants.REQ_MOVE.equals(request.getType())) {
			DropRequest dropRequest = (DropRequest) request;
			IFigure figure = getLayoutContainer();
			Point where = dropRequest.getLocation().getCopy();
			figure.translateToRelative(where);
			figure.translateFromParent(where);
			where.translate(getLayoutOrigin().getNegated());

			if (myFeedbackBoundsHelper == null) {
				myFeedbackBoundsHelper = new BorderLayoutHelper((AbstractFigureEditPart) getHost());
			}
			Rectangle feedbackBounds = myFeedbackBoundsHelper.getFeedbackBounds(where);
			figure.translateToParent(feedbackBounds);
			figure.translateToAbsolute(feedbackBounds);
			getFeedbackLayer().translateToRelative(feedbackBounds);

			if (myFeedbackFigure == null) {
				myFeedbackFigure = new RoundedRectangle();
				myFeedbackFigure.setFill(false);
				myFeedbackFigure.setOutline(true);
				myFeedbackFigure.setForegroundColor(FEEDBACK_COLOR);
				myFeedbackFigure.setLineWidth(2);
				myFeedbackFigure.setAntialias(SWT.ON);
				myFeedbackFigure.setBounds(feedbackBounds);
				getFeedbackLayer().add(myFeedbackFigure);
			} else {
				myFeedbackFigure.setBounds(feedbackBounds);
			}
		}
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		/**
		 * RequestConstants.REQ_DROP can be used here together with
		 * RequestConstants.REQ_MOVE due to the current
		 * DragEditPartsTrackerEx.handleDragInProgress() implementation.
		 * 
		 * Currently .handleDragInProgress() calls:
		 * 
		 * 1. updateTargetRequest() setting targetRequest type to
		 * getCommandName() (RequestConstants.REQ_MOVE)
		 * 
		 * 2. updateTargetUnderMouse(), showTargetFeedback(),
		 * showSourceFeedback() using current target request with the type set
		 * on step 1.
		 * 
		 * 3. setCurrentCommand(getCommand()); where (in addSourceCommands())
		 * request type will be set to RequestConstants.REQ_DROP
		 * 
		 * So, showTargetFeedback(), showSourceFeedback() methods should be able
		 * to react on RequestConstants.REQ_MOVE. In the same time
		 * eraseTargetFeedback() should be sensitive to
		 * RequestConstants.REQ_MOVE (if it was called from
		 * updateTargetUnderMouse() then EditPart was exited) and
		 * RequestConstants.REQ_DROP (if it was called from handleButtonUp())
		 * 
		 * See code for more details.
		 */
		if (RequestConstants.REQ_CREATE.equals(request.getType()) || RequestConstants.REQ_MOVE.equals(request.getType()) || RequestConstants.REQ_DROP.equals(request.getType())) {
			if (myFeedbackFigure != null) {
				getFeedbackLayer().remove(myFeedbackFigure);
				myFeedbackFigure = null;
			}
			myFeedbackBoundsHelper = null;
		} else {
			super.eraseTargetFeedback(request);
		}
	}

	@Override
	protected void showSizeOnDropFeedback(CreateRequest request) {
		Point p = new Point(request.getLocation().getCopy());
		IFigure feedback = getSizeOnDropFeedback(request);
		feedback.translateToRelative(p);
		Dimension size = request.getSize().getCopy();
		feedback.translateToRelative(size);
		feedback.setBounds(new Rectangle(p, size).expand(getCreationFeedbackOffset(request)));
	}

	@Override
	protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
		if (RequestConstants.REQ_MOVE_CHILDREN.equals(request.getType())) {
			Point where = request.getLocation().getCopy();
			getLayoutContainer().translateToRelative(where);
			getLayoutContainer().translateFromParent(where);
			where.translate(getLayoutOrigin().getNegated());
			Rectangle feedbackBounds = new BorderLayoutHelper((AbstractFigureEditPart) getHost()).getFeedbackBounds(where);
			return createChangeConstraintCommand(child, constraint, feedbackBounds);
		} else if (RequestConstants.REQ_RESIZE_CHILDREN.equals(request.getType())) {
			return createChangeSizeCommand(child, request);
		}
		// should never be here
		assert false;
		return null;
	}

	private Command createChangeSizeCommand(EditPart childEditPart, ChangeBoundsRequest request) {
		assert childEditPart instanceof AbstractFigureEditPart;
		AbstractFigureEditPart childFigureEditPart = (AbstractFigureEditPart) childEditPart;
		final RealFigure realFigure = childFigureEditPart.getRealFigure();
		if (request.getSizeDelta() == null) {
			return null;
		}
		if (false == realFigure.getLayoutData() instanceof BorderLayoutData) {
			return null;
		}
		final Dimension sizeDelta = request.getSizeDelta().getCopy();
		getLayoutContainer().translateToRelative(sizeDelta);
		final BorderLayoutData currentLayoutData = (BorderLayoutData) realFigure.getLayoutData();
		if (currentLayoutData.getAlignment() == Alignment.CENTER_LITERAL || currentLayoutData.isVertical() ? sizeDelta.height == 0 : sizeDelta.width == 0) {
			return null;
		}
		return new ICommandProxy(new AbstractTransactionalCommand(childFigureEditPart.getEditingDomain(), "Changing preferred size", Collections.singletonList(WorkspaceSynchronizer.getFile(realFigure
				.eResource()))) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				org.eclipse.gmf.gmfgraph.Dimension preferredSize = realFigure.getPreferredSize();
				if (preferredSize == null) {
					preferredSize = GMFGraphFactory.eINSTANCE.createDimension();
					realFigure.setPreferredSize(preferredSize);
				}
				if (currentLayoutData.isVertical()) {
					preferredSize.setDy(preferredSize.getDy() + sizeDelta.height);
				} else {
					preferredSize.setDx(preferredSize.getDx() + sizeDelta.width);
				}
				return CommandResult.newOKCommandResult();
			}
		});
	}

	@Override
	protected Command createChangeConstraintCommand(EditPart childEditPart, Object constraint) {
		return createChangeConstraintCommand(childEditPart, constraint, null);
	}

	// Extending default createChangeConstraintCommand method with additional
	// (optional) parameter - feedbackBounds
	protected Command createChangeConstraintCommand(EditPart childEditPart, Object constraint, final Rectangle feedbackBounds) {
		assert childEditPart instanceof AbstractFigureEditPart;
		AbstractFigureEditPart childFigureEditPart = (AbstractFigureEditPart) childEditPart;
		assert constraint instanceof BorderLayoutData;
		final BorderLayoutData layoutData = (BorderLayoutData) constraint;
		if (!isValidChildLayoutData(layoutData)) {
			return UnexecutableCommand.INSTANCE;
		}

		final RealFigure realFigure = (RealFigure) childFigureEditPart.getRealFigure();
		return new ICommandProxy(new AbstractTransactionalCommand(childFigureEditPart.getEditingDomain(), "Changing Border Layout Data", Collections.singletonList(WorkspaceSynchronizer
				.getFile(realFigure.eResource()))) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				realFigure.setLayoutData(layoutData);
				if (layoutData.getAlignment() != Alignment.CENTER_LITERAL && feedbackBounds != null) {
					if (realFigure.getPreferredSize() == null) {
						realFigure.setPreferredSize(GMFGraphFactory.eINSTANCE.createDimension());
					}
					org.eclipse.gmf.gmfgraph.Dimension preferredSize = realFigure.getPreferredSize();
					if (preferredSize.getDx() == 0) {
						preferredSize.setDx(feedbackBounds.width);
					}
					if (preferredSize.getDy() == 0) {
						preferredSize.setDy(feedbackBounds.height);
					}
				}
				return CommandResult.newOKCommandResult();
			}
		});
	}

	private boolean isValidChildLayoutData(final BorderLayoutData layoutData) {
		for (Figure childFigure : getRealFigure().getChildren()) {
			LayoutData childFigureLayoutData = childFigure.getLayoutData();
			if (childFigureLayoutData instanceof BorderLayoutData) {
				BorderLayoutData childLayoutData = (BorderLayoutData) childFigureLayoutData;
				if (layoutData.isVertical() == childLayoutData.isVertical() && layoutData.getAlignment() == childLayoutData.getAlignment()) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	protected Object translateToModelConstraint(Object figureConstraint) {
		BorderLayoutData data = GMFGraphFactory.eINSTANCE.createBorderLayoutData();
		if (org.eclipse.draw2d.BorderLayout.BOTTOM == figureConstraint) {
			data.setVertical(true);
			data.setAlignment(Alignment.END_LITERAL);
		} else if (org.eclipse.draw2d.BorderLayout.TOP == figureConstraint) {
			data.setVertical(true);
			data.setAlignment(Alignment.BEGINNING_LITERAL);
		} else if (org.eclipse.draw2d.BorderLayout.LEFT == figureConstraint) {
			data.setVertical(false);
			data.setAlignment(Alignment.BEGINNING_LITERAL);
		} else if (org.eclipse.draw2d.BorderLayout.RIGHT == figureConstraint) {
			data.setVertical(false);
			data.setAlignment(Alignment.END_LITERAL);
		} else {
			assert org.eclipse.draw2d.BorderLayout.CENTER == figureConstraint;
			data.setAlignment(Alignment.CENTER_LITERAL);
		}
		return data;
	}

	@Override
	protected Object getConstraintFor(ChangeBoundsRequest request, GraphicalEditPart child) {
		// Using request (mouse) location to determine new constraints instead
		// of modified child bounds as it was in super. implementation
		IFigure figure = getLayoutContainer();
		Point where = request.getLocation().getCopy();
		figure.translateToRelative(where);
		figure.translateFromParent(where);
		where.translate(getLayoutOrigin().getNegated());
		return getConstraintFor(where);
	}

	@Override
	protected Object getConstraintFor(Point point) {
		return new BorderLayoutHelper((AbstractFigureEditPart) getHost()).getConstraintFor(point);
	}

	@Override
	protected Object getConstraintFor(Rectangle rect) {
		return getConstraintFor(rect.getTopLeft());
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		if (false == request instanceof CreateViewRequest) {
			return null;
		}

		final CreateViewRequest createViewRequest = (CreateViewRequest) request;
		if (createViewRequest.getViewDescriptors().size() != 1) {
			// unable to handle several child elements creation
			return null;
		}
		final ViewDescriptor viewDescriptor = createViewRequest.getViewDescriptors().iterator().next();

		Object modelConstraint = translateToModelConstraint(getConstraintFor(createViewRequest));
		assert modelConstraint instanceof BorderLayoutData;
		final BorderLayoutData childLayoutData = (BorderLayoutData) modelConstraint;
		if (!isValidChildLayoutData(childLayoutData)) {
			return UnexecutableCommand.INSTANCE;
		}

		final Dimension requestedSize;
		if (createViewRequest.getSize() != null) {
			requestedSize = createViewRequest.getSize().getCopy();
			getLayoutContainer().translateToRelative(requestedSize);
		} else {
			Point where = createViewRequest.getLocation().getCopy();
			getLayoutContainer().translateToRelative(where);
			getLayoutContainer().translateFromParent(where);
			where.translate(getLayoutOrigin().getNegated());
			Rectangle feedbackBounds = new BorderLayoutHelper((AbstractFigureEditPart) getHost()).getFeedbackBounds(where);
			requestedSize = feedbackBounds.getSize();
		}

		AbstractFigureEditPart host = (AbstractFigureEditPart) getHost();
		return new ICommandProxy(new AbstractTransactionalCommand(host.getEditingDomain(), "Setting BorderLayoutData for child figure", Collections.singletonList(WorkspaceSynchronizer.getFile(host
				.getRealFigure().eResource()))) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				IAdaptable elementAdapter = viewDescriptor.getElementAdapter();
				RealFigure realFigure = (RealFigure) elementAdapter.getAdapter(RealFigure.class);
				if (realFigure == null) {
					return CommandResult.newErrorCommandResult("Unable to locate newly created child figure");
				}
				realFigure.setLayoutData(childLayoutData);
				if (childLayoutData.getAlignment() != Alignment.CENTER_LITERAL) {
					if (realFigure.getPreferredSize() == null) {
						realFigure.setPreferredSize(GMFGraphFactory.eINSTANCE.createDimension());
					}
					org.eclipse.gmf.gmfgraph.Dimension preferredSize = realFigure.getPreferredSize();
					int requestedWidth;
					int requestedHeight;
					if (createViewRequest.getSize() != null) {
						requestedWidth = requestedSize.width;
						requestedHeight = requestedSize.height;
					} else {
						if (preferredSize.getDx() == 0) {
							requestedWidth = requestedSize.width;
						} else {
							requestedWidth = preferredSize.getDx();
						}
						if (preferredSize.getDy() == 0) {
							requestedHeight = requestedSize.height;
						} else {
							requestedHeight = preferredSize.getDy();
						}
					}
					if (preferredSize.getDy() != requestedHeight) {
						preferredSize.setDy(requestedHeight);
					}
					if (preferredSize.getDx() != requestedWidth) {
						preferredSize.setDx(requestedWidth);
					}
				}
				return CommandResult.newOKCommandResult();
			}

		});
	}

	@Override
	protected EditPolicy createChildEditPolicy(EditPart childEditPart) {
		assert childEditPart instanceof AbstractFigureEditPart;
		AbstractFigureEditPart childFigureEditPart = (AbstractFigureEditPart) childEditPart;
		LayoutData layoutData = childFigureEditPart.getRealFigure().getLayoutData();
		if (false == layoutData instanceof BorderLayoutData) {
			return null;
		}
		BorderLayoutData borderLayoutData = (BorderLayoutData) layoutData;
		ResizableEditPolicy result = new ResizableEditPolicy();
		if (borderLayoutData.getAlignment() == Alignment.CENTER_LITERAL) {
			result.setResizeDirections(PositionConstants.NONE);
		} else if (borderLayoutData.getAlignment() == Alignment.BEGINNING_LITERAL) {
			result.setResizeDirections(borderLayoutData.isVertical() ? PositionConstants.SOUTH : PositionConstants.EAST);
		} else {
			// borderLayoutData.getAlignment() == Alignment.END_LITERAL
			result.setResizeDirections(borderLayoutData.isVertical() ? PositionConstants.NORTH : PositionConstants.WEST);
		}
		return result;
	}

	private RealFigure getRealFigure() {
		return ((AbstractFigureEditPart) getHost()).getRealFigure();
	}

}
