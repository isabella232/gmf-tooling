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
import java.util.Properties;

import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.gmf.internal.common.codegen.DefaultTextMerger;

import junit.framework.TestCase;

/**
 * @author artem
 */
public class TestDefaultMergeService extends TestCase {

	private DefaultTextMerger myMergeService;
	private final String myBeginTagXML;
	private final String myEndTagXML;

	public TestDefaultMergeService(String name) {
		super(name);
		final String[] r = new String[2];
		new DefaultTextMerger(new JControlModel()) {
			{
				r[0] = BEGIN_TAG;
				r[1] = END_TAG;
			}
		};
		// Copy from DefaultTextMerger cons
		myBeginTagXML =  "<!-- " + r[0] + " -->";
		myEndTagXML = "<!-- " + r[1] + " -->";
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		myMergeService = new DefaultTextMerger(new JControlModel());
	}

	public void testXML() {
		final String pieceToKeep = "<b>keep this</b>";
		final String xmlOld = "<p>aaa" + myBeginTagXML + pieceToKeep + myEndTagXML + "<i>bbb</i>ccc</p>";
		final String xmlNew = "<p>bbb" + myBeginTagXML + myEndTagXML + "<i>bbb</i><b>e</b>ccc</p>";
		String result = myMergeService.mergeXML(xmlOld, xmlNew);
		assertNotNull(result);
		assertEquals("<p>bbb" + myBeginTagXML + pieceToKeep + myEndTagXML + "<i>bbb</i><b>e</b>ccc</p>", result);
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
		assertEquals("merger with uninitialized control model can't perform merge", getJavaNewText(), myMergeService.mergeJava(getJavaOldText(), getJavaNewText()));
		
	}

	public void testProcessJava() {
		final String javaResult = myMergeService.process("java", getJavaOldText(), getJavaNewText());
		assertEquals(myMergeService.mergeJava(getJavaOldText(), getJavaNewText()), javaResult);
	}

	public void testProcessXml() {
		final String xmlOld = "<p>aaa<i>bbb</i>ccc</p>";
		final String xmlNew = "<p>ddd<b>e</b>ccc</p>";
		final String xmlResult = myMergeService.process("xml", xmlOld, xmlNew);
		assertEquals(myMergeService.mergeXML(xmlOld, xmlNew), xmlResult);
	}

	public void testProcessProperties() {
		final String propOld = "p1=v1\np2=v2\n#p3=\n";
		final String propNew = "p1=v1\np2=nv\np3=v3\n";
		final String propResult = myMergeService.process("properties", propOld, propNew);
		assertEquals(myMergeService.mergeProperties(propOld, propNew), propResult);
	}

	private String getJavaOldText() {
		return "class A {}";
	}

	private String getJavaNewText() {
		return "class D {int c;}";
	}
}
