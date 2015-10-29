/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.gmf.tooling.codegen.launcher.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.internal.common.codegen.CodeFormatterFactory;
import org.eclipse.gmf.tooling.codegen.launcher.Activator;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * org.eclipse.jdt.internal.ui.preferences.formatter.ProfileStore
 */
public class SerializedCodeFormatterFactory implements CodeFormatterFactory {

	private final String myCodeFormatterPath;

	public SerializedCodeFormatterFactory(String codeFormatterPath) {
		myCodeFormatterPath = codeFormatterPath;
	}

	@Override
	public CodeFormatter createCodeFormatter() {
		File formatter = new File(myCodeFormatterPath);
		Map<String, String> options;
		Collection<SerializedCodeFormatterFactory.Profile> profiles = null;
		try {
			profiles = readProfilesFromFile(formatter);
			options = profiles.iterator().next().getSettings();
		} catch (CoreException e) {
			throw new RuntimeException("Error has occured while loading formatter. "
					+ "Formatter file path: " + myCodeFormatterPath);
		}
		return ToolFactory.createCodeFormatter(options);
	}

	public List<Profile> readProfilesFromFile(File file) throws CoreException {
		try {
			final FileInputStream reader = new FileInputStream(file);
			try {
				return readProfilesFromStream(new InputSource(reader));
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		} catch (IOException e) {
			throw createException(e.getMessage());
		}
	}

	public static List<Profile> readProfilesFromStream(InputSource inputSource) throws CoreException {

		final ProfileDefaultHandler handler = new ProfileDefaultHandler();
		try {
			final SAXParserFactory factory = SAXParserFactory.newInstance();
			final SAXParser parser = factory.newSAXParser();
			parser.parse(inputSource, handler);
		} catch (SAXException e) {
			throw createException(e.getMessage());
		} catch (IOException e) {
			throw createException(e.getMessage());
		} catch (ParserConfigurationException e) {
			throw createException(e.getMessage());
		}
		return handler.getProfiles();
	}

	private static CoreException createException(String message) {
		return new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message));
	}

	public final static class Profile {

		private final String myName;

		private final Map<String, String> mySettings;

		private final int myVersion;

		private final String myKind;

		public Profile(String name, int version, String kind, Map<String, String> settings) {
			myName = name;
			mySettings = settings;
			myVersion = version;
			myKind = kind;
		}

		public Map<String, String> getSettings() {
			return mySettings;
		}

		public String getName() {
			return myName;
		}

		public int getVerstion() {
			return myVersion;
		}

		public String getKind() {
			return myKind;
		}
	}

	private final static class ProfileDefaultHandler extends DefaultHandler {

		private final static String XML_NODE_ROOT = "profiles";
		private final static String XML_NODE_PROFILE = "profile";
		private final static String XML_NODE_SETTING = "setting";

		private final static String XML_ATTRIBUTE_VERSION = "version";
		private final static String XML_ATTRIBUTE_ID = "id";
		private final static String XML_ATTRIBUTE_NAME = "name";
		private final static String XML_ATTRIBUTE_PROFILE_KIND = "kind";
		private final static String XML_ATTRIBUTE_VALUE = "value";


		private List<Profile> fProfiles;
		private int fVersion;

		private String fName;
		private Map<String, String> fSettings;
		private String fKind;

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

			if (qName.equals(XML_NODE_SETTING)) {

				final String key = attributes.getValue(XML_ATTRIBUTE_ID);
				final String value = attributes.getValue(XML_ATTRIBUTE_VALUE);
				fSettings.put(key, value);

			} else if (qName.equals(XML_NODE_PROFILE)) {

				fName = attributes.getValue(XML_ATTRIBUTE_NAME);
				fKind = attributes.getValue(XML_ATTRIBUTE_PROFILE_KIND);

				fSettings = new HashMap<String, String>(200);

			} else if (qName.equals(XML_NODE_ROOT)) {

				fProfiles = new ArrayList<Profile>();
				try {
					fVersion = Integer.parseInt(attributes.getValue(XML_ATTRIBUTE_VERSION));
				} catch (NumberFormatException ex) {
					throw new SAXException(ex);
				}

			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) {
			if (qName.equals(XML_NODE_PROFILE)) {
				fProfiles.add(new Profile(fName, fVersion, fKind, fSettings));
				fName = null;
				fSettings = null;
				fKind = null;
			}
		}

		public List<Profile> getProfiles() {
			return fProfiles;
		}

	}
}
