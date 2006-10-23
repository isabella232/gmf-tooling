/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.tests.xpand;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.core.resources.IFile;
import org.eclipse.gmf.internal.xpand.parser.XpandLexer;
import org.eclipse.gmf.internal.xpand.parser.XpandParser;
import org.eclipse.gmf.internal.xpand.xtend.parser.XtendLexer;
import org.eclipse.gmf.internal.xpand.xtend.parser.XtendParser;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.ast.Template;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExtensionFile;
import org.eclipse.gmf.internal.xpand.xtend.ast.XtendResource;

/**
 * @author artem
 */
public class TestsResourceManager implements ResourceManager {

	public XpandResource loadXpandResource(String fullyQualifiedName) {
		InputStream is = null;
		try {
			is = loadFile(fullyQualifiedName, XpandResource.TEMPLATE_EXTENSION);
			if (is == null) {
				return null;
			}
			return parseXpand(new InputStreamReader(is), fullyQualifiedName);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public XtendResource loadXtendResource(String fullyQualifiedName) {
		InputStream is = null;
		try {
			is = loadFile(fullyQualifiedName, XtendResource.FILE_EXTENSION);
			if (is == null) {
				return null;
			}
			return parseXtend(new InputStreamReader(is), fullyQualifiedName);
		} catch (RuntimeException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new IllegalStateException(ex);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * We use classLoader#getResourceAsStream here and mandate '/resources/' folder to be in classpath
	 * to ease test running and not to require them to be run as 'plug-in' tests. 
	 */
	private InputStream loadFile(String fullyQualifiedName, String fileExt) {
		String resName = fullyQualifiedName.replaceAll(SyntaxConstants.NS_DELIM, "/") + "." + fileExt;
		return getClass().getClassLoader().getResourceAsStream(resName);
	}

	private static Template parseXpand(Reader in, String fileName) {
		try {
			final XpandLexer scanner = new XpandLexer(toCharArray(in), fileName);
			final XpandParser parser = new XpandParser(scanner);
			scanner.lexer(parser);
			return parser.parser();
		} catch (RuntimeException e) {
			throw e;
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static ExtensionFile parseXtend(final Reader in, final String fileName) {
		try {
			final XtendLexer scanner = new XtendLexer(toCharArray(in), fileName);
			final XtendParser parser = new XtendParser(scanner);
			scanner.lexer(parser);
			return parser.parser();
		} catch (RuntimeException e) {
			throw e;
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static char[] toCharArray(Reader in) throws IOException {
		CharArrayWriter res = new CharArrayWriter(4096);
		char[] bb = new char[1024];
		int read;
		while ((read = in.read(bb)) != -1) {
			res.write(bb, 0, read);
		}
		return res.toCharArray();
	}

	public void forget(IFile resource) {
		throw new UnsupportedOperationException();
	}

	public XpandResource loadXpandResource(IFile file) {
		throw new UnsupportedOperationException();
	}

	public XtendResource loadXtendResource(IFile file) {
		throw new UnsupportedOperationException();
	}
}
