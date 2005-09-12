/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.doclet.proxies;

import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.ExecutableMemberDoc;


/**
 * Proxy to a ConstructorDoc
 */
public class ConstructorDocProxy
	extends ExecutableMemberDocProxy
	implements ConstructorDoc {

	public ConstructorDocProxy(ExecutableMemberDoc innerConstructorDoc) {
		super (innerConstructorDoc);
	}
	
	private ConstructorDoc getInnerConstructorDoc() {
		return (ConstructorDoc)getInnerObject();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ProgramElementDoc#qualifiedName()
	 */
	public String qualifiedName() {
		return getInnerConstructorDoc().qualifiedName();
	}
}
