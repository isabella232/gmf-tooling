package commands

import com.google.inject.Inject
import common.CommandTemplate
import diagram.MetaModel
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet

class CreateLinkStartCommand extends CommandTemplate<GenLink> {
	
	extension MetaModel = new MetaModel

	@Inject extension CommandCommon

	override body(GenLink it) '''
		«attributes»
		«ctors»
		«shouldExecute»
		«modelFacet.getRelationshipContainer»
		«additions»
	'''

	override commandName(GenLink it) 
		'''Create«commandNameInfix»StartCommand'''

	override supertypes(GenLink it) 
		'''extends org.eclipse.gmf.runtime.gwt.commands.VetoCommand'''
	
	def attributes(GenLink it) '''
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.View source;
	'''

	def ctors(GenLink it) '''
		«generatedMemberComment»
		public «commandName»(org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx requestEx) {
			//Until the mouse button is pressed, the source of the connection is in request.getTargetEditPart(), not in request.getSourceEditPart().
			source = (org.eclipse.gmf.runtime.notation.View)requestEx.getTargetEditPart().getModel();
		}
	'''
	
	def dispatch CharSequence shouldExecute(GenLink it) '''
		«generatedMemberComment»
		protected boolean shouldExecute() {
			if (source == null) {
				return false;
			}
		«creationConstraints.checkLinkConstraints("source.getElement()", "null")»
		«modelFacet.shouldExecute»
		}
	'''
	
	def dispatch CharSequence shouldExecute(LinkModelFacet it) '''return false;'''
	
	def dispatch CharSequence shouldExecute(TypeLinkModelFacet it) '''
		«IF null != containmentMetaFeature»
		«shouldExecuteForNonNullContainmentMetaFeature»
		«ELSE»
		return false;
		«ENDIF»
	'''
	
	def dispatch CharSequence shouldExecute(FeatureLinkModelFacet it) '''
		«metaFeature.checkFeature('source.getElement()', null)»
		return true;
	'''
	
	def shouldExecuteForNonNullContainmentMetaFeature(TypeLinkModelFacet it) { 
		val sourceReverseFeature = if (sourceMetaFeature != null) sourceMetaFeature.reverse else null
		'''
		org.eclipse.emf.ecore.EObject containerEObj = getRelationshipContainer(source.getElement(), «containmentMetaFeature.genClass.metaClass»);
		«containmentMetaFeature.genClass.declareAndAssign('container', 'containerEObj')»
		if (container == null) {
			return false;
		}
		«containmentMetaFeature.checkFeature('container', containmentMetaFeature.genClass)»
		«IF childMetaFeature != null && (childMetaFeature != containmentMetaFeature && !childMetaFeature.ecoreFeature.derived)»
		«childMetaFeature.checkFeature('container', containmentMetaFeature.genClass)»
		«ENDIF»
		«IF sourceReverseFeature != null && (!sourceReverseFeature.ecoreFeature.derived && (sourceReverseFeature != containmentMetaFeature && sourceReverseFeature != childMetaFeature))»
		«sourceReverseFeature.checkFeature('source.getElement()', null)»
		«ENDIF»
		return true;
		'''
	}
	
	def checkFeature(GenFeature it, String containerVar, GenClass containerClass) '''
		«IF ecoreFeature.upperBound > 0»
		if («featureMultiplicityComparator(containerVar, containerClass)») {
			return false;
		}
		«ENDIF»
	'''

}
