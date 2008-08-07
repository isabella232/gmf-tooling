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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.SVGProperty;
import org.eclipse.gmf.gmfgraph.SVGPropertyType;
import org.eclipse.gmf.runtime.lite.svg.SVGFigure;
import org.eclipse.gmf.tests.setup.figures.AbstractFigureGeneratorSetup;
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public class GeneratedSVGFigureTest extends AbstractSVGFigureTest {

	public GeneratedSVGFigureTest(String name) {
		super(name);
	}

	private AbstractFigureGeneratorSetup getSessionSetup(final org.eclipse.gmf.gmfgraph.SVGFigure f) {
		return new AbstractFigureGeneratorSetup() {

			@Override
			protected void addFigures(FigureGallery gallery) {
				gallery.setImplementationBundle("org.eclipse.gmf.runtime.lite.svg");
				gallery.getFigures().add(f);
			}
		};
	}

	protected SVGFigure createDraw2DFigure(Class<?> figureClass) {
		Object result = null;
		try {
			result = figureClass.newInstance();
		} catch (Exception e) {
			fail(e.getClass().getSimpleName() + ": " + e.getMessage());
		}
		assertTrue(figureClass.getName(), result instanceof SVGFigure);
		return (SVGFigure) result;
	}

	protected SVGFigure createDraw2DFigure(org.eclipse.gmf.gmfgraph.SVGFigure f) {
		AbstractFigureGeneratorSetup ss = getSessionSetup(f);
		FigureGeneratorUtil.generateAndParse(f);
		Class<?> fClass = ss.getFigureClass(f);
		return createDraw2DFigure(fClass);
	}

	/**
	 * Check that SVGFigure generates.
	 */
	public void testBasicGeneration() {
		org.eclipse.gmf.gmfgraph.SVGFigure f = GMFGraphFactory.eINSTANCE.createSVGFigure();
		f.setName("Crate");
		f.setDocumentURI(BOX_URI);
		SVGFigure f2d = createDraw2DFigure(f);
		assertEquals(BOX_URI, f2d.getURI());
		// Check default values
		assertFalse(f2d.isSafeRendering());
		assertNull(f2d.getAreaOfInterest());
	}

	/**
	 * Check advanced properties of SVGFigure (AOI, safe rendering).
	 */
	public void testAdvancedProperties() {
		org.eclipse.gmf.gmfgraph.SVGFigure f = GMFGraphFactory.eINSTANCE.createSVGFigure();
		f.setName("Crate");
		f.setDocumentURI(BOX_URI);
		f.setSafeRendering(true);
		f.setAreaOfInterest(GMFGraphFactory.eINSTANCE.createRectangle2D());
		f.getAreaOfInterest().setX(10f);
		f.getAreaOfInterest().setY(0.5f);
		f.getAreaOfInterest().setWidth(555f);
		f.getAreaOfInterest().setHeight(44.4f);
		SVGFigure f2d = createDraw2DFigure(f);
		assertEquals(BOX_URI, f2d.getURI());
		assertTrue(f2d.isSafeRendering());
		Rectangle2D aoi = f2d.getAreaOfInterest();
		assertNotNull(aoi);
		assertEquals(10f, (float) aoi.getX());
		assertEquals(0.5f, (float) aoi.getY());
		assertEquals(555f, (float) aoi.getWidth());
		assertEquals(44.4f, (float) aoi.getHeight());
	}

	/**
	 * Check that string property generates and actually works.
	 */
	public void testStringProperty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		org.eclipse.gmf.gmfgraph.SVGFigure f = GMFGraphFactory.eINSTANCE.createSVGFigure();
		f.setName("Crate");
		f.setDocumentURI(BOX_URI);
		SVGProperty p = GMFGraphFactory.eINSTANCE.createSVGProperty();
		p.setQuery("//:rect");
		p.setAttribute("width");
		p.setGetter("getA");
		p.setSetter("setA");
		// String type is the default
		f.getProperties().add(p);
		SVGFigure f2d = createDraw2DFigure(f);
		Method getter = f2d.getClass().getMethod("getA");
		Method setter = f2d.getClass().getMethod("setA", String.class);
		// Check initial value 49
		String v = (String) getter.invoke(f2d);
		assertEquals("49", v);
		// Check that modification works
		setter.invoke(f2d, "23");
		v = (String) getter.invoke(f2d);
		assertEquals("23", v);
	}

	/**
	 * Check that color property generates and actually works.
	 */
	public void testColorProperty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		org.eclipse.gmf.gmfgraph.SVGFigure f = GMFGraphFactory.eINSTANCE.createSVGFigure();
		f.setName("Crate");
		f.setDocumentURI(BOX_URI);
		SVGProperty p = GMFGraphFactory.eINSTANCE.createSVGProperty();
		p.setQuery("//:rect");
		p.setAttribute("fill");
		p.setGetter("getBackgroundColorX"); // Preserve original getter to check that 'callSuper' works
		p.setSetter("setBackgroundColor");
		p.setCallSuper(true);
		p.setType(SVGPropertyType.COLOR);
		f.getProperties().add(p);
		SVGFigure f2d = createDraw2DFigure(f);
		Method getter = f2d.getClass().getMethod("getBackgroundColorX");
		// Check initial value
		Color v = (Color) getter.invoke(f2d);
		assertEquals(new RGB(0x66, 0x33, 0), v.getRGB());
		// Check that modification works
		f2d.setBackgroundColor(new Color(null, 0xFF, 0x55, 0));
		assertEquals(new RGB(0xFF, 0x55, 0), f2d.getBackgroundColor().getRGB()); // Check Draw2d
		v = (Color) getter.invoke(f2d);
		assertEquals(new RGB(0xFF, 0x55, 0), v.getRGB()); // Check SVG DOM
	}

	/**
	 * Check that float property generates and actually works.
	 */
	public void testFloatProperty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		org.eclipse.gmf.gmfgraph.SVGFigure f = GMFGraphFactory.eINSTANCE.createSVGFigure();
		f.setName("Crate");
		f.setDocumentURI(BOX_URI);
		SVGProperty p = GMFGraphFactory.eINSTANCE.createSVGProperty();
		p.setQuery("//:line[5]");
		p.setAttribute("x1");
		p.setGetter("getX");
		p.setSetter("setX");
		p.setType(SVGPropertyType.FLOAT);
		f.getProperties().add(p);
		SVGFigure f2d = createDraw2DFigure(f);
		Method getter = f2d.getClass().getMethod("getX");
		Method setter = f2d.getClass().getMethod("setX", Float.TYPE);
		// Check initial value 30
		float v = (Float) getter.invoke(f2d);
		assertEquals(30f, v);
		// Check that modification works
		setter.invoke(f2d, 23f);
		v = (Float) getter.invoke(f2d);
		assertEquals(23f, v);
	}
}
