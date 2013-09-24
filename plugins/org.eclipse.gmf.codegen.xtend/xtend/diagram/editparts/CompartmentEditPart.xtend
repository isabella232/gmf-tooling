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
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import xpt.Common
import xpt.diagram.editparts.Utils_qvto

class CompartmentEditPart {
	@Inject extension Common;
	@Inject extension Utils_qvto;

	@Inject impl.diagram.editparts.CompartmentEditPart xptCompartmentEditPartImpl;
	@Inject xpt.diagram.editparts.Common xptEditpartsCommon;

	def className(GenCompartment it) '''«editPartClassName»'''

	def packageName(GenCompartment it) '''«getDiagram().editPartsPackageName»'''

	def qualifiedClassName(GenCompartment it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenCompartment it) '''«qualifiedClassName(it)»'''

	def Main(GenCompartment it) '''
«copyright(getDiagram().editorGen)»
package «packageName(it)»;

«generatedClassComment»
public class «className(it)» «extendsList(it)» «implementsList(it)» {

	«attributes(it)»
	
	«xptCompartmentEditPartImpl.constructor(it)»
	
	«xptCompartmentEditPartImpl.hasModelChildrenChanged(it)»
	
	«xptCompartmentEditPartImpl.getCompartmentName(it)»
	
	«xptCompartmentEditPartImpl.createFigure(it)»
	
	«createDefaultEditPolicies(it)»
	
	«xptCompartmentEditPartImpl.refreshVisuals(it)»
	
	«handleNotificationEvent(it)»
	
	«xptCompartmentEditPartImpl.refreshBounds(it)»
	
	«xptCompartmentEditPartImpl.setRatio(it)»
	
	«additions(it)»
}
'''

	def extendsList(GenCompartment it) '''
	extends «IF listLayout»org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart«ELSE»org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart«ENDIF»
	'''

	def implementsList(GenCompartment it) ''''''

	def attributes(GenCompartment it) '''
		«xptEditpartsCommon.visualIDConstant(it)»
	'''

	def createDefaultEditPolicies(GenCompartment it) '''
		«generatedMemberComment»
		protected void createDefaultEditPolicies() {
			«xptCompartmentEditPartImpl.createDefaultEditPoliciesBody(it)»
		}
	'''

	def handleNotificationEvent(GenCompartment it) '''
		«IF isStoringChildPositions(node)»
			«generatedMemberComment»
			protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification notification) {
				«xptCompartmentEditPartImpl.handleNotificationEventBody(it)»
			}
		«ENDIF»
	'''

	def additions(GenCompartment it) ''''''

}
