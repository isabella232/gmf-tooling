/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.xpand.migration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;

public class CFileImpl implements CFile {

	private static final String QVTO_EXTENSION = ".qvto";

	private String name;

	private byte[] bytes;

	public CFileImpl(String name, String contents) throws UnsupportedEncodingException {
		this.name = name;
		this.bytes = contents.getBytes(getCharset());
	}

	public void create(InputStream contents) throws IOException {
		throw new UnsupportedOperationException("TODO");
	}

	public String getCharset() {
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
		return QVTO_EXTENSION;
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
