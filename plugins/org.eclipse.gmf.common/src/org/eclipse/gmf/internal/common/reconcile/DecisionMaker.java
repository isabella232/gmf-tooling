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

public abstract class DecisionMaker {
	private final EStructuralFeature myFeature;

	public abstract Decision makeDecision(EObject current, EObject old);
	
	public DecisionMaker(EStructuralFeature feature){
		myFeature = feature;
	}
	
	public final EStructuralFeature getFeature(){
		return myFeature;
	}
	
	public static class ALWAYS_OLD extends DecisionMaker {
		public ALWAYS_OLD(EStructuralFeature feature){
			super(feature);
		}
		
		public Decision makeDecision(EObject current, EObject old) {
			return Decision.PRESERVE_OLD;
		}
	}
	
	public static class ALWAYS_NEW extends DecisionMaker {
		public ALWAYS_NEW(EStructuralFeature feature){
			super(feature);
		}
		
		public Decision makeDecision(EObject current, EObject old) {
			return Decision.ACCEPT_NEW;
		}
	}
	
}
