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

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.gmfgraph.BasicFont;
import org.eclipse.gmf.gmfgraph.Border;
import org.eclipse.gmf.gmfgraph.Color;
import org.eclipse.gmf.gmfgraph.CompoundBorder;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.Font;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.Insets;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LineBorder;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.MarginBorder;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.Polyline;
import org.eclipse.gmf.gmfgraph.RGBColor;
import org.eclipse.gmf.gmfgraph.Shape;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

public class GenericFigureCheck extends FigureCodegenTestBase.FigureCheck {
	private final Figure myGMFRootFigure;

	public GenericFigureCheck(Figure eFigure){
		myGMFRootFigure = eFigure;
	}

	public void checkFigure(IFigure figure) {
		assertNotNull(figure);
		checkFigure(myGMFRootFigure, figure);
	}
	
	protected void checkFigure(Figure gmfFigure, IFigure d2dFigure){
		checkFigureItself(gmfFigure, d2dFigure);
		checkFigureChildren(gmfFigure, d2dFigure);
	}
	
	protected void checkFigureChildren(Figure gmfFigure, IFigure d2dFigure){
		List gmfChildren = gmfFigure.getChildren();
		List d2dChildren = d2dFigure.getChildren();
		assertNotNull(gmfChildren);
		assertNotNull(d2dChildren);
		assertEquals(gmfChildren.size(), d2dChildren.size());
		
		Iterator gmfIter = gmfChildren.iterator();
		Iterator d2dIter = d2dChildren.iterator();
		
		while (gmfIter.hasNext() && d2dIter.hasNext()){
			Figure nextGMF = (Figure) gmfIter.next();
			IFigure nextD2D = (IFigure) d2dIter.next();
			checkFigure(nextGMF, nextD2D);
		}
	}
	
	protected void checkFigureItself(Figure gmfFigure, IFigure d2dFigure){
		checkSize(gmfFigure, d2dFigure);
		//XXX: checkLocation(gmfFigure, d2dFigure);
		checkMaximumSize(gmfFigure, d2dFigure);
		checkMinimumSize(gmfFigure, d2dFigure);
		checkPreferredSize(gmfFigure, d2dFigure);
		checkFont(gmfFigure, d2dFigure);
		checkForeground(gmfFigure, d2dFigure);
		checkBackgroud(gmfFigure, d2dFigure);
		checkInsets(gmfFigure, d2dFigure);
		checkBorder(gmfFigure, d2dFigure);
		checkShapeProperties(gmfFigure, d2dFigure);
		checkLabelText(gmfFigure, d2dFigure);
		checkPolylinePoints(gmfFigure, d2dFigure);
	}

	private void checkShapeProperties(Figure gmfFigure, IFigure figure) {
		if (gmfFigure instanceof Shape){
			Shape eShape = (Shape)gmfFigure; 
			assertTrue(figure instanceof org.eclipse.draw2d.Shape);
			org.eclipse.draw2d.Shape d2dShape = (org.eclipse.draw2d.Shape)figure;
			checkLineKind(eShape, d2dShape);
			checkLineWidth(eShape, d2dShape);
		}
	}

	protected void checkLineWidth(Shape eShape, org.eclipse.draw2d.Shape d2dShape) {
		if (eShape.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())){
			int expected = eShape.getLineWidth();
			assertEquals(expected, d2dShape.getLineWidth());
		}
	}

	protected void checkLineKind(Shape eShape, org.eclipse.draw2d.Shape d2dShape) {
		if (eShape.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())){
			LineKind expected = eShape.getLineKind();
			assertEquals(transformLineKind(expected), d2dShape.getLineStyle());
		}
	}
	
	private int transformLineKind(LineKind kind){
		Object d2dValue = getStaticFieldValue("Unknown LineKind: " + kind, Graphics.class, kind.getName());
		assertTrue(d2dValue instanceof Integer);
		return ((Integer)d2dValue).intValue();
	}

	protected final void checkDimension(Dimension eDimension, org.eclipse.draw2d.geometry.Dimension d2dDimension){
		assertEquals(new org.eclipse.draw2d.geometry.Dimension(eDimension.getDx(), eDimension.getDy()), d2dDimension);		
	}

	protected void checkPolylinePoints(Figure gmfFigure, IFigure d2dFigure) {
		if (gmfFigure instanceof Polyline && gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getPolyline_Template())){
			Polyline gmfPolyline = (Polyline)gmfFigure;
			assertTrue(d2dFigure instanceof org.eclipse.draw2d.Polyline);
			org.eclipse.draw2d.Polyline d2dPolyline = (org.eclipse.draw2d.Polyline)d2dFigure;
			
			PointList d2dPoints = d2dPolyline.getPoints();
			List gmfPoints = gmfPolyline.getTemplate();
			
			assertEquals(gmfPoints.size(), d2dPoints.size());
			for (int i = 0; i < d2dPoints.size(); i++){
				Point ePoint = (Point) gmfPoints.get(i);
				org.eclipse.draw2d.geometry.Point d2dPoint = d2dPoints.getPoint(i);
				
				assertEquals(new org.eclipse.draw2d.geometry.Point(ePoint.getX(), ePoint.getY()), d2dPoint);
			}
		}
		
	}

	protected void checkLabelText(Figure gmfFigure, IFigure d2dFigure) {
		if (gmfFigure instanceof Label && gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getLabel_Text())){
			assertTrue(d2dFigure instanceof org.eclipse.draw2d.Label);
			org.eclipse.draw2d.Label d2dLabel = (org.eclipse.draw2d.Label)d2dFigure;
			Label gmfLabel = (Label)gmfFigure;
			assertEquals(gmfLabel.getText(), d2dLabel.getText());
		}
	}

	protected void checkBackgroud(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())){
			checkColor(gmfFigure.getBackgroundColor(), figure.getBackgroundColor());
		}
	}

	protected void checkForeground(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())){
			checkColor(gmfFigure.getForegroundColor(), figure.getForegroundColor());
		}
	}

	protected final void checkColor(Color eColor, org.eclipse.swt.graphics.Color swtColor){
		assertNotNull(swtColor);
		assertNotNull(eColor);
		
		RGB expectedRGB;
		if (eColor instanceof ConstantColor){
			expectedRGB = transformConstantColor((ConstantColor)eColor).getRGB();
		} else if (eColor instanceof RGBColor){
			expectedRGB = transformRGBColor((RGBColor)eColor);
		} else {
			throw new IllegalStateException("Unknown color: " + eColor);
		}
		assertEquals(expectedRGB, swtColor.getRGB());
	}
	
	protected void checkFont(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Font())){
			Font eFont = gmfFigure.getFont();
			checkFont(eFont, figure.getFont());
		}
	}
	
	protected final void checkFont(Font gmfFont, org.eclipse.swt.graphics.Font actual){
		assertNotNull(actual);
		if (gmfFont instanceof BasicFont && actual.getFontData().length == 1){
			BasicFont expected = (BasicFont)gmfFont;
			FontData theOnly = actual.getFontData()[0];
			assertEquals(expected.getFaceName(), theOnly.getName());
			assertEquals(expected.getHeight(), theOnly.getHeight());
			
			int expectedStyle = gmfStyle2swtStyle(expected.getStyle());
			assertEquals(expectedStyle, theOnly.getStyle());
		}
	}
	
	private int gmfStyle2swtStyle(FontStyle gmfStyle){
		switch (gmfStyle.getValue()){
			case FontStyle.BOLD : return SWT.BOLD;
			case FontStyle.ITALIC : return SWT.ITALIC;
			case FontStyle.NORMAL : return SWT.NORMAL;
			default: throw new IllegalStateException("Unknown font style: " + gmfStyle);
		}
	}

	private org.eclipse.swt.graphics.Color transformConstantColor(ConstantColor color) {
		Class d2dClass = org.eclipse.draw2d.ColorConstants.class;
		Object d2dValue = getStaticFieldValue("Unknown color: " + color, d2dClass, color.getValue().getLiteral());
		assertTrue(d2dValue instanceof org.eclipse.swt.graphics.Color);
		return (org.eclipse.swt.graphics.Color)d2dValue;
	}
	
	private Object getStaticFieldValue(String failureMessage, Class clazz, String fieldName){
		try {
			Field constant = clazz.getField(fieldName);
			assertNotNull(failureMessage, constant);
			Object value = constant.get(null);
			assertNotNull(failureMessage, value);
			return value;
		} catch (Exception e) {
			fail(failureMessage + "\n" + e.toString());
			throw new InternalError("Unreachable");
		}
	}

	private RGB transformRGBColor(RGBColor color) {
		return new RGB(color.getRed(), color.getGreen(), color.getBlue());
	}

	protected void checkPreferredSize(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())){
			Dimension ePreferredSize = gmfFigure.getPreferredSize();
			checkDimension(ePreferredSize, figure.getPreferredSize());
		}
	}

	protected void checkSize(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Size())){
			Point eSize = gmfFigure.getSize();
			assertEquals(new org.eclipse.draw2d.geometry.Dimension(eSize.getX(), eSize.getY()), figure.getSize());
		}
	}
	
	protected void checkMaximumSize(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_MaximumSize())){
			Dimension eSize = gmfFigure.getMaximumSize();
			checkDimension(eSize, figure.getMaximumSize());
		}
	}
	
	protected void checkMinimumSize(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_MinimumSize())){
			Dimension eSize = gmfFigure.getMinimumSize();
			checkDimension(eSize, figure.getMinimumSize());
		}
	}
	
	
	protected void checkBorder(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Border())){
			Border eBorder = gmfFigure.getBorder();
			checkBorder(eBorder, figure.getBorder(), figure);
		}
	}
	
	protected final void checkBorder(Border eBorder, org.eclipse.draw2d.Border d2dBorder, IFigure mainD2DFigure){
		assertNotNull(eBorder);
		assertNotNull(d2dBorder);
		if (eBorder instanceof LineBorder){
			checkLineBorder((LineBorder)eBorder, d2dBorder);
		} else if (eBorder instanceof CompoundBorder){
			checkCompoundBorder((CompoundBorder)eBorder, d2dBorder, mainD2DFigure);
		} else if (eBorder instanceof MarginBorder){
			checkMarginBorder((MarginBorder)eBorder, d2dBorder, mainD2DFigure);
		}
	}
	
	protected final void checkMarginBorder(MarginBorder eBorder, org.eclipse.draw2d.Border d2dBorder, IFigure mainD2DFigure) {
		assertTrue(d2dBorder instanceof org.eclipse.draw2d.MarginBorder);
		org.eclipse.draw2d.MarginBorder actual = (org.eclipse.draw2d.MarginBorder)d2dBorder;
		if (eBorder.eIsSet(GMFGraphPackage.eINSTANCE.getMarginBorder_Insets())){
			Insets eInsets = eBorder.getInsets();
			checkInsets(eInsets, actual.getInsets(mainD2DFigure));
		}
	}

	protected final void checkCompoundBorder(CompoundBorder eBorder, org.eclipse.draw2d.Border d2dBorder, IFigure mainD2DFigure){
		assertTrue(d2dBorder instanceof org.eclipse.draw2d.CompoundBorder);
		org.eclipse.draw2d.CompoundBorder actual = (org.eclipse.draw2d.CompoundBorder)d2dBorder;
		if (eBorder.eIsSet(GMFGraphPackage.eINSTANCE.getCompoundBorder_Inner())){
			checkBorder(eBorder.getInner(), actual.getInnerBorder(), mainD2DFigure);
		}
		if (eBorder.eIsSet(GMFGraphPackage.eINSTANCE.getCompoundBorder_Outer())){
			checkBorder(eBorder.getOuter(), actual.getOuterBorder(), mainD2DFigure);
		}
	}
	
	protected final void checkLineBorder(LineBorder eBorder, org.eclipse.draw2d.Border d2dBorder){
		assertTrue(d2dBorder instanceof org.eclipse.draw2d.LineBorder);
		org.eclipse.draw2d.LineBorder actual = (org.eclipse.draw2d.LineBorder)d2dBorder;
		//intentionally always checked, there is a default value mathcing default value in d2d
		assertEquals(eBorder.getWidth(), actual.getWidth());
		 
		if (eBorder.eIsSet(GMFGraphPackage.eINSTANCE.getLineBorder_Color())){
			checkColor(eBorder.getColor(), actual.getColor());
		}
	}

	protected void checkInsets(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Insets())){
			checkInsets(gmfFigure.getInsets(), figure.getInsets());
		}
	}
	
	protected final void checkInsets(Insets eInsets, org.eclipse.draw2d.geometry.Insets d2dInsets){
		assertNotNull(d2dInsets);
		assertNotNull(eInsets);
		assertEquals(new org.eclipse.draw2d.geometry.Insets(eInsets.getTop(), eInsets.getLeft(), eInsets.getBottom(), eInsets.getRight()), d2dInsets);
	}

}
