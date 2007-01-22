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

import java.util.Arrays;
import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.BorderLayout;
import org.eclipse.gmf.gmfgraph.BorderLayoutData;
import org.eclipse.gmf.gmfgraph.CustomAttribute;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.CustomLayout;
import org.eclipse.gmf.gmfgraph.CustomLayoutData;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FigureMarker;
import org.eclipse.gmf.gmfgraph.FigureRef;
import org.eclipse.gmf.gmfgraph.FlowLayout;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.GridLayout;
import org.eclipse.gmf.gmfgraph.GridLayoutData;
import org.eclipse.gmf.gmfgraph.LayoutData;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.gmfgraph.XYLayoutData;


public class FigureLayoutSetup extends AbstractFigureGeneratorSetup {

	private Figure myParent;
	private Figure myParent1;
	private Figure myParent2;
	private Figure myParent3;
	private Figure myGroup;
	private Figure myGroup1;
	private Figure myGroup2;
	private Figure myGroup3;
	private Figure myGroup4;
	private CustomFigure myGroup5;
	private Figure myParent4;
	private Figure myParent5;
	private Figure myParent6;
	private Figure myParent7;
	private Figure myParent8;
	private Figure myParent9;
	private Figure myFigureWithCustomLayoutData;

	protected void addFigures(FigureGallery gallery) {
		gallery.getFigures().add(getParent());
		gallery.getFigures().add(getParent1());
		gallery.getFigures().add(getParent2());
		gallery.getFigures().add(getParent3());
// Uncomment then layout code will be generatable.
//		gallery.getFigures().add(getParent4());
//		gallery.getFigures().add(getParent5());
//		gallery.getFigures().add(getParent6());
//		gallery.getFigures().add(getParent7());
//		gallery.getFigures().add(getParent8());
//		gallery.getFigures().add(getParent9());
		gallery.getFigures().add(getGroup());
		gallery.getFigures().add(getGroup1());
		gallery.getFigures().add(getGroup2());
		gallery.getFigures().add(getGroup3());
		gallery.getFigures().add(getGroup4());
		gallery.getFigures().add(getGroup5());
		gallery.getFigures().add(getFigureWithCustomLayoutData());
	}
	
	public Figure getGroup5() {
		if (myGroup5 == null) {
			myGroup5 = GMFGraphFactory.eINSTANCE.createCustomFigure();
			myGroup5.setBundleName("org.eclipse.draw2d");
			myGroup5.setQualifiedClassName("org.eclipse.draw2d.Layer");
			myGroup5.setName("CustomLayer");
			
			Rectangle left = GMFGraphFactory.eINSTANCE.createRectangle();
			left.setName("Left");
			myGroup5.getChildren().add(left);
			
			RoundedRectangle right = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
			right.setName("Right");
			myGroup5.getChildren().add(right);
			
			setupXYLayout(myGroup5, left, right);
		}
		return myGroup5;
	}
	
	public Figure getGroup4() {
		if (myGroup4 == null) {
			myGroup4 = createRGBGroup("XY");
			Figure left = (Figure) myGroup4.getChildren().get(0);
			Figure right = (Figure) myGroup4.getChildren().get(1);

			setupXYLayout(myGroup4, left, right);
		}
		return myGroup4;
	}

	public Figure getGroup3() {
		if (myGroup3 == null) {
			myGroup3 = createRGBGroup("Toolbar");
			FlowLayout flowLayout = GMFGraphFactory.eINSTANCE.createFlowLayout();
			flowLayout.setForceSingleLine(true);
			flowLayout.setMajorSpacing(11);
			flowLayout.setMinorAlignment(Alignment.END_LITERAL); 
			myGroup3.setLayout(flowLayout);
		}
		return myGroup3;
	}

	public Figure getGroup2() {
		if (myGroup2 == null) {
			myGroup2 = createRGBGroup("ToolbarBadConfig");
			FlowLayout flowLayout = GMFGraphFactory.eINSTANCE.createFlowLayout();
			flowLayout.setForceSingleLine(true);
			flowLayout.setMinorSpacing(23456);
			flowLayout.setMajorAlignment(Alignment.FILL_LITERAL);
			myGroup2.setLayout(flowLayout);
		}
		return myGroup2;
	}

	public Figure getGroup1() {
		if (myGroup1 == null) {
			myGroup1 = createRGBGroup("Flow");
			FlowLayout flowLayout = GMFGraphFactory.eINSTANCE.createFlowLayout();
			flowLayout.setVertical(false);
			flowLayout.setForceSingleLine(false);
			flowLayout.setMinorAlignment(Alignment.END_LITERAL);
			flowLayout.setMajorAlignment(Alignment.FILL_LITERAL); // wrong one
			flowLayout.setMinorSpacing(23);
			flowLayout.setMinorSpacing(32);
			myGroup1.setLayout(flowLayout);
		}
		return myGroup1;
	}

	public Figure getGroup() {
		if (myGroup == null) {
			myGroup = createRGBGroup("Stack");
			myGroup.setLayout(GMFGraphFactory.eINSTANCE.createStackLayout());
		}
		return myGroup;
	}
	
	public Figure getParent9() {
		if (myParent9 == null) {
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
			
			myParent9 = GMFGraphFactory.eINSTANCE.createRectangle();
			myParent9.setName("CarefullyLayouted");
			myParent9.setLayout(layout);
		}
		return myParent9;
	}

	public Figure getFigureWithCustomLayoutData() {
		if (myFigureWithCustomLayoutData == null) {
			myFigureWithCustomLayoutData = GMFGraphFactory.eINSTANCE.createRectangle();
			myFigureWithCustomLayoutData.setName("MyFigureWithCustomLayoutData");
			Figure fig = GMFGraphFactory.eINSTANCE.createRectangle();
			fig.setName("ActualDataOwner");

			CustomLayoutData ld = GMFGraphFactory.eINSTANCE.createCustomLayoutData();
			ld.setQualifiedClassName("org.eclipse.draw2d.geometry.Point");

			CustomAttribute normalAttr = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			normalAttr.setDirectAccess(false);
			normalAttr.setMultiStatementValue(false);
			normalAttr.setName("location");
			normalAttr.setValue("11,12");
			
			ld.getAttributes().add(normalAttr);

			CustomAttribute directAttr = GMFGraphFactory.eINSTANCE.createCustomAttribute();
			directAttr.setDirectAccess(true);
			directAttr.setMultiStatementValue(false);
			directAttr.setName("x");
			directAttr.setValue("5");
			
			ld.getAttributes().add(directAttr);

			myFigureWithCustomLayoutData.setLayout(GMFGraphFactory.eINSTANCE.createXYLayout());
			fig.setLayoutData(ld);
			myFigureWithCustomLayoutData.getChildren().add(fig);
		}
		return myFigureWithCustomLayoutData;
	}

	public Figure getParent8() {
		if (myParent8 == null) {
			Figure actualContainer = createFigure2();
			Figure referencedFigure = (Figure) actualContainer.getChildren().get(0);
			
			myParent8 = GMFGraphFactory.eINSTANCE.createRectangle();
			myParent8.setName("ReferencedFigureParent");
			myParent8.setLayout(createGridLayoutAllProperties());
			
			FigureRef refChildA = GMFGraphFactory.eINSTANCE.createFigureRef();
			refChildA.setFigure(referencedFigure);
			refChildA.setLayoutData(createGridLayoutDataAllProperties(false));
			
			//same figure is referenced, different layout data
			FigureRef refChildB = GMFGraphFactory.eINSTANCE.createFigureRef();
			refChildB.setFigure(referencedFigure);
			refChildB.setLayoutData(createGridLayoutDataAllProperties(true));
			
			myParent8.getChildren().add(refChildA);
			myParent8.getChildren().add(refChildB);
		}
		return myParent8;
	}

	public Figure getParent7() {
		if (myParent7 == null) {
			myParent7 = GMFGraphFactory.eINSTANCE.createEllipse();
			myParent7.setName("GenEllipse");
			myParent7.setLayout(GMFGraphFactory.eINSTANCE.createGridLayout());
			
			Figure top = GMFGraphFactory.eINSTANCE.createLabel();
			top.setName("Top");
			top.setLayoutData(GMFGraphFactory.eINSTANCE.createGridLayoutData());
			myParent7.getChildren().add(top);
			
			Figure bottom = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
			bottom.setName("Bottom");
			bottom.setLayoutData(GMFGraphFactory.eINSTANCE.createGridLayoutData());
			myParent7.getChildren().add(bottom);
		}
		return myParent7;
	}

	public Figure getParent6() {
		if (myParent6 == null) {
			myParent6 = createFigure1();
			myParent6.setName("Parent");
			GridLayout layout = createGridLayoutAllProperties();
			layout.setNumColumns(1);
			layout.setEqualWidth(false);
			myParent6.setLayout(layout);
			
			for (Iterator children = myParent6.getChildren().iterator(); children.hasNext();){
				FigureMarker next = (FigureMarker)children.next();
				GridLayoutData data = createGridLayoutDataAllProperties(false);
				data.setHorizontalAlignment(Alignment.FILL_LITERAL);
				data.setOwner(next);
				Assert.assertEquals("data-owner relation should be bidirectional", data, next.getLayoutData());
			}
		}
		return myParent6;
	}

	
	public Figure getParent5() {
		if (myParent5 == null) {
			myParent5 = createFigure2();
			myParent5.setName("Parent5");
			EList children = myParent5.getChildren();
			Assert.assertFalse("Precondition -- children required to test layout", children.isEmpty());
			
			myParent5.setLayout(createGridLayoutAllProperties());
			
			boolean oddChild = false;
			for (Iterator it = children.iterator(); it.hasNext();){
				FigureMarker next = (FigureMarker)it.next();
				oddChild = !oddChild;
				LayoutData data = createGridLayoutDataAllProperties(oddChild);
				next.setLayoutData(data);
				Assert.assertEquals("data-owner relation should be bidirectional", next, data.getOwner());
			}
		}
		return myParent5;
	}
	
	public Figure getParent4() {
		if (myParent4 == null) {
			myParent4 = createFigure2();
			myParent4.setName("Parent4");
			myParent4.setLayout(createGridLayoutAllProperties());
		}
		return myParent4;
	}

	public Figure getParent3() {
		if (myParent3 == null) {
			myParent3 = GMFGraphFactory.eINSTANCE.createRectangle();
			myParent3.setName("Matreshka");
			
			LayoutData[] allAreCenters = new LayoutData[] {
				createLayoutData(Alignment.CENTER_LITERAL, true), 
				createLayoutData(Alignment.CENTER_LITERAL, false),
				createLayoutData(Alignment.FILL_LITERAL, true),
				createLayoutData(Alignment.FILL_LITERAL, false),
			};
			
			Figure nextParent = myParent3;
			for (int i = 0; i < allAreCenters.length; i++){
				BorderLayout layout = GMFGraphFactory.eINSTANCE.createBorderLayout();
				layout.setSpacing(FigureGeneratorUtil.createDimension(4, 2));
				nextParent.setLayout(layout);

				Figure child = GMFGraphFactory.eINSTANCE.createRectangle();
				child.setName("Doll" + (i + 1));
				child.setLayoutData(allAreCenters[i]);
				
				nextParent.getChildren().add(child);
				nextParent = child;
			}
		}
		return myParent3;
	}

	public Figure getParent2() {
		if (myParent2 == null) {
			myParent2 = GMFGraphFactory.eINSTANCE.createRectangle();
			myParent2.setName("BorderedContents");
			
			BorderLayout layout = GMFGraphFactory.eINSTANCE.createBorderLayout();
			layout.setSpacing(FigureGeneratorUtil.createDimension(2, 4));
			myParent2.setLayout(layout);
			
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
			
			myParent2.getChildren().addAll(Arrays.asList(new Figure[] {top, bottom, left, right, centerA}));
		}
		return myParent2;
	}

	public Figure getParent1() {
		if (myParent1 == null) {
			myParent1 = GMFGraphFactory.eINSTANCE.createRectangle();
			myParent1.setName("ParentWithoutLayout");
			Assert.assertNull(myParent1.getLayout());
			
			Figure child = GMFGraphFactory.eINSTANCE.createRectangle();
			child.setName("childWithLayoutData");
			child.setLayoutData(createGridLayoutDataAllProperties(false));
			
			myParent1.getChildren().add(child);
		}
		return myParent1;
	}

	public Figure getParent() {
		if (myParent == null) {
			myParent = GMFGraphFactory.eINSTANCE.createRectangle();
			myParent.setName("Root");
			
			Figure next = myParent;
			for (int i = 0; i < 4; i++){
				next = addPairOfChildRectanglesAndReturnLeft(next);
			}
		}
		return myParent;
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
	
	private GridLayout createGridLayoutAllProperties() {
		GridLayout layout = GMFGraphFactory.eINSTANCE.createGridLayout();
		layout.setEqualWidth(true);
		layout.setNumColumns(2);
		layout.setMargins(FigureGeneratorUtil.createDimension(5, 10));
		layout.setSpacing(FigureGeneratorUtil.createDimension(7, 8));
		return layout;
	}
	
	private BorderLayout createBorderLayoutAllProperties(){
		BorderLayout result = GMFGraphFactory.eINSTANCE.createBorderLayout();
		result.setSpacing(FigureGeneratorUtil.createDimension(11, 12));
		return result;
	}
	
	private BorderLayoutData createBorderLayoutDataAllProperties(Alignment alignment, boolean isVertical){
		BorderLayoutData result = GMFGraphFactory.eINSTANCE.createBorderLayoutData();
		result.setAlignment(alignment);
		result.setVertical(isVertical);
		return result;
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

	private BorderLayoutData createLayoutData(Alignment alignment, boolean isVertical){
		BorderLayoutData result = GMFGraphFactory.eINSTANCE.createBorderLayoutData();
		result.setAlignment(alignment);
		result.setVertical(isVertical);
		return result;
	}

	private Figure createRGBGroup(String rootName){
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setForegroundColor(FigureGeneratorUtil.createRGBColor(0, 0, 255));
		parent.setName(rootName);
		
		Figure greenEllipse = GMFGraphFactory.eINSTANCE.createEllipse();
		greenEllipse.setName("GreenEllipse");
		greenEllipse.setForegroundColor(FigureGeneratorUtil.createRGBColor(0, 255, 0));
		
		Figure redRRectangle = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		redRRectangle.setName("RedRoundedRectangle");
		redRRectangle.setForegroundColor(FigureGeneratorUtil.createRGBColor(255, 0, 0));
		
		parent.getChildren().add(greenEllipse);
		parent.getChildren().add(redRRectangle);
		
		return parent;
	}

	private void setupXYLayout(final Figure group, final Figure left, final Figure right){
		Assert.assertTrue(group.getChildren().contains(left));
		Assert.assertTrue(group.getChildren().contains(right));
		Assert.assertNotSame(left, right);

		group.setLayout(GMFGraphFactory.eINSTANCE.createXYLayout());
		
		XYLayoutData leftDataCorrect =  GMFGraphFactory.eINSTANCE.createXYLayoutData();
		leftDataCorrect.setTopLeft(FigureGeneratorUtil.createPoint(12, 13));
		leftDataCorrect.setSize(FigureGeneratorUtil.createDimension(20, 30));
		leftDataCorrect.setOwner(left);
		
		XYLayoutData rightDataIncomplete =  GMFGraphFactory.eINSTANCE.createXYLayoutData();
		rightDataIncomplete.setSize(FigureGeneratorUtil.createDimension(30, 20));
		right.setLayoutData(rightDataIncomplete);
	}

}
