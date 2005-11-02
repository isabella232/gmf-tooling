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

/**
 * Naming for EditPart classes.
 * @author artem
 */
public class EditPartNamingStrategy extends DefaultNamingStrategy {

	protected String getLinkSuffix() {
		return getNodeSuffix();
	}

	protected String getNodeSuffix() {
		return "EditPart";
	}

	protected String getCanvasSuffix() {
		return getNodeSuffix();
	}

	protected String getChildNodeSuffix() {
		return "ChildNodeEditPart";
	}

	protected String getChildNodeLabelSuffix() {
		return getChildNodeSuffix();
	}

	protected String getLinkLabelSuffix() {
		return getNodeSuffix();
	}

	protected String getNodeLabelSuffix() {
		return getNodeSuffix();
	}

	protected String getCompartmentSuffix() {
		return "CompartmentEditPart";
	}
	
}
