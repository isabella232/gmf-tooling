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

import org.eclipse.gmf.gmfgraph.BasicFont;
import org.eclipse.gmf.gmfgraph.Color;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.CompoundBorder;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Insets;
import org.eclipse.gmf.gmfgraph.LineBorder;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.MarginBorder;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.gmfgraph.Shape;

public class ShapePropertiesTest extends FigureCodegenTestBase {
	public ShapePropertiesTest(String name) {
		super(name);
	}

	public void testShapeLineStyle() {
		Rectangle container = GMFGraphFactory.eINSTANCE.createRectangle();
		container.setName("Container");
		for (Iterator kinds = LineKind.VALUES.iterator(); kinds.hasNext(); ) {
			LineKind next = (LineKind) kinds.next();
			Shape shape = GMFGraphFactory.eINSTANCE.createEllipse();
			shape.setName("Ellipse_" + next.getLiteral());
			shape.setLineKind(next);
			container.getChildren().add(shape);
		}
		performTests(container);
	}

	public void testShapeLineWidth() {
		Shape shape = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		shape.setLineWidth(23);
		shape.setName("Bold");
		performTests(shape);
	}

	public void testShapeInsets() {
		Rectangle withInsets = GMFGraphFactory.eINSTANCE.createRectangle();
		withInsets.setName("WithInsets");
		Insets insets = GMFGraphFactory.eINSTANCE.createInsets();
		insets.setBottom(23);
		insets.setTop(34);
		insets.setRight(45);
		insets.setLeft(56);
		withInsets.setInsets(insets);

		performTests(withInsets);
	}

	public void testLineBorder() {
		Rectangle container = GMFGraphFactory.eINSTANCE.createRectangle();
		container.setName("Root");

		Rectangle colorAndWidth = GMFGraphFactory.eINSTANCE.createRectangle();
		colorAndWidth.setName("ColorAndWidth");
		LineBorder colorAndWidthBorder = GMFGraphFactory.eINSTANCE.createLineBorder();
		colorAndWidthBorder.setColor(createConstantColor(ColorConstants.CYAN_LITERAL));
		colorAndWidthBorder.setWidth(23);
		colorAndWidth.setBorder(colorAndWidthBorder);

		Rectangle onlyColor = GMFGraphFactory.eINSTANCE.createRectangle();
		onlyColor.setName("OnlyColor");
		LineBorder onlyColorBorder = GMFGraphFactory.eINSTANCE.createLineBorder();
		onlyColorBorder.setColor(createConstantColor(ColorConstants.CYAN_LITERAL));
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
		
		container.getChildren().add(colorAndWidth);
		container.getChildren().add(onlyColor);
		container.getChildren().add(onlyWidth);
		container.getChildren().add(empty);
		
		performTests(container);
	}
	
	public void testCompoundBorder(){
		LineBorder outerOuter = GMFGraphFactory.eINSTANCE.createLineBorder();
		outerOuter.setColor(createConstantColor(ColorConstants.BLUE_LITERAL));
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
		
		Rectangle tester = GMFGraphFactory.eINSTANCE.createRectangle();
		tester.setBorder(result);
		tester.setName("Tester");
		
		performTests(tester);
	}
	
	public void testMarginBorder(){
		MarginBorder border = GMFGraphFactory.eINSTANCE.createMarginBorder();
		border.setInsets(GMFGraphFactory.eINSTANCE.createInsets());
		border.getInsets().setBottom(23);
		border.getInsets().setTop(34);
		border.getInsets().setRight(45);
		border.getInsets().setLeft(56);
		
		Shape marginTester = GMFGraphFactory.eINSTANCE.createEllipse();
		marginTester.setBorder(border);
		marginTester.setName("MarginTester");
		
		performTests(marginTester);
	}
	
	public void testConstantColors(){
		Rectangle rainbow = GMFGraphFactory.eINSTANCE.createRectangle();
		rainbow.setName("Rainbow");
		for (Iterator colors = ColorConstants.VALUES.iterator(); colors.hasNext();){
			ColorConstants next = (ColorConstants)colors.next();
			Rectangle nextColored = GMFGraphFactory.eINSTANCE.createRectangle();
			nextColored.setName(next.getLiteral());
			nextColored.setBackgroundColor(createConstantColor(next));
			rainbow.getChildren().add(nextColored);
		}
		performTests(rainbow);
	}
	
	public void testMaxAndMinSize(){
		RoundedRectangle withMinAndMaxSize = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		withMinAndMaxSize.setName("WithMinAndMaxSize");
		withMinAndMaxSize.setMaximumSize(createDimension(1000, 2000));
		withMinAndMaxSize.setMinimumSize(createDimension(234, 123));
		performTests(withMinAndMaxSize);
	}
	
	public void testDefaultFontName(){
		Rectangle noFontName = GMFGraphFactory.eINSTANCE.createRectangle();
		noFontName.setName("NoFontName");
		BasicFont noName = GMFGraphFactory.eINSTANCE.createBasicFont();
		noFontName.setFont(noName);
		
		Rectangle emptyFontName = GMFGraphFactory.eINSTANCE.createRectangle();
		emptyFontName.setName("EmptyFontName");
		BasicFont emptyName = GMFGraphFactory.eINSTANCE.createBasicFont();
		emptyName.setFaceName("");
		emptyFontName.setFont(emptyName);
		
		Rectangle root = GMFGraphFactory.eINSTANCE.createRectangle();
		root.setName("Root");
		
		root.getChildren().add(emptyFontName);
		root.getChildren().add(noFontName);
		
		performTests(root);
	}
	
	
	
	private Dimension createDimension(int x, int y){
		Dimension result = GMFGraphFactory.eINSTANCE.createDimension();
		result.setDx(x);
		result.setDy(y);
		return result;
	}
	
	private Color createConstantColor(ColorConstants constant) {
		ConstantColor result = GMFGraphFactory.eINSTANCE.createConstantColor();
		result.setValue(constant);
		return result;
	}
	
	

}
