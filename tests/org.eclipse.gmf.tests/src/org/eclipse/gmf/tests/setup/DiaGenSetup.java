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
import org.eclipse.gmf.bridge.genmodel.GenModelMatcher;
import org.eclipse.gmf.bridge.genmodel.NamingStrategy;
import org.eclipse.gmf.bridge.genmodel.NotationViewFactoryNamingStrategy;
import org.eclipse.gmf.bridge.genmodel.RuntimeGenModelAccess;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.tests.Utils;

/**
 * TODO another DiaGenSetup using DiagramGenModelTransformer 
 * to avoid errors in GMFGen initialization (like missed viewmaps)
 * @author artem
 */
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
		final GenModel runtimeModel = getRuntimeGenModel();
		final String pluginID = Utils.createUniquePluginID();
		assert runtimeModel != null;
		final GenModelMatcher gmm = new GenModelMatcher(Utils.createGenModel(domainSource.getModel(), pluginID));
		myGenDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		myGenDiagram.setDomainDiagramElement(gmm.findGenClass(domainSource.getDiagramElement()));
		myGenDiagram.setDomainMetaModel(gmm.findGenPackage(domainSource.getModel()));
		myGenDiagram.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, NotationPackage.eINSTANCE.getDiagram()));
		myGenDiagram.setPalette(createPalette());
		myGenDiagram.setVisualID(99);

		myGenNode = GMFGenFactory.eINSTANCE.createGenNode();
		myGenNode.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, NotationPackage.eINSTANCE.getNode()));
		myGenNode.setDomainMetaClass(gmm.findGenClass(domainSource.getNode().getEClass()));
		myGenNode.setDomainNameFeature(gmm.findGenFeature(domainSource.getNode().getNameAttr()));
		myGenNode.setContainmentMetaFeature(gmm.findGenFeature(domainSource.getNode().getContainment()));
		myGenNode.setViewmap(GMFGenFactory.eINSTANCE.createBasicNodeViewmap());
		myGenNode.setVisualID(100);

		myGenLink = GMFGenFactory.eINSTANCE.createGenLinkWithClass();
		myGenLink.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, NotationPackage.eINSTANCE.getEdge()));
		myGenLink.setDomainMetaClass(gmm.findGenClass(domainSource.getLinkAsClass().getEClass()));
		myGenLink.setDomainLinkTargetFeature(gmm.findGenFeature(domainSource.getLinkAsClass().getTargetFeature()));
		myGenLink.setContainmentMetaFeature(gmm.findGenFeature(domainSource.getLinkAsClass().getContainment()));
		myGenLink.setViewmap(GMFGenFactory.eINSTANCE.createDecoratedConnectionViewmap());
		myGenLink.setVisualID(200);
		// TODO add linkRefOnly
		myGenDiagram.getNodes().add(myGenNode);
		myGenDiagram.getLinks().add(myGenLink);
		// TODO make sure (validate?) .gmfgen model is valid not to ruin tests...
		// XXX alternatively, run this check as separate tests prior to those using this setup?
		return this;
	}

	private GenModel getRuntimeGenModel() {
		RuntimeGenModelAccess runtimeAccess = new RuntimeGenModelAccess();
		runtimeAccess.ensure();
		return runtimeAccess.model();
	}

	public void init(MapDefSource mapSource) {
		final DiagramRunTimeModelHelper drth = new BasicDiagramRunTimeModelHelper();
		final NamingStrategy epns = new EditPartNamingStrategy();
		DiagramGenModelTransformer t = new DiagramGenModelTransformer(drth, epns, new NotationViewFactoryNamingStrategy());
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
