package org.eclipse.gmf.ecore.edit.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation_detailsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_attributesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_classannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_operationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType_datatypeannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_enumannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_literalsEditPart;
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
}
