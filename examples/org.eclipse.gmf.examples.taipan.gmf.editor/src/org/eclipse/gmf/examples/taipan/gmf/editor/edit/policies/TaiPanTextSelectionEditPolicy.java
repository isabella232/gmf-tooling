/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class TaiPanTextSelectionEditPolicy extends SelectionEditPolicy {

	/**
	 * @generated
	 */
	private IFigure selectionFeedbackFigure;

	/**
	 * @generated
	 */
	private IFigure focusFeedbackFigure;

	/**
	 * @generated
	 */
	protected void showSelection() {
		hideSelection();
		addFeedback(selectionFeedbackFigure = createSelectionFeedbackFigure());
		refreshSelectionFeedbackBounds();
	}

	/**
	 * @generated
	 */
	protected void hideSelection() {
		if (selectionFeedbackFigure != null) {
			removeFeedback(selectionFeedbackFigure);
			selectionFeedbackFigure = null;
		}
	}

	/**
	 * @generated
	 */
	protected void showFocus() {
		hideFocus();
		addFeedback(focusFeedbackFigure = createFocusFeedbackFigure());
		refreshFocusFeedbackBounds();
	}

	/**
	 * @generated
	 */
	protected void hideFocus() {
		if (focusFeedbackFigure != null) {
			removeFeedback(focusFeedbackFigure);
			focusFeedbackFigure = null;
		}
	}

	/**
	 * @generated
	 */
	protected Rectangle getFeedbackBounds() {
		Rectangle bounds;
		IFigure hostFigure = getHostFigure();
		if (hostFigure instanceof Label) {
			Label label = (Label) hostFigure;
			bounds = label.getTextBounds();
			bounds.union(label.getIconBounds());
			bounds.intersect(label.getBounds());
		} else if (hostFigure instanceof WrapLabel) {
			WrapLabel label = (WrapLabel) hostFigure;
			bounds = label.getTextBounds();
			bounds.union(label.getIconBounds());
			bounds.intersect(label.getBounds());
		} else {
			bounds = getHostFigure().getBounds().getCopy();
		}
		return bounds;
	}

	/**
	 * @generated
	 */
	protected void refreshSelectionFeedbackBounds() {
		if (selectionFeedbackFigure != null) {
			selectionFeedbackFigure.setBounds(getFeedbackBounds().expand(2, 2));
		}
	}

	/**
	 * @generated
	 */
	protected void refreshFocusFeedbackBounds() {
		if (focusFeedbackFigure != null) {
			focusFeedbackFigure.setBounds(getFeedbackBounds().expand(5, 5));
		}
	}

	/**
	 * @generated
	 */
	protected Color getFeedbackColor() {
		return null;
	}

	/**
	 * @generated
	 */
	protected IFigure createSelectionFeedbackFigure() {
		RectangleFigure feedbackFigure = new RectangleFigure();
		feedbackFigure.setFill(false);
		Color feedbackColor = getFeedbackColor();
		if (feedbackColor != null) {
			feedbackFigure.setForegroundColor(feedbackColor);
		}
		return feedbackFigure;
	}

	/**
	 * @generated
	 */
	protected IFigure createFocusFeedbackFigure() {
		RectangleFigure feedbackFigure = new RectangleFigure();
		feedbackFigure.setFill(false);
		Color feedbackColor = getFeedbackColor();
		if (feedbackColor != null) {
			feedbackFigure.setForegroundColor(feedbackColor);
		}
		feedbackFigure.setLineStyle(Graphics.LINE_DOT);
		return feedbackFigure;
	}

	/**
	 * @generated
	 */
	public void refreshFeedback() {
		refreshSelectionFeedbackBounds();
		refreshFocusFeedbackBounds();
	}
}
