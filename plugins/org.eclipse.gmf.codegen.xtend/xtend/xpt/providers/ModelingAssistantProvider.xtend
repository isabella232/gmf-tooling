/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Borland) - #244970 (GenChildLabelNode can't be link's source/target)
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.providers

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import xpt.Common
import xpt.Common_qvto
import xpt.Externalizer
import xpt.ExternalizerUtils_qvto
import xpt.diagram.editparts.Utils_qvto

class ModelingAssistantProvider {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;
	@Inject extension ExternalizerUtils_qvto;

	@Inject ElementTypes xptElementTypes;
	@Inject Externalizer xptExternalizer;

	def extendsList(GenDiagram it) '''extends org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider'''

	def ModelingAssistantProvider(GenDiagram it) '''
		«copyright(editorGen)»
		package «providersPackageName»;
		
		«generatedClassComment»
		public class «modelingAssistantProviderClassName» «extendsList(it)» {
		
			«getTypesForPopupBar(it)»
		
			«getRelTypesOnSource(it)»
		
			«getRelTypesOnTarget(it)»
		
			«getRelTypesOnSourceAndTarget(it)»
		
			«getTypesForSource(it)»
		
			«getTypesForTarget(it)»
		
			«selectExistingElementForSource(it)»
		
			«selectExistingElementForTarget(it)»
		
			«selectExistingElement(it)»
		
			«isApplicableElement(it)»
		
			«selectElement(it)»
		
			«additions(it)»
		}
	'''

	def getTypesForPopupBar(GenDiagram it) '''
		«generatedMemberComment»
		public java.util.List getTypesForPopupBar(org.eclipse.core.runtime.IAdaptable host) {
			org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart editPart =
					(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) host.getAdapter(
							org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart.class);
			«FOR container : getAllContainers()»
				«IF container.assistantNodes.notEmpty»
					if (editPart instanceof «container.getEditPartQualifiedClassName()») {
					«newArrayListOfElementTypes('types')»(«container.assistantNodes.size»);
					«FOR node : container.assistantNodes»
						types.add(«xptElementTypes.accessElementType(node)»);
					«ENDFOR»
					return types;
					}
				«ENDIF»
			«ENDFOR»
			return java.util.Collections.EMPTY_LIST;
		}
	'''

	def getRelTypesOnSource(GenDiagram it) '''
		«generatedMemberComment»
		public java.util.List getRelTypesOnSource(org.eclipse.core.runtime.IAdaptable source) {
			org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart sourceEditPart =
					(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) source.getAdapter(
							org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart.class);
			«FOR source : getAllNodes()»
				«IF getAssistantOutgoingLinks(source).notEmpty»
					if (sourceEditPart instanceof «source.getEditPartQualifiedClassName()») {
						return ((«source.getEditPartQualifiedClassName()») sourceEditPart).getMARelTypesOnSource();
					}
				«ENDIF»
			«ENDFOR»
			return java.util.Collections.EMPTY_LIST;
		}
	'''

	def getRelTypesOnTarget(GenDiagram it) '''
		«generatedMemberComment»
		public java.util.List getRelTypesOnTarget(org.eclipse.core.runtime.IAdaptable target) {
			org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart targetEditPart =
					(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) target.getAdapter(
							org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart.class);
			«FOR target : getAllNodes()»
				«IF getAssistantIncomingLinks(target).notEmpty»
					if (targetEditPart instanceof «target.getEditPartQualifiedClassName()») {
						return ((«target.getEditPartQualifiedClassName()») targetEditPart).getMARelTypesOnTarget();
					}
				«ENDIF»
			«ENDFOR»
			return java.util.Collections.EMPTY_LIST;
		}
	'''

	def getRelTypesOnSourceAndTarget(GenDiagram it) '''
		«generatedMemberComment»
		public java.util.List getRelTypesOnSourceAndTarget(
				org.eclipse.core.runtime.IAdaptable source, org.eclipse.core.runtime.IAdaptable target) {
			org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart sourceEditPart =
			(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) source.getAdapter(
					org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart.class);
			org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart targetEditPart =
			(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) target.getAdapter(
					org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart.class);
			«FOR source : getAllNodes()»
			«IF getAssistantOutgoingLinks(source).notEmpty»
				if (sourceEditPart instanceof «source.getEditPartQualifiedClassName()») {
					return ((«source.getEditPartQualifiedClassName()») sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
				}
			«ENDIF»
			«ENDFOR»
			return java.util.Collections.EMPTY_LIST;
		}
	'''

	def getTypesForSource(GenDiagram it) '''
		«generatedMemberComment»
		public java.util.List getTypesForSource(org.eclipse.core.runtime.IAdaptable target,
				org.eclipse.gmf.runtime.emf.type.core.IElementType relationshipType) {
			org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart targetEditPart =
			(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) target.getAdapter(
					org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart.class);
			«FOR target : getAllNodes()»
			«IF getAssistantIncomingLinks(target).notEmpty»
				if (targetEditPart instanceof «target.getEditPartQualifiedClassName()») {
					return ((«target.getEditPartQualifiedClassName()») targetEditPart).getMATypesForSource(relationshipType);
				}
			«ENDIF»
			«ENDFOR»
			return java.util.Collections.EMPTY_LIST;
		}
	'''

	def getTypesForTarget(GenDiagram it) '''
		«generatedMemberComment»
		public java.util.List getTypesForTarget(org.eclipse.core.runtime.IAdaptable source,
				org.eclipse.gmf.runtime.emf.type.core.IElementType relationshipType) {
			org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart sourceEditPart =
			(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) source.getAdapter(
					org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart.class);
			«FOR source : getAllNodes()»
			«IF getAssistantOutgoingLinks(source).notEmpty»
				if (sourceEditPart instanceof «source.getEditPartQualifiedClassName()») {
					return ((«source.getEditPartQualifiedClassName()») sourceEditPart).getMATypesForTarget(relationshipType);
				}
			«ENDIF»
			«ENDFOR»
			return java.util.Collections.EMPTY_LIST;
		}
	'''

	def selectExistingElementForSource(GenDiagram it) '''
		«generatedMemberComment»
		public org.eclipse.emf.ecore.EObject selectExistingElementForSource(
				org.eclipse.core.runtime.IAdaptable target,
				org.eclipse.gmf.runtime.emf.type.core.IElementType relationshipType) {
			return selectExistingElement(target, getTypesForSource(target, relationshipType));
		}
	'''

	def selectExistingElementForTarget(GenDiagram it) '''
		«generatedMemberComment»
		public org.eclipse.emf.ecore.EObject selectExistingElementForTarget(
				org.eclipse.core.runtime.IAdaptable source,
				org.eclipse.gmf.runtime.emf.type.core.IElementType relationshipType) {
			return selectExistingElement(source, getTypesForTarget(source, relationshipType));
		}
	'''

	def selectExistingElement(GenDiagram it) '''
		«generatedMemberComment»
		protected org.eclipse.emf.ecore.EObject selectExistingElement(
				org.eclipse.core.runtime.IAdaptable host, java.util.Collection types) {
			if (types.isEmpty()) {
			return null;
			}
			org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart editPart =
			(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) host.getAdapter(
					org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart.class);
			if (editPart == null) {
			return null;
			}
			org.eclipse.gmf.runtime.notation.Diagram diagram =
			(org.eclipse.gmf.runtime.notation.Diagram) editPart.getRoot().getContents().getModel();
			java.util.HashSet<org.eclipse.emf.ecore.EObject> elements = new java.util.HashSet<org.eclipse.emf.ecore.EObject>();
			for (java.util.Iterator<org.eclipse.emf.ecore.EObject> it = diagram.getElement().eAllContents(); it.hasNext();) {
			org.eclipse.emf.ecore.EObject element = it.next();
			if (isApplicableElement(element, types)) {
			elements.add(element);
			}
			}
			if (elements.isEmpty()) {
			return null;
			}
			return selectElement((org.eclipse.emf.ecore.EObject[]) elements.toArray(
			new org.eclipse.emf.ecore.EObject[elements.size()]));
		}
	'''

	def isApplicableElement(GenDiagram it) '''
		«generatedMemberComment»
		protected boolean isApplicableElement(org.eclipse.emf.ecore.EObject element, java.util.Collection types) {
			org.eclipse.gmf.runtime.emf.type.core.IElementType type =
					org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry.getInstance().getElementType(element);
			return types.contains(type);
		}
	'''

	def selectElement(GenDiagram it) '''
		«generatedMemberComment»
		protected org.eclipse.emf.ecore.EObject selectElement(org.eclipse.emf.ecore.EObject[] elements) {
			org.eclipse.swt.widgets.Shell shell = org.eclipse.swt.widgets.Display.getCurrent().getActiveShell();
			org.eclipse.jface.viewers.ILabelProvider labelProvider =
				new org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider(
					«editorGen.plugin.activatorQualifiedClassName».getInstance().getItemProvidersAdapterFactory());
			org.eclipse.ui.dialogs.ElementListSelectionDialog dialog =
					new org.eclipse.ui.dialogs.ElementListSelectionDialog(shell, labelProvider);
			dialog.setMessage(«xptExternalizer.accessorCall(editorGen, messageKey(i18nKeyForModelingAssistantProvider(it)))»);
			dialog.setTitle(«xptExternalizer.accessorCall(editorGen, titleKey(i18nKeyForModelingAssistantProvider(it)))»);
			dialog.setMultipleSelection(false);
			dialog.setElements(elements);
			org.eclipse.emf.ecore.EObject selected = null;
			if (dialog.open() == org.eclipse.jface.window.Window.OK) {
				selected = (org.eclipse.emf.ecore.EObject) dialog.getFirstResult();
			}
			return selected;
		}
	'''

	def additions(GenDiagram it) ''''''

	def newArrayListOfElementTypes(String varName) '''
		java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType> «varName» = new java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>
	'''

	@Localization protected def String i18nKeyForModelingAssistantProvider(GenDiagram it) {
		return diagram.modelingAssistantProviderClassName
	}

	@Localization def i18nValues(GenDiagram it) '''
		«xptExternalizer.messageEntry(titleKey(i18nKeyForModelingAssistantProvider(it)), 'Select domain model element')»
		«xptExternalizer.messageEntry(messageKey(i18nKeyForModelingAssistantProvider(it)), 'Available domain model elements:')»
	'''

	@Localization def i18nAccessors(GenDiagram it) '''
		«xptExternalizer.accessorField(titleKey(i18nKeyForModelingAssistantProvider(it)))»
		«xptExternalizer.accessorField(messageKey(i18nKeyForModelingAssistantProvider(it)))»
	'''

}
