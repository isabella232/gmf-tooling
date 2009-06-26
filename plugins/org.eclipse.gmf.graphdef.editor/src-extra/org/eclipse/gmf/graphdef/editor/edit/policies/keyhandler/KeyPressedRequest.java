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
package org.eclipse.gmf.graphdef.editor.edit.policies.keyhandler;

import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.requests.LocationRequest;

public class KeyPressedRequest extends LocationRequest {

	private boolean myPerformed;

	private KeyStroke myKeyStroke;

	public KeyPressedRequest(KeyStroke keyStroke) {
		super(keyStroke);
		myKeyStroke = keyStroke;
	}

	public final boolean isPerformed() {
		return myPerformed;
	}

	public void markPerformed() {
		myPerformed = true;
	}

	public KeyStroke getKeyStroke() {
		return myKeyStroke;
	}

}
