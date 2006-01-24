package org.eclipse.gmf.ecore.edit.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;

/**
 * @generated
 */
public class EcoreModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		Object editPart = host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof EPackageEditPart) {
			List children = new ArrayList();
			children.add(EcoreElementTypes.EClass_1001);
			children.add(EcoreElementTypes.EPackage_1002);
			children.add(EcoreElementTypes.EAnnotation_1003);
			children.add(EcoreElementTypes.EDataType_1004);
			children.add(EcoreElementTypes.EEnum_1005);
			return children;
		}
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
		return Collections.EMPTY_LIST;
	}
}
