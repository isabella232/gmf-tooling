/*
 * Copyright (c) 2007, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Borland - initial API and implementation
 */
package org.eclipse.gmf.internal.common.migrate;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public interface MigrationDelegate {
	
	public boolean setValue(EObject object, EStructuralFeature feature, Object value, int position);
	
	public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name, boolean isElement);
	
	public EClassifier getType(EFactory factory, String typeName);
	
	public EObject createObject(EFactory factory, EClassifier type);
	
	public void preResolve();

	public void processObject(EObject result);

	public boolean isMigrationApplied();

	public void setResource(Resource resource);

	public boolean setManyReference(EObject object, EStructuralFeature feature, Object[] values);

	public void postLoad();

	public String getURI(String prefix, String resolved);
}
