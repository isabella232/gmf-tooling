/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.gmf.internal.common.reconcile;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

public class StringPatternDecisionMaker extends DecisionMaker {
	private Pattern myPattern;
	
	public StringPatternDecisionMaker(String valuePattern, EAttribute attribute){
		this(Pattern.compile(valuePattern), attribute);
	}
	
	public StringPatternDecisionMaker(Pattern valuePattern, EAttribute attribute){
		super(attribute);
		if (attribute.getEAttributeType() != EcorePackage.eINSTANCE.getEString()){
			throw new IllegalArgumentException("Expected string attribute");
		}
		if (attribute.getUpperBound() != 1){
			throw new IllegalArgumentException("Expected multiplicity [0..1] or [1]");
		}
		myPattern = valuePattern;
	}
	
	public Decision makeDecision(EObject current, EObject old) {
		String oldValue = (String)old.eGet(getFeature());
		if (oldValue != null && !myPattern.matcher(oldValue).matches()){
			return Decision.PRESERVE_OLD;
		} else {
			return Decision.ACCEPT_NEW;
		}
	}

}
