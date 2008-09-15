/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.migration;

import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.ast.AbstractDefinition;
import org.eclipse.gmf.internal.xpand.ast.Advice;
import org.eclipse.gmf.internal.xpand.ast.ExpressionStatement;
import org.eclipse.gmf.internal.xpand.ast.ImportDeclaration;
import org.eclipse.gmf.internal.xpand.ast.NamespaceImport;
import org.eclipse.gmf.internal.xpand.ast.Statement;
import org.eclipse.gmf.internal.xpand.ast.Template;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.ast.DeclaredParameter;
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.gmf.internal.xpand.migration.MigrationException.Type;
import org.eclipse.gmf.internal.xpand.model.XpandAdvice;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;

public class XpandMigrationFacade {

	private ResourceManager resourceManager;

	private String resourceName;

	private boolean migrateAspect;

	private Document document;

	public XpandMigrationFacade(ResourceManager resourceManager, String xtendResourceName, boolean migrateAspect) {
		this.resourceManager = resourceManager;
		resourceName = xtendResourceName;
		this.migrateAspect = migrateAspect;
	}

	public String migrateXpandResource() throws MigrationException {
		StringBuilder originalContent = new StringBuilder();
		try {
			if (migrateAspect) {
				throw new MigrationException(Type.UNSUPPORTED_ASPECT, "Aspect migration is not supported now");
			}
			Reader[] readers = resourceManager.resolveMultiple(resourceName, XpandResource.TEMPLATE_EXTENSION);
			assert readers.length > 0;
			Reader mainReader = readers[0];
			for (int ch = mainReader.read(); ch != -1; ch = mainReader.read()) {
				originalContent.append((char) ch);
			}
		} catch (IOException e) {
			throw new MigrationException(Type.RESOURCE_NOT_FOUND, "Unable to load resource: " + resourceName);
		}

		XpandResource xpandResource = resourceManager.loadXpandResource(resourceName);
		if (xpandResource == null) {
			throw new MigrationException(Type.RESOURCE_NOT_FOUND, "Unable to load resource: " + resourceName);
		}
		MigrationExecutionContext ctx = new MigrationExecutionContextImpl(resourceManager).<MigrationExecutionContext>cloneWithResource(xpandResource);
		Set<AnalysationIssue> issues = new HashSet<AnalysationIssue>();
		xpandResource.analyze(ctx, issues);
		if (issues.size() > 0) {
			throw new MigrationException(issues);
		}
		// TODO: decompose xpand resource here and use only first one
		if (false == xpandResource instanceof Template) {
			throw new MigrationException(Type.UNSUPPORTED_XPAND_RESOURCE, "Only Template instances are supported, but loaded: " + xpandResource);
		}
		Template xpandTemplate = (Template) xpandResource;

		document = new Document(originalContent.toString());
		TextEdit edit = migrate(xpandTemplate, ctx);
		try {
			edit.apply(document);
		} catch (MalformedTreeException e) {
			throw new MigrationException(Type.UNABLE_TO_APPLY_EDIT, e.getMessage());
		} catch (BadLocationException e) {
			throw new MigrationException(Type.UNABLE_TO_APPLY_EDIT, e.getMessage());
		}
		return document.get();
	}

	private TextEdit migrate(Template xpandTemplate, MigrationExecutionContext ctx) throws MigrationException {
		MultiTextEdit edit = new MultiTextEdit();
		StandardLibraryImports stdLibImportsManager = new StandardLibraryImports(getStdLibImportsPosition(xpandTemplate));
		TypeManager typeManager = new TypeManager();

		for (XpandDefinition definition : xpandTemplate.getDefinitions()) {
			assert definition instanceof AbstractDefinition;
			migrateDefinition((AbstractDefinition) definition, typeManager, stdLibImportsManager, ctx, edit);
		}
		
		for (XpandAdvice advice : xpandTemplate.getAdvices()) {
			assert advice instanceof Advice;
			migrateDefinition((Advice) advice, typeManager, stdLibImportsManager, ctx, edit);
		}
		
		injectStdlibImports(stdLibImportsManager, edit);
		return edit;
	}

	// TODO: use RangeMarker instead?
	private int getStdLibImportsPosition(Template xpandTemplate) {
		int offset = 0;
		if (xpandTemplate.getExtensions().length > 0) {
			ImportDeclaration[] extensions = xpandTemplate.getExtensions();
			offset = extensions[extensions.length - 1].getEndOffset();
		} else if (xpandTemplate.getImports().length > 0) {
			NamespaceImport[] imports = xpandTemplate.getImports();
			offset =  imports[imports.length - 1].getEndOffset();
		}
		if (offset > 0) {
			try {
				for (; !"»".equals(document.get(offset, 1)); offset++) {
				}
				offset++;
			} catch (BadLocationException e) {
				offset = 0;
			}
		}
		return offset;
	}

	private void injectStdlibImports(StandardLibraryImports stdLibImportsManager, MultiTextEdit edit) {
		if (stdLibImportsManager.getLibraries().length == 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		if (stdLibImportsManager.getPlaceholderIndex() > 0) {
			sb.append(ExpressionMigrationFacade.LF);
		}
		for (String stdLib : stdLibImportsManager.getLibraries()) {
			sb.append("«EXTENSION ");
			sb.append(stdLib);
			sb.append("»");
		}
		if (stdLibImportsManager.getPlaceholderIndex() == 0) {
			sb.append(ExpressionMigrationFacade.LF);
		}
		insert(stdLibImportsManager.getPlaceholderIndex(), sb, edit);
	}

	private void migrateDefinition(AbstractDefinition definition, TypeManager typeManager, StandardLibraryImports stdLibManager, MigrationExecutionContext ctx, MultiTextEdit edit) throws MigrationException {
		for (DeclaredParameter parameter : definition.getParams()) {
			migrateParameter(parameter, ctx, typeManager, edit);
		}
		
		VariableNameDispatcher variableNameDispatcher = new VariableNameDispatcher(definition);
		for (Statement statement : definition.getBody()) {
			if (statement instanceof ExpressionStatement) {
				migrateExpressionStatement((ExpressionStatement) statement, typeManager, stdLibManager, variableNameDispatcher, ctx, edit);
			}
		}
	}

	private void migrateParameter(DeclaredParameter parameter, MigrationExecutionContext ctx, TypeManager typeManager, MultiTextEdit edit) throws MigrationException {
		EClassifier parameterType = ctx.getTypeForName(parameter.getType().getValue());
		replace(parameter, parameter.getName().getValue() + " : " + typeManager.getQvtFQName(parameterType), edit);
	}

	private void migrateExpressionStatement(ExpressionStatement statement, TypeManager typeManager, StandardLibraryImports stdLibManager, VariableNameDispatcher variableNameDispatcher, MigrationExecutionContext ctx, MultiTextEdit edit) throws MigrationException {
		ExpressionMigrationFacade expressionMF = new ExpressionMigrationFacade(statement.getExpression(), typeManager, stdLibManager, variableNameDispatcher, ctx);
		StringBuilder result = expressionMF.migrate();
		replace(statement.getExpression(), result.toString(), edit);
	}

	private void replace(SyntaxElement syntaxElement, CharSequence replacement, MultiTextEdit edit) {
		ReplaceEdit replaceEdit = new ReplaceEdit(syntaxElement.getStartOffset(), syntaxElement.getEndOffset() + 1 - syntaxElement.getStartOffset(), replacement.toString());
		edit.addChild(replaceEdit);
	}
	
	private void insert(int position, CharSequence text, MultiTextEdit edit) {
		InsertEdit insertEdit = new InsertEdit(position, text.toString());
		edit.addChild(insertEdit);
	}

}
