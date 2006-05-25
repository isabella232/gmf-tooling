/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.internal.codegen.GMFGenConfig;
import org.eclipse.gmf.internal.common.reconcile.DefaultDecisionMaker;
import org.eclipse.gmf.internal.common.reconcile.Reconciler;
import org.eclipse.gmf.internal.common.reconcile.ReconcilerConfigBase;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.gmf.tests.setup.DiaDefSetup;
import org.eclipse.gmf.tests.setup.DiaDefSource;
import org.eclipse.gmf.tests.setup.DiaGenSetup;
import org.eclipse.gmf.tests.setup.DomainModelSetup;
import org.eclipse.gmf.tests.setup.DomainModelSource;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.MapSetup;
import org.eclipse.gmf.tests.setup.ToolDefSetup;
import org.eclipse.gmf.tests.setup.ToolDefSource;
import org.eclipse.gmf.tests.setup.DomainModelSource.NodeData;

public class CodegenReconcileTest extends ConfiguredTestCase {

	private GenEditorGenerator myEditorGen;

	public CodegenReconcileTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		MapDefSource mapDefSource = new MapSetup().init(new DiaDefSetup(null).init(), getSetup().getDomainModel(), new ToolDefSetup());
		DiaGenSetup diaGenSetup = new DiaGenSetup().init(mapDefSource);
		myEditorGen = diaGenSetup.getGenDiagram().getEditorGen();
	}

	protected final GenEditorGenerator getOriginal() {
		return myEditorGen;
	}

	protected final GenEditorGenerator createCopy() {
		return (GenEditorGenerator) EcoreUtil.copy(getOriginal());
	}

	public void testLoadGMFGen() throws Exception {
		GenEditorGenerator original = getOriginal();
		assertNotNull(original);
		GenEditorGenerator copy = createCopy();
		assertNotNull(copy);

		assertFalse(original == copy);
		assertFalse(original.equals(copy));

		assertEquals(original.getCopyrightText(), copy.getCopyrightText());
		assertEquals(original.isSameFileForDiagramAndModel(), copy.isSameFileForDiagramAndModel());
		assertEquals(original.getPackageNamePrefix(), copy.getPackageNamePrefix());

		final String NEW_VALUE = "New Value";
		copy.setCopyrightText(NEW_VALUE);
		assertEquals(copy.getCopyrightText(), NEW_VALUE);
		assertFalse(copy.getCopyrightText().equals(original.getCopyrightText()));
	}

	public void testReconcileDeepElementWithAlwaysMatcher() throws Exception {
		class GenPluginChange extends Assert implements UserChange {
			private final String NEW_PROVIDER = "NewProviderValue";
			private final String NEW_VERSION = "NewVersionValue";
			private final String NEW_ID = "NewPluginID";
			private final String NEW_ACTIVATOR = "NewActivator";
			private boolean myExpectedPrintingEnabled;

			public void applyChanges(GenEditorGenerator old) {
				GenPlugin genPlugin = old.getPlugin();
				assertNotNull(genPlugin.getProvider());
				assertNotNull(genPlugin.getVersion());
				assertNotNull(genPlugin.getID());
				assertNotNull(genPlugin.getActivatorClassName());
				assertFalse(genPlugin.isPrintingEnabled());
				
				myExpectedPrintingEnabled = !genPlugin.isPrintingEnabled();

				genPlugin.setProvider(NEW_PROVIDER);
				genPlugin.setVersion(NEW_VERSION);
				genPlugin.setID(NEW_ID);
				genPlugin.setActivatorClassName(NEW_ACTIVATOR);
				genPlugin.setPrintingEnabled(myExpectedPrintingEnabled);
			}
			
			public void assertChangesPreserved(GenEditorGenerator current) {
				GenPlugin genPlugin = current.getPlugin();
				assertEquals(NEW_PROVIDER, genPlugin.getProvider());
				assertEquals(NEW_VERSION, genPlugin.getVersion());
				assertEquals(NEW_ID, genPlugin.getID());
				assertEquals(NEW_ACTIVATOR, genPlugin.getActivatorClassName());
				assertEquals(myExpectedPrintingEnabled, genPlugin.isPrintingEnabled());
			}
			
			public ReconcilerConfigBase getReconcilerConfig() {
				return new GMFGenConfig();
			}
		}
		
		checkUserChange(new GenPluginChange());
	}
	
	
	public void testReconcileCompartmentIsListlayout(){
		class ConfigWithCompartments implements DiaDefSetup.Config {
			public void setupCanvasDef(Canvas canvasDef) {
				FigureGallery oneMoreGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
				canvasDef.getFigures().add(oneMoreGallery);
				Figure compartmentFigure = GMFGraphFactory.eINSTANCE.createRectangle();
				oneMoreGallery.getFigures().add(compartmentFigure);
				Compartment compartment = createCompartment(compartmentFigure, "CompartmentA", true, true);
				canvasDef.getCompartments().add(compartment);
			}
			
			public void setupLinkDef(Connection linkDef) {
				// 
			}
			
			public void setupNodeDef(Node nodeDef) {
				// 
			}

			private Compartment createCompartment(Figure figure, String name, boolean collapsible, boolean needsTitle){
				Compartment result = GMFGraphFactory.eINSTANCE.createCompartment();
				result.setCollapsible(true);
				result.setFigure(figure);
				result.setName(name);
				result.setNeedsTitle(needsTitle);
				return result;
			}
		}

		class DiaDefSetupWithCompartments extends DiaDefSetup {
			public DiaDefSetupWithCompartments(){
				super(new ConfigWithCompartments());
			}
			
			public Compartment getCompartment(){
				return (Compartment)getCanvasDef().getCompartments().get(0);
			}
		}
		
		class DomainSetupWithChildren extends DomainModelSetup {
			private NodeData myChildOfA;
			
			public DomainModelSetup init() {
				DomainModelSetup result = super.init();

				EClass childClass = EcoreFactory.eINSTANCE.createEClass();
				childClass.setName("ChildOfA");
				EAttribute childLabel = EcoreFactory.eINSTANCE.createEAttribute();
				childLabel.setName("childLabel");
				childLabel.setEType(EcorePackage.eINSTANCE.getEString());
				childClass.getEStructuralFeatures().add(childLabel);
				result.getModel().getEClassifiers().add(childClass);
				
				EReference containment = EcoreFactory.eINSTANCE.createEReference();
				containment.setContainment(true);
				containment.setName("childrenOfA");
				containment.setEType(childClass);
				containment.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
				result.getNodeA().getEClass().getEStructuralFeatures().add(containment);
				
				myChildOfA = new NodeData(childClass, childLabel, containment);
				return result;
			}
			
			public NodeData getChildOfA() {
				return myChildOfA;
			}
		}
		
		class MapSetupWithCompartments extends MapSetup {
			public MapSetup init(DiaDefSource ddSource, DomainModelSource domainSource, ToolDefSource toolDef) {
				Assert.assertTrue(domainSource instanceof DomainSetupWithChildren);
				Assert.assertTrue(ddSource instanceof DiaDefSetupWithCompartments);
				
				DomainSetupWithChildren domainWithChildren = (DomainSetupWithChildren)domainSource;
				DiaDefSetupWithCompartments diaDefSetupWithCompartments = (DiaDefSetupWithCompartments)ddSource;
				Assert.assertNotNull(diaDefSetupWithCompartments.getCompartment());
				
				MapSetup result = super.init(ddSource, domainSource, toolDef);
				
				NodeData childOfAData = domainWithChildren.getChildOfA();
				NodeMapping childOfAMapping = createNodeMapping(ddSource.getNodeDef(), childOfAData.getEClass(), ddSource.getLabelDef(), childOfAData.getNameAttr(), childOfAData.getContainment(), false);
				
				ChildReference childOfAReference = GMFMapFactory.eINSTANCE.createChildReference();
				childOfAReference.setOwnedChild(childOfAMapping);
				childOfAReference.setChildrenFeature(childOfAData.getContainment());
				result.getNodeA().getChildren().add(childOfAReference);
				
				CompartmentMapping childOfACompartment = GMFMapFactory.eINSTANCE.createCompartmentMapping();
				childOfACompartment.setCompartment(diaDefSetupWithCompartments.getCompartment());
				childOfACompartment.getChildren().add(childOfAReference);
				result.getNodeA().getCompartments().add(childOfACompartment);

				return result;
			}
		}

		class CompartmentChange extends Assert implements UserChange {
			private int myCompartmentsTotalCount;
			private final EStructuralFeature myGenCompartmentFeature;
			private final Boolean myExpectedValue;

			public CompartmentChange(EStructuralFeature genCompartmentFeature, boolean expectedValue){
				assertEquals(EcorePackage.eINSTANCE.getEBoolean(), genCompartmentFeature.getEType());
				myGenCompartmentFeature = genCompartmentFeature;
				myExpectedValue = Boolean.valueOf(expectedValue);
			}
			
			public final void applyChanges(GenEditorGenerator old) {
				GenDiagram diagram = old.getDiagram();
				assertEquals(1, diagram.getChildNodes().size());
				
				myCompartmentsTotalCount = 0;
				for (Iterator allNodes = diagram.getAllNodes().iterator(); allNodes.hasNext();){
					GenNode next = (GenNode) allNodes.next();
					for (Iterator compartments = next.getCompartments().iterator(); compartments.hasNext();){
						GenCompartment nextCompartment = (GenCompartment)compartments.next();
						myCompartmentsTotalCount++;
						nextCompartment.eSet(myGenCompartmentFeature, myExpectedValue);
					}
				}
				
				assertTrue(myCompartmentsTotalCount > 0);
			}
			
			public final void assertChangesPreserved(GenEditorGenerator current) {
				GenDiagram diagram = current.getDiagram();
				assertEquals(1, diagram.getChildNodes().size());
				
				int actualCompartmentsTotalCount = 0;
				for (Iterator allNodes = diagram.getAllNodes().iterator(); allNodes.hasNext();){
					GenNode next = (GenNode) allNodes.next();
					for (Iterator compartments = next.getCompartments().iterator(); compartments.hasNext();){
						GenCompartment nextCompartment = (GenCompartment)compartments.next();
						actualCompartmentsTotalCount++;
						Boolean actualValue = (Boolean)nextCompartment.eGet(myGenCompartmentFeature);
						assertEquals(getChangeDescription(), myExpectedValue, actualValue);
					}
				}
				
				assertEquals(myCompartmentsTotalCount, actualCompartmentsTotalCount);
			}
			
			public ReconcilerConfigBase getReconcilerConfig() {
				return new GMFGenConfig();
			}
			
			private String getChangeDescription() {
				return "CompartmentChange: " + myGenCompartmentFeature.getName() + ":" + myExpectedValue;
			}
		}
		
		DiaDefSetupWithCompartments ddSource = new DiaDefSetupWithCompartments();
		DomainSetupWithChildren domainSetup = new DomainSetupWithChildren();
		MapSetupWithCompartments mapDefSource = new MapSetupWithCompartments();
		mapDefSource.init(ddSource.init(), domainSetup.init(), new ToolDefSetup());
		
		assertFalse(mapDefSource.getNodeA().getCompartments().isEmpty());

		DiaGenSetup diaGenSetup = new DiaGenSetup().init(mapDefSource);
		myEditorGen = diaGenSetup.getGenDiagram().getEditorGen();
		
		assertNotNull(myEditorGen);
		assertFalse(diaGenSetup.getNodeA().getCompartments().isEmpty());
		
		final GMFGenPackage GMFGEN = GMFGenPackage.eINSTANCE;
		
		checkUserChange(new CompartmentChange(GMFGEN.getGenCompartment_CanCollapse(), true));
		checkUserChange(new CompartmentChange(GMFGEN.getGenCompartment_CanCollapse(), false));
		checkUserChange(new CompartmentChange(GMFGEN.getGenCompartment_HideIfEmpty(), true));
		checkUserChange(new CompartmentChange(GMFGEN.getGenCompartment_HideIfEmpty(), false));
		checkUserChange(new CompartmentChange(GMFGEN.getGenCompartment_NeedsTitle(), true));
		checkUserChange(new CompartmentChange(GMFGEN.getGenCompartment_NeedsTitle(), false));
		checkUserChange(new CompartmentChange(GMFGEN.getGenCompartment_ListLayout(), true));
		checkUserChange(new CompartmentChange(GMFGEN.getGenCompartment_ListLayout(), false));
	}
	
	public void testReconcileGenNodes() throws Exception {
		MapDefSource mapDefSource = new MapSetup().init(new DiaDefSetup(null).init(), getSetup().getDomainModel(), new ToolDefSetup());
		DiaGenSetup diaGenSetup = new DiaGenSetup().init(mapDefSource);
		myEditorGen = diaGenSetup.getGenDiagram().getEditorGen();
			
		class ListLayoutChange extends Assert implements UserChange {
			private final String NEW_CANONICAL_EP = "MyCanonicalPolicy";
			private final String NEW_GRAPHICAL_EP = "MyGraphicalPolicy";
			private final String BAD_CANONICAL_EP = "MyCanonicalEditPolicy"; //changed but still follows "(.*)CanonicalEditPolicy" pattern
			private final String BAD_GRAPHICAL_EP = "MyGraphicalNodeEditPolicy"; //changed but still follows "(.*)GraphicalNodeEditPolicy" pattern
			
			public void applyChanges(GenEditorGenerator old) {
				EList oldNodes = old.getDiagram().getAllNodes();
				assertEquals(2, oldNodes.size());
				GenNode nodeA = (GenNode) oldNodes.get(0);
				GenNode nodeB = (GenNode) oldNodes.get(1);
				
				nodeA.setCanonicalEditPolicyClassName(NEW_CANONICAL_EP);
				nodeA.setGraphicalNodeEditPolicyClassName(NEW_GRAPHICAL_EP);
				
				nodeB.setCanonicalEditPolicyClassName(BAD_CANONICAL_EP);
				nodeB.setGraphicalNodeEditPolicyClassName(BAD_GRAPHICAL_EP);
			}
			
			public void assertChangesPreserved(GenEditorGenerator current) {
				EList currentNodes = current.getDiagram().getAllNodes();
				assertEquals(2, currentNodes.size());
				GenNode nodeA = (GenNode) currentNodes.get(0);
				GenNode nodeB = (GenNode) currentNodes.get(1);
				
				assertEquals(NEW_CANONICAL_EP, nodeA.getCanonicalEditPolicyClassName());
				assertEquals(NEW_GRAPHICAL_EP, nodeA.getGraphicalNodeEditPolicyClassName());
				
				//FIXME: the checks below handle the problem with string-pattern reconciling approach
				//remove this checks when we will be able to reconcile this correctly
				assertFalse(BAD_CANONICAL_EP.equals(nodeB.getCanonicalEditPolicyClassName()));
				assertFalse(BAD_GRAPHICAL_EP.equals(nodeB.getGraphicalNodeEditPolicyClassName()));
			}
			
			public ReconcilerConfigBase getReconcilerConfig() {
				return new GMFGenConfig();
			}
		}
		
		checkUserChange(new ListLayoutChange());
	}
	
	public void testReconcileDiagramShortcuts(){
		final String[] PROVIDED_FOR = {"ModelA", "ModelB", "ModelC"}; 
		final String[] CONTAINS_TO = {"txt", "mdm", "taipan"};
		final String[] EMPTY = new String[0];
		
		class ShortcutChange extends Assert implements UserChange {
			private final String[] myProvidedFor;
			private final String[] myContainsTo;
			
			public ShortcutChange(String[] providedFor, String[] containsTo){
				myProvidedFor = providedFor;
				myContainsTo = containsTo;
			}
			
			public void applyChanges(GenEditorGenerator old) {
				GenDiagram diagram = old.getDiagram();
				assertNotNull(diagram);
				diagram.getShortcutsProvidedFor().addAll(Arrays.asList(myProvidedFor));
				diagram.getContainsShortcutsTo().addAll(Arrays.asList(myContainsTo));
				
				assertEqualsLists(Arrays.asList(myProvidedFor), diagram.getShortcutsProvidedFor());
				assertEqualsLists(Arrays.asList(myContainsTo), diagram.getContainsShortcutsTo());
			}

			public void assertChangesPreserved(GenEditorGenerator current) {
				GenDiagram diagram = current.getDiagram();
				assertEqualsLists(Arrays.asList(myProvidedFor), diagram.getShortcutsProvidedFor());
				assertEqualsLists(Arrays.asList(myContainsTo), diagram.getContainsShortcutsTo());
			}
			
			public ReconcilerConfigBase getReconcilerConfig() {
				return new GMFGenConfig();
			}
			
			private void assertEqualsLists(List expected, List actual){
				assertEquals(new ArrayList(expected), new ArrayList(actual));
			}
		}
		
		ShortcutChange someChange = new ShortcutChange(PROVIDED_FOR, CONTAINS_TO); 
		ShortcutChange emptyChange = new ShortcutChange(EMPTY, EMPTY);
		
		checkUserChange(someChange);
		checkUserChange(emptyChange);
	}

	public void testReconcileGenEditorGenerator() throws Exception {
		class UserChangeImpl extends Assert implements UserChange {
			private boolean mySameFile;
			private final boolean myExpectingCopyrightPreserved;
			
			public UserChangeImpl(boolean reconcileCopyright){
				myExpectingCopyrightPreserved = reconcileCopyright;
			}
			
			public void applyChanges(GenEditorGenerator old){
				old.setCopyrightText("AAA");
				old.setPackageNamePrefix("BBB");
				old.setDiagramFileExtension("CCC");
				
				mySameFile = !old.isSameFileForDiagramAndModel();

				old.setSameFileForDiagramAndModel(mySameFile);

				// we do not reconcile this now
				old.setTemplateDirectory("DDD");
				assertEquals("DDD", old.getTemplateDirectory());
			}
			
			public void assertChangesPreserved(GenEditorGenerator current){
				if (myExpectingCopyrightPreserved){
					assertEquals("AAA", current.getCopyrightText());
				} else {
					assertFalse("AAA".equals(current.getCopyrightText()));
				}

				assertEquals("BBB", current.getPackageNamePrefix());
				assertEquals("CCC", current.getDiagramFileExtension());
				assertEquals(mySameFile, current.isSameFileForDiagramAndModel());
				
				assertFalse("DDD".equals(current.getTemplateDirectory()));
			}
			
			public ReconcilerConfigBase getReconcilerConfig(){
				return new LimitedGMFGenConfig(myExpectingCopyrightPreserved);
			}
		}
		
		checkUserChange(new UserChangeImpl(false));
		checkUserChange(new UserChangeImpl(true));
	}
	
	private void checkUserChange(UserChange userChange){
		GenEditorGenerator old = createCopy();
		GenEditorGenerator current = createCopy();
		
		userChange.applyChanges(old);
		new Reconciler(userChange.getReconcilerConfig()).reconcileTree(current, old);
		userChange.assertChangesPreserved(current);
	}
	
	private static interface UserChange {
		public void applyChanges(GenEditorGenerator old);
		public void assertChangesPreserved(GenEditorGenerator current);
		public ReconcilerConfigBase getReconcilerConfig();
	}

	private static class LimitedGMFGenConfig extends ReconcilerConfigBase {
		public LimitedGMFGenConfig(boolean reconcileCopyright){
			final GMFGenPackage GMFGEN = GMFGenPackage.eINSTANCE;

			setMatcher(GMFGEN.getGenEditorGenerator(), ALWAYS_MATCH);
			if (reconcileCopyright){
				preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_CopyrightText());
			}
			preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_PackageNamePrefix());
			preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_DiagramFileExtension());
			preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_SameFileForDiagramAndModel());
			
			setMatcher(GMFGEN.getGenPlugin(), ALWAYS_MATCH); //exactly one feature for ALWAYS_MATCH GenEditorGenerator
			preserveIfSet(GMFGEN.getGenPlugin(), GMFGEN.getGenPlugin_Provider());
			preserveIfSet(GMFGEN.getGenPlugin(), GMFGEN.getGenPlugin_Version());
		}
		
		private void preserveIfSet(EClass eClass, EAttribute feature){
			//FIXME: only attributes for now, allow references
			addDecisionMaker(eClass, new DefaultDecisionMaker(feature));
		}
	}
	
}
