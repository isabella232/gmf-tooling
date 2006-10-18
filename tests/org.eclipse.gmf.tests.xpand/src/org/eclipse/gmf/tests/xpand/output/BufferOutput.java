/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.tests.xpand.output;

import org.eclipse.gmf.internal.xpand.ast.TextStatement;
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.gmf.internal.xpand.model.Output;

/**
 * @author artem
 */
public class BufferOutput implements Output {

	private final StringBuilder buffer;
	private boolean deleteLine = false;

	public BufferOutput(StringBuilder buffer) {
		assert buffer != null;
		this.buffer = buffer;
	}
	
	public void closeFile() {
		System.err.println("<<<CLOSE FILE");
		throw new UnsupportedOperationException();
	}

	public void openFile(String path, String fileMode) {
		System.err.println(">>>OPEN FILE");
		throw new UnsupportedOperationException();
	}

	public void enterStatement(SyntaxElement stmt) {
        if (stmt instanceof TextStatement) {
            deleteLine = ((TextStatement) stmt).isDeleteLine();
        }
	}

	public void exitStatement(SyntaxElement stmt) {
		deleteLine = false;
	}

	public void write(String text) {
		if (deleteLine) {
			int i = 0;
			while (i < text.length()) {
				char charAt = text.charAt(i);
				if (Character.isWhitespace(charAt)) {
					if (charAt == '\r' || charAt == '\n') {
						char nextToLF = text.charAt(++i);
						if (nextToLF != charAt && (nextToLF == '\n' || nextToLF == '\r')) {
							i++;
						}
						break;
					}
				}
				i++;
			}
			buffer.append(text.substring(i));
			deleteLine = false;
		} else {
			buffer.append(text);
		}
	}

}
