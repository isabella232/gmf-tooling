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

import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
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
	public void testExistence() {
		org.eclipse.gmf.gmfgraph.SVGFigure f = GMFGraphFactory.eINSTANCE.createSVGFigure();
		f.setName("Crate");
		f.setDocumentURI(BOX_URI);
		SVGFigure f2d = createDraw2DFigure(f);
		assertEquals(f2d.getURI(), BOX_URI);
	}
}
