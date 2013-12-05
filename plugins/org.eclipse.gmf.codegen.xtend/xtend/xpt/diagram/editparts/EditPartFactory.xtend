/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
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
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import diagram.editparts.ChildNodeLabelEditPart
import diagram.editparts.NodeEditPart
import diagram.editparts.LinkEditPart
import diagram.editparts.LinkLabelEditPart
import diagram.editparts.ExternalNodeLabelEditPart
import diagram.editparts.CompartmentEditPart
import diagram.editparts.NodeLabelEditPart
import diagram.editparts.DiagramEditPart

@com.google.inject.Singleton class EditPartFactory {

	@Inject extension Common;
	@Inject ChildNodeLabelEditPart childNodeLabelEditPart;
	@Inject NodeEditPart nodeEditPart;
	@Inject LinkEditPart linkEditPart;
	@Inject LinkLabelEditPart linkLabelEditPart;
	@Inject ExternalNodeLabelEditPart externalNodeLabelEditPart;
	@Inject CompartmentEditPart compartmentEditPart;
	@Inject NodeLabelEditPart nodeLabelEditPart;
	@Inject DiagramEditPart diagramEditPart;

	@Inject VisualIDRegistry xptVisualIDRegistry;

	def className(GenDiagram it) '''«it.editPartFactoryClassName»'''

	def packageName(GenDiagram it) '''«it.editPartsPackageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def EditPartFactory(GenDiagram it) '''
		«copyright(getDiagram().editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment()»
		public class «className(it)» implements org.eclipse.gef.EditPartFactory {
		
			«createEditPartMethod(it)»
			
			«createUnrecognizedEditPart(it)»

			«getTextCellEditorLocator(it)»
			
			«additions(it)»
		}
	'''

	def createEditPartMethod(GenDiagram it) '''
		«generatedMemberComment()»
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
					«extraLineBreak»
				«ENDFOR»
				}
			}
			return createUnrecognizedEditPart(context, model);
		}
	'''

	private def createEditPart(GenCommonBase it) '''
		«extraLineBreak»
		«xptVisualIDRegistry.caseVisualID(it)»
			return new «getEditPartQualifiedClassName(it)»(view);
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

	def dispatch getEditPartQualifiedClassName(GenCommonBase it) ''''''
	def dispatch getEditPartQualifiedClassName(GenNode it) '''«nodeEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenLink it) '''«linkEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenCompartment it) '''«compartmentEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenDiagram it) '''«diagramEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenExternalNodeLabel it) '''«externalNodeLabelEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenNodeLabel it) '''«nodeLabelEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenLinkLabel it) '''«linkLabelEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenChildLabelNode it) '''«childNodeLabelEditPart.qualifiedClassName(it)»'''

	def additions(GenDiagram it) ''''''

}
