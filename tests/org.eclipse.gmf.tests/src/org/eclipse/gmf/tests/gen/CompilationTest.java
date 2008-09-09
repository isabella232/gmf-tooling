/*
 * Copyright (c) 2005, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.internal.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.setup.DiaDefSetup;
import org.eclipse.gmf.tests.setup.DiaDefSource;
import org.eclipse.gmf.tests.setup.DiaGenSetup;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.DomainModelFileSetup;
import org.eclipse.gmf.tests.setup.DomainModelSetup;
import org.eclipse.gmf.tests.setup.DomainModelSetupInstanceClassName;
import org.eclipse.gmf.tests.setup.DomainModelSource;
import org.eclipse.gmf.tests.setup.GenProjectBaseSetup;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.MapSetup;
import org.eclipse.gmf.tests.setup.MultiPackageGenSetup;
import org.eclipse.gmf.tests.setup.MultiplePackagesDomainModelSetup;
import org.eclipse.gmf.tests.setup.ToolDefSetup;
import org.eclipse.gmf.tests.setup.ToolDefSource;
import org.eclipse.gmf.tests.setup.annotated.GenASetup;
import org.eclipse.gmf.tests.setup.annotated.GraphDefASetup;
import org.eclipse.gmf.tests.setup.annotated.MapDefASetup;
import org.eclipse.gmf.tests.setup.annotated.ToolDefASetup;
import org.eclipse.jdt.core.IBuffer;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;

/**
 * TODO add compilation check for CustomFigure(FigureAccessor(no fqn), FigureAccessor(fqn));  
 */
public abstract class CompilationTest extends TestCase {
	
	protected final GeneratorConfiguration myGenConfig;
	protected final ViewmapProducer myViewmapProducer;
	protected MapDefASetup myMapSource;
	protected GenDiagramMutator[] myGeneralMutators;
	protected GenDiagramMutator[] myRichClientMutators;

	protected CompilationTest(String name, GeneratorConfiguration genConfig, ViewmapProducer viewmapProducer) {
		super(name);
		assert genConfig != null;
		assert viewmapProducer != null;
		myGenConfig = genConfig;
		myViewmapProducer = viewmapProducer;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		URI selected = Plugin.createURI("/models/library/library.ecore"); //$NON-NLS-1$
		DomainModelSource dmSource =  new DomainModelFileSetup().init(selected);
		ToolDefSource tdmSource = new ToolDefASetup(dmSource.getModel());
		DiaDefSource gdmSource = new GraphDefASetup(dmSource.getModel());
		myMapSource = new MapDefASetup(dmSource.getModel(), tdmSource.getRegistry(), gdmSource.getCanvasDef()); 
		myGeneralMutators = new GenDiagramMutator[] { SAME_FILE_MUTATOR, SYNCHRONIZED_MUTATOR, SHORTCUT_STUFF_MUTATOR };
		myRichClientMutators = new GenDiagramMutator[] { SAME_FILE_MUTATOR, SHORTCUT_STUFF_MUTATOR };
	}

	// TODO EditPartViewer[Source|Setup]

	protected DiaGenSource createLibraryGen(boolean rcp) throws Exception {
		return new GenASetup(myMapSource.getMapping(), myViewmapProducer, rcp);
	}

	// avoid requests like #174171
	public void testCompileWithStrictOptions() throws Exception {
		final HashMap<String, String> options = new HashMap<String,String>();
		options.put(JavaCore.COMPILER_PB_EMPTY_STATEMENT, JavaCore.ERROR);
		//
		switchJavaOptions(options);
		try {
			testCompileMultiPackageDomain(); // run any test
		} finally {
			switchJavaOptions(options);
		}
	}

	/**
	 * Installs java compiler options specified in the map, the map gets updated with
	 * old values.
	 */
	private static void switchJavaOptions(HashMap<String, String> options) {
		@SuppressWarnings("unchecked")
		Hashtable<Object, Object> settings = JavaCore.getOptions();
		for (String key : options.keySet()) {
			String originalValue = (String) settings.get(key);
			settings.put(key, options.get(key)); // install new
			options.put(key, originalValue); // keep old
		}
		JavaCore.setOptions(settings);
	}

	public void testRCPCompile() throws Exception {
		DiaGenSource gmfGenSource = createLibraryGen(true);
		gmfGenSource.getGenDiagram().getEditorGen().setSameFileForDiagramAndModel(false);
		generateAndCompile(gmfGenSource, myRichClientMutators);
	}

	public void testCompileDiagram() throws Exception {
		DiaGenSource gmfGenSource = createLibraryGen(false);
		generateAndCompile(gmfGenSource, myGeneralMutators);
	}

	public void testCompilePotentialNameClashes() throws Exception {
		DomainModelSource domainModel = new DomainModelSetup().init();
		domainModel.getNodeA().getEClass().setName("Node"); // #142211
		domainModel.getNodeB().getEClass().setName("ShapeNode");
		domainModel.getLinkAsClass().getEClass().setName("ConnectionNode");
		domainModel.getNodeA().getNameAttr().setName("attribute");
		domainModel.getNodeB().getNameAttr().setName("class");
		domainModel.getDiagramElement().setName("Diagram");
		MapDefSource mapSource = new MapSetup().init(new DiaDefSetup().init(), domainModel, new ToolDefSetup());
		DiaGenSource gmfGenSource = new DiaGenSetup(myViewmapProducer).init(mapSource);
		generateAndCompile(gmfGenSource);
	}

	public void testCompileInstanceClassNames() throws Exception {
		DomainModelSetup domainModelSetup = new DomainModelSetupInstanceClassName().init();
		MapDefSource mapSource = new MapSetup().init(new DiaDefSetup().init(), domainModelSetup, new ToolDefSetup());
		DiaGenSource gmfGenSource = new DiaGenSetup(myViewmapProducer).init(mapSource);
		generateAndCompile(gmfGenSource, SYNCHRONIZED_MUTATOR);
	}
	
	public void testCompileMultiPackageDomain() throws Exception {
		DomainModelSource ds = new MultiplePackagesDomainModelSetup().init();
		MapDefSource ms = new MapSetup().init(new DiaDefSetup().init(), ds, new ToolDefSetup());

		final LinkedHashSet<EPackage> additionalPacks = new LinkedHashSet<EPackage>(8);
		additionalPacks.add(ds.getNodeA().getEClass().getEPackage());
		additionalPacks.add(ds.getNodeB().getEClass().getEPackage());
		additionalPacks.add(ds.getLinkAsClass().getEClass().getEPackage());

		DiaGenSource gmfGenSource = new MultiPackageGenSetup(additionalPacks).init(ms);

		generateAndCompile(gmfGenSource);
	}

	protected void generateAndCompile(DiaGenSource genSource, GenDiagramMutator... mutators) throws Exception {
		final GenEditorGenerator editorGen = genSource.getGenDiagram().getEditorGen();
		new GenProjectBaseSetup(myGenConfig).generateAndCompile(editorGen, mutators);
	}

	// pulled from LiteCompilationTestWithImportConflicts, as it seems to be non-specific to lite runtime
	public void testPreexistingImportConflicts() throws Exception {
		DiaGenSource gmfGenSource = createLibraryGen(false);
		gmfGenSource.getGenDiagram().getEditorGen().setSameFileForDiagramAndModel(false);
		String pluginId = gmfGenSource.getGenDiagram().getEditorGen().getPlugin().getID();
		IProject diagramProject = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginId);
		if (!diagramProject.isAccessible()) {
			//Initialize the plugin the same way it would be initialized if present.
			Generator.createEMFProject(diagramProject.getFolder("src").getFullPath(), null, Collections.<IProject>emptyList(), new NullProgressMonitor(), Generator.EMF_PLUGIN_PROJECT_STYLE);	//$NON-NLS-1$
		}
		IJavaProject javaProject = JavaCore.create(diagramProject);
		assertTrue(javaProject.exists());
		IPackageFragment pf = javaProject.getPackageFragmentRoot(diagramProject.getFolder("src")).createPackageFragment(gmfGenSource.getGenDiagram().getNotationViewFactoriesPackageName(), false, new NullProgressMonitor());	//$NON-NLS-1$
		ICompilationUnit cu = pf.getCompilationUnit(gmfGenSource.getGenDiagram().getNotationViewFactoryClassName() + ".java");	//$NON-NLS-1$
		String contents = MessageFormat.format("package {0};\nimport {2};\n /**\n * @generated\n */\npublic class {1} '{ }'", gmfGenSource.getGenDiagram().getNotationViewFactoriesPackageName(), gmfGenSource.getGenDiagram().getNotationViewFactoryClassName(), "javax.swing.text.View");	//$NON-NLS-1$
		if (cu.exists()) {
			IBuffer buffer = cu.getBuffer();
			buffer.setContents(contents);
			buffer.save(new NullProgressMonitor(), true);
		} else {
			pf.createCompilationUnit(cu.getElementName(), contents, false, new NullProgressMonitor());
		}
		generateAndCompile(gmfGenSource);
	}

	protected final GenDiagramMutator SAME_FILE_MUTATOR = new GenDiagramMutator("sameFileForDiagramAndModel") {
		private boolean myIsSameFileForDiagramAndModel;
		public void doMutation(GenDiagram d) {
			myIsSameFileForDiagramAndModel = d.getEditorGen().isSameFileForDiagramAndModel();
			d.getEditorGen().setSameFileForDiagramAndModel(!myIsSameFileForDiagramAndModel);
		}
		public void undoMutation(GenDiagram d) {
			d.getEditorGen().setSameFileForDiagramAndModel(myIsSameFileForDiagramAndModel);
		}
	};

	protected final GenDiagramMutator SYNCHRONIZED_MUTATOR = new GenDiagramMutator("synchronized") {
		private boolean myIsSynchronized;
		public void doMutation(GenDiagram d) {
			myIsSynchronized = d.isSynchronized();
			d.setSynchronized(!myIsSynchronized);
		}
		public void undoMutation(GenDiagram d) {
			d.setSynchronized(myIsSynchronized);
		}
	};

	protected final GenDiagramMutator SHORTCUT_STUFF_MUTATOR = new GenDiagramMutator("shortcuts") {
		private List<String> myShortcutsTo;
		private List<String> myShortcutsFor;
		public void doMutation(GenDiagram d) {
			myShortcutsTo = new ArrayList<String>(d.getContainsShortcutsTo());
			d.getContainsShortcutsTo().clear();
			d.getContainsShortcutsTo().add(d.getEditorGen().getModelID());
			myShortcutsFor = new ArrayList<String>(d.getShortcutsProvidedFor());
			d.getShortcutsProvidedFor().clear();
			d.getShortcutsProvidedFor().add(d.getEditorGen().getModelID());
		}
		public void undoMutation(GenDiagram d) {
			d.getContainsShortcutsTo().clear();
			d.getContainsShortcutsTo().addAll(myShortcutsTo);
			d.getShortcutsProvidedFor().clear();
			d.getShortcutsProvidedFor().addAll(myShortcutsFor);
		}
	};
}
