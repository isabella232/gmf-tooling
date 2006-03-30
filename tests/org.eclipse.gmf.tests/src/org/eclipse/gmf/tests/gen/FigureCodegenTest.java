/*
 * Copyright (c) 2005 Borland Software Corporation
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

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.common.codegen.NullImportAssistant;
import org.eclipse.gmf.gmfgraph.CustomAttribute;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.FigureGenerator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.draw2d.CustomFigureWithProperties;

/**
 * @author artem
 */
public class FigureCodegenTest extends FigureCodegenTestBase {
	public FigureCodegenTest(String name) {
		super(name);
	}

	public void testGenPolylineConnection() {
		performTests(ecoreContainmentRef(), new FigureCheck() {
			public void checkFigure(IFigure figure) {
				assertTrue(figure instanceof PolylineConnectionEx);
			}
		});
	}

	public void testGenCustomFigure() {
		performTests(figure1());
	}

	public void testGenSimpleShape() {
		performTests(figure2());
	}

	public void testGenComplexShape() {
		performTests(figure3());
	}

	public void testGenFigureWithoutPackageStmt() {
		setCustomFigureGenerator(new FigureGenerator(null, new NullImportAssistant(), new RuntimeFQNSwitch()));
		testGenComplexShape();
	}
	
	public void testGenCustomFigureWithAttributes(){
		CustomFigure result = GMFGraphFactory.eINSTANCE.createCustomFigure();
		result.setName("MyRectangleWithInner40x40");
		result.setBundleName(Plugin.getPluginID());
		result.setQualifiedClassName(CustomFigureWithProperties.class.getName());
		
		CustomAttribute innerWidthAttr = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		innerWidthAttr.setName("innerWidth");
		innerWidthAttr.setValue("40");
		result.getAttributes().add(innerWidthAttr);
		
		CustomAttribute innerHeightAttr = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		innerHeightAttr.setName("innerHeight");
		innerHeightAttr.setValue("40");
		innerHeightAttr.setDirectAccess(true);
		result.getAttributes().add(innerHeightAttr);
		
		Dimension outerPrefSize = GMFGraphFactory.eINSTANCE.createDimension();
		outerPrefSize.setDx(100);
		outerPrefSize.setDy(100);
		result.setPreferredSize(outerPrefSize);
		
		FigureCheck customCheck = new FigureCheck(){
			public void checkFigure(IFigure figure) {
				assertTrue(figure instanceof CustomFigureWithProperties);
				CustomFigureWithProperties custom = (CustomFigureWithProperties)figure;
				assertEquals(40, custom.getInnerWidth());
				assertEquals(40, custom.innerHeight);
			}
		};
		
		performTests(result); 
		performTests(result, customCheck);
	}
}
