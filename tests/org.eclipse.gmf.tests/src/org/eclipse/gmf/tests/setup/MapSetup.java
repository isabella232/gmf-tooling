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

import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.ToolGroup;
import org.eclipse.gmf.tests.setup.DomainModelSetup;

public class MapSetup implements MapDefSource {

	private Mapping myMap;

	public MapSetup() {
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public MapSetup init(DiaDefSetup ddSource, DomainModelSetup domainSource) {
		Mapping m = GMFMapFactory.eINSTANCE.createMapping();
		final ToolGroup toolGroup = GMFMapFactory.eINSTANCE.createToolGroup();
		toolGroup.setName("tg1");
		m.getToolGroups().add(toolGroup);
		CanvasMapping cme = GMFMapFactory.eINSTANCE.createCanvasMapping();
		cme.setDiagramCanvas(ddSource.getCanvasDef());
		cme.setDomainMetaElement(domainSource.getDiagramElement());
		cme.setDomainModel(domainSource.getModel());
		setupCanvasMapping(cme);

		NodeMapping nme = GMFMapFactory.eINSTANCE.createNodeMapping();
		nme.setDiagramNode(ddSource.getNodeDef());
		nme.setDomainMetaElement(domainSource.getNode().getEClass());
		nme.setEditFeature(domainSource.getNode().getNameAttr());
		nme.setContainmentFeature(domainSource.getNode().getContainment());
		nme.setTool(GMFMapFactory.eINSTANCE.createCreationTool());
		nme.getTool().setGroup(toolGroup);
		setupNodeMapping(nme);

		LinkMapping lme = GMFMapFactory.eINSTANCE.createLinkMapping();
		lme.setDiagramLink(ddSource.getLinkDef());
		lme.setDomainMetaElement(domainSource.getLinkAsClass().getEClass());
		lme.setLinkMetaFeature(domainSource.getLinkAsClass().getTargetFeature());
		lme.setContainmentFeature(domainSource.getLinkAsClass().getContainment());
		lme.setTool(GMFMapFactory.eINSTANCE.createCreationTool());
		lme.getTool().setGroup(toolGroup);
		setupLinkMapping(lme);

		m.setDiagram(cme);
		m.getNodes().add(nme);
		m.getLinks().add(lme);
		myMap = m;
		return this;
	}

	protected void setupCanvasMapping(CanvasMapping cme) {
	}

	protected void setupNodeMapping(NodeMapping nme) {
	}

	protected void setupLinkMapping(LinkMapping lme) {
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
