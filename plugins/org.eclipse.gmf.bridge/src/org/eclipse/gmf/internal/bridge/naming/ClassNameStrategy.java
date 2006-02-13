/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.naming;

import java.util.Iterator;

import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.mappings.AbstractNodeMapping;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.LinkLabelMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeLabelMapping;
import org.eclipse.gmf.mappings.NodeMapping;

/**
 * @author artem
 */
public class ClassNameStrategy extends AbstractNamingStrategy {

	private final String mySuffix;

	public ClassNameStrategy(String suffix) {
		this(suffix, null, new CollectingDispenser());
	}

	public ClassNameStrategy(String suffix, NamingStrategy chained, UniqueValueDispenser dispenser) {
		super(chained);
		assert suffix != null;
		mySuffix = suffix;
		setCache(dispenser);
	}

	public String get(CanvasMapping cme) {
		if (cme.getDomainMetaElement() == null) {
			return super.get(cme);
		}
		return createClassName(cme.getDomainMetaElement().getName());
	}

	public String get(NodeMapping nme) {
		if (nme.getDomainContext() == null) {
			return super.get(nme);
		}
		return createClassName(nme.getDomainContext().getName());
	}

	public String get(LinkMapping lme) {
		if (lme.getDomainMetaElement() != null) {
			return createClassName(lme.getDomainMetaElement().getName());
		} else if (lme.getLinkMetaFeature() != null) {
			return createClassName(lme.getLinkMetaFeature().getName());
		}
		return super.get(lme);
	}

	public String get(ChildNodeMapping nme) {
		if (nme.getDomainContext() == null) {
			return super.get(nme);
		}
		return createClassName(nme.getDomainContext().getName());
	}

	public String get(CompartmentMapping cm) {
		if (cm.getParentNodeMapping().getDomainContext() == null || cm.getCompartment() == null) {
			return super.get(cm);
		}
		return createClassName(cm.getParentNodeMapping().getDomainContext().getName() + '_' + cm.getCompartment().getName());
	}

	private String getQualifier(LabelMapping mapping) {
		String text = mapping.getText();
		if (text != null && text.length() > 0) {
			return text.length() > 8 ? text.substring(0, 8) : text;
		}
		assert mapping.getFeatures().size() > 0;
		StringBuffer sb = new StringBuffer();
		for (Iterator features = mapping.getFeatures().iterator(); features.hasNext();) {
			EAttribute feature = (EAttribute) features.next();
			if (sb.length() > 0) {
				sb.append('_');
			}
			sb.append(feature.getName());
		}
		return sb.toString();
	}

	public String getForEditFeature(AbstractNodeMapping nme, NodeLabelMapping labelMapping) {
		if (nme.getDomainContext() == null) {
			return super.getForEditFeature(nme, labelMapping);
		}
		String qualifier;
		if (labelMapping == null) {
			qualifier = nme.getEditFeature().getName();
		} else {
			qualifier = getQualifier(labelMapping);
		}
		return createClassName(nme.getDomainContext().getName() + '_' + qualifier);
	}

	public String getForEditFeature(LinkMapping lme, LinkLabelMapping labelMapping) {
		if (lme.getLabelEditFeature() == null) {
			return super.getForEditFeature(lme, labelMapping);
		}
		String qualifier;
		if (labelMapping == null) {
			qualifier = lme.getLabelEditFeature().getName();
		} else {
			qualifier = getQualifier(labelMapping);
		}
		if (lme.getDomainMetaElement() != null) {
			return createClassName(lme.getDomainMetaElement().getName() + '_' + qualifier);
		} else if (lme.getLinkMetaFeature() != null) {
			return createClassName(lme.getLinkMetaFeature().getName() + '_' + qualifier);
		}
		return super.getForEditFeature(lme, labelMapping);
	}

	protected String createClassName(String name) {
		name = CodeGenUtil.validJavaIdentifier(name);
		if (name.length() > 0) {
			name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
		}
		String fullName = ensureUnique(name, mySuffix);
		cacheName(fullName);
		return fullName;
	}

	protected String ensureUnique(String name, String suffix) {
		int i = 2;
		String uniqueName = name;
		while (isCachedName(uniqueName + suffix)) {
			uniqueName = name + i++;
		}
		return uniqueName + suffix;
	}

	private boolean isCachedName(String string) {
		return getCache() == null ? false : !getCache().isUnique(string);
	}

	private void cacheName(String fullName) {
		if (getCache() != null) {
			getCache().remember(fullName);
		}
	}

}
