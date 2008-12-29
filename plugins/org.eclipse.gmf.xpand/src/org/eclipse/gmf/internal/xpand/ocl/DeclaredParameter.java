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

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.ocl.cst.VariableCS;

/**
 * FIXME Might need to support init expressions for variables!
 * @author artem
 */
public class DeclaredParameter {

    private final VariableCS variableCS;
	private final TypeHelper type;

	public DeclaredParameter(VariableCS variableCS) {
		this.variableCS = variableCS;
		type = new TypeHelper(variableCS.getTypeCS());
    }

	public EClassifier getTypeForName(ExecutionContext ctx) {
		return type.getTypeForName(ctx);
	}

	public String getTypeName() {
		return type.getName();
	}

	public String getVarName() {
		return variableCS.getName();
	}

	public static DeclaredParameter[] create(List<VariableCS> p) {
		final DeclaredParameter[] params = new DeclaredParameter[p.size()];
		int i = 0;
		for (VariableCS v : p) {
			params[i++] = new DeclaredParameter(v);
		}
		return params;
	}
}
