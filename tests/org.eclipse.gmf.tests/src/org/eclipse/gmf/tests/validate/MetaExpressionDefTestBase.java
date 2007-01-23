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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.validate.Annotations;
import org.eclipse.gmf.internal.validate.StatusCodes;
import org.eclipse.gmf.validate.GMFValidator;


public abstract class MetaExpressionDefTestBase extends TestCase {
	
	protected EClass constraintMetaClass;
	protected EStructuralFeature languageAttr;
	protected EStructuralFeature bodyAttr;	
	protected EReference contraintRefFeatureCtx;
	protected EReference contraintRefWithOCLCtx;
	protected EClass containerClass;	
	protected EStructuralFeature ctxClassRef;		
	protected EStructuralFeature ctxTypeRef;
		
	/**
	 * @param name
	 */
	MetaExpressionDefTestBase(String name) {
		super(name);
	}
	
	protected abstract String getMetaDefinitionAnnotationKey();	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		EPackage model = DynamicModelHelper.createMetaModel();
		this.containerClass = DynamicModelHelper.createMetaClass(model);
		this.ctxClassRef = DynamicModelHelper.createFeature(containerClass, EcorePackage.eINSTANCE.getEClass());
		this.ctxTypeRef = DynamicModelHelper.createFeature(containerClass, EcorePackage.eINSTANCE.getEDataType());		
		
		this.constraintMetaClass = DynamicModelHelper.createMetaClass(model);
		this.languageAttr = DynamicModelHelper.createFeature(constraintMetaClass, EcorePackage.eINSTANCE.getEString());
		this.bodyAttr = DynamicModelHelper.createFeature(constraintMetaClass, EcorePackage.eINSTANCE.getEString());		
				
		// create valuespec|constraint meta-definition
		EAnnotation eAnnotation = AnnotationUtil.createAnnotation(constraintMetaClass, Annotations.CONSTRAINTS_META_URI);
		eAnnotation.getDetails().put(Annotations.Meta.DEF_KEY, getMetaDefinitionAnnotationKey());

		AnnotationUtil.addLanguageDefAnnotation(languageAttr);
		AnnotationUtil.addBodyDefAnnotation(bodyAttr);
		
		// create reference Container->Constraint
		this.contraintRefFeatureCtx = (EReference)DynamicModelHelper.createFeature(containerClass, constraintMetaClass);
		this.contraintRefFeatureCtx.setContainment(true);		
		AnnotationUtil.addContextDefAnnotation(contraintRefFeatureCtx, ctxClassRef.getName());
		
		this.contraintRefWithOCLCtx  = (EReference)DynamicModelHelper.createFeature(containerClass, constraintMetaClass);
		this.contraintRefWithOCLCtx.setContainment(true);
		AnnotationUtil.addContextDefAnnotation(contraintRefWithOCLCtx, ctxTypeRef.getName());	
	}
	
	public void testValidOCLConstraint() throws Exception {
		EObject constraintInstance = DynamicModelHelper.createInstance(constraintMetaClass);
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "eParameters->size() > 0"); //$NON-NLS-1$
		
		bindToEClassContext(constraintInstance, EcorePackage.eINSTANCE.getEOperation());		

		Diagnostic status = GMFValidator.validate(constraintInstance);
		assertTrue(status.getSeverity() == Diagnostic.OK);
	}
	
	public void testNoContextAvailable() throws Exception {						
		EObject constraintInstance = DynamicModelHelper.createInstance(constraintMetaClass);		
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "true"); //$NON-NLS-1$

		Diagnostic status = GMFValidator.validate(constraintInstance);
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.NO_VALUESPEC_CONTEXT_AVAILABLE);
	}
	
	
	public void testInvalidBody() throws Exception {
		EObject constraintInstance = DynamicModelHelper.createInstance(constraintMetaClass);
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "true..."); //$NON-NLS-1$
		bindToEClassContext(constraintInstance, EcorePackage.eINSTANCE.getEOperation());

		Diagnostic status = GMFValidator.validate(constraintInstance);
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_CONSTRAINT_EXPRESSION);		
	}
		
	public void testWrongContextTypeDef() throws Exception {
		ctxClassRef.setEType(containerClass);

		EObject constraintInstance = DynamicModelHelper.createInstance(constraintMetaClass);		
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "true"); //$NON-NLS-1$
		bindToEClassContext(constraintInstance, EcorePackage.eINSTANCE.getEOperation());		

		Diagnostic status = GMFValidator.validate(constraintInstance);
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.NO_VALUESPEC_CONTEXT_AVAILABLE);
	}
	
	public void testRegExpLikeConstraint() throws Exception {
		_testValidRegExpConstraint(Annotations.REGEXP_KEY);
		_testValidRegExpConstraint(Annotations.NEG_REGEXP_KEY);				
	}

	private void _testValidRegExpConstraint(String regexpLang) throws Exception {
		EObject constraintInstance = DynamicModelHelper.createInstance(constraintMetaClass);
		constraintInstance.eSet(languageAttr, regexpLang);
		constraintInstance.eSet(bodyAttr, "[.]"); //$NON-NLS-1$
				
		// first test EClass as in-proper context for regexp evaluation
		bindToEClassContext(constraintInstance, EcorePackage.eINSTANCE.getEOperation());	
		Diagnostic status = GMFValidator.validate(constraintInstance);
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_CONSTRAINT_EXPRESSION);		

		// patch context to EString to allow regexp evaluation  
		EObject containerInstance = DynamicModelHelper.createInstance(containerClass);
		containerInstance.eSet(ctxTypeRef, EcorePackage.eINSTANCE.getEString());
		// rebind to String type context
		containerInstance.eSet(contraintRefWithOCLCtx, constraintInstance);		
		
		status = GMFValidator.validate(constraintInstance);
		assertTrue(status.getSeverity() == Diagnostic.OK);
	}
		
	public void testDefinitionInheritance() throws Exception {
		// Subclass the Constraint metaclass 
		EClass intermConstraintSubClass = DynamicModelHelper.createMetaClass(constraintMetaClass.getEPackage());
		intermConstraintSubClass.getESuperTypes().add(constraintMetaClass);
		EClass finalConstraintSubClass = DynamicModelHelper.createMetaClass(constraintMetaClass.getEPackage());
		finalConstraintSubClass.getESuperTypes().add(intermConstraintSubClass);
				
		EObject constraintInstance = DynamicModelHelper.createInstance(finalConstraintSubClass);
		bindToEClassContext(constraintInstance, EcorePackage.eINSTANCE.getEOperation());
		
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "true..."); //$NON-NLS-1$
		
		Diagnostic status = GMFValidator.validate(constraintInstance);
		// check invalid definition was captured
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_CONSTRAINT_EXPRESSION);
		// check it's correct now
		constraintInstance.eSet(bodyAttr, "true"); //$NON-NLS-1$		
		status = GMFValidator.validate(constraintInstance);
		assertTrue(status.getSeverity() == Diagnostic.OK);		
	}
		
	public void testMissingBodyAnnotation() throws Exception {
		bodyAttr.getEAnnotations().clear();
				
		EObject constraintInstance = DynamicModelHelper.createInstance(constraintMetaClass);
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		 
		Diagnostic status = GMFValidator.validate(constraintInstance);
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.MISSING_VALUESPEC_BODY_ANNOTATION);		
	}
	
	protected void bindToEClassContext(EObject constraintInstance, EClass context) {
		EObject containerInstance = DynamicModelHelper.createInstance(containerClass);
		containerInstance.eSet(ctxClassRef, EcorePackage.eINSTANCE.getEOperation());
		containerInstance.eSet(contraintRefFeatureCtx, constraintInstance);		
	}	
}
