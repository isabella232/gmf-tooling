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

import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.gmf.internal.xpand.ocl.TypeHelper;
import org.eclipse.ocl.cst.PathNameCS;

/**
 * @author Sven Efftinge
 */
public class ImportDeclaration extends SyntaxElement {

    private final String importString;

    public ImportDeclaration(final int start, final int end, final int line, final PathNameCS importString) {
        super(start, end, line);
        this.importString = TypeHelper.toString(importString);
    }

    public String getImportString() {
        return importString;
    }
}
