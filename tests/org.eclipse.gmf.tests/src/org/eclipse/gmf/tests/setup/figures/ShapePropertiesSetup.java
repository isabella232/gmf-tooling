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

import org.eclipse.gmf.gmfgraph.BasicFont;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.CompoundBorder;
import org.eclipse.gmf.gmfgraph.CustomAttribute;
import org.eclipse.gmf.gmfgraph.CustomBorder;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Insets;
import org.eclipse.gmf.gmfgraph.LineBorder;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.MarginBorder;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.ScalablePolygon;
import org.eclipse.gmf.gmfgraph.Shape;


public class ShapePropertiesSetup extends AbstractFigureGeneratorSetup {

	private Figure myContainer;
	private Shape myShape;
	private Figure myShape1;
	private Figure myWithInsets;
	private Figure myContainer1;
	private Figure myTester;
	private Figure myMarginTester;
	private Figure myRainbow;
	private Figure myWithMinAndMaxSize;
	private Figure myRoot;
	private Figure myCustomBorderTester;
	private ScalablePolygon myScalablePolygon;
	private Figure myInnerScalablePolygonTester;

	protected void addFigures(FigureGallery gallery) {
		gallery.getFigures().add(getContainer());
		gallery.getFigures().add(getShape());
		gallery.getFigures().add(getShape1());
		gallery.getFigures().add(getWithInsets());
		gallery.getFigures().add(getContainer1());
		gallery.getFigures().add(getTester());
		gallery.getFigures().add(getMarginTester());
		gallery.getFigures().add(getRainbow());
		gallery.getFigures().add(getWithMinAndMaxSize());
		gallery.getFigures().add(getRoot());
		gallery.getFigures().add(getCustomBorderTester());
		gallery.getFigures().add(getScalablePolygon());
		gallery.getFigures().add(getInnerScalablePolygonTester());
	}

	public Figure getRoot() {
		if (myRoot == null) {
			Rectangle noFontName = GMFGraphFactory.eINSTANCE.createRectangle();
			noFontName.setName("NoFontName");
			BasicFont noName = GMFGraphFactory.eINSTANCE.createBasicFont();
			noFontName.setFont(noName);
			
			Rectangle emptyFontName = GMFGraphFactory.eINSTANCE.createRectangle();
			emptyFontName.setName("EmptyFontName");
			BasicFont emptyName = GMFGraphFactory.eINSTANCE.createBasicFont();
			emptyName.setFaceName("");
			emptyFontName.setFont(emptyName);
			
			myRoot = GMFGraphFactory.eINSTANCE.createRectangle();
			myRoot.setName("Root");
			
			myRoot.getChildren().add(emptyFontName);
			myRoot.getChildren().add(noFontName);
		}
		return myRoot;
	}

	public Figure getWithMinAndMaxSize() {
		if (myWithMinAndMaxSize == null) {
			myWithMinAndMaxSize = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
			myWithMinAndMaxSize.setName("WithMinAndMaxSize");
			myWithMinAndMaxSize.setMaximumSize(FigureGeneratorUtil.createDimension(1000, 2000));
			myWithMinAndMaxSize.setMinimumSize(FigureGeneratorUtil.createDimension(234, 123));			
		}
		return myWithMinAndMaxSize;
	}

	public Figure getRainbow() {
		if (myRainbow == null) {
			myRainbow = GMFGraphFactory.eINSTANCE.createRectangle();
			myRainbow.setName("Rainbow");
			for (ColorConstants next : ColorConstants.VALUES){
				Rectangle nextColored = GMFGraphFactory.eINSTANCE.createRectangle();
				nextColored.setName(next.getLiteral());
				nextColored.setBackgroundColor(FigureGeneratorUtil.createConstantColor(next));
				myRainbow.getChildren().add(nextColored);
			}
		}
		return myRainbow;
	}

	public Figure getMarginTester() {
		if (myMarginTester == null) {
			MarginBorder border = GMFGraphFactory.eINSTANCE.createMarginBorder();
			border.setInsets(GMFGraphFactory.eINSTANCE.createInsets());
			border.getInsets().setBottom(23);
			border.getInsets().setTop(34);
			border.getInsets().setRight(45);
			border.getInsets().setLeft(56);
			
			myMarginTester = GMFGraphFactory.eINSTANCE.createEllipse();
			myMarginTester.setBorder(border);
			myMarginTester.setName("MarginTester");
		}
		return myMarginTester;
	}
	
	public Figure getCustomBorderTester(){
		if (myCustomBorderTester == null){
			myCustomBorderTester = GMFGraphFactory.eINSTANCE.createRectangle();
			myCustomBorderTester.setName("CustomBorderTester");
			
			CustomBorder singleCustomBorder = GMFGraphFactory.eINSTANCE.createCustomBorder();
			singleCustomBorder.setQualifiedClassName(org.eclipse.draw2d.LineBorder.class.getName());
			CustomAttribute borderColor = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			borderColor.setName("color");
			borderColor.setValue("org.eclipse.draw2d.ColorConstants.blue");
			CustomAttribute borderWidth = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			borderWidth.setName("width");
			borderWidth.setValue("2");
			singleCustomBorder.getAttributes().add(borderColor);
			singleCustomBorder.getAttributes().add(borderWidth);
			myCustomBorderTester.setBorder(singleCustomBorder);
			
			Figure innerRectangle = GMFGraphFactory.eINSTANCE.createRectangle();
			innerRectangle.setName("TesterOfCompoundBorderWithCustomComponent");
			myCustomBorderTester.getChildren().add(innerRectangle);
			
			CompoundBorder compoundBorderWithCustomComponent = GMFGraphFactory.eINSTANCE.createCompoundBorder();
			MarginBorder justSomeGMFBorder = GMFGraphFactory.eINSTANCE.createMarginBorder();
			justSomeGMFBorder.setInsets(GMFGraphFactory.eINSTANCE.createInsets());
			justSomeGMFBorder.getInsets().setBottom(5);
			justSomeGMFBorder.getInsets().setTop(5);
			justSomeGMFBorder.getInsets().setLeft(5);
			justSomeGMFBorder.getInsets().setRight(5);
			compoundBorderWithCustomComponent.setInner(justSomeGMFBorder);
			
			CustomBorder customBorderAsComponent = GMFGraphFactory.eINSTANCE.createCustomBorder();
			customBorderAsComponent.setQualifiedClassName(org.eclipse.draw2d.TitleBarBorder.class.getName());
			CustomAttribute labelAttribute = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			labelAttribute.setName("label");
			labelAttribute.setValue("\"Label Text\"");
			
			CustomAttribute paddingAttribute = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			paddingAttribute.setName("padding");
			paddingAttribute.setValue("5");
			customBorderAsComponent.getAttributes().add(labelAttribute);
			customBorderAsComponent.getAttributes().add(paddingAttribute);
			compoundBorderWithCustomComponent.setOuter(customBorderAsComponent);
			innerRectangle.setBorder(compoundBorderWithCustomComponent);
		}
		return myCustomBorderTester;
	}

	public Figure getTester() {
		if (myTester == null) {
			LineBorder outerOuter = GMFGraphFactory.eINSTANCE.createLineBorder();
			outerOuter.setColor(FigureGeneratorUtil.createConstantColor(ColorConstants.BLUE_LITERAL));
			outerOuter.setWidth(22);
			
			MarginBorder outerInner = GMFGraphFactory.eINSTANCE.createMarginBorder();
			outerInner.setInsets(GMFGraphFactory.eINSTANCE.createInsets());
			outerInner.getInsets().setBottom(23);
			outerInner.getInsets().setTop(34);
			//sic! outerInner.getInsets().setRight(45);
			//sic! outerInner.getInsets().setLeft(56);
			
			CompoundBorder outer = GMFGraphFactory.eINSTANCE.createCompoundBorder();
			outer.setOuter(outerOuter);
			outer.setInner(outerInner);
			
			CompoundBorder innerEmpty = GMFGraphFactory.eINSTANCE.createCompoundBorder();
			//sic!
			innerEmpty.setInner(null);
			innerEmpty.setOuter(null);
			
			CompoundBorder result = GMFGraphFactory.eINSTANCE.createCompoundBorder();
			result.setOuter(outer);
			result.setInner(innerEmpty);
			
			myTester = GMFGraphFactory.eINSTANCE.createRectangle();
			myTester.setBorder(result);
			myTester.setName("Tester");
		}
		return myTester;
	}

	public Figure getContainer1() {
		if (myContainer1 == null) {
			myContainer1 = GMFGraphFactory.eINSTANCE.createRectangle();
			myContainer1.setName("Container1");

			Rectangle colorAndWidth = GMFGraphFactory.eINSTANCE.createRectangle();
			colorAndWidth.setName("ColorAndWidth");
			LineBorder colorAndWidthBorder = GMFGraphFactory.eINSTANCE.createLineBorder();
			colorAndWidthBorder.setColor(FigureGeneratorUtil.createConstantColor(ColorConstants.CYAN_LITERAL));
			colorAndWidthBorder.setWidth(23);
			colorAndWidth.setBorder(colorAndWidthBorder);

			Rectangle onlyColor = GMFGraphFactory.eINSTANCE.createRectangle();
			onlyColor.setName("OnlyColor");
			LineBorder onlyColorBorder = GMFGraphFactory.eINSTANCE.createLineBorder();
			onlyColorBorder.setColor(FigureGeneratorUtil.createConstantColor(ColorConstants.CYAN_LITERAL));
			onlyColor.setBorder(onlyColorBorder);

			Rectangle onlyWidth = GMFGraphFactory.eINSTANCE.createRectangle();
			onlyWidth.setName("OnlyWidth");
			LineBorder onlyWidthBorder = GMFGraphFactory.eINSTANCE.createLineBorder();
			onlyWidthBorder.setWidth(34);
			onlyWidth.setBorder(onlyWidthBorder);

			Rectangle empty = GMFGraphFactory.eINSTANCE.createRectangle();
			empty.setName("Empty");
			LineBorder emptyBorder = GMFGraphFactory.eINSTANCE.createLineBorder();
			empty.setBorder(emptyBorder);
			
			myContainer1.getChildren().add(colorAndWidth);
			myContainer1.getChildren().add(onlyColor);
			myContainer1.getChildren().add(onlyWidth);
			myContainer1.getChildren().add(empty);
		}
		return myContainer1;
	}

	public Figure getWithInsets() {
		if (myWithInsets == null) {
			myWithInsets = GMFGraphFactory.eINSTANCE.createRectangle();
			myWithInsets.setName("WithInsets");
			Insets insets = GMFGraphFactory.eINSTANCE.createInsets();
			insets.setBottom(23);
			insets.setTop(34);
			insets.setRight(45);
			insets.setLeft(56);
			myWithInsets.setInsets(insets);
		}
		return myWithInsets;
	}

	public Figure getShape1() {
		if (myShape1 == null) {
			myShape1 = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
			myShape1.setName("WithArialFont");
			myShape1.setFont(FigureGeneratorUtil.createBasicFont("Arial", 10, FontStyle.NORMAL_LITERAL));
		}
		return myShape1;
	}
	
	public Figure getShape() {
		if (myShape == null) {
			myShape = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
			myShape.setLineWidth(23);
			myShape.setName("Bold");
		}
		return myShape;
	}

	public Figure getContainer() {
		if (myContainer == null) {
			myContainer = GMFGraphFactory.eINSTANCE.createRectangle();
			myContainer.setName("Container");
			for (LineKind next : LineKind.VALUES) {
				Shape shape = GMFGraphFactory.eINSTANCE.createEllipse();
				shape.setName("Ellipse_" + next.getLiteral());
				shape.setLineKind(next);
				myContainer.getChildren().add(shape);
			}
		}
		return myContainer;
	}

	public Figure getScalablePolygon(){
		if (myScalablePolygon == null){
			myScalablePolygon = GMFGraphFactory.eINSTANCE.createScalablePolygon();
			myScalablePolygon.setName("ScalableRhomb");
			myScalablePolygon.setBackgroundColor(FigureGeneratorUtil.createConstantColor(ColorConstants.YELLOW_LITERAL));
			
			myScalablePolygon.getTemplate().add(FigureGeneratorUtil.createPoint(3, 0));
			myScalablePolygon.getTemplate().add(FigureGeneratorUtil.createPoint(6, 3));
			myScalablePolygon.getTemplate().add(FigureGeneratorUtil.createPoint(3, 6));
			myScalablePolygon.getTemplate().add(FigureGeneratorUtil.createPoint(0, 3));
		}
		return myScalablePolygon;
	}
	
	public Figure getInnerScalablePolygonTester(){
		if (myInnerScalablePolygonTester == null){
			myInnerScalablePolygonTester = GMFGraphFactory.eINSTANCE.createRectangle();
			myInnerScalablePolygonTester.setName("InnerScalablePolygonTester");

			ScalablePolygon innerScalableTriangle = GMFGraphFactory.eINSTANCE.createScalablePolygon();
			innerScalableTriangle.setName("InnerScalableTriangle");
			innerScalableTriangle.setForegroundColor(FigureGeneratorUtil.createConstantColor(ColorConstants.RED_LITERAL));
			innerScalableTriangle.setInsets(GMFGraphFactory.eINSTANCE.createInsets());
			innerScalableTriangle.getInsets().setBottom(10);
			innerScalableTriangle.getInsets().setTop(10);
			innerScalableTriangle.getInsets().setLeft(5);
			innerScalableTriangle.getInsets().setRight(5);
			
			innerScalableTriangle.getTemplate().add(FigureGeneratorUtil.createPoint(3, 0));
			innerScalableTriangle.getTemplate().add(FigureGeneratorUtil.createPoint(0, 4));
			innerScalableTriangle.getTemplate().add(FigureGeneratorUtil.createPoint(6, 4));
			
			myInnerScalablePolygonTester.getChildren().add(innerScalableTriangle);
		}
		return myInnerScalablePolygonTester;
		
	}
}
