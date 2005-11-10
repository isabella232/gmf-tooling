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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.XtoolsProxyCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

/**
 * @author dstadnik
 */
class EditPartTraceConstructor {

	private EditPartTraceConstructor() {
	}

	public static EditPartTraceRecord createEditPartNode(EditPart editPart) {
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		kids.add(new EditPartTraceRecord(String.valueOf(editPart.getModel()), DevPlugin.MODEL_IMAGE));
		if (editPart instanceof GraphicalEditPart) {
			GraphicalEditPart gEditPart = (GraphicalEditPart) editPart;
			kids.add(new EditPartTraceRecord("figure bounds " + gEditPart.getFigure().getBounds()));
		}
		return new EditPartTraceRecord(DevUtils.getFullClassName(editPart), DevPlugin.EDITPART_IMAGE, (EditPartTraceRecord[]) kids.toArray(new EditPartTraceRecord[kids.size()]));
	}

	public static EditPartTraceRecord createRequestNode(Request request) {
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		if (request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest cbRequest = (ChangeBoundsRequest) request;
			kids.add(new EditPartTraceRecord("location " + cbRequest.getLocation()));
			kids.add(new EditPartTraceRecord("move delta " + cbRequest.getMoveDelta()));
			kids.add(new EditPartTraceRecord("resize delta " + cbRequest.getSizeDelta()));
			kids.add(new EditPartTraceRecord("resize direction " + cbRequest.getResizeDirection()));
		}
		if (request instanceof GroupRequest) {
			List<? extends EditPart> editParts = (List<? extends EditPart>) ((GroupRequest) request).getEditParts();
			if (editParts != null) {
				for (EditPart editPart : editParts) {
					kids.add(createEditPartNode(editPart));
				}
			}
		}
		if (request instanceof EditCommandRequestWrapper) {
			IEditCommandRequest realRequest = ((EditCommandRequestWrapper) request).getEditCommandRequest();
			if (realRequest != null) {
				kids.add(createRequestNode(realRequest));
			}
		}
		return new EditPartTraceRecord(DevUtils.getFullClassName(request), DevPlugin.REQUEST_IMAGE, (EditPartTraceRecord[]) kids.toArray(new EditPartTraceRecord[kids.size()]));
	}

	private static String getLabel(IEditCommandRequest request) {
		String label = DevUtils.getFullClassName(request);
		if (request.getLabel() != null) {
			label += '<' + request.getLabel() + '>';
		}
		return label;
	}

	public static EditPartTraceRecord createRequestNode(IEditCommandRequest request) {
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		//kids.add(new EditPartTraceRecord("edit helper context " + request.getEditHelperContext()));
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
		return new EditPartTraceRecord(getLabel(request), DevPlugin.REQUEST_IMAGE, (EditPartTraceRecord[]) kids.toArray(new EditPartTraceRecord[kids.size()]));
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

	public static EditPartTraceRecord createCommandNode(org.eclipse.emf.common.command.Command command, CommandCreatedEvent event) {
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		Object source = event.getSource(command);
		if (source != null) {
			kids.add(new EditPartTraceRecord("from " + DevUtils.getFullClassName(source)));
		}
		if (command instanceof org.eclipse.emf.common.command.CompoundCommand) {
			for (org.eclipse.emf.common.command.Command subCommand : (List<? extends org.eclipse.emf.common.command.Command>) ((org.eclipse.emf.common.command.CompoundCommand) command).getCommandList()) {
				kids.add(createCommandNode(subCommand, event));
			}
		}
		return new EditPartTraceRecord(getLabel(command), getImage(command), (EditPartTraceRecord[]) kids.toArray(new EditPartTraceRecord[kids.size()]));
	}

	private static String getLabel(Command command) {
		String label = DevUtils.getFullClassName(command);
		if (command.getDebugLabel() != null) {
			label += '<' + command.getDebugLabel() + '>';
		}
		return label;
	}

	private static String getImage(Command command) {
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

	public static EditPartTraceRecord createCommandNode(Command command, CommandCreatedEvent event) {
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		Object source = event.getSource(command);
		if (source != null) {
			kids.add(new EditPartTraceRecord("from " + DevUtils.getFullClassName(source)));
		}
		if (command instanceof CompoundCommand) {
			for (Command subCommand : (List<? extends Command>) ((CompoundCommand) command).getCommands()) {
				kids.add(createCommandNode(subCommand, event));
			}
		}
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
		return new EditPartTraceRecord(getLabel(command), getImage(command), (EditPartTraceRecord[]) kids.toArray(new EditPartTraceRecord[kids.size()]));
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
			if (command.isExecutable()) {
				id = DevPlugin.COMMAND_IMAGE;
			}
		} catch (Exception e) {
			// ignore
		}
		return id;
	}

	public static EditPartTraceRecord createCommandNode(ICommand command, CommandCreatedEvent event) {
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		Object source = event.getSource(command);
		if (source != null) {
			kids.add(new EditPartTraceRecord("from " + DevUtils.getFullClassName(source)));
		}
		if (command instanceof CompositeCommand) {
			for (ICommand subCommand : (List<? extends ICommand>) ((CompositeCommand) command).getCommands()) {
				kids.add(createCommandNode(subCommand, event));
			}
		}
		if (command instanceof XtoolsProxyCommand) {
			Command realCommand = ((XtoolsProxyCommand) command).getCommand();
			if (realCommand != null) {
				kids.add(createCommandNode(realCommand, event));
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
		return new EditPartTraceRecord(getLabel(command), getImage(command), (EditPartTraceRecord[]) kids.toArray(new EditPartTraceRecord[kids.size()]));
	}
}