/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Orientable;
import org.eclipse.draw2d.ScrollPane;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.Ship_CargoCompartmentCanonicalEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.Ship_CargoCompartmentItemSemanticEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ListScrollBar;

import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * @generated
 */
public class Ship_CargoCompartmentEditPart extends ListCompartmentEditPart {

	/**
	 * @generated
	 */
	public static String VISUAL_ID = "5001";

	/**
	 * @generated
	 */
	public Ship_CargoCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected boolean hasModelChildrenChanged(Notification evt) {
		return false;
	}

	/**
	 * @generated
	 */
	protected String getTitleName() {
		return "CargoCompartment";
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Ship_CargoCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new Ship_CargoCompartmentCanonicalEditPolicy());
	}

	/**
	 * Temporary fix for the https://bugs.eclipse.org/bugs/show_bug.cgi?id=132219
	 * @generated
	 */
	public IFigure createFigure() {
		IMapMode mm = getMapMode();
		ResizableCompartmentFigure rcf = (ResizableCompartmentFigure) super.createFigure();
		if (rcf instanceof ShapeCompartmentFigure) {
			Insets insets = new Insets(mm.DPtoLP(1), mm.DPtoLP(2), mm.DPtoLP(1), mm.DPtoLP(0));
			Dimension size = new Dimension(mm.DPtoLP(15), mm.DPtoLP(15));

			ScrollPane scrollpane = rcf.getScrollPane();
			scrollpane.setHorizontalScrollBar(new ListScrollBar(Orientable.HORIZONTAL, insets, size, mm.DPtoLP(10), mm.DPtoLP(50)));
			scrollpane.setVerticalScrollBar(new ListScrollBar(Orientable.VERTICAL, insets, size, mm.DPtoLP(10), mm.DPtoLP(50)));

			int MB = mm.DPtoLP(5);
			scrollpane.setBorder(new MarginBorder(MB, MB, MB, MB));
			int SZ = mm.DPtoLP(10);
			scrollpane.setMinimumSize(new Dimension(SZ, SZ));
		} else {
			Insets insets = new Insets(mm.DPtoLP(1), mm.DPtoLP(2), mm.DPtoLP(1), mm.DPtoLP(0));
			Dimension size = new Dimension(mm.DPtoLP(15), mm.DPtoLP(15));

			ScrollPane scrollPane = rcf.getScrollPane();
			scrollPane.setVerticalScrollBar(new ListScrollBar(Orientable.VERTICAL, insets, size, mm.DPtoLP(10), mm.DPtoLP(50)));
		}
		return rcf;
	}
}
