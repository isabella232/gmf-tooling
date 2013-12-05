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
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.ViewmapLayoutType
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import xpt.Common
import xpt.Common_qvto
import xpt.Externalizer
import xpt.diagram.editparts.Utils_qvto
import xpt.providers.ElementTypes

@com.google.inject.Singleton class CompartmentEditPart {
	@Inject extension Common;
	@Inject extension Common_qvto;

	@Inject extension Utils_qvto;

	@Inject Externalizer xptExternalizer;
	@Inject xpt.diagram.editparts.Common xptEditpartsCommon;
	@Inject ElementTypes xptElementTypes;

	def className(GenCompartment it) '''«editPartClassName»'''

	def packageName(GenCompartment it) '''«getDiagram().editPartsPackageName»'''

	def constructor(GenCompartment it) '''
		«generatedMemberComment»
		public «className(it)»(org.eclipse.gmf.runtime.notation.View view) {
			super(view);
		}
	'''

	def hasModelChildrenChanged(GenCompartment it) '''
		«IF listLayout»
			«generatedMemberComment»
			protected boolean hasModelChildrenChanged(org.eclipse.emf.common.notify.Notification evt) {
				return false;
			}
		«ENDIF»
	'''

	def getCompartmentName(GenCompartment it) '''
		«generatedMemberComment»
		public String getCompartmentName() {
			return «xptExternalizer.accessorCall(diagram.editorGen, i18nKeyForCompartmentTitle(it))»;
		}
	'''

	def createFigure(GenCompartment it) '''
		«IF !needsTitle»
			«/*By default titles are shown even if there are no TitleStyle, we need to switch it off*/generatedMemberComment»
			public org.eclipse.draw2d.IFigure createFigure() {
				org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure result = (org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure) super.createFigure();
				result.setTitleVisibility(false);
				return result;
			}
		«ENDIF»
	'''

	def createDefaultEditPoliciesBody(GenCompartment it) '''
		super.createDefaultEditPolicies();
		«IF canCollapse»
			installEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy());
		«ENDIF»
		«xptEditpartsCommon.installSemanticEditPolicy(it)»
		«IF childNodes.notEmpty»
			«xptEditpartsCommon.installCreationEditPolicy(it)»
			installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.DRAG_DROP_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy());
		«ENDIF»
		«xptEditpartsCommon.installCanonicalEditPolicy(it)»
		«xptEditpartsCommon.behaviour(it)»
	'''

	def refreshVisuals(GenCompartment it) '''
		«IF isStoringChildPositions(node)»
			«generatedMemberComment»
			protected void refreshVisuals() {
				super.refreshVisuals();
				refreshBounds();
			}
		«ENDIF»
	'''

	def handleNotificationEventBody(GenCompartment it) '''
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();
		if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Width().equals(feature)
				|| org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Height().equals(feature)
				|| org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_X().equals(feature)
				|| org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_Y().equals(feature)) {
			refreshBounds();
		} 
	'''

	def refreshBounds(GenCompartment it) '''
		«IF isStoringChildPositions(node)»
			«generatedMemberComment»
			protected void refreshBounds() {
				int x = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_X())).intValue();
				int y = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_Y())).intValue();
				int width = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Width())).intValue();
				int height = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Height())).intValue();
				((org.eclipse.gef.GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), new org.eclipse.draw2d.geometry.Rectangle(x, y, width, height));
			}
		«ENDIF»
	'''

	def setRatio(GenCompartment it) '''
		«generatedMemberComment»
		protected void setRatio(Double ratio) {
			«IF ViewmapLayoutType::UNKNOWN_LITERAL == node.layoutType»
				if (getFigure().getParent().getLayoutManager() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout) {
					super.setRatio(ratio);
				}
			«ELSE»
				// nothing to do -- parent layout does not accept Double constraints as ratio
				// super.setRatio(ratio); 
			«ENDIF»
		}
	'''

	def getTargetEditPartMethod(GenCompartment it) '''
		«generatedMemberComment»
		public org.eclipse.gef.EditPart getTargetEditPart(org.eclipse.gef.Request request) {
			«IF childNodes.notEmpty»
			if (request instanceof org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest) {
				org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter adapter = ((org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
				org.eclipse.gmf.runtime.emf.type.core.IElementType type = (org.eclipse.gmf.runtime.emf.type.core.IElementType) adapter.getAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType.class);
				«FOR childNode : it.childNodes»
					if (type == «xptElementTypes.accessElementType(childNode)») {
						return this;
					}
				«ENDFOR»
				return getParent().getTargetEditPart(request);
			}
			«ENDIF»
			return super.getTargetEditPart(request);
		}
	'''

	@Localization def i18nAccessors(GenDiagram it) '''
	«FOR compartment : it.compartments»
		«internal_i18nAccessors(compartment)»
	«ENDFOR»
	'''

	@Localization def internal_i18nAccessors(GenCompartment it) //
	'''«IF null != title»«xptExternalizer.accessorField(i18nKeyForCompartmentTitle(it))»«ENDIF»'''

	@Localization def i18nValues(GenDiagram it) '''
		«FOR compartment : it.compartments»
			«internal_i18nValues(compartment)»
		«ENDFOR»
	'''

	@Localization def internal_i18nValues(GenCompartment it) '''
		«IF null != title»«xptExternalizer.messageEntry(i18nKeyForCompartmentTitle(it), title)»«ENDIF»
	'''

	@Localization def String i18nKeyForCompartmentTitle(GenCompartment compartment) {
		return className(compartment) + '.title'
	}
	

}
