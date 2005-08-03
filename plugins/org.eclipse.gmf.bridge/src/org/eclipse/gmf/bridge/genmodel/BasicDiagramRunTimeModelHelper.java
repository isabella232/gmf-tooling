/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.bridge.genmodel;

import java.util.Iterator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.diagramrt.DiagramRTPackage;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeMapping;

/**
 * Makes use of basic/standard classes for runtime presentation of diagram 
 * @author artem
 */
public class BasicDiagramRunTimeModelHelper implements DiagramRunTimeModelHelper {
	private static final String DIAGRAM_RT_URI = "http://www.eclipse.org/gmf/2005/diagramrt";
	private GenClass myNode;
	private GenClass myLink;
	private GenClass myCanvas;
	private GenClass myChildNode;
	private boolean myIsLoaded = false;

	public BasicDiagramRunTimeModelHelper() {
	}

	public GenClass get(NodeMapping nodeMapping) {
		loadGenModel();
		return myNode;
	}

	public GenClass get(LinkMapping linkMapping) {
		loadGenModel();
		return myLink;
	}

	public GenClass get(CanvasMapping canvasMapping) {
		loadGenModel();
		return myCanvas;
	}

	public GenClass get(ChildNodeMapping childNodeMapping) {
		loadGenModel();
		return myChildNode;
	}

	private void loadGenModel() {
		if (myIsLoaded ) {
			return;
		}
		myIsLoaded = true;
		URI diagramRTGenModelURI = (URI) EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(DIAGRAM_RT_URI);
		Resource r = new ResourceSetImpl().getResource(diagramRTGenModelURI, true);
		GenModel drtModel = (GenModel) r.getContents().get(0);
		GenPackage gp = drtModel.findGenPackage(DiagramRTPackage.eINSTANCE);
		for (Iterator it = gp.getGenClasses().iterator(); it.hasNext();) {
			GenClass next = (GenClass) it.next();
			if (DiagramRTPackage.eINSTANCE.getDiagramNode().getName().equals(next.getName())) {
				myNode = next;
			} else if (DiagramRTPackage.eINSTANCE.getDiagramLink().getName().equals(next.getName())) {
				myLink = next;
			} else if (DiagramRTPackage.eINSTANCE.getDiagramCanvas().getName().equals(next.getName())) {
				myCanvas = next;
			} else if (DiagramRTPackage.eINSTANCE.getChildNode().getName().equals(next.getName())) {
				myChildNode = next;
			}
		}
		r.unload();
		assert myNode != null && myLink != null && myCanvas != null;
	}
}
