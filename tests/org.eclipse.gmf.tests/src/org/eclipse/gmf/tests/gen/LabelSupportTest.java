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

import java.lang.reflect.Method;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LabeledContainer;
import org.eclipse.gmf.gmfgraph.Rectangle;

public class LabelSupportTest extends FigureCodegenTestBase {
	private static final String LABEL_NAME = "Typename";
	
	public LabelSupportTest(String name) {
		super(name);
	}
	
	public void testCustomFugureWithLabel(){
		CustomFigure custom = GMFGraphFactory.eINSTANCE.createCustomFigure();
		custom.setBundleName(DRAW2D); 
		custom.setQualifiedClassName(RectangleFigure.class.getName());
		
		performChecks(custom, "CustomParent", LABEL_NAME);
	}
	
	public void testRectangleWithLabel(){
		Rectangle simple = GMFGraphFactory.eINSTANCE.createRectangle();
		performChecks(simple, "SimpleParent", LABEL_NAME);
	}
	
	public void testLabeledContainer(){
		LabeledContainer labeledContainer = GMFGraphFactory.eINSTANCE.createLabeledContainer();
		performChecks(labeledContainer, "LabeledContainerAlreadyHasLabel_DoesItNeedOneMore", LABEL_NAME);
	}
	
	private void performChecks(Figure parent, String parentName, String labelName){
		parent.setName(parentName);
		
		Dimension prefSize = GMFGraphFactory.eINSTANCE.createDimension();
		prefSize.setDx(60);
		prefSize.setDy(60);
		parent.setPreferredSize(prefSize);
		
		Label label = GMFGraphFactory.eINSTANCE.createLabel();
		label.setName(labelName);
		
		parent.getChildren().add(label);
		
		performTests(parent, combineChecks(new GenericFigureCheck(parent), new LabelAccessorCheck(LABEL_NAME)));
	}
	
	private static class LabelAccessorCheck extends FigureCheck {
		private final String myLabelName;
		private static final Class[] NO_PARAMS = new Class[0];

		public LabelAccessorCheck(String labelName){
			myLabelName = labelName;
		}
		
		public void checkFigure(IFigure figure) {
			assertNotNull(figure);
			assertTrue("NodeEditPart requires this method in the inner figure class", 
					hasMethod(figure, "getFigure" + CodeGenUtil.capName(myLabelName), NO_PARAMS));
		}	
		
		private boolean hasMethod(Object instance, String methodName, Class[] params) {
			try {
				Method method = instance.getClass().getMethod(methodName, params);
				return method != null;
			} catch (SecurityException e) {
				return false;
			} catch (NoSuchMethodException e) {
				return false;
			}
		}
	}
}
