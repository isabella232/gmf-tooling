/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.bridge.genmodel;

import java.util.Iterator;

import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;

/**
 * Encapsulates iteration over diagram definition.
 * @author artem
 */
public abstract class MappingTransformer {

	public void transform(Mapping m) {
		process(m.getDiagram());
		for (Iterator it = m.getNodes().iterator(); it.hasNext();) {
			process((NodeMapping) it.next());
		}
		for (Iterator it = m.getLinks().iterator(); it.hasNext();) {
			process((LinkMapping) it.next());
		}
	}

	protected abstract void process(CanvasMapping cme);
	protected abstract void process(NodeMapping nme);
	protected abstract void process(LinkMapping lme);
}