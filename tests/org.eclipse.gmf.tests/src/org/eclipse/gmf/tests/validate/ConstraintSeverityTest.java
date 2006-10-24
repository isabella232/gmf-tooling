/**
 * Copyright (c) 2006 Borland Software Corporation
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


import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.internal.validate.Annotations;
import org.eclipse.gmf.internal.validate.StatusCodes;
import org.eclipse.gmf.validate.GMFValidator;

/**
 * // TODO - 1) make validation.Annotations public
 * 			 2) provide tests for the whole GMF validation 		
 */
@SuppressWarnings("unchecked")
public class ConstraintSeverityTest extends TestCase {
	
	EClass targetMetaElement;
	EObject targetInstance;
	
	public ConstraintSeverityTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		this.targetMetaElement = EcoreFactory.eINSTANCE.createEClass();
		ePackage.getEClassifiers().add(targetMetaElement);
		
		this.targetInstance = targetMetaElement.getEPackage().getEFactoryInstance().create(targetMetaElement);
	}
		
	public void testDefaultSeverity() throws Exception {
		attachOCLConstraint(targetMetaElement, "false", null); //$NON-NLS-1$ 
		assertEquals("error severity expected as default", Diagnostic.ERROR, getValidationStatus(targetInstance).getSeverity()); //$NON-NLS-1$	
	}
	
	public void testInfoExplicitSeverity() throws Exception {
		attachOCLConstraint(targetMetaElement, "false", Annotations.SEVERITY_INFO); //$NON-NLS-1$
		assertEquals("info severity expected", Diagnostic.INFO, getValidationStatus(targetInstance).getSeverity()); //$NON-NLS-1$
	}	
	
	public void testWarnExplicitSeverity() throws Exception {
		attachOCLConstraint(targetMetaElement, "false", Annotations.SEVERITY_WARN); //$NON-NLS-1$		
		assertEquals("warn severity expected",Diagnostic.WARNING, getValidationStatus(targetInstance).getSeverity()); //$NON-NLS-1$
	}
	
	public void testErrorExplicitSeverity() throws Exception {
		attachOCLConstraint(targetMetaElement, "false", Annotations.SEVERITY_ERROR); //$NON-NLS-1$
		assertEquals("error severity expected",Diagnostic.ERROR, getValidationStatus(targetInstance).getSeverity()); //$NON-NLS-1$
	}	
	
	public void testInvalidSeverity() throws Exception {
		String invalidValue = "foo"; //$NON-NLS-1$
		attachOCLConstraint(targetMetaElement, "true", invalidValue); //$NON-NLS-1$
		Diagnostic[] diagnostics = new Diagnostic[] { 
			GMFValidator.validate(targetMetaElement),
			GMFValidator.validate(targetInstance)
		};
		for (int i = 0; i < diagnostics.length; i++) {
			Diagnostic diagnostic = getDiagnosticForDestination(diagnostics[i], invalidValue);
			assertEquals("Expected 'Invalid Constraint Severity' status code", StatusCodes.INVALID_CONSTRAINT_SEVERITY, diagnostic.getCode()); //$NON-NLS-1$
			assertEquals("Expected 'error' severity", Diagnostic.ERROR, diagnostic.getSeverity()); //$NON-NLS-1$
			assertSame(invalidValue, getDiagnosticDestination(diagnostic));
		}
	}
	
	///////////////////////////////////
	// Validation auxiliary stuff
	// TODO - move to a ValidationTestCase super class
	//////////////////////////////////
	static Diagnostic getValidationStatus(EObject target) {
		Diagnostic diagnostic = GMFValidator.validate(target);
		Diagnostic targetDiagnostic = getDiagnosticForDestination(diagnostic, target);
		assertNotNull("No validation diagnostic produced for target", targetDiagnostic); //$NON-NLS-1$
		return targetDiagnostic;
	}
	
	static Object getDiagnosticDestination(Diagnostic diagnostic) {
		if(diagnostic.getData() == null || diagnostic.getData().isEmpty()) {
			return null;
		}
		return diagnostic.getData().get(0);
	}
	
	static Diagnostic getDiagnosticForDestination(Diagnostic diagnostic, Object validatedObject) {
		List data = diagnostic.getData();
		if(data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object element = it.next();
				if(element == validatedObject) {
					return diagnostic;
				}
			}
		}
		
		for (Iterator it = diagnostic.getChildren().iterator(); it.hasNext();) {
			Diagnostic childDiagnostic = (Diagnostic) it.next();
			Diagnostic result = getDiagnosticForDestination(childDiagnostic, validatedObject);
			if(result != null) {
				return result;
			}
		}
		return null;
	}
	
	static EAnnotation attachOCLConstraint(EModelElement constrainedElement, String body, String severity) {
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource(Annotations.CONSTRAINTS_URI);
		annotation.getDetails().put(Annotations.OCL_KEY, body);
		if(severity != null) {
			annotation.getDetails().put(Annotations.SEVERITY, severity);
		}
		constrainedElement.getEAnnotations().add(annotation);
		return annotation;
	}
}
