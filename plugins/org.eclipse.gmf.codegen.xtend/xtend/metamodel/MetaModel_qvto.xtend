/*
 * Copyright (c) 2008, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package metamodel

import com.google.inject.Inject
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl
import xpt.GenModelUtils_qvto

/*package local*/
class MetaModel_qvto {
	@Inject extension GenModelUtils_qvto

	def String getQualifiedPackageInterfaceName(GenPackage gp) {
		return gp.qualifiedPackageInterfaceName
	}

	//--
	//-- GenPackageImpl#getQualifiedFactoryInterfaceName()
	//--
	def String getQualifiedFactoryInterfaceName(GenPackage gp) {
		return (gp as GenPackageImpl).qualifiedFactoryInterfaceName
	}

	//--
	//-- GenPackage#getFactoryInstanceName
	//--
	def String getFactoryInstanceName(GenPackage gp) {
		return gp.factoryInstanceName;
	}

	//--
	//-- GenPackageImpl#getQualifiedItemProviderAdapterFactoryClassName()
	//--
	def String getQualifiedItemProviderAdapterFactoryClassName(GenPackage gp) {
		return (gp as GenPackageImpl).qualifiedItemProviderAdapterFactoryClassName
	}

	//--
	//-- GenClass#getQualifiedInterfaceName
	//--
	def String getQualifiedInterfaceName(GenClass gc) {
		return gc.qualifiedInterfaceName
	}

	//-- NOTE GenDataType#getQualifiedInstanceClassName returns primitive types as is,
	//-- while we return their java.lang wrappers
	def dispatch String getQualifiedClassName(GenClassifier xptSelf) {
		return xptSelf.qualifiedClassName
	}

	def dispatch String getQualifiedClassName(GenDataType xptSelf) {
		return xptSelf.ecoreDataType.getObjectCompatibleClassName()
	}

	def dispatch String getQualifiedClassName(GenEnum xptSelf) {
		return xptSelf.qualifiedClassName
	}

	//--
	//-- GenClass#getClassifierAccessorName
	//--
	def String getClassifierAccessorName(GenClassifier gc) {
		return gc.classifierAccessorName;
	}

	//--
	//-- GenFeature#getFeatureAccessorName
	//--
	def String getFeatureAccessorName(GenFeature gf) {
		return gf.featureAccessorName;
	}

	/*
	 * Casts the argument (which is assumed to be of the given source class) to the given target class. 
	 * A null value may be used for both source and target class to specify the EObject class.
	 * If the cast is required, it will be parenthesized as a whole, producing, e.g., ((EObject) o). 
	 * If the parentheses are not required, use unparenthesizedCast() extension.
	 */
	def String parenthesizedCast(String what, GenClass source, GenClass target) {
		if (needsCast(source, target)) {
			return '(' + unparenthesizedCast(what, source, target) + ')';
		} else {
			return what;
		}
	}

	/*
	 * Casts the argument (which is assumed to be of the given source class) to the given target class. 
	 * A null value may be used for both source and target class to specify the EObject class.
	 * If the cast is required, it will NOT be parenthesized as a whole, producing, e.g., (EObject) o. 
	 * If the parentheses are required, use parenthesizedCast() extension.
	 */
	def String unparenthesizedCast(String what, GenClass source, GenClass target) {
		return (if (needsCast(source, target))
			(if (target == null)
				'(org.eclipse.emf.ecore.EObject)' + what
			else
				'(' + getQualifiedInterfaceName(target) + ')' + what)
		else
			what)
	}

	//--See cast()
	private def boolean needsCast(GenClass source, GenClass target) {
		if (source == target) {
			return false;
		}
		if (target == null) {
			return source != null && source.externalInterface
		}
		return source == null || source.externalInterface || target.externalInterface || !target.isSuperTypeOf(source)
	}
}
