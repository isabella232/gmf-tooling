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
import org.eclipse.gmf.runtime.lite.svg.SVGFigure;
import org.eclipse.gmf.tests.setup.figures.AbstractFigureGeneratorSetup;
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil;

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
		assertEquals(f2d.getURI(), BOX_URI);
		assertFalse(f2d.isSafeRendering());
		assertNull(f2d.getAreaOfInterest());
	}

	/**
	 * Check that SVGFigure generates.
	 */
	public void testAdvancedProperties() {
		org.eclipse.gmf.gmfgraph.SVGFigure f = GMFGraphFactory.eINSTANCE.createSVGFigure();
		f.setName("Crate");
		f.setDocumentURI(BOX_URI);
		f.setSafeRendering(true);
		f.setAreaOfInterest(GMFGraphFactory.eINSTANCE.createRectangle2D());
		f.getAreaOfInterest().setX(10);
		f.getAreaOfInterest().setY(0.5);
		f.getAreaOfInterest().setWidth(555);
		f.getAreaOfInterest().setHeight(44.4);
		SVGFigure f2d = createDraw2DFigure(f);
		assertEquals(f2d.getURI(), BOX_URI);
		assertTrue(f2d.isSafeRendering());
		Rectangle2D aoi = f2d.getAreaOfInterest();
		assertNotNull(aoi);
		assertEquals(aoi.getX(), (double) 10);
		assertEquals(aoi.getY(), (double) 0.5);
		assertEquals(aoi.getWidth(), (double) 555);
		assertEquals(aoi.getHeight(), (double) 44.4);
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
		f.getProperties().add(p);
		SVGFigure f2d = createDraw2DFigure(f);
		Method getter = f2d.getClass().getMethod("getA");
		Method setter = f2d.getClass().getMethod("setA", String.class);
		String v = (String) getter.invoke(f2d);
		assertEquals(v, "49");
		setter.invoke(f2d, "23");
		v = (String) getter.invoke(f2d);
		assertEquals(v, "23");
	}
}
