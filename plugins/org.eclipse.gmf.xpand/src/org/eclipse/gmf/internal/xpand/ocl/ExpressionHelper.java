/*
 * Copyright (c) 2008, 2009 Borland Software Corporation
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
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
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
import org.eclipse.ocl.parser.OCLProblemHandler;

public class ExpressionHelper {
	
	private final OCLExpressionCS expressionCS;
	private OCLExpression<EClassifier> oclExpression;
	private EcoreEnvironment oclEnvironment;
	private Diagnostic oclExpressionDiagnostic;
	private SyntaxElement parentElement;
	
	public ExpressionHelper(OCLExpressionCS exprCS, SyntaxElement parentElement) {
		assert exprCS != null;
		this.expressionCS = exprCS;
		// TODO: determine start/end/line from CST element?
		this.parentElement = parentElement;
	}

	public OCLExpressionCS getCST() {
		return expressionCS;
	}

	public EClassifier analyze(ExecutionContext ctx, Set<AnalysationIssue> issues) {
		EcoreEnvironment env = getOCLEnvironment(ctx);
		OCLExpression<EClassifier> expression = getOCLExpression(env);
		handleOCLAnalyzationErrors(issues);
		return expression!= null ? expression.getType() : null;
	}

	/**
	 * TODO: report error message with more concrete positions (currently whole
	 * ImperativeOCL expression will be highlighted)
	 */
	private void handleOCLAnalyzationErrors(Set<AnalysationIssue> issues) {
		if (getOclExpressionDiagnostic() != null) {
			issues.add(new AnalysationIssue(AnalysationIssue.Type.INCOMPATIBLE_TYPES, getOclExpressionDiagnostic().getMessage(), this));
		}
	}

	public Object evaluate(ExecutionContext ctx) {
		EcoreEnvironment env = getOCLEnvironment(ctx);
		OCLExpression<EClassifier> expression = getOCLExpression(env);		
		if (getOclExpressionDiagnostic() != null) {
			throw new EvaluationException(getOclExpressionDiagnostic().getMessage(), this);
		}

		// TODO: use CustomOclValidationVisitor extracted from
		// QvtOperationalValidationVisitor once it is available.
		
//		// Validating AST only on evaluation time since this process can report
//		// some errors in indirectly references .qvto files which are not
//		// important while analyzing AST
//		ValidationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> validator = new ValidationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>(
//				env) {
//		};
//		expression.accept(validator);
//		Diagnostic validationResults = getOCLDiagnostic(env);
//		if (validationResults != null) {
//			throw new EvaluationException(validationResults.getMessage(), this);
//		}

		QvtOperationalEvaluationVisitor visitor = ctx.createEvaluationVisitor();
		defineGlobalVariables(ctx, visitor.getOperationalEvaluationEnv());
		initializeStreamsHolder(ctx.getScope(), ctx.getScope().getOutput().getNamedStreams(), visitor.getOperationalEvaluationEnv());
		Object val = visitor.visitExpression(expression);
		initializeStreamsHolder(ctx.getScope(), null, visitor.getOperationalEvaluationEnv());
		clearGlobalVariables(ctx, visitor.getOperationalEvaluationEnv());
		if (env.getOCLStandardLibrary().getOclInvalid() == val) {
			throw new EvaluationException("Can't evaluate expression: returned value is OclInvalid", this);
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
			oclExpressionDiagnostic = getOCLDiagnostic(env);
		}
		return oclExpression;
	}
	
	private Diagnostic getOCLDiagnostic(EcoreEnvironment env) {
		if (env.getProblemHandler() instanceof OCLProblemHandler) {
			OCLProblemHandler oclProblemHandler = (OCLProblemHandler) env.getProblemHandler();
			Diagnostic diagnostic = oclProblemHandler.getDiagnostic();
			if (diagnostic != null && diagnostic.getSeverity() == Diagnostic.ERROR) {
				return diagnostic;
			}
			oclProblemHandler.clearDiagnostic();
		}
		return null;
	}

	/**
	 * Should be called only after {@link #getOCLExpression(EcoreEnvironment)}
	 * 
	 * @return Diagnostic or null if expression was analyzed successfully
	 */
	private Diagnostic getOclExpressionDiagnostic() {
		return oclExpressionDiagnostic;
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
	
	public String getFileName() {
		return parentElement.getFileName();
	}
	
	public int getLine() {
		return parentElement.getLine();
	}

	/**
	 * @return cached oclExpression. This method should be called only after
	 *         analyze() or evaluate() method call.
	 */
	public OCLExpression<EClassifier> getOCLExpression() {
		return oclExpression;
	}
	
}
