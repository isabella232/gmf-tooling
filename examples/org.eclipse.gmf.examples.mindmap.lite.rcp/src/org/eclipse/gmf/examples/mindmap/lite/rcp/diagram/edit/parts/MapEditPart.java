package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;

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
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.TreeEditPart;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;

import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Relationship;
import org.eclipse.gmf.examples.mindmap.Resource;
import org.eclipse.gmf.examples.mindmap.Topic;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.CreateResource2002Command;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.CreateTopic2001Command;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.Relationship2ViewFactory;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.Relationship3ViewFactory;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.RelationshipViewFactory;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.ResourceViewFactory;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.TopicViewFactory;

import org.eclipse.gmf.runtime.lite.commands.ChangeBoundsCommand;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalEdgeCommand;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand;
import org.eclipse.gmf.runtime.lite.commands.ExpandDrawerCommand;
import org.eclipse.gmf.runtime.lite.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;

import org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart;

import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter;
import org.eclipse.gmf.runtime.lite.edit.parts.update.UpdateManager;

import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.EditPartRegistryBasedViewService;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.OwnedLinksNotationModelRefresher;

import org.eclipse.gmf.runtime.lite.requests.CreateRequestEx;

import org.eclipse.gmf.runtime.lite.services.IViewDecorator;

import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MapEditPart extends AbstractGraphicalEditPart implements
		IUpdatableEditPart {
	/**
	 * @generated
	 */
	public static String MODEL_ID = "Mindmap";

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public MapEditPart(Diagram model) {
		setModel(model);
	}

	/**
	 * @generated
	 */
	public Diagram getDiagram() {
		return (Diagram) getModel();
	}

	/**
	 * @generated
	 */
	protected void registerModel() {
		super.registerModel();
		View view = (View) getModel();
		if (view != null && view.isSetElement() && view.getElement() != null) {
			getViewer().getEditPartRegistry().put(view.getElement(), this);
		}
	}

	/**
	 * @generated
	 */
	protected void unregisterModel() {
		super.unregisterModel();
		View view = (View) getModel();
		if (view != null
				&& view.isSetElement()
				&& view.getElement() != null
				&& getViewer().getEditPartRegistry().get(view.getElement()) == this) {
			getViewer().getEditPartRegistry().remove(view.getElement());
		}
	}

	/**
	 * @generated
	 */
	public void addNotify() {
		super.addNotify();
		getDiagram().eAdapters().add(getUpdateManager());
		getDiagram().getElement().eAdapters().add(domainModelRefresher);
	}

	/**
	 * @generated
	 */
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new RootComponentEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {
			protected Command getCreateCommand(CreateRequest request) {
				if (request instanceof CreateRequestEx) {
					CreateRequestEx requestEx = (CreateRequestEx) request;
					int[] visualIds = requestEx.getVisualIds();
					CompoundCommand result = new CompoundCommand();
					for (int i = 0; i < visualIds.length; i++) {
						int nextVisualId = visualIds[i];
						switch (nextVisualId) {
						case TopicEditPart.VISUAL_ID:
							result.append(new CreateTopic2001Command(
									getDiagram(), requestEx,
									(Rectangle) getConstraintFor(request)));
							break;
						case ResourceEditPart.VISUAL_ID:
							result.append(new CreateResource2002Command(
									getDiagram(), requestEx,
									(Rectangle) getConstraintFor(request)));
							break;
						}
					}
					return new WrappingCommand(TransactionUtil
							.getEditingDomain(getDiagram().getElement()),
							result);
				}
				return null;
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
								.getNodeVisualID(getDiagram(), childNode
										.getElement());
						org.eclipse.emf.common.command.Command command = null;
						switch (newVisualID) {
						case TopicEditPart.VISUAL_ID: {
							CompoundCommand result = new CompoundCommand();
							EObject element = childNode.getElement();
							result.append(RemoveCommand.create(editingDomain,
									element.eContainer(),
									MindmapPackage.eINSTANCE
											.getMap_RootTopics(), element));

							result.append(AddCommand.create(editingDomain,
									getDiagram().getElement(),
									MindmapPackage.eINSTANCE
											.getMap_RootTopics(), element));
							result.append(RemoveCommand.create(editingDomain,
									childNode.eContainer(), childNode
											.eContainmentFeature(), childNode));
							if (newVisualID == visualID) {
								result.append(new ExpandDrawerCommand(
										getDiagram()));
								result.append(AddCommand.create(editingDomain,
										getDiagram(), NotationPackage.eINSTANCE
												.getView_PersistedChildren(),
										childNode));
								result.append(new SetBoundsCommand(childNode,
										(Rectangle) constraint));
							} else {
								result.append(new CreateNotationalNodeCommand(
										getDiagram(), element,
										((Rectangle) constraint).getCopy()
												.union(new Dimension(40, 40)),
										TopicViewFactory.INSTANCE));
							}
							command = result;
						}
							break;
						case ResourceEditPart.VISUAL_ID: {
							CompoundCommand result = new CompoundCommand();
							EObject element = childNode.getElement();
							result.append(RemoveCommand
									.create(editingDomain,
											element.eContainer(),
											MindmapPackage.eINSTANCE
													.getMap_Resources(),
											element));

							result.append(AddCommand
									.create(editingDomain, getDiagram()
											.getElement(),
											MindmapPackage.eINSTANCE
													.getMap_Resources(),
											element));
							result.append(RemoveCommand.create(editingDomain,
									childNode.eContainer(), childNode
											.eContainmentFeature(), childNode));
							if (newVisualID == visualID) {
								result.append(new ExpandDrawerCommand(
										getDiagram()));
								result.append(AddCommand.create(editingDomain,
										getDiagram(), NotationPackage.eINSTANCE
												.getView_PersistedChildren(),
										childNode));
								result.append(new SetBoundsCommand(childNode,
										(Rectangle) constraint));
							} else {
								result.append(new CreateNotationalNodeCommand(
										getDiagram(), element,
										((Rectangle) constraint).getCopy()
												.union(new Dimension(40, 60)),
										ResourceViewFactory.INSTANCE));
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
				org.eclipse.gef.commands.CompoundCommand command = new org.eclipse.gef.commands.CompoundCommand();
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
								.getNodeVisualID(getDiagram(), childNode
										.getElement());
						org.eclipse.emf.common.command.Command command = null;
						switch (newVisualID) {
						case TopicEditPart.VISUAL_ID:
							command = new CommandWrapper() {
								private CompoundCommand afterCopyCommand;

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
									afterCopyCommand = new CompoundCommand();
									afterCopyCommand.append(AddCommand.create(
											editingDomain, getDiagram()
													.getElement(),
											MindmapPackage.eINSTANCE
													.getMap_RootTopics(),
											result));
									afterCopyCommand
											.append(new CreateNotationalNodeCommand(
													getDiagram(),
													result,
													((Rectangle) constraint)
															.getCopy()
															.union(
																	new Dimension(
																			40,
																			40)),
													TopicViewFactory.INSTANCE));
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
						case ResourceEditPart.VISUAL_ID:
							command = new CommandWrapper() {
								private CompoundCommand afterCopyCommand;

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
									afterCopyCommand = new CompoundCommand();
									afterCopyCommand
											.append(AddCommand
													.create(
															editingDomain,
															getDiagram()
																	.getElement(),
															MindmapPackage.eINSTANCE
																	.getMap_Resources(),
															result));
									afterCopyCommand
											.append(new CreateNotationalNodeCommand(
													getDiagram(),
													result,
													((Rectangle) constraint)
															.getCopy()
															.union(
																	new Dimension(
																			40,
																			60)),
													ResourceViewFactory.INSTANCE));
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
		});

		installNotationModelRefresher();
		installLinkNotationModelRefresher();
	}

	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		IFigure f = new FreeformLayer();
		f.setBorder(new MarginBorder(5));
		f.setLayoutManager(new FreeformLayout());
		return f;
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class key) {
		if (SnapToHelper.class == key) {
			return new SnapToGrid(this);
		}
		if (TreeEditPart.class == key) {
			return getTreeEditPartAdapter();
		}
		return super.getAdapter(key);
	}

	/**
	 * @generated
	 */
	private TreeEditPartAdapter myTreeEditPartAdapter;

	/**
	 * @generated
	 */
	private TreeEditPartAdapter getTreeEditPartAdapter() {
		if (myTreeEditPartAdapter == null) {
			myTreeEditPartAdapter = new TreeEditPartAdapter();
		}
		return myTreeEditPartAdapter;
	}

	/**
	 * @generated
	 */
	protected List getModelChildren() {
		return getDiagram().getVisibleChildren();
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

	}

	/**
	 * @generated
	 */
	public void activate() {
		super.activate();
		if (!getDiagram().eAdapters().contains(getUpdateManager())) {
			getDiagram().eAdapters().add(getUpdateManager());
		}
		if (!getDiagram().getElement().eAdapters().contains(
				domainModelRefresher)) {
			getDiagram().getElement().eAdapters().add(domainModelRefresher);
		}
		installNotationModelRefresher();
		installLinkNotationModelRefresher();
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		uninstallLinkNotationModelRefresher();
		uninstallNotationModelRefresher();
		getDiagram().getElement().eAdapters().remove(domainModelRefresher);
		getDiagram().eAdapters().remove(getUpdateManager());
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
				.getEditingDomain(getDiagram().getElement());
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
							.getMap_RootTopics());
			filter = filter.or(NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getMap_Resources()));
			filter = filter.and(NotificationFilter
					.createNotifierFilter(getDiagram().getElement()));
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
			case TopicEditPart.VISUAL_ID:
				if (domainElement instanceof Topic) {
					return new CreateNotationalNodeCommand(getHost(),
							domainElement, new Rectangle(0, 0, 40, 40),
							TopicViewFactory.INSTANCE, false);
				}
				return null;
			case ResourceEditPart.VISUAL_ID:
				if (domainElement instanceof Resource) {
					return new CreateNotationalNodeCommand(getHost(),
							domainElement, new Rectangle(0, 0, 40, 60),
							ResourceViewFactory.INSTANCE, false);
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
			View viewObject = getDiagram();
			EObject modelObject = viewObject.getElement();
			EObject nextValue;
			int nodeVID;
			for (Iterator it = ((Map) modelObject).getRootTopics().iterator(); it
					.hasNext();) {
				nextValue = (EObject) it.next();
				nodeVID = MindmapVisualIDRegistry.INSTANCE.getNodeVisualID(
						viewObject, nextValue);
				if (TopicEditPart.VISUAL_ID == nodeVID) {
					result.add(new ElementDescriptor(nextValue, nodeVID));
				}
			}
			for (Iterator it = ((Map) modelObject).getResources().iterator(); it
					.hasNext();) {
				nextValue = (EObject) it.next();
				nodeVID = MindmapVisualIDRegistry.INSTANCE.getNodeVisualID(
						viewObject, nextValue);
				if (ResourceEditPart.VISUAL_ID == nodeVID) {
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
			return getDiagram();
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
				.getEditingDomain(getDiagram().getElement());
		getViewer().getEditDomain().getCommandStack().execute(
				new WrappingCommand(domainModelEditDomain, command));
	}

	/**
	 * @generated
	 */
	private void installLinkNotationModelRefresher() {
		LinkNotationModelRefresher refresher = getLinkNotationModelRefresher();
		if (refresher.isInstalled()) {
			return;
		}
		TransactionalEditingDomain domainModelEditDomain = TransactionUtil
				.getEditingDomain(getDiagram().getElement());
		refresher.install(domainModelEditDomain);
		refreshLinkNotationModel();
	}

	/**
	 * @generated
	 */
	private void uninstallLinkNotationModelRefresher() {
		getLinkNotationModelRefresher().uninstall();
	}

	/**
	 * @generated
	 */
	private LinkNotationModelRefresher linkNotationModelRefresher;

	/**
	 * Service to find a notational element that corresponds to the given underlying domain element. 
	 * @generated
	 */
	private IViewService viewService;

	/**
	 * @generated
	 */
	private IViewService getViewService() {
		if (viewService == null) {
			viewService = new EditPartRegistryBasedViewService(getViewer());
		}
		return viewService;
	}

	/**
	 * @generated
	 */
	private LinkNotationModelRefresher getLinkNotationModelRefresher() {
		if (linkNotationModelRefresher == null) {
			linkNotationModelRefresher = new LinkNotationModelRefresher(
					getViewService());
		}
		return linkNotationModelRefresher;
	}

	/**
	 * @generated
	 */
	private class LinkNotationModelRefresher extends
			OwnedLinksNotationModelRefresher {
		/**
		 * @generated
		 */
		public LinkNotationModelRefresher(IViewService viewService) {
			super(viewService);
		}

		/**
		 * NB: Child links of this element are selected based on constraint declared in org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapVisualIDRegistry. 
		 * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in 
		 * notational model having to be updated.
		 * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications
		 * result in such an update.
		 * @generated
		 */
		private NotificationFilter getConstrainedChildLinksFilter() {
			return NotificationFilter.NOT_TOUCH;
		}

		/**
		 * Creates a notification filter which filters notifications that may possibly result in uncontained links. 
		 * @generated
		 */
		private NotificationFilter createUncontainedLinksFilter() {
			return NotificationFilter
					.createEventTypeFilter(Notification.SET)
					.or(
							NotificationFilter
									.createEventTypeFilter(Notification.UNSET)
									.or(
											NotificationFilter
													.createEventTypeFilter(
															Notification.REMOVE)
													.or(
															NotificationFilter
																	.createEventTypeFilter(Notification.REMOVE_MANY))));
		}

		/**
		 * Creates a notification filter which filters notifications that may possibly affect the notational model
		 * @generated
		 */
		protected NotificationFilter createFilter() {

			NotificationFilter filter = NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getMap_Relations());

			filter = filter.or(NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getRelationship_Source()));

			filter = filter.or(NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getRelationship_Target()));

			filter = getConstrainedChildLinksFilter().or(filter);
			filter = filter.or(createUncontainedLinksFilter());
			return filter;
		}

		/**
		 * @generated
		 */
		protected CreateNotationalElementCommand getCreateNotationalElementCommand(
				ElementDescriptor descriptor) {
			LinkDescriptor linkDescriptor = (LinkDescriptor) descriptor;
			View sourceView = getViewService().findView(
					linkDescriptor.getSource());
			View targetView = getViewService().findView(
					linkDescriptor.getDestination());
			IViewDecorator decorator = null;
			if (sourceView == null || targetView == null) {
				return null;
			}
			switch (linkDescriptor.getVisualID()) {
			case RelationshipEditPart.VISUAL_ID:
				if (linkDescriptor.getElement() instanceof Relationship) {
					decorator = RelationshipViewFactory.INSTANCE;
				}
				break;
			case Relationship2EditPart.VISUAL_ID:
				if (linkDescriptor.getElement() instanceof Relationship) {
					decorator = Relationship2ViewFactory.INSTANCE;
				}
				break;
			case Relationship3EditPart.VISUAL_ID:
				if (linkDescriptor.getElement() instanceof Relationship) {
					decorator = Relationship3ViewFactory.INSTANCE;
				}
				break;
			}
			if (decorator == null) {
				return null;
			}
			return new CreateNotationalEdgeCommand(getHost().getDiagram(),
					linkDescriptor.getElement(), sourceView, targetView,
					decorator);
		}

		/**
		 * @generated
		 */
		protected List getSemanticChildLinks() {
			List result = new LinkedList();
			EObject modelObject = getDiagram().getElement();
			EObject nextValue;
			int linkVID;
			for (Iterator it = ((Map) modelObject).getRelations().iterator(); it
					.hasNext();) {
				nextValue = (EObject) it.next();
				linkVID = MindmapVisualIDRegistry.INSTANCE
						.getLinkWithClassVisualID(nextValue);
				switch (linkVID) {
				case RelationshipEditPart.VISUAL_ID: {
					EObject source = (EObject) ((Relationship) nextValue)
							.getSource();
					EObject target = (EObject) ((Relationship) nextValue)
							.getTarget();
					if (source != null && target != null) {
						result.add(new LinkDescriptor(source, target,
								nextValue, linkVID));
					}
					break;
				}
				case Relationship2EditPart.VISUAL_ID: {
					EObject source = (EObject) ((Relationship) nextValue)
							.getSource();
					EObject target = (EObject) ((Relationship) nextValue)
							.getTarget();
					if (source != null && target != null) {
						result.add(new LinkDescriptor(source, target,
								nextValue, linkVID));
					}
					break;
				}
				case Relationship3EditPart.VISUAL_ID: {
					EObject source = (EObject) ((Relationship) nextValue)
							.getSource();
					EObject target = (EObject) ((Relationship) nextValue)
							.getTarget();
					if (source != null && target != null) {
						result.add(new LinkDescriptor(source, target,
								nextValue, linkVID));
					}
					break;
				}
				}
			}
			return result;
		}

		/**
		 * @generated
		 */
		protected List getNotationalChildLinks() {
			List result = new LinkedList();
			List allLinks = getDiagram().getEdges();
			for (Iterator it = allLinks.iterator(); it.hasNext();) {
				Edge next = (Edge) it.next();
				if (next.isSetElement() && next.getElement() != null
						&& next.getElement().eResource() == null) {
					result.add(next);
					continue;
				}
				View source = next.getSource();
				if (source == null
						|| (source.isSetElement()
								&& source.getElement() != null && source
								.getElement().eResource() == null)) {
					result.add(next);
					continue;
				}
				View target = next.getTarget();
				if (target == null
						|| (target.isSetElement()
								&& target.getElement() != null && target
								.getElement().eResource() == null)) {
					result.add(next);
					continue;
				}
				if (next.isSetElement() && next.getElement() != null) {
					if (next.getElement().eContainer() == getDiagram()
							.getElement()) {
						int linkVID = MindmapVisualIDRegistry.getVisualID(next);
						switch (linkVID) {
						case RelationshipEditPart.VISUAL_ID:
						case Relationship2EditPart.VISUAL_ID:
						case Relationship3EditPart.VISUAL_ID:
							result.add(next);
							break;
						}
					}
				}
			}
			return result;
		}

		/**
		 * Returns whether a notational edge should be created for the given domain element. 
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
			return getDiagram();
		}
	}

	/**
	 * @generated
	 */
	protected void refreshLinkNotationModel() {
		AbstractNotationModelRefresher linkRefresher = getLinkNotationModelRefresher();
		if (!linkRefresher.isInstalled()) {
			return;
		}
		org.eclipse.emf.common.command.Command command = linkRefresher
				.buildRefreshNotationModelCommand();
		if (command == null) {
			return;
		}
		TransactionalEditingDomain domainModelEditDomain = TransactionUtil
				.getEditingDomain(getDiagram().getElement());
		getViewer().getEditDomain().getCommandStack().execute(
				new WrappingCommand(domainModelEditDomain, command));
	}

	/**
	 * @generated
	 */
	private RefreshAdapter domainModelRefresher = new RefreshAdapter(this);

	/**
	 * @generated
	 */
	private UpdateManager updateManager;

	/**
	 * @generated
	 */
	private UpdateManager getUpdateManager() {
		if (updateManager == null) {
			updateManager = new UpdateManager(getViewer());
		}
		return updateManager;
	}

	/**
	 * @generated
	 */
	private class TreeEditPartAdapter extends BaseTreeEditPart {
		/**
		 * @generated
		 */
		public TreeEditPartAdapter() {
			super(getDiagram(), MindmapDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());
		}

		/**
		 * @generated
		 */
		protected void createEditPolicies() {
			installEditPolicy(EditPolicy.COMPONENT_ROLE,
					new RootComponentEditPolicy());
		}

		/**
		 * @generated
		 */
		public void activate() {
			super.activate();
			if (!getDiagram().eAdapters().contains(getTreeUpdateManager())) {
				getDiagram().eAdapters().add(getTreeUpdateManager());
			}
			if (!getDiagram().getElement().eAdapters().contains(
					domainModelRefresher)) {
				getDiagram().getElement().eAdapters().add(domainModelRefresher);
			}
		}

		/**
		 * @generated
		 */
		public void deactivate() {
			getDiagram().getElement().eAdapters().remove(domainModelRefresher);
			getDiagram().eAdapters().remove(getTreeUpdateManager());
			super.deactivate();
		}

		/**
		 * @generated
		 */
		private RefreshAdapter domainModelRefresher = new RefreshAdapter(this);

		/**
		 * @generated
		 */
		private UpdateManager treeUpdateManager;

		/**
		 * @generated
		 */
		private UpdateManager getTreeUpdateManager() {
			if (treeUpdateManager == null) {
				treeUpdateManager = new UpdateManager(getViewer());
			}
			return treeUpdateManager;
		}
	}
}
