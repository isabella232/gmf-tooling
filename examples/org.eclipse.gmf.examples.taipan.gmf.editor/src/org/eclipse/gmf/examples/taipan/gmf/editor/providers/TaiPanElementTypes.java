/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.providers;

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
import org.eclipse.gmf.examples.taipan.TaiPanPackage;
import org.eclipse.gmf.examples.taipan.gmf.editor.expressions.TaiPanAbstractExpression;
import org.eclipse.gmf.examples.taipan.gmf.editor.expressions.TaiPanOCLFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanDiagramEditorPlugin;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class TaiPanElementTypes {

	/**
	 * @generated
	 */
	private TaiPanElementTypes() {
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
				return TaiPanDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
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
			elements.put(Aquatory_79, TaiPanPackage.eINSTANCE.getAquatory());
			elements.put(Item_2001, TaiPanPackage.eINSTANCE.getItem());
			elements.put(Port_1001, TaiPanPackage.eINSTANCE.getPort());
			elements.put(Ship_1002, TaiPanPackage.eINSTANCE.getShip());
			elements.put(ShipDestination_3001, TaiPanPackage.eINSTANCE.getShip_Destination());
			elements.put(Route_3002, TaiPanPackage.eINSTANCE.getRoute());
			elements.put(Route_3003, TaiPanPackage.eINSTANCE.getRoute());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	public static final IElementType Aquatory_79 = getElementType("org.eclipse.gmf.examples.taipan.gmf.editor.Aquatory_79");

	/**
	 * @generated
	 */
	public static final IElementType Item_2001 = getElementType("org.eclipse.gmf.examples.taipan.gmf.editor.Item_2001");

	/**
	 * @generated
	 */
	public static final IElementType Port_1001 = getElementType("org.eclipse.gmf.examples.taipan.gmf.editor.Port_1001");

	/**
	 * @generated
	 */
	public static final IElementType Ship_1002 = getElementType("org.eclipse.gmf.examples.taipan.gmf.editor.Ship_1002");

	/**
	 * @generated
	 */
	public static final IElementType ShipDestination_3001 = getElementType("org.eclipse.gmf.examples.taipan.gmf.editor.ShipDestination_3001");

	/**
	 * @generated
	 */
	public static final IElementType Route_3002 = getElementType("org.eclipse.gmf.examples.taipan.gmf.editor.Route_3002");

	/**
	 * @generated
	 */
	public static final IElementType Route_3003 = getElementType("org.eclipse.gmf.examples.taipan.gmf.editor.Route_3003");

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
		public static final ObjectInitializer Route_3002 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer(TaiPanOCLFactory.getExpression("0.8", //$NON-NLS-1$
				TaiPanPackage.eINSTANCE.getRoute()), TaiPanPackage.eINSTANCE.getRoute_Reliability()) });

		/**
		 * @generated
		 */
		public static final ObjectInitializer Route_3003 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer(TaiPanOCLFactory.getExpression("0.2", //$NON-NLS-1$
				TaiPanPackage.eINSTANCE.getRoute()), TaiPanPackage.eINSTANCE.getRoute_Reliability()) });

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
			private EStructuralFeature sFeature;

			/** 
			 * @generated
			 */
			private TaiPanAbstractExpression expression;

			/**
			 * @generated
			 */
			FeatureInitializer(TaiPanAbstractExpression expression, EStructuralFeature sFeature) {
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
