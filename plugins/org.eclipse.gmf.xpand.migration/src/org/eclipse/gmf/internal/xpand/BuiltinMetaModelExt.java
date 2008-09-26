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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;

public class BuiltinMetaModelExt extends BuiltinMetaModel {

	public final static String ORDEREDSET = "OrderedSet";

	public final static String BAG = "Bag";

	public final static String COLLECTION = "Collection";

	private static CollectionTypesSupportExt collectionTypesExt = new CollectionTypesSupportExt();

	static {
		collectionTypesExt.init(XECORE);
	}

	public static final boolean isListType(EClassifier classifier) {
		return classifier.getName().endsWith(BuiltinMetaModel.LIST);
	}

	public static final boolean isSetType(EClassifier classifier) {
		return classifier.getName().endsWith(BuiltinMetaModel.SET);
	}

	// TODO: remove this method - no OrderedSets during migration.
	public static final boolean isOrderedSetType(EClassifier classifier) {
		return classifier.getName().endsWith(BuiltinMetaModelExt.ORDEREDSET);
	}

	public static final boolean isBagType(EClassifier classifier) {
		return classifier.getName().endsWith(BuiltinMetaModelExt.BAG);
	}

	public static final boolean isAbstractCollectionType(EClassifier classifier) {
		return classifier.getName().endsWith(BuiltinMetaModelExt.COLLECTION);
	}
	
	public static EClass getBagType(EClassifier innerType) {
		return collectionTypesExt.getBagType(innerType);
	}
	
	public static EClass getOrderedSetType(EClassifier innerType) {
		return collectionTypesExt.getOrderedSetType(innerType);
	}
	
	public static EClass replaceCollectionElementType(EClassifier collectionType, EClassifier newElementType) {
		if (isListType(collectionType)) {
			return getListType(newElementType);
		} else if (isSetType(collectionType)) {
			return getSetType(newElementType);
		} else if (isOrderedSetType(collectionType)) {
			return getOrderedSetType(newElementType);
		} else if (isBagType(collectionType)) {
			return getBagType(newElementType);
		} else {
			return getCollectionType(newElementType);
		}
	}

	// TODO: Consider different collection types here
	public static EClassifier getCommonSuperType(Collection<EClassifier> elementTypes) {
		if (elementTypes.size() == 0) {
			return BuiltinMetaModel.VOID;
		}
		Iterator<EClassifier> it = elementTypes.iterator();
		EClassifier superType = it.next();
		while(it.hasNext()) {
			superType = getCommonSuperType(superType, it.next());
		}
		return superType;
	}

	public static EClassifier getCommonSuperType(EClassifier type1, EClassifier type2) {
		if (BuiltinMetaModel.VOID == type1) {
			return type2;
		}
		if (BuiltinMetaModel.isAssignableFrom(type1, type2)) {
			return type1;
		}
		if (type1 instanceof EClass) {
			EClass eClass = (EClass) type1;
			for (EClass nextSuperType : getAllSuperTypes(eClass)) {
				if (BuiltinMetaModel.isAssignableFrom(nextSuperType, type2)) {
					return nextSuperType;
				}
			}
		}
		return EcorePackage.eINSTANCE.getEJavaObject();
	}

	private static List<EClass> getAllSuperTypes(EClass eClass) {
		List<EClass> result = new ArrayList<EClass>(eClass.getESuperTypes());
		for (int i = 1; i < result.size(); i++) {
			EClass nextSuperType = result.get(i);
			result.addAll(nextSuperType.getESuperTypes());
		}
		return result;
	}

}
