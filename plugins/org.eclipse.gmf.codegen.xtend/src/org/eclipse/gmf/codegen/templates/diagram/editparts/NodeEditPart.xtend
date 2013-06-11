package org.eclipse.gmf.codegen.templates.diagram.editparts

import com.google.inject.Inject
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.gmf.codegen.gmfgen.GenNode
import xpt.Common

class NodeEditPart {

	@Inject extension Common;

	def getFilePath(GenNode genNode) {
		genNode.editPartQualifiedClassName + '_New'
	}

	def generate(GenNode genNode) '''
		«genPackageDeclaration(genNode)»
		
		public class «genNode.editPartClassName + '_New'» {
			
			«generatedClassComment(genNode)»
			public void doIt() {}
			
		
			«generatedClassComment(genNode, ' Some additional comment')»
			public «genNode.editPartClassName»() {
			}
		
		}
	'''

	def genPackageDeclaration(GenNode genNode) '''
		package «CodeGenUtil::getPackageName(genNode.editPartQualifiedClassName)»;
		
	'''
}
