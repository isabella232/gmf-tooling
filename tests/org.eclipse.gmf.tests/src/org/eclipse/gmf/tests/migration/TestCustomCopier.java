/*
 * Copyright (c) 2008, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anna Karjakina (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.migration;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.internal.codegen.util.Migrate2008;
import org.eclipse.gmf.internal.codegen.util.ModelVersions;
import org.eclipse.gmf.internal.common.ToolingResourceFactory;

public class TestCustomCopier extends TestCase {

	private EPackage gmfgen_2008;
	private EClass cGenEditorGenerator;
	private EClass cGenDiagram;
	private EClass cGenAuditRule;
	private EClass cGenExpressionInterpreter;
	private EClass cGenJavaExpressionProvider;
	private EClass cValueExpression;
	private EClass cGenMetricRule;
	private EEnum eGenLanguage;
	private EClass cGenLink;
	private EClass cGenChildNode;
	private EClass cGenLinkConstraints;
	private EClass cTypeModelFacet;
	private EClass cGenFeatureSeqInitializer;
	private EClass cGenFeatureValueSpec;

	public TestCustomCopier(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		gmfgen_2008 = EPackage.Registry.INSTANCE.getEPackage(ModelVersions.GMFGEN_2_1);
		cGenEditorGenerator = (EClass) gmfgen_2008.getEClassifier("GenEditorGenerator");
		cGenDiagram = (EClass) gmfgen_2008.getEClassifier("GenDiagram");
		cGenAuditRule = (EClass) gmfgen_2008.getEClassifier("GenAuditRule");
		cGenExpressionInterpreter = (EClass) gmfgen_2008.getEClassifier("GenExpressionInterpreter");
		cGenJavaExpressionProvider = (EClass) gmfgen_2008.getEClassifier("GenJavaExpressionProvider");
		cValueExpression = (EClass) gmfgen_2008.getEClassifier("ValueExpression");
		cGenMetricRule = (EClass) gmfgen_2008.getEClassifier("GenMetricRule");
		eGenLanguage = (EEnum) gmfgen_2008.getEClassifier("GenLanguage");
		cGenLink = (EClass) gmfgen_2008.getEClassifier("GenLink");
		cGenChildNode = (EClass) gmfgen_2008.getEClassifier("GenChildNode");
		cGenLinkConstraints = (EClass) gmfgen_2008.getEClassifier("GenLinkConstraints");
		cTypeModelFacet = (EClass) gmfgen_2008.getEClassifier("TypeModelFacet");
		cGenFeatureSeqInitializer = (EClass) gmfgen_2008.getEClassifier("GenFeatureSeqInitializer");
		cGenFeatureValueSpec = (EClass) gmfgen_2008.getEClassifier("GenFeatureValueSpec");
	}

	public void test06to08ModelTransform() throws Exception {
		//EObject testRoot = createTestModel();
		final URI uri = MigrationPatchesTest.createURI("228913-copier.gmfgen#/");
		Resource r = new ToolingResourceFactory().createResource(uri.trimFragment());
		ResourceSet rset = new ResourceSetImpl();
		rset.getResources().add(r);
		EObject testRoot = rset.getEObject(uri, true);
		final Migrate2008 m = new Migrate2008();
		EObject newGenModel = m.go(testRoot);
		assertTrue(m.wasMigrationApplied());
		checkTestModel(newGenModel);
	}
	
	private void checkTestModel(EObject editorGen) throws Exception {
		EPackage p = editorGen.eClass().getEPackage();
		assertEquals(gmfgen_2008.getNsURI(), p.getNsURI());
		
		assertEquals(cGenEditorGenerator, editorGen.eClass());

		final EStructuralFeature aGenExpressionInterpreter_Language = cGenExpressionInterpreter.getEStructuralFeature("language");
		final EStructuralFeature aValueExpression_Body = cValueExpression.getEStructuralFeature("body");
		final EStructuralFeature rValueExpression_Provider = cValueExpression.getEStructuralFeature("provider");

		EObject auditRoot = (EObject) editorGen.eGet(editorGen.eClass().getEStructuralFeature("audits"));
		assertNotNull(auditRoot);
		@SuppressWarnings("unchecked")
		List<EObject> auditRules = (List<EObject>) auditRoot.eGet(auditRoot.eClass().getEStructuralFeature("rules"));
		assertEquals(1, auditRules.size());
		EObject aud1 = auditRules.get(0);
		EObject aud1VE = (EObject) aud1.eGet(cGenAuditRule.getEStructuralFeature("rule"));
		assertNotNull(aud1VE);
		assertEquals("audit1", aud1VE.eGet(aValueExpression_Body));
		EObject aud1VEprov = (EObject) aud1VE.eGet(rValueExpression_Provider);
		assertNotNull(aud1VEprov);
		assertEquals(eGenLanguage.getEEnumLiteral("ocl"), aud1VEprov.eGet(aGenExpressionInterpreter_Language)); // can't invoke ExprProviderBase#getLanguage() method
		
		EObject metricsContainer = (EObject) editorGen.eGet(cGenEditorGenerator.getEStructuralFeature("metrics"));
		assertNotNull(metricsContainer);
		@SuppressWarnings("unchecked")
		List<EObject> metricsRules = (List<EObject>) metricsContainer.eGet(metricsContainer.eClass().getEStructuralFeature("metrics"));
		assertEquals(1, metricsRules.size());
		EObject met1VE = (EObject) metricsRules.get(0).eGet(cGenMetricRule.getEStructuralFeature("rule"));
		assertNotNull(met1VE);
		assertEquals("audit1", met1VE.eGet(aValueExpression_Body));
		EObject met1VEprov = (EObject) met1VE.eGet(rValueExpression_Provider);
		assertNotNull(met1VEprov);
		assertEquals(eGenLanguage.getEEnumLiteral("ocl"), met1VEprov.eGet(aGenExpressionInterpreter_Language)); // can't invoke ExprProviderBase#getLanguage() method
		
		assertEquals(aud1VEprov, met1VEprov);
		assertTrue(aud1VEprov == met1VEprov);
		assertEquals(met1VE, aud1VE); // copy
		assertTrue(met1VE == aud1VE);

		EObject diagram = (EObject) editorGen.eGet(cGenEditorGenerator.getEStructuralFeature("diagram"));
		assertNotNull(diagram);
		
		@SuppressWarnings("unchecked")
		List<EObject> links = (List<EObject>) diagram.eGet(cGenDiagram.getEStructuralFeature("links"));
		assertEquals(2, links.size());
		EObject link1 = links.get(0);
		assertNotNull(link1);
		EObject csts1 = (EObject) link1.eGet(cGenLink.getEStructuralFeature("creationConstraints"));
		assertNotNull(csts1);
		assertNull(csts1.eGet(cGenLinkConstraints.getEStructuralFeature("targetEnd")));
		EObject src1 = (EObject) csts1.eGet(cGenLinkConstraints.getEStructuralFeature("sourceEnd"));
		assertNotNull(src1);
		assertEquals("source_link1", src1.eGet(aValueExpression_Body));
		EObject src1prov = (EObject) src1.eGet(rValueExpression_Provider);
		assertNotNull(src1prov);
		assertEquals(eGenLanguage.getEEnumLiteral("nregexp"), src1prov.eGet(aGenExpressionInterpreter_Language));
		
		EObject link2 = links.get(1);
		EObject csts2 = (EObject) link2.eGet(cGenLink.getEStructuralFeature("creationConstraints"));
		assertNotNull(csts2);
		assertNull(csts2.eGet(cGenLinkConstraints.getEStructuralFeature("sourceEnd")));
		EObject trg2 = (EObject) csts2.eGet(cGenLinkConstraints.getEStructuralFeature("targetEnd"));
		assertNotNull(trg2);
		assertEquals("target_link2", trg2.eGet(aValueExpression_Body));
		EObject trg2prov = (EObject) trg2.eGet(rValueExpression_Provider);
		assertNotNull(trg2prov);
		//assertEquals(eGenLanguage.getEEnumLiteral("java"), trg2prov.getLanguage());
		assertEquals(cGenJavaExpressionProvider, trg2prov.eClass()); // can't invoke op getLanguage(), at least check eClass
		
		@SuppressWarnings("unchecked")
		List<EObject> nodes = (List<EObject>) diagram.eGet(cGenDiagram.getEStructuralFeature("childNodes"));
		assertEquals(2, nodes.size());
		EObject node1 = nodes.get(0);
		assertNotNull(node1);
		EObject fac1 = (EObject) node1.eGet(cGenChildNode.getEStructuralFeature("modelFacet"));
		assertNotNull(fac1);
		EObject node1cstr = (EObject) fac1.eGet(cTypeModelFacet.getEStructuralFeature("modelElementSelector"));
		assertNotNull(node1cstr);
		assertEquals("node1", node1cstr.eGet(aValueExpression_Body));
		EObject node1cstrProv = (EObject) node1cstr.eGet(rValueExpression_Provider);
		assertNotNull(node1cstrProv);
		assertEquals(eGenLanguage.getEEnumLiteral("ocl"), node1cstrProv.eGet(aGenExpressionInterpreter_Language));
		
		assertEquals(aud1VEprov, node1cstrProv);
		
		EObject node2 = nodes.get(1);
		assertNotNull(node2);
		EObject fac2 = (EObject) node2.eGet(cGenChildNode.getEStructuralFeature("modelFacet"));
		assertNotNull(fac2);
		EObject ir2 = (EObject) fac2.eGet(cTypeModelFacet.getEStructuralFeature("modelElementInitializer"));
		assertEquals(cGenFeatureSeqInitializer, ir2.eClass());
		@SuppressWarnings("unchecked")
		List<EObject> featureInitializers = (List<EObject>) ir2.eGet(cGenFeatureSeqInitializer.getEStructuralFeature("initializers"));
		assertEquals(1, featureInitializers.size());
		EObject fvs1 = featureInitializers.get(0);
		assertEquals(cGenFeatureValueSpec, fvs1.eClass());
		EObject node2ve = (EObject) fvs1.eGet(cGenFeatureValueSpec.getEStructuralFeature("value"));
		assertNotNull(node2ve);
		assertEquals("node2", node2ve.eGet(aValueExpression_Body));
		EObject node2veProv = (EObject) node2ve.eGet(rValueExpression_Provider);
		assertNotNull(node2veProv);
		assertEquals(eGenLanguage.getEEnumLiteral("regexp"), node2veProv.eGet(aGenExpressionInterpreter_Language));
		
		EObject exprProviderContainer = (EObject) editorGen.eGet(cGenEditorGenerator.getEStructuralFeature("expressionProviders")); 
		assertNotNull(exprProviderContainer);
		@SuppressWarnings("unchecked")
		List<EObject> providers = (List<EObject>) exprProviderContainer.eGet(exprProviderContainer.eClass().getEStructuralFeature("providers"));
		assertEquals(4, providers.size());
		assertEquals(cGenExpressionInterpreter, providers.get(0).eClass());
		assertEquals(cGenExpressionInterpreter, providers.get(1).eClass());
		assertEquals(cGenExpressionInterpreter, providers.get(2).eClass());
		assertEquals(cGenJavaExpressionProvider, providers.get(3).eClass());

		// feature comes from superclass, may ask either from ExprInterp or JavaExprProv
		EStructuralFeature rGenExpressionProviderBase_Expressions = cGenExpressionInterpreter.getEStructuralFeature("expressions");
		EObject pr1 = providers.get(0);
		assertEquals(eGenLanguage.getEEnumLiteral("ocl"), pr1.eGet(aGenExpressionInterpreter_Language));
		assertEquals(2, ((List<?>) pr1.eGet(rGenExpressionProviderBase_Expressions)).size());
		
		EObject pr2 = providers.get(1);
		assertEquals(eGenLanguage.getEEnumLiteral("regexp"), pr2.eGet(aGenExpressionInterpreter_Language));
		assertEquals(1, ((List<?>) pr2.eGet(rGenExpressionProviderBase_Expressions)).size());
		
		EObject pr3 = providers.get(2);
		assertEquals(eGenLanguage.getEEnumLiteral("nregexp"), pr3.eGet(aGenExpressionInterpreter_Language));
		assertEquals(1, ((List<?>) pr3.eGet(rGenExpressionProviderBase_Expressions)).size());
		
		EObject pr4 = providers.get(3);
		// Can't invoke java methods on DynamicEObjectImpl :(
		// assertEquals(eGenLanguage.getEEnumLiteral("java"), pr4.getClass().getMethod("getLanguage").invoke(pr4));
		assertEquals(1, ((List<?>) pr4.eGet(rGenExpressionProviderBase_Expressions)).size());
	}
}
