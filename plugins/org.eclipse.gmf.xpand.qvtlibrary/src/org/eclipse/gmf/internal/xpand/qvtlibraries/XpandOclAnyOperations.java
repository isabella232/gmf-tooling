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

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

public class XpandOclAnyOperations {

	@Operation(contextual = true, kind = Kind.HELPER)
	public static Boolean xpandCompareTo(Object self, Object parameter) {
		if (self == null) {
			return parameter == null;
		}
		if (parameter == null) {
			return false;
		}
		if (self instanceof Comparable) {
			return ((Comparable) self).compareTo(parameter) == 0;
		}
		return String.valueOf(self).compareTo(String.valueOf(parameter)) == 0;

	}

}
