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
package org.eclipse.gmf.tests.migration;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.FeatureNotFoundException;
import org.eclipse.gmf.internal.common.ToolingResourceFactory;
import org.eclipse.gmf.internal.common.migrate.MigrationUtil;
import org.eclipse.gmf.internal.common.migrate.ModelLoadHelper;
import org.eclipse.gmf.tests.Plugin;


public class MigrationPatchesTest extends TestCase {

	public MigrationPatchesTest(String name) {
		super(name);
	}
	
	/*
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=160894
	 */	
	public void testPatch_160894() throws Exception {
		String genmodelFileName = "patch_160894.gmfgen"; //$NON-NLS-1$
		
		Exception caughtException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("Expected wrapped runtime exception", caughtException instanceof WrappedException); //$NON-NLS-1$
		WrappedException wrappedException = (WrappedException)caughtException;
		assertTrue("Expected feature not found error", wrappedException.getCause() instanceof FeatureNotFoundException); //$NON-NLS-1$
		
		assertOnLoadModelMigrationSuccess(genmodelFileName);
	}
	
	/*
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=138440
	 */
	public void testPatch_138440() throws Exception {
		String genmodelFileName = "patch_138440.gmfgen"; //$NON-NLS-1$
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected IllegalArgumentException from metamodel EFactory", caughtGenException instanceof IllegalArgumentException); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);
		
		String gmfmapmodelFileName = "patch_138440.gmfmap"; //$NON-NLS-1$		
		Exception caughtMapException = assertOrdinaryLoadModelProblems(gmfmapmodelFileName);
		assertTrue("expected IllegalArgumentException from metamodel EFactory", caughtMapException instanceof IllegalArgumentException); //$NON-NLS-1$
		
		assertOnLoadModelMigrationSuccess(gmfmapmodelFileName);
	}	
	
	private static URI createURI(String testModelFileName) {
		try {
			return Plugin.createURI("/models/migration/" + testModelFileName); //$NON-NLS-1$
		} catch (IOException e) {
			e.printStackTrace();
			fail("Could not create test model URI"); //$NON-NLS-1$
		}
		return null;
	}
	
	void assertOnLoadModelMigrationSuccess(String modelFileName) throws Exception {
		URI uri = createURI(modelFileName); 
		ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), uri);
		assertTrue("Migration warning load status expected", loadHelper.getStatus().matches(IStatus.WARNING)); //$NON-NLS-1$
		
		EList warnings = loadHelper.getLoadedResource().getWarnings();
		assertEquals("Single Warning diagnostic expected", 1, warnings.size()); //$NON-NLS-1$		
		assertTrue("MigrationDiagnostic expected as warning", warnings.get(0) instanceof MigrationUtil.MigrationDiagnostic); //$NON-NLS-1$
		assertTrue(loadHelper.getLoadedResource().getErrors().isEmpty());
	}
	
	
	@SuppressWarnings("unchecked")
	Exception assertOrdinaryLoadModelProblems(String modelFileName) throws Exception {
		URI uri = createURI(modelFileName);
		Resource resource = new ToolingResourceFactory().createResource(uri);
		ResourceSet rset = new ResourceSetImpl();
		rset.getResources().add(resource);
		
		RuntimeException caughtException = null;
		try {
			rset.getResource(uri, true);
		} catch(RuntimeException e) {
			caughtException = e;
		}
		assertTrue("Expected model loading problems", //$NON-NLS-1$
				caughtException != null || !resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty());
		return caughtException;
	}
}
