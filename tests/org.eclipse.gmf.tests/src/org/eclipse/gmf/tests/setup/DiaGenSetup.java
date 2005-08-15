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
package org.eclipse.gmf.tests.setup;

import java.util.Iterator;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.gmf.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.EditPartNamingStrategy;
import org.eclipse.gmf.bridge.genmodel.MetaInfoProviderNamingStrategy;
import org.eclipse.gmf.bridge.genmodel.NamingStrategy;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.diagramrt.DiagramRTPackage;
import org.eclipse.gmf.tests.Utils;

public class DiaGenSetup implements DiaGenSource {
	private GenDiagram myGenDiagram;
	private GenNode myGenNode;
	private GenLinkWithClass myGenLink;

	public DiaGenSetup() {
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public DiaGenSetup init(DomainModelSource domainSource) {
		final GenModel runtimeModel = Utils.loadGenModel(DiagramRTPackage.eNS_URI);
		final String pluginID = Utils.createUniquePluginID();
		assert runtimeModel != null;
		myGenDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		myGenDiagram.setDomainDiagramElement(domainSource.getDiagramElement());
		myGenDiagram.setDomainMetaModel(domainSource.getModel());
		myGenDiagram.setEmfGenModel(Utils.createGenModel(domainSource.getModel(), pluginID));
		myGenDiagram.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, DiagramRTPackage.eINSTANCE.getDiagramCanvas()));
		myGenDiagram.setPalette(createPalette());
		myGenDiagram.setVisualID(99);

		myGenNode = GMFGenFactory.eINSTANCE.createGenNode();
		myGenNode.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, DiagramRTPackage.eINSTANCE.getDiagramNode()));
		myGenNode.setDomainMetaClass(domainSource.getNode().getEClass());
		myGenNode.setDomainNameFeature(domainSource.getNode().getNameAttr());
		myGenNode.setContainmentMetaFeature(domainSource.getNode().getContainment());
		myGenNode.setVisualID(100);

		myGenLink = GMFGenFactory.eINSTANCE.createGenLinkWithClass();
		myGenLink.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, DiagramRTPackage.eINSTANCE.getDiagramLink()));
		myGenLink.setDomainMetaClass(domainSource.getLinkAsClass().getEClass());
		myGenLink.setDomainLinkTargetFeature(domainSource.getLinkAsClass().getTargetFeature());
		myGenLink.setContainmentMetaFeature(domainSource.getLinkAsClass().getContainment());
		myGenLink.setVisualID(200);
		// TODO add linkRefOnly
		myGenDiagram.getNodes().add(myGenNode);
		myGenDiagram.getLinks().add(myGenLink);
		return this;
	}

	public void init(MapDefSource mapSource) {
		final DiagramRunTimeModelHelper drth = new BasicDiagramRunTimeModelHelper();
		final NamingStrategy epns = new EditPartNamingStrategy();
		final NamingStrategy mipns = new MetaInfoProviderNamingStrategy();
		DiagramGenModelTransformer t = new DiagramGenModelTransformer(drth, epns, mipns);
		t.transform(mapSource.getMapping());
		myGenDiagram = t.getResult();
		final String nodeEPName = epns.createClassName(mapSource.getNodeMapping());
		final String linkEPName = epns.createClassName(mapSource.getLinkMapping());
		for (Iterator it = myGenDiagram.getNodes().iterator(); it.hasNext();) {
			GenNode n = (GenNode) it.next();
			if (n.getEditPartClassName().equals(nodeEPName)) {
				myGenNode = n;
				break;
			}
		}
		for (Iterator it = myGenDiagram.getLinks().iterator(); it.hasNext();) {
			GenLink l = (GenLink) it.next();
			if (l.getEditPartClassName().equals(linkEPName) && l instanceof GenLinkWithClass) {
				myGenLink = (GenLinkWithClass) l;
				break;
			}
		}
		assert myGenNode != null;
		assert myGenLink != null;
	}

	public final GenDiagram getGenDiagram() {
		return myGenDiagram;
	}
	public final GenNode getGenNode() {
		return myGenNode;
	}

	public final GenLinkWithClass getGenLink() {
		return myGenLink;
	}

	// Empty palette, unless we'd like to test it
	private Palette createPalette() {
		return GMFGenFactory.eINSTANCE.createPalette();
	}
}
