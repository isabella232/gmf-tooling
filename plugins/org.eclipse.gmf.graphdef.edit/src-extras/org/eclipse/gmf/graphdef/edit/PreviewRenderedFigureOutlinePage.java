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
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

class PreviewRenderedFigureOutlinePage extends Page implements IContentOutlinePage, ISelectionChangedListener {

	private RectangleFigure background;
	private Control control;
	private ISelection selection;

	@Override
	public void createControl(Composite parent) {
		Composite res = new Composite(parent, SWT.BORDER);
		res.setLayout(new org.eclipse.swt.layout.GridLayout(1, false));
		Label disclaimerLabel = new Label(res, SWT.WRAP);
		disclaimerLabel.setText(Messages.previewDisclaimer);
		disclaimerLabel.setLayoutData(new org.eclipse.swt.layout.GridData(SWT.FILL, SWT.DEFAULT, true, false));
		FigureCanvas canvas = new FigureCanvas(res);
		canvas.setBackground(ColorConstants.white);
		background = new RectangleFigure();
		background.setForegroundColor(ColorConstants.white);
		background.setBackgroundColor(ColorConstants.white);
		GridLayout rectangleLayout = new GridLayout();
		background.setLayoutManager(rectangleLayout);
		canvas.setContents(background);
		canvas.setLayoutData(new org.eclipse.swt.layout.GridData(SWT.FILL, SWT.FILL, true, true));
		this.control = res;
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

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
	}

	public ISelection getSelection() {
		if (selection != null) {
			return new StructuredSelection();
		} else {
			return selection;
		}
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
	}

	public void setSelection(ISelection selection) {
		this.selection = selection;
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
				try {
					draw2figure.validate();
					background.add(draw2figure, new GridData(SWT.FILL, SWT.FILL, false, false));
				} catch (Exception ex) {
					org.eclipse.draw2d.Label exceptionLabel = new org.eclipse.draw2d.Label();
					exceptionLabel.setForegroundColor(ColorConstants.black);
					exceptionLabel.setText(ex.getLocalizedMessage());
					background.add(exceptionLabel, new GridData(SWT.FILL, SWT.FILL, true, true));
				}
				
			}
		}
	}

	public void selectionChanged(SelectionChangedEvent event) {
		handleSelectionChanged(event.getSelection());
	}
}