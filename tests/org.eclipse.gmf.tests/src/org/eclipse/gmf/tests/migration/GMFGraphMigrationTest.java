/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anna Karjakina (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.migration;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gmf.internal.common.ToolingResourceFactory;
import org.eclipse.gmf.internal.common.migrate.MigrationResource;
import org.eclipse.gmf.internal.common.migrate.ModelLoadHelper;

public class GMFGraphMigrationTest extends TestCase {

	public GMFGraphMigrationTest(String name) {
		super(name);
	}
	
	public void testSuite() {
		for (Test test : createAllTests()) {
			test.run(createResult());
		}
	}

	public static class GMFGraphFileTest extends TestCase {
		private URI myGMFGraphFileURI;

		public GMFGraphFileTest(URI gmfgraphFileURI) {
			super("testFile"); //$NON-NLS-1$
			myGMFGraphFileURI = gmfgraphFileURI;
		}

		public void testFile() throws Exception {
			assertNoOrdinaryLoadModelProblems(myGMFGraphFileURI);
			
			//assertOrdinaryLoadModelProblems(gmfgraphFileURI);

			//assertOnLoadModelMigrationSuccess(gmfgraphFileURI);

			URI newGenUri = temporarySaveMigratedModel(myGMFGraphFileURI, myGMFGraphFileURI.trimFileExtension().lastSegment(), myGMFGraphFileURI.fileExtension());
			changeNsUriToOldOne(newGenUri, "gmfgraph", "http://www.eclipse.org/gmf/2005/GraphicalDefinition"); //$NON-NLS-1$ //$NON-NLS-2$
			
			//assertOnLoadModelMigrationDidNothing(newGenUri);
			
			assertNoOrdinaryLoadModelProblems(newGenUri);
		}

		static void assertOnLoadModelMigrationSuccess(URI uri) throws Exception {
			ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), uri);
			
			EList<Resource.Diagnostic> errors = loadHelper.getLoadedResource().getErrors();
			assertTrue("Errors found after migration ("+uri+"): "+errors, errors.isEmpty()); //$NON-NLS-1$ //$NON-NLS-2$
			
			assertTrue("Migration warning load status expected for "+uri, loadHelper.getStatus().matches(IStatus.WARNING)); //$NON-NLS-1$
			EList<Resource.Diagnostic> warnings = loadHelper.getLoadedResource().getWarnings();
			assertEquals("Single Warning diagnostic expected for "+uri, 1, warnings.size()); //$NON-NLS-1$		
			assertTrue("MigrationDiagnostic expected as warning for "+uri, warnings.get(0) instanceof MigrationResource.Diagnostic); //$NON-NLS-1$
			
			assertTrue(loadHelper.getLoadedResource() instanceof XMLResource);
			XMLResource xmlResource = (XMLResource) loadHelper.getLoadedResource();
			assertEquals("Unknown elements were recorded after migration of "+uri, 0, xmlResource.getEObjectToExtensionMap().size()); //$NON-NLS-1$
		}

		static void assertOnLoadModelMigrationDidNothing(URI uri) throws Exception {
			ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), uri);
			
			EList<Resource.Diagnostic> errors = loadHelper.getLoadedResource().getErrors();
			assertTrue("Errors after re-run migration ("+uri+") on new migrated model: "+errors, errors.isEmpty()); //$NON-NLS-1$ //$NON-NLS-2$
			
			EList<Resource.Diagnostic> warnings = loadHelper.getLoadedResource().getWarnings();
			assertTrue("Warnings after re-run migration ("+uri+") on new migrated model: "+warnings, warnings.isEmpty()); //$NON-NLS-1$ //$NON-NLS-2$
			
			assertTrue(loadHelper.getLoadedResource() instanceof XMLResource);
			XMLResource xmlResource = (XMLResource) loadHelper.getLoadedResource();
			assertEquals("Unknown elements were recorded after re-migration of "+uri, 0, xmlResource.getEObjectToExtensionMap().size()); //$NON-NLS-1$
		}

		static Exception assertNoOrdinaryLoadModelProblems(URI uri) throws Exception {
			Resource resource = new ToolingResourceFactory().createResource(uri);
			ResourceSet rset = new ResourceSetImpl();
			rset.getResources().add(resource);

			RuntimeException caughtException = null;
			try {
				rset.getResource(uri, true);
			} catch (RuntimeException e) {
				caughtException = e;
			}
			assertTrue("Unexpected model loading problems for "+uri, //$NON-NLS-1$
					caughtException == null && resource.getErrors().isEmpty() && resource.getWarnings().isEmpty());
			return caughtException;
		}

		
		static Exception assertOrdinaryLoadModelProblems(URI uri) throws Exception {
			Resource resource = new ToolingResourceFactory().createResource(uri);
			ResourceSet rset = new ResourceSetImpl();
			rset.getResources().add(resource);

			RuntimeException caughtException = null;
			try {
				rset.getResource(uri, true);
			} catch (RuntimeException e) {
				caughtException = e;
			}
			assertTrue("Expected model loading problems for "+uri, //$NON-NLS-1$
					caughtException != null || !resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty());
			return caughtException;
		}

		private static URI temporarySaveMigratedModel(URI uri, String tempFilename, String tempFileExtension) throws IOException {
			ModelLoadHelper loadHelper = new ModelLoadHelper(new ResourceSetImpl(), uri);
			Resource resource = loadHelper.getLoadedResource();
			File newGenmodelFile = File.createTempFile(tempFilename, tempFileExtension.charAt(0) == '.' ? tempFileExtension : '.'+tempFileExtension);
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

		private static void changeNsUriToOldOne(URI newUri, String nsPrefix, String nsUri) throws IOException {
			Path path = new Path(newUri.toFileString());
			File file = path.toFile();
			FileReader reader = new FileReader(file);
			char[] chars = new char[100000];
			int length = reader.read(chars);
			String content = new String(chars, 0, length).replaceFirst("xmlns:"+nsPrefix+"=\"[^\"]+\"", "xmlns:"+nsPrefix+"=\""+nsUri+"\""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			FileWriter writer = new FileWriter(file);
			writer.write(content.toCharArray());
			writer.flush();
		}
	}

	private static Collection<URI> collectAllGMFGraphFiles(String rootFolder) {
		Collection<URI> result = new ArrayList<URI>();
		File root = new File(rootFolder);
		if (!root.isDirectory()) {
			root = root.getParentFile();
		}
		collectFilesRecursive(root, result, new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".gmfgraph"); //$NON-NLS-1$
			}
		});
		return result;
	}

	private static void collectFilesRecursive(File file, Collection<URI> files, FilenameFilter filenameFilter) {
		if (!file.isDirectory()) {
			if (filenameFilter.accept(file.getParentFile(), file.getName())) {
				URI fileURI = URI.createFileURI(file.getAbsolutePath());
				files.add(fileURI);
			}
		} else if (file.getName().charAt(0) != '.') {
			for (File child : file.listFiles()) {
				collectFilesRecursive(child, files, filenameFilter);
			}
		}
	}
	
	public static Collection<TestCase> createAllTests() {
		Collection<TestCase> result = new ArrayList<TestCase>(100);
		for (URI gmfgraphFileURI : collectAllGMFGraphFiles(File.listRoots()[0].getAbsolutePath())) { //$NON-NLS-1$
			GMFGraphFileTest test = new GMFGraphFileTest(gmfgraphFileURI);
			result.add(test);
		}
		return result;
	}

}
