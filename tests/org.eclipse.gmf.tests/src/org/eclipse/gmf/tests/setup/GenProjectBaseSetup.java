/*
 * Copyright (c) 2005 Borland Software Corporation
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
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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
import org.eclipse.core.runtime.CoreException;
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
		projectsToInit.clear(); // just in case
		compileUtil = new CompileUtil();
		final GenDiagram d = diaGenSource.getGenDiagram();
		final GenModel domainGenModel = d.getEditorGen().getDomainGenModel();
		generateEMFCode(domainGenModel);
        projectsToInit.add(domainGenModel.getModelPluginID());
        projectsToInit.add(domainGenModel.getEditPluginID());
		
		GeneratorBase generator = myGeneratorFactory.createGenerator(d);
		generator.run();
		hookGeneratorStatus(generator.getRunStatus());
		final String gmfEditorId = d.getEditorGen().getPlugin().getID();
		RuntimeWorkspaceSetup.INSTANCE.updateClassPath(ResourcesPlugin.getWorkspace().getRoot().getProject(gmfEditorId));

		projectsToInit.add(gmfEditorId);
		for (Iterator it = projectsToInit.iterator(); it.hasNext();) {
			String pluginID = (String) it.next();
			IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginID);
			hookProjectBuild(p);
		}
		hookJDTStatus(ResourcesPlugin.getWorkspace().getRoot().getProject(gmfEditorId));
		compileUtil = null;
	}

	private void generateEMFCode(GenModel domainGenModel) {
		domainGenModel.setCanGenerate(true);
		org.eclipse.emf.codegen.ecore.generator.Generator gen = new org.eclipse.emf.codegen.ecore.generator.Generator();
        gen.setInput(domainGenModel);
        gen.generate(domainGenModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new BasicMonitor());
        gen.generate(domainGenModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, new BasicMonitor());
        
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
		} catch (JavaModelException e) {
			Plugin.logError("Compilation error", e);
			Assert.fail(e.getMessage());
		}
		Assert.assertNotNull("Writable project root not found in the generated project", theRoot);
		Assert.assertTrue("Manifest was not generated", manifestFile != null && manifestFile.exists());

		Manifest manifest;
		try {
			manifest = new Manifest(manifestFile.getContents());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
			return;
		} catch (CoreException e) {
			Assert.fail(e.getMessage());
			return;
		}
		
		Attributes attributes = manifest.getMainAttributes();
		StringBuffer exportedPackages = new StringBuffer(attributes.getValue(Constants.EXPORT_PACKAGE));
		
        Collection genClassifiers = new ArrayList();
        for (Iterator it = domainGenModel.getGenPackages().iterator(); it.hasNext();) {
			GenPackage nextPackage = (GenPackage) it.next();
			genClassifiers.addAll(nextPackage.getGenClassifiers());
		}
        
        for (Iterator it = genClassifiers.iterator(); it.hasNext();) {
			GenClassifier nextGenClassifier = (GenClassifier) it.next();
			if (nextGenClassifier.getEcoreClassifier().eIsSet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME)) {
				generateUserInterface(nextGenClassifier.getEcoreClassifier().getInstanceClassName(), theRoot, exportedPackages);
			}
		}
        
        attributes.putValue(Constants.EXPORT_PACKAGE, exportedPackages.toString());
        try {
        	ByteArrayOutputStream contents = new ByteArrayOutputStream();
			manifest.write(contents);
			manifestFile.setContents(new ByteArrayInputStream(contents.toByteArray()), true, true, new NullProgressMonitor());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		} catch (CoreException e) {
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
			Plugin.logError(s.getMessage());
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
