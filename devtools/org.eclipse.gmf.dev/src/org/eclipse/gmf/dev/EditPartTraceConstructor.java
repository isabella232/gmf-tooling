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
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;

/**
 * @author dstadnik
 */
public class EditPartTraceConstructor {

	private static List<EditPartTraceContributor> contributors;

	private EditPartTraceConstructor() {
	}

	private static void loadContributors() {
		if (contributors != null) {
			return;
		}
		String id = DevPlugin.getInstance().getBundle().getSymbolicName();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(id, "editPartTraceContributors");
		contributors = new ArrayList<EditPartTraceContributor>(elements.length);
		for (int i = 0; i < elements.length; i++) {
			if (!"contributor".equals(elements[i].getName())) {
				continue;
			}
			try {
				contributors.add((EditPartTraceContributor) elements[i].createExecutableExtension("class"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static EditPartTraceRecord createEditPartNode(EditPart editPart) {
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		kids.add(new EditPartTraceRecord(String.valueOf(editPart.getModel()), DevPlugin.MODEL_IMAGE));
		if (editPart instanceof GraphicalEditPart) {
			GraphicalEditPart gEditPart = (GraphicalEditPart) editPart;
			kids.add(new EditPartTraceRecord("figure bounds " + gEditPart.getFigure().getBounds()));
		}
		loadContributors();
		for (EditPartTraceContributor contributor : contributors) {
			contributor.contribute(kids, editPart);
		}
		return new EditPartTraceRecord(DevUtils.getFullClassName(editPart), DevPlugin.EDITPART_IMAGE, kids.toArray(new EditPartTraceRecord[kids.size()]));
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
			List<? extends EditPart> editParts = ((GroupRequest) request).getEditParts();
			if (editParts != null) {
				for (EditPart editPart : editParts) {
					kids.add(createEditPartNode(editPart));
				}
			}
		}
		loadContributors();
		for (EditPartTraceContributor contributor : contributors) {
			contributor.contribute(kids, request);
		}
		return new EditPartTraceRecord(DevUtils.getFullClassName(request), DevPlugin.REQUEST_IMAGE, kids.toArray(new EditPartTraceRecord[kids.size()]));
	}

	public static EditPartTraceRecord createCommandNode(Command command, CommandCreatedEvent event) {
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		Object source = event.getSource(command);
		if (source != null) {
			kids.add(new EditPartTraceRecord("from " + DevUtils.getFullClassName(source)));
		}
		if (command instanceof CompoundCommand) {
			Iterator commands = ((CompoundCommand) command).getCommands().iterator();
			while (commands.hasNext()) {
				kids.add(createCommandNode((Command) commands.next(), event));
			}
		}
		loadContributors();
		for (EditPartTraceContributor contributor : contributors) {
			contributor.contribute(kids, command, event);
		}
		return new EditPartTraceRecord(getLabel(command), getImage(command), kids.toArray(new EditPartTraceRecord[kids.size()]));
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
}
