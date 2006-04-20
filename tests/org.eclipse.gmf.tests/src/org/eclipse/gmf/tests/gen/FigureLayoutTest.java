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

import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.BorderLayout;
import org.eclipse.gmf.gmfgraph.BorderLayoutData;
import org.eclipse.gmf.gmfgraph.CustomAttribute;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.CustomLayout;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureMarker;
import org.eclipse.gmf.gmfgraph.FigureRef;
import org.eclipse.gmf.gmfgraph.FlowLayout;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.GridLayout;
import org.eclipse.gmf.gmfgraph.GridLayoutData;
import org.eclipse.gmf.gmfgraph.LayoutData;
import org.eclipse.gmf.gmfgraph.RGBColor;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.gmfgraph.XYLayoutData;

public class FigureLayoutTest extends FigureCodegenTestBase {
	public FigureLayoutTest(String name){
		super(name);
	}
	
	public void disabled_XXX_testGridLayout(){
		//XXX: This test now fails due to absence of the GridLayout.
		//However, some less restictive checks done for grid layout in the performGridLayputTests() method    	
		//If this test passes, it is safe to replace performGridLayputTests() with perfromTests() in the whole class.
		Figure parent = figure2();
		parent.setLayout(createGridLayoutAllProperties());
		performTests(parent);
	}
	
	public void testConcreteShapeLayoutAllProperties(){
		Figure parent = figure2();
		EList children = parent.getChildren();
		assertFalse("Precondition -- children required to test layout", children.isEmpty());
		
		parent.setLayout(createGridLayoutAllProperties());
		
		boolean oddChild = false;
		for (Iterator it = children.iterator(); it.hasNext();){
			FigureMarker next = (FigureMarker)it.next();
			oddChild = !oddChild;
			LayoutData data = createGridLayoutDataAllProperties(oddChild);
			next.setLayoutData(data);
			assertEquals("data-owner relation should be bidirectional", next, data.getOwner());
		}
		performGridLayoutTests(parent);
	}
	
	public void testCustomFigureLayoutAllProperties(){
		Figure parent = figure1();
		parent.setName("Parent");
		GridLayout layout = createGridLayoutAllProperties();
		layout.setNumColumns(1);
		layout.setEqualWidth(false);
		parent.setLayout(layout);
		
		for (Iterator children = parent.getChildren().iterator(); children.hasNext();){
			FigureMarker next = (FigureMarker)children.next();
			GridLayoutData data = createGridLayoutDataAllProperties(false);
			data.setHorizontalAlignment(Alignment.FILL_LITERAL);
			data.setOwner(next);
			assertEquals("data-owner relation should be bidirectional", data, next.getLayoutData());
		}
		performGridLayoutTests(parent);
	}
	
	public void testDeepChildrenLayout(){
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setName("Root");
		
		Figure next = parent;
		for (int i = 0; i < 4; i++){
			next = addPairOfChildRectanglesAndReturnLeft(next);
		}
		performTests(parent);
	}
	
	public void testLayoutDefaults(){
		Figure parent = GMFGraphFactory.eINSTANCE.createEllipse();
		parent.setName("GenEllipse");
		parent.setLayout(GMFGraphFactory.eINSTANCE.createGridLayout());
		
		Figure top = GMFGraphFactory.eINSTANCE.createLabel();
		top.setName("Top");
		top.setLayoutData(GMFGraphFactory.eINSTANCE.createGridLayoutData());
		parent.getChildren().add(top);
		
		Figure bottom = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		bottom.setName("Bottom");
		bottom.setLayoutData(GMFGraphFactory.eINSTANCE.createGridLayoutData());
		parent.getChildren().add(bottom);
		
		performGridLayoutTests(parent);
	}
	
	public void testLayoutForReferencedChild(){
		Figure actualContainer = figure2();
		Figure referencedFigure = (Figure) actualContainer.getChildren().get(0);
		
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setName("ReferencedFigureParent");
		parent.setLayout(createGridLayoutAllProperties());
		
		FigureRef refChildA = GMFGraphFactory.eINSTANCE.createFigureRef();
		refChildA.setFigure(referencedFigure);
		refChildA.setLayoutData(createGridLayoutDataAllProperties(false));
		
		//same figure is referenced, different layout data
		FigureRef refChildB = GMFGraphFactory.eINSTANCE.createFigureRef();
		refChildB.setFigure(referencedFigure);
		refChildB.setLayoutData(createGridLayoutDataAllProperties(true));
		
		parent.getChildren().add(refChildA);
		parent.getChildren().add(refChildB);
		
		performGridLayoutTests(parent);
	}
	
	public void testMissedLayoutPresentLayoutData(){
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setName("ParentWithoutLayout");
		assertNull(parent.getLayout());
		
		Figure child = GMFGraphFactory.eINSTANCE.createRectangle();
		child.setName("childWithLayoutData");
		child.setLayoutData(createGridLayoutDataAllProperties(false));
		
		parent.getChildren().add(child);
		
		performTests(parent);
	}
	
	public void testBorderLayout(){
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setName("BorderedContents");
		
		BorderLayout layout = GMFGraphFactory.eINSTANCE.createBorderLayout();
		layout.setSpacing(createDimension(2, 4));
		parent.setLayout(layout);
		
		Figure centerA = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		centerA.setName("Center_1");
		centerA.setLayoutData(createLayoutData(Alignment.CENTER_LITERAL, false));

		Figure left = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		left.setName("Left");
		left.setLayoutData(createLayoutData(Alignment.BEGINNING_LITERAL, false));

		Figure right = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		right.setName("Right");
		right.setLayoutData(createLayoutData(Alignment.END_LITERAL, false));

		Figure top = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		top.setName("Top");
		top.setLayoutData(createLayoutData(Alignment.BEGINNING_LITERAL, true));

		Figure bottom = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		bottom.setName("Bottom");
		bottom.setLayoutData(createLayoutData(Alignment.END_LITERAL, true));
		
		parent.getChildren().addAll(Arrays.asList(new Figure[] {top, bottom, left, right, centerA}));
		
		performTests(parent);
	}
	
	public void testBorderLayoutDataCenter(){
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setName("Matreshka");
		
		LayoutData[] allAreCenters = new LayoutData[] {
			createLayoutData(Alignment.CENTER_LITERAL, true), 
			createLayoutData(Alignment.CENTER_LITERAL, false),
			createLayoutData(Alignment.FILL_LITERAL, true),
			createLayoutData(Alignment.FILL_LITERAL, false),
		};
		
		Figure nextParent = parent;
		for (int i = 0; i < allAreCenters.length; i++){
			BorderLayout layout = GMFGraphFactory.eINSTANCE.createBorderLayout();
			layout.setSpacing(createDimension(4, 2));
			nextParent.setLayout(layout);

			Figure child = GMFGraphFactory.eINSTANCE.createRectangle();
			child.setName("Doll" + (i + 1));
			child.setLayoutData(allAreCenters[i]);
			
			nextParent.getChildren().add(child);
			nextParent = child;
		}
		
		performTests(parent);
	}
	
	public void testCustomLayout(){
		CustomLayout layout = GMFGraphFactory.eINSTANCE.createCustomLayout();
		layout.setQualifiedClassName("com.borland.layouts.TheBestLayoutManagerForever");
		
		CustomAttribute normalAttr = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		normalAttr.setDirectAccess(false);
		normalAttr.setMultiStatementValue(false);
		normalAttr.setName("UnlimateAnswer");
		normalAttr.setValue("42");
		
		layout.getAttributes().add(normalAttr);

		CustomAttribute directAttr = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		directAttr.setDirectAccess(true);
		directAttr.setMultiStatementValue(false);
		directAttr.setName("DirectUltimateAnswer");
		directAttr.setValue("this.getUltimateAnswer() - 6 * 7");
		
		layout.getAttributes().add(directAttr);

		CustomAttribute multiAttr = GMFGraphFactory.eINSTANCE.createCustomAttribute();
		multiAttr.setDirectAccess(false);
		multiAttr.setMultiStatementValue(true);
		multiAttr.setName("MultiStatementParameter");
		multiAttr.setValue("int {0}; if (Boolean.TRUE.booleanValue()) '{' {0} = 42; } else '{' {0} = -42; } ");
		
		layout.getAttributes().add(multiAttr);
		
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setName("CarefullyLayouted");
		parent.setLayout(layout);
		
		//generate code will be incompilable due to the absence of the TheBestLayoutManagerForever
		generateAndParse(parent);
	}
	
	public void testStackLayout(){
		Figure group = createRGBGroup("Stack");
		group.setLayout(GMFGraphFactory.eINSTANCE.createStackLayout());
		performTests(group);
	}
	
	public void testFlowLayout(){
		Figure group = createRGBGroup("Flow");
		FlowLayout flowLayout = GMFGraphFactory.eINSTANCE.createFlowLayout();
		flowLayout.setVertical(false);
		flowLayout.setForceSingleLine(false);
		flowLayout.setMinorAlignment(Alignment.END_LITERAL);
		flowLayout.setMajorAlignment(Alignment.FILL_LITERAL); // wrong one
		flowLayout.setMinorSpacing(23);
		flowLayout.setMinorSpacing(32);
		group.setLayout(flowLayout);
		performTests(group);
	}

	public void testToolbarLayoutUnusedAndIncorrectValues(){
		Figure group = createRGBGroup("ToolbarBadConfig");
		FlowLayout flowLayout = GMFGraphFactory.eINSTANCE.createFlowLayout();
		flowLayout.setForceSingleLine(true);
		flowLayout.setMinorSpacing(23456);
		flowLayout.setMajorAlignment(Alignment.FILL_LITERAL);
		group.setLayout(flowLayout);
		performTests(group);
	}

	public void testToolbarLayout(){
		Figure group = createRGBGroup("Toolbar");
		FlowLayout flowLayout = GMFGraphFactory.eINSTANCE.createFlowLayout();
		flowLayout.setForceSingleLine(true);
		flowLayout.setMajorSpacing(11);
		flowLayout.setMinorAlignment(Alignment.END_LITERAL); 
		group.setLayout(flowLayout);
		performTests(group);
	}
	
	public void testXYLayout(){
		Figure group = createRGBGroup("XY");
		Figure left = (Figure) group.getChildren().get(0);
		Figure right = (Figure) group.getChildren().get(1);

		setupXYLayout(group, left, right);

		performTests(group);
		performTests(right);
		performTests(left);
	}
	
	public void testXYLayoutForCustomFigure(){
		CustomFigure group = GMFGraphFactory.eINSTANCE.createCustomFigure();
		group.setBundleName("org.eclipse.draw2d");
		group.setQualifiedClassName("org.eclipse.draw2d.Layer");
		group.setName("CustomLayer");
		
		Rectangle left = GMFGraphFactory.eINSTANCE.createRectangle();
		left.setName("Left");
		group.getChildren().add(left);
		
		RoundedRectangle right = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		right.setName("Right");
		group.getChildren().add(right);
		
		setupXYLayout(group, left, right);

		performTests(group);
	}
	
	private void setupXYLayout(final Figure group, final Figure left, final Figure right){
		assertTrue(group.getChildren().contains(left));
		assertTrue(group.getChildren().contains(right));
		assertNotSame(left, right);

		group.setLayout(GMFGraphFactory.eINSTANCE.createXYLayout());
		
		XYLayoutData leftDataCorrect =  GMFGraphFactory.eINSTANCE.createXYLayoutData();
		leftDataCorrect.setTopLeft(GMFGraphFactory.eINSTANCE.createPoint());
		leftDataCorrect.getTopLeft().setX(12);
		leftDataCorrect.getTopLeft().setY(13);
		leftDataCorrect.setSize(GMFGraphFactory.eINSTANCE.createDimension());
		leftDataCorrect.getSize().setDx(20);
		leftDataCorrect.getSize().setDy(30);
		leftDataCorrect.setOwner(left);
		
		XYLayoutData rightDataIncomplete =  GMFGraphFactory.eINSTANCE.createXYLayoutData();
		rightDataIncomplete.setSize(GMFGraphFactory.eINSTANCE.createDimension());
		rightDataIncomplete.getSize().setDx(30);
		rightDataIncomplete.getSize().setDy(20);
		right.setLayoutData(rightDataIncomplete);
	}

	private Figure createRGBGroup(String rootName){
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		setColor(parent, 0, 0, 255);
		parent.setName(rootName);
		
		Figure greenEllipse = GMFGraphFactory.eINSTANCE.createEllipse();
		greenEllipse.setName("GreenEllipse");
		setColor(greenEllipse, 0, 255, 0);
		
		Figure redRRectangle = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		redRRectangle.setName("RedRoundedRectangle");
		setColor(redRRectangle, 255, 0, 0);
		
		parent.getChildren().add(greenEllipse);
		parent.getChildren().add(redRRectangle);
		
		return parent;
	}
	
	private Figure addPairOfChildRectanglesAndReturnLeft(Figure parent){
		parent.setLayout(createBorderLayoutAllProperties());
		
		Rectangle left = GMFGraphFactory.eINSTANCE.createRectangle();
		left.setName(parent.getName() + "_1");
		left.setLayoutData(createBorderLayoutDataAllProperties(Alignment.BEGINNING_LITERAL, false));
		parent.getChildren().add(left);
		
		Rectangle right = GMFGraphFactory.eINSTANCE.createRectangle();
		right.setName(parent.getName() + "_2");
		right.setLayoutData(createBorderLayoutDataAllProperties(Alignment.END_LITERAL, false));
		parent.getChildren().add(right);
		
		return left;
	}
	
	private GridLayoutData createGridLayoutDataAllProperties(boolean horizontalBeginningNotEnd) {
		GridLayoutData data = GMFGraphFactory.eINSTANCE.createGridLayoutData();
		data.setGrabExcessHorizontalSpace(true);
		data.setGrabExcessVerticalSpace(false);
		data.setHorizontalAlignment(horizontalBeginningNotEnd ? Alignment.BEGINNING_LITERAL : Alignment.END_LITERAL);
		data.setVerticalAlignment(Alignment.CENTER_LITERAL);
		data.setHorizontalIndent(5);
		data.setHorizontalSpan(1);
		data.setVerticalSpan(1);
		return data;
	}

	private GridLayout createGridLayoutAllProperties() {
		GridLayout layout = GMFGraphFactory.eINSTANCE.createGridLayout();
		layout.setEqualWidth(true);
		layout.setNumColumns(2);
		
		Dimension margins = GMFGraphFactory.eINSTANCE.createDimension();
		margins.setDx(5);
		margins.setDy(10);
		layout.setMargins(margins);
		
		Dimension spacing = GMFGraphFactory.eINSTANCE.createDimension();
		spacing.setDx(7);
		spacing.setDy(8);
		layout.setSpacing(spacing);

		return layout;
	}
	
	private BorderLayout createBorderLayoutAllProperties(){
		BorderLayout result = GMFGraphFactory.eINSTANCE.createBorderLayout();
		Dimension spacing = GMFGraphFactory.eINSTANCE.createDimension();
		spacing.setDx(11);
		spacing.setDy(12);
		result.setSpacing(spacing);
		return result;
	}
	
	private BorderLayoutData createBorderLayoutDataAllProperties(Alignment alignment, boolean isVertical){
		BorderLayoutData result = GMFGraphFactory.eINSTANCE.createBorderLayoutData();
		result.setAlignment(alignment);
		result.setVertical(isVertical);
		return result;
	}
	
	private Dimension createDimension(int dx, int dy){
		Dimension result = GMFGraphFactory.eINSTANCE.createDimension();
		result.setDx(dx);
		result.setDy(dy);
		return result;
	}
	
	private BorderLayoutData createLayoutData(Alignment alignment, boolean isVertical){
		BorderLayoutData result = GMFGraphFactory.eINSTANCE.createBorderLayoutData();
		result.setAlignment(alignment);
		result.setVertical(isVertical);
		return result;
	}
	
	private void setColor(Figure figure, int red, int green, int blue){
		RGBColor color = GMFGraphFactory.eINSTANCE.createRGBColor();
		color.setRed(red);
		color.setGreen(green);
		color.setBlue(blue);
		figure.setForegroundColor(color);
	}
	
	private void performGridLayoutTests(Figure figure){
		generateAndParse(figure);
	}
	
	protected void performTests(Figure f) {
		super.performTests(f, new LayoutAwareCheck(f));
	}
	
}
