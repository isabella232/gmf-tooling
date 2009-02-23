/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.util;

import org.eclipse.gmf.internal.common.codegen.Conversions;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

public class CodeGenerationUtils {

	@Operation(contextual = false, kind = Kind.HELPER)
	public static String toStringLiteral(String stringValue) {
		return Conversions.toStringLiteral(stringValue);
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public static String escapeXML(String stringValue) {
		return org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(stringValue);
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public static String safeName(String name) {
		return org.eclipse.emf.codegen.util.CodeGenUtil.safeName(name);
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public static String validJavaIdentifier(String identifier) {
		return org.eclipse.emf.codegen.util.CodeGenUtil.validJavaIdentifier(identifier);
	}

}
