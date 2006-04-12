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

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;
import org.eclipse.gmf.ecore.edit.parts.ESuperTypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.ReferencesEditPart;

import org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin;

import org.eclipse.gmf.runtime.common.core.command.ICommand;

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;

import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

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
	public static final IMetamodelType EPackage_79 = new MetamodelType("EPackage_79", null, "EPackage", EcorePackage.eINSTANCE.getEPackage(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EAttribute_2001 = new HintedMetamodelType("EAttribute_2001", "EAttribute", EcorePackage.eINSTANCE.getEAttribute(), EAttributeEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EOperation_2002 = new HintedMetamodelType("EOperation_2002", "EOperation", EcorePackage.eINSTANCE.getEOperation(), EOperationEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EAnnotation_2003 = new HintedMetamodelType("EAnnotation_2003", "EAnnotation", EcorePackage.eINSTANCE.getEAnnotation(), EAnnotationEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EClass_2004 = new HintedMetamodelType("EClass_2004", "EClass", EcorePackage.eINSTANCE.getEClass(), EClass2EditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EPackage_2005 = new HintedMetamodelType("EPackage_2005", "EPackage", EcorePackage.eINSTANCE.getEPackage(), EPackage3EditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EDataType_2006 = new HintedMetamodelType("EDataType_2006", "EDataType", EcorePackage.eINSTANCE.getEDataType(), EDataTypeEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EEnum_2007 = new HintedMetamodelType("EEnum_2007", "EEnum", EcorePackage.eINSTANCE.getEEnum(), EEnumEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EStringToStringMapEntry_2008 = new HintedMetamodelType("EStringToStringMapEntry_2008", "EStringToStringMapEntry", EcorePackage.eINSTANCE
			.getEStringToStringMapEntry(), EStringToStringMapEntryEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EEnumLiteral_2009 = new HintedMetamodelType("EEnumLiteral_2009", "EEnumLiteral", EcorePackage.eINSTANCE.getEEnumLiteral(), EEnumLiteralEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EClass_1001 = new HintedMetamodelType("EClass_1001", "EClass", EcorePackage.eINSTANCE.getEClass(), EClassEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EPackage_1002 = new HintedMetamodelType("EPackage_1002", "EPackage", EcorePackage.eINSTANCE.getEPackage(), EPackage2EditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EAnnotation_1003 = new HintedMetamodelType("EAnnotation_1003", "EAnnotation", EcorePackage.eINSTANCE.getEAnnotation(), EAnnotation2EditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EDataType_1004 = new HintedMetamodelType("EDataType_1004", "EDataType", EcorePackage.eINSTANCE.getEDataType(), EDataType2EditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EEnum_1005 = new HintedMetamodelType("EEnum_1005", "EEnum", EcorePackage.eINSTANCE.getEEnum(), EEnum2EditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EAnnotationReferences_3001 = new HintedMetamodelType("EAnnotationReferences_3001", "EAnnotationReferences", ReferencesEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EReference_3002 = new HintedMetamodelType("EReference_3002", "EReference", EcorePackage.eINSTANCE.getEReference(), EReferenceEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EReference_3003 = new HintedMetamodelType("EReference_3003", "EReference", EcorePackage.eINSTANCE.getEReference(), EReference2EditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType EClassESuperTypes_3004 = new HintedMetamodelType("EClassESuperTypes_3004", "EClassESuperTypes", ESuperTypesEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static void register() {
		ElementTypeRegistry.getInstance().register(EPackage_79);
		ElementTypeRegistry.getInstance().register(EAttribute_2001);
		ElementTypeRegistry.getInstance().register(EOperation_2002);
		ElementTypeRegistry.getInstance().register(EAnnotation_2003);
		ElementTypeRegistry.getInstance().register(EClass_2004);
		ElementTypeRegistry.getInstance().register(EPackage_2005);
		ElementTypeRegistry.getInstance().register(EDataType_2006);
		ElementTypeRegistry.getInstance().register(EEnum_2007);
		ElementTypeRegistry.getInstance().register(EStringToStringMapEntry_2008);
		ElementTypeRegistry.getInstance().register(EEnumLiteral_2009);
		ElementTypeRegistry.getInstance().register(EClass_1001);
		ElementTypeRegistry.getInstance().register(EPackage_1002);
		ElementTypeRegistry.getInstance().register(EAnnotation_1003);
		ElementTypeRegistry.getInstance().register(EDataType_1004);
		ElementTypeRegistry.getInstance().register(EEnum_1005);
		ElementTypeRegistry.getInstance().register(EAnnotationReferences_3001);
		ElementTypeRegistry.getInstance().register(EReference_3002);
		ElementTypeRegistry.getInstance().register(EReference_3003);
		ElementTypeRegistry.getInstance().register(EClassESuperTypes_3004);
	}

	/**
	 * @generated
	 */
	public static class NullEditHelper extends AbstractEditHelper {

		/**
		 * @generated
		 */
		public ICommand getEditCommand(IEditCommandRequest req) {
			if (!(req instanceof ConfigureRequest)) {
				EcoreDiagramEditorPlugin.getInstance().logError("unserved request " + req);
			}
			return null;
		}
	}

	/**
	 * @generated
	 */
	public static class Initializers {

		/**
		 * @generated
		 */
		public static final ObjectInitializer EReference_3002 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer("false", //$NON-NLS-1$
				EcorePackage.eINSTANCE.getEReference(), EcorePackage.eINSTANCE.getEReference_Containment())

		});

		/**
		 * @generated
		 */
		public static final ObjectInitializer EReference_3003 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer("true", //$NON-NLS-1$
				EcorePackage.eINSTANCE.getEReference(), EcorePackage.eINSTANCE.getEReference_Containment())

		});

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
			private String expressionBody;

			/** 
			 * @generated
			 */
			private Query query;

			/**
			 * @generated
			 */
			FeatureInitializer(String expression, EClass context, EStructuralFeature sFeature) {
				this.sFeature = sFeature;
				this.expressionBody = expression;
				this.contextClass = context;
			}

			/** 
			 * @generated
			 */
			void init(EObject contextInstance) {
				if (this.query == null) {
					this.query = QueryFactory.eINSTANCE.createQuery(expressionBody, contextClass);
				}
				Object value = query.evaluate(contextInstance);
				if (sFeature.getEType() instanceof EEnum && value instanceof EEnumLiteral) {
					value = ((EEnumLiteral) value).getInstance();
				} else if (value != null && sFeature.isMany()) {
					value = new BasicEList((Collection) value);
				}
				contextInstance.eSet(sFeature, value);
			}
		} // end of FeatureInitializer

	} // end of Initializers

	/** 
	 * @generated
	 */
	private static class HintedMetamodelType extends MetamodelType implements IHintedType {

		/** 
		 * @generated
		 */
		private String mySemanticHint;

		/** 
		 * @generated
		 */
		public HintedMetamodelType(String id, String displayName, EClass eClass, String semanticHint) {
			super(id, null, displayName, eClass, new NullEditHelper());
			mySemanticHint = semanticHint;
		}

		/** 
		 * @generated
		 */
		public HintedMetamodelType(String id, String displayName, String semanticHint) {
			this(id, displayName, null, semanticHint);
		}

		/** 
		 * @generated
		 */
		public String getSemanticHint() {
			return mySemanticHint;
		}
	}
}
