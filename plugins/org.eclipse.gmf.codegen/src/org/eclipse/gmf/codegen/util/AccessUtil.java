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
package org.eclipse.gmf.codegen.util;

import java.util.Iterator;

import org.eclipse.gmf.codegen.gmfgen.EntryBase;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;

/**
 * Utility methods for templates.
 * 
 * @author dstadnik
 */
public class AccessUtil {

	private AccessUtil() {}

	private static String asJavaConstantName(String s) {
		s = s.toUpperCase();
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (i == 0) {
				if (!Character.isJavaIdentifierStart(c)) {
					c = '_';
				}
			} else {
				if (!Character.isJavaIdentifierPart(c)) {
					c = '_';
				}
			}
			b.append(c);
		}
		return b.toString();
	}

	// naming patterns

	public static String getCompartmentId(GenChildContainer compartment) {
		return asJavaConstantName(compartment.getTitleKey());
	}

	public static String getPaletteEntryId(EntryBase entry) {
		return asJavaConstantName(entry.getTitleKey());
	}

	public static String getLabelId(GenLabel label) {
		return label.getMetaFeature().getUpperName() + "_LABEL"; //$NON-NLS-1$
	}

	public static String getLabelTextId(GenLabel label) {
		return label.getMetaFeature().getUpperName() + "_TEXT"; //$NON-NLS-1$
	}

	public static String getNodeLabelEditPartClassName(GenNode genNode) {
		return "Label" + genNode.getEditPartClassName(); //$NON-NLS-1$
	}

	public static String getSemanticHintsClassName(GenCommonBase genElement) {
		return genElement.getClassNamePrefix() + genElement.getClassNameSuffux() + "SemanticHints"; //$NON-NLS-1$
	}

	// model access

	/**
	 * Returns iterator that traverse gen entities hierarchy
	 * starting from the specified root entity.
	 */
	public static Iterator getGenEntities(GenCommonBase genEntity) {
		return new GenIterator(genEntity);
	}

	private static class GenIterator implements Iterator {

		private GenCommonBase entity;
		private int feature; // internal id of the current structural feature
		private Iterator featureIterator; // running iterator for the feature
		private Object nextValue;

		public GenIterator(GenCommonBase entity) {
			this.entity = entity;
			nextValue = entity;
		}

		public boolean hasNext() {
			return nextValue != null;
		}

		public Object next() {
			if (nextValue == null) {
				return null;
			}
			Object value;
			if (nextValue instanceof GenIterator) {
				GenIterator nextIterator = (GenIterator) nextValue;
				value = nextIterator.next();
				if (!nextIterator.hasNext()) {
					nextValue = advance();
				}
			} else {
				value = nextValue;
				nextValue = advance();
			}
			if (nextValue instanceof GenNode) {
				nextValue = new GenIterator((GenNode) nextValue);
			}
			return value;
		}

		public void remove() {}

		protected Object advance() {
			if (featureIterator == null) {
				assert feature == 0;
				featureIterator = createFeatureIterator(++feature);
			}
			while (!featureIterator.hasNext()) {
				featureIterator = createFeatureIterator(++feature);
				if (featureIterator == null) {
					// no more features to traverse
					return null;
				}
			}
			return featureIterator.next();
		}

		protected Iterator createFeatureIterator(int feature) {
			Iterator i = null;
			if (entity instanceof GenDiagram) {
				GenDiagram genDiagram = (GenDiagram) entity;
				if (feature == 1) {
					i = genDiagram.getNodes().iterator();
				} else if (feature == 2) {
					i = genDiagram.getLinks().iterator();
				}
			} else if (entity instanceof GenNode) {
				GenNode genNode = (GenNode) entity;
				if (feature == 1) {
					i = genNode.getChildNodes().iterator();
				}
			}
			return i;
		}
	}
}
