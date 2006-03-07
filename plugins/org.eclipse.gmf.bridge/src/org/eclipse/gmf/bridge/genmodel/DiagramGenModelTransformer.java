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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.codegen.gmfgen.CompositeFeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.EntryBase;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenAuditable;
import org.eclipse.gmf.codegen.gmfgen.GenAuditedMetricTarget;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenConstraint;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenDomainElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenElementInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureValueSpec;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkConstraints;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNotationElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenSeverity;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.LinkEntry;
import org.eclipse.gmf.codegen.gmfgen.LinkLabelAlignment;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.NodeEntry;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ProviderPriority;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.AlignmentFacet;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.internal.bridge.History;
import org.eclipse.gmf.internal.bridge.NaiveIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.VisualIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediator;
import org.eclipse.gmf.mappings.AuditContainer;
import org.eclipse.gmf.mappings.AuditRule;
import org.eclipse.gmf.mappings.Auditable;
import org.eclipse.gmf.mappings.AuditedMetricTarget;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.DiagramElementTarget;
import org.eclipse.gmf.mappings.DomainElementTarget;
import org.eclipse.gmf.mappings.ElementInitializer;
import org.eclipse.gmf.mappings.FeatureSeqInitializer;
import org.eclipse.gmf.mappings.FeatureValueSpec;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.LinkConstraints;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.MappingEntry;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.NodeReference;
import org.eclipse.gmf.mappings.NotationElementTarget;
import org.eclipse.gmf.mappings.Severity;
import org.eclipse.gmf.mappings.ToolOwner;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.eclipse.gmf.tooldef.AbstractTool;
import org.eclipse.gmf.tooldef.BundleImage;
import org.eclipse.gmf.tooldef.CreationTool;
import org.eclipse.gmf.tooldef.ToolContainer;

/**
 * Creates generation model from diagram definition.
 * @author artem
 */
public class DiagramGenModelTransformer extends MappingTransformer {

	private GenEditorGenerator myGenModel;
	protected GenModelMatcher myGenModelMatch;
	private final DiagramRunTimeModelHelper myDRTHelper;
	private final ViewmapProducer myViewmaps = new InnerClassViewmapProducer();
	private final VisualIdentifierDispenser myVisualIDs;
	private final History myHistory;

	private final GenModelNamingMediator myNamingStrategy;

	public DiagramGenModelTransformer(DiagramRunTimeModelHelper drtHelper, GenModelNamingMediator namingStrategy) {
		myDRTHelper = drtHelper;
		myNamingStrategy = namingStrategy;
		myVisualIDs = new NaiveIdentifierDispenser();
		myHistory = new History();
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

	public GenEditorGenerator getResult() {
		return getGenEssence();
	}

	private GenEditorGenerator getGenEssence() {
		if (myGenModel == null) {
			myGenModel = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		}
		// init editor as well - transformer does not set any property to it, just make sure it's not null
		if (myGenModel.getEditor() == null) {
			myGenModel.setEditor(GMFGenFactory.eINSTANCE.createGenEditorView());
		}
		return myGenModel;
	}

	private GenDiagram getGenDiagram() {
		if (getGenEssence().getDiagram() == null) {
			getGenEssence().setDiagram(GMFGenFactory.eINSTANCE.createGenDiagram());
		}
		return getGenEssence().getDiagram();
	}

	private GenPlugin getGenPlugin() {
		if (getGenEssence().getPlugin() == null) {
			getGenEssence().setPlugin(GMFGenFactory.eINSTANCE.createGenPlugin());
		}
		return getGenEssence().getPlugin();
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
		myHistory.purge();
		GenPackage primaryPackage = findGenPackage(mapping.getDomainModel());
		getGenEssence().setDomainGenModel(primaryPackage == null ? null : primaryPackage.getGenModel());
		if (getGenEssence().getDomainGenModel() != null) {
			getGenEssence().setModelID(getGenEssence().getDomainGenModel().getModelName());
		}
		getGenDiagram().setDomainDiagramElement(findGenClass(mapping.getDomainMetaElement()));
		getGenDiagram().setDiagramRunTimeClass(findRunTimeClass(mapping));
		getGenDiagram().setVisualID(myVisualIDs.get(getGenDiagram()));
		getGenPlugin().setName(mapping.getDomainModel().getName() + " Plugin");
		getGenDiagram().setViewmap(myViewmaps.create(mapping.getDiagramCanvas()));
		getGenDiagram().setIconProviderPriority(ProviderPriority.LOW_LITERAL); // override ElementTypeIconProvider

		// set class names
		myNamingStrategy.feed(getGenDiagram(), mapping);
	}

	protected void process(TopNodeReference topNode) {
		final NodeMapping nme = topNode.getChild();
		assert nme != null;
		assertNodeMapping(nme);
		
		GenTopLevelNode genNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		getGenDiagram().getTopLevelNodes().add(genNode);
		genNode.setDiagramRunTimeClass(findRunTimeClass(nme));
		genNode.setModelFacet(createModelFacet(topNode));
		genNode.setVisualID(myVisualIDs.get(genNode));
		genNode.setViewmap(myViewmaps.create(nme.getDiagramNode()));
		handleNodeTool(nme, genNode);

		// set class names
		myNamingStrategy.feed(genNode, nme);
		
		processAbstractNode(nme, genNode);
		myHistory.log(nme, genNode);
	}

	private void process(ChildReference childNodeRef, GenChildContainer container) {
		final NodeMapping childNodeMapping = childNodeRef.getChild();
		assert childNodeMapping != null;
		assertNodeMapping(childNodeMapping);
		assert childNodeMapping.getDiagramNode() != null;

		GenChildNode childNode;
		if (myHistory.isKnownChildNode(childNodeMapping)) {
			// we can't reuse top-level GenNodes
			childNode = myHistory.findChildNode(childNodeMapping);
		} else {
			childNode = GMFGenFactory.eINSTANCE.createGenChildNode();
			myHistory.log(childNodeMapping, childNode);
			getGenDiagram().getChildNodes().add(childNode);

			childNode.setModelFacet(createModelFacet(childNodeRef));
			
			childNode.setDiagramRunTimeClass(findRunTimeClass(childNodeMapping));
			childNode.setViewmap(myViewmaps.create(childNodeMapping.getDiagramNode()));
			childNode.setVisualID(myVisualIDs.get(childNode));

			// set class names
			myNamingStrategy.feed(childNode, childNodeMapping);

			handleNodeTool(childNodeMapping, childNode);
			processAbstractNode(childNodeMapping, childNode);
		}
		if (childNodeMapping.getChildren().size() > 0) {
			// TODO just layout from childNodeMapping.getDiagramNode()
			container.setListLayout(false);
		}
		container.getChildNodes().add(childNode);
	}
	
	private void processAbstractNode(NodeMapping mapping, GenNode genNode) {
		Map compartments2GenCompartmentsMap = new HashMap();
		for (Iterator it = mapping.getCompartments().iterator(); it.hasNext();) {
			CompartmentMapping compartmentMapping = (CompartmentMapping) it.next();
			GenCompartment compartmentGen = createGenCompartment(compartmentMapping);
			genNode.getCompartments().add(compartmentGen);
			compartments2GenCompartmentsMap.put(compartmentMapping, compartmentGen);
		}

		for (Iterator it = mapping.getChildren().iterator(); it.hasNext();) {
			ChildReference childNodeRef = (ChildReference) it.next();
// Currently childNodeMapping should has compartment but we plan to make this reference optional
			CompartmentMapping compartmentMapping = childNodeRef.getCompartment();
			GenChildContainer genChildContainer;
			if (compartmentMapping != null && compartments2GenCompartmentsMap.containsKey(compartmentMapping)) {
				genChildContainer = (GenChildContainer) compartments2GenCompartmentsMap.get(compartmentMapping);
			} else {
				genChildContainer = genNode;
			}
			process(childNodeRef, genChildContainer);
		}
		for (Iterator labels = mapping.getLabelMappings().iterator(); labels.hasNext();) {
			LabelMapping labelMapping = (LabelMapping) labels.next();
			GenNodeLabel label = createNodeLabel(genNode, labelMapping);

			// set class names
			myNamingStrategy.feed(label, labelMapping);

			genNode.getLabels().add(label);
		}
	}

	private GenCompartment createGenCompartment(CompartmentMapping mapping) {
		Compartment compartment = mapping.getCompartment(); 
		assert compartment != null;
		GenCompartment childCompartment = GMFGenFactory.eINSTANCE.createGenCompartment();
		getGenDiagram().getCompartments().add(childCompartment);
		childCompartment.setVisualID(myVisualIDs.get(childCompartment));
		childCompartment.setDiagramRunTimeClass(getChildContainerRunTimeClass());
		childCompartment.setViewmap(myViewmaps.create(mapping.getCompartment()));
		childCompartment.setCanCollapse(compartment.isCollapsible());
		childCompartment.setNeedsTitle(compartment.isNeedsTitle());
		childCompartment.setTitle(compartment.getName());

		// set class names
		myNamingStrategy.feed(childCompartment, mapping);

		return childCompartment;
	}

	protected void process(LinkMapping lme) {
		assertLinkMapping(lme);
		GenLink gl = GMFGenFactory.eINSTANCE.createGenLink();
		getGenDiagram().getLinks().add(gl);
		gl.setModelFacet(createModelFacet(lme));
		if (lme.getTool() instanceof CreationTool) {
			LinkEntry le = GMFGenFactory.eINSTANCE.createLinkEntry();
			le.setEntryID(myVisualIDs.get(le));
			findToolGroup(lme.getTool()).getLinkTools().add(le);
			le.getGenLink().add(gl);
			setupCommonToolEntry(le, lme.getTool());
		}
		for (Iterator labels = lme.getLabelMappings().iterator(); labels.hasNext();) {
			LabelMapping labelMapping = (LabelMapping) labels.next();
			GenLinkLabel label = createLinkLabel(gl, labelMapping);

			// set class names
			myNamingStrategy.feed(label, labelMapping);

			gl.getLabels().add(label);
		}
		gl.setDiagramRunTimeClass(findRunTimeClass(lme));
		gl.setVisualID(myVisualIDs.get(gl));

		// set class names
		myNamingStrategy.feed(gl, lme);

		gl.setViewmap(myViewmaps.create(lme.getDiagramLink()));

		if(lme.getCreationConstraints() != null) {
			gl.setCreationConstraints(createLinkCreationConstraints(lme.getCreationConstraints()));
		}
		
		myHistory.log(lme, gl);
	}

	private GenNodeLabel createNodeLabel(GenNode node, LabelMapping mapping) {
		GenNodeLabel label;
		if (mapping.getDiagramLabel().getFigure().getParent() == null) { // mapping.isExternal()
			label = GMFGenFactory.eINSTANCE.createGenExternalNodeLabel();
		} else {
			label = GMFGenFactory.eINSTANCE.createGenNodeLabel();
		}
		label.setVisualID(myVisualIDs.get(label));
		label.setDiagramRunTimeClass(findRunTimeClass(mapping));
		label.setViewmap(myViewmaps.create(mapping.getDiagramLabel()));
		label.setModelFacet(createLabelModelFacet(mapping));
		return label;
	}

	private GenLinkLabel createLinkLabel(GenLink link, LabelMapping mapping) {
		GenLinkLabel label = GMFGenFactory.eINSTANCE.createGenLinkLabel();
		label.setVisualID(myVisualIDs.get(label));
		label.setDiagramRunTimeClass(findRunTimeClass(mapping));
		label.setViewmap(myViewmaps.create(mapping.getDiagramLabel()));
		label.setModelFacet(createLabelModelFacet(mapping));
		if (mapping.getDiagramLabel().find(AlignmentFacet.class) != null) {
			AlignmentFacet af = (AlignmentFacet) mapping.getDiagramLabel().find(AlignmentFacet.class);
			label.setAlignment(getLinkLabelAlignment(af.getAlignment()));
		}
		return label;
	}

	private LinkLabelAlignment getLinkLabelAlignment(Alignment alignment) {
		switch (alignment.getValue()) {
		case Alignment.BEGINNING: return LinkLabelAlignment.SOURCE_LITERAL;
		case Alignment.CENTER: return LinkLabelAlignment.MIDDLE_LITERAL;
		case Alignment.END: return LinkLabelAlignment.TARGET_LITERAL;
		default: throw new IllegalArgumentException("Link doesn't support alignment:" + alignment.getName());
		}
	}

	private LabelModelFacet createLabelModelFacet(LabelMapping mapping) {
		if (mapping.getFeatures().size() == 1) {
			FeatureLabelModelFacet modelFacet = GMFGenFactory.eINSTANCE.createFeatureLabelModelFacet();
			modelFacet.setMetaFeature(findGenFeature((EAttribute) mapping.getFeatures().get(0)));
			modelFacet.setViewPattern(mapping.getViewPattern());
			modelFacet.setEditPattern(mapping.getEditPattern());
			return modelFacet;
		}
		if (mapping.getFeatures().size() > 1) {
			CompositeFeatureLabelModelFacet modelFacet = GMFGenFactory.eINSTANCE.createCompositeFeatureLabelModelFacet();
			for (Iterator features = mapping.getFeatures().iterator(); features.hasNext();) {
				modelFacet.getMetaFeatures().add(findGenFeature((EAttribute) features.next()));
			}
			modelFacet.setViewPattern(mapping.getViewPattern());
			modelFacet.setEditPattern(mapping.getEditPattern());
			return modelFacet;
		}
		return null;
	}

	private GenClass findRunTimeClass(NodeMapping nme) {
		return myDRTHelper.get(nme);
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

	private GenClass findRunTimeClass(LabelMapping mapping) {
		return myDRTHelper.get(mapping);
	}

	private void handleNodeTool(ToolOwner nme, GenNode genNode) {
		if (nme.getTool() != null && nme.getTool() instanceof CreationTool) {
			// XXX handle other tool types (action, whatever)
			NodeEntry ne = GMFGenFactory.eINSTANCE.createNodeEntry();
			ne.setEntryID(myVisualIDs.get(ne));
			findToolGroup(nme.getTool()).getNodeTools().add(ne);
			ne.getGenNode().add(genNode);
			setupCommonToolEntry(ne, nme.getTool());
		}
	}

	private void setupCommonToolEntry(EntryBase te, AbstractTool tool) {
		te.setTitleKey(tool.getTitle() == null ? "" : tool.getTitle()); // same at (*1*)
		te.setDescriptionKey(tool.getDescription());
		// FIXME need to change this once better tooling definition is in place. 
		if (tool.getLargeIcon() instanceof BundleImage) {
			// XXX assume same bundle
			te.setLargeIconPath(((BundleImage) tool.getLargeIcon()).getPath());
		}
		if (tool.getSmallIcon() instanceof BundleImage) {
			// XXX assume same bundle
			te.setSmallIconPath(((BundleImage) tool.getSmallIcon()).getPath());
		}
	}

	/**
	 * TODO initialize palette with set of groups known from Mapping. Perhaps, don't even 
	 * create missed group in that case.
	 * FIXME and don't rely on title as unique key
	 */
	private ToolGroup findToolGroup(AbstractTool tool) {
		assert tool.eContainer() != null;
		ToolContainer tc = (ToolContainer) tool.eContainer();
		String groupName = tc.getTitle() == null ? "" : tc.getTitle(); // same at (*1*)
		for (Iterator it = getGenPalette().getGroups().iterator(); it.hasNext();) {
			ToolGroup next = (ToolGroup) it.next();
			if (groupName.equals(next.getTitleKey())) {
				return next;
			}
		}
		ToolGroup tg = GMFGenFactory.eINSTANCE.createToolGroup();
		tg.setEntryID(myVisualIDs.get(tg));
		getGenPalette().getGroups().add(tg);
		setupCommonToolEntry(tg, tc);
		return tg;
	}
	
	private void assertNodeMapping(NodeMapping mapping) {
		assert mapping.getDomainContext() != null;
		assert mapping.getDiagramNode() != null;
		assert checkLabelMappings(mapping);
	}

	private void assertLinkMapping(LinkMapping linkMapping) {
		assert linkMapping.getDiagramLink() != null;
		if (linkMapping.getDomainMetaElement() != null) {
			assert linkMapping.getLinkMetaFeature() != null;
		}
		assert checkLabelMappings(linkMapping);
	}

	private static boolean checkLabelMappings(MappingEntry entry) {
		boolean ok = true;
		for (Iterator it = entry.getLabelMappings().iterator(); ok && it.hasNext();) {
			ok = checkLabelFeatureValidity((LabelMapping) it.next());
		}
		return ok;
	}

	private static boolean checkLabelFeatureValidity(LabelMapping labelMapping) {
		final EClass domainElement = labelMapping.getMapEntry().getDomainContext(); 
		boolean isOk = true;
		for (Iterator it = labelMapping.getFeatures().iterator(); isOk && it.hasNext(); ) {
			EClass attrContainer = ((EAttribute) it.next()).getEContainingClass();
			isOk = attrContainer.isSuperTypeOf(domainElement);
		}
		return isOk;
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
	
	private TypeModelFacet createModelFacet(NodeReference anm) {
		final NodeMapping nodeMapping = anm.getChild();
		TypeModelFacet typeModelFacet = setupModelFacet(nodeMapping.getDomainContext(), anm.getContainmentFeature(), anm.getChildrenFeature());
		return setupAux(typeModelFacet, nodeMapping.getDomainSpecialization(), nodeMapping.getDomainInitializer());
	}

	private LinkModelFacet createModelFacet(LinkMapping lme) {
		if (lme.getDomainMetaElement() != null) {
			TypeLinkModelFacet mf = GMFGenFactory.eINSTANCE.createTypeLinkModelFacet();
			mf.setMetaClass(findGenClass(lme.getDomainMetaElement()));
			mf.setContainmentMetaFeature(findGenFeature(lme.getContainmentFeature()));
			mf.setChildMetaFeature(mf.getContainmentMetaFeature());
			mf.setSourceMetaFeature(findGenFeature(lme.getSourceMetaFeature()));
			mf.setTargetMetaFeature(findGenFeature(lme.getLinkMetaFeature()));
			setupAux(mf, lme.getDomainSpecialization(), lme.getDomainInitializer());
			return mf;
		} else if (lme.getLinkMetaFeature() != null) {
			FeatureLinkModelFacet mf = GMFGenFactory.eINSTANCE.createFeatureLinkModelFacet();
			mf.setMetaFeature(findGenFeature(lme.getLinkMetaFeature()));
			return mf;
		}
		return null; // notation link
	}

	private GenLinkConstraints createLinkCreationConstraints(LinkConstraints constraints) {
		LinkMapping lme = constraints.getLinkMapping();
		if(lme == null) {
			return null;
		}				
		GenLinkConstraints genConstraints = GMFGenFactory.eINSTANCE.createGenLinkConstraints();
		Constraint sourceConstraint = constraints.getSourceEnd();
		if(sourceConstraint != null) {
			genConstraints.setSourceEnd(createGenConstraint(sourceConstraint));
		}
		Constraint targetConstraint = constraints.getTargetEnd();
		if(targetConstraint != null) {
			genConstraints.setTargetEnd(createGenConstraint(targetConstraint));
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
			typeModelFacet.setModelElementSelector(createGenConstraint(spec));
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
	

	private GenConstraint createGenConstraint(Constraint constraint) {
		if(constraint.getBody() == null) {
			return null;
		}
		GenConstraint modelElementSelector = GMFGenFactory.eINSTANCE.createGenConstraint();
		modelElementSelector.setBody(constraint.getBody());
		modelElementSelector.setLanguage(constraint.getLanguage());		
		return modelElementSelector;
	}
	
	private GenAuditContainer createGenAuditContainer(AuditContainer ac) {
		GenAuditContainer gac = GMFGenFactory.eINSTANCE.createGenAuditContainer();
		gac.setId(ac.getId());
		gac.setName(ac.getName());
		gac.setDescription(ac.getDescription());
		for(Iterator it = ac.getChildContainers().iterator(); it.hasNext();) {
			AuditContainer nextChild = (AuditContainer) it.next();
			gac.getChildContainers().add(createGenAuditContainer(nextChild));
		}
		for (Iterator it = ac.getAudits().iterator(); it.hasNext();) {
			gac.getAudits().add(createGenAudit((AuditRule) it.next()));
		}
		return gac;
	}
	
	private GenAuditRule createGenAudit(AuditRule audit) {
		GenAuditRule genAudit = GMFGenFactory.eINSTANCE.createGenAuditRule();
		genAudit.setId(audit.getId());
		genAudit.setName(audit.getName());
		genAudit.setMessage(audit.getMessage());
		genAudit.setDescription(audit.getDescription());
		genAudit.setUseInLiveMode(audit.isUseInLiveMode());
		
		if(audit.getTarget() != null) {
			genAudit.setTarget(createRuleTarget(audit.getTarget()));
		}
		Constraint rule = audit.getRule();
		if(rule != null) {
			genAudit.setRule(createGenConstraint(rule));
		}

		Severity severity = audit.getSeverity();
		GenSeverity genSeverity = null;
		if(severity == Severity.INFO_LITERAL) {
			genSeverity = GenSeverity.INFO_LITERAL;
		} else if(severity == Severity.WARNING_LITERAL) {
			genSeverity = GenSeverity.WARNING_LITERAL;
		} else if(severity == Severity.ERROR_LITERAL) {
			genSeverity = GenSeverity.ERROR_LITERAL;
		}
		if(genSeverity != null) {
			genAudit.setSeverity(genSeverity);
		}
		return genAudit;
	} 
	
	private GenAuditable createRuleTarget(Auditable ruleTarget) {		
		if (ruleTarget instanceof DomainElementTarget) {
			DomainElementTarget domainTarget = (DomainElementTarget)ruleTarget;
			GenDomainElementTarget genDomainTarget = GMFGenFactory.eINSTANCE.createGenDomainElementTarget();
			genDomainTarget.setElement(domainTarget.getElement() != null ? findGenClass(domainTarget.getElement()) : null);
			return genDomainTarget;
		} else if (ruleTarget instanceof NotationElementTarget) {
			NotationElementTarget notationTarget = (NotationElementTarget) ruleTarget;
			GenNotationElementTarget genNotationTarget = GMFGenFactory.eINSTANCE.createGenNotationElementTarget();
			genNotationTarget.setElement(notationTarget.getElement() != null ? findGenClass(notationTarget.getElement()) : null);
			return genNotationTarget;

		} else if (ruleTarget instanceof DiagramElementTarget) {
			GenDiagramElementTarget diagramTarget = GMFGenFactory.eINSTANCE.createGenDiagramElementTarget();
			MappingEntry mappingEntry = ((DiagramElementTarget) ruleTarget).getElement();
			if (mappingEntry != null) {
				GenCommonBase genBase = null;
				LinkMapping lm = mappingEntry instanceof LinkMapping ? (LinkMapping) mappingEntry : null;
				if (lm != null) {
					genBase = myHistory.find(lm);
				} else {
					NodeMapping nm = mappingEntry instanceof NodeMapping ? (NodeMapping) mappingEntry : null;
					genBase = myHistory.find(nm);
				}
				
				assert genBase != null;				
				diagramTarget.setElement(genBase);
			}
			return diagramTarget;
		} else if(ruleTarget instanceof AuditedMetricTarget) {			
			GenAuditedMetricTarget genMetricTarget = GMFGenFactory.eINSTANCE.createGenAuditedMetricTarget();
			// TODO - no metrics logged in History return not initialized entity
			return genMetricTarget;
		} else {
			assert false : "Uknown rule target type"; //$NON-NLS-1$
		}
		return null;
	}

	protected void process(AuditContainer audits) {
		if(audits != null) {
			getGenEssence().setAudits(createGenAuditContainer(audits));	
		}
	}
}
