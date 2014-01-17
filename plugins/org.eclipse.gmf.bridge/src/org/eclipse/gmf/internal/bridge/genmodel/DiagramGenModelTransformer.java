/*
 * Copyright (c) 2005, 2010, 2013 Borland Software Corporation, Montages AG 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #403577, [optionally] avoid GenTopLevelNode / GenChildNode separation
 */
package org.eclipse.gmf.internal.bridge.genmodel;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.codegen.gmfgen.DesignLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.ExpressionLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ExpressionLabelParser;
import org.eclipse.gmf.codegen.gmfgen.ExternalParser;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenActionFactoryContributionItem;
import org.eclipse.gmf.codegen.gmfgen.GenApplication;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContext;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenAuditable;
import org.eclipse.gmf.codegen.gmfgen.GenAuditedMetricTarget;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenChildNodeBase;
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenConstraint;
import org.eclipse.gmf.codegen.gmfgen.GenContextMenu;
import org.eclipse.gmf.codegen.gmfgen.GenContributionItem;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenDomainAttributeTarget;
import org.eclipse.gmf.codegen.gmfgen.GenDomainElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenElementInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureValueSpec;
import org.eclipse.gmf.codegen.gmfgen.GenGroupMarker;
import org.eclipse.gmf.codegen.gmfgen.GenLanguage;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkConstraints;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenMeasurable;
import org.eclipse.gmf.codegen.gmfgen.GenMenuManager;
import org.eclipse.gmf.codegen.gmfgen.GenMetricContainer;
import org.eclipse.gmf.codegen.gmfgen.GenMetricRule;
import org.eclipse.gmf.codegen.gmfgen.GenNavigator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNotationElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenParserImplementation;
import org.eclipse.gmf.codegen.gmfgen.GenParsers;
import org.eclipse.gmf.codegen.gmfgen.GenPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.GenPropertySheet;
import org.eclipse.gmf.codegen.gmfgen.GenReferenceNewElementSpec;
import org.eclipse.gmf.codegen.gmfgen.GenRuleTarget;
import org.eclipse.gmf.codegen.gmfgen.GenSeparator;
import org.eclipse.gmf.codegen.gmfgen.GenSeverity;
import org.eclipse.gmf.codegen.gmfgen.GenSharedContributionItem;
import org.eclipse.gmf.codegen.gmfgen.GenStandardPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.GenToolBarManager;
import org.eclipse.gmf.codegen.gmfgen.GenVisualEffect;
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.LabelOffsetAttributes;
import org.eclipse.gmf.codegen.gmfgen.LabelTextAccessMethod;
import org.eclipse.gmf.codegen.gmfgen.LinkLabelAlignment;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.OclChoiceParser;
import org.eclipse.gmf.codegen.gmfgen.OpenDiagramBehaviour;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.PredefinedEnumParser;
import org.eclipse.gmf.codegen.gmfgen.PredefinedParser;
import org.eclipse.gmf.codegen.gmfgen.ProviderPriority;
import org.eclipse.gmf.codegen.gmfgen.SpecializationType;
import org.eclipse.gmf.codegen.gmfgen.StandardPreferencePages;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ValueExpression;
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.AlignmentFacet;
import org.eclipse.gmf.gmfgraph.ChildAccess;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.Direction;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.FigureRef;
import org.eclipse.gmf.gmfgraph.LabelOffsetFacet;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.Pin;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.gmfgraph.VisualFacet;
import org.eclipse.gmf.internal.bridge.BridgeFactoryGate;
import org.eclipse.gmf.internal.bridge.DistinctTopLevelNodesFactoryGate;
import org.eclipse.gmf.internal.bridge.Knowledge;
import org.eclipse.gmf.internal.bridge.NaiveIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.VisualIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.genmodel.navigator.NavigatorHandler;
import org.eclipse.gmf.internal.bridge.tooldef.PaletteHandler;
import org.eclipse.gmf.internal.codegen.util.Extras;
import org.eclipse.gmf.mappings.AuditContainer;
import org.eclipse.gmf.mappings.AuditRule;
import org.eclipse.gmf.mappings.AuditedMetricTarget;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.DesignLabelMapping;
import org.eclipse.gmf.mappings.DiagramElementTarget;
import org.eclipse.gmf.mappings.DomainAttributeTarget;
import org.eclipse.gmf.mappings.DomainElementTarget;
import org.eclipse.gmf.mappings.ElementInitializer;
import org.eclipse.gmf.mappings.ExpressionLabelMapping;
import org.eclipse.gmf.mappings.FeatureInitializer;
import org.eclipse.gmf.mappings.FeatureLabelMapping;
import org.eclipse.gmf.mappings.FeatureSeqInitializer;
import org.eclipse.gmf.mappings.FeatureValueSpec;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.Language;
import org.eclipse.gmf.mappings.LinkConstraints;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.MappingEntry;
import org.eclipse.gmf.mappings.MetricContainer;
import org.eclipse.gmf.mappings.MetricRule;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.NodeReference;
import org.eclipse.gmf.mappings.NotationElementTarget;
import org.eclipse.gmf.mappings.OclChoiceLabelMapping;
import org.eclipse.gmf.mappings.ReferenceNewElementSpec;
import org.eclipse.gmf.mappings.Severity;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.eclipse.gmf.mappings.VisualEffectMapping;

/**
 * Creates generation model from diagram definition.
 * 
 * @author artem
 */
public class DiagramGenModelTransformer extends MappingTransformer {

	private GenEditorGenerator myGenModel;

	protected GenModelMatcher myGenModelMatch;

	private final DiagramRunTimeModelHelper myDRTHelper;

	private final ViewmapProducer myViewmaps;

	private final VisualIdentifierDispenser myVisualIDs;

	private final boolean rcp;

	private final BridgeFactoryGate myFactoryGate;

	private final Map<GenClass, ElementType> myProcessedTypes = new IdentityHashMap<GenClass, ElementType>(); // GenClass -> MetamodelType

	private final Map<org.eclipse.gmf.mappings.ValueExpression, ValueExpression> myProcessedExpressions;

	private final PaletteHandler myPaletteProcessor;

	private final NavigatorHandler myNavigatorProcessor;

	private final PropertySheetHandler myPropertySheetProcessor;

	private final EcoreGenModelMatcher myEcoreGenModelMatch;

	private ExternalParser myDesignLabelParser;

	private ExternalParser myAuxParser;

	private GenContextMenu myDiagramContextMenu;

	private GenAuditContext myDefaultAuditContext;

	public static class Parameters {

		public final DiagramRunTimeModelHelper diagramModelHelper;

		public final ViewmapProducer viewmaps;

		public final VisualIdentifierDispenser vidDispenser;

		public final boolean rcp;

		public Parameters(DiagramRunTimeModelHelper drtHelper, ViewmapProducer viewmaps, VisualIdentifierDispenser vidDispenser, boolean rcp) {
			diagramModelHelper = drtHelper;
			this.viewmaps = viewmaps;
			this.vidDispenser = vidDispenser;
			this.rcp = rcp;
		}
	}

	public DiagramGenModelTransformer() {
		this(new BasicDiagramRunTimeModelHelper());
	}

	public DiagramGenModelTransformer(DiagramRunTimeModelHelper drtHelper) {
		this(new Parameters(drtHelper, new InnerClassViewmapProducer(), new NaiveIdentifierDispenser(), false));
	}

	public DiagramGenModelTransformer(Parameters opts) {
		this(opts.diagramModelHelper, opts.viewmaps, opts.vidDispenser, opts.rcp);
	}

	private DiagramGenModelTransformer(DiagramRunTimeModelHelper drtHelper, ViewmapProducer viewmaps, VisualIdentifierDispenser visualIdD, boolean rcp) {
		assert drtHelper != null && viewmaps != null;
		myDRTHelper = drtHelper;
		myViewmaps = viewmaps;
		myVisualIDs = visualIdD;
		this.rcp = rcp;
		myFactoryGate = new DistinctTopLevelNodesFactoryGate();
		myPaletteProcessor = new PaletteHandler();
		myNavigatorProcessor = new NavigatorHandler();
		myPropertySheetProcessor = new PropertySheetHandler();
		myEcoreGenModelMatch = new EcoreGenModelMatcher();
		myProcessedExpressions = new HashMap<org.eclipse.gmf.mappings.ValueExpression, ValueExpression>();
	}

	/**
	 * Optionally set GenModel to match ECore elements against. Should be
	 * invoked prior to {@link MappingTransformer#transform(Mapping)}, otherwise
	 * has no effect. Useful for tests (and other cases) when GenModel is not
	 * known to EMF (and thus can't be obtained using EMF techniques).
	 * 
	 * @param emfGenModel
	 *            EMF GenModel for domain model
	 */
	public void setEMFGenModel(GenModel emfGenModel) {
		myGenModelMatch = new GenModelMatcher(emfGenModel);
	}

	public GenEditorGenerator getResult() {
		return getGenEssence();
	}

	public BridgeFactoryGate getTrace() {
		return myFactoryGate;
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

	private void initGenPlugin() {
		if (getGenEssence().getPlugin() == null) {
			getGenEssence().setPlugin(GMFGenFactory.eINSTANCE.createGenPlugin());
		}
	}

	private void initGenUpdater() {
		if (getGenEssence().getDiagramUpdater() == null) {
			getGenEssence().setDiagramUpdater(GMFGenFactory.eINSTANCE.createGenDiagramUpdater());
		}

	}

	private GenNavigator genGenNavigator() {
		if (getGenEssence().getNavigator() == null) {
			getGenEssence().setNavigator(GMFGenFactory.eINSTANCE.createGenNavigator());
		}
		return getGenEssence().getNavigator();
	}

	private Palette getGenPalette() {
		Palette p = getGenDiagram().getPalette();
		if (p == null) {
			p = GMFGenFactory.eINSTANCE.createPalette();
			getGenDiagram().setPalette(p);
		}
		return p;
	}

	private GenPropertySheet getPropertySheet() {
		if (getGenEssence().getPropertySheet() == null) {
			getGenEssence().setPropertySheet(GMFGenFactory.eINSTANCE.createGenPropertySheet());
		}
		return getGenEssence().getPropertySheet();
	}

	private GenParsers getGenParsers() {
		// XXX meanwhile, we don't set any attributes to GenParsers (rather delegating to old, deprecated)
		if (getGenEssence().getLabelParsers() == null) {
			getGenEssence().setLabelParsers(GMFGenFactory.eINSTANCE.createGenParsers());
			// unless bug #235113 is fixed, always do ParserService
			getGenEssence().getLabelParsers().setExtensibleViaService(true);
		}
		return getGenEssence().getLabelParsers();
	}

	private GenContextMenu getDiagramContextMenu() {
		if (myDiagramContextMenu == null) {
			myDiagramContextMenu = GMFGenFactory.eINSTANCE.createGenContextMenu();
			myDiagramContextMenu.getContext().add(getGenDiagram());
			getGenEssence().getContextMenus().add(myDiagramContextMenu);
		}
		return myDiagramContextMenu;
	}

	protected void process(CanvasMapping mapping) {
		if (myGenModelMatch == null && mapping.getDomainModel() != null) {
			myGenModelMatch = new GenModelMatcher(mapping.getDomainModel());
		}
		myFactoryGate.prepare(mapping);
		if (mapping.getPalette() != null) {
			myPaletteProcessor.initialize(getGenPalette());
			myPaletteProcessor.process(mapping.getPalette());
		}
		if (!rcp) {
			myNavigatorProcessor.initialize(getGenDiagram(), genGenNavigator());
		}
		GenPackage primaryPackage = findGenPackage(mapping.getDomainModel());
		getGenEssence().setDomainGenModel(primaryPackage == null ? null : primaryPackage.getGenModel());
		getGenDiagram().setDomainDiagramElement(findGenClass(mapping.getDomainMetaElement()));
		getGenDiagram().setDiagramRunTimeClass(findRunTimeClass(mapping));
		getGenDiagram().setVisualID(myVisualIDs.getForDiagram(getGenDiagram()));
		getGenDiagram().setViewmap(myViewmaps.create(mapping.getDiagramCanvas()));
		getGenDiagram().setIconProviderPriority(ProviderPriority.LOW_LITERAL); // override ElementTypeIconProvider
		getGenDiagram().setValidationProviderPriority(ProviderPriority.LOW_LITERAL); // otherwise it's not available
		if (getGenDiagram().getDomainDiagramElement() != null) {
			// since diagram is the first entity to process consider it defines metamodel type
			getGenDiagram().setElementType(GMFGenFactory.eINSTANCE.createMetamodelType());
			myProcessedTypes.put(getGenDiagram().getDomainDiagramElement(), getGenDiagram().getElementType());
		} else {
			getGenDiagram().setElementType(GMFGenFactory.eINSTANCE.createNotationType());
		}

		initGenPlugin();
		initGenUpdater();

		myPropertySheetProcessor.initialize(getPropertySheet());
		myPropertySheetProcessor.process(mapping);
		addPreferencePages(getGenDiagram());

		if (rcp) {
			if (getGenEssence().getApplication() == null) {
				GenApplication app = GMFGenFactory.eINSTANCE.createGenApplication();
				addContributions(app);
				getGenEssence().setApplication(app);
			}
		}
		// XXX actually, better do it once whole transformation is complete
		if (getGenDiagram().generateCreateShortcutAction()) {
			getDiagramContextMenu().getItems().add(GMFGenFactory.eINSTANCE.createCreateShortcutAction());
		}
		// XXX ask Vano, if it's reasonable to generate LoadResourceAction only when there are shortcuts?
		getDiagramContextMenu().getItems().add(GMFGenFactory.eINSTANCE.createLoadResourceAction());
	}

	protected void process(TopNodeReference topNode) {
		final NodeMapping nme = topNode.getChild();
		assert nme != null;
		assertNodeMapping(nme);

		GenNode genNode = myFactoryGate.findOrCreateTopNode(nme, getGenDiagram());

		genNode.setDiagramRunTimeClass(findRunTimeClass(nme));
		genNode.setModelFacet(createModelFacet(topNode));
		genNode.setVisualID(myVisualIDs.getForTopNode(genNode));
		genNode.setViewmap(myViewmaps.create(nme.getDiagramNode()));
		setupElementType(genNode);
		myPaletteProcessor.process(nme, genNode);

		processAbstractNode(nme, genNode);

		if (!rcp) {
			myNavigatorProcessor.processTopNode(genNode);
		}
	}

	protected void process(AuditContainer audits) {
		if (audits != null) {
			getGenEssence().setAudits(createGenAuditRoot(audits));
		}
	}

	protected void process(MetricContainer metrics) {
		if (metrics != null) {
			GenMetricContainer genMetricContainer = GMFGenFactory.eINSTANCE.createGenMetricContainer();
			for (MetricRule next : metrics.getMetrics()) {
				genMetricContainer.getMetrics().add(createGenMetric(next));
			}
			getGenEssence().setMetrics(genMetricContainer);
		}
	}

	private void process(ChildReference childNodeRef, GenChildContainer container) {
		final NodeMapping childNodeMapping = childNodeRef.getChild();
		assert childNodeMapping != null;
		assertNodeMapping(childNodeMapping);

		GenChildNodeBase childNode = myFactoryGate.findCompatibleChildNode(childNodeMapping, childNodeRef);
		if (childNode == null) {
			childNode = createGenChildNode(childNodeRef);
		}

		if (container instanceof GenCompartment && childNodeMapping.getChildren().size() > 0) {
			// TODO just layout from childNodeMapping.getDiagramNode()
			((GenCompartment) container).setListLayout(false);
		}
		container.getChildNodes().add(childNode);
		if (!rcp) {
			myNavigatorProcessor.processChildNode(childNode, container);
		}
	}

	private GenChildNodeBase createGenChildNode(ChildReference childNodeRef) {
		final NodeMapping childNodeMapping = childNodeRef.getChild();
		final GenChildNodeBase childNode;
		final boolean needCompartmentChildrenLabelProcessing;
		if (Knowledge.isPureLabelNode(childNodeMapping)) {
			LabelMapping soleLabel = childNodeMapping.getLabelMappings().get(0);
			GenChildLabelNode childLabelNode = myFactoryGate.createChildLabelNode(childNodeMapping, getGenDiagram());
			childLabelNode.setViewmap(myViewmaps.create(soleLabel.getDiagramLabel()));
			childLabelNode.setLabelModelFacet(createLabelModelFacet(soleLabel));
			childLabelNode.setLabelReadOnly(soleLabel.isReadOnly());
			childLabelNode.setLabelElementIcon(soleLabel.getDiagramLabel().isElementIcon());
			childNode = childLabelNode;
			needCompartmentChildrenLabelProcessing = false;
		} else if (childNodeMapping.getDiagramNode().getAffixedParentSide() != Direction.NONE_LITERAL) {
			GenChildSideAffixedNode sideAffixedNode = myFactoryGate.createSideAffixedNode(childNodeMapping, getGenDiagram());
			sideAffixedNode.setViewmap(myViewmaps.create(childNodeMapping.getDiagramNode()));
			String positionConstantName = getAffixedSideAsPositionConstantsName(childNodeMapping.getDiagramNode());
			sideAffixedNode.setPreferredSideName(positionConstantName);
			childNode = sideAffixedNode;
			needCompartmentChildrenLabelProcessing = true;
		} else {
			childNode = myFactoryGate.createChildNode(childNodeMapping, getGenDiagram());
			childNode.setViewmap(myViewmaps.create(childNodeMapping.getDiagramNode()));
			needCompartmentChildrenLabelProcessing = true;
		}

		childNode.setModelFacet(createModelFacet(childNodeRef));

		childNode.setDiagramRunTimeClass(findRunTimeClass(childNodeMapping));
		childNode.setVisualID(myVisualIDs.getForChildNode(childNode));
		setupElementType(childNode);

		myPaletteProcessor.process(childNodeMapping, childNode);
		if (needCompartmentChildrenLabelProcessing) {
			processAbstractNode(childNodeMapping, childNode);
		}
		return childNode;
	}

	private String getAffixedSideAsPositionConstantsName(Node diagramNode) {
		Direction affixedSide = diagramNode.getAffixedParentSide();
		final String ANY_SIDE = "NONE";
		switch (affixedSide.getValue()) {
		case Direction.NONE:
			throw new IllegalStateException("DiagramNode: " + diagramNode + " is not side-affixed");
		case Direction.EAST:
		case Direction.NORTH:
		case Direction.WEST:
		case Direction.SOUTH:
			return affixedSide.getName();

		case Direction.NSEW:
			return ANY_SIDE;

		default:
			//Runtime does not support this
			return ANY_SIDE;
		}
	}

	private void processAbstractNode(NodeMapping mapping, GenNode genNode) {
		HashMap<CompartmentMapping, GenCompartment> compartments2GenCompartmentsMap = new HashMap<CompartmentMapping, GenCompartment>();
		for (CompartmentMapping compartmentMapping : mapping.getCompartments()) {
			GenCompartment compartmentGen = createGenCompartment(compartmentMapping, genNode);
			compartments2GenCompartmentsMap.put(compartmentMapping, compartmentGen);
		}

		for (ChildReference childNodeRef : mapping.getChildren()) {
			CompartmentMapping compartmentMapping = childNodeRef.getCompartment();
			GenChildContainer genChildContainer;
			if (compartmentMapping != null && compartments2GenCompartmentsMap.containsKey(compartmentMapping)) {
				genChildContainer = compartments2GenCompartmentsMap.get(compartmentMapping);
			} else {
				genChildContainer = genNode;
			}
			process(childNodeRef, genChildContainer);
		}
		for (LabelMapping labelMapping : mapping.getLabelMappings()) {
			createNodeLabel(genNode, labelMapping);
		}

		for (CanvasMapping nextRelatedCanvas : mapping.getRelatedDiagrams()) {
			OpenDiagramBehaviour openDiagramPolicy = GMFGenFactory.eINSTANCE.createOpenDiagramBehaviour();
			// ugly check that nodeMapping is related to owning canvasMapping, iow mapping.getCanvasMapping() == nextRelatedCanvas
			if (nextRelatedCanvas.eResource() != mapping.eResource()) {
				// unless we would like to ask user where to take appropriate .gmfgen...
				openDiagramPolicy.setDiagramKind("FIXME put GenEditorGenerator.modelID value here");
				openDiagramPolicy.setEditorID("FIXME put GenEditorView.id value here");
			}
			genNode.getBehaviour().add(openDiagramPolicy);
		}

		createVisualEffects(mapping, genNode, mapping.getDiagramNode());
	}

	private void createVisualEffects(MappingEntry mapping, GenCommonBase genCommon, DiagramElement diagramElement) {
		for (VisualEffectMapping visualEffectMapping : mapping.getVisualEffects()) {
			createVisualEffect(genCommon, visualEffectMapping, diagramElement);
		}
	}

	private GenCompartment createGenCompartment(CompartmentMapping mapping, GenNode genNode) {
		Compartment compartment = mapping.getCompartment();
		assert compartment != null;
		GenCompartment childCompartment = GMFGenFactory.eINSTANCE.createGenCompartment();
		getGenDiagram().getCompartments().add(childCompartment);
		genNode.getCompartments().add(childCompartment);
		childCompartment.setVisualID(myVisualIDs.getForCompartment(childCompartment));
		childCompartment.setDiagramRunTimeClass(getChildContainerRunTimeClass());
		childCompartment.setViewmap(myViewmaps.create(mapping.getCompartment()));
		childCompartment.setCanCollapse(compartment.isCollapsible());
		childCompartment.setNeedsTitle(compartment.isNeedsTitle());
		childCompartment.setTitle(compartment.getName());

		return childCompartment;
	}

	protected void process(LinkMapping lme) {
		assertLinkMapping(lme);

		GenLink gl = myFactoryGate.findOrCreateLink(lme, getGenDiagram());

		gl.setModelFacet(createModelFacet(lme));
		gl.setVisualID(myVisualIDs.getForLink(gl));
		myPaletteProcessor.process(lme, gl);
		for (LabelMapping labelMapping : lme.getLabelMappings()) {
			createLinkLabel(gl, labelMapping);
		}
		gl.setDiagramRunTimeClass(findRunTimeClass(lme));

		setupElementType(gl);

		gl.setViewmap(myViewmaps.create(lme.getDiagramLink()));

		if (lme.getCreationConstraints() != null) {
			gl.setCreationConstraints(createLinkCreationConstraints(lme.getCreationConstraints()));
		}

		if (!rcp) {
			myNavigatorProcessor.processLink(gl);
		}

		createVisualEffects(lme, gl, lme.getDiagramLink());
	}

	@Override
	protected void complete() {
		List<String> requiredPlugins = getGenEssence().getPlugin().getRequiredPlugins();
		final String GMF_TOOLING_RUNTIME = "org.eclipse.gmf.tooling.runtime"; //$NON-NLS-1$
		requiredPlugins.add(GMF_TOOLING_RUNTIME);
		requiredPlugins.addAll(Arrays.asList(myViewmaps.dependencies()));
	}

	//	private void process(AppearanceSteward appSteward) {
	//		if (appSteward.getAppearanceStyle() == null) {
	//			return;
	//		}
	//		
	//	}

	private GenNodeLabel createNodeLabel(GenNode node, LabelMapping mapping) {
		GenNodeLabel label;
		if (mapping.getDiagramLabel().isExternal()) {
			label = GMFGenFactory.eINSTANCE.createGenExternalNodeLabel();
		} else {
			label = GMFGenFactory.eINSTANCE.createGenNodeLabel();
		}
		node.getLabels().add(label);
		label.setVisualID(myVisualIDs.getForNodeLabel(label));
		label.setDiagramRunTimeClass(findRunTimeClass(mapping));
		label.setViewmap(myViewmaps.create(mapping.getDiagramLabel()));
		label.setModelFacet(createLabelModelFacet(mapping));
		label.setReadOnly(mapping.isReadOnly());
		label.setElementIcon(mapping.getDiagramLabel().isElementIcon());
		return label;
	}

	private void createVisualEffect(GenCommonBase parent, VisualEffectMapping mapping, DiagramElement parentDiagramElement) {
		GenVisualEffect visualEffect = GMFGenFactory.eINSTANCE.createGenVisualEffect();
		parent.getBehaviour().add(visualEffect);

		Pin graphPin = mapping.getDiagramPin();

		String name = graphPin.getName();

		visualEffect.setName(name);
		visualEffect.setPinKind(graphPin.eClass().getName());

		String operationName = graphPin.getOperationName();

		FigureDescriptor graphFigureDescriptor = parentDiagramElement.getFigure();

		if (!hasFigurePin(graphFigureDescriptor.getActualFigure(), graphPin)) {
			for (ChildAccess graphChildAccess : graphFigureDescriptor.getAccessors()) {
				if (hasFigurePin(graphChildAccess.getFigure(), graphPin)) {
					operationName = graphChildAccess.getAccessor() + "()." + operationName;
					break;
				}
			}
		}

		visualEffect.setOperationName(operationName);
		visualEffect.setOperationType(graphPin.getOperationType());
		visualEffect.setOclExpression(mapping.getOclExpression());

		String editPolicyQualifiedClassName = parent.getDiagram().getEditPoliciesPackageName() + '.'//
				+ CodeGenUtil.capName(CodeGenUtil.validJavaIdentifier(name)) + parent.getVisualID() //
				+ "Policy";

		visualEffect.setEditPolicyQualifiedClassName(editPolicyQualifiedClassName);
		visualEffect.setKey(editPolicyQualifiedClassName + ".KEY");
	}

	private boolean hasFigurePin(Figure figure, Pin pin) {
		RealFigure realFigure = (figure instanceof FigureRef) //
		? ((FigureRef) figure).getFigure() //
				: (RealFigure) figure;
		return realFigure.getPins().contains(pin);
	}

	private GenLinkLabel createLinkLabel(GenLink link, LabelMapping mapping) {
		GenLinkLabel label = GMFGenFactory.eINSTANCE.createGenLinkLabel();
		link.getLabels().add(label);
		label.setVisualID(myVisualIDs.getForLinkLabel(label));
		label.setDiagramRunTimeClass(findRunTimeClass(mapping));
		label.setViewmap(myViewmaps.create(mapping.getDiagramLabel()));
		label.setModelFacet(createLabelModelFacet(mapping));
		label.setReadOnly(mapping.isReadOnly());
		label.setElementIcon(mapping.getDiagramLabel().isElementIcon());
		if (findVF(mapping.getDiagramLabel(), AlignmentFacet.class) != null) {
			AlignmentFacet af = findVF(mapping.getDiagramLabel(), AlignmentFacet.class);
			label.setAlignment(getLinkLabelAlignment(af.getAlignment()));
		}
		LabelOffsetAttributes loa = GMFGenFactory.eINSTANCE.createLabelOffsetAttributes();
		LabelOffsetFacet lof = findVF(mapping.getDiagramLabel(), LabelOffsetFacet.class);
		if (lof != null) {
			loa.setX(lof.getX());
			loa.setY(lof.getY());
		} else {
			// stack labels under link by default
			int weight = link.getLabels().size() + 1;
			loa.setY(weight * 20);
		}
		label.getViewmap().getAttributes().add(loa);
		return label;
	}

	private static <T extends VisualFacet> T findVF(DiagramElement element, Class<T> facetClass) {
		for (VisualFacet vf : element.getFacets()) {
			if (facetClass.isInstance(vf)) {
				return facetClass.cast(vf);
			}
		}
		return null;
	}

	private LinkLabelAlignment getLinkLabelAlignment(Alignment alignment) {
		switch (alignment.getValue()) {
		case Alignment.BEGINNING:
			return LinkLabelAlignment.SOURCE_LITERAL;
		case Alignment.CENTER:
			return LinkLabelAlignment.MIDDLE_LITERAL;
		case Alignment.END:
			return LinkLabelAlignment.TARGET_LITERAL;
		default:
			throw new IllegalArgumentException("Link doesn't support alignment:" + alignment.getName());
		}
	}

	private LabelModelFacet createLabelModelFacet(LabelMapping mapping) {
		if (mapping instanceof FeatureLabelMapping) {
			FeatureLabelMapping flMapping = (FeatureLabelMapping) mapping;
			FeatureLabelModelFacet modelFacet = GMFGenFactory.eINSTANCE.createFeatureLabelModelFacet();
			for (EAttribute attr : flMapping.getFeatures()) {
				modelFacet.getMetaFeatures().add(findGenFeature(attr));
			}
			for (EAttribute attr : flMapping.getEditableFeatures()) {
				modelFacet.getEditableMetaFeatures().add(findGenFeature(attr));
			}
			modelFacet.setViewPattern(flMapping.getViewPattern());
			modelFacet.setEditorPattern(flMapping.getEditorPattern());
			modelFacet.setEditPattern(flMapping.getEditPattern());
			if (flMapping.eIsSet(GMFMapPackage.eINSTANCE.getFeatureLabelMapping_ViewMethod())) {
				modelFacet.setViewMethod(LabelTextAccessMethod.get(flMapping.getViewMethod().getValue()));
			}
			if (flMapping.eIsSet(GMFMapPackage.eINSTANCE.getFeatureLabelMapping_EditMethod())) {
				modelFacet.setEditMethod(LabelTextAccessMethod.get(flMapping.getEditMethod().getValue()));
			}
			// XXX temp code
			modelFacet.setParser(getOrCreateParser(flMapping));
			// XXX
			return modelFacet;
		}
		if (mapping instanceof OclChoiceLabelMapping) {
			OclChoiceLabelMapping oclMapping = (OclChoiceLabelMapping) mapping;
			FeatureLabelModelFacet modelFacet = GMFGenFactory.eINSTANCE.createFeatureLabelModelFacet();
			GenFeature feature = findGenFeature(oclMapping.getFeature());
			modelFacet.getMetaFeatures().add(feature);
			modelFacet.getEditableMetaFeatures().add(feature);
			modelFacet.setParser(createOclChoiceParser(oclMapping));
			return modelFacet;
		}
		if (mapping instanceof DesignLabelMapping) {
			DesignLabelModelFacet modelFacet = GMFGenFactory.eINSTANCE.createDesignLabelModelFacet();
			modelFacet.setParser(getOrCreateParser((DesignLabelMapping) mapping));
			return modelFacet;
		}
		if (mapping instanceof ExpressionLabelMapping) {
			ExpressionLabelModelFacet modelFacet = GMFGenFactory.eINSTANCE.createExpressionLabelModelFacet();
			ExpressionLabelParser parser = GMFGenFactory.eINSTANCE.createExpressionLabelParser();
			ExpressionLabelMapping elm = (ExpressionLabelMapping) mapping;
			parser.setExpressionContext(findGenClass(elm.getMapEntry().getDomainContext()));
			if (elm.getViewExpression() != null) {
				parser.setViewExpression(createValueExpression(elm.getViewExpression()));
			}
			if (elm.getEditExpression() != null) {
				parser.setEditExpression(createValueExpression(elm.getEditExpression()));
			}
			if (elm.getValidateExpression() != null) {
				parser.setValidateExpression(createGenConstraint(elm.getValidateExpression()));
			}
			modelFacet.setParser(parser);
			getGenParsers().getImplementations().add(parser);
			return modelFacet;
		}
		// create bare instance that points to a ExternalParser
		// this is modification of old contract (though, not breaking change, I believe)
		// that says null modelFacet means use of external parser
		LabelModelFacet modelFacet = GMFGenFactory.eINSTANCE.createLabelModelFacet();
		modelFacet.setParser(getOrCreateParser(mapping));
		return modelFacet;
	}

	private void setupElementType(GenNode genNode) {
		if (genNode.getModelFacet() != null) {
			MetamodelType metamodelType = (MetamodelType) myProcessedTypes.get(genNode.getModelFacet().getMetaClass());
			if (metamodelType == null) {
				// this is the first metaclass encounter; consider metamodel type definition
				genNode.setElementType(GMFGenFactory.eINSTANCE.createMetamodelType());
				myProcessedTypes.put(genNode.getModelFacet().getMetaClass(), genNode.getElementType());
			} else {
				// all subsequent encounters lead to specialization definitions
				SpecializationType specializationType = GMFGenFactory.eINSTANCE.createSpecializationType();
				specializationType.setMetamodelType(metamodelType);
				genNode.setElementType(specializationType);
			}
		} else {
			genNode.setElementType(GMFGenFactory.eINSTANCE.createNotationType());
		}
	}

	private void setupElementType(GenLink gl) {
		if (gl.getModelFacet() != null) {
			if (gl.getModelFacet() instanceof TypeModelFacet) {
				GenClass metaClass = ((TypeModelFacet) gl.getModelFacet()).getMetaClass();
				MetamodelType metamodelType = (MetamodelType) myProcessedTypes.get(metaClass);
				if (metamodelType == null) {
					// this is the first metaclass encounter; consider metamodel type definition
					gl.setElementType(GMFGenFactory.eINSTANCE.createMetamodelType());
					myProcessedTypes.put(metaClass, gl.getElementType());
				} else {
					// all subsequent encounters lead to specialization definitions
					SpecializationType specializationType = GMFGenFactory.eINSTANCE.createSpecializationType();
					specializationType.setMetamodelType(metamodelType);
					gl.setElementType(specializationType);
				}
			} else {
				// ref-based link; specialize null
				SpecializationType specializationType = GMFGenFactory.eINSTANCE.createSpecializationType();
				gl.setElementType(specializationType);
			}
		} else {
			gl.setElementType(GMFGenFactory.eINSTANCE.createNotationType());
		}
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

	private void assertNodeMapping(NodeMapping mapping) {
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
		for (LabelMapping labelMapping : (Collection<? extends LabelMapping>) entry.getLabelMappings()) {
			if (labelMapping instanceof FeatureLabelMapping) {
				final EClass domainElement = labelMapping.getMapEntry().getDomainContext();
				for (EAttribute attr : (Collection<? extends EAttribute>) ((FeatureLabelMapping) labelMapping).getFeatures()) {
					if (!Extras.isSuperTypeOf(attr.getEContainingClass(), domainElement)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private GenPackage findGenPackage(EPackage ePackage) {
		if (myGenModelMatch == null) {
			warnNoGenModelMatcher(ePackage);
			return null;
		}
		return myGenModelMatch.findGenPackage(ePackage);
	}

	private GenClass findGenClass(EClass eClass) {
		if (myGenModelMatch == null) {
			warnNoGenModelMatcher(eClass);
			return null;
		}
		return myGenModelMatch.findGenClass(eClass);
	}

	private GenFeature findGenFeature(EStructuralFeature feature) {
		if (myGenModelMatch == null) {
			warnNoGenModelMatcher(feature);
			return null;
		}
		return myGenModelMatch.findGenFeature(feature);
	}

	private void warnNoGenModelMatcher(EModelElement element) {
		// TODO : emit warning
	}

	private TypeModelFacet createModelFacet(NodeReference anm) {
		final NodeMapping nodeMapping = anm.getChild();
		if (nodeMapping.getDomainContext() == null) {
			return null;
		}
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
		if (lme == null) {
			return null;
		}
		GenLinkConstraints genConstraints = GMFGenFactory.eINSTANCE.createGenLinkConstraints();
		Constraint sourceConstraint = constraints.getSourceEnd();
		if (sourceConstraint != null) {
			genConstraints.setSourceEnd(createGenConstraint(sourceConstraint));
		}
		Constraint targetConstraint = constraints.getTargetEnd();
		if (targetConstraint != null) {
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
		if (spec != null) {
			typeModelFacet.setModelElementSelector(createGenConstraint(spec));
		}
		if (init != null) {
			typeModelFacet.setModelElementInitializer(createElementInitializer(init));
		}
		return typeModelFacet;
	}

	private GenElementInitializer createElementInitializer(ElementInitializer elementInitializer) {
		if (elementInitializer instanceof FeatureSeqInitializer) {
			FeatureSeqInitializer fsInitializer = (FeatureSeqInitializer) elementInitializer;
			GenFeatureSeqInitializer genFsInitializer = GMFGenFactory.eINSTANCE.createGenFeatureSeqInitializer();
			for (FeatureInitializer next : fsInitializer.getInitializers()) {
				genFsInitializer.getInitializers().add(createGenFeatureInitializer(next));
			}
			if (fsInitializer.eIsSet(GMFMapPackage.eINSTANCE.getFeatureSeqInitializer_ElementClass())) {
				genFsInitializer.setElementClass(findGenClass(fsInitializer.getElementClass()));
			}
			return genFsInitializer;
		}
		return null;
	}

	private GenFeatureInitializer createGenFeatureInitializer(FeatureInitializer featureInitializer) {
		if (featureInitializer instanceof FeatureValueSpec) {
			FeatureValueSpec featureValSpec = (FeatureValueSpec) featureInitializer;
			GenFeatureValueSpec genFeatureValSpec = GMFGenFactory.eINSTANCE.createGenFeatureValueSpec();
			genFeatureValSpec.setFeature(findGenFeature(featureValSpec.getFeature()));
			genFeatureValSpec.setValue(createValueExpression(featureValSpec.getValue()));

			return genFeatureValSpec;
		} else if (featureInitializer instanceof ReferenceNewElementSpec) {
			ReferenceNewElementSpec newElementSpec = (ReferenceNewElementSpec) featureInitializer;
			GenReferenceNewElementSpec genNewElementSpec = GMFGenFactory.eINSTANCE.createGenReferenceNewElementSpec();
			genNewElementSpec.setFeature(findGenFeature(newElementSpec.getFeature()));
			for (FeatureSeqInitializer next : newElementSpec.getNewElementInitializers()) {
				GenFeatureSeqInitializer nextGenFeatureSeqInitializer = (GenFeatureSeqInitializer) createElementInitializer(next);
				genNewElementSpec.getNewElementInitializers().add(nextGenFeatureSeqInitializer);
			}
			return genNewElementSpec;
		}
		assert false : "Unrecognized FeatureInitializer type"; //$NON-NLS-1$
		return null;
	}

	private static GenLanguage detectGenLanguage(Language mapLang) {
		switch (mapLang.getValue()) {
		case Language.OCL:
			return GenLanguage.OCL_LITERAL;
		case Language.JAVA:
			return GenLanguage.JAVA_LITERAL;
		case Language.REGEXP:
			return GenLanguage.REGEXP_LITERAL;
		case Language.NREGEXP:
			return GenLanguage.NREGEXP_LITERAL;
		case Language.LITERAL:
			return GenLanguage.LITERAL_LITERAL;
		default:
			assert false : mapLang;
		}
		return GenLanguage.OCL_LITERAL;
	}

	// may return GenConstraint, based on original expression type
	// XXX perhaps, combining #createValueExpression and #createGenConstraint into a single method makes sense?
	private ValueExpression createValueExpression(org.eclipse.gmf.mappings.ValueExpression valueExpression) {
		if (valueExpression instanceof Constraint) {
			return createGenConstraint((Constraint) valueExpression);
		}
		ValueExpression result = GMFGenFactory.eINSTANCE.createValueExpression();
		result.setBody(valueExpression.getBody());
		return bindToProvider(valueExpression, result);
	}

	private GenConstraint createGenConstraint(Constraint constraint) {
		if (constraint.getBody() == null) {
			return null;
		}
		GenConstraint genConstraint = GMFGenFactory.eINSTANCE.createGenConstraint();
		genConstraint.setBody(constraint.getBody());
		return bindToProvider(constraint, genConstraint);
	}

	private GenAuditRoot createGenAuditRoot(AuditContainer ac) {
		GenAuditRoot root = GMFGenFactory.eINSTANCE.createGenAuditRoot();
		LinkedList<AuditContainer> containers = new LinkedList<AuditContainer>();
		containers.add(ac);
		// parent container to it's path
		final HashMap<AuditContainer, LinkedList<GenAuditContainer>> pathMap = new HashMap<AuditContainer, LinkedList<GenAuditContainer>>();
		do {
			AuditContainer nextChild = containers.removeFirst();
			GenAuditContainer gac = GMFGenFactory.eINSTANCE.createGenAuditContainer();
			gac.setId(nextChild.getId());
			gac.setName(nextChild.getName());
			gac.setDescription(nextChild.getDescription());
			// FIXME setPath
			if (pathMap.containsKey(nextChild.getParentContainer())) {
				gac.getPath().addAll(pathMap.get(nextChild.getParentContainer()));
			}
			gac.getPath().add(gac);
			// collect next level
			if (nextChild.getChildContainers().size() > 0) {
				containers.addAll(nextChild.getChildContainers());
				pathMap.put(nextChild, new LinkedList<GenAuditContainer>(gac.getPath()));
			}
			root.getCategories().add(gac);
			for (AuditRule next : nextChild.getAudits()) {
				final GenAuditRule auditRule = createGenAudit(next);
				auditRule.setCategory(gac);
				root.getRules().add(auditRule);
				// Here's the logic used to be in GMFGen. Basically, all rules with targets != null
				// get a context (emf.validation), which is a scope or set of elements audit is evaluated against.
				// For certain cases, e.g. diagram elements as audit targets, special logic to select these
				// elements should get generated - to filter diagram views by visualID, and hence
				// there's another implementation of IClientSelector and dedicated context.
				if (auditRule.getTarget() instanceof GenDiagramElementTarget) {
					GenDiagramElementTarget gdet = (GenDiagramElementTarget) auditRule.getTarget();
					// Next used to live in GenDiagramElementTargetImpl#getClientContextID()
					//
					// Present approach relies on id matching not to create duplicating contexts,
					// however, smarter way is to match context's target and its elements.
					StringBuilder buf = new StringBuilder("Ctx"); //$NON-NLS-1$
					for (GenCommonBase nextElement : gdet.getElement()) {
						buf.append('_');
						int id = nextElement.getVisualID();
						if (id < 0) {
							buf.append('n');
						}
						buf.append(id);
					}
					String clientContextID = buf.toString();
					GenAuditContext ctx = null;
					for (GenAuditContext x : root.getClientContexts()) {
						if (clientContextID.equals(x.getId())) {
							ctx = x;
							break;
						}
					}
					if (ctx == null) {
						ctx = GMFGenFactory.eINSTANCE.createGenAuditContext();
						ctx.setId(clientContextID);
						root.getClientContexts().add(ctx);
					}
					gdet.setContextSelector(ctx);
				} else if (auditRule.getTarget() != null) {
					if (myDefaultAuditContext == null) {
						myDefaultAuditContext = GMFGenFactory.eINSTANCE.createGenAuditContext();
						root.getClientContexts().add(myDefaultAuditContext);
					}
					auditRule.getTarget().setContextSelector(myDefaultAuditContext);
				}
			}
		} while (!containers.isEmpty());
		return root;
	}

	private GenAuditRule createGenAudit(AuditRule audit) {
		GenAuditRule genAudit = GMFGenFactory.eINSTANCE.createGenAuditRule();
		genAudit.setId(audit.getId());
		genAudit.setName(audit.getName());
		genAudit.setMessage(audit.getMessage());
		genAudit.setDescription(audit.getDescription());
		genAudit.setUseInLiveMode(audit.isUseInLiveMode());

		if (audit.getTarget() != null) {
			GenRuleTarget genTarget = createRuleTarget(audit.getTarget());
			assert genTarget instanceof GenAuditable;
			if (genTarget instanceof GenAuditable) {
				genAudit.setTarget((GenAuditable) genTarget);
			}
		}
		Constraint rule = audit.getRule();
		if (rule != null) {
			genAudit.setRule(createGenConstraint(rule));
		}

		Severity severity = audit.getSeverity();
		GenSeverity genSeverity = null;
		if (severity == Severity.INFO_LITERAL) {
			genSeverity = GenSeverity.INFO_LITERAL;
		} else if (severity == Severity.WARNING_LITERAL) {
			genSeverity = GenSeverity.WARNING_LITERAL;
		} else if (severity == Severity.ERROR_LITERAL) {
			genSeverity = GenSeverity.ERROR_LITERAL;
		}
		if (genSeverity != null) {
			genAudit.setSeverity(genSeverity);
		}
		return genAudit;
	}

	private GenRuleTarget createRuleTarget(EObject ruleTarget) {
		if (ruleTarget instanceof DomainElementTarget) {
			DomainElementTarget domainTarget = (DomainElementTarget) ruleTarget;
			GenDomainElementTarget genDomainTarget = GMFGenFactory.eINSTANCE.createGenDomainElementTarget();
			genDomainTarget.setElement(domainTarget.getElement() != null ? findGenClass(domainTarget.getElement()) : null);
			return genDomainTarget;
		} else if (ruleTarget instanceof NotationElementTarget) {
			NotationElementTarget notationTarget = (NotationElementTarget) ruleTarget;
			GenNotationElementTarget genNotationTarget = GMFGenFactory.eINSTANCE.createGenNotationElementTarget();
			// XXX findGenClass gives GenClass from domain model, is that what's expected here (NotationTarget)?
			genNotationTarget.setElement(notationTarget.getElement() != null ? findGenClass(notationTarget.getElement()) : null);
			return genNotationTarget;

		} else if (ruleTarget instanceof DiagramElementTarget) {
			GenDiagramElementTarget diagramTarget = GMFGenFactory.eINSTANCE.createGenDiagramElementTarget();
			MappingEntry mappingEntry = ((DiagramElementTarget) ruleTarget).getElement();
			if (mappingEntry instanceof LinkMapping) {
				LinkMapping lm = (LinkMapping) mappingEntry;
				GenLink genLink = myFactoryGate.findLink(lm);
				assert genLink != null;
				if (genLink != null) {
					diagramTarget.getElement().add(genLink);
				}
			} else if (mappingEntry instanceof NodeMapping) {
				NodeMapping nm = (NodeMapping) mappingEntry;
				// There may be few GenChildNodes corresponding to same mapping entry.					
				// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=136701					
				diagramTarget.getElement().addAll(Arrays.asList(myFactoryGate.findAllNodesFor(nm)));
			}
			return diagramTarget;
		} else if (ruleTarget instanceof AuditedMetricTarget) {
			GenAuditedMetricTarget genMetricTarget = GMFGenFactory.eINSTANCE.createGenAuditedMetricTarget();
			AuditedMetricTarget metricTarget = (AuditedMetricTarget) ruleTarget;
			if (metricTarget.getMetric() != null) {
				genMetricTarget.setMetric(myFactoryGate.findMetricRule(metricTarget.getMetric()));
			}
			GenClassifier resultClassifier = myEcoreGenModelMatch.findGenClassifier(EcorePackage.eINSTANCE.getEDoubleObject());
			assert resultClassifier instanceof GenDataType;
			if (resultClassifier instanceof GenDataType) {
				genMetricTarget.setMetricValueContext((GenDataType) resultClassifier);
			}
			return genMetricTarget;
		} else if (ruleTarget instanceof DomainAttributeTarget) {
			DomainAttributeTarget attrTarget = (DomainAttributeTarget) ruleTarget;
			GenDomainAttributeTarget genAttrTarget = GMFGenFactory.eINSTANCE.createGenDomainAttributeTarget();
			if (attrTarget.getAttribute() != null) {
				genAttrTarget.setAttribute(findGenFeature(attrTarget.getAttribute()));
			}
			genAttrTarget.setNullAsError(attrTarget.isNullAsError());
			return genAttrTarget;
		} else {
			assert false : "Unknown rule target type"; //$NON-NLS-1$
		}
		return null;
	}

	private GenMetricRule createGenMetric(MetricRule metric) {
		GenMetricRule genMetric = GMFGenFactory.eINSTANCE.createGenMetricRule();
		genMetric.setKey(metric.getKey());
		genMetric.setName(metric.getName());
		genMetric.setDescription(metric.getDescription());
		genMetric.setLowLimit(metric.getLowLimit());
		genMetric.setHighLimit(metric.getHighLimit());

		if (metric.getRule() != null) {
			genMetric.setRule(createValueExpression(metric.getRule()));
		}

		if (metric.getTarget() != null) {
			GenRuleTarget genTarget = createRuleTarget(metric.getTarget());
			assert genTarget instanceof GenMeasurable;
			if (genTarget instanceof GenMeasurable) {
				genMetric.setTarget((GenMeasurable) genTarget);
			}
		}
		myFactoryGate.logMetricRule(metric, genMetric);
		return genMetric;
	}

	/**
	 * ValueExpressions may be reused, as such clients should treat second
	 * argument as template and record return value as actual expression.
	 * 
	 * FIXME when ValueExpression in Java language and non-empty body, create
	 * JavaProvider with injectBody set to true. Also respect this condition in
	 * search for existing provider
	 * 
	 * @return actual gmfgen::ValueExpression to reference
	 */
	private <T extends ValueExpression> T bindToProvider(org.eclipse.gmf.mappings.ValueExpression expression, T genExpression) {
		if (myProcessedExpressions.containsKey(expression)) {
			// Note: may have already been bound during transformation of reused node mapping
			@SuppressWarnings("unchecked")
			T reuse = (T) myProcessedExpressions.get(expression);
			return reuse;
		}
		GenLanguage language = detectGenLanguage(expression.getLanguage());
		if (language == null) {
			return genExpression;
		}
		GenExpressionProviderContainer providerContainer = getGenEssence().getExpressionProviders();
		if (providerContainer == null) {
			providerContainer = GMFGenFactory.eINSTANCE.createGenExpressionProviderContainer();
			getGenEssence().setExpressionProviders(providerContainer);
		}
		GenExpressionProviderBase provider = null;
		for (GenExpressionProviderBase nextProvider : providerContainer.getProviders()) {
			if (language.equals(nextProvider.getLanguage())) {
				provider = nextProvider;
				break;
			}
		}
		if (provider == null) {
			provider = createExpressionProvider(language);
			providerContainer.getProviders().add(provider);
		}
		provider.getExpressions().add(genExpression);
		myProcessedExpressions.put(expression, genExpression);
		return genExpression;
	}

	private GenExpressionProviderBase createExpressionProvider(GenLanguage language) {
		switch (language.getValue()) {
		case GenLanguage.JAVA:
			return GMFGenFactory.eINSTANCE.createGenJavaExpressionProvider();
		case GenLanguage.OCL:
		case GenLanguage.REGEXP:
		case GenLanguage.NREGEXP: {
			GenExpressionInterpreter regexpProvider = GMFGenFactory.eINSTANCE.createGenExpressionInterpreter();
			regexpProvider.setLanguage(language);
			return regexpProvider;
		}
		case GenLanguage.LITERAL:
			return GMFGenFactory.eINSTANCE.createGenLiteralExpressionProvider();
		default: {
			assert false : language;
			return GMFGenFactory.eINSTANCE.createGenExpressionInterpreter();
			// fake provider with no language set to fail validation (XXX perhaps, makes sense to add 'unrecognized' language?)
		}
		}
	}

	private void addPreferencePages(GenDiagram diagram) {
		GenPreferencePage general = createStandardPreferencePage(diagram, "general", diagram.getEditorGen().getModelID() + " Diagram", StandardPreferencePages.GENERAL_LITERAL);
		diagram.getPreferencePages().add(general);
		general.getChildren().add(createStandardPreferencePage(diagram, "appearance", "Appearance", StandardPreferencePages.APPEARANCE_LITERAL));
		general.getChildren().add(createStandardPreferencePage(diagram, "connections", "Connections", StandardPreferencePages.CONNECTIONS_LITERAL));
		general.getChildren().add(createStandardPreferencePage(diagram, "printing", "Printing", StandardPreferencePages.PRINTING_LITERAL));
		general.getChildren().add(createStandardPreferencePage(diagram, "rulersAndGrid", "Rulers And Grid", StandardPreferencePages.RULERS_AND_GRID_LITERAL));
	}

	private GenPreferencePage createStandardPreferencePage(GenDiagram diagram, String id, String name, StandardPreferencePages kind) {
		GenStandardPreferencePage page = GMFGenFactory.eINSTANCE.createGenStandardPreferencePage();
		page.setID(diagram.getEditorGen().getPlugin().getID() + '.' + id);
		page.setName(name);
		page.setKind(kind);
		return page;
	}

	private void addContributions(GenApplication application) {
		GenMenuManager mainMenu = GMFGenFactory.eINSTANCE.createGenMenuManager();
		mainMenu.getItems().add(createFileMenu(application.getSharedContributionItems()));
		mainMenu.getItems().add(createEditMenu(application.getSharedContributionItems()));
		mainMenu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.MB_ADDITIONS")); //$NON-NLS-1$
		mainMenu.getItems().add(createWindowMenu(application.getSharedContributionItems()));
		mainMenu.getItems().add(createHelpMenu(application.getSharedContributionItems()));
		application.setMainMenu(mainMenu);

		GenToolBarManager mainToolBar = GMFGenFactory.eINSTANCE.createGenToolBarManager();
		mainToolBar.getItems().add(createGroupMarker("\"group.file\"")); //$NON-NLS-1$
		mainToolBar.getItems().add(createFileToolBar(application.getSharedContributionItems()));
		mainToolBar.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.MB_ADDITIONS")); //$NON-NLS-1$
		mainToolBar.getItems().add(createGroupMarker("\"group.nav\"")); //$NON-NLS-1$
		mainToolBar.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.GROUP_EDITOR")); //$NON-NLS-1$
		mainToolBar.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.GROUP_HELP")); //$NON-NLS-1$
		mainToolBar.getItems().add(createHelpToolBar(application.getSharedContributionItems()));
		application.setMainToolBar(mainToolBar);
	}

	private GenGroupMarker createGroupMarker(String groupName) {
		GenGroupMarker gm = GMFGenFactory.eINSTANCE.createGenGroupMarker();
		gm.setGroupName(groupName);
		return gm;
	}

	private GenSeparator createSeparator(String groupName) {
		GenSeparator s = GMFGenFactory.eINSTANCE.createGenSeparator();
		s.setGroupName(groupName);
		return s;
	}

	private GenActionFactoryContributionItem createActionFactoryItem(String name) {
		GenActionFactoryContributionItem item = GMFGenFactory.eINSTANCE.createGenActionFactoryContributionItem();
		item.setName(name);
		return item;
	}

	private GenSharedContributionItem createSharedItem(List<GenContributionItem> sharedItems, GenContributionItem actualItem) {
		GenSharedContributionItem sitem = GMFGenFactory.eINSTANCE.createGenSharedContributionItem();
		if (actualItem instanceof GenActionFactoryContributionItem) {
			GenActionFactoryContributionItem afActualItem = (GenActionFactoryContributionItem) actualItem;
			for (GenContributionItem item : sharedItems) {
				if (item instanceof GenActionFactoryContributionItem) {
					GenActionFactoryContributionItem afItem = (GenActionFactoryContributionItem) item;
					if (afItem.getName().equals(afActualItem.getName())) {
						// shared action factory item is already contributed
						sitem.setActualItem(afItem);
						actualItem = null;
						break;
					}
				}
			}
		}
		if (actualItem != null) {
			sitem.setActualItem(actualItem);
			sharedItems.add(actualItem);
		}
		return sitem;
	}

	private GenMenuManager createFileMenu(List<GenContributionItem> sharedItems) {
		GenMenuManager menu = GMFGenFactory.eINSTANCE.createGenMenuManager();
		menu.setID("org.eclipse.ui.IWorkbenchActionConstants.M_FILE"); //$NON-NLS-1$
		menu.setName("&File"); //$NON-NLS-1$
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.FILE_START")); //$NON-NLS-1$
		GenMenuManager newMenu = GMFGenFactory.eINSTANCE.createGenMenuManager();
		newMenu.setID("\"new\""); //$NON-NLS-1$
		newMenu.setName("&New"); //$NON-NLS-1$
		newMenu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.MB_ADDITIONS")); //$NON-NLS-1$
		menu.getItems().add(newMenu);
		menu.getItems().add(GMFGenFactory.eINSTANCE.createGenSeparator());
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.MB_ADDITIONS")); //$NON-NLS-1$
		menu.getItems().add(GMFGenFactory.eINSTANCE.createGenSeparator());
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("CLOSE"))); //$NON-NLS-1$
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("CLOSE_ALL"))); //$NON-NLS-1$
		menu.getItems().add(GMFGenFactory.eINSTANCE.createGenSeparator());
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("SAVE"))); //$NON-NLS-1$
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("SAVE_AS"))); //$NON-NLS-1$
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("SAVE_ALL"))); //$NON-NLS-1$
		menu.getItems().add(GMFGenFactory.eINSTANCE.createGenSeparator());
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("QUIT"))); //$NON-NLS-1$
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.FILE_END")); //$NON-NLS-1$
		return menu;
	}

	private GenMenuManager createEditMenu(List<GenContributionItem> sharedItems) {
		GenMenuManager menu = GMFGenFactory.eINSTANCE.createGenMenuManager();
		menu.setID("org.eclipse.ui.IWorkbenchActionConstants.M_EDIT"); //$NON-NLS-1$
		menu.setName("&Edit"); //$NON-NLS-1$
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.EDIT_START")); //$NON-NLS-1$
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("UNDO"))); //$NON-NLS-1$
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("REDO"))); //$NON-NLS-1$
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.UNDO_EXT")); //$NON-NLS-1$
		menu.getItems().add(GMFGenFactory.eINSTANCE.createGenSeparator());
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("CUT"))); //$NON-NLS-1$
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("COPY"))); //$NON-NLS-1$
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("PASTE"))); //$NON-NLS-1$
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.CUT_EXT")); //$NON-NLS-1$
		menu.getItems().add(GMFGenFactory.eINSTANCE.createGenSeparator());
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("DELETE"))); //$NON-NLS-1$
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("SELECT_ALL"))); //$NON-NLS-1$
		menu.getItems().add(GMFGenFactory.eINSTANCE.createGenSeparator());
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.ADD_EXT")); //$NON-NLS-1$
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.EDIT_END")); //$NON-NLS-1$
		menu.getItems().add(createSeparator("org.eclipse.ui.IWorkbenchActionConstants.MB_ADDITIONS")); //$NON-NLS-1$
		return menu;
	}

	private GenMenuManager createWindowMenu(List<GenContributionItem> sharedItems) {
		GenMenuManager menu = GMFGenFactory.eINSTANCE.createGenMenuManager();
		menu.setID("org.eclipse.ui.IWorkbenchActionConstants.M_WINDOW"); //$NON-NLS-1$
		menu.setName("&Window"); //$NON-NLS-1$
		menu.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("OPEN_NEW_WINDOW"))); //$NON-NLS-1$
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.MB_ADDITIONS")); //$NON-NLS-1$
		// TODO : menu.add(ContributionItemFactory.OPEN_WINDOWS.create(window));
		return menu;
	}

	private GenMenuManager createHelpMenu(List<GenContributionItem> sharedItems) {
		GenMenuManager menu = GMFGenFactory.eINSTANCE.createGenMenuManager();
		menu.setID("org.eclipse.ui.IWorkbenchActionConstants.M_HELP"); //$NON-NLS-1$
		menu.setName("&Help"); //$NON-NLS-1$
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.HELP_START")); //$NON-NLS-1$
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.HELP_END")); //$NON-NLS-1$
		menu.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.MB_ADDITIONS")); //$NON-NLS-1$
		return menu;
	}

	private GenToolBarManager createFileToolBar(List<GenContributionItem> sharedItems) {
		GenToolBarManager toolBar = GMFGenFactory.eINSTANCE.createGenToolBarManager();
		toolBar.setID("org.eclipse.ui.IWorkbenchActionConstants.TOOLBAR_FILE"); //$NON-NLS-1$
		toolBar.getItems().add(createSeparator("org.eclipse.ui.IWorkbenchActionConstants.NEW_GROUP")); //$NON-NLS-1$
		toolBar.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.NEW_EXT")); //$NON-NLS-1$
		toolBar.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.SAVE_GROUP")); //$NON-NLS-1$
		toolBar.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("SAVE"))); //$NON-NLS-1$
		toolBar.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.SAVE_EXT")); //$NON-NLS-1$
		toolBar.getItems().add(createSharedItem(sharedItems, createActionFactoryItem("PRINT"))); //$NON-NLS-1$
		toolBar.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.PRINT_EXT")); //$NON-NLS-1$
		toolBar.getItems().add(createSeparator("org.eclipse.ui.IWorkbenchActionConstants.MB_ADDITIONS")); //$NON-NLS-1$
		return toolBar;
	}

	private GenToolBarManager createHelpToolBar(List<GenContributionItem> sharedItems) {
		GenToolBarManager toolBar = GMFGenFactory.eINSTANCE.createGenToolBarManager();
		toolBar.setID("org.eclipse.ui.IWorkbenchActionConstants.TOOLBAR_HELP"); //$NON-NLS-1$
		toolBar.getItems().add(createSeparator("org.eclipse.ui.IWorkbenchActionConstants.GROUP_HELP")); //$NON-NLS-1$
		toolBar.getItems().add(createGroupMarker("org.eclipse.ui.IWorkbenchActionConstants.GROUP_APP")); //$NON-NLS-1$
		return toolBar;
	}

	private GenParserImplementation getOrCreateParser(FeatureLabelMapping flMapping) {
		if (isEnumLabelMapping(flMapping)) {
			return getOrCreateEnumParser(flMapping);
		} else {
			return getOrCreatePredefinedParser(flMapping);
		}
	}

	private boolean isEnumLabelMapping(FeatureLabelMapping flMapping) {
		EList<EAttribute> features = flMapping.getFeatures();
		EList<EAttribute> editFeatures = flMapping.getEditableFeatures();
		if (features.size() != 1) {
			return false;
		}
		if (editFeatures.size() > features.size()) {
			return false;
		}
		if (!editFeatures.isEmpty() && editFeatures.get(0) != features.get(0)) {
			return false;
		}
		return features.get(0).getEType() instanceof EEnum;
	}

	private GenParserImplementation getOrCreateEnumParser(FeatureLabelMapping flMapping) {
		for (GenParserImplementation pi : getGenParsers().getImplementations()) {
			if (pi instanceof PredefinedEnumParser) {
				return (PredefinedEnumParser) pi;
			}
		}
		PredefinedEnumParser result = GMFGenFactory.eINSTANCE.createPredefinedEnumParser();
		getGenParsers().getImplementations().add(result);
		return result;
	}

	private GenParserImplementation createOclChoiceParser(OclChoiceLabelMapping oclMapping) {
		OclChoiceParser result = GMFGenFactory.eINSTANCE.createOclChoiceParser();
		if (oclMapping.getItemsExpression() != null) {
			result.setItemsExpression(createValueExpression(oclMapping.getItemsExpression()));
		}
		if (oclMapping.getShowExpression() != null) {
			result.setShowExpression(createValueExpression(oclMapping.getShowExpression()));
		}
		getGenParsers().getImplementations().add(result);
		return result;
	}

	private GenParserImplementation getOrCreatePredefinedParser(FeatureLabelMapping flMapping) {
		final LabelTextAccessMethod editMethod = LabelTextAccessMethod.get(flMapping.getEditMethod().getValue());
		final LabelTextAccessMethod viewMethod = LabelTextAccessMethod.get(flMapping.getViewMethod().getValue());
		for (GenParserImplementation pi : getGenParsers().getImplementations()) {
			if (pi instanceof PredefinedParser) {
				PredefinedParser pp = (PredefinedParser) pi;
				boolean same = pp.getEditMethod() == editMethod;
				same &= pp.getViewMethod() == viewMethod;
				if (same) {
					return pp;
				}
			}
		}
		PredefinedParser result = GMFGenFactory.eINSTANCE.createPredefinedParser();
		result.setEditMethod(editMethod);
		result.setViewMethod(viewMethod);
		getGenParsers().getImplementations().add(result);
		return result;
	}

	private GenParserImplementation getOrCreateParser(DesignLabelMapping flMapping) {
		if (myDesignLabelParser == null) {
			myDesignLabelParser = GMFGenFactory.eINSTANCE.createExternalParser();
			getGenParsers().getImplementations().add(myDesignLabelParser);
		}
		return myDesignLabelParser;
	}

	private GenParserImplementation getOrCreateParser(LabelMapping flMapping) {
		if (myAuxParser == null) {
			myAuxParser = GMFGenFactory.eINSTANCE.createExternalParser();
			getGenParsers().getImplementations().add(myAuxParser);
		}
		return myAuxParser;
	}
}
