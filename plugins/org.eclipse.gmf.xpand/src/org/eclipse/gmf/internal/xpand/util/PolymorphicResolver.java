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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.model.AmbiguousDefinitionException;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.ocl.ecore.EcoreEnvironment;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class PolymorphicResolver {

	public static XpandDefinition filterDefinition(final HashMap<XpandDefinition, List<EClassifier>> resolvedDefs, EClassifier targetType, List<EClassifier> paramTypes, EcoreEnvironment env) throws AmbiguousDefinitionException {
        final List<EClassifier> allParams = new ArrayList<EClassifier>();
        allParams.add(targetType);
        allParams.addAll(paramTypes);

        final TypesComparator typesComparator = new TypesComparator(env);
        
        final List<XpandDefinition> candidateDefinition = new ArrayList<XpandDefinition>();
		for (XpandDefinition def : resolvedDefs.keySet()) {
            final List<? extends EClassifier> featureParamTypes = resolvedDefs.get(def);
            if ((featureParamTypes.size() == allParams.size())
                    && (typesComparator .compare(featureParamTypes, allParams) >= 0)) {
            	candidateDefinition.add(def);
            }
        }
		final Comparator<XpandDefinition> comparator = new Comparator<XpandDefinition>() {
	        public int compare(XpandDefinition d1, XpandDefinition d2) {
	            return typesComparator.compare(resolvedDefs.get(d1), resolvedDefs.get(d2));
	        }
	    };
	    try {
	    	return filterWithComparator(candidateDefinition, comparator);
	    } catch (IllegalStateException ex) {
	    	throw new AmbiguousDefinitionException(candidateDefinition.get(0), candidateDefinition.get(1));
	    }
	}

    /**
     * @throws IllegalStateException when there are more than one candidates with same priority
     */
    private static <T> T filterWithComparator(List<T> candidates, Comparator<T> comparator) throws IllegalStateException {
        if (candidates.size() == 1) {
			return candidates.get(0);
		} else if (candidates.isEmpty()) {
			return null;
		} else {
            // sort features by specialization
            Collections.sort(candidates, comparator);

            if (comparator.compare(candidates.get(1), candidates.get(0)) > 0) {
				return candidates.get(0);
			} else {
				throw new IllegalStateException();
			}
        }
    }
    
}
