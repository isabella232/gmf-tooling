package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts;

import java.text.MessageFormat;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.command.CompoundCommand;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;

import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.TreeEditPart;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;

import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import org.eclipse.gef.tools.CellEditorLocator;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Topic;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.CreateRelationship4002Command;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.CreateRelationship4002StartCommand;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.CreateRelationship4003Command;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.CreateRelationship4003StartCommand;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.CreateRelationship4004Command;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.CreateRelationship4004StartCommand;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.CreateTopic_Subtopics4001Command;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.CreateTopic_Subtopics4001StartCommand;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.ReconnectRelationship4002SourceCommand;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.ReconnectRelationship4002TargetCommand;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.ReconnectRelationship4003SourceCommand;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.ReconnectRelationship4003TargetCommand;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.ReconnectRelationship4004SourceCommand;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.ReconnectRelationship4004TargetCommand;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.ReconnectTopic_Subtopics4001SourceCommand;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands.ReconnectTopic_Subtopics4001TargetCommand;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.TopicSubtopicsViewFactory;

import org.eclipse.gmf.runtime.lite.commands.CreateNotationalEdgeCommand;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.commands.RemoveNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;

import org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart;

import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter;

import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.EditPartRegistryBasedViewService;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.OwnedLinksNotationModelRefresher;

import org.eclipse.gmf.runtime.lite.edit.policies.DelegatingDirectEditPolicy;

import org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx;

import org.eclipse.gmf.runtime.lite.services.IViewDecorator;
import org.eclipse.gmf.runtime.lite.services.ParserUtil;
import org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager;

import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;

import org.eclipse.swt.SWT;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

import org.eclipse.swt.widgets.TreeItem;

/**
 * @generated
 */
public class TopicEditPart extends AbstractGraphicalEditPart implements
		NodeEditPart, IUpdatableEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public TopicEditPart(View model) {
		assert model instanceof Node;
		setModel(model);
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
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				TransactionalEditingDomain editingDomain = TransactionUtil
						.getEditingDomain(getDiagramNode().getDiagram()
								.getElement());
				CompoundCommand cc = new CompoundCommand();
				cc.append(getDomainModelRemoveCommand(editingDomain));
				cc
						.append(new RemoveNotationalElementCommand(
								(View) getDiagramNode().eContainer(),
								getDiagramNode()));
				return new WrappingCommand(editingDomain, cc);
			}

			private org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(
					TransactionalEditingDomain editingDomain) {
				return RemoveCommand.create(editingDomain, getDiagramNode()
						.getElement().eContainer(), MindmapPackage.eINSTANCE
						.getMap_RootTopics(), getDiagramNode().getElement());
			}
		});
		installEditPolicy(EditPolicy.LAYOUT_ROLE,
				new ConstrainedLayoutEditPolicy() {

					protected Command getCreateCommand(CreateRequest request) {
						return UnexecutableCommand.INSTANCE;
					}

					protected Object getConstraintFor(Rectangle rect) {
						return null;
					}

					protected Object getConstraintFor(Point point) {
						return null;
					}

					protected Command createChangeConstraintCommand(
							EditPart child, Object constraint) {
						return UnexecutableCommand.INSTANCE;
					}

					protected EditPolicy createChildEditPolicy(EditPart child) {
						return new ResizableEditPolicy() {
							public EditPart getTargetEditPart(Request request) {
								if (RequestConstants.REQ_SELECTION
										.equals(request.getType())) {
									return TopicEditPart.this;
								}
								return super.getTargetEditPart(request);
							}
						};
					}
				});
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new GraphicalNodeEditPolicy() {
					protected Command getReconnectTargetCommand(
							ReconnectRequest request) {
						ConnectionEditPart connection = request
								.getConnectionEditPart();
						if (connection.getModel() instanceof Edge == false) {
							return UnexecutableCommand.INSTANCE;
						}
						Edge edge = (Edge) connection.getModel();
						String modelID = MindmapVisualIDRegistry
								.getModelID(edge);
						if (!MapEditPart.MODEL_ID.equals(modelID)) {
							return UnexecutableCommand.INSTANCE;
						}
						org.eclipse.emf.common.command.Command result = null;
						int visualID = MindmapVisualIDRegistry
								.getVisualID(edge);
						switch (visualID) {
						case TopicSubtopicsEditPart.VISUAL_ID:
							result = new ReconnectTopic_Subtopics4001TargetCommand(
									request);
							break;
						case RelationshipEditPart.VISUAL_ID:
							result = new ReconnectRelationship4002TargetCommand(
									request);
							break;
						case Relationship2EditPart.VISUAL_ID:
							result = new ReconnectRelationship4003TargetCommand(
									request);
							break;
						case Relationship3EditPart.VISUAL_ID:
							result = new ReconnectRelationship4004TargetCommand(
									request);
							break;
						}
						if (result == null) {
							return UnexecutableCommand.INSTANCE;
						}
						return new WrappingCommand(TransactionUtil
								.getEditingDomain(getDiagramNode().getDiagram()
										.getElement()), result);
					}

					protected Command getReconnectSourceCommand(
							ReconnectRequest request) {
						ConnectionEditPart connection = request
								.getConnectionEditPart();
						if (connection.getModel() instanceof Edge == false) {
							return UnexecutableCommand.INSTANCE;
						}
						Edge edge = (Edge) connection.getModel();
						String modelID = MindmapVisualIDRegistry
								.getModelID(edge);
						if (!MapEditPart.MODEL_ID.equals(modelID)) {
							return UnexecutableCommand.INSTANCE;
						}
						org.eclipse.emf.common.command.Command result = null;
						int visualID = MindmapVisualIDRegistry
								.getVisualID(edge);
						switch (visualID) {
						case TopicSubtopicsEditPart.VISUAL_ID:
							result = new ReconnectTopic_Subtopics4001SourceCommand(
									request);
							break;
						case RelationshipEditPart.VISUAL_ID:
							result = new ReconnectRelationship4002SourceCommand(
									request);
							break;
						case Relationship2EditPart.VISUAL_ID:
							result = new ReconnectRelationship4003SourceCommand(
									request);
							break;
						case Relationship3EditPart.VISUAL_ID:
							result = new ReconnectRelationship4004SourceCommand(
									request);
							break;
						}
						if (result == null) {
							return UnexecutableCommand.INSTANCE;
						}
						return new WrappingCommand(TransactionUtil
								.getEditingDomain(getDiagramNode().getDiagram()
										.getElement()), result);
					}

					protected Command getConnectionCreateCommand(
							CreateConnectionRequest request) {
						if (request instanceof CreateConnectionRequestEx) {
							CreateConnectionRequestEx requestEx = (CreateConnectionRequestEx) request;
							int[] visualIds = requestEx.getVisualIds();
							CompoundCommand result = new CompoundCommand();
							for (int i = 0; i < visualIds.length; i++) {
								int nextVisualId = visualIds[i];
								switch (nextVisualId) {
								case TopicSubtopicsEditPart.VISUAL_ID:
									result
											.appendIfCanExecute(new CreateTopic_Subtopics4001StartCommand(
													requestEx));
									break;
								case RelationshipEditPart.VISUAL_ID:
									result
											.appendIfCanExecute(new CreateRelationship4002StartCommand(
													requestEx));
									break;
								case Relationship2EditPart.VISUAL_ID:
									result
											.appendIfCanExecute(new CreateRelationship4003StartCommand(
													requestEx));
									break;
								case Relationship3EditPart.VISUAL_ID:
									result
											.appendIfCanExecute(new CreateRelationship4004StartCommand(
													requestEx));
									break;
								}
							}
							if (!result.canExecute()) {
								//returning an unexecutable command does not change cursor to "No".
								return null;
							}
							Command wrappedResult = new WrappingCommand(
									TransactionUtil
											.getEditingDomain(getDiagramNode()
													.getDiagram().getElement()),
									result);
							request.setStartCommand(wrappedResult);
							return wrappedResult;
						}
						return null;
					}

					protected Command getConnectionCompleteCommand(
							CreateConnectionRequest request) {
						if (request.getStartCommand() == null
								|| !request.getStartCommand().canExecute()) {
							return UnexecutableCommand.INSTANCE;
						}
						if (request instanceof CreateConnectionRequestEx) {
							CreateConnectionRequestEx requestEx = (CreateConnectionRequestEx) request;
							int[] visualIds = requestEx.getVisualIds();
							CompoundCommand result = new CompoundCommand();
							for (int i = 0; i < visualIds.length; i++) {
								int nextVisualId = visualIds[i];
								switch (nextVisualId) {
								case TopicSubtopicsEditPart.VISUAL_ID:
									result
											.appendIfCanExecute(new CreateTopic_Subtopics4001Command(
													requestEx));
									break;
								case RelationshipEditPart.VISUAL_ID:
									result
											.appendIfCanExecute(new CreateRelationship4002Command(
													requestEx));
									break;
								case Relationship2EditPart.VISUAL_ID:
									result
											.appendIfCanExecute(new CreateRelationship4003Command(
													requestEx));
									break;
								case Relationship3EditPart.VISUAL_ID:
									result
											.appendIfCanExecute(new CreateRelationship4004Command(
													requestEx));
									break;
								}
							}
							if (result.getCommandList().size() != 1
									|| !result.canExecute()) {
								//Cannot create several connections at once.
								return UnexecutableCommand.INSTANCE;
							}
							return new WrappingCommand(TransactionUtil
									.getEditingDomain(getDiagramNode()
											.getDiagram().getElement()), result);
						}
						return UnexecutableCommand.INSTANCE;
					}
				});
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new DelegatingDirectEditPolicy());

		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				getPrimaryDragEditPolicy());
		installLinkNotationModelRefresher();
	}

	/**
	 * @generated
	 */
	protected EditPolicy getPrimaryDragEditPolicy() {
		ResizableEditPolicy result = new ResizableEditPolicy() {
			protected List createSelectionHandles() {
				List result = super.createSelectionHandles();
				for (Iterator it = getChildren().iterator(); it.hasNext();) {
					EditPart next = (EditPart) it.next();
					View nextView = (View) next.getModel();
					switch (MindmapVisualIDRegistry.getVisualID(nextView)) {
					case TopicThreadCompartmentEditPart.VISUAL_ID:
						result.addAll(((TopicThreadCompartmentEditPart) next)
								.createSelectionHandles());
						break;
					}
				}
				return result;
			}
		};
		return result;
	}

	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		IFigure invisibleRectangle = new Figure();
		invisibleRectangle.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		invisibleRectangle.add(shape);
		contentPane = setupContentPane(shape);

		IFigure decorationShape = createDecorationPane();
		if (decorationShape != null) {
			invisibleRectangle.add(decorationShape);
		}

		return invisibleRectangle;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		RoundedTopicFigure figure = new RoundedTopicFigure();
		primaryShape = figure;
		return primaryShape;
	}

	/**
	 * @generated
	 */
	public RoundedTopicFigure getPrimaryShape() {
		return (RoundedTopicFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	private IFigure createDecorationPane() {
		View view = (View) getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			return null;
		}

		Figure decorationPane = new Figure();
		decorationPane.setLayoutManager(new BorderLayout());

		ImageFigure imageFigure = new ImageFigure(MindmapDiagramEditorPlugin
				.getInstance().getBundledImage("icons/shortcut.gif"),
				PositionConstants.EAST);
		decorationPane.add(imageFigure, BorderLayout.BOTTOM);
		return decorationPane;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ToolbarLayout layout = new ToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane == null) {
			return super.getContentPane();
		}
		return contentPane;
	}

	/**
	 * @generated
	 */
	public Node getDiagramNode() {
		return (Node) getModel();
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TopicNameEditPart) {
			((TopicNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureTopicNameFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		return false;
	}

	/**
	 * Returns the label which should be direct-edited by default.
	 * @generated
	 */
	private EditPart getPrimaryLabelEditPart() {
		for (Iterator it = getDiagramNode().getChildren().iterator(); it
				.hasNext();) {
			View nextChild = (View) it.next();
			if (MindmapVisualIDRegistry.getVisualID(nextChild) == TopicNameEditPart.VISUAL_ID) {
				return (EditPart) getViewer().getEditPartRegistry().get(
						nextChild);
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public void performRequest(Request req) {
		if (RequestConstants.REQ_DIRECT_EDIT.equals(req.getType())) {
			EditPart labelToEdit;
			if (req instanceof DirectEditRequest) {
				labelToEdit = getLabelEditPart((DirectEditRequest) req);
			} else {
				labelToEdit = getPrimaryLabelEditPart();
			}
			if (labelToEdit != null) {
				labelToEdit.performRequest(req);
			}
		}
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
	private EditPart getLabelEditPart(DirectEditRequest req) {
		EditPart result = getViewer().findObjectAt(req.getLocation());
		if (result != null) {
			View view = (View) result.getModel();
			if (getDiagramNode().getChildren().contains(view)) {
				int visualId = MindmapVisualIDRegistry.getVisualID(view);
				switch (visualId) {
				case TopicNameEditPart.VISUAL_ID:
					return result;
				}
			}
		}
		return getPrimaryLabelEditPart();
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshBounds();
		refreshBackgroundColor();
		refreshForegroundColor();
		refreshFont();
		refreshVisibility();
	}

	/**
	 * @generated
	 */
	protected void refreshVisibility() {
		boolean isVisible = getDiagramNode().isVisible();
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

	/**
	 * @generated
	 */
	protected void refreshBounds() {
		Node node = getDiagramNode();
		if (node.getLayoutConstraint() == null) {
			return;
		}
		assert node.getLayoutConstraint() instanceof Bounds;
		Bounds bounds = (Bounds) node.getLayoutConstraint();
		int x = bounds.getX();
		int y = bounds.getY();
		int width = bounds.getWidth();
		int height = bounds.getHeight();
		if (width < 0) {
			x -= width;
			width = -width;
		}
		if (height < 0) {
			y -= height;
			height = -height;
		}
		((GraphicalEditPart) getParent()).setLayoutConstraint(this,
				getFigure(), new Rectangle(x, y, width, height));
	}

	/**
	 * @generated
	 */
	protected List getModelChildren() {
		return getDiagramNode().getVisibleChildren();
	}

	/**
	 * @generated
	 */
	protected List getModelSourceConnections() {
		return getDiagramNode().getSourceEdges();
	}

	/**
	 * @generated
	 */
	protected List getModelTargetConnections() {
		return getDiagramNode().getTargetEdges();
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {
		return new ChopboxAnchor(getFigure());
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return new ChopboxAnchor(getFigure());
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
		return new ChopboxAnchor(getFigure());
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return new ChopboxAnchor(getFigure());
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class key) {
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
	public void activate() {
		super.activate();
		getDiagramNode().getElement().eAdapters().add(domainModelRefresher);
		installLinkNotationModelRefresher();
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		uninstallLinkNotationModelRefresher();
		getDiagramNode().getElement().eAdapters().remove(domainModelRefresher);
		super.deactivate();
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
				.getEditingDomain(getDiagramNode().getDiagram().getElement());
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
		 * Creates a notification filter which filters notifications that may possibly affect the notational model
		 * @generated
		 */
		protected NotificationFilter createFilter() {

			NotificationFilter filter = NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getTopic_Subtopics());
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
			case TopicSubtopicsEditPart.VISUAL_ID:
				if (linkDescriptor.getElement() == null) {
					decorator = TopicSubtopicsViewFactory.INSTANCE;
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
			EObject modelObject = getDiagramNode().getElement();
			EObject nextValue;
			for (Iterator it = ((Topic) modelObject).getSubtopics().iterator(); it
					.hasNext();) {
				nextValue = (EObject) it.next();
				if (nextValue != null) {
					result.add(new LinkDescriptor(modelObject, nextValue, null,
							TopicSubtopicsEditPart.VISUAL_ID));
				}
			}
			return result;
		}

		/**
		 * @generated
		 */
		protected List getNotationalChildLinks() {
			List result = new LinkedList();
			List allLinks = getDiagramNode().getDiagram().getEdges();
			for (Iterator it = allLinks.iterator(); it.hasNext();) {
				Edge next = (Edge) it.next();
				if (!next.isSetElement() || next.getElement() == null) {
					if (next.getSource() == getDiagramNode()) {
						int linkVID = MindmapVisualIDRegistry.getVisualID(next);
						switch (linkVID) {
						case TopicSubtopicsEditPart.VISUAL_ID:
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
			return getDiagramNode();
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
				.getEditingDomain(getDiagramNode().getDiagram().getElement());
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
	public void addRefresher(EStructuralFeature feature, Refresher refresher) {
		CompositeRefresher compositeRefresher = getCompositeRefresher(feature);
		compositeRefresher.addRefresher(refresher);
	}

	/**
	 * @generated
	 */
	public void removeRefresher(EStructuralFeature feature, Refresher refresher) {
		CompositeRefresher compositeRefresher = getCompositeRefresher(feature);
		compositeRefresher.removeRefresher(refresher);
	}

	/**
	 * @generated
	 */
	private CompositeRefresher getCompositeRefresher(EStructuralFeature feature) {
		if (structuralFeatures2Refresher == null) {
			createRefreshers();
		}
		Refresher refresher = (Refresher) structuralFeatures2Refresher
				.get(feature);
		if (refresher instanceof CompositeRefresher) {
			return (CompositeRefresher) refresher;
		}
		CompositeRefresher result = new CompositeRefresher();
		if (refresher != null) {
			result.addRefresher(refresher);
		}
		structuralFeatures2Refresher.put(feature, result);
		return result;
	}

	/**
	 * @generated
	 */
	protected void refreshFont() {
		FontStyle style = (FontStyle) getDiagramNode().getStyle(
				NotationPackage.eINSTANCE.getFontStyle());
		Font toDispose = createdFont;
		if (style != null) {
			String fontName = style.getFontName();
			int fontHeight = style.getFontHeight();
			int fontStyle = SWT.NORMAL;
			if (style.isBold()) {
				fontStyle |= SWT.BOLD;
			}
			if (style.isItalic()) {
				fontStyle |= SWT.ITALIC;
			}
			Font currentFont = getFigure().getFont();
			if (currentFont != null) {
				FontData currentFontData = currentFont.getFontData()[0];
				if (currentFontData.getName().equals(fontName)
						&& currentFontData.getHeight() == fontHeight
						&& currentFontData.getStyle() == fontStyle) {
					return;
				}
			}
			createdFont = new Font(null, fontName, fontHeight, fontStyle);
			getFigure().setFont(createdFont);
		} else {
			//revert to the default font
			getFigure().setFont(getViewer().getControl().getFont());
			createdFont = null;
		}
		if (toDispose != null) {
			toDispose.dispose();
		}
	}

	/**
	 * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned).
	 * Whenever another non-default font is assigned to it, it is safe to dispose the previous one.
	 * @generated
	 */
	private Font createdFont;

	/**
	 * @generated
	 */
	protected void refreshForegroundColor() {
		LineStyle style = (LineStyle) getDiagramNode().getStyle(
				NotationPackage.eINSTANCE.getLineStyle());
		Color toDispose = createdForegroundColor;
		if (style != null) {
			int foregroundColor = style.getLineColor();
			int red = foregroundColor & 0x000000FF;
			int green = (foregroundColor & 0x0000FF00) >> 8;
			int blue = (foregroundColor & 0x00FF0000) >> 16;
			Color currentColor = getFigure().getForegroundColor();
			if (currentColor != null && currentColor.getRed() == red
					&& currentColor.getGreen() == green
					&& currentColor.getBlue() == blue) {
				return;
			}
			createdForegroundColor = new Color(null, red, green, blue);
			getFigure().setForegroundColor(createdForegroundColor);
		} else {
			getFigure().setForegroundColor(
					getViewer().getControl().getForeground());
			createdForegroundColor = null;
		}
		if (toDispose != null) {
			toDispose.dispose();
		}
	}

	/**
	 * The color (created by {@link #refreshForegroundColor()}) currently assigned to the figure.
	 * Whenever another color is assigned to it, it is safe to dispose the previous one.
	 * @generated
	 */
	private Color createdForegroundColor;

	/**
	 * @generated
	 */
	protected void refreshBackgroundColor() {
		FillStyle style = (FillStyle) getDiagramNode().getStyle(
				NotationPackage.eINSTANCE.getFillStyle());
		Color toDispose = createdBackgroundColor;
		if (style != null) {
			int backgroundColor = style.getFillColor();
			int red = backgroundColor & 0x000000FF;
			int green = (backgroundColor & 0x0000FF00) >> 8;
			int blue = (backgroundColor & 0x00FF0000) >> 16;
			Color currentColor = getFigure().getBackgroundColor();
			if (currentColor != null && currentColor.getRed() == red
					&& currentColor.getGreen() == green
					&& currentColor.getBlue() == blue) {
				return;
			}
			createdBackgroundColor = new Color(null, red, green, blue);
			getFigure().setBackgroundColor(createdBackgroundColor);
		} else {
			getFigure().setBackgroundColor(
					getViewer().getControl().getBackground());
		}
		if (toDispose != null) {
			toDispose.dispose();
		}
	}

	/**
	 * The color (created by {@link #refreshBackgroundColor()}) currently assigned to the figure.
	 * Whenever another color is assigned to it, it is safe to dispose the previous one.
	 * @generated
	 */
	private Color createdBackgroundColor;

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

		Refresher boundsRefresher = new Refresher() {
			public void refresh() {
				refreshBounds();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getNode_LayoutConstraint(), boundsRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getSize_Width(), boundsRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getSize_Height(), boundsRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getLocation_X(), boundsRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getLocation_Y(), boundsRefresher);
		Refresher visibilityRefresher = new Refresher() {
			public void refresh() {
				refreshVisibility();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getView_Visible(), visibilityRefresher);
		Refresher sourceEdgesRefresher = new Refresher() {
			public void refresh() {
				refreshSourceConnections();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getView_SourceEdges(), sourceEdgesRefresher);
		Refresher targetEdgesRefresher = new Refresher() {
			public void refresh() {
				refreshTargetConnections();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getView_TargetEdges(), targetEdgesRefresher);
		Refresher fontRefresher = new Refresher() {
			public void refresh() {
				refreshFont();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getFontStyle_FontHeight(), fontRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getFontStyle_FontName(), fontRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getFontStyle_Bold(), fontRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getFontStyle_Italic(), fontRefresher);

		Refresher backgroundColorRefresher = new Refresher() {
			public void refresh() {
				refreshBackgroundColor();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getFillStyle_FillColor(), backgroundColorRefresher);
		Refresher foregroundColorRefresher = new Refresher() {
			public void refresh() {
				refreshForegroundColor();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getLineStyle_LineColor(), foregroundColorRefresher);
	}

	/**
	 * @generated
	 */
	public class RoundedTopicFigure extends RoundedRectangle {
		/**
		 * @generated
		 */
		public RoundedTopicFigure() {
			this.setCornerDimensions(new Dimension(20, 20));
			this.setFill(true);
			this.setFillXOR(false);
			this.setOutline(true);
			this.setOutlineXOR(false);
			this.setLineWidth(1);
			this.setLineStyle(Graphics.LINE_SOLID);
			this.setForegroundColor(ROUNDEDTOPICFIGURE_FORE);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			Label topicNameFigure0 = new Label();
			topicNameFigure0.setText("<...>");

			this.add(topicNameFigure0);
			setFigureTopicNameFigure(topicNameFigure0);

		}

		/**
		 * @generated
		 */
		private Label fTopicNameFigure;

		/**
		 * @generated
		 */
		public Label getFigureTopicNameFigure() {
			return fTopicNameFigure;
		}

		/**
		 * @generated
		 */
		private void setFigureTopicNameFigure(Label fig) {
			fTopicNameFigure = fig;
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}

	/**
	 * @generated
	 */
	static final Color ROUNDEDTOPICFIGURE_FORE = new Color(null, 220, 220, 250);

	/**
	 * @generated
	 */
	private class TreeEditPartAdapter extends BaseTreeEditPart {
		/**
		 * @generated
		 */
		public TreeEditPartAdapter() {
			super(getDiagramNode(), MindmapDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());
		}

		/**
		 * @generated
		 */
		protected void createEditPolicies() {
			installEditPolicy(EditPolicy.COMPONENT_ROLE,
					new ComponentEditPolicy() {
						protected Command createDeleteCommand(
								GroupRequest deleteRequest) {
							TransactionalEditingDomain editingDomain = TransactionUtil
									.getEditingDomain(getDiagramNode()
											.getDiagram().getElement());
							CompoundCommand cc = new CompoundCommand();
							cc
									.append(getDomainModelRemoveCommand(editingDomain));
							cc.append(new RemoveNotationalElementCommand(
									(View) getDiagramNode().eContainer(),
									getDiagramNode()));
							return new WrappingCommand(editingDomain, cc);
						}

						private org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(
								TransactionalEditingDomain editingDomain) {
							return RemoveCommand.create(editingDomain,
									getDiagramNode().getElement().eContainer(),
									MindmapPackage.eINSTANCE
											.getMap_RootTopics(),
									getDiagramNode().getElement());
						}
					});
			installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
					new DirectEditPolicy() {
						protected void showCurrentEditValue(
								DirectEditRequest request) {
							String value = (String) request.getCellEditor()
									.getValue();
							setWidgetText(value);
						}

						protected Command getDirectEditCommand(
								DirectEditRequest request) {
							String value = (String) request.getCellEditor()
									.getValue();
							if (value == null) {
								//Invalid value is transformed into a null by the validator.
								//XXX: implement validator
								return UnexecutableCommand.INSTANCE;
							}
							final Object[] parseResult;
							try {
								parseResult = new MessageFormat(
										TopicNameEditPart.EDIT_PATTERN)
										.parse(value);
							} catch (IllegalArgumentException e) {
								return UnexecutableCommand.INSTANCE;
							} catch (ParseException e) {
								return UnexecutableCommand.INSTANCE;
							}
							TransactionalEditingDomain editingDomain = TransactionUtil
									.getEditingDomain(getDiagramNode()
											.getDiagram().getElement());
							if (parseResult.length != 1) {
								return UnexecutableCommand.INSTANCE;
							}
							org.eclipse.emf.common.command.Command domainModelCommand = createDomainModelCommand(
									editingDomain, parseResult);
							return new WrappingCommand(editingDomain,
									domainModelCommand);
						}

						org.eclipse.emf.common.command.Command createDomainModelCommand(
								TransactionalEditingDomain editingDomain,
								Object[] values) {
							Topic element = (Topic) getDiagramNode()
									.getElement();
							CompoundCommand result = new CompoundCommand();
							Object valueToSet;
							EAttribute feature = (EAttribute) MindmapPackage.eINSTANCE
									.getTopic_Name();
							try {
								valueToSet = ParserUtil.parseValue(feature,
										values[0]);
							} catch (IllegalArgumentException e) {
								return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;
							}
							result.append(SetCommand.create(editingDomain,
									element, feature, valueToSet));
							return result;
						}
					});
		}

		/**
		 * @generated
		 */
		private TreeDirectEditManager manager;

		/**
		 * @generated
		 */
		public void performRequest(Request req) {
			if (RequestConstants.REQ_DIRECT_EDIT == req.getType()) {
				performDirectEdit();
			} else {
				super.performRequest(req);
			}
		}

		/**
		 * @generated
		 */
		protected TreeDirectEditManager getManager() {
			if (manager == null) {
				manager = new TreeDirectEditManager(this, TextCellEditor.class,
						new CellEditorLocator() {
							public void relocate(CellEditor celleditor) {
								if (checkTreeItem()) {
									celleditor.getControl().setFont(
											((TreeItem) getWidget()).getFont());
									celleditor.getControl().setBounds(
											((TreeItem) getWidget())
													.getBounds());
								}
							}
						}) {
					protected void initCellEditor() {
						getCellEditor().setValue(getEditText());
					}
				};
			}
			return manager;
		}

		/**
		 * @generated
		 */
		protected void performDirectEdit() {
			getManager().show();
		}

		/**
		 * @generated
		 */
		protected String getEditText() {
			TopicNameEditPart primaryLabelEditPart = getPrimaryLabelEditPart();
			if (primaryLabelEditPart != null) {
				return primaryLabelEditPart.getLabelEditText();
			}
			return "";
		}

		/**
		 * @generated
		 */
		public void activate() {
			super.activate();
			getDiagramNode().getElement().eAdapters().add(domainModelRefresher);
		}

		/**
		 * @generated
		 */
		public void deactivate() {
			getDiagramNode().getElement().eAdapters().remove(
					domainModelRefresher);
			super.deactivate();
		}

		/**
		 * @generated
		 */
		private RefreshAdapter domainModelRefresher = new RefreshAdapter(this);

		/**
		 * @generated
		 */
		protected String getText() {
			TopicNameEditPart primaryLabelEditPart = getPrimaryLabelEditPart();
			if (primaryLabelEditPart != null) {
				return primaryLabelEditPart.getLabelText();
			}
			return super.getText();
		}

		/**
		 * @generated
		 */
		private TopicNameEditPart getPrimaryLabelEditPart() {
			for (Iterator it = getDiagramNode().getChildren().iterator(); it
					.hasNext();) {
				View nextChild = (View) it.next();
				if (MindmapVisualIDRegistry.getVisualID(nextChild) == TopicNameEditPart.VISUAL_ID) {
					return (TopicNameEditPart) TopicEditPart.this.getViewer()
							.getEditPartRegistry().get(nextChild);
				}
			}
			return null;
		}

		/**
		 * @generated
		 */
		protected void createRefreshers() {
			super.createRefreshers();
			Refresher labelRefresher = new Refresher() {
				public void refresh() {
					refreshVisuals();
				}
			};
			registerRefresher(MindmapPackage.eINSTANCE.getTopic_Name(),
					labelRefresher);
		}

		/**
		 * Since compartments and labels are not selectable edit parts, they are filtered from the overview as well.
		 * @generated
		 */
		protected List getModelChildren() {
			List result = new ArrayList();
			for (Iterator it = getDiagramNode().getVisibleChildren().iterator(); it
					.hasNext();) {
				View next = (View) it.next();
				DrawerStyle style = (DrawerStyle) next
						.getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
				if (style != null && style.isCollapsed()) {
					continue;
				}
				switch (MindmapVisualIDRegistry.getVisualID(next)) {
				case TopicThreadCompartmentEditPart.VISUAL_ID:
					result.addAll(next.getChildren());
					break;
				}
			}
			result.addAll(getDiagramNode().getSourceEdges());
			return result;
		}
	}
}
