/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev.insider.internal.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FreeformFigure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.dev.insider.internal.InsiderAccess;
import org.eclipse.gmf.dev.insider.internal.InsiderPlugin;
import org.eclipse.gmf.dev.insider.internal.PresentationFigure;
import org.eclipse.gmf.dev.insider.internal.PresentationLink;
import org.eclipse.gmf.dev.insider.internal.PresentationNode;
import org.eclipse.gmf.dev.insider.internal.View;
import org.eclipse.gmf.dev.insider.internal.PresentationFactory.PresentationVisitor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IViewSite;

/**
 * @author dstadnik
 */
public class PresentationController implements ISelectionChangedListener {

	public PresentationController(IViewSite viewSite) {
		assert viewSite != null;
		myViewSite = viewSite;
	}

	public void open(View view) {
		FreeformFigure presentation = InsiderAccess.getPresentationFactory().createPresentation(view);
		PresentationView presentationView = getPresentationView(true);
		if (presentationView != null) {
			if (presentationView.getContents().getLayer(LayerConstants.PRIMARY_LAYER) != null) {
				presentationView.getContents().removeLayer(LayerConstants.PRIMARY_LAYER);
			}
			presentationView.getContents().add(presentation, LayerConstants.PRIMARY_LAYER);
		}
	}

	public void selectionChanged(SelectionChangedEvent event) {
		PresentationView presentationView = getPresentationView(false);
		if (presentationView == null) {
			return;
		}
		final List elements = ((IStructuredSelection) event.getSelection()).toList();
		final List figures = new ArrayList(elements.size());
		InsiderAccess.getPresentationFactory().traverse(presentationView.getContents(), new PresentationVisitor() {

			public boolean accept(PresentationFigure figure) {
				if (elements.contains(figure.getFigureElement())) {
					figures.add(figure);
				}
				return false;
			}
		});
		if (presentationView.getContents().getLayer(LayerConstants.FEEDBACK_LAYER) != null) {
			presentationView.getContents().removeLayer(LayerConstants.FEEDBACK_LAYER);
		}
		FreeformLayer feedbackLayer = new FreeformLayer();
		for (int i = 0; i < figures.size(); i++) {
			PresentationFigure figure = (PresentationFigure) figures.get(i);
			IFigure feedbackFigure;
			if (figure instanceof PresentationLink) {
				feedbackFigure = new PresentationLink(null);
				((PresentationLink) feedbackFigure).setPoints(((PresentationLink) figure).getPoints());
			} else {
				feedbackFigure = new PresentationNode(null);
				feedbackFigure.setBounds(figure.getBounds());
			}
			feedbackFigure.setForegroundColor(ColorConstants.blue);
			feedbackLayer.add(feedbackFigure);
		}
		presentationView.getContents().addLayerAfter(feedbackLayer, LayerConstants.FEEDBACK_LAYER, LayerConstants.PRIMARY_LAYER);
	}

	private PresentationView getPresentationView(boolean create) {
		try {
			if (create) {
				return (PresentationView) getViewSite().getPage().showView("org.eclipse.gmf.dev.insider.PresentationView"); //$NON-NLS-1$
			} else {
				return (PresentationView) getViewSite().getPage().findView("org.eclipse.gmf.dev.insider.PresentationView"); //$NON-NLS-1$
			}
		} catch (Exception e) {
			InsiderPlugin.logError(null, e);
		}
		return null;
	}

	private IViewSite getViewSite() {
		return myViewSite;
	}

	private IViewSite myViewSite;
}
