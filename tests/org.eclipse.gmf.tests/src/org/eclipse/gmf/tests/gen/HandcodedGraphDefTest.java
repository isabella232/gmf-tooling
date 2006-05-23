/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FigureMarker;
import org.eclipse.gmf.gmfgraph.FigureRef;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.internal.bridge.Knowledge;

import junit.framework.TestCase;

/**
 * @author artem
 */
public class HandcodedGraphDefTest extends TestCase {
	private FigureGallery myGallery;
	private Rectangle myFigureWithLabel;
	private Node myNode;
	private Connection myConnection;

	public HandcodedGraphDefTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		myGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		myGallery.setName("g1");
		myFigureWithLabel = GMFGraphFactory.eINSTANCE.createRectangle();
		myFigureWithLabel.setName("RF");
		Label child = GMFGraphFactory.eINSTANCE.createLabel();
		child.setName("CHLF");
		myFigureWithLabel.getChildren().add(child);
		myGallery.getFigures().add(myFigureWithLabel);
		myNode = GMFGraphFactory.eINSTANCE.createNode();
		myNode.setName("N1");
		myNode.setFigure(myFigureWithLabel);

		myConnection = GMFGraphFactory.eINSTANCE.createConnection();
		myConnection.setName("C1");
		PolylineConnection c1 = GMFGraphFactory.eINSTANCE.createPolylineConnection();
		c1.setName("c1fig");
		myGallery.getFigures().add(c1);
		myConnection.setFigure(c1);
	}

	public void testDerivedNodeFigure() {
		assertNotNull(myNode.getFigure());
		assertNotNull(myNode.getNodeFigure());
		assertEquals(myNode.getFigure(), myNode.getNodeFigure());
	}

	public void testDerivedConnectionFigure() {
		assertNotNull(myConnection.getFigure());
		assertNotNull(myConnection.getConnectionFigure());
		assertEquals(myConnection.getFigure(), myConnection.getConnectionFigure());
	}

	public void testIsLabelExternalLogic() {
		DiagramLabel l = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		Label figure;
		l.setFigure(figure = GMFGraphFactory.eINSTANCE.createLabel());
		l.setName("L");
		figure.setName("LF");
		assertTrue("Label out from figure hierarchy should be treated as external", dgmtSnippetIsExternal(l));
		l.setFigure((Figure) myFigureWithLabel.getChildren().get(0));
		assertFalse("Label from figures hierarchy should be treated as internal", dgmtSnippetIsExternal(l));
	}

	private static boolean dgmtSnippetIsExternal(DiagramLabel element) {
		// Logic from DGMT to decide whether label is external or not 
		return Knowledge.isExternal(element);
	}

	/**
	 * There should be access from child figure/figure ref to parent. This check emerged when parent ref moved 
	 * to FigureMarker, having Figure#children as backref,  which makes us question if this works in respect
	 * of FigureRef, 
	 */
	public void testFigureRefParent() {
		// sanity, make sure parent works for ordinary figures
		assertParentOfFirstChild(myFigureWithLabel);
		
		final Figure figWithRef = GMFGraphFactory.eINSTANCE.createEllipse();
		figWithRef.setName("EF");
		final FigureRef fr = GMFGraphFactory.eINSTANCE.createFigureRef();
		fr.setFigure((Figure) myFigureWithLabel.getChildren().get(0));
		figWithRef.getChildren().add(fr);
		assertParentOfFirstChild(figWithRef);
	}

	private static void assertParentOfFirstChild(Figure figure) {
		final FigureMarker child = (FigureMarker) figure.getChildren().get(0);
		assertNotNull(child.getParent());
		assertEquals(figure, child.getParent());
	}
}
