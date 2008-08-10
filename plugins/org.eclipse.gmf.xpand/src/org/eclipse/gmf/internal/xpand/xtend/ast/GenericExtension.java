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

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;

public interface GenericExtension {

	String getName();
	
	String getFileName();
	
	EClassifier getContext();
	EOperation getOperation();

	// XXX odd parameters param, as if return type may depend from them?
	EClassifier getReturnType(final EClassifier[] parameters, ExecutionContext ctx, final Set<AnalysationIssue> issues);

	List<EClassifier> getParameterTypes();
	
	List<String> getParameterNames();

	void init(final ExecutionContext ctx);
	
	Object evaluate(final Object[] parameters, ExecutionContext ctx);

}
