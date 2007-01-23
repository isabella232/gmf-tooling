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

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.validate.Annotations;
import org.eclipse.gmf.internal.validate.StatusCodes;
import org.eclipse.gmf.validate.GMFValidator;


public class ConstraintDefTest extends MetaExpressionDefTestBase {

	public ConstraintDefTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected String getMetaDefinitionAnnotationKey() {
		return Annotations.Meta.CONSTRAINT;
	}
	
	public void testBodyBooleanType() throws Exception {
		EObject constraintInstance = DynamicModelHelper.createInstance(constraintMetaClass);
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "2006"); //$NON-NLS-1$
		
		bindToEClassContext(constraintInstance, EcorePackage.eINSTANCE.getEOperation());		

		Diagnostic status = GMFValidator.validate(constraintInstance);
		assertTrue(status.getSeverity() == Diagnostic.ERROR);
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_EXPRESSION_TYPE);		
	}
}
