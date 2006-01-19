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

import junit.framework.Assert;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.gmf.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.BasicGenModelAccess;
import org.eclipse.gmf.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.GenModelMatcher;
import org.eclipse.gmf.bridge.genmodel.RuntimeGenModelAccess;
import org.eclipse.gmf.codegen.gmfgen.FeatureModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.internal.bridge.naming.CollectingDispenser;
import org.eclipse.gmf.internal.bridge.naming.NamingStrategy;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediatorImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.tests.Utils;

/**
 * @author artem
 */
public class DiaGenSetup implements DiaGenSource {
	private GenDiagram myGenDiagram;
	private GenNode myNodeA;
	private GenLink myLinkC;
	private GenLink myLinkD;
	private GenNode myNodeB;

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
		myGenDiagram.setViewmap(createDiagramViewmap());
		myGenDiagram.setVisualID(99);

		myNodeA = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		myNodeA.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, NotationPackage.eINSTANCE.getNode()));
		myNodeA.setModelFacet(createNodeModelFacet(gmm, domainSource.getNodeA()));
		EAttribute editFeature = domainSource.getNodeA().getNameAttr();
		if (editFeature != null) {
			FeatureModelFacet modelFacet = GMFGenFactory.eINSTANCE.createFeatureModelFacet();
			modelFacet.setMetaFeature(gmm.findGenFeature(editFeature));
			GenNodeLabel label = GMFGenFactory.eINSTANCE.createGenNodeLabel();
			label.setModelFacet(modelFacet);
			label.setVisualID(401);
			myNodeA.getLabels().add(label);
		}
		myNodeA.setViewmap(createNodeViewmap());
		myNodeA.setVisualID(100);

		myLinkC = GMFGenFactory.eINSTANCE.createGenLink();
		myLinkC.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, NotationPackage.eINSTANCE.getEdge()));
		myLinkC.setModelFacet(createLinkModelFacet(gmm, domainSource.getLinkAsClass()));
		myLinkC.setViewmap(createLinkViewmap());
		myLinkC.setVisualID(200);
		// TODO add linkRefOnly
		myGenDiagram.getTopLevelNodes().add(myNodeA);
		myGenDiagram.getLinks().add(myLinkC);
		confineInResource();
		return this;
	}

	private Viewmap createLinkViewmap() {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx");
		return v;
	}

	private Viewmap createNodeViewmap() {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.draw2d.RoundedRectangle");
		return v;
	}

	private Viewmap createDiagramViewmap() {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.draw2d.FreeformLayer");
		return v;
	}

	private TypeModelFacet createNodeModelFacet(GenModelMatcher gmm, DomainModelSetup.NodeData node) {
		TypeModelFacet mf = GMFGenFactory.eINSTANCE.createTypeModelFacet();
		mf.setMetaClass(gmm.findGenClass(node.getEClass()));
		mf.setContainmentMetaFeature(gmm.findGenFeature(node.getContainment()));
		mf.setChildMetaFeature(mf.getContainmentMetaFeature());
		return mf;
	}

	private TypeLinkModelFacet createLinkModelFacet(final GenModelMatcher gmm, DomainModelSetup.LinkData link) {
		TypeLinkModelFacet mf = GMFGenFactory.eINSTANCE.createTypeLinkModelFacet();
		mf.setMetaClass(gmm.findGenClass(link.getEClass()));
		mf.setContainmentMetaFeature(gmm.findGenFeature(link.getContainment()));
		mf.setChildMetaFeature(mf.getContainmentMetaFeature());
		mf.setTargetMetaFeature(gmm.findGenFeature(link.getTargetFeature()));
		return mf;
	}

	private GenModel getRuntimeGenModel() {
		RuntimeGenModelAccess runtimeAccess = new RuntimeGenModelAccess();
		runtimeAccess.ensure();
		return runtimeAccess.model();
	}

	public DiaGenSetup init(MapDefSource mapSource) {
		final DiagramRunTimeModelHelper drth = new BasicDiagramRunTimeModelHelper();
		final CollectingDispenser uniquenessDispenser = new CollectingDispenser();
		final GenModelNamingMediatorImpl namingMediator = new GenModelNamingMediatorImpl(uniquenessDispenser);
		DiagramGenModelTransformer t = new DiagramGenModelTransformer(drth, namingMediator);
		BasicGenModelAccess gma = new BasicGenModelAccess(mapSource.getCanvas().getDomainModel());
		IStatus gmaStatus = gma.createDummy();
		Assert.assertTrue("Need (fake) genModel for transformation to work", gmaStatus.isOK());
		t.setEMFGenModel(gma.model());
		t.transform(mapSource.getMapping());
		myGenDiagram = t.getResult();
		uniquenessDispenser.forget();
		NamingStrategy epns = namingMediator.getEditPart();
		final String aNodeEPName = epns.get(mapSource.getNodeA());
		final String bNodeEPName = mapSource.getNodeB() == null ? null : epns.get(mapSource.getNodeB());
		final String cLinkEPName = epns.get(mapSource.getClassLink());
		final String dLinkEPName = epns.get(mapSource.getReferenceLink());
		for (Iterator it = myGenDiagram.getTopLevelNodes().iterator(); it.hasNext();) {
			GenNode n = (GenNode) it.next();
			if (n.getEditPartClassName().equals(aNodeEPName)) {
				myNodeA = n;
			}
			if (n.getEditPartClassName().equals(bNodeEPName)) {
				myNodeB = n;
			}
		}
		for (Iterator it = myGenDiagram.getLinks().iterator(); it.hasNext();) {
			GenLink l = (GenLink) it.next();
			if (l.getEditPartClassName().equals(cLinkEPName)) {
				myLinkC = l;
			}
			if (l.getEditPartClassName().equals(dLinkEPName)) {
				myLinkD = l;
			}
		}
		assert myNodeA != null;
		assert myLinkC != null;
		assert myLinkD != null;
		confineInResource();
		return this;
	}

	private void confineInResource() {
		new ResourceImpl(URI.createURI("uri://org.eclipse.gmf/tests/DiaGenSetup")).getContents().add(myGenDiagram);
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

	public GenLink getLinkD() {
		return myLinkD;
	}

	// Empty palette, unless we'd like to test it
	private Palette createPalette() {
		return null;
//		Palette rv = GMFGenFactory.eINSTANCE.createPalette();
//		ToolGroup tg = GMFGenFactory.eINSTANCE.createToolGroup();
//		tg.setTitleKey("fake-group");
//		tg.setCreateMethodName("createFakeGroup");
//		rv.getGroups().add(tg); // to satisfy [+] restriction
//		return rv;
	}
}
