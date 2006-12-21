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
package org.eclipse.gmf.examples.taipan.gmf.editor.application;

import java.io.File;
import java.util.Iterator;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanCreationWizard;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * @generated
 */
public class DiagramEditorActionBarAdvisor extends ActionBarAdvisor {

	/**
	 * @generated
	 */
	public DiagramEditorActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	/**
	 * @generated
	 */
	protected void makeActions(IWorkbenchWindow window) {

		register(ActionFactory.CLOSE.create(window));

		register(ActionFactory.CLOSE_ALL.create(window));

		register(ActionFactory.SAVE.create(window));

		register(ActionFactory.SAVE_AS.create(window));

		register(ActionFactory.SAVE_ALL.create(window));

		register(ActionFactory.QUIT.create(window));

		register(ActionFactory.UNDO.create(window));

		register(ActionFactory.REDO.create(window));

		register(ActionFactory.CUT.create(window));

		register(ActionFactory.COPY.create(window));

		register(ActionFactory.PASTE.create(window));

		register(ActionFactory.DELETE.create(window));

		register(ActionFactory.SELECT_ALL.create(window));

		register(ActionFactory.OPEN_NEW_WINDOW.create(window));
	}

	/**
	 * @generated
	 */
	protected void fillMenuBar(IMenuManager menu) {

		{
			IMenuManager menuX = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);

			menuX.add(new GroupMarker(IWorkbenchActionConstants.FILE_START));

			{
				IMenuManager menuXX = new MenuManager("&New", "new");

				menuXX.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
				menuX.add(menuXX);
			}

			menuX.add(new Separator());

			menuX.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));

			menuX.add(new Separator());

			menuX.add(getAction(ActionFactory.CLOSE.getId()));

			menuX.add(getAction(ActionFactory.CLOSE_ALL.getId()));

			menuX.add(new Separator());

			menuX.add(getAction(ActionFactory.SAVE.getId()));

			menuX.add(getAction(ActionFactory.SAVE_AS.getId()));

			menuX.add(getAction(ActionFactory.SAVE_ALL.getId()));

			menuX.add(new Separator());

			menuX.add(getAction(ActionFactory.QUIT.getId()));

			menuX.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));
			menu.add(menuX);
		}

		{
			IMenuManager menuX = new MenuManager("&Edit", IWorkbenchActionConstants.M_EDIT);

			menuX.add(new GroupMarker(IWorkbenchActionConstants.EDIT_START));

			menuX.add(getAction(ActionFactory.UNDO.getId()));

			menuX.add(getAction(ActionFactory.REDO.getId()));

			menuX.add(new GroupMarker(IWorkbenchActionConstants.UNDO_EXT));

			menuX.add(new Separator());

			menuX.add(getAction(ActionFactory.CUT.getId()));

			menuX.add(getAction(ActionFactory.COPY.getId()));

			menuX.add(getAction(ActionFactory.PASTE.getId()));

			menuX.add(new GroupMarker(IWorkbenchActionConstants.CUT_EXT));

			menuX.add(new Separator());

			menuX.add(getAction(ActionFactory.DELETE.getId()));

			menuX.add(getAction(ActionFactory.SELECT_ALL.getId()));

			menuX.add(new Separator());

			menuX.add(new GroupMarker(IWorkbenchActionConstants.ADD_EXT));

			menuX.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));

			menuX.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
			menu.add(menuX);
		}

		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));

		{
			IMenuManager menuX = new MenuManager("&Window", IWorkbenchActionConstants.M_WINDOW);

			menuX.add(getAction(ActionFactory.OPEN_NEW_WINDOW.getId()));

			menuX.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			menu.add(menuX);
		}

		{
			IMenuManager menuX = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);

			menuX.add(new GroupMarker(IWorkbenchActionConstants.HELP_START));

			menuX.add(new GroupMarker(IWorkbenchActionConstants.HELP_END));

			menuX.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			menu.add(menuX);
		}
	}

	/**
	 * @generated
	 */
	protected void fillCoolBar(ICoolBarManager toolBar) {

	}

	/**
	 * @generated
	 */
	private static boolean openEditor(IWorkbench workbench, org.eclipse.emf.common.util.URI fileURI) {
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage page = workbenchWindow.getActivePage();
		IEditorDescriptor editorDescriptor = workbench.getEditorRegistry().getDefaultEditor(fileURI.toFileString());
		if (editorDescriptor == null) {
			MessageDialog.openError(workbenchWindow.getShell(), "Error", org.eclipse.osgi.util.NLS.bind("There is no editor registered for the file ''{0}''", fileURI.toFileString()));
			return false;
		} else {
			try {
				page.openEditor(new URIEditorInput(fileURI), editorDescriptor.getId());
			} catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), "Open Editor", exception.getMessage());
				return false;
			}
		}
		return true;
	}

	/**
	 * @generated
	 */
	public static class NewDiagramAction extends WorkbenchWindowActionDelegate {

		/**
		 * @generated
		 */
		public void run(IAction action) {
			TaiPanCreationWizard wizard = new TaiPanCreationWizard();
			wizard.init(getWindow().getWorkbench(), StructuredSelection.EMPTY);
			WizardDialog wizardDialog = new WizardDialog(getWindow().getShell(), wizard);
			wizardDialog.open();
		}
	}

	/**
	 * @generated
	 */
	public static class OpenURIAction extends WorkbenchWindowActionDelegate {

		/**
		 * @generated
		 */
		public void run(IAction action) {
			LoadResourceAction.LoadResourceDialog loadResourceDialog = new LoadResourceAction.LoadResourceDialog(getWindow().getShell());
			if (Dialog.OK == loadResourceDialog.open()) {
				for (Iterator i = loadResourceDialog.getURIs().iterator(); i.hasNext();) {
					openEditor(getWindow().getWorkbench(), (org.eclipse.emf.common.util.URI) i.next());
				}
			}
		}
	}

	/**
	 * @generated
	 */
	public static class OpenAction extends WorkbenchWindowActionDelegate {

		/**
		 * @generated
		 */
		public void run(IAction action) {
			FileDialog fileDialog = new FileDialog(getWindow().getShell(), org.eclipse.swt.SWT.OPEN);
			fileDialog.open();
			if (fileDialog.getFileName() != null && fileDialog.getFileName().length() > 0) {
				openEditor(getWindow().getWorkbench(), org.eclipse.emf.common.util.URI.createFileURI(fileDialog.getFilterPath() + File.separator + fileDialog.getFileName()));
			}
		}
	}

	/**
	 * @generated
	 */
	public static class AboutAction extends WorkbenchWindowActionDelegate {

		/**
		 * @generated
		 */
		public void run(IAction action) {
			MessageDialog.openInformation(getWindow().getShell(), "About", "TaiPan Diagram Editor");
		}
	}
}
