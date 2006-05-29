/*******************************************************************************
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 ******************************************************************************/
package org.eclipse.gmf.examples.mindmap.diagram.part;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.providers.MindmapElementTypes;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.ObjectAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateViewAndOptionallyElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class MindmapCreateSubtopicAction implements IObjectActionDelegate {

	public final static String ID = "org.eclipse.gmf.examples.mindmap.popup.MindmapCreateSubtopicActionID";

	private TopicEditPart selectedElement;

	public void run(IAction action) {
		CreateConnectionRequest connectionRequest = getCreateConnectionRequest();
		Command c = getConnectionAndEndCommands(connectionRequest);
		selectedElement.getDiagramEditDomain().getDiagramCommandStack().execute(c);
		Collection newObjects = DiagramCommandStack.getReturnValues(c);
		Iterator i = newObjects.iterator();
		if (i.hasNext()) {
			Object obj = i.next();
			View view = (View) ((IAdaptable) obj).getAdapter(View.class);
			final EditPart elementPart = selectedElement.findEditPart(selectedElement.getParent(), (EObject) view.getElement());
			final EditPartViewer v = elementPart.getViewer();
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
					v.setSelection(new StructuredSelection(elementPart));
					Request der = new Request(RequestConstants.REQ_DIRECT_EDIT);
					elementPart.performRequest(der);
				}
			});
		}
	}

	protected CreateConnectionRequest getCreateConnectionRequest() {
		CreateConnectionRequest connectionRequest = CreateViewRequestFactory.getCreateConnectionRequest(MindmapElementTypes.TopicSubtopics_4001, selectedElement.getDiagramPreferencesHint());
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
		Point p = selectedElement.getFigure().getBounds().getTopRight().getCopy();
		selectedElement.getFigure().translateToAbsolute(p);
		int edgeCount = selectedElement.getNotationView().getSourceEdges().size();
		// A quick hack to get subtopics to layout to the right, from top to
		// bottom
		int offset = (edgeCount * 50) - 100;
		connectionRequest.setLocation(p.translate(100, offset));
		connectionRequest.setSourceEditPart(selectedElement);
		return connectionRequest;
	}

	protected Command getConnectionAndEndCommands(CreateConnectionRequest request) {
		CompoundCommand cc = new CompoundCommand("Create Subtopic and Link");
		ObjectAdapter connectionAdapter = new ObjectAdapter();
		connectionAdapter.setObject(MindmapElementTypes.TopicSubtopics_4001);
		ObjectAdapter endAdapter = new ObjectAdapter();
		endAdapter.setObject(MindmapElementTypes.Topic_2001);
		MapEditPart map = (MapEditPart) selectedElement.getParent();
		CreateViewAndOptionallyElementCommand createOtherEndCmd = new CreateViewAndOptionallyElementCommand(endAdapter, map, request.getLocation(), selectedElement.getDiagramPreferencesHint());
		cc.add(new EtoolsProxyCommand(createOtherEndCmd));
		ICommand connectionCommand = new DeferredCreateConnectionViewAndElementCommand(request, connectionAdapter, request.getSourceEditPart(), createOtherEndCmd.getResult(), selectedElement
				.getViewer());
		cc.add(new EtoolsProxyCommand(connectionCommand));
		return cc;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		selectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof TopicEditPart) {
				selectedElement = (TopicEditPart) structuredSelection.getFirstElement();
			}
		}
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

}
