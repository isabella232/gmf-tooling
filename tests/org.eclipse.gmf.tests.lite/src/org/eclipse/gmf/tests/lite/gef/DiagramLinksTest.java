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

import java.util.Collection;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
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

	public void testRerouteLinkWithClass() throws Exception {
		Node createdNodeA = createNode(getGenModel().getNodeA(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNodeA);
		Node createdNodeB = createNode(getGenModel().getNodeB(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNodeB);
		Edge link = createLink(getGenModel().getLinkC(), createdNodeA, createdNodeB);
		assertNotNull("Link not created", link);
		ConnectionEditPart linkEp = (ConnectionEditPart) findEditPart(link);
		assertNotNull("Could not find editpart that represents link", linkEp);
		TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) getGenModel().getLinkC().getModelFacet();
		EStructuralFeature containmentFeature = createdNodeA.getElement().eClass().getEStructuralFeature(typeLinkModelFacet.getContainmentMetaFeature().getName());
		assertNotNull("Could not find containment feature", containmentFeature);
		EStructuralFeature targetFeature = link.getElement().eClass().getEStructuralFeature(typeLinkModelFacet.getTargetMetaFeature().getName());
		assertNotNull("Could not find target feature", targetFeature);
		assertSame("Target feature incorrect before reconnecting source", createdNodeB.getElement(), link.getElement().eGet(targetFeature));

		Node createdNodeA1 = createNode(getGenModel().getNodeA(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNodeA1);
		EditPart a1Ep = findEditPart(createdNodeA1);
		assertNotNull("Could not find editpart for the new source", a1Ep);
		reconnectLink(linkEp, a1Ep, true);
		assertSame("Notation model not updated", createdNodeA1, link.getSource());
		Collection containedObjectsA = (Collection) createdNodeA.getElement().eGet(containmentFeature);
		assertFalse("Old source still contains the link", containedObjectsA.contains(link.getElement()));
		Collection containedObjectsA1 = (Collection) createdNodeA1.getElement().eGet(containmentFeature);
		assertTrue("New source does not contain the link", containedObjectsA1.contains(link.getElement()));
		assertSame("Target feature changed after reconnecting source", createdNodeB.getElement(), link.getElement().eGet(targetFeature));

		getCommandStack().undo();
		assertSame("Notation model inconsistent after undo", createdNodeA, link.getSource());
		containedObjectsA = (Collection) createdNodeA.getElement().eGet(containmentFeature);
		assertTrue("Old source does not contain the link after undo", containedObjectsA.contains(link.getElement()));
		containedObjectsA1 = (Collection) createdNodeA1.getElement().eGet(containmentFeature);
		assertFalse("New source contains the link after undo", containedObjectsA1.contains(link.getElement()));
		assertSame("Target feature incorrect after undoing source reconnection", createdNodeB.getElement(), link.getElement().eGet(targetFeature));

		Node createdNodeB1 = createNode(getGenModel().getNodeB(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNodeB1);
		EditPart b1Ep = findEditPart(createdNodeB1);
		assertNotNull("Could not find editpart for the new target", b1Ep);
		reconnectLink(linkEp, b1Ep, false);
		assertSame("Notation model not updated", createdNodeB1, link.getTarget());
		assertSame("Target feature not updated", createdNodeB1.getElement(), link.getElement().eGet(targetFeature));

		getCommandStack().undo();
		assertSame("Notation model inconsistent after undo", createdNodeB, link.getTarget());
		assertSame("Target feature inconsistent after undo", createdNodeB.getElement(), link.getElement().eGet(targetFeature));
	}

	public void testRerouteLinkWithFeature() throws Exception {
		Node createdNodeA = createNode(getGenModel().getNodeA(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNodeA);
		Node createdNodeB = createNode(getGenModel().getNodeB(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNodeB);
		Edge link = createLink(getGenModel().getLinkD(), createdNodeA, createdNodeB);
		assertNotNull("Link not created", link);
		ConnectionEditPart linkEp = (ConnectionEditPart) findEditPart(link);
		assertNotNull("Could not find editpart that represents link", linkEp);
		FeatureLinkModelFacet featureLinkModelFacet = (FeatureLinkModelFacet) getGenModel().getLinkD().getModelFacet();
		EStructuralFeature metaFeature = createdNodeA.getElement().eClass().getEStructuralFeature(featureLinkModelFacet.getMetaFeature().getName());
		assertSame("Domain source of the link does not point at the element its notation points at", createdNodeB.getElement(), createdNodeA.getElement().eGet(metaFeature));
		assertSame("Link's element is incorrect", createdNodeB.getElement(), link.getElement());

		Node createdNodeA1 = createNode(getGenModel().getNodeA(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNodeA1);
		EditPart a1Ep = findEditPart(createdNodeA1);
		assertNotNull("Could not find editpart for the new source", a1Ep);
		reconnectLink(linkEp, a1Ep, true);
		assertSame("Notation model not updated on reconnecting source", createdNodeA1, link.getSource());
		assertNull("Old source still references target after reconnecting source", createdNodeA.getElement().eGet(metaFeature));
		assertSame("New source does not reference target after reconnecting source", createdNodeB.getElement(), createdNodeA1.getElement().eGet(metaFeature));
		assertSame("Link's element is incorrect after reconnecting source", createdNodeB.getElement(), link.getElement());

		getCommandStack().undo();
		assertSame("Notation model inconsistent after undo", createdNodeA, link.getSource());
		assertSame("Old source does not reference target after undo", createdNodeB.getElement(), createdNodeA.getElement().eGet(metaFeature));
		assertNull("New source references target after undo", createdNodeA1.getElement().eGet(metaFeature));
		assertSame("Link's element is incorrect", createdNodeB.getElement(), link.getElement());

		Node createdNodeB1 = createNode(getGenModel().getNodeB(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNodeB1);
		EditPart b1Ep = findEditPart(createdNodeB1);
		assertNotNull("Could not find editpart for the new target", b1Ep);
		reconnectLink(linkEp, b1Ep, false);
		assertSame("Notation model not updated on reconnecting target", createdNodeB1, link.getTarget());
		assertSame("Source does not reference new target after reconnecting target", createdNodeB1.getElement(), createdNodeA.getElement().eGet(metaFeature));
		assertSame("Link's element is incorrect", createdNodeB1.getElement(), link.getElement());

		getCommandStack().undo();
		assertSame("Notation model inconsistent after undo", createdNodeA, link.getSource());
		assertSame("source does not reference old target after undo", createdNodeB.getElement(), createdNodeA.getElement().eGet(metaFeature));
		assertSame("Link's element is incorrect", createdNodeB.getElement(), link.getElement());
	}

	protected void reconnectLink(ConnectionEditPart linkEP, EditPart elementToReconnectTo, boolean isSourceNotTarget) {
		//TODO: Declare this method in GeneratorConfiguration.ViewerConfiguration, implementation to the LiteGeneratorConfiguration.LiteViewerConfiguration
		ReconnectRequest reconnectRequest = new ReconnectRequest(isSourceNotTarget ? RequestConstants.REQ_RECONNECT_SOURCE : RequestConstants.REQ_RECONNECT_TARGET);
		reconnectRequest.setConnectionEditPart(linkEP);
		reconnectRequest.setLocation(new Point(0,0));
		reconnectRequest.setTargetEditPart(elementToReconnectTo);
		Command command = elementToReconnectTo.getCommand(reconnectRequest);
		assertNotNull("No command for reconnect request", command);
		assertTrue("Reconnect command cannot be executed", command.canExecute());
		execute(command);
	}
}
