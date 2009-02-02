/*
 * Copyright (c) 2008, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.ant;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class InputSupport {

	private static final String SCHEMA_LOCATION = "schemaLocation";

	private static final String XSI_URI = "http://www.w3.org/2001/XMLSchema-instance";

	private static final String SCHEMA_LOCATION_ATTRIB = "xsi:" + SCHEMA_LOCATION;

	private URI myInputURI;
	private Object myInputObject;
	private ResourceSet myResourceSet;
	private InputSupport myChain;
	private Map<String, URI> mySchemaLocations;
	
	public InputSupport(ResourceSet resourceSet) {
		myResourceSet = resourceSet;
	}

	public void setBareInput(String input) {
		myInputObject = input;
	}

	public void setURI(URI uri) {
		myInputURI = uri;
	}

	protected ResourceSet getResourceSet() {
		if (myResourceSet == null) {
			myResourceSet = new ResourceSetImpl();
			myResourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
		}
		return myResourceSet;
	}

	public Object getTarget() {
		if (myInputURI != null) {
			return getResourceSet().getEObject(myInputURI, true);
		}
		if (myInputObject != null) {
			return myInputObject;
		}
		if (myChain != null) {
			return myChain.getTarget();
		}
		return null;
	}

	public void chain(InputSupport input) {
		myChain = input;
	}
	
	public Map<String, URI> getInputSchemaLocations() {
		if (myChain != null) {
			return myChain.getInputSchemaLocations();
		}
		if (mySchemaLocations == null) {
			mySchemaLocations = myInputURI != null ? loadSchemaLocations() : Collections.<String, URI> emptyMap();
		}
		return mySchemaLocations;
	}
	
	/**
	 * Should be called only if myInputURI != null
	 */
	private Map<String, URI> loadSchemaLocations() {
		final Map<String, URI> result = new HashMap<String, URI>();
		try {
			InputSource inputSource = new InputSource(myResourceSet.getURIConverter().createInputStream(myInputURI));
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			DefaultHandler handler = new DefaultHandler() {

				private boolean isRootElement = true;

				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					if (!isRootElement) {
						throw new SAXException("End of parsing");
					}
					isRootElement = false;
					String schemaLocations = attributes.getValue(XSI_URI, SCHEMA_LOCATION);
					if (schemaLocations == null) {
						schemaLocations = attributes.getValue(SCHEMA_LOCATION_ATTRIB);
					}
					if (schemaLocations != null) {
						for (StringTokenizer stringTokenizer = new StringTokenizer(schemaLocations, " "); stringTokenizer.hasMoreTokens();) {
							String key = stringTokenizer.nextToken();
							if (stringTokenizer.hasMoreTokens()) {
								String value = stringTokenizer.nextToken();
								URI metamodelURI = URI.createURI(value);
								if (metamodelURI.isRelative() && metamodelURI.hasRelativePath()) {
									metamodelURI = metamodelURI.resolve(myInputURI);
								}
								result.put(key, metamodelURI);
							}
						}
					}
				}
			};
			parser.parse(inputSource, handler);
		} catch (IOException e) {
			// ignoring
		} catch (ParserConfigurationException e) {
			// ignoring
		} catch (SAXException e) {
			// ignoring
		}
		return result;
	}

}
