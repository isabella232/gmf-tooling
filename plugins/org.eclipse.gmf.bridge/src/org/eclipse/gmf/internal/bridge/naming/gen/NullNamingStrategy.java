/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.naming.gen;

import org.eclipse.gmf.internal.bridge.naming.NamingStrategy;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeMapping;

/**
 * @author dstadnik
 */
public class NullNamingStrategy implements NamingStrategy {

	public String get(CanvasMapping mapping) {
		return null;
	}

	public String get(CompartmentMapping mapping) {
		return null;
	}

	public String get(LabelMapping mapping) {
		return null;
	}

	public String get(LinkMapping mapping) {
		return null;
	}

	public String get(NodeMapping mapping) {
		return null;
	}
}
