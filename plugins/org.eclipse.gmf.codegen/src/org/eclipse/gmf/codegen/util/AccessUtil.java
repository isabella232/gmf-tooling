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

import org.eclipse.gmf.codegen.gmfgen.GenBaseElement;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass;
import org.eclipse.gmf.codegen.gmfgen.GenNode;

/**
 * Utility methods for templates.
 * 
 * @author dstadnik
 */
public class AccessUtil {

	private AccessUtil() {}

	// naming patterns

	public static String getNameSemanticHint(GenBaseElement genElement) {
		return genElement.getDomainNameFeature().getName();
	}

	public static String getSemanticHintsClassName(GenBaseElement genElement) {
		String domainClassName;
		if (genElement instanceof GenLinkWithClass) {
			domainClassName = ((GenLinkWithClass) genElement).getDomainMetaClass().getName();
		} else {
			domainClassName = ((GenNode) genElement).getDomainMetaClass().getName();
		}
		return domainClassName + "SemanticHints"; //$NON-NLS-1$
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
