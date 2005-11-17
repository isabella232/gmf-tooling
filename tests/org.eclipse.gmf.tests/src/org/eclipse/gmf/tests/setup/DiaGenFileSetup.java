/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	  Karen Shaglamdjan (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;

/**
 * TODO another DiaGenSetup using DiagramGenModelTransformer 
 * to avoid errors in GMFGen initialization (like missed viewmaps)
 * @author artem
 */
class DiaGenFileSetup implements DiaGenSource {

	private GenDiagram myGenDiagram;
	private GenNode myGenNode;
	private GenLink myGenLink;

	public DiaGenFileSetup() {
	}

	public DiaGenFileSetup init(URI sourceURI) {
		ResourceSet srcResSet = new ResourceSetImpl();
 		Resource srcRes = srcResSet.getResource(sourceURI, true);
 		myGenDiagram = (GenDiagram) srcRes.getContents().get(0);
		return this;
	}

	public final GenDiagram getGenDiagram() {
		return myGenDiagram;
	}
	
	public final GenNode getGenNode() {
		return myGenNode;
	}

	public final GenLink getGenLink() {
		return myGenLink;
	}
}
