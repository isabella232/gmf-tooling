/*
 * Copyright (c) 2008 Borland Software Corporation
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

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenConstraint;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenElementInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureValueSpec;
import org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider;
import org.eclipse.gmf.codegen.gmfgen.GenLanguage;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkConstraints;
import org.eclipse.gmf.codegen.gmfgen.GenMetricContainer;
import org.eclipse.gmf.codegen.gmfgen.GenMetricRule;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ValueExpression;
import org.eclipse.gmf.internal.codegen.util.CustomCopier;
import org.eclipse.gmf.internal.common.ToolingResourceFactory;

public class TestCustomCopier extends TestCase {

	public TestCustomCopier(String name) {
		super(name);
	}

	public void testCustomModelTransform() throws Exception {
		//EObject testRoot = createTestModel();
		final URI uri = MigrationPatchesTest.createURI("228913-copier.gmfgen#/");
		Resource r = new ToolingResourceFactory().createResource(uri.trimFragment());
		ResourceSet rset = new ResourceSetImpl();
		rset.getResources().add(r);
		EObject testRoot = rset.getEObject(uri, true);
		EObject newGenModel = CustomCopier.go(testRoot, GMFGenPackage.eINSTANCE);
		checkTestModel(newGenModel);
	}
	
	private void checkTestModel(EObject newRoot) {
		EPackage p = newRoot.eClass().getEPackage();
		assertEquals("http://www.eclipse.org/gmf/2008/GenModel", p.getNsURI());
		
		assertTrue(newRoot instanceof GenEditorGenerator);
		GenEditorGenerator root = (GenEditorGenerator) newRoot;

		GenAuditRoot auditRoot = root.getAudits();
		assertNotNull(auditRoot);
		assertEquals(1, auditRoot.getRules().size());
		GenAuditRule aud1 = auditRoot.getRules().get(0);
		GenConstraint aud1VE = aud1.getRule();
		assertNotNull(aud1VE);
		assertEquals("audit1", aud1VE.getBody());
		GenExpressionProviderBase aud1VEprov = aud1VE.getProvider();
		assertNotNull(aud1VEprov);
		assertEquals(GenLanguage.OCL_LITERAL, aud1VEprov.getLanguage());
		
		GenMetricContainer metricRoot = root.getMetrics();
		assertNotNull(metricRoot);
		assertEquals(1, metricRoot.getMetrics().size());
		GenMetricRule met1 = metricRoot.getMetrics().get(0);
		ValueExpression met1VE = met1.getRule();
		assertNotNull(met1VE);
		assertEquals("audit1", met1VE.getBody());
		GenExpressionProviderBase met1VEprov = met1VE.getProvider();
		assertNotNull(met1VEprov);
		assertEquals(GenLanguage.OCL_LITERAL, met1VEprov.getLanguage());
		
		assertEquals(aud1VEprov, met1VEprov);
		assertTrue(aud1VEprov == met1VEprov);
		assertEquals(met1VE, aud1VE); // copy
		assertTrue(met1VE == aud1VE);

		GenDiagram diagram = root.getDiagram();
		assertNotNull(diagram);
		
		EList<GenLink> links = diagram.getLinks();
		assertEquals(2, links.size());
		GenLink link1 = links.get(0);
		assertNotNull(link1);
		GenLinkConstraints csts1 = link1.getCreationConstraints();
		assertNotNull(csts1);
		assertNull(csts1.getTargetEnd());
		GenConstraint src1 = csts1.getSourceEnd();
		assertNotNull(src1);
		assertEquals("source_link1", src1.getBody());
		GenExpressionProviderBase src1prov = src1.getProvider();
		assertNotNull(src1prov);
		assertEquals(GenLanguage.NREGEXP_LITERAL, src1prov.getLanguage());
		
		GenLink link2 = links.get(1);
		GenLinkConstraints csts2 = link2.getCreationConstraints();
		assertNotNull(csts2);
		assertNull(csts2.getSourceEnd());
		GenConstraint trg2 = csts2.getTargetEnd();
		assertNotNull(trg2);
		assertEquals("target_link2", trg2.getBody());
		GenExpressionProviderBase trg2prov = trg2.getProvider();
		assertNotNull(trg2prov);
		assertEquals(GenLanguage.JAVA_LITERAL, trg2prov.getLanguage());
		
		EList<GenChildNode> nodes = diagram.getChildNodes();
		assertEquals(2, nodes.size());
		GenChildNode node1 = nodes.get(0);
		assertNotNull(node1);
		TypeModelFacet fac1 = node1.getModelFacet();
		assertNotNull(fac1);
		GenConstraint node1cstr = fac1.getModelElementSelector();
		assertNotNull(node1cstr);
		assertEquals("node1", node1cstr.getBody());
		GenExpressionProviderBase node1cstrProv = node1cstr.getProvider();
		assertNotNull(node1cstrProv);
		assertEquals(GenLanguage.OCL_LITERAL, node1cstrProv.getLanguage());
		
		assertEquals(aud1VEprov, node1cstrProv);
		
		GenChildNode node2 = nodes.get(1);
		assertNotNull(node2);
		TypeModelFacet fac2 = node2.getModelFacet();
		assertNotNull(fac2);
		GenElementInitializer ir2 = fac2.getModelElementInitializer();
		assertTrue(ir2 instanceof GenFeatureSeqInitializer);
		GenFeatureSeqInitializer irs2 = (GenFeatureSeqInitializer) ir2;
		EList<GenFeatureInitializer> irs2s = irs2.getInitializers();
		assertEquals(1, irs2s.size());
		GenFeatureInitializer fvs1 = irs2s.get(0);
		assertTrue(fvs1 instanceof GenFeatureValueSpec);
		GenFeatureValueSpec fvs1c = (GenFeatureValueSpec) fvs1;
		ValueExpression node2ve = fvs1c.getValue();
		assertNotNull(node2ve);
		assertEquals("node2", node2ve.getBody());
		GenExpressionProviderBase node2veProv = node2ve.getProvider();
		assertNotNull(node2veProv);
		assertEquals(GenLanguage.REGEXP_LITERAL, node2veProv.getLanguage());
		
		GenExpressionProviderContainer providerRoot = root.getExpressionProviders();
		assertNotNull(providerRoot);
		EList<GenExpressionProviderBase> providers = providerRoot.getProviders();
		assertEquals(4, providers.size());
		assertTrue(providers.get(0) instanceof GenExpressionInterpreter);
		assertTrue(providers.get(1) instanceof GenExpressionInterpreter);
		assertTrue(providers.get(2) instanceof GenExpressionInterpreter);
		assertTrue(providers.get(3) instanceof GenJavaExpressionProvider);
		GenExpressionInterpreter pr1 = (GenExpressionInterpreter) providers.get(0);
		assertEquals(GenLanguage.OCL_LITERAL, pr1.getLanguage());
		assertEquals(2, pr1.getExpressions().size());
		
		GenExpressionInterpreter pr2 = (GenExpressionInterpreter) providers.get(1);
		assertEquals(GenLanguage.REGEXP_LITERAL, pr2.getLanguage());
		assertEquals(1, pr2.getExpressions().size());
		
		GenExpressionInterpreter pr3 = (GenExpressionInterpreter) providers.get(2);
		assertEquals(GenLanguage.NREGEXP_LITERAL, pr3.getLanguage());
		assertEquals(1, pr3.getExpressions().size());
		
		GenJavaExpressionProvider pr4 = (GenJavaExpressionProvider) providers.get(3);
		assertEquals(GenLanguage.JAVA_LITERAL, pr4.getLanguage());
		assertEquals(1, pr4.getExpressions().size());
	}
}
