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
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

/**
 * @generated
 */
public class TaiPanEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public static final String EXTERNAL_NODE_LABELS_LAYER = "External Node Labels"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			int viewVisualID = TaiPanVisualIDRegistry.getVisualID(view);
			switch (viewVisualID) {
			case PortEditPart.VISUAL_ID:
				return new PortEditPart(view);
			case Port_locationEditPart.VISUAL_ID:
				return new Port_locationEditPart(view);
			case ShipEditPart.VISUAL_ID:
				return new ShipEditPart(view);
			case Ship_nameEditPart.VISUAL_ID:
				return new Ship_nameEditPart(view);
			case SmallItemsEditPart.VISUAL_ID:
				return new SmallItemsEditPart(view);
			case LargeItemEditPart.VISUAL_ID:
				return new LargeItemEditPart(view);
			case LargeItem_articleEditPart.VISUAL_ID:
				return new LargeItem_articleEditPart(view);
			case LargeItem_weightEditPart.VISUAL_ID:
				return new LargeItem_weightEditPart(view);
			case EmptyBoxEditPart.VISUAL_ID:
				return new EmptyBoxEditPart(view);
			case Ship_SmallCargoCompartmentEditPart.VISUAL_ID:
				return new Ship_SmallCargoCompartmentEditPart(view);
			case Ship_LargeCargoCompartmentEditPart.VISUAL_ID:
				return new Ship_LargeCargoCompartmentEditPart(view);
			case AquatoryEditPart.VISUAL_ID:
				return new AquatoryEditPart(view);
			case DestinationEditPart.VISUAL_ID:
				return new DestinationEditPart(view);
			case Destination_UnknownEditPart.VISUAL_ID:
				return new Destination_UnknownEditPart(view);
			case RouteEditPart.VISUAL_ID:
				return new RouteEditPart(view);
			case Route_descriptionEditPart.VISUAL_ID:
				return new Route_descriptionEditPart(view);
			case Route_reliabilityEditPart.VISUAL_ID:
				return new Route_reliabilityEditPart(view);
			case Route2EditPart.VISUAL_ID:
				return new Route2EditPart(view);
			case Route_description2EditPart.VISUAL_ID:
				return new Route_description2EditPart(view);
			case Route_reliability2EditPart.VISUAL_ID:
				return new Route_reliability2EditPart(view);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrapLabel)
			return new TextCellEditorLocator((WrapLabel) source.getFigure());
		else {
			IFigure figure = source.getFigure();
			return new LabelCellEditorLocator((Label) figure);
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrapLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrapLabel wrapLabel) {
			super();
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrapLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);

			if (getWrapLabel().isTextWrapped() && getWrapLabel().getText().length() > 0)
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			else {
				int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			}

			if (!rect.equals(new Rectangle(text.getBounds())))
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
		}

	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);

			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));

			if (!rect.equals(new Rectangle(text.getBounds())))
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
		}
	}
}
