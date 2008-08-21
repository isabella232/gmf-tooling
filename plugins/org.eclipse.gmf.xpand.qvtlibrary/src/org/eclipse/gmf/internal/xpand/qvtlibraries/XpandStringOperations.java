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

public class XpandStringOperations {

	public static class Metainfo {

		private static final String STRING_CONTEXT = Activator.OCL_LIBRARY_PACKAGE + "::String"; //$NON-NLS-1$

		private static final String[] TO_FIRST_LOWER = new String[] { STRING_CONTEXT, "String" };

		public static String[] xpandToFirstLower(String self) {
			return TO_FIRST_LOWER;
		}
	}

	public String xpandToFirstLower(String self) {
		if ((self == null) || (self.length() == 0)) {
			return self;
		}
		char[] arr = self.toCharArray();
		arr[0] = Character.toLowerCase(arr[0]);
		return new String(arr);
	}

}
