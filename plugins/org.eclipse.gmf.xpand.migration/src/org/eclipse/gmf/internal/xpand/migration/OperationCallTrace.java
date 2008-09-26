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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;

public class OperationCallTrace extends ExpressionAnalyzeTrace {

	public enum Type {
		UNDESOLVED_PARAMETER_TYPE, UNDESOLVED_TARGET_TYPE, STATIC_EXTENSION_REF, OPERATION_REF, EXTENSION_REF, IMPLICIT_COLLECT_OPERATION_REF, IMPLICIT_COLLECT_EXTENSION_REF
	}

	private Type type;

	private EOperation operation;

	private EClassifier targetType;

	private List<EClassifier> paramTypes;

	public OperationCallTrace(EClassifier result, List<EClassifier> paramTypes, Type type) {
		super(result);
		this.paramTypes = paramTypes;
		this.type = type;
	}

	public OperationCallTrace(EClass result, List<EClassifier> paramTypes, EClassifier targetType) {
		this(result, paramTypes, Type.IMPLICIT_COLLECT_EXTENSION_REF);
		this.targetType = targetType;
	}

	public OperationCallTrace(EClassifier result, List<EClassifier> paramTypes, EClassifier targetType, EOperation operation, Type type) {
		this(result, paramTypes, type);
		this.targetType = targetType;
		this.operation = operation;
	}

	public OperationCallTrace(EClassifier result, List<EClassifier> paramTypes, EClassifier targetType, EOperation operation) {
		this(result, paramTypes, targetType, operation, OperationCallTrace.Type.OPERATION_REF);
		this.paramTypes = paramTypes;
	}

	public Type getType() {
		return type;
	}

	/**
	 * @return EOperation referenced by this OperationCall or null if getType()
	 *         != (OPERATION_REF || IMPLICIT_COLLECT_OPERATION_REF)
	 */
	public EOperation getEOperation() {
		return operation;
	}

	/**
	 * @return EClassifier representing the type of OperationCall target or null
	 *         if getType() != (OPERATION_REF || IMPLICIT_COLLECT_OPERATION_REF
	 *         || IMPLICIT_COLLECT_EXTENSION_REF)
	 */
	public EClassifier getTargetType() {
		return targetType;
	}

	public List<EClassifier> getParamTypes() {
		return paramTypes;
	}

}
