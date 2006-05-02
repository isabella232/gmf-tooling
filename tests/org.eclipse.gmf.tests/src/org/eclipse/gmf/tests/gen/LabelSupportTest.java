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
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.BorderLayout;
import org.eclipse.gmf.gmfgraph.BorderLayoutData;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LabeledContainer;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;

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
	
	public void testDeepLabelGraphdefOnly(){
		Rectangle root = GMFGraphFactory.eINSTANCE.createRectangle();
		root.setName("Root");
		BorderLayout layout = GMFGraphFactory.eINSTANCE.createBorderLayout();
		root.setLayout(layout);
		
		RoundedRectangle padding = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		padding.setName("Padding");
		BorderLayoutData paddingData = GMFGraphFactory.eINSTANCE.createBorderLayoutData();
		paddingData.setAlignment(Alignment.FILL_LITERAL);
		padding.setLayoutData(paddingData);
		
		Rectangle intermediateLabelContainer = GMFGraphFactory.eINSTANCE.createRectangle();
		intermediateLabelContainer.setName("intermediateLabelContainer");
		BorderLayoutData labelData = GMFGraphFactory.eINSTANCE.createBorderLayoutData();
		labelData.setAlignment(Alignment.BEGINNING_LITERAL);
		labelData.setVertical(true);
		intermediateLabelContainer.setLayoutData(labelData);
		
		addLabel(intermediateLabelContainer, LABEL_NAME);

		root.getChildren().add(intermediateLabelContainer);
		root.getChildren().add(padding);
		
		performTests(root, combineChecks(new GenericFigureCheck(root), new LabelAccessorCheck(LABEL_NAME)));		
	}
	
	private void performChecks(Figure parent, String parentName, String labelName){
		parent.setName(parentName);
		
		Dimension prefSize = GMFGraphFactory.eINSTANCE.createDimension();
		prefSize.setDx(60);
		prefSize.setDy(60);
		parent.setPreferredSize(prefSize);
		
		addLabel(parent, labelName);
		
		performTests(parent, combineChecks(new GenericFigureCheck(parent), new LabelAccessorCheck(LABEL_NAME)));
	}

	private void addLabel(Figure parent, String labelName) {
		Label label = GMFGraphFactory.eINSTANCE.createLabel();
		label.setName(labelName);
		
		Node labelNode = GMFGraphFactory.eINSTANCE.createNode();
		labelNode.setName("LabelNode");
		labelNode.setFigure(label);
		
		parent.getChildren().add(label);
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
