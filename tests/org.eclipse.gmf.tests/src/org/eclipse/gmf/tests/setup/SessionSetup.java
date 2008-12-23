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
package org.eclipse.gmf.tests.setup;

import org.eclipse.gmf.tests.TestConfiguration;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * @author artem
 */
public class SessionSetup implements TestConfiguration {

	private DomainModelSource myDomainModel;
	private DiaGenSource myGenModel;
	private GenProjectSetup myProject;
	private MapDefSource myMapModel;
	private DiaDefSource myGraphDefModel;
	private ToolDefSource myToolDefModel;
	private int myUses;
	protected static boolean factoryClosed = false;
	private final GeneratorConfiguration myGeneratorConfig;

	/**
	 * Use factory method {@link #newInstance()} instead
	 * @param generatorConfig 
	 */
	protected SessionSetup(GeneratorConfiguration generatorConfig) {
		assert generatorConfig != null;
		myGeneratorConfig = generatorConfig;
	}

	/**
	 * When running as an all-tests suite, we won't li
	 */
	public static void disallowSingleTestCaseUse() {
		factoryClosed = true;
	}

	/**
	 * @return <code>null</code> if {@link #disallowSingleTestCaseUse()} was called
	 */
	public static SessionSetup newInstance() {
		if (factoryClosed) {
			return null;
		}
		return new SessionSetup(new RuntimeBasedGeneratorConfiguration());
	}

	public DomainModelSource getDomainModel() {
		if (myDomainModel == null) {
			myDomainModel = createDomainModel();
		}
		return myDomainModel;
	}

	protected DomainModelSource createDomainModel() {
		return new DomainModelSetup().init();
	}

	public DiaGenSource getGenModel() {
		if (myGenModel == null) {
			myGenModel = createGenModel();
		}
		return myGenModel;
	}

	protected DiaGenSource createGenModel() {
		return new DiaGenSetup().init(getMapModel());
	}

	protected GenProjectSetup getGenProject() throws Exception {
		if (myProject == null) {
			myProject = createGenProject();
		}
		return myProject;
	}

	protected GenProjectSetup createGenProject() throws BundleException {
		return new GenProjectSetup(getGeneratorConfiguration()).init(getGenModel());
	}

	public GeneratorConfiguration getGeneratorConfiguration() {
		return myGeneratorConfig;
	}

	public MapDefSource getMapModel() {
		if (myMapModel == null) {
			myMapModel = createMapModel();
		}
		return myMapModel;
	}

	protected MapDefSource createMapModel() {
		return new MapSetup().init(getGraphDefModel(), getDomainModel(), getToolDefModel());
	}

	public DiaDefSource getGraphDefModel() {
		if (myGraphDefModel == null) {
			myGraphDefModel = createGraphDefModel();
		}
		return myGraphDefModel;
	}

	protected DiaDefSource createGraphDefModel() {
		return new DiaDefSetup().init();
	}

	public ToolDefSource getToolDefModel() {
		if (myToolDefModel == null) {
			myToolDefModel = createToolDefModel();
		}
		return myToolDefModel;
	}

	protected ToolDefSource createToolDefModel() {
		return new ToolDefSetup();
	}

	public void cleanup() throws Exception {
		System.err.println(getClass().getName() + ":uses:" + myUses);
		if (myProject != null) {
			myProject.uninstall();
		}
	}

	public final Class<?> loadGeneratedClass(String qualifiedClassName) throws Exception {
		// move to GenProjectSetup?
		return getGeneratedPlugin().loadClass(qualifiedClassName);
	}

	public final Bundle getGeneratedPlugin() throws Exception {
		return getGenProject().getBundle();
	}

	// FUTURE: automatically unload/cleanup when myUses goes to zero.
	public void oneUp() {
		myUses++;
	}

	public void oneDown() {
		myUses--;
	}	
}
