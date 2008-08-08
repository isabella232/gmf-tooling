/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.gmf.internal.xpand.model.XpandAdvice;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.ocl.DeclaredParameter;
import org.eclipse.gmf.internal.xpand.util.TypeNameUtil;
import org.eclipse.ocl.cst.TypeCS;

/**
 * @author Sven Efftinge
 */
public class Advice extends AbstractDefinition implements XpandAdvice {

    public final static String DEF_VAR_NAME = "targetDef";

    private final Identifier pointCut;

    private final boolean wildParams;

    public Advice(final int start, final int end, final int line, final Identifier pointCut, final TypeCS type,
            final DeclaredParameter[] params, final boolean wildParams, final Statement[] body) {
        super(start, end, line, type, params, body);
        this.pointCut = pointCut;
        this.wildParams = wildParams;
    }

    public Identifier getPointCut() {
        return pointCut;
    }

    @Override
    public String toString() {
        return owner.getFullyQualifiedName() + " " + pointCut.getValue() + getParamString() + " FOR " + type.toString();
    }

    @Override
    public void analyze(ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        ctx = ctx.cloneWithVariable(new Variable(DEF_VAR_NAME, BuiltinMetaModel.DEFINITION_TYPE, null));
        super.analyze(ctx, issues);
    }

    private String getParamString() {
        if ((params == null) || (params.length == 0)) {
			return wildParams ? "(*)" : "";
		}
        final StringBuilder buff = new StringBuilder("(");
        for (int i = 0; i < params.length; i++) {
            final DeclaredParameter p = params[i];
            buff.append(p.getVarName()).append(" ").append(p.getTypeName());
            if (i + 1 < params.length) {
                buff.append(",");
            }
        }
        if (wildParams) {
            buff.append(",*");
        }
        return buff.append(")").toString();
    }

    private Pattern p = null;

    public boolean matches(final XpandDefinition def, ExecutionContext ctx) {
        if (p == null) {
            p = Pattern.compile(pointCut.getValue().replaceAll("\\*", ".*"));
        }
        // 1) AROUND simpleName
        final Matcher m1 = p.matcher(def.getName());
        // 2) AROUND fully::qualified::name
        final Matcher m2 = p.matcher(def.getOwner().getFullyQualifiedName() + TypeNameUtil.NS_DELIM + def.getName());
        if (m1.matches() || m2.matches()) {
            ctx = ctx.cloneWithResource(def.getOwner());
            final EClassifier t = def.getTargetType().getTypeForName(ctx);
            final EClassifier[] paramTypes = new EClassifier[def.getParams().length];
            for (int i = 0; i < paramTypes.length; i++) {
                paramTypes[i] = def.getParams()[i].getTypeForName(ctx);
            }
            // FIXME next check can be done earlier
            if ((params.length == paramTypes.length) || (wildParams && (params.length <= paramTypes.length))) {

                ctx = ctx.cloneWithResource(this.owner);	//need to resolve in the context of the aspect
                final EClassifier at = type.getTypeForName(ctx);
                if (BuiltinMetaModel.isAssignableFrom(ctx, at, t)) {
                    for (int i = 0; i < params.length; i++) {
                        final EClassifier pt = params[i].getTypeForName(ctx);
                        if (!BuiltinMetaModel.isAssignableFrom(ctx, pt, paramTypes[i])) {
							return false;
						}
                    }
                    return true;
                }
            }
        }
        return false;
    }

}
