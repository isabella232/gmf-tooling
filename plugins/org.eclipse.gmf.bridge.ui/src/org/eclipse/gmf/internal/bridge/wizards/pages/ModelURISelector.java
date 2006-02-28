/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.wizards.pages;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

/**
 * @author artem
 */
public class ModelURISelector implements Listener {

	private final String myGroupTitle;

	private final String myFileExt;

	private final Loader myModelLoader;

	private Text uriText;

	private Menu browseMenu;

	private Group myControl;

	public ModelURISelector(String groupTitle, String fileExt, Loader modelLoader) {
		myGroupTitle = groupTitle;
		myFileExt = fileExt;
		myModelLoader = modelLoader;
	}

	public void setURIText(String text) {
		uriText.setText(text);
	}
	public void setURIText(URI uri) {
		setURIText(uri.toString());
	}

	public Control createControl(Composite parent) {
		myControl = new Group(parent, SWT.NONE);
		GridLayout l = new GridLayout();
		l.numColumns = 2;
		myControl.setLayout(l);
		myControl.setText(myGroupTitle);
		uriText = new Text(myControl, SWT.SINGLE | SWT.BORDER);
		uriText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		browseMenu = createBrowseMenu(myControl);
		createToolBar(myControl);
		return myControl;
	}

	public Menu getBrowseMenu() {
		return browseMenu;
	}

	/**
	 * @see http://www.eclipse.org/swt/snippets/
	 * @param parent
	 */
	private void createToolBar(Composite parent) {
		final ToolBar toolBar = new ToolBar(parent, SWT.NONE);
		new ToolItem(toolBar, SWT.SEPARATOR);
		new ToolItem(toolBar, SWT.SEPARATOR);
		final ToolItem toolItem = new ToolItem(toolBar, SWT.DROP_DOWN);
		toolItem.setText(Messages.uriSelectorBrowse);
		toolItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.ARROW) {
					Rectangle rect = toolItem.getBounds();
					Point pt = new Point(rect.x, rect.y + rect.height);
					pt = toolBar.toDisplay(pt);
					getBrowseMenu().setLocation(pt.x, pt.y);
					getBrowseMenu().setVisible(true);
				}
			}
		});

		new ToolItem(toolBar, SWT.SEPARATOR);
		new ToolItem(toolBar, SWT.SEPARATOR);
		ToolItem toolItem1 = new ToolItem(toolBar, SWT.PUSH);
		toolItem1.setText(Messages.uriSelectorLoad);
		toolItem1.addListener(SWT.Selection, this);
	}

	protected Menu createBrowseMenu(Control parent) {
		Menu menu = new Menu(parent);
		MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText(Messages.uriSelectorWorkspace);
		item.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				handleBrowseWorkspace();
			}
		});
		item = new MenuItem(menu, SWT.PUSH);
		item.setText(Messages.uriSelectorFilesystem);
		item.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				handleBrowseFilesystem();
			}
		});
		return menu;
	}

	protected void handleBrowseWorkspace() {
		ResourceSelectionDialog d = new ResourceSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), null);
		if (ResourceSelectionDialog.OK != d.open()) {
			return;
		}
		Object[] result = d.getResult();
		if (result != null) {
			IResource resource = (IResource) result[0];
			if (isValidWorkspaceResource(resource)) {
				setURIText(URI.createURI(URI.createPlatformResourceURI(resource.getFullPath().toString()).toString(), true).toString());
			}
		}
	}

	protected void handleBrowseFilesystem() {
		FileDialog fileDialog = new FileDialog(getShell(), SWT.OPEN | SWT.SINGLE);
		fileDialog.setFilterExtensions(new String[] { "*." + myFileExt }); //$NON-NLS-1$

		if (fileDialog.open() != null && fileDialog.getFileNames().length > 0) {
			String filePath = fileDialog.getFileNames()[0];
			setURIText(URI.createFileURI(filePath).toString());
		}
	}

	protected boolean isValidWorkspaceResource(IResource resource) {
		if (resource.getType() != IResource.FILE) {
			return false;
		}
		return myFileExt.equals(((IFile) resource).getFileExtension());
	}

	protected Shell getShell() {
		return myControl.getShell();
	}

	public void handleEvent(Event event) {
		myModelLoader.run(this, uriText.getText());
	}

	interface Loader {
		void run(ModelURISelector selector, String uriText);
	}
}
