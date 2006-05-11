/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.tr;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.bridge.genmodel.EcoreGenModelMatcher;


public class EcoreGenModelMatcherTest extends TestCase {
	EcoreGenModelMatcher matcher;
	URI genModelURI;	
	
	public EcoreGenModelMatcherTest(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception {
		matcher = new EcoreGenModelMatcher();
		genModelURI = URI.createURI("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.genmodel"); //$NON-NLS-1$
	}

	public void testEcoreGenPackage() throws Exception {		
		GenPackage genPackage = matcher.findGenPackage(EcorePackage.eINSTANCE);
		assertEcoreGenModelElement(genPackage);
		assertEquals(EcorePackage.eINSTANCE.getNsURI(), genPackage.getEcorePackage().getNsURI());
	}
		
	public void testEcoreGenClass() throws Exception {		
		GenClass genClass = matcher.findGenClass(EcorePackage.eINSTANCE.getEClass());
		assertEcoreGenModelElement(genClass);
	}
	
	public void testEcoreDataType() throws Exception {		
		GenClassifier genClassifier = matcher.findGenClassifier(EcorePackage.eINSTANCE.getEString());
		assertEcoreGenModelElement(genClassifier);
		assertTrue(genClassifier instanceof GenDataType);
	}
	
	
	private void assertEcoreGenModelElement(GenBase element) {
		assertNotNull(element);
		assertNotNull(element.eResource());
		assertEquals(genModelURI, element.eResource().getURI());
	}
}