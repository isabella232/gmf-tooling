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
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
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
			setCustomFigureGenerator(createGenerator(createImportAssistant(), createStaticIdentity()));
			figure.setName(baseName + "_StaticIdentity");
			performTests(figure);
			
			setCustomFigureGenerator(createGenerator(createImportAssistant(), createDefaultStrategy()));
			figure.setName(baseName + "_DefaultMapMode");
			performTests(figure);
	
			ImportAssistant assistant = createImportAssistant();
			setCustomFigureGenerator(createGenerator(assistant, createStandaloneStrategy(assistant)));
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
		return new MapModeCodeGenStrategy.StaticIdentityMapMode();
	}
	
	private MapModeCodeGenStrategy createDefaultStrategy(){
		return new MapModeCodeGenStrategy.RuntimeUnspecifiedMapMode();
	}
	
	private MapModeCodeGenStrategy createStandaloneStrategy(ImportAssistant assistant){
		return new MapModeCodeGenStrategy.RuntimeMapModeFromPluginClass(assistant, getPluginActivatorClassFQN());
	}

	private ImportAssistant createImportAssistant(){
		return new ImportUtil(getFigurePackageName());
	}
	
	private FigureGenerator createGenerator(ImportAssistant assistant, MapModeCodeGenStrategy strategy) {
		if (strategy instanceof MapModeCodeGenStrategy.RuntimeMapModeFromPluginClass){
			MapModeCodeGenStrategy.RuntimeMapModeFromPluginClass impl = (MapModeCodeGenStrategy.RuntimeMapModeFromPluginClass)strategy;
			assertSame(assistant, impl.getImportAssistant());
		}
		return new FigureGenerator(assistant.getPackageName(), assistant, new RuntimeFQNSwitch(), strategy);
	}
}
