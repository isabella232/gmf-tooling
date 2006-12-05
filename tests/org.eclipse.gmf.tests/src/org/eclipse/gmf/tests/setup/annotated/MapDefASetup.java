/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup.annotated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.FeatureLabelMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.MappingEntry;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tooldef.CreationTool;
import org.eclipse.gmf.tooldef.ToolRegistry;

/**
 * Creates mapping model from annotated domain model.
 * 
 * @author dstadnik
 */
public class MapDefASetup extends AbstractASetup implements MapDefSource {

	protected EPackage ePackage;

	protected Mapping mapping;

	protected ToolRegistry registry;

	protected Canvas canvas;

	protected Map<EClass, List<ChildReference>> nodeMappings;

	protected Map<EClass, List<CompartmentMapping>> compartmentMappings;

	protected Map<EClass, List<FeatureLabelMapping>> labelMappings;

	public MapDefASetup(EPackage ePackage, ToolRegistry registry, Canvas canvas) {
		this.ePackage = ePackage;
		this.registry = registry;
		this.canvas = canvas;
	}

	protected Iterator getAllDomainModelContents() {
		return ePackage.eAllContents();
	}

	protected void createMapping() {
		nodeMappings = new HashMap<EClass, List<ChildReference>>();
		compartmentMappings = new HashMap<EClass, List<CompartmentMapping>>();
		labelMappings = new HashMap<EClass, List<FeatureLabelMapping>>();
		mapping = GMFMapFactory.eINSTANCE.createMapping();

		processDomainModel();

		// unwind nodes hierarchy
		List<ChildReference> refs = nodeMappings.remove(mapping.getDiagram().getDomainMetaElement());
		if (refs != null) {
			for (ChildReference ref : refs) {
				TopNodeReference tref = GMFMapFactory.eINSTANCE.createTopNodeReference();
				tref.setContainmentFeature(ref.getContainmentFeature());
				tref.setOwnedChild(ref.getOwnedChild());
				mapping.getNodes().add(tref);
				List<CompartmentMapping> compartments = compartmentMappings.remove(tref.getOwnedChild().getDomainMetaElement());
				if (compartments != null) {
					tref.getOwnedChild().getCompartments().addAll(compartments);
				}
				unwindNodeMappings(tref.getOwnedChild());
			}
		}
		assert nodeMappings.isEmpty() : "Inconsistent gmf annotations (nodes)"; //$NON-NLS-1$

		// distribute label mappings among node and link mappings
		for (Iterator it = mapping.eAllContents(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof MappingEntry) {
				MappingEntry entry = (MappingEntry) next;
				List<FeatureLabelMapping> list = labelMappings.remove(entry.getDomainMetaElement());
				if (list != null) {
					for (FeatureLabelMapping lmapping : list) {
						entry.getLabelMappings().add(lmapping);
					}
				}
			}
		}
		assert labelMappings.isEmpty() : "Inconsistent gmf annotations (labels)"; //$NON-NLS-1$
	}

	protected void unwindNodeMappings(NodeMapping parent) {
		List<ChildReference> refs = nodeMappings.remove(parent.getDomainMetaElement());
		if (refs != null) {
			for (ChildReference ref : refs) {
				parent.getChildren().add(ref);
				List<CompartmentMapping> compartments = compartmentMappings.remove(ref.getOwnedChild().getDomainMetaElement());
				if (compartments != null) {
					ref.getOwnedChild().getCompartments().addAll(compartments);
				}
				unwindNodeMappings(ref.getOwnedChild());
				CompartmentMapping cmapping = findCompartment(parent, ref.getOwnedChild());
				if (cmapping != null) {
					ref.setCompartment(cmapping);
				}
			}
		}
	}

	protected CompartmentMapping findCompartment(NodeMapping parent, NodeMapping child) {
		List<Parameter> params = getParameters(child.getDomainMetaElement());
		for (Parameter param : params) {
			if ("in".equals(param.name)) { //$NON-NLS-1$
				String comparmtentName = param.value;
				assert comparmtentName != null;
				for (Iterator it = parent.getCompartments().iterator(); it.hasNext();) {
					CompartmentMapping cmapping = (CompartmentMapping) it.next();
					if (cmapping.getCompartment().getName().equals(comparmtentName)) {
						return cmapping;
					}
				}
			}
		}
		return null;
	}

	protected void processCanvas(EModelElement element, String name, List<Parameter> params) {
		CanvasMapping cmapping = GMFMapFactory.eINSTANCE.createCanvasMapping();
		cmapping.setDomainModel(ePackage);
		cmapping.setDomainMetaElement((EClass) element);
		cmapping.setPalette(registry.getPalette());
		cmapping.setDiagramCanvas(canvas);
		mapping.setDiagram(cmapping);
	}

	protected void processNode(EModelElement element, String name, List<Parameter> params) {
		name = getName(element, name);
		EReference containment = findReferenceByQName(ePackage, params, "containment"); //$NON-NLS-1$
		assert ((EClass) containment.getEType()).isSuperTypeOf((EClass) element) : "Containment feature should contain instances of node class"; //$NON-NLS-1$
		ChildReference ref = GMFMapFactory.eINSTANCE.createChildReference();
		ref.setContainmentFeature(containment);
		NodeMapping nmapping = GMFMapFactory.eINSTANCE.createNodeMapping();
		nmapping.setDomainMetaElement((EClass) element);
		nmapping.setTool(findCreationTool(element, name));
		nmapping.setDiagramNode(findNode(element, name));
		ref.setOwnedChild(nmapping);
		List<ChildReference> refs = nodeMappings.get(containment.getEContainingClass());
		if (refs == null) {
			refs = new ArrayList<ChildReference>();
			nodeMappings.put(containment.getEContainingClass(), refs);
		}
		refs.add(ref);
	}

	protected void processCompartment(EModelElement element, String name, List<Parameter> params) {
		assert name != null;
		CompartmentMapping cmapping = GMFMapFactory.eINSTANCE.createCompartmentMapping();
		cmapping.setCompartment(findCompartment(element, name));
		List<CompartmentMapping> list = compartmentMappings.get((EClass) element);
		if (list == null) {
			list = new ArrayList<CompartmentMapping>();
			compartmentMappings.put((EClass) element, list);
		}
		list.add(cmapping);
	}

	protected void processLink(EModelElement element, String name, List<Parameter> params) {
		name = getName(element, name);
		LinkMapping lmapping = GMFMapFactory.eINSTANCE.createLinkMapping();
		if (element instanceof EClass) {
			EClass type = (EClass) element;
			lmapping.setDomainMetaElement(type);
			lmapping.setContainmentFeature(findReferenceByQName(ePackage, params, "containment")); //$NON-NLS-1$
			lmapping.setSourceMetaFeature(findReference(type, "source")); //$NON-NLS-1$
			lmapping.setLinkMetaFeature(findReference(type, "target")); //$NON-NLS-1$
		} else {
			lmapping.setLinkMetaFeature((EReference) element);
		}
		lmapping.setTool(findCreationTool(element, name));
		lmapping.setDiagramLink(findConnection(element, name));
		mapping.getLinks().add(lmapping);
	}

	protected void processLabel(EModelElement element, String name, List<Parameter> params) {
		name = getName(element, name);
		EAttribute attr = (EAttribute) element;
		FeatureLabelMapping lmapping = GMFMapFactory.eINSTANCE.createFeatureLabelMapping();
		lmapping.getFeatures().add(attr);
		lmapping.setDiagramLabel(findLabel(element, name));
		List<FeatureLabelMapping> list = labelMappings.get(attr.getEContainingClass());
		if (list == null) {
			list = new ArrayList<FeatureLabelMapping>();
			labelMappings.put(attr.getEContainingClass(), list);
		}
		list.add(lmapping);
	}

	protected CreationTool findCreationTool(EModelElement element, String name) {
		for (Iterator it = registry.eAllContents(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof CreationTool) {
				CreationTool tool = (CreationTool) next;
				if (name.equals(tool.getTitle())) {
					return tool;
				}
			}
		}
		return null;
	}

	protected Node findNode(EModelElement element, String name) {
		for (Iterator it = canvas.getNodes().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			if (name.equals(node.getName())) {
				return node;
			}
		}
		return null;
	}

	protected Compartment findCompartment(EModelElement element, String name) {
		for (Iterator it = canvas.getCompartments().iterator(); it.hasNext();) {
			Compartment compartment = (Compartment) it.next();
			if (name.equals(compartment.getName())) {
				return compartment;
			}
		}
		return null;
	}

	protected Connection findConnection(EModelElement element, String name) {
		for (Iterator it = canvas.getConnections().iterator(); it.hasNext();) {
			Connection connection = (Connection) it.next();
			if (name.equals(connection.getName())) {
				return connection;
			}
		}
		return null;
	}

	protected DiagramLabel findLabel(EModelElement element, String name) {
		for (Iterator it = canvas.getLabels().iterator(); it.hasNext();) {
			DiagramLabel label = (DiagramLabel) it.next();
			if (name.equals(label.getName())) {
				return label;
			}
		}
		return null;
	}

	// source

	public Mapping getMapping() {
		if (mapping == null) {
			createMapping();
			saveModel(mapping, "gmfmap"); //$NON-NLS-1$
			validate(mapping);
		}
		return mapping;
	}

	public NodeMapping getNodeA() {
		return null;
	}

	public NodeMapping getNodeB() {
		return null;
	}

	public LinkMapping getClassLink() {
		return null;
	}

	public LinkMapping getReferenceLink() {
		return null;
	}
}
