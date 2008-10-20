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

import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ast.FeatureCall;
import org.eclipse.gmf.internal.xpand.expression.ast.OperationCall;
import org.eclipse.ocl.Environment;

public class ModelManager {

	private boolean mapThisToSelf;

	private StandardLibraryImports stdLibraryImports;

	private OclKeywordManager oclKeywordManager;
	
	public ModelManager(StandardLibraryImports libraryImports, boolean mapThisToSelf) {
		this(libraryImports, new OclKeywordManager(), mapThisToSelf);
	}

	public ModelManager(StandardLibraryImports libraryImports, OclKeywordManager keywordManager, boolean mapThisToSelf) {
		stdLibraryImports = libraryImports;
		this.mapThisToSelf = mapThisToSelf;
		oclKeywordManager = keywordManager;
	}

	public String getName(OperationCall operationCall, OperationCallTrace trace) {
		if (trace.getType() == OperationCallTrace.Type.OPERATION_REF || trace.getType() == OperationCallTrace.Type.IMPLICIT_COLLECT_OPERATION_REF) {
			String operationName = stdLibraryImports.getOperationName(trace.getEOperation());
			if (operationName != null) {
				return operationName;
			}
		}
		if (trace.getType() == OperationCallTrace.Type.STATIC_EXTENSION_REF || trace.getType() == OperationCallTrace.Type.EXTENSION_REF
				|| trace.getType() == OperationCallTrace.Type.IMPLICIT_COLLECT_EXTENSION_REF) {
			if (trace.getNativeLibraryName() != null) {
				stdLibraryImports.registerNativeLibrary(trace.getNativeLibraryName());
			}
		}
		return oclKeywordManager.getValidIdentifierValue(operationCall.getName());
	}

	public String getName(FeatureCall featureCall, FeatureCallTrace trace) {
		// Only env. var. references with name "this" should be substituted with
		// "self"
		if (mapThisToSelf && trace.getType() == FeatureCallTrace.Type.ENV_VAR_REF && ExecutionContext.IMPLICIT_VARIABLE.equals(featureCall.getName().getValue())) {
			return Environment.SELF_VARIABLE_NAME;
		}
		return oclKeywordManager.getValidIdentifierValue(featureCall.getName());
	}

}
