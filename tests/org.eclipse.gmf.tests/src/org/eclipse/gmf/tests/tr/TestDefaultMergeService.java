/*
 * Copyright (c) 2006 Borland Software Corporation
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

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Properties;

import junit.framework.TestCase;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.gmf.internal.common.codegen.DefaultTextMerger;
import org.eclipse.gmf.internal.common.codegen.TextMerger;

/**
 * @author artem
 */
public class TestDefaultMergeService extends TestCase {

	private DefaultTextMerger myMergeService;

	public TestDefaultMergeService(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		URL controlFile = Platform.getBundle("org.eclipse.gmf.codegen").getEntry("/templates/emf-merge.xml");
		JControlModel controlModel = new JControlModel();
		controlModel.initialize(CodeGenUtil.instantiateFacadeHelper(JMerger.DEFAULT_FACADE_HELPER_CLASS), controlFile.toString());
		assertTrue(controlModel.canMerge());
		myMergeService = createMergeService(controlModel);
	}

	protected final DefaultTextMerger createMergeService(JControlModel controlModel) {
		return new DefaultTextMerger(controlModel);
	}

	public void testProcessHitRightMethod() {
		final boolean[] hitXML = new boolean[1];
		final boolean[] hitPluginXML = new boolean[1];
		final boolean[] hitManifestMF = new boolean[1];
		class TextMergeHitTest extends TextMerger {
			@Override
			public String mergeXML(String oldText, String newText) {
				hitXML[0] = true;
				return super.mergeXML(oldText, newText);
			}
			@Override
			public String mergePluginXML(String oldText, String newText) {
				hitPluginXML[0] = true;
				return super.mergePluginXML(oldText, newText);
			}
			@Override
			public String mergeManifestMF(String oldText, String newText) {
				hitManifestMF[0] = true;
				return super.mergeManifestMF(oldText, newText);
			}
		}
		TextMergeHitTest hitTest = new TextMergeHitTest();

		hitXML[0] = hitPluginXML[0] = hitManifestMF[0] = false;
		hitTest.process("MANIFEST.MF", "", "");
		assertTrue(!hitXML[0] && !hitPluginXML[0] && hitManifestMF[0]);

		hitXML[0] = hitPluginXML[0] = hitManifestMF[0] = false;
		hitTest.process("sample.xml", "", "");
		assertTrue(hitXML[0] && !hitPluginXML[0] && !hitManifestMF[0]);

		hitXML[0] = hitPluginXML[0] = hitManifestMF[0] = false;
		hitTest.process("plugin.xml", "", "");
		assertTrue(!hitXML[0] && hitPluginXML[0] && !hitManifestMF[0]);
	}

	public void testProperties() throws Exception {
		final String oldContent = "prop1=value1\n" + "prop2=value2\n" + "#propRemoved=\n" + "propAdded=newValue\n" + "prop3=value3\n";
		final String newContent = "prop1=value1\n" + "prop2=modifiedValue2\n" + "propRemoved=someValue\n" + "prop3=value3\n";
		String merged = myMergeService.mergeProperties(oldContent, newContent);
		assertNotNull(merged);
		Properties result = new Properties();
		result.load(new ByteArrayInputStream(merged.getBytes()));
		assertEquals(4, result.size());
		assertEquals("value1", result.getProperty("prop1"));
		assertEquals("value2", result.getProperty("prop2"));
		assertEquals("value3", result.getProperty("prop3"));
		// check removed property not appear
		assertNull(result.getProperty("propRemoved"));
		// check added property kept
		assertEquals("newValue", result.getProperty("propAdded"));
	}

	public void testJava() {
		final String marker = "/**\n* @generated\n*/\n";
		final String oldMethodB = "protected void methodB() {new Object();}";
		final String oldJava = marker + "class B {\n" + marker + "public void methodA() {new Object();}\n" + oldMethodB + "\n}";
		final String newMethodA = "public void methodA() {new String();}\n";
		final String newJava = marker + "class B {\n" + marker + newMethodA + marker + "protected void methodB() {new String();}" + "\n}";
		final String mergeRes = myMergeService.mergeJava(oldJava, newJava);
		assertEquals(marker + "class B {\n" + marker + newMethodA + oldMethodB + "\n}", mergeRes);
	}

	public void testJavaMergeNoControlModel() { 
		DefaultTextMerger mergeServiceNoControl = createMergeService(new JControlModel()); 
		assertEquals("merger with uninitialized control model can't perform merge", getJavaNewText(), mergeServiceNoControl.mergeJava(getJavaOldText(), getJavaNewText()));
	}

	public void testProcessJava() {
		final String javaResult = myMergeService.process("Sample.java", getJavaOldText(), getJavaNewText());
		assertEquals(myMergeService.mergeJava(getJavaOldText(), getJavaNewText()), javaResult);
	}

	public void testProcessXml() {
		final String xmlOld = "<p>aaa<i>bbb</i>ccc</p>";
		final String xmlNew = "<p>ddd<b>e</b>ccc</p>";
		final String xmlResult = myMergeService.process("sample.xml", xmlOld, xmlNew);
		assertEquals(myMergeService.mergeXML(xmlOld, xmlNew), xmlResult);
	}

	public void testProcessProperties() {
		final String propOld = "p1=v1\np2=v2\n#p3=\n";
		final String propNew = "p1=v1\np2=nv\np3=v3\n";
		final String propResult = myMergeService.process("sample.properties", propOld, propNew);
		assertEquals(myMergeService.mergeProperties(propOld, propNew), propResult);
	}

	private String getJavaOldText() {
		return "class A {}";
	}

	private String getJavaNewText() {
		return "class D {int c;}";
	}
}
