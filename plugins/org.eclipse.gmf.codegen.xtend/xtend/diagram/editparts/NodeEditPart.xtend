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

import xpt.Common
import com.google.inject.Inject
import xpt.diagram.editparts.Utils_qvto
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode

@com.google.inject.Singleton class NodeEditPart {
	@Inject extension Common;
	@Inject extension Utils_qvto;
	
	@Inject impl.diagram.editparts.NodeEditPart xptNodeEditPartImpl;
	@Inject xpt.diagram.editparts.Common xptCommon;
	
	def qualifiedClassName(GenNode it) '''«xptNodeEditPartImpl.packageName(it)».«xptNodeEditPartImpl.className(it)»'''
	
	def fullPath(GenNode it) '''«qualifiedClassName(it)»'''
	
	def Main(GenNode it) '''
	«copyright(diagram.editorGen)»
	package «xptNodeEditPartImpl.packageName(it)»;
	
	«generatedClassComment»
	public class «xptNodeEditPartImpl.className(it)» «extendsList(it)» «implementsList(it)» {
	
		«attributes(it)»
		
		«xptNodeEditPartImpl.constructor(it)»
		
		«createDefaultEditPolicies(it)»
		
		«xptNodeEditPartImpl.createLayoutEditPolicy(it)»
		
		«xptNodeEditPartImpl.createNodeShape(it.viewmap, it)»
		
	«IF hasFixedChildren(it)»
		«xptNodeEditPartImpl.addFixedChild(it)»
	
		«xptNodeEditPartImpl.removeFixedChild(it)»
	
		«xptNodeEditPartImpl.addChildVisual(it)»
	
		«xptNodeEditPartImpl.removeChildVisual(it)»
	
		«xptNodeEditPartImpl.getContentPaneFor(it)»
	«ENDIF»
	
		«xptNodeEditPartImpl.addBorderItem(it)»
		
		«xptNodeEditPartImpl.createNodePlate(it)»
		
		«xptNodeEditPartImpl.getPrimaryDragEditPolicy(it)»
		
		«xptNodeEditPartImpl.createFigure(it)»
		
		«xptNodeEditPartImpl.setupContentPane(it)»
		
		«xptNodeEditPartImpl.getContentPane(it)»
	
		«xptNodeEditPartImpl.setForegroundColor(it)»
	
		«xptNodeEditPartImpl.setBackgroundColor(it)»
	
		«xptNodeEditPartImpl.setLineWidth(it)»
	
		«xptNodeEditPartImpl.setLineStyle(it)»
	
		«xptNodeEditPartImpl.getPrimaryChildEditPart(it)»
	
	«IF hasChildrenInListCompartments(it)»
		«xptNodeEditPartImpl.getTargetEditPartMethod(it)»
	«ENDIF»
	
		«handleNotificationEvent(it)»
	
		«xptNodeEditPartImpl.innerClassDeclaration(viewmap)»
		
		«additions(it)»
	}
	'''

	def extendsList(GenNode it) '''extends «xptNodeEditPartImpl.extendsListContents(it)»'''

	def implementsList(GenNode it) ''''''

	def attributes(GenNode it) '''
		«xptCommon.visualIDConstant(it)»
	
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure contentPane;
	
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure primaryShape;
	'''

	def createDefaultEditPolicies(GenNode it) '''
		«generatedMemberComment»
		protected void createDefaultEditPolicies() {
			«xptNodeEditPartImpl.createDefaultEditPoliciesBody(it)»
		}
	'''

	def dispatch handleNotificationEvent(GenNode it) ''''''

	def dispatch handleNotificationEvent(GenTopLevelNode it) '''
		«/** This code is important for refreshing shortcut decoration
		on adding corresponding annotation to the View instance.*/»
		«IF diagram.generateShortcutIcon()»
			«generatedMemberComment»
			protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification event) {
				«xptNodeEditPartImpl.handleNotificationEventBody(it)»
			}
		«ENDIF»
	'''

	def additions(GenNode it) ''''''	
	
}