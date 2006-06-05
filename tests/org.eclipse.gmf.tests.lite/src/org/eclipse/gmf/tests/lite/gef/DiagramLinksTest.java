/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.gef;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gmf.runtime.notation.Bendpoints;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.tests.rt.RuntimeDiagramTestBase;

public class DiagramLinksTest extends RuntimeDiagramTestBase {
	public DiagramLinksTest(String name) {
		super(name);
	}

	public void testBendpoints() throws Exception {
		Node createdNode1 = createNode(getGenModel().getNodeA(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNode1);
		Node createdNode2 = createNode(getGenModel().getNodeB(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNode2);
		Edge link = createLink(getGenModel().getLinkC(), createdNode1, createdNode2);
		assertNotNull("Link not created", link);
		ConnectionEditPart linkEp = (ConnectionEditPart) findEditPart(link);
		assertNotNull("Could not find editpart that represents link", linkEp);
		//Bendpoints bendpoints = link.getBendpoints();
		//it is currently unspecified whether bendpoints are empty or null. Null is treated as empty, anyway.
		modifyBendpoints(RequestConstants.REQ_CREATE_BENDPOINT, 0, new Point(500, 500), linkEp);
		checkBendpointsSize(link, 1);
		modifyBendpoints(RequestConstants.REQ_MOVE_BENDPOINT, 0, new Point(400, 400), linkEp);
		checkBendpointsSize(link, 1);
		modifyBendpoints(RequestConstants.REQ_CREATE_BENDPOINT, 1, new Point(700, 700), linkEp);
		checkBendpointsSize(link, 2);
		//Move one bendpoint pretty close to another bendpoint: this should be translated into a delete bendpoint command.
		modifyBendpoints(RequestConstants.REQ_MOVE_BENDPOINT, 1, new Point(401, 400), linkEp);
		checkBendpointsSize(link, 1);
	}

	private void modifyBendpoints(String requestType, int index, Point point, ConnectionEditPart linkEp) {
		//since the fake viewer suppresses update, and the showSourceFeedback() operates with Polyline directly, force update of polyline points
		((PolylineConnection)linkEp.getFigure()).layout();
		BendpointRequest bendpointRequest = new BendpointRequest();
		bendpointRequest.setType(requestType);
		bendpointRequest.setIndex(index);
		bendpointRequest.setLocation(point);
		bendpointRequest.setSource(linkEp);
		//showSourceFeedback is used to sometimes translate a move bendpoint request into a delete bendpoint request.
		linkEp.showSourceFeedback(bendpointRequest);
		Command command = linkEp.getCommand(bendpointRequest);
		assertNotNull("No command", command);
		assertTrue("Unexecutable command", command.canExecute());
		linkEp.eraseSourceFeedback(bendpointRequest);
		command.execute();
	}

	private void checkBendpointsSize(Edge link, int expectedSize) {
		Bendpoints bendpoints = link.getBendpoints();
		assertNotNull(bendpoints);
		assertTrue(bendpoints instanceof RelativeBendpoints);
		RelativeBendpoints relativeBendpoints = (RelativeBendpoints) bendpoints;
		assertEquals(expectedSize, relativeBendpoints.getPoints().size());
	}
}
