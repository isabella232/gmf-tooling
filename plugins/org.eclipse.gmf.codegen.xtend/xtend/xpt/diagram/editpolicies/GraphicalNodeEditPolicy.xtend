/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
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
package xpt.diagram.editpolicies

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenNode
import xpt.Common
import xpt.providers.ElementTypes
import xpt.QualifiedClassNameProvider

class GraphicalNodeEditPolicy {
	@Inject extension Common;
	@Inject extension QualifiedClassNameProvider;
	
	@Inject ElementTypes xptElementTypes;

	def className(GenNode it) '''«it.graphicalNodeEditPolicyClassName»'''

	def packageName(GenNode it) '''«it.getDiagram().editPoliciesPackageName»'''

	def qualifiedClassName(GenNode it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenNode it) '''«qualifiedClassName(it)»'''

	def GraphicalNodeEditPolicy(GenNode it) '''
		«copyright(it.diagram.editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» «implementsList(it)» {
			
			«getConnectionCompleteCommand(it)»
			
			«getElementType(it)»
			
			«getConnectionWithReorientedViewCompleteCommand(it)»
		
			«additions(it)»
		}
	'''

	def extendsList(GenNode it) '''extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy'''

	def implementsList(GenNode it) ''''''

	def getConnectionCompleteCommand(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command getConnectionCompleteCommand(
				org.eclipse.gef.requests.CreateConnectionRequest request) {
			org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getElementType(request);
			«FOR link : reorientedIncomingLinks.sortBy(l|l.visualID)»
			if («xptElementTypes.accessElementType(link)» == elementType) {
				«IF link.outgoingCreationAllowed»
					if (request.getSourceEditPart() != getHost()) {
				«ENDIF»
				return getConnectionWithReorientedViewCompleteCommand(request);
				«IF link.outgoingCreationAllowed»
					}
				«ENDIF»
			}
			«ENDFOR»
			return super.getConnectionCompleteCommand(request);
		}
	'''

	def getElementType(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.emf.type.core.IElementType getElementType(
				org.eclipse.gef.requests.CreateConnectionRequest request) {
			if (request instanceof org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest) {
			org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter requestAdapter =
			((org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest) request)
					.getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
			return (org.eclipse.gmf.runtime.emf.type.core.IElementType) requestAdapter.getAdapter(
			org.eclipse.gmf.runtime.emf.type.core.IElementType.class);
			}
			return null;
		}
	'''

	def getConnectionWithReorientedViewCompleteCommand(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command getConnectionWithReorientedViewCompleteCommand(
				org.eclipse.gef.requests.CreateConnectionRequest request) {
			org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy c =
			(org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy) super.getConnectionCompleteCommand(request);
			org.eclipse.gmf.runtime.common.core.command.CompositeCommand cc =
			(org.eclipse.gmf.runtime.common.core.command.CompositeCommand) c.getICommand();
			org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain =
			((org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) getHost()).getEditingDomain();
			«getReorientConnectionViewCommandQualifiedClassName(getDiagram())» rcvCommand =
			new «getReorientConnectionViewCommandQualifiedClassName(getDiagram())»(editingDomain, null);
			rcvCommand.setEdgeAdaptor(getViewAdapter());
			cc.compose(rcvCommand);
			return c;
		}
	'''

	def additions(GenNode it) ''''''

}
