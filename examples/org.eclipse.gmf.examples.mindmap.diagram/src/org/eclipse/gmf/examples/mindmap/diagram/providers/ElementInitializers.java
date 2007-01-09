package org.eclipse.gmf.examples.mindmap.diagram.providers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.examples.mindmap.diagram.expressions.MindmapAbstractExpression;
import org.eclipse.gmf.examples.mindmap.diagram.expressions.MindmapOCLFactory;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static class Initializers {
		/**
		 * @generated
		 */
		public static final IObjectInitializer Relationship_3002 = new ObjectInitializer(
				MindmapPackage.eINSTANCE.getRelationship()) {
			protected void init() {
				add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
						.getRelationship_Type(), MindmapOCLFactory
						.getExpression("RelationshipType::EXTENDS", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship())));
				add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
						.getRelationship_Label(), MindmapOCLFactory
						.getExpression("\'extends\'", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship())));
			}
		}; // Relationship_3002 ObjectInitializer		
		/**
		 * @generated
		 */
		public static final IObjectInitializer Relationship_3003 = new ObjectInitializer(
				MindmapPackage.eINSTANCE.getRelationship()) {
			protected void init() {
				add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
						.getRelationship_Type(), MindmapOCLFactory
						.getExpression("RelationshipType::INCLUDES", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship())));
				add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
						.getRelationship_Label(), MindmapOCLFactory
						.getExpression("\'includes\'", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship())));
			}
		}; // Relationship_3003 ObjectInitializer		
		/**
		 * @generated
		 */
		public static final IObjectInitializer Relationship_3004 = new ObjectInitializer(
				MindmapPackage.eINSTANCE.getRelationship()) {
			protected void init() {
				add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
						.getRelationship_Type(), MindmapOCLFactory
						.getExpression("RelationshipType::DEPENDENCY", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship())));
				add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
						.getRelationship_Label(), MindmapOCLFactory
						.getExpression("\'depends\'", //$NON-NLS-1$
								MindmapPackage.eINSTANCE.getRelationship())));
			}
		}; // Relationship_3004 ObjectInitializer

		/** 
		 * @generated
		 */
		private Initializers() {
		}

		/** 
		 * @generated
		 */
		public static interface IObjectInitializer {
			/** 
			 * @generated
			 */
			public void init(EObject instance);
		}

		/** 
		 * @generated
		 */
		public static abstract class ObjectInitializer implements
				IObjectInitializer {
			/** 
			 * @generated
			 */
			final EClass element;
			/** 
			 * @generated
			 */
			private List featureInitializers = new ArrayList();

			/** 
			 * @generated
			 */
			ObjectInitializer(EClass element) {
				this.element = element;
				init();
			}

			/**
			 * @generated
			 */
			protected abstract void init();

			/** 
			 * @generated
			 */
			protected final IFeatureInitializer add(
					IFeatureInitializer initializer) {
				featureInitializers.add(initializer);
				return initializer;
			}

			/** 
			 * @generated
			 */
			public void init(EObject instance) {
				for (Iterator it = featureInitializers.iterator(); it.hasNext();) {
					IFeatureInitializer nextExpr = (IFeatureInitializer) it
							.next();
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
		interface IFeatureInitializer {
			/**
			 * @generated
			 */
			void init(EObject contextInstance);
		}

		/**
		 * @generated
		 */
		static IFeatureInitializer createNewElementFeatureInitializer(
				EStructuralFeature initFeature,
				ObjectInitializer[] newObjectInitializers) {
			final EStructuralFeature feature = initFeature;
			final ObjectInitializer[] initializers = newObjectInitializers;
			return new IFeatureInitializer() {
				public void init(EObject contextInstance) {
					for (int i = 0; i < initializers.length; i++) {
						EObject newInstance = initializers[i].element
								.getEPackage().getEFactoryInstance().create(
										initializers[i].element);
						if (feature.isMany()) {
							((Collection) contextInstance.eGet(feature))
									.add(newInstance);
						} else {
							contextInstance.eSet(feature, newInstance);
						}
						initializers[i].init(newInstance);
					}
				}
			};
		}

		/**
		 * @generated
		 */
		static IFeatureInitializer createExpressionFeatureInitializer(
				EStructuralFeature initFeature,
				MindmapAbstractExpression valueExpression) {
			final EStructuralFeature feature = initFeature;
			final MindmapAbstractExpression expression = valueExpression;
			return new IFeatureInitializer() {
				public void init(EObject contextInstance) {
					expression.assignTo(feature, contextInstance);
				}
			};
		}
	} // end of Initializers
}
