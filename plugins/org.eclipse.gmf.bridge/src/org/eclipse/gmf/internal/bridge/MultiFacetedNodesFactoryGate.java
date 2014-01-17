package org.eclipse.gmf.internal.bridge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenChildNodeBase;
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenMultiFacetedNode;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeNodeModelFacet;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.NodeMapping;

public class MultiFacetedNodesFactoryGate extends BridgeFactoryGateBase {

	private final Map<NodeMapping, GenMultiFacetedNode> myMultiFacetNodes = new HashMap<NodeMapping, GenMultiFacetedNode>();

	private final Map<NodeMapping, List<GenChildNode>> mySingleFacetNodes = new HashMap<NodeMapping, List<GenChildNode>>();

	private final Map<NodeMapping, GenTopLevelNode> myDesignTopNodes = new HashMap<NodeMapping, GenTopLevelNode>();

	private final Map<NodeMapping, GenChildNode> myDesignChildNodes = new HashMap<NodeMapping, GenChildNode>();

	@Override
	public void prepare(CanvasMapping canvasMap) {
		super.prepare(canvasMap);
		myMultiFacetNodes.clear();
		mySingleFacetNodes.clear();
	}

	@Override
	public GenNode findOrCreateTopNode(NodeMapping nodeMap, TypeModelFacet modelFacet, GenDiagram diagram) {
		if (modelFacet == null) {
			GenTopLevelNode result = myDesignTopNodes.get(nodeMap);
			if (result == null) {
				result = doCreateDesignTopNode(nodeMap, diagram);
			}
			return result;
		}

		GenMultiFacetedNode result = myMultiFacetNodes.get(nodeMap);
		if (result != null) {
			if (result.getModelFacet() != modelFacet) {
				throw new IllegalStateException("Expected model facet: " + modelFacet + ", actual : " + result.getModelFacet());
			}
			return result;
		}

		result = createMultiFacetedNode(nodeMap, diagram);
		result.setModelFacet(modelFacet);

		return result;
	}

	@Override
	public GenChildNodeBase useCompatibleChildNode(NodeMapping nodeMap, TypeModelFacet modelFacet, ChildReference childRef, GenChildContainer container) {
		GenChildNodeBase result = findOrMakeCompatible(nodeMap, modelFacet, childRef, container);
		if (result != null) {
			container.getChildNodes().add(result);
		}
		return result;
	}

	private GenChildNodeBase findOrMakeCompatible(NodeMapping nodeMap, TypeModelFacet modelFacet, ChildReference childRef, GenChildContainer container) {
		//design nodes (modelFacet == null) are always created the old-way
		if (modelFacet == null) {
			GenChildNode known = myDesignChildNodes.get(nodeMap);
			assert known == null || matchFeaturesWithModelFacet(childRef, modelFacet);
			return known;
		}

		//whatever multi-faceted we have will be compatible, but lets first check single-faceted
		if (mySingleFacetNodes.containsKey(nodeMap)) {
			for (GenChildNode nextSingleFaceted : mySingleFacetNodes.get(nodeMap)) {
				if (matchFeaturesWithModelFacet(childRef, nextSingleFaceted.getModelFacet())) {
					return nextSingleFaceted;
				}
			}
		}

		GenMultiFacetedNode result = myMultiFacetNodes.get(nodeMap);
		if (result == null) {
			return null;
		}
		boolean found = false;
		for (TypeModelFacet next : result.allModelFacets()) {
			if (matchFeaturesWithModelFacet(childRef, next)) {
				if (next instanceof TypeNodeModelFacet) {
					((TypeNodeModelFacet) next).getContainers().add(container);
				}
			}
		}
		if (!found) {
			result.getAdditionalModelFacets().add(wrapModelFacet(modelFacet, container));
		}
		return result;
	}

	@Override
	public GenChildNodeBase createChildNode(NodeMapping nodeMap, TypeModelFacet modelFacet, GenChildContainer container) {
		if (modelFacet == null) {
			return createChildNode(nodeMap, container, GMFGenPackage.eINSTANCE.getGenChildNode(), true);
		}
		GenMultiFacetedNode result = createMultiFacetedNode(nodeMap, container.getDiagram());
		result.getAdditionalModelFacets().add(wrapModelFacet(modelFacet, container));
		container.getChildNodes().add(result);
		return result;
	}

	@Override
	public GenChildLabelNode createChildLabelNode(NodeMapping nodeMap, TypeModelFacet facet, GenChildContainer container) {
		GenChildLabelNode result = (GenChildLabelNode) createChildNode(nodeMap, container, GMFGenPackage.eINSTANCE.getGenChildLabelNode(), facet == null);
		result.setModelFacet(facet);
		return result;
	}

	@Override
	public GenChildSideAffixedNode createSideAffixedNode(NodeMapping nodeMap, TypeModelFacet facet, GenChildContainer container) {
		GenChildSideAffixedNode result = (GenChildSideAffixedNode) createChildNode(nodeMap, container, GMFGenPackage.eINSTANCE.getGenChildSideAffixedNode(), facet == null);
		result.setModelFacet(facet);
		return result;
	}

	@Override
	public GenNode[] findAllNodesFor(NodeMapping nm) {
		assert nm != null;
		List<GenNode> result = new ArrayList<GenNode>() {

			private static final long serialVersionUID = 1L;

			public boolean add(GenNode node) {
				return node != null && super.add(node);
			}

			@Override
			public boolean addAll(Collection<? extends GenNode> c) {
				return c != null && super.addAll(c);
			}

		};

		result.add(myDesignTopNodes.get(nm));
		result.add(myMultiFacetNodes.get(nm));
		result.add(myDesignChildNodes.get(nm));
		result.addAll(mySingleFacetNodes.get(nm));

		return (GenNode[]) result.toArray(new GenNode[result.size()]);
	}

	private TypeNodeModelFacet wrapModelFacet(TypeModelFacet modelFacet, GenChildContainer container) {
		TypeNodeModelFacet result = GMFGenFactory.eINSTANCE.createTypeNodeModelFacet();
		result.getContainers().add(container);
		for (EStructuralFeature feature : GMFGenPackage.eINSTANCE.getTypeModelFacet().getEAllStructuralFeatures()) {
			if (feature.isDerived() || !feature.isChangeable()) {
				continue;
			}
			if (feature instanceof EReference) {
				EReference ref = (EReference) feature;
				if (ref.isContainer() || ref.isContainment()) {
					continue;
				}
			}
			result.eSet(feature, modelFacet.eGet(feature));
		}
		return result;
	}

	private GenTopLevelNode doCreateDesignTopNode(NodeMapping nm, GenDiagram diagram) {
		GenTopLevelNode result = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		result.setModelFacet(null);
		diagram.getTopLevelNodes().add(result);
		myDesignTopNodes.put(nm, result);
		return result;
	}

	private GenChildNode createChildNode(NodeMapping nodeMap, GenChildContainer container, EClass eClass, boolean design) {
		assert nodeMap != null;
		GenChildNode result = (GenChildNode) eClass.getEPackage().getEFactoryInstance().create(eClass);
		container.getDiagram().getChildNodes().add(result);
		container.getChildNodes().add(result);
		if (design) {
			myDesignChildNodes.put(nodeMap, result);
		} else {
			List<GenChildNode> genNodes = mySingleFacetNodes.get(nodeMap);
			if (genNodes == null) {
				genNodes = new LinkedList<GenChildNode>();
				mySingleFacetNodes.put(nodeMap, genNodes);
			}
			genNodes.add(result);
		}
		return result;
	}

	private GenMultiFacetedNode createMultiFacetedNode(NodeMapping nm, GenDiagram diagram) {
		GenMultiFacetedNode result = GMFGenFactory.eINSTANCE.createGenMultiFacetedNode();
		diagram.getMultiFacetedNodes().add(result);
		myMultiFacetNodes.put(nm, result);
		return result;
	}

}
