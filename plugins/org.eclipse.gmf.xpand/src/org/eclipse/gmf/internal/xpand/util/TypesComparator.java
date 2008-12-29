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
package org.eclipse.gmf.internal.xpand.util;

import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

public final class TypesComparator implements Comparator<List<? extends EClassifier>> {

	private final EcoreEnvironment env;

	public TypesComparator(EcoreEnvironment env) {
		this.env = env;
	}
	
	/**
     * 
     * returns -1 if the second list of types is not assignable to the first
     * list of types returns 0 if the second list of types exactly matches the
     * first list of types returns 1 if the second list of types is assignable
     * to the first list of types
     */
    public int compare(final List<? extends EClassifier> types1, final List<? extends EClassifier> types2) {
        if ((types1 == null) || (types2 == null)) {
			throw new NullPointerException();
		}
        if (types1.size() != types2.size()) {
			return -1;
		}
        boolean directMatch = true;
        for (int i = 0, x = types1.size(); i < x; i++) {
            final EClassifier type1 = TypeUtil.resolveType(env, types1.get(i));
            final EClassifier type2 = TypeUtil.resolveType(env, types2.get(i));
            int rel = BuiltinMetaModel.getRelationship(env, type1, type2);
            if ((rel & UMLReflection.SUBTYPE) != 0) {
            	if (rel != UMLReflection.SAME_TYPE) {
            		 // sic! Update directMatch *conditionally*
            		directMatch = false;
            	}
            } else {
				return -1;
			}
        }
        if (directMatch) {
			return 0;
		} else {
			return 1;
		}
    }

}