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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.internal.xpand.ast.AbstractAstVisitor;
import org.eclipse.gmf.internal.xpand.ast.AbstractDefinition;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.ocl.DeclaredParameter;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;
import org.eclipse.ocl.ecore.TypeExp;

public class UnusedMetamodelsCollector extends AbstractAstVisitor {

	private LinkedHashSet<EPackage> myUnusedEPackages;

	private ExecutionContext myContext;

	public UnusedMetamodelsCollector(Set<EPackage> ePackages, ExecutionContext context) {
		myUnusedEPackages = new LinkedHashSet<EPackage>(ePackages);
		myContext = context;
	}

	public Set<EPackage> getUnusedEPackages() {
		return myUnusedEPackages;
	}

	@Override
	protected boolean visit(AbstractDefinition definition) {
		if (myUnusedEPackages.size() == 0) {
			return false;
		}
		EClassifier type = definition.getType().getTypeForName(myContext);
		if (type != null) {
			myUnusedEPackages.remove(type.getEPackage());
		}
		for (DeclaredParameter parameter : definition.getParemeters()) {
			type = parameter.getTypeForName(myContext);
			if (type != null) {
				myUnusedEPackages.remove(type.getEPackage());
			}
		}
		return super.visit(definition);
	}

	@Override
	protected void visitExpressionHelper(ExpressionHelper expressionHelper) {
		if (myUnusedEPackages.size() == 0) {
			return;
		}
		if (expressionHelper.getOCLExpression() != null) {
			purgeUsedEPackages(expressionHelper.getOCLExpression());
			for (Iterator<EObject> it = expressionHelper.getOCLExpression().eAllContents(); it.hasNext();) {
				purgeUsedEPackages(it.next());
			}
		}
	}

	private void purgeUsedEPackages(EObject oclAstElement) {
		if (oclAstElement instanceof TypeExp) {
			TypeExp typeExpression = (TypeExp) oclAstElement;
			if (typeExpression.getReferredType() != null) {
				myUnusedEPackages.remove(typeExpression.getReferredType().getEPackage());
			}
		}
	}

}
