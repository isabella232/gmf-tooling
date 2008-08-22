/**
 * Copyright (c) 2007 Borland Software Corporation
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.qvtlibraries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;

public class XpandIntegerOperations {

	public static class Metainfo {

		private static final String INTEGER_CONTEXT = Activator.OCL_LIBRARY_PACKAGE + Activator.OCL_PATH_SEPARATOR + PrimitiveType.INTEGER_NAME;

		private static final String SEQUENCE_OF_INTEGER = SequenceType.SINGLETON_NAME + "(" + PrimitiveType.INTEGER_NAME + ")"; //$NON-NLS-1$ //$NON-NLS-2$

		private static final String[] INT_UP_TO = new String[] { INTEGER_CONTEXT, PrimitiveType.INTEGER_NAME, SEQUENCE_OF_INTEGER };

		public static String[] xpandUpTo(Integer self, Integer parameter) {
			return INT_UP_TO;
		}
	}

	public List<Integer> xpandUpTo(Integer self, Integer parameter) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int l1 = self.intValue(), l2 = parameter.intValue(); l1 <= l2; l1++) {
			result.add(new Integer(l1));
		}
		return result;
	}

}
