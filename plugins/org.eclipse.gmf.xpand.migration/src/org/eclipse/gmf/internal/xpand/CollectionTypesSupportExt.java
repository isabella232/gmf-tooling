/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

public class CollectionTypesSupportExt {

	// These are M2 elements, next to EClass and EReferences, extension of ECore
	// meta model
	static final EClass BAG_TYPE = EcoreFactory.eINSTANCE.createEClass();

	static final EClass ORDEREDSET_TYPE = EcoreFactory.eINSTANCE.createEClass();

	static EClass BAG_OF_OBJECT;

	static EClass ORDEREDSET_OF_OBJECT;

	private final Map<EClassifier, EClass> bagsM1 = new HashMap<EClassifier, EClass>();

	private final Map<EClassifier, EClass> orderedSetsM1 = new HashMap<EClassifier, EClass>();

	void init(EPackage xecore) {
		BAG_TYPE.setName(BuiltinMetaModelExt.BAG);
		ORDEREDSET_TYPE.setName(BuiltinMetaModelExt.ORDEREDSET);
		BAG_TYPE.getESuperTypes().add(CollectionTypesSupport.COLLECTION_TYPE);
		ORDEREDSET_TYPE.getESuperTypes().add(CollectionTypesSupport.COLLECTION_TYPE);
		xecore.getEClassifiers().add(BAG_TYPE);
		xecore.getEClassifiers().add(ORDEREDSET_TYPE);

		BAG_OF_OBJECT = newBagType(EcorePackage.eINSTANCE.getEJavaObject());
		ORDEREDSET_OF_OBJECT = newOrderedSetType(EcorePackage.eINSTANCE.getEJavaObject());
		bagsM1.put(null, newBagType(BuiltinMetaModel.VOID));
		orderedSetsM1.put(null, newOrderedSetType(BuiltinMetaModel.VOID));
	}

	/**
	 * @param name
	 * @return true if name is one of M2 collection meta-types (either
	 *         Collection, List, Set)
	 */
	// TODO: remove? is it important?
	public boolean isCollectionMetaType(String name) {
		return BAG_TYPE.getName().equals(name) || ORDEREDSET_TYPE.getName().equals(name);
	}

	public EClass getCollectionType(String metaTypeName, EClassifier innerType) {
		assert isCollectionMetaType(metaTypeName);
		if (BAG_TYPE.getName().equals(metaTypeName)) {
			return getBagType(innerType);
		}
		if (ORDEREDSET_TYPE.getName().equals(metaTypeName)) {
			return getOrderedSetType(innerType);
		}
		throw new IllegalStateException();
	}

	EClass getCollectionType(EClass metaType, EClassifier innerType) {
		if (BAG_TYPE.equals(metaType)) {
			return getBagType(innerType);
		}
		if (ORDEREDSET_TYPE.equals(metaType)) {
			return getOrderedSetType(innerType);
		}
		throw new IllegalStateException();
	}

	public EClass getBagType(EClassifier innerType) {
		EClass existing = bagsM1.get(innerType);
		if (existing == null) {
			existing = newBagType(innerType);
			bagsM1.put(innerType, existing);
		}
		return existing;
	}

	public EClass getOrderedSetType(EClassifier innerType) {
		EClass existing = orderedSetsM1.get(innerType);
		if (existing == null) {
			existing = newOrderedSetType(innerType);
			orderedSetsM1.put(innerType, existing);
		}
		return existing;
	}

	private static EClass newBagType(EClassifier innerType) {
		EClass c = BuiltinMetaModel.internalNewParameterizedType(BAG_TYPE, innerType);
		c.getESuperTypes().add(CollectionTypesSupport.COLLECTION_OF_OBJECT);
		return c;
	}

	private static EClass newOrderedSetType(EClassifier innerType) {
		EClass c = BuiltinMetaModel.internalNewParameterizedType(ORDEREDSET_TYPE, innerType);
		c.getESuperTypes().add(CollectionTypesSupport.COLLECTION_OF_OBJECT);
		return c;
	}

}
