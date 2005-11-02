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

import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeMapping;

/**
 * Means to provide your own names for classes being generated from genmodel. 
 * Return values (class names) are not expected to be fully-qualified names.
 * <code>null</code> return value means use default naming scheme handcoded in genmodel impl.
 * Instances of this class could be used as-is in case you are ok with naming scheme coded in genmodel 
 * @author artem
 */
public class NamingStrategy {

	public String createClassName(NodeMapping nme) {
		return null;
	}
	
	public String createLableTextClassName(NodeMapping nme) {
		return null;
	}

	public String createClassName(ChildNodeMapping chnme) {
		return null;
	}
	
	public String createLableTextClassName(ChildNodeMapping chnme) {
		return null;
	}

	public String createClassName(LinkMapping lme) {
		return null;
	}

	public String createLableClassName(LinkMapping lme) {
		return null;
	}

	public String createLableTextClassName(LinkMapping lme) {
		return null;
	}

	
	public String createClassName(CanvasMapping mapping) {
		return null;
	}
	
	public String createClassName(Compartment compartment) {
		return null;
	}
	
}
