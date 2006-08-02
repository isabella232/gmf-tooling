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

package org.eclipse.gmf.tests.gef;


import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.rt.GeneratedCanvasTest;

/**
 * TODO: This test should be joined with the part of DiagramNodeTest concerning
 * .gmfgraph properties and an integration of these properties with notation
 * model layer. As a result, this test should be executed with separate session
 * setup to ensure corresponding properties was set in .gmfgraph model
 * (comparment properties + link color + label font). Finaly, it'll be possible
 * to remove corresponding properties from the default .gmfgen model created by
 * DiaDefSetup. (?)
 * 
 * .gmfgraph -> .gmfgen (ViewMap properties) transformation is checked as a
 * separate test.
 */
public final class CompartmentPropertiesTest extends GeneratedCanvasTest {
	private static final NotationPackage NOTATION = NotationPackage.eINSTANCE; 
	
	public CompartmentPropertiesTest(String name) {
		super(name);
	}
	
	/**
	 * Simplified version of testCompartmentTitles() 
	 * Checks GEF properties for notation elements explictly created via RTSource.
	 * Emulates opening of the diagram created earlier  
	 */
	public void testCompartmentTitles_Static(){
		checkNoTitle(getCompartmentEditPartB());
		checkHasTitle(getCompartmentEditPartA());
		//notation elements were explicitly created in RTSource, 
		//it does not make sense to check their styles
	}
	
	public void testCompartmentTitles(){
		CompartmentEditPart newCompartmentA = createNewCompartment(getSetup().getGenModel().getNodeA());
		checkHasTitle(newCompartmentA);
		View withTitleStyle = getNotation(newCompartmentA);
		TitleStyle titleStyle = (TitleStyle) withTitleStyle.getStyle(NOTATION.getTitleStyle());
		assertNotNull(titleStyle);
		assertTrue(titleStyle.isShowTitle());
		
		
		CompartmentEditPart newCompartmentB = createNewCompartment(getSetup().getGenModel().getNodeB());
		checkNoTitle(newCompartmentB);
		View withoutTitleStyle = getNotation(newCompartmentB);
		assertNull("[#143934] Required to disable title configuration in property sheet", 
				withoutTitleStyle.getStyle(NOTATION.getTitleStyle()));
	}
	
	public void testCompartmentCollapsed_Static(){
		checkIsCollapsed(getCompartmentEditPartA(), false); //even collapsible figure should not be collpased by default
		checkIsCollapsed(getCompartmentEditPartB(), false);
		
		checkHasCollapseHandler("Collapsible compartment should show collapse handler", getCompartmentEditPartA(), true);
		checkHasCollapseHandler("Not-collapsible compartment should not show collapse handler", getCompartmentEditPartB(), false);
	}
	
	public void testCompartmentCollapsed(){
		CompartmentEditPart newCompartmentA = createNewCompartment(getSetup().getGenModel().getNodeA());
		checkIsCollapsed(newCompartmentA, false); 
		
		View collapsible = getNotation(newCompartmentA);
		DrawerStyle drawerStyle = (DrawerStyle) collapsible.getStyle(NOTATION.getDrawerStyle());
		assertNotNull(drawerStyle);
		assertFalse(drawerStyle.isCollapsed());
		
		CompartmentEditPart newCompartmentB = createNewCompartment(getSetup().getGenModel().getNodeB());
		checkIsCollapsed(newCompartmentB, false); //sic!
		View notCollapsible = getNotation(newCompartmentB);
		assertNull(notCollapsible.getStyle(NOTATION.getDrawerStyle()));
	}
	
	private void checkIsCollapsed(CompartmentEditPart editPart, boolean expected){
		checkCompartmentFigure(editPart);
		ResizableCompartmentFigure figure = (ResizableCompartmentFigure) editPart.getFigure();
		ScrollPane scrollPane = figure.getScrollPane();
		assertEquals(expected, scrollPane.getVerticalScrollBarVisibility() == ScrollPane.NEVER);
	}
	
	private void checkHasCollapseHandler(String message, CompartmentEditPart editPart, boolean expected){
		//it is related to scr #146531
		//it is unclear how to check it directly
		//we will just check that generated code installs predefined editpolicy to achieve this 
		EditPolicy policy = editPart.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		assertEquals(message, expected, policy instanceof ResizableCompartmentEditPolicy);
	}
	
	private void checkNoTitle(CompartmentEditPart editPart){
		checkCompartmentFigure(editPart);
		ResizableCompartmentFigure noTitle = (ResizableCompartmentFigure) editPart.getFigure();
		IFigure textPane = noTitle.getTextPane();
		assertTrue(
				!textPane.isVisible() || 
				textPane.getChildren().isEmpty() ||
				!((IFigure)textPane.getChildren().get(0)).isVisible());
	}

	private void checkHasTitle(CompartmentEditPart editPart){
		checkCompartmentFigure(editPart);
		ResizableCompartmentFigure withTitle = (ResizableCompartmentFigure) editPart.getFigure();
		IFigure textPane = withTitle.getTextPane();
		assertNotNull(textPane);
		assertTrue(textPane.isVisible());
		assertFalse(textPane.getChildren().isEmpty());
		IFigure label = (IFigure) textPane.getChildren().get(0);
		assertTrue(label instanceof WrapLabel);
		assertTrue(label.isVisible());
		String text = ((WrapLabel)label).getText();
		assertTrue(text != null && text.trim().length() > 0);
	}

	private void checkCompartmentFigure(CompartmentEditPart editPart) {
		assertTrue(editPart.getFigure() instanceof ResizableCompartmentFigure);
		ResizableCompartmentFigure figure = (ResizableCompartmentFigure) editPart.getFigure();
		IFigure textPane = figure.getTextPane();
		assertNotNull(textPane); //even if no labels
	}

	private CompartmentEditPart createNewCompartment(GenNode genTopLevelParent){
		GenCompartment genCompartment = getGenCompartment(genTopLevelParent);
		View notationParent = createNode(genTopLevelParent, getDiagram());
		assertNotNull(notationParent);
		View notationCompartment = findChildView(notationParent, genCompartment);
		assertNotNull(notationCompartment);
		
		CompartmentEditPart editPart = (CompartmentEditPart) findEditPart(notationCompartment);
		assertNotNull(editPart);
		return editPart;
	}
	
	/**
	 * TODO: expose compartments through interface returned by
	 * getSetup().getGenModel() and remove this method
	 */
	private final GenCompartment getGenCompartment(GenNode genNode) {
		return (GenCompartment) genNode.getCompartments().get(0);
	}
	
}
