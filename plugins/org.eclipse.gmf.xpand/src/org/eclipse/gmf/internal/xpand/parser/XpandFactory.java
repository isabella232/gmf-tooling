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
package org.eclipse.gmf.internal.xpand.parser;

import java.util.List;

import lpg.runtime.IToken;

import org.eclipse.gmf.internal.xpand.ast.Advice;
import org.eclipse.gmf.internal.xpand.ast.Definition;
import org.eclipse.gmf.internal.xpand.ast.ErrorStatement;
import org.eclipse.gmf.internal.xpand.ast.ExpandStatement;
import org.eclipse.gmf.internal.xpand.ast.ExpressionStatement;
import org.eclipse.gmf.internal.xpand.ast.FileStatement;
import org.eclipse.gmf.internal.xpand.ast.ForEachStatement;
import org.eclipse.gmf.internal.xpand.ast.IfStatement;
import org.eclipse.gmf.internal.xpand.ast.ImportDeclaration;
import org.eclipse.gmf.internal.xpand.ast.LetStatement;
import org.eclipse.gmf.internal.xpand.ast.NamespaceImport;
import org.eclipse.gmf.internal.xpand.ast.ProtectStatement;
import org.eclipse.gmf.internal.xpand.ast.Statement;
import org.eclipse.gmf.internal.xpand.ast.Template;
import org.eclipse.gmf.internal.xpand.ast.TextStatement;
import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.gmf.internal.xpand.ocl.DeclaredParameter;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;

/**
 * @author Sven Efftinge
 */
public class XpandFactory {

	private final String fileName;

	public XpandFactory(final String fileName) {
		this.fileName = fileName;
	}

	public Template createTemplate(final List<NamespaceImport> imports, final List<ImportDeclaration> extensions, final List<Definition> defines, final List<Advice> advices, final IToken eof) {
		final NamespaceImport[] i = imports.toArray(new NamespaceImport[imports.size()]);
		final ImportDeclaration[] ext = extensions.toArray(new ImportDeclaration[extensions.size()]);

		final Definition[] d = defines.toArray(new Definition[defines.size()]);
		final Advice[] a = advices.toArray(new Advice[advices.size()]);
		final Template t = new Template(0, end(eof), 0, i, ext, d, a);
		return handle(t);
	}

	public Definition createDefinition(final IToken startToken, final IToken endToken, final IToken n, final List<VariableCS> p, final TypeCS type, final List<Statement> s) {
		final int start = start(startToken);
		final int end = end(endToken);
		final int line = line(startToken);
		final Identifier name = createIdentifier(n);
		final Statement[] body = s.toArray(new Statement[s.size()]);
		return handle(new Definition(start, end, line, name, type, DeclaredParameter.create(p), body));
	}

	public TextStatement createTextStatement(final IToken t, final IToken m) {
		String text = t.toString();
		if (text.length() > 1) {
			text = text.substring(1, text.length() - 1);
		} else {
			text = "";
		}
		return handle(new TextStatement(start(m != null ? m : t), end(t), line(m != null ? m : t), text, m != null));
	}

	public ForEachStatement createForEachStatement(final IToken start, final IToken end, final OCLExpressionCS e, final IToken v, final OCLExpressionCS sep, final IToken iter, final List<SyntaxElement> s) {
		final Statement[] body = s.toArray(new Statement[s.size()]);
		return handle(new ForEachStatement(start(start), end(end), line(start), createIdentifier(v), e, body, sep, iter != null ? createIdentifier(iter) : null));
	}

	public IfStatement createIfStatement(final IToken start, final OCLExpressionCS condition, final List<SyntaxElement> statements, final IfStatement elseIf) {
		final Statement[] body = statements.toArray(new Statement[statements.size()]);
		final int end = body[body.length - 1].getEnd();
		return handle(new IfStatement(start(start), end, line(start), condition, body, elseIf));
	}

	public LetStatement createLetStatement(final IToken start, final IToken end, final OCLExpressionCS e, final IToken name, final List<SyntaxElement> statements) {
		final Statement[] body = statements.toArray(new Statement[statements.size()]);
		return handle(new LetStatement(start(start), end(end), line(start), createIdentifier(name), e, body));
	}

	public ErrorStatement createErrorStatement(final IToken start, final OCLExpressionCS expr) {
		return handle(new ErrorStatement(start(start), expr.getEndOffset(), line(start), expr));
	}

	public ExpressionStatement createExpressionStatement(final OCLExpressionCS e, int lineNumber) {
		return handle(new ExpressionStatement(e.getStartOffset(), e.getEndOffset(), lineNumber, e));
	}

	public FileStatement createFileStatement(final IToken start, final IToken end, final OCLExpressionCS fileName, final Identifier option, final List<SyntaxElement> statements) {
		final Statement[] body = statements.toArray(new Statement[statements.size()]);
		return handle(new FileStatement(start(start), end(end), line(start), fileName, body, option));
	}

	// FIXME disabled as token - no reason, just true/false 
	public ProtectStatement createProtectStatement(final IToken start, final IToken end, final OCLExpressionCS startC, final OCLExpressionCS endC, final OCLExpressionCS id, final IToken disabled, final List<SyntaxElement> statements) {
		final Statement[] body = statements.toArray(new Statement[statements.size()]);
		return handle(new ProtectStatement(start(start), end(end), line(start), startC, endC, body, id, disabled != null));
	}

	public ExpandStatement createExpandStatement(final IToken start, final PathNameCS definition, final List<OCLExpressionCS> parameters, final OCLExpressionCS target, final boolean foreach, final OCLExpressionCS sep) {
		final OCLExpressionCS[] params = parameters.toArray(new OCLExpressionCS[parameters.size()]);
		int end = definition.getEndOffset();
		if (sep != null) {
			end = sep.getEndOffset();
		} else if (target != null) {
			end = target.getEndOffset();
		} else if (params.length > 0) {
			end = params[params.length - 1].getEndOffset();
		}
		return handle(new ExpandStatement(start(start), end, line(start), definition, target, sep, params, foreach));
	}

	public NamespaceImport createNamespaceImport(IToken start, StringLiteralExpCS namespace) {
		return handle(new NamespaceImport(start(start), namespace.getEndOffset(), line(start), namespace));
	}

	public ImportDeclaration createImportDeclaration(final IToken start, final PathNameCS namespace) {
		return handle(new ImportDeclaration(start(start), namespace.getEndOffset(), line(start), namespace));
	}

	public Advice createAround(final IToken start, final IToken end, final Identifier n, final List<VariableCS> p, final boolean wildparams, final TypeCS t, final List<Statement> s) {
		final Statement[] body = s.toArray(new Statement[s.size()]);
		final Advice a = new Advice(start(start), end(end), line(start), n, t, DeclaredParameter.create(p), wildparams, body);
		return handle(a);
	}

	// copy from ExpressionFactory
	private <T extends SyntaxElement> T handle(final T expr) {
		expr.setFileName(fileName);
		return expr;
	}

	private static int end(final IToken c) {
		return c.getEndOffset();
	}

	private static int start(final IToken c) {
		return c.getStartOffset();
	}

	private static int line(final IToken c) {
		return c.getLine();
	}

	public Identifier createIdentifier(IToken name) {
		return new Identifier(start(name), end(name), line(name), name.toString());
	}
}
