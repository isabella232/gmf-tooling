/**
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.svg;

import java.awt.geom.Rectangle2D;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.lite.svg.SVGFigure;
import org.eclipse.swt.graphics.RGB;

public class SVGFigureTest extends AbstractSVGFigureTest {

	public SVGFigureTest(String name) {
		super(name);
	}

	/**
	 * Check that test canvas is available.
	 */
	public void testCanvasSetup() {
		paintImage();
		Dimension size = getParentFigure().getSize();
		assertEquals(size.width, 200);
		assertEquals(size.height, 200);
		assertColor(0, 0, ColorConstants.green.getRGB());
		assertColor(1, 1, ColorConstants.yellow.getRGB());
		assertColor(100, 100, ColorConstants.yellow.getRGB());
		assertColor(198, 198, ColorConstants.yellow.getRGB());
		assertColor(199, 199, ColorConstants.green.getRGB());
	}

	/**
	 * Check that SVGFigure loads documents.
	 */
	public void testDocumentLoading() {
		SVGFigure f = new SVGFigure();
		f.setURI(BOX_URI);
		assertTrue(f.checkContentAvailable());
	}

	/**
	 * Check that SVGFigure renders documents.
	 */
	public void testRendering() {
		SVGFigure f = new SVGFigure();
		f.setURI(BOX_URI);
		f.setPreferredSize(50, 50);
		getParentFigure().add(f);
		paintImage();
		assertColor(0, 0, new RGB(0, 0, 0));
		assertColor(1, 1, new RGB(0x66, 0x33, 0));
		assertColor(48, 48, new RGB(0x66, 0x33, 0));
		assertColor(49, 49, new RGB(0, 0, 0));
		assertColor(25, 50, ColorConstants.yellow.getRGB());
		assertColor(50, 25, ColorConstants.yellow.getRGB());
	}

	/**
	 * Check that SVGFigure respects client area.
	 */
	public void testClientArea() {
		SVGFigure f = new SVGFigure();
		f.setURI(BOX_URI);
		f.setPreferredSize(90, 90);
		f.setBorder(new MarginBorder(20));
		getParentFigure().add(f);
		paintImage();
		assertColor(19, 19, ColorConstants.yellow.getRGB());
		assertColor(20, 20, new RGB(0, 0, 0));
		assertColor(21, 21, new RGB(0x66, 0x33, 0));
	}

	/**
	 * Check that SVGFigure respects AOI.
	 */
	public void testAreaOfInterest() {
		SVGFigure f = new SVGFigure();
		f.setURI(GROUP_URI);
		f.setAreaOfInterest(new Rectangle2D.Float(20f, 20f, 20f, 20f));
		f.setPreferredSize(20, 20);
		getParentFigure().add(f);
		paintImage();
		assertColor(0, 0, new RGB(0, 0, 0xFF));
		assertColor(1, 1, new RGB(0xFF, 0, 0));
		assertColor(18, 18, new RGB(0xFF, 0, 0));
		assertColor(19, 19, new RGB(0, 0, 0xFF));
		assertColor(19, 20, ColorConstants.yellow.getRGB());
		assertColor(20, 19, ColorConstants.yellow.getRGB());
	}
}
