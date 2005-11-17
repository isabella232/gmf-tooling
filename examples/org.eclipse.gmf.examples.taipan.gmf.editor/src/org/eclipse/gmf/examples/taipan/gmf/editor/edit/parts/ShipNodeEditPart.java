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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.ShipNodeItemSemanticEditPolicy;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanSemanticHints;

import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

/**
 * @generated
 */
public class ShipNodeEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	private IFigure contentPane;

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
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		DefaultSizeNodeFigure node = new DefaultSizeNodeFigure() {

			protected void paintFigure(Graphics graphics) {
				super.paintFigure(graphics);
				graphics.fillRectangle(getClientArea());
				graphics.drawRectangle(getClientArea());
			}
		};
		node.setLayoutManager(new StackLayout());
		node.add(contentPane = createContentPane());
		return node;
	}

	/**
	 * @generated
	 */
	protected IFigure createContentPane() {
		IFigure plate = new Figure();
		ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
		layout.setSpacing(getMapMode().DPtoLP(5));
		plate.setLayoutManager(layout);
		return plate;
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
