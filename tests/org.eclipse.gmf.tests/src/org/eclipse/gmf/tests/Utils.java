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
 *    Mickael Istria (EBM Websourcing) - Support for target platform creation
 */
package org.eclipse.gmf.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.internal.bridge.genmodel.BasicGenModelAccess;
import org.eclipse.osgi.internal.framework.EquinoxBundle;
import org.eclipse.osgi.storage.BundleInfo.Generation;
import org.eclipse.pde.core.target.ITargetDefinition;
import org.eclipse.pde.core.target.ITargetLocation;
import org.eclipse.pde.core.target.ITargetPlatformService;
import org.eclipse.pde.core.target.LoadTargetDefinitionJob;
import org.eclipse.pde.internal.core.target.TargetPlatformService;
import org.eclipse.swt.widgets.Display;
import org.junit.Assert;
import org.osgi.framework.Bundle;

/**
 * @author artem
 * 
 */
public class Utils {

	/**
	 * FIXME use DummyGenModel instead of BasicGenModelAccess Create in-memory
	 * genmodel for provided (in-memory) domain model
	 * 
	 * @param aModel
	 *            source model
	 * @return initilized genModel, ready to run code generation
	 */
	public static GenModel createGenModel(EPackage aModel) {
		BasicGenModelAccess gmAccess = new BasicGenModelAccess(aModel);
		IStatus s = gmAccess.createDummy();
		assert s.isOK();
		GenModel genModel = gmAccess.model();
		// not sure I need these
		String pluginID = Utils.createUniquePluginID();
		genModel.setModelPluginID(pluginID);
		genModel.setModelDirectory("/" + pluginID + "/src/");
		genModel.setEditDirectory(genModel.getModelDirectory());
		return genModel;
	}

	public static GenClass findGenClass(GenModel genModel, String className) {
		for (TreeIterator<EObject> it = genModel.eAllContents(); it.hasNext();) {
			EObject next = it.next();
			if (next instanceof GenClassifier == false) {
				continue;
			}
			if (next instanceof GenClass) {
				GenClass rc = (GenClass) next;
				if (rc.getName().equals(className)) {
					return rc;
				}
			}
			it.prune();
		}
		return null;
	}

	/**
	 * Tests need class matching using names as it's not always ok to compare
	 * ecore classes as done in
	 * {@link org.eclipse.gmf.internal.bridge.genmodel.GenModelMatcher#findGenClass(EClass)}
	 */
	public static GenClass findGenClass(GenModel genModel, EClass domainClass) {
		return findGenClass(genModel, domainClass.getName());
	}

	public static String createUniquePluginID() {
		return String.format("sample.t%1$tH-%1$tM-%1$tS.%1$tL", Calendar.getInstance());
	}

	/**
	 * @return false if timeout broke the loop
	 */
	public static boolean dispatchDisplayMessages(boolean[] condition, int timeoutSeconds) {
		assert Display.getCurrent() != null;
		final long start = System.currentTimeMillis();
		final long deltaMillis = timeoutSeconds * 1000;
		do {
			while (Display.getCurrent().readAndDispatch()) {
				;
			}
		} while (condition[0] && (System.currentTimeMillis() - start) < deltaMillis);
		return !condition[0];
	}

	/**
	 * @return false if message re-dispatch was broken by timeout
	 */
	public static boolean dispatchDisplayMessages(int timeoutSeconds) {
		final long start = System.currentTimeMillis();
		final long deltaMillis = timeoutSeconds * 1000;
		while (Display.getCurrent().readAndDispatch()) {
			if ((System.currentTimeMillis() - start) > deltaMillis) {
				return false;
			}
		}
		return true;
	}

	public static void assertDispatchDisplayMessages(int timeoutSeconts) {
		boolean queueCleared = dispatchDisplayMessages(3);
		Assert.assertTrue("Display message redispatch was not expected to end by timeout", queueCleared);
	}

	public static void assertDispatchDisplayMessages(boolean[] condition, int timeoutSeconds) {
		boolean conditionSatisfied = Utils.dispatchDisplayMessages(condition, 10);
		Assert.assertTrue("Timeout while waiting for jobs to complete", conditionSatisfied);
	}

	/**
	 * Sets a target platform in the test platform to get workspace builds OK
	 * with PDE.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	public static void setTargetPlatform() throws Exception {
		ITargetPlatformService tpService = TargetPlatformService.getDefault();
		ITargetDefinition targetDef = tpService.newTarget();
		targetDef.setName("Tycho platform");
		Bundle[] bundles = Platform.getBundle("org.eclipse.core.runtime").getBundleContext().getBundles();
		List<ITargetLocation> bundleContainers = new ArrayList<ITargetLocation>();
		Set<File> dirs = new HashSet<File>();
		for (Bundle bundle : bundles) {
			EquinoxBundle bundleImpl = (EquinoxBundle) bundle;
			Generation generation = (Generation) bundleImpl.getModule().getCurrentRevision().getRevisionInfo();
			File file = generation.getBundleFile().getBaseFile();
			File folder = file.getParentFile();
			if (!dirs.contains(folder)) {
				dirs.add(folder);
				bundleContainers.add(tpService.newDirectoryLocation(folder.getAbsolutePath()));
			}
		}
		targetDef.setTargetLocations(bundleContainers.toArray(new ITargetLocation[bundleContainers.size()]));
		targetDef.setArch(Platform.getOSArch());
		targetDef.setOS(Platform.getOS());
		targetDef.setWS(Platform.getWS());
		targetDef.setNL(Platform.getNL());
		// targetDef.setJREContainer()
		tpService.saveTargetDefinition(targetDef);

		Job job = new LoadTargetDefinitionJob(targetDef);
		job.schedule();
		job.join();
	}
}
