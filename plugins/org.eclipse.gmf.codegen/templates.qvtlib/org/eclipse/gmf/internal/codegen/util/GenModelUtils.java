/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.util;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

public class GenModelUtils {

	@Operation(contextual = false, kind = Kind.HELPER)
	public static GenClass getDocumentRoot(GenPackage genPackage) {
		return genPackage.hasDocumentRoot() ? genPackage.getDocumentRoot() : null;
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public static GenClassifier findGenClassifier(GenModel genModel, EClassifier eClassifier) {
		return genModel.findGenClassifier(eClassifier);
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public static Boolean isListType(GenFeature genFeature) {
		// can't implement in .qvto because
		// XMLTypePackage.eNS_URI.equals(getExtendedMetaData().getNamespace((EStructuralFeature)eTypedElement));
		// part of the check seems to be essential
		return genFeature.isListType();
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public static Boolean isDerived(GenFeature genFeature) {
		return genFeature.isDerived();
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public static GenClass getTypeGenClassX(GenFeature genFeature) {
		return genFeature.getTypeGenClass();
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public static String getGetAccessor(GenFeature genFeature) {
		return genFeature.getGetAccessor();
	}
}