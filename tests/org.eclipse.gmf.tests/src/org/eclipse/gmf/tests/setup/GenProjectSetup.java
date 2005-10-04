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

import junit.framework.AssertionFailedError;

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
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PDEState;
import org.eclipse.pde.internal.ui.wizards.imports.PluginImportOperation;
import org.osgi.framework.Bundle;

/**
 * @author artem
 */
public class GenProjectSetup {

	private Bundle myBundle;

	public GenProjectSetup() {
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public GenProjectSetup init(DiaGenSource diaGenSource) throws Exception {
		if (!JavaCore.VERSION_1_4.equals(JavaCore.getOption(JavaCore.COMPILER_SOURCE))) {
			Hashtable options = JavaCore.getOptions();
			options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_4);
			options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_4);
			options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_4);
			JavaCore.setOptions(options);
		}
		if (PDECore.isDevLaunchMode()) {
			// Need to get some gmf source code into target workspace 
			importDevPluginsIntoRunTimeWorkspace(new String[] {
					"org.eclipse.gmf.runtime",
					"org.eclipse.gmf.edit",
					"org.eclipse.gmf.runtime.gef",
			});
		}
		final GenDiagram d = diaGenSource.getGenDiagram();
		final LinkedHashSet projectsToInit = new LinkedHashSet();
		d.getEMFGenModel().setCanGenerate(true);
		d.getEMFGenModel().generate(new NullProgressMonitor());
		projectsToInit.add(d.getEMFGenModel().getModelPluginID());
		d.getEMFGenModel().generateEdit(new NullProgressMonitor());
		projectsToInit.add(d.getEMFGenModel().getEditPluginID());
		new Generator(d).run();
		projectsToInit.add(d.getPluginID());
		Bundle b = null;
		for (Iterator it = projectsToInit.iterator(); it.hasNext();) {
			String pluginID = (String) it.next();
			IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginID);
			p.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
			IMarker[] compileErrors = getJavaErrors(p);
			if (compileErrors.length > 0) {
				StringBuilder sb = new StringBuilder();
				sb.append(p.getName()).append(" has compilation problems:\n");
				throw new AssertionFailedError(formatErrors(sb, compileErrors));
			}
			String url = p.getLocation().toFile().toURL().toExternalForm();
			b = Plugin.getBundleContext().installBundle(url);
		}
		myBundle = b;
		myBundle.start();
		return this;
	}

	public final Bundle getBundle() {
		return myBundle;
	}

	private void importDevPluginsIntoRunTimeWorkspace(String[] pluginIDs) throws CoreException {
		PDEState pdeState = new PDEState(getDevPluginsLocations(pluginIDs), false, new NullProgressMonitor());
		PluginImportOperation.IReplaceQuery query = new PluginImportOperation.IReplaceQuery() {
			public int doQuery(IProject arg0) {
				return YES;
			}
		};
		PluginImportOperation op = new PluginImportOperation(pdeState.getModels(), PluginImportOperation.IMPORT_WITH_SOURCE, query, true);
		ResourcesPlugin.getWorkspace().run(op, new NullProgressMonitor());
		for (int i = 0; i < pluginIDs.length; i++) {
			IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginIDs[i]);
			p.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
			IMarker[] compileErrors = getJavaErrors(p);
			if (compileErrors.length > 0) {
				throw new AssertionFailedError(formatErrors(new StringBuilder("UNEXPECTED: Compilation errors in imported devplugins:\n"), compileErrors));
			}
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

	private IMarker[] collectJavaMarkers(IProject p) throws CoreException {
		return p.findMarkers(IJavaModelMarker.JAVA_MODEL_PROBLEM_MARKER, true, IResource.DEPTH_INFINITE);
	}

	private IMarker[] getJavaErrors(IProject p) throws CoreException {
		return filterSevereMarkers(collectJavaMarkers(p));
	}

	private IMarker[] filterSevereMarkers(IMarker[] problems) throws CoreException {
		ArrayList rv = new ArrayList(problems.length);
		for (int i = 0; i < problems.length; i++) {
			if (IMarker.SEVERITY_ERROR == ((Integer) problems[i].getAttribute(IMarker.SEVERITY)).intValue()) {
				rv.add(problems[i]);
			}
		}
		return (IMarker[]) rv.toArray(new IMarker[rv.size()]);
	}

	private String formatErrors(StringBuilder sb, IMarker[] compileErrors) {
		for (int i = 0; i < compileErrors.length; i++) {
			try {
				sb.append(compileErrors[i].getAttribute(IMarker.MESSAGE));
			} catch (CoreException ex) {
				sb.append("--ex:");
				sb.append(ex.getMessage());
			}
			sb.append(",\n");
		}
		return sb.toString();
	}
}
