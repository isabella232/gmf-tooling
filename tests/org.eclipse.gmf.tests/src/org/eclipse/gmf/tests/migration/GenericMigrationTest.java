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
import java.util.Collection;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.internal.common.ToolingResourceFactory;
import org.eclipse.gmf.internal.common.migrate.MigrationHelperDelegate;
import org.eclipse.gmf.internal.common.migrate.MigrationHelperDelegateImpl;
import org.eclipse.gmf.internal.common.migrate.MigrationResource;
import org.eclipse.gmf.internal.common.migrate.ModelLoadHelper;

/**
 * @author artem
 */
public class GenericMigrationTest extends TestCase {
	private EAttribute myAttrToRemove;
	private EAttribute myAttrToRename;
	private EReference myWidenedRef;
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

	private void createMetaModel() {
		EPackage mmPackage = EcoreFactory.eINSTANCE.createEPackage();
		EClass mClass = EcoreFactory.eINSTANCE.createEClass();
		myAttrToRemove = EcoreFactory.eINSTANCE.createEAttribute();
		myAttrToRename = EcoreFactory.eINSTANCE.createEAttribute();
		myWidenedRef = EcoreFactory.eINSTANCE.createEReference();
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
		mClass.getEStructuralFeatures().add(myWidenedRef);
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
		myWidenedRef.setName("myWidenedRef");
		myWidenedRef.setUpperBound(-1);
		myWidenedRef.setContainment(true);
		myWidenedRef.setEType(mNarrowClass);
		myAttrNarrow.setName("myNarrowAttr");
		myAttrNarrow.setEType(EcorePackage.eINSTANCE.getEString());
		myAttrNarrowChild.setName("myNarrowChildAttr");
		myAttrNarrowChild.setEType(EcorePackage.eINSTANCE.getEString());
	}

	private EObject newInstance() {
		return getMetaModel().getEFactoryInstance().create(myAttrToRemove.getEContainingClass());
	}

	private EObject newNarrowInstance() {
		return getMetaModel().getEFactoryInstance().create(myWidenedRef.getEReferenceType());
	}

	private EObject newNarrowChildInstance() {
		return getMetaModel().getEFactoryInstance().create(myAttrNarrowChild.getEContainingClass());
	}

	private EPackage getMetaModel() {
		return myAttrToRemove.getEContainingClass().getEPackage();
	}

	public void oldTestRemovedAttribute() {
		final EObject testObject = newInstance();
		testObject.eSet(myAttrToRemove, "value");

		final String oldNsURI = getMetaModel().getNsURI();
		EPackage.Registry.INSTANCE.put(oldNsURI, getMetaModel());
		final String newNsURI = oldNsURI + "/2";
		EPackage.Registry.INSTANCE.put(newNsURI, getMetaModel());

		try {
			URI uri = null;
			try {
				uri = URI.createFileURI(File.createTempFile("removed", ".tests").getAbsolutePath());
				final ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
				final Resource res = resourceSetImpl.createResource(uri);
				res.getContents().add(testObject);
				res.save(null);
				resourceSetImpl.getResources().remove(testObject);
			} catch (IOException ex) {
				fail(ex.toString());
			}
			// remove attr from metamodel
			myAttrToRemove.getEContainingClass().getEStructuralFeatures().remove(myAttrToRemove);

			// try to load mm
			try {
				new ResourceSetImpl().createResource(uri).load(null);
				fail("Load should fail because of missing meta-model attribute");
			} catch (IOException ex) {
				// expected
				assertNotNull(ex.getMessage());
				assertTrue(ex.getMessage().contains(myAttrToRemove.getName()));
			}

			EPackage.Registry.INSTANCE.put(oldNsURI, null);

//			MigrationConfig.Registry.INSTANCE.register(new MigrationConfig.Descriptor() {
//				private final MigrationConfig cfg = new MigrationConfig(newNsURI, new String[] { oldNsURI });
//				{
//					cfg.registerDeletedAttribute(testObject.eClass(), myAttrToRemove.getName());
//				}
//
//				public MigrationConfig getConfig() {
//					return cfg;
//				}
//
//				public String getExtension() {
//					return "tests";
//				}
//
//			});
//			Resource migrated = MigrationUtil.migrateModel(uri).getLoadedResource();
//			assertNotNull(migrated);
//			assertTrue(migrated.getErrors().isEmpty() && migrated.getWarnings().isEmpty());
//			assertEquals(1, migrated.getContents().size());
//			EObject migratedObj = migrated.getContents().get(0);
//			assertEquals(testObject.eClass(), migratedObj.eClass());
		} finally {
			// clean-up, avoid any chances to affect other tests
			// XXX MigrationConfig should be cleaned as well.
			EPackage.Registry.INSTANCE.put(oldNsURI, null);
			EPackage.Registry.INSTANCE.put(newNsURI, null);
		}
	}

	public void testRemovedAttribute() {
		final EObject testObject = newInstance();
		testObject.eSet(myAttrToRemove, "value");

		final String oldNsURI = getMetaModel().getNsURI();
		EPackage.Registry.INSTANCE.put(oldNsURI, getMetaModel());
		final String newNsURI = oldNsURI + "/2";
		EPackage.Registry.INSTANCE.put(newNsURI, getMetaModel());

		try {
			URI uri = null;
			try {
				uri = URI.createFileURI(File.createTempFile("removed", ".tests").getAbsolutePath());
				final ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
				final Resource res = resourceSetImpl.createResource(uri);
				res.getContents().add(testObject);
				res.save(null);
				resourceSetImpl.getResources().remove(testObject);
			} catch (IOException ex) {
				fail(ex.toString());
			}
			// remove attr from metamodel
			myAttrToRemove.getEContainingClass().getEStructuralFeatures().remove(myAttrToRemove);

			// try to load mm
			try {
				new ResourceSetImpl().createResource(uri).load(null);
				fail("Load should fail because of missing meta-model attribute");
			} catch (IOException ex) {
				// expected
				assertNotNull(ex.getMessage());
				assertTrue(ex.getMessage().contains(myAttrToRemove.getName()));
			}

			EPackage.Registry.INSTANCE.put(oldNsURI, null);

			Resource.Factory factory = new ToolingResourceFactory() {

				@Override
				public Resource createResource(URI uri) {
					return new MigrationResource(uri) {
						protected MigrationHelperDelegate createDelegate() {
							MigrationHelperDelegate delegate = new MigrationHelperDelegateImpl() {
								{
									registerDeletedAttributes(testObject.eClass(), myAttrToRemove.getName());
								}
							};
							return delegate;
						}

						protected Collection<String> getBackwardSupportedURIs() {
							return Collections.singleton(oldNsURI);
						}

						protected String getMetamodelNsURI() {
							return newNsURI;
						}
					};
				}
				
			};
			Resource migrated = createLoadHelper(factory, uri).getLoadedResource();
			assertNotNull(migrated);
			assertTrue(migrated.getErrors().isEmpty());
			assertFalse(migrated.getWarnings().isEmpty());
			assertEquals(1, migrated.getContents().size());
			EObject migratedObj = migrated.getContents().get(0);
			assertEquals(testObject.eClass(), migratedObj.eClass());
		} finally {
			// clean-up, avoid any chances to affect other tests
			// XXX MigrationConfig should be cleaned as well.
			EPackage.Registry.INSTANCE.put(oldNsURI, null);
			EPackage.Registry.INSTANCE.put(newNsURI, null);
		}
	}

	public void testWidenedReference() {
		final EObject testObject = newInstance();
		EObject narrowValue = newNarrowInstance();
		String attrValue = "narrow value";
		
		narrowValue.eSet(myAttrNarrow, attrValue);
		EList narrowValues = new BasicEList();
		narrowValues.add(narrowValue);
		testObject.eSet(myWidenedRef, narrowValues);

		EPackage metamodel = getMetaModel();
		
		final String oldNsURI = metamodel.getNsURI();
		EPackage.Registry.INSTANCE.put(oldNsURI, metamodel);
		final String newNsURI = oldNsURI + "/2";
		EPackage.Registry.INSTANCE.put(newNsURI, metamodel);

		try {
			URI uri = null;
			try {
				uri = URI.createFileURI(File.createTempFile("widened", ".tests").getAbsolutePath());
				final ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
				final Resource res = resourceSetImpl.createResource(uri);
				res.getContents().add(testObject);
				res.save(null);
				resourceSetImpl.getResources().remove(testObject);
			} catch (IOException ex) {
				fail(ex.toString());
			}
			
			// widen reference in metamodel
			
			EClass mWideClass = EcoreFactory.eINSTANCE.createEClass();
			myWidenedRef.getEContainingClass().getEPackage().getEClassifiers().add(mWideClass);
			mWideClass.setName("WideClass");
			mWideClass.setAbstract(true);
			myWidenedRef.setEType(mWideClass);
			myAttrNarrow.getEContainingClass().getESuperTypes().add(mWideClass);
			
			// try to load mm
			try {
				new ResourceSetImpl().createResource(uri).load(null);
				fail("Load should fail because of unknown meta-model attribute");
			} catch (RuntimeException ex) {
				// expected
				assertNotNull(ex.getMessage());
			} catch (IOException ex) {
				// expected
				assertNotNull(ex.getMessage());
			}

			EPackage.Registry.INSTANCE.put(oldNsURI, null);

			Resource.Factory factory = new ToolingResourceFactory() {

				@Override
				public Resource createResource(URI uri) {
					return new MigrationResource(uri) {
						protected MigrationHelperDelegate createDelegate() {
							MigrationHelperDelegate delegate = new MigrationHelperDelegateImpl() {
								{
									registerNarrowReferenceType(myWidenedRef, myAttrNarrow.getEContainingClass());
								}
							};
							return delegate;
						}

						protected Collection<String> getBackwardSupportedURIs() {
							return Collections.<String>singleton(oldNsURI);
						}

						@Override
						protected String getMetamodelNsURI() {
							return newNsURI;
						}
					};
				}
				
			};
			
			// try to load mm
			Resource migrated = createLoadHelper(factory, uri).getLoadedResource();
			assertNotNull(migrated);
			assertTrue(migrated.getErrors().isEmpty());
			assertFalse(migrated.getWarnings().isEmpty());
			assertEquals(1, migrated.getContents().size());
			EObject migratedObj = migrated.getContents().get(0);
			assertEquals(testObject.eClass(), migratedObj.eClass());
			
			assertTrue(migratedObj.eIsSet(myWidenedRef));
			Object narrowRef = migratedObj.eGet(myWidenedRef, true);
			assertTrue(narrowRef instanceof EList);
			EList narrowRefs = (EList) narrowRef;
			assertFalse(narrowRefs.isEmpty());
			assertEquals(1, narrowRefs.size());
			Object narrowRefsFirst = narrowRefs.get(0);
			assertTrue(narrowRefsFirst instanceof EObject);
			EObject narrowInstance = (EObject) narrowRefsFirst;
			assertFalse(narrowInstance.eClass().isAbstract());
			assertFalse(narrowInstance.eClass().equals(myWidenedRef.getEType()));
			assertEquals(narrowInstance.eClass(), myAttrNarrow.getEContainingClass());
			assertTrue(narrowInstance.eIsSet(myAttrNarrow));
			Object haveValue = narrowInstance.eGet(myAttrNarrow, true);
			assertEquals(attrValue, haveValue);
		} finally {
			// clean-up, avoid any chances to affect other tests
			EPackage.Registry.INSTANCE.put(oldNsURI, null);
			EPackage.Registry.INSTANCE.put(newNsURI, null);
		}
	}

	public void testWidenedReferenceWith2Types() {
		final EObject testObject = newInstance();
		EObject narrowValue = newNarrowInstance();
		String attrValue = "narrow value";
		EObject narrowChildValue = newNarrowChildInstance();
		String attrChildValue = "narrow child value";
		
		narrowValue.eSet(myAttrNarrow, attrValue);
		narrowChildValue.eSet(myAttrNarrowChild, attrChildValue);
		EList narrowValues = new BasicEList();
		narrowValues.add(narrowValue);
		narrowValues.add(narrowChildValue);
		testObject.eSet(myWidenedRef, narrowValues);

		EPackage metamodel = getMetaModel();
		
		final String oldNsURI = metamodel.getNsURI();
		EPackage.Registry.INSTANCE.put(oldNsURI, metamodel);
		final String newNsURI = oldNsURI + "/2";
		EPackage.Registry.INSTANCE.put(newNsURI, metamodel);

		try {
			URI uri = null;
			try {
				uri = URI.createFileURI(File.createTempFile("widened2Types", ".tests").getAbsolutePath());
				final ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
				final Resource res = resourceSetImpl.createResource(uri);
				res.getContents().add(testObject);
				res.save(null);
				resourceSetImpl.getResources().remove(testObject);
			} catch (IOException ex) {
				fail(ex.toString());
			}
			
			// widen reference in metamodel
			
			EClass mWideClass = EcoreFactory.eINSTANCE.createEClass();
			myWidenedRef.getEContainingClass().getEPackage().getEClassifiers().add(mWideClass);
			mWideClass.setName("WideClass");
			mWideClass.setAbstract(true);
			myWidenedRef.setEType(mWideClass);
			myAttrNarrow.getEContainingClass().getESuperTypes().add(mWideClass);
			
			// try to load mm
			try {
				new ResourceSetImpl().createResource(uri).load(null);
				fail("Load should fail because of unknown meta-model attribute");
			} catch (RuntimeException ex) {
				// expected
				assertNotNull(ex.getMessage());
			} catch (IOException ex) {
				// expected
				assertNotNull(ex.getMessage());
			}

			EPackage.Registry.INSTANCE.put(oldNsURI, null);

			Resource.Factory factory = new ToolingResourceFactory() {

				@Override
				public Resource createResource(URI uri) {
					return new MigrationResource(uri) {
						protected MigrationHelperDelegate createDelegate() {
							MigrationHelperDelegate delegate = new MigrationHelperDelegateImpl() {
								{
									registerNarrowReferenceType(myWidenedRef, myAttrNarrow.getEContainingClass());
								}
							};
							return delegate;
						}

						protected Collection<String> getBackwardSupportedURIs() {
							return Collections.<String>singleton(oldNsURI);
						}

						@Override
						protected String getMetamodelNsURI() {
							return newNsURI;
						}
					};
				}
				
			};
			
			// try to load mm
			Resource migrated = createLoadHelper(factory, uri).getLoadedResource();
			assertNotNull(migrated);
			assertTrue(migrated.getErrors().isEmpty());
			assertFalse(migrated.getWarnings().isEmpty());
			assertEquals(1, migrated.getContents().size());
			EObject migratedObj = migrated.getContents().get(0);
			assertEquals(testObject.eClass(), migratedObj.eClass());
			
			assertTrue(migratedObj.eIsSet(myWidenedRef));
			Object narrowRefList = migratedObj.eGet(myWidenedRef, true);
			assertTrue(narrowRefList instanceof EList);
			EList narrowInstancesList = (EList) narrowRefList;
			assertFalse(narrowInstancesList.isEmpty());
			assertEquals(2, narrowInstancesList.size());
			
			Object narrowRefsFirst = narrowInstancesList.get(0);
			assertTrue(narrowRefsFirst instanceof EObject);
			EObject narrowInstance1 = (EObject) narrowRefsFirst;
			assertFalse(narrowInstance1.eClass().isAbstract());
			assertFalse(narrowInstance1.eClass().equals(myWidenedRef.getEType()));
			assertEquals(narrowInstance1.eClass(), myAttrNarrow.getEContainingClass());
			assertTrue(narrowInstance1.eIsSet(myAttrNarrow));
			Object haveValue = narrowInstance1.eGet(myAttrNarrow, true);
			assertEquals(attrValue, haveValue);

			Object narrowRefsSecond = narrowInstancesList.get(1);
			assertTrue(narrowRefsSecond instanceof EObject);
			EObject narrowInstance2 = (EObject) narrowRefsSecond;
			assertFalse(narrowInstance2.eClass().isAbstract());
			assertFalse(narrowInstance2.eClass().equals(myWidenedRef.getEType()));
			assertEquals(narrowInstance2.eClass(), myAttrNarrowChild.getEContainingClass());
			assertTrue(narrowInstance2.eIsSet(myAttrNarrowChild));
			Object haveChildValue = narrowInstance2.eGet(myAttrNarrowChild, true);
			assertEquals(attrChildValue, haveChildValue);
		} finally {
			// clean-up, avoid any chances to affect other tests
			EPackage.Registry.INSTANCE.put(oldNsURI, null);
			EPackage.Registry.INSTANCE.put(newNsURI, null);
		}
	}

	private static ModelLoadHelper createLoadHelper(final Resource.Factory factory, URI modelResourceURI) {
		if(modelResourceURI == null) {
			throw new IllegalArgumentException("null resource uri"); //$NON-NLS-1$
		}
		ResourceSetImpl rset = new ResourceSetImpl();
		rset.setResourceFactoryRegistry(new ResourceFactoryRegistryImpl() {			
			public Resource.Factory getFactory(URI uri) {
				return factory;
			}
		});

		return new ModelLoadHelper(rset, modelResourceURI);
	}	
}