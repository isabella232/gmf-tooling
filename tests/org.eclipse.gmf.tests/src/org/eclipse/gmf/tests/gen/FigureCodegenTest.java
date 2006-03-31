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
import org.eclipse.draw2d.ScrollBar;
import org.eclipse.gmf.common.codegen.NullImportAssistant;
import org.eclipse.gmf.gmfgraph.CustomAttribute;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.FigureGenerator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

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
		result.setName("MyHorizontalScrollBar");
		result.setBundleName(DRAW2D);
		result.setQualifiedClassName(ScrollBar.class.getName());
		
		CustomAttribute minimum = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		minimum.setName("minimum");
		minimum.setValue("1");
		result.getAttributes().add(minimum);
		
		CustomAttribute maximum = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		maximum.setName("Maximum"); //note first 'M'
		maximum.setValue("99");
		result.getAttributes().add(maximum);

		CustomAttribute orientation = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		orientation.setName("horizontal");
		orientation.setValue("true");
		result.getAttributes().add(orientation);
		
		Dimension outerPrefSize = GMFGraphFactory.eINSTANCE.createDimension();
		outerPrefSize.setDx(100);
		outerPrefSize.setDy(100);
		result.setPreferredSize(outerPrefSize);
		
		FigureCheck customCheck = new FigureCheck(){
			public void checkFigure(IFigure figure) {
				assertTrue(figure instanceof ScrollBar);
				ScrollBar custom = (ScrollBar)figure;
				assertEquals(1, custom.getMinimum());
				assertEquals(99, custom.getMaximum());
				assertTrue(custom.isHorizontal());
				
				assertEquals(new org.eclipse.draw2d.geometry.Dimension(100, 100), custom.getPreferredSize());
			}
		};
		
		//performTests(result); ScrollBar creates additional children 
		performTests(result, customCheck);
	}
}
