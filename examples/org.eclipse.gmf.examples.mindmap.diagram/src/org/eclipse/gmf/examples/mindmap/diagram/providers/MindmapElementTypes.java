/*******************************************************************************
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.gmf.examples.mindmap.diagram.providers;

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
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.diagram.expressions.MindmapAbstractExpression;
import org.eclipse.gmf.examples.mindmap.diagram.expressions.MindmapOCLFactory;
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class MindmapElementTypes {

	/**
	 * @generated
	 */
	private MindmapElementTypes() {
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
				return MindmapDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
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
			elements.put(Map_79, MindmapPackage.eINSTANCE.getMap());
			elements.put(Thread_2001, MindmapPackage.eINSTANCE.getThread());
			elements.put(ThreadItem_2002, MindmapPackage.eINSTANCE.getThreadItem());
			elements.put(Topic_1001, MindmapPackage.eINSTANCE.getTopic());
			elements.put(Resource_1002, MindmapPackage.eINSTANCE.getResource());
			elements.put(TopicSubtopics_3001, MindmapPackage.eINSTANCE.getTopic_Subtopics());
			elements.put(Relationship_3002, MindmapPackage.eINSTANCE.getRelationship());
			elements.put(Relationship_3003, MindmapPackage.eINSTANCE.getRelationship());
			elements.put(Relationship_3004, MindmapPackage.eINSTANCE.getRelationship());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	public static final IElementType Map_79 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Map_79");

	/**
	 * @generated
	 */
	public static final IElementType Thread_2001 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Thread_2001");

	/**
	 * @generated
	 */
	public static final IElementType ThreadItem_2002 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.ThreadItem_2002");

	/**
	 * @generated
	 */
	public static final IElementType Topic_1001 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Topic_1001");

	/**
	 * @generated
	 */
	public static final IElementType Resource_1002 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Resource_1002");

	/**
	 * @generated
	 */
	public static final IElementType TopicSubtopics_3001 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.TopicSubtopics_3001");

	/**
	 * @generated
	 */
	public static final IElementType Relationship_3002 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Relationship_3002");

	/**
	 * @generated
	 */
	public static final IElementType Relationship_3003 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Relationship_3003");

	/**
	 * @generated
	 */
	public static final IElementType Relationship_3004 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Relationship_3004");

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
		public static final ObjectInitializer Relationship_3002 = new ObjectInitializer(new FeatureInitializer[] {
				new FeatureInitializer(MindmapOCLFactory.getExpression("RelationshipType::DEPENDENCY", //$NON-NLS-1$
						MindmapPackage.eINSTANCE.getRelationship()), MindmapPackage.eINSTANCE.getRelationship_Type()), new FeatureInitializer(MindmapOCLFactory.getExpression("'depends'", //$NON-NLS-1$
						MindmapPackage.eINSTANCE.getRelationship()), MindmapPackage.eINSTANCE.getRelationship_Label()) });

		/**
		 * @generated
		 */
		public static final ObjectInitializer Relationship_3003 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer(MindmapOCLFactory.getExpression("RelationshipType::INCLUDES", //$NON-NLS-1$
				MindmapPackage.eINSTANCE.getRelationship()), MindmapPackage.eINSTANCE.getRelationship_Type()), new FeatureInitializer(MindmapOCLFactory.getExpression("'includes'", //$NON-NLS-1$
				MindmapPackage.eINSTANCE.getRelationship()), MindmapPackage.eINSTANCE.getRelationship_Label()) });

		/**
		 * @generated
		 */
		public static final ObjectInitializer Relationship_3004 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer(MindmapOCLFactory.getExpression("RelationshipType::EXTENDS", //$NON-NLS-1$
				MindmapPackage.eINSTANCE.getRelationship()), MindmapPackage.eINSTANCE.getRelationship_Type()), new FeatureInitializer(MindmapOCLFactory.getExpression("'extends'", //$NON-NLS-1$
				MindmapPackage.eINSTANCE.getRelationship()), MindmapPackage.eINSTANCE.getRelationship_Label()) });

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
			private MindmapAbstractExpression expression;

			/**
			 * @generated
			 */
			FeatureInitializer(MindmapAbstractExpression expression, EStructuralFeature sFeature) {
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
