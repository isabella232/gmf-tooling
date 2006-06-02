/*
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.examples.mindmap.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.Connection;

import org.eclipse.gmf.examples.mindmap.diagram.edit.policies.Relationship3ItemSemanticEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;

/**
 * @generated
 */
public class Relationship3EditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4004;

	/**
	 * @generated
	 */
	public Relationship3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Relationship3ItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new DashedLineOpenArrow();
	}

	/**
	 * @generated
	 */
	public class DashedLineOpenArrow extends org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx {

		/**
		 * @generated
		 */
		public DashedLineOpenArrow() {

			this.setLineStyle(org.eclipse.draw2d.Graphics.LINE_DASH);
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.PolylineDecoration createTargetDecoration() {
			org.eclipse.draw2d.PolylineDecoration df = new org.eclipse.draw2d.PolylineDecoration();
			// dispatchNext?

			org.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();
			pl.addPoint(-1, 1);
			pl.addPoint(0, 0);
			pl.addPoint(-1, -1);
			df.setTemplate(pl);
			df.setScale(7, 3);

			return df;
		}
	}
}
