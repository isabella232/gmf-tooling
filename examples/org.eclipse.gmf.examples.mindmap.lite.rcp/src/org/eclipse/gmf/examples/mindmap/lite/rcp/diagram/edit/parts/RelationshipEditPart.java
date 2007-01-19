package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts;

import java.text.MessageFormat;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;

import org.eclipse.draw2d.geometry.Dimension;

import org.eclipse.emf.common.command.CompoundCommand;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.TreeEditPart;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.editpolicies.DirectEditPolicy;

import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.GroupRequest;

import org.eclipse.gef.tools.CellEditorLocator;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Relationship;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.runtime.lite.commands.RemoveNotationalEdgeCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;

import org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart;

import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter;

import org.eclipse.gmf.runtime.lite.edit.policies.BendpointEditPolicy;
import org.eclipse.gmf.runtime.lite.edit.policies.DelegatingDirectEditPolicy;

import org.eclipse.gmf.runtime.lite.services.ParserUtil;
import org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager;

import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;

import org.eclipse.swt.widgets.TreeItem;

/**
 * @generated
 */
public class RelationshipEditPart extends AbstractConnectionEditPart implements
		IUpdatableEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4002;

	/**
	 * @generated
	 */
	public RelationshipEditPart(View view) {
		assert view instanceof Edge;
		setModel(view);
	}

	/**
	 * @generated
	 */
	public Edge getDiagramEdge() {
		return (Edge) getModel();
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
				final Edge edgeToRemove = getDiagramEdge();
				final View source = edgeToRemove.getSource();
				final View target = edgeToRemove.getTarget();
				TransactionalEditingDomain editingDomain = TransactionUtil
						.getEditingDomain(getDiagramEdge().getDiagram()
								.getElement());
				CompoundCommand cc = new CompoundCommand();
				cc.append(createDomainModelRemoveCommand(editingDomain));
				cc.append(new RemoveNotationalEdgeCommand(source.getDiagram(),
						edgeToRemove));
				return new WrappingCommand(editingDomain, cc);
			}

			private org.eclipse.emf.common.command.Command createDomainModelRemoveCommand(
					TransactionalEditingDomain editingDomain) {
				CompoundCommand result = new CompoundCommand();
				result.append(RemoveCommand.create(editingDomain,
						getDiagramEdge().getElement().eContainer(),
						MindmapPackage.eINSTANCE.getMap_Relations(),
						getDiagramEdge().getElement()));
				result.append(SetCommand.create(editingDomain, getDiagramEdge()
						.getElement(), MindmapPackage.eINSTANCE
						.getRelationship_Source(), SetCommand.UNSET_VALUE));
				result.append(SetCommand.create(editingDomain, getDiagramEdge()
						.getElement(), MindmapPackage.eINSTANCE
						.getRelationship_Target(), SetCommand.UNSET_VALUE));
				return result;
			}
		});
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,
				new ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE,
				new BendpointEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new DelegatingDirectEditPolicy());

	}

	/**
	 * Returns the label which should be direct-edited by default.
	 * @generated
	 */
	private EditPart getPrimaryLabelEditPart() {
		for (Iterator it = getDiagramEdge().getChildren().iterator(); it
				.hasNext();) {
			View nextChild = (View) it.next();
			if (MindmapVisualIDRegistry.getVisualID(nextChild) == RelationshipLabelEditPart.VISUAL_ID) {
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
			if (getDiagramEdge().getChildren().contains(view)) {
				int visualId = MindmapVisualIDRegistry.getVisualID(view);
				switch (visualId) {
				case RelationshipLabelEditPart.VISUAL_ID:
					return result;
				}
			}
		}
		return getPrimaryLabelEditPart();
	}

	/**
	 * @generated
	 */
	protected List getModelChildren() {
		return ((Edge) getModel()).getChildren();
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
		getDiagramEdge().getElement().eAdapters().add(domainModelRefresher);
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		getDiagramEdge().getElement().eAdapters().remove(domainModelRefresher);
		super.deactivate();
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
		Refresher bendpointsRefresher = new Refresher() {
			public void refresh() {
				refreshBendpoints();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getEdge_Bendpoints(), bendpointsRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getRelativeBendpoints_Points(), bendpointsRefresher);
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
		refreshBendpoints();
	}

	/**
	 * @generated
	 */
	protected void refreshBendpoints() {
		RelativeBendpoints bendpoints = (RelativeBendpoints) getDiagramEdge()
				.getBendpoints();
		if (bendpoints == null) {
			getConnectionFigure().setRoutingConstraint(Collections.EMPTY_LIST);
			return;
		}
		List modelConstraint = bendpoints.getPoints();
		List figureConstraint = new ArrayList();
		for (int i = 0; i < modelConstraint.size(); i++) {
			RelativeBendpoint wbp = (RelativeBendpoint) modelConstraint.get(i);
			org.eclipse.draw2d.RelativeBendpoint rbp = new org.eclipse.draw2d.RelativeBendpoint(
					getConnectionFigure());
			rbp.setRelativeDimensions(new Dimension(wbp.getSourceX(), wbp
					.getSourceY()), new Dimension(wbp.getTargetX(), wbp
					.getTargetY()));
			rbp.setWeight((i + 1) / ((float) modelConstraint.size() + 1));
			figureConstraint.add(rbp);
		}
		getConnectionFigure().setRoutingConstraint(figureConstraint);
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

	/**
	 * @generated
	 */
	public void addNotify() {
		super.addNotify();
		getConnectionFigure().setConnectionRouter(
				new BendpointConnectionRouter());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected IFigure createFigure() {
		return new DashedLineOpenArrow();
	}

	/**
	 * @generated
	 */
	public class DashedLineOpenArrow extends PolylineConnection {

		/**
		 * @generated
		 */
		public DashedLineOpenArrow() {
			this.setFill(true);
			this.setFillXOR(false);
			this.setOutline(true);
			this.setOutlineXOR(false);
			this.setLineWidth(1);
			this.setLineStyle(Graphics.LINE_DASH);

			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			df.setFill(true);
			df.setFillXOR(false);
			df.setOutline(true);
			df.setOutlineXOR(false);
			df.setLineWidth(1);
			df.setLineStyle(Graphics.LINE_SOLID);
			return df;
		}

	}

	/**
	 * @generated
	 */
	private class TreeEditPartAdapter extends BaseTreeEditPart {
		/**
		 * @generated
		 */
		public TreeEditPartAdapter() {
			super(getDiagramEdge(), MindmapDiagramEditorPlugin.getInstance()
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
							final Edge edgeToRemove = getDiagramEdge();
							final View source = edgeToRemove.getSource();
							final View target = edgeToRemove.getTarget();
							TransactionalEditingDomain editingDomain = TransactionUtil
									.getEditingDomain(getDiagramEdge()
											.getDiagram().getElement());
							CompoundCommand cc = new CompoundCommand();
							cc
									.append(createDomainModelRemoveCommand(editingDomain));
							cc.append(new RemoveNotationalEdgeCommand(source
									.getDiagram(), edgeToRemove));
							return new WrappingCommand(editingDomain, cc);
						}

						private org.eclipse.emf.common.command.Command createDomainModelRemoveCommand(
								TransactionalEditingDomain editingDomain) {
							CompoundCommand result = new CompoundCommand();
							result.append(RemoveCommand
									.create(editingDomain, getDiagramEdge()
											.getElement().eContainer(),
											MindmapPackage.eINSTANCE
													.getMap_Relations(),
											getDiagramEdge().getElement()));
							result.append(SetCommand.create(editingDomain,
									getDiagramEdge().getElement(),
									MindmapPackage.eINSTANCE
											.getRelationship_Source(),
									SetCommand.UNSET_VALUE));
							result.append(SetCommand.create(editingDomain,
									getDiagramEdge().getElement(),
									MindmapPackage.eINSTANCE
											.getRelationship_Target(),
									SetCommand.UNSET_VALUE));
							return result;
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
										RelationshipLabelEditPart.EDIT_PATTERN)
										.parse(value);
							} catch (IllegalArgumentException e) {
								return UnexecutableCommand.INSTANCE;
							} catch (ParseException e) {
								return UnexecutableCommand.INSTANCE;
							}
							TransactionalEditingDomain editingDomain = TransactionUtil
									.getEditingDomain(getDiagramEdge()
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
							Relationship element = (Relationship) getDiagramEdge()
									.getElement();
							CompoundCommand result = new CompoundCommand();
							Object valueToSet;
							EAttribute feature = (EAttribute) MindmapPackage.eINSTANCE
									.getRelationship_Label();
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
			RelationshipLabelEditPart primaryLabelEditPart = getPrimaryLabelEditPart();

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
			getDiagramEdge().getElement().eAdapters().add(domainModelRefresher);
		}

		/**
		 * @generated
		 */
		public void deactivate() {
			getDiagramEdge().getElement().eAdapters().remove(
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
		protected void createRefreshers() {
			super.createRefreshers();
			Refresher labelRefresher = new Refresher() {
				public void refresh() {
					refreshVisuals();
				}
			};
			registerRefresher(MindmapPackage.eINSTANCE.getRelationship_Label(),
					labelRefresher);
		}

		/**
		 * @generated
		 */
		protected String getText() {
			RelationshipLabelEditPart primaryLabelEditPart = getPrimaryLabelEditPart();
			if (primaryLabelEditPart != null) {
				return primaryLabelEditPart.getLabelText();
			}
			return super.getText();
		}

		/**
		 * @generated
		 */
		private RelationshipLabelEditPart getPrimaryLabelEditPart() {
			for (Iterator it = getDiagramEdge().getChildren().iterator(); it
					.hasNext();) {
				View nextChild = (View) it.next();
				if (MindmapVisualIDRegistry.getVisualID(nextChild) == RelationshipLabelEditPart.VISUAL_ID) {
					return (RelationshipLabelEditPart) RelationshipEditPart.this
							.getViewer().getEditPartRegistry().get(nextChild);
				}
			}
			return null;
		}

		/**
		 * Since labels are not selectable edit parts, they are filtered from the overview as well.
		 * @generated
		 */
		protected List getModelChildren() {
			return Collections.EMPTY_LIST;
		}
	}
}
