/*
 * Copyright (c) 2005, 2009 Sven Efftinge and others.
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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.gmf.internal.xpand.ast.analyze.UnusedMetamodelsCollector;
import org.eclipse.gmf.internal.xpand.ast.analyze.UnusedModulesCollector;
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.XpandAdvice;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtResource;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;

/**
 * XXX why it's SyntaxElement? What does 'getLine()' means?
 * 
 * @author Sven Efftinge
 */
public class Template extends SyntaxElement implements XpandResource {

	private final NamespaceImport[] imports;

	private final Definition[] definitions;

	private final ImportDeclaration[] extensions;

	private final Advice[] advices;

	private String qualifiedName;

	private String[] importStrings = null;

	private String[] importedExtensions = null;

	public Template(final int start, final int end, final int line, final NamespaceImport[] imports, final ImportDeclaration[] extensions, final Definition[] definitions, final Advice[] advices) {
		super(start, end, line);
		this.imports = imports;
		this.extensions = extensions;
		for (Definition element : definitions) {
			element.setOwner(this);
		}
		this.definitions = definitions;
		for (Advice element : advices) {
			element.setOwner(this);
		}
		this.advices = advices;
	}

	public String getFullyQualifiedName() {
		// XXX what's the reason to have both file name and qualified name?
		return qualifiedName == null ? getFileName() : qualifiedName;
	}

	public void setFullyQualifiedName(String name) {
		qualifiedName = name;
	}

	public XpandDefinition[] getDefinitions() {
		return definitions;
	}

	public void analyze(ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		ctx = ctx.cloneWithResource(this);
		// for (ImportDeclaration importDeclaration : extensions) {
		// QvtResource extension =
		// ctx.getScope().findExtension(importDeclaration.getImportString());
		// if (extension == null) {
		// issues.add(new
		// AnalysationIssue(AnalysationIssue.Type.EXTENSION_NOT_FOUND,
		// "Couldn't find " + importDeclaration.getImportString(),
		// importDeclaration));
		// } else {
		// for (Module module : extension.getModules()) {

		// }
		// }
		// }
		//		
		for (Definition element : definitions) {
			element.analyze(ctx, issues);
		}
		for (Advice element : advices) {
			element.analyze(ctx, issues);
		}

		Map<Module, ImportDeclaration> module2ImportDeclarationMap = new LinkedHashMap<Module, ImportDeclaration>();
		for (ImportDeclaration importDeclaration : extensions) {
			QvtResource extension = ctx.getScope().findExtension(importDeclaration.getImportString());
			if (extension == null) {
				issues.add(new AnalysationIssue(AnalysationIssue.Type.EXTENSION_NOT_FOUND, "Couldn't find " + importDeclaration.getImportString(), importDeclaration));
			} else {
				for (Module module : extension.getModules()) {
					module2ImportDeclarationMap.put(module, importDeclaration);
				}
			}
		}

		Map<EPackage, NamespaceImport> ePackage2NapespaceImportMap = new LinkedHashMap<EPackage, NamespaceImport>();
		Registry packageRegistry = ctx.getScope().createPackageRegistry(getImportedNamespaces());
		for (NamespaceImport namespaceImport : imports) {
			if (!packageRegistry.containsKey(namespaceImport.getImportString())) {
				issues.add(new AnalysationIssue(AnalysationIssue.Type.NAMESPACE_NOT_FOUND, "Couldn't find " + namespaceImport.getImportString(), namespaceImport));
			} else {
				ePackage2NapespaceImportMap.put(packageRegistry.getEPackage(namespaceImport.getImportString()), namespaceImport);
			}
		}
		
		addWarnings(module2ImportDeclarationMap, ePackage2NapespaceImportMap, ctx, issues);
	}

	private void addWarnings(Map<Module, ImportDeclaration> module2ImportDeclarationMap, Map<EPackage, NamespaceImport> ePackage2NapespaceImportMap, ExecutionContext ctx, Set<AnalysationIssue> issues) {
		UnusedModulesCollector unusedModulesCollector = new UnusedModulesCollector(module2ImportDeclarationMap.keySet());
		UnusedMetamodelsCollector unusedMetamodelsCollector = new UnusedMetamodelsCollector(ePackage2NapespaceImportMap.keySet(), ctx);
		new AstIterator(new CompositeAstVisitor(unusedModulesCollector, unusedMetamodelsCollector)).iterate(this);
		for (Module unusedModule : unusedModulesCollector.getUnusedModules()) {
			ImportDeclaration importDeclaration = module2ImportDeclarationMap.get(unusedModule);
			issues.add(new AnalysationIssue(AnalysationIssue.Type.UNUSED_IMPORT, "Extension " + importDeclaration.getImportString() + " is never used", importDeclaration, true));
		}
		for (EPackage unusedEPackage : unusedMetamodelsCollector.getUnusedEPackages()) {
			NamespaceImport namespaceImport = ePackage2NapespaceImportMap.get(unusedEPackage);
			issues.add(new AnalysationIssue(AnalysationIssue.Type.UNUSED_IMPORT, "Import " + namespaceImport.getImportString() + " is never used", namespaceImport, true));
		}
	}

	// XXX is it really worth it to kepp imports as ast nodes?
	// Is it performance gain to duplicate them here with string[]?
	public String[] getImportedNamespaces() {
		if (importStrings == null) {
			importStrings = new String[imports.length];
			for (int i = 0; i < importStrings.length; i++) {
				importStrings[i] = imports[i].getImportString();
			}
		}
		return importStrings;
	}

	public String[] getImportedExtensions() {
		if (importedExtensions == null) {
			importedExtensions = new String[extensions.length];
			for (int i = 0; i < extensions.length; i++) {
				importedExtensions[i] = extensions[i].getImportString();
			}
		}
		return importedExtensions;
	}

	public XpandAdvice[] getAdvices() {
		return advices;
	}

}
