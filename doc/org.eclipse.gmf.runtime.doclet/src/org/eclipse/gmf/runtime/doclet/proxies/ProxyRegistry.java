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

import java.util.HashMap;


/**
 * Registry of proxies.
 */
public class ProxyRegistry {

	private HashMap objectToProxyMap;
	
	public ProxyRegistry() {
		this.objectToProxyMap = new HashMap();
	}
	
	public void registerProxy(Object object, Proxy proxy) {
		this.objectToProxyMap.put(object, proxy);
	}
	
	public Proxy getProxyForObject(Object object) {
		return (Proxy)this.objectToProxyMap.get(object);
	}
	
}
