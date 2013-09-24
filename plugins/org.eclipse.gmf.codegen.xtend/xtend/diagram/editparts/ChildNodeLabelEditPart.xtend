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
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import xpt.Common
import xpt.Common_qvto
import xpt.diagram.editparts.Utils_qvto

class ChildNodeLabelEditPart {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;

	@Inject impl.diagram.editparts.ChildNodeLabelEditPart xptChildNodeLabelEditPart;
	@Inject impl.diagram.editparts.NodeEditPart xptNodeEditPart;
	@Inject xpt.diagram.editparts.Common xptEditpartsCommon;
	@Inject TextAware xptTextAware;

	def className(GenChildLabelNode it) '''«editPartClassName»'''

	def packageName(GenChildLabelNode it) '''«getDiagram().editPartsPackageName»'''

	def qualifiedClassName(GenChildLabelNode it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenChildLabelNode it) '''«qualifiedClassName(it)»'''

	def Main(GenChildLabelNode it) '''
«copyright(getDiagram().editorGen)»
package «packageName(it)»;

«generatedClassComment»
public class «className(it)» «extendsList(it)» «implementsList(it)» {
	
	«attributes(it)»
	
	«xptChildNodeLabelEditPart.constructor(it)»

	«getDragTracker(it)»
	
	«createDefaultEditPolicies(it)»

	«xptTextAware.methods(it, false, labelReadOnly, labelElementIcon, viewmap, labelModelFacet, it, getDiagram())»

	«xptEditpartsCommon.notationalListeners(it)»

«IF getAssistantOutgoingLinks(it).notEmpty»
	«xptNodeEditPart.getMARelTypesOnSource(it)»

	«xptNodeEditPart.getMARelTypesOnSourceAndTarget(it)»

	«xptNodeEditPart.getMATypesForTarget(it)»
«ENDIF»

«IF getAssistantIncomingLinks(it).notEmpty»
	«xptNodeEditPart.getMARelTypesOnTarget(it)»

	«xptNodeEditPart.getMATypesForSource(it)»
«ENDIF»

	«handleNotificationEvent(it)»

	«xptEditpartsCommon.labelFigure(it.viewmap)»
	
	«additions(it)»
}
'''

	def extendsList(GenChildLabelNode it) '''extends org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart'''

	def implementsList(GenChildLabelNode it) '''implements org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart'''

	def attributes(GenChildLabelNode it) '''
		«xptEditpartsCommon.visualIDConstant(it)»
		
		«xptTextAware.fields(it)»
	'''

	def getDragTracker(GenChildLabelNode it) '''
		«generatedMemberComment»
		public org.eclipse.gef.DragTracker getDragTracker(org.eclipse.gef.Request request) {
			«xptChildNodeLabelEditPart.getDragTrackerBody(it)»
		}
	'''

	def createDefaultEditPolicies(GenChildLabelNode it) '''
		«generatedMemberComment»
		protected void createDefaultEditPolicies() {
			«xptChildNodeLabelEditPart.createDefaultEditPoliciesBody(it)»
		}
	'''

	def handleNotificationEvent(GenChildLabelNode it) '''
		«generatedMemberComment»
		protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification event) {
			«xptChildNodeLabelEditPart.handleNotificationEventBody(it)»
		}
	'''

	def additions(GenChildLabelNode it) ''''''

}
