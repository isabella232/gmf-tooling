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
package org.eclipse.gmf.internal.xpand.ast;

import org.eclipse.gmf.internal.xpand.model.XpandAdvice;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;

public abstract class AbstractAstVisitor implements AstVisitor {

	public boolean visit(Template template) {
		return true;
	}

	public boolean visit(XpandAdvice advice) {
		if (advice instanceof AbstractDefinition) {
			return visit((AbstractDefinition) advice);
		}
		return true;
	}

	public boolean visit(XpandDefinition definition) {
		if (definition instanceof AbstractDefinition) {
			return visit((AbstractDefinition) definition);
		}
		return true;
	}

	protected boolean visit(AbstractDefinition definition) {
		return true;
	}

	public boolean visit(ErrorStatement statement) {
		visitExpressionHelper(statement.getMessage());
		return true;
	}

	public boolean visit(ExpandStatement statement) {
		for (ExpressionHelper parameter : statement.getParameters()) {
			visitExpressionHelper(parameter);
		}
		if (statement.getSeparator() != null) {
			visitExpressionHelper(statement.getSeparator());
		}
		if (statement.getTarget() != null) {
			visitExpressionHelper(statement.getTarget());
		}
		return true;
	}

	public boolean visit(ExpressionStatement statement) {
		visitExpressionHelper(statement.getExpression());
		return true;
	}

	public boolean visit(FileStatement statement) {
		visitExpressionHelper(statement.getTargetFileName());
		return true;
	}

	public boolean visit(ForEachStatement statement) {
		if (statement.getSeparator() != null) {
			visitExpressionHelper(statement.getSeparator());
		}
		visitExpressionHelper(statement.getTarget());
		return true;
	}

	public boolean visit(IfStatement statement) {
		if (statement.getCondition() != null) {
			visitExpressionHelper(statement.getCondition());
		}
		return true;
	}

	public boolean visit(LetStatement statement) {
		visitExpressionHelper(statement.getVarValue());
		return true;
	}

	public boolean visit(ProtectStatement statement) {
		visitExpressionHelper(statement.getCommentStart());
		visitExpressionHelper(statement.getCommentEnd());
		visitExpressionHelper(statement.getId());
		return true;
	}

	public boolean visit(TextStatement statement) {
		return true;
	}

	public boolean visit(Statement statement) {
		return true;
	}

	protected void visitExpressionHelper(ExpressionHelper expressionHelper) {
	}

}
