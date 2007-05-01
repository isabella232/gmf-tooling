/*
 * Copyright (c) 2006, 2007 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationDetailsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassAttributesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassClassAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassOperationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeDataTypeAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEnumAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageClassesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageDataTypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEnumsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackagePackageAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackagePackagesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EcoreDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return view.getEAnnotation("Shortcut") != null && view.isSetElement() && (view.getElement() == null || view.getElement().eIsProxy()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EClassAttributesEditPart.VISUAL_ID:
			return getEClassAttributes_7001SemanticChildren(view);
		case EClassOperationsEditPart.VISUAL_ID:
			return getEClassOperations_7002SemanticChildren(view);
		case EClassClassAnnotationsEditPart.VISUAL_ID:
			return getEClassClassAnnotations_7003SemanticChildren(view);
		case EPackageClassesEditPart.VISUAL_ID:
			return getEPackageClasses_7004SemanticChildren(view);
		case EPackagePackagesEditPart.VISUAL_ID:
			return getEPackagePackages_7005SemanticChildren(view);
		case EPackageDataTypesEditPart.VISUAL_ID:
			return getEPackageDataTypes_7006SemanticChildren(view);
		case EPackageEnumsEditPart.VISUAL_ID:
			return getEPackageEnums_7007SemanticChildren(view);
		case EPackagePackageAnnotationsEditPart.VISUAL_ID:
			return getEPackagePackageAnnotations_7008SemanticChildren(view);
		case EAnnotationDetailsEditPart.VISUAL_ID:
			return getEAnnotationDetails_7009SemanticChildren(view);
		case EDataTypeDataTypeAnnotationsEditPart.VISUAL_ID:
			return getEDataTypeDataTypeAnnotations_7010SemanticChildren(view);
		case EEnumLiteralsEditPart.VISUAL_ID:
			return getEEnumLiterals_7011SemanticChildren(view);
		case EEnumEnumAnnotationsEditPart.VISUAL_ID:
			return getEEnumEnumAnnotations_7012SemanticChildren(view);
		case EPackageEditPart.VISUAL_ID:
			return getEPackage_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEClassAttributes_7001SemanticChildren(View view) {
		EClass modelElement = (EClass) view.getElement();
		List semanticChildren = getEClassAttributes_7001SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEClassAttributes_7001DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEClassOperations_7002SemanticChildren(View view) {
		EClass modelElement = (EClass) view.getElement();
		List semanticChildren = getEClassOperations_7002SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEClassOperations_7002DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEClassClassAnnotations_7003SemanticChildren(View view) {
		EClass modelElement = (EClass) view.getElement();
		List semanticChildren = getEClassClassAnnotations_7003SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEClassClassAnnotations_7003DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPackageClasses_7004SemanticChildren(View view) {
		EPackage modelElement = (EPackage) view.getElement();
		List semanticChildren = getEPackageClasses_7004SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEPackageClasses_7004DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPackagePackages_7005SemanticChildren(View view) {
		EPackage modelElement = (EPackage) view.getElement();
		List semanticChildren = getEPackagePackages_7005SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEPackagePackages_7005DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPackageDataTypes_7006SemanticChildren(View view) {
		EPackage modelElement = (EPackage) view.getElement();
		List semanticChildren = getEPackageDataTypes_7006SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEPackageDataTypes_7006DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPackageEnums_7007SemanticChildren(View view) {
		EPackage modelElement = (EPackage) view.getElement();
		List semanticChildren = getEPackageEnums_7007SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEPackageEnums_7007DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPackagePackageAnnotations_7008SemanticChildren(View view) {
		EPackage modelElement = (EPackage) view.getElement();
		List semanticChildren = getEPackagePackageAnnotations_7008SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEPackagePackageAnnotations_7008DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEAnnotationDetails_7009SemanticChildren(View view) {
		EAnnotation modelElement = (EAnnotation) view.getElement();
		List semanticChildren = getEAnnotationDetails_7009SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEAnnotationDetails_7009DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEDataTypeDataTypeAnnotations_7010SemanticChildren(View view) {
		EDataType modelElement = (EDataType) view.getElement();
		List semanticChildren = getEDataTypeDataTypeAnnotations_7010SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEDataTypeDataTypeAnnotations_7010DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEEnumLiterals_7011SemanticChildren(View view) {
		EEnum modelElement = (EEnum) view.getElement();
		List semanticChildren = getEEnumLiterals_7011SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEEnumLiterals_7011DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEEnumEnumAnnotations_7012SemanticChildren(View view) {
		EEnum modelElement = (EEnum) view.getElement();
		List semanticChildren = getEEnumEnumAnnotations_7012SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEEnumEnumAnnotations_7012DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPackage_1000SemanticChildren(View view) {
		EPackage modelElement = (EPackage) view.getElement();
		List semanticChildren = getEPackage_1000SemanticChildren(modelElement);
		List result = new LinkedList();
		for (Iterator semanticIterator = semanticChildren.iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			if (isEPackage_1000DomainMetaChild(EcoreVisualIDRegistry.getNodeVisualID(view, nextElement))) {
				result.add(nextElement);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static List getEClassAttributes_7001SemanticChildren(EClass modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getEAttributes());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEClassOperations_7002SemanticChildren(EClass modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getEOperations());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEClassClassAnnotations_7003SemanticChildren(EClass modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getEAnnotations());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEPackageClasses_7004SemanticChildren(EPackage modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getEClassifiers());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEPackagePackages_7005SemanticChildren(EPackage modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getESubpackages());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEPackageDataTypes_7006SemanticChildren(EPackage modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getEClassifiers());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEPackageEnums_7007SemanticChildren(EPackage modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getEClassifiers());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEPackagePackageAnnotations_7008SemanticChildren(EPackage modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getEAnnotations());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEAnnotationDetails_7009SemanticChildren(EAnnotation modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getDetails());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEDataTypeDataTypeAnnotations_7010SemanticChildren(EDataType modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getEAnnotations());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEEnumLiterals_7011SemanticChildren(EEnum modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getELiterals());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEEnumEnumAnnotations_7012SemanticChildren(EEnum modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getEAnnotations());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getEPackage_1000SemanticChildren(EPackage modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getEClassifiers());
		allValues.addAll(modelElement.getESubpackages());
		allValues.addAll(modelElement.getEAnnotations());
		return allValues;
	}

	/**
	 * @generated
	 */
	public static boolean isEClassAttributes_7001DomainMetaChild(int visualID) {
		switch (visualID) {
		case EAttributeEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEClassOperations_7002DomainMetaChild(int visualID) {
		switch (visualID) {
		case EOperationEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEClassClassAnnotations_7003DomainMetaChild(int visualID) {
		switch (visualID) {
		case EAnnotation2EditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEPackageClasses_7004DomainMetaChild(int visualID) {
		switch (visualID) {
		case EClass2EditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEPackagePackages_7005DomainMetaChild(int visualID) {
		switch (visualID) {
		case EPackage3EditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEPackageDataTypes_7006DomainMetaChild(int visualID) {
		switch (visualID) {
		case EDataType2EditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEPackageEnums_7007DomainMetaChild(int visualID) {
		switch (visualID) {
		case EEnum2EditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEPackagePackageAnnotations_7008DomainMetaChild(int visualID) {
		switch (visualID) {
		case EAnnotation2EditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEAnnotationDetails_7009DomainMetaChild(int visualID) {
		switch (visualID) {
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEDataTypeDataTypeAnnotations_7010DomainMetaChild(int visualID) {
		switch (visualID) {
		case EAnnotation2EditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEEnumLiterals_7011DomainMetaChild(int visualID) {
		switch (visualID) {
		case EEnumLiteralEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEEnumEnumAnnotations_7012DomainMetaChild(int visualID) {
		switch (visualID) {
		case EAnnotation2EditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isEPackage_1000DomainMetaChild(int visualID) {
		switch (visualID) {
		case EClassEditPart.VISUAL_ID:
		case EPackage2EditPart.VISUAL_ID:
		case EAnnotationEditPart.VISUAL_ID:
		case EDataTypeEditPart.VISUAL_ID:
		case EEnumEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

}
