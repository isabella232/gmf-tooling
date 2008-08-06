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

import org.eclipse.gmf.internal.xpand.ResourceMarker;

public interface XpandResource extends XpandAnalyzable, ResourceMarker {
	public static final String TEMPLATE_EXTENSION = "xpt";

	String getFullyQualifiedName(); // [artem] from Resource XXX reconsider - almost useless?

    XpandDefinition[] getDefinitions();

    XpandAdvice[] getAdvices();
}
