package org.eclipse.gmf.codegen.templates.diagram.editparts

import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.emf.codegen.util.CodeGenUtil

class NodeEditPart {
	
	def getFilePath(GenNode genNode) {
		genNode.editPartQualifiedClassName
	}
	
	def generate(GenNode genNode) '''
		«genPackageDeclaration(genNode)»
		
		public class «genNode.editPartClassName» {

			/**
			 *
			 * @generated
			**/
			public «genNode.editPartClassName»() {
			}

		}
	'''
	def genPackageDeclaration(GenNode genNode) '''
		package «CodeGenUtil::getPackageName(genNode.editPartQualifiedClassName)»;
		
	'''
}