package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.expressions.MindmapAbstractExpression;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.expressions.MindmapOCLFactory;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapDiagramEditorPlugin;

/**
 * @generated
 */
public class DomainElementInitializer {
	/**
	 * @generated
	 */
	public static interface IElementInitializer {
		/**
		 * @generated
		 */
		public void initializeElement(EObject instance);
	}

	/**
	 * @generated
	 */
	private static IElementInitializer NULL_INITIALIZER = new IElementInitializer() {
		public void initializeElement(EObject instance) {
		}
	};

	/**
	 * @generated
	 */
	public static IElementInitializer Topic_2001 = NULL_INITIALIZER;
	/**
	 * @generated
	 */
	public static IElementInitializer Resource_2002 = NULL_INITIALIZER;
	/**
	 * @generated
	 */
	public static IElementInitializer Thread_3001 = NULL_INITIALIZER;
	/**
	 * @generated
	 */
	public static IElementInitializer ThreadItem_3002 = NULL_INITIALIZER;
	/**
	 * @generated
	 */
	public static final IElementInitializer Relationship_4002 = new ObjectInitializer(
			MindmapPackage.eINSTANCE.getRelationship()) {
		protected void init() {
			add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
					.getRelationship_Type(), MindmapOCLFactory.getExpression(
					"RelationshipType::EXTENDS", //$NON-NLS-1$
					MindmapPackage.eINSTANCE.getRelationship())));
			add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
					.getRelationship_Label(), MindmapOCLFactory.getExpression(
					"\'extends\'", //$NON-NLS-1$
					MindmapPackage.eINSTANCE.getRelationship())));
		}
	}; // Relationship_4002 ObjectInitializer
	/**
	 * @generated
	 */
	public static final IElementInitializer Relationship_4003 = new ObjectInitializer(
			MindmapPackage.eINSTANCE.getRelationship()) {
		protected void init() {
			add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
					.getRelationship_Type(), MindmapOCLFactory.getExpression(
					"RelationshipType::INCLUDES", //$NON-NLS-1$
					MindmapPackage.eINSTANCE.getRelationship())));
			add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
					.getRelationship_Label(), MindmapOCLFactory.getExpression(
					"\'includes\'", //$NON-NLS-1$
					MindmapPackage.eINSTANCE.getRelationship())));
		}
	}; // Relationship_4003 ObjectInitializer
	/**
	 * @generated
	 */
	public static final IElementInitializer Relationship_4004 = new ObjectInitializer(
			MindmapPackage.eINSTANCE.getRelationship()) {
		protected void init() {
			add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
					.getRelationship_Type(), MindmapOCLFactory.getExpression(
					"RelationshipType::DEPENDENCY", //$NON-NLS-1$
					MindmapPackage.eINSTANCE.getRelationship())));
			add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
					.getRelationship_Label(), MindmapOCLFactory.getExpression(
					"\'depends\'", //$NON-NLS-1$
					MindmapPackage.eINSTANCE.getRelationship())));
		}
	}; // Relationship_4004 ObjectInitializer

	/** 
	 * @generated
	 */
	public static abstract class ObjectInitializer implements
			IElementInitializer {
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
		protected final FeatureInitializer add(FeatureInitializer initializer) {
			featureInitializers.add(initializer);
			return initializer;
		}

		/** 
		 * @generated
		 */
		public void initializeElement(EObject instance) {
			for (Iterator it = featureInitializers.iterator(); it.hasNext();) {
				FeatureInitializer nextExpr = (FeatureInitializer) it.next();
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
	interface FeatureInitializer {
		/**
		 * @generated
		 */
		void init(EObject contextInstance);
	}

	/**
	 * @generated
	 */
	static FeatureInitializer createNewElementFeatureInitializer(
			EStructuralFeature initFeature,
			ObjectInitializer[] newObjectInitializers) {
		final EStructuralFeature feature = initFeature;
		final ObjectInitializer[] initializers = newObjectInitializers;
		return new FeatureInitializer() {
			public void init(EObject contextInstance) {
				for (int i = 0; i < initializers.length; i++) {
					EObject newInstance = initializers[i].element.getEPackage()
							.getEFactoryInstance().create(
									initializers[i].element);
					if (feature.isMany()) {
						((Collection) contextInstance.eGet(feature))
								.add(newInstance);
					} else {
						contextInstance.eSet(feature, newInstance);
					}
					initializers[i].initializeElement(newInstance);
				}
			}
		};
	}

	/**
	 * @generated
	 */
	static FeatureInitializer createExpressionFeatureInitializer(
			EStructuralFeature initFeature,
			MindmapAbstractExpression valueExpression) {
		final EStructuralFeature feature = initFeature;
		final MindmapAbstractExpression expression = valueExpression;
		return new FeatureInitializer() {
			public void init(EObject contextInstance) {
				expression.assignTo(feature, contextInstance);
			}
		};
	}

	/**
	 * @generated
	 */
	public static class LinkConstraints {
		/**
		 * @generated 
		 */
		public static final LinkConstraints TopicSubtopics_4001 = createTopicSubtopics_4001();

		/**
		 * @generated 
		 */
		private static LinkConstraints createTopicSubtopics_4001() {
			Map sourceEnv = new HashMap(3);
			sourceEnv.put("oppositeEnd", MindmapPackage.eINSTANCE.getTopic()); //$NON-NLS-1$
			MindmapAbstractExpression sourceExpression = MindmapOCLFactory
					.getExpression("self <> oppositeEnd", //$NON-NLS-1$
							MindmapPackage.eINSTANCE.getTopic(), sourceEnv);
			MindmapAbstractExpression targetExpression = null;
			return new LinkConstraints(sourceExpression, targetExpression);
		}

		/**
		 * @generated 
		 */
		private static final String OPPOSITE_END_VAR = "oppositeEnd"; //$NON-NLS-1$
		/**
		 * @generated 
		 */
		private MindmapAbstractExpression srcEndInv;
		/**
		 * @generated 
		 */
		private MindmapAbstractExpression targetEndInv;

		/**
		 * @generated 
		 */
		public LinkConstraints(MindmapAbstractExpression sourceEnd,
				MindmapAbstractExpression targetEnd) {
			this.srcEndInv = sourceEnd;
			this.targetEndInv = targetEnd;
		}

		/**
		 * @generated 
		 */
		public boolean canCreateLink(Object source, Object target,
				boolean isBackDirected) {
			if (source != null) {
				MindmapAbstractExpression sourceConstraint = isBackDirected ? targetEndInv
						: srcEndInv;
				if (sourceConstraint != null
						&& !evaluate(sourceConstraint, source, target, false)) {
					return false;
				}
			}
			if (target != null) {
				MindmapAbstractExpression targetConstraint = isBackDirected ? srcEndInv
						: targetEndInv;
				if (targetConstraint != null
						&& !evaluate(targetConstraint, target, source, true)) {
					return false;
				}
			}
			return true;
		}

		/**
		 * @generated 
		 */
		private static boolean evaluate(MindmapAbstractExpression constraint,
				Object sourceEnd, Object oppositeEnd, boolean clearEnv) {
			Map evalEnv = Collections.singletonMap(OPPOSITE_END_VAR,
					oppositeEnd);
			try {
				Object val = constraint.evaluate(sourceEnd, evalEnv);
				return (val instanceof Boolean) ? ((Boolean) val)
						.booleanValue() : false;
			} catch (Exception e) {
				MindmapDiagramEditorPlugin.getInstance().logError(
						"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}
	}
}
