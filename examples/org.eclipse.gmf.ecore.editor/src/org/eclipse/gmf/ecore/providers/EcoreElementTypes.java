package org.eclipse.gmf.ecore.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import org.eclipse.gmf.ecore.editor.EcoreDiagramEditorPlugin;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;

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
			return EcoreDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
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
		if (EPackage_79 == type) {
			return EcorePackage.eINSTANCE.getEPackage();
		} else if (EAttribute_2001 == type) {
			return EcorePackage.eINSTANCE.getEAttribute();
		} else if (EOperation_2002 == type) {
			return EcorePackage.eINSTANCE.getEOperation();
		} else if (EAnnotation_2003 == type) {
			return EcorePackage.eINSTANCE.getEAnnotation();
		} else if (EClass_2004 == type) {
			return EcorePackage.eINSTANCE.getEClass();
		} else if (EPackage_2005 == type) {
			return EcorePackage.eINSTANCE.getEPackage();
		} else if (EDataType_2006 == type) {
			return EcorePackage.eINSTANCE.getEDataType();
		} else if (EEnum_2007 == type) {
			return EcorePackage.eINSTANCE.getEEnum();
		} else if (EAnnotation_2008 == type) {
			return EcorePackage.eINSTANCE.getEAnnotation();
		} else if (EStringToStringMapEntry_2009 == type) {
			return EcorePackage.eINSTANCE.getEStringToStringMapEntry();
		} else if (EAnnotation_2010 == type) {
			return EcorePackage.eINSTANCE.getEAnnotation();
		} else if (EEnumLiteral_2011 == type) {
			return EcorePackage.eINSTANCE.getEEnumLiteral();
		} else if (EAnnotation_2012 == type) {
			return EcorePackage.eINSTANCE.getEAnnotation();
		} else if (EClass_1001 == type) {
			return EcorePackage.eINSTANCE.getEClass();
		} else if (EPackage_1002 == type) {
			return EcorePackage.eINSTANCE.getEPackage();
		} else if (EAnnotation_1003 == type) {
			return EcorePackage.eINSTANCE.getEAnnotation();
		} else if (EDataType_1004 == type) {
			return EcorePackage.eINSTANCE.getEDataType();
		} else if (EEnum_1005 == type) {
			return EcorePackage.eINSTANCE.getEEnum();
		} else if (EAnnotationReferences_3001 == type) {
			return EcorePackage.eINSTANCE.getEAnnotation_References();
		} else if (EReference_3002 == type) {
			return EcorePackage.eINSTANCE.getEReference();
		} else if (EReference_3003 == type) {
			return EcorePackage.eINSTANCE.getEReference();
		} else if (EClassESuperTypes_3004 == type) {
			return EcorePackage.eINSTANCE.getEClass_ESuperTypes();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final IMetamodelType EPackage_79 = new MetamodelType("EPackage_79", null, "EPackage", EcorePackage.eINSTANCE.getEPackage(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EAttribute_2001 = new MetamodelType("EAttribute_2001", null, "EAttribute", EcorePackage.eINSTANCE.getEAttribute(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EOperation_2002 = new MetamodelType("EOperation_2002", null, "EOperation", EcorePackage.eINSTANCE.getEOperation(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EAnnotation_2003 = new MetamodelType("EAnnotation_2003", null, "EAnnotation", EcorePackage.eINSTANCE.getEAnnotation(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EClass_2004 = new MetamodelType("EClass_2004", null, "EClass", EcorePackage.eINSTANCE.getEClass(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EPackage_2005 = new MetamodelType("EPackage_2005", null, "EPackage", EcorePackage.eINSTANCE.getEPackage(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EDataType_2006 = new MetamodelType("EDataType_2006", null, "EDataType", EcorePackage.eINSTANCE.getEDataType(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EEnum_2007 = new MetamodelType("EEnum_2007", null, "EEnum", EcorePackage.eINSTANCE.getEEnum(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EAnnotation_2008 = new MetamodelType("EAnnotation_2008", null, "EAnnotation", EcorePackage.eINSTANCE.getEAnnotation(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EStringToStringMapEntry_2009 = new MetamodelType("EStringToStringMapEntry_2009", null, "EStringToStringMapEntry", EcorePackage.eINSTANCE
			.getEStringToStringMapEntry(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EAnnotation_2010 = new MetamodelType("EAnnotation_2010", null, "EAnnotation", EcorePackage.eINSTANCE.getEAnnotation(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EEnumLiteral_2011 = new MetamodelType("EEnumLiteral_2011", null, "EEnumLiteral", EcorePackage.eINSTANCE.getEEnumLiteral(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EAnnotation_2012 = new MetamodelType("EAnnotation_2012", null, "EAnnotation", EcorePackage.eINSTANCE.getEAnnotation(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EClass_1001 = new MetamodelType("EClass_1001", null, "EClass", EcorePackage.eINSTANCE.getEClass(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EPackage_1002 = new MetamodelType("EPackage_1002", null, "EPackage", EcorePackage.eINSTANCE.getEPackage(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EAnnotation_1003 = new MetamodelType("EAnnotation_1003", null, "EAnnotation", EcorePackage.eINSTANCE.getEAnnotation(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EDataType_1004 = new MetamodelType("EDataType_1004", null, "EDataType", EcorePackage.eINSTANCE.getEDataType(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EEnum_1005 = new MetamodelType("EEnum_1005", null, "EEnum", EcorePackage.eINSTANCE.getEEnum(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EAnnotationReferences_3001 = new MetamodelType("EAnnotationReferences_3001", null, "EAnnotationReferences", null, new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EReference_3002 = new MetamodelType("EReference_3002", null, "EReference", EcorePackage.eINSTANCE.getEReference(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EReference_3003 = new MetamodelType("EReference_3003", null, "EReference", EcorePackage.eINSTANCE.getEReference(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType EClassESuperTypes_3004 = new MetamodelType("EClassESuperTypes_3004", null, "EClassESuperTypes", null, new NullEditHelper());

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
		ElementTypeRegistry.getInstance().register(EAnnotation_2008);
		ElementTypeRegistry.getInstance().register(EStringToStringMapEntry_2009);
		ElementTypeRegistry.getInstance().register(EAnnotation_2010);
		ElementTypeRegistry.getInstance().register(EEnumLiteral_2011);
		ElementTypeRegistry.getInstance().register(EAnnotation_2012);
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
}
