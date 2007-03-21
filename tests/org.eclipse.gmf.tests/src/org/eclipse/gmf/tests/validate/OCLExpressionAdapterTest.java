/**
 * Copyright (c) 2006 Borland Software Corporation
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


import junit.framework.TestCase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.gmf.internal.validate.expressions.EnvironmentProvider;
import org.eclipse.gmf.internal.validate.expressions.ExpressionProviderRegistry;
import org.eclipse.gmf.internal.validate.expressions.IEvaluationEnvironment;
import org.eclipse.gmf.internal.validate.expressions.IModelExpression;
import org.eclipse.gmf.internal.validate.expressions.IModelExpressionProvider;
import org.eclipse.gmf.internal.validate.expressions.IParseEnvironment;
import org.eclipse.gmf.tests.EPath;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;

@SuppressWarnings("unchecked")
public class OCLExpressionAdapterTest extends TestCase {
	EClassifier context;
	IModelExpressionProvider provider;
	EPath modelAccess;
	
	public OCLExpressionAdapterTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		this.context = EcorePackage.eINSTANCE.getEClass();
		this.provider = ExpressionProviderRegistry.getInstance().getProvider("ocl"); //$NON-NLS-1$
		assertNotNull("OCL expression provider must be available", provider); //$NON-NLS-1$
		this.modelAccess = EPath.createEcorePathFromModel(Plugin.createURI(LinksSessionSetup.modelURI));		
	}

	public void testEnvVariables() throws Exception {
		EClassifier oclIntegerType = provider.createExpression("'aString'", context).getResultType();
		EClassifier oclBooleanType = provider.createExpression("true", context).getResultType();
		
		IParseEnvironment env = EnvironmentProvider.createParseEnv();
		env.setVariable("intVar", oclIntegerType);
		env.setVariable("boolVar", oclBooleanType);	

		Integer intVal = new Integer(1);
		Boolean boolVal = new Boolean(true);
		IEvaluationEnvironment evalEnv = EnvironmentProvider.createEvaluationEnv();
		evalEnv.setVariable("intVar", intVal);
		evalEnv.setVariable("boolVar", boolVal);

		EObject contextInstance = EcorePackage.eINSTANCE.getEClass();		
		
		assertSame(intVal, provider.createExpression("intVar", context, env).evaluate(contextInstance, evalEnv));
		assertSame(boolVal, provider.createExpression("boolVar", context, env).evaluate(contextInstance, evalEnv));		
	}
	
	public void testAssignReferenceMany() throws Exception {
		EReference ref = modelAccess.lookup("links::Root::elements", EReference.class); //$NON-NLS-1$
		
		assertTrue(expression("null.oclAsType(links::Node)").isAssignableToElement(ref)); //$NON-NLS-1$
		assertTrue(ref.getEReferenceType().isSuperTypeOf(modelAccess.lookup("links::Node", EClass.class))); //$NON-NLS-1$		

		assertTrue(expression("null.oclAsType(links::Container)").isAssignableToElement(ref)); //$NON-NLS-1$
		assertTrue(ref.getEReferenceType().isSuperTypeOf(modelAccess.lookup("links::Container", EClass.class))); //$NON-NLS-1$
		assertTrue(expression("Bag { null.oclAsType(links::Container) }").isAssignableToElement(ref)); //$NON-NLS-1$
		
		assertFalse(expression("null.oclAsType(links::Root)").isAssignableToElement(ref)); //$NON-NLS-1$
		assertFalse(ref.getEReferenceType().isSuperTypeOf(modelAccess.lookup("links::Root", EClass.class))); //$NON-NLS-1$		
	}

	public void testAssignReferenceSingle() throws Exception {
		EReference ref = modelAccess.lookup("links::Link::target", EReference.class); //$NON-NLS-1$

		assertTrue(expression("null.oclAsType(links::Node)").isAssignableToElement(ref)); //$NON-NLS-1$
		assertTrue(ref.getEReferenceType().isSuperTypeOf(modelAccess.lookup("links::Node", EClass.class))); //$NON-NLS-1$		
		assertTrue(expression("null.oclAsType(links::Container)").isAssignableToElement(ref)); //$NON-NLS-1$
		assertTrue(ref.getEReferenceType().isSuperTypeOf(modelAccess.lookup("links::Container", EClass.class))); //$NON-NLS-1$
		
		assertFalse(expression("null.oclAsType(links::Root)").isAssignableToElement(ref)); //$NON-NLS-1$
		assertFalse(ref.getEReferenceType().isSuperTypeOf(modelAccess.lookup("links::Root", EClass.class))); //$NON-NLS-1$

		assertFalse(expression("Bag{null.oclAsType(links::Root)}").isAssignableToElement(ref)); //$NON-NLS-1$
		assertFalse(ref.getEReferenceType().isSuperTypeOf(modelAccess.lookup("links::Root", EClass.class))); //$NON-NLS-1$		
	}	
	
	/*
	 * !!! Note: This testcase uses intentionally Type literals in order to cover usage
	 * 	of OCL TypeType as meta-types in assignment to ecore metamodel elements.   
	 */	
	public void testOCL_TypeType() throws Exception {
		EAttribute feature = createAttr(EcorePackage.eINSTANCE.getEClassifier());
		assertTrue(expression("links::TestEnum").isAssignableToElement(feature)); //$NON-NLS-1$		
		assertFalse(expression("links::TestEnum::LIT1").isAssignableToElement(feature)); //$NON-NLS-1$		
		
		assertTrue(expression("ecore::EInt").isAssignableToElement(feature)); //$NON-NLS-1$
		assertFalse("Collection can't be assigned to scalar", expression("Bag{ecore::EInt}").isAssignableToElement(feature)); //$NON-NLS-1$ //$NON-NLS-2$	
		feature.setUpperBound(-1); // set isMany = true
		assertTrue("Scalar should allowed to intialize feature[0..*]", expression("ecore::EInt").isAssignableToElement(feature)); //$NON-NLS-1$ //$NON-NLS-2$				
		assertTrue(expression("Bag{ecore::EInt, ecore::EInt}").isAssignableToElement(feature)); //$NON-NLS-1$
		assertTrue(expression("Bag{links::TestEnum}").isAssignableToElement(feature)); //$NON-NLS-1$		
		
		EReference ref = createRef(EcorePackage.eINSTANCE.getEClass());
		assertFalse(expression("ecore::EInt").isAssignableToElement(ref)); //$NON-NLS-1$	
		assertTrue(expression("links::Node").isAssignableToElement(ref)); //$NON-NLS-1$
		ref.setUpperBound(-1); // set isMany = true
		assertTrue(expression("Bag{links::Node}").isAssignableToElement(ref)); //$NON-NLS-1$
		assertFalse(expression("Bag{ecore::EInt}").isAssignableToElement(ref)); //$NON-NLS-1$		
	}
		
	public void testOCLTypes() throws Exception {
		EAttribute feature = createAttr(EcorePackage.eINSTANCE.getEDouble());
		assertTrue("Integer should be taken as Real", expression("self->size()").isAssignableToElement(feature)); //$NON-NLS-1$ //$NON-NLS-2$
		assertTrue(expression("1.5").isAssignableToElement(feature)); //$NON-NLS-1$		

		assertFalse("Cardinality mismatch", expression("Sequence{10}").isAssignableToElement(feature)); //$NON-NLS-1$ //$NON-NLS-2$		
		feature.setUpperBound(-1); // set isMany = true
		// test many = true for all OCL CollectionTypes
		// any CollectionType should be compatible for assignement to a feature [isMany = true]
		assertTrue("Bag must be compatible to feature [0..*]", expression("Bag{self->size()/*int*/}").isAssignableToElement(feature)); //$NON-NLS-1$ //$NON-NLS-2$
		assertTrue("Sequence must be compatible to feature [0..*]", expression("Sequence{self->size()/*int*/}").isAssignableToElement(feature)); //$NON-NLS-1$ //$NON-NLS-2$		
		assertTrue("Set must be compatible to feature [0..*]", expression("Set{self->size()/*int*/}").isAssignableToElement(feature)); //$NON-NLS-1$ //$NON-NLS-2$		
		assertTrue("OrderedSet must be compatible to feature [0..*]", expression("OrderedSet{self->size()/*int*/}").isAssignableToElement(feature)); //$NON-NLS-1$ //$NON-NLS-2$
		
		// checking mixing different types with common super type  
		assertTrue("OrderedSet must be compatible to feature [0..*]", expression("Bag{ 10, 5.33 }").isAssignableToElement(feature)); //$NON-NLS-1$ //$NON-NLS-2$
		
		// check Real not conformant to Integer
		EAttribute intFeature = createAttr(EcorePackage.eINSTANCE.getEInt());
		assertFalse("Real can't be assigned to Integer", expression("1.55").isAssignableToElement(intFeature)); //$NON-NLS-1$ //$NON-NLS-2$		
		assertTrue(expression("15").isAssignableToElement(intFeature)); //$NON-NLS-1$		
	}
	
	public void testPrimitivesConversion() throws Exception {
		assertTrue(expression("true").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEBoolean()))); //$NON-NLS-1$
		assertTrue(expression("true").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEBooleanObject()))); //$NON-NLS-1$

		assertTrue(expression("1").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEInt()))); //$NON-NLS-1$		
		assertTrue(expression("1").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEIntegerObject()))); //$NON-NLS-1$
		// EMFT OCL does not support Byte/byte types 
//		assertTrue(expression("1").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEByte()))); //$NON-NLS-1$		
//		assertTrue(expression("1").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEByteObject()))); //$NON-NLS-1$
		assertTrue(expression("1").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEShort()))); //$NON-NLS-1$		
		assertTrue(expression("1").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEShortObject()))); //$NON-NLS-1$
		assertTrue(expression("1").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getELong()))); //$NON-NLS-1$		
		assertTrue(expression("1").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getELongObject()))); //$NON-NLS-1$
		
		assertFalse(expression("1.5").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEInt()))); //$NON-NLS-1$		
		assertFalse(expression("1.5").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEIntegerObject()))); //$NON-NLS-1$
		assertFalse(expression("1.5").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEShort()))); //$NON-NLS-1$		
		assertFalse(expression("1.5").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEShortObject()))); //$NON-NLS-1$
		assertFalse(expression("1.5").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getELong()))); //$NON-NLS-1$		
		assertFalse(expression("1.5").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getELongObject()))); //$NON-NLS-1$		
		
				
		assertTrue(expression("1.5").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEFloat()))); //$NON-NLS-1$		
		assertTrue(expression("1.5").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEFloatObject()))); //$NON-NLS-1$						
		assertTrue(expression("1.5").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEDouble()))); //$NON-NLS-1$		
		assertTrue(expression("1.5").isAssignableToElement(createAttr(EcorePackage.eINSTANCE.getEDoubleObject()))); //$NON-NLS-1$		
	}
	
	public void testEnumerationLiteral() throws Exception {
		EAttribute attr = modelAccess.lookup("links::Container::enumAttr_Init", EAttribute.class); //$NON-NLS-1$
		assertTrue(expression("links::TestEnum::LIT1").isAssignableToElement(attr)); //$NON-NLS-1$		
		assertFalse(expression("links::TestEnum").isAssignableToElement(attr)); //$NON-NLS-1$
		
		EAttribute manyEnumsAttr = createAttr(modelAccess.lookup("links::TestEnum", EClassifier.class)); //$NON-NLS-1$
		manyEnumsAttr.setUpperBound(-1);
		assertTrue(expression("Bag{links::TestEnum::LIT0, links::TestEnum::LIT1}").isAssignableToElement(manyEnumsAttr)); //$NON-NLS-1$
		assertFalse(expression("Bag{links::TestEnum}").isAssignableToElement(manyEnumsAttr)); //$NON-NLS-1$		
	}
		
	IModelExpression expression(String body) throws Exception {
		EPackage.Registry reg = new EPackageRegistryImpl();
		reg.putAll(EPackage.Registry.INSTANCE);
		EPackage model = modelAccess.lookup("links", EPackage.class); //$NON-NLS-1$
		reg.put(model.getNsURI(), model);

		IParseEnvironment env = EnvironmentProvider.createParseEnv();		
		env.setImportRegistry(reg);		
		
		IModelExpression expression = provider.createExpression(body, context, env);
		
		assertTrue("Invalid body: " + expression.getStatus().getMessage(), expression.getStatus().isOK()); //$NON-NLS-1$
		return expression;
	}
	
	EAttribute createAttr(EClassifier eType) {
		assertNotNull("non-null type required ", eType); //$NON-NLS-1$
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("myFeature_" + eType.getName()); //$NON-NLS-1$
		attribute.setEType(eType);
		return attribute;
	}
	
	EReference createRef(EClass eType) {
		assertNotNull("non-null type required ", eType); //$NON-NLS-1$
		EReference ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setName("myFeature_" + eType.getName()); //$NON-NLS-1$
		ref.setEType(eType);
		return ref;
	}	
}
