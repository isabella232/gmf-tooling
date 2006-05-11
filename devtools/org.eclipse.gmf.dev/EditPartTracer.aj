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
package org.eclipse.gmf.runtime.diagram.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author dstadnik
 */
public aspect EditPartTracer {

	pointcut makingCommand(EditPart editPart, Request request) :  (execution(Command ConnectionEditPart.getCommand(Request)) || execution(Command GraphicalEditPart.getCommand(Request))) && target(editPart) && args(request);

	Command around(EditPart editPart, Request request) : makingCommand(editPart, request) {
		fireCommandRequested(editPart, request);
		Map sources = new HashMap();
		Command command = null;
		try {
			command = proceed(editPart, request);
		} finally {
			fireCommandCreated(editPart, request, command, sources);
		}
		return command;
	}

	private static Object getTraceView() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return null;
		}
		IWorkbenchPage page = window.getActivePage();
		if (page == null) {
			return null;
		}
		return page.findView("org.eclipse.gmf.dev.EditPartTraceView");
	}

	private void fireCommandRequested(EditPart editPart, Request request) {
		Object view = getTraceView();
		if (view == null) {
			return;
		}
		try {
			view.getClass().getDeclaredMethod("traceCommandRequested", EditPart.class, Request.class).invoke(view, editPart, request);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private void fireCommandCreated(EditPart editPart, Request request, Command command, Map sources) {
		Object view = getTraceView();
		if (view == null) {
			return;
		}
		try {
			view.getClass().getDeclaredMethod("traceCommandCreated", EditPart.class, Request.class, Command.class, Map.class).invoke(view, editPart, request, command, sources);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
