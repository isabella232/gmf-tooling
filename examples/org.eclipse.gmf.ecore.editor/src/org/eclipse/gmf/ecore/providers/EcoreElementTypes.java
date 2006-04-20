package org.eclipse.gmf.ecore.providers;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.common.util.BasicEList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.gmf.ecore.expressions.EcoreAbstractExpression;
import org.eclipse.gmf.ecore.expressions.EcoreOCLFactory;

import org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin;

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class EcoreElementTypes {

	/**
	 * @generated
	 */
	private EcoreElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			element = ((EStructuralFeature) element).getEContainingClass();
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return EcoreDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();
			elements.put(EPackage_79, EcorePackage.eINSTANCE.getEPackage());
			elements.put(EAttribute_2001, EcorePackage.eINSTANCE.getEAttribute());
			elements.put(EOperation_2002, EcorePackage.eINSTANCE.getEOperation());
			elements.put(EAnnotation_2003, EcorePackage.eINSTANCE.getEAnnotation());
			elements.put(EClass_2004, EcorePackage.eINSTANCE.getEClass());
			elements.put(EPackage_2005, EcorePackage.eINSTANCE.getEPackage());
			elements.put(EDataType_2006, EcorePackage.eINSTANCE.getEDataType());
			elements.put(EEnum_2007, EcorePackage.eINSTANCE.getEEnum());
			elements.put(EStringToStringMapEntry_2008, EcorePackage.eINSTANCE.getEStringToStringMapEntry());
			elements.put(EEnumLiteral_2009, EcorePackage.eINSTANCE.getEEnumLiteral());
			elements.put(EClass_1001, EcorePackage.eINSTANCE.getEClass());
			elements.put(EPackage_1002, EcorePackage.eINSTANCE.getEPackage());
			elements.put(EAnnotation_1003, EcorePackage.eINSTANCE.getEAnnotation());
			elements.put(EDataType_1004, EcorePackage.eINSTANCE.getEDataType());
			elements.put(EEnum_1005, EcorePackage.eINSTANCE.getEEnum());
			elements.put(EAnnotationReferences_3001, EcorePackage.eINSTANCE.getEAnnotation_References());
			elements.put(EReference_3002, EcorePackage.eINSTANCE.getEReference());
			elements.put(EReference_3003, EcorePackage.eINSTANCE.getEReference());
			elements.put(EClassESuperTypes_3004, EcorePackage.eINSTANCE.getEClass_ESuperTypes());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	public static final IElementType EPackage_79 = getElementType("org.eclipse.gmf.ecore.editor.EPackage_79");

	/**
	 * @generated
	 */
	public static final IElementType EAttribute_2001 = getElementType("org.eclipse.gmf.ecore.editor.EAttribute_2001");

	/**
	 * @generated
	 */
	public static final IElementType EOperation_2002 = getElementType("org.eclipse.gmf.ecore.editor.EOperation_2002");

	/**
	 * @generated
	 */
	public static final IElementType EAnnotation_2003 = getElementType("org.eclipse.gmf.ecore.editor.EAnnotation_2003");

	/**
	 * @generated
	 */
	public static final IElementType EClass_2004 = getElementType("org.eclipse.gmf.ecore.editor.EClass_2004");

	/**
	 * @generated
	 */
	public static final IElementType EPackage_2005 = getElementType("org.eclipse.gmf.ecore.editor.EPackage_2005");

	/**
	 * @generated
	 */
	public static final IElementType EDataType_2006 = getElementType("org.eclipse.gmf.ecore.editor.EDataType_2006");

	/**
	 * @generated
	 */
	public static final IElementType EEnum_2007 = getElementType("org.eclipse.gmf.ecore.editor.EEnum_2007");

	/**
	 * @generated
	 */
	public static final IElementType EStringToStringMapEntry_2008 = getElementType("org.eclipse.gmf.ecore.editor.EStringToStringMapEntry_2008");

	/**
	 * @generated
	 */
	public static final IElementType EEnumLiteral_2009 = getElementType("org.eclipse.gmf.ecore.editor.EEnumLiteral_2009");

	/**
	 * @generated
	 */
	public static final IElementType EClass_1001 = getElementType("org.eclipse.gmf.ecore.editor.EClass_1001");

	/**
	 * @generated
	 */
	public static final IElementType EPackage_1002 = getElementType("org.eclipse.gmf.ecore.editor.EPackage_1002");

	/**
	 * @generated
	 */
	public static final IElementType EAnnotation_1003 = getElementType("org.eclipse.gmf.ecore.editor.EAnnotation_1003");

	/**
	 * @generated
	 */
	public static final IElementType EDataType_1004 = getElementType("org.eclipse.gmf.ecore.editor.EDataType_1004");

	/**
	 * @generated
	 */
	public static final IElementType EEnum_1005 = getElementType("org.eclipse.gmf.ecore.editor.EEnum_1005");

	/**
	 * @generated
	 */
	public static final IElementType EAnnotationReferences_3001 = getElementType("org.eclipse.gmf.ecore.editor.EAnnotationReferences_3001");

	/**
	 * @generated
	 */
	public static final IElementType EReference_3002 = getElementType("org.eclipse.gmf.ecore.editor.EReference_3002");

	/**
	 * @generated
	 */
	public static final IElementType EReference_3003 = getElementType("org.eclipse.gmf.ecore.editor.EReference_3003");

	/**
	 * @generated
	 */
	public static final IElementType EClassESuperTypes_3004 = getElementType("org.eclipse.gmf.ecore.editor.EClassESuperTypes_3004");

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static class Initializers {

		/**
		 * @generated
		 */
		public static final ObjectInitializer EReference_3002 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer(EcoreOCLFactory.getExpression("false", //$NON-NLS-1$
				EcorePackage.eINSTANCE.getEReference()), EcorePackage.eINSTANCE.getEReference_Containment()) });

		/**
		 * @generated
		 */
		public static final ObjectInitializer EReference_3003 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer(EcoreOCLFactory.getExpression("true", //$NON-NLS-1$
				EcorePackage.eINSTANCE.getEReference()), EcorePackage.eINSTANCE.getEReference_Containment()) });

		/** 
		 * @generated
		 */
		private Initializers() {
		}

		/** 
		 * @generated
		 */
		public static class ObjectInitializer {

			/** 
			 * @generated
			 */
			private FeatureInitializer[] initExpressions;

			/** 
			 * @generated
			 */
			ObjectInitializer(FeatureInitializer[] initExpressions) {
				this.initExpressions = initExpressions;
			}

			/** 
			 * @generated
			 */
			public void init(EObject instance) {
				for (int i = 0; i < initExpressions.length; i++) {
					FeatureInitializer nextExpr = initExpressions[i];
					nextExpr.init(instance);
				}
			}
		} // end of ObjectInitializer

		/** 
		 * @generated
		 */
		static class FeatureInitializer {

			/** 
			 * @generated
			 */
			private EClass contextClass;

			/** 
			 * @generated
			 */
			private EStructuralFeature sFeature;

			/** 
			 * @generated
			 */
			private EcoreAbstractExpression expression;

			/**
			 * @generated
			 */
			FeatureInitializer(EcoreAbstractExpression expression, EStructuralFeature sFeature) {
				this.sFeature = sFeature;
				this.expression = expression;
			}

			/** 
			 * @generated
			 */
			void init(EObject contextInstance) {
				Object value = expression.evaluate(contextInstance);
				if (sFeature.getEType() instanceof EEnum && value instanceof EEnumLiteral) {
					value = ((EEnumLiteral) value).getInstance();
				} else if (value != null && sFeature.isMany()) {
					value = new BasicEList((Collection) value);
				}
				contextInstance.eSet(sFeature, value);
			}
		} // end of FeatureInitializer
	} // end of Initializers
}
