/*******************************************************************************
* Copyright (c) 2011, 2012 Montages A.G.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Guillaume Hillairet (Montages A.G.) : initial implementation
*******************************************************************************/
package org.eclipse.gmf.tests.tr;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContext;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference;
import org.eclipse.gmf.codegen.gmfgen.GenParserImplementation;
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ValueExpression;
import org.eclipse.gmf.internal.bridge.transform.GenModelDetector;
import org.eclipse.gmf.internal.bridge.transform.TransformToGenModelOperation;
import org.eclipse.gmf.internal.common.URIUtil;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.tests.ConfiguredTestCase;

public abstract class QvtTransformCompareTestSupport  extends ConfiguredTestCase {
	
	protected static String FOLDER_MODELS = "models"; //$NON-NLS-1$
	protected static String FILE_BASE = "test"; //$NON-NLS-1$
	protected static String FILE_EXT_ECORE = "ecore"; //$NON-NLS-1$
	protected static String FILE_EXT_GMFGEN = "gmfgen"; //$NON-NLS-1$
	protected static String FILE_EXT_GMFGRAPH = "gmfgraph"; //$NON-NLS-1$
	protected static String FILE_EXT_GMFMAP = "gmfmap"; //$NON-NLS-1$
	protected static String FILE_EXT_GMFTOOL = "gmftool"; //$NON-NLS-1$
	
	protected IProject myProject;
	
	protected static String testFolder = "platform:/plugin/org.eclipse.gmf.tests/models/tests";  //$NON-NLS-1$
	
	private String emf_model_uri;
	private String gen_model_uri;
	private String tool_model_uri;
	private String graph_model_uri;
	private String map_model_uri;
	
	public QvtTransformCompareTestSupport(String name, String ecoreFile, String genFile, String toolFile, String graphFile, String mapFile) {
		super(name);
		emf_model_uri = ecoreFile;
		gen_model_uri = genFile;
		tool_model_uri = toolFile;
		graph_model_uri = graphFile;
		map_model_uri = mapFile;
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		myProject = createProject();
	}

	@Override
	protected void tearDown() throws Exception {
		deleteProject();
		myProject = null;
		super.tearDown();
	}
	
	protected void prepareResources() throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		Resource emf = rs.createResource(URI.createURI(emf_model_uri));
		emf.load(null);
		Resource tool = rs.createResource(URI.createURI(tool_model_uri));
		tool.load(null);
		Resource graph = rs.createResource(URI.createURI(graph_model_uri));
		graph.load(null);
		Resource map = rs.createResource(URI.createURI(map_model_uri));
		map.load(null);
	}
	
	protected GenEditorGenerator executeBaseTransformation() {
		try {
			prepareResources();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		TransformToGenModelOperation operation = new TransformToGenModelOperation(new ResourceSetImpl());
		loadMappingModel(URI.createURI(map_model_uri), operation);
		operation.getGenModelDetector().detect();
		
		try {
			operation.loadGenModel(URI.createURI(gen_model_uri), null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		operation.setGenURI(createURI(FILE_EXT_GMFGEN));
		
		IStatus status = operation.executeTransformation(null);
		assertTrue(status.getMessage(), status.isOK());
		
		GenEditorGenerator genEditor = (GenEditorGenerator) operation.getResourceSet().getResource(
				operation.getGenURI(), true).getContents().get(0);
		
		assertNotNull(genEditor);
		genEditor.eResource().setURI(genEditor.eResource().getURI().trimFileExtension().appendFileExtension("java.gmfgen"));
		try {
			genEditor.eResource().save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return genEditor;
	}
	
	protected GenEditorGenerator executeQvtTransformation() {
		return executeQvtTransformation(false, true);
	}
	
	protected GenEditorGenerator executeQvtTransformation(boolean rcp, boolean useCodeGen) {
		try {
			prepareResources();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		TransformToGenModelOperation operation = new TransformToGenModelOperation(new ResourceSetImpl());
		loadMappingModel(URI.createURI(map_model_uri), operation);
		operation.getGenModelDetector().detect();

		try {
			operation.loadGenModel(URI.createURI(gen_model_uri), null);
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		
		String pathName = getProject().getName() + 
				IPath.SEPARATOR + FOLDER_MODELS + 
				IPath.SEPARATOR + "test.gmfgen"; //$NON-NLS-1$
		
		URI uri = URI.createPlatformResourceURI(pathName, true);
		
		operation.setGenURI(uri);
		operation.getOptions().setUseMapMode(true);
		operation.getOptions().setUseRuntimeFigures(false);
		operation.getOptions().setGenerateRCP(rcp);
		operation.getOptions().setInTransformationCodeGen(useCodeGen);
		
		try {
			operation.getOptions().setTransformation(new URL(
					URI.createURI("platform:/plugin/org.eclipse.gmf.bridge/transforms/Map2Gen.qvto").toString()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		IStatus status = operation.executeTransformation(null);
		assertTrue(status.getMessage(), status.isOK());
		
		GenEditorGenerator genEditor = (GenEditorGenerator) operation.getResourceSet().getResource(
				operation.getGenURI(), true).getContents().get(0);
		
		assertNotNull(genEditor);
		genEditor.eResource().setURI(genEditor.eResource().getURI().trimFileExtension().appendFileExtension("qvt.gmfgen"));
		try {
			genEditor.eResource().save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return genEditor;
	}
	
	protected void deleteProject() throws CoreException {
		if (getProject() != null) {
			if (getProject().isOpen()) {
				getProject().close(new NullProgressMonitor());
			}
			if (getProject().exists()) {
				getProject().delete(true, new NullProgressMonitor());
			}
		}
	}

	protected IProject getProject() {
		return myProject;
	}

	protected IProject createProject() {
		String projectName = "TransformToGenModelOperationTest_" + String.valueOf(System.currentTimeMillis()); //$NON-NLS-1$
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		assertFalse("Project with this name already present in the workspace: " + projectName, project.exists());
		try {
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());
		} catch (CoreException e) {
			fail(e.getMessage());
		}
		assertTrue("Project was not created: " + projectName, project.exists());
		return project;
	}

	protected void loadMappingModel(URI mapURI, TransformToGenModelOperation myOperation) {
		Mapping mapping = null;
		try {
			mapping = myOperation.loadMappingModel(mapURI, null);
			assertNotNull("Mapping should be resolved", mapping);
			Diagnostic validationResult = myOperation.getMapmodelValidationResult();
			assertNotNull("MappingModel validation result should be set", validationResult);
			assertFalse("MappingModel validation result should differ from CANCEL value", IStatus.CANCEL == validationResult.getSeverity());
			assertFalse("MappingModel validation result should differ from ERROR value", IStatus.ERROR == validationResult.getSeverity());
			assertNotNull("GenModelDetector should be initialized", myOperation.getGenModelDetector());
			assertNull("GenModel should be reset", myOperation.getGenModel());
		} catch (CoreException e) {
			fail(e.getStatus().getMessage());
		}
	}

	protected URI createDefaultGenModel(URI mapURI, TransformToGenModelOperation myOperation) {
		URI genmodelURI = null;
		try {
			GenModelDetector gmd = myOperation.getGenModelDetector();
			assertNotNull("GenModelDetector should be initialized", gmd);
			genmodelURI = gmd.createDefault(getProject().getName(), URIUtil.getFile(mapURI));
			assertNotNull("GenModel URI should be created", genmodelURI);
			
			IFile file = URIUtil.getFile(mapURI);
			assertNotNull("GenModel file should be created", file);
			assertTrue("GenModel file should exists", file.exists());
		} catch (CoreException e) {
			fail("Failed to create default GenModel: " + e.getMessage());
		}
		return genmodelURI;
	}

	protected URI prepareResources(String baseURI) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		Resource emf = rs.createResource(URI.createURI(baseURI+".ecore"));
		emf.load(null);
		Resource tool = rs.createResource(URI.createURI(baseURI+".gmftool"));
		tool.load(null);
		Resource graph = rs.createResource(URI.createURI(baseURI+".gmfgraph"));
		graph.load(null);
		Resource map = rs.createResource(URI.createURI(baseURI+".gmfmap"));
		map.load(null);
		
		return URI.createURI(baseURI+".gmfmap");
	}
	
	protected URI createURI(String extension) {
		String pathName = getProject().getName() + 
				IPath.SEPARATOR + FOLDER_MODELS + 
				IPath.SEPARATOR + FILE_BASE + "." + extension; //$NON-NLS-1$
		URI uri = URI.createPlatformResourceURI(pathName, true);
		return uri;
	}
	
	protected GenChildNode getChildNodeByVisualID(int visualID, EList<GenChildNode> child) {
		for (GenChildNode node: child) {
			if (visualID == node.getVisualID()) {
				return node;
			}
		}
		return null;
	}
	
	protected void checkObjectAttributes(EObject expected, EObject actual) {
		if (expected == null) {
			assertNull(actual);
			return;
		}
		
		assertNotNull(actual);
		
		for (EAttribute attr: expected.eClass().getEAllAttributes()) {
			if (expected.eIsSet(attr)) {
				
				assertTrue("attribute "+expected.eClass().getName()+"."+attr.getName()+" should be set", actual.eIsSet(attr));
				
				if (attr.isMany()) {
					List<?> exp = (List<?>) expected.eGet(attr);
					List<?> act = (List<?>) actual.eGet(attr);
					assertEquals(exp.size(), act.size());
					
					for (int i=0; i<exp.size(); i++) {
						assertTrue(act.contains(exp.get(i)));
					}
				} else {
					assertEquals(expected.eClass().getName()+" attribute: "+attr.getName(), expected.eGet(attr), actual.eGet(attr));
				}
				
			} else {
				assertFalse("attribute "+attr.getName()+" should not be set", actual.eIsSet(attr));
			}
		}
	}

	protected void checkContainedObjects(EObject expected, EObject actual) {
		if (expected == null) {
			assertNull(actual);
			return;
		}
		
		assertNotNull(actual);
		
		for (EReference ref: expected.eClass().getEAllReferences()) {
			if (ref.isMany()) {
				@SuppressWarnings("unchecked")
				EList<EObject> expectedObjects = (EList<EObject>) expected.eGet(ref);
				@SuppressWarnings("unchecked")
				EList<EObject> actualObjects = (EList<EObject>) actual.eGet(ref);

				assertEquals(expected.eClass().getName()+" number of elements in: " + ref.getName(), expectedObjects.size(), actualObjects.size());
				
				for (int i=0;i<expectedObjects.size();i++) {
					if (ref.isContainment()) {
						checkObjectAttributes(expectedObjects.get(i), actualObjects.get(i));
						checkContainedObjects(expectedObjects.get(i), actualObjects.get(i));
					}
				}
			} else {
				EObject exp = (EObject) expected.eGet(ref);
				EObject act = (EObject) actual.eGet(ref);
				
				if (ref.isContainment()) {
					checkObjectAttributes(exp, act);
					checkContainedObjects(exp, act);
				}
			}
		}
	}
	
	protected GenExpressionProviderBase findGenExpressionProviderBase(GenExpressionProviderBase exp, EList<GenExpressionProviderBase> actuals) {
		for (GenExpressionProviderBase actual: actuals) {
			if (checkValueExpressions(exp.getExpressions(), actual.getExpressions()))
				return actual;
		}
		return null;
	}
	
	protected ValueExpression findValueExpression(ValueExpression expected, EList<ValueExpression> actuals) {
		for (ValueExpression actual: actuals) {
			if (actual.getBody().equals(expected.getBody()) && actual.getBodyString().equals(expected.getBodyString())) {
				return actual;
			}
		}
		return null;
	}
	
	protected boolean checkValueExpressions(EList<ValueExpression> expected, EList<ValueExpression> actual) {
		if (expected.size() == actual.size()) {
			boolean find = true;
			for (int i=0;i<expected.size();i++) {
				ValueExpression exp = expected.get(i);
				ValueExpression found = findValueExpression(exp, actual);
				find = find && found != null;
			}
			return find;
		}
		return false;
	}
	
	protected GenNavigatorChildReference findSameChildReference(GenNavigatorChildReference expected, EList<GenNavigatorChildReference> actuals, EList<GenNavigatorChildReference> found) {
		for (GenNavigatorChildReference actual: actuals) {
			
			if (expected.getChild().getVisualID() == actual.getChild().getVisualID()) {
				
				if (expected.getParent() == null) {
					assertNull(actual.getParent());
					if (!found.contains(actual))
						return actual;
				} else {
					assertNotNull(actual.getParent());
					if (actual.getParent().getVisualID() == expected.getParent().getVisualID()) {
						if (!found.contains(actual))
							return actual;
					}
				}
			}
		}
		return null;
	}
	
	protected GenAuditContext findActualCtx(GenAuditContext expected, EList<GenAuditContext> actuals) {
		for (GenAuditContext actual: actuals) {
			if (actual.getId().equals(expected.getId())) {
				return actual;
			}
		}
		return null;
	}
	
	protected GenParserImplementation findParserImpl(GenParserImplementation expectImpl, EList<GenParserImplementation> actuals) {
		for (GenParserImplementation actual: actuals) {
			if (actual.eClass().equals(expectImpl.eClass())) {
				boolean res = true;
				for (LabelModelFacet facet: expectImpl.getUses()) {
					res = res && findLabelModelFacet(facet, actual.getUses());
				}
				if (res)
					return actual;
			}
		}
		return null;
	}

	private boolean findLabelModelFacet(LabelModelFacet facet, EList<LabelModelFacet> uses) {
		GenCommonBase expected = (GenCommonBase)facet.eContainer();
		
		if (uses.isEmpty()) return false;
		for (LabelModelFacet f: uses) {
			if (f.eContainer() instanceof GenCommonBase) {
				if ( ((GenCommonBase)f.eContainer()).getVisualID() == expected.getVisualID() )
					return true;
			}
		}
		return false;
	}
	
}
