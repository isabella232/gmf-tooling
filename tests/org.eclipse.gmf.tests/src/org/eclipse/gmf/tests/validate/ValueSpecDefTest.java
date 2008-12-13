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

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.internal.validate.Annotations;
import org.eclipse.gmf.internal.validate.StatusCodes;
import org.eclipse.gmf.validate.GMFValidator;


public class ValueSpecDefTest extends MetaExpressionDefTestBase {

	EStructuralFeature restrictTypeFeature;
	
	public ValueSpecDefTest(String name) {
		super(name, Annotations.Meta.VALUESPEC);
	}
	
	@Override
	protected void setUp() throws Exception {	
		super.setUp();
		
		this.restrictTypeFeature = DynamicModelHelper.createFeature(containerClass, EcorePackage.eINSTANCE.getEDataType());		
	}
	
	public void testBodyTypeRestriction() throws Exception {
		setTypeRestrictionExpression();

		EObject constraintInstance = EcoreUtil.create(constraintMetaClass);
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		// provide Integer as a valid Real
		constraintInstance.eSet(bodyAttr, "2006"); //$NON-NLS-1$
		// set the eval context, thought the expression evaluation is independent of it
		EObject owner = bindToNewContextInstance(constraintInstance);
		// set expression result type restriction
		owner.eSet(restrictTypeFeature, EcorePackage.eINSTANCE.getEDouble());

		Diagnostic status = GMFValidator.validate(owner);
		assertEquals(Diagnostic.OK, status.getSeverity());		
	}
	
	public void testBodyTypeRestrictionViolation() throws Exception {
		setTypeRestrictionExpression();

		EObject constraintInstance = EcoreUtil.create(constraintMetaClass);
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "self.name"); //$NON-NLS-1$
		
		EObject owner = bindToNewContextInstance(constraintInstance);
		// set expression result type restriction
		owner.eSet(restrictTypeFeature, EcorePackage.eINSTANCE.getEDouble());

		Diagnostic status = GMFValidator.validate(owner);
		assertEquals(Diagnostic.ERROR, status.getSeverity());
		assertEquals(StatusCodes.INVALID_EXPRESSION_TYPE, AnnotationUtil.getChildDiagnostic(status).getCode());		
	}
	
	private void setTypeRestrictionExpression() {
		EAnnotation eAnnotation = AnnotationUtil.createAnnotation(constraintRefFeatureCtx, Annotations.CONSTRAINTS_META_URI);
		eAnnotation.getDetails().put(Annotations.Meta.DEF_KEY, Annotations.Meta.TYPE);
		eAnnotation.getDetails().put(Annotations.OCL_KEY, restrictTypeFeature.getName());
	}	
}
