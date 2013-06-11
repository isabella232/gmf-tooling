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
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.diagram.editparts

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.ViewmapLayoutType
import xpt.Common
import xpt.diagram.editparts.Utils_qvto

class DiagramEditPart {
	@Inject extension Common;
	@Inject extension Utils_qvto;

	@Inject xpt.diagram.editparts.Common xptEditpartsCommon;

	def constructor(GenDiagram it) '''
		«generatedMemberComment»
		public «editPartClassName»(org.eclipse.gmf.runtime.notation.View view) {
			super(view);
		}
	'''

	def createDefaultEditPoliciesBody(GenDiagram it) '''
	super.createDefaultEditPolicies();
	«xptEditpartsCommon.installSemanticEditPolicy(it)»
	«xptEditpartsCommon.installCanonicalEditPolicy(it)»
	«xptEditpartsCommon.installCreationEditPolicy(it)»
	«IF generateCreateShortcutAction() && null == editorGen.application»
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.DRAG_DROP_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy() {
			public org.eclipse.gef.commands.Command getDropObjectsCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest dropRequest) {
				java.util.ArrayList<org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor> viewDescriptors = new java.util.ArrayList<org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor>();
				for (java.util.Iterator<?> it = dropRequest.getObjects().iterator(); it.hasNext();) {
					Object nextObject = it.next();
					if (false == nextObject instanceof org.eclipse.emf.ecore.EObject) {
						continue;
					}
					viewDescriptors.add(new org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor(new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter((org.eclipse.emf.ecore.EObject) nextObject), org.eclipse.gmf.runtime.notation.Node.class, null, getDiagramPreferencesHint()));
				}
				return createShortcutsCommand(dropRequest, viewDescriptors);
			}

			private org.eclipse.gef.commands.Command createShortcutsCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest dropRequest, java.util.List<org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor> viewDescriptors) {
				org.eclipse.gef.commands.Command command = createViewsAndArrangeCommand(dropRequest, viewDescriptors);
				if (command != null) {
					return command.chain(new org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy(new «getCreateShortcutDecorationsCommandQualifiedClassName()»(getEditingDomain(), (org.eclipse.gmf.runtime.notation.View) getModel(), viewDescriptors)));
				}
				return null;
			}
		});
	«ENDIF»
	«IF shouldGenerateDiagramViewmap(it)»
		// diagram figure does layout; need to install child editpolicy to show selection feedback
		installEditPolicy(org.eclipse.gef.EditPolicy.LAYOUT_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {
			protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {
				final org.eclipse.gef.editpolicies.NonResizableEditPolicy p = new org.eclipse.gef.editpolicies.NonResizableEditPolicy();
				p.setDragAllowed(false);
				return p;
			}
			protected org.eclipse.gef.commands.Command getMoveChildrenCommand(org.eclipse.gef.Request request) {
				return null;
			}
			protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gef.requests.CreateRequest request) {
				return null;
			}
		});
	«ENDIF»
	«xptEditpartsCommon.behaviour(it)»
	// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
'''

	def createFigure(GenDiagram it) '''
		«IF shouldGenerateDiagramViewmap(it)»
			«generatedMemberComment»
			protected org.eclipse.draw2d.IFigure createFigure() {
				org.eclipse.draw2d.FreeformLayer l = new org.eclipse.draw2d.FreeformLayer();
				l.setBorder(new org.eclipse.draw2d.MarginBorder(50));
				«initLayout(viewmap.layoutType, 'lm')»
				l.setLayoutManager(lm);
				return l;
			}
		«ENDIF»
	'''

	def initLayout(ViewmapLayoutType it, String varName) '''
		«IF it == ViewmapLayoutType::TOOLBAR_LAYOUT_LITERAL»
			org.eclipse.draw2d.ToolbarLayout «varName» = new org.eclipse.draw2d.ToolbarLayout();
			«varName».setSpacing(10);
		«ELSEIF it == ViewmapLayoutType::FLOW_LAYOUT_LITERAL»
			org.eclipse.draw2d.FlowLayout «varName» = new org.eclipse.draw2d.FlowLayout();
			«varName».setMajorSpacing(10);
			«varName».setMinorSpacing(10);
		«ELSE»
			org.eclipse.draw2d.LayoutManager «varName» = null; /*FIXME - unknown layout type*/
		«ENDIF»
	'''
}
