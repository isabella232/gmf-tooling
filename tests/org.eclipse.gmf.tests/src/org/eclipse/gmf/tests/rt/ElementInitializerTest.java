/*
 * Copyright (c) 2005, 2009 Borland Software Corporation
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureValueSpec;
import org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;

/**
 * Tests domain meta-model element initialization   
 */
public class ElementInitializerTest extends GeneratedCanvasTest {
	private EObject nodeAElement;
	private EObject nodeBElement;
	protected String myElementInitializersClassName;
	private Node myNodeB;
	private Node myNodeA;	
	
	public ElementInitializerTest(String name) {
		super(name);
		myDefaultSetup = LinksSessionSetup.newInstance();
	}

	protected void setUp() throws Exception {
		super.setUp();
		myNodeA = createNode(getGenModel().getNodeA(), getDiagram());
		this.nodeAElement = myNodeA.getElement();
		myNodeB = createNode(getGenModel().getNodeB(), getDiagram());
		this.nodeBElement = myNodeB.getElement();
		assertNotNull("Tested node A element not available", nodeAElement); //$NON-NLS-1$
		assertNotNull("Tested node B element not available", nodeBElement); //$NON-NLS-1$
		myElementInitializersClassName = getGenModel().getGenDiagram().getProvidersPackageName() + ".ElementInitializers"; //$NON-NLS-1$
	}
	
	public void testNewElementInitializer() throws Exception {
		EStructuralFeature feature = nodeAElement.eClass().getEStructuralFeature("refNewElement"); //$NON-NLS-1$		
		assertNotNull("feature not found in the intializer class", feature); //$NON-NLS-1$
		
		Object val = nodeAElement.eGet(feature);
		assertTrue(val instanceof EClass);
		EClass newEClass = (EClass)val;
		assertEquals("Only one attribute expected", 1, newEClass.getEAllAttributes().size()); //$NON-NLS-1$
		EAttribute attribute = newEClass.getEAllAttributes().iterator().next();
		assertEquals("attribute should be named by its EClass name", attribute.eClass().getName(), attribute.getName()); //$NON-NLS-1$
		assertEquals("attribute must be of String type", EcorePackage.eINSTANCE.getEString(), attribute.getEType()); //$NON-NLS-1$		
		
		assertEquals("Only one operation expected", 1, newEClass.getEOperations().size()); //$NON-NLS-1$
		EOperation operation = newEClass.getEOperations().iterator().next();
		assertEquals("operation should be named by its metaclass", operation.eClass().getName(), operation.getName()); //$NON-NLS-1$
		EClassifier expectedType = nodeAElement.eClass();
		assertEquals("operation should return type of its containing class", expectedType, operation.getEType()); //$NON-NLS-1$
	}

	public void testSeveralNewElementInitializers() {
		EStructuralFeature feature = nodeAElement.eClass().getEStructuralFeature("nestedNodes1"); //$NON-NLS-1$		
		assertNotNull("feature not found in the intializer class", feature); //$NON-NLS-1$
		
		Object val = nodeAElement.eGet(feature);
		assertTrue(val instanceof Collection<?>);
		Collection<?> children = (Collection<?>) val;
		assertEquals("2 child nodes expected", 2, children.size());
		int index = 0;
		for (Iterator<?> it = children.iterator(); it.hasNext(); index++) {
			Object nextChild = it.next();
			assertTrue("Incorrect child present", nextChild instanceof EObject);
			EObject nextEObject = (EObject) nextChild;
			EStructuralFeature nameFeature = nextEObject.eClass().getEStructuralFeature("name");
			assertNotNull("feature 'name' was not found in child node", nameFeature);
			Object name = nextEObject.eGet(nameFeature);
			assertTrue("Incorrect name value returned", name instanceof String);
			assertEquals("Name feature was not correctly initialized", nextEObject.eClass().getName() + "_" + index, (String) name);
		}
	}

	/*
	 * [227127] Literal element initializers
	 */
	public void testLiteralElementInitializers() {
		Edge a2b = createLink(getGenModel().getLinkC(), myNodeA, myNodeB);
		assertNotNull("There were no link kind restrictions, should be no problem to create a link", a2b);
		EObject linkObject = a2b.getElement();
		assertNotNull(linkObject);
		EStructuralFeature boolAttr = linkObject.eClass().getEStructuralFeature("boolToInit");
		assertNotNull(boolAttr);
		EStructuralFeature stringAttr = linkObject.eClass().getEStructuralFeature("stringToInit");
		assertNotNull(stringAttr);
		assertEquals("Value of boolean attribute after element creation should match one set in LinkSessionSetup", Boolean.TRUE, linkObject.eGet(boolAttr));
		assertEquals("Value of string attribute after element creation should match one set in LinkSessionSetup", "init-string", linkObject.eGet(stringAttr));
	}
	
	public void testDeepNewElementInitializers() {
		// Node_0
		EObject child = getFirstChildNode1(nodeAElement);
		// Node_0_0
		child = getFirstChildNode1(child);
		// Node_0_0_0
		child = getFirstChildNode1(child);
		// Node_0_0_0_0
		child = getFirstChildNode1(child);
		// Node_0_0_0_0_0
		child = getFirstChildNode1(child);
	}
	
	private EObject getFirstChildNode1(EObject parent) {
		EStructuralFeature feature = parent.eClass().getEStructuralFeature("nestedNodes1"); //$NON-NLS-1$		
		assertNotNull("feature not found in the intializer class", feature); //$NON-NLS-1$
		Object val = parent.eGet(feature);
		assertTrue(val instanceof Collection<?>);
		Collection<?> children = (Collection<?>) val;
		assertTrue("At least one child node expected", children.size() > 0);
		Object child = children.iterator().next();
		assertTrue("Child element dhould be EObject", child instanceof EObject);
		return (EObject) child;
	}
	
	public void testJavaInitializers() throws Exception {
		Class<?> javaContainerClass = getSetup().loadGeneratedClass(myElementInitializersClassName);
		assertNotNull("Could not find generated java initializer class", javaContainerClass); //$NON-NLS-1$

		GenJavaExpressionProvider javaProvider = null;
		GenExpressionProviderContainer container = getGenModel().getGenDiagram().getEditorGen().getExpressionProviders();
		for (GenExpressionProviderBase nextProvider : container.getProviders()) {
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

		Iterator<EObject> it = getGenModel().getGenDiagram().eAllContents();
		while (it.hasNext()) {
			Object element = it.next();
			if(element instanceof GenFeatureSeqInitializer) {
				GenFeatureSeqInitializer fsInitializer = (GenFeatureSeqInitializer) element;
				for (GenFeatureInitializer featureInitializer : fsInitializer.getInitializers()) {					
					if(!(featureInitializer instanceof GenFeatureValueSpec)) continue;
					GenFeatureValueSpec nextFtValSpec = (GenFeatureValueSpec)featureInitializer;						
					if (nextFtValSpec.getValue().getProvider() != javaProvider) continue;
					GenCommonBase diagramElement = null;
					if (fsInitializer.getTypeModelFacet().eContainer() instanceof GenCommonBase) {
						// hack to get required element to construct java operation name - 
						// assume model facets are contained in GenNode/GenLink
						diagramElement = (GenCommonBase ) fsInitializer.getTypeModelFacet().eContainer();
					}
					if (diagramElement == null) {
						continue; // just in case
					}

					// ElementInitializers.ext#javaMethodName
					StringBuilder operationName = new StringBuilder(nextFtValSpec.getFeature().getEcoreFeature().getName());
					operationName.append('_');
					if (nextFtValSpec.getFeatureSeqInitializer().getCreatingInitializer() != null) {
						operationName.append(nextFtValSpec.getFeatureSeqInitializer().getCreatingInitializer().getFeature().getEcoreFeature().getName());
						operationName.append('_');
					}
					operationName.append(diagramElement.getUniqueIdentifier());					
					Method method = findMethod(javaContainerClass, operationName.toString(), fsInitializer.getElementClass());
					assertNotNull("Can't find Java method:" + operationName.toString(), method);
					 
					GenFeature genFeature = nextFtValSpec.getFeature();
					if(genFeature.isPrimitiveType() && !genFeature.isListType()) {
						assertTrue("Use wrapper class for primitive return type", //$NON-NLS-1$
								!method.getReturnType().isPrimitive() && genFeature.isPrimitiveType());
						assertEquals(method.getReturnType(), EcoreUtil.wrapperClassFor(genFeature.getEcoreFeature().getEType().getInstanceClass())); 
						 
						primitiveTypeAttrTested = true;
					} 
					else if(!genFeature.isReferenceType() && genFeature.getEcoreFeature().isMany() && genFeature.getEcoreFeature().getEType().getInstanceClass().isPrimitive()) {
						assertEquals(List.class.getName(), method.getReturnType().getName());
						multiValPrimitiveTypeAttrTested = true;
					} 
					else if(!genFeature.isReferenceType() && !genFeature.isPrimitiveType() && !genFeature.isListType()) {
						assertEquals(genFeature.getType(genFeature.getGenClass()), method.getReturnType().getName());
						objValTypeAttrTested = true;
					} 
					else if(!genFeature.isReferenceType() && !genFeature.isPrimitiveType() && genFeature.isListType()) {
						assertEquals(List.class.getName(), method.getReturnType().getName());
						multiObjValTypeAttrTested = true;
					} 
					else if(genFeature.isReferenceType() && !genFeature.isListType()) {
						assertEquals(genFeature.getTypeGenClass().getQualifiedInterfaceName(), method.getReturnType().getName());
						refTested = true;
					}   							
					else if(genFeature.isReferenceType() && genFeature.isListType()) {
						assertEquals(List.class.getName(), method.getReturnType().getName());
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

	public void testAttrMany() throws Exception {
		EStructuralFeature attrManyFeature = nodeBElement.eClass().getEStructuralFeature("integers_Init"); //$NON-NLS-1$		
		assertNotNull("field not found in tested class", attrManyFeature); //$NON-NLS-1$
		Object value = nodeBElement.eGet(attrManyFeature);		
		assertEquals(value, Arrays.asList(new Object[] { new Integer(10), new Integer(20) }));		
	}
	
	
	public void testReferenceToMany() throws Exception {
		EStructuralFeature refToManyFeature = nodeAElement.eClass().getEStructuralFeature("reference_Init"); //$NON-NLS-1$		
		assertNotNull("field not found in tested class", refToManyFeature); //$NON-NLS-1$
		Object value = nodeAElement.eGet(refToManyFeature);		
		assertEquals(value, Arrays.asList(new Object[] { nodeAElement }));		
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
	
	public void testManyEnumLiteralAttr() throws Exception {		
		EStructuralFeature enumField = nodeAElement.eClass().getEStructuralFeature("manyEnumAttr_Init"); //$NON-NLS-1$		
		assertNotNull("enum field not found in tested class", enumField); //$NON-NLS-1$
		assertTrue(enumField.getEType() instanceof EEnum);
		
		EEnum testEnum = (EEnum) enumField.getEType();
		Collection<Enumerator> expectedValues = new ArrayList<Enumerator>();
		expectedValues.add(getEnumLiteralInstance(testEnum, "LIT0")); //$NON-NLS-1$
		expectedValues.add(getEnumLiteralInstance(testEnum, "LIT1")); //$NON-NLS-1$
		
		Object literalValues = nodeAElement.eGet(enumField);
		assertTrue(literalValues instanceof Collection<?>);
		Collection<?> retrivedValues = (Collection<?>) literalValues;
		assertEquals(expectedValues, retrivedValues);		
	}	

	public void testManyRealAttr() throws Exception {		
		EStructuralFeature realField = nodeAElement.eClass().getEStructuralFeature("manyRealAttr_Init"); //$NON-NLS-1$		
		assertNotNull("Float type attribute not found in tested class", realField); //$NON-NLS-1$
		
		Object realValues = nodeAElement.eGet(realField);
		assertTrue(realValues instanceof Collection<?>);
		Collection<?> retrivedValues = (Collection<?>) realValues;
		// @see LinkSessionSetup
		Collection<Float> expectedValues = new ArrayList<Float>();
		expectedValues.add(new Float(1.0));
		expectedValues.add(new Float(1.5));
		// 1->1.0 should involve known numeric type default conversion in Element Initializer
		assertEquals(expectedValues, retrivedValues);		
	}	
	
	private Enumerator getEnumLiteralInstance(EEnum eEnum, String literalName) {
		EEnumLiteral literal = eEnum.getEEnumLiteral(literalName);
		assertNotNull("Enum literal not found", literal); //$NON-NLS-1$
		assertNotNull("Enum literal has no instance", literal.getInstance()); //$NON-NLS-1$
		return literal.getInstance();
	}
	
	private Method findMethod(Class<?> clazz, String methodName, GenClass contextClass) throws Exception {
		try {
			Class<?>[] params = new Class[] { getSetup().loadGeneratedClass(contextClass.getQualifiedInterfaceName()) };
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
