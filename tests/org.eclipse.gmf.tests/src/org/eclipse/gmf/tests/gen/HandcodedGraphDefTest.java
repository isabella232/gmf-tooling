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

import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FigureMarker;
import org.eclipse.gmf.gmfgraph.FigureRef;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.Rectangle;

import junit.framework.TestCase;

/**
 * @author artem
 */
public class HandcodedGraphDefTest extends TestCase {
	private FigureGallery myGallery;
	private Rectangle myFigureWithLabel;

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
	}

	public void testIsLabelExternalLogic() {
		DiagramLabel l = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		l.setFigure(GMFGraphFactory.eINSTANCE.createLabel());
		l.setName("L");
		l.getFigure().setName("LF");
		assertTrue("Label out from figure hierarchy should be treated as external", dgmtSnippetIsExternal(l));
		l.setFigure((Figure) myFigureWithLabel.getChildren().get(0));
		assertFalse("Label from figures hierarchy should be treated as internal", dgmtSnippetIsExternal(l));
	}

	private static boolean dgmtSnippetIsExternal(DiagramElement element) {
		// Logic from DGMT to decide whether label is external or not 
		return element.getFigure().getParent() == null;
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
