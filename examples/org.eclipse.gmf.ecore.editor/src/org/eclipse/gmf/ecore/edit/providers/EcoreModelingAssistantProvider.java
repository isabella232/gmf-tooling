package org.eclipse.gmf.ecore.edit.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation4EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation5EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation_detailsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_attributesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_classannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_operationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType_datatypeannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_enumannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_literalsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_classesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_datatypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_enumsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_packageannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_packagesEditPart;

/**
 * @generated
 */
public class EcoreModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		Object editPart = host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof EClassEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAttribute_2001);
			children.add(EcoreElementTypes.EOperation_2002);
			children.add(EcoreElementTypes.EAnnotation_2003);
			return children;
		}
		if (editPart instanceof EPackage2EditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EClass_2004);
			children.add(EcoreElementTypes.EPackage_2005);
			children.add(EcoreElementTypes.EDataType_2006);
			children.add(EcoreElementTypes.EEnum_2007);
			children.add(EcoreElementTypes.EAnnotation_2008);
			return children;
		}
		if (editPart instanceof EAnnotation3EditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EStringToStringMapEntry_2009);
			return children;
		}
		if (editPart instanceof EDataType2EditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAnnotation_2010);
			return children;
		}
		if (editPart instanceof EEnum2EditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EEnumLiteral_2011);
			children.add(EcoreElementTypes.EAnnotation_2012);
			return children;
		}
		if (editPart instanceof EClass_attributesEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAttribute_2001);
			return children;
		}
		if (editPart instanceof EClass_operationsEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EOperation_2002);
			return children;
		}
		if (editPart instanceof EClass_classannotationsEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAnnotation_2003);
			return children;
		}
		if (editPart instanceof EPackage_classesEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EClass_2004);
			return children;
		}
		if (editPart instanceof EPackage_packagesEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EPackage_2005);
			return children;
		}
		if (editPart instanceof EPackage_datatypesEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EDataType_2006);
			return children;
		}
		if (editPart instanceof EPackage_enumsEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EEnum_2007);
			return children;
		}
		if (editPart instanceof EPackage_packageannotationsEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAnnotation_2008);
			return children;
		}
		if (editPart instanceof EAnnotation_detailsEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EStringToStringMapEntry_2009);
			return children;
		}
		if (editPart instanceof EDataType_datatypeannotationsEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAnnotation_2010);
			return children;
		}
		if (editPart instanceof EEnum_literalsEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EEnumLiteral_2011);
			return children;
		}
		if (editPart instanceof EEnum_enumannotationsEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAnnotation_2012);
			return children;
		}
		if (editPart instanceof EPackageEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EClass_1001);
			children.add(EcoreElementTypes.EPackage_1002);
			children.add(EcoreElementTypes.EAnnotation_1003);
			children.add(EcoreElementTypes.EDataType_1004);
			children.add(EcoreElementTypes.EEnum_1005);
			return children;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		Object sourceEditPart = source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof EClassEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EReference_3002);
			children.add(EcoreElementTypes.EReference_3003);
			children.add(EcoreElementTypes.EClassESuperTypes_3004);
			return children;
		}
		if (sourceEditPart instanceof EAnnotation4EditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAnnotationReferences_3001);
			return children;
		}
		if (sourceEditPart instanceof EAnnotation2EditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAnnotationReferences_3001);
			return children;
		}
		if (sourceEditPart instanceof EAnnotationEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAnnotationReferences_3001);
			return children;
		}
		if (sourceEditPart instanceof EAnnotation5EditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAnnotationReferences_3001);
			return children;
		}
		if (sourceEditPart instanceof EAnnotation3EditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EAnnotationReferences_3001);
			return children;
		}
		if (sourceEditPart instanceof EClass2EditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EReference_3002);
			children.add(EcoreElementTypes.EReference_3003);
			children.add(EcoreElementTypes.EClassESuperTypes_3004);
			return children;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		Object targetEditPart = target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof EClassEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EClassESuperTypes_3004);
			return children;
		}
		if (targetEditPart instanceof EClass2EditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EClassESuperTypes_3004);
			return children;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		Object sourceEditPart = source.getAdapter(IGraphicalEditPart.class);
		Object targetEditPart = target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof EClassEditPart) {
			List children = new ArrayList();
			if (targetEditPart instanceof EClassEditPart) {
				children.add(EcoreElementTypes.EClassESuperTypes_3004);
			}
			if (targetEditPart instanceof EClass2EditPart) {
				children.add(EcoreElementTypes.EClassESuperTypes_3004);
			}
			return children;
		}
		if (sourceEditPart instanceof EAnnotation4EditPart) {
			List children = new ArrayList();
			return children;
		}
		if (sourceEditPart instanceof EAnnotation2EditPart) {
			List children = new ArrayList();
			return children;
		}
		if (sourceEditPart instanceof EAnnotationEditPart) {
			List children = new ArrayList();
			return children;
		}
		if (sourceEditPart instanceof EAnnotation5EditPart) {
			List children = new ArrayList();
			return children;
		}
		if (sourceEditPart instanceof EAnnotation3EditPart) {
			List children = new ArrayList();
			return children;
		}
		if (sourceEditPart instanceof EClass2EditPart) {
			List children = new ArrayList();
			if (targetEditPart instanceof EClassEditPart) {
				children.add(EcoreElementTypes.EClassESuperTypes_3004);
			}
			if (targetEditPart instanceof EClass2EditPart) {
				children.add(EcoreElementTypes.EClassESuperTypes_3004);
			}
			return children;
		}
		return Collections.EMPTY_LIST;
	}
}
