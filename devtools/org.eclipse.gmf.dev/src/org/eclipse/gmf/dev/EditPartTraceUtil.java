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

import java.util.IdentityHashMap;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author dstadnik
 */
public class EditPartTraceUtil {

	private EditPartTraceUtil() {
	}

	public static EditPartTraceView getTraceView() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return null;
		}
		IWorkbenchPage page = window.getActivePage();
		if (page == null) {
			return null;
		}
		return (EditPartTraceView) page.findView("org.eclipse.gmf.dev.EditPartTraceView");
	}

	public static void fireCommandRequested(EditPart editPart, Request request) {
		EditPartTraceView view = getTraceView();
		if (view == null) {
			return;
		}
		try {
			view.traceCommandRequested(editPart, request);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void fireCommandCreated(EditPart editPart, Request request, Command command) {
		EditPartTraceView view = getTraceView();
		if (view == null) {
			return;
		}
		try {
			view.traceCommandCreated(editPart, request, command);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void addSource(Object command, Object source) {
		EditPartTraceView view = getTraceView();
		if (view == null) {
			return;
		}
		CommandCreatedEvent event = view.getCurrentEvent();
		if (event == null) {
			return;
		}
		if (event.sources == null) {
			event.sources = new IdentityHashMap();
		}
		event.sources.put(command, source);
	}
}
