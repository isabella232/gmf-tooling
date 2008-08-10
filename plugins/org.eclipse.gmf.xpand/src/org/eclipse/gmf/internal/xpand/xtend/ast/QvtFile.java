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
package org.eclipse.gmf.internal.xpand.xtend.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.runtime.util.NonTransformationExecutionContext;

public class QvtFile implements QvtResource {

	private CompiledModule compiledModule;
	private List<QvtExtension> extensions;
	private String fileName;

	public QvtFile(CompiledModule module, String fullyQualifiedName) {
		this.compiledModule = module;
		fileName = fullyQualifiedName;
	}

	public QvtOperationalEnv getEnvironment() {
		return compiledModule.getSyntaxElement().getEnvironment();
	}
	public List<QvtExtension> getExtensions() {
		if (extensions == null && compiledModule.getErrors().length == 0) {
			extensions = new ArrayList<QvtExtension>();
			Module module = compiledModule.getModule();
			if (module != null) {
				NonTransformationExecutionContext context = new NonTransformationExecutionContext(Collections.singleton(module));
				for (EOperation operation : module.getEOperations()) {
					if (operation instanceof Helper) {
						extensions.add(new QvtExtension(context.createHelperCall((Helper) operation), this, fileName));
					}
				}
			}
		}
		return extensions;
	}

	public void analyze(ExecutionContext ctx, Set<AnalysationIssue> issues) {
		if (compiledModule.getErrors().length > 0) {
			for (int i = 0; i < compiledModule.getErrors().length; i++) {
				QvtMessage qvtMessage = compiledModule.getErrors()[i];
				if (qvtMessage.getSeverity() == QvtMessage.SEVERITY_ERROR) {
					issues.add(new AnalysationIssue(AnalysationIssue.Type.SYNTAX_ERROR, qvtMessage.toString(), (SyntaxElement) null));
				}
			}
		}
	}

	public String[] getImportedExtensions() {
		// no-op now, not sure it's possible to use this data
		return new String[0];
	}

	public String[] getImportedNamespaces() {
		// no-op now, not sure it's possible to use this data
		return new String[0];
	}
}
