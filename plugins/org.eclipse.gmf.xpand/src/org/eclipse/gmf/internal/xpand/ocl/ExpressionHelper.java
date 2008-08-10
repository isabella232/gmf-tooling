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

import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.OCLExpression;

public class ExpressionHelper {

	private final OCLExpressionCS expressionCS;

	public ExpressionHelper(OCLExpressionCS exprCS) {
		assert exprCS != null;
		this.expressionCS = exprCS;
	}
	public OCLExpressionCS getCST() {
		return expressionCS;
	}

	public EClassifier analyze(ExecutionContext ctx, Set<AnalysationIssue> issues) {
		EcoreEnvironment env = ctx.getOCLEnvironment();
		OCLExpression<EClassifier> expression = new EmbeddedQVTAnalyzer(env).analyzeExpression(expressionCS);
		return expression.getType();
	}

	public Object evaluate(ExecutionContext ctx) {
		EcoreEnvironment env = ctx.getOCLEnvironment();
		//
		Context context = new Context();
		QvtOperationalEnvFactory envFactory = QvtOperationalEnvFactory.INSTANCE;
		QvtOperationalEvaluationEnv evaluationEnv = envFactory.createEvaluationEnvironment(context, null);
		ctx.populate(evaluationEnv);
		OCLExpression<EClassifier> expression = new EmbeddedQVTAnalyzer(env).analyzeExpression(expressionCS);
		//System.out.println("ExpressionHelper.evaluate():" + expression);
		/* 
		 * XXX From TestExternHelperCall - perhaps, need to collect all imports, though seems to work for me without that
		HashSet<Module> importedModules = new HashSet<Module>();
		importedModules.add(module);
		QvtOperationalParserUtil.collectAllImports(module, importedModules);
		
		XXX ask Radek - what's the difference between plain QvtOperationalEnv(null) and subclass he creates 
						in there, which mangles with umlReflection (though seems to leave it the same)
		visitor = new QvtOperationalEvaluationVisitorImpl.createNonTransformationExecutionContextVisitor((QvtOperationalEnv) env, evaluationEnv, Collections.<Module>emptySet());
		 */
		QvtOperationalEvaluationVisitorImpl visitor = new QvtOperationalEvaluationVisitorImpl((QvtOperationalEnv) env, evaluationEnv);
		// FIXME move context handling with this->self inside ExecutionContextImpl? Or, it's better to have explicit,
		// separate environment for each execution?
		Variable self = ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);  
		if (self != null) {
			evaluationEnv.add(Environment.SELF_VARIABLE_NAME, self.getValue());
			evaluationEnv.setOperationSelf(self.getValue());
		}
		Object val = visitor.visitExpression(expression);
		if (env.getOCLStandardLibrary().getOclInvalid() == val) {
			throw new EvaluationException("Can't evaluate expression: retured value is OclInvalid", null);
		}
/*
		OCL ocl = OCL.newInstance();
		ctx.populate((EcoreEvaluationEnvironment) ocl.getEvaluationEnvironment());
		Object val = ocl.evaluate(self == null ? null : self.getValue(), expression);
		if (ocl.isInvalid(val)) {
			// TODO serialize CST to show actual string that's wrong
			throw new EvaluationException("Can't evaluate expression: retured value is OclInvalid", null);
		}
*/
		return val;
	}
}
