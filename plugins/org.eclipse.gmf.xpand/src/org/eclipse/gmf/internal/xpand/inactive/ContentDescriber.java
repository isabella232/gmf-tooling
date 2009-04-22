/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.inactive;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.ITextContentDescriber;

/**
 * Major difference from platform's default content describer (which uses BOM) is that we
 * supply ISO-8859-1 encoding for legacy template files (those with 0xAB and 0xBB), but keep
 * exposing UTF-8 as our default encoding. Besides, we do recognize UTF-8 encoding even if
 * there's no BOM in the file (looking for 0xC2 0xAB and 0xC2 0xBB sequences)
 * 
 * Another important aspect of this detector is that it is confident (i.e. VALID) about GMF-Xpand 
 * content type when there's no IMPORT statement in the template that looks like OAW Xpand. 
 * @author artem
 */
public class ContentDescriber implements ITextContentDescriber {
	private final Pattern myImportClause;
	
	public ContentDescriber() {
		myImportClause = Pattern.compile("IMPORT\\s+");
	}
	
	public int describe(Reader contents, IContentDescription description) throws IOException {
		// no idea what I can tell here, but if I do not implement ITextContentDescriber, attempt to save
		// existing! UTF-8 xpt file under template folder with ISO encoding results in error "can't convert UTF to ISO"
		// - for some stupid reason Eclipse TextEditor tries to come up with new encoding for existing file
		final char[] lookahead = new char[1024];
		int count = contents.read(lookahead);
		if (count == 0 || count == -1) {
			return INDETERMINATE;
		}
		return checkSpecificToGMF(CharBuffer.wrap(lookahead, 0, count));
	}

	public int describe(InputStream contents, IContentDescription description) throws IOException {
		contents = StreamDecoder.ensureMarkSupported(contents);
		int check = INDETERMINATE;
		try {
			final char[] lookahead = new char[1024];
			contents.mark(lookahead.length + 1);
			// use US-ASCII as keywords we are looking for got codes < 127
			int count = new InputStreamReader(contents, Charset.forName("US-ASCII")).read(lookahead); //$NON-NLS-1$
			if (count == 0 || count == -1) {
				return INDETERMINATE;
			}
			check = checkSpecificToGMF(CharBuffer.wrap(lookahead, 0, count));
			if (check == INVALID) {
				return INVALID;
			}
		} finally {
			contents.reset();
		}
		StreamDecoder sd = new StreamDecoder(contents, null);
		if (sd.getEncoding() == null) {
			return check;
		}
		if (description != null) {
			description.setProperty(IContentDescription.CHARSET, sd.getEncoding().name());
		}
		// XXX alternatively, may return 'check' result, but which content type
		// would get assigned to empty (just created) files then?
		return VALID;
	}

	public QualifiedName[] getSupportedOptions() {
		return null; // none
	}

	// uses INVALID, VALID and INDETERMINATE constants to indicate
	// whether template is "definitely not GMF's", "definitely GMF's" and "can't tell" respectively 
	private int checkSpecificToGMF(CharSequence s) throws IOException {
		Matcher m = myImportClause.matcher(s);
		if (m.find()) {
			if (m.hitEnd() || m.end() >= s.length()) {
				return INDETERMINATE; // found IMPORT, but can't tell what's after that
			}
			char firstNonSpace = s.charAt(m.end());
			return firstNonSpace == '"' || firstNonSpace == '\'' ? VALID : INVALID;
		}
		return INDETERMINATE;
	}
}
