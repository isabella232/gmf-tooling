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
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.osgi.framework.Bundle;

/**
 * ALMOST TRUE: With PDE, we need source code in the running workspace to allow compilation of our code 
 * (because PDE doesn't reexport set of plugins from it's running configuration, and it's no longer possible 
 * to set Target Platform to "same as running" as it was back in Eclipse 2.x).
 * 
 * !!! NEW !!!
 * 
 * Now, we managed to compile against linked binary folders, although using linked content instead of plugins 
 * requires us to explicitly add some plugins earlier available through plugin re-export (namely, oe.jface.text) 
 *  
 * 
 * Classloading works because there's -dev argument in the command line. With PDE launch, it's done by PDE.
 * Without PDE, running tests as part of the build relies on Eclipse Testing Framework's org.eclipse.test_3.1.0/library.xml
 * which specifies "-dev bin". Once it's not specified, or new format (properties file with plugin-id=binfolder) 
 * is in use, classloading of the generated code will fail and another mechanism should be invented then.
 * 
 * If you get ClassNotFoundException while running tests in PDE environment, try to set read-only attribute for the next file:
 * 'development-workspace'\.metadata\.plugins\org.eclipse.pde.core\'JUnitLaunchConfigName'\dev.properties
 * @author artem
 */
public class RuntimeWorkspaceSetup {

	/**
	 * Copy of <code>PDECore.CLASSPATH_CONTAINER_ID</code>
	 */
	private static final String PLUGIN_CONTAINER_ID = "org.eclipse.pde.core.requiredPlugins";

	private boolean isDevLaunchMode;

	public RuntimeWorkspaceSetup() {
		isDevLaunchMode = isDevLaunchMode();
	}

	/**
	 * Copy (almost, except for strange unused assignment) of <code>PDECore.isDevLaunchMode()</code>
	 */
	private static boolean isDevLaunchMode() {
		String[] args = Platform.getApplicationArgs();
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-pdelaunch")) { //$NON-NLS-1$
				return true;
			}
		}
		return false;
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	// TODO Refactor to clear away similar code (CodeCompilationTest, RuntimeWorkspaceSetup, GenProjectSetup)
	public RuntimeWorkspaceSetup init() throws Exception {
		ensureJava14();
		if (isDevLaunchMode) {
			// Need to get some gmf source code into target workspace 
			importDevPluginsIntoRunTimeWorkspace(new String[] {
//					"org.apache.batik",
					"org.eclipse.gmf.runtime.notation",
					"org.eclipse.gmf.runtime.notation.edit",
					"org.eclipse.wst.common.ui.properties",
					"org.eclipse.gmf.runtime.common.core",
					"org.eclipse.gmf.runtime.common.ui",
					"org.eclipse.gmf.runtime.draw2d.ui",
					"org.eclipse.gmf.runtime.draw2d.ui.render",
					"org.eclipse.gmf.runtime.gef.ui",
					"org.eclipse.gmf.runtime.common.ui.services",
					"org.eclipse.gmf.runtime.emf.type.core",
					"org.eclipse.gmf.runtime.emf.clipboard.core",
					"org.eclipse.emf.validation",
					"org.eclipse.gmf.runtime.emf.core",
					"org.eclipse.gmf.runtime.common.ui.services.action",
					"org.eclipse.gmf.runtime.common.ui.action",
					"org.eclipse.gmf.runtime.common.ui.action.ide",
					"org.eclipse.gmf.runtime.emf.ui",
					"org.eclipse.gmf.runtime.emf.commands.core",
					"org.eclipse.gmf.runtime.diagram.core",
					"org.eclipse.gmf.runtime.diagram.ui",
					"org.eclipse.gmf.runtime.common.ui.services.properties",
					"org.eclipse.gmf.runtime.emf.ui.properties",
					"org.eclipse.gmf.runtime.diagram.ui.actions",
					"org.eclipse.gmf.runtime.diagram.ui.properties",
					"org.eclipse.gmf.runtime.diagram.ui.providers",
					"org.eclipse.gmf.runtime.diagram.ui.providers.ide",
					"org.eclipse.gmf.runtime.diagram.ui.render",
					"org.eclipse.gmf.runtime.diagram.ui.resources.editor",
					"org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide",
					"org.eclipse.gmf.runtime.notation.providers",
//					"antlr", //$NON-NLS-1$					
					"org.eclipse.emf.ocl", //$NON-NLS-1$
					"org.eclipse.emf.query", //$NON-NLS-1$	
					"org.eclipse.emf.query.ocl", //$NON-NLS-1$
			});
		}
		return this;
	}

	public static IProject getSOSProject() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(".SOSProject");
	}

	/**
	 * Another approach - output binary folders of required plugins are linked as subfolders 
	 * of our own sosProject (created in the target workspace). Then, we could use library classpathEntries
	 * (details why we should use _workspace_ paths for libraries could be found at 
	 * <code>org.eclipse.jdt.internal.core.builder.NameEnvironment#computeClasspathLocations</code>)
	 *  
	 * TODO don't assume workspace is clear, check sosProject existence first
	 * TODO utilize GenDiagram.requiredPluginIDs once it's a field (i.e. add oe.jface.text and don't create plugin project then, just plain project with links
	 */
	private void importDevPluginsIntoRunTimeWorkspace(String[] pluginIDs) throws CoreException {
		IProject p = getSOSProject();
		final Path srcPath = new Path('/' + p.getName() + "/src"); //$NON-NLS-1$
		Generator.createEMFProject(srcPath, null, Collections.EMPTY_LIST, new NullProgressMonitor(), Generator.EMF_PLUGIN_PROJECT_STYLE, null);
		URL[] urls = getDevPluginsLocations(pluginIDs);
		for (int i = 0; i < urls.length; i++) {
			IPath path = new Path(urls[i].getPath());
			IFolder f = p.getFolder(path.lastSegment().replace('.', '_'));
			f.createLink(path.append("bin/"), IResource.REPLACE, new NullProgressMonitor());
		}
		
		StringBuffer pluginXmlContent = new StringBuffer();
		pluginXmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<?eclipse version=\"3.0\"?>\n<plugin ");
		pluginXmlContent.append(" version=\"1.0.0\" name='%providerName' id='");
		pluginXmlContent.append(p.getName());
		pluginXmlContent.append("'>\n<requires>\n");
		pluginXmlContent.append("<import plugin='org.eclipse.jface.text' export='true'/>");
		pluginXmlContent.append("</requires>\n</plugin>");
		p.getFile("plugin.xml").create(new ByteArrayInputStream(pluginXmlContent.toString().getBytes()), true, new NullProgressMonitor());
	}

	private IJavaProject asJavaProject(IProject p) {
		return JavaCore.create(p);
	}

	/**
	 * TODO uniqueClassPathEntries is not needed if diagramProj gets here only once. It's not the case
	 * now - refactor LinkCreationConstraintsTest to utilize genProject created in AuditRulesTest (?)
	 * TODO refactor with ClasspathContainerInitializer - just for the sake of fixing the knowledge 
	 */
	public void updateClassPath(IProject diagramProj) throws CoreException {
		if (!isDevLaunchMode) {
			return;
		}
		IResource[] members;
		try {
			members = getSOSProject().members();
		} catch (CoreException ex) {
			ex.printStackTrace();
			members = new IResource[0];
		}
		final IJavaProject sosJavaPrj = asJavaProject(getSOSProject());
		IClasspathEntry[] cpOrig = asJavaProject(diagramProj).getRawClasspath();
		ArrayList rv = new ArrayList(10 + cpOrig.length + members.length);
		rv.addAll(Arrays.asList(cpOrig));
		IClasspathContainer c = JavaCore.getClasspathContainer(new Path(PLUGIN_CONTAINER_ID), sosJavaPrj);
		if (c != null) {
			IClasspathEntry[] cpAdd = c.getClasspathEntries();
			rv.addAll(Arrays.asList(cpAdd));
		}
		for (int i = 0; i < members.length; i++) {
			if (members[i].getType() != IResource.FOLDER || !members[i].isLinked()) {
				continue;
			}
			rv.add(JavaCore.newLibraryEntry(members[i].getFullPath(), null, null));
		}
		IPath antlrPath = new Path(getDevPluginsLocations(new String[] {"antlr"})[0].getPath());
		rv.add(JavaCore.newLibraryEntry(antlrPath.append("lib/antlr.jar"), null, null));

		final Set uniqueClassPathEntries = new HashSet();
		for (Iterator it = rv.iterator(); it.hasNext();) {
			IClasspathEntry next = (IClasspathEntry) it.next();
			if (uniqueClassPathEntries.contains(next.getPath())) {
				it.remove();
			} else {
				uniqueClassPathEntries.add(next.getPath());
			}
		}
		IClasspathEntry[] cpNew = (IClasspathEntry[]) rv.toArray(new IClasspathEntry[rv.size()]);
		asJavaProject(diagramProj).setRawClasspath(cpNew, new NullProgressMonitor());
	}

	private URL[] getDevPluginsLocations(String[] pluginIDs) {
		ArrayList/*<URL>*/ urls = new ArrayList/*<URL>*/(pluginIDs.length); 
		for (int i = 0; i < pluginIDs.length; i++) {
			try {
				Bundle b = Platform.getBundle(pluginIDs[i]);
				if (b != null) {
					urls.add(Platform.resolve(b.getEntry("/")));
				} else {
					System.err.println("Bundle " + pluginIDs[i] + " is missing, skipped.");
				}
			} catch (Exception ex) {
				Plugin.logError("Error looking for " + pluginIDs[i] + " plug-in:", ex);
				ex.printStackTrace();
			}
		}
		return (URL[]) urls.toArray(new URL[urls.size()]);
	}

	/**
	 * at least
	 */
	public void ensureJava14() {
		if (!JavaCore.VERSION_1_4.equals(JavaCore.getOption(JavaCore.COMPILER_SOURCE))) {
			Hashtable options = JavaCore.getOptions();
			options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_4);
			options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_4);
			options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_4);
			JavaCore.setOptions(options);
		}
	}
}
