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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.diadef.CommonBase;
import org.eclipse.gmf.diadef.RunTimeProperty;
import org.eclipse.gmf.diagramrt.DiagramRTPackage;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeMapping;

/**
 * Creates bare extended version of basic Diagram Run-Time model from gmfmap. 
 * This extended version is expected to be modified by toolsmith to capture additional
 * attributes/features of diagram.
 * @author artem
 */
public class DiagramRunTimeModelTransformer extends MappingTransofrmer {
	private final EPackage myPackage;

	public DiagramRunTimeModelTransformer(String modelName, String modelNsURI) {
		myPackage = EcoreFactory.eINSTANCE.createEPackage();
		myPackage.setName(modelName);
		myPackage.setNsPrefix(modelName+"-drt");
		myPackage.setNsURI(modelNsURI);
	}

	public EPackage getResult() {
		return myPackage;
	}

	protected void process(CanvasMapping cme) {
		addEClass(cme.getDiagramCanvas(), DiagramRTPackage.eINSTANCE.getDiagramCanvas());
	}

	protected void process(NodeMapping nme) {
		addEClass(nme.getDiagramNode(), DiagramRTPackage.eINSTANCE.getDiagramNode());
	}

	protected void process(LinkMapping lme) {
		addEClass(lme.getDiagramLink(), DiagramRTPackage.eINSTANCE.getDiagramLink());
	}

	private void addEClass(CommonBase diaDefElement, EClass superClass) {
		EClass c = createEClass(diaDefElement.getName(), superClass);
		myPackage.getEClassifiers().add(c);
		for (Iterator it = diaDefElement.getProperties().iterator(); it.hasNext();) {
			RunTimeProperty p = (RunTimeProperty) it.next();
			EAttribute a = EcoreFactory.eINSTANCE.createEAttribute();
			a.setName(p.getName());
			a.setEType(EcorePackage.eINSTANCE.getEString());
			c.getEAttributes().add(a);
		}
	}

	private EClass createEClass(String name, EClass superClass) {
		EClass c = EcoreFactory.eINSTANCE.createEClass();
		c.setName(name);
		c.getESuperTypes().add(superClass);
		return c;
	}
}
