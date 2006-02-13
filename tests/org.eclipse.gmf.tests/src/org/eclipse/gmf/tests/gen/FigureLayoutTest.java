package org.eclipse.gmf.tests.gen;

import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.BorderLayout;
import org.eclipse.gmf.gmfgraph.BorderLayoutData;
import org.eclipse.gmf.gmfgraph.CustomAttribute;
import org.eclipse.gmf.gmfgraph.CustomLayout;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureMarker;
import org.eclipse.gmf.gmfgraph.FigureRef;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.GridLayout;
import org.eclipse.gmf.gmfgraph.GridLayoutData;
import org.eclipse.gmf.gmfgraph.LayoutData;
import org.eclipse.gmf.gmfgraph.Rectangle;

public class FigureLayoutTest extends FigureCodegenTestBase {
	public FigureLayoutTest(String name){
		super(name);
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
			LayoutData data = createLayoutDataAllProperties(oddChild);
			next.setLayoutData(data);
			assertEquals("data-owner relation should be bidirectional", next, data.getOwner());
		}
		performTests(parent);
	}
	
//	public void testLayoutIsStorable() throws IOException {
//		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
//		parent.setName("Parent");
//		parent.setLayout(createLayoutAllProperties());
//		
//		Figure leftGreenFilled = GMFGraphFactory.eINSTANCE.createRectangle();
//		leftGreenFilled.setName("LeftGreen");
//		RGBColor green = GMFGraphFactory.eINSTANCE.createRGBColor();
//		green.setGreen(255);
//		leftGreenFilled.setBackgroundColor(green);
//		leftGreenFilled.setLayoutData(createLayoutDataAllProperties(true));
//		
//		Figure rightRedOutline = GMFGraphFactory.eINSTANCE.createRectangle();
//		rightRedOutline.setName("RightRed");
//		RGBColor red = GMFGraphFactory.eINSTANCE.createRGBColor();
//		red.setRed(255);
//		rightRedOutline.setForegroundColor(green);
//		rightRedOutline.setLayoutData(createLayoutDataAllProperties(false));
//		
//		Resource resource = new ResourceSetImpl().createResource(URI.createFileURI("C:/test-uri.xmi"));
//		resource.getContents().add(parent);
//		resource.save(null);
//	}
	
	public void testCustomFigureLayoutAllProperties(){
		Figure parent = figure1();
		parent.setName("Parent");
		GridLayout layout = createGridLayoutAllProperties();
		layout.setNumColumns(1);
		layout.setEqualWidth(false);
		parent.setLayout(layout);
		
		for (Iterator children = parent.getChildren().iterator(); children.hasNext();){
			FigureMarker next = (FigureMarker)children.next();
			GridLayoutData data = createLayoutDataAllProperties(false);
			data.setHorizontalAlignment(Alignment.FILL_LITERAL);
			data.setOwner(next);
			assertEquals("data-owner relation should be bidirectional", data, next.getLayoutData());
		}
		performTests(parent);
	}
	
	public void testDeepChildrenLayout(){
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setName("Root");
		
		Figure next = parent;
		for (int i = 0; i < 4; i++){
			next = addPairOfChildRectnaglesAndReturnLeft(next);
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
		
		performTests(parent);
	}
	
	public void testLayoutForReferencedChild(){
		Figure actualContainer = figure2();
		Figure referencedFigure = (Figure) actualContainer.getChildren().get(0);
		
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setName("ReferencedFigureParent");
		parent.setLayout(createGridLayoutAllProperties());
		
		FigureRef refChildA = GMFGraphFactory.eINSTANCE.createFigureRef();
		refChildA.setFigure(referencedFigure);
		refChildA.setLayoutData(createLayoutDataAllProperties(false));
		
		//same figure is referenced, different layout data
		FigureRef refChildB = GMFGraphFactory.eINSTANCE.createFigureRef();
		refChildB.setFigure(referencedFigure);
		refChildB.setLayoutData(createLayoutDataAllProperties(true));
		
		parent.getChildren().add(refChildA);
		parent.getChildren().add(refChildB);
		
		performTests(parent);
	}
	
	public void testMissedLayoutPresentLayoutData(){
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setName("ParentWithoutLayout");
		assertNull(parent.getLayout());
		
		Figure child = GMFGraphFactory.eINSTANCE.createRectangle();
		child.setName("childWithLayoutData");
		child.setLayoutData(createLayoutDataAllProperties(false));
		
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
		
		Figure centerB = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		centerB.setName("Center_2");
		centerB.setLayoutData(createLayoutData(Alignment.CENTER_LITERAL, true));

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
		
		parent.getChildren().addAll(Arrays.asList(new Figure[] {top, bottom, left, right, centerA, centerB}));
		
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
		
		performTests(parent);
	}
	
	private Figure addPairOfChildRectnaglesAndReturnLeft(Figure parent){
		GridLayout parentLayout = createGridLayoutAllProperties();
		parentLayout.setNumColumns(2);
		parentLayout.setMargins(null);
		parentLayout.setSpacing(null);
		parent.setLayout(parentLayout);
		
		Rectangle left = GMFGraphFactory.eINSTANCE.createRectangle();
		left.setName(parent.getName() + "_1");
		left.setLayoutData(createLayoutDataAllProperties(true));
		parent.getChildren().add(left);
		
		Rectangle right = GMFGraphFactory.eINSTANCE.createRectangle();
		right.setName(parent.getName() + "_2");
		right.setLayoutData(createLayoutDataAllProperties(false));
		parent.getChildren().add(right);
		
		return left;
	}
	
	private GridLayoutData createLayoutDataAllProperties(boolean horizontalBeginningNotEnd) {
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

}
