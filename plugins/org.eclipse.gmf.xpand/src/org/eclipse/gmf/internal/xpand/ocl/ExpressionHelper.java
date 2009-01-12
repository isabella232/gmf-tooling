/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.ocl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.StreamsHolder;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.Scope;
import org.eclipse.gmf.internal.xpand.qvtlibraries.XpandGlobalVars;
import org.eclipse.gmf.internal.xpand.util.XpandStreamOperations;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtResource;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitor;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.parser.OCLProblemHandler;

public class ExpressionHelper {
	
	private final OCLExpressionCS expressionCS;
	private OCLExpression<EClassifier> oclExpression;
	private EcoreEnvironment oclEnvironment;
	
	public ExpressionHelper(OCLExpressionCS exprCS) {
		assert exprCS != null;
		this.expressionCS = exprCS;
		// TODO: determine start/end/line from CST element?
	}

	public OCLExpressionCS getCST() {
		return expressionCS;
	}

	public EClassifier analyze(ExecutionContext ctx, Set<AnalysationIssue> issues) {
		EcoreEnvironment env = getOCLEnvironment(ctx);
		OCLExpression<EClassifier> expression = getOCLExpression(env);
		handleOCLAnalyzationErrors(env.getProblemHandler(), issues);
		return expression.getType();
	}

	/**
	 * Temporary method reporting errors came from QVT expression analysis.
	 * TODO: make it working
	 */
	private void handleOCLAnalyzationErrors(ProblemHandler problemHandler, Set<AnalysationIssue> issues) {
		if (problemHandler instanceof org.eclipse.ocl.parser.OCLProblemHandler) {
			org.eclipse.ocl.parser.OCLProblemHandler oclProblemHandler = (OCLProblemHandler) problemHandler;
			Diagnostic diagnostic = oclProblemHandler.getDiagnostic();
			if (diagnostic != null && diagnostic.getSeverity() == Diagnostic.ERROR) {
				issues.add(new AnalysationIssue(AnalysationIssue.Type.INCOMPATIBLE_TYPES, diagnostic.getMessage(), this));
			}
			oclProblemHandler.clearDiagnostic();
		}
	}

	public Object evaluate(ExecutionContext ctx) {
		EcoreEnvironment env = getOCLEnvironment(ctx);
		OCLExpression<EClassifier> expression = getOCLExpression(env);
		QvtOperationalEvaluationEnv evaluationEnv = (QvtOperationalEvaluationEnv) ctx.createEvaluationEnvironment();
		QvtOperationalEvaluationVisitor visitor = ctx.createEvaluationVisitor(evaluationEnv);
		defineGlobalVariables(ctx, evaluationEnv);
		initializeStreamsHolder(ctx.getScope(), ctx.getScope().getOutput().getNamedStreams(), evaluationEnv);
		Object val = visitor.visitExpression(expression);
		initializeStreamsHolder(ctx.getScope(), null, evaluationEnv);
		clearGlobalVariables(ctx, evaluationEnv);
		if (env.getOCLStandardLibrary().getOclInvalid() == val) {
			throw new EvaluationException("Can't evaluate expression: retured value is OclInvalid", null);
		}
		return val;		
	}

	private EcoreEnvironment getOCLEnvironment(ExecutionContext ctx) {
		if (oclEnvironment == null) {
			oclEnvironment = ctx.getOCLEnvironment();
		}
		return oclEnvironment;
	}
	
	private OCLExpression<EClassifier> getOCLExpression(EcoreEnvironment env) {
		if (oclExpression == null) {
			oclExpression = new EmbeddedQVTAnalyzer(env).analyzeExpression(expressionCS);
		}
		return oclExpression;
	}

	private void clearGlobalVariables(ExecutionContext ctx, QvtOperationalEvaluationEnv evaluationEnv) {
		Collection<String> globalVarNames = ctx.getScope().getGlobalVarNames();
		if (globalVarNames.isEmpty()) {
			return;
		}
		XpandGlobalVars globalVarsLibInstance = getGlobalVarsLibraryInstance(ctx.getScope(), evaluationEnv);
		if (globalVarsLibInstance != null) {
			globalVarsLibInstance.globalVariables = Collections.emptyMap();
		}
	}

	private void defineGlobalVariables(ExecutionContext ctx, QvtOperationalEvaluationEnv evaluationEnv) {
		Scope scope = ctx.getScope();
		Collection<String> globalVarNames = scope.getGlobalVarNames();
		if (globalVarNames.isEmpty()) {
			return;
		}
		XpandGlobalVars globalVarsLibInstance = getGlobalVarsLibraryInstance(scope, evaluationEnv);
		if (globalVarsLibInstance != null) {
			Map<String, Object> globalVars = new HashMap<String, Object>();
			for (String varName : globalVarNames) {
				globalVars.put(varName, scope.getGlobalVariable(varName).getValue());
			}
			globalVarsLibInstance.globalVariables = globalVars;
		}
	}
	
	private XpandGlobalVars getGlobalVarsLibraryInstance(Scope scope, QvtOperationalEvaluationEnv evaluationEnv) {
		QvtResource globalVarsOperationResource = scope.findExtension("xpt::GlobalVarOperations");
		if (globalVarsOperationResource != null) {
			for (Module module : globalVarsOperationResource.getModules()) {
				ModuleInstance moduleInstance = evaluationEnv.getThisOfType(module);
				if (moduleInstance != null) {
					XpandGlobalVars globalVarsLibInstance = moduleInstance.getAdapter(XpandGlobalVars.class);
					if (globalVarsLibInstance != null) {
						return globalVarsLibInstance;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Initializes QVT black-box java library with the given value of the streams holder.
	 */
	private void initializeStreamsHolder(Scope scope, StreamsHolder namedStreams, QvtOperationalEvaluationEnv evaluationEnv) {
		QvtResource streamOperationResource = scope.findExtension("xpt::StreamOperations");
		if (streamOperationResource != null) {
			for (Module module : streamOperationResource.getModules()) {
				ModuleInstance moduleInstance = evaluationEnv.getThisOfType(module);
				if (moduleInstance != null) {
					XpandStreamOperations libInstance = moduleInstance.getAdapter(XpandStreamOperations.class);
					if (libInstance != null) {
						libInstance.streamsHolder = namedStreams;
					}
				}
			}
		}
	}

	public int getStart() {
		return expressionCS.getStartOffset();
	}

	public int getEnd() {
		return expressionCS.getEndOffset();
	}
	
}
