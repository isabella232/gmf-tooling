/**
 * Copyright (c) 2006, 2007 Borland Software Corporation
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

import java.util.Iterator;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.gef.AbstractDiagramEditorTest;
import org.eclipse.gmf.tests.lite.setup.LibraryConstrainedSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.ui.PlatformUI;

public class ExternalNodeLabelsTest extends AbstractDiagramEditorTest {
	public ExternalNodeLabelsTest(String name) {
		super(name);
		PlatformUI.getWorkbench().getEditorRegistry();
	}

	@Override
	protected SessionSetup createDefaultSetup() {
		return LibraryConstrainedSetup.getInstance();
	}

	public void testExternalNodeLabelsPosition() throws Exception {
		GenNode nodeB = getSetup().getGenModel().getNodeB();
		GenExternalNodeLabel firstExternalNodeLabel = getFirstExternalNodeLabel(nodeB);
		assertNotNull("Incorrect setup: expected ", firstExternalNodeLabel);
		Node nodeBInstance = createNode(nodeB, getDiagram());
		View extLabelInstance = findChildView(nodeBInstance, firstExternalNodeLabel);
		assertTrue("External node label was not created automatically", extLabelInstance instanceof Node);
		GraphicalEditPart nodeBEP = (GraphicalEditPart) findEditPart(nodeBInstance);
		assertNotNull(nodeBEP);
		GraphicalEditPart extLabelEP = (GraphicalEditPart) findEditPart(extLabelInstance);
		assertNotNull(extLabelEP);
		((GraphicalEditPart)getViewerConfiguration().getViewer().getRootEditPart()).getFigure().validate();
		checkExternalNodeLabelBounds(nodeBEP, extLabelEP);

		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setMoveDelta(new Point(5, 5));
		req.setSizeDelta(new Dimension(7, 7));
		req.setEditParts(nodeBEP);
		req.setResizeDirection(PositionConstants.NORTH_WEST);
		Command cmd = nodeBEP.getCommand(req);
		assertNotNull("No resize command", cmd);
		assertTrue("Can't execute resize command", cmd.canExecute());
		getCommandStack().execute(cmd);
		((GraphicalEditPart)getViewerConfiguration().getViewer().getRootEditPart()).getFigure().validate();
		checkExternalNodeLabelBounds(nodeBEP, extLabelEP);

		req.setMoveDelta(new Point(0, 0));
		req.setSizeDelta(new Dimension(7, 7));
		req.setEditParts(nodeBEP);
		req.setResizeDirection(PositionConstants.SOUTH_EAST);
		cmd = nodeBEP.getCommand(req);
		assertNotNull("No resize command", cmd);
		assertTrue("Can't execute resize command", cmd.canExecute());
		getCommandStack().execute(cmd);
		checkExternalNodeLabelBounds(nodeBEP, extLabelEP);
	}

	private void checkExternalNodeLabelBounds(GraphicalEditPart nodeEP, GraphicalEditPart extLabelEP) {
		Rectangle nodeBounds = nodeEP.getFigure().getBounds();
		Rectangle labelBounds = extLabelEP.getFigure().getBounds();
		Node extLabelNode = (Node) extLabelEP.getModel();
		Location location = (Location) extLabelNode.getLayoutConstraint();
		assertNotNull("External label does not have layout constraint", location);
		Dimension tolerance = labelBounds.getSize().scale(1.0/3.0);
		Point nodeBottom = nodeBounds.getBottom();
		Point labelTop = labelBounds.getTop();
		assertEquals("Unexpected position of external node label", nodeBottom.x + location.getX(), labelTop.x, tolerance.width);
		assertEquals("Unexpected position of external node label", nodeBottom.y + location.getY(), labelTop.y, tolerance.height);
	}

	@SuppressWarnings("unchecked")
	private GenExternalNodeLabel getFirstExternalNodeLabel(GenNode genNode) {
		for(Iterator it = genNode.getLabels().iterator(); it.hasNext(); ) {
			GenNodeLabel next = (GenNodeLabel) it.next();
			if (next instanceof GenExternalNodeLabel) {
				return (GenExternalNodeLabel) next;
			}
		}
		return null;
	}

	public void testExternalNodeLabelsWithZoom() throws Exception {
		ZoomManager zoomManager = (ZoomManager) getDiagramEditPart().getViewer().getProperty(ZoomManager.class.toString());
		assertNotNull(zoomManager);
		zoomManager.setZoom(4.0);
		testExternalNodeLabelsPosition();
	}

	public void testCompartmentCollapsibility() throws Exception {
		GenNode nodeB = getSetup().getGenModel().getNodeB();
		assertTrue("Incorrect Setup: passed node has no compartments", nodeB.getCompartments().size() > 0);
		GenCompartment genCompartment = (GenCompartment) nodeB.getCompartments().get(0);
		assertTrue("Incorrect Setup: passed node has no children", genCompartment.getChildNodes().size() > 0);

		GenNode childNode = (GenNode) genCompartment.getChildNodes().get(0);

		Node nodeBInstance = createNode(nodeB, getDiagram());
		
		Node nodeBCompartment = (Node) findChildView(nodeBInstance, genCompartment);
		assertNotNull("Failed to find the compartment", nodeBCompartment);
		DrawerStyle drawerStyle = (DrawerStyle) nodeBCompartment.getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
		assertNotNull("Drawer style not added automatically", drawerStyle);
		assertFalse("Compartment should be expanded by default", drawerStyle.isCollapsed());

		Node level1Child = createNode(childNode, nodeBCompartment);
		assertNotNull("Child not created", level1Child);
		assertTrue(nodeBCompartment.getChildren().contains(level1Child));

		EditPart compartmentEP = findEditPart(nodeBCompartment);
		assertNotNull("Edit part for compartment is missing", compartmentEP);
		EditPart childEP = findEditPart(level1Child);
		assertNotNull("Edit part for child is missing", childEP);
		assertTrue("Edit part for child is inactive", childEP.isActive());
		assertSame("Unexpected parent of the child edit part", compartmentEP, childEP.getParent());

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(drawerStyle);
		org.eclipse.emf.common.command.Command command = SetCommand.create(domain, drawerStyle, NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), Boolean.TRUE);
		assertTrue("Failed to obtain command to collapse the compartment", command != null && command.canExecute());
		new EMFCommandOperation(domain, command).execute(new NullProgressMonitor(), null);
		assertTrue("Compartment failed to collapse", drawerStyle.isCollapsed());
		assertNotNull("Collapsing compartment should not have removed the view", level1Child.eResource());
		assertFalse("Collapsing compartment should have removed the child edit part", childEP.isActive());
		childEP = findEditPart(level1Child);
		assertNull("Collapsing compartment should have made the child edit part go away", childEP);

		command = SetCommand.create(domain, drawerStyle, NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), Boolean.FALSE);
		assertTrue("Failed to obtain command to expand the compartment", command != null && command.canExecute());
		new EMFCommandOperation(domain, command).execute(new NullProgressMonitor(), null);
		assertFalse("Compartment failed to expand", drawerStyle.isCollapsed());
		assertNotNull("Expanding compartment should not have done anything to the view", level1Child.eResource());
		childEP = findEditPart(level1Child);
		assertTrue("Expanding compartment should have made the child edit part to reappear", childEP.isActive());
	}
}
