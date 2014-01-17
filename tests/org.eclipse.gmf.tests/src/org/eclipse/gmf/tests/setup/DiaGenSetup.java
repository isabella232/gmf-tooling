/*
 * Copyright (c) 2005, 2008 Borland Software Corporation
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


import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenConstraint;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenDomainElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenLanguage;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenSeverity;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.internal.bridge.DistinctTopLevelNodesFactoryGate;
import org.eclipse.gmf.internal.bridge.NaiveIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelMatcher;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.internal.bridge.genmodel.RuntimeGenModelAccess;
import org.eclipse.gmf.internal.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.internal.bridge.naming.gen.GenNamingMediatorImpl;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.Utils;

/**
 * @author artem
 */
public class DiaGenSetup implements DiaGenSource {
	private GenDiagram myGenDiagram;
	private GenTopLevelNode myNodeA;
	private GenLink myLinkC;
	private GenLink myLinkD;
	private GenNode myNodeB;
	private ViewmapProducer myViewmapProducer;

	public DiaGenSetup() {
		this(new InnerClassViewmapProducer());
	}

	public DiaGenSetup(ViewmapProducer viewmapProducer) {
		myViewmapProducer = viewmapProducer;
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public DiaGenSetup init(DomainModelSource domainSource) {
		final GenModel runtimeModel = getRuntimeGenModel();
		assert runtimeModel != null;
		final GenModelMatcher gmm = new GenModelMatcher(Utils.createGenModel(domainSource.getModel()));
		myGenDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		GenEditorGenerator genBurden = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		myGenDiagram.setDomainDiagramElement(gmm.findGenClass(domainSource.getDiagramElement()));
		genBurden.setDomainGenModel(myGenDiagram.getDomainDiagramElement().getGenModel());
		genBurden.setEditor(GMFGenFactory.eINSTANCE.createGenEditorView());
		myGenDiagram.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, NotationPackage.eINSTANCE.getDiagram()));
		myGenDiagram.setPalette(createPalette());
		myGenDiagram.setViewmap(createDiagramViewmap());
		myGenDiagram.setVisualID(99);
		MetamodelType dgmmType = GMFGenFactory.eINSTANCE.createMetamodelType();
		myGenDiagram.setElementType(dgmmType);
		genBurden.setDiagram(myGenDiagram);
		genBurden.setPlugin(GMFGenFactory.eINSTANCE.createGenPlugin());
		genBurden.setDiagramUpdater(GMFGenFactory.eINSTANCE.createGenDiagramUpdater());
		genBurden.setLabelParsers(GMFGenFactory.eINSTANCE.createGenParsers());

		myNodeA = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		myNodeA.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, NotationPackage.eINSTANCE.getNode()));
		myNodeA.setModelFacet(createNodeModelFacet(gmm, domainSource.getNodeA()));
		myNodeA.setElementType(GMFGenFactory.eINSTANCE.createMetamodelType());
		EAttribute editFeature = domainSource.getNodeA().getNameAttr();
		if (editFeature != null) {
			FeatureLabelModelFacet modelFacet = GMFGenFactory.eINSTANCE.createFeatureLabelModelFacet();
			modelFacet.getMetaFeatures().add(gmm.findGenFeature(editFeature));
			GenNodeLabel label = GMFGenFactory.eINSTANCE.createGenNodeLabel();
			label.setModelFacet(modelFacet);
			label.setVisualID(401);
			label.setViewmap(createLabelViewmap());
			label.setDiagramRunTimeClass(myNodeA.getDiagramRunTimeClass());
			myNodeA.getLabels().add(label);
			modelFacet.setParser(GMFGenFactory.eINSTANCE.createExternalParser());
			genBurden.getLabelParsers().getImplementations().add(modelFacet.getParser());
		}
		myNodeA.setViewmap(createNodeViewmap());
		myNodeA.setVisualID(100);

		myLinkC = GMFGenFactory.eINSTANCE.createGenLink();
		myLinkC.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, NotationPackage.eINSTANCE.getEdge()));
		myLinkC.setModelFacet(createLinkModelFacet(gmm, domainSource.getLinkAsClass()));
		myLinkC.setViewmap(createLinkViewmap());
		myLinkC.setVisualID(200);
		myLinkC.setElementType(GMFGenFactory.eINSTANCE.createMetamodelType());
		// TODO add linkRefOnly
		myGenDiagram.getTopLevelNodes().add(myNodeA);
		myGenDiagram.getLinks().add(myLinkC);

		GenExpressionProviderContainer providerContainer = GMFGenFactory.eINSTANCE.createGenExpressionProviderContainer();
		myGenDiagram.getEditorGen().setExpressionProviders(providerContainer);
		myGenDiagram.getEditorGen().setAudits(createAudits(providerContainer));
		confineInResource();
		return this;
	}

	private static Viewmap createLinkViewmap() {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx");
		return v;
	}

	private static Viewmap createNodeViewmap() {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.draw2d.RoundedRectangle");
		return v;
	}

	private static Viewmap createDiagramViewmap() {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.draw2d.FreeformLayer");
		return v;
	}

	private static Viewmap createLabelViewmap() {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.draw2d.Label");
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
		DiagramGenModelTransformer.Parameters opts = new DiagramGenModelTransformer.Parameters(
				new BasicDiagramRunTimeModelHelper(), // 
				myViewmapProducer, //
				new DistinctTopLevelNodesFactoryGate(), //
				new NaiveIdentifierDispenser(), false);
		DiagramGenModelTransformer t = new DiagramGenModelTransformer(opts);
		t.setEMFGenModel(initGenModel(mapSource.getMapping().getDiagram().getDomainModel()));
		t.transform(mapSource.getMapping());
		new GenNamingMediatorImpl().traverse(t.getResult());
		myGenDiagram = t.getResult().getDiagram();
		
		myNodeA = findTheOnlyTopLevelNodeFor(t, mapSource.getNodeA());
		myNodeB = mapSource.getNodeB() == null ? null : findTheOnlyTopLevelNodeFor(t, mapSource.getNodeB());
		myLinkC = t.getTrace().findLink(mapSource.getClassLink());
		myLinkD = t.getTrace().findLink(mapSource.getReferenceLink());
		if (mapSource instanceof MapSetup) {
			initSpecific((MapSetup) mapSource);
		}
		assert myNodeA != null;
		assert myLinkC != null;
		assert myLinkD != null;
		confineInResource();
		return this;
	}
	
	private void initSpecific(MapSetup setup) {
		for (GenLink nextLink : myGenDiagram.getLinks()) {
			if (nextLink == myLinkC || nextLink == myLinkD) {
				continue;
			}
			if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
				TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
				nextLink.setIncomingCreationAllowed(true);
				if (isSelfLink(modelFacet) || modelFacet.getContainmentMetaFeature().getEcoreFeature().getUpperBound() > 1) {
					nextLink.setOutgoingCreationAllowed(true);					
				} else {
					nextLink.setOutgoingCreationAllowed(false);
				}
			} else if (nextLink.getModelFacet() instanceof FeatureLinkModelFacet) {
				FeatureLinkModelFacet modelFacet = (FeatureLinkModelFacet) nextLink.getModelFacet();
				nextLink.setIncomingCreationAllowed(true);
				if (isSelfLink(modelFacet) || modelFacet.getMetaFeature().getEcoreFeature().getUpperBound() > 1) {
					nextLink.setOutgoingCreationAllowed(true);
				} else {
					nextLink.setOutgoingCreationAllowed(false);
				}
			}
		}
	}
	
	private boolean isSelfLink(FeatureLinkModelFacet modelFacet) {
		return modelFacet.getMetaFeature().getTypeGenClass() == modelFacet.getMetaFeature().getGenClass();
	}

	private boolean isSelfLink(TypeLinkModelFacet modelFacet) {
		return modelFacet.getTargetMetaFeature().getTypeGenClass() == modelFacet.getContainmentMetaFeature().getGenClass();
	}

	protected GenModel initGenModel(EPackage domainModel) {
		return Utils.createGenModel(domainModel);
	}
	
	private void confineInResource() {
		new ResourceImpl(URI.createURI("uri://org.eclipse.gmf/tests/DiaGenSetup")).getContents().add(myGenDiagram.getEditorGen());
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

	private GenAuditRoot createAudits(GenExpressionProviderContainer providerContainer) {
		GenClass classA = getNodeA().getDomainMetaClass();
		assert getLinkC().getModelFacet() instanceof TypeLinkModelFacet : "Expecting link with class"; //$NON-NLS-1$
		GenClass classC = ((TypeLinkModelFacet)getLinkC().getModelFacet()).getMetaClass();
		GenAuditRoot root = GMFGenFactory.eINSTANCE.createGenAuditRoot();
		GenAuditContainer topCat = createAuditContainer(Plugin.getPluginID() + ".category1" + System.currentTimeMillis()); //$NON-NLS-1$
		root.getCategories().add(topCat);
		topCat.getPath().add(topCat);
		// create set of allways satisfied constraints
		topCat.getAudits().add(createAudit("constraint.id1", "true", classA, GenSeverity.ERROR_LITERAL, false)); //$NON-NLS-1$ //$NON-NLS-2$
		topCat.getAudits().add(createAudit("constraint.id2", "10 > 0", classC, GenSeverity.WARNING_LITERAL, false));	//$NON-NLS-1$ //$NON-NLS-2$
		root.getRules().addAll(topCat.getAudits());

		GenAuditContainer subCat = createAuditContainer("category2"); //$NON-NLS-1$
		root.getCategories().add(subCat);
		subCat.getPath().add(topCat);
		subCat.getPath().add(subCat);
		subCat.getAudits().add(createAudit("constraint.id3", "''<>'Foo'", classA, GenSeverity.INFO_LITERAL, false)); //$NON-NLS-1$ //$NON-NLS-2$
		root.getRules().addAll(subCat.getAudits());

		GenExpressionInterpreter provider = GMFGenFactory.eINSTANCE.createGenExpressionInterpreter();
		provider.setLanguage(GenLanguage.OCL_LITERAL);
		providerContainer.getProviders().add(provider);
		for (GenAuditRule a : root.getRules()) {
			provider.getExpressions().add(a.getRule());
		}
		
		return root;
	}
	
	private GenAuditRule createAudit(String id, String ruleBody, GenClass target, GenSeverity severity, boolean isLiveMode) {
		GenAuditRule audit = GMFGenFactory.eINSTANCE.createGenAuditRule();
		audit.setId(id);
		audit.setName("Name of" + id); //$NON-NLS-1$
		GenDomainElementTarget ruleTarget = GMFGenFactory.eINSTANCE.createGenDomainElementTarget();
		ruleTarget.setElement(target);
		audit.setTarget(ruleTarget);
		GenConstraint rule = GMFGenFactory.eINSTANCE.createGenConstraint();
		rule.setBody(ruleBody);
		audit.setRule(rule);
		
		audit.setSeverity(severity);
		audit.setUseInLiveMode(isLiveMode);
		return audit;
	}
	private GenAuditContainer createAuditContainer(String id) {
		GenAuditContainer container = GMFGenFactory.eINSTANCE.createGenAuditContainer();		
		container.setId(id);
		container.setName("Name of " + id); //$NON-NLS-1$
		container.setDescription("Description of " + id); //$NON-NLS-1$
		return container;
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
	
	private static GenTopLevelNode findTheOnlyTopLevelNodeFor(DiagramGenModelTransformer t, NodeMapping nodeMapping) {
		GenNode[] all = t.getTrace().findAllNodesFor(nodeMapping);
		for (int i = 0; i < all.length; i++) {
			if (all[i] instanceof GenTopLevelNode) {
				return (GenTopLevelNode) all[i];
			}
		}
		return null;
	}

}