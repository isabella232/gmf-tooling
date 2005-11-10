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

import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

/**
 * @author dstadnik
 */
public class CommandCreatedEvent {

	EditPart editPart;
	Request request;
	Command command;
	Map sources;
	List<CommandCreatedEvent> siblings;

	public Object getSource(Object object) {
		Object source = null;
		if (sources != null) {
			source = sources.get(object);
		}
		if (source == null && siblings != null) {
			for (CommandCreatedEvent sibling : siblings) {
				source = sibling.getSource(object);
				if (source != null) {
					break;
				}
			}
		}
		return source;
	}
}
