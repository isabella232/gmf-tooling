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

import java.text.MessageFormat;

import org.eclipse.gmf.internal.common.codegen.ManifestFileMerge;

import junit.framework.TestCase;

/**
 * @author artem
 */
public class ManifestMergeTest extends TestCase {

	private final ManifestFileMerge manifestMerge;

	public ManifestMergeTest(String name) {
		super(name);
		manifestMerge = new ManifestFileMerge("\n"); 
	}


	public void testHeaderOldOnly() {
		MessageFormat pattern = newPattern();
		String oldText = format(pattern, "Bundle-ClassPath: .\n");
		String newText = format(pattern, "");
		String result = manifestMerge.process(oldText, newText);
		assertEquals(oldText, result);
	}

	public void testHeaderNewOnly() {
		// ignored and not ignored
		MessageFormat pattern = newPattern();
		String oldText = format(pattern, "");
		String newText = format(pattern, "Bundle-ClassPath: .\n");
		String result = manifestMerge.process(oldText, newText);
		String expected = oldText + "Bundle-ClassPath: .\n";
		assertEquals("New header should get inserted", expected, result);
		oldText = oldText + "GMF-IgnoreMerge: Bundle-ClassPath\n";
		result = manifestMerge.process(oldText, newText);
		assertEquals("...unless it's explicitly ignored", oldText, result);
	}

	public void testPreserve() {
		MessageFormat pattern = newPattern();
		String oldText = format(pattern, "Bundle-ClassPath: bin/\n");
		String newText = format(pattern, "Bundle-ClassPath: .\n");
		oldText = oldText + "GMF-IgnoreMerge: Bundle-ClassPath\n";
		String result = manifestMerge.process(oldText, newText);
		assertEquals(oldText, result);
	}

	public void testAppendMultivalued() {
		MessageFormat pattern = newPattern();
		String valueTail = ";directive:=one;attr=\"two\"";
		String oldText = format(pattern, "Bundle-ClassPath: bin/" + valueTail + ",\n runtime/\n");
		String newText = format(pattern, "Bundle-ClassPath: runtime/, out/" + valueTail +"\n");
		String expected = format(pattern, "Bundle-ClassPath: bin/" + valueTail + ",\n runtime/,\n out/" + valueTail + "\n");
		String result = manifestMerge.process(oldText, newText);
		assertEquals(expected, result);
	}

	public void testPreserveMultivaluedAttributes() {
		MessageFormat pattern = newPattern();
		String valueTail = ";directive:=one;attr=\"two\"";
		String oldText = format(pattern, "Bundle-ClassPath: bin/" + valueTail + ",runtime/\n");
		String newText = format(pattern, "Bundle-ClassPath: bin/, runtime/\n" );
		String result = manifestMerge.process(oldText, newText);
		assertEquals(oldText, result);
	}

	public void testPreserveAttributeWithComma() {
		MessageFormat pattern = newPattern();
		String valueTail = ";attr=\"[1.0,2.0)\"";
		String oldText = format(pattern, "Bundle-ClassPath: bin/" + valueTail + ",runtime/\n");
		String newText = format(pattern, "Bundle-ClassPath: bin/, runtime/\n" );
		String result = manifestMerge.process(oldText, newText);
		assertEquals(oldText, result);
	}

	public void testOverwrite() {
		MessageFormat pattern = newPattern();
		String oldText = format(pattern, "Bundle-ClassPath: bin/\n");
		String newText = format(pattern, "Bundle-ClassPath: .\n");
		String result = manifestMerge.process(oldText, newText);
		assertEquals(newText, result);
	}

	private static MessageFormat newPattern() {
		return new MessageFormat( 
"Bundle-Name: %pluginName\n{0}" + 
"Require-Bundle: org.eclipse.core.runtime,\n" +
" org.eclipse.core.resources;visibility:=reexport,\n" + 
" org.eclipse.ui.views\n");
	}

	private static String format(MessageFormat pattern, String... args) {
		return pattern.format(args);
	}
}
