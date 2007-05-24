/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.migration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.gmf.internal.common.migrate.MigrationDelegate;
import org.eclipse.gmf.internal.common.migrate.MigrationDelegateImpl;
import org.eclipse.gmf.internal.common.migrate.MigrationResource;

/**
 * @author artem
 */
public class GenericMigrationTest extends TestCase {
	private EAttribute myAttrToRemove;
	private EAttribute myAttrToRename;
	private EReference myWidenedRef1;
	private EReference myWidenedRef2;
	private EAttribute myAttrNarrow;
	private EAttribute myAttrNarrowChild;

	public GenericMigrationTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		createMetaModel();
	}

	private EPackage createMetaModel() {
		EPackage mmPackage = EcoreFactory.eINSTANCE.createEPackage();
		EClass mClass = EcoreFactory.eINSTANCE.createEClass();
		myAttrToRemove = EcoreFactory.eINSTANCE.createEAttribute();
		myAttrToRename = EcoreFactory.eINSTANCE.createEAttribute();
		myWidenedRef1 = EcoreFactory.eINSTANCE.createEReference();
		myWidenedRef2 = EcoreFactory.eINSTANCE.createEReference();
		myAttrNarrow = EcoreFactory.eINSTANCE.createEAttribute();
		myAttrNarrowChild = EcoreFactory.eINSTANCE.createEAttribute();
		EClass mNarrowClass = EcoreFactory.eINSTANCE.createEClass();
		EClass mNarrowClassChild = EcoreFactory.eINSTANCE.createEClass();
		mNarrowClassChild.getESuperTypes().add(mNarrowClass);
		mmPackage.getEClassifiers().add(mClass);
		mmPackage.getEClassifiers().add(mNarrowClass);
		mmPackage.getEClassifiers().add(mNarrowClassChild);
		mClass.getEStructuralFeatures().add(myAttrToRemove);
		mClass.getEStructuralFeatures().add(myAttrToRename);
		mClass.getEStructuralFeatures().add(myWidenedRef1);
		mClass.getEStructuralFeatures().add(myWidenedRef2);
		mNarrowClass.getEStructuralFeatures().add(myAttrNarrow);
		mNarrowClassChild.getEStructuralFeatures().add(myAttrNarrowChild);
		mmPackage.setName("MM1");
		mmPackage.setNsPrefix("mm");
		mmPackage.setNsURI("uri:/mm/1");
		mClass.setName("MClass");
		mNarrowClass.setName("NarrowClass");
		mNarrowClassChild.setName("NarrowClassChild");
		myAttrToRemove.setName("myRemovedAttr");
		myAttrToRemove.setEType(EcorePackage.eINSTANCE.getEString());
		myAttrToRename.setName("myRenamedAttr");
		myAttrToRename.setEType(EcorePackage.eINSTANCE.getEString());
		myWidenedRef1.setName("myWidenedRef1");
		myWidenedRef1.setUpperBound(-1);
		myWidenedRef1.setContainment(true);
		myWidenedRef1.setEType(mNarrowClass);
		myWidenedRef2.setName("myWidenedRef2");
		myWidenedRef2.setUpperBound(-1);
		myWidenedRef2.setContainment(true);
		myWidenedRef2.setEType(mNarrowClass);
		myAttrNarrow.setName("myNarrowAttr");
		myAttrNarrow.setEType(EcorePackage.eINSTANCE.getEString());
		myAttrNarrowChild.setName("myNarrowChildAttr");
		myAttrNarrowChild.setLowerBound(1);
		myAttrNarrowChild.setEType(EcorePackage.eINSTANCE.getEString());
		return mmPackage;
	}

	private EObject newInstance() {
		return getMetaModel().getEFactoryInstance().create(myAttrToRemove.getEContainingClass());
	}

	private EObject newNarrowInstance() {
		return getMetaModel().getEFactoryInstance().create(myAttrNarrow.getEContainingClass());
	}

	private EObject newNarrowChildInstance() {
		return getMetaModel().getEFactoryInstance().create(myAttrNarrowChild.getEContainingClass());
	}

	private EPackage getMetaModel() {
		return myWidenedRef1.getEContainingClass().getEPackage();
	}

	private boolean checkResourceHasNoProblems(Resource migratedResource) {
		assertNotNull(migratedResource);
		assertTrue(migratedResource.getErrors().isEmpty());
		if (migratedResource instanceof MigrationResource) {
			assertFalse(migratedResource.getWarnings().isEmpty());
			assertEquals(1, migratedResource.getWarnings().size());
			assertTrue(migratedResource.getWarnings().get(0) instanceof MigrationResource.Diagnostic);
		} else {
			assertTrue(migratedResource.getWarnings().isEmpty());
		}
		boolean validate = true;
		for (Iterator<EObject> it=migratedResource.getAllContents(); it.hasNext() && validate;) {
			validate = EcoreValidator.INSTANCE.validate(it.next(), null, null);
		}
		return validate;
	}
	
	private String assertLoadingProblemsAfterMetamodelChanges(EPackage metamodel, URI modelResource) {
		String errorMessage = null;
		// try to load mm
		try {
			ResourceSetImpl rset = new ResourceSetImpl();
			rset.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
			Resource resource = rset.createResource(modelResource);
			resource.load(null);
			fail("Load should fail because of metamodel changes");
		} catch (RuntimeException ex) {
			// expected
			assertNotNull(ex.getMessage());
			errorMessage = ex.getMessage();
		} catch (IOException ex) {
			// expected
			assertNotNull(ex.getMessage());
			errorMessage = ex.getMessage();
		}

		return errorMessage;
	}

	private URI saveToResource(EPackage metamodel, String filenameStart, String fileextension, EObject... rootObjects) {
		URI uri = null;
		Collection<EObject> roots = Arrays.asList(rootObjects);
		try {
			uri = URI.createFileURI(File.createTempFile(filenameStart, fileextension.startsWith(".") ? fileextension : "."+fileextension).getAbsolutePath());
			ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
			resourceSetImpl.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
			Resource res = resourceSetImpl.createResource(uri);
			res.getContents().addAll(roots);
			res.save(null);
			resourceSetImpl.getResources().removeAll(roots);
		} catch (IOException ex) {
			fail(ex.toString());
		}
		return uri;
	}

	protected void checkNarrowedInstanceAttribute(EObject narrowInstance, EAttribute attribute, String attrValue) {
		assertEquals(narrowInstance.eClass(), attribute.getEContainingClass());
		assertTrue(narrowInstance.eIsSet(attribute));
		Object haveValue = narrowInstance.eGet(attribute, true);
		assertEquals(attrValue, haveValue);
	}

	protected List<EObject> checkReferenceIsNarrowed(EObject migratedObj, EReference widenedRef) {
		List<EObject> result = null;
		assertTrue(migratedObj.eIsSet(widenedRef));
		Object narrowRef = migratedObj.eGet(widenedRef, true);
		if (widenedRef.isMany()) {
			result = new ArrayList<EObject>();
			assertTrue(narrowRef instanceof EList);
			EList<?> narrowRefs = (EList<?>) narrowRef;
			assertFalse(narrowRefs.isEmpty());
			for (int i=0; i<narrowRefs.size(); i++) {
				Object migratedNarrowRefs = narrowRefs.get(i);
				assertTrue(migratedNarrowRefs instanceof EObject);
				EObject narrowInstance = (EObject) migratedNarrowRefs;
				result.add(narrowInstance);
			}
		} else {
			assertTrue(narrowRef instanceof EObject);
			EObject narrowInstance = (EObject) narrowRef;
			result = Collections.singletonList(narrowInstance);
		}
		return result;
	}

	private void checkInstanceClassChanged(EObject narrowInstance, EReference widenedReference) {
		assertFalse(narrowInstance.eClass().isAbstract());
		assertFalse(narrowInstance.eClass().equals(widenedReference.getEType()));
	}

	private void widenReferenceTypeFrom(EReference refToBeWiden, EClass containingClass, EPackage metamodel) {
		EClass mWideClass = EcoreFactory.eINSTANCE.createEClass();
		refToBeWiden.getEContainingClass().getEPackage().getEClassifiers().add(mWideClass);
		mWideClass.setName("WideClass");
		mWideClass.setAbstract(true);
		refToBeWiden.setEType(mWideClass);
		EList<EClass> supertypes = containingClass.getESuperTypes();
		if (!supertypes.contains(mWideClass)) {
			supertypes.add(mWideClass);
		}
	}

	private EList<EObject> create2DifferentReferences(String attrValue, String attrChildValue) {
		final EList<EObject> narrowInstances = new BasicEList<EObject>();
		if (attrValue != null) {
			EObject narrowInstance = newNarrowInstance();
			narrowInstance.eSet(myAttrNarrow, attrValue);
			narrowInstances.add(narrowInstance);
		}
		if (attrChildValue != null) {
			EObject narrowChildInstance = newNarrowChildInstance();
			narrowChildInstance.eSet(myAttrNarrowChild, attrChildValue);
			narrowInstances.add(narrowChildInstance);
		}
		return narrowInstances;
	}

	private EList<EObject> createNarrowReferences(String attrValue) {
		final EList<EObject> narrowInstances = new BasicEList<EObject>();
		if (attrValue != null) {
			EObject narrowInstance = newNarrowInstance();
			narrowInstance.eSet(myAttrNarrow, attrValue);
			narrowInstances.add(narrowInstance);
		}
		return narrowInstances;
	}

	private EObject createRootWithReferences(EReference reference, EList<EObject> referenceValues) {
		final EObject testObject1 = newInstance();
		testObject1.eSet(reference, referenceValues);
		return testObject1;
	}

	public void testRemovedAttribute() {
		final EObject testObject = newInstance();
		testObject.eSet(myAttrToRemove, "value");

		EPackage metamodel = getMetaModel();
		URI uri = saveToResource(metamodel, "removed", "tests", testObject);
		
		// remove attr from metamodel
		myAttrToRemove.getEContainingClass().getEStructuralFeatures().remove(myAttrToRemove);

		String errorMessage = assertLoadingProblemsAfterMetamodelChanges(metamodel, uri);
		assertTrue(errorMessage.contains(myAttrToRemove.getName()));

		final MigrationDelegateImpl delegate = new MigrationDelegateImpl();
		delegate.registerDeletedAttributes(testObject.eClass(), myAttrToRemove.getName());

		Resource migrated = loadMigrationResource(metamodel, delegate, uri);
		checkResourceHasNoProblems(migrated);
		
		assertEquals(1, migrated.getContents().size());
		EObject migratedObj = migrated.getContents().get(0);
		assertEquals(testObject.eClass(), migratedObj.eClass());

	}

	public void testWidenedReference() {
		final String attrValue = "narrow value";
		final EList<EObject> narrowValues = createNarrowReferences(attrValue);
		final EObject testObject = createRootWithReferences(myWidenedRef1, narrowValues);

		EPackage metamodel = getMetaModel();
		URI uri = saveToResource(metamodel, "widened", "tests", testObject);
		
		// widen reference in metamodel
		widenReferenceTypeFrom(myWidenedRef1, myAttrNarrow.getEContainingClass(), metamodel);
		
		// try to load mm
		String errorMessage = assertLoadingProblemsAfterMetamodelChanges(getMetaModel(), uri);
		//assertTrue(errorMessage.contains(myWidenedRef1.getEType().getName())); //XXX check
		
		MigrationDelegateImpl delegate = new MigrationDelegateImpl();
		delegate.registerNarrowedAbstractType(myWidenedRef1.getEType().getName(), myAttrNarrow.getEContainingClass());
		
		// try to load mm
		Resource migrated = loadMigrationResource(metamodel, delegate, uri);
		checkResourceHasNoProblems(migrated);
		
		assertEquals(1, migrated.getContents().size());
		EObject migratedObj = migrated.getContents().get(0);
		assertEquals(testObject.eClass(), migratedObj.eClass());
		
		List<EObject> narrowed = checkReferenceIsNarrowed(migratedObj, myWidenedRef1);
		assertEquals(1, narrowed.size());
		
		EObject narrowInstance = narrowed.get(0);
		checkInstanceClassChanged(narrowInstance, myWidenedRef1);
		checkNarrowedInstanceAttribute(narrowInstance, myAttrNarrow, attrValue);
	}

	public void testWidenedReferenceWith2Types() {
		final String attrValue = "narrow value";
		final String attrChildValue = "narrow child value";
		final EList<EObject> narrowValues = create2DifferentReferences(attrValue, attrChildValue);
		final EObject testObject = createRootWithReferences(myWidenedRef1, narrowValues);

		EPackage metamodel = getMetaModel();
		URI uri = saveToResource(metamodel, "widened2Types", "tests", testObject);

		// widen reference in metamodel
		widenReferenceTypeFrom(myWidenedRef1, myAttrNarrow.getEContainingClass(), metamodel);

		// try to load mm
		String errorMessage = assertLoadingProblemsAfterMetamodelChanges(metamodel, uri);
		// assertTrue(errorMessage.contains(myWidenedRef1.getEType().getName())); //XXX

		MigrationDelegateImpl delegate = new MigrationDelegateImpl();
		delegate.registerNarrowedAbstractType(myWidenedRef1.getEType().getName(), myAttrNarrow.getEContainingClass());

		// try to load mm
		Resource migrated = loadMigrationResource(metamodel, delegate, uri);
		checkResourceHasNoProblems(migrated);

		assertEquals(1, migrated.getContents().size());
		EObject migratedObj = migrated.getContents().get(0);
		assertEquals(testObject.eClass(), migratedObj.eClass());
		
		List<EObject> narrowed = checkReferenceIsNarrowed(migratedObj, myWidenedRef1);
		assertEquals(2, narrowed.size());
		
		EObject narrowInstance1 = narrowed.get(0);
		checkInstanceClassChanged(narrowInstance1, myWidenedRef1);
		checkNarrowedInstanceAttribute(narrowInstance1, myAttrNarrow, attrValue);
		
		EObject narrowInstance2 = narrowed.get(1);
		checkInstanceClassChanged(narrowInstance2, myWidenedRef1);
		checkNarrowedInstanceAttribute(narrowInstance2, myAttrNarrowChild, attrChildValue);
	}

	public void test2WidenedReferences() {
		final String attrValue1 = "narrow value 1";
		final EList<EObject> narrowValues1 = createNarrowReferences(attrValue1);
		final EObject testObject1 = createRootWithReferences(myWidenedRef1, narrowValues1);
		final String attrValue2 = "narrow value 2";
		final String attrChildValue2 = "narrow child value 2";
		final EList<EObject> narrowValues2 = create2DifferentReferences(attrValue2, attrChildValue2);
		final EObject testObject2 = createRootWithReferences(myWidenedRef2, narrowValues2);
		final String attrValue3 = "narrow value 3";
		final EList<EObject> narrowValues3 = createNarrowReferences(attrValue3);
		final EObject testObject3 = createRootWithReferences(myWidenedRef1, narrowValues3);
		final String attrValue4 = "narrow value 4";
		final EList<EObject> narrowValues4 = createNarrowReferences(attrValue4);
		final EObject testObject4 = createRootWithReferences(myWidenedRef2, narrowValues4);

		EPackage metamodel = getMetaModel();
		URI uri = saveToResource(metamodel, "widened2Refs", "tests", testObject1, testObject2, testObject3, testObject4);

		// widen reference in metamodel
		widenReferenceTypeFrom(myWidenedRef1, myAttrNarrow.getEContainingClass(), metamodel);
		widenReferenceTypeFrom(myWidenedRef2, myAttrNarrow.getEContainingClass(), metamodel);

		// try to load mm
		String errorMessage = assertLoadingProblemsAfterMetamodelChanges(metamodel, uri);
		// assertTrue(errorMessage.contains(myAttrNarrow.getName())); //XXX

		MigrationDelegateImpl delegate = new MigrationDelegateImpl();
		delegate.registerNarrowedAbstractType(myWidenedRef1.getEType().getName(), myAttrNarrow.getEContainingClass());
		delegate.registerNarrowedAbstractType(myWidenedRef2.getEType().getName(), myAttrNarrow.getEContainingClass());

		// try to load mm
		Resource migrated = loadMigrationResource(metamodel, delegate, uri);
		checkResourceHasNoProblems(migrated);

		assertEquals(4, migrated.getContents().size());
		
		EObject migratedObj1 = migrated.getContents().get(0);
		assertEquals(testObject1.eClass(), migratedObj1.eClass());
		
		List<EObject> narrowed1 = checkReferenceIsNarrowed(migratedObj1, myWidenedRef1);
		assertEquals(1, narrowed1.size());
		checkReferenceIsNarrowed(migratedObj1, myWidenedRef1);
		
		EObject narrowed1first = narrowed1.get(0);
		checkNarrowedInstanceAttribute(narrowed1first, myAttrNarrow, attrValue1);
		
		EObject migratedObj2 = migrated.getContents().get(1);
		assertEquals(testObject2.eClass(), migratedObj2.eClass());
		
		List<EObject> narrowed2 = checkReferenceIsNarrowed(migratedObj2, myWidenedRef2);
		assertEquals(2, narrowed2.size());
		checkReferenceIsNarrowed(migratedObj2, myWidenedRef2);
		
		EObject narrowed2first = narrowed2.get(0);
		checkNarrowedInstanceAttribute(narrowed2first, myAttrNarrow, attrValue2);
		
		EObject narrowed2second = narrowed2.get(1);
		checkNarrowedInstanceAttribute(narrowed2second, myAttrNarrowChild, attrChildValue2);
		
		EObject migratedObj3 = migrated.getContents().get(2);
		assertEquals(testObject3.eClass(), migratedObj3.eClass());
		
		List<EObject> narrowed3 = checkReferenceIsNarrowed(migratedObj3, myWidenedRef1);
		assertEquals(1, narrowed3.size());
		checkReferenceIsNarrowed(migratedObj3, myWidenedRef1);
		
		EObject narrowed3first = narrowed3.get(0);
		checkNarrowedInstanceAttribute(narrowed3first, myAttrNarrow, attrValue3);
		
		EObject migratedObj4 = migrated.getContents().get(3);
		assertEquals(testObject4.eClass(), migratedObj4.eClass());
		
		List<EObject> narrowed4 = checkReferenceIsNarrowed(migratedObj4, myWidenedRef2);
		assertEquals(1, narrowed3.size());
		checkReferenceIsNarrowed(migratedObj4, myWidenedRef2);
		
		EObject narrowed4first = narrowed4.get(0);
		checkNarrowedInstanceAttribute(narrowed4first, myAttrNarrow, attrValue4);
	}

	public void testWidenedReferenceWithDifferentDefaults() {
		// create model based on current metamodel
		String attrValue = "narrow value";
		String attrChildValue = "narrow child value";
		final EList<EObject> narrowValues = create2DifferentReferences(attrValue, attrChildValue);
		final EObject testObject = createRootWithReferences(myWidenedRef1, narrowValues);

		EPackage metamodel = getMetaModel();
		URI uri = saveToResource(metamodel, "widened2Defaults", "tests", testObject);

		// try to load mm
		try {
			ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
			resourceSetImpl.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
			Resource ordinaryResource = resourceSetImpl.createResource(uri);
			ordinaryResource.load(null);
			boolean validate = checkResourceHasNoProblems(ordinaryResource);
			assertTrue("Should not fail with obligatory metamodel attribute not set", validate);
		} catch (RuntimeException ex) {
			fail();
		} catch (IOException ex) {
			fail();
		}
		MigrationDelegateImpl badDelegate = new MigrationDelegateImpl();
		badDelegate.registerNarrowedAbstractType(myWidenedRef1.getEType().getName(), myAttrNarrowChild.getEContainingClass());

	
		// try to load mm
		Resource badMigrated = loadMigrationResource(getMetaModel(), badDelegate, uri);
		checkResourceHasNoProblems(badMigrated);
		boolean validateBad = checkResourceHasNoProblems(badMigrated);
		assertFalse("Should fail with obligatory metamodel attribute not set", validateBad);

		MigrationDelegateImpl delegate = new MigrationDelegateImpl() {
			{
				registerNarrowedAbstractType(myWidenedRef1.getEType().getName(), myAttrNarrowChild.getEContainingClass());
			}
			private Collection<EObject> myToBeChecked = new ArrayList<EObject>();

			@Override
			public void processObject(EObject result) {
				super.processObject(result);
				if (myAttrNarrowChild.getEContainingClass().equals(result.eClass())) {
					myToBeChecked.add(result);
				}
			}

			@Override
			public void postProcess() {
				super.postProcess();
				for (EObject narrowed : myToBeChecked) {
					if (!narrowed.eIsSet(myAttrNarrowChild)) {
						EObject defaultTyped = narrowed.eClass().getEPackage().getEFactoryInstance().create((EClass) myWidenedRef1.getEType());
						for (EStructuralFeature feature : narrowed.eClass().getEAllStructuralFeatures()) {
							if (narrowed.eIsSet(feature)) {
								defaultTyped.eSet(feature, narrowed.eGet(feature));
							}
						}
						EObject parent = narrowed.eContainer();
						@SuppressWarnings("unchecked")
						EList<EObject> children = (EList<EObject>) parent.eGet(myWidenedRef1);
						int index = children.indexOf(narrowed);
						children.remove(narrowed);
						children.add(index, defaultTyped);
					}
				}
			}
		};

		// try to load mm
		Resource migrated = loadMigrationResource(getMetaModel(), delegate, uri);
		checkResourceHasNoProblems(migrated);
		boolean validate = checkResourceHasNoProblems(migrated);
		assertTrue("Should not fail with obligatory metamodel attribute not set", validate);

		assertEquals(1, migrated.getContents().size());
		EObject migratedObj = migrated.getContents().get(0);
		assertEquals(testObject.eClass(), migratedObj.eClass());

		List<EObject> narrowed = checkReferenceIsNarrowed(migratedObj, myWidenedRef1);
		assertEquals(2, narrowed.size());

		EObject narrowInstance1 = narrowed.get(0);
		assertFalse(narrowInstance1.eClass().isAbstract());
		assertTrue(narrowInstance1.eClass().equals(myWidenedRef1.getEType()));
		checkNarrowedInstanceAttribute(narrowInstance1, myAttrNarrow, attrValue);

		EObject narrowInstance2 = narrowed.get(1);
		checkInstanceClassChanged(narrowInstance2, myWidenedRef1);
		checkNarrowedInstanceAttribute(narrowInstance2, myAttrNarrowChild, attrChildValue);
	}
	
	private Resource loadMigrationResource(EPackage metamodel, MigrationDelegate delegate, URI modelResourceURI) {
		if(modelResourceURI == null) {
			throw new IllegalArgumentException("null resource uri"); //$NON-NLS-1$
		}
		ResourceSetImpl rset = new ResourceSetImpl();
		rset.getResources().add(createMigrationResource(delegate, modelResourceURI));
		rset.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
		return rset.getResource(modelResourceURI, true);
	}
	
	private Resource createMigrationResource(final MigrationDelegate delegate, URI modelResourceURI) {
		return new MigrationResource(modelResourceURI) {
			protected MigrationDelegate createDelegate() {
				return delegate;
			}
		};
	}
}