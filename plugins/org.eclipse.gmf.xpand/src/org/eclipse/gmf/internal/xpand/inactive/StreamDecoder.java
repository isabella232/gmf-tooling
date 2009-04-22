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

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import org.eclipse.gmf.internal.xpand.Activator;

/**
 * FIXME tests!!! (especially that C2AB and C2BB without BOM give UTF8)
 * @author artem
 */
public class StreamDecoder {

	public static final Charset LEGACY_ENCODING = Charset.forName("ISO-8859-1"); //$NON-NLS-1$

	private final InputStream myInputStream;
	private final Charset myDefaultEncoding;
	private Reader myResult;
	private Charset myEncoding;

	/**
	 * @param is can't be null
	 * @param defaultEncoding may be null
	 */
	public StreamDecoder(InputStream is, Charset defaultEncoding) {
		assert is != null;
		myInputStream = ensureMarkSupported(is);
		myDefaultEncoding = defaultEncoding;
	}

	public Reader getReader() {
		if (myResult == null) {
			myResult = createReader(myInputStream, getEncoding());
		}
		return myResult;
	}

	/**
	 * @return defaultEncoding, if can't detect
	 */
	public Charset getEncoding() {
		if (myEncoding == null) {
			myEncoding = detectEncoding(myInputStream);
		}
		return myEncoding;
	}

	// is passed supports marks
	protected Charset detectEncoding(InputStream is) {
		assert is.markSupported();
		final int markLimit = 1024;
		is.mark(markLimit); // pure guess, most templates, even those with EPL comment header, got smth that far  
		try {
			int b1 = is.read();
			int b2 = is.read();
			if (b1 == -1 || b2 == -1) {
				return myDefaultEncoding;
			}
			if (b1 == 0xFE && b2 == 0xFF) {
				return Charset.forName("UTF-16BE");
			}
			if (b1 == 0xFF && b2 == 0xFE) {
				return Charset.forName("UTF-16LE");
			}
			int b3 = is.read();
			if (b3 == -1) {
				return myDefaultEncoding;
			}
			if (b1 == 0xEF && b2 == 0xBB && b3 == 0xBF) {
				return Charset.forName("UTF-8");
			}
			is.reset(); // all over again
			boolean foundC2, foundAB, foundBB, foundC2AB, foundC2BB;
			foundC2 = foundAB = foundBB = foundC2AB = foundC2BB = false;
			for (int i = markLimit; i > 0; i--) {
				int b = is.read();
				if (b == -1) {
					break;
				}
				if (!foundAB && !foundC2AB) {
					foundAB = b == 0xAB;
					foundC2AB = foundC2 && foundAB;
				}
				if (!foundBB && !foundC2BB) {
					foundBB = b == 0xBB;
					foundC2BB = foundC2 && foundBB;
				}
				foundC2 = b == 0xC2; // keeps knowledge whether current byte is C2 for the next iteration
			}
			if (foundC2AB && foundC2BB) {
				return Charset.forName("UTF-8");
			}
			if (foundAB && foundBB) {
				return LEGACY_ENCODING;
			}
		} catch (IOException ex) {
			// IGNORE
		} finally {
			try {
				is.reset();
			} catch (IOException ex) {
				// XXX actually, should avoid using Activator as it may trigger plugin initialization
				// but as long as it can barely happen here...
				Activator.logError(ex);
			}
		}
		return myDefaultEncoding;
	}

	protected Reader createReader(InputStream is, Charset encoding) {
		return encoding != null ? new InputStreamReader(is, encoding) : new InputStreamReader(is);
	}

	/**
	 * @return same or wrapped input stream that has {@link InputStream#markSupported()} == true
	 */
	public static InputStream ensureMarkSupported(InputStream is) {
		return is.markSupported() ? is : new BufferedInputStream(is);
	}
//	public static Reader ensureMarkSupported(Reader r) {
//		return r.markSupported() ? r : new BufferedReader(r);
//	}
}
