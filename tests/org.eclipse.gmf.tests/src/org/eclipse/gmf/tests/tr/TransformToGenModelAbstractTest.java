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
import org.eclipse.gmf.codegen.gmfgen.Viewmap;

public abstract class TransformToGenModelAbstractTest extends TransformToGenModelOperationSupport {
	
	public TransformToGenModelAbstractTest(String name) {
		super(name);
	}
	
	public void testGenAuditRoot() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();
		
		doTestGenAuditRoot(expected, actual);
	}

	public void testGenTopLevelNode() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();
		
		doTestGenTopLevelNode(expected, actual);
	}
	
	public void testGenChildNode() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();
		
		doTestGenChildNode(expected, actual);
	}

	public void testGenLink() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();
		
		doTestGenLink(expected, actual);
	}

	public void testGenNavigator() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenNavigator(expected, actual);
	}
	
	public void testGenNavigatorChildReferences() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();
		
		doTestGenNavigatorChildReferences(expected, actual);
	}

	public void testGenPlugin() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenPlugin(expected, actual);
	}

	public void testGenPropertySheet() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenPropertySheet(expected, actual);
	}

	public void testGenPropertySheetTabs() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenPropertySheetTabs(expected, actual);
	}

	public void testGenDiagramPalette() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestDiagramPalette(expected, actual);
	}

	public void testGenDiagramPaletteToolGroup() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestDiagramPaletteToolGroup(expected, actual);
	}

	public void testGenDiagramUpdater() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenDiagramUpdater(expected, actual);
	}

	public void testGenEditorView() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenEditorView(expected, actual);
	}

	public void testLabelGenParsers() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestLabelGenParsers(expected, actual);
	}

	public void testGenContextMenu() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenContextMenu(expected, actual);
	}

	public void testGenDiagramAttributes() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenDiagramAttributes(expected, actual);
	}

	public void testGenExpressionProviderContainer() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenExpressionProviderContainer(expected, actual);
	}

	public void testGenCompartments() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenDiagramCompartments(expected, actual);
	}

	public void testGenDiagramBehaviour() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenDiagramBehaviour(expected, actual);
	}

	public void testGenDiagramAssistantNodes() {
		GenEditorGenerator expected = executeBaseTransformation();
		GenEditorGenerator actual = executeQvtTransformation();

		doTestGenDiagramAssistantNodes(expected, actual);
	}

	protected void doTestGenDiagramAttributes(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
		GenDiagram baseDiagram = expectedGenEditor.getDiagram();
		GenDiagram qvtDiagram = actualGenEditor.getDiagram();

		checkObjectAttributes(baseDiagram, qvtDiagram);
	}

	protected void doTestGenAuditRoot(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
		GenAuditRoot baseAudit = expectedGenEditor.getAudits();
		GenAuditRoot qvtAudit = actualGenEditor.getAudits();

		if (baseAudit == null) {
			assertNull(qvtAudit);
		} else {
			assertNotNull(qvtAudit);

			checkObjectAttributes(baseAudit, qvtAudit);
			
			EList<GenAuditRule> expR = baseAudit.getRules();
			EList<GenAuditRule> actR = qvtAudit.getRules();
			assertEquals(expR.size(), actR.size());
			for (int i=0; i<expR.size(); i++) {
				GenAuditRule exp = expR.get(i);
				GenAuditRule act = actR.get(i);
				
				checkObjectAttributes(exp, act);
			}
			
			EList<GenAuditContext> expCtx = baseAudit.getClientContexts();
			EList<GenAuditContext> actCtx = qvtAudit.getClientContexts();

			assertEquals(expCtx.size(), actCtx.size());
			for (int i=0;i<expCtx.size();i++) {
				GenAuditContext exp = expCtx.get(i);
				GenAuditContext act = findActualCtx(exp, actCtx);
				assertNotNull(act);

				checkObjectAttributes(exp, act);
			}
			
			EList<GenAuditContainer> expCt = baseAudit.getCategories();
			EList<GenAuditContainer> actCt = qvtAudit.getCategories();
			
			assertEquals(expCt.size(), actCt.size());
			for (int i=0;i<expCt.size();i++) {
				GenAuditContainer exp = expCt.get(i);
				GenAuditContainer act = actCt.get(i);
				
				checkObjectAttributes(exp, act);
			}
		}
	}

	protected void doTestGenTopLevelNode(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
		GenDiagram expectedDiagram = expectedGenEditor.getDiagram();
		GenDiagram actualDiagram = actualGenEditor.getDiagram();

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
			
			if (expectedNode.getViewmap() == null)
				assertNull(actualNode.getViewmap());
			else {
				assertNotNull(actualNode.getViewmap());
				Viewmap expViewmap = expectedNode.getViewmap();
				Viewmap actViewmap = actualNode.getViewmap();
				
				assertEquals(expViewmap.getRequiredPluginIDs(), actViewmap.getRequiredPluginIDs());
				checkObjectAttributes(expViewmap, actViewmap);
			}
			
			assertEquals(expectedNode.getLabels().size(), actualNode.getLabels().size());
			
			for (int j=0;j<expectedNode.getLabels().size(); j++) {
				GenNodeLabel expectedLabel = expectedNode.getLabels().get(j);
				GenNodeLabel actualLabel = actualNode.getLabels().get(j);
				
				assertEquals(expectedLabel.getVisualID(), actualLabel.getVisualID());
				checkObjectAttributes(expectedLabel, actualLabel);
				
				if (expectedLabel.getViewmap() == null)
					assertNull(actualLabel.getViewmap());
				else {
					assertNotNull(actualLabel.getViewmap());
					Viewmap expViewmap = expectedLabel.getViewmap();
					Viewmap actViewmap = actualLabel.getViewmap();
					
					checkObjectAttributes(expViewmap, actViewmap);
				}
			}
		}
	}
	
	protected void checkNodeAttributes(GenNode expectedNode, GenNode actualNode) {
		assertEquals(expectedNode.getVisualID(), actualNode.getVisualID());
		assertEquals(expectedNode.getUniqueIdentifier(), actualNode.getUniqueIdentifier());

		assertEquals(expectedNode.getClassNamePrefix(), actualNode.getClassNamePrefix());
		assertEquals(expectedNode.getClassNameSuffux(), actualNode.getClassNameSuffux());
		
		System.out.println(expectedNode.getCanonicalEditPolicyQualifiedClassName() + " ---- " + actualNode.getCanonicalEditPolicyQualifiedClassName());
		
//		assertEquals(expectedNode.getCanonicalEditPolicyClassName(), actualNode.getCanonicalEditPolicyClassName());
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

	protected void doTestGenChildNode(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
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
			
			System.out.println(expectedNode.getCanonicalEditPolicyQualifiedClassName());
			System.out.println(actualNode.getCanonicalEditPolicyQualifiedClassName());
			
			checkNodeAttributes(expectedNode, actualNode);
			
			ElementType expectedType = expectedNode.getElementType();
			ElementType actualType = actualNode.getElementType();

			assertEquals(expectedType.getDisplayName(), actualType.getDisplayName());
			assertEquals(expectedType.getUniqueIdentifier(), actualType.getUniqueIdentifier());
			assertEquals(expectedType.getDiagramElement().getUniqueIdentifier(), actualType.getDiagramElement().getUniqueIdentifier());
			
			assertEquals(expectedNode.getAssistantNodes().size(), actualNode.getAssistantNodes().size());
			
			EList<Behaviour> expectedBehaviour = expectedNode.getBehaviour();
			EList<Behaviour> actualBehaviour = actualNode.getBehaviour();
			
			assertEquals(expectedBehaviour.size(), actualBehaviour.size());
			
			EList<GenNodeLabel> expLabel = expectedNode.getLabels();
			EList<GenNodeLabel> actLabel = actualNode.getLabels();
			
			assertEquals(expLabel.size(), actLabel.size());
			
			for (int j=0;j<expLabel.size();j++) {
				GenNodeLabel l = expLabel.get(j);
				GenNodeLabel ll = actLabel.get(j);
				
				assertEquals(l.getVisualID(), ll.getVisualID());
				
				LabelModelFacet expFacet = l.getModelFacet();
				LabelModelFacet actFacet = l.getModelFacet();
				
				assertEquals(expFacet.eContainingFeature(), actFacet.eContainingFeature());
			}
			
			
		}
	}
	
	protected void doTestGenLink(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
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
			
			LinkModelFacet expFacet = expLink.getModelFacet();
			LinkModelFacet actFacet = expLink.getModelFacet();
			checkObjectAttributes(expFacet, actFacet);
			assertEquals(expFacet.getSourceType(), actFacet.getSourceType());
			assertEquals(expFacet.eContainingFeature(), actFacet.eContainingFeature());
			assertEquals(expFacet.getTargetType(), actFacet.getTargetType());
			
			EList<GenLinkLabel> expLabels = expLink.getLabels();
			EList<GenLinkLabel> actLabels = actLink.getLabels();
			assertEquals(expLabels.size(), actLabels.size());
		}
	}

	protected void doTestGenNavigator(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {		
		GenNavigator baseNavigator = expectedGenEditor.getNavigator();
		GenNavigator qvtNavigator = actualGenEditor.getNavigator();

		checkObjectAttributes(baseNavigator, qvtNavigator);
	}

	protected void doTestGenNavigatorChildReferences(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
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

	protected void doTestDiagramPalette(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
		Palette expected = expectedGenEditor.getDiagram().getPalette();
		Palette actual = actualGenEditor.getDiagram().getPalette();

		checkObjectAttributes(expected, actual);
	}

	protected void doTestDiagramPaletteToolGroup(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
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

	//
	//	Plugin
	//

	protected void doTestGenPlugin(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
		GenPlugin basePlugin = expectedGenEditor.getPlugin();
		GenPlugin qvtPlugin = actualGenEditor.getPlugin();

		checkObjectAttributes(basePlugin, qvtPlugin);
		checkContainedObjects(basePlugin, qvtPlugin);
	}

	//
	//	Editor
	//

	protected void doTestGenEditorView(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
		GenEditorView baseEditor = expectedGenEditor.getEditor();
		GenEditorView qvtEditor = actualGenEditor.getEditor();

		checkObjectAttributes(baseEditor, qvtEditor);

		GenEditorGenerator baseEditorGen = baseEditor.getEditorGen();
		GenEditorGenerator qvtEditorGen = qvtEditor.getEditorGen();

		checkObjectAttributes(baseEditorGen, qvtEditorGen);
		
//		checkContainedObjects(baseEditorGen, qvtEditorGen);
	}

	//
	//	DiagramUpdater
	//

	protected void doTestGenDiagramUpdater(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
		GenDiagramUpdater baseUpdater = expectedGenEditor.getDiagramUpdater();
		GenDiagramUpdater qvtUpdater = actualGenEditor.getDiagramUpdater();

		checkObjectAttributes(baseUpdater, qvtUpdater);
		checkContainedObjects(baseUpdater, qvtUpdater);
	}

	//
	//	PropertySheet
	//

	protected void doTestGenPropertySheet(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
		GenPropertySheet basePropSheet = expectedGenEditor.getPropertySheet();
		GenPropertySheet qvtPropSheet = actualGenEditor.getPropertySheet();

		assertEquals(basePropSheet.getLabelProviderClassName(), qvtPropSheet.getLabelProviderClassName());
		assertEquals(basePropSheet.getLabelProviderQualifiedClassName(), qvtPropSheet.getLabelProviderQualifiedClassName());

		assertEquals(basePropSheet.getPackageName(), qvtPropSheet.getPackageName());

		checkObjectAttributes(basePropSheet, qvtPropSheet);
		checkContainedObjects(basePropSheet, qvtPropSheet);
	}

	protected void doTestGenPropertySheetTabs(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
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

	protected void doTestLabelGenParsers(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
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

	protected void doTestGenContextMenu(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) { 
		EList<GenContextMenu> baseContexts = expectedGenEditor.getContextMenus();
		EList<GenContextMenu> qvtContexts = actualGenEditor.getContextMenus();

		assertEquals(baseContexts.size(), qvtContexts.size());

		for (int i=0; i<baseContexts.size(); i++) {
			assertEquals(baseContexts.get(i).getID(), qvtContexts.get(i).getID());

			checkObjectAttributes(baseContexts.get(i), qvtContexts.get(i));
			checkContainedObjects(baseContexts.get(i), qvtContexts.get(i));
		}
	}

	//
	// ExpressionProviderContainer
	//

	protected void doTestGenExpressionProviderContainer(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
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
	
	protected void doTestGenDiagramAssistantNodes(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
		EList<GenNode> expected = expectedGenEditor.getDiagram().getAssistantNodes();
		EList<GenNode> actual = actualGenEditor.getDiagram().getAssistantNodes();

		assertEquals(expected.size(), actual.size());

		for (int i=0; i<expected.size();i++) {
			checkObjectAttributes(expected.get(i), actual.get(i));
		}
	}

	protected void doTestGenDiagramBehaviour(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
		EList<Behaviour> expected = expectedGenEditor.getDiagram().getBehaviour();
		EList<Behaviour> actual = actualGenEditor.getDiagram().getBehaviour();

		assertEquals(expected.size(), actual.size());
		for (int i=0; i<expected.size();i++) {
			checkObjectAttributes(expected.get(i), actual.get(i));
			checkContainedObjects(expected.get(i), actual.get(i));
		}
	}

	protected void doTestGenDiagramCompartments(GenEditorGenerator expectedGenEditor, GenEditorGenerator actualGenEditor) {
		EList<GenCompartment> expected = expectedGenEditor.getDiagram().getCompartments();
		EList<GenCompartment> actual = actualGenEditor.getDiagram().getCompartments();

		assertEquals(expected.size(), actual.size());
		for (int i=0; i<expected.size();i++) {
			checkObjectAttributes(expected.get(i), actual.get(i));
			checkContainedObjects(expected.get(i), actual.get(i));
		}
	}

}
