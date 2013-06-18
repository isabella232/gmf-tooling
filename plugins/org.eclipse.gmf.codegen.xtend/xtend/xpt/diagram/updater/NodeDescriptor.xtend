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

	def NodeDescriptor(GenDiagramUpdater it) '''
		«copyright(editorGen)»
		package «editorGen.editor.packageName»;
		
		«generatedClassComment»
		public class «nodeDescriptorClassName» «extendsList(it)» {
			«constructor(it)»
		
			«additions(it)»
		}
	'''

	def extendsList(GenDiagramUpdater it) '''extends org.eclipse.gmf.tooling.runtime.update.UpdaterNodeDescriptor'''

	def constructor(GenDiagramUpdater it) '''
		«generatedMemberComment»
		public «nodeDescriptorClassName»(org.eclipse.emf.ecore.EObject modelElement, int visualID) {
			super(modelElement, visualID);
		}
	'''

	def additions(GenDiagramUpdater it) ''''''
}
