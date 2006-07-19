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
package org.eclipse.gmf.tests.gen;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenEditorView;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.SpecializationType;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.jdt.core.JavaConventions;

/**
 * Tests for handcoded method implementations in GMFGen model
 * @author artem
 */
public class HandcodedImplTest extends ConfiguredTestCase {
	
	private static final String INVALID_JAVA_CHARS = "<>?#!. =\"'\n\t\\";
	
	private GenDiagram myGenModel;

	public HandcodedImplTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		// FIXME need complex genmodel with a lot of nodes and links to make tests effective 
		myGenModel = getSetup().getGenModel().getGenDiagram();
	}

	public void testUniqueIdentifier_IsUnique() {
		HashSet allIds = new HashSet(1<<7);
		for (GenCommonBaseIterator it = new GenCommonBaseIterator(myGenModel); it.hasNext();) {
			GenCommonBase next = it.nextElement();
			assertFalse("There should be no two same 'unique' identifiers in GMFGen", allIds.contains(next.getUniqueIdentifier()));
			allIds.add(next.getUniqueIdentifier());
		}
		assertTrue("Test is not valid unless few elements were checked", allIds.size() > 1);
		allIds.clear();
	}

	public void testUniqueIdentifier_IsConstant() {
		LinkedList/*<String>*/ allIdsOrdered = new LinkedList/*<String>*/();
		for (GenCommonBaseIterator it = new GenCommonBaseIterator(myGenModel); it.hasNext();) {
			GenCommonBase next = it.nextElement();
			allIdsOrdered.add(next.getUniqueIdentifier());
		}
		assertTrue("Test is not valid unless there are few elements to check", allIdsOrdered.size() > 1);
		Iterator itSaved = allIdsOrdered.iterator();
		GenCommonBaseIterator it = new GenCommonBaseIterator(myGenModel);
		for (; it.hasNext() && itSaved.hasNext();) {
			GenCommonBase next = it.nextElement();
			String savedID = itSaved.next().toString();
			assertEquals("Subsequent invocations of getUniqueIdentifier produce different results", savedID, next.getUniqueIdentifier());
		}
		assertEquals("Lists are not equal in size", itSaved.hasNext(), it.hasNext());
		allIdsOrdered.clear();
	}

	public void testGenEditorGenerator_DomainFileExtension(){
		GenEditorGenerator generator = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		generator.setDomainFileExtension("AAA");
		assertEquals("AAA", generator.getDomainFileExtension());
		
		generator.setDomainFileExtension(null);
		assertNotNull(generator.getDomainFileExtension());
		
		GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		GenPackage genPackage = GenModelFactory.eINSTANCE.createGenPackage();
		genPackage.setPrefix("CBA");
		genModel.getGenPackages().add(genPackage);
		generator.setDomainGenModel(genModel);
		assertNotNull(generator.getDomainFileExtension());
		assertEquals("cba", generator.getDomainFileExtension());

		generator.setDomainFileExtension("");
		assertNotNull(generator.getDomainFileExtension());
		assertEquals("cba", generator.getDomainFileExtension());

		generator.setDomainFileExtension(" ");
		assertNotNull(generator.getDomainFileExtension());
		assertEquals("cba", generator.getDomainFileExtension());
	}
	
	public void testGenEditorGenerator_DiagramFileExtension(){
		GenEditorGenerator generator = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		generator.setDomainFileExtension("AAA");
		generator.setDiagramFileExtension("BBB");
		assertEquals("AAA", generator.getDomainFileExtension());
		assertEquals("BBB", generator.getDiagramFileExtension());
		
		generator.setDomainFileExtension("AAA");
		generator.setDiagramFileExtension(null);
		assertNotNull(generator.getDiagramFileExtension());
		assertTrue(generator.getDiagramFileExtension().length() != 0);
		
		generator.setDomainFileExtension("AAA");
		generator.setDiagramFileExtension("");
		assertNotNull(generator.getDiagramFileExtension());
		assertFalse("".equals(generator.getDiagramFileExtension()));
	}
	
	public void testGenEditorGenerator_ModelId(){
		GenEditorGenerator generator = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		assertNotNull(generator.getModelID());
		assertFalse(generator.getModelID().trim().length() == 0);

		generator.setModelID("");
		assertNotNull(generator.getModelID());
		assertFalse(generator.getModelID().trim().length() == 0);
	
		generator.setModelID(" ");
		assertNotNull(generator.getModelID());
		assertFalse(generator.getModelID().trim().length() == 0);
		
		generator.setModelID("ABC");
		assertEquals("ABC", generator.getModelID());
		
		generator = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		GenModel mockGenModel = GenModelFactory.eINSTANCE.createGenModel();
		mockGenModel.setModelName("CBA");
		generator.setDomainGenModel(mockGenModel);
		assertEquals("CBA", generator.getModelID());
	}
	
	public void testGenEditorGenerator_PackageNamePrefix() {
		GenEditorGenerator generator = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		generator.setPackageNamePrefix(null);
		assertNotNull(generator.getPackageNamePrefix());

		generator.setPackageNamePrefix("ABC");
		assertEquals("ABC", generator.getPackageNamePrefix());

		GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		GenPackage genPackage = GenModelFactory.eINSTANCE.createGenPackage();
		genPackage.setBasePackage("CBA");
		genModel.getGenPackages().add(genPackage);
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("DEF");
		genPackage.setEcorePackage(ePackage);
		generator.setDomainGenModel(genModel);
		assertEquals("ABC", generator.getPackageNamePrefix());
		
		generator.setPackageNamePrefix(null);
		assertNotNull(generator.getPackageNamePrefix());
		assertTrue(generator.getPackageNamePrefix().trim().length() > 0);
		
		generator.setPackageNamePrefix("");
		assertNotNull(generator.getPackageNamePrefix());
		assertTrue(generator.getPackageNamePrefix().trim().length() > 0);

		generator.setPackageNamePrefix(" ");
		assertNotNull(generator.getPackageNamePrefix());
		assertTrue(generator.getPackageNamePrefix().trim().length() > 0);
	}
	
	public void testGetAllDomainGenPackages() {
		GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		genModel.setModelPluginID("plugin1");
		genModel.setModelDirectory("modelDir1");
		genModel.setEditDirectory("dir1");
		genModel.setEditPluginClass("EditPluginClassName");
		GenPackage genPackage1 = GenModelFactory.eINSTANCE.createGenPackage();
		GenClass genClass = GenModelFactory.eINSTANCE.createGenClass();
		genPackage1.getGenClasses().add(genClass);
		genModel.getGenPackages().add(genPackage1);
		GenPackage genPackage2 = GenModelFactory.eINSTANCE.createGenPackage();
		genModel.getGenPackages().add(genPackage2);
		
		GenEditorGenerator generator = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		generator.setDomainGenModel(genModel);
		
		assertTrue(generator.getAllDomainGenPackages(false).size() == 1);
		assertEquals(genPackage1, generator.getAllDomainGenPackages(false).get(0));
		
		GenModel genModel2 = GenModelFactory.eINSTANCE.createGenModel();
		genModel2.setModelPluginID("plugin2");
		genModel2.setModelDirectory("modelDir2");
		genModel2.setEditDirectory("dir2");
		genModel2.setEditPluginClass("EditPluginClassName2");
		GenPackage genPackage3 = GenModelFactory.eINSTANCE.createGenPackage();
		genClass = GenModelFactory.eINSTANCE.createGenClass();
		genPackage3.getGenClasses().add(genClass);
		genModel2.getGenPackages().add(genPackage3);
		GenPackage genPackage4 = GenModelFactory.eINSTANCE.createGenPackage();
		genModel2.getGenPackages().add(genPackage4);
		genModel.getUsedGenPackages().add(genPackage3);
		genModel.getUsedGenPackages().add(genPackage4);
		
		assertTrue(generator.getAllDomainGenPackages(false).size() == 1);
		assertEquals(genPackage1, generator.getAllDomainGenPackages(false).get(0));		

		assertTrue(generator.getAllDomainGenPackages(true).size() == 2);
		assertTrue(generator.getAllDomainGenPackages(true).contains(genPackage1));		
		assertTrue(generator.getAllDomainGenPackages(true).contains(genPackage3));
	}
	
	public void testGenPlugin_RequiredPluginIds(){
		final String BUNDLE_EXPRESSIONS = "com.mycompany.expressions";
		final String[] BUNDLE_VIEWMAPS_MANY = {"com.mycompany.viewmapsA", "com.mycompany.viewmapsB"};
		final String BUNDLE_VIEWMAPS_ONE = "com.mycompany.viewmapsC";

		GenEditorGenerator mockGenerator = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		
		GenExpressionProviderContainer expressionProviderContainer = GMFGenFactory.eINSTANCE.createGenExpressionProviderContainer();
		mockGenerator.setExpressionProviders(expressionProviderContainer);
		GenExpressionInterpreter expressionProvider = GMFGenFactory.eINSTANCE.createGenExpressionInterpreter();
		expressionProviderContainer.getProviders().add(expressionProvider);
		expressionProvider.getRequiredPluginIDs().add(BUNDLE_EXPRESSIONS);
		
		GenPlugin mockPlugin = GMFGenFactory.eINSTANCE.createGenPlugin();
		mockGenerator.setPlugin(mockPlugin);
		
		GenDiagram mockDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		mockGenerator.setDiagram(mockDiagram);
		
		GenNode mockNodeA = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		mockDiagram.getTopLevelNodes().add(mockNodeA);
		Viewmap mockViewmapA = GMFGenFactory.eINSTANCE.createFigureViewmap();
		mockViewmapA.getRequiredPluginIDs().add(BUNDLE_VIEWMAPS_ONE);
		mockNodeA.setViewmap(mockViewmapA);
		
		GenNode mockNodeB = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		mockDiagram.getTopLevelNodes().add(mockNodeB);
		Viewmap mockViewmapB = GMFGenFactory.eINSTANCE.createFigureViewmap();
		mockViewmapB.getRequiredPluginIDs().addAll(Arrays.asList(BUNDLE_VIEWMAPS_MANY));
		mockNodeB.setViewmap(mockViewmapB);
		
		List allRequired = mockPlugin.getRequiredPluginIDs();  
		assertTrue(allRequired.contains(BUNDLE_EXPRESSIONS));
		assertTrue(allRequired.contains(BUNDLE_VIEWMAPS_ONE));
		assertTrue(allRequired.containsAll(Arrays.asList(BUNDLE_VIEWMAPS_MANY)));
	}
	
	public void testGenPlugin_id() {
		GenPlugin genPlugin = GMFGenFactory.eINSTANCE.createGenPlugin();
		GenEditorGenerator editorGen = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		editorGen.setPlugin(genPlugin);
		genPlugin.setID(null);
		assertNotNull(genPlugin.getID());
		assertTrue(genPlugin.getID().length() > 0);
		
		genPlugin.setID("");
		assertNotNull(genPlugin.getID());
		assertTrue(genPlugin.getID().length() > 0);

		genPlugin.setID("pluginID");
		assertEquals("pluginID", genPlugin.getID());
	}
	
	public void testGenPlugin_name() {
		GenEditorGenerator genEditorGenerator = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		GenPlugin genPlugin = GMFGenFactory.eINSTANCE.createGenPlugin();
		genEditorGenerator.setPlugin(genPlugin);
		genPlugin.setName(null);
		assertNotNull(genPlugin.getName());
		assertTrue(genPlugin.getName().length() > 0);
		
		genPlugin.setName("plugin name");
		assertEquals("plugin name", genPlugin.getName());
	}
	
	public void testGenDiagram_EditingDomainID() {
		GenDiagram genDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		GenEditorGenerator editorGen = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		editorGen.setDiagram(genDiagram);
		editorGen.setPlugin(GMFGenFactory.eINSTANCE.createGenPlugin());
		genDiagram.setEditingDomainID(null);		
		assertNotNull(genDiagram.getEditingDomainID());
		assertTrue(genDiagram.getEditingDomainID().length() > 0);
		
		genDiagram.setEditingDomainID("");		
		assertNotNull(genDiagram.getEditingDomainID());
		assertTrue(genDiagram.getEditingDomainID().length() > 0);

		genDiagram.setEditingDomainID("editingDomainid");
		assertEquals("editingDomainid", genDiagram.getEditingDomainID());
	}
	
	public void testGenDiagram_generateCreateShortcutAction() {
		GenDiagram genDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		genDiagram.getContainsShortcutsTo().clear();
		assertFalse(genDiagram.generateCreateShortcutAction());
		
		genDiagram.getContainsShortcutsTo().add("ecore");
		assertTrue(genDiagram.generateCreateShortcutAction());
	}
	
	public void testGenDiagram_generateShortcutIcon() {
		GenDiagram genDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		genDiagram.getShortcutsProvidedFor().clear();
		assertFalse(genDiagram.generateShortcutIcon());
		
		genDiagram.getShortcutsProvidedFor().add("Ecore");
		assertTrue(genDiagram.generateShortcutIcon());
	}
	
	public void testGenDiagram_generateInitDiagramAction() {
		GenDiagram genDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		assertFalse(genDiagram.generateInitDiagramAction());
		
		genDiagram.setDomainDiagramElement(GenModelFactory.eINSTANCE.createGenClass());
		assertTrue(genDiagram.generateInitDiagramAction());
	}
	
	public void testGenDiagram_hasLinkCreationConstraints() {
		GenDiagram genDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		GenLink link = GMFGenFactory.eINSTANCE.createGenLink();
		genDiagram.getLinks().add(link);
		assertFalse(genDiagram.hasLinkCreationConstraints());
		
		link = GMFGenFactory.eINSTANCE.createGenLink();
		genDiagram.getLinks().add(link);
		link.setCreationConstraints(GMFGenFactory.eINSTANCE.createGenLinkConstraints());
		assertTrue(genDiagram.hasLinkCreationConstraints());
	}
	
	public void testGenCommonBase_getAllNodes() {
		GenDiagram genDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		GenTopLevelNode topLevelNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		genDiagram.getTopLevelNodes().add(topLevelNode);
		GenChildNode childNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		genDiagram.getChildNodes().add(childNode);
		GenCompartment genCompartment = GMFGenFactory.eINSTANCE.createGenCompartment();
		genDiagram.getCompartments().add(genCompartment);
		
		Collection nodes = genDiagram.getAllNodes();
		assertTrue(nodes.contains(topLevelNode));
		assertTrue(nodes.contains(childNode));
		assertFalse(nodes.contains(genCompartment));
		assertFalse(nodes.contains(genDiagram));
	}
	
	public void testGenCommonBase_getAllChildContainers() {
		GenDiagram genDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		GenTopLevelNode topLevelNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		genDiagram.getTopLevelNodes().add(topLevelNode);
		GenChildNode childNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		genDiagram.getChildNodes().add(childNode);
		GenCompartment genCompartment = GMFGenFactory.eINSTANCE.createGenCompartment();
		genDiagram.getCompartments().add(genCompartment);
		
		Collection nodes = genDiagram.getAllChildContainers();
		assertTrue(nodes.contains(topLevelNode));
		assertTrue(nodes.contains(childNode));
		assertTrue(nodes.contains(genCompartment));
		assertFalse(nodes.contains(genDiagram));
	}
	
	public void testGenCommonBase_getAllContainers() {
		GenDiagram genDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		GenTopLevelNode topLevelNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		genDiagram.getTopLevelNodes().add(topLevelNode);
		GenChildNode childNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		genDiagram.getChildNodes().add(childNode);
		GenCompartment genCompartment = GMFGenFactory.eINSTANCE.createGenCompartment();
		genDiagram.getCompartments().add(genCompartment);
		
		Collection nodes = genDiagram.getAllContainers();
		assertTrue(nodes.contains(topLevelNode));
		assertTrue(nodes.contains(childNode));
		assertTrue(nodes.contains(genCompartment));
		assertTrue(nodes.contains(genDiagram));
	}
	
	public void testGenCommonBase_ClassNameSuffux() {
		assertClassNameSuffix(GMFGenFactory.eINSTANCE.createGenDiagram());
		assertClassNameSuffix(GMFGenFactory.eINSTANCE.createGenChildNode());
		assertClassNameSuffix(GMFGenFactory.eINSTANCE.createGenChildLabelNode());
		assertClassNameSuffix(GMFGenFactory.eINSTANCE.createGenTopLevelNode());
		assertClassNameSuffix(GMFGenFactory.eINSTANCE.createGenCompartment());
		assertClassNameSuffix(GMFGenFactory.eINSTANCE.createGenLinkLabel());
		assertClassNameSuffix(GMFGenFactory.eINSTANCE.createGenNodeLabel());
		assertClassNameSuffix(GMFGenFactory.eINSTANCE.createGenExternalNodeLabel());
		assertClassNameSuffix(GMFGenFactory.eINSTANCE.createGenLink());
	}
	
	private void assertClassNameSuffix(GenCommonBase commonBase) {
		assertNotNull(commonBase.getClassNameSuffux());
		assertTrue(commonBase.getClassNameSuffux().length() == 0);
	}

	public void testGenCommonBase_ClassNamePrefix() {
		GenClass domainElement = GenModelFactory.eINSTANCE.createGenClass();
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("DomainModelClassName" + INVALID_JAVA_CHARS);
		domainElement.setEcoreClass(eClass);
		TypeModelFacet typeModelFacet = GMFGenFactory.eINSTANCE.createTypeModelFacet();
		typeModelFacet.setMetaClass(domainElement);
		TypeLinkModelFacet typeLinkModelFacet = GMFGenFactory.eINSTANCE.createTypeLinkModelFacet();
		typeLinkModelFacet.setMetaClass(domainElement);
		EReference reference = EcoreFactory.eINSTANCE.createEReference();
		reference.setName("Reference" + INVALID_JAVA_CHARS);
		eClass.getEStructuralFeatures().add(reference);
		GenFeature genFeature = GenModelFactory.eINSTANCE.createGenFeature();
		genFeature.setEcoreFeature(reference);
		domainElement.getGenFeatures().add(genFeature);
		FeatureLinkModelFacet featureLinkModelFacet = GMFGenFactory.eINSTANCE.createFeatureLinkModelFacet();
		featureLinkModelFacet.setMetaFeature(genFeature);
		
		GenDiagram diagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		assertClassNamePrefix(diagram);
		
		diagram.setDomainDiagramElement(domainElement);
		assertClassNamePrefix(diagram);
		
		GenChildNode genChildNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		assertClassNamePrefix(genChildNode);
		
		genChildNode.setModelFacet(typeModelFacet);
		assertClassNamePrefix(genChildNode);
		
		GenChildLabelNode genChildLabelNode = GMFGenFactory.eINSTANCE.createGenChildLabelNode();
		assertClassNamePrefix(genChildLabelNode);
		
		genChildLabelNode.setModelFacet(typeModelFacet);
		assertClassNamePrefix(genChildLabelNode);
		
		GenTopLevelNode genTopLevelNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		assertClassNamePrefix(genTopLevelNode);
		
		genTopLevelNode.setModelFacet(typeModelFacet);
		assertClassNamePrefix(genTopLevelNode);

		GenCompartment compartment = GMFGenFactory.eINSTANCE.createGenCompartment();
		genTopLevelNode.getCompartments().add(compartment);
		assertClassNamePrefix(compartment);
		
		compartment.setTitle("Title:" + INVALID_JAVA_CHARS);
		assertClassNamePrefix(compartment);
		
		GenLink genLink = GMFGenFactory.eINSTANCE.createGenLink();
		assertClassNamePrefix(genLink);
		
		genLink.setModelFacet(typeLinkModelFacet);
		assertClassNamePrefix(genLink);
		
		genLink.setModelFacet(featureLinkModelFacet);
		assertClassNamePrefix(genLink);
		
		GenLinkLabel genLinkLabel = GMFGenFactory.eINSTANCE.createGenLinkLabel();
		genLink.getLabels().add(genLinkLabel);
		assertClassNamePrefix(genLinkLabel);
		
		genLinkLabel.getMetaFeatures().add(genFeature);
		assertClassNamePrefix(genLinkLabel);
		
		GenNodeLabel genNodeLabel = GMFGenFactory.eINSTANCE.createGenNodeLabel();
		genTopLevelNode.getLabels().add(genNodeLabel);
		assertClassNamePrefix(genNodeLabel);

		genNodeLabel.getMetaFeatures().add(genFeature);
		assertClassNamePrefix(genNodeLabel);

		GenExternalNodeLabel genExternalNodeLabel = GMFGenFactory.eINSTANCE.createGenExternalNodeLabel();
		genTopLevelNode.getLabels().add(genExternalNodeLabel);
		assertClassNamePrefix(genExternalNodeLabel);

		genExternalNodeLabel.getMetaFeatures().add(genFeature);
		assertClassNamePrefix(genExternalNodeLabel);
	}
	
	private void assertClassNamePrefix(GenCommonBase commonBase) {
		assertNotNull(commonBase.getClassNamePrefix());
		assertTrue(commonBase.getClassNamePrefix().length() > 0);
		IStatus s = JavaConventions.validateJavaTypeName(commonBase.getClassNamePrefix());
		assertTrue("Default prefix: " + s.getMessage(), s.getSeverity() != IStatus.ERROR);		
	}

	public void testPackageNames() {
		GenDiagram genDiagram = myGenModel;
		Set state = new HashSet();

		// package names check
		checkPackageName(state, "PackageNames:editCommands", genDiagram.getEditCommandsPackageName());
		checkPackageName(state, "PackageNames:editHelpers", genDiagram.getEditHelpersPackageName());
		checkPackageName(state, "PackageNames:editParts", genDiagram.getEditPartsPackageName());
		checkPackageName(state, "PackageNames:editPolicies", genDiagram.getEditPoliciesPackageName());
		checkPackageName(state, "GenEditorView:packageName", genDiagram.getEditorGen().getEditor().getPackageName());
		checkPackageName(state, "PackageNames:providers", genDiagram.getProvidersPackageName());
		checkPackageName(state, "PackageNames:notationViewFactories", genDiagram.getNotationViewFactoriesPackageName());

		if(genDiagram.getEditorGen().getExpressionProviders() != null) {
			GenExpressionProviderContainer providers =genDiagram.getEditorGen().getExpressionProviders();
			checkPackageName(state, "GenExpressionProviderContainer:expressions", providers.getExpressionsPackageName());
		} else {
			state.add("GenExpressionProviderContainer:expressions");			
		}

		// coverage check
		for (Iterator classifiers = GMFGenPackage.eINSTANCE.getEClassifiers().iterator(); classifiers.hasNext();) {
			Object next = classifiers.next();
			if (next instanceof EClass) {
				checkPackageNamesCoverage(state, (EClass) next);
			}
		}
	}

	public void testClassNames() {
		GenDiagram genDiagram = myGenModel;
		Set state = new HashSet();
		GenEditorView  genEditor = myGenModel.getEditorGen().getEditor();

		// class names check
		checkClassName(state, "EditPartCandies:ReorientConnectionViewCommand", genDiagram.getReorientConnectionViewCommandClassName(), genDiagram.getReorientConnectionViewCommandQualifiedClassName());
		checkClassName(state, "EditPartCandies:BaseEditHelper", genDiagram.getBaseEditHelperClassName(), genDiagram.getBaseEditHelperQualifiedClassName());
		checkClassName(state, "EditPartCandies:EditPartFactory", genDiagram.getEditPartFactoryClassName(), genDiagram.getEditPartFactoryQualifiedClassName());
		checkClassName(state, "EditPartCandies:BaseExternalNodeLabelEditPart", genDiagram.getBaseExternalNodeLabelEditPartClassName(), genDiagram.getBaseExternalNodeLabelEditPartQualifiedClassName());
		checkClassName(state, "EditPartCandies:BaseItemSemanticEditPolicy", genDiagram.getBaseItemSemanticEditPolicyClassName(), genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName());
		checkClassName(state, "EditPartCandies:BaseGraphicalNodeEditPolicy", genDiagram.getBaseGraphicalNodeEditPolicyClassName(), genDiagram.getBaseGraphicalNodeEditPolicyQualifiedClassName());
		checkClassName(state, "EditPartCandies:ReferenceConnectionEditPolicy", genDiagram.getReferenceConnectionEditPolicyClassName(), genDiagram.getReferenceConnectionEditPolicyQualifiedClassName());
		checkClassName(state, "EditPartCandies:CanonicalEditPolicy", genDiagram.getCanonicalEditPolicyClassName(), genDiagram.getCanonicalEditPolicyQualifiedClassName());
		checkClassName(state, "EditPartCandies:TextSelectionEditPolicy", genDiagram.getTextSelectionEditPolicyClassName(), genDiagram.getTextSelectionEditPolicyQualifiedClassName());
		checkClassName(state, "EditPartCandies:TextNonResizableEditPolicy", genDiagram.getTextNonResizableEditPolicyClassName(), genDiagram.getTextNonResizableEditPolicyQualifiedClassName());
		checkClassName(state, "EditPartCandies:ExternalNodeLabelHostLayoutEditPolicy", genDiagram.getExternalNodeLabelHostLayoutEditPolicyClassName(), genDiagram.getExternalNodeLabelHostLayoutEditPolicyQualifiedClassName());
		checkClassName(state, "ProviderClassNames:ElementTypes", genDiagram.getElementTypesClassName(), genDiagram.getElementTypesQualifiedClassName());
		checkClassName(state, "ProviderClassNames:NotationViewProvider", genDiagram.getNotationViewProviderClassName(), genDiagram.getNotationViewProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:EditPartProvider", genDiagram.getEditPartProviderClassName(), genDiagram.getEditPartProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:PaletteProvider", genDiagram.getPaletteProviderClassName(), genDiagram.getPaletteProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:ModelingAssistantProvider", genDiagram.getModelingAssistantProviderClassName(), genDiagram.getModelingAssistantProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:PropertyProvider", genDiagram.getPropertyProviderClassName(), genDiagram.getPropertyProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:IconProvider", genDiagram.getIconProviderClassName(), genDiagram.getIconProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:ParserProvider", genDiagram.getParserProviderClassName(), genDiagram.getParserProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:AbstractParser", genDiagram.getAbstractParserClassName(), genDiagram.getAbstractParserQualifiedClassName());
		checkClassName(state, "ProviderClassNames:StructuralFeatureParser", genDiagram.getStructuralFeatureParserClassName(), genDiagram.getStructuralFeatureParserQualifiedClassName());
		checkClassName(state, "ProviderClassNames:StructuralFeaturesParser", genDiagram.getStructuralFeaturesParserClassName(), genDiagram.getStructuralFeaturesParserQualifiedClassName());
		checkClassName(state, "ProviderClassNames:ContributionItemProvider", genDiagram.getContributionItemProviderClassName(), genDiagram.getContributionItemProviderQualifiedClassName());
		checkClassName(state, "GenEditorView:ActionBarContributor", genEditor.getActionBarContributorClassName(), genEditor.getActionBarContributorQualifiedClassName());
		checkClassName(state, "EditorCandies:CreationWizard", genDiagram.getCreationWizardClassName(), genDiagram.getCreationWizardQualifiedClassName());
		checkClassName(state, "EditorCandies:CreationWizardPage", genDiagram.getCreationWizardPageClassName(), genDiagram.getCreationWizardPageQualifiedClassName());
		checkClassName(state, "EditorCandies:DiagramEditorUtil", genDiagram.getDiagramEditorUtilClassName(), genDiagram.getDiagramEditorUtilQualifiedClassName());
		checkClassName(state, "EditorCandies:DiagramFileCreator", genDiagram.getDiagramFileCreatorClassName(), genDiagram.getDiagramFileCreatorQualifiedClassName());
		checkClassName(state, "EditorCandies:DocumentProvider", genDiagram.getDocumentProviderClassName(), genDiagram.getDocumentProviderQualifiedClassName());
		checkClassName(state, "GenEditorView:className", genEditor.getClassName(), genEditor.getQualifiedClassName());
		checkClassName(state, "EditorCandies:InitDiagramFileAction", genDiagram.getInitDiagramFileActionClassName(), genDiagram.getInitDiagramFileActionQualifiedClassName());
		checkClassName(state, "EditorCandies:NewDiagramFileWizard", genDiagram.getNewDiagramFileWizardClassName(), genDiagram.getNewDiagramFileWizardQualifiedClassName());
		checkClassName(state, "EditorCandies:MatchingStrategy", genDiagram.getMatchingStrategyClassName(), genDiagram.getMatchingStrategyQualifiedClassName());
		checkClassName(state, "EditorCandies:PreferenceInitializer", genDiagram.getPreferenceInitializerClassName(), genDiagram.getPreferenceInitializerQualifiedClassName());
		checkClassName(state, "EditorCandies:VisualIDRegistry", genDiagram.getVisualIDRegistryClassName(), genDiagram.getVisualIDRegistryQualifiedClassName());
		checkClassName(state, "EditorCandies:LoadResourceAction", genDiagram.getLoadResourceActionClassName(), genDiagram.getLoadResourceActionQualifiedClassName());
		checkClassName(state, "LinkConstraints:LinkCreationConstraints", genDiagram.getLinkCreationConstraintsClassName(), genDiagram.getLinkCreationConstraintsQualifiedClassName());
		checkClassName(state, "Shortcuts:CreateShortcutAction", genDiagram.getCreateShortcutActionClassName(), genDiagram.getCreateShortcutActionQualifiedClassName());
		checkClassName(state, "Shortcuts:ShortcutsDecoratorProvider", genDiagram.getShortcutsDecoratorProviderClassName(), genDiagram.getShortcutsDecoratorProviderQualifiedClassName());
		checkClassName(state, "EditorCandies:ElementChooser", genDiagram.getElementChooserClassName(), genDiagram.getElementChooserQualifiedClassName());
		checkClassName(state, "BatchValidation:ValidationProvider", genDiagram.getValidationProviderClassName(), genDiagram.getValidationProviderQualifiedClassName());
		checkClassName(state, "BatchValidation:ValidationDecoratorProvider", genDiagram.getValidationDecoratorProviderClassName(), genDiagram.getValidationDecoratorProviderQualifedClassName());		
		checkClassName(state, "BatchValidation:MarkerNavigationProvider", genDiagram.getMarkerNavigationProviderClassName(), genDiagram.getMarkerNavigationProviderQualifiedClassName());
		checkClassName(state, "BatchValidation:MetricProvider", genDiagram.getMetricProviderClassName(), genDiagram.getMetricProviderQualifiedClassName());

		if(genDiagram.getEditorGen().getExpressionProviders() != null) {
			GenExpressionProviderContainer providers =genDiagram.getEditorGen().getExpressionProviders();
			checkClassName(state, "GenExpressionProviderContainer:AbstractExpression", providers.getAbstractExpressionClassName(), providers.getAbstractExpressionQualifiedClassName());
		} else {
			state.add("GenExpressionProviderContainer:AbstractExpression");			
		}

		Palette palette = genDiagram.getPalette();
		if (palette != null) {
			checkClassName(state, "Palette:Factory", palette.getFactoryClassName(), palette.getFactoryQualifiedClassName());
		} else {
			state.add("Palette:Factory");
		}
		GenPlugin genPlugin = genDiagram.getEditorGen().getPlugin();
		checkClassName(state, "GenPlugin:Activator", genPlugin.getActivatorClassName(), genPlugin.getActivatorQualifiedClassName());

		for (GenCommonBaseIterator entities = new GenCommonBaseIterator(genDiagram); entities.hasNext();) {
			GenCommonBase nextEntity = entities.nextElement();
			checkClassName(state, "GenCommonBase:EditPart", nextEntity.getEditPartClassName(), nextEntity.getEditPartQualifiedClassName());
			checkClassName(state, "GenCommonBase:ItemSemanticEditPolicy", nextEntity.getItemSemanticEditPolicyClassName(), nextEntity.getItemSemanticEditPolicyQualifiedClassName());
			checkClassName(state, "GenCommonBase:NotationViewFactory", nextEntity.getNotationViewFactoryClassName(), nextEntity.getNotationViewFactoryQualifiedClassName());
			checkEditSupport(state, nextEntity);
			if (nextEntity instanceof GenChildContainer) {
				GenChildContainer genContainer = (GenChildContainer) nextEntity;
				checkClassName(state, "GenChildContainer:CanonicalEditPolicy", genContainer.getCanonicalEditPolicyClassName(), genContainer.getCanonicalEditPolicyQualifiedClassName());
			}
			if (nextEntity instanceof GenNode) {
				GenNode genNode = (GenNode) nextEntity;
				checkClassName(state, "GenNode:GraphicalNodeEditPolicy", genNode.getGraphicalNodeEditPolicyClassName(), genNode.getGraphicalNodeEditPolicyQualifiedClassName());
			}
		}

		GenAuditContainer audits = genDiagram.getEditorGen().getAudits();
		if(audits != null && !audits.getAllAuditRules().isEmpty()) {
			Set checkedContexts = new HashSet();			
			for (Iterator it = audits.getAllAuditRules().iterator(); it.hasNext();) {
				GenAuditRule nextAudit = (GenAuditRule) it.next();
				if(!checkedContexts.contains(nextAudit.getContextSelectorQualifiedClassName())) {
					checkClassName(state, "GenAuditRule:ContextSelector", nextAudit.getContextSelectorClassName(), nextAudit.getContextSelectorQualifiedClassName());
					checkedContexts.add(nextAudit.getContextSelectorQualifiedClassName());					
				}
				checkClassName(state, "GenAuditRule:ConstraintAdapter", nextAudit.getConstraintAdapterClassName(), nextAudit.getConstraintAdapterQualifiedClassName());				
			}
		} else {
			state.add("GenAuditRule:ContextSelector");
		}
		
		// test model may not contain them
		state.add("GenCommonBase:EditPart");
		state.add("GenCommonBase:ItemSemanticEditPolicy");
		state.add("GenCommonBase:NotationViewFactory");
		state.add("GenContainer:CanonicalEditPolicy");
		state.add("GenNode:GraphicalNodeEditPolicy");
		state.add("MetamodelType:EditHelper");
		state.add("SpecializationType:EditHelperAdvice");
		// disable explicitly
		state.add("ElementType:EditHelper");
		state.add("FigureViewmap:Figure");
		state.add("ExternalLabel:TextEditPart");
		state.add("ExternalLabel:TextNotationViewFactory");

		// coverage check
		for (Iterator classifiers = GMFGenPackage.eINSTANCE.getEClassifiers().iterator(); classifiers.hasNext();) {
			Object next = classifiers.next();
			if (next instanceof EClass) {
				checkClassNamesCoverage(state, (EClass) next);
			}
		}
	}

	protected void checkEditSupport(Set state, GenCommonBase diagramElement) {
		ElementType genType = diagramElement.getElementType();
		if (genType instanceof MetamodelType) {
			MetamodelType metamodelType = (MetamodelType) genType;
			checkClassName(state, "MetamodelType:EditHelper", metamodelType.getEditHelperClassName(), metamodelType.getEditHelperQualifiedClassName());
		} else if (genType instanceof SpecializationType) {
			SpecializationType specializationType = (SpecializationType) genType;
			checkClassName(state, "SpecializationType:EditHelperAdvice", specializationType.getEditHelperAdviceClassName(), specializationType.getEditHelperAdviceQualifiedClassName());
		}
	}

	protected void checkPackageName(Set state, String id, String packageName) {
		IStatus s = JavaConventions.validatePackageName(packageName);
		assertTrue(id + " package name is not valid : " + s.getMessage(), s.getSeverity() != IStatus.ERROR);
		state.add(packageName); // for unique package name check
		state.add(id); // for coverage check
	}

	protected void checkClassName(Set state, String id, String simpleClassName, String qualifiedClassName) {
		IStatus s = JavaConventions.validateJavaTypeName(simpleClassName);
		assertTrue(id + " simple class name is not valid : " + s.getMessage(), s.getSeverity() != IStatus.ERROR);
		s = JavaConventions.validateJavaTypeName(qualifiedClassName);
		assertTrue(id + " qualified class name is not valid : " + s.getMessage(), s.getSeverity() != IStatus.ERROR);
		assertTrue(id + " simple class name does not match the qualified one : '" + simpleClassName + "', '" + qualifiedClassName + "'", qualifiedClassName.endsWith('.' + simpleClassName));
		assertFalse(qualifiedClassName + " is not unique", state.contains(qualifiedClassName));
		state.add(qualifiedClassName); // for unique class name check
		state.add(id); // for coverage check
	}

	protected void checkPackageNamesCoverage(Set state, EClass eClass) {
		final String PN = "PackageName";
		for (Iterator attributes = eClass.getEAttributes().iterator(); attributes.hasNext();) {
			EAttribute attribute = (EAttribute) attributes.next();
			if (attribute.getName().endsWith(PN) && attribute.getName().length() > PN.length()) {
				String packageName = attribute.getName();
				packageName = packageName.substring(0, packageName.length() - PN.length());
				String id = eClass.getName() + ':' + packageName;
				//System.err.println("check " + id);
				assertTrue(id + " package name is not checked", state.contains(id));
			}
		}
	}

	protected void checkClassNamesCoverage(Set state, EClass eClass) {
		final String CN = "ClassName";
		final String QCN = "QualifiedClassName";
		final String GET = "get";
		for (Iterator attributes = eClass.getEAttributes().iterator(); attributes.hasNext();) {
			EAttribute attribute = (EAttribute) attributes.next();
			if (attribute.getName().endsWith(QCN) && attribute.getName().length() > QCN.length()) {
				// TODO : attribute with fqn; ignore for now
			} else if (attribute.getName().endsWith(CN) && attribute.getName().length() > CN.length()) {
				String className = attribute.getName();
				className = className.substring(0, className.length() - CN.length());
				className = Character.toUpperCase(className.charAt(0)) + className.substring(1);
				String id = eClass.getName() + ':' + className;
				//System.err.println("check simple " + id);
				assertTrue(id + " simple class name is not checked", state.contains(id));
			}
		}
		for (Iterator operations = eClass.getEOperations().iterator(); operations.hasNext();) {
			EOperation operation = (EOperation) operations.next();
			if (operation.getName().startsWith(GET) && operation.getName().endsWith(QCN)
					&& operation.getName().length() > GET.length() + QCN.length()) {
				String className = operation.getName();
				className = className.substring(GET.length(), className.length() - QCN.length());
				String id = eClass.getName() + ':' + className;
				//System.err.println("check qualified " + id);
				assertTrue(id + " qualified class name is not checked", state.contains(id));
			}
		}
	}

	private static class GenCommonBaseIterator implements Iterator {
		private GenCommonBase nextBase;
		private Iterator wrappedIterator;

		public GenCommonBaseIterator(GenDiagram genDiagram) {
			assert genDiagram != null;
			nextBase = genDiagram;
			wrappedIterator = genDiagram.eAllContents();
		}
		public boolean hasNext() {
			return nextBase != null;
		}
		public GenCommonBase nextElement() {
			if (nextBase == null) {
				throw new NoSuchElementException();
			}
			GenCommonBase rv = nextBase;
			advance();
			return rv;
		}
		public Object next() {
			return nextElement();
		}
		private void advance() {
			nextBase = null;
			while (wrappedIterator.hasNext()) {
				Object next = wrappedIterator.next();
				if (next instanceof GenCommonBase) {
					nextBase = (GenCommonBase) next;
					break;
				}
			}
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
