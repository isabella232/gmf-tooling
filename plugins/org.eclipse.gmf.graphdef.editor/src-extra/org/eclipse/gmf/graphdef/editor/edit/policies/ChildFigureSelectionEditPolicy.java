/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.policies;

import java.util.Iterator;

import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.graphdef.editor.edit.parts.AbstractFigureEditPart;
import org.eclipse.gmf.graphdef.editor.edit.policies.assistant.AssistantFigureKeyListener;
import org.eclipse.gmf.graphdef.editor.edit.policies.assistant.BubbleFigure;
import org.eclipse.gmf.graphdef.editor.edit.policies.assistant.HeadlessDiagramGraphicalViewer;
import org.eclipse.gmf.graphdef.editor.edit.policies.assistant.PreviewFigure;
import org.eclipse.gmf.graphdef.editor.edit.policies.assistant.SelectEditPartDragTracker;
import org.eclipse.gmf.graphdef.editor.edit.policies.assistant.SelectableBubbleItemFigure;
import org.eclipse.gmf.graphdef.editor.edit.policies.keyhandler.KeyHandler;
import org.eclipse.gmf.graphdef.editor.edit.policies.keyhandler.KeyPressedRequest;
import org.eclipse.gmf.graphdef.editor.part.GMFGraphDiagramEditorPlugin;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;

public class ChildFigureSelectionEditPolicy extends DiagramAssistantEditPolicy implements KeyHandlerEditPolicy {

	private static final String PNG_EXTENSION = ".png";

	private static final String ICONS_FOLDER = "icons/handles/";

	private static final String UNKNOWN_FIGURE_ICON = ICONS_FOLDER + "Unknown" + PNG_EXTENSION;

	private BubbleFigure myFeedbackFigure;

	private static Figure getFigure(EditPart editPart) {
		View view = ((IGraphicalEditPart) editPart).getNotationView();
		if (view != null && view.getElement() instanceof Figure) {
			return (Figure) view.getElement();
		}
		return null;
	}

	public void processRequest(KeyPressedRequest request) {
		if (KeyHandler.ACTIVATE_CHILD_SELECTION.equals(request.getKeyStroke()) && !isDiagramAssistantShowing()) {
			showDiagramAssistant(request.getLocation());
			request.markPerformed();
		}
	}

	public void activate() {
		// TODO: copied from DiagramAssistantEditPolicy. M.b. use super
		// implementation of this method?
		getHost().addEditPartListener(new EditPartListener.Stub() {

			public void selectedStateChanged(EditPart editpart) {
				if (!editpart.hasFocus() || !shouldShowDiagramAssistant()) {
					hideDiagramAssistant();
				}
			}

		});
	}

	@Override
	protected void hideDiagramAssistant() {
		if (getHost() instanceof AbstractFigureEditPart) {
			((AbstractFigureEditPart) getHost()).setDragAllowed(true);
		}
		if (getFeedbackFigure() == null) {
			return;
		}
		disposeFeedbackFigure();
	}

	protected boolean isDiagramAssistant(Object object) {
		return object instanceof BubbleFigure;
	}

	@Override
	protected boolean isDiagramAssistantShowing() {
		return getFeedbackFigure() != null;
	}

	@Override
	protected void showDiagramAssistant(Point referencePoint) {
		if (getFeedbackFigure() != null || getRealFigure() == null || getRealFigure().getChildren().size() == 0) {
			return;
		}
		initFeedbackFigure();
		setLocation(getFeedbackFigure(), referencePoint);
		if (getHost() instanceof AbstractFigureEditPart) {
			((AbstractFigureEditPart) getHost()).setDragAllowed(false);
		}
	}

	private void setLocation(BubbleFigure feedbackFigure, Point referencePoint) {
		Point point = referencePoint.getCopy();
		getHostFigure().translateToAbsolute(point);
		feedbackFigure.translateToRelative(point);
		point.translate(0, -feedbackFigure.getSize().height);
		feedbackFigure.setLocation(point);
	}

	private void initFeedbackFigure() {
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		myFeedbackFigure = new BubbleFigure();
		HeadlessDiagramGraphicalViewer viewer = new HeadlessDiagramGraphicalViewer(getHost().getViewer().getEditPartFactory(), layer.getFont(), TransactionUtil.getEditingDomain(getRealFigure()));
		for (Iterator it = getHost().getChildren().iterator(); it.hasNext();) {
			IGraphicalEditPart childEditPart = (IGraphicalEditPart) it.next();
			Figure figure = getFigure(childEditPart);
			if (figure != null) {
				final SelectableBubbleItemFigure itemFigure = new SelectableBubbleItemFigure(new SelectEditPartDragTracker(childEditPart));
				itemFigure.addMouseMotionListener(new MouseMotionListener.Stub() {

					@Override
					public void mouseEntered(MouseEvent me) {
						myFeedbackFigure.selectChild(itemFigure);
					}
				});
				myFeedbackFigure.add(itemFigure);
				PreviewFigure previewFigure = new PreviewFigure(childEditPart.getNotationView(), viewer);
				// TODO: Better check for figure instance here.
				if (previewFigure.isPreviewValid()) {
					previewFigure.setPreferredSize(15, 15);
					itemFigure.setItemRepresentation(BubbleFigure.Mode.PREVIEW, previewFigure);
				} else {
					itemFigure.setItemRepresentation(BubbleFigure.Mode.PREVIEW, new ImageFigure(GMFGraphDiagramEditorPlugin.getInstance().getBundledImage(UNKNOWN_FIGURE_ICON)));
				}
				itemFigure.setItemRepresentation(BubbleFigure.Mode.ICON, getImageFigure(figure));
				if (myFeedbackFigure.getChildren().size() == 1) {
					myFeedbackFigure.selectChild(itemFigure);
				}
			}
		}

		myFeedbackFigure.setMode(BubbleFigure.Mode.PREVIEW);
		myFeedbackFigure.setSize(myFeedbackFigure.getPreferredSize());
		layer.add(myFeedbackFigure);
		myFeedbackFigure.addKeyListener(new AssistantFigureKeyListener(myFeedbackFigure) {

			@Override
			protected void hideAssistant() {
				hideDiagramAssistant();
			}
		});
		myFeedbackFigure.addFocusListener(new org.eclipse.draw2d.FocusListener.Stub() {

			@Override
			public void focusLost(FocusEvent fe) {
				Display.getCurrent().asyncExec(new Runnable() {

					public void run() {
						hideDiagramAssistant();
					}
				});
			}
		});
		myFeedbackFigure.requestFocus();
	}

	private IFigure getImageFigure(Figure figure) {
		switch (figure.eClass().getClassifierID()) {
		case GMFGraphPackage.ELLIPSE:
		case GMFGraphPackage.LABEL:
		case GMFGraphPackage.POINT:
		case GMFGraphPackage.POLYGON:
		case GMFGraphPackage.POLYLINE:
		case GMFGraphPackage.RECTANGLE:
		case GMFGraphPackage.ROUNDED_RECTANGLE:
			return new ImageFigure(GMFGraphDiagramEditorPlugin.getInstance().getBundledImage(ICONS_FOLDER + figure.eClass().getName() + PNG_EXTENSION));
		default:
			return new ImageFigure(GMFGraphDiagramEditorPlugin.getInstance().getBundledImage(UNKNOWN_FIGURE_ICON));
		}
	}

	private void disposeFeedbackFigure() {
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		layer.remove(getFeedbackFigure());
		myFeedbackFigure = null;
	}

	private RealFigure getRealFigure() {
		Figure figure = getFigure(getHost());
		return figure instanceof RealFigure ? (RealFigure) figure : null;
	}

	private BubbleFigure getFeedbackFigure() {
		return myFeedbackFigure;
	}

}
