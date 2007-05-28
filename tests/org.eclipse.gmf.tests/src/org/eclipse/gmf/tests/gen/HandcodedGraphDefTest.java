/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
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

import junit.framework.TestCase;

import org.eclipse.gmf.gmfgraph.ChildAccess;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Ellipse;
import org.eclipse.gmf.gmfgraph.FigureAccessor;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FigureRef;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.tests.setup.DiaDefSetup;

/**
 * @author artem
 */
public class HandcodedGraphDefTest extends TestCase {
	private FigureGallery myGallery;
	private Rectangle myFigureWithLabel;
	private Node myNode;
	private Connection myConnection;
	private ChildAccess myFigureWithLabelAccess;

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
		FigureDescriptor fd = DiaDefSetup.newDescriptor("RF_TLF", myFigureWithLabel);
		myGallery.getDescriptors().add(fd);
		myNode = GMFGraphFactory.eINSTANCE.createNode();
		myNode.setName("N1");
		myNode.setFigure(fd);
		myFigureWithLabelAccess = DiaDefSetup.newAccess(fd, child);

		myConnection = GMFGraphFactory.eINSTANCE.createConnection();
		myConnection.setName("C1");
		PolylineConnection c1 = GMFGraphFactory.eINSTANCE.createPolylineConnection();
		c1.setName("c1fig");
		fd = DiaDefSetup.newDescriptor("c1tlf", c1);
		myGallery.getDescriptors().add(fd);
		myConnection.setFigure(fd);
	}

	public void testGetDescriptor() {
		assertNotNull(myFigureWithLabel.getDescriptor());
		assertEquals(myNode.getFigure(), myFigureWithLabel.getDescriptor());
		assertNotNull(myFigureWithLabel.getChildren().get(0).getDescriptor());
		assertEquals(myNode.getFigure(), myFigureWithLabel.getChildren().get(0).getDescriptor());
		assertNotNull(myConnection.getFigure().getActualFigure().getDescriptor());
	}

	public void testIsLabelExternalLogic() {
		DiagramLabel l = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		Label figure = GMFGraphFactory.eINSTANCE.createLabel();
		figure.setName("LF");
		l.setFigure(DiaDefSetup.newDescriptor("x", figure));
		l.setName("L");
		assertTrue("Label out from figure hierarchy should be treated as external", l.isExternal());
		l.setFigure(myFigureWithLabel.getDescriptor());
		l.setAccessor(myFigureWithLabelAccess);
		assertFalse("Label from figures hierarchy should be treated as internal", l.isExternal());
	}

	public void testGetAccessor() {
		assertNotNull(myFigureWithLabelAccess.getAccessor());
		ChildAccess ca = GMFGraphFactory.eINSTANCE.createChildAccess();
		ca.setAccessor("a1");
		assertEquals("a1", ca.getAccessor());
		//
		Ellipse el = GMFGraphFactory.eINSTANCE.createEllipse();
		ca.setFigure(el);
		assertEquals("a1", ca.getAccessor());
		el.setName("ElliName");
		assertEquals("a1", ca.getAccessor());
		ca.setAccessor("");
		assertEquals("ElliName", ca.getAccessor());
		ca.setFigure(null);
		assertEquals("null", ca.getAccessor());
		//
		FigureRef fr = GMFGraphFactory.eINSTANCE.createFigureRef();
		fr.setFigure(el);
		ca.setFigure(fr);
		assertEquals("ElliName", ca.getAccessor());
		FigureAccessor fa = GMFGraphFactory.eINSTANCE.createFigureAccessor();
		fa.setAccessor("ThroughFA");
		CustomFigure cf = GMFGraphFactory.eINSTANCE.createCustomFigure();
		cf.setQualifiedClassName("org.eclipse.draw2d.IFigure");
		fa.setTypedFigure(cf);
		ca.setFigure(cf);
		assertEquals("ThroughFA", ca.getAccessor());
	}
}
