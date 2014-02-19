/**
 * Copyright (c) 2006, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.diagram.editpolicies

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common

@com.google.inject.Singleton class DiagramItemSemanticEditPolicy {
	@Inject extension Common;
	
	@Inject childContainerCreateCommand xptChildContainerCreateCommand;
	@Inject BaseItemSemanticEditPolicy xptBaseItemSemanticEditPolicy;
	
	def className(GenDiagram it) '''«it.itemSemanticEditPolicyClassName»'''

	def packageName(GenDiagram it) '''«it.editPoliciesPackageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''
	
	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''
	
	def DiagramItemSemanticEditPolicy(GenDiagram it) '''
		«copyright(getDiagram().editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment()»
		public class «className(it)» extends «xptBaseItemSemanticEditPolicy.qualifiedClassName(it)» {
		
			«xptBaseItemSemanticEditPolicy.defaultConstructor(it)»
		
			«xptChildContainerCreateCommand.childContainerCreateCommand(it.topLevelNodes)»
			
			«getDuplicateCommand(it)»
			
			«DuplicateAnythingCommand(it)»
			
			«additions(it)»
		}
	'''

	def getDuplicateCommand(GenDiagram it) '''
		«generatedMemberComment()»
		protected org.eclipse.gef.commands.Command getDuplicateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest req) {
			org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = ((org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) getHost()).getEditingDomain();
			return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
		}
	'''
	
	def DuplicateAnythingCommand(GenDiagram it) '''
		«generatedClassComment()»
		private static class DuplicateAnythingCommand extends org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand {
		
			«DAC_constructor(it)»
		
			«DAC_additions(it)»
		}
	'''

	def DAC_constructor(GenDiagram it) '''
		«generatedMemberComment()»
		public DuplicateAnythingCommand(org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain, org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}
	'''
	
	def DAC_additions(GenDiagram it) ''''''
	
	def additions(GenDiagram it) ''''''	
	
}