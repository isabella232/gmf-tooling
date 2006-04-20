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

import java.util.Arrays;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.ScrollBar;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.common.codegen.NullImportAssistant;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.CustomAttribute;
import org.eclipse.gmf.gmfgraph.CustomConnection;
import org.eclipse.gmf.gmfgraph.CustomDecoration;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Insets;
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
		
		FigureCheck defaultCheckWithoutChildren = new GenericFigureCheck(result){
			protected void checkFigureChildren(Figure gmfFigure, IFigure d2dFigure) {
				//ScrollBar creates additional children that are missed in the model
				//Thus nothing to check here
			}
		};  
		
		performTests(result, combineChecks(customCheck, defaultCheckWithoutChildren));  
	}
	
	public void testGenCustomDecoration(){
		final String POINT_LIST = PointList.class.getName();
		final String POLYGON_DECORATION = PolygonDecoration.class.getName();

		CustomDecoration result = GMFGraphFactory.eINSTANCE.createCustomDecoration();
		result.setName("MyPolygonDecoration");
		result.setBundleName(DRAW2D);
		result.setQualifiedClassName(POLYGON_DECORATION);
		
		Insets insets = GMFGraphFactory.eINSTANCE.createInsets();
		insets.setBottom(12);
		insets.setLeft(23);
		insets.setRight(34);
		insets.setTop(45);
		result.setInsets(insets);
		
		ConstantColor color = GMFGraphFactory.eINSTANCE.createConstantColor();
		color.setValue(ColorConstants.YELLOW_LITERAL);
		result.setBackgroundColor(color);
		
		CustomAttribute scale = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		scale.setName("scale");
		scale.setValue("1, 1");
		result.getAttributes().add(scale);
		
		CustomAttribute pointList = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		pointList.setName("Template");
		pointList.setMultiStatementValue(true);
		pointList.setValue(
				POINT_LIST + " {0} = new " + POINT_LIST + "();" +
				"{0}.addAll(" + POLYGON_DECORATION + ".TRIANGLE_TIP);");
		
		result.getAttributes().add(pointList);
		
		FigureCheck customCheck = new FigureCheck(){
			public void checkFigure(IFigure figure) {
				assertTrue(figure instanceof PolygonDecoration);
				PolygonDecoration decoration = (PolygonDecoration)figure;
				//we can not check scale directly, but following line checks it implicitly
				assertTrue(Arrays.equals(PolygonDecoration.TRIANGLE_TIP.toIntArray(), decoration.getPoints().toIntArray()));
			}
		};
		
		performTests(result, combineChecks(customCheck, new GenericFigureCheck(result)));
	}
	
	public void testGenCustomConnection(){
		final String NAME = "MyPolylineConnection"; 
		//use the same PolylineConnection as always but as custom one
		final CustomConnection result = GMFGraphFactory.eINSTANCE.createCustomConnection();
		result.setName(NAME);
		result.setBundleName(DRAW2D);
		result.setQualifiedClassName(PolylineConnection.class.getName());
		
		CustomAttribute router = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		router.setName("connectionRouter");
		router.setValue("new org.eclipse.draw2d.BendpointConnectionRouter()");
		result.getAttributes().add(router);
		
		CustomAttribute fakeConstarint = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		fakeConstarint.setName("routingConstraint");
		fakeConstarint.setValue("new Integer(42)");
		result.getAttributes().add(fakeConstarint);
		
		GenericFigureCheck constraintCheck = new GenericFigureCheck(result){
			protected void checkFigureItself(Figure gmfFigure, IFigure d2dFigure) {
				assertEquals("Only one figure expected", NAME, gmfFigure.getName());
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
		
		performTests(result, constraintCheck);
	}
	
}
