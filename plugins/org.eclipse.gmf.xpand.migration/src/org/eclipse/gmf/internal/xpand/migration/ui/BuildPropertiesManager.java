/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.migration.ui;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.gmf.internal.xpand.migration.Activator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;

public class BuildPropertiesManager {

	private static final String BUILD_PROPERTIES = "build.properties";

	private static final String PROPERTY_JAR_ORDER = "jars.compile.order";

	private static final String DEFAULT_JAR_NAME = ".";

	private static final String DEFAULT_LIBRARY_ENTRY = IBuildEntry.JAR_PREFIX + DEFAULT_JAR_NAME;

	/** Copied from {@link org.eclipse.pde.internal.core.util.PropertiesUtil} */
	private static final char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	private IProject project;

	private List<IFolder> sourceFolders = new ArrayList<IFolder>();

	private List<IResource> binInclude = new ArrayList<IResource>();

	private IFile buildPropertiesFile;

	/** Copied from {@link org.eclipse.pde.internal.core.util.PropertiesUtil} */
	private static String createWritableName(String source) {
		if (source.indexOf(' ') >= 0) {
			// has blanks
			StringBuffer writableName = new StringBuffer();
			for (int i = 0; i < source.length(); i++) {
				char c = source.charAt(i);
				if (c == ' ') {
					writableName.append("\\ "); //$NON-NLS-1$
				} else
					writableName.append(c);
			}
			source = writableName.toString();
		}
		return createEscapedValue(source);
	}

	/** Copied from {@link org.eclipse.pde.internal.core.util.PropertiesUtil} */
	public static String createEscapedValue(String value) {
		// if required, escape property values as \\uXXXX
		StringBuffer buf = new StringBuffer(value.length() * 2);
		// assume expansion by less than factor of 2
		for (int i = 0; i < value.length(); i++) {
			char character = value.charAt(i);
			if (character == '\\' || character == '\t' || character == '\r' || character == '\n' || character == '\f') {
				// handle characters requiring leading \
				buf.append('\\');
				buf.append(character);
			} else if ((character < 0x0020) || (character > 0x007e)) {
				// handle characters outside base range (encoded)
				buf.append('\\');
				buf.append('u');
				buf.append(HEX[(character >> 12) & 0xF]); // first nibble
				buf.append(HEX[(character >> 8) & 0xF]); // second nibble
				buf.append(HEX[(character >> 4) & 0xF]); // third nibble
				buf.append(HEX[character & 0xF]); // fourth nibble
			} else {
				// handle base characters
				buf.append(character);
			}
		}
		return buf.toString();
	}

	/** Copied from {@link org.eclipse.pde.internal.core.util.PropertiesUtil} */
	public static int getInsertOffset(IDocument doc) {
		int offset = doc.getLength();
		for (int i = doc.getNumberOfLines() - 1; i >= 0; i--) {
			try {
				if (doc.get(doc.getLineOffset(i), doc.getLineLength(i)).trim().length() > 0) {
					break;
				}
				offset = doc.getLineOffset(i);
			} catch (BadLocationException e) {
			}
		}
		return offset;
	}

	// TODO: move to the shared static MigrationUtils class
	private static CoreException createCoreException(Throwable th) {
		return new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Exception during migration", th));
	}

	private static CoreException createCoreException(String message) {
		return new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message));
	}

	// TODO: move to the shared static MigrationUtils class
	private static IProgressMonitor createSubProgressMonitor(IProgressMonitor monitor, String taskName, int numberOfTicks) throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException("Process was canceled");
		}
		SubProgressMonitor spm = new SubProgressMonitor(monitor, numberOfTicks);
		if (taskName != null) {
			spm.setTaskName(taskName);
		}
		return spm;
	}

	public BuildPropertiesManager(IProject project) {
		this.project = project;
	}

	public void addSourceFolder(IFolder sourceFolder) {
		sourceFolders.add(sourceFolder);
	}

	public void addBinInclude(IResource resource) {
		binInclude.add(resource);
	}

	public void save(IProgressMonitor monitor) throws CoreException, InterruptedException {
		if (sourceFolders.isEmpty() && binInclude.isEmpty()) {
			monitor.done();
			return;
		}
		monitor.beginTask("Saving modified " + BUILD_PROPERTIES + " file", 6);
		Properties buildProperties = loadBuildProperties();
		monitor.worked(1);
		IDocument document = loadDocument(getBuildPropertiesFile());
		String lf = TextUtilities.getDefaultLineDelimiter(document);
		monitor.worked(1);
		MultiTextEdit edit = new MultiTextEdit();
		addSourceFolders(edit, document, buildProperties, lf);
		monitor.worked(1);
		addBinIncludes(edit, document, buildProperties, lf);
		monitor.worked(1);
		try {
			edit.apply(document);
		} catch (MalformedTreeException e) {
			createCoreException(e);
		} catch (BadLocationException e) {
			createCoreException(e);
		}
		monitor.worked(1);
		saveDocument(document, getBuildPropertiesFile(), createSubProgressMonitor(monitor, "Saving modified " + BUILD_PROPERTIES + " file", 1));
	}

	private void addBinIncludes(MultiTextEdit edit, IDocument document, Properties buildProperties, String lf) throws CoreException {
		List<String> binIncludes = getValues(buildProperties, IBuildEntry.BIN_INCLUDES);
		for (IResource resource : binInclude) {
			IPath projectRelativePath = resource.getProjectRelativePath();
			if (resource instanceof IFolder) {
				projectRelativePath = projectRelativePath.addTrailingSeparator();
			}
			binIncludes.add(projectRelativePath.toString());
		}
		modifyKey(IBuildEntry.BIN_INCLUDES, binIncludes, edit, document, buildProperties, lf);
	}

	private void addSourceFolders(MultiTextEdit edit, IDocument document, Properties buildProperties, String lf) throws CoreException {
		List<String> jarOrderValues = getValues(buildProperties, PROPERTY_JAR_ORDER);
		if (!jarOrderValues.contains(DEFAULT_JAR_NAME)) {
			jarOrderValues.add(DEFAULT_JAR_NAME);
			modifyKey(PROPERTY_JAR_ORDER, jarOrderValues, edit, document, buildProperties, lf);
		}
		List<String> defaultLibraryFolders = getValues(buildProperties, DEFAULT_LIBRARY_ENTRY);
		for (IFolder nextFolder : sourceFolders) {
			defaultLibraryFolders.add(nextFolder.getProjectRelativePath().addTrailingSeparator().toString());
		}
		modifyKey(DEFAULT_LIBRARY_ENTRY, defaultLibraryFolders, edit, document, buildProperties, lf);
	}

	private void modifyKey(String key, List<String> values, MultiTextEdit edit, IDocument document, Properties buildProperties, String lf) throws CoreException {
		String text = serialize(values, key, lf);
		if (buildProperties.containsKey(key)) {
			int offset = getKeyOffset(document, key);
			int length = getKeyLength(document, key, offset);
			edit.addChild(new ReplaceEdit(offset, length, text));
		} else {
			edit.addChild(new InsertEdit(getInsertOffset(document), text));
		}
	}

	/**
	 * Similar to
	 * {@link org.eclipse.pde.internal.core.text.build.Build#adjustOffsets()}
	 */
	private int getKeyLength(IDocument document, String key, int keyOffset) {
		int lines = document.getNumberOfLines();
		try {
			for (int i = 0; i < lines; i++) {
				int offset = document.getLineOffset(i);
				if (offset < keyOffset) {
					continue;
				}
				int length = document.getLineLength(i);
				String line = document.get(offset, length);
				if (line.startsWith("#") | line.startsWith("!")) {
					return offset - 1 - keyOffset;
				}

				line = line.trim();
				if (line.length() == 0) {
					return offset - 1 - keyOffset;
				}
				if (!line.endsWith("\\")) {
					return offset + document.getLineLength(i) - keyOffset;
				}
			}
		} catch (BadLocationException e) {
			// should never be here
		}
		return document.getLength() - keyOffset;
	}

	/**
	 * Similar to
	 * {@link org.eclipse.pde.internal.core.text.build.Build#adjustOffsets()}
	 */
	private int getKeyOffset(IDocument document, String key) throws CoreException {
		try {
			int lines = document.getNumberOfLines();
			for (int i = 0; i < lines; i++) {
				int offset = document.getLineOffset(i);
				int length = document.getLineLength(i);
				String line = document.get(offset, length);
				if (line.startsWith("#") | line.startsWith("!")) {
					continue;
				}
				line = line.trim();
				int index = line.indexOf('=');
				if (index == -1) {
					continue;
				}
				String name = line.substring(0, index).trim();
				if (createEscapedValue(key).equals(name)) {
					while (Character.isSpaceChar(document.getChar(offset))) {
						offset += 1;
					}
					return offset;
				}
			}
		} catch (BadLocationException e) {
			// should never be here
		}
		assert false;
		throw createCoreException("Property: " + key + " was not found in " + BUILD_PROPERTIES + " file");
	}

	/**
	 * Copied from
	 * {@link org.eclipse.pde.internal.core.text.build.BuildEntry#write()}
	 */
	private String serialize(List<String> values, String propertyName, String lf) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(createWritableName(propertyName));
		buffer.append(" = "); //$NON-NLS-1$
		int indentLength = propertyName.length() + 3;
		for (int i = 0; i < values.size(); i++) {
			buffer.append(createEscapedValue(values.get(i)));
			if (i < values.size() - 1) {
				buffer.append(",\\"); //$NON-NLS-1$
				buffer.append(lf);
				for (int j = 0; j < indentLength; j++) {
					buffer.append(" "); //$NON-NLS-1$
				}
			}
		}
		buffer.append(lf);
		return buffer.toString();
	}

	private List<String> getValues(Properties buildProperties, String key) {
		List<String> values = new ArrayList<String>();
		if (!buildProperties.containsKey(key)) {
			return values;
		}
		StringTokenizer stok = new StringTokenizer(buildProperties.getProperty(key).toString(), ","); //$NON-NLS-1$
		while (stok.hasMoreTokens()) {
			values.add(stok.nextToken().trim());
		}
		return values;
	}

	private IDocument loadDocument(IFile file) throws CoreException {
		if (!file.exists()) {
			return new Document();
		}
		try {
			Reader reader = new InputStreamReader(buildPropertiesFile.getContents(), file.getCharset());
			StringBuilder currentLine = new StringBuilder();
			for (char nextChar = (char) reader.read(); nextChar != (char) -1; nextChar = (char) reader.read()) {
				currentLine.append(nextChar);
			}
			return new Document(currentLine.toString());
		} catch (IOException e) {
			throw createCoreException(e);
		}
	}

	private void saveDocument(IDocument document, IFile file, IProgressMonitor monitor) throws CoreException {
		// TODO: check if it works correctly
		String charset = file.exists() ? file.getCharset() : "ISO-8859-1";
		try {
			InputStream inputStream = new ByteArrayInputStream(document.get().getBytes(charset));
			if (buildPropertiesFile.exists()) {
				buildPropertiesFile.setContents(inputStream, IFile.FORCE | IFile.KEEP_HISTORY, monitor);
			} else {
				buildPropertiesFile.create(inputStream, true, monitor);
			}
		} catch (UnsupportedEncodingException e) {
			throw createCoreException(e);
		}
	}

	private Properties loadBuildProperties() throws CoreException {
		Properties result = new Properties();
		if (getBuildPropertiesFile().exists()) {
			try {
				result.load(getBuildPropertiesFile().getContents());
			} catch (IOException e) {
				throw createCoreException(e);
			}
		}
		return result;
	}

	private IFile getBuildPropertiesFile() {
		if (buildPropertiesFile == null) {
			buildPropertiesFile = project.getFile(BUILD_PROPERTIES);
		}
		return buildPropertiesFile;
	}

}
