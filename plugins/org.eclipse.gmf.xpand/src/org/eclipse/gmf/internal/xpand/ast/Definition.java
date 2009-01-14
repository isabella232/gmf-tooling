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

import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.gmf.internal.xpand.ocl.DeclaredParameter;
import org.eclipse.gmf.internal.xpand.ocl.TypeHelper;
import org.eclipse.gmf.internal.xpand.util.TypeNameUtil;
import org.eclipse.ocl.cst.TypeCS;

/**
 * @author Sven Efftinge
 */
public class Definition extends AbstractDefinition implements XpandDefinition {
    private final Identifier name;

    public Definition(final int start, final int end, final int line, final Identifier name, final TypeCS type,
            final DeclaredParameter[] params, final Statement[] body) {
        super(start, end, line, type, params, body);
        this.name = name;
    }

    public String getName() {
        return name.getValue();
    }

    public TypeHelper getTargetType() {
    	return type;
    }

	public final Template getOwner() {
		return owner;
	}

	public final DeclaredParameter[] getParams() {
		return params;
	}

    @Override
    public String toString() {
        return getOwner().getFullyQualifiedName() + TypeNameUtil.NS_DELIM + getName() + getParamString() + " FOR " + type.getName();
    }

    private String getParamString() {
        if ((params == null) || (params.length == 0)) {
			return "";
		}
        final StringBuilder buff = new StringBuilder("(");
        for (int i = 0; i < params.length; i++) {
            final DeclaredParameter p = params[i];
            buff.append(p.getVarName()).append(" ").append(p.getTypeName());
            if (i + 1 < params.length) {
                buff.append(",");
            }
        }
        return buff.append(")").toString();
    }
}
