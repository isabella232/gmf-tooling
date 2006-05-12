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
package org.eclipse.gmf.dev.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.dev.CommandCreatedEvent;
import org.eclipse.gmf.dev.DevPlugin;
import org.eclipse.gmf.dev.DevUtils;
import org.eclipse.gmf.dev.EditPartTraceConstructor;
import org.eclipse.gmf.dev.EditPartTraceContributor;
import org.eclipse.gmf.dev.EditPartTraceRecord;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

/**
 * @author dstadnik
 */
public class ExtEditPartTraceContributor implements EditPartTraceContributor {

	public void contribute(List<EditPartTraceRecord> kids, EditPart editPart) {
	}

	public void contribute(List<EditPartTraceRecord> kids, Request request) {
		if (request instanceof EditCommandRequestWrapper) {
			IEditCommandRequest realRequest = ((EditCommandRequestWrapper) request).getEditCommandRequest();
			if (realRequest != null) {
				kids.add(createRequestNode(realRequest));
			}
		}
	}

	public static EditPartTraceRecord createRequestNode(IEditCommandRequest request) {
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		// kids.add(new EditPartTraceRecord("edit helper context " + request.getEditHelperContext()));
		List elementsToEdit = request.getElementsToEdit();
		if (elementsToEdit != null) {
			for (Object elementToEdit : elementsToEdit) {
				kids.add(new EditPartTraceRecord("element to edit " + elementToEdit));
			}
		}
		Map parameters = request.getParameters();
		if (parameters != null) {
			for (Object key : parameters.keySet()) {
				if ("org.eclipse.gmf.dev.sources".equals(key)) {
					continue;
				}
				kids.add(new EditPartTraceRecord(String.valueOf(key) + '=' + parameters.get(key), DevPlugin.PARAMETER_IMAGE));
			}
		}
		return new EditPartTraceRecord(getLabel(request), DevPlugin.REQUEST_IMAGE, kids.toArray(new EditPartTraceRecord[kids.size()]));
	}

	private static String getLabel(IEditCommandRequest request) {
		String label = DevUtils.getFullClassName(request);
		if (request.getLabel() != null) {
			label += '<' + request.getLabel() + '>';
		}
		return label;
	}

	public void contribute(List<EditPartTraceRecord> kids, Command command, CommandCreatedEvent event) {
		if (command instanceof EtoolsProxyCommand) {
			ICommand realCommand = ((EtoolsProxyCommand) command).getICommand();
			if (realCommand != null) {
				kids.add(createCommandNode(realCommand, event));
			}
		}
		if (command instanceof IAdaptable) {
			org.eclipse.emf.common.command.Command delegate = (org.eclipse.emf.common.command.Command) ((IAdaptable) command).getAdapter(org.eclipse.emf.common.command.Command.class);
			if (delegate != null) {
				kids.add(createCommandNode(delegate, event));
			}
		}
	}

	public static EditPartTraceRecord createCommandNode(ICommand command, CommandCreatedEvent event) {
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		Object source = event.getSource(command);
		if (source != null) {
			kids.add(new EditPartTraceRecord("from " + DevUtils.getFullClassName(source)));
		}
		if (command instanceof CompositeCommand) {
			Iterator subCommands = ((CompositeCommand) command).iterator();
			while (subCommands.hasNext()) {
				kids.add(createCommandNode((ICommand) subCommands.next(), event));
			}
		}
		if (command instanceof CommandProxy) {
			Command realCommand = ((CommandProxy) command).getCommand();
			if (realCommand != null) {
				kids.add(EditPartTraceConstructor.createCommandNode(realCommand, event));
			}
		}
		if (command instanceof SemanticCreateCommand) {
			ICommand realCommand = (ICommand) DevUtils.getFieldValue(command, "realSemanticCommand");
			if (realCommand != null) {
				kids.add(createCommandNode(realCommand, event));
			}
		}
		if (command instanceof IAdaptable) {
			org.eclipse.emf.common.command.Command delegate = (org.eclipse.emf.common.command.Command) ((IAdaptable) command).getAdapter(org.eclipse.emf.common.command.Command.class);
			if (delegate != null) {
				kids.add(createCommandNode(delegate, event));
			}
		}
		return new EditPartTraceRecord(getLabel(command), getImage(command), kids.toArray(new EditPartTraceRecord[kids.size()]));
	}

	private static String getLabel(ICommand command) {
		String label = DevUtils.getFullClassName(command);
		if (command.getLabel() != null) {
			label += '<' + command.getLabel() + '>';
		}
		return label;
	}

	private static String getImage(ICommand command) {
		String id = DevPlugin.COMMANDX_IMAGE;
		try {
			if (command.canExecute()) {
				id = DevPlugin.COMMAND_IMAGE;
			}
		} catch (Exception e) {
			// ignore
		}
		return id;
	}

	public static EditPartTraceRecord createCommandNode(org.eclipse.emf.common.command.Command command, CommandCreatedEvent event) {
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		Object source = event.getSource(command);
		if (source != null) {
			kids.add(new EditPartTraceRecord("from " + DevUtils.getFullClassName(source)));
		}
		if (command instanceof org.eclipse.emf.common.command.CompoundCommand) {
			for (org.eclipse.emf.common.command.Command subCommand : (List<? extends org.eclipse.emf.common.command.Command>) ((org.eclipse.emf.common.command.CompoundCommand) command)
					.getCommandList()) {
				kids.add(createCommandNode(subCommand, event));
			}
		}
		return new EditPartTraceRecord(getLabel(command), getImage(command), kids.toArray(new EditPartTraceRecord[kids.size()]));
	}

	private static String getLabel(org.eclipse.emf.common.command.Command command) {
		String label = DevUtils.getFullClassName(command);
		if (command.getLabel() != null) {
			label += '<' + command.getLabel() + '>';
		}
		return label;
	}

	private static String getImage(org.eclipse.emf.common.command.Command command) {
		String id = DevPlugin.COMMANDX_IMAGE;
		try {
			if (command.canExecute()) {
				id = DevPlugin.COMMAND_IMAGE;
			}
		} catch (Exception e) {
			// ignore
		}
		return id;
	}
}