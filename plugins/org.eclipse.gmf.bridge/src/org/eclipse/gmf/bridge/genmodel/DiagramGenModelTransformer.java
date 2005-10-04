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

import java.util.Iterator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.codegen.gmfgen.CompartmentLayoutKind;
import org.eclipse.gmf.codegen.gmfgen.DecoratedConnectionViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkReferenceOnly;
import org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.LinkDecoration;
import org.eclipse.gmf.codegen.gmfgen.LinkEntry;
import org.eclipse.gmf.codegen.gmfgen.NodeEntry;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ShapeAttributes;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.diadef.AdornmentKind;
import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.diadef.DiagramElement;
import org.eclipse.gmf.diadef.LineKind;
import org.eclipse.gmf.diadef.Node;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;

/**
 * Creates generation model from diagram definition.
 * @author artem
 */
public class DiagramGenModelTransformer extends MappingTransofrmer {
	private static final int CANVAS_COUNT_BASE = 79;
	private static final int NODE_COUNT_BASE = 100;
	private static final int CHILD_COUNT_BASE = 200;
	private static final int LINK_COUNT_BASE = 300;

	private GenDiagram myGenModel;
	private GenModelMatcher myGenModelMatch;
	private final DiagramRunTimeModelHelper myDRTHelper;
	private final NamingStrategy myEditPartNamingStrategy;
	private final NamingStrategy myMetaInfoNamingStrategy;
	private int myNodeCount = 0;
	private int myLinkCount = 0;
	private int myChildCount = 0;

	public DiagramGenModelTransformer(DiagramRunTimeModelHelper drtHelper, NamingStrategy editPartNaming, NamingStrategy metaInfoNaming) {
		myDRTHelper = drtHelper;
		myEditPartNamingStrategy = editPartNaming;
		myMetaInfoNamingStrategy = metaInfoNaming;
	}

	/**
	 * Optionally set GenModel to match ECore elements against. 
	 * Should be invoked prior to {@link MappingTransofrmer#transform(Mapping)}, otherwise has no effect.
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
		getGenDiagram().setMetaInfoProviderClassName(createMetaInfoProviderClassName(mapping));
		getGenDiagram().setDiagramRunTimeClass(findRunTimeClass(mapping));
		getGenDiagram().setVisualID(CANVAS_COUNT_BASE);
		getGenDiagram().setPluginName(mapping.getDomainModel().getName() + " Plugin");
	}

	protected void process(NodeMapping nme) {
		assert nme.getDomainMetaElement() != null;
		assert nme.getDiagramNode() != null;
		assert checkDirectEditAttrValidity(nme);
		GenNode genNode = GMFGenFactory.eINSTANCE.createGenNode();
		getGenDiagram().getNodes().add(genNode);
		genNode.setDiagramRunTimeClass(findRunTimeClass(nme));
		genNode.setDomainMetaClass(findGenClass(nme.getDomainMetaElement()));
		genNode.setContainmentMetaFeature(findGenFeature(nme.getContainmentFeature()));
		genNode.setVisualID(NODE_COUNT_BASE + (++myNodeCount));
		if (getGenDiagram().getDomainMetaModel() != null) {
			assert getGenDiagram().getDomainMetaModel() == nme.getDomainMetaElement().getEPackage();
		}
		if (nme.getEditFeature() != null) {
			genNode.setDomainNameFeature(findGenFeature(nme.getEditFeature()));
		}
		genNode.setEditPartClassName(createEditPartClassName(nme));
		genNode.setMetaInfoProviderClassName(createMetaInfoProviderClassName(nme));
		genNode.setViewmap(GMFGenFactory.eINSTANCE.createBasicNodeViewmap());
		// XXX nme.getDiagramNode.isSetDefaultWidth add DefaultSizeAttributes to viewmap
		handleToolDef(nme.getDiagramNode(), genNode);
		for (Iterator it = nme.getDiagramNode().getCompartments().iterator(); it.hasNext();) {
			Compartment compartment = (Compartment) it.next();
			GenChildContainer childContainer = GMFGenFactory.eINSTANCE.createGenChildContainer();
			childContainer.setGroupID(compartment.getName());
			childContainer.setCanCollapse(compartment.isCollapsible());
			childContainer.setNeedsTitle(compartment.isNeedsTitle());
			childContainer.setLayoutKind(CompartmentLayoutKind.TOOLBAR_LITERAL);
			childContainer.setTitleKey(compartment.getName());
			genNode.getChildContainers().add(childContainer);
		}

		for (Iterator it = nme.getChildMappings().iterator(); it.hasNext();) {
			ChildNodeMapping childNodeMapping = (ChildNodeMapping) it.next();
			GenChildNode childNode = GMFGenFactory.eINSTANCE.createGenChildNode();
			assert childNodeMapping.getDomainChildrenFeature() instanceof EReference;
			assert childNodeMapping.getDomainChildrenFeature().getEType() instanceof EClass;
			childNode.setContainmentMetaFeature(findGenFeature(childNodeMapping.getDomainChildrenFeature()));
			
			if (childNodeMapping.getDomainMetaElement() != null) {
				childNode.setDomainMetaClass(findGenClass(childNodeMapping.getDomainMetaElement()));
			} else {
				childNode.setDomainMetaClass(findGenClass((EClass) childNodeMapping.getDomainChildrenFeature().getEType()));
			}
			
			childNode.setDiagramRunTimeClass(findRunTimeClass(childNodeMapping));
			childNode.setEditPartClassName(createEditPartClassName(childNodeMapping));
			childNode.setMetaInfoProviderClassName(createMetaInfoProviderClassName(childNodeMapping));
			childNode.setGroupID(childNodeMapping.getCompartment().getName());
			childNode.setVisualID(CHILD_COUNT_BASE + (++myChildCount ));
			
			if (childNodeMapping.getEditFeature() != null) {
				childNode.setDomainNameFeature(findGenFeature(childNodeMapping.getEditFeature()));
			}
			
			genNode.getChildNodes().add(childNode);
			handleToolDef(childNodeMapping.getDiagramNode(), childNode);
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
		GenLink gl;
		if (lme.getDomainMetaElement() != null) {
			GenLinkWithClass genLink = GMFGenFactory.eINSTANCE.createGenLinkWithClass();
			getGenDiagram().getLinks().add(genLink);
			genLink.setDomainMetaClass(findGenClass(lme.getDomainMetaElement()));
			genLink.setDomainLinkTargetFeature(findGenFeature(lme.getLinkMetaFeature()));
			gl = genLink;
		} else {
			GenLinkReferenceOnly genLink = GMFGenFactory.eINSTANCE.createGenLinkReferenceOnly();
			getGenDiagram().getLinks().add(genLink);
			genLink.setDomainLinkTargetFeature(findGenFeature(lme.getLinkMetaFeature()));
			gl = genLink;
		}
		if (lme.getDiagramLink().isNeedsTool()) {
			LinkEntry le = GMFGenFactory.eINSTANCE.createLinkEntry();
			findToolGroup(lme.getDiagramLink().getToolGroupID()).getLinkTools().add(le);
			le.setGenLink(gl);
			setupCommonToolEntry(le, lme.getDiagramLink());
		}
		gl.setDomainNameFeature(findGenFeature(lme.getLabelEditFeature()));
		gl.setDiagramRunTimeClass(findRunTimeClass(lme));
		gl.setEditPartClassName(createEditPartClassName(lme));
		gl.setMetaInfoProviderClassName(createMetaInfoProviderClassName(lme));
		gl.setContainmentMetaFeature(findGenFeature(lme.getContainmentFeature()));
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

	private String createMetaInfoProviderClassName(NodeMapping nme) {
		return myMetaInfoNamingStrategy.createClassName(nme);
	}

	private String createMetaInfoProviderClassName(LinkMapping lme) {
		return myMetaInfoNamingStrategy.createClassName(lme);
	}

	private String createMetaInfoProviderClassName(CanvasMapping mapping) {
		return myMetaInfoNamingStrategy.createClassName(mapping);
	}

	private String createMetaInfoProviderClassName(ChildNodeMapping chnme) {
		return myMetaInfoNamingStrategy.createClassName(chnme);
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
}
