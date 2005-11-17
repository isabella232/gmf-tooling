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
package org.eclipse.gmf.dev.insider.internal;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class PresentationNode extends RectangleFigure implements PresentationFigure {

	public PresentationNode(Element figureElement) {
		myFigureElement = figureElement;
	}

	public Element getFigureElement() {
		return myFigureElement;
	}

	protected void fillShape(Graphics graphics) {}

	private Element myFigureElement;
}
