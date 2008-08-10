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
package org.eclipse.gmf.internal.xpand.model;

import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.ResourceMarker;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtExtension;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 * XXX would be great to have some cancellation behavior available from environment (i.e. for debuger to be able to stop execution)
 */
public interface ExecutionContext {

	public final static String IMPLICIT_VARIABLE = "this";

	ExecutionContext cloneWithVariable(Variable... v);

	ExecutionContext cloneWithResource(ResourceMarker ns);

	Variable getVariable(String name);

	Set<QvtExtension> getAllExtensions();

	// may return null if no definition found
	XpandDefinition findDefinition(String name, EClassifier target, EClassifier[] paramTypes);
	
	EcoreEnvironment getOCLEnvironment();
	void populate(EcoreEvaluationEnvironment ee);

	Scope getScope();

}
