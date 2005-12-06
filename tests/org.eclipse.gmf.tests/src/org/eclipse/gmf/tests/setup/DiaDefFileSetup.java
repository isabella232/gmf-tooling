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
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.Node;

public class DiaDefFileSetup implements DiaDefSource {

	private Canvas myCanvasDef;
	private Node myNodeDef;
	private Connection myLinkDef;

	public DiaDefFileSetup init(URI sourceURI) throws IOException {
		ResourceSet srcResSet = new ResourceSetImpl();
		Resource srcRes = srcResSet.getResource(sourceURI, true);
		myCanvasDef = (Canvas) srcRes.getContents().get(0);
		myNodeDef = (Node) myCanvasDef.getNodes().get(0);
		myLinkDef = (Connection) myCanvasDef.getConnections().get(0);
		return this;
	}

	public final Canvas getCanvasDef() {
		return myCanvasDef;
	}

	public final Connection getLinkDef() {
		return myLinkDef;
	}

	public final Node getNodeDef() {
		return myNodeDef;
	}
}
