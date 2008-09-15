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
package org.eclipse.gmf.internal.xpand.migration;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.VoidType;

public class TypeManager {

	private static final String OCL_PATH_SEPARATOR = "::";

	private final ModeltypeImports modeltypeImportsManger;

	public static final boolean isListType(EClassifier classifier) {
		return classifier.getName().endsWith(BuiltinMetaModel.LIST);
	}

	public static final boolean isSetType(EClassifier classifier) {
		return classifier.getName().endsWith(BuiltinMetaModel.SET);
	}
	
	public TypeManager() {
		modeltypeImportsManger = null;
	}

	public TypeManager(ModeltypeImports modelImports) {
		modeltypeImportsManger = modelImports;
	}

	public String getQvtFQName(EEnumLiteral literal) {
		return getPackageName(literal.getEEnum().getEPackage()) + OCL_PATH_SEPARATOR + literal.getEEnum().getName() + OCL_PATH_SEPARATOR + literal.getName();
	}

	public String getQvtFQName(EClassifier classifier) throws MigrationException {
		if (classifier == BuiltinMetaModel.VOID) {
			return VoidType.SINGLETON_NAME;
		}
		if (classifier instanceof EDataType) {
			/**
			 * Handling QVT primitive types here.
			 */
			if (EcorePackage.eINSTANCE.getEString() == classifier) {
				return PrimitiveType.STRING_NAME;
			} else if (EcorePackage.eINSTANCE.getEBoolean() == classifier) {
				return PrimitiveType.BOOLEAN_NAME;
			} else if (EcorePackage.eINSTANCE.getEInt() == classifier) {
				return PrimitiveType.INTEGER_NAME;
			} else if (EcorePackage.eINSTANCE.getEDouble() == classifier) {
				return PrimitiveType.REAL_NAME;
			} else if (EcorePackage.eINSTANCE.getEJavaObject() == classifier) {
				return AnyType.SINGLETON_NAME;
			}
		}
		if (BuiltinMetaModel.isCollectionType(classifier)) {
			StringBuilder sb = new StringBuilder();
			if (isSetType(classifier)) {
				sb.append("Set(");
			} else if (isListType(classifier)) {
				sb.append("Sequence(");
			} else {
				sb.append("Collection(");
			}
			// was: if (classifier ==
			// CollectionTypesSupport.COLLECTION_OF_OBJECT || classifier ==
			// CollectionTypesSupport.LIST_OF_OBJECT || classifier ==
			// CollectionTypesSupport.SET_OF_OBJECT) {
			sb.append(getQvtFQName(BuiltinMetaModel.getInnerType(classifier)));
			return sb.append(")").toString();
		}
		EPackage ePackage = classifier.getEPackage();
		assert ePackage != null;
		return getPackageName(ePackage) + OCL_PATH_SEPARATOR + classifier.getName();
	}
	
	private String getPackageName(EPackage ePackage) {
		return modeltypeImportsManger != null ? modeltypeImportsManger.getModeltypeAlias(ePackage) : ePackage.getName();
	}

}
