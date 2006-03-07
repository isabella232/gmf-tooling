/*
 * Copyright (c) 2005 Borland Software Corporation
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

import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;

/**
 * @generated
 */
public class Route_descriptionTextEditPart extends TextCompartmentEditPart {

	/**
	 * @generated
	 */
	public Route_descriptionTextEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	private String defaultText;

	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		IFigure figure = super.createFigure();
		if (figure instanceof Label) {
			defaultText = ((Label) figure).getText();
		} else if (figure instanceof WrapLabel) {
			defaultText = ((WrapLabel) figure).getText();
		}
		return figure;
	}

	/**
	 * @generated
	 */
	protected String getLabelText() {
		String text = super.getLabelText();
		if (text == null || text.length() == 0) {
			return defaultText;
		}
		return text;
	}

	/**
	 * @generated
	 */
	public IParser getParser() {
		if (parser == null) {
			String parserHint = ((View) getModel()).getType();
			EObject element = resolveSemanticElement();
			if (element != null) {
				ParserHintAdapter hintAdapter = new ParserHintAdapter(element, parserHint) {

					public Object getAdapter(Class adapter) {
						if (IElementType.class.equals(adapter)) {
							return TaiPanElementTypes.Route_3002;
						}
						return super.getAdapter(adapter);
					}
				};
				parser = ParserService.getInstance().getParser(hintAdapter);
			}
		}
		return parser;
	}
}
