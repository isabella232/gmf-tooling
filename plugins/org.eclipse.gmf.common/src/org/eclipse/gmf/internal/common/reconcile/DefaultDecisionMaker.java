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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class DefaultDecisionMaker extends DecisionMaker {
	public DefaultDecisionMaker(EStructuralFeature feature){
		super(feature);
	}
	
	public Decision makeDecision(EObject current, EObject old) {
		assert current.eClass().equals(old.eClass());
		return (!current.eIsSet(getFeature()) && old.eIsSet(getFeature())) ? Decision.PRESERVE_OLD : Decision.ACCEPT_NEW;
	}

}
