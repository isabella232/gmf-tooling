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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeTypes;
import org.osgi.framework.Bundle;

public class StandaloneMapModeTest extends FigureCodegenTestBase {
	private StandaloneGenerator.Config myGeneratorConfig;

	public StandaloneMapModeTest(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		myGeneratorConfig = null;
	}
	
	public void testStaticIdentityMapMode(){
		myGeneratorConfig = new StandaloneGenerator.ConfigImpl(getTestPluginName(), getFigurePackageName(), false);
		performTests(createTestFigure(), new FigureSizeCheck(123, 456));
	}
	
	public void testRuntimeIdentityMapMode(){
		myGeneratorConfig = new StandaloneGenerator.ConfigImpl(getTestPluginName(), getFigurePackageName(), true);
		performTests(createTestFigure(), new InstantiateFigureHook(123, 456, MapModeTypes.IDENTITY_MM, myGeneratorConfig));
	}
	
	public void testRuntimeHiMetricsMapMode(){
		myGeneratorConfig = new StandaloneGenerator.ConfigImpl(getTestPluginName(), getFigurePackageName(), true);
		performTests(createTestFigure(), new InstantiateFigureHook(123, 456, MapModeTypes.HIMETRIC_MM, myGeneratorConfig));		
	}
	
	protected StandaloneGenerator.Config getGMFGraphGeneratorConfig(){
		assertNotNull(myGeneratorConfig);
		return myGeneratorConfig;
	}
	
	private Figure createTestFigure(){
		Rectangle result = GMFGraphFactory.eINSTANCE.createRectangle();
		result.setName("TestFigure");
		Point size = GMFGraphFactory.eINSTANCE.createPoint();
		size.setX(123);
		size.setY(456);
		result.setSize(size);
		return result;
	}	
	
	private static class FigureSizeCheck extends FigureCheck {
		private final Dimension mySize;
		
		public FigureSizeCheck(int width, int height){
			this(new Dimension(width, height));
		}

		public FigureSizeCheck(Dimension size){
			mySize = size;
		}
		
		public void checkFigure(IFigure figure) {
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
		
		protected IFigure instantiateFigure(Class figureClass) {
			try {
				hookMapMode();
			} catch (Exception e) {
				fail(e.getMessage());
			}
			return super.instantiateFigure(figureClass);
		}
		
		private void hookMapMode() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
			Bundle bundle = Platform.getBundle(myConfig.getPluginID());
			assertNotNull(bundle);
			Class activatorClass = bundle.loadClass(myConfig.getPluginActivatorPackageName() + "." + myConfig.getPluginActivatorClassName());
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
