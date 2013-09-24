/**
 * Copyright (c) 2007-2013 Borland Software Corporation and others
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
package xpt.diagram.commands

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common

class CreateShortcutDecorationsCommand {
	@Inject extension Common;

	def className(GenDiagram it) '''«it.createShortcutDecorationsCommandClassName»'''

	def packageName(GenDiagram it) '''«editCommandsPackageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def CreateShortcutDecorationsCommand(GenDiagram it) '''
«copyright(it.editorGen)»
package «packageName(it)»;

«generatedClassComment(it)»
public class «className(it)»
		extends org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand {

	«generatedMemberComment(it)»
	private java.util.List myDescriptors;

	«generatedMemberComment(it)»
	public «className(it)»(
			org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain,
			org.eclipse.gmf.runtime.notation.View parentView,
			java.util.List viewDescriptors) {
		super(editingDomain, "Create Shortcuts", getWorkspaceFiles(parentView)); //$NON-NLS-1$
		myDescriptors = viewDescriptors;
	}

	«generatedMemberComment(it)»
	public «className(it)»(
			org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain,
			org.eclipse.gmf.runtime.notation.View parentView,
			org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor viewDescriptor) {
		this(editingDomain, parentView, java.util.Collections.singletonList(viewDescriptor));
	}

	«generatedMemberComment(it)»
	protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(
			org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info)
			throws org.eclipse.core.commands.ExecutionException {
		for (java.util.Iterator it = myDescriptors.iterator(); it.hasNext();) {
			org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor nextDescriptor =
					(org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor) it.next();
			org.eclipse.gmf.runtime.notation.View view =
					(org.eclipse.gmf.runtime.notation.View) nextDescriptor.getAdapter(
							org.eclipse.gmf.runtime.notation.View.class);
			if (view != null && view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				«addShortcutAnnotation(it, 'view')»
			}
		}
		return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult();
	}
	
	«additions(it)»
}
'''

	def additions(GenDiagram diagram) ''''''

}
