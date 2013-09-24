package xpt.diagram.editpolicies

import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import com.google.inject.Inject

/** 
 * FIXME: [MG] - reverse the calls? call common code from here and TextelectionEP and not vice versa 
*/
class TextNonResizableEditPolicy {
	@Inject extension TextFeedback
	
	def className(GenDiagram it) '''«it.textNonResizableEditPolicyClassName»'''

	def packageName(GenDiagram it) '''«it.editPoliciesPackageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''
	
	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''
	
	def TextNonResizableEditPolicy(GenDiagram it) '''«TextNonResizableEditPolicyInvocation(it)»'''
}