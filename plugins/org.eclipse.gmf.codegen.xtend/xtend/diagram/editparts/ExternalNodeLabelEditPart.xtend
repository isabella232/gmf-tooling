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
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package diagram.editparts

import com.google.inject.Inject
import impl.diagram.editparts.TextAware
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import xpt.Common

class ExternalNodeLabelEditPart {
	@Inject extension Common;

	@Inject xpt.diagram.editparts.Common xptEditpartsCommon;
	@Inject impl.diagram.editparts.ExternalNodeLabelEditPart xptExternalNodeLabelEditPart;
	@Inject TextAware xptTextAware

	def className(GenExternalNodeLabel it) '''«editPartClassName»'''

	def packageName(GenExternalNodeLabel it) '''«getDiagram().editPartsPackageName»'''

	def qualifiedClassName(GenExternalNodeLabel it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenExternalNodeLabel it) '''«qualifiedClassName(it)»'''

	def Main(GenExternalNodeLabel it) '''
«copyright(getDiagram().editorGen)»
package «packageName(it)»;

«generatedClassComment»
public class «className(it)» «extendsList(it)» «implementsList(it)» {

	«attributes(it)»
	
	«xptExternalNodeLabelEditPart.initializer(it)»
	
	«xptExternalNodeLabelEditPart.constructor(it)»
	
	«createDefaultEditPolicies(it)»
	
	«xptExternalNodeLabelEditPart.getBorderItemLocator(it)»
	
	«xptExternalNodeLabelEditPart.refreshBounds(it)»
	
	«xptTextAware.methods(it, false, readOnly, elementIcon, viewmap, modelFacet, node, getDiagram())»
	
	«handleNotificationEvent(it)»
	
	«xptExternalNodeLabelEditPart.createFigure(it)»
	
	«additions(it)»
}
'''

	def extendsList(GenExternalNodeLabel it) '''extends org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart'''

	def implementsList(GenExternalNodeLabel it) '''implements org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart, org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart'''

	def attributes(GenExternalNodeLabel it) '''
		«xptEditpartsCommon.visualIDConstant(it)»
		
		«xptTextAware.fields(it)»
	'''

	def createDefaultEditPolicies(GenExternalNodeLabel it) '''
		«generatedMemberComment»
		protected void createDefaultEditPolicies() {
			«xptExternalNodeLabelEditPart.createDefaultEditPoliciesBody(it)»
		}
	'''

	def handleNotificationEvent(GenExternalNodeLabel it) '''
		«generatedMemberComment»
		protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification event) {
			«xptExternalNodeLabelEditPart.handleNotificationEventBody(it)»
		}
	'''

	def additions(GenExternalNodeLabel it) ''''''
}
