package diagram.parts

import com.google.inject.Inject
import common.BaseClassTemplate
import diagram.VisualIDRegistry
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram

class EditPartFactory extends BaseClassTemplate<GenDiagram> {
	
	extension CommonHelper = new CommonHelper
	
	@Inject extension VisualIDRegistry

	override generate(GenDiagram  it) '''
		package «editPartsPackageName»;

		«generatedClassComment»
		public class «editPartFactoryClassName» «supertypes(it)» {
			«body»
		}
	'''

	override body(GenDiagram it) 
	'''
		«externalNodeLabels»
		«clientFactory»
		«ctor»
		«createEditPart»
		«createUnrecognizedEditPart»
	'''

	override qualifiedClassName(GenDiagram it) { editPartFactoryQualifiedClassName }
	
	override supertypes(GenDiagram it) 
		'''implements org.eclipse.gef.EditPartFactory'''

	private val externalNodeLabels = '''
		«generatedMemberComment»
		public static final String EXTERNAL_NODE_LABELS_LAYER = "External Node Labels";
	'''

	private val clientFactory = '''
		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory;
	'''
	
	private def ctor(GenDiagram it) '''
		«generatedMemberComment»
		public «diagram.editPartFactoryClassName»(org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory) {
			this.clientFactory = clientFactory;
		}
	'''

	private def createEditPart(GenDiagram it) '''
		«generatedMemberComment»
		public org.eclipse.gef.EditPart createEditPart(org.eclipse.gef.EditPart context, Object model) {
			if (model instanceof org.eclipse.gmf.runtime.notation.View) {
				org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) model;
				String modelID = «getModelIDMethodCall»(view);
				if (!«modelID».equals(modelID)) {
					return null;
				}
				int viewVisualID = «getVisualIDMethodCall»(view);
				switch (viewVisualID) {
					«FOR c: getAllContainers»«c.doCreate»«ENDFOR»
					«FOR l: links»«l.doCreate»«ENDFOR»
				}
			}
			return createUnrecognizedEditPart(context, model);
		}
	'''

	private def CharSequence doCreate(GenCommonBase it) 
		'''
			«caseVisualID»
			«FOR label: allLabels»
			«doCreate(label)»
			«ENDFOR»
		'''

	private val createUnrecognizedEditPart = '''
		«generatedMemberComment»
		private org.eclipse.gef.EditPart createUnrecognizedEditPart(org.eclipse.gef.EditPart context, Object model) {
			// Handle creation of unrecognized child node EditParts here
			return null;
		}
	'''

	private def caseVisualID(GenCommonBase base) '''
		case «visualID(base)»:
			return new «base.getEditPartQualifiedClassName()»(«base.cast»view, clientFactory);
	'''

	private dispatch def cast(GenCommonBase base) ''''''
	private dispatch def cast(GenDiagram base) '''(org.eclipse.gmf.runtime.notation.Diagram)'''

}