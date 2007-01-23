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

import junit.framework.TestCase;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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
		assertSame(AnnotationUtil.OCL.getConstraintBodyDetail(constraint), AnnotationUtil.getChildDiagnosticSource(status));
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_VALUE_EXPRESSION);
		String defaultMessage = AnnotationUtil.getChildDiagnostic(status).getMessage();
		assertNotNull(defaultMessage);
		assertTrue(defaultMessage.trim().length() > 0);
	}
	
	public void testMissingConstraintBody() throws Exception {
		EAnnotation constraint = AnnotationUtil.OCL.createConstraint(eClass, null); //$NON-NLS-1$
		Diagnostic status = GMFValidator.validate(eClass);
		assertTrue(status.getSeverity() == Diagnostic.WARNING);
		assertSame(AnnotationUtil.OCL.getConstraintBodyDetail(constraint), AnnotationUtil.getChildDiagnosticSource(status));
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.EMPTY_CONSTRAINT_BODY);
	}
	
	public void testInvalidConstraintExpressionType() throws Exception {
		EAnnotation constraint = AnnotationUtil.OCL.createConstraint(eClass, "'aString'"); //$NON-NLS-1$
		Diagnostic status = GMFValidator.validate(eClass);
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertSame(AnnotationUtil.OCL.getConstraintBodyDetail(constraint), AnnotationUtil.getChildDiagnosticSource(status));
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_EXPRESSION_TYPE);
	}
		
	public void testValidConstrainedElement() {
		AnnotationUtil.OCL.createConstraint(eClass, "true"); //$NON-NLS-1$
		EObject target = DynamicModelHelper.createInstance(eClass);
		
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
		EObject target = DynamicModelHelper.createInstance(eClass);

		Diagnostic status = GMFValidator.validate(target);
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertSame(target, AnnotationUtil.getChildDiagnosticSource(status));		
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.CONSTRAINT_VIOLATION);
	}
	
	public void testInvalidConstrainetContext() {
		EModelElement invalidCtx = eClass.getEPackage();
		EAnnotation constraint = AnnotationUtil.OCL.createConstraint(invalidCtx, "true"); //$NON-NLS-1$

		Diagnostic status = GMFValidator.validate(invalidCtx);
		assertTrue(status.getSeverity() == Diagnostic.WARNING);
		assertSame(AnnotationUtil.OCL.getConstraintBodyDetail(constraint), AnnotationUtil.getChildDiagnosticSource(status));		
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_CONSTRAINT_CONTEXT);
	}		
}