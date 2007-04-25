/*
 * Copyright (c) 2005, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import junit.framework.Assert;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase;
import org.eclipse.gmf.tests.CompileUtil;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.osgi.framework.Constants;

/**
 * Generates and (by default) compiles gmf plugins.
 * @author artem
 */
public class GenProjectBaseSetup {
	private final Set<String> projectsToInit = new LinkedHashSet<String>(); 
	private CompileUtil compileUtil;
	private GeneratorConfiguration myGeneratorFactory;
	
	private static final String INTERFACE_TEMPLATE = "{0} public interface {1} '{ }'";

	public GenProjectBaseSetup(GeneratorConfiguration generatorFactory) {
		myGeneratorFactory = generatorFactory;
	}

	public void generateAndCompile(DiaGenSource diaGenSource) throws Exception {
		projectsToInit.clear();	//just in case
		compileUtil = new CompileUtil();
		final GenDiagram d = diaGenSource.getGenDiagram();
		generateDiagramPrerequisites(d);
		generateDiagramPlugin(d);
		for (String pluginID : projectsToInit) {
			IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginID);
			hookProjectBuild(p);
		}
		compileUtil = null;
	}

	protected void generateDiagramPrerequisites(GenDiagram d) throws Exception {
		final GenModel domainGenModel = d.getEditorGen().getDomainGenModel();
		if (domainGenModel != null) {
			generateEMFCode(domainGenModel);
			projectsToInit.add(domainGenModel.getModelPluginID());
			projectsToInit.add(domainGenModel.getEditPluginID());
		}
	}

	protected void generateDiagramPlugin(GenDiagram d) throws Exception {
		GeneratorBase generator = myGeneratorFactory.createGenerator(d);
		generator.run();
		hookGeneratorStatus(generator.getRunStatus());
		final String gmfEditorId = d.getEditorGen().getPlugin().getID();
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(gmfEditorId);
		RuntimeWorkspaceSetup.INSTANCE.updateClassPath(project);
		RuntimeWorkspaceSetup.INSTANCE.getReadyToStartAsBundle(project);

		projectsToInit.add(gmfEditorId);
		hookJDTStatus(ResourcesPlugin.getWorkspace().getRoot().getProject(gmfEditorId));
	}

	private void generateEMFCode(GenModel domainGenModel) {
		domainGenModel.setCanGenerate(true);
		org.eclipse.emf.codegen.ecore.generator.Generator gen = new org.eclipse.emf.codegen.ecore.generator.Generator();
        gen.setInput(domainGenModel);
        gen.generate(domainGenModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new BasicMonitor());
        gen.generate(domainGenModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, new BasicMonitor());
        
		fixInstanceClasses(domainGenModel);
		RuntimeWorkspaceSetup.INSTANCE.getReadyToStartAsBundle(ResourcesPlugin.getWorkspace().getRoot().getProject(domainGenModel.getModelPluginID()));
		if (!domainGenModel.getModelPluginID().equals(domainGenModel.getEditPluginID())) {
			RuntimeWorkspaceSetup.INSTANCE.getReadyToStartAsBundle(ResourcesPlugin.getWorkspace().getRoot().getProject(domainGenModel.getEditPluginID()));
		}
	}

	private void fixInstanceClasses(GenModel domainGenModel) {
		final Set<String> allInstanceClassNames = new HashSet<String>();
		for (GenPackage nextPackage : domainGenModel.getGenPackages()) {
			for (GenClassifier nextGenClassifier : nextPackage.getGenClassifiers()) {
				if (nextGenClassifier.getEcoreClassifier().eIsSet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME)) {
					allInstanceClassNames.add(nextGenClassifier.getEcoreClassifier().getInstanceClassName());
				}
			}
		}
		if (allInstanceClassNames.isEmpty()) {
			return;
		}

		IPackageFragmentRoot theRoot = null;
		IFile manifestFile = null;
		try {
			String pluginID = domainGenModel.getModelPluginID();
			IProject pluginProject = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginID);
			IJavaProject javaProject = JavaCore.create(pluginProject);
			Assert.assertNotNull("Generated EMF model project is not a java project", javaProject);
			IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
			for (int i = 0; i < roots.length && theRoot == null; i++) {
				if (!roots[i].isReadOnly()) {
					theRoot = roots[i];
				}
			}
			
			manifestFile = pluginProject.getFile(JarFile.MANIFEST_NAME);
			Assert.assertNotNull("Writable project root not found in the generated project", theRoot);
			Assert.assertTrue("Manifest was not generated", manifestFile != null && manifestFile.exists());

			Manifest manifest = new Manifest(manifestFile.getContents());

			Attributes attributes = manifest.getMainAttributes();
			StringBuffer exportedPackages = new StringBuffer(attributes.getValue(Constants.EXPORT_PACKAGE));

			for (String instanceClassName : allInstanceClassNames) {
				generateUserInterface(instanceClassName, theRoot, exportedPackages);
			}

			attributes.putValue(Constants.EXPORT_PACKAGE, exportedPackages.toString());
			ByteArrayOutputStream contents = new ByteArrayOutputStream();
			manifest.write(contents);
			manifestFile.setContents(new ByteArrayInputStream(contents.toByteArray()), true, true, new NullProgressMonitor());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	private void generateUserInterface(String fqClassName, IPackageFragmentRoot projectRoot, StringBuffer exportedPackages) {
		String className = CodeGenUtil.getSimpleClassName(fqClassName);
		String packageName = CodeGenUtil.getPackageName(fqClassName);
		if (packageName == null) {
			packageName = "";
		}
		String packagePrefix = packageName;
		try {
			IPackageFragment pkgFragment = projectRoot.createPackageFragment(packageName, true, new NullProgressMonitor());
			if (packagePrefix.length() > 0) {
				packagePrefix = "package " + packagePrefix + ";";
			}
			pkgFragment.createCompilationUnit(className + ".java", MessageFormat.format(INTERFACE_TEMPLATE, new Object[] {packagePrefix, className}), true, new NullProgressMonitor());
		} catch (JavaModelException e) {
			Assert.fail(e.getMessage());
		}
		if (packageName.length() > 0 && exportedPackages.indexOf(packageName) == -1) {
			exportedPackages.append(",");
			exportedPackages.append(packageName);
		}
	}

	public List<String> getGeneratedProjectNames() {
		return Collections.unmodifiableList(new LinkedList<String>(projectsToInit));
	}

	protected void hookProjectBuild(IProject p) throws Exception {
		IStatus s = compileUtil.build(p);
		if (!s.isOK()) {
			Plugin.getInstance().getLog().log(s);
			if (s.getException() != null) {
				s.getException().printStackTrace(System.err);
			} else {
				System.err.println("hookProjectBuild failed without exception:" + s);
			}
			Assert.fail(s.getMessage());
		}
	}

	// FIXME turn verification back once figure templates are ok
	protected void hookJDTStatus(IProject p) throws Exception {
//		JDTUtil jdtUtil = new JDTUtil(p);
//		IStatus jdtStatus = jdtUtil.collectProblems();
//		if (!jdtStatus.isOK()) {
//			Plugin.logError(jdtStatus.getMessage());
//			Assert.fail(jdtStatus.getMessage());
//		}
	}

	protected void hookGeneratorStatus(IStatus generatorStatus) {
		if (!generatorStatus.isOK()) {
			Plugin.getInstance().getLog().log(generatorStatus);
		}
		if (generatorStatus.getSeverity() == IStatus.ERROR) {
			Assert.fail("GMF editor generation produced errors:" + generatorStatus.toString()); //$NON-NLS-1$
		}
	}
}
