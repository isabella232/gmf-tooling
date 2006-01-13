/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.wizards.pages;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.tooldef.AbstractTool;
import org.eclipse.gmf.tooldef.ToolRegistry;

/**
 * @author artem
 */
public class WizardInput {
	private ResourceSet resourceSet;
	private EPackage myDomainModel;
	private Canvas myCanvas;
	private ToolRegistry myRegistry;
	private Mapping mapInstance;
	private List/*<EClass>*/ myNodeCandidates;
	private List/*<ENamedElement>*/ myLinkCandidates;
	private Hierarchy myHierarchy;

	public WizardInput() {
	}

	public ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	public void setDomainModel(EPackage aPackage) {
		checkUnload(myDomainModel);
		myDomainModel = aPackage;
	}

	public void setGraphDef(Canvas canvas) {
		checkUnload(myCanvas);
		myCanvas = canvas;
	}

	public void setToolDef(ToolRegistry registry) {
		checkUnload(myRegistry);
		myRegistry = registry;
	}

	public Mapping getMapping() {
		if (mapInstance == null) {
			mapInstance = GMFMapFactory.eINSTANCE.createMapping();
		}
		return mapInstance;
	}

	public boolean isReady2Go() {
		return myDomainModel != null && myCanvas != null /*&& myRegistry != null*/;
	}

	private void checkUnload(EObject eobj) {
		if (eobj == null) {
			return;
		}
		if (eobj.eResource().getResourceSet() == resourceSet && eobj.eResource().isLoaded()) {
			eobj.eResource().unload();
		}
	}
	public List/*<EClass>*/ getCanvasElementCandidates() {
		UniqueEList rv = new UniqueEList();
		for (Iterator it = myDomainModel.getEClassifiers().iterator(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof EClass) {
				EClass eClass = (EClass) next;
				if (!eClass.isAbstract() && !eClass.isInterface() && !eClass.getEAllContainments().isEmpty()) {
					rv.add(eClass);
				}
			}
		}
		return rv;
	}

	public void selectCanvasElement(EClass eClass) {
		assert eClass.getEPackage() == myDomainModel;
		CanvasMapping cm;
		if (getMapping().getDiagram() == null) {
			cm =  GMFMapFactory.eINSTANCE.createCanvasMapping();
			// +palette/gmfgraph.canvas
		} else {
			cm = getMapping().getDiagram();
		}
		cm.setDomainMetaElement(eClass);
		cm.setDomainModel(eClass.getEPackage());
		getMapping().setDiagram(cm);
	}

	public void feedDefaultMapping() {
		final Hierarchy hierarchy = getHierarchy();
		myNodeCandidates = new UniqueEList(hierarchy.getAccessibleClasses());
		myLinkCandidates = new UniqueEList(hierarchy.getAccessibleLinkClasses());
		List/*<EClass>*/ nodeProposals = new UniqueEList();
		List/*<EClass>*/ linkProposals = new UniqueEList();
		for (Iterator iter = myNodeCandidates.iterator(); iter.hasNext();) {
			EClass element = (EClass) iter.next();
			if (hierarchy.isLeaf(element)) {
				nodeProposals.add(element);
			}
		}
		for (Iterator iter = myLinkCandidates.iterator(); iter.hasNext();) {
			EClass element = (EClass) iter.next();
			if (hierarchy.isLeaf(element)) {
				linkProposals.add(element);
			}
		}
		myLinkCandidates.addAll(hierarchy.getAccessibleReferences());
		linkProposals.addAll(hierarchy.getAccessibleReferences(nodeProposals.iterator()));
		getMapping().getNodes().clear();
		getMapping().getNodes().addAll(nodesFrom(nodeProposals));
		getMapping().getLinks().clear();
		getMapping().getLinks().addAll(linksFrom(linkProposals));
	}

	private Hierarchy getHierarchy() {
		if (myHierarchy == null) {
			myHierarchy = new Hierarchy(getMapping().getDiagram().getDomainMetaElement().getEAllContainments(), myDomainModel);
			myHierarchy.collect();
		}
		return myHierarchy;
	}

	public NodeMapping[] nodeCandidates() {
		return (NodeMapping[]) nodesFrom(myNodeCandidates).toArray(new NodeMapping[0]);
	}

	public LinkMapping[] linkCandidates() {
		return (LinkMapping[]) linksFrom(myLinkCandidates).toArray(new LinkMapping[0]);
	}

	private List nodesFrom(List candidates) {
		BasicEList rv = new BasicEList(candidates.size());
		for (Iterator iter = candidates.iterator(); iter.hasNext();) {
			EClass eClass = (EClass) iter.next();
			NodeMapping nm = GMFMapFactory.eINSTANCE.createNodeMapping();
			nm.setDomainMetaElement(eClass);
			nm.setContainmentFeature(getHierarchy().backRef(eClass));
			nm.setDiagramNode(findSuitableNode(nm));
			nm.setEditFeature(findEditFeature(eClass));
			nm.setTool(findTool(nm));
			rv.add(nm);
		}
		return rv;
	}

	private List/*<LinkMapping>*/ linksFrom(List candidates) {
		BasicEList rv = new BasicEList(candidates.size());
		for (Iterator iter = candidates.iterator(); iter.hasNext();) {
			Object next = iter.next();
			LinkMapping lm = GMFMapFactory.eINSTANCE.createLinkMapping();
			if (next instanceof EClass) {
				EClass eClass = (EClass) next;
				lm.setDomainMetaElement(eClass);
				lm.setContainmentFeature(getHierarchy().backRef(eClass));
				lm.setLabelEditFeature(findEditFeature(eClass));
				lm.setLinkMetaFeature(getHierarchy().getLinkFeature(eClass));
			} else {
				lm.setLinkMetaFeature((EReference) next);
			}
			lm.setDiagramLink(findSuitableLink(lm));
			lm.setTool(findTool(lm));
			rv.add(lm);
		}
		return rv;
	}

	private Node findSuitableNode(NodeMapping nm) {
		String name = nm.getDomainMetaElement() == null ? null : nm.getDomainMetaElement().getName();
		return (Node) doSearch(myCanvas.getNodes(), name);
	}

	private Connection findSuitableLink(LinkMapping lm) {
		String name = null;
		if (lm.getDomainMetaElement() != null) {
			name = lm.getDomainMetaElement().getName();
		} else if (lm.getLinkMetaFeature() != null) {
			name = lm.getLinkMetaFeature().getEContainingClass().getName();
		}
		return (Connection) doSearch(myCanvas.getConnections(), name);
	}

	private DiagramElement doSearch(List/*<DiagramElement>*/ elements, String namePart) {
		if (elements.isEmpty()) {
			return null;
		}
		if (namePart != null) {
			DiagramElement c = matchName(elements, namePart);
			if (c != null) {
				return c;
			}
		}
		return (DiagramElement) elements.get(0);
	}

	private DiagramElement matchName(List/*<DiagramElement>*/ elements, String namePart) {
		for (Iterator it = elements.iterator(); it.hasNext();) {
			DiagramElement next = (DiagramElement) it.next();
			if (next.getName() != null && next.getName().indexOf(namePart) >= 0) {
				return next;
			}
		}
		return null;
	}

	private AbstractTool findTool(NodeMapping nm) {
		return null;
	}

	private AbstractTool findTool(LinkMapping lm) {
		return null;
	}

	private EAttribute findEditFeature(EClass class1) {
		for (Iterator it = class1.getEAllAttributes().iterator(); it.hasNext();) {
			EAttribute n = (EAttribute) it.next();
			if (EcorePackage.eINSTANCE.getEString().equals(n.getEType())) {
				return n;
			}
		}
		return null;
	}

	private static class Hierarchy {
		private final List/*<EReference>*/ myRefs;
		private final EPackage myDomainModel2;
		private final Map/*<EClass, Set<EClass>>*/ myResult;
		private Set myAccessibleLeaves;
		private Set myAccessibleClasses = new HashSet();
		private Set myAccessibleLinkClasses = new HashSet();

		public Hierarchy(List/*<EReference>*/ eRefs, EPackage domainModel) {
			myRefs = eRefs;
			myDomainModel2 = domainModel;
			myResult = new HashMap();
			for (Iterator iter = eRefs.iterator(); iter.hasNext();) {
				EReference element = (EReference) iter.next();
				myResult.put(element.getEReferenceType(), new HashSet());
			}
		}

		public EReference backRef(EClass element) {
			for (Iterator it2 = myRefs.iterator(); it2.hasNext();) {
				EReference r = (EReference) it2.next();
				if (r.getEReferenceType().isSuperTypeOf(element)) {
					return r;
				}
			}
			return null;
		}

		public boolean isLeaf(EClass element) {
			return myAccessibleLeaves.contains(element);
		}

		public EReference getLinkFeature(EClass element) {
			BasicEList l = collectAllNonContainment(element);
			if (l.isEmpty()) {
				return null;
			}
			for (Iterator iter = l.iterator(); iter.hasNext();) {
				EReference ref = (EReference) iter.next();
				if (element.isSuperTypeOf(ref.getEReferenceType())) {
					continue;
				}
				for (Iterator it2 = myResult.keySet().iterator(); it2.hasNext();) {
					EClass c = (EClass) it2.next();
					if (c.isSuperTypeOf(ref.getEReferenceType())) {
						return ref;
					}
				}
			}
			return null;
		}
		public void collect() {
			collect(true);
		}

		private void collect(boolean recurse) {
			Set nonLeaves = new HashSet();
			final HashSet leavesSet = new HashSet();
			for (Iterator it = myDomainModel2.getEClassifiers().iterator(); it.hasNext();) {
				Object next = it.next();
				if (next instanceof EClass) {
					EClass eClass = (EClass) next;
					for (Iterator it2 = myResult.entrySet().iterator(); it2.hasNext();) {
						Map.Entry entry = (Map.Entry) it2.next();
						EClass element = (EClass) entry.getKey();
						if (element.isSuperTypeOf(eClass)) {
							((Set) entry.getValue()).add(eClass);
							if (recurse) {
								Hierarchy h2 = new Hierarchy(eClass.getEAllContainments(), myDomainModel2);
								h2.collect(false);
								myAccessibleLinkClasses .addAll(h2.getAccessibleClasses());
								leavesSet.addAll(h2.myAccessibleLeaves);
							}
							if (!eClass.isAbstract() &&  !eClass.isInterface()) {
								myAccessibleClasses.add(eClass);
							}
							nonLeaves.addAll(eClass.getESuperTypes());
						}
					}
				}
			}
			leavesSet.addAll(myAccessibleClasses);
			leavesSet.removeAll(nonLeaves);
			myAccessibleLeaves = Collections.unmodifiableSet(leavesSet);
			myAccessibleClasses = Collections.unmodifiableSet(myAccessibleClasses);
			myAccessibleLinkClasses = Collections.unmodifiableSet(myAccessibleLinkClasses);
		}

		public Set/*<EClass>*/ getAccessibleClasses() {
			return myAccessibleClasses;
		}

		public Set/*<EClass>*/ getAccessibleLinkClasses() {
			return myAccessibleLinkClasses;
		}

		public Set/*<EReference>*/ getAccessibleReferences() {
			return getAccessibleReferences(myAccessibleClasses.iterator());
		}

		public Set/*<EReference>*/ getAccessibleReferences(Iterator/*<EClass>*/ iter) {
			HashSet rv = new HashSet();
			for (; iter.hasNext();) {
				EClass element = (EClass) iter.next();
				rv.addAll(collectAllNonContainment(element));
			}
			return rv;
		}

		private BasicEList collectAllNonContainment(EClass element) {
			BasicEList l = new BasicEList(element.getEAllReferences());
			l.removeAll(element.getEAllContainments());
			return l;
		}
	}
}
