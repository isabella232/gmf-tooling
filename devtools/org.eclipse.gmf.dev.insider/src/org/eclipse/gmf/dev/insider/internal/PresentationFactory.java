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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FreeformFigure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.dev.insider.ElementMetaInfo;
import org.eclipse.gmf.dev.insider.ElementUtil;
import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class PresentationFactory {

	public FreeformFigure createPresentation(View view) {
		FreeformLayer container = new FreeformLayer();
		container.setOpaque(true);
		container.setBackgroundColor(ColorConstants.white);
		container.setForegroundColor(ColorConstants.gray);
		addFigures(container, view.getElements());
		return container;
	}

	private void addFigures(IFigure container, Element[] elements) {
		for (int i = 0; i < elements.length; i++) {
			Element element = elements[i];
			if (!ElementMetaInfo.FIGURE_ELEMENT.equals(element.getNodeName())) {
				continue;
			}
			PointList pointList = getPointList(element);
			if (pointList != null) {
				PresentationLink figure = new PresentationLink(element);
				figure.setPoints(pointList);
				container.add(figure);
				addFigures(container, ElementUtil.getChildren(element, ElementMetaInfo.FIGURE_ELEMENT));
				continue;
			}
			Rectangle bounds = getBounds(element);
			if (bounds != null) {
				PresentationNode figure = new PresentationNode(element);
				figure.setBounds(bounds);
				container.add(figure);
				addFigures(container, ElementUtil.getChildren(element, ElementMetaInfo.FIGURE_ELEMENT));
				continue;
			}
		}
	}

	private Rectangle getBounds(Element element) {
		Element[] boundsElements = ElementUtil.getChildren(element, ElementMetaInfo.BOUNDS_ELEMENT);
		if (boundsElements.length < 1) {
			return null;
		}
		Element boundsElement = boundsElements[0];
		try {
			int x = Integer.parseInt(boundsElement.getAttribute(ElementMetaInfo.X_ATTRIBUTE));
			int y = Integer.parseInt(boundsElement.getAttribute(ElementMetaInfo.Y_ATTRIBUTE));
			int width = Integer.parseInt(boundsElement.getAttribute(ElementMetaInfo.WIDTH_ATTRIBUTE));
			int height = Integer.parseInt(boundsElement.getAttribute(ElementMetaInfo.HEIGHT_ATTRIBUTE));
			return new Rectangle(x, y, width, height);
		} catch (NumberFormatException nfe) {
			String msg = InsiderPlugin.getResourceString("error.invalidBounds"); //$NON-NLS-1$
			InsiderPlugin.logError(msg, nfe);
		}
		return null;
	}

	private PointList getPointList(Element element) {
		Element[] pointListElements = ElementUtil.getChildren(element, ElementMetaInfo.POINT_LIST_ELEMENT);
		if (pointListElements.length < 1) {
			return null;
		}
		Element pointListElement = pointListElements[0];
		PointList pointList = new PointList();
		Element[] pointElements = ElementUtil.getChildren(pointListElement, ElementMetaInfo.POINT_ELEMENT);
		try {
			for (int i = 0; i < pointElements.length; i++) {
				Element pointElement = pointElements[i];
				int x = Integer.parseInt(pointElement.getAttribute(ElementMetaInfo.X_ATTRIBUTE));
				int y = Integer.parseInt(pointElement.getAttribute(ElementMetaInfo.Y_ATTRIBUTE));
				pointList.addPoint(x, y);
			}
			return pointList;
		} catch (NumberFormatException nfe) {
			String msg = InsiderPlugin.getResourceString("error.invalidPoint"); //$NON-NLS-1$
			InsiderPlugin.logError(msg, nfe);
		}
		return null;
	}

	public boolean traverse(IFigure figure, PresentationVisitor visitor) {
		if (figure instanceof PresentationFigure) {
			if (visitor.accept((PresentationFigure) figure)) {
				return true;
			}
		}
		List children = figure.getChildren();
		for (int i = 0; i < children.size(); i++) {
			if (traverse((IFigure) children.get(i), visitor)) {
				return true;
			}
		}
		return false;
	}

	public interface PresentationVisitor {

		public boolean accept(PresentationFigure figure);
	}
}
