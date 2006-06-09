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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.swt.graphics.RGB;

public class DiagramNodeTest extends DiagramTestBase {

	private final Point myMoveDelta = new Point(10, 20);
	private final Dimension mySizeDelta = new Dimension(100, 50);

	public DiagramNodeTest(String name) {
		super(name);
	}

	public void testChangeBounds() {
		final EditPart editPart = getNodeEditPartA();
		final Node notation = getNotation(editPart);
		
		final Point originalLocation = getLocation(notation);
		final Dimension originalSize = getSize(notation);
		final Point expectedLocation = originalLocation.getTranslated(myMoveDelta);
		final Dimension expectedNewSize = originalSize.getExpanded(mySizeDelta);
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		// TODO use expectedLocation as fields, and calculate deltas here locally 
		req.setMoveDelta(myMoveDelta);
		req.setSizeDelta(mySizeDelta);
		req.setEditParts(editPart);
		req.setResizeDirection(PositionConstants.NORTH_WEST);
		Command cmd = editPart.getCommand(req);
		assertNotNull("No resize command", cmd);
		assertTrue("Can't execute resize command", cmd.canExecute());
		getCommandStack().execute(cmd);
		assertBoundValues(notation, expectedLocation, expectedNewSize, "exec");

		assertTrue("Can't undo resize command", getCommandStack().canUndo());
		getCommandStack().undo();
		assertBoundValues(notation, originalLocation, originalSize, "undo");

		assertTrue("Can't redo resize command", getCommandStack().canRedo());
		getCommandStack().redo();
		assertBoundValues(notation, expectedLocation, expectedNewSize, "redo");
	}
	
	private void assertBoundValues(Node notation, Point expectedLocation, Dimension expectedSize, String assertTag) {
		assertEquals("Location doesn't match one set after [" + assertTag + ']', expectedLocation, getLocation(notation));
		assertEquals("Size doesn't match one set after [" + assertTag + ']', expectedSize, getSize(notation));
	}

	private int getForegroundColor(Node notation) {
		// @see o.e.g.r.d.ui.GraphicalEditPart#refreshForegroundColor
		LineStyle ls = (LineStyle) notation.getStyle(NotationPackage.eINSTANCE.getLineStyle());
		return ls.getLineColor();
		//return PresentationResourceManager.getInstance().getColor(new Integer(ls.getLineColor()));
	}

	private int getBackgroundColor(Node notation) {
		FillStyle fs = (FillStyle) notation.getStyle(NotationPackage.eINSTANCE.getFillStyle());
		return fs.getFillColor();
		//return PresentationResourceManager.getInstance().getColor(new Integer(fs.getFillColor()));
	}

	private Dimension getSize(Node notation) {
		Size b = (Size) notation.getLayoutConstraint();
		return new Dimension(b.getWidth(), b.getHeight());
	}

	private Point getLocation(Node notation) {
		Location l = (Location) notation.getLayoutConstraint();
		return new Point(l.getX(), l.getY());
	}

	public void testChangeColors() {
		final Node notation = getNotation(getNodeEditPartA());
		
		final int originalBackgroundColor = getBackgroundColor(notation); 
		final int originalForegroundColor = getForegroundColor(notation);
		
		final int newBackgroundColor = FigureUtilities.RGBToInteger(new RGB(255, 0, 0)).intValue(); // RED
		final int newForegroundColor = FigureUtilities.RGBToInteger(new RGB(0, 255, 255)).intValue(); // CYAN
		assert newBackgroundColor != originalBackgroundColor;
		assert newForegroundColor != originalForegroundColor;

		final Command foreCmd = createChangeColorCommand(notation, newForegroundColor, true);
		assertNotNull("No changeForegroundColor command", foreCmd);
		assertTrue("Can't execute changeForegroundColor command", foreCmd.canExecute());

		getCommandStack().execute(foreCmd);
		assertColorValues(notation, newForegroundColor, originalBackgroundColor, "exec(fore)");

		assertTrue("Can't undo changeForegroundColor command", getCommandStack().canUndo());
		getCommandStack().undo();
		assertColorValues(notation, originalForegroundColor, originalBackgroundColor, "undo(fore)");

		assertTrue("Can't redo changeForegroundColor command", getCommandStack().canRedo());
		getCommandStack().redo();
		assertColorValues(notation, newForegroundColor, originalBackgroundColor, "redo(fore)");

		// after redo, newForeroundColor should be considered as originalForeground
		// unless one change the order of fore/back checks
		final Command backCmd = createChangeColorCommand(notation, newBackgroundColor, false);
		assertNotNull("No changeBackgroundColor command", backCmd);
		assertTrue("Can't execute changeBackgroundColor command", backCmd.canExecute());

		getCommandStack().execute(backCmd);
		assertColorValues(notation, newForegroundColor, newBackgroundColor, "exec(back)");

		assertTrue("Can't undo changeBackgroundColor command", getCommandStack().canUndo());
		getCommandStack().undo();
		assertColorValues(notation, newForegroundColor, originalBackgroundColor, "undo(back)");

		assertTrue("Can't redo changeBackgroundColor command", getCommandStack().canRedo());
		getCommandStack().redo();
		assertColorValues(notation, newForegroundColor, newBackgroundColor, "redo(back)");
	}

	private Command createChangeColorCommand(Node notation, final int newColor, final boolean isForeground) {
		return getViewerConfiguration().getSetNotationalElementStructuralFeature(notation, 
				isForeground ? NotationPackage.eINSTANCE.getLineStyle_LineColor() : NotationPackage.eINSTANCE.getFillStyle_FillColor(), 
				new Integer(newColor));
	}

	private void assertColorValues(Node notation, int expectedForegroundColor, int expectedBackgroundColor, String assertTag) {
		assertEquals("Foreground color doesn't match after [" + assertTag + ']', expectedForegroundColor, getForegroundColor(notation));
		assertEquals("Background color doesn't match after [" + assertTag + ']', expectedBackgroundColor, getBackgroundColor(notation));
	}

}
