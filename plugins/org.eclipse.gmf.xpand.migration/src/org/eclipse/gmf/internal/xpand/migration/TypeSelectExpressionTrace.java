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

import org.eclipse.emf.ecore.EClassifier;

public class TypeSelectExpressionTrace implements ExpressionAnalyzeTrace {

	private EClassifier resultType;

	private EClassifier targetType;

	public TypeSelectExpressionTrace(EClassifier result, EClassifier targetType) {
		resultType = result;
		this.targetType = targetType;
	}

	public EClassifier getResultType() {
		return resultType;
	}

	public EClassifier getTargetType() {
		return targetType;
	}

	public boolean isValid() {
		return resultType != null;
	}

}
