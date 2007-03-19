/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.gmf.tests.gen;

import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator.Config;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeTypes;
import org.eclipse.gmf.tests.setup.figures.FigureCheck;
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil;
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil.GeneratedClassData;
import org.osgi.framework.Bundle;

/**
 * @see MapModeStrategyTest
 */
public class StandaloneMapModeTest extends TestCase {

	public StandaloneMapModeTest(String name) {
		super(name);
	}
	
	public void testStaticIdentityMapMode(){
		Config config = FigureGeneratorUtil.createStandaloneGeneratorConfig(FigureGeneratorUtil.DEFAULT_FIGURE_PACKAGE, false);
		GeneratedClassData[] theOnly = FigureGeneratorUtil.generateAndCompile(config, createTestFigure());
		assertEquals(1, theOnly.length);
		new FigureSizeCheck(123, 456).go(theOnly[0].getLoadedClass());
	}
	
	public void testRuntimeIdentityAndHiMetricMapMode(){
		Config config = FigureGeneratorUtil.createStandaloneGeneratorConfig(FigureGeneratorUtil.DEFAULT_FIGURE_PACKAGE, true);
		GeneratedClassData[] theOnly = FigureGeneratorUtil.generateAndCompile(config, createTestFigure());
		assertNotNull(theOnly);
		assertEquals(1, theOnly.length);
		Class<?> figureClass = theOnly[0].getLoadedClass();
		new InstantiateFigureHook(123, 456, MapModeTypes.IDENTITY_MM, config).go(figureClass);
		new InstantiateFigureHook(123, 456, MapModeTypes.HIMETRIC_MM, config).go(figureClass);
	}
	
	private Figure createTestFigure(){
		Rectangle result = GMFGraphFactory.eINSTANCE.createRectangle();
		result.setName("TestFigure");
		result.setSize(FigureGeneratorUtil.createPoint(123, 456));
		return result;
	}	
	
	private static class FigureSizeCheck extends FigureCheck {
		private final Dimension mySize;
		
		public FigureSizeCheck(int width, int height){
			mySize = new Dimension(width, height);
		}

		protected void checkFigure(IFigure figure) {
			assertEquals(mySize, figure.getSize());
		}
	}
	
	private static class InstantiateFigureHook extends FigureSizeCheck {
		private final IMapMode myMapMode;
		private final StandaloneGenerator.Config myConfig;

		public InstantiateFigureHook(int width, int height, IMapMode mapMode, StandaloneGenerator.Config config){
			super(mapMode.DPtoLP(width), mapMode.DPtoLP(height));
			myMapMode = mapMode;
			myConfig = config;
		}
		
		protected IFigure instantiateFigure(Class<?> figureClass) {
			try {
				hookMapMode();
			} catch (Exception e) {
				fail(e.getMessage());
			}
			return super.instantiateFigure(figureClass);
		}
		
		private void hookMapMode() throws Exception {
			Bundle bundle = Platform.getBundle(myConfig.getPluginID());
			assertNotNull(bundle);
			Class<?> activatorClass = bundle.loadClass(myConfig.getPluginActivatorPackageName() + "." + myConfig.getPluginActivatorClassName());
			assertNotNull(activatorClass);
			Method getDefault = activatorClass.getMethod("getDefault", new Class[0]);
			assertNotNull(getDefault);
			Object activator = getDefault.invoke(null, new Object[0]);
			assertNotNull(activator);
			
			Method setMapMode = activatorClass.getMethod("setMapMode", new Class[] {IMapMode.class});
			assertNotNull(setMapMode);
			setMapMode.invoke(activator, new Object[] {myMapMode});
			
			Method getMapMode = activatorClass.getMethod("getMapMode", new Class[0]);
			assertNotNull(getMapMode);
			assertEquals(myMapMode, getMapMode.invoke(activator, new Object[0]));
		}
	}
}
