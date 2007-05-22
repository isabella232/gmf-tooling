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

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.internal.common.ToolingResourceFactory;
import org.eclipse.gmf.internal.common.migrate.MigrationResource;
import org.eclipse.gmf.internal.common.migrate.ModelLoadHelper;
import org.eclipse.gmf.mappings.FeatureLabelMapping;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.MappingEntry;
import org.eclipse.gmf.tests.Plugin;

public class MigrationPatchesTest extends TestCase {

	public MigrationPatchesTest(String name) {
		super(name);
	}

	/*
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=138440
	 */
	public void testPatch_138440() throws Exception {
		URI genmodelFileName = createURI("patch_138440.gmfgen"); //$NON-NLS-1$
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected IllegalArgumentException from metamodel EFactory", caughtGenException instanceof IllegalArgumentException); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);

		URI newGenUri = temporarySaveMigratedModel(genmodelFileName, "patch_138440", "gmfgen");
		changeNsUriToOldOne(newGenUri, "gmfgen", "http://www.eclipse.org/gmf/2005/GenModel/2.0");
		
		assertOnLoadModelMigrationSuccess(newGenUri);
		
		URI gmfmapmodelFileName = createURI("patch_138440.gmfmap"); //$NON-NLS-1$
		Exception caughtMapException = assertOrdinaryLoadModelProblems(gmfmapmodelFileName);
		assertTrue("expected IllegalArgumentException from metamodel EFactory", caughtMapException instanceof IllegalArgumentException); //$NON-NLS-1$

		assertOnLoadModelMigrationSuccess(gmfmapmodelFileName);

		URI newMapUri = temporarySaveMigratedModel(gmfmapmodelFileName, "patch_138440", "gmfmap");
		changeNsUriToOldOne(newMapUri, "gmfmap", "http://www.eclipse.org/gmf/2005/mappings/2.0");
		
		assertOnLoadModelMigrationSuccess(newMapUri);
	}

	/*
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=161380
	 */
	public void testPatch_161380() throws Exception {
		URI genmodelFileName = createURI("patch_161380.gmfgen"); //$NON-NLS-1$
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);

		URI newGenUri = temporarySaveMigratedModel(genmodelFileName, "patch_138440", "gmfgen");
		changeNsUriToOldOne(newGenUri, "gmfgen", "http://www.eclipse.org/gmf/2005/GenModel/2.0");
		
		assertOnLoadModelMigrationSuccess(newGenUri);
		
		URI gmfmapmodelFileName = createURI("patch_161380.gmfmap"); //$NON-NLS-1$		
		Exception caughtMapException = assertOrdinaryLoadModelProblems(gmfmapmodelFileName);
		assertTrue("expected diagnostic exception", caughtMapException != null); //$NON-NLS-1$

		assertOnLoadModelMigrationSuccess(gmfmapmodelFileName);

		URI newUri = temporarySaveMigratedModel(gmfmapmodelFileName, "patch_161380", "gmfmap");
		changeNsUriToOldOne(newUri, "gmfmap", "http://www.eclipse.org/gmf/2005/mappings/2.0");
		
		assertOnLoadModelMigrationSuccess(newUri);
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

	void assertOnLoadModelMigrationSuccess(URI uri) throws Exception {
		ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), uri);
		
		assertTrue("Migration warning load status expected", loadHelper.getStatus().matches(IStatus.WARNING)); //$NON-NLS-1$
		EList<Resource.Diagnostic> warnings = loadHelper.getLoadedResource().getWarnings();
		assertEquals("Single Warning diagnostic expected", 1, warnings.size()); //$NON-NLS-1$		
		assertTrue("MigrationDiagnostic expected as warning", warnings.get(0) instanceof MigrationResource.Diagnostic); //$NON-NLS-1$
		
		EList<Resource.Diagnostic> errors = loadHelper.getLoadedResource().getErrors();
		assertTrue(errors.isEmpty());
	}

	Exception assertOrdinaryLoadModelProblems(URI uri) throws Exception {
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
		URI genmodelFileName = createURI("testGenDiagram.gmfgen"); //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);

		URI newUri = temporarySaveMigratedModel(genmodelFileName, "testGenDiagram", "gmfgen");
		changeNsUriToOldOne(newUri, "gmfgen", "http://www.eclipse.org/gmf/2005/GenModel/2.0");
		
		assertOnLoadModelMigrationSuccess(newUri);
	}

	/*
	FeatureLabelModelFacet 
	Removed refs:
	ref genmodel.GenFeature[1] metaFeature;
	 */
	public void testFeatureLabelModelFacet() throws Exception {
		URI genmodelFileName = createURI("testFeatureLabelModelFacet.gmfgen"); //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);
		checkFeatureLabelModelFacetsMigrated(genmodelFileName);

		URI newUri = temporarySaveMigratedModel(genmodelFileName, "testFeatureLabelModelFacet", "gmfgen");
		changeNsUriToOldOne(newUri, "gmfgen", "http://www.eclipse.org/gmf/2005/GenModel/2.0");
		
		assertOnLoadModelMigrationSuccess(newUri);
		checkFeatureLabelModelFacetsMigrated(newUri);
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
		URI genmodelFileName = createURI("testGenAuditRootDefaultAndNested.gmfgen"); //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);

		URI newUri = temporarySaveMigratedModel(genmodelFileName, "testGenAuditRootDefaultAndNested", "gmfgen");
		changeNsUriToOldOne(newUri, "gmfgen", "http://www.eclipse.org/gmf/2005/GenModel/2.0");
		
		assertOnLoadModelMigrationSuccess(newUri);
	}

	public void testGenAuditRootNoDefaultButNested() throws Exception {
		URI genmodelFileName = createURI("testGenAuditRootNoDefaultButNested.gmfgen"); //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);
	}

	public void testGenAudits() throws Exception {
		URI genmodelFileName = createURI("testGenAudits.gmfgen"); //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);

		URI newUri = temporarySaveMigratedModel(genmodelFileName, "testGenAudits", "gmfgen");
		changeNsUriToOldOne(newUri, "gmfgen", "http://www.eclipse.org/gmf/2005/GenModel/2.0");
		
		assertOnLoadModelMigrationSuccess(newUri);
	}

	public void testGenEditorAuditRootNoDefaultButNested() throws Exception {
		URI genmodelFileName = createURI("testGenEditorAuditRootNoDefaultButNested.gmfgen"); //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);

		URI newUri = temporarySaveMigratedModel(genmodelFileName, "testGenEditorAuditRootNoDefaultButNested", "gmfgen");
		changeNsUriToOldOne(newUri, "gmfgen", "http://www.eclipse.org/gmf/2005/GenModel/2.0");
		
		assertOnLoadModelMigrationSuccess(newUri);
	}

	public void testGenAuditsCorrectCategories() throws Exception {
		URI genmodelFileName = createURI("testGenAuditsCorrectCategories.gmfgen"); //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);
		
		checkModelAndCorrectCategories(genmodelFileName);

		URI newUri = temporarySaveMigratedModel(genmodelFileName, "testGenAuditsCorrectCategories", "gmfgen");
		changeNsUriToOldOne(newUri, "gmfgen", "http://www.eclipse.org/gmf/2005/GenModel/2.0");
		
		assertOnLoadModelMigrationSuccess(newUri);
		
		checkModelAndCorrectCategories(newUri);
	}

	private URI temporarySaveMigratedModel(URI uri, String tempFilename, String tempFileExtension) throws IOException {
		ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), uri);
		Resource resource = loadHelper.getLoadedResource();
		File newGenmodelFile = File.createTempFile(tempFilename, tempFileExtension.startsWith(".") ? tempFileExtension : "."+tempFileExtension);
		URI newUri = URI.createFileURI(newGenmodelFile.getAbsolutePath());
		resource.setURI(newUri);
		try {
			resource.save(null);
		} catch (IOException ex) {
			fail(ex.toString());
		}
		return newUri;
	}

	private void changeNsUriToOldOne(URI newUri, String nsPrefix, String nsUri) throws IOException {
		Path path = new Path(newUri.toFileString());
		File file = path.toFile();
		FileReader reader = new FileReader(file);
		char[] chars = new char[100000];
		int length = reader.read(chars);
		String content = new String(chars, 0, length).replaceFirst("xmlns:"+nsPrefix+"=\"[^\"]+\"", "xmlns:"+nsPrefix+"=\""+nsUri+"\"");
		FileWriter writer = new FileWriter(file);
		writer.write(content.toCharArray());
		writer.flush();
	}

	private void checkModelAndCorrectCategories(URI uri) {
		ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), uri);
		Resource resource = loadHelper.getLoadedResource();
		int allContentsSize = 0;
		for (Iterator<EObject> it = resource.getAllContents(); it.hasNext();) {
			EObject next = it.next();
			allContentsSize++;
			if (next instanceof GenEditorGenerator) {
				GenEditorGenerator genEditor = (GenEditorGenerator) next;
				assertNotNull(genEditor.getAudits());
			} else if (next instanceof GenAuditRoot) {
				GenAuditRoot root = (GenAuditRoot) next;
				assertFalse(root.getCategories().isEmpty());
				assertFalse(root.getRules().isEmpty());
				assertEquals(3, root.getCategories().size());
				assertEquals(3, root.getRules().size());
			} else if (next instanceof GenAuditContainer) {
				GenAuditContainer nextContainer = (GenAuditContainer) next;
				assertFalse(nextContainer.getAudits().isEmpty());
				assertEquals(nextContainer.getAudits().size(), 1);
			} else if (next instanceof GenAuditRule) {
				GenAuditRule nextRule = (GenAuditRule) next;
				GenAuditContainer nextCategory = nextRule.getCategory();
				assertNotNull(nextCategory);
				assertEquals("Audit rule expected to be placed to correct audit category after migration", "rule:"+nextCategory.getId(), nextRule.getId()); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		assertEquals(8, allContentsSize);
	}

	public void testNotChangingOrderOfLabelMappings() throws Exception {
		URI gmfmapmodelFileName = createURI("testNotChangingOrderOfLabelMappings.gmfmap"); //$NON-NLS-1$
		Exception caughtMapException = assertOrdinaryLoadModelProblems(gmfmapmodelFileName);
		assertTrue("expected diagnostic exception", caughtMapException != null); //$NON-NLS-1$

		assertOnLoadModelMigrationSuccess(gmfmapmodelFileName);
		checkOrderOfLabelMappings(gmfmapmodelFileName);

		URI newMapUri = temporarySaveMigratedModel(gmfmapmodelFileName, "testNotChangingOrderOfLabelMappings", "gmfmap"); //$NON-NLS-1$ //$NON-NLS-2$
		changeNsUriToOldOne(newMapUri, "gmfmap", "http://www.eclipse.org/gmf/2005/mappings/2.0"); //$NON-NLS-1$ //$NON-NLS-2$
		
		assertOnLoadModelMigrationSuccess(newMapUri);
		checkOrderOfLabelMappings(newMapUri);
	}

	private void checkOrderOfLabelMappings(URI modelURI) {
		ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), modelURI);
		Resource res = loadHelper.getLoadedResource();
		for (Iterator<EObject> it = res.getAllContents(); it.hasNext();) {
			EObject next = it.next();
			if (next instanceof MappingEntry) {
				MappingEntry nextEntry = (MappingEntry) next;
				EList<LabelMapping> labelMappings = nextEntry.getLabelMappings();
				assertFalse(labelMappings.isEmpty());
				assertEquals(5, labelMappings.size());
				checkMapping(labelMappings.get(0), false);
				checkMapping(labelMappings.get(1), true);
				checkMapping(labelMappings.get(2), false);
				checkMapping(labelMappings.get(3), true);
				checkMapping(labelMappings.get(4), false);
			}
		}
	}

	private void checkMapping(LabelMapping mapping, boolean shouldBeNarrowed) {
		assertEquals(shouldBeNarrowed, mapping instanceof FeatureLabelMapping);
		assertNotNull(mapping.getDiagramLabel());
		if (shouldBeNarrowed) {
			assertFalse(((FeatureLabelMapping)mapping).getFeatures().isEmpty());
		}
	}

	private void checkFeatureLabelModelFacetsMigrated(URI uri) {
		ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), uri);
		Resource resource = loadHelper.getLoadedResource();
		assertEquals(2, resource.getContents().size());
		Object first = resource.getContents().get(0);
		assertTrue(first instanceof FeatureLabelModelFacet);
		FeatureLabelModelFacet firstFeatureLabelModelFacet = (FeatureLabelModelFacet) first;
		assertEquals(1, firstFeatureLabelModelFacet.getMetaFeatures().size());
		Object second = resource.getContents().get(1);
		assertTrue(second instanceof FeatureLabelModelFacet);
		FeatureLabelModelFacet secondFeatureLabelModelFacet = (FeatureLabelModelFacet) second;
		assertEquals(2, secondFeatureLabelModelFacet.getMetaFeatures().size());
	}
}
