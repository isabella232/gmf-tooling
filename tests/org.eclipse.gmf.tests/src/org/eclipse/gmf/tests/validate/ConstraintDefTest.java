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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.internal.validate.Annotations;
import org.eclipse.gmf.internal.validate.StatusCodes;
import org.eclipse.gmf.validate.GMFValidator;


public class ConstraintDefTest extends MetaExpressionDefTestBase {

	public ConstraintDefTest(String name) {
		super(name, Annotations.Meta.CONSTRAINT);
	}

	public void testBodyBooleanType() throws Exception {
		EObject constraintInstance = EcoreUtil.create(constraintMetaClass);
		constraintInstance.eSet(languageAttr, Annotations.OCL_KEY);
		constraintInstance.eSet(bodyAttr, "2006"); //$NON-NLS-1$
		
		EObject owner = bindToNewContextInstance(constraintInstance);		

		Diagnostic status = GMFValidator.validate(owner);
		assertEquals(Diagnostic.ERROR, status.getSeverity());
		assertEquals(AnnotationUtil.getChildDiagnostic(status).getCode(), StatusCodes.INVALID_EXPRESSION_TYPE);		
	}
}
