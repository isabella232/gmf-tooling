/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.mindmap.rcp.view.factories;

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
import org.eclipse.gmf.examples.mindmap.rcp.expressions.MindmapAbstractExpression;
import org.eclipse.gmf.examples.mindmap.rcp.expressions.MindmapOCLFactory;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapDiagramEditorPlugin;

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
			add(createExpressionFeatureInitializer(
					MindmapPackage.eINSTANCE.getRelationship_Type(),
					MindmapOCLFactory
							.getExpression(
									"RelationshipType::EXTENDS", MindmapPackage.eINSTANCE.getRelationship())));//$NON-NLS-1$
			add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
					.getRelationship_Label(), MindmapOCLFactory.getExpression(
					"\'extends\'", MindmapPackage.eINSTANCE.getRelationship())));//$NON-NLS-1$
		}
	}; // Relationship_4002 ObjectInitializer
	/**
	 * @generated
	 */
	public static final IElementInitializer Relationship_4003 = new ObjectInitializer(
			MindmapPackage.eINSTANCE.getRelationship()) {
		protected void init() {
			add(createExpressionFeatureInitializer(
					MindmapPackage.eINSTANCE.getRelationship_Type(),
					MindmapOCLFactory
							.getExpression(
									"RelationshipType::INCLUDES", MindmapPackage.eINSTANCE.getRelationship())));//$NON-NLS-1$
			add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
					.getRelationship_Label(), MindmapOCLFactory.getExpression(
					"\'includes\'", MindmapPackage.eINSTANCE.getRelationship())));//$NON-NLS-1$
		}
	}; // Relationship_4003 ObjectInitializer
	/**
	 * @generated
	 */
	public static final IElementInitializer Relationship_4004 = new ObjectInitializer(
			MindmapPackage.eINSTANCE.getRelationship()) {
		protected void init() {
			add(createExpressionFeatureInitializer(
					MindmapPackage.eINSTANCE.getRelationship_Type(),
					MindmapOCLFactory
							.getExpression(
									"RelationshipType::DEPENDENCY", MindmapPackage.eINSTANCE.getRelationship())));//$NON-NLS-1$
			add(createExpressionFeatureInitializer(MindmapPackage.eINSTANCE
					.getRelationship_Label(), MindmapOCLFactory.getExpression(
					"\'depends\'", MindmapPackage.eINSTANCE.getRelationship())));//$NON-NLS-1$
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
		public void init(EObject contextInstance);
	}

	/**
	 * @generated
	 */
	static FeatureInitializer createNewElementFeatureInitializer(
			EStructuralFeature initFeature,
			ObjectInitializer[] newObjectInitializers) {
		return new NewElementFeatureInitializer(initFeature,
				newObjectInitializers);
	}

	/**
	 * @generated
	 */
	private static class NewElementFeatureInitializer implements
			FeatureInitializer {
		/**
		 * @generated
		 */
		private final EStructuralFeature myFeature;
		/**
		 * @generated
		 */
		private final ObjectInitializer[] myInitializers;

		/**
		 * @generated
		 */
		public NewElementFeatureInitializer(EStructuralFeature initFeature,
				ObjectInitializer[] newObjectInitializers) {
			myFeature = initFeature;
			myInitializers = newObjectInitializers;
		}

		/**
		 * @generated
		 */
		public void init(EObject contextInstance) {
			for (int i = 0; i < myInitializers.length; i++) {
				EObject newInstance = myInitializers[i].element.getEPackage()
						.getEFactoryInstance()
						.create(myInitializers[i].element);
				if (myFeature.isMany()) {
					((Collection) contextInstance.eGet(myFeature))
							.add(newInstance);
				} else {
					contextInstance.eSet(myFeature, newInstance);
				}
				myInitializers[i].initializeElement(newInstance);
			}
		}
	}

	/**
	 * @generated
	 */
	static FeatureInitializer createExpressionFeatureInitializer(
			EStructuralFeature initFeature,
			MindmapAbstractExpression valueExpression) {
		return new ExpressionFeatureInitializer(initFeature, valueExpression);
	}

	/**
	 * @generated
	 */
	private static class ExpressionFeatureInitializer implements
			FeatureInitializer {
		/**
		 * @generated
		 */
		private final EStructuralFeature myFeature;
		/**
		 * @generated
		 */
		private final MindmapAbstractExpression myExpression;

		/**
		 * @generated
		 */
		public ExpressionFeatureInitializer(EStructuralFeature initFeature,
				MindmapAbstractExpression valueExpression) {
			myFeature = initFeature;
			myExpression = valueExpression;
		}

		/**
		 * @generated
		 */
		public void init(EObject contextInstance) {
			myExpression.assignTo(myFeature, contextInstance);
		}
	}

	/**
	 * @generated
	 */
	public static class LinkConstraints {
		/**
		 * @generated
		 */
		private static final String OPPOSITE_END_VAR = "oppositeEnd"; //$NON-NLS-1$

		/**
		 * @generated
		 */
		private static final MindmapAbstractExpression TopicSubtopics_4001_SourceExpression;

		/**
		 * @generated
		 */
		static {
			Map env = new HashMap(3);
			env.put(OPPOSITE_END_VAR, MindmapPackage.eINSTANCE.getTopic());
			TopicSubtopics_4001_SourceExpression = MindmapOCLFactory
					.getExpression(
							"self <> oppositeEnd", MindmapPackage.eINSTANCE.getTopic(), env); //$NON-NLS-1$
		}

		/**
		 * @generated
		 */
		public static boolean canExistTopicSubtopics_4001(EObject source,
				EObject target) {
			if (!evaluate(TopicSubtopics_4001_SourceExpression, source, target,
					false)) {
				return false;
			}
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistRelationship_4002(EObject source,
				EObject target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistRelationship_4003(EObject source,
				EObject target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistRelationship_4004(EObject source,
				EObject target) {
			return true;
		}

		/**
		 * @generated
		 */
		private static boolean evaluate(MindmapAbstractExpression constraint,
				Object sourceEnd, Object oppositeEnd, boolean clearEnv) {
			if (sourceEnd == null) {
				return true;
			}
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
