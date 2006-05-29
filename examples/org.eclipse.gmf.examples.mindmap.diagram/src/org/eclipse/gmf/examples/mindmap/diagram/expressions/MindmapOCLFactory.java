/**
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.examples.mindmap.diagram.expressions;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;

import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.Variable;

import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.helper.OCLParsingException;

import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import org.eclipse.emf.ocl.types.util.Types;

/**
 * @generated 
 */
public class MindmapOCLFactory {

	/**
	 * @generated 
	 */
	private MindmapOCLFactory() {
	}

	/**
	 * @generated 
	 */
	public static MindmapAbstractExpression getExpression(String body, EClassifier context, Map environment) {
		return new Expression(body, context, environment);
	}

	/**
	 * @generated 
	 */
	public static MindmapAbstractExpression getExpression(String body, EClassifier context) {
		return getExpression(body, context, Collections.EMPTY_MAP);
	}

	/**
	 * @generated 
	 */
	private static class Expression extends MindmapAbstractExpression {

		/**
		 * @generated 
		 */
		private Query query;

		/**
		 * @generated 
		 */
		public Expression(String body, EClassifier context, Map environment) {
			super(body, context, environment);

			IOCLHelper oclHelper = (environment.isEmpty()) ? HelperUtil.createOCLHelper() : HelperUtil.createOCLHelper(createCustomEnv(environment));
			oclHelper.setContext(context());
			try {
				OCLExpression oclExpression = oclHelper.createQuery(body);
				this.query = QueryFactory.eINSTANCE.createQuery(oclExpression);
			} catch (OCLParsingException e) {
				setStatus(IStatus.ERROR, e.getMessage(), e);
			}
		}

		/**
		 * @generated 
		 */
		protected Object doEvaluate(Object context, Map env) {
			if (query == null) {
				return null;
			}
			EvaluationEnvironment evalEnv = query.getEvaluationEnvironment();
			// init environment
			for (Iterator it = env.entrySet().iterator(); it.hasNext();) {
				Map.Entry nextEntry = (Map.Entry) it.next();
				evalEnv.replace((String) nextEntry.getKey(), nextEntry.getValue());
			}

			try {
				Object result = query.evaluate(context);
				return (result != Types.OCL_INVALID) ? result : null;
			} finally {
				evalEnv.clear();
			}
		}

		/**
		 * @generated 
		 */
		private static EcoreEnvironmentFactory createCustomEnv(Map environment) {
			final Map env = environment;
			return new EcoreEnvironmentFactory() {

				public Environment createClassifierContext(Object context) {
					Environment ecoreEnv = super.createClassifierContext(context);
					for (Iterator it = env.keySet().iterator(); it.hasNext();) {
						String varName = (String) it.next();
						EClassifier varType = (EClassifier) env.get(varName);
						ecoreEnv.addElement(varName, createVar(varName, varType), true);
					}
					return ecoreEnv;
				}
			};
		}

		/**
		 * @generated 
		 */
		private static Variable createVar(String name, EClassifier type) {
			Variable var = ExpressionsFactory.eINSTANCE.createVariable();
			var.setName(name);
			var.setType(EcoreEnvironment.getOCLType(type));
			return var;
		}
	}
}
