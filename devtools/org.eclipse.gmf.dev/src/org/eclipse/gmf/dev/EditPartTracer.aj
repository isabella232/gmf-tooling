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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

/**
 * @author dstadnik
 */
public aspect EditPartTracer {

	pointcut makingCommandInEditPart(EditPart editPart, Request request) : execution(Command EditPart.getCommand(Request)) && target(editPart) && args(request);

	Command around(EditPart editPart, Request request) : makingCommandInEditPart(editPart, request) {
		EditPartTraceUtil.fireCommandRequested(editPart, request);
		Command command = null;
		try {
			command = proceed(editPart, request);
		} finally {
			EditPartTraceUtil.fireCommandCreated(editPart, request, command);
		}
		return command;
	}

	pointcut makingCommandInEditPolicy(EditPolicy editPolicy, Request request) : execution(Command EditPolicy.getCommand(Request)) && target(editPolicy) && args(request);

	Command around(EditPolicy editPolicy, Request request) : makingCommandInEditPolicy(editPolicy, request) {
		Command command = proceed(editPolicy, request);
		if (command != null) {
			EditPartTraceUtil.addSource(command, editPolicy);
		}
		return command;
	}
}
