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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.expression.ast.Expression;

public class ExpandAnalyzeTrace extends ForEachAnalyzeTrace {

	private Map<Expression, EClassifier> parametersMap = new HashMap<Expression, EClassifier>();

	public ExpandAnalyzeTrace(Expression[] parameters, EClassifier[] parameterTypes, EClassifier separatorType, EClassifier targetType) {
		super(targetType, separatorType);
		assert parameters.length == parameterTypes.length;
		for (int i = 0; i < parameters.length; i++) {
			parametersMap.put(parameters[i], parameterTypes[i]);
		}
	}

	public EClassifier getParameterType(Expression parameter) {
		return parametersMap.get(parameter);
	}

}
