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
			if (!EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(view))) {
				return null;
			}

			int viewVisualID = EcoreVisualIDRegistry.getVisualID(view);
			switch (viewVisualID) {
			case 1001:
				return new EClassEditPart(view);
			case 4004:
				return new EClass_nameEditPart(view);
			case 1002:
				return new EPackage2EditPart(view);
			case 4009:
				return new EPackage_name2EditPart(view);
			case 1003:
				return new EAnnotation2EditPart(view);
			case 4011:
				return new EAnnotation_source2EditPart(view);
			case 1004:
				return new EDataType2EditPart(view);
			case 4012:
				return new EDataType_name2EditPart(view);
			case 1005:
				return new EEnum2EditPart(view);
			case 4014:
				return new EEnum_name2EditPart(view);
			case 2001:
				return new EAttributeEditPart(view);
			case 2002:
				return new EOperationEditPart(view);
			case 2003:
				return new EAnnotationEditPart(view);
			case 2004:
				return new EClass2EditPart(view);
			case 2005:
				return new EPackage3EditPart(view);
			case 2006:
				return new EDataTypeEditPart(view);
			case 2007:
				return new EEnumEditPart(view);
			case 2008:
				return new EStringToStringMapEntryEditPart(view);
			case 2009:
				return new EEnumLiteralEditPart(view);
			case 5001:
				return new EClass_attributesEditPart(view);
			case 5002:
				return new EClass_operationsEditPart(view);
			case 5003:
				return new EClass_classannotationsEditPart(view);
			case 5004:
				return new EPackage_classesEditPart(view);
			case 5005:
				return new EPackage_packagesEditPart(view);
			case 5006:
				return new EPackage_datatypesEditPart(view);
			case 5007:
				return new EPackage_enumsEditPart(view);
			case 5008:
				return new EPackage_packageannotationsEditPart(view);
			case 5009:
				return new EAnnotation_detailsEditPart(view);
			case 5010:
				return new EDataType_datatypeannotationsEditPart(view);
			case 5011:
				return new EEnum_literalsEditPart(view);
			case 5012:
				return new EEnum_enumannotationsEditPart(view);
			case 79:
				return new EPackageEditPart(view);
			case 3001:
				return new ReferencesEditPart(view);
			case 3002:
				return new EReferenceEditPart(view);
			case 4015:
				return new EReference_nameEditPart(view);
			case 3003:
				return new EReference2EditPart(view);
			case 4016:
				return new EReference_name2EditPart(view);
			case 3004:
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

	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrapLabel)
			return new TextCellEditorLocator((WrapLabel) source.getFigure());
		else {
			IFigure figure = source.getFigure();
			return new LabelCellEditorLocator((Label) figure);
		}
	}

	static private class TextCellEditorLocator implements CellEditorLocator {

		private WrapLabel wrapLabel;

		public TextCellEditorLocator(WrapLabel wrapLabel) {
			super();
			this.wrapLabel = wrapLabel;
		}

		public WrapLabel getWrapLabel() {
			return wrapLabel;
		}

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

	private static class LabelCellEditorLocator implements CellEditorLocator {

		private Label label;

		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		public Label getLabel() {
			return label;
		}

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
