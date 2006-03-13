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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.internal.common.reconcile.DefaultDecisionMaker;
import org.eclipse.gmf.internal.common.reconcile.Matcher;
import org.eclipse.gmf.internal.common.reconcile.Reconciler;
import org.eclipse.gmf.internal.common.reconcile.ReconcilerConfigBase;
import org.eclipse.gmf.tests.ConfiguredTestCase;

public class CodegenReconcileTest extends ConfiguredTestCase {

	private GenEditorGenerator myEditorGen;

	public CodegenReconcileTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		myEditorGen = getSetup().getGenModel().getGenDiagram().getEditorGen(); 
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
		GenPlugin old = createCopy().getPlugin();
		GenPlugin current = createCopy().getPlugin();

		assertNotNull(old.getProvider());
		assertNotNull(old.getVersion());

		final String NEW_PROVIDER = "NewProviderValue";
		final String NEW_VERSION = "NewVersionValue";

		old.setProvider(NEW_PROVIDER);
		old.setVersion(NEW_VERSION);

		createReconciler().reconcileTree(current, old);

		assertEquals(NEW_PROVIDER, current.getProvider());
		assertEquals(NEW_VERSION, current.getVersion());
	}

	public void testReconcileGenEditorGenerator() throws Exception {
		GenEditorGenerator old = createCopy();
		GenEditorGenerator current = createCopy();

		old.setCopyrightText("AAA");
		old.setPackageNamePrefix("BBB");
		old.setDiagramFileExtension("CCC");

		boolean sameFile = !old.isSameFileForDiagramAndModel();
		old.setSameFileForDiagramAndModel(sameFile);

		// we do not reconcile this now
		old.setTemplateDirectory("DDD");
		assertEquals("DDD", old.getTemplateDirectory());

		createReconciler().reconcileTree(current, old);

		assertEquals("AAA", current.getCopyrightText());
		assertEquals("BBB", current.getPackageNamePrefix());
		assertEquals("CCC", current.getDiagramFileExtension());
		assertEquals(sameFile, current.isSameFileForDiagramAndModel());

		assertEquals("DDD", old.getTemplateDirectory());
		assertFalse("DDD".equals(current.getTemplateDirectory()));
	}

	private Reconciler createReconciler() {
		return new Reconciler(new GMFGenConfig());
	}

	/**
	 * FIXME copy of oeg.internal.codegen.GMFGenConfig
	 * Duplicated here for 2 reasons: 
	 * 1 - need to find better placement for GMFGenConfig (not ui plugin), but can't do it right away
	 * 2 - perhaps, we should check particular configuration in this test (i.e. don't add, say, CopyrightText into
	 * config and check it's not preserved during reconcile) 
	 */
	private static class GMFGenConfig extends ReconcilerConfigBase {
		public GMFGenConfig(){
			final GMFGenPackage GMFGEN = GMFGenPackage.eINSTANCE;

			setMatcher(GMFGEN.getGenEditorGenerator(), ALWAYS_MATCH);
			preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_CopyrightText());
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
		
		private static final Matcher ALWAYS_MATCH = new Matcher(){
			public boolean match(EObject current, EObject old) {
				return current.eClass().equals(old.eClass());
			}
		};
	}
}
