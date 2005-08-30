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



/**
 * Base proxy class. Used to wrap an Standard Doclet object. Derived classes
 * forward calls to the wrapped instance and wrap generally the returned object.
 */

public class Proxy {
	
	protected Object innerObject;
	
	protected static ProxyFactory FACTORY = ProxyFactory.getInstance();
	
	public Proxy(Object innerObject) {
		this.innerObject = innerObject;
	}

	/*package*/ Object getInnerObject() {
		return this.innerObject;
	}

}
