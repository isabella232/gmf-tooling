/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup.figures;

import junit.framework.Assert;

import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Ellipse;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.Polygon;
import org.eclipse.gmf.gmfgraph.PolygonDecoration;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator.Config;
import org.eclipse.gmf.tests.TestConfiguration;
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil.GeneratedClassData;


public abstract class AbstractFigureGeneratorSetup implements TestConfiguration {
	
	private FigureGallery myFigureGallery;

	private GeneratedClassData[] myClassDatas;

	private PolylineConnection myEcoreContainmentRef;

	private Figure myCustomFigure;

	private Figure mySimpleShape;

	private Figure myComplexShape;

	private Config myConfig;
	
	protected abstract void addFigures(FigureGallery gallery);
	
	public Class getFigureClass(Figure f) {
		GeneratedClassData[] classDatas = getClassData();
		for (int i = 0; i < classDatas.length; i++) {
			if (classDatas[i].getFigureDef() == f) {
				return classDatas[i].getLoadedClass();
			}
		}
		Assert.fail("Class was not found in generated plugin: " + getConfig().getPluginID() + "|" + getConfig().getMainPackageName() + "|" + f.getName());
		return null;
	}
	
	private GeneratedClassData[] getClassData() {
		if (myClassDatas == null) {
			myClassDatas = FigureGeneratorUtil.generateAndCompile(getFigureGallery(), getConfig());
		}
		return myClassDatas;
	}
	
	protected Config getConfig() {
		if (myConfig == null) {
			myConfig = FigureGeneratorUtil.createStandaloneGeneratorConfig();
		}
		return myConfig;
	}

	private FigureGallery getFigureGallery() {
		if (myFigureGallery == null) {
			myFigureGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
			myFigureGallery.setName("bb");
			addFigures(myFigureGallery);
			Assert.assertFalse("No figures was added to the gallery by subclasses", myFigureGallery.getFigures().isEmpty());
		}
		return myFigureGallery;
	}

// Creating figures:
	
	public PolylineConnection getEcoreContainmentRef() {
		if (myEcoreContainmentRef == null) {
			myEcoreContainmentRef = GMFGraphFactory.eINSTANCE.createPolylineConnection();
			myEcoreContainmentRef.setName("ContainmentRef");
			PolygonDecoration df = createBlueRhomb();
			df.setFill(true);
			myEcoreContainmentRef.setSourceDecoration(df);
		}
		return myEcoreContainmentRef;
	}
	
	private PolygonDecoration createBlueRhomb() {
		PolygonDecoration df = GMFGraphFactory.eINSTANCE.createPolygonDecoration();
		df.setName("BlueRhombDecoration");
		df.getTemplate().add(FigureGeneratorUtil.createPoint(-1, 1));
		df.getTemplate().add(FigureGeneratorUtil.createPoint(0, 0));
		df.getTemplate().add(FigureGeneratorUtil.createPoint(-1, -1));
		df.getTemplate().add(FigureGeneratorUtil.createPoint(-2, 0));
		
		df.setBackgroundColor(FigureGeneratorUtil.createConstantColor(ColorConstants.BLUE_LITERAL));
		df.setForegroundColor(FigureGeneratorUtil.createRGBColor(0, 0, 255));
		return df;
	}
	
	public final Figure getCustomFigure() {
		if (myCustomFigure == null) {
			myCustomFigure = createFigure1();
		}
		return myCustomFigure;
	}
	

	public final Figure getSimpleShape() {
		if (mySimpleShape == null) {
			mySimpleShape = createFigure2();
		}
		return mySimpleShape;
	}
	
	public final Figure getComplexShape() {
		if (myComplexShape == null) {
			myComplexShape = createFigure3();
		}
		return myComplexShape;
	}

	protected static Figure createFigure1() {
		CustomFigure cf = GMFGraphFactory.eINSTANCE.createCustomFigure();
		cf.setName("MyRRectangleAsCustom");
		cf.setBundleName(FigureGeneratorUtil.DRAW2D);
		cf.setQualifiedClassName(org.eclipse.draw2d.RoundedRectangle.class.getName());
		Point p = GMFGraphFactory.eINSTANCE.createPoint();
		p.setX(1023);
		p.setY(33);
		cf.setSize(p);
		cf.getChildren().add(createFigure2());
		Ellipse e = GMFGraphFactory.eINSTANCE.createEllipse();
		e.setName("Elli");
		e.setFill(true);
		cf.getChildren().add(e);
		return cf;
	}

	protected static Figure createFigure2() {
		Rectangle r = GMFGraphFactory.eINSTANCE.createRectangle();
		r.setName("MyRect");
		r.setFill(true);
		r.setLineWidth(3);
		r.setLineKind(LineKind.LINE_DASHDOT_LITERAL);
		Label l1 = GMFGraphFactory.eINSTANCE.createLabel();
		l1.setText("aaaaa");
		l1.setName("L1");
		l1.setFont(FigureGeneratorUtil.createBasicFont("Arial", 9, FontStyle.ITALIC_LITERAL));
		l1.setForegroundColor(FigureGeneratorUtil.createConstantColor(ColorConstants.CYAN_LITERAL));
		Label l2 = GMFGraphFactory.eINSTANCE.createLabel();
		l2.setText("bbbbb");
		l2.setName("L2");
		l2.setFont(FigureGeneratorUtil.createBasicFont("Helvetica", 12, FontStyle.BOLD_LITERAL));
		r.getChildren().add(l1);
		r.getChildren().add(l2);
		return r;
	}

	private static Figure createFigure3() {
		Figure myFigure3 = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		myFigure3.setName("Rounded1");
		Polygon pg = GMFGraphFactory.eINSTANCE.createPolygon();
		pg.setName("Polygon1");
		pg.getTemplate().add(FigureGeneratorUtil.createPoint(1, 2));
		pg.getTemplate().add(FigureGeneratorUtil.createPoint(0, 3));
		pg.getTemplate().add(FigureGeneratorUtil.createPoint(-2, -1));
		myFigure3.getChildren().add(pg);
		myFigure3.getChildren().add(createFigure1());
		return myFigure3;
	}
}
