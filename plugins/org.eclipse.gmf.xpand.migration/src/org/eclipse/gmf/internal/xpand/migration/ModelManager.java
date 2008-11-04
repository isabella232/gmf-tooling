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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.expression.ast.FeatureCall;
import org.eclipse.gmf.internal.xpand.expression.ast.OperationCall;
import org.eclipse.ocl.Environment;

public class ModelManager {

	private StandardLibraryImports stdLibraryImports;

	private OclKeywordManager oclKeywordManager;

	private Set<String> selfVariableAliases = new HashSet<String>();

	public ModelManager(StandardLibraryImports libraryImports) {
		this(libraryImports, new OclKeywordManager());
	}

	public ModelManager(StandardLibraryImports libraryImports, OclKeywordManager keywordManager) {
		stdLibraryImports = libraryImports;
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
		return trace.getType() == OperationCallTrace.Type.OPERATION_REF || trace.getType() == OperationCallTrace.Type.IMPLICIT_COLLECT_OPERATION_REF ? oclKeywordManager.getValidIdentifierValue(trace
				.getEOperation().getName()) : oclKeywordManager.getValidIdentifierValue(operationCall.getName());
	}

	public String getName(FeatureCall featureCall, FeatureCallTrace trace) {
		// Only env. var. references with name "this" should be substituted with
		// "self"
		if (trace.getType() == FeatureCallTrace.Type.ENV_VAR_REF && selfVariableAliases.contains(featureCall.getName().getValue())) {
			return Environment.SELF_VARIABLE_NAME;
		}
		if (trace.getType() == FeatureCallTrace.Type.FEATURE_REF) {
			EStructuralFeature feature = trace.getFeature();
			if (EcorePackage.eINSTANCE.getETypedElement().isSuperTypeOf(feature.getEContainingClass())
					&& EcorePackage.eINSTANCE.getETypedElement_UpperBound().getFeatureID() == EcorePackage.eINSTANCE.getETypedElement().getFeatureID(feature)) {
				return oclKeywordManager.getValidIdentifierValue(feature.getName()) + ".oclAsType(Integer)";
			}
		}
		return trace.getType() == FeatureCallTrace.Type.FEATURE_REF ? oclKeywordManager.getValidIdentifierValue(trace.getFeature().getName()) : oclKeywordManager.getValidIdentifierValue(featureCall
				.getName());
	}

	public void registerSelfAlias(String selfVariableAlias) {
		selfVariableAliases.add(selfVariableAlias);
	}

	public void unregisterSelfAlias(String selfVariableAlias) {
		selfVariableAliases.remove(selfVariableAlias);
	}

}
