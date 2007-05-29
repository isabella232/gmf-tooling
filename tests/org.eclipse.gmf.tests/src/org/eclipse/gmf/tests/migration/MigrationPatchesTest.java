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
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FlowLayout;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LabeledContainer;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.Rectangle;
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
		
		assertOnLoadModelMigrationDidNothing(newGenUri);
		
		URI gmfmapmodelFileName = createURI("patch_138440.gmfmap"); //$NON-NLS-1$
		Exception caughtMapException = assertOrdinaryLoadModelProblems(gmfmapmodelFileName);
		assertTrue("expected IllegalArgumentException from metamodel EFactory", caughtMapException instanceof IllegalArgumentException); //$NON-NLS-1$

		assertOnLoadModelMigrationSuccess(gmfmapmodelFileName);

		URI newMapUri = temporarySaveMigratedModel(gmfmapmodelFileName, "patch_138440", "gmfmap");
		changeNsUriToOldOne(newMapUri, "gmfmap", "http://www.eclipse.org/gmf/2005/mappings/2.0");
		
		assertOnLoadModelMigrationDidNothing(newMapUri);
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
		
		assertOnLoadModelMigrationDidNothing(newGenUri);
		
		URI gmfmapmodelFileName = createURI("patch_161380.gmfmap"); //$NON-NLS-1$		
		Exception caughtMapException = assertOrdinaryLoadModelProblems(gmfmapmodelFileName);
		assertTrue("expected diagnostic exception", caughtMapException != null); //$NON-NLS-1$

		assertOnLoadModelMigrationSuccess(gmfmapmodelFileName);

		URI newUri = temporarySaveMigratedModel(gmfmapmodelFileName, "patch_161380", "gmfmap");
		changeNsUriToOldOne(newUri, "gmfmap", "http://www.eclipse.org/gmf/2005/mappings/2.0");
		
		assertOnLoadModelMigrationDidNothing(newUri);
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
		
		EList<Resource.Diagnostic> errors = loadHelper.getLoadedResource().getErrors();
		assertTrue("Errors found after migration: "+errors, errors.isEmpty()); //$NON-NLS-1$
		
		assertTrue("Migration warning load status expected", loadHelper.getStatus().matches(IStatus.WARNING)); //$NON-NLS-1$
		EList<Resource.Diagnostic> warnings = loadHelper.getLoadedResource().getWarnings();
		assertEquals("Single Warning diagnostic expected", 1, warnings.size()); //$NON-NLS-1$		
		assertTrue("MigrationDiagnostic expected as warning", warnings.get(0) instanceof MigrationResource.Diagnostic); //$NON-NLS-1$
		
		assertTrue(loadHelper.getLoadedResource() instanceof XMLResource);
		XMLResource xmlResource = (XMLResource) loadHelper.getLoadedResource();
		assertEquals("Unknown elements were found after migration", 0, xmlResource.getEObjectToExtensionMap().size());
	}

	void assertOnLoadModelMigrationDidNothing(URI uri) throws Exception {
		ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), uri);
		
		EList<Resource.Diagnostic> errors = loadHelper.getLoadedResource().getErrors();
		assertTrue("Errors after re-run migration on new migrated model: "+errors, errors.isEmpty());
		
		EList<Resource.Diagnostic> warnings = loadHelper.getLoadedResource().getWarnings();
		assertTrue("Warnings after re-run migration on new migrated model: "+warnings, warnings.isEmpty());
		
		assertTrue(loadHelper.getLoadedResource() instanceof XMLResource);
		XMLResource xmlResource = (XMLResource) loadHelper.getLoadedResource();
		assertEquals("Unknown elements were found after re-migration", 0, xmlResource.getEObjectToExtensionMap().size());
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
		
		assertOnLoadModelMigrationDidNothing(newUri);
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
		
		assertOnLoadModelMigrationDidNothing(newUri);
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
		
		assertOnLoadModelMigrationDidNothing(newUri);
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
		
		assertOnLoadModelMigrationDidNothing(newUri);
	}

	public void testGenEditorAuditRootNoDefaultButNested() throws Exception {
		URI genmodelFileName = createURI("testGenEditorAuditRootNoDefaultButNested.gmfgen"); //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);

		URI newUri = temporarySaveMigratedModel(genmodelFileName, "testGenEditorAuditRootNoDefaultButNested", "gmfgen");
		changeNsUriToOldOne(newUri, "gmfgen", "http://www.eclipse.org/gmf/2005/GenModel/2.0");
		
		assertOnLoadModelMigrationDidNothing(newUri);
	}

	public void testGenAuditsCorrectCategories() throws Exception {
		URI genmodelFileName = createURI("testGenAuditsCorrectCategories.gmfgen"); //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(genmodelFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(genmodelFileName);
		
		checkModelAndCorrectCategories(genmodelFileName);

		URI newUri = temporarySaveMigratedModel(genmodelFileName, "testGenAuditsCorrectCategories", "gmfgen");
		changeNsUriToOldOne(newUri, "gmfgen", "http://www.eclipse.org/gmf/2005/GenModel/2.0");
		
		assertOnLoadModelMigrationDidNothing(newUri);
		
		checkModelAndCorrectCategories(newUri);
	}

	private URI temporarySaveMigratedModel(URI uri, String tempFilename, String tempFileExtension) throws IOException {
		ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), uri);
		Resource resource = loadHelper.getLoadedResource();
		File newGenmodelFile = File.createTempFile(tempFilename, tempFileExtension.startsWith(".") ? tempFileExtension : "."+tempFileExtension);
		newGenmodelFile.deleteOnExit();
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
		
		assertOnLoadModelMigrationDidNothing(newMapUri);
		checkOrderOfLabelMappings(newMapUri);
	}

	public void testRequiredPluginsMoved() throws Exception {
		URI gmfmapmodelFileName = createURI("testRequiredPluginsMoved.gmfgen"); //$NON-NLS-1$
		Exception caughtMapException = assertOrdinaryLoadModelProblems(gmfmapmodelFileName);
		assertTrue("expected diagnostic exception", caughtMapException != null); //$NON-NLS-1$

		assertOnLoadModelMigrationSuccess(gmfmapmodelFileName);
		checkAllRequiredPluginsAreNotLost(gmfmapmodelFileName);

		URI newMapUri = temporarySaveMigratedModel(gmfmapmodelFileName, "testRequiredPluginsMoved", "gmfgen"); //$NON-NLS-1$ //$NON-NLS-2$
		changeNsUriToOldOne(newMapUri, "gmfgen", "http://www.eclipse.org/gmf/2005/GenModel/2.0"); //$NON-NLS-1$ //$NON-NLS-2$
		
		assertOnLoadModelMigrationDidNothing(newMapUri);
		checkAllRequiredPluginsAreNotLost(newMapUri);
	}

	private void checkAllRequiredPluginsAreNotLost(URI modelUri) {
		ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), modelUri);
		Resource resource = loadHelper.getLoadedResource();
		assertEquals(1, resource.getContents().size());
		Object first = resource.getContents().get(0);
		assertTrue(first instanceof GenEditorGenerator);
		GenEditorGenerator genEditor = (GenEditorGenerator) first;
		assertNotNull(genEditor.getExpressionProviders());
		assertFalse(genEditor.getExpressionProviders().getProviders().isEmpty());
		GenPlugin plugin = genEditor.getPlugin();
		assertNotNull(plugin);
		EList<String> requiredPlugins = plugin.getRequiredPlugins();
		assertEquals(3, requiredPlugins.size());
		assertEquals("org.eclipse.emf.ocl", requiredPlugins.get(0));
		assertEquals("org.eclipse.emf.query.ocl", requiredPlugins.get(1));
		assertEquals("org.eclipse.emf.ecore", requiredPlugins.get(2));
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


	public void testGraphReferencingElements() throws Exception {
		URI gmfgraphFileName = createURI("basic.gmfgraph"); //$NON-NLS-1$
		
		Exception caughtGenException = assertOrdinaryLoadModelProblems(gmfgraphFileName);
		assertTrue("expected diagnostic exception", caughtGenException != null); //$NON-NLS-1$				

		assertOnLoadModelMigrationSuccess(gmfgraphFileName);
		checkAllFigureReferences(gmfgraphFileName);

		URI newUri = temporarySaveMigratedModel(gmfgraphFileName, "basic", "gmfgraph");
		changeNsUriToOldOne(newUri, "gmfgraph", "http://www.eclipse.org/gmf/2005/GraphicalDefinition");
		
		//assertOnLoadModelMigrationDidNothing(newUri);
		checkAllFigureReferences(newUri);
	}

	private void checkAllFigureReferences(URI modelUri) {
		ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), modelUri);
		Resource resource = loadHelper.getLoadedResource();
		
		assertEquals(1, resource.getContents().size());
		Object first = resource.getContents().get(0);
		assertTrue(first instanceof Canvas);
		Canvas canvas = (Canvas) first;
		assertEquals(8, canvas.eContents().size());
		
		assertNotNull(canvas.getFigures());
		assertFalse(canvas.getFigures().isEmpty());
		assertEquals(1, canvas.getFigures().size());
		
		FigureGallery fg = canvas.getFigures().get(0);
		assertEquals("GenericDiagramFigures", fg.getName());
		assertTrue(fg.getFigures().isEmpty());
		assertFalse(fg.getDescriptors().isEmpty());
		assertEquals(5, fg.getDescriptors().size());
		
		FigureDescriptor fg1 = fg.getDescriptors().get(0);
		assertTrue(fg1.getAccessors().isEmpty());
		
		FigureDescriptor fg5 = fg.getDescriptors().get(4);
		assertFalse(fg5.getAccessors().isEmpty());
		assertEquals(1, fg5.getAccessors().size());
		
		Figure figure1 = fg.getDescriptors().get(0).getActualFigure();
		assertTrue(figure1 instanceof Rectangle);
		Rectangle nr  = (Rectangle) figure1;
		assertEquals("NodeRectangle", nr.getName());
		assertNotNull(nr.getLayout());
		assertTrue(nr.getLayout() instanceof FlowLayout);
		assertNotNull(nr.getDescriptor());
		assertEquals(nr, nr.getDescriptor().getActualFigure());
		assertEquals(0, nr.getDescriptor().getAccessors().size());
		
		Figure figure2 = fg.getDescriptors().get(1).getActualFigure();
		assertTrue(figure2 instanceof PolylineConnection);
		PolylineConnection pc = (PolylineConnection) figure2;
		assertEquals("ConnectionLine", pc.getName());
		assertNotNull(pc.getDescriptor());
		assertEquals(pc, pc.getDescriptor().getActualFigure());
		assertEquals(0, pc.getDescriptor().getAccessors().size());
		
		Figure figure3 = fg.getDescriptors().get(2).getActualFigure();
		assertTrue(figure3 instanceof LabeledContainer);
		LabeledContainer lc = (LabeledContainer) figure3;
		assertEquals("ContainerFigure", lc.getName());
		assertNotNull(lc.getDescriptor());
		assertEquals(lc, lc.getDescriptor().getActualFigure());
		assertEquals(0, lc.getDescriptor().getAccessors().size());
		
		Figure figure4 = fg.getDescriptors().get(3).getActualFigure();
		assertTrue(figure4 instanceof Label);
		Label lab = (Label) figure4;
		assertEquals("LabelFigure", lab.getName());
		assertNotNull(lab.getDescriptor());
		assertEquals(lab, lab.getDescriptor().getActualFigure());
		assertEquals(0, lab.getDescriptor().getAccessors().size()); //2 references!!!
		
		Figure figure5 = fg.getDescriptors().get(4).getActualFigure();
		assertTrue(figure5 instanceof Rectangle);
		Rectangle nnr = (Rectangle) figure5;
		assertEquals("NamedNodeRectangle", nnr.getName());
		assertNotNull(nnr.getLayout());
		assertTrue(nnr.getLayout() instanceof FlowLayout);
		assertNotNull(nnr.getChildren());
		assertFalse(nnr.getChildren().isEmpty());
		assertEquals(1, nnr.getChildren().size());
		assertNotNull(nnr.getDescriptor());
		assertEquals(nnr, nnr.getDescriptor().getActualFigure());

		Figure figure1in5 = (Figure) nnr.getChildren().get(0);
		assertTrue(figure1in5 instanceof Label);
		Label nnrLabel = (Label) figure1in5;
		assertEquals("NamedNode_NameLabelFigure", nnrLabel.getName());
		assertNotNull(nnrLabel.getDescriptor());
		assertEquals(nnrLabel.getDescriptor(), nnr.getDescriptor());
		assertEquals(1, nnr.getDescriptor().getAccessors().size());
		assertEquals(nnrLabel, nnr.getDescriptor().getAccessors().get(0).getFigure());

		assertNotNull(canvas.getNodes());
		assertFalse(canvas.getNodes().isEmpty());
		assertEquals(2, canvas.getNodes().size());
		
		Node node1 = canvas.getNodes().get(0);
		assertEquals("Node", node1.getName());
		
		Node node2 = canvas.getNodes().get(1);
		assertEquals("NamedNode", node2.getName());
		
		assertNotNull(canvas.getConnections());
		assertFalse(canvas.getConnections().isEmpty());
		assertEquals(1, canvas.getConnections().size());
		
		Connection connection = canvas.getConnections().get(0);
		assertEquals("Link", connection.getName());
		
		assertNotNull(canvas.getCompartments());
		assertFalse(canvas.getCompartments().isEmpty());
		assertEquals(1, canvas.getCompartments().size());
		
		Compartment compartment = canvas.getCompartments().get(0);
		assertEquals("Compartment", compartment.getName());
		
		assertNotNull(canvas.getLabels());
		assertFalse(canvas.getLabels().isEmpty());
		assertEquals(3, canvas.getLabels().size());
		
		DiagramLabel l1 = canvas.getLabels().get(0);
		assertEquals("NamedNode_Name", l1.getName());
		
		DiagramLabel l2 = canvas.getLabels().get(1);
		assertEquals("Label", l2.getName());
		
		DiagramLabel l3 = canvas.getLabels().get(2);
		assertEquals("LabelWOIcon", l3.getName());
	}

}
