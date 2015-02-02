package org.eclipse.gmf.tests.tr;

import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.AbstractToolEntry;
import org.eclipse.gmf.codegen.gmfgen.Attributes;
import org.eclipse.gmf.codegen.gmfgen.Behaviour;
import org.eclipse.gmf.codegen.gmfgen.ColorAttributes;
import org.eclipse.gmf.codegen.gmfgen.DefaultSizeAttributes;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.ExpressionLabelParser;
import org.eclipse.gmf.codegen.gmfgen.ExternalParser;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenAuditable;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenContextMenu;
import org.eclipse.gmf.codegen.gmfgen.GenContributionItem;
import org.eclipse.gmf.codegen.gmfgen.GenCustomPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenDomainAttributeTarget;
import org.eclipse.gmf.codegen.gmfgen.GenDomainElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenEditorView;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNotationElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenParserImplementation;
import org.eclipse.gmf.codegen.gmfgen.GenParsers;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.GenStandardPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap;
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.LabelOffsetAttributes;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ModeledViewmap;
import org.eclipse.gmf.codegen.gmfgen.OpenDiagramBehaviour;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap;
import org.eclipse.gmf.codegen.gmfgen.ResizeConstraints;
import org.eclipse.gmf.codegen.gmfgen.SharedBehaviour;
import org.eclipse.gmf.codegen.gmfgen.SnippetViewmap;
import org.eclipse.gmf.codegen.gmfgen.StandardEntry;
import org.eclipse.gmf.codegen.gmfgen.StyleAttributes;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.ToolGroupItem;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ValueExpression;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.gmf.tests.tr.TransformationTestSupport.Transformation;

/**
 * Compare results form Java & QVTO transformations.
 * 
 * @author ghillairet
 *
 */
public class CompareTransformationEngineTest extends ConfiguredTestCase {
	protected static String testFolder = "platform:/plugin/org.eclipse.gmf.tests/models/tests/";  //$NON-NLS-1$

	public CompareTransformationEngineTest(String name) {
		super(name);
	}

	protected GenModel genModel;
	protected Mapping mapping;
	protected GenEditorGenerator expectedGenerator;
	protected GenEditorGenerator actualGenerator;

	private IProject myProject;
	private URI traceURI;

	// map -> test.gmfmap
	// ecore -> test.ecore
	// genmodel -> test.genmodel
	@Override
	public void setUp() throws Exception {
		super.setUp();
		myProject = createProject();
		traceURI = URI.createURI(myProject.getFile("test.trace").getFullPath().toString());

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource mapRes = resourceSet.createResource(URI.createURI(testFolder+"test.gmfmap"));
		mapRes.load(null);
		Resource genRes = resourceSet.createResource(URI.createURI(testFolder+"test.genmodel"));
		genRes.load(null);

		mapping = (Mapping) mapRes.getContents().get(0);
		genModel = (GenModel) genRes.getContents().get(0);

		Transformation java = TransformationTestSupport.getJavaTransformation(genModel, mapping, false);
		Transformation qvt = TransformationTestSupport.getQvtTransformation(genModel, mapping, false);

		expectedGenerator = java.execute(traceURI.trimFileExtension().appendFileExtension("java.gmfgen"));
		actualGenerator = qvt.execute(traceURI.trimFileExtension().appendFileExtension("qvt.gmfgen"));
	}

	@Override
	public void tearDown() throws Exception {
		deleteProject();
		myProject = null;
		super.tearDown();
	}

	public void testDummy() {
		// TODO: Remove when ParsersTest fixed.
	}
	
	public void testGenEditorGenerator() {
		assertNotNull(expectedGenerator);
		assertNotNull(actualGenerator);
		assertNotSame(expectedGenerator, actualGenerator);
		assertNotNull(expectedGenerator.eResource());
		assertNotNull(actualGenerator.eResource());

		assertNotSame(expectedGenerator.eResource(), actualGenerator.eResource());
		assertSame(expectedGenerator.eResource().getResourceSet(), actualGenerator.eResource().getResourceSet());

		assertEquals(expectedGenerator.getCopyrightText(), actualGenerator.getCopyrightText());
		assertEquals(expectedGenerator.getDiagramFileExtension(), actualGenerator.getDiagramFileExtension());
		assertEquals(expectedGenerator.getDomainFileExtension(), actualGenerator.getDomainFileExtension());
		assertEquals(expectedGenerator.getModelID(), actualGenerator.getModelID());
		assertEquals(expectedGenerator.getPackageNamePrefix(), actualGenerator.getPackageNamePrefix());
		assertEquals(expectedGenerator.getPluginDirectory(), actualGenerator.getPluginDirectory());
		assertEquals(expectedGenerator.getTemplateDirectory(), actualGenerator.getTemplateDirectory());
	}

	public void testGenEditorView() {
		GenEditorView expected = expectedGenerator.getEditor();
		GenEditorView actual = actualGenerator.getEditor();

		assertEquals(expected.getActionBarContributorClassName(), actual.getActionBarContributorClassName());
		assertEquals(expected.getClassName(), actual.getClassName());
		assertEquals(expected.getContextID(), actual.getContextID());
		assertEquals(expected.isEclipseEditor(), actual.isEclipseEditor());
		assertEquals(expected.getIconPath(), actual.getIconPath());
		assertEquals(expected.getIconPathX(), actual.getIconPathX());
		assertEquals(expected.getID(), actual.getID());
		assertEquals(expected.getPackageName(), actual.getPackageName());

		assertEquals(expected.getActionBarContributorQualifiedClassName(), actual.getActionBarContributorQualifiedClassName());
		assertEquals(expected.getQualifiedClassName(), actual.getQualifiedClassName());
	}

	public void testGenPlugin() {
		GenPlugin expected = expectedGenerator.getPlugin();
		GenPlugin actual = actualGenerator.getPlugin();

		assertNotNull(expected);
		assertNotNull(actual);

		assertEquals(expected.getActivatorClassName(), actual.getActivatorClassName());
		assertEquals(expected.getID(), actual.getID());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.isPrintingEnabled(), actual.isPrintingEnabled());
		assertEquals(expected.getProvider(), actual.getProvider());
		assertEquals(expected.getVersion(), actual.getVersion());

		assertEquals(expected.getRequiredPlugins().size(), actual.getRequiredPlugins().size());
		List<String> actualPlugins = actual.getRequiredPlugins();
		for (int i=0; i<expected.getRequiredPlugins().size(); i++) {
			String exp = expected.getRequiredPlugins().get(i);
			assertTrue(actualPlugins.contains(exp));
		}
	}

	public void testContextMenus() {
		EList<GenContextMenu> expected = expectedGenerator.getContextMenus();
		EList<GenContextMenu> actual = actualGenerator.getContextMenus();

		assertEquals(expected.size(), actual.size());
		for (int i=0; i<expected.size(); i++) {
			GenContextMenu exp = expected.get(i);
			GenContextMenu act = actual.get(i);

			assertEquals(exp.getID(), act.getID());
			assertEquals(exp.getItems().size(), act.getItems().size());
		}
	}

	protected void testGenContributionItem(GenContributionItem expected, GenContributionItem actual) {
		// TODO
	}

	public void testNumberOfElementsInGenDiagram() {
		GenDiagram expected = expectedGenerator.getDiagram();
		GenDiagram actual = actualGenerator.getDiagram();

		assertEquals(expected.getTopLevelNodes().size(), actual.getTopLevelNodes().size());
		assertEquals(expected.getChildNodes().size(), actual.getChildNodes().size());
		assertEquals(expected.getCompartments().size(), actual.getCompartments().size());
		assertEquals(expected.getLinks().size(), actual.getLinks().size());
	}

	public void testGenDiagram() {
		GenDiagram expected = expectedGenerator.getDiagram();
		GenDiagram actual = actualGenerator.getDiagram();

		assertNotNull(expected);
		assertNotNull(actual);

		assertEquals(expected.getDiagramRunTimeClass().getName(), actual.getDiagramRunTimeClass().getName());

		for (EAttribute attribute: GMFGenPackage.eINSTANCE.getGenDiagram().getEAllAttributes()) {
			if (expected.eIsSet(attribute)) {
				assertTrue(attribute+" should be set", actual.eIsSet(attribute));

				if (!attribute.isMany()) {
					assertEquals(expected.eGet(attribute), actual.eGet(attribute));
				}
			} else {
				assertFalse(attribute+" should not be set", actual.eIsSet(attribute));
			}
		}
	}

	public void testGenTopLevelNodeVisualID() {
		//	GenTopLevelNode
		EList<GenTopLevelNode> expected = expectedGenerator.getDiagram().getTopLevelNodes();
		EList<GenTopLevelNode> actual = actualGenerator.getDiagram().getTopLevelNodes();

		assertEquals("Number of GenTopLevelNode should be the same", expected.size(), actual.size());
		for (int i=0; i<expected.size(); i++) {
			GenTopLevelNode exp = expected.get(i);
			GenTopLevelNode act = actual.get(i);

			assertEquals("Node visualID should be the same", exp.getVisualID(), act.getVisualID());

			EList<GenNodeLabel> expLabels = exp.getLabels();
			EList<GenNodeLabel> actLabels = act.getLabels();

			assertEquals("Number of GenNodeLabel should be the same", expLabels.size(), actLabels.size());
			for (int j=0; j<expLabels.size(); j++) {
				GenNodeLabel expLabel = expLabels.get(j);
				GenNodeLabel actLabel = actLabels.get(j);

				assertEquals("Node visualID should be the same", expLabel.getVisualID(), actLabel.getVisualID());
			}
		}
	}

	public void testGenChildNodeVisualID() {
		// GenChildNode
		EList<GenChildNode> expChildNodes = expectedGenerator.getDiagram().getChildNodes();
		EList<GenChildNode> actChildNodes = actualGenerator.getDiagram().getChildNodes();

		assertEquals("Number of GenChildNode should be the same", expChildNodes.size(), actChildNodes.size());
		for (int i=0; i<expChildNodes.size(); i++) {
			GenChildNode exp = expChildNodes.get(i);
			GenChildNode act = actChildNodes.get(i);

			assertEquals("Node visualID should be the same", exp.getVisualID(), act.getVisualID());

			EList<GenNodeLabel> expLabels = exp.getLabels();
			EList<GenNodeLabel> actLabels = act.getLabels();

			assertEquals("Number of GenNodeLabel should be the same", expLabels.size(), actLabels.size());
			for (int j=0; j<expLabels.size(); j++) {
				GenNodeLabel expLabel = expLabels.get(j);
				GenNodeLabel actLabel = actLabels.get(j);

				assertEquals("Node visualID should be the same", expLabel.getVisualID(), actLabel.getVisualID());
			}
		}
	}

	public void testGenLinkVisualID() {
		// GenLink
		EList<GenLink> expLinks = expectedGenerator.getDiagram().getLinks();
		EList<GenLink> actLinks = actualGenerator.getDiagram().getLinks();

		assertEquals("Number of GenLink should be the same", expLinks.size(), actLinks.size());
		for (int i=0; i<expLinks.size(); i++) {
			GenLink exp = expLinks.get(i);
			GenLink act = actLinks.get(i);

			assertEquals("Node visualID should be the same", exp.getVisualID(), act.getVisualID());

			EList<GenLinkLabel> expLabels = exp.getLabels();
			EList<GenLinkLabel> actLabels = act.getLabels();

			assertEquals("Number of GenNodeLabel should be the same", expLabels.size(), actLabels.size());
			for (int j=0; j<expLabels.size(); j++) {
				GenLinkLabel expLabel = expLabels.get(j);
				GenLinkLabel actLabel = actLabels.get(j);

				assertEquals("Node visualID should be the same", expLabel.getVisualID(), actLabel.getVisualID());
			}
		}
	}

	public void testGenCompartmentVisualID() {
		// GenCompartment
		EList<GenCompartment> expCompartments = expectedGenerator.getDiagram().getCompartments();
		EList<GenCompartment> actCompartments = actualGenerator.getDiagram().getCompartments();
		// Known issue: GenCompartment are not set in same order.
		assertEquals("Number of GenLink should be the same", expCompartments.size(), actCompartments.size());
		for (int i=0; i<expCompartments.size(); i++) {
			GenCompartment exp = expCompartments.get(i);
			GenCompartment act = findCompartment(exp, actCompartments);
			assertNotNull("Identical GenCompartment should be found", act);
			assertEquals("Node visualID should be the same", exp.getVisualID(), act.getVisualID());
		}
	}

	public void testGenTopLevelNodeAttributes() {
		//	GenTopLevelNode
		EList<GenTopLevelNode> expected = expectedGenerator.getDiagram().getTopLevelNodes();
		EList<GenTopLevelNode> actual = actualGenerator.getDiagram().getTopLevelNodes();

		assertEquals("Number of GenLink should be the same", expected.size(), actual.size());

		for (int i=0; i<expected.size(); i++) {
			GenTopLevelNode exp = expected.get(i);
			GenTopLevelNode act = actual.get(i);

			assertEquals(exp.getCanonicalEditPolicyClassName(), act.getCanonicalEditPolicyClassName());
			assertEquals(exp.getCanonicalEditPolicyQualifiedClassName(), act.getCanonicalEditPolicyQualifiedClassName());
			assertEquals(exp.getClassNamePrefix(), act.getClassNamePrefix());
			assertEquals(exp.getClassNameSuffux(), act.getClassNameSuffux());
			assertEquals(exp.getCreateCommandClassName(), act.getCreateCommandClassName());
			assertEquals(exp.getCreateCommandQualifiedClassName(), act.getCreateCommandQualifiedClassName());
			assertEquals(exp.getEditPartClassName(), act.getEditPartClassName());
			assertEquals(exp.getEditPartQualifiedClassName(), act.getEditPartQualifiedClassName());
			assertEquals(exp.getGraphicalNodeEditPolicyClassName(), act.getGraphicalNodeEditPolicyClassName());
			assertEquals(exp.getGraphicalNodeEditPolicyQualifiedClassName(), act.getGraphicalNodeEditPolicyQualifiedClassName());
			assertEquals(exp.getItemSemanticEditPolicyClassName(), act.getItemSemanticEditPolicyClassName());
			assertEquals(exp.getItemSemanticEditPolicyQualifiedClassName(), act.getItemSemanticEditPolicyQualifiedClassName());
			assertEquals(exp.getNotationViewFactoryClassName(), act.getNotationViewFactoryClassName());
			assertEquals(exp.getNotationViewFactoryQualifiedClassName(), act.getNotationViewFactoryQualifiedClassName());
			assertEquals(exp.getPrimaryDragEditPolicyQualifiedClassName(), act.getPrimaryDragEditPolicyQualifiedClassName());
			assertEquals(exp.getUniqueIdentifier(), act.getUniqueIdentifier());
			assertEquals(exp.getVisualID(), act.getVisualID());
		}
	}
	
	public void testGenChildNodeAttributes() {
		//		GenChildNode
		EList<GenChildNode> expected = expectedGenerator.getDiagram().getChildNodes();
		EList<GenChildNode> actual = actualGenerator.getDiagram().getChildNodes();

		assertEquals("Number of GenChildNode should be the same", expected.size(), actual.size());

		for (int i=0; i<expected.size(); i++) {
			GenChildNode exp = expected.get(i);
			GenChildNode act = actual.get(i);

			assertEquals(exp.eClass(), act.eClass());

			for (EAttribute attribute: exp.eClass().getEAllAttributes()) {
				if (exp.eIsSet(attribute)) {
					assertTrue(attribute+" should be set", act.eIsSet(attribute));

					if (!attribute.isMany()) {
						assertEquals(exp.eGet(attribute), act.eGet(attribute));
					}
				} else {
					assertFalse(attribute+" should not be set", act.eIsSet(attribute));
				}	
			}
		}
	}
	
	public void testGenLinksAttributes() {		
		//	GenLink
		EList<GenLink> expected = expectedGenerator.getDiagram().getLinks();
		EList<GenLink> actual = actualGenerator.getDiagram().getLinks();

		assertEquals("Number of GenLink should be the same", expected.size(), actual.size());

		for (int i=0; i<expected.size(); i++) {
			GenLink expLink = expected.get(i);
			GenLink actLink = actual.get(i);

			assertEquals(expLink.getClassNamePrefix(), actLink.getClassNamePrefix());
			assertEquals(expLink.getClassNameSuffux(), actLink.getClassNameSuffux());
			assertEquals(expLink.getCreateCommandClassName(), actLink.getCreateCommandClassName());
			assertEquals(expLink.getCreateCommandQualifiedClassName(), actLink.getCreateCommandQualifiedClassName());
			assertEquals(expLink.getEditPartClassName(), actLink.getEditPartClassName());
			assertEquals(expLink.getEditPartQualifiedClassName(), actLink.getEditPartQualifiedClassName());
			assertEquals(expLink.getItemSemanticEditPolicyClassName(), actLink.getItemSemanticEditPolicyClassName());
			assertEquals(expLink.getItemSemanticEditPolicyQualifiedClassName(), actLink.getItemSemanticEditPolicyQualifiedClassName());
			assertEquals(expLink.getNotationViewFactoryClassName(), actLink.getNotationViewFactoryClassName());
			assertEquals(expLink.getNotationViewFactoryQualifiedClassName(), actLink.getNotationViewFactoryQualifiedClassName());
			assertEquals(expLink.getReorientCommandClassName(), actLink.getReorientCommandClassName());
			assertEquals(expLink.getReorientCommandQualifiedClassName(), actLink.getReorientCommandQualifiedClassName());
			assertEquals(expLink.getVisualID(), actLink.getVisualID());
			assertEquals(expLink.getUniqueIdentifier(), actLink.getUniqueIdentifier());
		}
	}
	
	public void testGenCompartmentAttributes() {
		// GenCompartment
		EList<GenCompartment> expCompartments = expectedGenerator.getDiagram().getCompartments();
		EList<GenCompartment> actCompartments = actualGenerator.getDiagram().getCompartments();
		// Known issue: GenCompartment are not set in same order.
		assertEquals("Number of GenLink should be the same", expCompartments.size(), actCompartments.size());
		for (int i=0; i<expCompartments.size(); i++) {
			GenCompartment exp = expCompartments.get(i);
			GenCompartment act = findCompartment(exp, actCompartments);
			assertNotNull("Compartment with ID "+exp.getVisualID()+" not found", act);
			
			assertEquals("Node visualID should be the same", exp.getVisualID(), act.getVisualID());
			assertEquals(exp.getCanonicalEditPolicyClassName(), act.getCanonicalEditPolicyClassName());
			assertEquals(exp.getCanonicalEditPolicyQualifiedClassName(), act.getCanonicalEditPolicyQualifiedClassName());
			assertEquals(exp.getClassNamePrefix(), act.getClassNamePrefix());
			assertEquals(exp.getClassNameSuffux(), act.getClassNameSuffux());
			assertEquals(exp.getEditPartClassName(), act.getEditPartClassName());
			assertEquals(exp.getEditPartQualifiedClassName(), act.getEditPartQualifiedClassName());
			assertEquals(exp.getItemSemanticEditPolicyClassName(), act.getItemSemanticEditPolicyClassName());
			assertEquals(exp.getItemSemanticEditPolicyQualifiedClassName(), act.getItemSemanticEditPolicyQualifiedClassName());
			assertEquals(exp.getNotationViewFactoryClassName(), act.getNotationViewFactoryClassName());
			assertEquals(exp.getNotationViewFactoryQualifiedClassName(), act.getNotationViewFactoryQualifiedClassName());
			assertEquals(exp.getTitle(), act.getTitle());
			assertEquals(exp.getUniqueIdentifier(), act.getUniqueIdentifier());
			assertEquals(exp.isCanCollapse(), act.isCanCollapse());
			assertEquals(exp.isHideIfEmpty(), act.isHideIfEmpty());
			assertEquals(exp.isListLayout(), act.isListLayout());
			assertEquals(exp.isNeedsTitle(), act.isNeedsTitle());
			assertEquals(exp.isSansDomain(), act.isSansDomain());
		}
	}

	public void testGenTopLevelNodeReferences() {
		//	GenTopLevelNode
		EList<GenTopLevelNode> expected = expectedGenerator.getDiagram().getTopLevelNodes();
		EList<GenTopLevelNode> actual = actualGenerator.getDiagram().getTopLevelNodes();
	
		assertEquals("Number of GenLink should be the same", expected.size(), actual.size());
	
		for (int i=0; i<expected.size(); i++) {
			GenTopLevelNode exp = expected.get(i);
			GenTopLevelNode act = actual.get(i);
	
			testElementType(exp.getElementType(), act.getElementType());
			testViewmap(exp.getViewmap(), act.getViewmap());
			testBehaviours(exp.getBehaviour(),act.getBehaviour());
			testTypeModelFacet(exp.getModelFacet(), act.getModelFacet());
			testGenNodeLabels(exp.getLabels(), act.getLabels());
			
			assertEquals(exp.getDiagramRunTimeClass().getName(), act.getDiagramRunTimeClass().getName());
			assertEquals(exp.getStyles().size(), act.getStyles().size());
			assertEquals(exp.getBehaviour().size(), act.getBehaviour().size());
			assertEquals(exp.getContainedNodes().size(), act.getContainedNodes().size());
			assertEquals(exp.getCompartments().size(), act.getCompartments().size());
			assertEquals(exp.getGenIncomingLinks().size(), act.getGenIncomingLinks().size());
			assertEquals(exp.getGenOutgoingLinks().size(), act.getGenOutgoingLinks().size());
			assertEquals(exp.getReorientedIncomingLinks().size(), act.getReorientedIncomingLinks().size());
		}
	}

	public void testGenChildNodeReferences() {
		//		GenChildNode
		EList<GenChildNode> expected = expectedGenerator.getDiagram().getChildNodes();
		EList<GenChildNode> actual = actualGenerator.getDiagram().getChildNodes();
	
		assertEquals("Number of GenChildNode should be the same", expected.size(), actual.size());
	
		for (int i=0; i<expected.size(); i++) {
			GenChildNode exp = expected.get(i);
			GenChildNode act = actual.get(i);
			
			testElementType(exp.getElementType(), act.getElementType());
			testViewmap(exp.getViewmap(), act.getViewmap());
			testBehaviours(exp.getBehaviour(),act.getBehaviour());
			testTypeModelFacet(exp.getModelFacet(), act.getModelFacet());
			testGenNodeLabels(exp.getLabels(), act.getLabels());
			
			assertEquals(exp.getDiagramRunTimeClass().getName(), act.getDiagramRunTimeClass().getName());
			assertEquals(exp.getStyles().size(), act.getStyles().size());
			assertEquals(exp.getBehaviour().size(), act.getBehaviour().size());
			assertEquals(exp.getContainedNodes().size(), act.getContainedNodes().size());
			assertEquals(exp.getCompartments().size(), act.getCompartments().size());
			assertEquals(exp.getGenIncomingLinks().size(), act.getGenIncomingLinks().size());
			assertEquals(exp.getGenOutgoingLinks().size(), act.getGenOutgoingLinks().size());
			assertEquals(exp.getReorientedIncomingLinks().size(), act.getReorientedIncomingLinks().size());
		}
	}

	public void testGenLinksReferences() {		
		//	GenTopLevelNode
		EList<GenLink> expected = expectedGenerator.getDiagram().getLinks();
		EList<GenLink> actual = actualGenerator.getDiagram().getLinks();

		assertEquals("Number of GenLink should be the same", expected.size(), actual.size());
		
		for (int i=0; i<expected.size(); i++) {
			GenLink expLink = expected.get(i);
			GenLink actLink = actual.get(i);

			testElementType(expLink.getElementType(), actLink.getElementType());
			testViewmap(expLink.getViewmap(), actLink.getViewmap());
			testBehaviours(expLink.getBehaviour(),actLink.getBehaviour());
			testLinkModelFacet(expLink.getModelFacet(), actLink.getModelFacet());
			
			assertEquals(expLink.getDiagramRunTimeClass().getName(), actLink.getDiagramRunTimeClass().getName());
			assertEquals(expLink.getStyles().size(), actLink.getStyles().size());
			assertEquals(expLink.getBehaviour().size(), actLink.getBehaviour().size());
			assertEquals(expLink.getGenIncomingLinks().size(), actLink.getGenIncomingLinks().size());
			assertEquals(expLink.getGenOutgoingLinks().size(), actLink.getGenOutgoingLinks().size());
			assertEquals(expLink.getLabels().size(), actLink.getLabels().size());
		}
	}
	
	public void testGenCompartmentReferences() {
		// GenCompartment
		EList<GenCompartment> expCompartments = expectedGenerator.getDiagram().getCompartments();
		EList<GenCompartment> actCompartments = actualGenerator.getDiagram().getCompartments();
		// Known issue: GenCompartment are not set in same order.
		assertEquals("Number of GenLink should be the same", expCompartments.size(), actCompartments.size());
		for (int i=0; i<expCompartments.size(); i++) {
			GenCompartment exp = expCompartments.get(i);
			GenCompartment act = findCompartment(exp, actCompartments);
			assertNotNull("Identical GenCompartment should be found", act);
			
			assertNotNull(act.getDiagram());
			
			testElementType(exp.getElementType(), act.getElementType());
			testViewmap(exp.getViewmap(), act.getViewmap());
			testBehaviours(exp.getBehaviour(),act.getBehaviour());
			
			assertEquals(exp.getNode().getVisualID(), act.getNode().getVisualID());
			
			assertEquals(exp.getDiagramRunTimeClass().getName(), act.getDiagramRunTimeClass().getName());
			assertEquals(exp.getStyles().size(), act.getStyles().size());
			assertEquals(exp.getChildNodes().size(), act.getChildNodes().size());
			for (int j=0; j<exp.getChildNodes().size(); j++) {
				GenNode expNode = exp.getChildNodes().get(j);
				GenNode actNode = act.getChildNodes().get(j);
				
				assertEquals(expNode.getVisualID(), actNode.getVisualID());
			}
			assertEquals(exp.getContainedNodes().size(), act.getContainedNodes().size());
			for (int j=0; j<exp.getContainedNodes().size(); j++) {
				GenNode expNode = exp.getContainedNodes().get(j);
				GenNode actNode = act.getContainedNodes().get(j);
				
				assertEquals(expNode.getVisualID(), actNode.getVisualID());
			}
		}
	}
	
	protected void testGenNodeLabels(EList<GenNodeLabel> expected, EList<GenNodeLabel> actual) {
		assertEquals(expected.size(), actual.size());
		for (int i=0; i<expected.size(); i++) {
			GenNodeLabel exp = expected.get(i);
			GenNodeLabel act = actual.get(i);
			assertEquals(exp.eClass(), act.eClass());
			testGenNodeLabel(exp, act);
		}
	}

	protected void testGenNodeLabel(GenNodeLabel expected, GenNodeLabel actual) {
		assertEquals(expected.getVisualID(), actual.getVisualID());
		assertEquals(expected.getUniqueIdentifier(), actual.getUniqueIdentifier());
		assertEquals(expected.getEditPartClassName(), actual.getEditPartClassName());
		assertEquals(expected.getNotationViewFactoryClassName(), actual.getNotationViewFactoryClassName());
		assertEquals(expected.isElementIcon(), actual.isElementIcon());
		assertEquals(expected.isReadOnly(), actual.isReadOnly());
		assertEquals(expected.isSansDomain(), actual.isSansDomain());
		
		assertEquals(expected.getNode().getVisualID(), actual.getNode().getVisualID());
		assertEquals(expected.getNode().getUniqueIdentifier(), actual.getNode().getUniqueIdentifier());
		
		testElementType(expected.getElementType(), actual.getElementType());
		testViewmap(expected.getViewmap(), actual.getViewmap());
		testBehaviours(expected.getBehaviour(), actual.getBehaviour());
		testLabelModelFacet(expected.getModelFacet(), actual.getModelFacet());
		
	}

	private void testLabelModelFacet(LabelModelFacet expected, LabelModelFacet actual) {
		assertEquals(expected.eClass(), actual.eClass());
		assertNotNull(expected.getParser());
		assertNotNull(actual.getParser()); // TODO: assertEquals(Parser, Parser)
		
		if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet())) {
			testFeatureLabelModelFacet((FeatureLabelModelFacet) expected, (FeatureLabelModelFacet) actual);
		}
	}
	
	private void testFeatureLabelModelFacet(FeatureLabelModelFacet expected, FeatureLabelModelFacet actual) {
		assertEquals(expected.getViewPattern(), actual.getViewPattern());
		assertEquals(expected.getEditorPattern(), actual.getEditorPattern());
		assertEquals(expected.getEditPattern(), actual.getEditPattern());
		assertEquals(expected.getViewMethod().getLiteral(), actual.getViewMethod().getLiteral());
		assertEquals(expected.getEditMethod().getLiteral(), actual.getEditMethod().getLiteral());
		
		assertEquals(expected.getMetaFeatures().size(), actual.getMetaFeatures().size());
		for (int i=0; i<expected.getMetaFeatures().size(); i++) {
			GenFeature exp = expected.getMetaFeatures().get(i);
			GenFeature act = actual.getMetaFeatures().get(i);
			
			assertEquals(exp.eClass(), act.eClass());
			assertEquals(exp.getName(), act.getName());
		}
		assertEquals(expected.getEditableMetaFeatures().size(), actual.getEditableMetaFeatures().size());
		for (int i=0; i<expected.getEditableMetaFeatures().size(); i++) {
			GenFeature exp = expected.getMetaFeatures().get(i);
			GenFeature act = actual.getMetaFeatures().get(i);
			
			assertEquals(exp.eClass(), act.eClass());
			assertEquals(exp.getName(), act.getName());
		}
	}

	private void testTypeModelFacet(TypeModelFacet expected, TypeModelFacet actual) {
		assertEquals(expected.eClass(), actual.eClass());
		if (expected.eIsSet(GMFGenPackage.eINSTANCE.getTypeModelFacet_ContainmentMetaFeature())) {
			assertTrue(actual.eIsSet(GMFGenPackage.eINSTANCE.getTypeModelFacet_ContainmentMetaFeature()));
			assertEquals(expected.getContainmentMetaFeature().getName(), actual.getContainmentMetaFeature().getName());
		} else {
			assertFalse(actual.eIsSet(GMFGenPackage.eINSTANCE.getTypeModelFacet_ContainmentMetaFeature()));
		}
		if (expected.eIsSet(GMFGenPackage.eINSTANCE.getTypeModelFacet_ChildMetaFeature())) {
			assertTrue(actual.eIsSet(GMFGenPackage.eINSTANCE.getTypeModelFacet_ChildMetaFeature()));
			assertEquals(expected.getChildMetaFeature().getName(), actual.getChildMetaFeature().getName());
		} else {
			assertFalse(actual.eIsSet(GMFGenPackage.eINSTANCE.getTypeModelFacet_ChildMetaFeature()));
		}
	}

	private void testLinkModelFacet(LinkModelFacet expected, LinkModelFacet actual) {
		if (expected == null) {
			assertNull(actual);
		} else {
			assertNotNull(actual);
			assertEquals(expected.eClass(), actual.eClass());
		}
		
		if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getTypeLinkModelFacet())) {
			testTypeLinkModelFacet((TypeLinkModelFacet)expected, (TypeLinkModelFacet)actual);
		}
	}
	
	private void testTypeLinkModelFacet(TypeLinkModelFacet expected, TypeLinkModelFacet actual) {
		assertEquals(expected.getMetaClass().getName(), actual.getMetaClass().getName());
		testTypeModelFacet(expected, actual);
	}
	
	public void testGenParser() {
		GenParsers expected = expectedGenerator.getLabelParsers();
		GenParsers actual = actualGenerator.getLabelParsers();

		if (expected != null) {
			assertNotNull(actual);

			System.out.println(expected.getImplementations());
			System.out.println(actual.getImplementations());

			assertEquals(expected.getClassName(), actual.getClassName());
			assertEquals(expected.getImplPackageName(), actual.getImplPackageName());
			assertEquals(expected.getPackageName(), actual.getPackageName());
			assertEquals(expected.getProviderPriority().getLiteral(), actual.getProviderPriority().getLiteral());
			assertEquals(expected.isExtensibleViaService(), actual.isExtensibleViaService());

			assertEquals(expected.getImplementations().size(), actual.getImplementations().size());

			for (int i=0; i<expected.getImplementations().size(); i++) {
				GenParserImplementation exp = expected.getImplementations().get(i);
				GenParserImplementation act = actual.getImplementations().get(i);

				testGenParserImplementation(exp, act);
			}
		} else {
			assertNull(actual);
		}
	}

	private void testGenParserImplementation(GenParserImplementation expected, GenParserImplementation actual) {
		assertEquals(expected.eClass(), actual.eClass());

		assertEquals(expected.getUses().size(), actual.getUses().size());

		if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getExternalParser())) {
			testExternalParser((ExternalParser)expected, (ExternalParser)actual);
		} else if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getExpressionLabelParser())) {
			testExpressionLabelParser((ExpressionLabelParser)expected, (ExpressionLabelParser)actual);
		}
	}

	private void testExpressionLabelParser(ExpressionLabelParser expected, ExpressionLabelParser actual) {
		assertEquals(expected.getClassName(), actual.getClassName());

		assertEquals(expected.getExpressionContext().getName(), actual.getExpressionContext().getName());

		if (expected.getEditExpression() != null) {
			assertNotNull(actual.getEditExpression());

			ValueExpression exp = expected.getEditExpression();
			ValueExpression act = actual.getEditExpression();

			assertEquals(exp.eClass(), act.eClass());
			assertEquals(exp.getBody(), act.getBody());
			assertEquals(exp.getLangName(), act.getLangName());

			if (exp.getProvider() != null) {
				assertNotNull(act.getProvider());
			} else {
				assertNull(act.getProvider());
			}

			if (exp.eClass().equals(GMFGenPackage.eINSTANCE.getGenConstraint())) {

			}
		}
	}

	private void testExternalParser(ExternalParser expected, ExternalParser actual) {
		assertEquals(expected.getHint(), actual.getHint());
	}

	public void testPalette() {
		Palette expected = expectedGenerator.getDiagram().getPalette();
		Palette actual = actualGenerator.getDiagram().getPalette();
	
		assertNotNull("Expected Palette should not be null", expected);
		assertNotNull("Actual Palette should not be null", actual);
	
		assertEquals(expected.getFactoryClassName(), actual.getFactoryClassName());
		assertEquals(expected.isFlyout(), actual.isFlyout());
		assertEquals(expected.getPackageName(), actual.getPackageName());
	
		assertEquals(expected.getGroups().size(), actual.getGroups().size());
		for (int i=0; i<expected.getGroups().size(); i++) {
			ToolGroup exp = expected.getGroups().get(i);
			ToolGroup act = actual.getGroups().get(i);
	
			testToolGroup(exp, act);
		}
	}

	private void testToolGroup(ToolGroup expected, ToolGroup actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getTitle(), actual.getTitle());
		assertEquals(expected.getLargeIconPath(), actual.getLargeIconPath());
		assertEquals(expected.getSmallIconPath(), actual.getSmallIconPath());
		assertEquals(expected.getCreateMethodName(), actual.getCreateMethodName());

		assertEquals(expected.isCollapse(), actual.isCollapse());
		assertEquals(expected.isStack(), actual.isStack());
		assertEquals(expected.isToolsOnly(), actual.isToolsOnly());

		assertEquals(expected.getEntries().size(), actual.getEntries().size());
		for (int i = 0; i < expected.getEntries().size(); i++) {
			ToolGroupItem exp = expected.getEntries().get(i);
			ToolGroupItem act = actual.getEntries().get(i);

			if (exp instanceof AbstractToolEntry) {
				testAbstractToolEntry((AbstractToolEntry)exp, (AbstractToolEntry)act);
			}
		}
	}

	private void testAbstractToolEntry(AbstractToolEntry expected, AbstractToolEntry actual) {
		assertEquals(expected.eClass(), actual.eClass());

		assertEquals(expected.getCreateMethodName(), actual.getCreateMethodName());
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getTitle(), actual.getTitle());
		assertEquals(expected.getLargeIconPath(), actual.getLargeIconPath());
		assertEquals(expected.getSmallIconPath(), actual.getSmallIconPath());

		assertEquals(expected.isDefault(), actual.isDefault());
		assertEquals(expected.getQualifiedToolName(), actual.getQualifiedToolName());

		assertEquals(expected.getProperties().size(), actual.getProperties().size());
		for (int i=0; i<expected.getProperties().size(); i++) {
			Entry<String, String> exp = expected.getProperties().get(i);
			Entry<String, String> act = actual.getProperties().get(i);

			assertEquals(exp.getKey(), act.getKey());
			assertEquals(exp.getKey(), act.getValue());
		}

		if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getStandardEntry())) {
			testStandardEntry((StandardEntry) expected, (StandardEntry) actual);
		} else if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getToolEntry())) {
			testToolEntry((ToolEntry) expected, (ToolEntry) actual);
		}
	}

	private void testStandardEntry(StandardEntry expected, StandardEntry actual) {
		assertEquals(expected.getKind().getLiteral(), actual.getKind().getLiteral());
	}

	private void testToolEntry(ToolEntry expected, ToolEntry actual) {
		assertEquals(expected.getElements().size(), actual.getElements().size());
		for (int i=0; i<expected.getElements().size(); i++) {
			GenCommonBase exp = expected.getElements().get(i);
			GenCommonBase act = expected.getElements().get(i);

			assertEquals(exp.eClass(), act.eClass());
			assertEquals(exp.getVisualID(), act.getVisualID());
			assertEquals(exp.getUniqueIdentifier(), act.getUniqueIdentifier());
		}
		assertEquals(expected.getGenLinks().size(), actual.getGenLinks().size());
		for (int i=0; i<expected.getGenLinks().size(); i++) {
			GenLink exp = expected.getGenLinks().get(i);
			GenLink act = expected.getGenLinks().get(i);

			assertEquals(exp.eClass(), act.eClass());
			assertEquals(exp.getVisualID(), act.getVisualID());
			assertEquals(exp.getUniqueIdentifier(), act.getUniqueIdentifier());
		}
		assertEquals(expected.getGenNodes().size(), actual.getGenNodes().size());
		for (int i=0; i<expected.getGenNodes().size(); i++) {
			GenNode exp = expected.getGenNodes().get(i);
			GenNode act = expected.getGenNodes().get(i);

			assertEquals(exp.eClass(), act.eClass());
			assertEquals(exp.getVisualID(), act.getVisualID());
			assertEquals(exp.getUniqueIdentifier(), act.getUniqueIdentifier());
		}
	}

	public void testGenAuditRoot() {
		GenAuditRoot expected = expectedGenerator.getAudits();
		GenAuditRoot actual = actualGenerator.getAudits();

		testGenAuditContainers(expected.getCategories(), actual.getCategories());
	}

	public void testGenPreferencePages() {
		EList<GenPreferencePage> expected = expectedGenerator.getDiagram().getPreferencePages();
		EList<GenPreferencePage> actual = actualGenerator.getDiagram().getPreferencePages();

		assertEquals(expected.size(), actual.size());
		for (int i=0; i<expected.size(); i++) {
			GenPreferencePage exp = expected.get(i);
			GenPreferencePage act = actual.get(i);

			assertEquals(exp.eClass(), act.eClass());
			assertEquals(exp.getID(), act.getID());
			assertEquals(exp.getName(), act.getName());
			assertEquals(exp.getClassName(), act.getClassName());
			assertEquals(exp.getParentCategory(), act.getParentCategory());
			assertEquals(exp.getQualifiedClassName(), act.getQualifiedClassName());

			if (exp.eClass().equals(GMFGenPackage.eINSTANCE.getGenCustomPreferencePage())) {
				assertEquals((GenCustomPreferencePage)exp, (GenCustomPreferencePage)act);
			} else if (exp.eClass().equals(GMFGenPackage.eINSTANCE.getGenStandardPreferencePage())) {
				assertEquals((GenStandardPreferencePage)exp, (GenStandardPreferencePage)act);
			}
		}
	}

	private void assertEquals(GenCustomPreferencePage expected, GenCustomPreferencePage actual) {
		assertEquals(expected.isGenerateBoilerplate(), actual.isGenerateBoilerplate());
		assertEquals(expected.getQualifiedClassName(), actual.getQualifiedClassName());
	}

	private void assertEquals(GenStandardPreferencePage expected, GenStandardPreferencePage actual) {
		assertEquals(expected.getClassName(), actual.getClassName());
		assertEquals(expected.getKind().getLiteral(), actual.getKind().getLiteral());
	}

	protected void testGenAuditContainers(EList<GenAuditContainer> expected, EList<GenAuditContainer> actual) {
		assertEquals(expected.size(), actual.size());
		for (int i=0; i<expected.size(); i++) {
			GenAuditContainer exp = expected.get(i);
			GenAuditContainer act = actual.get(i);

			assertEquals(exp.getId(), act.getId());
			assertEquals(exp.getDescription(), act.getDescription());
			assertEquals(exp.getName(), act.getName());

			assertEquals(exp.getPath().size(), act.getPath().size());
		}
	}

	protected void testGenAuditRules(EList<GenAuditRule> expected, EList<GenAuditRule> actual) {
		assertEquals(expected.size(), actual.size());

		for (int i=0; i<expected.size(); i++) {
			GenAuditRule exp = expected.get(i);
			GenAuditRule act = actual.get(i);

			assertEquals(exp.getId(), act.getId());
			assertEquals(exp.getDescription(), act.getDescription());
			assertEquals(exp.getMessage(), act.getMessage());
			assertEquals(exp.getName(), act.getName());
			assertEquals(exp.isRequiresConstraintAdapter(), act.isRequiresConstraintAdapter());
			assertEquals(exp.getSeverity().getLiteral(), act.getSeverity().getLiteral());
			assertEquals(exp.isUseInLiveMode(), act.isUseInLiveMode());

			GenAuditable expAuditable = exp.getTarget();
			GenAuditable actAuditable = act.getTarget();

			assertEquals(expAuditable.eClass(), actAuditable.eClass());
			assertEquals(expAuditable.getTargetClassModelQualifiedName(), actAuditable.getTargetClassModelQualifiedName());
			assertEquals(expAuditable.getTargetClass(), actAuditable.getTargetClass());
			assertEquals(expAuditable.getContext(), actAuditable.getContext());

			if (expAuditable.eClass().equals(GMFGenPackage.eINSTANCE.getGenDomainAttributeTarget())) {
				assertEquals((GenDomainAttributeTarget) expAuditable, (GenDomainAttributeTarget) actAuditable);
			} else if (expAuditable.eClass().equals(GMFGenPackage.eINSTANCE.getGenDomainElementTarget())) {
				assertEquals((GenDomainElementTarget) expAuditable, (GenDomainElementTarget) actAuditable);
			} else if (expAuditable.eClass().equals(GMFGenPackage.eINSTANCE.getGenNotationElementTarget())) {
				assertEquals((GenNotationElementTarget) expAuditable, (GenNotationElementTarget) actAuditable);
			}
		}
	}

	private void assertEquals(GenDomainAttributeTarget expected, GenDomainAttributeTarget actual) {
		assertEquals(expected.isNullAsError(), actual.isNullAsError());
		assertEquals(expected.getAttribute(), actual.getAttribute());
	}

	private void assertEquals(GenDomainElementTarget expected, GenDomainElementTarget actual) {
		assertEquals(expected.getElement(), actual.getElement());
	}

	private void assertEquals(GenNotationElementTarget expected, GenNotationElementTarget actual) {
		assertEquals(expected.getElement(), actual.getElement());
	}

	protected void testBehaviours(EList<Behaviour> expected, EList<Behaviour> actual) {
		assertEquals(expected.size(), actual.size());

		for (int i=0; i<expected.size(); i++) {
			Behaviour exp = expected.get(i);
			Behaviour act = actual.get(i);

			assertEquals(exp.eClass(), act.eClass());
			assertEquals(exp.getEditPolicyQualifiedClassName(), act.getEditPolicyQualifiedClassName());
			assertEquals(exp.getSubject().getUniqueIdentifier(), act.getSubject().getUniqueIdentifier());

			if (exp.eClass().equals(GMFGenPackage.eINSTANCE.getOpenDiagramBehaviour())) {
				assertEquals((OpenDiagramBehaviour)exp, (OpenDiagramBehaviour)act);
			} else if (exp.eClass().equals(GMFGenPackage.eINSTANCE.getSharedBehaviour())) {
				assertEquals((SharedBehaviour)exp, (SharedBehaviour)act);
			}
		}
	}

	protected void assertEquals(OpenDiagramBehaviour expected, OpenDiagramBehaviour actual) {
		assertEquals(expected.getDiagramKind(), actual.getDiagramKind());
		assertEquals(expected.getEditorID(), actual.getEditorID());
		assertEquals(expected.getEditPolicyClassName(), actual.getEditPolicyClassName());
	}

	protected void assertEquals(SharedBehaviour expected, SharedBehaviour actual) {
		assertEquals(expected.getDelegate().getSubject().getUniqueIdentifier(), actual.getDelegate().getSubject().getUniqueIdentifier());
	}

	protected void testElementType(ElementType expected, ElementType actual) {
		if (expected == null) {
			assertNull(actual);
		} else {
			assertNotNull(actual);
	
			assertEquals(expected.eClass(), actual.eClass());
			assertEquals(expected.getDisplayName(), actual.getDisplayName());
			assertEquals(expected.getUniqueIdentifier(), actual.getUniqueIdentifier());
			assertEquals(expected.getDiagramElement().getUniqueIdentifier(), actual.getDiagramElement().getUniqueIdentifier());
		}
	}

	protected void testViewmap(Viewmap expected, Viewmap actual) {
		assertNotNull(expected);
		assertNotNull(actual);

		assertEquals(expected.eClass(), actual.eClass());
		assertEquals(expected.getLayoutType(), actual.getLayoutType());
		assertEquals(expected.getRequiredPluginIDs().size(), actual.getRequiredPluginIDs().size());

		for (int i=0; i<expected.getRequiredPluginIDs().size(); i++) {
			String exp = expected.getRequiredPluginIDs().get(i);
			String act = expected.getRequiredPluginIDs().get(i);

			assertEquals(exp, act);
		}
		List<String> actualPluginsIDs = actual.getRequiredPluginIDs();
		for (int i=0; i<expected.getRequiredPluginIDs().size(); i++) {
			String exp = expected.getRequiredPluginIDs().get(i);
			
			assertTrue(actualPluginsIDs.contains(exp));
		}
		EList<Attributes> expAttributes = expected.getAttributes();
		EList<Attributes> actAttributes = actual.getAttributes();
		assertEquals(expAttributes.size(), actAttributes.size());
		for (int j=0; j<expAttributes.size(); j++) {
			Attributes expAttr = expAttributes.get(j);
			Attributes actAttr = actAttributes.get(j);
			testAttributes(expAttr, actAttr);
		}

		if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getFigureViewmap())) {
			assertEquals((FigureViewmap)expected, (FigureViewmap)actual);
		} else if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getSnippetViewmap())) {
			assertEquals((SnippetViewmap)expected, (SnippetViewmap)actual);
		} else if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getInnerClassViewmap())) {
			assertEquals((InnerClassViewmap)expected, (InnerClassViewmap)actual);
		} else if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getParentAssignedViewmap())) {
			assertEquals((ParentAssignedViewmap)expected, (ParentAssignedViewmap)actual);
		} else if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getModeledViewmap())) {
			assertEquals((ModeledViewmap)expected, (ModeledViewmap)actual);
		}
	}

	protected void assertEquals(ModeledViewmap expected, ModeledViewmap actual) {
		assertEquals(expected.getFigureModel(), actual.getFigureModel());
	}

	protected void assertEquals(ParentAssignedViewmap expected, ParentAssignedViewmap actual) {
		assertEquals(expected.getFigureQualifiedClassName(), actual.getFigureQualifiedClassName());
		assertEquals(expected.getGetterName(), actual.getGetterName());
		assertEquals(expected.getSetterName(), actual.getSetterName());
	}

	protected void assertEquals(InnerClassViewmap expected, InnerClassViewmap actual) {
		assertEquals(expected.getClassBody(), actual.getClassBody());
		assertEquals(expected.getClassName(), actual.getClassName());
	}

	protected void assertEquals(SnippetViewmap expected, SnippetViewmap actual) {
		assertEquals(expected.getBody(), actual.getBody());
	}

	protected void assertEquals(FigureViewmap expected, FigureViewmap actual) {
		assertEquals(expected.getFigureQualifiedClassName(), actual.getFigureQualifiedClassName());
	}

	protected void testAttributes(Attributes expected, Attributes actual) {
		assertNotNull(expected);
		assertNotNull(actual);

		assertEquals(expected.eClass(), actual.eClass());

		if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getColorAttributes())) {
			assertEquals((ColorAttributes) expected, (ColorAttributes) actual);
		} else if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getStyleAttributes())) {
			assertEquals((StyleAttributes) expected, (StyleAttributes) actual);
		} else if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getResizeConstraints())) {
			assertEquals((ResizeConstraints) expected, (ResizeConstraints) actual);
		} else if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getDefaultSizeAttributes())) {
			assertEquals((DefaultSizeAttributes) expected, (DefaultSizeAttributes) actual);
		} else if (expected.eClass().equals(GMFGenPackage.eINSTANCE.getLabelOffsetAttributes())) {
			assertEquals((LabelOffsetAttributes) expected, (LabelOffsetAttributes) actual);
		} else {
			throw new IllegalArgumentException("EClass not found");
		}
	}

	protected void assertEquals(ColorAttributes expected, ColorAttributes actual) {
		assertEquals(expected.getBackgroundColor(), actual.getBackgroundColor());
		assertEquals(expected.getForegroundColor(), actual.getForegroundColor());
	}

	protected void assertEquals(StyleAttributes expected, StyleAttributes actual) {
		assertEquals(expected.isFixedBackground(), actual.isFixedBackground());
		assertEquals(expected.isFixedFont(), actual.isFixedFont());
		assertEquals(expected.isFixedForeground(), actual.isFixedForeground());
	}

	protected void assertEquals(ResizeConstraints expected, ResizeConstraints actual) {
		assertEquals(expected.getNonResizeHandles(), actual.getNonResizeHandles());
		assertEquals(expected.getResizeHandles(), actual.getResizeHandles());
		assertEquals(expected.getResizeHandleNames().size(), actual.getResizeHandleNames().size());
		for (int i=0; i<expected.getResizeHandleNames().size(); i++) {
			String exp = expected.getResizeHandleNames().get(i);
			String act = actual.getResizeHandleNames().get(i);

			assertEquals(exp, act);
		}
		assertEquals(expected.getNonResizeHandleNames().size(), actual.getNonResizeHandleNames().size());
		for (int i=0; i<expected.getNonResizeHandleNames().size(); i++) {
			String exp = expected.getNonResizeHandleNames().get(i);
			String act = actual.getNonResizeHandleNames().get(i);

			assertEquals(exp, act);
		}
	}

	protected void assertEquals(DefaultSizeAttributes expected, DefaultSizeAttributes actual) {
		assertEquals(expected.getHeight(), actual.getHeight());
		assertEquals(expected.getWidth(), actual.getWidth());
	}

	protected void assertEquals(LabelOffsetAttributes expected, LabelOffsetAttributes actual) {
		assertEquals(expected.getX(), actual.getX());
		assertEquals(expected.getY(), actual.getY());
	}

	private GenCompartment findCompartment(GenCompartment expected, EList<GenCompartment> compartments) {
		for (GenCompartment actual: compartments) {
			if (actual.getUniqueIdentifier().equals(expected.getUniqueIdentifier())) {
				return actual;
			}
		}
		return null;
	}

	protected IProject createProject() {
		String projectName = "TransformToGenModelOperationTest_" + String.valueOf(System.currentTimeMillis()); //$NON-NLS-1$
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		assertFalse("Project with this name already present in the workspace: " + projectName, project.exists());
		try {
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());
		} catch (CoreException e) {
			fail(e.getMessage());
		}
		assertTrue("Project was not created: " + projectName, project.exists());
		return project;
	}

	protected void deleteProject() throws CoreException {
		if (getProject() != null) {
			if (getProject().isOpen()) {
				getProject().close(new NullProgressMonitor());
			}
			if (getProject().exists()) {
				getProject().delete(true, new NullProgressMonitor());
			}
		}
	}

	protected IProject getProject() {
		return myProject;
	}
}
