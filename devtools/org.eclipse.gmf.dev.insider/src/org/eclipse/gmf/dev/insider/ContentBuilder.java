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
package org.eclipse.gmf.dev.insider;

import java.util.List;

import org.w3c.dom.Element;

/**
 * Content provider for Insider model.
 * Insider model is a DOM tree.
 * 
 * @author dstadnik
 */
public interface ContentBuilder {

	public void setContext(InsiderContext context);

	/**
	 * Contributes model data for the specified object.
	 * If this builder creates a child element then it should be
	 * returned so the further children may be contributed to it;
	 * return <code>null</code> otherwise.
	 */
	public Element contribute(Element element, Object object);

	/**
	 * Returns list of the object children in domain model.
	 * This list will never be modified.
	 * 
	 * In most cases the first object asked for children
	 * is an InsiderContext. Content builder may cache it to
	 * acquire additional information later.
	 */
	public List getChildren(Object object);
}
