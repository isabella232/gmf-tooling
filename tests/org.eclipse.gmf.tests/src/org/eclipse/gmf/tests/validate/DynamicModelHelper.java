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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class DynamicModelHelper {
	private static int ID = 0;
	
	private DynamicModelHelper() {
		super();
	}
	
	public static EObject createInstance(EClass eClass) {
		EFactory eFactory = eClass.getEPackage().getEFactoryInstance();
		return eFactory.create(eClass);
	}
	
	public static EPackage createMetaModel() {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		String suffix = genID();
		ePackage.setName("model_" + suffix); //$NON-NLS-1$
		ePackage.setNsURI("http://model_" + suffix); //$NON-NLS-1$
		ePackage.setNsPrefix("ns_" + suffix); //$NON-NLS-1$		
		return ePackage;
	}
	
	public static EClass createMetaClass(EPackage owningModel) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		owningModel.getEClassifiers().add(eClass);
		String suffix = genID();
		eClass.setName("class_" + suffix); //$NON-NLS-1$
		return eClass;
	}
	
	public static EStructuralFeature createFeature(EClass owningClass, EClassifier eType) {
		EStructuralFeature eStructuralFeature = (eType instanceof EClass) ?
				EcoreFactory.eINSTANCE.createEReference() : EcoreFactory.eINSTANCE.createEAttribute();
		owningClass.getEStructuralFeatures().add(eStructuralFeature);
		
		String suffix = genID();
		eStructuralFeature.setName("feature_" + suffix); //$NON-NLS-1$
		eStructuralFeature.setEType(eType);
		return eStructuralFeature;
	}
		
	private static String genID() {
		return Integer.toString(ID++);
	}
}