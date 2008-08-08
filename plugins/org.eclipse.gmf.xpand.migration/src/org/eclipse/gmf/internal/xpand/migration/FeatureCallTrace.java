/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.migration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;

public class FeatureCallTrace implements ExpressionAnalyzeTrace {

	public enum Type {
		ENUM_LITERAL_REF, ENV_VAR_REF, FEATURE_REF, IMPLICIT_COLLECT_FEATURE_REF, UNDESOLVED_TARGET_TYPE, UNSUPPORTED_CLASSIFIER_REF;
	}

	private EClassifier resultType;

	private EEnumLiteral literal;

	private Type type;

	private EStructuralFeature feature;

	private EClassifier targetType;

	public FeatureCallTrace(EClassifier result, EEnumLiteral literal) {
		this(result, Type.ENUM_LITERAL_REF);
		this.literal = literal;
	}

	public FeatureCallTrace(EClassifier result, EStructuralFeature feature, EClassifier targetType) {
		this(result, Type.FEATURE_REF);
		this.feature = feature;
		this.targetType = targetType;
	}

	public FeatureCallTrace(EClass result, EClassifier targetType) {
		this(result, Type.IMPLICIT_COLLECT_FEATURE_REF);
		this.targetType = targetType;
	}

	public FeatureCallTrace(EClassifier result, Type type) {
		resultType = result;
		this.type = type;
	}

	public EClassifier getResultType() {
		return resultType;
	}

	/**
	 * @return referenced enum literal or null if getType() != ENUM_LITERAL_REF
	 */
	public EEnumLiteral getEnumLiteral() {
		return literal;
	}

	/**
	 * @return EStructuralFeature referenced by this FeatureCall or null if
	 *         getType() != FEATURE_REF
	 */
	public EStructuralFeature getFeature() {
		return feature;
	}

	/**
	 * @return EClassifier representing the type of FeatureCall target or null
	 *         if getType() != (FEATURE_REF || IMPLICIT_COLLECT_FEATURE_REF)
	 */
	public EClassifier getTargetType() {
		return targetType;
	}

	public Type getType() {
		return type;
	}

}
