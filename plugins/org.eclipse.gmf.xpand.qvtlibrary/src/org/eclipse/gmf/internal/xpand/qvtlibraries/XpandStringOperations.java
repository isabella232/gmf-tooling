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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;

public class XpandStringOperations {

	public static class Metainfo {

		private static final String STRING_CONTEXT = Activator.OCL_LIBRARY_PACKAGE + Activator.OCL_PATH_SEPARATOR + PrimitiveType.STRING_NAME;

		private static final String SEQUENCE_OF_STRING = SequenceType.SINGLETON_NAME + "(" + PrimitiveType.STRING_NAME + ")"; //$NON-NLS-1$ //$NON-NLS-2$

		private static final String[] TO_FIRST_LOWER = new String[] { STRING_CONTEXT, PrimitiveType.STRING_NAME };

		private static final String[] TO_CHAR_LIST = new String[] { STRING_CONTEXT, SEQUENCE_OF_STRING };

		private static final String[] SUBSTRING = new String[] { STRING_CONTEXT, PrimitiveType.INTEGER_NAME, PrimitiveType.STRING_NAME };

		private static final String[] REPLACE_ALL = new String[] { STRING_CONTEXT, PrimitiveType.STRING_NAME, PrimitiveType.STRING_NAME, PrimitiveType.STRING_NAME };

		private static final String[] REPLACE_FIRST = new String[] { STRING_CONTEXT, PrimitiveType.STRING_NAME, PrimitiveType.STRING_NAME, PrimitiveType.STRING_NAME };

		private static final String[] SPLIT = new String[] { STRING_CONTEXT, PrimitiveType.STRING_NAME, SEQUENCE_OF_STRING };

		private static final String[] MATCHES = new String[] { STRING_CONTEXT, PrimitiveType.STRING_NAME, PrimitiveType.BOOLEAN_NAME };

		public static String[] xpandToFirstLower(String self) {
			return TO_FIRST_LOWER;
		}

		public static String[] xpandToCharList(String self) {
			return TO_CHAR_LIST;
		}

		public static String[] xpandSubstring(String self, Integer beginIndex) {
			return SUBSTRING;
		}

		public static String[] xpandReplaceAll(String self, String regex, String replacement) {
			return REPLACE_ALL;
		}

		public static String[] xpandReplaceFirst(String self, String regex, String replacement) {
			return REPLACE_FIRST;
		}

		public static String[] xpandSplit(String self, String regex) {
			return SPLIT;
		}

		public static String[] xpandMatches(String self, String regex) {
			return MATCHES;
		}

		public static String[] xpandStartsWith(String self, String prefix) {
			return MATCHES;
		}

		public static String[] xpandEndsWith(String self, String suffix) {
			return MATCHES;
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

	public List<String> xpandToCharList(String self) {
		ArrayList<String> rv = new ArrayList<String>(self.length());
		for (int i = 0; i < self.length(); i++) {
			rv.add(self.substring(i, i + 1));
		}
		return rv;
	}

	public String xpandSubstring(String self, Integer beginIndex) {
		return self.substring(beginIndex);
	}

	public String xpandReplaceAll(String self, String regex, String replacement) {
		return self.replaceAll(regex, replacement);
	}

	public String xpandReplaceFirst(String self, String regex, String replacement) {
		return self.replaceFirst(regex, replacement);
	}

	public List<String> xpandSplit(String self, String regex) {
		return Arrays.asList(self.split(regex));
	}

	public Boolean xpandMatches(String self, String regex) {
		return self.matches(regex);
	}

	public Boolean xpandStartsWith(String self, String prefix) {
		return self.startsWith(prefix);
	}

	public Boolean xpandEndsWith(String self, String suffix) {
		return self.endsWith(suffix);
	}

}
