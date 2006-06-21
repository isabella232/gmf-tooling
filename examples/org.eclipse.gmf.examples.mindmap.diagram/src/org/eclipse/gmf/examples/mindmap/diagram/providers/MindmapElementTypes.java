package org.eclipse.gmf.examples.mindmap.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.examples.mindmap.diagram.expressions.MindmapAbstractExpression;
import org.eclipse.gmf.examples.mindmap.diagram.expressions.MindmapOCLFactory;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapDiagramEditorPlugin;

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
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			element = ((EStructuralFeature) element).getEContainingClass();
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return MindmapDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
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
			elements.put(ThreadItem_2002, MindmapPackage.eINSTANCE
					.getThreadItem());
			elements.put(Topic_1001, MindmapPackage.eINSTANCE.getTopic());
			elements.put(Resource_1002, MindmapPackage.eINSTANCE.getResource());
			elements.put(TopicSubtopics_3001, MindmapPackage.eINSTANCE
					.getTopic_Subtopics());
			elements.put(Relationship_3002, MindmapPackage.eINSTANCE
					.getRelationship());
			elements.put(Relationship_3003, MindmapPackage.eINSTANCE
					.getRelationship());
			elements.put(Relationship_3004, MindmapPackage.eINSTANCE
					.getRelationship());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	public static final IElementType Map_79 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Map_79"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Thread_2001 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Thread_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ThreadItem_2002 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.ThreadItem_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Topic_1001 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Topic_1001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Resource_1002 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Resource_1002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TopicSubtopics_3001 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.TopicSubtopics_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Relationship_3002 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Relationship_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Relationship_3003 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Relationship_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Relationship_3004 = getElementType("org.eclipse.gmf.examples.mindmap.diagram.Relationship_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Map_79);
			KNOWN_ELEMENT_TYPES.add(Thread_2001);
			KNOWN_ELEMENT_TYPES.add(ThreadItem_2002);
			KNOWN_ELEMENT_TYPES.add(Topic_1001);
			KNOWN_ELEMENT_TYPES.add(Resource_1002);
			KNOWN_ELEMENT_TYPES.add(TopicSubtopics_3001);
			KNOWN_ELEMENT_TYPES.add(Relationship_3002);
			KNOWN_ELEMENT_TYPES.add(Relationship_3003);
			KNOWN_ELEMENT_TYPES.add(Relationship_3004);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static class Initializers {

		/**
		 * @generated
		 */
		public static final ObjectInitializer Relationship_3002 = new ObjectInitializer(
				new FeatureInitializer[] {
						new FeatureInitializer(MindmapOCLFactory.getExpression(
								"RelationshipType::EXTENDS", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship()),
								MindmapPackage.eINSTANCE.getRelationship_Type()),
						new FeatureInitializer(MindmapOCLFactory.getExpression(
								"\'extends\'", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship()),
								MindmapPackage.eINSTANCE
										.getRelationship_Label()) });

		/**
		 * @generated
		 */
		public static final ObjectInitializer Relationship_3003 = new ObjectInitializer(
				new FeatureInitializer[] {
						new FeatureInitializer(MindmapOCLFactory.getExpression(
								"RelationshipType::DEPENDENCY", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship()),
								MindmapPackage.eINSTANCE.getRelationship_Type()),
						new FeatureInitializer(MindmapOCLFactory.getExpression(
								"\'depends\'", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship()),
								MindmapPackage.eINSTANCE
										.getRelationship_Label()) });

		/**
		 * @generated
		 */
		public static final ObjectInitializer Relationship_3004 = new ObjectInitializer(
				new FeatureInitializer[] {
						new FeatureInitializer(MindmapOCLFactory.getExpression(
								"RelationshipType::INCLUDES", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship()),
								MindmapPackage.eINSTANCE.getRelationship_Type()),
						new FeatureInitializer(MindmapOCLFactory.getExpression(
								"\'includes\'", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship()),
								MindmapPackage.eINSTANCE
										.getRelationship_Label()) });

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
					try {
						nextExpr.init(instance);
					} catch (RuntimeException e) {
						MindmapDiagramEditorPlugin.getInstance().logError(
								"Feature initialization failed", e); //$NON-NLS-1$						
					}
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
			FeatureInitializer(MindmapAbstractExpression expression,
					EStructuralFeature sFeature) {
				this.sFeature = sFeature;
				this.expression = expression;
			}

			/** 
			 * @generated
			 */
			void init(EObject contextInstance) {
				expression.assignTo(sFeature, contextInstance);
			}
		} // end of FeatureInitializer
	} // end of Initializers
}
