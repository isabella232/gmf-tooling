/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - added uri and uriFragment helpers
 */
package org.eclipse.gmf.internal.codegen.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.ocl.util.CollectionUtil;

public class EMFUtils {

	@Operation(contextual = false, kind = Kind.HELPER)
	public static List<EObject> getReferencingObjects(EObject target) {
		Collection<EStructuralFeature.Setting> settings = CrossReferencer.find(target.eResource().getContents()).get(target);
		if (settings == null) {
			return CollectionUtil.<EObject> createNewSequence(Collections.<EObject> emptyList());
		}
		List<EObject> result = new ArrayList<EObject>();
		for (Setting setting : settings) {
			result.add(setting.getEObject());
		}
		return CollectionUtil.<EObject> createNewSequence(result);
	}

	@Operation(contextual = true, kind = Kind.QUERY)
	public String uriFragment(EObject target) {
		if (target.eResource() == null) {
			return String.valueOf(System.identityHashCode(target)); // anything will do, identityHashCode just for personal amusement.
		}
		return target.eResource().getURIFragment(target);
	}

	@Operation(contextual = true, kind = Kind.QUERY)
	public String uri(EObject target) {
		String fragment = uriFragment(target);
		if (target.eResource() == null) {
			return fragment;
		}
		return target.eResource().getURI().appendFragment(fragment).toString();
	}
}