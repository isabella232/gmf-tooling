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

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.tests.rt.GeneratedCanvasTest;
import org.eclipse.swt.graphics.RGB;

public class DiagramNodeTest extends GeneratedCanvasTest {

	private final Point myMoveDelta = new Point(10, 20);
	private final Dimension mySizeDelta = new Dimension(100, 50);
	private EditPart myNodeEditPart;

	public DiagramNodeTest(String name) {
		super(name);
	}

	protected EditPart getNodeEditPart() {
		return myNodeEditPart;
	}

	// TODO EditPartViewer[Source|Setup]
	protected void setUp() throws Exception {
		super.setUp();
		myNodeEditPart = findEditPart(getCanvasInstance().getNode());
	}

	public void testChangeBounds() {
		final Point originalLocation = getLocation();
		final Dimension originalSize = getSize();
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
		assertEquals("Location doesn't match one set after [" + assertTag + ']', expectedLocation, getLocation());
		assertEquals("Size doesn't match one set after [" + assertTag + ']', expectedSize, getSize());
	}

	private int getForegroundColor() {
		// @see o.e.g.r.d.ui.GraphicalEditPart#refreshForegroundColor
		LineStyle ls = (LineStyle) getNode().getStyle(NotationPackage.eINSTANCE.getLineStyle());
		return ls.getLineColor();
		//return PresentationResourceManager.getInstance().getColor(new Integer(ls.getLineColor()));
	}

	private int getBackgroundColor() {
		FillStyle fs = (FillStyle) getNode().getStyle(NotationPackage.eINSTANCE.getFillStyle());
		return fs.getFillColor();
		//return PresentationResourceManager.getInstance().getColor(new Integer(fs.getFillColor()));
	}

	private Dimension getSize() {
		Size b = (Size) getNode().getLayoutConstraint();
		return new Dimension(b.getWidth(), b.getHeight());
	}

	private Point getLocation() {
		Location l = (Location) getNode().getLayoutConstraint();
		return new Point(l.getX(), l.getY());
	}

	public void testChangeColors() {
		final int originalBackgroundColor = getBackgroundColor(); 
		final int originalForegroundColor = getForegroundColor();
		
		final int newBackgroundColor = FigureUtilities.RGBToInteger(new RGB(255, 0, 0)).intValue(); // RED
		final int newForegroundColor = FigureUtilities.RGBToInteger(new RGB(0, 255, 255)).intValue(); // CYAN
		assert newBackgroundColor != originalBackgroundColor;
		assert newForegroundColor != originalForegroundColor;

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

	private Command createChangeColorCommand(final int newColor, final boolean isForeground) {
		TransactionalEditingDomain ed = ((IGraphicalEditPart) getNodeEditPart()).getEditingDomain();
		assertNotNull("No TransactionalEditingDomain found", ed);
		return new EtoolsProxyCommand(new AbstractTransactionalCommand(ed, "ChangeColor", Collections.EMPTY_LIST) {
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException  {
				IGraphicalEditPart ep = ((IGraphicalEditPart) getNodeEditPart()); 
				ep.setStructuralFeatureValue(isForeground ? NotationPackage.eINSTANCE.getLineStyle_LineColor() : NotationPackage.eINSTANCE.getFillStyle_FillColor(), new Integer(newColor));
				return null;
			}
		});
	}

	private void assertColorValues(int expectedForegroundColor, int expectedBackgroundColor, String assertTag) {
		assertEquals("Foreground color doesn't match after [" + assertTag + ']', expectedForegroundColor, getForegroundColor());
		assertEquals("Background color doesn't match after [" + assertTag + ']', expectedBackgroundColor, getBackgroundColor());
	}

//	private Request createChangeColorRequest() {
//		return new Request();
//	}

	protected Node getNode() {
		return (Node) getNodeEditPart().getModel();
	}
}
