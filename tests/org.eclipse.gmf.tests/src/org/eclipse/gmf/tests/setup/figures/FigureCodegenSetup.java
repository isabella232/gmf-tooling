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

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.ScrollBar;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.CustomAttribute;
import org.eclipse.gmf.gmfgraph.CustomConnection;
import org.eclipse.gmf.gmfgraph.CustomDecoration;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Insets;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LineBorder;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator.Config;

/**
 * In addition these figures will be generated into the root package to check
 * this functionality.
 */
public class FigureCodegenSetup extends AbstractFigureGeneratorSetup {

	private org.eclipse.gmf.gmfgraph.PolylineConnection myLink;

	private CustomFigure myCustom;

	private Figure myRoot;

	private Figure myRoot1;

	private CustomConnection myResult;

	private CustomDecoration myResult1;

	private CustomFigure myResult2;

	private Config myConfig;

	protected void addFigures(FigureGallery gallery) {
		gallery.getFigures().add(getEcoreContainmentRef());
		gallery.getFigures().add(getFigure1());
		gallery.getFigures().add(getFigure2());
		gallery.getFigures().add(getFigure3());
		gallery.getFigures().add(getLink());
		gallery.getFigures().add(getCustom());
		gallery.getFigures().add(getRoot());
		gallery.getFigures().add(getRoot1());
		gallery.getFigures().add(getResult());
		gallery.getFigures().add(getResult1());
		gallery.getFigures().add(getResult2());
	}

	public CustomFigure getResult2() {
		if (myResult2 == null) {
			myResult2 = GMFGraphFactory.eINSTANCE.createCustomFigure();
			myResult2.setName("MyHorizontalScrollBar");
			myResult2.setBundleName(FigureGeneratorUtil.DRAW2D);
			myResult2.setQualifiedClassName(ScrollBar.class.getName());

			CustomAttribute minimum = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			minimum.setName("minimum");
			minimum.setValue("1");
			myResult2.getAttributes().add(minimum);

			CustomAttribute maximum = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			maximum.setName("Maximum"); // note first 'M'
			maximum.setValue("99");
			myResult2.getAttributes().add(maximum);

			CustomAttribute orientation = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			orientation.setName("horizontal");
			orientation.setValue("true");
			myResult2.getAttributes().add(orientation);

			myResult2.setPreferredSize(FigureGeneratorUtil.createDimension(100, 100));
		}
		return myResult2;
	}

	public CustomDecoration getResult1() {
		if (myResult1 == null) {
			myResult1 = GMFGraphFactory.eINSTANCE.createCustomDecoration();
			final String POINT_LIST = PointList.class.getName();
			final String POLYGON_DECORATION = PolygonDecoration.class.getName();

			myResult1.setName("MyPolygonDecoration");
			myResult1.setBundleName(FigureGeneratorUtil.DRAW2D);
			myResult1.setQualifiedClassName(POLYGON_DECORATION);

			Insets insets = GMFGraphFactory.eINSTANCE.createInsets();
			insets.setBottom(12);
			insets.setLeft(23);
			insets.setRight(34);
			insets.setTop(45);
			myResult1.setInsets(insets);

			ConstantColor color = GMFGraphFactory.eINSTANCE.createConstantColor();
			color.setValue(ColorConstants.YELLOW_LITERAL);
			myResult1.setBackgroundColor(color);

			CustomAttribute scale = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			scale.setName("scale");
			scale.setValue("1, 1");
			myResult1.getAttributes().add(scale);

			CustomAttribute pointList = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			pointList.setName("Template");
			pointList.setMultiStatementValue(true);
			pointList.setValue(POINT_LIST + " {0} = new " + POINT_LIST + "();" + "{0}.addAll(" + POLYGON_DECORATION + ".TRIANGLE_TIP);");

			myResult1.getAttributes().add(pointList);
		}
		return myResult1;
	}

	public CustomConnection getResult() {
		if (myResult == null) {
			myResult = GMFGraphFactory.eINSTANCE.createCustomConnection();
			final String NAME = "MyPolylineConnection";
			// use the same PolylineConnection as always but as custom one

			myResult.setName(NAME);
			myResult.setBundleName(FigureGeneratorUtil.DRAW2D);
			myResult.setQualifiedClassName(PolylineConnection.class.getName());

			CustomAttribute router = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			router.setName("connectionRouter");
			router.setValue("new org.eclipse.draw2d.BendpointConnectionRouter()");
			myResult.getAttributes().add(router);

			CustomAttribute fakeConstarint = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			fakeConstarint.setName("routingConstraint");
			fakeConstarint.setValue("new Integer(42)");
			myResult.getAttributes().add(fakeConstarint);
		}
		return myResult;
	}

	public Figure getRoot1() {
		if (myRoot1 == null) {
			myRoot1 = GMFGraphFactory.eINSTANCE.createRectangle();
			myRoot1.setName("MultiBorderedRoot");

			Figure constantlyBordered = GMFGraphFactory.eINSTANCE.createRectangle();
			constantlyBordered.setName("WithRedConstantBorder");
			LineBorder constantRedBorder = GMFGraphFactory.eINSTANCE.createLineBorder();
			constantRedBorder.setColor(FigureGeneratorUtil.createConstantColor(ColorConstants.RED_LITERAL));
			constantRedBorder.setWidth(5);
			constantlyBordered.setBorder(constantRedBorder);
			myRoot1.getChildren().add(constantlyBordered);

			Figure rgbBordered = GMFGraphFactory.eINSTANCE.createRectangle();
			rgbBordered.setName("WithRedRGBBorder");
			LineBorder rgbRedBorder = GMFGraphFactory.eINSTANCE.createLineBorder();
			rgbRedBorder.setColor(FigureGeneratorUtil.createRGBColor(255, 0, 0));
			rgbRedBorder.setWidth(7);
			rgbBordered.setBorder(rgbRedBorder);
			myRoot1.getChildren().add(rgbBordered);
		}
		return myRoot1;
	}

	public Figure getRoot() {
		if (myRoot == null) {
			myRoot = GMFGraphFactory.eINSTANCE.createEllipse();
			myRoot.setName("FullOfColorsAndFonts");
			myRoot.setFont(FigureGeneratorUtil.createBasicFont("Arial", 23, FontStyle.BOLD_LITERAL));
			myRoot.setForegroundColor(FigureGeneratorUtil.createConstantColor(ColorConstants.ORANGE_LITERAL));
			myRoot.setBackgroundColor(FigureGeneratorUtil.createConstantColor(ColorConstants.GREEN_LITERAL));

			Label sansLabel = GMFGraphFactory.eINSTANCE.createLabel();
			sansLabel.setName("SansLabel");
			sansLabel.setFont(FigureGeneratorUtil.createBasicFont("Sans", 8, FontStyle.ITALIC_LITERAL));
			sansLabel.setForegroundColor(FigureGeneratorUtil.createConstantColor(ColorConstants.BLUE_LITERAL));
			myRoot.getChildren().add(sansLabel);

			Label tahomaLabel = GMFGraphFactory.eINSTANCE.createLabel();
			tahomaLabel.setName("TahomaLabel");
			tahomaLabel.setFont(FigureGeneratorUtil.createBasicFont("Tahoma", 12, FontStyle.NORMAL_LITERAL));
			tahomaLabel.setForegroundColor(FigureGeneratorUtil.createConstantColor(ColorConstants.YELLOW_LITERAL));
			myRoot.getChildren().add(tahomaLabel);

			Rectangle deepLabelContainer = GMFGraphFactory.eINSTANCE.createRectangle();
			deepLabelContainer.setName("DeepLabelContainer");
			deepLabelContainer.setForegroundColor(FigureGeneratorUtil.createRGBColor(123, 23, 3));
			deepLabelContainer.setBackgroundColor(FigureGeneratorUtil.createRGBColor(2, 123, 23));
			myRoot.getChildren().add(deepLabelContainer);

			Label defaultFontLabel = GMFGraphFactory.eINSTANCE.createLabel();
			defaultFontLabel.setName("DefaultFontLabel");
			defaultFontLabel.setFont(FigureGeneratorUtil.createBasicFont(null, 34, FontStyle.BOLD_LITERAL));
			defaultFontLabel.setForegroundColor(FigureGeneratorUtil.createConstantColor(ColorConstants.CYAN_LITERAL));
			deepLabelContainer.getChildren().add(defaultFontLabel);
		}
		return myRoot;
	}

	public CustomFigure getCustom() {
		if (myCustom == null) {
			myCustom = GMFGraphFactory.eINSTANCE.createCustomFigure();
			myCustom.setBundleName(FigureGeneratorUtil.DRAW2D);
			myCustom.setQualifiedClassName(ScrollBar.class.getName());
			myCustom.setName(CodeGenUtil.getSimpleClassName(ScrollBar.class.getName()));
		}
		return myCustom;
	}

	public org.eclipse.gmf.gmfgraph.PolylineConnection getLink() {
		if (myLink == null) {
			myLink = GMFGraphFactory.eINSTANCE.createPolylineConnection();
			myLink.setName("AlmostRedLink");
			myLink.setForegroundColor(FigureGeneratorUtil.createRGBColor(255, 1, 1));
		}
		return myLink;
	}

	// Also testing code generation for figurein in root package here.
	protected Config getConfig() {
		if (myConfig == null) {
			myConfig = FigureGeneratorUtil.createStandaloneGeneratorConfig(null, true);
		}
		return myConfig;
	}

}
