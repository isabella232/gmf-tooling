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
package org.eclipse.gmf.internal.xpand.ant;

import org.apache.tools.ant.BuildException;
import org.eclipse.emf.common.util.URI;

public class Metamodel {

	private String myNsUri;

	private URI myLocation;

	public void setNsUri(String nsUri) {
		myNsUri = nsUri;
	}

	public String getNsUri() {
		return myNsUri;
	}

	public void setLocation(String location) {
		try {
			myLocation = URI.createURI(location);
		} catch (IllegalArgumentException ex) {
			throw new BuildException(ex);
		}
	}

	public URI getLocation() {
		return myLocation;
	}

}
