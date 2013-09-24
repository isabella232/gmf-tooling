package xpt.diagram.editpolicies

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram

/** 
 * FIXME: [MG] - reverse the calls? call common code from here and TextelectionEP and not vice versa 
*/
class TextSelectionEditPolicy {
	
	@Inject extension TextFeedback
	
	def className(GenDiagram it) '''«it.textSelectionEditPolicyClassName»'''

	def packageName(GenDiagram it) '''«it.editPoliciesPackageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''
	
	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''
	
	def TextSelectionEditPolicy(GenDiagram it) '''«TextSelectionEditPolicyInvocation(it)»'''
}