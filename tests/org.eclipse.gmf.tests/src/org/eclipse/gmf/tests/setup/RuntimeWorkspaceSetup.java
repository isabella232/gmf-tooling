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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.framework.internal.core.FrameworkProperties;
import org.osgi.framework.Bundle;

/**
 * Running tests within PDE, we face two major problems:
 * <ol>
 * <li>Compile generated plugins against projects in our development workspaces. We are not alone here, suffice 
 * it to mention {@linkplain https://bugs.eclipse.org/bugs/show_bug.cgi?id=109137} and 
 * {@linkplain https://bugs.eclipse.org/bugs/show_bug.cgi?id=182537}. 
 * Though it's possible to inject development plugins into target configuration
 * <pre>
 *  URL url = FileLocator.resolve(Platform.getBundle("org.eclipse.gmf.validate").getEntry("/"));
 * 	TargetPlatformHelper.getPDEState().addAdditionalBundles(new URL[] {});
 * </pre> 
 * it doesn't help, unless <code>org.eclipse.jdt.internal.core.builder.NameEnvironment#computeClasspathLocations<code> 
 * [can be|is] modified to support folders with classes.
 * 
 * <p> For now, we managed to compile against linked binary folders, although using linked content instead of plugins 
 * requires us to explicitly add some plugins earlier available through plugin re-export (namely, oe.jface.text)</p>
 *  
 * <li>Loading compiled classes. This can be solved either with "-dev bin" command-line argument or using 
 * {@link #getReadyToStartAsBundle(IProject)} hack that updates classpath specified in manifest.mf.
 * Eclipse Testing Framework used to specify "-dev bin, runtime" (org.eclipse.test_3.1.0/library.xml), but 
 * these days (as of 3.3 M6) seem to abandon this practice.  
 * </ol>
 * 
 * Running tests as part of the build, we don't experience troubles with compiling, and classloading is 
 * solved with {@link #getReadyToStartAsBundle(IProject)} hack now.
 * 
 * @author artem
 */
public class RuntimeWorkspaceSetup {

	/**
	 * Copy of <code>PDECore.CLASSPATH_CONTAINER_ID</code>
	 */
	private static final String PLUGIN_CONTAINER_ID = "org.eclipse.pde.core.requiredPlugins"; //$NON-NLS-1$

	private final boolean isDevLaunchMode;
	private final boolean isDevBinPresent;

	public static RuntimeWorkspaceSetup INSTANCE;

	public RuntimeWorkspaceSetup() {
		isDevLaunchMode = isDevLaunchMode();
		List<String> l = Arrays.asList(Platform.getCommandLineArgs());
		int i;
		if ((i = l.indexOf("-dev")) != -1) {
			isDevBinPresent = i + 1 < l.size() && l.get(i+1).startsWith("bin");
		} else {
			isDevBinPresent = FrameworkProperties.getProperty("osgi.dev", "").contains("bin");
		}
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

	public RuntimeWorkspaceSetup initFull() throws Exception {
		init(new String[] {
//				"org.apache.batik",
				"org.eclipse.gmf.runtime.notation", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.notation.edit", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.common.core", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.common.ui", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.draw2d.ui", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.draw2d.ui.render", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.gef.ui", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.common.ui.services", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.emf.type.core", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.emf.clipboard.core", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.emf.core", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.common.ui.services.action", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.common.ui.action", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.common.ui.action.ide", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.emf.ui", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.emf.commands.core", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.diagram.core", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.diagram.ui", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.common.ui.services.properties", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.emf.ui.properties", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.diagram.ui.actions", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.diagram.ui.properties", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.diagram.ui.providers", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.diagram.ui.providers.ide", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.diagram.ui.render", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.diagram.ui.resources.editor", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide", //$NON-NLS-1$
				"org.eclipse.gmf.runtime.notation.providers", //$NON-NLS-1$			
				"org.eclipse.emf.ocl", //$NON-NLS-1$
				"org.eclipse.emf.query", //$NON-NLS-1$	
				"org.eclipse.emf.query.ocl", //$NON-NLS-1$
				//
				"org.eclipse.emf.edit", //$NON-NLS-1$
				"org.eclipse.emf.transaction", //$NON-NLS-1$
				"org.eclipse.emf.workspace", //$NON-NLS-1$
				"org.eclipse.emf.validation", //$NON-NLS-1$
		});
		return this;
	}

	public RuntimeWorkspaceSetup initLite() throws Exception {
		init("org.eclipse.gmf.runtime.notation", //$NON-NLS-1$
			"org.eclipse.gmf.runtime.notation.edit", //$NON-NLS-1$
			"org.eclipse.emf.ocl", //$NON-NLS-1$
			"org.eclipse.emf.transaction", //$NON-NLS-1$
			"org.eclipse.emf.validation", //$NON-NLS-1$
			"org.eclipse.emf.workspace", //$NON-NLS-1$
			"org.eclipse.gmf.runtime.draw2d.ui", //$NON-NLS-1$
			"org.eclipse.gmf.runtime.lite"); //$NON-NLS-1$
		return this;
	}
	
	// TODO Refactor to clear away similar code (CodeCompilationTest, RuntimeWorkspaceSetup, GenProjectSetup)
	private void init(String... pluginsToImport) throws Exception {
		ensureJava14();
		turnWorkspaceHistoryOff();
		if (isDevLaunchMode) {
			// Need to get some gmf source code into target workspace
			importDevPluginsIntoRunTimeWorkspace(pluginsToImport); // takes 2,5 seconds
		}
	}

	public static IProject getSOSProject() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(".SOSProject"); //$NON-NLS-1$
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
		final List<IProject> referencedProjects = Collections.emptyList();
		Generator.createEMFProject(srcPath, null, referencedProjects, new NullProgressMonitor(), Generator.EMF_PLUGIN_PROJECT_STYLE, null);
		
		StringBuffer pluginXmlContent = new StringBuffer();
		pluginXmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<?eclipse version=\"3.0\"?>\n<plugin "); //$NON-NLS-1$
		pluginXmlContent.append(" version=\"1.0.0\" name='%providerName' id='"); //$NON-NLS-1$
		pluginXmlContent.append(p.getName());
		pluginXmlContent.append("'>\n<requires>\n"); //$NON-NLS-1$
		pluginXmlContent.append("<import plugin='org.eclipse.jface.text' export='true'/>\n"); //$NON-NLS-1$
		pluginXmlContent.append("<import plugin='org.eclipse.ui.views.properties.tabbed' export='true'/>\n"); //$NON-NLS-1$

		ClasspathEntry[] classpathEntries = getClasspathEntries(pluginIDs);
		for (int i = 0; i < classpathEntries.length; i++) {
			classpathEntries[i].importTo(p, pluginXmlContent);
		}

		pluginXmlContent.append("</requires>\n</plugin>"); //$NON-NLS-1$
		p.getFile("plugin.xml").create(new ByteArrayInputStream(pluginXmlContent.toString().getBytes()), true, new NullProgressMonitor()); //$NON-NLS-1$
	}

	private ClasspathEntry[] getClasspathEntries(String[] pluginIDs) {
		ArrayList<ClasspathEntry> entries = new ArrayList<ClasspathEntry>(pluginIDs.length); 
		for (int i = 0; i < pluginIDs.length; i++) {
			ClasspathEntry nextEntry = new ClasspathEntry(pluginIDs[i]);
			if (nextEntry.isValid()) {
				entries.add(nextEntry);				
			} else {
				System.out.println("Bundle " + pluginIDs[i] + " is missing, skipped."); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return entries.toArray(new ClasspathEntry[entries.size()]);
	}

	private IJavaProject asJavaProject(IProject p) {
		return JavaCore.create(p);
	}

	/**
	 * a substiture for "-dev bin" command-line argument - update
	 * a manifest.mf with explicit bin/ classpath for classloading to work 
	 */
	public void getReadyToStartAsBundle(IProject project) {
		if (isDevBinPresent) {
			return; // no sense
		}
		try {
			IFile manifest = project.getFile("META-INF/MANIFEST.MF");
			if (manifest.exists()) {
				BufferedReader r = new BufferedReader(new InputStreamReader(manifest.getContents(), manifest.getCharset()));
				String line;
				boolean found = false;
				StringBuilder result = new StringBuilder();
				while ((line = r.readLine()) != null) {
					result.append(line);
					if (!found && line.startsWith("Bundle-ClassPath:")) {
						if (line.indexOf("bin/") == -1) {
							result.append(", bin/");
						}
						found = true;
					}
					result.append("\n");
				}
				if (!found) {
					result.insert(0, "Bundle-ClassPath: bin/, .\n");
				}
				manifest.setContents(new ByteArrayInputStream(result.toString().getBytes(manifest.getCharset())), true, false, new NullProgressMonitor());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail("Can't get project " + project.getName() + " ready to be started as bundle:" + ex);
		}
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
		ArrayList<IClasspathEntry> rv = new ArrayList<IClasspathEntry>(10 + cpOrig.length + members.length);
		IClasspathContainer c = JavaCore.getClasspathContainer(new Path(PLUGIN_CONTAINER_ID), sosJavaPrj);
		if (c != null) {
			IClasspathEntry[] cpAdd = c.getClasspathEntries();
			rv.addAll(Arrays.asList(cpAdd));
		}
		for (int i = 0; i < members.length; i++) {
			if (!members[i].isLinked()) {
				continue;
			}
			rv.add(JavaCore.newLibraryEntry(members[i].getFullPath(), null, null));
		}

		final Set<IPath> uniqueClassPathEntries = new HashSet<IPath>();
		IClasspathEntry[] cpOrigResolved = asJavaProject(diagramProj).getResolvedClasspath(true);
		for (int i = 0; i < cpOrigResolved.length; i++) {
			uniqueClassPathEntries.add(cpOrigResolved[i].getPath());
		}
		for (Iterator<IClasspathEntry> it = rv.iterator(); it.hasNext();) {
			IClasspathEntry next = it.next();
			if (uniqueClassPathEntries.contains(next.getPath())) {
				it.remove();
			} else {
				uniqueClassPathEntries.add(next.getPath());
			}
		}
		rv.addAll(Arrays.asList(cpOrig));
		
		IClasspathEntry[] cpNew = rv.toArray(new IClasspathEntry[rv.size()]);
		asJavaProject(diagramProj).setRawClasspath(cpNew, new NullProgressMonitor());
	}

	/**
	 * at least 1.4
	 */
	@SuppressWarnings("unchecked")
	private void ensureJava14() {
		if (!JavaCore.VERSION_1_4.equals(JavaCore.getOption(JavaCore.COMPILER_SOURCE))) {
			Hashtable<String,String> options = JavaCore.getOptions();
			options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_4);
			options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_4);
			options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_4);
			JavaCore.setOptions(options);
		}
	}

	/**
	 * No need to track history for workspace resources
	 */
	private void turnWorkspaceHistoryOff() throws CoreException {
		IWorkspaceDescription wd = ResourcesPlugin.getWorkspace().getDescription();
		wd.setFileStateLongevity(0);
		wd.setMaxFileStates(0);
		wd.setMaxFileStateSize(0);
		wd.setSnapshotInterval(60*60*1000);
		wd.setAutoBuilding(false);
		ResourcesPlugin.getWorkspace().setDescription(wd);
	}

	private class ClasspathEntry {
		
		private String myPluginID;
		private URL myBundleURL;
		private File myBundleFile;
		private File myClassesContainerFile;

		private ClasspathEntry(String pluginID) {
			myPluginID = pluginID;
		}

		public void importTo(IProject p, StringBuffer pluginXmlContent) {
			if (!getClassesContainerFile().exists()) {
				pluginXmlContent.append("<import plugin='"); //$NON-NLS-1$
				pluginXmlContent.append(myPluginID);
				pluginXmlContent.append("' export='true'/>\n"); //$NON-NLS-1$
			} else {
				if (getClassesContainerFile().isDirectory()) {
					String entryName = getBundleFile().getName().replace('.', '_');
					IFolder folder = p.getFolder(entryName);
					try {
						folder.createLink(new Path(getClassesContainerFile().getAbsolutePath()), IResource.REPLACE, new NullProgressMonitor());
					} catch (CoreException e) {
						e.printStackTrace();
					}
				} else if (getClassesContainerFile().isFile()) {
					String entryName = getClassesContainerFile().getName();
					IFile file = p.getFile(entryName);
					try {
						file.createLink(new Path(getClassesContainerFile().getAbsolutePath()), IResource.REPLACE, new NullProgressMonitor());
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		private File getClassesContainerFile() {
			if (myClassesContainerFile == null) {
				myClassesContainerFile = new File(getBundleFile(), getRelativePath());
			}
			return myClassesContainerFile;
		}
		
		private File getBundleFile() {
			if (myBundleFile == null) {
				myBundleFile = new File(getBundleURL().getFile());
			}
			return myBundleFile;
		}
		
		private String getRelativePath() {
			return "/bin/"; //$NON-NLS-1$
		}
		
		private URL getBundleURL() {
			if (myBundleURL == null) {
				Bundle bundle = Platform.getBundle(myPluginID);
				if (bundle == null) {
					//Do not throw exception. This allows requiring lite runtime plugin and not failing in configurations where it is not present.
					return null;
				}
				try {
					myBundleURL = FileLocator.resolve(bundle.getEntry("/")); //$NON-NLS-1$
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return myBundleURL;
		}
		
		public boolean isValid() {
			return getBundleURL() != null;
		}
		
	}
}
