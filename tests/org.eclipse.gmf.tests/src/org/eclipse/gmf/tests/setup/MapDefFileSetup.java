/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Karen Shaglamdjan (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;

public class MapDefFileSetup implements MapDefSource {

	private Mapping myMap;

	public MapDefFileSetup init(URI sourceURI) throws IOException {
		ResourceSet srcResSet = new ResourceSetImpl();
		Resource srcRes = srcResSet.getResource(sourceURI, true);
		myMap = (Mapping) srcRes.getContents().get(0);
		return this;
	}

	public final Mapping getMapping() {
		return myMap;
	}

	public final CanvasMapping getCanvasMapping() {
		return getMapping().getDiagram();
	}

	public NodeMapping getNodeMapping() {
		return (NodeMapping) getMapping().getNodes().get(0);
	}

	public LinkMapping getLinkMapping() {
		return (LinkMapping) getMapping().getLinks().get(0);
	}
}
