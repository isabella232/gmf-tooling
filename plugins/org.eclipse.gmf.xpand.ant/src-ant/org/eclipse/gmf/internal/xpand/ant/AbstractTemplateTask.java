/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.ant;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.internal.xpand.EPackageRegistryBasedURIResourceMap;

public abstract class AbstractTemplateTask extends Task {

	private final InputSupport myInput;

	private final ResourceSetImpl myResourceSet;

	private String[] myTemplateRoots;

	private Collection<Metamodel> myMetamodels = new ArrayList<Metamodel>();

	public AbstractTemplateTask() {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.setURIResourceMap(new EPackageRegistryBasedURIResourceMap(resourceSet.getURIConverter()));
		myResourceSet = resourceSet;
		myInput = new InputSupport(myResourceSet);
	}

	public void setTemplateRoot(String root) {
		ArrayList<String> roots = new ArrayList<String>();
		for (StringTokenizer st = new StringTokenizer(root, ";, "); st.hasMoreTokens();) {
			roots.add(st.nextToken().trim());
		}
		myTemplateRoots = roots.toArray(new String[roots.size()]);
	}

	protected String[] getTemplateRoots() {
		return myTemplateRoots;
	}

	public void setInputURI(String uri) {
		myInput.setURI(uri);
	}

	public void setBareInput(String input) {
		myInput.setBareInput(input);
	}

	protected InputSupport getInput() {
		return myInput;
	}

	public void addMetamodel(Metamodel metamodel) {
		myMetamodels.add(metamodel);
	}

	protected XpandFacade createFacade() throws BuildException {
		XpandFacade xf = new XpandFacade(myResourceSet);
		if (myTemplateRoots != null && myTemplateRoots.length > 0) {
			try {
				for (String r : myTemplateRoots) {
					xf.addLocation(r);
				}
			} catch (MalformedURLException ex) {
				throw new BuildException(ex, getLocation());
			}
		}
		return registerMetamodels(xf);
	}

	private XpandFacade registerMetamodels(XpandFacade xf) {
		for (Metamodel metamodel : myMetamodels) {
			xf.registerMetamodel(metamodel.getNsUri(), metamodel.getLocation());
		}
		return xf;
	}

}
