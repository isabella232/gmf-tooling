/*
 * Copyright (c) 2008, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.ant;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

class InputSupport {
	private String myInputURI;
	private Object myInputObject;
	private ResourceSet myResourceSet;
	private InputSupport myChain;
	
	public InputSupport(ResourceSet resourceSet) {
		myResourceSet = resourceSet;
	}

	public void setBareInput(String input) {
		myInputObject = input;
	}

	public void setURI(String uri) {
		myInputURI = uri;
	}

	protected ResourceSet getResourceSet() {
		if (myResourceSet == null) {
			myResourceSet = new ResourceSetImpl();
			myResourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
		}
		return myResourceSet;
	}

	public Object getTarget() {
		if (myInputURI != null) {
			return getResourceSet().getEObject(URI.createURI(myInputURI), true);
		}
		if (myInputObject != null) {
			return myInputObject;
		}
		if (myChain != null) {
			return myChain.getTarget();
		}
		return null;
	}

	public void chain(InputSupport input) {
		myChain = input;
	}

}
