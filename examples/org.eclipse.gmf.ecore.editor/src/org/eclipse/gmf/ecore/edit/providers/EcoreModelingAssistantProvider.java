package org.eclipse.gmf.ecore.edit.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
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
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof EClassEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAttribute_2001);
			types.add(EcoreElementTypes.EOperation_2002);
			types.add(EcoreElementTypes.EAnnotation_2003);
			return types;
		}
		if (editPart instanceof EPackage2EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EClass_2004);
			types.add(EcoreElementTypes.EPackage_2005);
			types.add(EcoreElementTypes.EDataType_2006);
			types.add(EcoreElementTypes.EEnum_2007);
			types.add(EcoreElementTypes.EAnnotation_2008);
			return types;
		}
		if (editPart instanceof EAnnotation3EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EStringToStringMapEntry_2009);
			return types;
		}
		if (editPart instanceof EDataType2EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotation_2010);
			return types;
		}
		if (editPart instanceof EEnum2EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EEnumLiteral_2011);
			types.add(EcoreElementTypes.EAnnotation_2012);
			return types;
		}
		if (editPart instanceof EClass_attributesEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAttribute_2001);
			return types;
		}
		if (editPart instanceof EClass_operationsEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EOperation_2002);
			return types;
		}
		if (editPart instanceof EClass_classannotationsEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotation_2003);
			return types;
		}
		if (editPart instanceof EPackage_classesEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EClass_2004);
			return types;
		}
		if (editPart instanceof EPackage_packagesEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EPackage_2005);
			return types;
		}
		if (editPart instanceof EPackage_datatypesEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EDataType_2006);
			return types;
		}
		if (editPart instanceof EPackage_enumsEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EEnum_2007);
			return types;
		}
		if (editPart instanceof EPackage_packageannotationsEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotation_2008);
			return types;
		}
		if (editPart instanceof EAnnotation_detailsEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EStringToStringMapEntry_2009);
			return types;
		}
		if (editPart instanceof EDataType_datatypeannotationsEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotation_2010);
			return types;
		}
		if (editPart instanceof EEnum_literalsEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EEnumLiteral_2011);
			return types;
		}
		if (editPart instanceof EEnum_enumannotationsEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotation_2012);
			return types;
		}
		if (editPart instanceof EPackageEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EClass_1001);
			types.add(EcoreElementTypes.EPackage_1002);
			types.add(EcoreElementTypes.EAnnotation_1003);
			types.add(EcoreElementTypes.EDataType_1004);
			types.add(EcoreElementTypes.EEnum_1005);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof EAnnotationEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
			return types;
		}
		if (sourceEditPart instanceof EAnnotation4EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
			return types;
		}
		if (sourceEditPart instanceof EAnnotation3EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
			return types;
		}
		if (sourceEditPart instanceof EClassEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EReference_3003);
			types.add(EcoreElementTypes.EReference_3002);
			types.add(EcoreElementTypes.EClassESuperTypes_3004);
			return types;
		}
		if (sourceEditPart instanceof EAnnotation5EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
			return types;
		}
		if (sourceEditPart instanceof EClass2EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EReference_3003);
			types.add(EcoreElementTypes.EReference_3002);
			types.add(EcoreElementTypes.EClassESuperTypes_3004);
			return types;
		}
		if (sourceEditPart instanceof EAnnotation2EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof EClassEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EClassESuperTypes_3004);
			return types;
		}
		if (targetEditPart instanceof EClass2EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EClassESuperTypes_3004);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof EAnnotationEditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EAnnotation4EditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EAnnotation3EditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EClassEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof EClassEditPart) {
				types.add(EcoreElementTypes.EClassESuperTypes_3004);
			}
			if (targetEditPart instanceof EClass2EditPart) {
				types.add(EcoreElementTypes.EClassESuperTypes_3004);
			}
			return types;
		}
		if (sourceEditPart instanceof EAnnotation5EditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EClass2EditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof EClassEditPart) {
				types.add(EcoreElementTypes.EClassESuperTypes_3004);
			}
			if (targetEditPart instanceof EClass2EditPart) {
				types.add(EcoreElementTypes.EClassESuperTypes_3004);
			}
			return types;
		}
		if (sourceEditPart instanceof EAnnotation2EditPart) {
			List types = new ArrayList();
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof EClassEditPart) {
			List types = new ArrayList();
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_3004) {
				types.add(EcoreElementTypes.EClass_1001);
			}
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_3004) {
				types.add(EcoreElementTypes.EClass_2004);
			}
			return types;
		}
		if (targetEditPart instanceof EClass2EditPart) {
			List types = new ArrayList();
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_3004) {
				types.add(EcoreElementTypes.EClass_1001);
			}
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_3004) {
				types.add(EcoreElementTypes.EClass_2004);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof EAnnotationEditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EAnnotation4EditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EAnnotation3EditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EClassEditPart) {
			List types = new ArrayList();
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_3004) {
				types.add(EcoreElementTypes.EClass_1001);
			}
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_3004) {
				types.add(EcoreElementTypes.EClass_2004);
			}
			return types;
		}
		if (sourceEditPart instanceof EAnnotation5EditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EClass2EditPart) {
			List types = new ArrayList();
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_3004) {
				types.add(EcoreElementTypes.EClass_1001);
			}
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_3004) {
				types.add(EcoreElementTypes.EClass_2004);
			}
			return types;
		}
		if (sourceEditPart instanceof EAnnotation2EditPart) {
			List types = new ArrayList();
			return types;
		}
		return Collections.EMPTY_LIST;
	}
}
