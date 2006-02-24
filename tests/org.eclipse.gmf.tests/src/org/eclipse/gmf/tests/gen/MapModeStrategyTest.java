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

import org.eclipse.gmf.common.codegen.ImportAssistant;
import org.eclipse.gmf.common.codegen.ImportUtil;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.gmfgraph.util.FigureQualifiedNameSwitch;
import org.eclipse.gmf.graphdef.codegen.FigureGenerator;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;

public class MapModeStrategyTest extends FigureCodegenTestBase {
	public MapModeStrategyTest(String name) {
		super(name);
	}
	
	public void testPreferredSize(){
		checkAllStrategies(createFigureWithPrefferedSize());
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
			setCustomFigureGenerator(createGenerator(createStaticIdentity()));
			figure.setName(baseName + "_StaticIdentity");
			performTests(figure);
			
			setCustomFigureGenerator(createGenerator(createDefaultStrategy()));
			figure.setName(baseName + "_DefaultMapMode");
			performTests(figure);
	
			setCustomFigureGenerator(createGenerator(createStandaloneStrategy()));
			figure.setName(baseName + "_StandaloneMapMode");
			performTests(figure);
		} finally {
			figure.setName(baseName);
		}
	}
	
	private Figure createFigureWithPrefferedSize(){
		Figure figure = figure2();
		figure.setName("Figure2WithPreferredSize");
		Dimension preferredSize = GMFGraphFactory.eINSTANCE.createDimension();
		preferredSize.setDx(234);
		preferredSize.setDy(567);
		figure.setPreferredSize(preferredSize);
		return figure;
	}
	
	private MapModeCodeGenStrategy createStaticIdentity(){
		return new MapModeCodeGenStrategy.StaticIdentityMapMode(createImportAssistant());
	}
	
	private MapModeCodeGenStrategy createDefaultStrategy(){
		return new MapModeCodeGenStrategy.RuntimeUnspecifiedMapMode(createImportAssistant());
	}
	
	private MapModeCodeGenStrategy createStandaloneStrategy(){
		return new MapModeCodeGenStrategy.RuntimeMapModeFromPluginClass(createImportAssistant(), getPluginActivatorClassFQN());
	}

	private ImportAssistant createImportAssistant(){
		return new ImportUtil(getFigurePackageName());
	}
	
	private FigureGenerator createGenerator(MapModeCodeGenStrategy strategy) {
		return new FigureGenerator(strategy.getImportAssistant().getPackageName(), strategy.getImportAssistant(), new FigureQualifiedNameSwitch(), strategy);
	}
}
