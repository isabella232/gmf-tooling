/*
 * Copyright (c) 2006 Borland Software Corporation
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.internal.common.ToolingResourceFactory;
import org.eclipse.gmf.internal.common.migrate.MigrationHelper;
import org.eclipse.gmf.internal.common.migrate.MigrationHelperDelegate;
import org.eclipse.gmf.internal.common.migrate.MigrationResource;
import org.eclipse.gmf.internal.common.migrate.ModelLoadHelper;

/**
 * @author artem
 */
public class GenericMigrationTest extends TestCase {
	private EAttribute myAttrToRemove;

	public GenericMigrationTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		createMetaModel();
	}

	private void createMetaModel() {
		EPackage mm = EcoreFactory.eINSTANCE.createEPackage();
		EClass mc = EcoreFactory.eINSTANCE.createEClass();
		myAttrToRemove = EcoreFactory.eINSTANCE.createEAttribute();
		mm.getEClassifiers().add(mc);
		mc.getEStructuralFeatures().add(myAttrToRemove);
		mm.setName("MM1");
		mm.setNsPrefix("mm");
		mm.setNsURI("uri:/mm/1");
		mc.setName("MClass");
		myAttrToRemove.setName("myAttr");
		myAttrToRemove.setEType(EcorePackage.eINSTANCE.getEString());
	}

	private EObject newInstance() {
		return getMetaModel().getEFactoryInstance().create(myAttrToRemove.getEContainingClass());
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
							MigrationHelperDelegate delegate = new MigrationHelper.MigrationHelperDelegateImpl() {
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
			Resource migrated = migrateModel(factory, uri).getLoadedResource();
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

	private static ModelLoadHelper migrateModel(final Resource.Factory factory, URI modelResourceURI) {
		if(modelResourceURI == null) {
			throw new IllegalArgumentException("null resource uri"); //$NON-NLS-1$
		}
		ResourceSetImpl rset = new ResourceSetImpl();
		rset.setResourceFactoryRegistry(new ResourceFactoryRegistryImpl() {			
			public Factory getFactory(URI uri) {
				return factory;
			}
		});

		ModelLoadHelper loadHelper = new ModelLoadHelper(rset, modelResourceURI);
		return loadHelper;
	}	

}