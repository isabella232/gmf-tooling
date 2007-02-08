/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.tr;

import java.util.HashSet;
import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.internal.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediator;
import org.eclipse.gmf.mappings.AuditContainer;
import org.eclipse.gmf.mappings.AuditRule;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.Severity;

/**
 * @author artem
 */
public class AuditRootTest extends TestCase {

	private AuditContainer topCat;
	private GenAuditRoot genRoot;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// four containers (levels: 1-2-1), owning one rule each
		topCat = createAuditContainer("ac1");
		final AuditContainer containerChild1 = createAuditContainer("ac2");
		containerChild1.setParentContainer(topCat);
		final AuditContainer containerChild1bis = createAuditContainer("ac2-bis");
		containerChild1bis.setParentContainer(topCat);
		final AuditContainer containerChild2 = createAuditContainer("ac3");
		containerChild2.setParentContainer(containerChild1);

		topCat.getAudits().add(createAuditRule("r1"));
		containerChild1.getAudits().add(createAuditRule("r2"));
		containerChild2.getAudits().add(createAuditRule("r3"));
		containerChild1bis.getAudits().add(createAuditRule("r4"));

		class DiagramGenModelTransformerX extends DiagramGenModelTransformer {
			private DiagramGenModelTransformerX() {
				super(new BasicDiagramRunTimeModelHelper(), new GenModelNamingMediator.Empty());
			}
			public GenAuditRoot go(AuditContainer audits) {
				super.process(audits);
				return getResult().getAudits();
			}
		};
		genRoot = new DiagramGenModelTransformerX().go(topCat);
		assertNotNull(genRoot);
	}

	private static AuditContainer createAuditContainer(String id) {
		AuditContainer container = GMFMapFactory.eINSTANCE.createAuditContainer();		
		container.setId(id);
		container.setName("Name of \"" + id + "\""); //$NON-NLS-1$ //$NON-NLS-2$
		container.setDescription("Description of \"" + id + "\""); //$NON-NLS-1$ //$NON-NLS-2$
		return container;
	}

	private static AuditRule createAuditRule(String token) {
		AuditRule r = GMFMapFactory.eINSTANCE.createAuditRule();
		r.setId(token);
		r.setMessage("Message for " + token);
		r.setDescription("Description for " + token);
		r.setSeverity(Severity.get(token.hashCode() % 3));
		r.setUseInLiveMode(token.hashCode() % 2 == 0);
		return r;
	}

	public void testStructure() {
		//count nodes
		assertEquals(4, genRoot.getCategories().size());
		assertEquals(4, genRoot.getRules().size());
		HashSet c = new HashSet(genRoot.getCategories());
		for (Iterator it = genRoot.getRules().iterator(); it.hasNext();) {
			GenAuditRule r = (GenAuditRule) it.next();
			assertNotNull(r.getCategory());
			assertTrue("each rule belongs to sole category", c.remove(r.getCategory()));
			assertEquals(genRoot, r.getCategory().getRoot()); // temp check
			assertEquals(genRoot, r.getRoot());
		}
	}

	public void testPath() {
		final GenAuditContainer c1 = findGenCategory(topCat);
		assertEquals(1, c1.getPath().size());
		assertEquals(c1, c1.getPath().get(0));

		final AuditContainer ac2 = (AuditContainer) topCat.getChildContainers().get(0);
		final GenAuditContainer c2 = findGenCategory(ac2);
		assertEquals(2, c2.getPath().size());
		assertEquals(c1, c2.getPath().get(0));
		assertEquals(c2, c2.getPath().get(1));

		final GenAuditContainer c2bis = findGenCategory((AuditContainer) topCat.getChildContainers().get(1));
		assertEquals(2, c2bis.getPath().size());
		assertEquals(c1, c2bis.getPath().get(0));
		assertEquals(c2bis, c2bis.getPath().get(1));

		final GenAuditContainer c3 = findGenCategory((AuditContainer) ac2.getChildContainers().get(0));
		assertEquals(3, c3.getPath().size());
		assertEquals(c1, c3.getPath().get(0));
		assertEquals(c2, c3.getPath().get(1));
		assertEquals(c3, c3.getPath().get(2));
	}

	public void testCategoryAttributes() {
		// id, message, desc
		AuditContainer ci = (AuditContainer) topCat.getChildContainers().get(1);
		GenAuditContainer co = findGenCategory(ci);
		assertNotNull(co);
		assertEquals(ci.getDescription(), co.getDescription());
		assertEquals(ci.getName(), co.getName());
	}

	public void testRuleAttributes() {
		final AuditRule ri = (AuditRule) ((AuditContainer) topCat.getChildContainers().get(1)).getAudits().get(0);
		GenAuditRule ro = findGenRule(ri);
		assertNotNull(ro);
		assertEquals(ri.getName(), ro.getName());
		assertEquals(ri.getDescription(), ro.getDescription());
		assertEquals(ri.getMessage(), ro.getMessage());
		assertEquals(ri.isUseInLiveMode(), ro.isUseInLiveMode());
		assertEquals(ri.getSeverity().getLiteral(), ro.getSeverity().getLiteral());
		assertEquals(ri.getContainer().getId(), ro.getCategory().getId());
	}

	private GenAuditContainer findGenCategory(AuditContainer ac) {
		for (Object o : genRoot.getCategories()) {
			if (ac.getId().equals(((GenAuditContainer) o).getId())) {
				return (GenAuditContainer) o;
			}
		}
		return null;
	}

	private GenAuditRule findGenRule(AuditRule r) {
		for (Object o : genRoot.getRules()) {
			if (r.getId().equals(((GenAuditRule) o).getId())) {
				return (GenAuditRule) o;
			}
		}
		return null;
	}
}
