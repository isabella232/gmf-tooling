/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.diagram.commands

import com.google.inject.Inject
import metamodel.MetaModel
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import xpt.Common
import xpt.diagram.Utils_qvto
import xpt.providers.ElementInitializers
import xpt.OclMigrationProblems_qvto

@com.google.inject.Singleton class CreateNodeCommand {
	@Inject extension Common;
	@Inject extension Utils_qvto;
	@Inject extension OclMigrationProblems_qvto;

	@Inject MetaModel xptMetaModel;
	@Inject ElementInitializers xptElementInitializers;

	def className(GenNode it) '''«it.createCommandClassName»'''

	def packageName(GenNode it) '''«it.getDiagram().editCommandsPackageName»'''

	def qualifiedClassName(GenNode it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenNode it) '''«qualifiedClassName(it)»'''

	def CreateNodeCommand(GenNode it) '''
		«copyright(it.diagram.editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment(it)»
		public class «className(it)» extends org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand {
		
			«_constructor(it)»
		
			«getElementToEdit(it)»
		
			«canExecuteMethod(it)»
		
			«doExecuteWithResultMethod(it)»
		
			«doConfigureMethod(it)»
			
			«additions(it)»	
		}
	'''

	def _constructor(GenNode it) '''
		«generatedMemberComment(it)»
		public «className(it)»(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {
			super(req.getLabel(), null, req);
		}
	'''

	/**
	 * TODO: either use setElementToEdit, or generate downcasted version (which may be troublesome if containment and child features point to a different parent) 
	 */
	def getElementToEdit(GenNode it) '''
			«generatedMemberComment(it, 'FIXME: replace with setElementToEdit()')»
		protected org.eclipse.emf.ecore.EObject getElementToEdit() {
			org.eclipse.emf.ecore.EObject container = ((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getContainer();
			if (container instanceof org.eclipse.gmf.runtime.notation.View) {
				container = ((org.eclipse.gmf.runtime.notation.View) container).getElement();
			}
			return container;
		}
	'''

	def doExecuteWithResultMethod(GenNode it) '''
		«generatedMemberComment(it)»
		protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info) throws org.eclipse.core.commands.ExecutionException {
		«IF it.modelFacet.isPhantomElement()»
			«phantomElementCreation(it.modelFacet, it, 'newElement')»
		«ELSE»
			«normalElementCreation(it.modelFacet, it, 'newElement')»
		«ENDIF»
		«extraLineBreak»
		«initialize(it.modelFacet, it, 'newElement')»
		«IF true/*FIXME boolean needsExternalConfiguration*/»
			«extraLineBreak»
			doConfigure(newElement, monitor, info);
			«extraLineBreak»
		«ENDIF»
			((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).setNewElement(«xptMetaModel.
			DowncastToEObject(it.modelFacet.metaClass, 'newElement')»);
			return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult(newElement);
		}
	'''

	/**
	 * Unlike original CreateElementCommand, we don't keep track of IStatus from configureCommand.execute,
	 * nor allow status setting from doDefaultCreation. The reason is ICommandProxy#execute implementation,
	 * which ignores any status from wrapped ICommand. Besides, both CommandResult and IStatus seems too much to me.
	 */
	def doConfigureMethod(GenNode it) '''
		«generatedMemberComment(it)»
		protected void doConfigure(«xptMetaModel.QualifiedClassName(it.modelFacet.metaClass)» newElement, org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info) throws org.eclipse.core.commands.ExecutionException {
			org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = ((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getElementType();
			org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest configureRequest = new org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest(getEditingDomain(), «xptMetaModel.
			DowncastToEObject(it.modelFacet.metaClass, 'newElement')», elementType);
			configureRequest.setClientContext(((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getClientContext());
			configureRequest.addParameters(getRequest().getParameters());
			org.eclipse.gmf.runtime.common.core.command.ICommand configureCommand = elementType.getEditCommand(configureRequest);
			if (configureCommand != null && configureCommand.canExecute()) {
				configureCommand.execute(monitor, info);
			}
		}
	'''

	def canExecuteMethod(GenNode it) '''
		«generatedMemberComment(it)»
		public boolean canExecute() {
		«IF modelFacet.isPhantomElement()»
			return true;
		«ELSE»
			«canExecute_Normal(it.modelFacet)»
			«extraLineBreak»
		«ENDIF»
		}
	'''

	def canExecute_Normal(TypeModelFacet it) '''
«IF !isUnbounded(it.containmentMetaFeature.ecoreFeature) ||
		(childMetaFeature != containmentMetaFeature && !isUnbounded(it.childMetaFeature.ecoreFeature))»
	«xptMetaModel.DeclareAndAssign(it.containmentMetaFeature.genClass, 'container', 'getElementToEdit()')»
	«IF !isUnbounded(it.containmentMetaFeature.ecoreFeature)»
		«IF isSingleValued(containmentMetaFeature.ecoreFeature)»
		if («xptMetaModel.getFeatureValue(containmentMetaFeature, 'container', containmentMetaFeature.genClass)» != null) {
		«ELSE»
		if («xptMetaModel.getFeatureValue(containmentMetaFeature, 'container', containmentMetaFeature.genClass)».size() >= «containmentMetaFeature.
		ecoreFeature.upperBound») {
		«ENDIF»
			return false;
		}
	«ENDIF»
	«IF childMetaFeature != containmentMetaFeature && !isUnbounded(childMetaFeature.ecoreFeature)»
		«IF isSingleValued(childMetaFeature.ecoreFeature)»
		if («xptMetaModel.getFeatureValue(childMetaFeature, 'container', containmentMetaFeature.genClass)» != null) {
		«ELSE»
		if («xptMetaModel.getFeatureValue(childMetaFeature, 'container', containmentMetaFeature.genClass)».size() >= «childMetaFeature.
		ecoreFeature.upperBound») {
		«ENDIF»
			return false;
		}
	«ENDIF»
«ENDIF»
	return true;
'''

	def phantomElementCreation(TypeModelFacet it, GenNode node, String varName) '''
		// Uncomment to put "phantom" objects into the diagram file.		
		// org.eclipse.emf.ecore.resource.Resource resource = 
		// 		((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getContainer().eResource();
		// if (resource == null) {
		// 	return null;
		// }
		org.eclipse.emf.ecore.resource.Resource resource = getElementToEdit().eResource();
		«xptMetaModel.NewInstance(it.metaClass, varName)»
		resource.getContents().add(«xptMetaModel.DowncastToEObject(it.metaClass, varName)»);
	'''

	def normalElementCreation(TypeModelFacet it, GenNode node, String varName) '''
		«xptMetaModel.NewInstance(it.metaClass, varName)»
		«extraLineBreak»
		«IF containmentMetaFeature != null»
			«xptMetaModel.DeclareAndAssign(it.containmentMetaFeature.genClass, 'owner', 'getElementToEdit()')»
			«xptMetaModel.modifyFeature(containmentMetaFeature, 'owner', containmentMetaFeature.genClass, varName)»
		«ELSE»
			//
			// FIXME no containment feature found in the genmodel, toolsmith need to manually write code here to add «varName» to a parent
			//
		«ENDIF»
		«IF hasExplicitChildFeature(it)»
			«xptMetaModel.DeclareAndAssign(it.childMetaFeature.genClass, 'childHolder', 'getElementToEdit()')»
			«xptMetaModel.modifyFeature(it.childMetaFeature, 'childHolder', childMetaFeature.genClass, varName)»
		«ENDIF»
	'''

	def initialize(TypeModelFacet it, GenNode node, String newElementVar) // 
		'''«xptElementInitializers.initMethodCall(node, it, newElementVar)»'''

	def additions(GenNode it) ''''''

}
