/**
 * Copyright (c) 2006-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt

import java.util.Set
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenFeatureImpl
import org.eclipse.emf.ecore.EDataType

class GenModelUtils_qvto {
	private static final Set<String> PRIMITIVES = newHashSet('boolean', 'byte', 'char', 'double', 'float', 'int', 'long',
		'short');

	/**
	 * GenModel functionality unrelated to EMF generated code
	 * or metamodel access only.
	 */
	def GenFeature getReverse(GenFeature feature) {
		return feature.reverse;
	}

	/**
	 * For primitive types, return their java.lang wrappers, for non-primitive
	* types returns instanceClassName as is
	* 
	*/
	def String getObjectCompatibleClassName(EDataType dt) {
		val String instanceClass = dt.instanceClassName;
		if(instanceClass.contains('.')) return instanceClass;
		return switch (instanceClass) {
			case 'boolean': return "java.lang.Boolean"
			case 'byte': return 'java.lang.Byte'
			case 'char': return 'java.lang.Character'
			case 'double': return 'java.lang.Double'
			case 'float': return 'java.lang.Float'
			case 'int': return 'java.lang.Integer'
			case 'long': return 'java.lang.Long'
			case 'short': return 'java.lang.Short'
			default: 'java.lang.Object'
		}
	}

	//GenFeature#getTypeGenClassifier()
	def GenClassifier getTypeGenClassifier(GenFeature feature) {
		return feature.typeGenClassifier;
	}

	/**
	* FIXME: for models loaded from generated package (e.g. gmf tests often
	* refer to EClass/EOperation directly from EcorePackage) instanceClassName
	* is always set and thus all metamodel types are treated as external interfaces,
	* with useless casts to EObject
	* 
	* GenClass#isExternalInterface()
	 */
	def boolean isExternalInterface(GenClass gc) {
		return gc.externalInterface;
	}

	//GenFeatureImpl#isContains
	def boolean isContains(GenFeature gf) {
		return (gf as GenFeatureImpl).contains;
	}

	def boolean isPrimitiveType(GenFeature gf) {
		return PRIMITIVES.contains(gf.ecoreFeature.EType.instanceClassName)
	}

	//Workaround for EMF 2.5M4 change (bug #255469) - always assume implicit EObject supertype.
	def boolean isSuperTypeOf(GenClass xptSelf, GenClass subclassCandidate) {
		if (xptSelf.ecoreClass.name == 'EObject' &&
			xptSelf.ecoreClass.EPackage.nsURI == 'http://www.eclipse.org/emf/2002/Ecore') {
			return true;
		}
		return xptSelf.ecoreClass.isSuperTypeOf(subclassCandidate.ecoreClass)
	}

	/**
	 * @returns 4 for Java1.4, 5 for JDK 5.0, 6 for JDK6.0 and 7 for JDK7.0
 	*/
	def int jdkComplianceLevel(GenClass xptSelf) {
		var GenJDKLevel l = if (xptSelf == null) GenJDKLevel::JDK60_LITERAL else xptSelf.genPackage.genModel.complianceLevel;
		switch (l) {
			case GenJDKLevel::JDK14_LITERAL: 4
			case GenJDKLevel::JDK50_LITERAL: 5
			case GenJDKLevel::JDK60_LITERAL: 6
			case GenJDKLevel::JDK70_LITERAL: 7
			default: 6
		}
	}

}
