/*
 * Copyright (c) 2006, 2007 Eclipse.org
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
import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.internal.common.ToolingResourceFactory;
import org.eclipse.gmf.internal.common.migrate.MigrationResource;
import org.eclipse.gmf.internal.common.migrate.ModelLoadHelper;
import org.eclipse.gmf.tests.Plugin;

public class MigrationPatchesTest extends TestCase {

	public MigrationPatchesTest(String name) {
		super(name);
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

	/*
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=161380
	 */
	public void testPatch_161380() throws Exception {
		String genmodelFileName = "patch_161380.gmfgen"; //$NON-NLS-1$
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);

		String gmfmapmodelFileName = "patch_161380.gmfmap"; //$NON-NLS-1$		
		Exception caughtMapException = assertOrdinaryLoadModelProblems(gmfmapmodelFileName);
		assertTrue("expected diagnostic exception", caughtMapException != null); //$NON-NLS-1$

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
		EList<Resource.Diagnostic> warnings = loadHelper.getLoadedResource().getWarnings();
		assertEquals("Single Warning diagnostic expected", 1, warnings.size()); //$NON-NLS-1$		
		assertTrue("MigrationDiagnostic expected as warning", warnings.get(0) instanceof MigrationResource.Diagnostic); //$NON-NLS-1$
		
		assertTrue(loadHelper.getLoadedResource().getErrors().isEmpty());
	}

	Exception assertOrdinaryLoadModelProblems(String modelFileName) throws Exception {
		URI uri = createURI(modelFileName);
		Resource resource = new ToolingResourceFactory().createResource(uri);
		ResourceSet rset = new ResourceSetImpl();
		rset.getResources().add(resource);

		RuntimeException caughtException = null;
		try {
			rset.getResource(uri, true);
		} catch (RuntimeException e) {
			caughtException = e;
		}
		assertTrue("Expected model loading problems", //$NON-NLS-1$
				caughtException != null || !resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty());
		return caughtException;
	}

	/*
	GenDiagram
	Removed attrs:
	attr String paletteProviderClassName;
	attr ProviderPriority paletteProviderPriority;
	attr String propertyProviderClassName;
	attr ProviderPriority propertyProviderPriority;
	attr String referenceConnectionEditPolicyClassName;
	attr String externalNodeLabelHostLayoutEditPolicyClassName;
	attr String diagramFileCreatorClassName;
	attr String preferenceInitializerClassName;
	 */
	public void testGenDiagram() throws Exception {
		String genmodelFileName = "testGenDiagram.gmfgen"; //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);
	}

	/*
	FeatureLabelModelFacet 
	Removed refs:
	ref genmodel.GenFeature[1] metaFeature;
	 */
	public void testFeatureLabelModelFacet() throws Exception {
		String genmodelFileName = "testFeatureLabelModelFacet.gmfgen"; //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);
	}

//	/*
//	TypeLinkModelFacet 
//	Removed attrs:
//	attr String createCommandClassName;
//	 */
//	public void testTypeLinkModelFacet() throws Exception {
//		String genmodelFileName = "testTypeLinkModelFacet.gmfgen"; //$NON-NLS-1$
//		
//		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
//		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				
//
//		assertOnLoadModelMigrationSuccess(genmodelFileName);
//	}

	public void testGenAuditRootDefaultAndNested() throws Exception {
		String genmodelFileName = "testGenAuditRootDefaultAndNested.gmfgen"; //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);
	}

	public void testGenAuditRootNoDefaultButNested() throws Exception {
		String genmodelFileName = "testGenAuditRootNoDefaultButNested.gmfgen"; //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);
	}

	public void testGenAudits() throws Exception {
		String genmodelFileName = "testGenAudits.gmfgen"; //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);
	}

	public void testGenEditorAuditRootNoDefaultButNested() throws Exception {
		String genmodelFileName = "testGenEditorAuditRootNoDefaultButNested.gmfgen"; //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);
	}

	public void testGenAuditsCorrectCategories() throws Exception {
		String genmodelFileName = "testGenAuditsCorrectCategories.gmfgen"; //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);

		URI uri = createURI(genmodelFileName);
		ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), uri);
		Resource resource = loadHelper.getLoadedResource();
		for (Iterator<EObject> it = resource.getAllContents(); it.hasNext();) {
			EObject next = it.next();
			if (next instanceof GenAuditRule) {
				GenAuditRule nextRule = (GenAuditRule) next;
				GenAuditContainer nextCategory = nextRule.getCategory();
				assertEquals("Audit rule expected to be placed to correct audit category after migration", "rule:"+nextCategory.getId(), nextRule.getId()); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}
}
