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
package org.eclipse.gmf.internal.xpand.qvtlibraries;

import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

public class XpandGlobalVars {

	@Operation(contextual = false, kind = Kind.HELPER)
	public static String xpandGetStringGlobalVar(String varName) {
		Variable var = Activator.getDefault().getGlobalVars().get(varName);
		return var != null ? String.valueOf(var.getValue()) : null;
	}
	
	public static Object xpandGetObjectGlobalVar(String varName) {
		Variable var = Activator.getDefault().getGlobalVars().get(varName);
		return var != null ? var.getValue() : null;
	}

}
