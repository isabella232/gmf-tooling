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

import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

/**
 * Traces editparts notifications.
 * 
 * @author dstadnik
 */
public interface EditPartTraceListener {

	/**
	 * Called when command was requested but before it was created.
	 */
	public void commandRequested(EditPart editPart, Request request);

	/**
	 * Edit part created command in response to the request.
	 */
	public void commandCreated(EditPart editPart, Request request, Command command, Map sources);
}
