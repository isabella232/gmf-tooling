/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.sketch.transformer;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenCustomPropertyTab;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramUpdater;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenEditorView;
import org.eclipse.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenPropertySheet;
import org.eclipse.gmf.codegen.gmfgen.GenPropertyTab;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.SpecializationType;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeTabFilter;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelMatcher;
import org.eclipse.gmf.internal.bridge.genmodel.RuntimeGenModelAccess;
import org.eclipse.gmf.internal.common.reconcile.Reconciler;
import org.eclipse.gmf.internal.sketch.transformer.reconcile.SketchReconcilerConfig;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.sketch.SketchCompartment;
import org.eclipse.gmf.sketch.SketchDiagram;
import org.eclipse.gmf.sketch.SketchDiagramElement;
import org.eclipse.gmf.sketch.SketchLabel;
import org.eclipse.gmf.sketch.SketchLink;
import org.eclipse.gmf.sketch.SketchNode;
import org.eclipse.jface.operation.IRunnableWithProgress;

/**
 * @author dstadnik
 */
public class SketchTransformer implements IRunnableWithProgress {

	private SketchDiagram diagram;

	private GenEditorGenerator editorGen;

	private IStatus status;

	private Map<SketchNode, GenNode> boundNodes = new HashMap<SketchNode, GenNode>();

	private Map<SketchCompartment, GenCompartment> boundCompartments = new HashMap<SketchCompartment, GenCompartment>();

	private Map<EClass, MetamodelType> boundMetamodelTypes = new HashMap<EClass, MetamodelType>();

	private GenModelMatcher genModelMatcher;

	private GenClass ntDiagram;

	private GenClass ntNode;

	private GenClass ntEdge;

	private VisualIDsDispenser visualIDsDispenser;

	private NamesHelper namesHelper = new NamesHelper();

	public SketchTransformer(SketchDiagram diagram, GenModel genModel) {
		assert diagram != null;
		this.diagram = diagram;
		if (genModel != null) {
			this.genModelMatcher = new GenModelMatcher(genModel);
		}
		initNotationModel();
		visualIDsDispenser = new VisualIDsDispenser(diagram);
	}

	protected void initNotationModel() {
		RuntimeGenModelAccess runtimeAccess = new RuntimeGenModelAccess();
		runtimeAccess.ensure();
		GenPackage gp = runtimeAccess.genPackage();
		for (GenClass genClass : gp.getGenClasses()) {
			if (NotationPackage.eINSTANCE.getNode().getName().equals(genClass.getName())) {
				ntNode = genClass;
			} else if (NotationPackage.eINSTANCE.getEdge().getName().equals(genClass.getName())) {
				ntEdge = genClass;
			} else if (NotationPackage.eINSTANCE.getDiagram().getName().equals(genClass.getName())) {
				ntDiagram = genClass;
			}
		}
		assert ntDiagram != null;
		assert ntNode != null;
		assert ntEdge != null;
	}

	public final SketchDiagram getSource() {
		return diagram;
	}

	public final IStatus getStatus() {
		return status;
	}

	public final GenEditorGenerator getResult() {
		return editorGen;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		if (diagram == null) {
			status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.SketchTransformer_NoCanvas);
			return;
		}
		try {
			transformSketch();
		} finally {
			boundNodes.clear();
			boundCompartments.clear();
			boundMetamodelTypes.clear();
		}
		status = Status.OK_STATUS;
	}

	public void reconcile(GenEditorGenerator existingEditorGen) {
		new Reconciler(new SketchReconcilerConfig()).reconcileTree(editorGen, existingEditorGen);
	}

	protected void transformSketch() {
		createEditor();
		for (SketchNode node : boundNodes.keySet()) {
			if (!node.getReferencedNodes().isEmpty()) {
				addReferencedNodes(boundNodes.get(node), node.getReferencedNodes());
			}
		}
		for (SketchCompartment compartment : boundCompartments.keySet()) {
			if (!compartment.getReferencedNodes().isEmpty()) {
				addReferencedNodes(boundCompartments.get(compartment), compartment.getReferencedNodes());
			}
		}
	}

	protected void addReferencedNodes(GenChildContainer genContainer, List<SketchNode> referencedNodes) {
		for (SketchNode referencedNode : referencedNodes) {
			GenNode referencedGenNode = boundNodes.get(referencedNode);
			if (referencedGenNode == null) {
				Activator.logWarning(Messages.SketchTransformer_RefNodeNotResolved);
				continue;
			}
			if (!(referencedGenNode instanceof GenChildNode)) {
				Activator.logWarning(Messages.SketchTransformer_RefNodeNotChild);
			}
			genContainer.getChildNodes().add((GenChildNode) referencedGenNode);
		}
	}

	protected void createEditor() {
		editorGen = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		if (genModelMatcher != null) {
			editorGen.setDomainGenModel(genModelMatcher.getGenModel());
		}
		createDiagram();
		GenPlugin plugin = GMFGenFactory.eINSTANCE.createGenPlugin();
		editorGen.setPlugin(plugin);
		GenEditorView view = GMFGenFactory.eINSTANCE.createGenEditorView();
		editorGen.setEditor(view);
		GenDiagramUpdater updater = GMFGenFactory.eINSTANCE.createGenDiagramUpdater();
		editorGen.setDiagramUpdater(updater);
		createProperties();
	}

	protected void createProperties() {
		GenPropertySheet properties = GMFGenFactory.eINSTANCE.createGenPropertySheet();
		editorGen.setPropertySheet(properties);
		GenPropertyTab tabAppearance = GMFGenFactory.eINSTANCE.createGenStandardPropertyTab();
		tabAppearance.setID("appearance"); //$NON-NLS-1$
		tabAppearance.setLabel("Appearance"); //$NON-NLS-1$
		properties.getTabs().add(tabAppearance);
		GenPropertyTab tabGridRulers = GMFGenFactory.eINSTANCE.createGenStandardPropertyTab();
		tabGridRulers.setID("diagram"); //$NON-NLS-1$
		tabGridRulers.setLabel("Rulers & Grid"); //$NON-NLS-1$
		properties.getTabs().add(tabGridRulers);
		GenCustomPropertyTab tabDomainModel = GMFGenFactory.eINSTANCE.createGenCustomPropertyTab();
		tabDomainModel.setID("domain_model"); //$NON-NLS-1$
		tabDomainModel.setLabel("Domain Model"); //$NON-NLS-1$
		properties.getTabs().add(tabDomainModel);
		TypeTabFilter filter = GMFGenFactory.eINSTANCE.createTypeTabFilter();
		filter.getTypes().add("org.eclipse.gef.EditPart"); //$NON-NLS-1$
		filter.getTypes().add("org.eclipse.gmf.runtime.notation.View"); //$NON-NLS-1$
		tabDomainModel.setFilter(filter);
	}

	protected void createDiagram() {
		GenDiagram genDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		genDiagram.setDiagramRunTimeClass(ntDiagram);
		genDiagram.setViewmap(createViewmap(diagram.getShape(), genDiagram));
		EClass type = diagram.getType();
		ElementType elementType;
		if (type != null) {
			elementType = GMFGenFactory.eINSTANCE.createMetamodelType();
			genDiagram.setDomainDiagramElement(genModelMatcher.findGenClass(type));
			boundMetamodelTypes.put(type, (MetamodelType) elementType);
		} else {
			elementType = GMFGenFactory.eINSTANCE.createNotationType();
		}
		genDiagram.setElementType(elementType);
		genDiagram.setVisualID(visualIDsDispenser.get(diagram));
		namesHelper.fix(genDiagram, diagram.getName());
		editorGen.setDiagram(genDiagram);
		Palette palette = GMFGenFactory.eINSTANCE.createPalette();
		genDiagram.setPalette(palette);
		ToolGroup group = GMFGenFactory.eINSTANCE.createToolGroup();
		String groupTitle = diagram.getName();
		if (groupTitle == null && type != null) {
			groupTitle = type.getName();
		}
		group.setTitle(groupTitle);
		palette.getGroups().add(group);
		for (SketchNode node : diagram.getNodes()) {
			createNode(node, group);
		}
		for (SketchLink link : diagram.getLinks()) {
			createLink(link, group);
		}
	}

	protected void createNode(SketchNode node, ToolGroup group) {
		GenTopLevelNode genNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		editorGen.getDiagram().getTopLevelNodes().add(genNode);
		if (!node.getAttributes().isEmpty()) {
			Activator.logWarning(Messages.SketchTransformer_TopNodeAttrsIgnored);
		}
		if (node.isOnBorder()) {
			Activator.logWarning(Messages.SketchTransformer_TopNodeOnBorder);
		}
		createNodeHelper(node, group, genNode, diagram.getType());
	}

	protected void createChildNode(SketchNode node, ToolGroup group, GenChildContainer genContainer, EClass containerType) {
		GenChildNode genNode;
		if (!node.getAttributes().isEmpty()) {
			genNode = GMFGenFactory.eINSTANCE.createGenChildLabelNode();
			((GenChildLabelNode) genNode).setLabelModelFacet(createFeatureLabelModelFacet(node.getAttributes()));
		} else if (node.isOnBorder()) {
			genNode = GMFGenFactory.eINSTANCE.createGenChildSideAffixedNode();
		} else {
			genNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		}
		editorGen.getDiagram().getChildNodes().add(genNode);
		genContainer.getChildNodes().add(genNode);
		createNodeHelper(node, group, genNode, containerType);
	}

	protected void createNodeHelper(SketchNode node, ToolGroup group, GenNode genNode, EClass containerType) {
		genNode.setDiagramRunTimeClass(ntNode);
		genNode.setViewmap(createViewmap(node.getShape(), genNode));
		EClass type = node.getType();
		ElementType elementType;
		if (type != null) {
			elementType = createElementType(type);
			TypeModelFacet modelFacet = GMFGenFactory.eINSTANCE.createTypeModelFacet();
			modelFacet.setMetaClass(genModelMatcher.findGenClass(type));
			if (containerType != null) {
				EReference containmentRef = findReference(containerType, type, true);
				modelFacet.setContainmentMetaFeature(genModelMatcher.findGenFeature(containmentRef));
			}
			genNode.setModelFacet(modelFacet);
		} else {
			elementType = GMFGenFactory.eINSTANCE.createNotationType();
		}
		genNode.setElementType(elementType);
		genNode.setVisualID(visualIDsDispenser.get(node));
		namesHelper.fix(genNode, node.getName());
		boundNodes.put(node, genNode);
		ToolEntry tool = addTool(node, group);
		tool.getGenNodes().add(genNode);
		if (tool.getTitle() == null) {
			tool.setTitle(type != null ? type.getName() : "Node" + genNode.getVisualID()); //$NON-NLS-1$
		}
		for (SketchNode childNode : node.getNodes()) {
			createChildNode(childNode, group, genNode, type);
		}
		for (SketchCompartment compartment : node.getCompartments()) {
			createCompartment(compartment, group, genNode, type);
		}
		if (!(genNode instanceof GenChildLabelNode)) {
			for (SketchLabel label : node.getLabels()) {
				GenNodeLabel genLabel = label.isExternal() ? GMFGenFactory.eINSTANCE.createGenExternalNodeLabel() : GMFGenFactory.eINSTANCE.createGenNodeLabel();
				initLabel(label, genLabel);
				genNode.getLabels().add(genLabel);
			}
		}
	}

	protected void createCompartment(SketchCompartment compartment, ToolGroup group, GenNode parentGenNode, EClass containerType) {
		GenCompartment genCompartment = GMFGenFactory.eINSTANCE.createGenCompartment();
		genCompartment.setDiagramRunTimeClass(ntNode);
		genCompartment.setViewmap(createViewmap(compartment.getShape(), genCompartment));
		genCompartment.setVisualID(visualIDsDispenser.get(compartment));
		namesHelper.fix(genCompartment, compartment.getName());
		editorGen.getDiagram().getCompartments().add(genCompartment);
		parentGenNode.getCompartments().add(genCompartment);
		boundCompartments.put(compartment, genCompartment);
		for (SketchNode childNode : compartment.getNodes()) {
			createChildNode(childNode, group, genCompartment, containerType);
		}
	}

	protected void createLink(SketchLink link, ToolGroup group) {
		if (link.getSource() == null) {
			Activator.logWarning(Messages.SketchTransformer_NoLinkSource);
			return;
		}
		if (link.getTarget() == null) {
			Activator.logWarning(Messages.SketchTransformer_NoLinkTarget);
			return;
		}
		GenLink genLink = GMFGenFactory.eINSTANCE.createGenLink();
		genLink.setDiagramRunTimeClass(ntEdge);
		genLink.setViewmap(createViewmap(link.getShape(), genLink));
		EClass sourceType = link.getSource().getType();
		EClass targetType = link.getTarget().getType();
		EClass type = link.getType();
		ElementType elementType;
		if (type != null) {
			// class-based link
			elementType = createElementType(type);
			TypeLinkModelFacet modelFacet = GMFGenFactory.eINSTANCE.createTypeLinkModelFacet();
			modelFacet.setMetaClass(genModelMatcher.findGenClass(type));
			for (EObject element = link.getSource();; element = element.eContainer()) {
				EClass containerType = null;
				if (element instanceof SketchNode) {
					containerType = ((SketchNode) element).getType();
				} else if (element instanceof SketchDiagram) {
					containerType = ((SketchDiagram) element).getType();
				} else {
					break;
				}
				if (containerType != null) {
					EReference containmentReference = findReference(containerType, type, true);
					if (containmentReference != null) {
						modelFacet.setContainmentMetaFeature(genModelMatcher.findGenFeature(containmentReference));
						break;
					}
				}
			}
			if (sourceType != null) {
				EReference sourceReference = findReference(type, sourceType, false);
				modelFacet.setSourceMetaFeature(genModelMatcher.findGenFeature(sourceReference));
			}
			if (targetType != null) {
				EReference targetReference = findReference(type, targetType, false);
				modelFacet.setTargetMetaFeature(genModelMatcher.findGenFeature(targetReference));
			}
			genLink.setModelFacet(modelFacet);
		} else {
			if (sourceType != null && targetType != null) {
				// ref-based link
				EReference linkReference = findReference(sourceType, targetType, false);
				if (linkReference != null) {
					elementType = GMFGenFactory.eINSTANCE.createSpecializationType();
					FeatureLinkModelFacet modelFacet = GMFGenFactory.eINSTANCE.createFeatureLinkModelFacet();
					modelFacet.setMetaFeature(genModelMatcher.findGenFeature(linkReference));
					genLink.setModelFacet(modelFacet);
				} else {
					elementType = GMFGenFactory.eINSTANCE.createNotationType();
				}
			} else {
				elementType = GMFGenFactory.eINSTANCE.createNotationType();
			}
		}
		genLink.setElementType(elementType);
		genLink.setVisualID(visualIDsDispenser.get(link));
		namesHelper.fix(genLink, link.getName());
		ToolEntry tool = addTool(link, group);
		tool.getGenLinks().add(genLink);
		if (tool.getTitle() == null) {
			tool.setTitle(type != null ? type.getName() : "Link" + genLink.getVisualID()); //$NON-NLS-1$
		}
		editorGen.getDiagram().getLinks().add(genLink);
		for (SketchLabel label : link.getLabels()) {
			GenLinkLabel genLabel = GMFGenFactory.eINSTANCE.createGenLinkLabel();
			initLabel(label, genLabel);
			genLink.getLabels().add(genLabel);
		}
	}

	protected void initLabel(SketchLabel label, GenLabel genLabel) {
		genLabel.setDiagramRunTimeClass(ntNode);
		genLabel.setViewmap(createViewmap(label.getShape(), genLabel));
		genLabel.setVisualID(visualIDsDispenser.get(label));
		namesHelper.fix(genLabel, label.getName());
		if (!label.getAttributes().isEmpty()) {
			genLabel.setModelFacet(createFeatureLabelModelFacet(label.getAttributes()));
		}
	}

	protected FeatureLabelModelFacet createFeatureLabelModelFacet(List<EAttribute> attributes) {
		FeatureLabelModelFacet labelFacet = GMFGenFactory.eINSTANCE.createFeatureLabelModelFacet();
		for (EAttribute attribute : attributes) {
			GenFeature genFeature = genModelMatcher.findGenFeature(attribute);
			if (genFeature != null) {
				labelFacet.getMetaFeatures().add(genFeature);
			} else {
				Activator.logWarning(String.format(Messages.SketchTransformer_NoGenFeatureForAttr, attribute.getName()));
			}
		}
		return labelFacet;
	}

	protected ElementType createElementType(EClass type) {
		if (boundMetamodelTypes.containsKey(type)) {
			SpecializationType elementType = GMFGenFactory.eINSTANCE.createSpecializationType();
			elementType.setMetamodelType(boundMetamodelTypes.get(type));
			return elementType;
		} else {
			MetamodelType elementType = GMFGenFactory.eINSTANCE.createMetamodelType();
			boundMetamodelTypes.put(type, elementType);
			return elementType;
		}
	}

	protected ToolEntry addTool(SketchDiagramElement element, ToolGroup group) {
		ToolEntry tool = GMFGenFactory.eINSTANCE.createToolEntry();
		if (element.getName() != null) {
			tool.setTitle(element.getName());
		}
		group.getEntries().add(tool);
		return tool;
	}

	protected EReference findReference(EClass container, EClass type, boolean containment) {
		EReference bestRef = null;
		for (EReference ref : container.getEAllReferences()) {
			if (ref.isContainment() != containment) {
				continue;
			}
			if (ref.getEReferenceType() == type) {
				return ref; // perfect match
			}
			if (ref.getEReferenceType().isSuperTypeOf(type)) {
				bestRef = ref;
			}
		}
		return bestRef;
	}

	protected FigureViewmap createViewmap(String shape, GenCommonBase genElement) {
		FigureViewmap viewmap = GMFGenFactory.eINSTANCE.createFigureViewmap();
		viewmap.setFigureQualifiedClassName(shape == null ? getDefaultShape(genElement) : shape);
		return viewmap;
	}

	protected String getDefaultShape(GenCommonBase genElement) {
		if (genElement instanceof GenDiagram) {
			return "org.eclipse.draw2d.FreeformLayer"; //$NON-NLS-1$
		} else if (genElement instanceof GenChildLabelNode || genElement instanceof GenLabel) {
			return "org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"; //$NON-NLS-1$
		} else if (genElement instanceof GenNode || genElement instanceof GenCompartment) {
			return "org.eclipse.draw2d.RectangleFigure"; //$NON-NLS-1$
		} else if (genElement instanceof GenLink) {
			return "org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx"; //$NON-NLS-1$
		}
		return "org.eclipse.draw2d.Figure"; //$NON-NLS-1$
	}
}
