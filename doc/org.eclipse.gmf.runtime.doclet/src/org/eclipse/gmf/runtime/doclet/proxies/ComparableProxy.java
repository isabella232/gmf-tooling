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
