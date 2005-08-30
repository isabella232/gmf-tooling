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
 * Proxy to a Comparable
 */
public class ComparableProxy extends Proxy
	implements Comparable {

	public ComparableProxy(Comparable innerComparable) {
		super (innerComparable);
	}
	
	private Comparable getInnerComparable() {
		return (Comparable)getInnerObject();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		if (o instanceof Proxy) {
			o = ((Proxy)o).getInnerObject();
		}
		return getInnerComparable().compareTo(o);
	}

}
