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

import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.util.Generator;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.jdt.core.IJavaModelMarker;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.pde.internal.core.PDEState;
import org.eclipse.pde.internal.ui.wizards.imports.PluginImportOperation;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * TODO FIXME launching tests from build scripts doesn't require importing/compiling source projects  
 * @author artem
 */
public class GenProjectSetup {

	private Bundle myBundle;

	public GenProjectSetup() {
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public GenProjectSetup init(DiaGenSource diaGenSource) {
		if (!JavaCore.VERSION_1_4.equals(JavaCore.getOption(JavaCore.COMPILER_SOURCE))) {
			Hashtable options = JavaCore.getOptions();
			options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_4);
			options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_4);
			options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_4);
			JavaCore.setOptions(options);
		}
		importDevPluginsIntoRunTimeWorkspace(new String[] {
				"org.eclipse.gmf.runtime",
				"org.eclipse.gmf.edit",
				"org.eclipse.gmf.runtime.gef",
		});
		final GenDiagram d = diaGenSource.getGenDiagram();
		final LinkedHashSet projectsToInit = new LinkedHashSet();
		d.getEmfGenModel().setCanGenerate(true);
		d.getEmfGenModel().generate(new NullProgressMonitor());
		projectsToInit.add(d.getEmfGenModel().getModelPluginID());
		d.getEmfGenModel().generateEdit(new NullProgressMonitor());
		projectsToInit.add(d.getEmfGenModel().getEditPluginID());
		new Generator(d).run();
		projectsToInit.add(d.getPluginID());
		Bundle b = null;
		for (Iterator it = projectsToInit.iterator(); it.hasNext();) {
			try {
				String pluginID = (String) it.next();
				IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginID);
				p.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
				if (hasJavaErrors(p)) {
					System.err.println(p.getName() + " has compilation problems");
				}
				String url = p.getLocation().toFile().toURL().toExternalForm();
				b = Plugin.getBundleContext().installBundle(url);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		myBundle = b;
		try {
			myBundle.start();
		} catch (BundleException ex) {
			ex.printStackTrace();
		}
		return this;
	}

	private void importDevPluginsIntoRunTimeWorkspace(String[] pluginIDs) {
		PDEState pdeState = new PDEState(getDevPluginsLocations(pluginIDs), false, new NullProgressMonitor());
		PluginImportOperation.IReplaceQuery query = new PluginImportOperation.IReplaceQuery() {
			public int doQuery(IProject arg0) {
				return YES;
			}
		};
		PluginImportOperation op = new PluginImportOperation(pdeState.getModels(), PluginImportOperation.IMPORT_WITH_SOURCE, query, true);
		try {
			ResourcesPlugin.getWorkspace().run(op, new NullProgressMonitor());
			for (int i = 0; i < pluginIDs.length; i++) {
				IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginIDs[i]);
				p.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
				if (hasJavaErrors(p)) {
					System.err.println("UNEXPECTED: Compilation errors in devplugins");
				}
			}
		} catch (CoreException ex) {
			ex.printStackTrace();
		}
	}

	private URL[] getDevPluginsLocations(String[] pluginIDs) {
		ArrayList/*<URL>*/ urls = new ArrayList/*<URL>*/(pluginIDs.length); 
		for (int i = 0; i < pluginIDs.length; i++) {
			try {
				Bundle b = Platform.getBundle(pluginIDs[i]);
				urls.add(Platform.resolve(b.getEntry("/")));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return (URL[]) urls.toArray(new URL[urls.size()]);
	}

	public final Bundle getBundle() {
		return myBundle;
	}

	private IMarker[] collectJavaMarkers(IProject p) throws CoreException {
		return p.findMarkers(IJavaModelMarker.JAVA_MODEL_PROBLEM_MARKER, true, IResource.DEPTH_INFINITE);
	}

	private boolean hasJavaErrors(IProject p) {
		try {
			IMarker[] problems = collectJavaMarkers(p);
			boolean rv = false;
			for (int i = 0; i < problems.length; i++) {
				if (IMarker.SEVERITY_ERROR == ((Integer) problems[i].getAttribute(IMarker.SEVERITY)).intValue()) {
					rv = true;
					System.out.println(problems[i].getAttribute(IMarker.MESSAGE));
				}
			}
			return rv;
		} catch (CoreException ex) {
			ex.printStackTrace();
			return true;
		}
	}
}
