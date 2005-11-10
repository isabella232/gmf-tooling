/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev;

import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

/**
 * @author dstadnik
 */
public class PartTrackerView extends ViewPart {

	private Tree control;
	private PartTracker tracker;

	public void createPartControl(Composite parent) {
		control = new Tree(parent, SWT.SINGLE);
		tracker = new PartTracker(getViewSite().getPage());

		IAction clearAction = new Action("Clear") { //$NON-NLS-1$

			public void run() {
				if (control != null && !control.isDisposed()) {
					control.removeAll();
				}
			}
		};
		getViewSite().getActionBars().getToolBarManager().add(clearAction);
	}

	public void setFocus() {
		if (control != null && !control.isDisposed()) {
			control.setFocus();
		}
	}

	public void dispose() {
		if (tracker != null) {
			tracker.dispose();
			tracker = null;
		}
	}

	public TreeItem addItem(String text) {
		TreeItem item = new TreeItem(control, SWT.NONE);
		if (text != null) {
			item.setText(text);
		}
		scrollDown(item);
		return item;
	}

	public TreeItem addItem(String text, IWorkbenchPart part) {
		if (part == this) {
			return null;
		}
		TreeItem item = new TreeItem(control, SWT.NONE);
		Image image = part.getTitleImage();
		if (image != null && !image.isDisposed()) {
			item.setImage(image);
		}
		if (text != null) {
			text = text + ' ' + part.getTitle();
		} else {
			text = part.getTitle();
		}
		item.setText(text);
		scrollDown(item);
		return item;
	}

	public TreeItem addItem(String text, ISelection selection) {
		TreeItem item = new TreeItem(control, SWT.NONE);
		addItem(item, text, selection);
		scrollDown(item);
		return item;
	}

	private TreeItem addItem(TreeItem item, String text, ISelection selection) {
		if (selection == null) {
			if (text != null) {
				item.setText(text);
			}
			return null;
		}
		String value;
		if (selection instanceof IStructuredSelection) {
			value = "structured selection"; //$NON-NLS-1$
			IStructuredSelection elements = (IStructuredSelection) selection;
			if (elements.isEmpty()) {
				value += " : empty"; //$NON-NLS-1$
			} else {
				Iterator i = elements.iterator();
				while (i.hasNext()) {
					Object element = i.next();
					TreeItem elementItem = new TreeItem(item, SWT.NONE);
					elementItem.setText(getClassName(element, false) + ':' + String.valueOf(element));
				}
			}
		} else {
			value = selection.toString();
		}
		if (text != null) {
			value = text + ' ' + value;
		}
		item.setText(value);
		item.setExpanded(true);
		return item;
	}

	private void scrollDown(TreeItem item) {
		control.showItem(item);
	}

	public Object getAdapter(Class adapter) {
		if (Control.class.isAssignableFrom(adapter)) {
			return control;
		}
		return super.getAdapter(adapter);
	}

	public static String getClassName(Object obj, boolean fqn) {
		if (obj == null) {
			return null;
		}
		String name = obj.getClass().getName();
		return fqn ? name : name.substring(name.lastIndexOf('.') + 1);
	}

	private class PartTracker implements IPartListener, ISelectionListener {

		private IWorkbenchPage page;

		public PartTracker(IWorkbenchPage page) {
			this.page = page;
			page.addPartListener(this);
			page.addSelectionListener(this);
		}

		public void partActivated(IWorkbenchPart part) {
			addItem("[actv]", part); //$NON-NLS-1$
		}

		public void partDeactivated(IWorkbenchPart part) {
			addItem("[deac]", part); //$NON-NLS-1$
		}

		public void partBroughtToTop(IWorkbenchPart part) {
			addItem("[btop]", part); //$NON-NLS-1$
		}

		public void partOpened(IWorkbenchPart part) {
			addItem("[opnd]", part); //$NON-NLS-1$
		}

		public void partClosed(IWorkbenchPart part) {
			addItem("[clsd]", part); //$NON-NLS-1$
		}

		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			addItem("[selc]", selection); //$NON-NLS-1$
		}

		public void dispose() {
			page.removeSelectionListener(this);
			page.removePartListener(this);
		}
	}
}
