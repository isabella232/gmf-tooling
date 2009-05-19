/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.ast.analyze;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.gmf.internal.xpand.ast.AbstractAstVisitor;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.ecore.OperationCallExp;

public class UnusedModulesCollector extends AbstractAstVisitor {

	private Set<Module> myUnusedModules;

	public UnusedModulesCollector(Set<Module> allModules) {
		myUnusedModules = new LinkedHashSet<Module>(allModules);
	}

	public Set<Module> getUnusedModules() {
		return myUnusedModules;
	}

	@Override
	protected void visitExpressionHelper(ExpressionHelper expressionHelper) {
		if (myUnusedModules.size() == 0) {
			return;
		}
		if (expressionHelper.getOCLExpression() != null) {
			purgeUsedModule(expressionHelper.getOCLExpression());
			for (Iterator<EObject> it = expressionHelper.getOCLExpression().eAllContents(); it.hasNext();) {
				purgeUsedModule(it.next());
			}
		}
	}

	private void purgeUsedModule(EObject oclAstElement) {
		if (oclAstElement instanceof OperationCallExp) {
			OperationCallExp opCall = (OperationCallExp) oclAstElement;
			EOperation referredOperation = opCall.getReferredOperation();
			if (referredOperation != null) {
				EObject eContainer = referredOperation.eContainer();
				if (eContainer instanceof Module) {
					myUnusedModules.remove(eContainer);
				}
			}
		}
	}

}
