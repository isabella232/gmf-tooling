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
package org.eclipse.gmf.dev.hook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

/**
 * @author dstadnik
 */
public class EditPartTracer {

	private List listeners;

	private EditPartTracer() {}

	public static EditPartTracer getInstance(EditPartViewer viewer) {
		if (viewer == null) {
			return null;
		}
		return (EditPartTracer) viewer.getProperty(EditPartTracer.class.getName());
	}

	public static EditPartTracer install(EditPartViewer viewer) {
		EditPartTracer tracer = getInstance(viewer);
		if (tracer == null && viewer != null) {
			tracer = new EditPartTracer();
			viewer.setProperty(EditPartTracer.class.getName(), tracer);
		}
		return tracer;
	}

	public void addTraceListener(EditPartTraceListener listener) {
		if (listener == null) {
			throw new IllegalArgumentException();
		}
		if (listeners == null) {
			listeners = new ArrayList();
		}
		listeners.add(listener);
	}

	public void removeTraceListener(EditPartTraceListener listener) {
		if (listener == null) {
			throw new IllegalArgumentException();
		}
		if (listeners == null) {
			return;
		}
		listeners.remove(listener);
	}

	public void fireCommandRequested(EditPart editPart, Request request) {
		if (listeners == null) {
			return;
		}
		for (int i = 0; i < listeners.size(); i++) {
			try {
				((EditPartTraceListener) listeners.get(i)).commandRequested(editPart, request);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

	public void fireCommandCreated(EditPart editPart, Request request, Command command, Map sources) {
		if (listeners == null) {
			return;
		}
		for (int i = 0; i < listeners.size(); i++) {
			try {
				((EditPartTraceListener) listeners.get(i)).commandCreated(editPart, request, command, sources);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

	public static class Insider extends AbstractGraphicalEditPart {

		/**
		 * Standard implementation of getCommand(Request) method
		 * from AbstractEditPart that also traces edit policies
		 * that created particular commands.
		 */
		public static Command getCommand(EditPolicyIterator editPolicies, Request request, Map sources) {
			Command command = null;
			while (editPolicies.hasNext()) {
				EditPolicy nextPolicy = editPolicies.next();
				Command nextCommand = nextPolicy.getCommand(request);
				if (nextCommand != null) {
					sources.put(nextCommand, nextPolicy);
				}
				command = command == null ? nextCommand : command.chain(nextCommand);
			}
			return command;
		}

		protected IFigure createFigure() {
			return null;
		}

		protected void createEditPolicies() {}
	}
}
