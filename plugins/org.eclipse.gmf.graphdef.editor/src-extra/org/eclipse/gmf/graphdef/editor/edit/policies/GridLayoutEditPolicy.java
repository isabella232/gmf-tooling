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
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.graphdef.editor.edit.parts.AbstractFigureEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

public class GridLayoutEditPolicy extends ConstrainedLayoutEditPolicy {

	private static final Color FEEDBACK_COLOR = ColorConstants.lightBlue;
	
	private static final Color GRID_COLOR = ColorConstants.lightGreen;
	
	private static final Color INNER_FIGURES_COLOR = ColorConstants.red;

	private RoundedRectangle myFeedbackFigure;

	private GridLayoutHelper myFeedbackBoundsHelper;

	private GridFigure myGridFigure;

	@Override
	protected void showLayoutTargetFeedback(Request request) {
		if (/* RequestConstants.REQ_CREATE.equals(request.getType()) || */RequestConstants.REQ_MOVE.equals(request.getType())) {
// [1]			
			DropRequest dropRequest = (DropRequest) request;
			IFigure figure = getLayoutContainer();
			Point where = dropRequest.getLocation().getCopy();
			figure.translateToRelative(where);
			figure.translateFromParent(where);
			where.translate(getLayoutOrigin().getNegated());

			if (myFeedbackBoundsHelper == null) {
				myFeedbackBoundsHelper = new GridLayoutHelper(getAbstractFigureEditPart());
				
			}
			if (myGridFigure == null) {
				myGridFigure = new GridFigure(myFeedbackBoundsHelper.getGrid(), myFeedbackBoundsHelper.getHeights(), myFeedbackBoundsHelper.getWidths(), myFeedbackBoundsHelper.getGridLayout());
				Rectangle bounds = figure.getBounds().getCopy();
				figure.translateToAbsolute(bounds);
				getFeedbackLayer().translateToRelative(bounds);
				myGridFigure.setBounds(bounds);
				myGridFigure.setForegroundColor(GRID_COLOR);
				myGridFigure.setInnerFigureBoundsColor(INNER_FIGURES_COLOR);
				myGridFigure.setLineWidth(2);
				getFeedbackLayer().add(myGridFigure);
			}
			IFigure childFigure = null;
			if (dropRequest instanceof GroupRequest) {
				List editParts = ((GroupRequest) dropRequest).getEditParts();
				assert editParts.size() == 1;
				childFigure = ((AbstractFigureEditPart) editParts.get(0)).getFigure();
			}
			Rectangle feedbackBounds = myFeedbackBoundsHelper.getFeedbackBounds(where, childFigure);
			if (feedbackBounds == null) {
				eraseTargetFeedback(request);
				return;
			}
			figure.translateToParent(feedbackBounds);
			figure.translateToAbsolute(feedbackBounds);
			getFeedbackLayer().translateToRelative(feedbackBounds);

			if (myFeedbackFigure == null) {
				myFeedbackFigure = new RoundedRectangle();
				myFeedbackFigure.setFill(false);
				myFeedbackFigure.setOutline(true);
				myFeedbackFigure.setForegroundColor(FEEDBACK_COLOR);
				myFeedbackFigure.setLineWidth(1);
				myFeedbackFigure.setAntialias(SWT.ON);
				myFeedbackFigure.setBounds(feedbackBounds);
				getFeedbackLayer().add(myFeedbackFigure);
			} else {
				myFeedbackFigure.setBounds(feedbackBounds);
			}
			
//[2]
//			ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;
//			IFigure figure = getLayoutContainer();
//			Point where = changeBoundsRequest.getLocation().getCopy();
//			figure.translateToRelative(where);
//			figure.translateFromParent(where);
//			where.translate(getLayoutOrigin().getNegated());
//
//			if (changeBoundsRequest.getEditParts().size() != 1) {
//				// capable of moving only one child element at a time
//				return;
//			}
//
//			final AbstractFigureEditPart childEditPart = (AbstractFigureEditPart) changeBoundsRequest.getEditParts().get(0);
//			final int newChildPosition = new GridLayoutHelper(getAbstractFigureEditPart()).getNewChildPosition(where);
//			getAbstractFigureEditPart().removeChildVisual(childEditPart);
//			getAbstractFigureEditPart().addChildVisual(childEditPart, newChildPosition);
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
		if (/* RequestConstants.REQ_CREATE.equals(request.getType()) || */RequestConstants.REQ_MOVE.equals(request.getType()) || RequestConstants.REQ_DROP.equals(request.getType())) {
//[1]			
			if (myFeedbackFigure != null) {
				getFeedbackLayer().remove(myFeedbackFigure);
				myFeedbackFigure = null;
			}
			if (myGridFigure != null) {
				getFeedbackLayer().remove(myGridFigure);
				myGridFigure = null;
			}
			myFeedbackBoundsHelper = null;
			
//[2]
//			getAbstractFigureEditPart().refresh();
		} else {
			super.eraseTargetFeedback(request);
		}
	}

	/**
	 * With Grid layout move means reorder but not change layout constraints.
	 * Handling it in a different way.
	 */
	@Override
	protected Command getMoveChildrenCommand(Request request) {
		ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;
		IFigure figure = getLayoutContainer();
		Point where = changeBoundsRequest.getLocation().getCopy();
		figure.translateToRelative(where);
		figure.translateFromParent(where);
		where.translate(getLayoutOrigin().getNegated());

		if (changeBoundsRequest.getEditParts().size() != 1) {
			// capable of moving only one child element at a time
			return UnexecutableCommand.INSTANCE;
		}

		final AbstractFigureEditPart childEditPart = (AbstractFigureEditPart) changeBoundsRequest.getEditParts().get(0);
		final int newChildPosition = new GridLayoutHelper(getAbstractFigureEditPart()).getNewChildPosition(where);
		return newChildPosition == -1 ? UnexecutableCommand.INSTANCE : new ICommandProxy(new AbstractTransactionalCommand(childEditPart.getEditingDomain(), "Moving child figure", Collections
				.singletonList(WorkspaceSynchronizer.getFile(getRealFigure().eResource()))) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				getRealFigure().getChildren().move(newChildPosition, childEditPart.getRealFigure());
				getAbstractFigureEditPart().getNotationView().persistChildren();
				getAbstractFigureEditPart().getNotationView().getPersistedChildren().move(newChildPosition, childEditPart.getNotationView());
				// getAbstractFigureEditPart().getNotationView().getChildren().remove(childEditPart.getNotationView());
				// getAbstractFigureEditPart().getNotationView().getChildren().add(newChildPosition,
				// childEditPart.getNotationView());
				return CommandResult.newOKCommandResult();
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#
	 * createChangeConstraintCommand(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#getConstraintFor
	 * (org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	protected Object getConstraintFor(Point point) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#getConstraintFor
	 * (org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	protected Object getConstraintFor(Rectangle rect) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse
	 * .gef.requests.CreateRequest)
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		return new ResizableEditPolicy();
	}

	private AbstractFigureEditPart getAbstractFigureEditPart() {
		return (AbstractFigureEditPart) getHost();
	}

	private RealFigure getRealFigure() {
		return ((AbstractFigureEditPart) getHost()).getRealFigure();
	}

}
