/*
 * Copyright (c) 2005,2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.internal.xpand.ast;

import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.gmf.internal.xpand.model.XpandAnalyzable;
import org.eclipse.gmf.internal.xpand.model.XpandEvaluatable;
import org.eclipse.gmf.internal.xpand.ocl.DeclaredParameter;
import org.eclipse.gmf.internal.xpand.ocl.TypeHelper;
import org.eclipse.ocl.cst.TypeCS;

public abstract class AbstractDefinition extends SyntaxElement implements XpandAnalyzable, XpandEvaluatable {

    protected final TypeHelper type;

    protected final DeclaredParameter[] params;

    private final Statement[] body;

    protected Template owner = null;

    public AbstractDefinition(final int start, final int end, final int line, final TypeCS type, final DeclaredParameter[] params, final Statement[] body) {
        super(start, end, line);
        this.type = new TypeHelper(type);
        this.params = params;
        this.body = body;
    }

    /**
	 * FIXME used only in tests, should I keep it?
	 */
	public Statement[] getBody() {
		return body;
	}

	public void setOwner(final Template owner) {
        this.owner = owner;
    }

    public void analyze(ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        final EClassifier thisType = type.getTypeForName(ctx);
        if (thisType == null) {
            issues.add(new AnalysationIssue(AnalysationIssue.Type.TYPE_NOT_FOUND, "Couldn't find " + type.getName(), this));
        }
        ctx = ctx.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, thisType, null));
        Variable[] vars = new Variable[params.length];
        for (int i = 0; i < params.length; i++) {
            EClassifier paramType = params[i].getTypeForName(ctx);
            if (paramType == null) {
                issues.add(new AnalysationIssue(AnalysationIssue.Type.TYPE_NOT_FOUND, "Couldn't find "
                        + params[i].getTypeName(), this /* FIXME: was: params[i].getType()*/));
                paramType = EcorePackage.eINSTANCE.getEObject();
            }
            final String name = params[i].getVarName();
            vars[i] = new Variable(name, paramType, null);
        }
        ctx = ctx.cloneWithVariable(vars);
        for (int i = 0; i < body.length; i++) {
            body[i].analyze(ctx, issues);
        }
    }

    public void evaluate(ExecutionContext ctx) {
        ctx = ctx.cloneWithResource(owner);
        for (int i = 0; i < body.length; i++) {
            body[i].evaluate(ctx);
        }
    }
    
    public TypeHelper getType() {
    	return type;
    }
    
    public DeclaredParameter[] getParemeters() {
    	return params;
    }
}
