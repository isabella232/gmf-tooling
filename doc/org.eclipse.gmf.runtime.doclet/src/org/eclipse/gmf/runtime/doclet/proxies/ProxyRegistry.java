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
