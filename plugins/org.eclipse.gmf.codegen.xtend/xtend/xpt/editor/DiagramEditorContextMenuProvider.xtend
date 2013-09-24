/**
 * Copyright (c) 2008, 2009, 2013 Borland Software Corporation and others
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
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef
import xpt.Common
import xpt.QualifiedClassNameProvider

class DiagramEditorContextMenuProvider {
	@Inject extension Common;
	@Inject extension QualifiedClassNameProvider;

	@Inject DeleteElementAction xptDeleteElementAction;

	@MetaDef def className(GenDiagram it) '''DiagramEditorContextMenuProvider'''

	def packageName(GenDiagram it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def DiagramEditorContextMenuProvider(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» extends org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider {
		
			«generatedMemberComment»
			private org.eclipse.ui.IWorkbenchPart part;
		
			«generatedMemberComment»
			private «xptDeleteElementAction.qualifiedClassName(it)» deleteAction;
		
			«generatedMemberComment»
			public DiagramEditorContextMenuProvider(org.eclipse.ui.IWorkbenchPart part, org.eclipse.gef.EditPartViewer viewer) {
				super(part, viewer);
				this.part = part;
				deleteAction = new «xptDeleteElementAction.qualifiedClassName(it)»(part);
				deleteAction.init();
			}
		
			«generatedMemberComment»
			public void dispose() {
				if (deleteAction != null) {
					deleteAction.dispose();
					deleteAction = null;
				}
				super.dispose();
			}
		
			«generatedMemberComment»
			public void buildContextMenu(final org.eclipse.jface.action.IMenuManager menu) {
				getViewer().flush();
				try {
					org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(
							(org.eclipse.emf.ecore.EObject) getViewer().getContents().getModel()).runExclusive(new Runnable() {
		
						public void run() {
							org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService.getInstance().contributeToPopupMenu(
									DiagramEditorContextMenuProvider.this, part);
							menu.remove(org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.ACTION_DELETE_FROM_MODEL);
							menu.appendToGroup("editGroup", deleteAction);
						}
					});
				} catch (Exception e) {
			«getActivatorQualifiedClassName(editorGen.plugin)».getInstance().logError("Error building context menu", e);
			}
			}
			«additions(it)»
		}
	'''

	def additions(GenDiagram it) ''''''

}
