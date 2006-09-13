/*
 * Copyright (c) 2005, 2006 Borland Software Corporation
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

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.FeatureModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;

/**
 * Use with caution - dumb element lookup code  
 * @author artem
 */
public class DiaGenFileSetup implements DiaGenSource {

	private GenDiagram myGenDiagram;
	private GenNode myNodeA;
	private GenNode myNodeB;
	private GenLink myLinkC;
	private GenLink myLinkD;

	public DiaGenFileSetup() {
	}

	public DiaGenFileSetup init(URI sourceURI) {
		ResourceSet srcResSet = new ResourceSetImpl();
 		Resource srcRes = srcResSet.getResource(sourceURI, true);
 		GenEditorGenerator editorGen = (GenEditorGenerator) srcRes.getContents().get(0);
 		myGenDiagram = editorGen.getDiagram();
 		// FIXME somehow select particular link - protected find()
 		for (Iterator it = myGenDiagram.getLinks().iterator(); it.hasNext();) {
 			GenLink next = (GenLink) it.next();
 			if (myLinkC == null && next.getModelFacet() instanceof TypeModelFacet) {
 				myLinkC = next;
 			}
 			if (myLinkD == null && next.getModelFacet() instanceof FeatureModelFacet) {
 				myLinkD = next;
 			}
 		}
 		// TODO decide from myLinkC modelFacet or even introduce source/target genNodes attrs in GenLink (!!!)
 		myNodeA = (GenNode) myGenDiagram.getTopLevelNodes().get(0);
 		myNodeB = (GenNode) myGenDiagram.getTopLevelNodes().get(1);
 		return this;
	}

	public final GenDiagram getGenDiagram() {
		return myGenDiagram;
	}
	
	public final GenNode getNodeA() {
		return myNodeA;
	}

	public final GenNode getNodeB() {
		return myNodeB;
	}

	public final GenLink getLinkC() {
		return myLinkC;
	}

	public final GenLink getLinkD() {
		return myLinkD;
	}
}
