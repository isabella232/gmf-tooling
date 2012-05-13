/*
 * Copyright (c) 2005, 2010 Borland Software Corporation and others
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
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;

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
 * <p>UPDATE: As of Eclipse 3.4 M7, PDE got better support for self-hosting and is capable compiling plugins 
 * in runtime workspace against target platform! Hooray!</p>
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

	private final boolean isDevBinPresent;

	private static RuntimeWorkspaceSetup instance;

	public static RuntimeWorkspaceSetup get() {
		if (instance == null) {
			instance = new RuntimeWorkspaceSetup();
			instance.init();
		}
		return instance;
	}

	public RuntimeWorkspaceSetup() {
		List<String> l = Arrays.asList(Platform.getCommandLineArgs());
		int i;
		if ((i = l.indexOf("-dev")) != -1) {
			isDevBinPresent = i + 1 < l.size() && l.get(i + 1).startsWith("bin");
		} else {
			String osgiDevProp = Plugin.getBundleContext().getProperty("osgi.dev");
			isDevBinPresent = osgiDevProp != null && osgiDevProp.contains("bin");
		}
	}

	// TODO Refactor to clear away similar code (CodeCompilationTest, RuntimeWorkspaceSetup, GenProjectSetup)
	private void init() {
		ensureJava14();
		try {
			IWorkspaceDescription wd = ResourcesPlugin.getWorkspace().getDescription();
			turnWorkspaceHistoryOff(wd);
			switchAutobuildOff(wd);
			ResourcesPlugin.getWorkspace().setDescription(wd);
		} catch (CoreException ex) {
			Assert.fail(ex.getMessage());
		}
	}

	/**
	 * a substitute for "-dev bin" command-line argument - update
	 * a manifest.mf with explicit bin/ classpath for classloading to work
	 *  
	 * FIXME copy class files to the root instead of modify manifest file
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
				// XXX not so good assumption that Bundle-ClassPath fits single line
				// If classpath spans few lines, we might not notice bin/ and
				// append it twice, with some bogus empty entries in between, 
				// which may lead to smth like 
				// java.lang.IllegalArgumentException: Path must include project and resource name: /org.sample.prim.diagram
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
	 * at least 1.4
	 */
	@SuppressWarnings("restriction")
	private static void ensureJava14() {
		String actual = JavaCore.getOption(JavaCore.COMPILER_SOURCE);
		long comparableValue = CompilerOptions.versionToJdkLevel(actual);
		if (comparableValue < CompilerOptions.versionToJdkLevel(JavaCore.VERSION_1_4)) {
			@SuppressWarnings("unchecked")
			Hashtable<String, String> options = JavaCore.getOptions();
			JavaCore.setComplianceOptions(JavaCore.VERSION_1_4, options);
			JavaCore.setOptions(options);
		}
	}

	/**
	 * No need to track history for workspace resources
	 */
	private static void turnWorkspaceHistoryOff(IWorkspaceDescription wd) {
		wd.setFileStateLongevity(0);
		wd.setMaxFileStates(0);
		wd.setMaxFileStateSize(0);
		wd.setSnapshotInterval(60 * 60 * 1000);
	}

	private static void switchAutobuildOff(IWorkspaceDescription wd) {
		wd.setAutoBuilding(false);
	}
}
