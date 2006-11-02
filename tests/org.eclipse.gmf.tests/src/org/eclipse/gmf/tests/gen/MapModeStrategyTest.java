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

import junit.framework.TestCase;

import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.FigureGenerator;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil;

public class MapModeStrategyTest extends TestCase {
	public MapModeStrategyTest(String name) {
		super(name);
	}
	
	public void testPreferredSize(){
		checkAllStrategies(createFigureWithPreferredSize());
	}
	
	public void testRoundedRectangleCorners(){
		RoundedRectangle rounded = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		rounded.setName("RoundedRectangleWithCorners");
		rounded.setCornerWidth(23);
		rounded.setCornerHeight(14);
		checkAllStrategies(rounded);
	}
	
	private void checkAllStrategies(Figure figure){
		String baseName = figure.getName();
		try {
			figure.setName(baseName + "_StaticIdentity");
			FigureGeneratorUtil.generateAndParse(figure, createGenerator(MapModeCodeGenStrategy.STATIC, null));
			
			figure.setName(baseName + "_DefaultMapMode");
			FigureGeneratorUtil.generateAndParse(figure, createGenerator(MapModeCodeGenStrategy.DYNAMIC, null));
	
			figure.setName(baseName + "_StandaloneMapMode");
			FigureGeneratorUtil.generateAndParse(figure, createGenerator(MapModeCodeGenStrategy.DYNAMIC, FigureGeneratorUtil.DEFAULT_PLUGIN_ACTIVATOR + ".getDefault()."));
		} finally {
			figure.setName(baseName);
		}
	}
	
	private Figure createFigureWithPreferredSize(){
		Figure figure = GMFGraphFactory.eINSTANCE.createRectangle();
		figure.setName("Figure2WithPreferredSize");
		figure.setPreferredSize(FigureGeneratorUtil.createDimension(234, 567));
		return figure;
	}
	
	private FigureGenerator createGenerator(MapModeCodeGenStrategy strategy, String accessor) {
		return new FigureGenerator(new RuntimeFQNSwitch(), strategy, accessor, false);
	}
}
