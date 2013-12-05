/**
 * Copyright (c) 2006, 2009 Borland Software Corporation
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
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import xpt.diagram.editparts.Common
import xpt.editor.VisualIDRegistry
import xpt.diagram.editpolicies.TextSelectionEditPolicy

@com.google.inject.Singleton class ExternalNodeLabelEditPart {
	@Inject extension xpt.Common;

	@Inject Common xptEditpartsCommon;
	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject TextSelectionEditPolicy textSelestion;

	def className(GenExternalNodeLabel it) '''«editPartClassName»'''

	def packageName(GenExternalNodeLabel it) '''«getDiagram().editPartsPackageName»'''

	def initializer(GenExternalNodeLabel it) '''
		«generatedMemberComment»
		static {
			registerSnapBackPosition(«xptVisualIDRegistry.typeMethodCall(it)», new org.eclipse.draw2d.geometry.Point(0, 0));
		}
	'''

	def constructor(GenExternalNodeLabel it) '''
		«generatedMemberComment»
		public «className(it)»(org.eclipse.gmf.runtime.notation.View view) {
			super(view);
		}
	'''

	def createDefaultEditPoliciesBody(GenExternalNodeLabel it) '''
		super.createDefaultEditPolicies();
		installEditPolicy(org.eclipse.gef.EditPolicy.DIRECT_EDIT_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy());
		installEditPolicy(org.eclipse.gef.EditPolicy.SELECTION_FEEDBACK_ROLE, new «textSelestion.qualifiedClassName(getDiagram())»());
		«xptEditpartsCommon.behaviour(it)»
	'''

	def getBorderItemLocator(GenExternalNodeLabel it) '''
		«generatedMemberComment»
		public org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator getBorderItemLocator() {
			org.eclipse.draw2d.IFigure parentFigure = getFigure().getParent();
			if (parentFigure != null && parentFigure.getLayoutManager() != null) {
				Object constraint = parentFigure.getLayoutManager().getConstraint(getFigure());
				return (org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator) constraint;
			}
			return null;
		}
	'''

	def refreshBounds(GenExternalNodeLabel it) '''
		«generatedMemberComment»
		public void refreshBounds() {
			int x = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_X())).intValue();
			int y = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_Y())).intValue();
			int width = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Width())).intValue();
			int height = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Height())).intValue();
			getBorderItemLocator().setConstraint(new org.eclipse.draw2d.geometry.Rectangle(x, y, width, height));
		}
	'''

	def handleNotificationEventBody(GenExternalNodeLabel it) '''
		Object feature = event.getFeature();
		«xptEditpartsCommon.handleText(it)»
		super.handleNotificationEvent(event);
	'''

	def createFigure(GenExternalNodeLabel it) '''
		«xptEditpartsCommon.labelFigure(viewmap)»
	'''
}
