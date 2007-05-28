/**
 * Copyright (c) 2006, 2007 Borland Software Corporation
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
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.LabeledContainer;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.tests.setup.DiaDefSetup;


public class LabelSupportSetup extends AbstractFigureGeneratorSetup {
	
	private FigureDescriptor myCustom;

	private FigureDescriptor mySimple;

	private FigureDescriptor myLabeledContainer;

	private FigureDescriptor myRoot;

	protected void addFigures(FigureGallery gallery) {
		gallery.getDescriptors().add(getCustom());
		gallery.getDescriptors().add(getSimple());
		gallery.getDescriptors().add(getLabeledContainer());
		gallery.getDescriptors().add(getRoot());
	}
	
	public FigureDescriptor getRoot() {
		if (myRoot == null) {
			final Rectangle rootFigure = GMFGraphFactory.eINSTANCE.createRectangle();
			myRoot = DiaDefSetup.newDescriptor("Root", rootFigure);
			BorderLayout layout = GMFGraphFactory.eINSTANCE.createBorderLayout();
			myRoot.getActualFigure().setLayout(layout);
			
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

			rootFigure.getChildren().add(intermediateLabelContainer);
			rootFigure.getChildren().add(padding);

			addLabel(myRoot, intermediateLabelContainer);
		}
		return myRoot;
	}

	public FigureDescriptor getLabeledContainer() {
		if (myLabeledContainer == null) {
			final LabeledContainer fig = GMFGraphFactory.eINSTANCE.createLabeledContainer();
			myLabeledContainer = DiaDefSetup.newDescriptor("LabeledContainerAlreadyHasLabel_DoesItNeedOneMore", fig);
			addLabel(myLabeledContainer, fig);
		}
		return myLabeledContainer;
	}

	public FigureDescriptor getSimple() {
		if (mySimple == null) {
			Rectangle simpleFig = GMFGraphFactory.eINSTANCE.createRectangle();
			mySimple = DiaDefSetup.newDescriptor("SimpleParent", simpleFig);
			addLabel(mySimple, simpleFig);
		}
		return mySimple;
	}

	public FigureDescriptor getCustom() {
		if (myCustom == null) {
			final CustomFigure fig = GMFGraphFactory.eINSTANCE.createCustomFigure();
			fig.setQualifiedClassName(RectangleFigure.class.getName());
			myCustom = DiaDefSetup.newDescriptor("CustomParent", fig);
			addLabel(myCustom, fig);
		}
		return myCustom;
	}

	private void addLabel(FigureDescriptor fd, RealFigure parent) {
		parent.setPreferredSize(FigureGeneratorUtil.createDimension(60, 60));
		Label label = GMFGraphFactory.eINSTANCE.createLabel();
		parent.getChildren().add(label);
		DiaDefSetup.newAccess(fd, label).setAccessor("Typename");
	}
}
