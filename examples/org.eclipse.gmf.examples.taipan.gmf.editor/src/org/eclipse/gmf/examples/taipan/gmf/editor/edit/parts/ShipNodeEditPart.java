/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RectangularDropShadowLineBorder;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.RectangleFigure;

import org.eclipse.gef.EditPart;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.ShipNodeGraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.ShipNodeItemSemanticEditPolicy;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanSemanticHints;

/**
 * @generated
 */
public class ShipNodeEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	public ShipNodeEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ShipNodeItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ShipNodeGraphicalNodeEditPolicy());
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return new RectangleFigure();
	}

	/**
	 * @generated
	 */
	protected void decorateNodeShape(Shape shape) {

	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		return new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setBorder(new RectangularDropShadowLineBorder(0));
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		if (shape instanceof Shape) {
			decorateNodeShape((Shape) shape);
		}
		figure.add(shape);
		addContentPane(shape);
		return figure;
	}

	/**
	 * @generated
	 */
	protected void addContentPane(IFigure shape) {
		contentPane = shape;
		ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
		layout.setSpacing(getMapMode().DPtoLP(5));
		contentPane.setLayoutManager(layout);
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
		return getChildBySemanticHint(TaiPanSemanticHints.Ship_1002Labels.NAME_TEXT);
	}
}
