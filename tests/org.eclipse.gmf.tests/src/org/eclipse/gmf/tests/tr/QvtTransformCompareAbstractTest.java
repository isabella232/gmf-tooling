/*******************************************************************************
* Copyright (c) 2011, 2012 Montages A.G.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Guillaume Hillairet (Montages A.G.) : initial implementation
*******************************************************************************/
package org.eclipse.gmf.tests.tr;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.Behaviour;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContext;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenContextMenu;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramUpdater;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenEditorView;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNavigator;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenParserImplementation;
import org.eclipse.gmf.codegen.gmfgen.GenParsers;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenPropertySheet;
import org.eclipse.gmf.codegen.gmfgen.GenPropertyTab;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.ToolGroupItem;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;

public abstract class QvtTransformCompareAbstractTest extends QvtTransformCompareTestSupport {

	public QvtTransformCompareAbstractTest(String name, String mapModel) {
		super(	name, 
				testFolder+"/test.ecore", 
				testFolder+"/test.genmodel",
				testFolder+"/test.gmftool", 
				testFolder+"/test.gmfgraph", 
				mapModel );
	}

	protected GenEditorGenerator actualGenerator;
	protected GenEditorGenerator expectedGenerator;
	
	public void setUp() throws Exception {
		super.setUp();
		Transformation java = getJavaTransformation(false);
		expectedGenerator = java.execute();
		java.saveGenEditor("java");
		Transformation qvt = getQvtTransformation(false);
		actualGenerator = qvt.execute();
		qvt.saveGenEditor("qvt");
	}

	public void testGenAuditRoot() {
		GenAuditRoot expected = expectedGenerator.getAudits();
		GenAuditRoot actual = actualGenerator.getAudits();

		if (expected == null) {
			assertNull(actual);
		} else {
			assertNotNull(actual);

			checkObjectAttributes(expected, actual);
			doTestAuditRules(expected, actual);
			doTestAuditContainer(expected, actual);
			doTestAuditContext(expected, actual);
		}
	}

	public void testGenTopLevelNode() {
		GenDiagram expectedDiagram = expectedGenerator.getDiagram();
		GenDiagram actualDiagram = actualGenerator.getDiagram();

		assertNotNull(expectedDiagram);
		assertNotNull(actualDiagram);

		EList<GenTopLevelNode> expected = expectedDiagram.getTopLevelNodes();
		EList<GenTopLevelNode> actual = actualDiagram.getTopLevelNodes();

		assertEquals(expected.size(), actual.size());
		for (int i=0;i<expected.size();i++) {
			GenTopLevelNode expectedNode = expected.get(i);
			GenTopLevelNode actualNode = actual.get(i);

			checkNodeAttributes(expectedNode, actualNode);

			assertEquals(expectedNode.getChildNodes().size(), actualNode.getChildNodes().size());

			doTestViewmap(expectedNode, actualNode);
			doTestLabels(expectedNode, actualNode);
			doTestModelFacet(expectedNode, actualNode);
		}
	}

	public void testGenChildNode() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		GenDiagram expectedDiagram = expectedGenEditor.getDiagram();
		GenDiagram actualDiagram = actualGenEditor.getDiagram();

		assertNotNull(expectedDiagram);
		assertNotNull(actualDiagram);
		
		EList<GenChildNode> expected = expectedDiagram.getChildNodes();
		EList<GenChildNode> actual = actualDiagram.getChildNodes();

		assertEquals(expected.size(), actual.size());
		for (int i=0;i<expected.size();i++) {
			GenChildNode expectedNode = expected.get(i);
			GenChildNode actualNode = getChildNodeByVisualID(expectedNode.getVisualID(), actual);
			assertNotNull(actualNode);

			checkNodeAttributes(expectedNode, actualNode);
			checkObjectAttributes(expectedNode, actualNode);
			
			assertEquals(expectedNode.getAssistantNodes().size(), actualNode.getAssistantNodes().size());

			EList<Behaviour> expectedBehaviour = expectedNode.getBehaviour();
			EList<Behaviour> actualBehaviour = actualNode.getBehaviour();

			assertEquals(expectedBehaviour.size(), actualBehaviour.size());

			doTestViewmap(expectedNode, actualNode);
			doTestLabels(expectedNode, actualNode);
			doTestElementType(expectedNode, actualNode);
			doTestModelFacet(expectedNode, actualNode);
		}
	}

	public void testGenLink() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;
		
		GenDiagram expectedDiagram = expectedGenEditor.getDiagram();
		GenDiagram actualDiagram = actualGenEditor.getDiagram();

		assertNotNull(expectedDiagram);
		assertNotNull(actualDiagram);

		EList<GenLink> expected = expectedDiagram.getLinks();
		EList<GenLink> actual = actualDiagram.getLinks();

		assertEquals(expected.size(), actual.size());

		for (int i=0;i<expected.size();i++) {
			GenLink expLink = expected.get(i);
			GenLink actLink = expected.get(i);
			checkObjectAttributes(expLink, actLink);

			doTestElementType(expLink, actLink);
			doTestLabels(expLink, actLink);
			doTestModelFacet(expLink, actLink);
		}
	}

	public void testGenNavigator() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;
		
		GenNavigator baseNavigator = expectedGenEditor.getNavigator();
		GenNavigator qvtNavigator = actualGenEditor.getNavigator();
		
		checkObjectAttributes(baseNavigator, qvtNavigator);
	}

	public void testGenNavigatorChildReferences() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		GenNavigator expected = expectedGenEditor.getNavigator();
		GenNavigator actual = actualGenEditor.getNavigator();
		
		if (expected == null)
			assertNull(actual);
		else {
			assertNotNull(actual);

			assertTrue(expected.eResource().getContents().size() == 1);
			assertTrue(actual.eResource().getContents().size() == 1);

			EList<GenNavigatorChildReference> exp = expected.getChildReferences();
			EList<GenNavigatorChildReference> act = actual.getChildReferences();

			EList<GenNavigatorChildReference> found = new BasicEList<GenNavigatorChildReference>();
			assertEquals(exp.size(), act.size());
			for (int i=0; i<exp.size();i++) {
				GenNavigatorChildReference expRef = exp.get(i);
				GenNavigatorChildReference actualRef = findSameChildReference(expRef, act, found);

				assertNotNull(actualRef);

				if (!found.contains(actualRef)) {
					found.add(actualRef);
					checkObjectAttributes(expRef, actualRef);
				}
			}
			assertEquals(exp.size(), found.size());
		}
	}

	public void testGenPlugin() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;
		
		GenPlugin basePlugin = expectedGenEditor.getPlugin();
		GenPlugin qvtPlugin = actualGenEditor.getPlugin();

		checkObjectAttributes(basePlugin, qvtPlugin);
		checkContainedObjects(basePlugin, qvtPlugin);
	}

	public void testGenPropertySheet() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		GenPropertySheet basePropSheet = expectedGenEditor.getPropertySheet();
		GenPropertySheet qvtPropSheet = actualGenEditor.getPropertySheet();

		assertEquals(basePropSheet.getLabelProviderClassName(), qvtPropSheet.getLabelProviderClassName());
		assertEquals(basePropSheet.getLabelProviderQualifiedClassName(), qvtPropSheet.getLabelProviderQualifiedClassName());

		assertEquals(basePropSheet.getPackageName(), qvtPropSheet.getPackageName());

		checkObjectAttributes(basePropSheet, qvtPropSheet);
		checkContainedObjects(basePropSheet, qvtPropSheet);
	}

	public void testGenPropertySheetTabs() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;
		
		GenPropertySheet expected = expectedGenEditor.getPropertySheet();
		GenPropertySheet actual = actualGenEditor.getPropertySheet();

		if (expected == null)
			assertNull(actual);
		else {
			EList<GenPropertyTab> exp = expected.getTabs();
			EList<GenPropertyTab> act = actual.getTabs();

			assertEquals(exp.size(), act.size());
			for (int i=0; i<exp.size();i++) {
				checkObjectAttributes(exp.get(i), act.get(i));
			}

			checkContainedObjects(expected, actual);
		}
	}

	public void testGenDiagramPalette() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		Palette expected = expectedGenEditor.getDiagram().getPalette();
		Palette actual = actualGenEditor.getDiagram().getPalette();

		checkObjectAttributes(expected, actual);
	}

	public void testGenDiagramPaletteToolGroup() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		Palette basePalette = expectedGenEditor.getDiagram().getPalette();
		Palette qvtPalette = actualGenEditor.getDiagram().getPalette();

		if (basePalette == null) {
			assertNull(qvtPalette);
		} else {
			assertNotNull(qvtPalette);

			EList<ToolGroup> expected = basePalette.getGroups();
			EList<ToolGroup> actual = qvtPalette.getGroups();

			assertEquals(expected.size(), actual.size());

			for (int i=0;i<expected.size(); i++) {
				ToolGroup exp = expected.get(i);
				ToolGroup act = actual.get(i);

				checkObjectAttributes(exp, act);
				
				EList<ToolGroupItem> expItems = exp.getEntries();
				EList<ToolGroupItem> actItems = act.getEntries();

				assertEquals(expItems.size(), actItems.size());

				for (int j=0;j<expItems.size();j++) {
					checkObjectAttributes(expItems.get(i), actItems.get(i));

				}
			}
		}
	}

	public void testGenDiagramUpdater() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;
		
		GenDiagramUpdater baseUpdater = expectedGenEditor.getDiagramUpdater();
		GenDiagramUpdater qvtUpdater = actualGenEditor.getDiagramUpdater();

		checkObjectAttributes(baseUpdater, qvtUpdater);
		checkContainedObjects(baseUpdater, qvtUpdater);
	}

	public void testGenEditorView() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		GenEditorView baseEditor = expectedGenEditor.getEditor();
		GenEditorView qvtEditor = actualGenEditor.getEditor();

		checkObjectAttributes(baseEditor, qvtEditor);

		GenEditorGenerator baseEditorGen = baseEditor.getEditorGen();
		GenEditorGenerator qvtEditorGen = qvtEditor.getEditorGen();

		checkObjectAttributes(baseEditorGen, qvtEditorGen);

		//		checkContainedObjects(baseEditorGen, qvtEditorGen);
	}

	public void testLabelGenParsers() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		GenParsers baseParser = expectedGenEditor.getLabelParsers();
		GenParsers qvtParser = actualGenEditor.getLabelParsers();

		checkObjectAttributes(baseParser, qvtParser);

		EList<GenParserImplementation> expected = baseParser.getImplementations();
		EList<GenParserImplementation> actual = qvtParser.getImplementations();

		assertEquals(expected.size(), actual.size());
		for (int i=0;i<expected.size();i++) {
			GenParserImplementation expectImpl = expected.get(i);
			GenParserImplementation actualImpl = findParserImpl(expectImpl, actual);
			assertNotNull(actualImpl);
			checkObjectAttributes(expectImpl, actualImpl);
		}
	}

	public void testGenContextMenu() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		EList<GenContextMenu> baseContexts = expectedGenEditor.getContextMenus();
		EList<GenContextMenu> qvtContexts = actualGenEditor.getContextMenus();

		assertEquals(baseContexts.size(), qvtContexts.size());

		for (int i=0; i<baseContexts.size(); i++) {
			assertEquals(baseContexts.get(i).getID(), qvtContexts.get(i).getID());

			checkObjectAttributes(baseContexts.get(i), qvtContexts.get(i));
			checkContainedObjects(baseContexts.get(i), qvtContexts.get(i));
		}
	}

	public void testGenDiagramAttributes() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		GenDiagram baseDiagram = expectedGenEditor.getDiagram();
		GenDiagram qvtDiagram = actualGenEditor.getDiagram();

		checkObjectAttributes(baseDiagram, qvtDiagram);
	}

	public void testGenExpressionProviderContainer() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		GenExpressionProviderContainer baseExpr = expectedGenEditor.getExpressionProviders();
		GenExpressionProviderContainer qvtExpr = actualGenEditor.getExpressionProviders();

		if (baseExpr == null) {
			assertNull(qvtExpr);
		} else {
			assertNotNull(qvtExpr);

			checkObjectAttributes(baseExpr, qvtExpr);

			EList<GenExpressionProviderBase>  expected = baseExpr.getProviders();
			EList<GenExpressionProviderBase>  actual = baseExpr.getProviders();

			assertEquals(expected.size(), actual.size());
			for (int i=0;i<expected.size();i++) {
				GenExpressionProviderBase exp = expected.get(i);
				GenExpressionProviderBase act = findGenExpressionProviderBase(exp, actual);
				assertNotNull(act);
				checkObjectAttributes(exp, act);
			}
		}
	}

	public void testGenCompartments() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		EList<GenCompartment> expected = expectedGenEditor.getDiagram().getCompartments();
		EList<GenCompartment> actual = actualGenEditor.getDiagram().getCompartments();

		assertEquals(expected.size(), actual.size());
		for (int i=0; i<expected.size();i++) {
			checkObjectAttributes(expected.get(i), actual.get(i));
			checkContainedObjects(expected.get(i), actual.get(i));
		}
	}

	public void testGenDiagramBehaviour() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		EList<Behaviour> expected = expectedGenEditor.getDiagram().getBehaviour();
		EList<Behaviour> actual = actualGenEditor.getDiagram().getBehaviour();

		assertEquals(expected.size(), actual.size());
		for (int i=0; i<expected.size();i++) {
			checkObjectAttributes(expected.get(i), actual.get(i));
			checkContainedObjects(expected.get(i), actual.get(i));
		}
	}

	public void testGenDiagramAssistantNodes() {
		GenEditorGenerator expectedGenEditor = expectedGenerator;
		GenEditorGenerator actualGenEditor = actualGenerator;

		EList<GenNode> expected = expectedGenEditor.getDiagram().getAssistantNodes();
		EList<GenNode> actual = actualGenEditor.getDiagram().getAssistantNodes();

		assertEquals(expected.size(), actual.size());

		for (int i=0; i<expected.size();i++) {
			checkObjectAttributes(expected.get(i), actual.get(i));
		}
	}

	protected void doTestAuditRules(GenAuditRoot expected, GenAuditRoot actual) {
		EList<GenAuditRule> expR = expected.getRules();
		EList<GenAuditRule> actR = actual.getRules();
	
		assertEquals(expR.size(), actR.size());
		for (int i=0; i<expR.size(); i++) {
			GenAuditRule exp = expR.get(i);
			GenAuditRule act = actR.get(i);
	
			checkObjectAttributes(exp, act);
		}
	}

	protected void doTestAuditContext(GenAuditRoot expected, GenAuditRoot actual) {
		EList<GenAuditContext> expCtx = expected.getClientContexts();
		EList<GenAuditContext> actCtx = actual.getClientContexts();
	
		assertEquals(expCtx.size(), actCtx.size());
		for (int i=0;i<expCtx.size();i++) {
			GenAuditContext exp = expCtx.get(i);
			GenAuditContext act = findActualCtx(exp, actCtx);
			assertNotNull(act);
	
			checkObjectAttributes(exp, act);
		}
	}

	protected void doTestAuditContainer(GenAuditRoot expected, GenAuditRoot actual) {
		EList<GenAuditContainer> expCt = expected.getCategories();
		EList<GenAuditContainer> actCt = actual.getCategories();
	
		assertEquals(expCt.size(), actCt.size());
		for (int i=0;i<expCt.size();i++) {
			GenAuditContainer exp = expCt.get(i);
			GenAuditContainer act = actCt.get(i);
	
			checkObjectAttributes(exp, act);
		}
	}

	protected void doTestViewmap(GenCommonBase expectedNode, GenCommonBase actualNode) {
		if (expectedNode.getViewmap() == null)
			assertNull(actualNode.getViewmap());
		else {
			assertNotNull(actualNode.getViewmap());
			Viewmap expViewmap = expectedNode.getViewmap();
			Viewmap actViewmap = actualNode.getViewmap();

			assertEquals(expViewmap.getRequiredPluginIDs(), actViewmap.getRequiredPluginIDs());
			checkObjectAttributes(expViewmap, actViewmap);
		}
	}

	protected void doTestLabels(GenNode expectedNode, GenNode actualNode) {
		assertEquals(expectedNode.getLabels().size(), actualNode.getLabels().size());

		for (int j=0;j<expectedNode.getLabels().size(); j++) {
			GenNodeLabel expectedLabel = expectedNode.getLabels().get(j);
			GenNodeLabel actualLabel = actualNode.getLabels().get(j);

			assertEquals(expectedLabel.getVisualID(), actualLabel.getVisualID());

			LabelModelFacet expFacet = expectedLabel.getModelFacet();
			LabelModelFacet actFacet = expectedLabel.getModelFacet();

			assertEquals(expFacet.eContainingFeature(), actFacet.eContainingFeature());

			checkObjectAttributes(expectedLabel, actualLabel);

			doTestViewmap(expectedLabel, actualLabel);
		}
	}

	protected void doTestModelFacet(GenNode expected, GenNode actual) {
		TypeModelFacet expFacet = expected.getModelFacet();
		TypeModelFacet actFacet = actual.getModelFacet();

		assertEquals(expFacet.getChildMetaFeature().getName(), actFacet.getChildMetaFeature().getName());
		assertEquals(expFacet.eContainingFeature().getName(), actFacet.eContainingFeature().getName());
		assertEquals(expFacet.getContainmentMetaFeature().getName(), actFacet.getContainmentMetaFeature().getName());
	}

	protected void doTestModelFacet(GenLink expected, GenLink actual) {
		LinkModelFacet expFacet = expected.getModelFacet();
		LinkModelFacet actFacet = actual.getModelFacet();
		checkObjectAttributes(expFacet, actFacet);
		assertEquals(expFacet.getSourceType(), actFacet.getSourceType());
		assertEquals(expFacet.eContainingFeature(), actFacet.eContainingFeature());
		assertEquals(expFacet.getTargetType(), actFacet.getTargetType());
	}

	protected void doTestLabels(GenLink expected, GenLink actual) {
		EList<GenLinkLabel> expLabels = expected.getLabels();
		EList<GenLinkLabel> actLabels = actual.getLabels();
		assertEquals(expLabels.size(), actLabels.size());

		for (int i=0;i<expLabels.size(); i++) {
			GenLinkLabel expL = expLabels.get(i);
			GenLinkLabel actL = actLabels.get(i);

			checkObjectAttributes(expL, actL);
		}
	}
	
	protected void checkNodeAttributes(GenNode expectedNode, GenNode actualNode) {
		assertEquals(expectedNode.getVisualID(), actualNode.getVisualID());
		assertEquals(expectedNode.getUniqueIdentifier(), actualNode.getUniqueIdentifier());

		assertEquals(expectedNode.getClassNamePrefix(), actualNode.getClassNamePrefix());
		assertEquals(expectedNode.getClassNameSuffux(), actualNode.getClassNameSuffux());

		assertEquals(expectedNode.getCanonicalEditPolicyClassName(), actualNode.getCanonicalEditPolicyClassName());
		assertEquals(expectedNode.getCanonicalEditPolicyQualifiedClassName(), actualNode.getCanonicalEditPolicyQualifiedClassName());

		assertEquals(expectedNode.getCreateCommandClassName(), actualNode.getCreateCommandClassName());
		assertEquals(expectedNode.getCreateCommandQualifiedClassName(), actualNode.getCreateCommandQualifiedClassName());
		assertEquals(expectedNode.getEditPartClassName(), actualNode.getEditPartClassName());
		assertEquals(expectedNode.getEditPartQualifiedClassName(), actualNode.getEditPartQualifiedClassName());
		assertEquals(expectedNode.getGraphicalNodeEditPolicyClassName(), actualNode.getGraphicalNodeEditPolicyClassName());
		assertEquals(expectedNode.getGraphicalNodeEditPolicyQualifiedClassName(), actualNode.getGraphicalNodeEditPolicyQualifiedClassName());
		assertEquals(expectedNode.getItemSemanticEditPolicyClassName(), actualNode.getItemSemanticEditPolicyClassName());
		assertEquals(expectedNode.getItemSemanticEditPolicyQualifiedClassName(), actualNode.getItemSemanticEditPolicyQualifiedClassName());
		assertEquals(expectedNode.getNotationViewFactoryClassName(), actualNode.getNotationViewFactoryClassName());
		assertEquals(expectedNode.getNotationViewFactoryQualifiedClassName(), actualNode.getNotationViewFactoryQualifiedClassName());
		assertEquals(expectedNode.getPrimaryDragEditPolicyQualifiedClassName(), actualNode.getPrimaryDragEditPolicyQualifiedClassName());
	}

	protected void doTestElementType(GenCommonBase expectedNode, GenCommonBase actualNode) {
		ElementType expectedType = expectedNode.getElementType();
		ElementType actualType = actualNode.getElementType();

		assertEquals(expectedType.getDisplayName(), actualType.getDisplayName());
		assertEquals(expectedType.getUniqueIdentifier(), actualType.getUniqueIdentifier());
		assertEquals(expectedType.getDiagramElement().getUniqueIdentifier(), actualType.getDiagramElement().getUniqueIdentifier());
	}
	
}
