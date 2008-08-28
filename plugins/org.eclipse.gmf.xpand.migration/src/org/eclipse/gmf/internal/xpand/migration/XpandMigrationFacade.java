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

import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.ast.AbstractDefinition;
import org.eclipse.gmf.internal.xpand.ast.ExpressionStatement;
import org.eclipse.gmf.internal.xpand.ast.ImportDeclaration;
import org.eclipse.gmf.internal.xpand.ast.NamespaceImport;
import org.eclipse.gmf.internal.xpand.ast.Statement;
import org.eclipse.gmf.internal.xpand.ast.Template;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.expression.ast.StringLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.gmf.internal.xpand.migration.MigrationException.Type;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;

public class XpandMigrationFacade {

	private ResourceManager resourceManager;

	private String resourceName;

	private boolean migrateAspect;

	// private Stack<AbstractImportsManager> importsManagers = new
	// Stack<AbstractImportsManager>();
	//	
	// private StandardLibraryImports stdLibImportsManager;

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
		MigrationExecutionContext ctx = new MigrationExecutionContextImpl(resourceManager).<MigrationExecutionContext> cloneWithResource(xpandResource);
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

		IDocument document = new Document(originalContent.toString());
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
		StandardLibraryImports stdLibImportsManager = new StandardLibraryImports(0);
		ModeltypeImports modeltypeImportsManger = new ModeltypeImports(0, true);
		TypeManager typeManager = new TypeManager(modeltypeImportsManger);

		
		MultiTextEdit edit = new MultiTextEdit();
		// importsManagers.push(stdLibImportsManager = new
		// StandardLibraryImports(getOutput()));
		addLibraryImports(xpandTemplate, edit);
		addNamespaceImports(xpandTemplate, edit);

		for (XpandDefinition definition : xpandTemplate.getDefinitions()) {
			assert definition instanceof AbstractDefinition;
			migrateDefinition((AbstractDefinition) definition, typeManager, stdLibImportsManager, ctx, edit);
		}
		
		addStandardLibraries(stdLibImportsManager, edit);
		addModeltypes(modeltypeImportsManger, edit);
		return edit;
	}

	private void addModeltypes(ModeltypeImports modeltypeImportsManger, MultiTextEdit edit) {
		// TODO Auto-generated method stub
		
	}

	private void addStandardLibraries(StandardLibraryImports stdLibImportsManager, MultiTextEdit edit) {
		// TODO Auto-generated method stub
	}

	private void migrateDefinition(AbstractDefinition definition, TypeManager typeManager, StandardLibraryImports stdLibManager, MigrationExecutionContext ctx, MultiTextEdit edit) throws MigrationException {
		VariableNameDispatcher variableNameDispatcher = new VariableNameDispatcher(definition);
		for (Statement statement : definition.getBody()) {
			if (statement instanceof ExpressionStatement) {
				migrateExpressionStatement((ExpressionStatement) statement, typeManager, stdLibManager, variableNameDispatcher, ctx, edit);
			}
		}
	}

	private void migrateExpressionStatement(ExpressionStatement statement, TypeManager typeManager, StandardLibraryImports stdLibManager, VariableNameDispatcher variableNameDispatcher, MigrationExecutionContext ctx, MultiTextEdit edit) throws MigrationException {
		ExpressionMigrationFacade expressionMF = new ExpressionMigrationFacade(statement.getExpression(), typeManager, stdLibManager, variableNameDispatcher, ctx);
		StringBuilder result = expressionMF.migrate();
		replaceInOriginalContent(statement.getExpression(), result.toString(), edit);
	}

	private void addNamespaceImports(Template xpandTemplate, MultiTextEdit edit) {
		for (NamespaceImport importDeclaration : xpandTemplate.getImports()) {
			StringLiteral importString = importDeclaration.getStringLiteral();
			replaceInOriginalContent(importString, migrateNamespaceImport(importString), edit);
		}
	}

	private StringBuilder migrateNamespaceImport(StringLiteral importString) {
		// TODO: write migration code here
		StringBuilder result = new StringBuilder("\"" + importString.getValue() + "\"");
		return result;
	}

	private void addLibraryImports(Template xpandTemplate, MultiTextEdit edit) {
		for (ImportDeclaration importDeclaration : xpandTemplate.getExtensions()) {
			Identifier importString = importDeclaration.getImportString();
			replaceInOriginalContent(importString, migrateLibraryImport(importString), edit);
		}
	}

	private StringBuilder migrateLibraryImport(Identifier importString) {
		// TODO: write migration code here
		StringBuilder result = new StringBuilder(importString.getValue());
		return result;
	}

	private void replaceInOriginalContent(SyntaxElement syntaxElement, CharSequence replacement, MultiTextEdit edit) {
		ReplaceEdit replaceEdit = new ReplaceEdit(syntaxElement.getStartOffset(), syntaxElement.getEndOffset() + 1 - syntaxElement.getStartOffset(), replacement.toString());
		edit.addChild(replaceEdit);
	}

}
