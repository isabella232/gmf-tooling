/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.navigator

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import xpt.Common

@com.google.inject.Singleton class getEditorInput {
	@Inject extension Common;

	def getEditorInput(GenEditorGenerator it) '''
		«generatedMemberComment»
		private static org.eclipse.ui.IEditorInput getEditorInput(org.eclipse.gmf.runtime.notation.Diagram diagram) {
			org.eclipse.emf.ecore.resource.Resource diagramResource = diagram.eResource();
		«IF null == it.application»
			for (org.eclipse.emf.ecore.EObject nextEObject : diagramResource.getContents()) {
				if (nextEObject == diagram) {
					return new org.eclipse.ui.part.FileEditorInput(org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(diagramResource));
				}
				if (nextEObject instanceof org.eclipse.gmf.runtime.notation.Diagram) {
					break;
				}
			}
		«ENDIF»
			«defineURIEditorInput(diagram, 'diagram', 'editorInput')»
			return editorInput;
		}
	'''

	def defineURIEditorInput(GenDiagram it, String diagramVarName, String editorInputVarName) '''
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.ecore.util.EcoreUtil.getURI(«diagramVarName»);
		String editorName = uri.lastSegment() + '#' + «diagramVarName».eResource().getContents().indexOf(«diagramVarName»);
		org.eclipse.ui.IEditorInput «editorInputVarName» = new org.eclipse.emf.common.ui.URIEditorInput(uri, editorName);
	'''
}
