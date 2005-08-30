/*
 *+------------------------------------------------------------------------+
 *| Licensed Materials - Property of IBM                                   |
 *| (C) Copyright IBM Corp. 2005.  All Rights Reserved.                    |
 *|                                                                        |
 *| US Government Users Restricted Rights - Use, duplication or disclosure |
 *| restricted by GSA ADP Schedule Contract with IBM Corp.                 |
 *+------------------------------------------------------------------------+
 */
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
