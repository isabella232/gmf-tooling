package commands

import com.google.inject.Inject
import org.eclipse.emf.ecore.EReference
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import common.Common

/**
 * EMF command to remove a link. Used by Reconnect*Commands and by ComponentEditPolicies.
 */
class DomainModelRemoveCommand {

	extension Common = new Common	
	@Inject extension CommandCommon

	def domainModelRemoveCommand(GenLink it, String edgeVar) '''
		«generatedMemberComment»
		private org.eclipse.emf.common.command.Command createDomainModelRemoveCommand(org.eclipse.emf.edit.domain.EditingDomain editingDomain) {
			«modelFacet.domainModelRemoveCommand('editingDomain', edgeVar)»
		}
	'''	
	
	def domainModelRemoveCommand(GenNode it, String nodeVar) '''
		«generatedMemberComment»
		private org.eclipse.emf.common.command.Command createDomainModelRemoveCommand(org.eclipse.emf.edit.domain.EditingDomain editingDomain) {
			«modelFacet.domainModelRemoveCommand('editingDomain', nodeVar)»
		}
	'''
	
	def domainModelRemoveCommand(LinkModelFacet it, String domainVar, String edgeVar)
		'''return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;'''
	
	def domainModelRemoveCommand(TypeLinkModelFacet it, String domainVar, String edgeVar) 
		'''«deleteCommand(domainVar, edgeVar)»'''
	
	def domainModelRemoveCommand(TypeModelFacet it, String domainVar, String edgeVar) 
		'''«deleteCommand(domainVar, edgeVar)»'''
	
	def deleteCommand(TypeModelFacet it, String domainVar, String elementVar) 
		'''return org.eclipse.gmf.runtime.gwt.commands.DestroyElementCommand.create(«domainVar», «elementVar».getElement());'''
	
	def domainModelRemoveCommand(FeatureLinkModelFacet it, String domainVar, String edgeVar) '''
		«IF metaFeature.referenceType && (metaFeature.ecoreFeature as EReference).containment»
		org.eclipse.emf.common.command.CompoundCommand result = new org.eclipse.emf.common.command.CompoundCommand();
		result.append(«metaFeature.unplugFeatureCommand(domainVar, edgeVar + '.getSource().getElement()', edgeVar + '.getTarget().getElement()')»);
		result.append(new org.eclipse.emf.edit.command.AddCommand(«domainVar», «edgeVar.getPhantomContainmentResource».getContents(), «edgeVar».getTarget().getElement()));
		return result;
		«ELSE»
		return «metaFeature.unplugFeatureCommand(domainVar, edgeVar + '.getSource().getElement()', edgeVar + '.getTarget().getElement()')»;
		«ENDIF»
	'''

}
