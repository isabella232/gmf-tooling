/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    dvorak - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.gmf.mappings.FeatureInitializer;
import org.eclipse.gmf.mappings.FeatureSeqInitializer;
import org.eclipse.gmf.mappings.FeatureValueSpec;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.MappingEntry;
import org.eclipse.gmf.mappings.ReferenceNewElementSpec;
import org.eclipse.gmf.mappings.provider.GMFMapItemProviderAdapterFactory;

@SuppressWarnings("unchecked")
public class HandcodedGMFMapItemProvidersTest extends TestCase {
	Resource resource; 
	
	public HandcodedGMFMapItemProvidersTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createURI("uri://myResource"); //$NON-NLS-1$
		this.resource = rs.getResource(uri, false);
		if (this.resource == null) {
			this.resource = rs.createResource(uri);
		}
		assertNotNull("Resource must have been created", this.resource); //$NON-NLS-1$
		// add ecore metamodel as the data source for  IItemPropertyDescriptor.getChoiceOfValues()
		rs.getResources().add(EcorePackage.eINSTANCE.eResource());
	}

	public void testReferenceNewElementInitializer() throws Exception {
		EStructuralFeature feature = GMFMapPackage.eINSTANCE.getFeatureInitializer_Feature();
		FeatureSeqInitializer fSeqInitializer = createRootInitializer(EcorePackage.eINSTANCE.getEClass());
		ReferenceNewElementSpec featureInitializer = GMFMapFactory.eINSTANCE.createReferenceNewElementSpec();
		fSeqInitializer.getInitializers().add(featureInitializer);

		// create new ReferenceNewElementInitializer
		featureInitializer.setFeature(EcorePackage.eINSTANCE.getEClass_EStructuralFeatures());
		FeatureSeqInitializer newElementInitializer = GMFMapFactory.eINSTANCE.createFeatureSeqInitializer();
		featureInitializer.getNewElementInitializers().add(newElementInitializer);
		
		Collection newEStructuralFeatureChoices = getChoiceOfValues(newElementInitializer, GMFMapPackage.eINSTANCE.getFeatureSeqInitializer_ElementClass());
		assertConcreteSubClasses(EcorePackage.eINSTANCE.getEStructuralFeature(), newEStructuralFeatureChoices);
		
		assertEquals("Only EReference, EAttribute subclasses expected", Arrays.asList(new EClass[] { //$NON-NLS-1$
				EcorePackage.eINSTANCE.getEAttribute(),
				EcorePackage.eINSTANCE.getEReference()
			}), newEStructuralFeatureChoices);

		FeatureValueSpec nestedFeatureValueSpec = GMFMapFactory.eINSTANCE.createFeatureValueSpec();
		newElementInitializer.getInitializers().add(nestedFeatureValueSpec);
		newElementInitializer.setElementClass(EcorePackage.eINSTANCE.getEAttribute());

		assertInitFeatures(EcorePackage.eINSTANCE.getEAttribute(), getChoiceOfValues(nestedFeatureValueSpec, feature));
		
		newElementInitializer.setElementClass(null);
		assertInitFeatures(EcorePackage.eINSTANCE.getEStructuralFeature(), getChoiceOfValues(nestedFeatureValueSpec, feature));		
	}
	
	public void testFeatureInitializer() throws Exception {
		EStructuralFeature feature = GMFMapPackage.eINSTANCE.getFeatureInitializer_Feature();
		FeatureSeqInitializer fSeqInitializer = createRootInitializer(EcorePackage.eINSTANCE.getEClass());
		FeatureInitializer featureInitializer = GMFMapFactory.eINSTANCE.createFeatureValueSpec();
		fSeqInitializer.getInitializers().add(featureInitializer);

		// no other choices for domain element as its derived from MappingEntry
		assertEquals(Collections.singleton(fSeqInitializer.getElementClass()), getChoiceOfValues(fSeqInitializer, GMFMapPackage.eINSTANCE.getFeatureSeqInitializer_ElementClass()));

		// test for EClass features only
		assertInitFeatures(EcorePackage.eINSTANCE.getEClass(), getChoiceOfValues(featureInitializer, feature));
		
		fSeqInitializer.getMappingEntry().setDomainMetaElement(null);
		assertEqualsChoices("All ecore features expected for no domain element", //$NON-NLS-1$
				appendNullChoice(getAllFeatures()), getChoiceOfValues(featureInitializer, feature));
	}

	void assertInitFeatures(EClass elementClass, Collection<EStructuralFeature> featureChoices) {
		assertTrue("multiple features expected", featureChoices.size() > 0); //$NON-NLS-1$
		for (EStructuralFeature nextFeature : featureChoices) {
			assertTrue("Feature must be changeable", nextFeature.isChangeable()); //$NON-NLS-1$
			assertTrue("Feature must come from the element EClas", nextFeature.getEContainingClass().isSuperTypeOf(elementClass)); //$NON-NLS-1$
		}
	}
	
	void assertConcreteSubClasses(EClass superClass, Collection<EClass> eClassChoices) {
		assertTrue("multiple EClasses expected", eClassChoices.size() > 0); //$NON-NLS-1$
		for (EClass nextClass : eClassChoices) {
			assertTrue("Choice EClass must be subClass", superClass.isSuperTypeOf(nextClass)); //$NON-NLS-1$
			assertTrue("Concrete EClass expected", !nextClass.isAbstract() && !nextClass.isInterface()); //$NON-NLS-1$
		}
	}
		
	private FeatureSeqInitializer createRootInitializer(EClass domainElement) {
		MappingEntry mappingEntry = GMFMapFactory.eINSTANCE.createNodeMapping();
		resource.getContents().add(mappingEntry);
		
		mappingEntry.setDomainMetaElement(domainElement);
		FeatureSeqInitializer fSeqInitializer = GMFMapFactory.eINSTANCE.createFeatureSeqInitializer();
		mappingEntry.setDomainInitializer(fSeqInitializer);
		return fSeqInitializer;
	}
	
	private static void assertEqualsChoices(String msg, Collection c1, Collection c2) {
		assertEquals(msg, new HashSet(c1), new HashSet(c2));
	}
	
	private static List<EClass> getAllEClasses() {
		List<EClass> allClasses = new ArrayList<EClass>();
		for (Iterator it = EcorePackage.eINSTANCE.getEClassifiers().iterator(); it.hasNext();) {
			EClassifier nextClassifier = (EClassifier) it.next();
			if(nextClassifier instanceof EClass) {
				allClasses.add((EClass)nextClassifier);
			}
		}
		return allClasses;
	}
	
	private List<EStructuralFeature> getAllFeatures() {
		List<EStructuralFeature> featList = new ArrayList<EStructuralFeature>();
		for (EClass eClass : getAllEClasses()) {
			featList.addAll(eClass.getEStructuralFeatures());
		}
		return featList;
	}
	
	private static <T> Collection<T> appendNullChoice(Collection<T> choices) {
		assertFalse(choices.contains(null));
		Collection<T> allWithNull = new ArrayList<T>(choices);
		allWithNull.add(null);
		return allWithNull;
	}
	
	private static Collection getChoiceOfValues(EObject object, EStructuralFeature featureToSet) {
		IItemPropertySource propertySource = (IItemPropertySource)new GMFMapItemProviderAdapterFactory().adapt(object, IItemPropertySource.class);
		IItemPropertyDescriptor propertyDescriptor = null;		
		for (Iterator it = propertySource.getPropertyDescriptors(object).iterator(); it.hasNext();) {
			IItemPropertyDescriptor nextDescriptor = (IItemPropertyDescriptor) it.next();
			if(nextDescriptor.getFeature(object) == featureToSet) {
				propertyDescriptor = nextDescriptor;
			}
		}
		assertNotNull("Property descriptor for " + featureToSet + " must exist", propertyDescriptor); //$NON-NLS-1$ //$NON-NLS-2$		
		return propertyDescriptor.getChoiceOfValues(object);
	}
}
