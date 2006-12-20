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
import org.eclipse.ui.actions.ContributionItemFactory;
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
	protected void fillMenuBar(IMenuManager menuBar) {
		IWorkbenchWindow window = getActionBarConfigurer().getWindowConfigurer().getWindow();
		menuBar.add(createFileMenu(window));
		menuBar.add(createEditMenu(window));
		menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuBar.add(createWindowMenu(window));
		menuBar.add(createHelpMenu(window));
	}

	/**
	 * @generated
	 */
	protected IMenuManager createFileMenu(IWorkbenchWindow window) {
		IMenuManager menu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
		menu.add(new GroupMarker(IWorkbenchActionConstants.FILE_START));
		IMenuManager newMenu = new MenuManager("&New", "new"); //$NON-NLS-2$
		newMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(newMenu);
		menu.add(new Separator());
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(new Separator());
		addToMenuAndRegister(menu, ActionFactory.CLOSE.create(window));
		addToMenuAndRegister(menu, ActionFactory.CLOSE_ALL.create(window));
		menu.add(new Separator());
		addToMenuAndRegister(menu, ActionFactory.SAVE.create(window));
		addToMenuAndRegister(menu, ActionFactory.SAVE_AS.create(window));
		addToMenuAndRegister(menu, ActionFactory.SAVE_ALL.create(window));
		menu.add(new Separator());
		addToMenuAndRegister(menu, ActionFactory.QUIT.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));
		return menu;
	}

	/**
	 * @generated
	 */
	protected IMenuManager createEditMenu(IWorkbenchWindow window) {
		IMenuManager menu = new MenuManager("&Edit", IWorkbenchActionConstants.M_EDIT);
		menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_START));
		addToMenuAndRegister(menu, ActionFactory.UNDO.create(window));
		addToMenuAndRegister(menu, ActionFactory.REDO.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.UNDO_EXT));
		menu.add(new Separator());
		addToMenuAndRegister(menu, ActionFactory.CUT.create(window));
		addToMenuAndRegister(menu, ActionFactory.COPY.create(window));
		addToMenuAndRegister(menu, ActionFactory.PASTE.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.CUT_EXT));
		menu.add(new Separator());
		addToMenuAndRegister(menu, ActionFactory.DELETE.create(window));
		addToMenuAndRegister(menu, ActionFactory.SELECT_ALL.create(window));
		menu.add(new Separator());
		menu.add(new GroupMarker(IWorkbenchActionConstants.ADD_EXT));
		menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		return menu;
	}

	/**
	 * @generated
	 */
	protected IMenuManager createWindowMenu(IWorkbenchWindow window) {
		IMenuManager menu = new MenuManager("&Window", IWorkbenchActionConstants.M_WINDOW);
		addToMenuAndRegister(menu, ActionFactory.OPEN_NEW_WINDOW.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(ContributionItemFactory.OPEN_WINDOWS.create(window));
		return menu;
	}

	/**
	 * @generated
	 */
	protected IMenuManager createHelpMenu(IWorkbenchWindow window) {
		IMenuManager menu = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
		menu.add(new GroupMarker(IWorkbenchActionConstants.HELP_START));
		menu.add(new GroupMarker(IWorkbenchActionConstants.HELP_END));
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		return menu;
	}

	/**
	 * @generated
	 */
	protected void addToMenuAndRegister(IMenuManager menu, IAction action) {
		menu.add(action);
		register(action);
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
