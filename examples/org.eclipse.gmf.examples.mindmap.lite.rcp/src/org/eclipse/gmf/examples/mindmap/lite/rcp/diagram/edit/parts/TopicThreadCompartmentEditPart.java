package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.Viewport;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.command.CommandWrapper;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.RemoveCommand;

import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;

import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Thread;
import org.eclipse.gmf.examples.mindmap.Topic;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.CreateThread3001Command;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.ThreadViewFactory;

import org.eclipse.gmf.runtime.lite.commands.ChangeBoundsCommand;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand;
import org.eclipse.gmf.runtime.lite.commands.ExpandDrawerCommand;
import org.eclipse.gmf.runtime.lite.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;

import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;

import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor;

import org.eclipse.gmf.runtime.lite.figures.CompartmentFigure;

import org.eclipse.gmf.runtime.lite.handles.CompartmentCollapseHandle;

import org.eclipse.gmf.runtime.lite.requests.CreateRequestEx;

import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TopicThreadCompartmentEditPart extends AbstractGraphicalEditPart
		implements IUpdatableEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7001;

	/**
	 * @generated
	 */
	public TopicThreadCompartmentEditPart(View view) {
		setModel(view);
	}

	/**
	 * @generated
	 */
	protected List getModelChildren() {
		DrawerStyle style = (DrawerStyle) getDiagramNode().getStyle(
				NotationPackage.eINSTANCE.getDrawerStyle());
		if (style != null && style.isCollapsed()) {
			return Collections.EMPTY_LIST;
		}
		return getDiagramNode().getChildren();
	}

	/**
	 * @generated
	 */
	protected Node getDiagramNode() {
		return (Node) getModel();
	}

	/**
	 * @generated
	 */
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {
			protected Command createChangeConstraintCommand(
					final ChangeBoundsRequest request, final EditPart child,
					Object constraint) {
				final Node node = (Node) child.getModel();
				org.eclipse.emf.common.command.Command emfCommand = new ChangeBoundsCommand(
						node, request, ((GraphicalEditPart) child).getFigure());
				return new WrappingCommand(TransactionUtil
						.getEditingDomain(node.getDiagram().getElement()),
						emfCommand);
			}

			protected Command createChangeConstraintCommand(EditPart child,
					Object constraint) {
				assert false;
				return UnexecutableCommand.INSTANCE;
			}

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child != null) {
					EditPolicy result = child
							.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
					if (result != null) {
						return result;
					}
				}
				return super.createChildEditPolicy(child);
			}

			protected Command createAddCommand(final EditPart child,
					final Object constraint) {
				if (child.getModel() instanceof Node) {
					final Node childNode = (Node) child.getModel();
					final TransactionalEditingDomain editingDomain = TransactionUtil
							.getEditingDomain(childNode.getDiagram()
									.getElement());
					String modelID = MindmapVisualIDRegistry
							.getModelID(childNode);
					if (MapEditPart.MODEL_ID.equals(modelID)) {
						final int visualID = MindmapVisualIDRegistry
								.getVisualID(childNode);
						final int newVisualID = MindmapVisualIDRegistry.INSTANCE
								.getNodeVisualID(getDiagramNode(), childNode
										.getElement());
						org.eclipse.emf.common.command.Command command = null;
						switch (newVisualID) {
						case ThreadEditPart.VISUAL_ID: {
							org.eclipse.emf.common.command.CompoundCommand result = new org.eclipse.emf.common.command.CompoundCommand();
							EObject element = childNode.getElement();
							result.append(RemoveCommand.create(editingDomain,
									element.eContainer(),
									MindmapPackage.eINSTANCE
											.getTopic_Comments(), element));

							result.append(AddCommand.create(editingDomain,
									getDiagramNode().getElement(),
									MindmapPackage.eINSTANCE
											.getTopic_Comments(), element));
							result.append(RemoveCommand.create(editingDomain,
									childNode.eContainer(), childNode
											.eContainmentFeature(), childNode));
							if (newVisualID == visualID) {
								result.append(new ExpandDrawerCommand(
										getDiagramNode()));
								result.append(AddCommand.create(editingDomain,
										getDiagramNode(),
										NotationPackage.eINSTANCE
												.getView_PersistedChildren(),
										childNode));
								result.append(new SetBoundsCommand(childNode,
										(Rectangle) constraint));
							} else {
								result.append(new CreateNotationalNodeCommand(
										getDiagramNode(), element,
										((Rectangle) constraint).getCopy()
												.union(new Dimension(40, 40)),
										ThreadViewFactory.INSTANCE));
							}
							command = result;
						}
							break;
						}
						if (command != null) {
							return new WrappingCommand(editingDomain, command);
						}
					}
				}
				return UnexecutableCommand.INSTANCE;
			}

			protected Command getCloneCommand(ChangeBoundsRequest request) {
				List editParts = request.getEditParts();
				CompoundCommand command = new CompoundCommand();
				command.setDebugLabel("Clone in ConstrainedLayoutEditPolicy");//$NON-NLS-1$
				GraphicalEditPart childPart;
				Rectangle r;
				Object constraint;

				for (int i = 0; i < editParts.size(); i++) {
					childPart = (GraphicalEditPart) editParts.get(i);
					r = childPart.getFigure().getBounds().getCopy();
					//convert r to absolute from childpart figure
					childPart.getFigure().translateToAbsolute(r);
					r = request.getTransformedRectangle(r);
					//convert this figure to relative 
					getLayoutContainer().translateToRelative(r);
					getLayoutContainer().translateFromParent(r);
					r.translate(getLayoutOrigin().getNegated());
					constraint = getConstraintFor(r);
					command.add(createCloneCommand(childPart,
							translateToModelConstraint(constraint)));
				}
				return command.unwrap();
			}

			protected Command createCloneCommand(final EditPart child,
					final Object constraint) {
				if (child.getModel() instanceof Node) {
					final Node childNode = (Node) child.getModel();
					final TransactionalEditingDomain editingDomain = TransactionUtil
							.getEditingDomain(childNode.getDiagram()
									.getElement());
					String modelID = MindmapVisualIDRegistry
							.getModelID(childNode);
					if (MapEditPart.MODEL_ID.equals(modelID)) {
						final int newVisualID = MindmapVisualIDRegistry.INSTANCE
								.getNodeVisualID(getDiagramNode(), childNode
										.getElement());
						org.eclipse.emf.common.command.Command command = null;
						switch (newVisualID) {
						case ThreadEditPart.VISUAL_ID:
							command = new CommandWrapper() {
								private org.eclipse.emf.common.command.CompoundCommand afterCopyCommand;

								protected org.eclipse.emf.common.command.Command createCommand() {
									EObject element = childNode.getElement();
									//We are being optimistic here about whether further commands can be executed.
									//Otherwise, we would have to execute the CopyCommand on every mouse move, which could be much too expensive.  
									return CopyCommand.create(editingDomain,
											element);
								}

								protected boolean prepare() {
									if (!super.prepare()) {
										return false;
									}

									return true;
								}

								public void execute() {
									super.execute();
									final Collection results = super
											.getResult();
									assert results.size() == 1;
									EObject result = (EObject) results
											.iterator().next();
									afterCopyCommand = new org.eclipse.emf.common.command.CompoundCommand();
									afterCopyCommand.append(AddCommand.create(
											editingDomain, getDiagramNode()
													.getElement(),
											MindmapPackage.eINSTANCE
													.getTopic_Comments(),
											result));
									afterCopyCommand
											.append(new CreateNotationalNodeCommand(
													getDiagramNode(),
													result,
													((Rectangle) constraint)
															.getCopy()
															.union(
																	new Dimension(
																			40,
																			40)),
													ThreadViewFactory.INSTANCE));
									if (afterCopyCommand.canExecute()) {
										afterCopyCommand.execute();
									} else {
										assert false;
									}
								}

								public void undo() {
									afterCopyCommand.undo();
									super.undo();
								}

								public void redo() {
									super.redo();
									afterCopyCommand.redo();
								}
							};
							break;
						}
						if (command != null) {
							return new WrappingCommand(editingDomain, command);
						}
					}
				}
				return UnexecutableCommand.INSTANCE;
			}

			protected Command getCreateCommand(CreateRequest request) {
				if (request instanceof CreateRequestEx) {
					CreateRequestEx requestEx = (CreateRequestEx) request;
					int[] visualIds = requestEx.getVisualIds();
					org.eclipse.emf.common.command.CompoundCommand result = new org.eclipse.emf.common.command.CompoundCommand();
					for (int i = 0; i < visualIds.length; i++) {
						int nextVisualId = visualIds[i];
						switch (nextVisualId) {
						case ThreadEditPart.VISUAL_ID:
							result.append(new CreateThread3001Command(
									(View) getModel(), requestEx,
									(Rectangle) getConstraintFor(request)));
							break;
						}
					}
					return new WrappingCommand(TransactionUtil
							.getEditingDomain(((View) getModel()).getDiagram()
									.getElement()), result);
				}
				return null;
			}
		});

		installNotationModelRefresher();
	}

	/**
	 * Returns the selection handles that should be contributed to the parent when it becomes selected.
	 * @generated
	 */
	public List createSelectionHandles() {
		return Collections.singletonList(new CompartmentCollapseHandle(this,
				getTitleName()));
	}

	/**
	 * @generated
	 */
	public void performRequest(Request req) {
		if (RequestConstants.REQ_OPEN.equals(req.getType())) {
			Command command = getCommand(req);
			if (command != null && command.canExecute()) {
				getViewer().getEditDomain().getCommandStack().execute(command);
			}
			return;
		}
		super.performRequest(req);
	}

	/**
	 * @generated
	 */
	protected String getTitleName() {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public IFigure createFigure() {
		Figure result = new CompartmentFigure();
		result.setLayoutManager(new StackLayout());
		ScrollPane scrollPane = new ScrollPane();
		result.add(scrollPane);
		Viewport viewport = new FreeformViewport();
		contentPane = new FreeformLayer();
		contentPane.setLayoutManager(new FreeformLayout());
		viewport.setContents(contentPane);
		scrollPane.setViewport(viewport);
		return result;
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class key) {
		if (SnapToHelper.class == key) {
			return new SnapToGrid(this);
		}
		return super.getAdapter(key);
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		return contentPane;
	}

	/**
	 * @generated
	 */
	private IFigure contentPane;

	/**
	 * @generated
	 */
	public void activate() {
		super.activate();
		installNotationModelRefresher();
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		uninstallNotationModelRefresher();
		super.deactivate();
	}

	/**
	 * @generated
	 */
	private void installNotationModelRefresher() {
		ChildNotationModelRefresher refresher = getNotationModelRefresher();
		if (refresher.isInstalled()) {
			return;
		}
		TransactionalEditingDomain domainModelEditDomain = TransactionUtil
				.getEditingDomain(getDiagramNode().getDiagram().getElement());
		refresher.install(domainModelEditDomain);
		refreshNotationModel();
	}

	/**
	 * @generated
	 */
	private void uninstallNotationModelRefresher() {
		getNotationModelRefresher().uninstall();
	}

	/**
	 * @generated
	 */
	private ChildNotationModelRefresher notationModelRefresher;

	/**
	 * @generated
	 */
	private ChildNotationModelRefresher getNotationModelRefresher() {
		if (notationModelRefresher == null) {
			notationModelRefresher = new NotationModelRefresher();
		}
		return notationModelRefresher;
	}

	/**
	 * @generated
	 */
	private class NotationModelRefresher extends ChildNotationModelRefresher {

		/**
		 * Creates a notification filter which filters notifications that may possibly affect the notational model
		 * @generated
		 */
		protected NotificationFilter createFilter() {
			NotificationFilter filter = NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getTopic_Comments());
			filter = filter.and(NotificationFilter
					.createNotifierFilter(getDiagramNode().getElement()));
			return filter;
		}

		/**
		 * @generated
		 */
		protected CreateNotationalElementCommand getCreateNotationalElementCommand(
				ElementDescriptor descriptor) {
			EObject domainElement = descriptor.getElement();
			int nodeVisualID = descriptor.getVisualID();
			switch (nodeVisualID) {
			case ThreadEditPart.VISUAL_ID:
				if (domainElement instanceof Thread) {
					return new CreateNotationalNodeCommand(getHost(),
							domainElement, new Rectangle(0, 0, 40, 40),
							ThreadViewFactory.INSTANCE, false);
				}
				return null;
			default:
				return null;
			}
		}

		/**
		 * @generated
		 */
		protected List getSemanticChildNodes() {

			List result = new LinkedList();
			View viewObject = getDiagramNode();
			EObject modelObject = viewObject.getElement();
			EObject nextValue;
			int nodeVID;
			for (Iterator it = ((Topic) modelObject).getComments().iterator(); it
					.hasNext();) {
				nextValue = (EObject) it.next();
				nodeVID = MindmapVisualIDRegistry.INSTANCE.getNodeVisualID(
						viewObject, nextValue);
				if (ThreadEditPart.VISUAL_ID == nodeVID) {
					result.add(new ElementDescriptor(nextValue, nodeVID));
				}
			}
			return result;
		}

		/**
		 * Returns whether a notational element should be created for the given domain element. 
		 * The generated code always returns true. 
		 * User can change implementation of this method to handle a more sophisticated logic.
		 * @generated
		 */
		protected boolean shouldCreateView(ElementDescriptor descriptor) {
			return true;
		}

		/**
		 * @generated
		 */
		protected View getHost() {
			return getDiagramNode();
		}
	}

	/**
	 * @generated
	 */
	protected void refreshNotationModel() {
		AbstractNotationModelRefresher childRefresher = getNotationModelRefresher();
		if (!childRefresher.isInstalled()) {
			return;
		}
		org.eclipse.emf.common.command.Command command = childRefresher
				.buildRefreshNotationModelCommand();
		if (command == null) {
			return;
		}
		TransactionalEditingDomain domainModelEditDomain = TransactionUtil
				.getEditingDomain(getDiagramNode().getDiagram().getElement());
		getViewer().getEditDomain().getCommandStack().execute(
				new WrappingCommand(domainModelEditDomain, command));
	}

	/**
	 * @generated
	 */
	private HashMap structuralFeatures2Refresher;

	/**
	 * @generated
	 */
	public Refresher getRefresher(EStructuralFeature feature, Notification msg) {
		if (structuralFeatures2Refresher == null) {
			createRefreshers();
		}
		return (Refresher) structuralFeatures2Refresher.get(feature);
	}

	/**
	 * @generated
	 */
	private void createRefreshers() {
		structuralFeatures2Refresher = new HashMap();
		Refresher childrenRefresher = new Refresher() {
			public void refresh() {
				refreshChildren();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getView_PersistedChildren(), childrenRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getView_TransientChildren(), childrenRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getView_Styles(), childrenRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getDrawerStyle_Collapsed(), childrenRefresher);

		Refresher visibilityRefresher = new Refresher() {
			public void refresh() {
				refreshVisibility();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getView_Visible(), visibilityRefresher);
	}

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		//XXX:		refreshBackgroundColor();
		//XXX:		refreshForegroundColor();
		//XXX:		refreshFont();
		refreshVisibility();
	}

	/**
	 * @generated
	 */
	protected void refreshVisibility() {
		boolean isVisible = ((View) getModel()).isVisible();
		boolean wasVisible = getFigure().isVisible();
		if (isVisible == wasVisible) {
			return;
		}
		if (!isVisible && (getSelected() != SELECTED_NONE)) {
			getViewer().deselect(this);
		}

		getFigure().setVisible(isVisible);
		getFigure().revalidate();
	}
}
