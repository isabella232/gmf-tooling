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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import junit.framework.Assert;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.ScrollBar;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.tests.setup.figures.FigureCheck;
import org.eclipse.gmf.tests.setup.figures.FigureCodegenSetup;
import org.eclipse.gmf.tests.setup.figures.GenericFigureCheck;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * @author artem
 */
public class FigureCodegenTest extends FigureCodegenTestBase {

	public FigureCodegenTest(String name) {
		super(name);
	}

	private FigureCodegenSetup getSessionSetup() {
		if (mySessionSetup == null){
			mySessionSetup = new FigureCodegenSetup();
		}
		Assert.assertTrue("Incorrect session setup was used, use FigureCodegenSetup instead of: " + mySessionSetup, mySessionSetup instanceof FigureCodegenSetup);
		return (FigureCodegenSetup) mySessionSetup;
	}
	
	public void testGenPolylineConnection() {
		performTests(getSessionSetup().getEcoreContainmentRef(), new FigureCheck() {
			public void checkFigure(IFigure figure) {
				assertTrue(figure instanceof PolylineConnectionEx);
			}
		});
	}

	public void testGenCustomFigure() {
		performTests(getSessionSetup().getCustomFigure());
	}

	public void testGenSimpleShape() {
		performTests(getSessionSetup().getSimpleShape());
	}

	public void testGenComplexShape() {
		performTests(getSessionSetup().getComplexShape());
	}
	
	public void testGenCustomFigureWithAttributes(){
		FigureCheck defaultCheckWithoutChildren = new GenericFigureCheck(getSessionSetup().getResult2()){
			protected void checkFigureChildren(Figure gmfFigure, IFigure d2dFigure) {
				//ScrollBar creates additional children that are missed in the model
				//Thus nothing to check here
			}
		};  
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
		performTests(getSessionSetup().getResult2(), FigureCheck.combineChecks(customCheck, defaultCheckWithoutChildren));  
	}
	
	public void testGenCustomDecoration(){
		FigureCheck customCheck = new FigureCheck(){
			public void checkFigure(IFigure figure) {
				assertTrue(figure instanceof PolygonDecoration);
				PolygonDecoration decoration = (PolygonDecoration)figure;
				//we can not check scale directly, but following line checks it implicitly
				assertTrue(Arrays.equals(PolygonDecoration.TRIANGLE_TIP.toIntArray(), decoration.getPoints().toIntArray()));
			}
		};
		
		performTests(getSessionSetup().getResult1(), FigureCheck.combineChecks(customCheck, new GenericFigureCheck(getSessionSetup().getResult1())));
	}
	
	public void testGenCustomConnection(){
		GenericFigureCheck constraintCheck = new GenericFigureCheck(getSessionSetup().getResult()){
			protected void checkFigureItself(Figure gmfFigure, IFigure d2dFigure) {
				assertEquals("Only one figure expected", getSessionSetup().getResult().getName(), gmfFigure.getName());
				super.checkFigureItself(gmfFigure, d2dFigure);
				checkConstraint(d2dFigure);
			}

			private void checkConstraint(IFigure figure) {
				assertTrue(figure instanceof PolylineConnection);
				PolylineConnection decoration = (PolylineConnection)figure;
				assertTrue(decoration.getConnectionRouter() instanceof BendpointConnectionRouter);
				assertEquals(new Integer(42), decoration.getRoutingConstraint());
			}
		};
		
		performTests(getSessionSetup().getResult(), constraintCheck);
	}

	public void testCustomFigureWithSameNameAsReferredClassName(){
		performTests(getSessionSetup().getCustom(), FigureCheck.CHECK_CAN_CREATE_INSTANCE);
	}
	
	public void testFigureWithTwoBorderedChildren(){
		FigureCheck staticFieldsCheck = new StaticFieldsChecker(1, Color.class);
		performTests(getSessionSetup().getRoot1(), FigureCheck.combineChecks(new GenericFigureCheck(getSessionSetup().getRoot1()), staticFieldsCheck));
	}
	
	public void testFigureWithStaticFieldsForColorAndFonts(){
		FigureCheck fontFieldsCheck = new StaticFieldsChecker(4, Font.class); //root + 3 labels
		FigureCheck colorFieldsCheck = new StaticFieldsChecker(2, Color.class); // only RGB colors should get field
	
		performTests(getSessionSetup().getRoot(), FigureCheck.combineChecks(fontFieldsCheck, colorFieldsCheck));
	}
	
	public void testConnectionWithColor(){
		FigureCheck colorFieldsCheck = new StaticFieldsChecker(1, Color.class);
		performTests(getSessionSetup().getLink(), colorFieldsCheck);
	}
	
	private static class StaticFieldsChecker extends FigureCheck {
		private final int myExpectedFieldCount;
		private final Class myFieldClazz;

		public StaticFieldsChecker(int expectedFieldCount, Class fieldClazz){
			myExpectedFieldCount = expectedFieldCount;
			myFieldClazz = fieldClazz;
		}
		
		public void checkFigure(IFigure figure) {
			Class figureClazz = figure.getClass();
			Field[] fields = figureClazz.getDeclaredFields();
			int staticFinalFields = 0;
			for (int i = 0; i < fields.length; i++){
				Field next = fields[i];
				int modifiers = next.getModifiers();
				if (myFieldClazz.equals(next.getType()) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)){
					staticFinalFields++;
				}
			}
			assertTrue("Expected: at least " + myExpectedFieldCount +" constants of type :" + myFieldClazz.getName() + ". Actual: " + staticFinalFields, staticFinalFields >= myExpectedFieldCount);
		}
	}

}
