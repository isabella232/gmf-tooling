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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ast.FeatureCall;
import org.eclipse.gmf.internal.xpand.expression.ast.OperationCall;
import org.eclipse.ocl.Environment;

public class ModelManager {

	// TODO: fill this map with all necessary OCL keywords to substitute with
	private static final Set<String> OCL_KEYWORDS = new HashSet<String>();

	static {
		// TODO: add all keywords here
		// OCL_KEYWORDS.add("context");
	}

	private boolean mapThisToSelf;

	private StandardLibraryImports stdLibraryImports;

	public ModelManager(StandardLibraryImports libraryImports, boolean mapThisToSelf) {
		stdLibraryImports = libraryImports;
		this.mapThisToSelf = mapThisToSelf;
	}

	public String getName(OperationCall operationCall, OperationCallTrace trace) {
		if (trace.getType() == OperationCallTrace.Type.OPERATION_REF || trace.getType() == OperationCallTrace.Type.IMPLICIT_COLLECT_OPERATION_REF) {
			String operationName = stdLibraryImports.getOperationName(trace.getEOperation());
			if (operationName != null) {
				return operationName;
			}
		}
		return internalGetName(operationCall);
	}

	public String getName(FeatureCall featureCall, FeatureCallTrace trace) {
		// Only env. var. references with name "this" should be substituted with
		// "self"
		if (mapThisToSelf && trace.getType() == FeatureCallTrace.Type.ENV_VAR_REF && ExecutionContext.IMPLICIT_VARIABLE.equals(featureCall.getName().getValue())) {
			return Environment.SELF_VARIABLE_NAME;
		}
		return internalGetName(featureCall);
	}

	private String internalGetName(FeatureCall featureCall) {
		String featureName = featureCall.getName().getValue();
		if (OCL_KEYWORDS.contains(featureName)) {
			return OclCs.ESCAPE_PREFIX + featureName;
		}
		return featureName;
	}

}
