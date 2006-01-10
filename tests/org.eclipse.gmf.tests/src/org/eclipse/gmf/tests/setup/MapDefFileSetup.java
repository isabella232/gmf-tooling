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
import java.util.Iterator;

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
	private LinkMapping myClassLink;
	private LinkMapping myRefLink;

	public MapDefFileSetup init(URI sourceURI) throws IOException {
		ResourceSet srcResSet = new ResourceSetImpl();
		Resource srcRes = srcResSet.getResource(sourceURI, true);
		myMap = (Mapping) srcRes.getContents().get(0);
		for (Iterator it = getMapping().getLinks().iterator(); it.hasNext();) {
			LinkMapping next = (LinkMapping) it.next();
			if (myClassLink == null && next.getDomainMetaElement() != null) {
				myClassLink = next;
			}
			if (myRefLink == null && next.getDomainMetaElement() == null) {
				myRefLink = next;
			}
		}
		return this;
	}

	public final Mapping getMapping() {
		return myMap;
	}

	public final CanvasMapping getCanvas() {
		return getMapping().getDiagram();
	}

	public NodeMapping getNodeA() {
		return (NodeMapping) getMapping().getNodes().get(0);
	}

	public NodeMapping getNodeB() {
		return (NodeMapping) getMapping().getNodes().get(1);
	}

	public LinkMapping getClassLink() {
		return myClassLink;
	}

	public LinkMapping getReferenceLink() {
		return myRefLink;
	}
}
