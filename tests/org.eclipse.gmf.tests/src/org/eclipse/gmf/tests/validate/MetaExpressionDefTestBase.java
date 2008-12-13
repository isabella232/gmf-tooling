/*
 * Copyright (c) 2007, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    dvorak - initial API and implementation
 *    Artem Tikhomirov (Borland) - [230418] non-containment contexts; refactoring
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.internal.validate.Annotations;
import org.eclipse.gmf.internal.validate.StatusCodes;
import org.eclipse.gmf.validate.GMFValidator;


public abstract class MetaExpressionDefTestBase extends TestCase {
	
	protected EClass constraintMetaClass;
	protected EStructuralFeature languageAttr;
	protected EStructuralFeature bodyAttr;	
	protected EReference constraintRefFeatureCtx;
	protected EReference constraintRefWithOCLCtx;
	protected EClass containerClass;	
	protected EStructuralFeature ctxClassRef;		
	protected EStructuralFeature ctxTypeRef;

	protected final String metaDefinitionAnnotationKey;

	/**
	 * @param name
	 */
	MetaExpressionDefTestBase(String name, String metaDefKey) {
		super(name);
		metaDefinitionAnnotationKey = metaDefKey;
	}
	
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
		eAnnotation.getDetails().put(Annotations.Meta.DEF_KEY, metaDefinitionAnnotationKey);

		EcoreUtil.setAnnotation(languageAttr, Annotations.CONSTRAINTS_META_URI, Annotations.Meta.DEF_KEY, Annotations.Meta.LANG);
		EcoreUtil.setAnnotation(bodyAttr, Annotations.CONSTRAINTS_META_URI, Annotations.Meta.DEF_KEY, Annotations.Meta.BODY);
		
		// create reference Container->Constraint
		this.constraintRefFeatureCtx = (EReference)DynamicModelHelper.createFeature(containerClass, constraintMetaClass);
		this.constraintRefFeatureCtx.setContainment(true);		
		AnnotationUtil.addContextDefAnnotation(constraintRefFeatureCtx, ctxClassRef.getName());
		
		this.constraintRefWithOCLCtx  = (EReference)DynamicModelHelper.createFeature(containerClass, constraintMetaClass);
		this.constraintRefWithOCLCtx.setContainment(true);
		AnnotationUtil.addContextDefAnnotation(constraintRefWithOCLCtx, ctxTypeRef.getName());	
	}
	
	public void testValidOCLConstraint() throws Exception {
		EObject constraintInstance = EcoreUtil.create(constraintMetaClass);
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "eParameters->size() > 0"); //$NON-NLS-1$
		
		bindToNewContextInstance(constraintInstance);		

		Diagnostic status = GMFValidator.validate(constraintInstance);
		assertEquals(Diagnostic.OK, status.getSeverity());
	}
	
	public void testNoContextAvailable() throws Exception {						
		EObject constraintInstance = EcoreUtil.create(constraintMetaClass);		
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "true"); //$NON-NLS-1$

		EObject owner = bindToNewContextInstance(constraintInstance);
		owner.eUnset(ctxClassRef); // clear context reference
		Diagnostic status = GMFValidator.validate(owner);
		assertEquals(Diagnostic.ERROR, status.getSeverity());
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.NO_VALUESPEC_CONTEXT_AVAILABLE);
	}
	
	
	public void testInvalidBody() throws Exception {
		EObject constraintInstance = EcoreUtil.create(constraintMetaClass);
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "true..."); //$NON-NLS-1$
		bindToNewContextInstance(constraintInstance);

		Diagnostic status = GMFValidator.validate(bindToNewContextInstance(constraintInstance));
		assertEquals(Diagnostic.ERROR, status.getSeverity());
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_CONSTRAINT_EXPRESSION);		
	}
		
	public void testWrongContextTypeDef() throws Exception {
		ctxClassRef.setEType(containerClass);

		EObject constraintInstance = EcoreUtil.create(constraintMetaClass);		
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "true"); //$NON-NLS-1$
		EObject owner = bindToNewContextInstance(constraintInstance);		

		Diagnostic status = GMFValidator.validate(owner);
		assertEquals(Diagnostic.ERROR, status.getSeverity());
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.NO_VALUESPEC_CONTEXT_AVAILABLE);
	}
	
	public void testRegExpLikeConstraint() throws Exception {
		_testValidRegExpConstraint(Annotations.REGEXP_KEY);
		_testValidRegExpConstraint(Annotations.NEG_REGEXP_KEY);				
	}

	private void _testValidRegExpConstraint(String regexpLang) throws Exception {
		EObject constraintInstance = EcoreUtil.create(constraintMetaClass);
		constraintInstance.eSet(languageAttr, regexpLang);
		constraintInstance.eSet(bodyAttr, "[.]"); //$NON-NLS-1$
				
		// first test EClass as in-proper context for regexp evaluation
		EObject owner = bindToNewContextInstance(constraintInstance);	
		Diagnostic status = GMFValidator.validate(owner);
		assertEquals(Diagnostic.ERROR, status.getSeverity());
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_CONSTRAINT_EXPRESSION);		

		// patch context to EString to allow regexp evaluation  
		EObject containerInstance = EcoreUtil.create(containerClass);
		containerInstance.eSet(ctxTypeRef, EcorePackage.eINSTANCE.getEString());
		// rebind to String type context
		containerInstance.eSet(constraintRefWithOCLCtx, constraintInstance);		
		
		status = GMFValidator.validate(containerInstance);
		assertEquals(Diagnostic.OK, status.getSeverity());
	}
		
	public void testDefinitionInheritance() throws Exception {
		// Subclass the Constraint metaclass 
		EClass intermConstraintSubClass = DynamicModelHelper.createMetaClass(constraintMetaClass.getEPackage());
		intermConstraintSubClass.getESuperTypes().add(constraintMetaClass);
		EClass finalConstraintSubClass = DynamicModelHelper.createMetaClass(constraintMetaClass.getEPackage());
		finalConstraintSubClass.getESuperTypes().add(intermConstraintSubClass);
				
		EObject constraintInstance = EcoreUtil.create(finalConstraintSubClass);
		EObject owner = bindToNewContextInstance(constraintInstance);
		
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "true..."); //$NON-NLS-1$
		
		Diagnostic status = GMFValidator.validate(owner);
		// check invalid definition was captured
		assertEquals(Diagnostic.ERROR, status.getSeverity());
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_CONSTRAINT_EXPRESSION);
		// check it's correct now
		constraintInstance.eSet(bodyAttr, "true"); //$NON-NLS-1$		
		status = GMFValidator.validate(owner);
		assertEquals(Diagnostic.OK, status.getSeverity());		
	}
		
	public void testMissingBodyAnnotation() throws Exception {
		bodyAttr.getEAnnotations().clear();
				
		EObject constraintInstance = EcoreUtil.create(constraintMetaClass);
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		 
		Diagnostic status = GMFValidator.validate(bindToNewContextInstance(constraintInstance));
		assertEquals(Diagnostic.ERROR, status.getSeverity());
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.MISSING_VALUESPEC_BODY_ANNOTATION);		
	}
	
	protected EObject bindToNewContextInstance(EObject constraintInstance) {
		EObject ownerInstance = EcoreUtil.create(containerClass);
		ownerInstance.eSet(ctxClassRef, EcorePackage.eINSTANCE.getEOperation());
		ownerInstance.eSet(constraintRefFeatureCtx, constraintInstance);	
		return ownerInstance;
	}	
}
