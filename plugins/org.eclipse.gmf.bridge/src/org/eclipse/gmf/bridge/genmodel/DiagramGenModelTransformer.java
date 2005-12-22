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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.codegen.gmfgen.BasicNodeViewmap;
import org.eclipse.gmf.codegen.gmfgen.ColorAttributes;
import org.eclipse.gmf.codegen.gmfgen.CompartmentLayoutKind;
import org.eclipse.gmf.codegen.gmfgen.CompartmentPlacementKind;
import org.eclipse.gmf.codegen.gmfgen.DecoratedConnectionViewmap;
import org.eclipse.gmf.codegen.gmfgen.FeatureModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenElementInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureValueSpec;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkConstraints;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.LinkDecoration;
import org.eclipse.gmf.codegen.gmfgen.LinkEntry;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ModelElementSelector;
import org.eclipse.gmf.codegen.gmfgen.NodeEntry;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ShapeAttributes;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ValueExpression;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.ConnectionFigure;
import org.eclipse.gmf.gmfgraph.CustomConnection;
import org.eclipse.gmf.gmfgraph.DecorationFigure;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.Shape;
import org.eclipse.gmf.gmfgraph.util.FigureQualifiedNameSwitch;
import org.eclipse.gmf.gmfgraph.util.GMFGraphSwitch;
import org.eclipse.gmf.mappings.AbstractNodeMapping;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.CreationTool;
import org.eclipse.gmf.mappings.ElementInitializer;
import org.eclipse.gmf.mappings.FeatureSeqInitializer;
import org.eclipse.gmf.mappings.FeatureValueSpec;
import org.eclipse.gmf.mappings.LinkConstraints;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.Tool;

/**
 * Creates generation model from diagram definition.
 * @author artem
 */
public class DiagramGenModelTransformer extends MappingTransformer {

	private static final int CANVAS_COUNT_BASE = 79;
	private static final int NODE_COUNT_BASE = 1000;
	private static final int CHILD_COUNT_BASE = 2000;
	private static final int LINK_COUNT_BASE = 3000;
	private static final int LABEL_COUNT_BASE = 4000;
	private static final int COMPARTMENT_COUNT_BASE = 5000;

	private GenDiagram myGenModel;
	private GenModelMatcher myGenModelMatch;
	private final DiagramRunTimeModelHelper myDRTHelper;
	private final NamingStrategy myNamingStrategy;

	private final GMFGraphSwitch myFiqureQualifiedNamesSwitch = new FigureQualifiedNameSwitch();

	private int myNodeCount = 0;
	private int myLinkCount = 0;
	private int myChildCount = 0;
	private int myLabelCount = 0;
	private int myCompartmentCount = 0;

	public DiagramGenModelTransformer(DiagramRunTimeModelHelper drtHelper, NamingStrategy namingStrategy) {
		myDRTHelper = drtHelper;
		myNamingStrategy = namingStrategy;
	}

	/**
	 * Optionally set GenModel to match ECore elements against. 
	 * Should be invoked prior to {@link MappingTransformer#transform(Mapping)}, otherwise has no effect.
	 * Useful for tests (and other cases) when GenModel is not known to EMF 
	 * (and thus can't be obtained using EMF techniques).
	 * @param emfGenModel EMF GenModel for domain model
	 */
	public void setEMFGenModel(GenModel emfGenModel) {
		myGenModelMatch = new GenModelMatcher(emfGenModel);
	}

	public GenDiagram getResult() {
		return getGenDiagram();
	}

	private GenDiagram getGenDiagram() {
		if (myGenModel == null) {
			myGenModel = GMFGenFactory.eINSTANCE.createGenDiagram();
		}
		return myGenModel;
	}

	private Palette getGenPalette() {
		Palette p = getGenDiagram().getPalette();
		if (p == null) {
			p = GMFGenFactory.eINSTANCE.createPalette();
			getGenDiagram().setPalette(p);
		}
		return p;
	}

	protected void process(CanvasMapping mapping) {
		assert mapping.getDomainModel() != null;
		if (myGenModelMatch == null) {
			myGenModelMatch = new GenModelMatcher(mapping.getDomainModel());
		}
		getGenDiagram().setDomainMetaModel(findGenPackage(mapping.getDomainModel()));
		getGenDiagram().setDomainDiagramElement(findGenClass(mapping.getDomainMetaElement()));
		getGenDiagram().setDiagramRunTimeClass(findRunTimeClass(mapping));
		getGenDiagram().setVisualID(CANVAS_COUNT_BASE);
		getGenDiagram().setPluginName(mapping.getDomainModel().getName() + " Plugin");
		getGenDiagram().setViewmap(GMFGenFactory.eINSTANCE.createDiagramViewmap());

		// set class names
		getGenDiagram().setNotationViewFactoryClassName(myNamingStrategy.createCanvasClassName(mapping, GenCommonBase.NOTATION_VIEW_FACTORY_SUFFIX));
		getGenDiagram().setEditPartClassName(myNamingStrategy.createCanvasClassName(mapping, GenCommonBase.EDIT_PART_SUFFIX));
		getGenDiagram().setItemSemanticEditPolicyClassName(myNamingStrategy.createCanvasClassName(mapping, GenCommonBase.ITEM_SEMANTIC_EDIT_POLICY_SUFFIX));
		getGenDiagram().setCanonicalEditPolicyClassName(myNamingStrategy.createCanvasClassName(mapping, GenChildContainer.CANONICAL_EDIT_POLICY_SUFFIX));
	}

	protected void process(NodeMapping nme) {
		assertAbstractNodeMapping(nme);
		assert nme.getDiagramNode() != null;
		
		GenNode genNode = GMFGenFactory.eINSTANCE.createGenNode();
		getGenDiagram().getNodes().add(genNode);
		genNode.setDiagramRunTimeClass(findRunTimeClass(nme));
		genNode.setModelFacet(createModelFacet(nme));
		genNode.setVisualID(NODE_COUNT_BASE + (++myNodeCount));
		if (nme.getEditFeature() != null) {
			FeatureModelFacet modelFacet = GMFGenFactory.eINSTANCE.createFeatureModelFacet();
			modelFacet.setMetaFeature(findGenFeature(nme.getEditFeature()));
			GenNodeLabel label = GMFGenFactory.eINSTANCE.createGenNodeLabel();
			label.setModelFacet(modelFacet);
			label.setVisualID(LABEL_COUNT_BASE + (++myLabelCount));
			label.setDiagramRunTimeClass(getNodeLabelRunTimeClass());
			label.setViewmap(GMFGenFactory.eINSTANCE.createLabelViewmap());

			// set class names
			label.setNotationViewFactoryClassName(myNamingStrategy.createNodeLabelClassName(nme, nme.getEditFeature(), GenCommonBase.NOTATION_VIEW_FACTORY_SUFFIX));
			label.setEditPartClassName(myNamingStrategy.createNodeLabelClassName(nme, nme.getEditFeature(), GenCommonBase.EDIT_PART_SUFFIX));
			label.setItemSemanticEditPolicyClassName(myNamingStrategy.createNodeLabelClassName(nme, nme.getEditFeature(), GenCommonBase.ITEM_SEMANTIC_EDIT_POLICY_SUFFIX));

			genNode.getLabels().add(label);
		}
		genNode.setViewmap(GMFGenFactory.eINSTANCE.createBasicNodeViewmap());
		handleNodeTool(nme, genNode);

		// set class names
		genNode.setNotationViewFactoryClassName(myNamingStrategy.createNodeClassName(nme, GenCommonBase.NOTATION_VIEW_FACTORY_SUFFIX));
		genNode.setEditPartClassName(myNamingStrategy.createNodeClassName(nme, GenCommonBase.EDIT_PART_SUFFIX));
		genNode.setItemSemanticEditPolicyClassName(myNamingStrategy.createNodeClassName(nme, GenCommonBase.ITEM_SEMANTIC_EDIT_POLICY_SUFFIX));
		genNode.setCanonicalEditPolicyClassName(myNamingStrategy.createNodeClassName(nme, GenChildContainer.CANONICAL_EDIT_POLICY_SUFFIX));
		genNode.setGraphicalNodeEditPolicyClassName(myNamingStrategy.createNodeClassName(nme, GenNode.GRAPHICAL_NODE_EDIT_POLICY_SUFFIX));
		
		processAbstractNode(nme, genNode);
	}

	private void process(ChildNodeMapping childNodeMapping, GenChildContainer container) {
		assertAbstractNodeMapping(childNodeMapping);
		assert childNodeMapping.getDiagramNode() != null;

		GenChildNode childNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		childNode.setModelFacet(createModelFacet(childNodeMapping));
		
		childNode.setDiagramRunTimeClass(findRunTimeClass(childNodeMapping));
		childNode.setViewmap(GMFGenFactory.eINSTANCE.createBasicNodeViewmap());
		childNode.setVisualID(CHILD_COUNT_BASE + (++myChildCount ));
		childNode.setChildContainersPlacement(CompartmentPlacementKind.TOOLBAR_LITERAL);

		// set class names
		childNode.setNotationViewFactoryClassName(myNamingStrategy.createChildNodeClassName(childNodeMapping, GenCommonBase.NOTATION_VIEW_FACTORY_SUFFIX));
		childNode.setEditPartClassName(myNamingStrategy.createChildNodeClassName(childNodeMapping, GenCommonBase.EDIT_PART_SUFFIX));
		childNode.setItemSemanticEditPolicyClassName(myNamingStrategy.createChildNodeClassName(childNodeMapping, GenCommonBase.ITEM_SEMANTIC_EDIT_POLICY_SUFFIX));
		childNode.setCanonicalEditPolicyClassName(myNamingStrategy.createChildNodeClassName(childNodeMapping, GenChildContainer.CANONICAL_EDIT_POLICY_SUFFIX));
		childNode.setGraphicalNodeEditPolicyClassName(myNamingStrategy.createChildNodeClassName(childNodeMapping, GenNode.GRAPHICAL_NODE_EDIT_POLICY_SUFFIX));

		if (childNodeMapping.getEditFeature() != null) {
			FeatureModelFacet modelFacet = GMFGenFactory.eINSTANCE.createFeatureModelFacet();
			modelFacet.setMetaFeature(findGenFeature(childNodeMapping.getEditFeature()));
			GenNodeLabel label = GMFGenFactory.eINSTANCE.createGenNodeLabel();
			label.setModelFacet(modelFacet);
			label.setVisualID(LABEL_COUNT_BASE + (++myLabelCount));
			label.setDiagramRunTimeClass(getNodeLabelRunTimeClass());
			label.setViewmap(GMFGenFactory.eINSTANCE.createLabelViewmap());

			// set class names
			label.setNotationViewFactoryClassName(myNamingStrategy.createNodeLabelClassName(childNodeMapping, childNodeMapping.getEditFeature(), GenCommonBase.NOTATION_VIEW_FACTORY_SUFFIX));
			label.setEditPartClassName(myNamingStrategy.createNodeLabelClassName(childNodeMapping, childNodeMapping.getEditFeature(), GenCommonBase.EDIT_PART_SUFFIX));
			label.setItemSemanticEditPolicyClassName(myNamingStrategy.createNodeLabelClassName(childNodeMapping, childNodeMapping.getEditFeature(), GenCommonBase.ITEM_SEMANTIC_EDIT_POLICY_SUFFIX));

			childNode.getLabels().add(label);
		}

		container.getChildNodes().add(childNode);
		handleNodeTool(childNodeMapping, childNode);
		processAbstractNode(childNodeMapping, childNode);
		
		if (childNodeMapping.getChildMappings().size() > 0) {
			// TODO just layout from childNodeMapping.getDiagramNode()
			if (container instanceof GenNode) {
				((GenNode) container).setChildContainersPlacement(CompartmentPlacementKind.FLOW_LITERAL);
			} else if (container instanceof GenCompartment) {
				((GenCompartment) container).setLayoutKind(CompartmentLayoutKind.XY_LITERAL);
			}
		}
	}
	
	private void processAbstractNode(AbstractNodeMapping mapping, GenNode genNode) {
		Map compartments2GenCompartmentsMap = new HashMap();
		for (Iterator it = mapping.getCompartmentMappings().iterator(); it.hasNext();) {
			CompartmentMapping compartmentMapping = (CompartmentMapping) it.next();
			GenCompartment compartmentGen = createGenCompartment(compartmentMapping);
			genNode.getCompartments().add(compartmentGen);
			compartments2GenCompartmentsMap.put(compartmentMapping, compartmentGen);
		}

		for (Iterator it = mapping.getChildMappings().iterator(); it.hasNext();) {
			ChildNodeMapping childNodeMapping = (ChildNodeMapping) it.next();
// Currently childNodeMapping should has compartment but we plan to make this reference optional
			CompartmentMapping compartmentMapping = childNodeMapping.getCompartment();
			GenChildContainer genChildContainer;
			if (compartmentMapping != null && compartments2GenCompartmentsMap.containsKey(compartmentMapping)) {
				genChildContainer = (GenChildContainer) compartments2GenCompartmentsMap.get(compartmentMapping);
			} else {
				genChildContainer = genNode;
			}
			process(childNodeMapping, genChildContainer);
		}
	}

	private GenCompartment createGenCompartment(CompartmentMapping mapping) {
		Compartment compartment = mapping.getCompartment(); 
		assert compartment != null;
		GenCompartment childCompartment = GMFGenFactory.eINSTANCE.createGenCompartment();
		childCompartment.setVisualID(COMPARTMENT_COUNT_BASE + (++myCompartmentCount));
		childCompartment.setDiagramRunTimeClass(getChildContainerRunTimeClass());
		childCompartment.setViewmap(GMFGenFactory.eINSTANCE.createCompartmentViewmap());
		childCompartment.setCanCollapse(compartment.isCollapsible());
		childCompartment.setNeedsTitle(compartment.isNeedsTitle());
		childCompartment.setLayoutKind(CompartmentLayoutKind.TOOLBAR_LITERAL);
		childCompartment.setTitle(compartment.getName());

		// set class names
		childCompartment.setNotationViewFactoryClassName(myNamingStrategy.createCompartmentClassName(mapping.getParentNodeMapping(), compartment, GenCommonBase.NOTATION_VIEW_FACTORY_SUFFIX));
		childCompartment.setEditPartClassName(myNamingStrategy.createCompartmentClassName(mapping.getParentNodeMapping(), compartment, GenCommonBase.EDIT_PART_SUFFIX));
		childCompartment.setItemSemanticEditPolicyClassName(myNamingStrategy.createCompartmentClassName(mapping.getParentNodeMapping(), compartment, GenCommonBase.ITEM_SEMANTIC_EDIT_POLICY_SUFFIX));
		childCompartment.setCanonicalEditPolicyClassName(myNamingStrategy.createCompartmentClassName(mapping.getParentNodeMapping(), compartment, GenChildContainer.CANONICAL_EDIT_POLICY_SUFFIX));

		return childCompartment;
	}

	protected void process(LinkMapping lme) {
		assert lme.getDiagramLink() != null;
		assert lme.getLinkMetaFeature() != null;
		GenLink gl = GMFGenFactory.eINSTANCE.createGenLink();
		getGenDiagram().getLinks().add(gl);
		gl.setModelFacet(createModelFacet(lme));
		if (lme.getTool() instanceof CreationTool) {
			LinkEntry le = GMFGenFactory.eINSTANCE.createLinkEntry();
			findToolGroup(lme.getTool()).getLinkTools().add(le);
			le.getGenLink().add(gl);
			le.setCreateMethodName(myNamingStrategy.createToolCreationMethodName(lme));
			setupCommonToolEntry(le, lme.getTool(), lme.getDomainMetaClass() != null ? lme.getDomainMetaClass().getName() : lme.getLinkMetaFeature().getName());
		}
		EAttribute editFeature = lme.getLabelEditFeature();
		if (editFeature != null) {
			FeatureModelFacet modelFacet = GMFGenFactory.eINSTANCE.createFeatureModelFacet();
			modelFacet.setMetaFeature(findGenFeature(lme.getLabelEditFeature()));
			GenLinkLabel label = GMFGenFactory.eINSTANCE.createGenLinkLabel();
			label.setModelFacet(modelFacet);
			label.setVisualID(LABEL_COUNT_BASE + (++myLabelCount));
			label.setDiagramRunTimeClass(getLinkLabelRunTimeClass());
			label.setViewmap(GMFGenFactory.eINSTANCE.createLabelViewmap());

			// set class names
			label.setNotationViewFactoryClassName(myNamingStrategy.createLinkLabelClassName(lme, lme.getLabelEditFeature(), GenCommonBase.NOTATION_VIEW_FACTORY_SUFFIX));
			label.setTextNotationViewFactoryClassName(myNamingStrategy.createLinkLabelClassName(lme, lme.getLabelEditFeature(), GenLinkLabel.TEXT_NOTATION_VIEW_FACTORY_SUFFIX));
			label.setEditPartClassName(myNamingStrategy.createLinkLabelClassName(lme, lme.getLabelEditFeature(), GenCommonBase.EDIT_PART_SUFFIX));
			label.setTextEditPartClassName(myNamingStrategy.createLinkLabelClassName(lme, lme.getLabelEditFeature(), GenLinkLabel.TEXT_EDIT_PART_SUFFIX));
			label.setItemSemanticEditPolicyClassName(myNamingStrategy.createLinkLabelClassName(lme, lme.getLabelEditFeature(), GenCommonBase.ITEM_SEMANTIC_EDIT_POLICY_SUFFIX));

			gl.getLabels().add(label);
		}
		gl.setDiagramRunTimeClass(findRunTimeClass(lme));
		gl.setVisualID(LINK_COUNT_BASE + (++myLinkCount));

		// set class names
		gl.setNotationViewFactoryClassName(myNamingStrategy.createLinkClassName(lme, GenCommonBase.NOTATION_VIEW_FACTORY_SUFFIX));
		gl.setEditPartClassName(myNamingStrategy.createLinkClassName(lme, GenCommonBase.EDIT_PART_SUFFIX));
		gl.setItemSemanticEditPolicyClassName(myNamingStrategy.createLinkClassName(lme, GenCommonBase.ITEM_SEMANTIC_EDIT_POLICY_SUFFIX));

		gl.setViewmap(createViewmap(lme.getDiagramLink()));

		if(lme.getCreationConstraints() != null) {
			gl.setCreationConstraints(createLinkCreationConstraints(lme.getCreationConstraints()));
		}
	}

	private Viewmap createViewmap(Connection conn) {
		assert conn.getFigure() instanceof ConnectionFigure;
		Viewmap viewmap = null;
		if (conn.getFigure() instanceof PolylineConnection) {
			PolylineConnection pc = (PolylineConnection) conn.getFigure();
			DecoratedConnectionViewmap v = GMFGenFactory.eINSTANCE.createDecoratedConnectionViewmap();
			if (pc.getSourceDecoration() != null) {
				v.setSource(from(pc.getSourceDecoration()));
			}
			if (pc.getTargetDecoration() != null) {
				v.setTarget(from(pc.getTargetDecoration()));
			}
			viewmap = v;
		} else {
			assert conn.getFigure() instanceof CustomConnection;
			BasicNodeViewmap v = GMFGenFactory.eINSTANCE.createBasicNodeViewmap(); // FIXME rename BasicNodeV to just GenericV
			v.setFigureQualifiedClassName(qualifiedFigureName(conn.getFigure()));
			viewmap = v;
		}
		setupAttributes(conn.getFigure(), viewmap);
		return viewmap;
	}

	private void setupAttributes(Figure figure, Viewmap v) {
		if (figure.getColorStyle() != null) {
			ColorAttributes attrs = GMFGenFactory.eINSTANCE.createColorAttributes();
			attrs.setBackgroundColor(figure.getColorStyle().getBackgroundColor());
			attrs.setForegroundColor(figure.getColorStyle().getForegroundColor());
			v.getAttributes().add(attrs);
		}
		if (figure instanceof Shape) {
			ShapeAttributes attrs = GMFGenFactory.eINSTANCE.createShapeAttributes();
			attrs.setLineStyle(((Shape) figure).getLineKind().getLiteral());
			attrs.setLineWidth(((Shape) figure).getLineWidth());
			v.getAttributes().add(attrs);
		}
	}

	private LinkDecoration from(DecorationFigure df) {
		LinkDecoration ld = GMFGenFactory.eINSTANCE.createLinkDecoration();
		ld.setFigureQualifiedClassName(qualifiedFigureName(df));
		return ld;
	}

	private String qualifiedFigureName(Figure fig) {
		return (String) myFiqureQualifiedNamesSwitch.doSwitch(fig);
	}

	private GenClass findRunTimeClass(NodeMapping nme) {
		return myDRTHelper.get(nme);
	}

	private GenClass findRunTimeClass(ChildNodeMapping childNodeMapping) {
		return myDRTHelper.get(childNodeMapping);
	}

	private GenClass findRunTimeClass(LinkMapping lme) {
		return myDRTHelper.get(lme);
	}

	private GenClass findRunTimeClass(CanvasMapping mapping) {
		return myDRTHelper.get(mapping);
	}

	private GenClass getChildContainerRunTimeClass() {
		return myDRTHelper.getChildContainerDefault();
	}

	private GenClass getNodeLabelRunTimeClass() {
		return myDRTHelper.getNodeLabelDefault();
	}

	private GenClass getLinkLabelRunTimeClass() {
		return myDRTHelper.getLinkLabelDefault();
	}

	private void handleNodeTool(AbstractNodeMapping nme, GenNode genNode) {
		if (nme.getTool() != null && nme.getTool() instanceof CreationTool) {
			// XXX handle other tool types (action, whatever)
			NodeEntry ne = GMFGenFactory.eINSTANCE.createNodeEntry();
			findToolGroup(nme.getTool()).getNodeTools().add(ne);
			ne.getGenNode().add(genNode);
			ne.setCreateMethodName(myNamingStrategy.createToolCreationMethodName(nme));
			setupCommonToolEntry(ne, nme.getTool(), nme.getDomainMetaClass().getName());
		}
	}

	private void setupCommonToolEntry(ToolEntry te, Tool tool, String elementName) {
		// FIXME need to change this once better tooling definition is in place. 
		te.setLargeIconPath(null);
		te.setSmallIconPath(null);
		te.setTitleKey(elementName);
		te.setDescriptionKey(elementName);
	}

	/**
	 * TODO initialize palette with set of groups known from Mapping. Perhaps, don't even 
	 * create missed group in that case.
	 */
	private ToolGroup findToolGroup(Tool tool) {
		assert tool.getGroup() != null;
		String groupName = tool.getGroup().getName() == null ? "" : tool.getGroup().getName();
		for (Iterator it = getGenPalette().getGroups().iterator(); it.hasNext();) {
			ToolGroup next = (ToolGroup) it.next();
			if (groupName.equals(next.getTitleKey())) {
				return next;
			}
		}
		ToolGroup tg = GMFGenFactory.eINSTANCE.createToolGroup();
		getGenPalette().getGroups().add(tg);
		tg.setTitleKey(groupName);
		tg.setCreateMethodName(myNamingStrategy.createToolGroupCreationMethodName(tool.getGroup()));
		return tg;
	}
	
	private void assertAbstractNodeMapping(AbstractNodeMapping mapping) {
		assert mapping.getDomainMetaClass() != null;
		assert checkDirectEditAttrValidity(mapping);
	}

	private boolean checkDirectEditAttrValidity(AbstractNodeMapping nme) {
		if (nme.getEditFeature() == null) {
			return true;
		}
		EClassifier attrContainer = nme.getEditFeature().getEContainingClass();
		return attrContainer == nme.getDomainMetaClass() || nme.getDomainMetaClass().getEAllSuperTypes().contains(attrContainer);
	}

	private GenPackage findGenPackage(EPackage ePackage) {
		return myGenModelMatch.findGenPackage(ePackage);
	}

	private GenClass findGenClass(EClass eClass) {
		return myGenModelMatch.findGenClass(eClass);
	}

	private GenFeature findGenFeature(EStructuralFeature feature) {
		return myGenModelMatch.findGenFeature(feature);
	}
	
	private TypeModelFacet createModelFacet(AbstractNodeMapping anm) {
		TypeModelFacet typeModelFacet = setupModelFacet(anm.getDomainMetaClass(), anm.getContainmentFeature(), null);
		return setupAux(typeModelFacet, anm.getDomainSpecialization(), anm.getDomainInitializer());
	}

	private LinkModelFacet createModelFacet(LinkMapping lme) {
		if (lme.getDomainMetaElement() != null) {
			TypeLinkModelFacet mf = GMFGenFactory.eINSTANCE.createTypeLinkModelFacet();
			mf.setMetaClass(findGenClass(lme.getDomainMetaClass()));
			mf.setContainmentMetaFeature(findGenFeature(lme.getContainmentFeature()));
			mf.setChildMetaFeature(mf.getContainmentMetaFeature());
			mf.setSourceMetaFeature(findGenFeature(lme.getSourceMetaFeature()));
			mf.setTargetMetaFeature(findGenFeature(lme.getLinkMetaFeature()));
			setupAux(mf, lme.getDomainSpecialization(), lme.getDomainInitializer());
			return mf;
		} else {
			FeatureModelFacet mf = GMFGenFactory.eINSTANCE.createFeatureModelFacet();
			mf.setMetaFeature(findGenFeature(lme.getLinkMetaFeature()));
			return mf;
		}
	}

	private GenLinkConstraints createLinkCreationConstraints(LinkConstraints constraints) {
		LinkMapping lme = constraints.getLinkMapping();
		if(lme == null) {
			return null;
		}				
		GenLinkConstraints genConstraints = GMFGenFactory.eINSTANCE.createGenLinkConstraints();
		Constraint sourceConstraint = constraints.getSourceEnd();
		if(sourceConstraint != null) {
			genConstraints.setSourceEnd(createExpression(sourceConstraint.getBody(), sourceConstraint.getLanguage()));
		}
		Constraint targetConstraint = constraints.getTargetEnd();
		if(targetConstraint != null) {
			genConstraints.setTargetEnd(createExpression(targetConstraint.getBody(), targetConstraint.getLanguage()));
		}		
		return genConstraints; 
	}

	private TypeModelFacet setupModelFacet(EClass domainMetaElement, EStructuralFeature containmentFeature, EStructuralFeature childFeature) {
		TypeModelFacet mf = GMFGenFactory.eINSTANCE.createTypeModelFacet();
		mf.setMetaClass(findGenClass(domainMetaElement));
		mf.setContainmentMetaFeature(findGenFeature(containmentFeature));
		mf.setChildMetaFeature(childFeature == null ? mf.getContainmentMetaFeature() : findGenFeature(childFeature));
		return mf;
	}

	/**
	 * @return typeModelFacet argument for convenience
	 */
	private TypeModelFacet setupAux(TypeModelFacet typeModelFacet, Constraint spec, ElementInitializer init) {
		// construct model element selector for domain EClass specializations if any exist
		if(spec != null) {
			typeModelFacet.setModelElementSelector(createModelElementSelector(spec));
		}
		if(init != null) {
			typeModelFacet.setModelElementInitializer(createElementInitializer(init));			
		}
		return typeModelFacet;
	}

	private GenElementInitializer createElementInitializer(ElementInitializer elementInitializer) {
		if(elementInitializer instanceof FeatureSeqInitializer) {
			FeatureSeqInitializer fsInitializer = (FeatureSeqInitializer) elementInitializer;
			GenFeatureSeqInitializer fSeqInitializer = GMFGenFactory.eINSTANCE.createGenFeatureSeqInitializer();
			
			for (Iterator it = fsInitializer.getInitializers().iterator(); it.hasNext();) {
				FeatureValueSpec nextValSpec = (FeatureValueSpec) it.next();
				
				GenFeatureValueSpec nextGenValSpec = GMFGenFactory.eINSTANCE.createGenFeatureValueSpec();				
				nextGenValSpec.setBody(nextValSpec.getBody());
				nextGenValSpec.setLanguage(nextValSpec.getLanguage());
				nextGenValSpec.setFeature(findGenFeature(nextValSpec.getFeature()));
				
				fSeqInitializer.getInitializers().add(nextGenValSpec);
			}
			return fSeqInitializer;
		}
		return null;
	}
	
	private ValueExpression createExpression(String body, String lang) {
		if(body == null) {
			return null;
		}
		ValueExpression valueExpression = GMFGenFactory.eINSTANCE.createValueExpression();
		valueExpression.setBody(body);
		valueExpression.setLanguage(lang);
		return valueExpression;
	}
	
	private static ModelElementSelector createModelElementSelector(Constraint metaElementConstraint) {
		ModelElementSelector modelElementSelector = GMFGenFactory.eINSTANCE.createModelElementSelector();
		modelElementSelector.setBody(metaElementConstraint.getBody());
		modelElementSelector.setLanguage(metaElementConstraint.getLanguage());		
		return modelElementSelector;
	}
}
