/**
 * Copyright (c) 2007 Borland Software Corporation
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.qvtlibraries;

import java.util.List;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.ocl.util.CollectionUtil;

public class XpandIntegerOperations {

	@Operation(contextual = true, kind = Kind.HELPER)
	public static List<Integer> xpandUpTo(Integer self, Integer parameter) {
		List<Integer> result = CollectionUtil.<Integer> createNewSequence();
		for (int l1 = self.intValue(), l2 = parameter.intValue(); l1 <= l2; l1++) {
			result.add(new Integer(l1));
		}
		return result;
	}

}
