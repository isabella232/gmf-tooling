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

import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.BorderLayout;
import org.eclipse.gmf.gmfgraph.BorderLayoutData;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;


public class LabelSupportSetup extends AbstractFigureGeneratorSetup {
	
	public static final String LABEL_NAME = "Typename";

	private CustomFigure myCustom;

	private Figure mySimple;

	private Figure myLabeledContainer;

	private Figure myRoot;

	protected void addFigures(FigureGallery gallery) {
		gallery.getFigures().add(getCustom());
		gallery.getFigures().add(getSimple());
		gallery.getFigures().add(getLabeledContainer());
		gallery.getFigures().add(getRoot());
	}
	
	public Figure getRoot() {
		if (myRoot == null) {
			myRoot = GMFGraphFactory.eINSTANCE.createRectangle();
			myRoot.setName("Root");
			BorderLayout layout = GMFGraphFactory.eINSTANCE.createBorderLayout();
			myRoot.setLayout(layout);
			
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

			myRoot.getChildren().add(intermediateLabelContainer);
			myRoot.getChildren().add(padding);
		}
		return myRoot;
	}

	public Figure getLabeledContainer() {
		if (myLabeledContainer == null) {
			myLabeledContainer = GMFGraphFactory.eINSTANCE.createLabeledContainer();
			addLabel(myLabeledContainer, "LabeledContainerAlreadyHasLabel_DoesItNeedOneMore", LABEL_NAME);
		}
		return myLabeledContainer;
	}

	public Figure getSimple() {
		if (mySimple == null) {
			mySimple = GMFGraphFactory.eINSTANCE.createRectangle();
			addLabel(mySimple, "SimpleParent", LABEL_NAME);
		}
		return mySimple;
	}

	public Figure getCustom() {
		if (myCustom == null) {
			myCustom = GMFGraphFactory.eINSTANCE.createCustomFigure();
			myCustom.setBundleName(FigureGeneratorUtil.DRAW2D); 
			myCustom.setQualifiedClassName(RectangleFigure.class.getName());
			addLabel(myCustom, "CustomParent", LABEL_NAME);
		}
		return myCustom;
	}
	
	public String getLabelName() {
		return LABEL_NAME;
	}

	private void addLabel(Figure parent, String parentName, String labelName){
		parent.setName(parentName);
		parent.setPreferredSize(FigureGeneratorUtil.createDimension(60, 60));
		addLabel(parent, labelName);
	}
	
	private void addLabel(Figure parent, String labelName) {
		Label label = GMFGraphFactory.eINSTANCE.createLabel();
		label.setName(labelName);
		
		Node labelNode = GMFGraphFactory.eINSTANCE.createNode();
		labelNode.setName("LabelNode");
		labelNode.setFigure(label);
		
		parent.getChildren().add(label);
	}

}
