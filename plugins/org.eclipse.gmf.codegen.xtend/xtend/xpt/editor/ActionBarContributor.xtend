/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.editor

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorView
import xpt.Common
import xpt.Common_qvto
import xpt.GenEditorGenerator_qvto

class ActionBarContributor {
	@Inject extension Common;
	@Inject extension Common_qvto;

	@Inject extension GenEditorGenerator_qvto;

	@Inject ValidateAction xptValidateAction;

	def extendsList(GenEditorView it) '''extends org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor'''

	def ActionBarContributor(GenEditorView it) '''
		«copyright(editorGen)»
		package «packageName»;
		
		«generatedClassComment»
		public class «actionBarContributorClassName» «extendsList(it)» {
		
			«generatedMemberComment»
			protected Class getEditorClass() {
				return «getQualifiedClassName()».class;
			}
		
			«generatedMemberComment»
			protected String getEditorId() {
				return «getQualifiedClassName()».ID;
			}
			«initMethod(it)»
			«additions(it)»
		}
	'''

	def initMethod(GenEditorView it) '''
		«generatedMemberComment»
		public void init(org.eclipse.ui.IActionBars bars, org.eclipse.ui.IWorkbenchPage page) {
			super.init(bars, page);
			// print preview
			org.eclipse.jface.action.IMenuManager fileMenu = bars.getMenuManager().findMenuUsingPath(org.eclipse.ui.IWorkbenchActionConstants.M_FILE);
			«_assert('fileMenu != null')»
			«IF editorGen.plugin.printingEnabled»
				org.eclipse.jface.action.IAction printPreviewAction = new org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.RenderedPrintPreviewAction(new org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.EnhancedPrintActionHelper());
				fileMenu.insertBefore("print", printPreviewAction); «nonNLS(1)»
			«ELSE»
				fileMenu.remove("pageSetupAction"); «nonNLS(1)»
			«ENDIF»
			«IF editorGen.diagram.validationEnabled || hasAudits(editorGen) ||
			(editorGen.metrics != null && editorGen.metrics.metrics.notEmpty)»
				org.eclipse.jface.action.IMenuManager editMenu = bars.getMenuManager().findMenuUsingPath(org.eclipse.ui.IWorkbenchActionConstants.M_EDIT);
				«_assert('editMenu != null')»
				if (editMenu.find("validationGroup") == null) { «nonNLS(1)»
					editMenu.add(new org.eclipse.jface.action.GroupMarker("validationGroup")); «nonNLS(1)»
				}
				«IF editorGen.diagram.validationEnabled || hasAudits(editorGen)»
					org.eclipse.jface.action.IAction validateAction = new «xptValidateAction.qualifiedClassName(editorGen.diagram)»(page);
					editMenu.appendToGroup("validationGroup", validateAction); «nonNLS(1)»
				«ENDIF»
				«IF editorGen.metrics != null && editorGen.metrics.metrics.notEmpty»
					org.eclipse.jface.action.IAction metricsAction = new «editorGen.diagram.getMetricProviderQualifiedClassName()».MetricsAction(page);
					editMenu.appendToGroup("validationGroup", metricsAction); «nonNLS(1)»
				«ENDIF»
			«ENDIF/*hasAudits || hasMetrics */»
		}
	'''

	def additions(GenEditorView it) ''''''

}
