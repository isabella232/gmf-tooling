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

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureValueSpec;
import org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
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
	
	public void testJavaInitializers() throws Exception {
		Class javaContainerClass = loadJavaContainerClass();
		assertNotNull("Could not find generated java initializer class", javaContainerClass);

		GenJavaExpressionProvider javaProvider = null;
		GenExpressionProviderContainer container = getGenModel().getGenDiagram().getEditorGen().getExpressionProviders();
		for (Iterator providerIt = container.getProviders().iterator(); providerIt.hasNext();) {
			Object nextProvider = providerIt.next();
			if(nextProvider instanceof GenJavaExpressionProvider) {
				javaProvider = (GenJavaExpressionProvider)nextProvider;
			}
		}
		assertNotNull(javaProvider);
		boolean primitiveTypeAttrTested = false;
		boolean objValTypeAttrTested = false;			
		boolean refTested = false;			
		boolean multiValPrimitiveTypeAttrTested = false;
		boolean multiObjValTypeAttrTested = false;			
		boolean multiRefTested = false;			
					
		Iterator it = getGenModel().getGenDiagram().eAllContents();
		while (it.hasNext()) {
			Object element = it.next();
			if(element instanceof GenFeatureSeqInitializer) {
				GenFeatureSeqInitializer fsInitializer = (GenFeatureSeqInitializer)element;
				TypeModelFacet typeModelFacet = (TypeModelFacet)fsInitializer.eContainer();
				GenClass metaGenClass = typeModelFacet.getMetaClass();
				for (Iterator ftIt = fsInitializer.getInitializers().iterator(); ftIt.hasNext();) {
					GenFeatureValueSpec nextFtValSpec = (GenFeatureValueSpec) ftIt.next();						
					if(container.getProvider(nextFtValSpec) != javaProvider) continue;
					String operationName = javaProvider.getOperationName(nextFtValSpec);					
					Method method = findMethod(javaContainerClass, operationName, metaGenClass);
					 
					GenFeature genFeature = nextFtValSpec.getFeature();
					if(genFeature.isPrimitiveType() && !genFeature.isListType()) {
						assertTrue("Use wrapper class for primitive return type", //$NON-NLS-1$
								!method.getReturnType().isPrimitive() && genFeature.isPrimitiveType());
						assertEquals(method.getReturnType(), EcoreUtil.wrapperClassFor(genFeature.getEcoreFeature().getEType().getInstanceClass())); 
						 
						primitiveTypeAttrTested = true;
					} 
					else if(!genFeature.isReferenceType() && genFeature.getEcoreFeature().isMany() && genFeature.getEcoreFeature().getEType().getInstanceClass().isPrimitive()) {
						assertEquals(method.getReturnType().getName(), EList.class.getName());
						multiValPrimitiveTypeAttrTested = true; 
					} 
					else if(!genFeature.isReferenceType() && !genFeature.isPrimitiveType() && !genFeature.isListType()) {
						assertEquals(method.getReturnType().getName(), genFeature.getType());
						objValTypeAttrTested = true;
					} 
					else if(!genFeature.isReferenceType() && !genFeature.isPrimitiveType() && genFeature.isListType()) {
						assertEquals(method.getReturnType().getName(), EList.class.getName());						
						multiObjValTypeAttrTested = true;								
					} 
					else if(genFeature.isReferenceType() && !genFeature.isListType()) {
						assertEquals(method.getReturnType().getName(), genFeature.getTypeGenClass().getQualifiedInterfaceName());
						refTested = true;				
					}   							
					else if(genFeature.isReferenceType() && genFeature.isListType()) {
						assertEquals(method.getReturnType().getName(), EList.class.getName());
						multiRefTested = true;								
					}   														
				}
			}
		}
		
		assertTrue(primitiveTypeAttrTested);
		assertTrue(objValTypeAttrTested);			
		assertTrue(refTested);			
		assertTrue(multiValPrimitiveTypeAttrTested);
		assertTrue(multiObjValTypeAttrTested);			
		assertTrue(multiRefTested);		
	}	

	protected Class loadJavaContainerClass() {
		String javaContainerName = "Initializers$Java"; //$NON-NLS-1$
		try {
			return loadGeneratedClass(getGenModel().getGenDiagram().getElementTypesQualifiedClassName() + "$" + javaContainerName); //$NON-NLS-1$
		} catch (ClassNotFoundException e) {
			return null;
		}
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
	
	private Method findMethod(Class clazz, String methodName, GenClass contextClass) {
		try {
			Class[] params = new Class[] { loadGeneratedClass(contextClass.getQualifiedInterfaceName()) };
			for (int i = 0; i < clazz.getDeclaredMethods().length; i++) {
				Method method = clazz.getDeclaredMethods()[i];
				if(method.getName().equals(methodName)) {
					if(Arrays.equals(params, method.getParameterTypes())) {
						return method;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			fail("Expected class not generated. " + e.toString()); //$NON-NLS-1$
		}
		return null;
	}
}
