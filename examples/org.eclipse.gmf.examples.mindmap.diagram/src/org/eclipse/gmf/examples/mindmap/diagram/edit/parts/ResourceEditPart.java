/*
 * 
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Richard Gronback (Borland) - initial API and implementation
 
 */
package org.eclipse.gmf.examples.mindmap.diagram.edit.parts;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polygon;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.examples.mindmap.diagram.edit.policies.ResourceItemSemanticEditPolicy;
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class ResourceEditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2002;

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
	public ResourceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ResourceItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		XYLayoutEditPolicy lep = new XYLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child instanceof IBorderItemEditPart) {
					return new BorderItemSelectionEditPolicy();
				}
				EditPolicy result = super.createChildEditPolicy(child);
				if (result == null) {
					return new ResizableShapeEditPolicy();
				}
				return result;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ResourceFigure figure = new ResourceFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ResourceFigure getPrimaryShape() {
		return (ResourceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer,
			IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof ResourceNameEmailEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(40), getMapMode().DPtoLP(60));
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(MindmapVisualIDRegistry
				.getType(ResourceNameEmailEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() == getModel()
				&& EcorePackage.eINSTANCE.getEModelElement_EAnnotations()
						.equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
	}

	/**
	 * @generated
	 */
	public class ResourceFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		public ResourceFigure() {

			this.setLayoutManager(new XYLayout());
			this.setFill(false);
			this.setOutline(false);
			this.setLineWidth(0);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(40),
					getMapMode().DPtoLP(60)));
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(40),
					getMapMode().DPtoLP(60)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(40),
					getMapMode().DPtoLP(60)));
			this.setSize(getMapMode().DPtoLP(40), getMapMode().DPtoLP(60));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			Ellipse head0 = new Ellipse();
			head0.setForegroundColor(HEAD0_FORE);
			head0.setBackgroundColor(HEAD0_BACK);
			head0.setSize(getMapMode().DPtoLP(40), getMapMode().DPtoLP(20));

			this.add(head0);

			Polygon body0 = new Polygon();
			body0.addPoint(new Point(getMapMode().DPtoLP(23), getMapMode()
					.DPtoLP(19)));
			body0.addPoint(new Point(getMapMode().DPtoLP(23), getMapMode()
					.DPtoLP(24)));
			body0.addPoint(new Point(getMapMode().DPtoLP(39), getMapMode()
					.DPtoLP(24)));
			body0.addPoint(new Point(getMapMode().DPtoLP(39), getMapMode()
					.DPtoLP(29)));
			body0.addPoint(new Point(getMapMode().DPtoLP(23), getMapMode()
					.DPtoLP(29)));
			body0.addPoint(new Point(getMapMode().DPtoLP(23), getMapMode()
					.DPtoLP(36)));
			body0.addPoint(new Point(getMapMode().DPtoLP(39), getMapMode()
					.DPtoLP(48)));
			body0.addPoint(new Point(getMapMode().DPtoLP(39), getMapMode()
					.DPtoLP(53)));
			body0.addPoint(new Point(getMapMode().DPtoLP(20), getMapMode()
					.DPtoLP(42)));
			body0.addPoint(new Point(getMapMode().DPtoLP(1), getMapMode()
					.DPtoLP(53)));
			body0.addPoint(new Point(getMapMode().DPtoLP(1), getMapMode()
					.DPtoLP(48)));
			body0.addPoint(new Point(getMapMode().DPtoLP(17), getMapMode()
					.DPtoLP(36)));
			body0.addPoint(new Point(getMapMode().DPtoLP(17), getMapMode()
					.DPtoLP(29)));
			body0.addPoint(new Point(getMapMode().DPtoLP(1), getMapMode()
					.DPtoLP(29)));
			body0.addPoint(new Point(getMapMode().DPtoLP(1), getMapMode()
					.DPtoLP(24)));
			body0.addPoint(new Point(getMapMode().DPtoLP(17), getMapMode()
					.DPtoLP(24)));
			body0.addPoint(new Point(getMapMode().DPtoLP(17), getMapMode()
					.DPtoLP(19)));
			body0.setForegroundColor(BODY0_FORE);
			body0.setBackgroundColor(BODY0_BACK);

			this.add(body0);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = true;

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
	static final Color HEAD0_FORE = new Color(null, 220, 220, 250);

	/**
	 * @generated
	 */
	static final Color HEAD0_BACK = new Color(null, 230, 230, 255);

	/**
	 * @generated
	 */
	static final Color BODY0_FORE = new Color(null, 220, 220, 250);

	/**
	 * @generated
	 */
	static final Color BODY0_BACK = new Color(null, 230, 230, 255);

}
