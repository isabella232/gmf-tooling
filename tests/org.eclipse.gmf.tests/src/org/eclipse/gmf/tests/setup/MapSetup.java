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

import java.util.Arrays;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.mappings.AuditContainer;
import org.eclipse.gmf.mappings.AuditRule;
import org.eclipse.gmf.mappings.Auditable;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.LinkConstraints;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.Severity;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.eclipse.gmf.tests.setup.DomainModelSource.LinkData;
import org.eclipse.gmf.tests.setup.DomainModelSource.NodeData;

public class MapSetup implements MapDefSource {

	private Mapping myMap;
	private NodeMapping myNodeA;
	private NodeMapping myNodeAChild;
	private CompartmentMapping myNodeACompartment;
	private NodeMapping myNodeB;
	private NodeMapping myNodeBChild;
	private CompartmentMapping myNodeBCompartment;
	private LinkMapping myClassLink;
	private LinkMapping myRefLink;
	
	public MapSetup() {
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public MapSetup init(DiaDefSource ddSource, DomainModelSource domainSource, ToolDefSource toolDef) {
		initCanvasMappping(domainSource.getModel(), ddSource.getCanvasDef(), domainSource.getDiagramElement());
		if (toolDef.getMainMenu() != null) {
			myMap.getDiagram().getMenuContributions().add(toolDef.getMainMenu());
		}
		myMap.getDiagram().setPalette(toolDef.getPalette());
		
		myNodeA = createNodeMapping(ddSource.getNodeDef(), ddSource.getLabelDef(), domainSource.getNodeA());
		myNodeA.setContextMenu(toolDef.getNodeContextMenu());
		myNodeA.setTool(toolDef.getNodeCreationTool());
		
		DiaDefSetup ddSetup = ddSource instanceof DiaDefSetup ? (DiaDefSetup) ddSource : null;
		DomainModelSetup dmSetup = domainSource instanceof DomainModelSetup ? (DomainModelSetup) domainSource : null;
		
		if (domainSource.getNodeB() != null) {
			Node graphNode = ddSetup != null ? ddSetup.getColoredNodeDef() : ddSource.getNodeDef();
			DiagramLabel graphLabel = ddSetup != null ? ddSetup.getDecoratedLabelDef() : ddSource.getLabelDef();
			myNodeB = createNodeMapping(graphNode, graphLabel, domainSource.getNodeB());
		}
		
		if (ddSetup != null && dmSetup != null) {
			ChildReference childReference = createChildNode(ddSetup.getNodeDef(), ddSetup.getLabelDef(), dmSetup.getChildOfA(), myNodeA);
			myNodeAChild = childReference.getOwnedChild();
			myNodeACompartment = createCompartment(ddSetup.getCompartmentA(), myNodeA, new ChildReference[] {childReference});	

			if (myNodeB != null) {
				childReference = createChildNode(ddSetup.getColoredNodeDef(), ddSetup.getDecoratedLabelDef(), dmSetup.getChildOfB(), myNodeB);
				myNodeBChild = childReference.getOwnedChild();
				myNodeBCompartment = createCompartment(ddSetup.getCompartmentB(), myNodeB, new ChildReference[] {childReference});
			}

		}
		
		myClassLink = createLinkMapping(ddSource.getLinkDef(), domainSource.getLinkAsClass());
		myClassLink.setTool(toolDef.getLinkCreationTool());
		if (domainSource.getLinkAsRef() != null) {
			myRefLink = createLinkMapping(ddSource.getLinkDef(), null, domainSource.getLinkAsRef(), null);
		}

		return this;
	}

	private CompartmentMapping createCompartment(Compartment diagramCompartment, NodeMapping parent, ChildReference[] childReferences) {
		CompartmentMapping compartmentMapping = GMFMapFactory.eINSTANCE.createCompartmentMapping();
		compartmentMapping.setCompartment(diagramCompartment);
		compartmentMapping.getChildren().addAll(Arrays.asList(childReferences));
		
		parent.getCompartments().add(compartmentMapping);
		return compartmentMapping;
	}

	private ChildReference createChildNode(Node diagramNode, DiagramLabel diagramLabel, NodeData domainNode, NodeMapping parent) {
		NodeMapping nodeMapping = createNodeMapping(diagramNode, domainNode.getEClass(), diagramLabel, domainNode.getNameAttr(), domainNode.getContainment(), false);
		ChildReference childReference = GMFMapFactory.eINSTANCE.createChildReference();
		childReference.setOwnedChild(nodeMapping);
		childReference.setChildrenFeature(domainNode.getContainment());
		childReference.setContainmentFeature(domainNode.getContainment());
		parent.getChildren().add(childReference);
		return childReference;
	}

	private void initCanvasMappping(EPackage domainModel, Canvas canvas, EClass diagramElement) {
		Mapping m = GMFMapFactory.eINSTANCE.createMapping();		
			
		CanvasMapping cme = GMFMapFactory.eINSTANCE.createCanvasMapping();
		cme.setDiagramCanvas(canvas);
		cme.setDomainMetaElement(diagramElement);
		cme.setDomainModel(domainModel);
		setupCanvasMapping(cme);
		m.setDiagram(cme);
		myMap = m;
	}
	
	protected final AuditRule createAudit(String id, String ruleBody, Auditable target, Severity severity, boolean isLiveMode) {
		AuditRule audit = GMFMapFactory.eINSTANCE.createAuditRule();
		audit.setId(id);
		// add quation marks to test xml escapes in plugin.xml
		audit.setName("Name of \"" + id + "\""); //$NON-NLS-1$ //$NON-NLS-2$
		audit.setMessage("Violation of \"" + id + "\""); //$NON-NLS-1$ //$NON-NLS-2$
		audit.setDescription("Description of \"" + id + "\""); //$NON-NLS-1$ //$NON-NLS-2$
		audit.setTarget(target);
		Constraint rule = GMFMapFactory.eINSTANCE.createConstraint();
		rule.setBody(ruleBody);
		audit.setRule(rule);
		
		audit.setSeverity(severity);
		audit.setUseInLiveMode(isLiveMode);
		return audit;
	}
	
	protected final AuditContainer createAuditContainer(String id) {
		AuditContainer container = GMFMapFactory.eINSTANCE.createAuditContainer();		
		container.setId(id);
		container.setName("Name of \"" + id + "\""); //$NON-NLS-1$ //$NON-NLS-2$
		container.setDescription("Description of \"" + id + "\""); //$NON-NLS-1$ //$NON-NLS-2$
		return container;
	}

	private LinkMapping createLinkMapping(Connection link, LinkData data) {
		return createLinkMapping(link, data.getEClass(), data.getTargetFeature(), data.getContainment());
	}

	private LinkMapping createLinkMapping(Connection link, EClass domainMetaElement, EStructuralFeature linkMetafeature, EReference containmentFeature) {		
		LinkMapping lme = GMFMapFactory.eINSTANCE.createLinkMapping();
		lme.setDiagramLink(link);
		lme.setDomainMetaElement(domainMetaElement);
		lme.setLinkMetaFeature(linkMetafeature);
		lme.setContainmentFeature(containmentFeature);
		// FIXME lme.setTool(GMFMapFactory.eINSTANCE.createCreationTool());
		if (domainMetaElement == null) {
			setupReferenceLinkMapping(lme);
		} else {
			setupClassLinkMapping(lme);
		}
		myMap.getLinks().add(lme);
		return lme;
	}

	private NodeMapping createNodeMapping(Node nodeDef, DiagramLabel labelDef, NodeData nodeData) {
		return createNodeMapping(nodeDef, nodeData.getEClass(), labelDef, nodeData.getNameAttr(), nodeData.getContainment());
	}

	private NodeMapping createNodeMapping(Node nodeDef, EClass domainMetaElement, DiagramLabel labelDef, EAttribute editFeature, EReference containmentFeature) {
		return createNodeMapping(nodeDef, domainMetaElement, labelDef, editFeature, containmentFeature, true);
	}
	
	protected final NodeMapping createNodeMapping(Node nodeDef, EClass domainMetaElement, DiagramLabel labelDef, EAttribute editFeature, EReference containmentFeature, boolean addTopNodeReference) {
		NodeMapping nme = GMFMapFactory.eINSTANCE.createNodeMapping();
		nme.setDiagramNode(nodeDef);
		nme.setDomainMetaElement(domainMetaElement);
		if (editFeature != null) {
			final LabelMapping lm = GMFMapFactory.eINSTANCE.createLabelMapping();
			lm.getFeatures().add(editFeature);
			lm.setDiagramLabel(labelDef);
			nme.getLabelMappings().add(lm);
		}
		// FIXME nme.setTool(GMFMapFactory.eINSTANCE.createCreationTool());
		setupNodeMapping(nme);
	
		if (addTopNodeReference){
			TopNodeReference tnr = GMFMapFactory.eINSTANCE.createTopNodeReference();
			tnr.setOwnedChild(nme);
			tnr.setContainmentFeature(containmentFeature);
			myMap.getNodes().add(tnr);
		}
		return nme;	
	}

	protected void addCreationConstraints(LinkMapping linkMapping, String sourceConstraint, String endConstraint) {
		LinkConstraints constraints = GMFMapFactory.eINSTANCE.createLinkConstraints();
		Constraint source = GMFMapFactory.eINSTANCE.createConstraint();
		source.setBody(sourceConstraint);
		constraints.setSourceEnd(source);
		
		Constraint target = GMFMapFactory.eINSTANCE.createConstraint();
		target.setBody(endConstraint);
		constraints.setTargetEnd(target);
		
		linkMapping.setCreationConstraints(constraints);
	}		

	/**
	 * Allows for extra initialization code. Does nothing by default
	 */
	protected void setupCanvasMapping(CanvasMapping cme) {
	}

	/**
	 * Allows for extra initialization code. Does nothing by default
	 */
	protected void setupNodeMapping(NodeMapping nme) {
	}

	/**
	 * Allows for extra initialization code. Does nothing by default
	 */
	protected void setupClassLinkMapping(LinkMapping lme) {
	}

	/**
	 * Allows for extra initialization code. Does nothing by default
	 */
	protected void setupReferenceLinkMapping(LinkMapping lme) {
	}

	public final Mapping getMapping() {
		return myMap;
	}

	public NodeMapping getNodeA() {
		return myNodeA;
	}

	public NodeMapping getNodeB() {
		return myNodeB;
	}

	public LinkMapping getClassLink() {
		return myClassLink;
	}

	public LinkMapping getReferenceLink() {
		return myRefLink;
	}

	public NodeMapping getNodeAChild() {
		return myNodeAChild;
	}

	public CompartmentMapping getNodeACompartment() {
		return myNodeACompartment;
	}

	public NodeMapping getNodeBChild() {
		return myNodeBChild;
	}

	public CompartmentMapping getNodeBCompartment() {
		return myNodeBCompartment;
	}
}
