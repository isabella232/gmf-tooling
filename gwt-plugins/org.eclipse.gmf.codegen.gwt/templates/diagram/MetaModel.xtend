package diagram

import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType

class MetaModel {

	def getMetaClass(GenClassifier it) 
		'''«it.genPackage.getQualifiedPackageInterfaceName».eINSTANCE.get«it.getClassifierAccessorName»()'''

	def getMetaFeature(GenFeature it) 
		'''«it.genPackage.getQualifiedPackageInterfaceName».eINSTANCE.get«it.getFeatureAccessorName»()'''

	def castEObject(GenClass it, String eObjectValue) 
		'''(«getQualifiedInterfaceName») «eObjectValue»'''
	
	def downcastToEObject(GenClass it, String value) 
		'''«IF isExternalInterface»(org.eclipse.emf.ecore.EObject) «ENDIF»«value»'''

	def newInstance(GenClass it)
		'''
		«IF it.mapEntry»
		«getQualifiedFactoryInterfaceName(it.genPackage)».«getFactoryInstanceName(it.genPackage)».create(«metaClass»)
		«ELSE»
		«getQualifiedFactoryInterfaceName(genPackage)».«getFactoryInstanceName(genPackage)».create«ecoreClass.name»()
		«ENDIF»
		'''

	def newInstance(GenClass it, String varName) 
		'''«getQualifiedInterfaceName» «varName» = «IF it.mapEntry»(«getQualifiedInterfaceName») «ENDIF»«newInstance(it)»;'''
	
	/*
	 * Declares new variable of appropriate type and assigns casted value to it.
 	*/
	def declareAndAssign(GenClass it, String assignee, String value) 
		'''«getQualifiedInterfaceName» «assignee» = («getQualifiedInterfaceName») «value»;'''

	def getQualifiedFactoryInterfaceName(GenPackage gp) { (gp as GenPackageImpl).qualifiedFactoryInterfaceName }

	def getFactoryInstanceName(GenPackage gp) { gp.factoryInstanceName }
	
	def getFeatureValue(GenFeature it, String containerVar, GenClass containerClass) '''
		«IF isExternalInterface(containerClass)»
			((«featureTargetType») ((org.eclipse.emf.ecore.EObject) «containerVar»).eGet(«metaFeature»))
		«ELSE»
			«containerVar».«getGetAccessor»()
		«ENDIF»
	'''
	
	def getFeatureValue(GenFeature it, String containerVar, GenClass container, Boolean needsCastToResultType) '''
		«IF isExternalInterface(genClass)»
			«IF needsCastToResultType»((«featureTargetType») «ENDIF»«parenthesizedCast(containerVar, container, null)».eGet(«metaFeature»)«IF needsCastToResultType»)«ENDIF»
		«ELSE»
		«parenthesizedCast(containerVar, container, genClass)».«getGetAccessor»()
		«ENDIF»
	'''
	
	
	def featureTargetType(GenFeature it) '''«IF isListType»java.util.List«ELSE»«findGenClassifier(genClass.genPackage.genModel, ecoreFeature.EType).QualifiedClassName»«ENDIF»'''
	
	def parenthesizedCast(String what, GenClass source, GenClass target) {
		if (needsCast(source, target)) '(' + unparenthesizedCast(what, source, target) + ')' else what
	}

	def unparenthesizedCast(String what, GenClass source, GenClass target) {
		if (needsCast(source, target))
			if (target == null)
				"(org.eclipse.emf.ecore.EObject)" + what 
			else '(' + target.getQualifiedInterfaceName + ')' + what 
		else what
	}

	def needsCast(GenClass source, GenClass target) {
		if (source == target) 
			false 
		else if (target == null) 
			source != null && source.isExternalInterface 
			else source == null || (target.isExternalInterface || (source.isExternalInterface || !target.ecoreClass.isSuperTypeOf(source.ecoreClass)))
	}
	
	def GenClassifier findGenClassifier(GenModel genModel, EClassifier eClassifier) {
		genModel.findGenClassifier(eClassifier)
	}
	
	def dispatch QualifiedClassName(GenClass it) '''«getQualifiedInterfaceName»'''
	def dispatch QualifiedClassName(GenClassifier it) '''«getQualifiedClassName()»'''
	
	def dispatch getQualifiedClassName(GenClassifier it) {
		null
	}
	
	def dispatch getQualifiedClassName(GenDataType it) {
		ecoreDataType.getObjectCompatibleClassName
	}
	
	def dispatch getQualifiedClassName(GenEnum it) {
		genPackage.getInterfacePackageName + '.' + ecoreEnum.name
	}
	
	def getObjectCompatibleClassName(EDataType it) {
		if (instanceClassName.indexOf('.') > 0) instanceClassName 
		else switch instanceClassName { 
			case 'boolean': 'java.lang.Boolean' 
			case 'byte': 'java.lang.Byte' 
			case 'char': 'java.lang.Character' 
			case 'double': 'java.lang.Double'
			case 'float': 'java.lang.Float'
			case 'int': 'java.lang.Integer' 
			case 'long': 'java.lang.Long' 
			case 'short': 'java.lang.Short' 
			default:'java.lang.Object' 
		}
	}

	/*
	 * Does instanceof check.
	 */
	def IsInstance(GenClass it, String accessor) 
		'''«accessor» instanceof «getQualifiedInterfaceName»'''
		
	def isExternalInterface(GenClass genClass) {
		null != genClass.ecoreClass.instanceClassName
	}

}