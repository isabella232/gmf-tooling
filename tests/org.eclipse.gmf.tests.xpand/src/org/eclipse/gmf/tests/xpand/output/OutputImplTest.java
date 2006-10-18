/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.gmf.tests.xpand.output;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.ast.ExpressionStatement;
import org.eclipse.gmf.internal.xpand.ast.TextStatement;
import org.eclipse.gmf.internal.xpand.model.Output;

public class OutputImplTest extends TestCase {
	private Output output;

	private StringBuilder buffer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		buffer = new StringBuilder(50);
		output = new BufferOutput(buffer);
	}

	private Output getOutput() {
		return output;
	}

	private StringBuilder getBuffer() {
		return buffer;
	}

	public final void testDeleteLine1() {
		final Output bo = getOutput();

		bo.enterStatement(new TextStatement(0, 1, 1, "", false));
		bo.write("Hallo test \r\n    ");
		bo.enterStatement(new TextStatement(0, 1, 1, "", true));
		bo.write("     \n  \t  Ola");

		assertEquals("Hallo test \r\n      \t  Ola", getBuffer().toString());
	}

	public final void testDeleteLine2() {
		final Output bo = getOutput();

		bo.enterStatement(new TextStatement(0, 1, 1, "", false));
		bo.write("Hallo test \r  \t  ");
		bo.enterStatement(new TextStatement(0, 1, 1, "", true));
		bo.write("     \n    Ola");

		assertEquals("Hallo test \r  \t      Ola", getBuffer().toString());
	}

	public final void testDeleteLine2_5() {
		final Output bo = getOutput();

		bo.enterStatement(new TextStatement(0, 1, 1, "", true));
		bo.write("\r\nfirstLine\r\n");

		assertEquals("firstLine\r\n", getBuffer().toString());
	}

	public final void testDeleteLine3() {
		final Output bo = getOutput();

		bo.enterStatement(new TextStatement(0, 1, 1, "", true));
		bo.write("\r\n");
		bo.enterStatement(new TextStatement(0, 1, 1, "", true));
		bo.write("\r\n \tTest");

		assertEquals(" \tTest", getBuffer().toString());
	}

	public final void testDeleteLine4() {
		final Output bo = getOutput();

		bo.enterStatement(new TextStatement(0, 1, 1, "", true));
		bo.write("\r\n");
		bo.enterStatement(new ExpressionStatement(0, 1, 1, null));
		bo.write(" mein scholli ");
		bo.enterStatement(new TextStatement(0, 1, 1, "", true));
		bo.write("\r\n \tTest");

		// XXX original test kept \r\n here, i.e. " mein scholli \r\n \tTest"
		// because pattern OutputImpl used to decide whether to delete line or not
		// respected deleteLine only if there was no characters other than whitespace
		// since last newline. IOW, it ignored ->> if there was non-whitespace
		// earlier in the same line. Odd to me - if person wants this newline to be kept,
		// he'll just put ">>" instead "->>"
		assertEquals(" mein scholli  \tTest", getBuffer().toString());
	}

	public final void testPattern() {
		assertEquals("   ", del("", "   \n   "));
		assertEquals("foobar", del("foo", "\nbar"));
		assertEquals("foo\n   bar", del("foo\n   ", "  \nbar"));
		assertEquals("foo\r\tbar", del("foo\r\t", "\r\nbar"));

		assertEquals("package", del("", "\r\npackage"));
	}

	private String del(String start, String end) {
		final Output bo = getOutput();

		buffer.setLength(0);
		bo.enterStatement(new TextStatement(0, 1, 1, "", false));
		bo.write(start);
		bo.enterStatement(new TextStatement(0, 1, 1, "", true));
		bo.write(end);

		return getBuffer().toString();
	}
}
