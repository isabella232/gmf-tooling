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

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.gmfgraph.BasicFont;
import org.eclipse.gmf.gmfgraph.Color;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.Font;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.Polyline;
import org.eclipse.gmf.gmfgraph.RGBColor;
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
	
	private void checkFigure(Figure gmfFigure, IFigure d2dFigure){
		checkFigureItself(gmfFigure, d2dFigure);
		checkFigureChildren(gmfFigure, d2dFigure);
	}
	
	private void checkFigureChildren(Figure gmfFigure, IFigure d2dFigure){
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
	
	private void checkFigureItself(Figure gmfFigure, IFigure d2dFigure){
		checkSize(gmfFigure, d2dFigure);
		checkPreferredSize(gmfFigure, d2dFigure);
		checkFont(gmfFigure, d2dFigure);
		checkForeground(gmfFigure, d2dFigure);
		checkBackgroud(gmfFigure, d2dFigure);
		checkLabelText(gmfFigure, d2dFigure);
		checkPolylinePoints(gmfFigure, d2dFigure);
	}
	
	private void checkPolylinePoints(Figure gmfFigure, IFigure d2dFigure) {
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

	private void checkLabelText(Figure gmfFigure, IFigure d2dFigure) {
		if (gmfFigure instanceof Label && gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getLabel_Text())){
			assertTrue(d2dFigure instanceof org.eclipse.draw2d.Label);
			org.eclipse.draw2d.Label d2dLabel = (org.eclipse.draw2d.Label)d2dFigure;
			Label gmfLabel = (Label)gmfFigure;
			assertEquals(gmfLabel.getText(), d2dLabel.getText());
		}
	}

	private void checkBackgroud(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())){
			checkColor(gmfFigure.getBackgroundColor(), figure.getBackgroundColor());
		}
	}

	private void checkForeground(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())){
			checkColor(gmfFigure.getForegroundColor(), figure.getForegroundColor());
		}
	}

	private void checkColor(Color eColor, org.eclipse.swt.graphics.Color swtColor){
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
	
	private void checkFont(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Font())){
			Font eFont = gmfFigure.getFont();
			checkFont(eFont, figure.getFont());
		}
	}
	
	private void checkFont(Font gmfFont, org.eclipse.swt.graphics.Font actual){
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
		switch(color.getValue().getValue()){
			case ColorConstants.BLACK : return org.eclipse.draw2d.ColorConstants.black;
			case ColorConstants.BLUE : return org.eclipse.draw2d.ColorConstants.blue;
			case ColorConstants.CYAN : return org.eclipse.draw2d.ColorConstants.cyan;
			case ColorConstants.DARK_BLUE : return org.eclipse.draw2d.ColorConstants.darkBlue;
			case ColorConstants.DARK_GRAY: return org.eclipse.draw2d.ColorConstants.darkGray;
			case ColorConstants.DARK_GREEN: return org.eclipse.draw2d.ColorConstants.darkGreen;
			case ColorConstants.GRAY: return org.eclipse.draw2d.ColorConstants.gray;
			case ColorConstants.GREEN: return org.eclipse.draw2d.ColorConstants.green;
			case ColorConstants.LIGHT_BLUE: return org.eclipse.draw2d.ColorConstants.lightBlue;
			case ColorConstants.LIGHT_GRAY: return org.eclipse.draw2d.ColorConstants.lightGray;
			case ColorConstants.LIGHT_GREEN: return org.eclipse.draw2d.ColorConstants.lightGreen;
			case ColorConstants.ORANGE: return org.eclipse.draw2d.ColorConstants.orange;
			case ColorConstants.RED: return org.eclipse.draw2d.ColorConstants.red;
			case ColorConstants.WHITE: return org.eclipse.draw2d.ColorConstants.white;
			case ColorConstants.YELLOW: return org.eclipse.draw2d.ColorConstants.yellow;
			default: throw new IllegalArgumentException("Unknown Color: " + color);
		}
	}

	private RGB transformRGBColor(RGBColor color) {
		return new RGB(color.getRed(), color.getGreen(), color.getBlue());
	}

	private void checkPreferredSize(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())){
			Dimension ePreferredSize = gmfFigure.getPreferredSize();
			assertEquals(new org.eclipse.draw2d.geometry.Dimension(ePreferredSize.getDx(), ePreferredSize.getDy()), figure.getPreferredSize());
		}
	}

	private void checkSize(Figure gmfFigure, IFigure figure) {
		if (gmfFigure.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Size())){
			Point eSize = gmfFigure.getSize();
			assertEquals(new org.eclipse.draw2d.geometry.Dimension(eSize.getX(), eSize.getY()), figure.getSize());
		}
	}

}
