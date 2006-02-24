package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.gmf.ecore.editor.EcoreDiagramEditorPlugin;

import org.eclipse.gmf.ecore.providers.EcoreSemanticHints;

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
	private String getModelID(View containerView) {
		EAnnotation annotation = containerView.getEAnnotation("ViewIdentifier"); //$NON-NLS-1$
		if (annotation == null) {
			return null;
		}
		return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private int getVisualID(View containerView) {
		EAnnotation annotation = containerView.getEAnnotation("ViewIdentifier"); //$NON-NLS-1$
		if (annotation == null) {
			return -1;
		}
		String visualID = (String) annotation.getDetails().get("visualID"); //$NON-NLS-1$
		if (visualID == null) {
			return -1;
		}
		try {
			return Integer.parseInt(visualID);
		} catch (NumberFormatException e) {
			EcoreDiagramEditorPlugin.getInstance().logError("Unable to parse \"visualID\" annotation: " + visualID, e);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			if (!"Ecore".equals(getModelID(view))) {
				return null;
			}

			int viewVisualID = getVisualID(view);
			switch (viewVisualID) {
			case 1001:
				return new EClassEditPart(view);
			case 4004:
				return new EClass_nameEditPart(view);
			case 1002:
				return new EPackage2EditPart(view);
			case 4010:
				return new EPackage_name2EditPart(view);
			case 1003:
				return new EAnnotation3EditPart(view);
			case 4012:
				return new EAnnotation_source3EditPart(view);
			case 1004:
				return new EDataType2EditPart(view);
			case 4014:
				return new EDataType_name2EditPart(view);
			case 1005:
				return new EEnum2EditPart(view);
			case 4017:
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
				return new EAnnotation2EditPart(view);
			case 2009:
				return new EStringToStringMapEntryEditPart(view);
			case 2010:
				return new EAnnotation4EditPart(view);
			case 2011:
				return new EEnumLiteralEditPart(view);
			case 2012:
				return new EAnnotation5EditPart(view);
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
			case 4018:
				if (EcoreSemanticHints.EReference_3002Labels.EREFERENCENAME_4018_LABEL.equals(view.getType())) {
					return new EReference_nameEditPart(view);
				} else {
					return new EReference_nameTextEditPart(view);
				}
			case 3003:
				return new EReference2EditPart(view);
			case 4019:
				if (EcoreSemanticHints.EReference_3003Labels.EREFERENCENAME_4019_LABEL.equals(view.getType())) {
					return new EReference_name2EditPart(view);
				} else {
					return new EReference_name2TextEditPart(view);
				}
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

}
