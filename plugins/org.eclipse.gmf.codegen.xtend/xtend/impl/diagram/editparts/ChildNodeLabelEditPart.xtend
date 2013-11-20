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
package impl.diagram.editparts

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import xpt.Common
import xpt.QualifiedClassNameProvider
import xpt.diagram.editpolicies.TextNonResizableEditPolicy

/**
 * Revisit: [MG]: @Inject extension same-named-api-class -> template extends api-class?
 */
class ChildNodeLabelEditPart {
	@Inject extension Common;
	@Inject extension QualifiedClassNameProvider

	@Inject xpt.diagram.editparts.Common xptEditpartsCommon;
	@Inject TextNonResizableEditPolicy xptTextNonResizable;

	def className(GenChildLabelNode it) '''«editPartClassName»'''

	def packageName(GenChildLabelNode it) '''«getDiagram().editPartsPackageName»'''

	def constructor(GenChildLabelNode it) '''
		«generatedMemberComment»
		public «className(it)»(org.eclipse.gmf.runtime.notation.View view) {
			super(view);
		}
	'''

	def getDragTrackerBody(GenChildLabelNode it) '''
		if (request instanceof org.eclipse.gef.requests.SelectionRequest && ((org.eclipse.gef.requests.SelectionRequest) request).getLastButtonPressed() == 3) {
			return null;
		}
		return new org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx(this);
	'''

	def createDefaultEditPoliciesBody(GenChildLabelNode it) '''
		super.createDefaultEditPolicies();
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE, new «getItemSemanticEditPolicyQualifiedClassName(it)»());
		installEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE, new «xptTextNonResizable.qualifiedClassName(getDiagram())»());
		installEditPolicy(org.eclipse.gef.EditPolicy.COMPONENT_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy());
		installEditPolicy(org.eclipse.gef.EditPolicy.DIRECT_EDIT_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy());
		«xptEditpartsCommon.behaviour(it)»
	'''

	def handleNotificationEventBody(GenChildLabelNode it) '''
		Object feature = event.getFeature();
		«xptEditpartsCommon.handleText(it)»
		super.handleNotificationEvent(event);
	'''

}
