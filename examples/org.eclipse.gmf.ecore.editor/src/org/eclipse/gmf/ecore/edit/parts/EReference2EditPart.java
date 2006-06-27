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
package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.Connection;

import org.eclipse.gmf.ecore.edit.policies.EReference2ItemSemanticEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;

/**
 * @generated
 */
public class EReference2EditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4003;

	/**
	 * @generated
	 */
	public EReference2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EReference2ItemSemanticEditPolicy());
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
		return new SolidLineWSrcDiamond();
	}

	/**
	 * @generated
	 */
	public class SolidLineWSrcDiamond extends org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx {

		/**
		 * @generated
		 */
		public SolidLineWSrcDiamond() {

			setSourceDecoration(createSourceDecoration());
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.PolygonDecoration createSourceDecoration() {
			org.eclipse.draw2d.PolygonDecoration df = new org.eclipse.draw2d.PolygonDecoration();
			// dispatchNext?
			df.setFill(true);
			org.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();
			pl.addPoint(-1, 1);
			pl.addPoint(0, 0);
			pl.addPoint(-1, -1);
			pl.addPoint(-2, 0);
			pl.addPoint(-1, 1);
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));

			return df;
		}

	}

}
