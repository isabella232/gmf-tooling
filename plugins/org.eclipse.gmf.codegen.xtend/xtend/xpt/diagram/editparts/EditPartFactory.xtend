/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.diagram.editparts

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common
import xpt.editor.VisualIDRegistry

class EditPartFactory {

	@Inject extension Common;
	@Inject VisualIDRegistry xptVisualIDRegistry;

	def EditPartFactory(GenDiagram it) '''
		«copyright(getDiagram().editorGen)»
		package «editPartsPackageName»;
		
		«generatedClassComment()»
		public class «editPartFactoryClassName» implements org.eclipse.gef.EditPartFactory {
		
			«createEditPartMethod()»
			
			«createUnrecognizedEditPart()»
			
			«getTextCellEditorLocator()»
			
			«additions()»
		}
	'''

	def createEditPartMethod(GenDiagram it) '''
		«generatedMemberComment(it)»
		public org.eclipse.gef.EditPart createEditPart(org.eclipse.gef.EditPart context, Object model) {
			if (model instanceof org.eclipse.gmf.runtime.notation.View) {
				org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) model;
				switch («xptVisualIDRegistry.getVisualIDMethodCall(it)»(view)) {
					
				«createEditPart(it)»
				«FOR node : it.allNodes»
					«createEditPart(node)»
					«FOR label : node.labels»
						«createEditPart(label)»
					«ENDFOR»
				«ENDFOR»
				«FOR comp : it.compartments»
					«createEditPart(comp)»
				«ENDFOR»
				«FOR link : it.links»
					«createEditPart(link)»
					«FOR label : link.labels»
						«createEditPart(label)»
					«ENDFOR»
				«ENDFOR»
				}
			}
			return createUnrecognizedEditPart(context, model);
		}
	'''

	private def createEditPart(GenCommonBase it) '''
		«caseVisualID()»
			return new «getEditPartQualifiedClassName()»(view);
			
	'''

	def createUnrecognizedEditPart(GenDiagram it) '''
		«generatedMemberComment()»
		 private org.eclipse.gef.EditPart createUnrecognizedEditPart(org.eclipse.gef.EditPart context, Object model) {
		 	// Handle creation of unrecognized child node EditParts here
		 	return null;
		 }
	'''

	def getTextCellEditorLocator(GenDiagram it) '''
		«generatedMemberComment()»
		public static org.eclipse.gef.tools.CellEditorLocator getTextCellEditorLocator(
				org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart source) {
			return org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
		}
	'''

	def additions(GenDiagram it) '''«stampXtend2»'''

}
