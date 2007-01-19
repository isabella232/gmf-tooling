package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;

import org.eclipse.draw2d.geometry.Dimension;

import org.eclipse.emf.common.command.CompoundCommand;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.command.RemoveCommand;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.TreeEditPart;

import org.eclipse.gef.commands.Command;

import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import org.eclipse.gef.requests.GroupRequest;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapDiagramEditorPlugin;

import org.eclipse.gmf.runtime.lite.commands.RemoveNotationalEdgeCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;

import org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart;

import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;

import org.eclipse.gmf.runtime.lite.edit.policies.BendpointEditPolicy;

import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;

/**
 * @generated
 */
public class TopicSubtopicsEditPart extends AbstractConnectionEditPart
		implements IUpdatableEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public TopicSubtopicsEditPart(View view) {
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
				return RemoveCommand.create(editingDomain, getDiagramEdge()
						.getSource().getElement(), MindmapPackage.eINSTANCE
						.getTopic_Subtopics(), getDiagramEdge().getTarget()
						.getElement());
			}
		});
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,
				new ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE,
				new BendpointEditPolicy());

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
		return new PolylineConnection();
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
							return RemoveCommand.create(editingDomain,
									getDiagramEdge().getSource().getElement(),
									MindmapPackage.eINSTANCE
											.getTopic_Subtopics(),
									getDiagramEdge().getTarget().getElement());
						}
					});
		}

		/**
		 * @generated
		 */
		protected void createRefreshers() {
			super.createRefreshers();
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
