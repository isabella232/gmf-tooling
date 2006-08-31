/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: dvorak - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.internal.common.migrate.ModelLoadHelper;
import org.eclipse.gmf.tests.Plugin;


public class ModelLoadHelperTest extends TestCase {

	public ModelLoadHelperTest(String name) {
		super(name);
	}

	
	public void testLoadSuccess() throws Exception {
		URI uri = Plugin.createURI("/models/links/links.ecore"); //$NON-NLS-1$
		ResourceSet rset = new ResourceSetImpl();
		ModelLoadHelper loadHelper = new ModelLoadHelper(rset, uri);
		assertTrue(loadHelper.getStatus().isOK());
		assertNotNull(loadHelper.getContentsRoot());
		assertNotNull(loadHelper.getLoadedResource());
		assertTrue(loadHelper.getLoadedResource().getErrors().isEmpty());
	}

	public void testLoadFailure() throws Exception {
		// load invalid model 
		URI uri = Plugin.createURI("/.classpath"); //$NON-NLS-1$
		ResourceSet rset = new ResourceSetImpl();
		ModelLoadHelper loadHelper = new ModelLoadHelper(rset, uri);
		assertFalse(loadHelper.getStatus().isOK());
		assertNull(loadHelper.getContentsRoot());
		assertNotNull(loadHelper.getLoadedResource());
		assertFalse(loadHelper.getLoadedResource().getErrors().isEmpty());
	}	
}
