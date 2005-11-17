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
import org.eclipse.gmf.dev.insider.internal.ui.actions.MemorizeActiveEditorAction;
import org.eclipse.gmf.dev.insider.internal.ui.actions.OpenPresentationAction;
import org.eclipse.gmf.dev.insider.internal.ui.actions.ShowIdsAction;
import org.eclipse.gmf.dev.insider.internal.ui.actions.ShowSimpleTypesAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.part.DrillDownAdapter;

/**
 * @author dstadnik
 */
public class InsiderActionGroup extends ActionGroup {

	public InsiderActionGroup(InsiderView view) {
		TreeViewer viewer = view.getViewer();
		myDrill = new DrillDownAdapter(viewer);
		myMemorizeActiveEditorAction = new MemorizeActiveEditorAction();
		myOpenPresentationAction = new OpenPresentationAction(view);
		myShowSimpleTypesAction = new ShowSimpleTypesAction(view);
		view.setShowSimpleTypes(myShowSimpleTypesAction.isChecked());
		myShowIdsAction = new ShowIdsAction(view);
		view.setShowIds(myShowIdsAction.isChecked());
		myClearAction = new Action("Clear") {

			public void run() {
				InsiderAccess.getViewManager().removeAll();
			}
		};
	}

	public void fillContextMenu(IMenuManager manager) {
		manager.add(myMemorizeActiveEditorAction);
		manager.add(myOpenPresentationAction);
		manager.add(myShowSimpleTypesAction);
		manager.add(myShowIdsAction);
		manager.add(new Separator());
		myDrill.addNavigationActions(manager);
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	public void fillActionBars(IActionBars actionBars) {
		fillLocalPullDown(actionBars.getMenuManager());
		fillLocalToolBar(actionBars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(myShowSimpleTypesAction);
		manager.add(myShowIdsAction);
		manager.add(myClearAction);
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(myMemorizeActiveEditorAction);
		manager.add(new Separator());
		myDrill.addNavigationActions(manager);
	}

	private ShowSimpleTypesAction myShowSimpleTypesAction;
	private ShowIdsAction myShowIdsAction;
	private OpenPresentationAction myOpenPresentationAction;
	private MemorizeActiveEditorAction myMemorizeActiveEditorAction;
	private IAction myClearAction;
	private DrillDownAdapter myDrill;
}
