package org.eclipse.gmf.releng.generators;

/**********************************************************************
 * Copyright (c) 2002 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v0.5
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v05.html
 * 
 * Contributors: 
 * IBM - Initial API and implementation
 **********************************************************************/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * Utility class to convert buildmanifest.properties files into fetch.xml files.
 */
public class SiteBuilder extends AbstractApplication {

	protected String siteLocation;

	protected String siteXMLLocation;

	protected String buildNumber;

	protected List features;
	
	protected Set excludes;
	
	protected Set includes;


	class FeatureData {
		FeatureData(String id, String version, String os, String ws,
				String arch, String jar) {
			this.jar = jar;
			this.id = id;
			this.version = version;
			this.os = os;
			this.ws = ws;
			this.arch = arch;
		}

		String jar;

		String id;

		String version;

		String os;

		String ws;

		String arch;

	}

	public SiteBuilder() throws Exception {
		features = new ArrayList();
	}

	public static void main(String[] args) throws Exception {
		SiteBuilder builder = new SiteBuilder();
		builder.run(args);
	}

	public void run() {
		try {
			scanFeatures();
			writeSiteXML();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void scanFeatures() throws Exception {
		File root = new File(siteLocation, "features");
		String[] features = root.list();
		if (features == null) {
			System.out.println("Could not find features.");
			return;
		}
		for (int i = 0; i < features.length; i++) {
			File featureFile = new File(root, features[i]);
			String name = featureFile.getName();
			String id;
			if (name.indexOf("_") > 0) {
				id = name.substring(0, name.indexOf("_"));
			} else {
				id = name.trim();
			}

			JarFile featureJar = new JarFile(featureFile);
			ZipEntry featureXml = featureJar.getEntry("feature.xml");
			if (featureXml == null) {
				System.out.println("Could not find descriptor for: "
						+ features[i]);
			} else {
				InputStream featureXmlIs = featureJar.getInputStream(featureXml);
				addFeatureXml(featureXmlIs, id, featureFile);
			}
		}
	}

	private void addFeatureXml(InputStream featureIs, String featureId,
			File featureFile) throws Exception {

		// check if the feature is not listed among features to exclude
		if (excludes.contains(featureId)) {
				System.out.println("INFO: Feature " + featureId + " skipped...");
				return;
		}
		// check if include list is not empty and the feature is there
		if (!includes.isEmpty() && !includes.contains(featureId)) {
			System.out.println("INFO: Feature " + featureId + " skipped...");
			return;
		}
		
		System.out.println("Adding feature " + featureFile.getName());
		
		Document feature = null;
		// load feature.xml
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			feature = builder.parse(featureIs);
		} catch (FactoryConfigurationError e) {
			// unable to get a document builder factory
		} catch (ParserConfigurationException e) {
			// parser was unable to be configured
		} catch (SAXException e) {
			// parsing error
		} catch (IOException e) {
			// i/o error
		}
		if (feature == null) {
			System.out.println(" WARNING: Cannot read feature.xml from the feature "
					+ featureFile.getName());
			return;
		}
		
		Node versionNode = feature.getDocumentElement().getAttributeNode("version");
		String featureVersion = versionNode.getNodeValue();

		features.add(new FeatureData(featureId, featureVersion, null, null, null, featureFile.getName()));
	}

	private StringBuffer readFile(File target) throws IOException {
		FileInputStream fis = new FileInputStream(target);
		InputStreamReader reader = new InputStreamReader(fis);
		StringBuffer result = new StringBuffer();
		char[] buf = new char[4096];
		int count;
		try {
			count = reader.read(buf, 0, buf.length);
			while (count != -1) {
				result.append(buf, 0, count);
				count = reader.read(buf, 0, buf.length);
			}
		} finally {
			try {
				fis.close();
				reader.close();
			} catch (IOException e) {
			}
		}
		return result;
	}

	protected void writeSiteXML() throws Exception {
		StringWriter extraInfo = new StringWriter();
		PrintWriter writer = new PrintWriter(extraInfo);

		StringWriter categoryExtraInfo = new StringWriter();
		PrintWriter categoryWriter = new PrintWriter(categoryExtraInfo);

		try {
			for (Iterator iter = features.iterator(); iter.hasNext();) {
				FeatureData data = (FeatureData) iter.next();
				writer.println();
				writer.print("\t");
				writer.print("<feature url=\"features/");
				writer.print(data.jar);

				// fix for #38154
				writer.print("\" patch=\"");
				writer.print("false");

				writer.print("\" id=\"");
				writer.print(data.id);
				writer.print("\" version=\"");
				writer.print(data.version);

				// add os, ws and arch attributes if they exist
				if (data.os != null) {
					writer.print("\" os=\"");
					writer.print(data.os);
				}
				if (data.ws != null) {
					writer.print("\" ws=\"");
					writer.print(data.ws);
				}
				if (data.arch != null) {
					writer.print("\" arch=\"");
					writer.print(data.arch);
				}
				writer.println("\">");
				writer.print("\t\t");
				writer.print("<category name=\"");
				writer.print(buildNumber);
				writer.println("\"/>");
				writer.print("\t");
				writer.println("</feature>");
			}

			categoryWriter.println();
			categoryWriter.print("\t");
			categoryWriter.print("<category-def label=\"Graphical Modeling Framework ");
			categoryWriter.print(buildNumber);
			categoryWriter.print("\" name=\"");
			categoryWriter.print(buildNumber);
			categoryWriter.println("\">");
			categoryWriter.print("\t\t");
			categoryWriter.println("<description>");
			categoryWriter
					.print("This category contains the various features of the ");
			categoryWriter.print(buildNumber);
			categoryWriter.print(" build of the Graphical Modeling Framework.");
			categoryWriter.print("\t\t");
			categoryWriter.println("</description>");
			categoryWriter.print("\t");
			categoryWriter.println("</category-def>");
			categoryWriter.println();
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}

		// read site.xml
		File originalXML = new File(siteXMLLocation);
		StringBuffer site = readFile(originalXML);
		int pos = scan(site, 0, "<category-def");
		if (pos == -1) {
			pos = scan(site, 0, "</site");
		}
		if (pos == -1) {
			System.out
					.println("Error writing site.xml.  Initial file and new file are both probably invalid");
			pos = 0;
		}

		// Insert features either before the first <category-def or, if there
		// are
		// no category-def, then before the /site.
		site.insert(pos, extraInfo.toString());

		// Insert category-def before the /site
		pos = scan(site, 0, "</site");
		if (pos == -1) {
			System.out
					.println("Error writing site.xml.  Initial file and new file are both probably invalid");
		} else {
			site.insert(pos, categoryExtraInfo.toString());
		}

		File destination = new File(siteLocation, "site.xml");
		FileOutputStream fos = new FileOutputStream(destination);
		try {
			PrintWriter pw = new PrintWriter(fos);
			pw.write(site.toString());
			pw.flush();
			pw.close();
		} finally {
			fos.close();
		}
	}

	private int scan(StringBuffer buf, int start, String target) {
		return scan(buf, start, new String[] { target });
	}

	private int scan(StringBuffer buf, int start, String[] targets) {
		for (int i = start; i < buf.length(); i++) {
			for (int j = 0; j < targets.length; j++) {
				if (i < buf.length() - targets[j].length()) {
					String match = buf.substring(i, i + targets[j].length());
					if (targets[j].equals(match))
						return i;
				}
			}
		}
		return -1;
	}

	protected void processCommandLine(List commands) {
		// looks for param/arg-like commands

		// String used to name the build. Only appears in the Category-def name
		String[] arguments = getArguments(commands, "-build");
		this.buildNumber = arguments[0]; // only consider one location

		// Path to the sites root directory. IE the directory that will contain
		// the
		// plugins and featues directories for the geneated update site.
		arguments = getArguments(commands, "-site");
		this.siteLocation = arguments[0]; // only consider one location

		// Ful path and name of the site.xml file.
		arguments = getArguments(commands, "-sitexml");
		this.siteXMLLocation = arguments[0];
		
		// List of the feature IDs of those features, which may be available, but should NOT be listed in  site.xml
		arguments = getArguments(commands, "-exclude");
		for (int i=0; i<arguments.length; i++) {
			excludes.add(arguments[i].trim());
		}
		
		// List of the feature IDs of those features, which should _only_ be listed in site.xml if exist
		arguments = getArguments(commands, "-include");
		for (int i=0; i<arguments.length; i++) {
			includes.add(arguments[i].trim());
		}

	}

	private String verifyQualifier(String s) {
		char[] chars = s.trim().toCharArray();
		boolean whitespace = false;
		for (int i = 0; i < chars.length; i++) {
			if (!Character.isLetterOrDigit(chars[i])) {
				chars[i] = '-';
				whitespace = true;
			}
		}
		return whitespace ? new String(chars) : s;
	}

}