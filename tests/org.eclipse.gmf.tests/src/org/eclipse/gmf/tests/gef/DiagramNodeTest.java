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

import java.util.Iterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.gmfgraph.Color;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.Font;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.rt.GeneratedCanvasTest;
import org.eclipse.gmf.tests.setup.DiaDefSetup;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.figures.GenericFigureCheck;
import org.eclipse.swt.graphics.RGB;

/**
 * TODO: Currently this class mixes two different sorts of test:
 * 
 * 1. Tests sending some requests to the editparts and executing returned
 * commands
 * 
 * 2. Tests checking the propagation of some properties from .gmfgraph to the
 * code + interaction of these properties with corresponding notation layer
 * properties (styles)
 * 
 * Tests from the second cathegory should be moved into the separated test set
 * (joined with the tests from CompartmentPropertiesTest?) Special SessionSetup
 * should be created for this type of tests setting corresponding properties for
 * the links/labels before code generation. Following tests should be moved there:
 * 
 * - testNotColoredLink 
 * - testColoredLink 
 * - testLabelFonts
 */
public class DiagramNodeTest extends GeneratedCanvasTest {
	private final GenericFigureCheck.ColorTransformer ourColorTransformer = new GenericFigureCheck.ColorTransformer();
	private final Point myMoveDelta = new Point(10, 20);
	private final Dimension mySizeDelta = new Dimension(100, 50);

	public DiagramNodeTest(String name) {
		super(name);
	}
	
	public void testCanCreateLink(){
		View nodeA = getNotation(getNodeEditPartA());
		View nodeB = getNotation(getNodeEditPartB());
		ConnectionEditPart linkByClass = createAndCheckLink(nodeA, nodeB, getSetup().getGenModel().getLinkC());
		assertNotNull(linkByClass);

		//there is already linkByRef between a and b, use new target
		nodeB = createNode(getSetup().getGenModel().getNodeB(), getDiagram());
		ConnectionEditPart linkByRef = createAndCheckLink(nodeA, nodeB, getSetup().getGenModel().getLinkD());
		assertNotNull(linkByRef);
	}
	
	public void testNotColoredLink(){
		View nodeA = getNotation(getNodeEditPartA());
		View nodeB = getNotation(getNodeEditPartB());
		ConnectionEditPart linkByClass = createAndCheckLink(nodeA, nodeB, getSetup().getGenModel().getLinkC());
		checkLinkColor(linkByClass, getSetup().getMapModel().getClassLink().getDiagramLink());
	}
	
	public void testColoredLink(){
		View nodeA = createNode(getSetup().getGenModel().getNodeA(), getDiagram());
		View nodeB = createNode(getSetup().getGenModel().getNodeB(), getDiagram());
		ConnectionEditPart linkByRef = createAndCheckLink(nodeA, nodeB, getSetup().getGenModel().getLinkD());
		checkLinkColor(linkByRef, getSetup().getMapModel().getReferenceLink().getDiagramLink());
	}
	
	public void testLabelFonts(){
		class FontChecker extends GenericFigureCheck {
			public FontChecker(){
				super(null);
			}
			
			public void createAndCheckLabels(GenNode prototype, DiagramLabel eLabel, View notationContainer){
				assertFalse(prototype.getLabels().isEmpty());
				View node = createNode(prototype, notationContainer);
				for (Iterator allLabels = prototype.getLabels().iterator(); allLabels.hasNext();){
					GenLabel nextLabelType = (GenLabel)allLabels.next();
					View notationLabel = findChildView(node, nextLabelType);
					assertNotNull(notationLabel);
					GraphicalEditPart labelEditPart = (GraphicalEditPart) findEditPart(notationLabel);
					assertNotNull(labelEditPart);
					checkFont(labelEditPart, (Figure)eLabel.getFigure());
				}
			}
			
			public void checkFont(GraphicalEditPart editPart, Figure eFigure) {
				IFigure d2dFgure = editPart.getFigure();
				assertNotNull(d2dFgure);
				
				Font font = eFigure.getFont();
				if (font == null){
					font = getViewerConfiguration().getDefaultFont();
				}
				
				checkFont(font, d2dFgure.getFont());
			}
		}
		
		FontChecker fontChecker = new FontChecker();
		
		DiaGenSource gmfGen = getSetup().getGenModel();
		DiaDefSetup gmfGraph = (DiaDefSetup)getSetup().getGraphDefModel();
		
// [AS]: Temporary disabling the test with default font because of some problems on builder.
//		fontChecker.createAndCheckLabels(gmfGen.getNodeA(), gmfGraph.getLabelDef(), getDiagram());
		fontChecker.createAndCheckLabels(gmfGen.getNodeB(), gmfGraph.getDecoratedLabelDef(), getDiagram());
	}
	
	private ConnectionEditPart createAndCheckLink(View source, View target, GenLink genLinkType){
		Edge newLink = createLink(genLinkType, source, target);
		assertNotNull(newLink);
		assertEquals(source, newLink.getSource());
		assertEquals(target, newLink.getTarget());
		
		getDiagramEditPart().refresh();
		
		ConnectionEditPart newLinkEditPart = (ConnectionEditPart) findEditPart(newLink);
		assertNotNull(newLinkEditPart);
		return newLinkEditPart;
	}
	
	private void checkLinkColor(ConnectionEditPart newLinkEditPart, Connection gmfGraphConnection){
		IFigure actual = newLinkEditPart.getFigure();
		assertTrue(actual instanceof PolylineConnection);
		Figure gmfFigure = (Figure)gmfGraphConnection.getFigure();
		Color gmfColor = gmfFigure.getForegroundColor();
		RGB expectedRGB = gmfColor == null ? getViewerConfiguration().getDefaultLinkColor() : ourColorTransformer.gmf2swt(gmfColor);
		assertEquals(expectedRGB, actual.getForegroundColor().getRGB());
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

// Tests for Notation Model hierarchy
	public void testCreateTopLevelNodeNotationElements() {
		GenNode genNode = getSetup().getGenModel().getNodeA();
		Node node = createNode(genNode, getCanvasInstance().getCanvas());
		assertNotNull("Notation model Node was not created", node);
	
		for (Iterator it = genNode.getLabels().iterator(); it.hasNext();) {
			GenNodeLabel nextLabel = (GenNodeLabel) it.next();
			assertNotNull("Notation model element was not created for label: " + nextLabel.getVisualID(), findChildView(node, nextLabel));
		}
		
		for (Iterator it = genNode.getCompartments().iterator(); it.hasNext();) {
			GenCompartment nextCompartment = (GenCompartment) it.next();
			assertNotNull("Notation model element was not created for compartment: " + nextCompartment.getVisualID(), findChildView(node, nextCompartment));			
		}
	}
	
	public void testCreateLeafChildNodeNotationElements() {
		GenNode nodeA = getSetup().getGenModel().getNodeA();
		assertTrue("Incorrect Setup: passed node has no compartments", nodeA.getCompartments().size() > 0);
		GenCompartment genCompartment = (GenCompartment) nodeA.getCompartments().get(0);
		assertTrue("Incorrect Setup: passed node has no children", genCompartment.getChildNodes().size() > 1);

		GenNode leafGenChildNodeLabelOnly = (GenNode) genCompartment.getChildNodes().get(1);
		assertTrue("Incorrect Setup: specified childNode is not leaf label-only node", leafGenChildNodeLabelOnly.getChildNodes().size() == 0);
		assertTrue("Incorrect Setup: specified childNode is not leaf label-only node", leafGenChildNodeLabelOnly.getCompartments().size() == 0);
		assertTrue("Incorrect Setup: specified childNode is not leaf label-only node", leafGenChildNodeLabelOnly.getLabels().size() == 0);
		assertTrue("Incorrect Setup: specified childNode is not leaf label-only node", leafGenChildNodeLabelOnly instanceof GenChildLabelNode);
		Node leafNode = createNode(leafGenChildNodeLabelOnly, getCanvasInstance().getNodeACompartment());
		assertNotNull("Node was not created", leafNode);
		assertTrue("Leaf node has children", leafNode.getChildren().size() == 0);

		GenNode leafGenChildNode = (GenNode) genCompartment.getChildNodes().get(0);
		assertTrue("Incorrect Setup: specified childNode is not leaf node", leafGenChildNode.getChildNodes().size() == 0);
		assertTrue("Incorrect Setup: specified childNode is not leaf node", leafGenChildNode.getCompartments().size() == 0);
		leafNode = createNode(leafGenChildNode, getCanvasInstance().getNodeACompartment());
		assertNotNull("Node was not created", leafNode);
		for (Iterator it = leafGenChildNode.getLabels().iterator(); it.hasNext();) {
			GenLabel nextLabel = (GenLabel) it.next();
			assertNotNull("Notation model element was not created for label: " + nextLabel.getVisualID(), findChildView(leafNode, nextLabel));
		}
	}
	
	public void testCreateInnerChildNodeNotationElements() {
		GenNode nodeB = getSetup().getGenModel().getNodeB();
		assertTrue("Incorrect Setup: passed node has no compartments", nodeB.getCompartments().size() > 0);
		GenCompartment genCompartment = (GenCompartment) nodeB.getCompartments().get(0);
		assertTrue("Incorrect Setup: passed node has no children", genCompartment.getChildNodes().size() > 0);

		GenNode childNode = (GenNode) genCompartment.getChildNodes().get(0);
		assertTrue("Incorrect Setup: specified childNode is not level-1 child node", childNode.getCompartments().size() > 0);
		GenCompartment childNodeCompartment = (GenCompartment) childNode.getCompartments().get(0);
		assertTrue("Incorrect Setup: specified childNode is not level-1 child node", childNodeCompartment.getChildNodes().size() > 0);
		
		Node level1Child = createNode(childNode, getCanvasInstance().getNodeBCompartment());
		assertNotNull("Level1 ChildNode was not created", level1Child);
		View level1Compartment = findChildView(level1Child, (GenCommonBase) childNode.getCompartments().get(0));
		assertNotNull("Level1 Compartment was not created", level1Compartment);
		
		GenNode recursiveChildNode = (GenNode) childNodeCompartment.getChildNodes().get(0);
		assertTrue("Incorrect Setup: specified childNode is not recursive child node", recursiveChildNode.getChildNodes().size() == 0);
		assertTrue("Incorrect Setup: specified childNode is not recursive child node", recursiveChildNode.getCompartments().size() == 1);
		GenCompartment recursiveChildNodeCompartment = (GenCompartment) childNode.getCompartments().get(0);
		assertTrue("Incorrect Setup: specified childNode is not recursive child node", recursiveChildNodeCompartment.getChildNodes().size() > 0);
		assertTrue("Incorrect Setup: specified childNode is not recursive child node", recursiveChildNodeCompartment.getChildNodes().get(0) == recursiveChildNode);

		Node level2Child = createNode(recursiveChildNode, level1Compartment);
		assertNotNull("Level2 ChildNode was not created", level2Child);
		View level2Compartment = findChildView(level2Child, (GenCommonBase) recursiveChildNode.getCompartments().get(0));
		assertNotNull("Level1 Compartment was not created", level2Compartment);

		Node level3Child = createNode(recursiveChildNode, level2Compartment);
		assertNotNull("Level2 ChildNode was not created", level3Child);
		View level3Compartment = findChildView(level3Child, (GenCommonBase) recursiveChildNode.getCompartments().get(0));
		assertNotNull("Level1 Compartment was not created", level3Compartment);
	}
	

// TODO: Uncomment this test once child nodes without compartments will be supposred in lite generator
//	public void testCreateChildNodeNotWithinCompartment() {
//		assertTrue("Incorrect Setup: GenModel with only two nodes", getSetup().getGenModel().getGenDiagram().getTopLevelNodes().size() > 2);
//		GenNode genNodeC = (GenNode) getSetup().getGenModel().getGenDiagram().getTopLevelNodes().get(2);
//		assertFalse("Incorrect Setup: passed node has compartments", genNodeC.getCompartments().size() > 0);
//		assertTrue("Incorrect Setup: passed node has no children", genNodeC.getChildNodes().size() > 0);
//
//		GenNode genChildNode = (GenNode) genNodeC.getChildNodes().get(0);
//
//		Node topLevelNode = createNode(genNodeC, getDiagram());
//		assertNotNull("Top level node was not created", topLevelNode);
//		assertTrue("Incorrect number of top-level node children was created", genNodeC.getLabels().size() == topLevelNode.getChildren().size());
//		for (Iterator it = genNodeC.getLabels().iterator(); it.hasNext();) {
//			GenNodeLabel nextLabel = (GenNodeLabel) it.next();
//			assertNotNull("Notation model element was not created for label: " + nextLabel.getVisualID(), findChildView(topLevelNode, nextLabel));
//		}
//		
//		Node childNode = createNode(genChildNode, topLevelNode);
//		assertNotNull("Child node without compartment was not created", childNode);
//	}
	
}
