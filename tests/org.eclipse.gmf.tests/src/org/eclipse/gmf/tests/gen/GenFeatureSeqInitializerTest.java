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
package org.eclipse.gmf.tests.gen;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureValueSpec;
import org.eclipse.gmf.codegen.gmfgen.GenReferenceNewElementSpec;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelMatcher;


public class GenFeatureSeqInitializerTest extends TestCase {	
	private GenModelMatcher genModelMatcher;
	private GenReferenceNewElementSpec newElementSpec_EClass_eReferences;
	private GenReferenceNewElementSpec newElementSpec_EClass_eReferences_eReferenceType;
	private GenFeatureSeqInitializer initializer_EClass_eReferences_eReferenceType;
	private GenFeatureSeqInitializer rootInitializer;
	private TypeModelFacet initializedModelFacet;
	private GenFeatureSeqInitializer initializer_EClass_eReferences;
	private GenFeatureValueSpec featureVal_EClass_name;
	private GenFeatureValueSpec featureVal_EClass_eReferences_name;
	private GenFeatureValueSpec featureVal_EClass_eReferences_eReferenceType_name;
	
	public GenFeatureSeqInitializerTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		// use ecore as test model
		this.genModelMatcher = new GenModelMatcher(EcorePackage.eINSTANCE);
		
		initializedModelFacet = createInitializedElement(EcorePackage.eINSTANCE.getEClass());
		assertNotNull(initializedModelFacet.getMetaClass());
		rootInitializer = (GenFeatureSeqInitializer)initializedModelFacet.getModelElementInitializer();
		featureVal_EClass_name = addFeatureValueSpec(rootInitializer, EcorePackage.eINSTANCE.getENamedElement_Name(), "'a Name'"); //$NON-NLS-1$
		
		newElementSpec_EClass_eReferences = addNewElementSpec(rootInitializer, EcorePackage.eINSTANCE.getEClass_EReferences());
		initializer_EClass_eReferences = createNewElementInitializer(newElementSpec_EClass_eReferences, null);
		featureVal_EClass_eReferences_name = addFeatureValueSpec(initializer_EClass_eReferences, EcorePackage.eINSTANCE.getENamedElement_Name(), "'a Name'"); //$NON-NLS-1$
		
		newElementSpec_EClass_eReferences_eReferenceType = addNewElementSpec(initializer_EClass_eReferences, EcorePackage.eINSTANCE.getEReference_EReferenceType());
		initializer_EClass_eReferences_eReferenceType = createNewElementInitializer(newElementSpec_EClass_eReferences_eReferenceType, null);
		featureVal_EClass_eReferences_eReferenceType_name = addFeatureValueSpec(initializer_EClass_eReferences_eReferenceType, EcorePackage.eINSTANCE.getENamedElement_Name(), "'a Name'"); //$NON-NLS-1$

	}

	public void testStructure() throws Exception {				
		assertNull(rootInitializer.getCreatingInitializer());
		assertSame(newElementSpec_EClass_eReferences, initializer_EClass_eReferences.getCreatingInitializer());
		assertSame(newElementSpec_EClass_eReferences_eReferenceType, initializer_EClass_eReferences_eReferenceType.getCreatingInitializer());		

		assertSame(rootInitializer, newElementSpec_EClass_eReferences.getFeatureSeqInitializer());	
		assertSame(initializer_EClass_eReferences, newElementSpec_EClass_eReferences_eReferenceType.getFeatureSeqInitializer());		
		
		assertTrue(rootInitializer.getInitializers().contains(newElementSpec_EClass_eReferences));
		assertTrue(initializer_EClass_eReferences.getInitializers().contains(newElementSpec_EClass_eReferences_eReferenceType));				
		
		assertSame(rootInitializer, featureVal_EClass_name.getFeatureSeqInitializer());		
		assertSame(initializer_EClass_eReferences, featureVal_EClass_eReferences_name.getFeatureSeqInitializer());
		assertSame(initializer_EClass_eReferences_eReferenceType, featureVal_EClass_eReferences_eReferenceType_name.getFeatureSeqInitializer());
		
		assertSame(initializedModelFacet, rootInitializer.getTypeModelFacet());		
		assertSame(initializedModelFacet, initializer_EClass_eReferences.getTypeModelFacet());
		assertSame(initializedModelFacet, initializer_EClass_eReferences_eReferenceType.getTypeModelFacet());
	}
	
	public void testObjectInitializerFieldName() throws Exception {
		String elementID = "EClass_101"; //$NON-NLS-1$
		assertEquals(elementID, rootInitializer.getInitializerFieldName(elementID));		
		assertEquals(newElementSpec_EClass_eReferences.getFeature().getName(), 
			initializer_EClass_eReferences.getInitializerFieldName(elementID));
		assertEquals(newElementSpec_EClass_eReferences.getFeature().getName() + "_" + newElementSpec_EClass_eReferences_eReferenceType.getFeature().getName(), //$NON-NLS-1$
			initializer_EClass_eReferences_eReferenceType.getInitializerFieldName(elementID));		

		
	}	
	
	public void testContext() throws Exception {
		assertNotNull(rootInitializer.getElementClass());
		assertSame(initializedModelFacet.getMetaClass(), rootInitializer.getElementClass());
		assertSame(initializer_EClass_eReferences.getElementClass(), newElementSpec_EClass_eReferences.getFeature().getTypeGenClass());
		assertSame(initializer_EClass_eReferences_eReferenceType.getElementClass(), newElementSpec_EClass_eReferences_eReferenceType.getFeature().getTypeGenClass());

		// test explicit context
		newElementSpec_EClass_eReferences_eReferenceType.setFeature(genModelMatcher.findGenFeature(EcorePackage.eINSTANCE.getETypedElement_EType()));
		assertSame(genModelMatcher.findGenClass(EcorePackage.eINSTANCE.getEClassifier()), initializer_EClass_eReferences_eReferenceType.getElementClass());
		// downcast the context to compatible sub-class
		GenClass expectedEClassCtx = genModelMatcher.findGenClass(EcorePackage.eINSTANCE.getEClass());
		initializer_EClass_eReferences_eReferenceType.setElementClass(expectedEClassCtx);		
		assertSame(expectedEClassCtx, initializer_EClass_eReferences_eReferenceType.getElementClass());
		// reset explicit context
		initializer_EClass_eReferences_eReferenceType.setElementClass(null);
		assertSame(genModelMatcher.findGenClass(EcorePackage.eINSTANCE.getEClassifier()), initializer_EClass_eReferences_eReferenceType.getElementClass());		
	}
	
	public void testAllFeatureSeqInitializes() throws Exception {
		List<GenFeatureSeqInitializer> initList = rootInitializer.getAllFeatureSeqInitializers();
		assertEquals(0, initList.indexOf(rootInitializer));
		assertEquals(1, initList.indexOf(initializer_EClass_eReferences));
		assertEquals(2, initList.indexOf(initializer_EClass_eReferences_eReferenceType));		
	}

	@SuppressWarnings("unchecked")	
	private GenFeatureSeqInitializer createNewElementInitializer(GenReferenceNewElementSpec newElementSpec, EClass elementClass) {
		GenFeatureSeqInitializer seqInitializer = GMFGenFactory.eINSTANCE.createGenFeatureSeqInitializer();
		seqInitializer.setElementClass(genModelMatcher.findGenClass(elementClass));
		newElementSpec.getNewElementInitializers().add(seqInitializer);
		return seqInitializer;
	}
	
	@SuppressWarnings("unchecked")	
	private GenReferenceNewElementSpec addNewElementSpec(GenFeatureSeqInitializer owningInitializer, EStructuralFeature eFeature) {
		GenReferenceNewElementSpec newElementSpec = GMFGenFactory.eINSTANCE.createGenReferenceNewElementSpec();
		newElementSpec.setFeature(genModelMatcher.findGenFeature(eFeature));
		owningInitializer.getInitializers().add(newElementSpec);
		return newElementSpec;
	}
	
	private TypeModelFacet createInitializedElement(EClass eClass) {
		TypeModelFacet modelFacet = GMFGenFactory.eINSTANCE.createTypeModelFacet();
		modelFacet.setMetaClass(genModelMatcher.findGenClass(eClass));
		
		GenFeatureSeqInitializer seqInitializer = GMFGenFactory.eINSTANCE.createGenFeatureSeqInitializer();
		modelFacet.setModelElementInitializer(seqInitializer);
		return modelFacet;
	}
	
	public void testElementClassFeauture() throws Exception {
		// should be readonly for the top initializer
		GenClass oldVal = rootInitializer.getElementClass();
		GenClass newVal = genModelMatcher.findGenClass(EcorePackage.eINSTANCE.getEAnnotation());
		assertNotSame(oldVal, newVal);
		rootInitializer.setElementClass(newVal);
		assertNotSame(newVal, rootInitializer.getElementClass());
		assertSame(oldVal, rootInitializer.getElementClass());
		
		oldVal = initializer_EClass_eReferences.getElementClass();
		assertNotSame(newVal, initializer_EClass_eReferences.getElementClass());
		initializer_EClass_eReferences.setElementClass(newVal);
		assertSame(newVal, initializer_EClass_eReferences.getElementClass());
		// setting null should result in the default derived from the feature type
		initializer_EClass_eReferences.setElementClass(null);
		assertSame(oldVal, initializer_EClass_eReferences.getElementClass());
	}
	
	@SuppressWarnings("unchecked")	
	private GenFeatureValueSpec addFeatureValueSpec(GenFeatureSeqInitializer owningInitializer, EStructuralFeature eFeature, String oclBody) {
		GenFeatureValueSpec valueSpec = GMFGenFactory.eINSTANCE.createGenFeatureValueSpec();
		valueSpec.setFeature(genModelMatcher.findGenFeature(eFeature));
		valueSpec.setBody(oclBody);

		owningInitializer.getInitializers().add(valueSpec);
		return valueSpec;
	}
}
