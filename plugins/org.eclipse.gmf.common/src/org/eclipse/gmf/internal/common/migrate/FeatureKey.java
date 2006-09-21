/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: dvorak - initial API and implementation
 */
package org.eclipse.gmf.internal.common.migrate;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Key class uniquely identifying a structural feature.
 * <p>
 * Motivation: avoid use of object identity based equals(..) for EStructuralFeature.    
 */
public class FeatureKey {
	
	private String namespaceURI;	
	private String className;
	private String featureName;
	
	/**
	 * Creates uninitialized feature key.
	 * <p>
	 * Note: It's safe to use {@link #equals(Object)}, {@link #hashCode()} on the created
	 * 		instance. A particular feature can be assigned repeatedly in order to support key 
	 * 		instance reuse. 
	 * 
	 * @see #setFeature(EStructuralFeature)     
	 */
	public FeatureKey() {			
	}
	
	public static FeatureKey create(EStructuralFeature feature) {
		FeatureKey pair = new FeatureKey();
		pair.setFeature(feature);
		return pair;
	}
	
	public void setFeature(EStructuralFeature feature) {
		EClass eClass = feature.getEContainingClass();
		this.className = (eClass != null) ? eClass.getName() : null;
		this.namespaceURI = (eClass != null && eClass.getEPackage() != null) ? eClass.getEPackage().getNsURI() : null;
		this.featureName = feature.getName();
	}
	
	@Override
	public boolean equals(Object that) {
		FeatureKey another = (FeatureKey) that;
		return	(className != null ? className.equals(another.className) : another.className == null) && 
				(featureName != null ? featureName.equals(another.featureName) : another.featureName == null) && 
				(namespaceURI != null ? namespaceURI.equals(another.namespaceURI) : another.namespaceURI == null);
	}
	
	@Override
	public int hashCode() {
		return (className == null ? 0 : className.hashCode()) ^ (featureName == null ? 0 : featureName.hashCode()) ^ (namespaceURI == null ? 0 : namespaceURI.hashCode());
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append('[').append(namespaceURI).append(']').append(':');
		buf.append(className).append(':').append(featureName);
		return buf.toString();
	}
}