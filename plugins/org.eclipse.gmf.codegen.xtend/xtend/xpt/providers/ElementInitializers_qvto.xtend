/**
 * Copyright (c) 2008, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - API extracted to GMF-T runtime, migrated to Xtend2 
 */
package xpt.providers

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum
import org.eclipse.gmf.codegen.gmfgen.GenFeatureValueSpec
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer
import java.util.Collection
import org.eclipse.gmf.codegen.gmfgen.GenReferenceNewElementSpec
import java.util.List

/**
 * FIXME: [MG] commented getSuffixes below
 */
@com.google.inject.Singleton class ElementInitializers_qvto { // 

	def List<Integer> newListAppending(List<Integer> list, int toAppend) {
		var result = <Integer>newLinkedList()
		result.addAll(list)
		result.add(toAppend)
		return result;
	}
	
	def dispatch boolean expressionResultNeedsCast(GenClassifier it) {
		return false
	}

	def dispatch boolean expressionResultNeedsCast(GenClass it) {
		return false
	}

	def dispatch boolean expressionResultNeedsCast(GenDataType it) {
		return it.isNumberObject() || it.isPrimitiveNumberType()
	}

	def dispatch boolean expressionResultNeedsCast(GenEnum it) {
		return true
	}

	/**
	 * Present approach may result in duplicated methods in few odd scenarios
	 * when same feature gets initialized using java language inside single ElementInitializer hierarchy, 
	 * e.g. for a given diagram element, with feature1 and feature2 of a same/similar kind:
	 * feature1
	 *   Instance1
	 *     featureX
	 *       InstanceX1
	 *         featureY = 'aaa' (Java)
	 * feature2
	 *   Instance2
	 *     featureX
	 *       InstanceX2
	 *         featureY = 'bbb' (Java)
	 * there would be two featureY_featureY_DiagramElement() methods
	 */
	def String javaMethodName(GenCommonBase de, GenFeatureValueSpec valueSpec) {
		var middlePart = ''
		if (valueSpec.featureSeqInitializer.creatingInitializer != null) {
			middlePart = valueSpec.featureSeqInitializer.creatingInitializer.feature.ecoreFeature.name + '_'
		}
		return valueSpec.feature.ecoreFeature.name + '_' + middlePart + de.uniqueIdentifier
	}

	def Iterable<GenFeatureValueSpec> recurseCollectValueSpec(GenFeatureSeqInitializer si) {
		return recurseCollectValueSpec(si, <GenFeatureValueSpec>newLinkedHashSet())
	}

	def Iterable<GenFeatureValueSpec> recurseCollectValueSpec(GenFeatureSeqInitializer si,
		Collection<GenFeatureValueSpec> acc) {
		acc.addAll(si.initializers.filter(typeof(GenFeatureValueSpec)))
		for (ref : si.initializers.filter(typeof(GenReferenceNewElementSpec))) {
			for (featureSeqInit : ref.newElementInitializers) {
				recurseCollectValueSpec(featureSeqInit, acc)
			}
		}
		return acc
	}

	def String getVariableName(String prefix, Iterable<Integer> suffixes) {
		return prefix + combinedSuffix(suffixes)
	}

	protected def dispatch boolean isNumberObject(GenClassifier it) {
		return false
	}

	protected def dispatch boolean isNumberObject(GenClass it) {
		return false
	}

	protected def dispatch boolean isNumberObject(GenEnum it) {
		return false
	}

	protected def dispatch boolean isNumberObject(GenDataType it) {
		return switch (it.ecoreDataType.instanceClassName) {
			case 'java.math.BigDecimal': true
			case 'java.math.BigInteger': true
			case 'java.lang.Byte': true
			case 'java.lang.Double': true
			case 'java.lang.Float': true
			case 'java.lang.Integer': true
			case 'java.lang.Long': true
			case 'java.lang.Short': true
			default: false
		}
	}

	protected def dispatch boolean isPrimitiveNumberType(GenClassifier it) {
		return false
	}

	protected def dispatch boolean isPrimitiveNumberType(GenClass it) {
		return false
	}

	protected def dispatch boolean isPrimitiveNumberType(GenEnum it) {
		return false
	}

	protected def dispatch boolean isPrimitiveNumberType(GenDataType it) {
		return switch (it.ecoreDataType.instanceClassName) {
			case 'byte': true
			case 'double': true
			case 'float': true
			case 'int': true
			case 'long': true
			case 'short': true
			default: false
		}
	}

	def String combinedSuffix(Iterable<Integer> suffixes) {
		return '_' + suffixes.join('_')
	}

}
