/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Fedorov (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - additional test cases
 */
package org.eclipse.gmf.tests.tr;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.common.codegen.PluginXMLTextMerger;


public class PluginXMLTextMergerTest extends TestCase {
	
	private final static String NL = System.getProperties().getProperty("line.separator"); //$NON-NLS-1$
	private static final String PI_TARGET_GMFGEN = "gmfgen"; //$NON-NLS-1$
	private static final String PI_DATA_GENERATED = "generated"; //$NON-NLS-1$
	private static final String PI_GENERATED_VALUE = "true"; //$NON-NLS-1$
	private static final String PI = MessageFormat.format("      <?{0} {1}=\"{2}\"?>", PI_TARGET_GMFGEN, PI_DATA_GENERATED, PI_GENERATED_VALUE); //$NON-NLS-1$

	private final static String T_00 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL; //$NON-NLS-1$
	private final static String T_01 = "<?eclipse version=\"3.0\"?>" + NL + NL; //$NON-NLS-1$
	private final static String T_02 = "<plugin>" + NL + NL; //$NON-NLS-1$

	private final static String T_10 = "   <extension point=\"org.eclipse.core.runtime.preferences\">" + NL; //$NON-NLS-1$
	private final static String T_11 = PI + NL;
	private final static String T_12 = "      <initializer class=\"org.example.mindmap.diagram.part.MindmapDiagramPreferenceInitializer\"/>" + NL; //$NON-NLS-1$
	private final static String T_13 = "   </extension>" + NL + NL; //$NON-NLS-1$
	
	private final static String T_20 = "   <extension point=\"org.eclipse.core.runtime.preferences\">" + NL; //$NON-NLS-1$
	private final static String T_21 = PI + NL;
	private final static String T_22 = "      <initializer class=\"org.example.mindmap.diagram.part.MindmapDiagramPreferenceInitializer2\"/>" + NL; //$NON-NLS-1$
	private final static String T_23 = "   </extension>" + NL + NL; //$NON-NLS-1$

	private final static String T_30 = "   <extension point=\"org.eclipse.core.runtime.preferences\">" + NL; //$NON-NLS-1$
	private final static String T_31 = "      <initializer class=\"org.example.mindmap.diagram.part.MindmapDiagramPreferenceInitializer3\"/>" + NL; //$NON-NLS-1$
	private final static String T_32 = "   </extension>" + NL + NL; //$NON-NLS-1$

	private final static String T_33 = "   <extension point='org.eclipse.core.runtime.preferences'>" + NL; //$NON-NLS-1$
	private final static String T_34 = "      <initializer class=\"org.example.mindmap.diagram.part.MindmapDiagramPreferenceInitializer3\"/>" + NL; //$NON-NLS-1$
	private final static String T_35 = "   </extension>" + NL + NL; //$NON-NLS-1$

	private final static String T_36 = "   <extension point = \"org.eclipse.core.runtime.preferences\">" + NL; //$NON-NLS-1$
	private final static String T_37 = "      <initializer class=\"org.example.mindmap.diagram.part.MindmapDiagramPreferenceInitializer3\"/>" + NL; //$NON-NLS-1$
	private final static String T_38 = "   </extension>" + NL + NL; //$NON-NLS-1$

	private final static String T_40 = "   <extension" + NL; //$NON-NLS-1$
	private final static String T_41 = "         point=\"org.eclipse.ui.views\">" + NL; //$NON-NLS-1$
	private final static String T_42 = "      <category" + NL; //$NON-NLS-1$
	private final static String T_43 = "            id=\"org.eclipse.gmf.examples.mindmap.diagram.categoryMindmap\"" + NL; //$NON-NLS-1$
	private final static String T_44 = "            name=\"%diagram.category.mindmap\"/>" + NL; //$NON-NLS-1$
	private final static String T_45 = "   </extension>" + NL + NL; //$NON-NLS-1$
	
	private final static String T_50 = "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.properties.propertiesProviders\">" + NL; //$NON-NLS-1$
	private final static String T_51 = PI + NL;
	private final static String T_52 = "      <PropertiesProvider"+ NL; //$NON-NLS-1$
	private final static String T_53 = "            verifyPluginLoaded=\"false\""+ NL; //$NON-NLS-1$
	private final static String T_54 = "            class=\"org.example.mindmap.diagram.providers.MindmapPropertyProvider\">"+ NL; //$NON-NLS-1$
	private final static String T_55 = "         <Priority name=\"Lowest\"/>"+ NL; //$NON-NLS-1$
	private final static String T_56 = "      </PropertiesProvider>"+ NL; //$NON-NLS-1$
	private final static String T_57 = "   </extension>" + NL + NL; //$NON-NLS-1$

	private final static String T_60 = "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.parserProviders\">" + NL; //$NON-NLS-1$
	private final static String T_61 = PI + NL;
	private final static String T_62 = "      <ParserProvider class=\"org.example.mindmap.diagram.providers.MindmapParserProvider\">"+ NL; //$NON-NLS-1$
	private final static String T_63 = "         <Priority name=\"Lowest\"/>"+ NL; //$NON-NLS-1$
	private final static String T_64 = "      </ParserProvider>"+ NL; //$NON-NLS-1$
	private final static String T_65 = "   </extension>" + NL + NL; //$NON-NLS-1$

	private final static String T_70 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"; //$NON-NLS-1$
	private final static String T_71 = "<?eclipse version=\"3.0\"?>"; //$NON-NLS-1$
	private final static String T_72 = "<plugin>"; //$NON-NLS-1$
	private final static String T_73 = "   <extension point=\"org.eclipse.core.runtime.preferences\">"; //$NON-NLS-1$
	private final static String T_74 = PI;
	private final static String T_75 = "      <initializer class=\"org.example.mindmap.diagram.part.MindmapDiagramPreferenceInitializer\"/>"; //$NON-NLS-1$
	private final static String T_76 = "   </extension>"; //$NON-NLS-1$
	private final static String T_77 = "   <extension point=\"org.eclipse.core.runtime.preferences\">"; //$NON-NLS-1$
	private final static String T_78 = "      <initializer class=\"org.example.mindmap.diagram.part.MindmapDiagramPreferenceInitializer3\"/>"; //$NON-NLS-1$
	private final static String T_79 = "   </extension>"; //$NON-NLS-1$

	private final static String T_80 = "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.parserProviders\">" + NL; //$NON-NLS-1$
	private final static String T_81 = "      <!-- " + PI + " -->" + NL; //$NON-NLS-1$
	private final static String T_82 = "   <!--<extension point=\"org.eclipse.core.runtime.preferences\">" + NL; //$NON-NLS-1$
	private final static String T_83 = "      <initializer class=\"org.example.mindmap.diagram.part.MindmapDiagramPreferenceInitializer3\"/>" + NL; //$NON-NLS-1$
	private final static String T_84 = "   </extension>-->" + NL + NL; //$NON-NLS-1$
	private final static String T_85 = "      <ParserProvider class=\"org.example.mindmap.diagram.providers.MindmapParserProvider\">"+ NL; //$NON-NLS-1$
	private final static String T_86 = "         <Priority name=\"Lowest\"/>"+ NL; //$NON-NLS-1$
	private final static String T_87 = "      </ParserProvider>"+ NL; //$NON-NLS-1$
	private final static String T_88 = "   </extension>" + NL + NL; //$NON-NLS-1$

	private final static String T_99 = "</plugin>"; //$NON-NLS-1$

	private final static String T_0 = T_00 + T_01 + T_02;
	private final static String T_1 = T_10 + T_11 + T_12 + T_13;
	private final static String T_2 = T_20 + T_21 + T_22 + T_23;
	private final static String T_3 = T_30 + T_31 + T_32;
	private final static String T_3_A = T_33 + T_34 + T_35;
	private final static String T_3_S = T_36 + T_37 + T_38;
	private final static String T_4 = T_40 + T_41 + T_42 + T_43 + T_44 + T_45;
	private final static String T_5 = T_50 + T_51 + T_52 + T_53 + T_54 + T_55 + T_56 + T_57;
	private final static String T_6 = T_60 + T_61 + T_62 + T_63 + T_64 + T_65;
	private final static String T_7 = T_70 + T_71 + T_72 + T_73 + T_74 + T_75 + T_76 + T_77 + T_78 + T_79;
	private final static String T_8 = T_80 + T_81 + T_82 + T_83 + T_84 + T_85 + T_86 + T_87 + T_88;

	private PluginXMLTextMerger myMerger;
	private boolean shouldFailOnException = true; 

	public PluginXMLTextMergerTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		myMerger = new PluginXMLTextMerger(PI_TARGET_GMFGEN, PI_DATA_GENERATED, PI_GENERATED_VALUE) {
			@Override
			protected void logException(String message, Exception e) {
				if (shouldFailOnException) {
					fail(message);
				}
			}
		};
	}
	
	public void testInvalidOld() {
		final String oldXML = NL;
		final String newXML = T_0 + T_2 + T_99;
		final String expectedResult = newXML;
		shouldFailOnException = false;
		internalTest(oldXML, newXML, expectedResult);
	}

	public void testInvalidNew() {
		final String oldXML = T_0 + T_1 + T_99;
		final String newXML = NL;
		final String expectedResult = oldXML;
		shouldFailOnException = false;
		internalTest(oldXML, newXML, expectedResult);
	}

	/**
	 * this one may pass ok even if result is not merged ok, because default behaviour is to just return newXML. 
	 */
	public void testAddEmptyOld() {
		final String oldXML = T_0 + T_99;
		final String newXML = T_0 + T_2 + T_99;
		final String expectedResult = T_0 + T_2.trim() + NL + T_99;
		internalTestIgnoreNewlines(oldXML, newXML, expectedResult);
	}

	/**
	 * This one helps to catch situation from {@link #testAddEmptyOld()}, when
	 * default newXML is returned 
	 */
	public void testAddNonEmptyOld() {
		final String oldContent = "<extension-point id='zzz'/>" + NL; //$NON-NLS-1$
		final String oldXML = T_0 + oldContent + T_99;
		final String newXML = T_0 + T_2 + T_99;
		final String expectedResult = T_0 +  oldContent + T_2.trim() + NL + T_99;
		internalTest(oldXML, newXML, expectedResult);
	}

// DOESNT work because nothing but extensions are copied from original xml
//	public void testAddToEmptyWithComment() {
//		final String oldXML = T_0 + T_99;
//		final String newXML = T_0 + "<!-- xxx -->" + NL + T_2 + T_99;
//		final String expectedResult = newXML;
//		internalTestIgnoreNewlines(oldXML, newXML, expectedResult);
//	}

	public void testWithEntities() {
		final String e1 = "&#x0A;&#x0D;&#10;&#13;";
		final String e2 = "&lt;&gt;";
		final String oldXML = T_0 + e1 + T_1 + e2 + T_99;
		final String newXML = T_0 + T_2 + T_99;
		final String expectedResult = T_0 + e1 + T_2 + e2 + T_99;
		internalTest(oldXML, newXML, expectedResult);
	}

	public void testDifferentNewLines() {
		final String oldXML = T_0 + T_1 + T_3 + T_4 + T_5 + T_99;
		final String newXML = T_0 + T_2 + T_6 + T_99;
		final String expectedResult = T_0 + T_2 + T_3 + T_4 + T_6 + NL + T_99;
		internalTestIgnoreNewlines(oldXML, switchNewlines(newXML), expectedResult);
		internalTestIgnoreNewlines(switchNewlines(oldXML), newXML, expectedResult);
		internalTestIgnoreNewlines(switchNewlines(oldXML), switchNewlines(newXML), expectedResult);
		internalTestIgnoreNewlines(oldXML, newXML, switchNewlines(expectedResult));
	}

	private static String switchNewlines(String testString) {
		final String replacement = NL.length() == 2 ? "\n" : "\r\n";
		final Matcher matcher = Pattern.compile(NL).matcher(testString);
		assertTrue(matcher.find());
		return matcher.replaceAll(replacement);
	}

	public void testRemove() {
		final String oldXML = T_0 + T_1 + T_99;
		final String newXML = T_0 + T_99;
		//TODO: remove orphan whitespaces
		final String expectedResult = T_0 + "   " + NL + NL + T_99; //$NON-NLS-1$
		internalTest(oldXML, newXML, expectedResult);
	}

	public void testKeep() {
		final String oldXML = T_0 + T_4 + T_99;
		final String newXML = T_0 + T_99;
		final String expectedResult = T_0 + T_4 + T_99;
		internalTest(oldXML, newXML, expectedResult);
	}

	public void testReplace() {
		final String oldXML = T_0 + T_1 + T_99;
		final String newXML = T_0 + T_2 + T_99;
		final String expectedResult = newXML;
		internalTest(oldXML, newXML, expectedResult);
	}

//	 DOESNT work because nothing but extensions are copied from original xml
//	public void testReplace2() {
//		final String oldXML = T_0 + T_1 + T_99;
//		final String newXML = T_0 + "<!-- xxx -->" + NL + T_2 + T_99;
//		final String expectedResult = newXML;
//		internalTest(oldXML, newXML, expectedResult);
//	}

	public void testGeneratedNot() {
		final String oldXML = (T_0 + T_1 + T_99).replace("generated=\"true\"", "generated=\"false\"");
		final String newXML = T_0 + T_2 + T_99;
		final String expectedResult = oldXML;
		internalTest(oldXML, newXML, expectedResult);
	}

	public void testComplex() {
		final String oldXML = T_0 + T_1 + T_3 + T_4 + T_5 + T_99;
		final String newXML = T_0 + T_2 + T_6 + T_99;
		final String expectedResult = T_0 + T_2 + T_3 + T_4 + T_6 + NL + T_99;
		internalTest(oldXML, newXML, expectedResult);
	}
	
	public void testUnformatted() {
		final String oldXML = T_7 + T_99;
		final String newXML = T_0 + T_2 + T_99;
		final String expectedResult = T_70 + T_71 + T_72 + T_20 + T_21 + T_22 + T_79 + T_77 + T_78 + T_79 + T_99;
		internalTest(oldXML, newXML, expectedResult);
	}

	public void testWithComments() {
		final String oldXML = T_0 + T_1 + T_8 + T_99;
		final String newXML = T_0 + T_2 + T_99;
		final String expectedResult = T_0 + T_2 + T_8 + T_99;
		internalTest(oldXML, newXML, expectedResult);
	}

	public void testApostrophe() {
		final String oldXML = T_0 + T_3_A + T_99;
		final String newXML = T_0 + T_2 + T_99;
		final String expectedResult = T_0 + T_3_A + T_99;
		internalTest(oldXML, newXML, expectedResult);
	}

	public void testSpace() {
		final String oldXML = T_0 + T_3_S + T_99;
		final String newXML = T_0 + T_2 + T_99;
		final String expectedResult = T_0 + T_3_S + T_99;
		internalTest(oldXML, newXML, expectedResult);
	}

	private void internalTest(String oldXML, String newXML, String expectedResult) {
		String result = myMerger.process(oldXML, newXML);
		assertNotNull(result);
		assertEquals(expectedResult, result);
	}

	private void internalTestIgnoreNewlines(String oldXML, String newXML, String expectedResult) {
		String result = myMerger.process(oldXML, newXML);
		assertNotNull(result);
		final Pattern pattern = Pattern.compile("\r\n");
		String uniformResult = pattern.matcher(result).replaceAll("\n");
		String uniformExpected = pattern.matcher(expectedResult).replaceAll("\n");
		assertEquals(uniformExpected, uniformResult);
	}
}
