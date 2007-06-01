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
package org.eclipse.gmf.internal.sketch.transformer.reconcile;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.internal.codegen.util.VisualIDMatcher;
import org.eclipse.gmf.internal.common.reconcile.Copier;
import org.eclipse.gmf.internal.common.reconcile.Decision;
import org.eclipse.gmf.internal.common.reconcile.DefaultDecision;
import org.eclipse.gmf.internal.common.reconcile.ReconcilerConfigBase;

/**
 * @author dstadnik
 */
public class SketchReconcilerConfig extends ReconcilerConfigBase {

	private final GMFGenPackage GMFGEN = GMFGenPackage.eINSTANCE;

	public SketchReconcilerConfig() {
		setMatcher(GMFGEN.getGenEditorGenerator(), ALWAYS_MATCH);
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_CopyrightText());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_PackageNamePrefix());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_DomainFileExtension());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_DiagramFileExtension());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_SameFileForDiagramAndModel());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_ModelID());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_DynamicTemplates());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_TemplateDirectory());
		addDecision(GMFGEN.getGenEditorGenerator(), new Decision.ALWAYS_OLD(GMFGEN.getGenEditorGenerator_Plugin()));
		addDecision(GMFGEN.getGenEditorGenerator(), new Decision.ALWAYS_OLD(GMFGEN.getGenEditorGenerator_Editor()));
		addDecision(GMFGEN.getGenEditorGenerator(), new Decision.ALWAYS_OLD(GMFGEN.getGenEditorGenerator_DiagramUpdater()));
		addDecision(GMFGEN.getGenEditorGenerator(), new Decision.ALWAYS_OLD(GMFGEN.getGenEditorGenerator_PropertySheet()));
		addDecision(GMFGEN.getGenEditorGenerator(), new Decision.ALWAYS_OLD(GMFGEN.getGenEditorGenerator_Audits()));
		addDecision(GMFGEN.getGenEditorGenerator(), new Decision.ALWAYS_OLD(GMFGEN.getGenEditorGenerator_ExpressionProviders()));
		addDecision(GMFGEN.getGenEditorGenerator(), new Decision.ALWAYS_OLD(GMFGEN.getGenEditorGenerator_Application()));

		// Diagram

		setMatcher(GMFGEN.getGenDiagram(), ALWAYS_MATCH);
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getGenDiagram_Synchronized());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getShortcuts_ContainsShortcutsTo());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getShortcuts_ShortcutsProvidedFor());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getProviderClassNames_IconProviderPriority());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getEditorCandies_CreationWizardIconPath());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getEditorCandies_CreationWizardCategoryID());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getBatchValidation_ValidationEnabled());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getBatchValidation_LiveValidationUIFeedback());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getBatchValidation_ValidationDecorators());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getBatchValidation_ValidationDecoratorProviderClassName());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getBatchValidation_ValidationDecoratorProviderPriority());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getBatchValidation_ValidationProviderClassName());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getBatchValidation_ValidationProviderPriority());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getBatchValidation_MetricProviderPriority());
		preserveIfSet(GMFGEN.getGenDiagram(), GMFGEN.getBatchValidation_MetricProviderClassName());
		addDecision(GMFGEN.getGenDiagram(), new Decision.ALWAYS_OLD(GMFGEN.getGenDiagram_Preferences()));
		addDecision(GMFGEN.getGenDiagram(), new Decision.ALWAYS_OLD(GMFGEN.getGenDiagram_PreferencePages()));
		addDecision(GMFGEN.getGenDiagram(), new ViewmapDecision());

		for (EClass node : new EClass[] { GMFGEN.getGenTopLevelNode(), GMFGEN.getGenChildNode(), GMFGEN.getGenChildLabelNode(), GMFGEN.getGenChildSideAffixedNode() }) {
			setMatcher(node, new VisualIDMatcher());
			addDecision(node, new ModelFacetDecision());
			addDecision(node, new ViewmapDecision());
			preserveIfSet(node, GMFGEN.getGenNode_PrimaryDragEditPolicyQualifiedClassName());
		}
		addDecision(GMFGEN.getGenChildLabelNode(), new LabelModelFacetDecision());
		preserveIfSet(GMFGEN.getGenChildSideAffixedNode(), GMFGEN.getGenChildSideAffixedNode_PreferredSideName());

		setMatcher(GMFGEN.getGenCompartment(), new VisualIDMatcher());
		preserveIfSet(GMFGEN.getGenCompartment(), GMFGEN.getGenCompartment_Title());
		preserveIfSet(GMFGEN.getGenCompartment(), GMFGEN.getGenCompartment_ListLayout());
		preserveIfSet(GMFGEN.getGenCompartment(), GMFGEN.getGenCompartment_CanCollapse());
		preserveIfSet(GMFGEN.getGenCompartment(), GMFGEN.getGenCompartment_HideIfEmpty());
		preserveIfSet(GMFGEN.getGenCompartment(), GMFGEN.getGenCompartment_NeedsTitle());
		addDecision(GMFGEN.getGenCompartment(), new ViewmapDecision());

		setMatcher(GMFGEN.getGenLink(), new VisualIDMatcher());
		preserveIfSet(GMFGEN.getGenLink(), GMFGEN.getGenLink_IncomingCreationAllowed());
		preserveIfSet(GMFGEN.getGenLink(), GMFGEN.getGenLink_OutgoingCreationAllowed());
		preserveIfSet(GMFGEN.getGenLink(), GMFGEN.getGenLink_ViewDirectionAlignedWithModel());
		addDecision(GMFGEN.getGenLink(), new ModelFacetDecision());
		addDecision(GMFGEN.getGenLink(), new ViewmapDecision());
		addDecision(GMFGEN.getGenLink(), new Decision.ALWAYS_OLD(GMFGEN.getGenLink_CreationConstraints()));

		for (EClass label : new EClass[] { GMFGEN.getGenLinkLabel(), GMFGEN.getGenNodeLabel(), GMFGEN.getGenExternalNodeLabel() }) {
			setMatcher(label, new VisualIDMatcher());
			addDecision(label, new LabelModelFacetDecision());
			addDecision(label, new ViewmapDecision());
			preserveIfSet(label, GMFGEN.getGenLabel_ElementIcon());
			preserveIfSet(label, GMFGEN.getGenLabel_ReadOnly());
		}
		preserveIfSet(GMFGEN.getGenLinkLabel(), GMFGEN.getGenLinkLabel_Alignment());

		setMatcher(GMFGEN.getCustomBehaviour(), ALWAYS_MATCH);
		setCopier(GMFGEN.getCustomBehaviour(), Copier.COMPLETE_COPY);

		setMatcher(GMFGEN.getOpenDiagramBehaviour(), ALWAYS_MATCH);
		setCopier(GMFGEN.getOpenDiagramBehaviour(), Copier.COMPLETE_COPY);

		setMatcher(GMFGEN.getMetamodelType(), ALWAYS_MATCH);
		preserveIfSet(GMFGEN.getMetamodelType(), GMFGEN.getElementType_DisplayName());
		preserveIfSet(GMFGEN.getMetamodelType(), GMFGEN.getElementType_DefinedExternally());

		setMatcher(GMFGEN.getSpecializationType(), ALWAYS_MATCH);
		preserveIfSet(GMFGEN.getSpecializationType(), GMFGEN.getElementType_DisplayName());
		preserveIfSet(GMFGEN.getSpecializationType(), GMFGEN.getElementType_DefinedExternally());

		// Palette

		setMatcher(GMFGEN.getPalette(), ALWAYS_MATCH);
		preserveIfSet(GMFGEN.getPalette(), GMFGEN.getPalette_Flyout());
		preserveIfSet(GMFGEN.getPalette(), GMFGEN.getPalette_PackageName());
		preserveIfSet(GMFGEN.getPalette(), GMFGEN.getPalette_FactoryClassName());

		for (EClass entry : new EClass[] { GMFGEN.getToolGroup(), GMFGEN.getToolEntry(), GMFGEN.getStandardEntry() }) {
			setMatcher(entry, new PropertyMatcher(GMFGEN.getEntryBase_Title()));
			preserveIfSet(entry, GMFGEN.getEntryBase_Description());
			preserveIfSet(entry, GMFGEN.getEntryBase_CreateMethodName());
			preserveIfSet(entry, GMFGEN.getEntryBase_LargeIconPath());
			preserveIfSet(entry, GMFGEN.getEntryBase_SmallIconPath());
		}
		for (EClass entry : new EClass[] { GMFGEN.getToolEntry(), GMFGEN.getStandardEntry() }) {
			preserveIfSet(entry, GMFGEN.getAbstractToolEntry_Default());
			preserveIfSet(entry, GMFGEN.getAbstractToolEntry_QualifiedToolName());
		}
		preserveIfSet(GMFGEN.getToolGroup(), GMFGEN.getToolGroup_Collapse());
		preserveIfSet(GMFGEN.getToolGroup(), GMFGEN.getToolGroup_Stack());
		preserveIfSet(GMFGEN.getStandardEntry(), GMFGEN.getStandardEntry_Kind());
	}

	private void preserveIfSet(EClass eClass, EAttribute feature) {
		addDecision(eClass, new DefaultDecision(feature));
	}
}
