/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.common.migrate;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

public class MigrationHelperDelegateImpl implements MigrationHelperDelegate {
	private final EStructuralFeature myDeletedAttribute = EcoreFactory.eINSTANCE.createEAttribute();

	public MigrationHelperDelegateImpl() {
		super();
		myDeletedAttribute.setName("attributeIsDeleted"); //$NON-NLS-1$
		myDeletedAttribute.setEType(EcorePackage.eINSTANCE.getEString());
	}

	private Map<EClassifier, Collection<String>> myDeletedAttributes = new HashMap<EClassifier, Collection<String>>();
	private Map<EReference, EClass> myNarrowReferenceTypes = new HashMap<EReference, EClass>();
	private Map<EClass, Map<String, EStructuralFeature>> myRenamedAttributes = new HashMap<EClass, Map<String, EStructuralFeature>>();
	private Map<String, EClassifier> myRenamedTypes = new HashMap<String, EClassifier>();
	
	public void registerDeletedAttributes(EClassifier classifier, String... deletedAttrNames) {
		assert !myDeletedAttributes.containsKey(classifier);
		myDeletedAttributes.put(classifier, Arrays.asList(deletedAttrNames));
	}
	
	public void registerNarrowReferenceType(EReference reference, EClass concreteType) {
		myNarrowReferenceTypes.put(reference, concreteType);
	}
	
	public void registerRenamedAttributes(EClass eClass, Map<String, EStructuralFeature> renamedAttributes) {
		myRenamedAttributes.put(eClass, renamedAttributes);
	}
	
	public void registerRenamedType(String oldTypeName, EClassifier newType) {
		myRenamedTypes.put(oldTypeName, newType);
	}
	
	public void registerRenamedAttribute(EClass eClass, String oldName, EStructuralFeature newStructuralFeature) {
		Map<String, EStructuralFeature> renamedAttributes = myRenamedAttributes.get(eClass);
		if (renamedAttributes == null) {
			renamedAttributes = new HashMap<String, EStructuralFeature>();
		}
		renamedAttributes.put(oldName, newStructuralFeature);
		registerRenamedAttributes(eClass, renamedAttributes);
	}
	
	public boolean isAttributeDeleted(EClass clazz, String name) {
		Collection<String> deletedAttributes = myDeletedAttributes.get(clazz);
		boolean result = deletedAttributes != null && deletedAttributes.contains(name);
		for (Iterator<EClass> it=clazz.getEAllSuperTypes().iterator(); !result && it.hasNext();) {
			EClass nextParent = it.next();
			result = isAttributeDeleted(nextParent, name);
		}
		return result;
	}
	
	public EClass getNarrowReferenceType(EStructuralFeature feature) {
		return myNarrowReferenceTypes.get(feature);
	}

	public EStructuralFeature getRenamedFeatureFor(EClass clazz, String name) {
	    Map<String, EStructuralFeature> renamings = myRenamedAttributes.get(clazz);
		EStructuralFeature result = renamings != null ? renamings.get(name) : null;
		for (Iterator<EClass> it=clazz.getEAllSuperTypes().iterator(); result == null && it.hasNext();) {
			EClass nextParent = it.next();
			result = getRenamedFeatureFor(nextParent, name);
		}
		return result;
	}

	public EClassifier getRenamedType(String typeName) {
		return myRenamedTypes.get(typeName);
	}

	public EClass getStructuralFeatureType(EStructuralFeature feature) {
		return getNarrowReferenceType(feature);
	}

	public boolean setValue(EObject object, EStructuralFeature feature, Object value, int position) {
		return myDeletedAttribute.equals(feature);
	}

	public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name, boolean isElement) {
		EStructuralFeature result = null;
		EStructuralFeature rename = null;
		if ((rename = getRenamedFeatureFor(eClass, name)) != null) {
			result = rename;
		} else if (isAttributeDeleted(eClass, name)) {
			result = myDeletedAttribute;
		}
		return result;
	}

	public EClassifier getType(EFactory factory, String typeName) {
		EClassifier result = null;
		EClassifier type = getRenamedType(typeName);
		if (type != null) {
			result = type;
		}
		return result;
	}

	public EObject createObject(EFactory factory, EClassifier type) {
		return null;
	}
	
	public void postProcess() {
	}

	public void processObject(EObject result) {
	}

	public boolean isOldVersionDetected(String uriString) {
		return true;
	}
	
	protected static EReference createNewReference(String name, EClass eType, boolean isContainment) {
		EReference ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setName(name);
		ref.setEType(eType);
		ref.setContainment(isContainment);
		ref.setLowerBound(0);
		ref.setUpperBound(-1);
		return ref;
	}
}