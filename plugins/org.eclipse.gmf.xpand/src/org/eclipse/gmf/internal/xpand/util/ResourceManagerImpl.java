/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Artem Tikhomirov (Borland)
 *     Boris Blajer (Borland) - support for composite resources
 */
package org.eclipse.gmf.internal.xpand.util;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.gmf.internal.xpand.Activator;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtFile;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtResource;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;

// FIXME it's not a good idea to parse file on every proposal computation
public abstract class ResourceManagerImpl implements ResourceManager {

	private final class InputStreadCFile implements CFile {

		private byte[] bytes;

		private String name;

		public InputStreadCFile(Reader reader, String name) throws IOException {
			StringWriter sw = new StringWriter();
			for (int ch = reader.read(); ch != -1; ch = reader.read()) {
				sw.write(ch);
			}
			bytes = sw.toString().getBytes(getCharset());
			this.name = name;
		}

		public void create(InputStream contents) throws IOException {
			throw new UnsupportedOperationException("TODO");
		}

		public String getCharset() throws IOException {
			return "UTF-8";
		}

		public InputStream getContents() throws IOException {
			return new ByteArrayInputStream(bytes);
		}

		public CFolder getParent() {
			return null;
		}

		public long getTimeStamp() {
			return -1;
		}

		public String getUnitName() {
			return name;
		}

		public void setContents(InputStream contents) throws IOException {
			throw new UnsupportedOperationException("TODO");
		}

		public void delete() throws IOException {
			throw new UnsupportedOperationException("TODO");
		}

		public boolean exists() {
			return true;
		}

		public String getExtension() {
			return QvtResource.FILE_EXTENSION;
		}

		public IFileStore getFileStore() throws IOException {
			throw new UnsupportedOperationException("TODO");
		}

		public String getFullPath() {
			return name;
		}

		public String getName() {
			return name;
		}

		public void refresh() throws IOException {
		}
	}
	
	// TODO: implement this import resolved to use resolveMultiple() method
	private final class ImportResolverImpl implements IImportResolver {

		public String getPackageName(CFolder folder) {
			// TODO Auto-generated method stub
			return null;
		}

		public CFile resolveImport(String importedUnitName) {
			// TODO Auto-generated method stub
			return null;
		}

		public CFile resolveImport(CFile parentFile, String importedUnitName) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	private final Map<String, XpandResource> cachedXpand = new TreeMap<String, XpandResource>();
	private final Map<String, QvtResource> cachedQvt = new TreeMap<String, QvtResource>();

	public QvtResource loadQvtResource(String fullyQualifiedName) {
		try {
			return loadQvtResourceThroughCache(fullyQualifiedName);
		} catch (FileNotFoundException ex) {
			return null; // Missing resource is an anticipated situation, not a
			// error that should be handled
		} catch (IOException e) {
			Activator.logError(e);
		} catch (ParserException e) {
			// TODO: check if any exceptions present here at all..
			handleParserException(e);
		}
		return null;
	}

	protected QvtResource loadQvtResourceThroughCache(String qualifiedName) throws IOException, ParserException {
		if (hasCachedQvt(qualifiedName)) {
			return cachedQvt.get(qualifiedName);
		}
		final QvtResource loaded = doLoadQvtResource(qualifiedName);
		assert loaded != null; // this is the contract of loadXtendResource
		if (shouldCache()) {
			cachedQvt.put(qualifiedName, loaded);
		}
		return loaded;
	}

	private QvtResource doLoadQvtResource(String fullyQualifiedName) throws IOException, ParserException {
		Reader[] readers = resolveMultiple(fullyQualifiedName, QvtResource.FILE_EXTENSION);
		assert readers.length == 1;
		CFile cFile = new InputStreadCFile(readers[0], fullyQualifiedName);
		// TODO: use different kind of ImportResolver being able to construct
		// referenced CFiles using ResourceManagerImpl
		QvtCompiler qvtCompiler = new QvtCompiler(new ImportResolverImpl());
		QvtCompilerOptions options = new QvtCompilerOptions();
		options.setGenerateCompletionData(false);
		options.setShowAnnotations(false);
		try {
			CompiledModule module = qvtCompiler.compile(cFile, options, null).getModule();
//			assert module.getModule() instanceof Library;
			return new QvtFile(module, fullyQualifiedName);	
		} catch (MdaException e) {
			throw new ParserException(fullyQualifiedName, new ParserException.ErrorLocationInfo(e.toString()));
		}
	}

	public XpandResource loadXpandResource(String fullyQualifiedName) {
		try {
			return loadXpandThroughCache(fullyQualifiedName);
		} catch (FileNotFoundException ex) {
			return null;	//Missing resource is an anticipated situation, not a error that should be handled
		} catch (IOException ex) {
			// XXX come up with better handling
			Activator.logWarn(ex.getMessage());
		} catch (ParserException ex) {
			handleParserException(ex);
		}
		return null;
	}

	protected XpandResource loadXpandThroughCache(String qualifiedName) throws IOException, ParserException {
		if (hasCachedXpand(qualifiedName)) {
			return cachedXpand.get(qualifiedName);
		}
		final XpandResource loaded = doLoadXpandResource(qualifiedName);
		if (shouldCache()) {
			cachedXpand.put(qualifiedName, loaded);
		}
		return loaded;
	}

	private XpandResource doLoadXpandResource(String fullyQualifiedName) throws IOException, ParserException {
		Reader[] rs1 = resolveMultiple(fullyQualifiedName, XpandResource.TEMPLATE_EXTENSION);
		assert rs1 != null && rs1.length > 0; // exception should be thrown to indicate issues with resolve
		XpandResource[] unadvised = loadXpandResources(rs1, fullyQualifiedName);
		XpandResource[] advices = null;
		try {
	    	String aspectsTemplateName = getAspectsTemplateName(fullyQualifiedName);
	    	Reader[] rs2 = resolveMultiple(aspectsTemplateName, XpandResource.TEMPLATE_EXTENSION);
	    	// XXX relax resolveMultiple to return empty array and use length==0 here instead of exception
	    	advices = loadXpandResources(rs2, aspectsTemplateName);
		} catch (FileNotFoundException e) {
		} catch (IOException ex) {
			// XXX come up with better handling
			Activator.logWarn(ex.getMessage());
		} catch (ParserException ex) {
			handleParserException(ex);
		}
		if (advices == null && unadvised.length == 1) {
			return unadvised[0];
		}
		return new CompositeXpandResource(this, unadvised, advices);
	}

	/**
	 * XXX: only to simplify tests, should be private or inlined
	 */
	protected String getAspectsTemplateName(String fullyQualifiedName) {
		return ASPECT_PREFIX + fullyQualifiedName;
	}

	/**
	 * If the given fully-qualified name is an aspect, transforms it to its "host" fully-qualified name. Otherwise,
	 * returns the given fully-qualified name.
	 */
	protected String getNonAspectsTemplateName(String possiblyAspectedFullyQualifiedName) {
		if (possiblyAspectedFullyQualifiedName == null) {
			return null;
		}
		if (possiblyAspectedFullyQualifiedName.startsWith(ASPECT_PREFIX)) {
			return possiblyAspectedFullyQualifiedName.substring(ASPECT_PREFIX.length());
		}
		return possiblyAspectedFullyQualifiedName;
	}

	protected abstract void handleParserException(ParserException ex);

	/**
	 * Returns an array of resolutions, in the order from newest to oldest. 
	 * This is to enable one template to partially override only a subset of parent templates.
	 *  
	 * @return never return <code>null</code> or an empty array, throw exception instead
	 * @throws IOException in case resource can't be read. Throw {@link java.io.FileNotFoundException} to indicate resource was not found. 
	 */
	protected abstract Reader[] resolveMultiple(String fullyQualifiedName, String extension) throws IOException;

	/**
	 * Readers get closed after parse attempt.
	 */
	protected XpandResource[] loadXpandResources(Reader[] readers, String fullyQualifiedName) throws IOException, ParserException {
		XpandResource[] result = new XpandResource[readers.length];
		for (int i = 0; i < readers.length; i++) {
			assert readers[i] != null;
			try {
				result[i] = new XpandResourceParser().parse(readers[i], fullyQualifiedName);
				assert result[i] != null; // this is the contract of parse
			} finally {
				try {
					readers[i].close();
				} catch (Exception ex) {/*IGNORE*/}
			}
		}
		return result;
	}

	protected abstract boolean shouldCache();

	protected final boolean hasCachedXpand(String fullyQualifiedName) {
		return shouldCache() && cachedXpand.containsKey(fullyQualifiedName);
	}
	protected final boolean hasCachedQvt(String fullyQualifiedName) {
		return shouldCache() && cachedQvt.containsKey(fullyQualifiedName);
	}

	protected final void forgetCachedXpand(String fullyQualifiedName) {
		cachedXpand.remove(fullyQualifiedName);
	}

	protected final void forgetCachedQvt(String fullyQualifiedName) {
		cachedQvt.remove(fullyQualifiedName);
	}

	protected final void forgetAll() {
		cachedXpand.clear();
		cachedQvt.clear();
	}

	private static final String ASPECT_PREFIX = "aspects" + TypeNameUtil.NS_DELIM;	//$NON-NLS-1$
}
