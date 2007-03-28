/*
 *  Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.TaiPanCreateShortcutDecorationsCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.wizard.Wizard;

/**
 * Allows to select foreign model element and add shortcut to the diagram.
 * 
 * @generated
 */
public class ShortcutCreationWizard extends Wizard {

	/**
	 * @generated
	 */
	private ReferencedElementSelectionPage referencedElementSelectionPage;

	/**
	 * @generated
	 */
	private TransactionalEditingDomain editingDomain;

	/**
	 * @generated
	 */
	public ShortcutCreationWizard(EObject modelElement, View view, TransactionalEditingDomain editingDomain) {
		referencedElementSelectionPage = new ReferencedElementSelectionPage("Select referenced element", view);
		referencedElementSelectionPage.setTitle("Referenced element");
		referencedElementSelectionPage.setDescription("Select element that the new shortcut will refer to.");
		referencedElementSelectionPage.setModelElement(modelElement);

		this.editingDomain = editingDomain;
	}

	/**
	 * @generated
	 */
	public void addPages() {
		addPage(referencedElementSelectionPage);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		CreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(new EObjectAdapter(referencedElementSelectionPage.getModelElement()), Node.class, null,
				TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		ICommand command = new CreateCommand(editingDomain, viewDescriptor, referencedElementSelectionPage.getView());
		command = command.compose(new TaiPanCreateShortcutDecorationsCommand(editingDomain, referencedElementSelectionPage.getView(), viewDescriptor));
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException ee) {
			TaiPanDiagramEditorPlugin.getInstance().logError("Unable to create shortcut", ee); //$NON-NLS-1$
		}
		return true;
	}

	/**
	 * @generated
	 */
	private static class ReferencedElementSelectionPage extends ModelElementSelectionPage {

		/**
		 * @generated
		 */
		private View view;

		/**
		 * @generated
		 */
		public ReferencedElementSelectionPage(String pageName, View view) {
			super(pageName);
			this.view = view;
		}

		/**
		 * @generated
		 */
		public View getView() {
			return view;
		}

		/**
		 * @generated
		 */
		protected String getSelectionTitle() {
			return "Select referenced element:";
		}

		/**
		 * @generated
		 */
		protected boolean validatePage() {
			if (selectedModelElement == null) {
				setErrorMessage("Referenced element is not selected");
				return false;
			}
			boolean result = ViewService.getInstance().provides(Node.class, new EObjectAdapter(selectedModelElement), view, null, ViewUtil.APPEND, true,
					TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			setErrorMessage(result ? null : "Invalid referenced element is selected");
			return result;
		}
	}
}
