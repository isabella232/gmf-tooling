/*
 * Copyright (c) 2006, 2009 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.gmf.internal.xpand.Activator;
import org.eclipse.gmf.internal.xpand.inactive.StreamDecoder;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.BundleUnitResolver;

/**
 * Node: no support for relative paths (i.e. '..::templates::SomeTemplate.xpt')
 * @author artem
 */
public class BundleResourceManager extends ResourceManagerImpl {
	private final URL[] paths;

	public BundleResourceManager(URL... paths) {
		assert paths != null && paths.length > 0; 
		this.paths = new URL[paths.length];
		for (int i = 0; i < paths.length; i++) {
			this.paths[i] = fixTrailingSlash(paths[i]);
		}
	}

	/**
	 * new URL("base:url/path1/withoutTrailingSlash", "path2/noLeadingSlash")
	 * results in "base:url/path/path2/noLeadingSlash" - note lost "withoutTrailingSlash" part
	 * XXX Perhaps, would be better for clients do this 'normalization'?
	 */
	private static URL fixTrailingSlash(URL u) {
		try {
			if (u.getPath() != null && !u.getPath().endsWith("/")) {
				return new URL(u, u.getPath() + '/');
			}
		} catch (MalformedURLException ex) {
			/*IGNORE*/
		}
		return u;
	}

	@Override
	protected boolean shouldCache() {
		return true;
	}

	@Override
	protected void handleParserException(ParserException ex) {
		throw new EvaluationException(ex.toString());
	}

	private Reader createReader(String urlPath, URL baseUrl) throws MalformedURLException, IOException {
		URL u = new URL(baseUrl, urlPath);
		InputStream is = u.openStream();
		// XXX here we ignore the fact baseUrl may point to workspace location
		// and hence charset can be derived from IFile
		// FIXME for now, go with legacy encoding as a default
		return new StreamDecoder(is, StreamDecoder.LEGACY_ENCODING).getReader();
	}

	@Override
	protected Reader[] resolveMultiple(String fullyQualifiedName, String extension) throws IOException {
		final String urlPath = fullyQualifiedName.replaceAll(TypeNameUtil.NS_DELIM, "/") + '.' + extension;
		ArrayList<Reader> result = new ArrayList<Reader>(paths.length);
		for (int i = 0; i < paths.length; i++) {
			try {
				result.add(createReader(urlPath, paths[i]));
			} catch (MalformedURLException ex) {
				/*IGNORE*/
			} catch (IOException ex) {
				// XXX perhaps, conditionally turn logging on to debug template loading issues?
				/*IGNORE*/
			} catch (Exception ex) {
				// just in case
				Activator.logError(ex);
			}
		}
		if (result.isEmpty()) {
			throw new FileNotFoundException(fullyQualifiedName);
		}
		return result.toArray(new Reader[result.size()]);
	}

	@Override
	protected String resolveCFileFullPath(String fullyQualifiedName, String extension) {
		final String urlPath = fullyQualifiedName.replaceAll(TypeNameUtil.NS_DELIM, "/") + '.' + extension;
		if (paths.length > 0) {
			try {
				return new URL(paths[0], urlPath).toString();
			} catch (MalformedURLException e) {
				/* IGNORE */
			}
		}
		return fullyQualifiedName + "." + extension;
	}
	
	@Override
	protected UnitResolver getQVTUnitResolver() {
		return BundleUnitResolver.createResolver(Arrays.asList(paths), true);
	}
}
