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
import org.eclipse.emf.ecore.EOperation;

public class OperationCallTrace implements ExpressionAnalyzeTrace {

	public enum Type {
		UNDESOLVED_PARAMETER_TYPE, UNDESOLVED_TARGET_TYPE, STATIC_EXTENSION_REF, OPERATION_REF, EXTENSION_REF, IMPLICIT_COLLECT_OPERATION_REF, IMPLICIT_COLLECT_EXTENSION_REF
	}

	private EClassifier resultType;

	private Type type;

	private EOperation operation;

	private EClassifier targetType;

	public OperationCallTrace(EClassifier result, Type type) {
		resultType = result;
		this.type = type;
	}

	public OperationCallTrace(EClassifier result, EOperation operation) {
		this(result, Type.OPERATION_REF);
		this.operation = operation;
	}

	public OperationCallTrace(EClass result, EClassifier targetType) {
		this(result, Type.IMPLICIT_COLLECT_EXTENSION_REF);
		this.targetType = targetType;
	}

	public OperationCallTrace(EClass result, EClassifier targetType, EOperation operation) {
		this(result, Type.IMPLICIT_COLLECT_OPERATION_REF);
		this.targetType = targetType;
		this.operation = operation;
	}

	public EClassifier getResultType() {
		return resultType;
	}

	public Type getType() {
		return type;
	}

	/**
	 * @return EOperation referenced by this OperationCall or null if getType()
	 *         != OPERATION_REF
	 */
	public EOperation getEOperation() {
		return operation;
	}

	/**
	 * @return EClassifier representing the type of OperationCall target or null
	 *         if getType() != (IMPLICIT_COLLECT_OPERATION_REF ||
	 *         IMPLICIT_COLLECT_EXTENSION_REF)
	 */
	public EClassifier getTargetType() {
		return targetType;
	}

}
