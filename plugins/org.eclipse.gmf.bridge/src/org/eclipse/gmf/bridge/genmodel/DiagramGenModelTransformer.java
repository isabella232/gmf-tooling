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
import org.eclipse.gmf.codegen.gmfgen.CompartmentLayoutKind;
import org.eclipse.gmf.codegen.gmfgen.CompartmentPlacementKind;
import org.eclipse.gmf.codegen.gmfgen.DecoratedConnectionViewmap;
import org.eclipse.gmf.codegen.gmfgen.FeatureModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenElementInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureValueSpec;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
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
import org.eclipse.gmf.diadef.AdornmentKind;
import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.diadef.DiagramElement;
import org.eclipse.gmf.diadef.LineKind;
import org.eclipse.gmf.diadef.Node;
import org.eclipse.gmf.mappings.AbstractNodeMapping;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.ElementInitializer;
import org.eclipse.gmf.mappings.FeatureSeqInitializer;
import org.eclipse.gmf.mappings.FeatureValueSpec;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;

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
	private final NamingStrategy myEditPartNamingStrategy;
	private final NamingStrategy myNotationViewFactoryNamingStrategy;

	private int myNodeCount = 0;
	private int myLinkCount = 0;
	private int myChildCount = 0;
	private int myLabelCount = 0;
	private int myCompartmentCount = 0;

	public DiagramGenModelTransformer(DiagramRunTimeModelHelper drtHelper, NamingStrategy editPartNaming, NamingStrategy notationViewFactoryNaming) {
		myDRTHelper = drtHelper;
		myEditPartNamingStrategy = editPartNaming;
		myNotationViewFactoryNamingStrategy = notationViewFactoryNaming;
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
		getGenDiagram().setEditPartClassName(createEditPartClassName(mapping));
		getGenDiagram().setDiagramRunTimeClass(findRunTimeClass(mapping));
		getGenDiagram().setVisualID(CANVAS_COUNT_BASE);
		getGenDiagram().setPluginName(mapping.getDomainModel().getName() + " Plugin");
		getGenDiagram().setViewmap(GMFGenFactory.eINSTANCE.createDiagramViewmap());
	}

	protected void process(NodeMapping nme) {
		assert nme.getDomainMetaElement() != null;
		assert nme.getDiagramNode() != null;
		assert checkDirectEditAttrValidity(nme);
// TODO: add this assertion?
//		assert nme.getContainmentFeature().getEType() instanceof EClass;
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
			label.setNotationViewFactoryClassName(createLabelTextNotationViewFactoryClassName(nme));
			genNode.getLabels().add(label);
		}
		genNode.setEditPartClassName(createEditPartClassName(nme));
		genNode.setNotationViewFactoryClassName(createNotationViewFactoryClassName(nme));
		genNode.setViewmap(GMFGenFactory.eINSTANCE.createBasicNodeViewmap());
		// XXX nme.getDiagramNode.isSetDefaultWidth add DefaultSizeAttributes to viewmap
		handleToolDef(nme.getDiagramNode(), genNode);
		
		processAbstractNode(nme, genNode);
	}
	
	private void process(ChildNodeMapping childNodeMapping, GenChildContainer container) {
		GenChildNode childNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		assert childNodeMapping.getContainmentFeature().getEType() instanceof EClass;
		assert childNodeMapping.getDiagramNode() != null;
//		TODO: add one mode assertion?
//		assert checkDirectEditAttrValidity(nme);
		
		if (childNodeMapping.getDomainMetaElement() != null) {
			childNode.setModelFacet(createModelFacet(childNodeMapping));
		} else {
			childNode.setModelFacet(setupModelFacet((EClass) childNodeMapping.getContainmentFeature().getEType(), childNodeMapping.getContainmentFeature(), null));
		}
		
		childNode.setDiagramRunTimeClass(findRunTimeClass(childNodeMapping));
		childNode.setViewmap(GMFGenFactory.eINSTANCE.createBasicNodeViewmap());
		childNode.setEditPartClassName(createEditPartClassName(childNodeMapping));
		childNode.setNotationViewFactoryClassName(createNotationViewFactoryClassName(childNodeMapping));
		childNode.setVisualID(CHILD_COUNT_BASE + (++myChildCount ));
		childNode.setChildContainersPlacement(CompartmentPlacementKind.TOOLBAR_LITERAL);
		
		if (childNodeMapping.getEditFeature() != null) {
			FeatureModelFacet modelFacet = GMFGenFactory.eINSTANCE.createFeatureModelFacet();
			modelFacet.setMetaFeature(findGenFeature(childNodeMapping.getEditFeature()));
			GenNodeLabel label = GMFGenFactory.eINSTANCE.createGenNodeLabel();
			label.setModelFacet(modelFacet);
			label.setVisualID(LABEL_COUNT_BASE + (++myLabelCount));
			label.setDiagramRunTimeClass(getNodeLabelRunTimeClass());
			label.setViewmap(GMFGenFactory.eINSTANCE.createLabelViewmap());
			label.setNotationViewFactoryClassName(createLabelTextNotationViewFactoryClassName(childNodeMapping));
			childNode.getLabels().add(label);
		}

		container.getChildNodes().add(childNode);
		handleToolDef(childNodeMapping.getDiagramNode(), childNode);
		processAbstractNode(childNodeMapping, childNode);
		
		if (childNodeMapping.getDiagramNode().getCompartments().size() > 0 || childNodeMapping.getChildMappings().size() > 0) {
			if (container instanceof GenNode) {
				((GenNode) container).setChildContainersPlacement(CompartmentPlacementKind.FLOW_LITERAL);
			} else if (container instanceof GenCompartment) {
				((GenCompartment) container).setLayoutKind(CompartmentLayoutKind.XY_LITERAL);
			}
		}
	}
	
	private void processAbstractNode(AbstractNodeMapping mapping, GenNode genNode) {
		Map compartment2GenMap = new HashMap();
		for (Iterator it = mapping.getDiagramNode().getCompartments().iterator(); it.hasNext();) {
			Compartment compartment = (Compartment) it.next();
			GenCompartment childCompartment = GMFGenFactory.eINSTANCE.createGenCompartment();
			childCompartment.setVisualID(COMPARTMENT_COUNT_BASE + (++myCompartmentCount));
			childCompartment.setDiagramRunTimeClass(getChildContainerRunTimeClass());
			childCompartment.setViewmap(GMFGenFactory.eINSTANCE.createCompartmentViewmap());
			childCompartment.setCanCollapse(compartment.isCollapsible());
			childCompartment.setNeedsTitle(compartment.isNeedsTitle());
			childCompartment.setLayoutKind(CompartmentLayoutKind.TOOLBAR_LITERAL);
			childCompartment.setTitle(compartment.getName());
			childCompartment.setEditPartClassName(createEditPartClassName(compartment));
			childCompartment.setNotationViewFactoryClassName(createNotationViewFactoryClassName(compartment));
			genNode.getCompartments().add(childCompartment);
			compartment2GenMap.put(compartment, childCompartment);
		}
		
		for (Iterator it = mapping.getChildMappings().iterator(); it.hasNext();) {
			ChildNodeMapping childNodeMapping = (ChildNodeMapping) it.next();
			Compartment parentCompartment = childNodeMapping.getCompartment();
			GenChildContainer container;
			if (parentCompartment == null || !compartment2GenMap.containsKey(parentCompartment)) {
				container = genNode;
			} else {
				container = (GenChildContainer) compartment2GenMap.get(parentCompartment);
			}
			process(childNodeMapping, container);
		}
	}

	private void handleToolDef(Node nodeToolDef, GenNode genNode) {
		if (nodeToolDef.isNeedsTool()) {
			NodeEntry ne = GMFGenFactory.eINSTANCE.createNodeEntry();
			findToolGroup(nodeToolDef.getToolGroupID()).getNodeTools().add(ne);
			ne.setGenNode(genNode);
			setupCommonToolEntry(ne, nodeToolDef);
		}
	}

	protected void process(LinkMapping lme) {
		assert lme.getDiagramLink() != null;
		assert lme.getLinkMetaFeature() != null;
		GenLink gl = GMFGenFactory.eINSTANCE.createGenLink();
		getGenDiagram().getLinks().add(gl);
		gl.setModelFacet(createModelFacet(lme));
		if (lme.getDiagramLink().isNeedsTool()) {
			LinkEntry le = GMFGenFactory.eINSTANCE.createLinkEntry();
			findToolGroup(lme.getDiagramLink().getToolGroupID()).getLinkTools().add(le);
			le.setGenLink(gl);
			setupCommonToolEntry(le, lme.getDiagramLink());
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
			label.setNotationViewFactoryClassName(createLabelNotationViewFactoryClassName(lme));
			label.setTextNotationViewFactoryClassName(createLabelTextNotationViewFactoryClassName(lme));
			gl.getLabels().add(label);
		}
		gl.setDiagramRunTimeClass(findRunTimeClass(lme));
		gl.setEditPartClassName(createEditPartClassName(lme));
		gl.setNotationViewFactoryClassName(createNotationViewFactoryClassName(lme));
		gl.setVisualID(LINK_COUNT_BASE + (++myLinkCount));

		initViewmap(lme, gl);

		LineKind lineKind = lme.getDiagramLink().getLineKind();
		if (lineKind != null) {
			ShapeAttributes attrs = GMFGenFactory.eINSTANCE.createShapeAttributes();
			switch (lineKind.getValue()) {
			case LineKind.SOLID : attrs.setLineStyle("LINE_SOLID"); break;
			case LineKind.DOT : attrs.setLineStyle("LINE_DOT"); break;
			case LineKind.DASH : attrs.setLineStyle("LINE_DASH"); break;
			}
			gl.getViewmap().getAttributes().add(attrs);
		}
	}

	private void initViewmap(LinkMapping lme, GenLink gl) {
		if (lme.getDiagramLink().getSourceAdornment() != null || lme.getDiagramLink().getTargetAdornment() != null) {
			DecoratedConnectionViewmap viewmap = GMFGenFactory.eINSTANCE.createDecoratedConnectionViewmap();
			LinkDecoration d = decorationFromAdornment(lme.getDiagramLink().getSourceAdornment());
			if (d != null) {
				viewmap.setSource(d);
			}
			d = decorationFromAdornment(lme.getDiagramLink().getTargetAdornment());
			if (d != null) {
				viewmap.setTarget(d);
			}
			gl.setViewmap(viewmap);
		} else {
			// XXX actually, another viewmap should be here
			gl.setViewmap(GMFGenFactory.eINSTANCE.createDecoratedConnectionViewmap());
		}
	}

	//

	private String createEditPartClassName(NodeMapping nme) {
		return myEditPartNamingStrategy.createClassName(nme);
	}
	
	private String createEditPartClassName(Compartment compartment) {
		return myEditPartNamingStrategy.createClassName(compartment);
	}

	private String createEditPartClassName(LinkMapping lme) {
		return myEditPartNamingStrategy.createClassName(lme);
	}

	private String createEditPartClassName(CanvasMapping mapping) {
		return myEditPartNamingStrategy.createClassName(mapping);
	}

	private String createEditPartClassName(ChildNodeMapping chnme) {
		return myEditPartNamingStrategy.createClassName(chnme);
	}

	//

	private String createNotationViewFactoryClassName(NodeMapping nme) {
		return myNotationViewFactoryNamingStrategy.createClassName(nme);
	}
	
	private String createLabelTextNotationViewFactoryClassName(NodeMapping nme) {
		return myNotationViewFactoryNamingStrategy.createLableTextClassName(nme);
	}	

	private String createLabelTextNotationViewFactoryClassName(ChildNodeMapping chnme) {
		return myNotationViewFactoryNamingStrategy.createLableTextClassName(chnme);
	}	
	
	private String createNotationViewFactoryClassName(Compartment compartment) {
		return myNotationViewFactoryNamingStrategy.createClassName(compartment);
	}
	
	private String createNotationViewFactoryClassName(LinkMapping lme) {
		return myNotationViewFactoryNamingStrategy.createClassName(lme);
	}

	private String createLabelNotationViewFactoryClassName(LinkMapping lme) {
		return myNotationViewFactoryNamingStrategy.createLableClassName(lme);
	}	
	
	private String createLabelTextNotationViewFactoryClassName(LinkMapping lme) {
		return myNotationViewFactoryNamingStrategy.createLableTextClassName(lme);
	}	

	private String createNotationViewFactoryClassName(ChildNodeMapping chnme) {
		return myNotationViewFactoryNamingStrategy.createClassName(chnme);
	}

	//

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

	private LinkDecoration decorationFromAdornment(AdornmentKind adornment) {
		String figureClassName = figureClassFromAdornment(adornment);
		if (figureClassName == null) {
			return null;
		}
		LinkDecoration d = GMFGenFactory.eINSTANCE.createLinkDecoration();
		d.setFigureQualifiedClassName(figureClassName);
		return d;
	}

	private String figureClassFromAdornment(AdornmentKind adornment) {
		if (adornment == null) {
			return null;
		}
		switch (adornment.getValue()) {
		case AdornmentKind.OPEN_TRIANGLE : return "org.eclipse.draw2d.PolylineDecoration";
		case AdornmentKind.FILLED_TRIANGLE : return "org.eclipse.draw2d.PolygonDecoration";
		case AdornmentKind.RHOMB : return "org.eclipse.gmf.draw2d.RhombDecoration";
		case AdornmentKind.FILLED_RHOMB : return "org.eclipse.gmf.draw2d.FilledRhombDecoration";
		}
		return null;
	}

	private void setupCommonToolEntry(ToolEntry te, DiagramElement diagramElement) {
		final String elementName = diagramElement.getName();
		if (diagramElement.getLargeIconPath() == null) {
			te.setLargeIconPath("icons/large/" + elementName + ".gif");
		} else {
			te.setLargeIconPath(diagramElement.getLargeIconPath());
		}
		if (diagramElement.getSmallIconPath() == null) {
			// XXX never gets here as long the same code is inside DiagramElementImpl.getSmallIconPath()
			te.setSmallIconPath("icons/small/" + elementName + ".gif");
		} else {
			te.setSmallIconPath(diagramElement.getSmallIconPath());
		}
		te.setTitleKey(elementName);
		te.setDescriptionKey(elementName);
	}

	private ToolGroup findToolGroup(String id) {
		id = id == null ? "" : id;
		for (Iterator it = getGenPalette().getGroups().iterator(); it.hasNext();) {
			ToolGroup next = (ToolGroup) it.next();
			if (id.equals(next.getTitleKey())) {
				return next;
			}
		}
		ToolGroup tg = GMFGenFactory.eINSTANCE.createToolGroup();
		getGenPalette().getGroups().add(tg);
		tg.setTitleKey(id);
		return tg;
	}

	private boolean checkDirectEditAttrValidity(NodeMapping nme) {
		if (nme.getEditFeature() == null) {
			return true;
		}
		EClassifier attrContainer = nme.getEditFeature().getEContainingClass();
		return attrContainer == nme.getDomainMetaElement() || nme.getDomainMetaElement().getEAllSuperTypes().contains(attrContainer);
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
		TypeModelFacet typeModelFacet = setupModelFacet(anm.getDomainMetaElement(), anm.getContainmentFeature(), null);
		return setupAux(typeModelFacet, anm.getDomainSpecialization(), anm.getDomainInitializer());
	}

	private LinkModelFacet createModelFacet(LinkMapping lme) {
		if (lme.getDomainMetaElement() != null) {
			TypeLinkModelFacet mf = GMFGenFactory.eINSTANCE.createTypeLinkModelFacet();
			mf.setMetaClass(findGenClass(lme.getDomainMetaElement()));
			mf.setContainmentMetaFeature(findGenFeature(lme.getContainmentFeature()));
			mf.setChildMetaFeature(mf.getContainmentMetaFeature());
			mf.setTargetMetaFeature(findGenFeature(lme.getLinkMetaFeature()));
			setupAux(mf, lme.getDomainSpecialization(), lme.getDomainInitializer());
			return mf;
		} else {
			FeatureModelFacet mf = GMFGenFactory.eINSTANCE.createFeatureModelFacet();
			mf.setMetaFeature(findGenFeature(lme.getLinkMetaFeature()));
			return mf;
		}
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
	
	private static ModelElementSelector createModelElementSelector(Constraint metaElementConstraint) {
		ModelElementSelector modelElementSelector = GMFGenFactory.eINSTANCE.createModelElementSelector();
		modelElementSelector.setBody(metaElementConstraint.getBody());
		modelElementSelector.setLanguage(metaElementConstraint.getLanguage());		
		return modelElementSelector;
	}
}
