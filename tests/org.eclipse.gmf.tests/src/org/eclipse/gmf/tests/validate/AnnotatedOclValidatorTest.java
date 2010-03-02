/*
 * Copyright (c) 2007, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    dvorak - initial API and implementation
 *    Artem Tikhomirov (Borland) - [230418] non-containment contexts; refactoring
 *                                 [256461] test implicit EObject operations access
 */
package org.eclipse.gmf.tests.validate;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.internal.validate.StatusCodes;
import org.eclipse.gmf.validate.GMFValidator;
import org.eclipse.gmf.validate.ValidationOptions;

public class AnnotatedOclValidatorTest extends TestCase {
	
	EClass eClass;
	
	/**
	 * @param name
	 */
	public AnnotatedOclValidatorTest(String name) {
		super(name);		
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		EPackage model = DynamicModelHelper.createMetaModel();
		this.eClass = DynamicModelHelper.createMetaClass(model);			
	}

	public void testCorrectConstraint() throws Exception {
		AnnotationUtil.OCL.createConstraint(eClass, "true"); //$NON-NLS-1$
		Diagnostic status = GMFValidator.validate(eClass);
		assertTrue(status.getSeverity() == Diagnostic.OK);
	}
	
	public void testInvalidConstraintBody() throws Exception {
		EAnnotation constraint = AnnotationUtil.OCL.createConstraint(eClass, ";-)"); //$NON-NLS-1$
		Diagnostic status = GMFValidator.validate(eClass);
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_VALUE_EXPRESSION);
		assertSame(eClass, AnnotationUtil.getChildDiagnosticSource(status));
		String defaultMessage = AnnotationUtil.getChildDiagnostic(status).getMessage();
		assertNotNull(defaultMessage);
		assertTrue(defaultMessage.indexOf(AnnotationUtil.OCL.getConstraintBodyDetail(constraint).getValue()) >= 0);
	}
	
	public void testMissingConstraintBody() throws Exception {
		EAnnotation constraint = AnnotationUtil.OCL.createConstraint(eClass, null); //$NON-NLS-1$
		Diagnostic status = GMFValidator.validate(eClass);
		assertTrue(status.getSeverity() == Diagnostic.WARNING);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.EMPTY_CONSTRAINT_BODY);
		assertSame(AnnotationUtil.OCL.getConstraintBodyDetail(constraint), AnnotationUtil.getChildDiagnosticSource(status));
	}
	
	public void testInvalidConstraintExpressionType() throws Exception {
		AnnotationUtil.OCL.createConstraint(eClass, "'aString'"); //$NON-NLS-1$
		Diagnostic status = GMFValidator.validate(eClass);
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_EXPRESSION_TYPE);
		assertSame(eClass, AnnotationUtil.getChildDiagnosticSource(status));
	}
		
	public void testValidConstrainedElement() {
		AnnotationUtil.OCL.createConstraint(eClass, "true"); //$NON-NLS-1$
		EObject target = EcoreUtil.create(eClass);
		
		ValidationOptions opts = new ValidationOptions();
		opts.setReportSuccess(true);
		
		Diagnostic status = GMFValidator.validate(target, opts);
		assertTrue(status.getSeverity() == Diagnostic.OK);
		assertSame(target, AnnotationUtil.getChildDiagnosticSource(status));		
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.CONSTRAINT_SATISFIED);
		
		String defaultMessage = AnnotationUtil.getChildDiagnostic(status).getMessage();
		assertNotNull(defaultMessage);
		assertTrue(defaultMessage.trim().length() > 0);		
	}
	
	public void testInvalidConstrainedElement() {
		AnnotationUtil.OCL.createConstraint(eClass, "false"); //$NON-NLS-1$
		EObject target = EcoreUtil.create(eClass);

		Diagnostic status = GMFValidator.validate(target);
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.CONSTRAINT_VIOLATION);
		assertSame(target, AnnotationUtil.getChildDiagnosticSource(status));		
	}
	
	public void testInvalidConstrainetContext() {
		EModelElement invalidCtx = eClass.getEPackage();
		EAnnotation constraint = AnnotationUtil.OCL.createConstraint(invalidCtx, "true"); //$NON-NLS-1$

		Diagnostic status = GMFValidator.validate(invalidCtx);
		assertTrue(status.getSeverity() == Diagnostic.WARNING);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_CONSTRAINT_CONTEXT);
		assertSame(constraint, AnnotationUtil.getChildDiagnosticSource(status));		
	}		

	public void testImplicitEObjectOperationsEnabled() {
		AnnotationUtil.OCL.createConstraint(eClass, "eContainer().oclIsUndefined() and eClass().name = '" + eClass.getName() + '\''); //$NON-NLS-1$
		Diagnostic status = GMFValidator.validate(eClass);
		String msg = AnnotationUtil.getChildDiagnostic(status) != null ? AnnotationUtil.getChildDiagnostic(status).getMessage() : status.getMessage();
		assertTrue(msg, status.getSeverity() == Diagnostic.OK);

		EObject target = EcoreUtil.create(eClass);
		status = GMFValidator.validate(target);
		msg = AnnotationUtil.getChildDiagnostic(status) != null ? AnnotationUtil.getChildDiagnostic(status).getMessage() : status.getMessage();
		assertTrue(msg, status.getSeverity() == Diagnostic.OK);
	}
}