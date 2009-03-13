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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.NonTransformationExecutionContext;

public class QvtFile implements QvtResource {

	private List<QvtExtension> extensions;

	private final String fileName;

	private final Set<Module> modules;

	private QvtMessage[] errors = new QvtMessage[0];

	/**
	 * Can be used for creating QvtFile around modules came from BlackBox
	 * extension point. In this case modules has no errors if they was loaded
	 * successfully.
	 */
	public QvtFile(List<Module> modules, String fullyQualifiedName) {
		this.modules = new LinkedHashSet<Module>(modules);
		fileName = fullyQualifiedName;
	}
	public QvtFile(CompiledUnit cu, String fullyQualifiedName) {
		this(cu.getModules(), fullyQualifiedName);
		List<QvtMessage> allErrors = cu.getErrors();
		errors = allErrors.toArray(new QvtMessage[allErrors.size()]);
	}

	public Set<Module> getModules() {
		return modules;
	}

	public List<QvtExtension> getExtensions() {
		if (extensions == null && errors.length == 0) {
			extensions = new ArrayList<QvtExtension>();
			if (getModules() != null) {
				NonTransformationExecutionContext context = new NonTransformationExecutionContext(getModules());
				for (Module module : getModules()) {
					for (EOperation operation : module.getEOperations()) {
						if (operation instanceof Helper) {
							extensions.add(new QvtExtension(context.createHelperCall((Helper) operation), this, fileName));
						}
					}
				}
			}
		}
		return extensions;
	}

	public void analyze(ExecutionContext ctx, Set<AnalysationIssue> issues) {
		if (errors.length > 0) {
			for (int i = 0; i < errors.length; i++) {
				QvtMessage qvtMessage = errors[i];
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
