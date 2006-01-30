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

import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanStructuralFeatureParser;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;

/**
 * @generated
 */
public class RouteReliabilityLinkLabelTextEditPart extends TextCompartmentEditPart {

	/**
	 * @generated
	 */
	public RouteReliabilityLinkLabelTextEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public IParser getParser() {
		if (parser == null) {
			parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("reliability"));
			((TaiPanStructuralFeatureParser) parser).setViewPattern("reliability: {0}");
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected boolean isEditable() {
		return false;
	}
}
