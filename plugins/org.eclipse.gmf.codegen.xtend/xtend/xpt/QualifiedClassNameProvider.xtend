package xpt

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import xpt.diagram.editpolicies.CompartmentItemSemanticEditPolicy
import xpt.diagram.editpolicies.DiagramItemSemanticEditPolicy
import xpt.diagram.editpolicies.LinkItemSemanticEditPolicy
import xpt.diagram.editpolicies.NodeItemSemanticEditPolicy
import xpt.diagram.commands.CreateNodeCommand
import xpt.diagram.commands.CreateLinkCommand

class QualifiedClassNameProvider {

	@Inject CompartmentItemSemanticEditPolicy compItemSemantic;
	@Inject DiagramItemSemanticEditPolicy diagramItemSemantic;
	@Inject LinkItemSemanticEditPolicy linkItemSemantic;
	@Inject NodeItemSemanticEditPolicy nodeItemSemantic;
	
	@Inject CreateLinkCommand linkCommand
	@Inject CreateNodeCommand nodeCommand
	
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenCommonBase it) ''''''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenDiagram it) '''«diagramItemSemantic.qualifiedClassName(it)»'''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenCompartment it) '''«compItemSemantic.qualifiedClassName(it)»'''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenLink it) '''«linkItemSemantic.qualifiedClassName(it)»'''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenNode it) '''«nodeItemSemantic.qualifiedClassName(it)»'''
	
	def dispatch getItemSemanticEditPolicyClassName(GenCommonBase it) ''''''
	def dispatch getItemSemanticEditPolicyClassName(GenDiagram it) '''«diagramItemSemantic.className(it)»'''
	def dispatch getItemSemanticEditPolicyClassName(GenCompartment it) '''«compItemSemantic.className(it)»'''
	def dispatch getItemSemanticEditPolicyClassName(GenLink it) '''«linkItemSemantic.className(it)»'''
	def dispatch getItemSemanticEditPolicyClassName(GenNode it) '''«nodeItemSemantic.className(it)»'''
	
	def dispatch getCreateCommandQualifiedClassName(GenCommonBase it) ''''''
	def dispatch getCreateCommandQualifiedClassName(GenNode it) '''«nodeCommand.qualifiedClassName(it)»'''
	def dispatch getCreateCommandQualifiedClassName(GenLink it) '''«linkCommand.qualifiedClassName(it)»'''
}