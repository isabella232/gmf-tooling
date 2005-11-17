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

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.dev.insider.AbstractContentBuilder;
import org.eclipse.gmf.dev.insider.InsiderContext;
import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class ContextFigureContentBuilder extends AbstractContentBuilder {

	public Element contribute(Element element, Object object) {
		return null;
	}

	public List getChildren(Object object) {
		if (object instanceof InsiderContext) {
			InsiderContext context = (InsiderContext) object;
			IFigure figure = context.getFigure();
			if (figure == null) {
				return null;
			}
			return Collections.singletonList(figure);
		}
		return null;
	}
}
