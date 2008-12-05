/*
 * Copyright (c) 2005, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *    Radek Dvorak (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - refactoring
 */
package org.eclipse.gmf.internal.validate;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.validate.IDefElementProvider.StringValProvider;
import org.eclipse.gmf.internal.validate.IDefElementProvider.TypeProvider;
import org.eclipse.gmf.internal.validate.expressions.IModelExpression;

class ConstraintDef extends ValueSpecDef {
	
	private static final TypeProvider BOOLEAN_TYPE = 
		new TypeProvider() {
			public IStatus getStatus() {			
				return Status.OK_STATUS;
			}
			public EClassifier getType(EObject context) {						
				return EcorePackage.eINSTANCE.getEBooleanObject();
			}
			public boolean isAssignable(EObject context, IModelExpression expression) {
				return expression.isAssignableTo(EcorePackage.eINSTANCE.getEBooleanObject());
			}

			public String toString() {			
				return EcorePackage.eINSTANCE.getEBooleanObject().getName();
			}
		};
					
	public ConstraintDef(StringValProvider body, StringValProvider lang) {
		super(body, lang, BOOLEAN_TYPE);
	}
	
	public String getLabel() {
		return Messages.def_ConstraintDefLabel;
	}	
	
	public String toString() {
		return "constraint: " + super.toString(); //$NON-NLS-1$
	}
}
