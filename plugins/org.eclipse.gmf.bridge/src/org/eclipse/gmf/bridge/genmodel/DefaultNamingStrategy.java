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

import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.mappings.AbstractNodeMapping;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeMapping;

/**
 * In most cases it should be sufficient to override <code>getXXXSuffix()</code>
 * methods to get nice and valid class names.
 * Implementation keeps track of produced names and tries to create unique name 
 * appending numerical suffix to it. Use {@link #clearNamesCache()} to clean 
 * names cache in case you reuse the instance.
 * 
 * @author artem
 */
public class DefaultNamingStrategy extends NamingStrategy {

	protected Set/* <String> */myNamesCache;

	public DefaultNamingStrategy() {
		myNamesCache = new HashSet();
	}

	public DefaultNamingStrategy(Set namesCache) {
		myNamesCache = namesCache;
		if (myNamesCache == null) {
			myNamesCache = new HashSet();
		}
	}

	public void reset() {
		myNamesCache.clear();
	}

	public String createCanvasClassName(CanvasMapping mapping, String suffix) {
		if (mapping.getDomainMetaElement() == null) {
			return null;
		}
		return createClassName(mapping.getDomainMetaElement().getName(), getCanvasSuffix(suffix));
	}

	public String createNodeClassName(NodeMapping mapping, String suffix) {
		if (mapping.getDomainMetaClass() == null) {
			return null;
		}
		return createClassName(mapping.getDomainMetaClass().getName(), getNodeSuffix(suffix));
	}

	public String createChildNodeClassName(ChildNodeMapping mapping, String suffix) {
		if (mapping.getDomainMetaClass() == null) {
			return null;
		}
		return createClassName(mapping.getDomainMetaClass().getName(), getChildNodeSuffix(suffix));
	}

	public String createCompartmentClassName(AbstractNodeMapping mapping, Compartment compartment, String suffix) {
		if (mapping.getDomainMetaClass() == null) {
			return null;
		}
		return createClassName(mapping.getDomainMetaClass().getName() + '_' + compartment.getName(), getCompartmentSuffix(suffix));
	}

	public String createNodeLabelClassName(AbstractNodeMapping mapping, EStructuralFeature labelFeature, String suffix) {
		if (mapping.getDomainMetaClass() == null) {
			return null;
		}
		return createClassName(mapping.getDomainMetaClass().getName() + '_' + labelFeature.getName(), getCompartmentSuffix(suffix));
	}

	public String createLinkClassName(LinkMapping mapping, String suffix) {
		if (mapping.getDomainMetaClass() != null) {
			return createClassName(mapping.getDomainMetaClass().getName(), getLinkSuffix(suffix));
		} else if (mapping.getLinkMetaFeature() != null) {
			return createClassName(mapping.getLinkMetaFeature().getName(), getLinkSuffix(suffix));
		}
		return null;
	}

	public String createLinkLabelClassName(LinkMapping mapping, EStructuralFeature labelFeature, String suffix) {
		if (mapping.getDomainMetaClass() != null) {
			return createClassName(mapping.getDomainMetaClass().getName() + '_' + labelFeature.getName(), getLinkSuffix(suffix));
		} else if (mapping.getLinkMetaFeature() != null) {
			return createClassName(mapping.getLinkMetaFeature().getName() + '_' + labelFeature.getName(), getLinkSuffix(suffix));
		}
		return null;
	}

	/**
	 * Returns specific class suffix instead of the specified default suffix.
	 * Returned value should be valid java class name suffix.
	 */
	protected String getCanvasSuffix(String suffix) {
		return suffix;
	}

	/**
	 * Returns specific class suffix instead of the specified default suffix.
	 * Returned value should be valid java class name suffix.
	 */
	protected String getNodeSuffix(String suffix) {
		return suffix;
	}

	/**
	 * Returns specific class suffix instead of the specified default suffix.
	 * Returned value should be valid java class name suffix.
	 */
	protected String getChildNodeSuffix(String suffix) {
		return suffix;
	}

	/**
	 * Returns specific class suffix instead of the specified default suffix.
	 * Returned value should be valid java class name suffix.
	 */
	protected String getCompartmentSuffix(String suffix) {
		return suffix;
	}

	/**
	 * Returns specific class suffix instead of the specified default suffix.
	 * Returned value should be valid java class name suffix.
	 */
	protected String getLinkSuffix(String suffix) {
		return suffix;
	}

	protected String createClassName(String name, String suffix) {
		name = CodeGenUtil.validJavaIdentifier(name);
		if (name.length() > 0) {
			name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
		}
		String fullName = ensureUnique(name, suffix);
		myNamesCache.add(fullName);
		return fullName;
	}

	protected String ensureUnique(String name, String suffix) {
		int i = 2;
		String uniqueName = name;
		while (myNamesCache.contains(uniqueName + suffix)) {
			uniqueName = name + i++;
		}
		return uniqueName + suffix;
	}
}
