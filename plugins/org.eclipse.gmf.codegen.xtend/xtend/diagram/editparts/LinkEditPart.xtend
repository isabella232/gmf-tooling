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
import org.eclipse.gmf.codegen.gmfgen.GenLink
import xpt.Common

@com.google.inject.Singleton class LinkEditPart {
	@Inject extension Common;

	@Inject impl.diagram.editparts.LinkEditPart xptLinkEditPart;
	@Inject xpt.diagram.editparts.Common xptEditpartsCommon;

	def qualifiedClassName(GenLink it) '''«xptLinkEditPart.packageName(it)».«xptLinkEditPart.className(it)»'''

	def fullPath(GenLink it) '''«qualifiedClassName(it)»'''

	def Main(GenLink it) '''
	«copyright(getDiagram().editorGen)»
		package «xptLinkEditPart.packageName(it)»;
		
		«generatedClassComment»
		public class «xptLinkEditPart.className(it)» «extendsList(it)» «implementsList(it)» {
		
			«attributes(it)»
			
			«xptLinkEditPart.constructor(it)»
			
			«createDefaultEditPolicies(it)»
		
			«xptLinkEditPart.addFixedChild(it)»
		
			«xptLinkEditPart.addChildVisual(it)»
		
			«xptLinkEditPart.removeFixedChild(it)»
		
			«xptLinkEditPart.removeChildVisual(it)»
			
			«xptLinkEditPart.createLinkFigure(it)»
			
			«additions(it)»
		}
	'''

	def extendsList(GenLink it) '''extends org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart'''

	def implementsList(GenLink it) '''
		«IF treeBranch»implements org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart«ENDIF»
	'''

	def attributes(GenLink it) '''
		«xptEditpartsCommon.visualIDConstant(it)»
	'''

	def createDefaultEditPolicies(GenLink it) '''
		«generatedMemberComment»
		protected void createDefaultEditPolicies() {
			«xptLinkEditPart.createDefaultEditPoliciesBody(it)»
		}
	'''

	def additions(GenLink it) ''''''
}
