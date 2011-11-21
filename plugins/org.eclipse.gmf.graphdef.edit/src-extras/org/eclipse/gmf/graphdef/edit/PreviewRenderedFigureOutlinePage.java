/*******************************************************************************
* Copyright (c) 2011 EBM Websourcing (PetalsLink)
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* Mickael Istria (EBM - PetalsLink) : initial implementation
*******************************************************************************/
package org.eclipse.gmf.graphdef.edit;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.FigureRef;
import org.eclipse.gmf.runtime.graphdef.GMFGraphRenderedFigure;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

class PreviewRenderedFigureOutlinePage extends Page implements IContentOutlinePage, ISelectionChangedListener {

	private RectangleFigure background;
	private FigureCanvas control;

	@Override
	public void createControl(Composite parent) {
		FigureCanvas canvas = new FigureCanvas(parent);
		canvas.setBackground(ColorConstants.white);
		background = new RectangleFigure();
		background.setForegroundColor(ColorConstants.white);
		background.setBackgroundColor(ColorConstants.white);
		org.eclipse.draw2d.GridLayout rectangleLayout = new org.eclipse.draw2d.GridLayout();
		background.setLayoutManager(rectangleLayout);
		rectangleLayout.marginHeight = 10;
		rectangleLayout.marginWidth = 10;
		canvas.setContents(background);
		this.control = canvas;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Control getControl() {
		return control;
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
	}

	@Override
	public void setFocus() {
		getControl().setFocus();
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
	}

	@Override
	public ISelection getSelection() {
		return new StructuredSelection();
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
	}

	@Override
	public void setSelection(ISelection selection) {
		handleSelectionChanged(selection);
	}

	private void handleSelectionChanged(ISelection selection) {
		background.removeAll();
		if (selection instanceof IStructuredSelection) {
			Object item = ((IStructuredSelection) selection).getFirstElement();
			Figure modelFigure = null;
			if (item instanceof FigureRef) {
				modelFigure = ((FigureRef) item).getFigure();
			} else if (item instanceof FigureDescriptor) {
				modelFigure = ((FigureDescriptor)item).getActualFigure();
			} else if (item instanceof DiagramElement) {
				FigureDescriptor figureDesc = ((DiagramElement) item).getFigure();
				if (figureDesc != null) {
					modelFigure = figureDesc.getActualFigure();
				}
			} else if (item instanceof Figure) {
				modelFigure = (Figure) item;
			}
			
			if (modelFigure != null) {
				GMFGraphRenderedFigure draw2figure = new GMFGraphRenderedFigure(modelFigure);
				background.add(draw2figure);
			}
		}
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		handleSelectionChanged(event.getSelection());
	}
}