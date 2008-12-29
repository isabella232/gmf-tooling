/*
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.internal.xpand.model;

public interface XpandAdvice {

    public boolean matches(XpandDefinition def, ExecutionContext ctx);

    public void evaluate(ExecutionContext ctx);

}
