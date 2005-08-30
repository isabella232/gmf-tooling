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
 * Utility to deal with proxies
 */
public class ProxyUtil {
	
	public static Object getInnerObject(Object possibleProxy) {
		if (possibleProxy instanceof Proxy) {
			possibleProxy = ((Proxy)possibleProxy).getInnerObject();
		}
		return possibleProxy;
	}
}
