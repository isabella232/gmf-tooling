/*
 * Copyright (c) 2006, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.gmf.tests.xpand;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collections;

import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.util.BundleUnitResolver;
import org.eclipse.gmf.internal.xpand.util.ParserException;
import org.eclipse.gmf.internal.xpand.util.ResourceManagerImpl;
import org.eclipse.gmf.internal.xpand.util.TypeNameUtil;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;

/**
 * @author artem
 */
public class TestsResourceManager extends ResourceManagerImpl implements ResourceManager {

	/**
	 * We use classLoader#getResourceAsStream here and mandate '/resources/' folder to be in classpath
	 * to ease test running and not to require them to be run as 'plug-in' tests. 
	 */
	private InputStream loadFile(String fullyQualifiedName, String fileExt) {
		String resName = fullyQualifiedName.replaceAll(TypeNameUtil.NS_DELIM, "/") + "." + fileExt;
		return getClass().getClassLoader().getResourceAsStream(resName);
	}

	protected void handleParserException(ParserException ex) {
		ex.printStackTrace();
	}

	protected Reader[] resolveMultiple(String fullyQualifiedName, String extension) throws IOException {
		InputStream inputStream = loadFile(fullyQualifiedName, extension);
		if (inputStream == null) {
			throw new FileNotFoundException(fullyQualifiedName);
		}
		return new Reader[] { new InputStreamReader(inputStream, Charset.forName("UTF-8")) };
	}

	@Override
	protected boolean shouldCache() {
		return false;
	}
	
	@Override
	protected String resolveCFileFullPath(String fullyQualifiedName, String fileExtension) {
		return fullyQualifiedName + "." + fileExtension;
	}

	@Override
	protected UnitResolver getQVTUnitResolver() {
		URL resource = getClass().getClassLoader().getResource("."); 
		return BundleUnitResolver.createResolver(Collections.singletonList(resource), true); 
	}
}
