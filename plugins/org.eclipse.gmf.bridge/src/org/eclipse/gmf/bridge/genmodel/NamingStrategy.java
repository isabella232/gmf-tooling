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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.mappings.AbstractNodeMapping;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.ToolGroup;

/**
 * Means to provide your own names for classes being generated from genmodel. 
 * Returned values (class names) are not expected to be fully qualified names.
 * <code>null</code> return value means that default naming scheme handcoded
 * in genmodel impl should be used. Instances of this class could be used as is
 * in case you are ok with naming scheme provided by genmodel.
 * 
 * @author artem
 */
public class NamingStrategy {

	public String createCanvasClassName(CanvasMapping mapping, String suffix) {
		return null;
	}

	public String createNodeClassName(NodeMapping mapping, String suffix) {
		return null;
	}

	public String createChildNodeClassName(ChildNodeMapping mapping, String suffix) {
		return null;
	}

	public String createCompartmentClassName(AbstractNodeMapping mapping, Compartment compartment, String suffix) {
		return null;
	}

	public String createNodeLabelClassName(AbstractNodeMapping mapping, EStructuralFeature labelFeature, String suffix) {
		return null;
	}

	public String createLinkClassName(LinkMapping mapping, String suffix) {
		return null;
	}

	public String createLinkLabelClassName(LinkMapping mapping, EStructuralFeature labelFeature, String suffix) {
		return null;
	}
	
	public String createToolCreationMethodName(AbstractNodeMapping nodeMapping) {
		return null;
	}

	public String createToolCreationMethodName(LinkMapping linkMapping) {
		return null;
	}
	
	public String createToolGroupCreationMethodName(ToolGroup toolGroup) {
		return null;
	}
	
	public void reset() {
	};
}
