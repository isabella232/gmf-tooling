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

import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.dev.insider.AbstractContentBuilder;
import org.eclipse.gmf.dev.insider.ElementMetaInfo;
import org.eclipse.gmf.dev.insider.InsiderContext;
import org.eclipse.gmf.dev.insider.ReferenceUtil;
import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class FigureContentBuilder extends AbstractContentBuilder {

	public Element contribute(Element element, Object object) {
		if (object instanceof IFigure) {
			IFigure figure = (IFigure) object;
			return createFigure(element, figure);
		}
		return null;
	}

	protected Element createFigure(Element parent, IFigure figure) {
		Element element = createObject(parent, figure, ElementMetaInfo.FIGURE_ELEMENT);
		if (figure instanceof Connection) {
			Connection connection = (Connection) figure;
			createPointList(element, connection.getPoints());
		} else {
			Rectangle bounds = figure.getBounds().getCopy();
			figure.translateToAbsolute(bounds);
			createBounds(element, bounds);
		}
		EditPart editPart = getController(figure);
		if (editPart != null) {
			ReferenceUtil.createReference(element, editPart);
		}
		return element;
	}

	public List getChildren(Object object) {
		if (object instanceof IFigure) {
			IFigure figure = (IFigure) object;
			return figure.getChildren();
		}
		return null;
	}

	private EditPart getController(IFigure figure) {
		InsiderContext context = getContext();
		if (context == null) {
			return null;
		}
		EditPartViewer viewer = context.getViewer();
		if (viewer == null) {
			return null;
		}
		return (EditPart) viewer.getVisualPartMap().get(figure);
	}
}
