/**
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.ecore.edit.parts;

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
import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

/**
 * @generated
 */
public class EcoreEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public static final String EXTERNAL_NODE_LABELS_LAYER = "External Node Labels";

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			int viewVisualID = EcoreVisualIDRegistry.getVisualID(view);
			switch (viewVisualID) {
			case EClassEditPart.VISUAL_ID:
				return new EClassEditPart(view);
			case EClass_nameEditPart.VISUAL_ID:
				return new EClass_nameEditPart(view);
			case EPackage2EditPart.VISUAL_ID:
				return new EPackage2EditPart(view);
			case EPackage_nameEditPart.VISUAL_ID:
				return new EPackage_nameEditPart(view);
			case EAnnotation2EditPart.VISUAL_ID:
				return new EAnnotation2EditPart(view);
			case EAnnotation_sourceEditPart.VISUAL_ID:
				return new EAnnotation_sourceEditPart(view);
			case EDataType2EditPart.VISUAL_ID:
				return new EDataType2EditPart(view);
			case EDataType_nameEditPart.VISUAL_ID:
				return new EDataType_nameEditPart(view);
			case EEnum2EditPart.VISUAL_ID:
				return new EEnum2EditPart(view);
			case EEnum_nameEditPart.VISUAL_ID:
				return new EEnum_nameEditPart(view);
			case EAttributeEditPart.VISUAL_ID:
				return new EAttributeEditPart(view);
			case EOperationEditPart.VISUAL_ID:
				return new EOperationEditPart(view);
			case EAnnotationEditPart.VISUAL_ID:
				return new EAnnotationEditPart(view);
			case EClass2EditPart.VISUAL_ID:
				return new EClass2EditPart(view);
			case EPackage3EditPart.VISUAL_ID:
				return new EPackage3EditPart(view);
			case EDataTypeEditPart.VISUAL_ID:
				return new EDataTypeEditPart(view);
			case EEnumEditPart.VISUAL_ID:
				return new EEnumEditPart(view);
			case EStringToStringMapEntryEditPart.VISUAL_ID:
				return new EStringToStringMapEntryEditPart(view);
			case EEnumLiteralEditPart.VISUAL_ID:
				return new EEnumLiteralEditPart(view);
			case EClass_attributesEditPart.VISUAL_ID:
				return new EClass_attributesEditPart(view);
			case EClass_operationsEditPart.VISUAL_ID:
				return new EClass_operationsEditPart(view);
			case EClass_classannotationsEditPart.VISUAL_ID:
				return new EClass_classannotationsEditPart(view);
			case EPackage_classesEditPart.VISUAL_ID:
				return new EPackage_classesEditPart(view);
			case EPackage_packagesEditPart.VISUAL_ID:
				return new EPackage_packagesEditPart(view);
			case EPackage_datatypesEditPart.VISUAL_ID:
				return new EPackage_datatypesEditPart(view);
			case EPackage_enumsEditPart.VISUAL_ID:
				return new EPackage_enumsEditPart(view);
			case EPackage_packageannotationsEditPart.VISUAL_ID:
				return new EPackage_packageannotationsEditPart(view);
			case EAnnotation_detailsEditPart.VISUAL_ID:
				return new EAnnotation_detailsEditPart(view);
			case EDataType_datatypeannotationsEditPart.VISUAL_ID:
				return new EDataType_datatypeannotationsEditPart(view);
			case EEnum_literalsEditPart.VISUAL_ID:
				return new EEnum_literalsEditPart(view);
			case EEnum_enumannotationsEditPart.VISUAL_ID:
				return new EEnum_enumannotationsEditPart(view);
			case EPackageEditPart.VISUAL_ID:
				return new EPackageEditPart(view);
			case ReferencesEditPart.VISUAL_ID:
				return new ReferencesEditPart(view);
			case EReferenceEditPart.VISUAL_ID:
				return new EReferenceEditPart(view);
			case EReference_nameEditPart.VISUAL_ID:
				return new EReference_nameEditPart(view);
			case EReference2EditPart.VISUAL_ID:
				return new EReference2EditPart(view);
			case EReference_name2EditPart.VISUAL_ID:
				return new EReference_name2EditPart(view);
			case ESuperTypesEditPart.VISUAL_ID:
				return new ESuperTypesEditPart(view);
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
