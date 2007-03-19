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
		final org.eclipse.gmf.gmfgraph.PolylineConnection f = getSessionSetup().getEcoreContainmentRef();
		performTests(f, new GenericFigureCheck(null/*fake arg*/) {
			protected void checkFigure(IFigure figure) {
				assertTrue(figure instanceof PolylineConnectionEx);
				assertTrue(figure.getChildren().get(0) instanceof PolygonDecoration);
				// bug #172864
				checkFigure(f.getSourceDecoration(), (PolygonDecoration) figure.getChildren().get(0));
			}
		});
	}

	public void testGenCustomFigure() {
		final Figure f = getSessionSetup().getCustomFigure();
		performTests(f, new GenericFigureCheck(f));
	}

	public void testGenSimpleShape() {
		final Figure f = getSessionSetup().getSimpleShape();
		performTests(f, new GenericFigureCheck(f));
	}

	public void testGenComplexShape() {
		final Figure f = getSessionSetup().getComplexShape();
		performTests(f, new GenericFigureCheck(f));
	}
	
	public void testGenCustomFigureWithAttributes(){
		FigureCheck defaultCheckWithoutChildren = new GenericFigureCheck(getSessionSetup().getResult2()){
			protected void checkFigure(IFigure figure) {
				assertTrue(figure instanceof ScrollBar);
				ScrollBar custom = (ScrollBar)figure;
				assertEquals(1, custom.getMinimum());
				assertEquals(99, custom.getMaximum());
				assertTrue(custom.isHorizontal());
				assertEquals(new org.eclipse.draw2d.geometry.Dimension(100, 100), custom.getPreferredSize());

				super.checkFigure(figure);
			}

			protected void checkFigureChildren(Figure gmfFigure, IFigure d2dFigure) {
				//ScrollBar creates additional children that are missed in the model
				//Thus nothing to check here
			}
		};  
		performTests(getSessionSetup().getResult2(), defaultCheckWithoutChildren);  
	}
	
	public void testGenCustomDecoration(){
		FigureCheck customCheck = new FigureCheck(){
			protected void checkFigure(IFigure figure) {
				assertTrue(figure instanceof PolygonDecoration);
				PolygonDecoration decoration = (PolygonDecoration)figure;
				//we can not check scale directly, but following line checks it implicitly
				assertTrue(Arrays.equals(PolygonDecoration.TRIANGLE_TIP.toIntArray(), decoration.getPoints().toIntArray()));
			}
		};
		
		performTests(getSessionSetup().getResult1(), customCheck.chain(new GenericFigureCheck(getSessionSetup().getResult1())));
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
		performTests(getSessionSetup().getRoot1(), new GenericFigureCheck(getSessionSetup().getRoot1()).chain(staticFieldsCheck));
	}
	
	public void testFigureWithStaticFieldsForColorAndFonts(){
		FigureCheck fontFieldsCheck = new StaticFieldsChecker(4, Font.class); //root + 3 labels
		FigureCheck colorFieldsCheck = new StaticFieldsChecker(2, Color.class); // only RGB colors should get field
	
		performTests(getSessionSetup().getRoot(), fontFieldsCheck.chain(colorFieldsCheck));
	}
	
	public void testConnectionWithColor(){
		FigureCheck colorFieldsCheck = new StaticFieldsChecker(1, Color.class);
		performTests(getSessionSetup().getLink(), colorFieldsCheck);
	}
	
	private static class StaticFieldsChecker extends FigureCheck {
		private final int myExpectedFieldCount;
		private final Class<?> myFieldClazz;

		public StaticFieldsChecker(int expectedFieldCount, Class<?> fieldClazz){
			myExpectedFieldCount = expectedFieldCount;
			myFieldClazz = fieldClazz;
		}
		
		protected void checkFigure(IFigure figure) {
			Class<? extends IFigure> figureClazz = figure.getClass();
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
