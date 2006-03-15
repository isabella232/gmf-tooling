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

import junit.framework.Assert;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.internal.codegen.GMFGenConfig;
import org.eclipse.gmf.internal.common.reconcile.DefaultDecisionMaker;
import org.eclipse.gmf.internal.common.reconcile.Reconciler;
import org.eclipse.gmf.internal.common.reconcile.ReconcilerConfigBase;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.gmf.tests.setup.DiaDefSetup;
import org.eclipse.gmf.tests.setup.DiaGenSetup;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.MapSetup;
import org.eclipse.gmf.tests.setup.ToolDefSetup;

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
		class GenPluginChange extends Assert implements UserChange {
			private final String NEW_PROVIDER = "NewProviderValue";
			private final String NEW_VERSION = "NewVersionValue";

			public void applyChanges(GenEditorGenerator old) {
				GenPlugin genPlugin = old.getPlugin();
				assertNotNull(genPlugin.getProvider());
				assertNotNull(genPlugin.getVersion());

				genPlugin.setProvider(NEW_PROVIDER);
				genPlugin.setVersion(NEW_VERSION);
			}
			
			public void assertChangesPreserved(GenEditorGenerator current) {
				assertEquals(NEW_PROVIDER, current.getPlugin().getProvider());
				assertEquals(NEW_VERSION, current.getPlugin().getVersion());
			}
			
			public ReconcilerConfigBase getReconcilerConfig() {
				return new LimitedGMFGenConfig(true);
			}
		}
		
		checkUserChange(new GenPluginChange());
	}
	
	public void testReconcileGenNodes() throws Exception {
		MapDefSource mapDefSource = new MapSetup().init(new DiaDefSetup(null).init(), getSetup().getDomainModel(), new ToolDefSetup());
		DiaGenSetup diaGenSetup = new DiaGenSetup().init(mapDefSource);
		myEditorGen = diaGenSetup.getGenDiagram().getEditorGen();
			
		class ListLayoutChange extends Assert implements UserChange {
			//FIXME: "MyCanonicalEditPolicy" or "MyGraphiclNodeEditPolicy" will break the magic
			private final String NEW_CANONICAL_EP = "MyCanonicalPolicy";
			private final String NEW_GRAPHICAL_EP = "MyGraphicalPolicy";
			
			public void applyChanges(GenEditorGenerator old) {
				EList oldNodes = old.getDiagram().getAllNodes();
				assertEquals(2, oldNodes.size());
				GenNode nodeA = (GenNode) oldNodes.get(0);
				GenNode nodeB = (GenNode) oldNodes.get(1);
				
				nodeA.setListLayout(true);
				nodeB.setListLayout(false);
				
				nodeA.setCanonicalEditPolicyClassName(NEW_CANONICAL_EP);
				nodeA.setGraphicalNodeEditPolicyClassName(NEW_GRAPHICAL_EP);
			}
			
			public void assertChangesPreserved(GenEditorGenerator current) {
				EList currentNodes = current.getDiagram().getAllNodes();
				assertEquals(2, currentNodes.size());
				GenNode nodeA = (GenNode) currentNodes.get(0);
				GenNode nodeB = (GenNode) currentNodes.get(1);
				
				assertTrue(nodeA.isListLayout());
				assertFalse(nodeB.isListLayout());
				
				assertEquals(NEW_CANONICAL_EP, nodeA.getCanonicalEditPolicyClassName());
				assertEquals(NEW_GRAPHICAL_EP, nodeA.getGraphicalNodeEditPolicyClassName());
			}
			
			public ReconcilerConfigBase getReconcilerConfig() {
				return new GMFGenConfig();
			}
		}
		
		checkUserChange(new ListLayoutChange());
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
