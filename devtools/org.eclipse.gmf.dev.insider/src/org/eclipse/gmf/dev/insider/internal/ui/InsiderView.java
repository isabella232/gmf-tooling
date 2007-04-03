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
package org.eclipse.gmf.dev.insider.internal.ui;

import org.eclipse.gmf.dev.insider.internal.InsiderAccess;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.part.ViewPart;

public class InsiderView extends ViewPart {

	public void createPartControl(Composite parent) {
		myViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		myViewer.setContentProvider(new InsiderContentProvider());
		myViewer.setLabelProvider(new InsiderLabelProvider());
		myViewer.setInput(InsiderAccess.getViewManager());
		myPresentationController = new PresentationController(getViewSite());
		myActionGroup = new InsiderActionGroup(this);
		hookContextMenu();
		myViewer.addOpenListener(new ReferenceOpener());
		myViewer.addSelectionChangedListener(myPresentationController);
		myViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (selection.size() != 1) {
					return;
				}
				Object selected = selection.getFirstElement();
				TreeViewer viewer = (TreeViewer) event.getViewer();
				if (viewer.getExpandedState(selected)) {
					viewer.collapseToLevel(selected, 1);
				} else {
					viewer.expandToLevel(selected, 1);
				}
			}
		});
		myActionGroup.fillActionBars(getViewSite().getActionBars());
	}

	public void setFocus() {
		myViewer.getControl().setFocus();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager(getViewSite().getId());
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				myActionGroup.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(myViewer.getControl());
		myViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, myViewer);
	}

	public final boolean isShowSimpleTypes() {
		return getLabelProvider().isShowSimpleTypes();
	}

	public void setShowSimpleTypes(boolean showSimpleTypes) {
		if (getLabelProvider().isShowSimpleTypes() == showSimpleTypes) {
			return;
		}
		getLabelProvider().setShowSimpleTypes(showSimpleTypes);
		myViewer.refresh(true);
	}

	public final boolean isShowIds() {
		return getLabelProvider().isShowIds();
	}

	public void setShowIds(boolean showIds) {
		if (getLabelProvider().isShowIds() == showIds) {
			return;
		}
		getLabelProvider().setShowIds(showIds);
		myViewer.refresh(true);
	}

	public final boolean isShowBounds() {
		return getLabelProvider().isShowBounds();
	}

	public void setShowBounds(boolean showBounds) {
		if (getLabelProvider().isShowBounds() == showBounds) {
			return;
		}
		getLabelProvider().setShowBounds(showBounds);
		myViewer.refresh(true);
	}

	private InsiderLabelProvider getLabelProvider() {
		return (InsiderLabelProvider) myViewer.getLabelProvider();
	}

	public PresentationController getPresentationController() {
		return myPresentationController;
	}

	public TreeViewer getViewer() {
		return myViewer;
	}

	private TreeViewer myViewer;
	private PresentationController myPresentationController;
	private InsiderActionGroup myActionGroup;
}
