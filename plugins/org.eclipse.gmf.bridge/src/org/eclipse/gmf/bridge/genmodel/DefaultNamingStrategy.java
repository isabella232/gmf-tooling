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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.diadef.Node;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.jdt.core.JavaConventions;

/**
 * In most cases it should be sufficient to override <code>getXXXSuffix()</code>
 * methods to get nice and valid class names.
 * Implementation keeps track of produced names and tries to create unique name 
 * appending numerical suffix to it. Use {@link #clearUniqueNameCache()} to clean 
 * names cache in case you reuse the instance. 
 * 
 * @author artem
 */
public class DefaultNamingStrategy extends NamingStrategy {
	private final Set/* <String> */myNamesCache = new HashSet();

	public String createClassName(CanvasMapping mapping) {
		return translateNameToJavaIdentifier(mapping.getDiagramCanvas().getName() + getCanvasSuffix());
	}
	
	public String createClassName(NodeMapping nme) {
		return translateNameToJavaIdentifier(nme.getDiagramNode().getName() + getNodeSuffix());
	}

	public String createLableTextClassName(NodeMapping nme) {
		return translateNameToJavaIdentifier(nme.getDiagramNode().getName() + " " + (nme.getEditFeature() != null ? nme.getEditFeature().getName() : "LabelText" + nme.hashCode()) + getNodeLabelSuffix());
	}
	
	public String createClassName(ChildNodeMapping chnme) {
		return translateNameToJavaIdentifier(chnme.getDiagramNode().getName() + getChildNodeSuffix());
	}
	
	public String createLableTextClassName(ChildNodeMapping chnme) {
		return translateNameToJavaIdentifier(chnme.getDiagramNode().getName() + " " + (chnme.getEditFeature() != null ? chnme.getEditFeature().getName() : "LabelText" + chnme.hashCode()) + getChildNodeLabelSuffix());
	}

	public String createClassName(LinkMapping lme) {
		return translateNameToJavaIdentifier(lme.getDiagramLink().getName() + getLinkSuffix());
	}

	public String createLableClassName(LinkMapping lme) {
		return translateNameToJavaIdentifier(lme.getDiagramLink().getName() + " " + (lme.getLabelEditFeature() != null ? lme.getLabelEditFeature().getName() : "Label" + lme.hashCode()) + getLinkLabelSuffix());
	}

	public String createLableTextClassName(LinkMapping lme) {
		return translateNameToJavaIdentifier(lme.getDiagramLink().getName() + " " + (lme.getLabelEditFeature() != null ? lme.getLabelEditFeature().getName() : "LabelText" + lme.hashCode()) + getLinkLabelTextSuffix());
	}
	
	public String createClassName(Compartment compartment) {
		return translateNameToJavaIdentifier(((Node) compartment.eContainer()).getName() + " " + compartment.getName() + getCompartmentSuffix());
	}
	
	protected String getNodeLabelSuffix() {
		return "";
	}
	
	protected String getLinkLabelSuffix() {
		return "";
	}
	
	protected String getLinkLabelTextSuffix() {
		return "Text" + getLinkLabelSuffix();
	}

	protected String getCompartmentSuffix() {
		return "";
	}

	protected String getLinkSuffix() {
		return "";
	}

	protected String getNodeSuffix() {
		return "";
	}

	protected String getCanvasSuffix() {
		return "";
	}

	protected String getChildNodeSuffix() {
		return "";
	}
	
	protected String getChildNodeLabelSuffix() {
		return "";
	}

	public void clearUniqueNameCache() {
		myNamesCache.clear();
	}

	protected String ensureUnique(String name) {
		int i = 2;
		while (myNamesCache.contains(name)) {
			name = name + String.valueOf(i++); 
		}
		return name;
	}

	protected String translateNameToJavaIdentifier(String name) {
		name = name.trim();
		IStatus s = JavaConventions.validateJavaTypeName(name);
		if (s.getSeverity() != IStatus.ERROR) {
			return name;
		}
		StringBuffer sb = new StringBuffer(name.length());
		if (!Character.isJavaIdentifierStart(name.charAt(0)) && Character.isJavaIdentifierPart(name.charAt(0))) {
			sb.append('_');
		}
		for (int i = 0; i < name.length(); i++) {
			if (Character.isJavaIdentifierPart(name.charAt(i))) {
				sb.append(name.charAt(i));
			} else {
				sb.append('_');
			}
		}
		return ensureUnique(sb.toString());
	}
}
