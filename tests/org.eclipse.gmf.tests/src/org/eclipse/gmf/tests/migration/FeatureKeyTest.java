/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: dvorak - initial API and implementation
 */
package org.eclipse.gmf.tests.migration;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.internal.common.migrate.FeatureKey;

@SuppressWarnings("unchecked")
public class FeatureKeyTest extends TestCase {
	EPackage ePackage1;
	EClass eClassA1;	
	EPackage ePackage2;
	EClass eClassA2;
	
	public FeatureKeyTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ePackage1 = EcoreFactory.eINSTANCE.createEPackage();
		ePackage1.setNsURI("ePackage1"); //$NON-NLS-1$
		eClassA1 = EcoreFactory.eINSTANCE.createEClass();
		eClassA1.setName("A"); //$NON-NLS-1$
		
		ePackage2 = EcoreFactory.eINSTANCE.createEPackage();		
		ePackage2.setNsURI("ePackage2"); //$NON-NLS-1$
		eClassA2 = EcoreFactory.eINSTANCE.createEClass();
		eClassA2.setName("A"); //$NON-NLS-1$
	}	
	
	public void testUninitialized() throws Exception {
		FeatureKey unInitFeatureKey = new FeatureKey();
		assertEquals(unInitFeatureKey, new FeatureKey());	
		
		unInitFeatureKey.setFeature(EcorePackage.eINSTANCE.getENamedElement_Name());
		assertFalse(unInitFeatureKey.equals(new FeatureKey()));
	}
	
	public void testEquals() throws Exception {
		FeatureKey featureKey = FeatureKey.create(EcorePackage.eINSTANCE.getENamedElement_Name());
		assertEquals(featureKey, featureKey);		
		assertEquals(featureKey, FeatureKey.create(EcorePackage.eINSTANCE.getENamedElement_Name()));
		
		FeatureKey differentFeatureKey = FeatureKey.create(EcorePackage.eINSTANCE.getEClass_Abstract());
		assertFalse(featureKey.equals(differentFeatureKey));
		
		differentFeatureKey.setFeature(EcorePackage.eINSTANCE.getENamedElement_Name());
		assertEquals(featureKey, differentFeatureKey);
	}
		
	public void testAdvancedEquals() throws Exception {
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		assertEquals(FeatureKey.create(attribute), FeatureKey.create(attribute));

		attribute.setName("x"); //$NON-NLS-1$
		EAttribute attribute2 = (EAttribute)EcoreUtil.copy(attribute);
		assertEquals(FeatureKey.create(attribute), FeatureKey.create(attribute2));
		attribute2.setName("y"); //$NON-NLS-1$
		assertFalse(FeatureKey.create(attribute).equals(FeatureKey.create(attribute2)));
		
		attribute2 = (EAttribute)EcoreUtil.copy(attribute);
		eClassA1.getEStructuralFeatures().add(attribute);
		eClassA2.getEStructuralFeatures().add(attribute2);
		assertEquals(FeatureKey.create(attribute), FeatureKey.create(attribute2));
				
		ePackage1.getEClassifiers().add(eClassA1);
		ePackage2.getEClassifiers().add(eClassA2);
		assertFalse(FeatureKey.create(attribute).equals(FeatureKey.create(attribute2)));
	}
	
	private void assertEquals(FeatureKey expected, FeatureKey actual) {
		Assert.assertEquals(expected, actual);
		assertEquals("Expect the same hashcode for equals", expected.hashCode(), actual.hashCode()); //$NON-NLS-1$
	}
}
