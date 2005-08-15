/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gef;

import junit.framework.TestCase;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;
import org.eclipse.gmf.diagramrt.DiagramNode;
import org.eclipse.gmf.runtime.gef.ColorSupport;
import org.eclipse.gmf.runtime.gef.commands.ChangeNodeColorCommand;
import org.eclipse.gmf.tests.SessionSetup;
import org.eclipse.gmf.tests.setup.RTSetup;
import org.eclipse.gmf.tests.setup.RTSource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

public class DiagramNodeTest extends TestCase {
	private final Point myMoveDelta = new Point(10, 20);
	private final Dimension mySizeDelta = new Dimension(100, 50);
	private final CommandStack myCommandStack = new CommandStack();
	private EditPart myNodeEditPart;
	private EditPartViewer myViewer;
	private Composite myParentShell;

	public DiagramNodeTest(String name) {
		super(name);
	}

	private EditPart getNodeEditPart() {
		return myNodeEditPart;
	}

	private CommandStack getCommandStack() {
		return myCommandStack;
	}

	protected void setUp() throws Exception {
		super.setUp();
		Bundle b = SessionSetup.getGenProject().getBundle();
		String epFactoryClassName = SessionSetup.getGenModel().getGenDiagram().getEditPartFactoryQualifiedClassName();
		Class epFactory = b.loadClass(epFactoryClassName);
		assert EditPartFactory.class.isAssignableFrom(epFactory);
		myViewer = createViewer();
		myViewer.setEditPartFactory((EditPartFactory) epFactory.newInstance());
		RTSource rtDiagram = new RTSetup().init(SessionSetup.getGenModel());
		myViewer.setContents(rtDiagram.getCanvas());
		myNodeEditPart = (EditPart) myViewer.getEditPartRegistry().get(rtDiagram.getNode());
	}

	private EditPartViewer createViewer() {
		GraphicalViewerImpl gv = new GraphicalViewerImpl();
		myParentShell = new Shell(SWT.NONE);
		gv.createControl(myParentShell);
		return gv;
	}

	protected void tearDown() throws Exception {
		if (myParentShell != null) {
			myParentShell.dispose();
			myParentShell = null;
		}
		super.tearDown();
	}

	public void testChangeBounds() {
		final Point originalLocation = getNode().getLocation();
		final Dimension originalSize = getNode().getSize();
		final Point expectedLocation = originalLocation.getTranslated(myMoveDelta);
		final Dimension expectedNewSize = originalSize.getExpanded(mySizeDelta);
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		// TODO use expectedLocation as fields, and calculate deltas here locally 
		req.setMoveDelta(myMoveDelta);
		req.setSizeDelta(mySizeDelta);
		req.setEditParts(getNodeEditPart());
		req.setResizeDirection(PositionConstants.NORTH_WEST);
		Command cmd = getNodeEditPart().getCommand(req);
		assertNotNull("No resize command", cmd);
		assertTrue("Can't execute resize command", cmd.canExecute());
		getCommandStack().execute(cmd);
		assertBoundValues(expectedLocation, expectedNewSize, "exec");

		assertTrue("Can't undo resize command", getCommandStack().canUndo());
		getCommandStack().undo();
		assertBoundValues(originalLocation, originalSize, "undo");

		assertTrue("Can't redo resize command", getCommandStack().canRedo());
		getCommandStack().redo();
		assertBoundValues(expectedLocation, expectedNewSize, "redo");
	}

	private void assertBoundValues(Point expectedLocation, Dimension expectedSize, String assertTag) {
		assertEquals("Location doesn't match one set after [" + assertTag + ']', expectedLocation, getNode().getLocation());
		assertEquals("Size doesn't match one set after [" + assertTag + ']', expectedSize, getNode().getSize());
	}

	public void testChangeColors() {
		final String originalBackgroundColor = getNode().getBackgroundColor();
		final String originalForegroundColor = getNode().getForegroundColor();
		final String newBackgroundColor = ColorSupport.RED;
		final String newForegroundColor = ColorSupport.CYAN;
		assert !newBackgroundColor.equals(originalBackgroundColor);
		assert !newForegroundColor.equals(originalForegroundColor);

		final Command foreCmd = createChangeColorCommand(newForegroundColor, true);
		assertNotNull("No changeForegroundColor command", foreCmd);
		assertTrue("Can't execute changeForegroundColor command", foreCmd.canExecute());

		getCommandStack().execute(foreCmd);
		assertColorValues(newForegroundColor, originalBackgroundColor, "exec(fore)");

		assertTrue("Can't undo changeForegroundColor command", getCommandStack().canUndo());
		getCommandStack().undo();
		assertColorValues(originalForegroundColor, originalBackgroundColor, "undo(fore)");

		assertTrue("Can't redo changeForegroundColor command", getCommandStack().canRedo());
		getCommandStack().redo();
		assertColorValues(newForegroundColor, originalBackgroundColor, "redo(fore)");

		// after redo, newForeroundColor should be considered as originalForeground
		// unless one change the order of fore/back checks
		final Command backCmd = createChangeColorCommand(newBackgroundColor, false);
		assertNotNull("No changeBackgroundColor command", backCmd);
		assertTrue("Can't execute changeBackgroundColor command", backCmd.canExecute());

		getCommandStack().execute(backCmd);
		assertColorValues(newForegroundColor, newBackgroundColor, "exec(back)");

		assertTrue("Can't undo changeBackgroundColor command", getCommandStack().canUndo());
		getCommandStack().undo();
		assertColorValues(newForegroundColor, originalBackgroundColor, "undo(back)");

		assertTrue("Can't redo changeBackgroundColor command", getCommandStack().canRedo());
		getCommandStack().redo();
		assertColorValues(newForegroundColor, newBackgroundColor, "redo(back)");
	}

	private Command createChangeColorCommand(String newColor, boolean isForeground) {
		// final Request req = createChangeColorRequest();
		// req.setColor(newColor); FIXME
		//return getNodeEditPart().getCommand(foreReq);
		return new ChangeNodeColorCommand(getNode(), newColor, isForeground);
	}

	private void assertColorValues(String expectedForegroundColor, String expectedBackgroundColor, String assertTag) {
		assertEquals("Foreground color doesn't match after [" + assertTag + ']', expectedForegroundColor, getNode().getForegroundColor());
		assertEquals("Background color doesn't match after [" + assertTag + ']', expectedBackgroundColor, getNode().getBackgroundColor());
	}

//	private Request createChangeColorRequest() {
//		return new Request();
//	}

	private DiagramNode getNode() {
		return (DiagramNode) getNodeEditPart().getModel();
	}
}
