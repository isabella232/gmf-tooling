/**
 * Copyright (c) 2007, 2009, 2012 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - API extracted to gmf.tooling.runtime (#372479)  	  
 *                               - #386838 - migrate to Xtend2
 */
package xpt.diagram.updater

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagramUpdater
import xpt.Common

class NodeDescriptor {
	@Inject extension Common;

	def className(GenDiagramUpdater it) '''«nodeDescriptorClassName»'''
	
	def packageName(GenDiagramUpdater it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagramUpdater it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagramUpdater it) '''«qualifiedClassName(it)»'''

	def NodeDescriptor(GenDiagramUpdater it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» {
			«constructor(it)»
		
			«additions(it)»
		}
	'''

	def extendsList(GenDiagramUpdater it) '''extends org.eclipse.gmf.tooling.runtime.update.UpdaterNodeDescriptor'''

	def constructor(GenDiagramUpdater it) '''
		«generatedMemberComment»
		public «className(it)»(org.eclipse.emf.ecore.EObject modelElement, int visualID) {
			super(modelElement, visualID);
		}
	'''

	def additions(GenDiagramUpdater it) ''''''
}
