/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    dvorak - initial API and implementation
 */
package org.eclipse.gmf.tests.validate;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.internal.validate.Annotations;


public class AnnotationUtil {
	
	public static final ConstraintHelper OCL = new ConstraintHelper(Annotations.OCL_KEY);
	public static final ConstraintHelper REGEXP = new ConstraintHelper(Annotations.REGEXP_KEY);

	private AnnotationUtil() {
		super();
	}
	
	public static Object getDiagnosticSource(Diagnostic diagnostic) {
		if(diagnostic.getData() != null && !diagnostic.getData().isEmpty()) {
			return diagnostic.getData().get(0);
		}
		return null;
	}
	
	public static Diagnostic getChildDiagnostic(Diagnostic diagnostic) {
		if(diagnostic.getChildren() != null && !diagnostic.getChildren().isEmpty()) {
			return diagnostic.getChildren().get(0);
		}
		return null;
	}
	
	public static Object getChildDiagnosticSource(Diagnostic diagnostic) {
		return getDiagnosticSource(getChildDiagnostic(diagnostic));
	}

	
	public static EAnnotation createAnnotation(EModelElement modelElement, String source) {
		assert modelElement != null;
		assert source != null;
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		modelElement.getEAnnotations().add(eAnnotation);

		eAnnotation.setSource(source);
		return eAnnotation;
	}
	

	public static EAnnotation addLanguageDefAnnotation(EStructuralFeature langFeature) {
		EAnnotation eAnnotation = createAnnotation(langFeature, Annotations.CONSTRAINTS_META_URI);
		eAnnotation.getDetails().put(Annotations.Meta.DEF_KEY, Annotations.Meta.LANG);
		return eAnnotation;
	}
	
	public static EAnnotation addBodyDefAnnotation(EStructuralFeature bodyFeature) {
		EAnnotation eAnnotation = createAnnotation(bodyFeature, Annotations.CONSTRAINTS_META_URI);
		eAnnotation.getDetails().put(Annotations.Meta.DEF_KEY, Annotations.Meta.BODY);
		return eAnnotation;
	}
	
	public static EAnnotation addContextRefAnnotation(EModelElement contextResolutionElement, String ctxRef) {
		EAnnotation eAnnotation = createAnnotation(contextResolutionElement, Annotations.CONSTRAINTS_META_URI);
		eAnnotation.getDetails().put(Annotations.Meta.DEF_KEY, Annotations.Meta.CONTEXT);
		eAnnotation.getDetails().put(Annotations.Meta.REF, ctxRef);
		return eAnnotation; 
	}
	
	public static EAnnotation addContextDefAnnotation(EModelElement contextResolutionElement, String oclExpression) {
		EAnnotation eAnnotation = createAnnotation(contextResolutionElement, Annotations.CONSTRAINTS_META_URI);
		eAnnotation.getDetails().put(Annotations.Meta.DEF_KEY, Annotations.Meta.CONTEXT);
		eAnnotation.getDetails().put(Annotations.OCL_KEY, oclExpression);
		return eAnnotation; 
	}	
	

	static Map.Entry<String, String> getDetailByKey(EAnnotation constraint, String key) {
		for (Map.Entry<String, String> entry : constraint.getDetails()) {
			if(key.equals(entry.getKey())) {
				return entry;
			}
		}
		return null;
	}		

	
	static class ConstraintHelper {
		private String lang;

		public ConstraintHelper(String lang) {
			super();
			this.lang = lang;
		}

		public Map.Entry<String, String> getConstraintBodyDetail(EAnnotation constraint) {
			return getDetailByKey(constraint, lang);
		}
		
		public Map.Entry<String, String> getConstraintDescDetail(EAnnotation constraint) {
			return getDetailByKey(constraint, Annotations.DESCRIPTION);
		}		

		public EAnnotation createConstraint(EModelElement modelElement, String body) {
			EAnnotation eAnnotation = createAnnotation(modelElement, Annotations.CONSTRAINTS_URI);
			eAnnotation.getDetails().put(lang, body);
			return eAnnotation;
		}
		
		public EAnnotation createConstraint(EModelElement modelElement, String body, String description) {
			EAnnotation eAnnotation = createConstraint(modelElement, body);
			eAnnotation.getDetails().put(Annotations.DESCRIPTION, description);
			return eAnnotation;
		}
	}
}
