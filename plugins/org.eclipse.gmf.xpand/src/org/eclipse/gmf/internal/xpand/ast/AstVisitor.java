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

public interface AstVisitor {

	boolean visit(Template template);

	boolean visit(XpandAdvice advice);

	boolean visit(XpandDefinition definition);

	boolean visit(ErrorStatement statement);

	boolean visit(ExpandStatement statement);

	boolean visit(ExpressionStatement statement);

	boolean visit(FileStatement statement);

	boolean visit(ForEachStatement statement);

	boolean visit(IfStatement statement);

	boolean visit(LetStatement statement);

	boolean visit(ProtectStatement statement);

	boolean visit(TextStatement statement);

	boolean visit(Statement statement);

}
