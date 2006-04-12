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

import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
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

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.DestinationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.RouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanDiagramEditorPlugin;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;

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
	public static final IMetamodelType Aquatory_79 = new MetamodelType("Aquatory_79", null, "Aquatory", TaiPanPackage.eINSTANCE.getAquatory(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType Item_2001 = new HintedMetamodelType("Item_2001", "Item", TaiPanPackage.eINSTANCE.getItem(), ItemEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType Port_1001 = new HintedMetamodelType("Port_1001", "Port", TaiPanPackage.eINSTANCE.getPort(), PortEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType Ship_1002 = new HintedMetamodelType("Ship_1002", "Ship", TaiPanPackage.eINSTANCE.getShip(), ShipEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType ShipDestination_3001 = new HintedMetamodelType("ShipDestination_3001", "ShipDestination", DestinationEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType Route_3002 = new HintedMetamodelType("Route_3002", "Route", TaiPanPackage.eINSTANCE.getRoute(), RouteEditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static final IMetamodelType Route_3003 = new HintedMetamodelType("Route_3003", "Route", TaiPanPackage.eINSTANCE.getRoute(), Route2EditPart.VISUAL_ID);

	/**
	 * @generated
	 */
	public static void register() {
		ElementTypeRegistry.getInstance().register(Aquatory_79);
		ElementTypeRegistry.getInstance().register(Item_2001);
		ElementTypeRegistry.getInstance().register(Port_1001);
		ElementTypeRegistry.getInstance().register(Ship_1002);
		ElementTypeRegistry.getInstance().register(ShipDestination_3001);
		ElementTypeRegistry.getInstance().register(Route_3002);
		ElementTypeRegistry.getInstance().register(Route_3003);
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
				TaiPanDiagramEditorPlugin.getInstance().logError("unserved request " + req);
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
		public static final ObjectInitializer Route_3002 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer("0.8", //$NON-NLS-1$
				TaiPanPackage.eINSTANCE.getRoute(), TaiPanPackage.eINSTANCE.getRoute_Reliability())

		});

		/**
		 * @generated
		 */
		public static final ObjectInitializer Route_3003 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer("0.2", //$NON-NLS-1$
				TaiPanPackage.eINSTANCE.getRoute(), TaiPanPackage.eINSTANCE.getRoute_Reliability())

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
