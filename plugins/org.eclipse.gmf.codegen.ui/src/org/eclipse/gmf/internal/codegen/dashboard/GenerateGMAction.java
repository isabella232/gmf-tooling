/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.dashboard;

import org.eclipse.core.resources.IFile;
import org.eclipse.gmf.bridge.ui.dashboard.DashboardAction;
import org.eclipse.gmf.bridge.ui.dashboard.DashboardFacade;
import org.eclipse.gmf.bridge.ui.dashboard.DashboardState;
import org.eclipse.gmf.internal.codegen.popup.actions.TransformToGenModel;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author dstadnik
 */
public class GenerateGMAction implements DashboardAction {

	private DashboardFacade context;

	public void init(DashboardFacade context) {
		this.context = context;
	}

	public boolean isEnabled() {
		DashboardState state = context.getState();
		if (context.isStrict()) {
			if (state.dmFileName == null || state.dgmFileName == null || state.tdmFileName == null) {
				return false;
			}
		}
		return context.getProject() != null && state.mmFileName != null;
	}

	public void run() {
		DashboardState state = context.getState();
		IFile file = context.getFile(state.mmFileName);
		TransformToGenModel action = new TransformToGenModel();
		IAction uiAction = new Action() {
		};
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		action.setActivePart(uiAction, window.getPartService().getActivePart());
		action.selectionChanged(uiAction, new StructuredSelection(file));
		action.run(uiAction);
		IFile gfile = action.getGenModelFile();
		state.gmFileName = context.getName(gfile);
		context.updateStatus();
	}
}
