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
package org.eclipse.gmf.tests.rt;

import java.util.Arrays;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * Tests domain meta-model element initialization   
 */
public class ElementInitializerTest extends RuntimeDiagramTestBase {
	private EObject nodeAElement;
	private EObject nodeBElement;	
	
	public ElementInitializerTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Node nodeA = createNode(getGenModel().getNodeA(), getDiagram());
		this.nodeAElement = nodeA.getElement();
		Node nodeB = createNode(getGenModel().getNodeB(), getDiagram());
		this.nodeBElement = nodeB.getElement();
		assertNotNull("Tested node A element not available", nodeAElement); //$NON-NLS-1$
		assertNotNull("Tested node B element not available", nodeBElement); //$NON-NLS-1$		
	}
	
	public void testAttrMany() throws Exception {
		EStructuralFeature attrManyFeature = nodeBElement.eClass().getEStructuralFeature("integers_Init"); //$NON-NLS-1$		
		assertNotNull("field not found in tested class", attrManyFeature); //$NON-NLS-1$
		Object value = nodeBElement.eGet(attrManyFeature);		
		assertEquals(value, new BasicEList(Arrays.asList(new Object[] { new Integer(10), new Integer(20) })));		
	}
	
	
	public void testReferenceToMany() throws Exception {
		EStructuralFeature refToManyFeature = nodeAElement.eClass().getEStructuralFeature("reference_Init"); //$NON-NLS-1$		
		assertNotNull("field not found in tested class", refToManyFeature); //$NON-NLS-1$
		Object value = nodeAElement.eGet(refToManyFeature);		
		assertEquals(value, new BasicEList(Arrays.asList(new Object[] { nodeAElement })));		
	}
	
	// #115521 - test of enum literal assignment to a structural feature 	
	public void testEnumLiteralAttr() throws Exception {		
		EStructuralFeature enumField = nodeAElement.eClass().getEStructuralFeature("enumAttr_Init"); //$NON-NLS-1$		
		assertNotNull("enum field not found in tested class", enumField); //$NON-NLS-1$
		assertTrue(enumField.getEType() instanceof EEnum);
		
		EEnum testEnum = (EEnum) enumField.getEType();
		EEnumLiteral literal = testEnum.getEEnumLiteral("LIT1"); //$NON-NLS-1$
		Object literalValue = nodeAElement.eGet(enumField);
		assertNotNull(literalValue);		
		assertFalse("Should be set to different from default", literalValue.equals(enumField.getDefaultValue())); //$NON-NLS-1$
		assertSame("Expected literal set by initializer", literal.getInstance(), literalValue); //$NON-NLS-1$		
	}	
}
