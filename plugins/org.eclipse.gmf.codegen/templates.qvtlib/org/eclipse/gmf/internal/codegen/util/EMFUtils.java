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

}