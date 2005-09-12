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

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.SerialFieldTag;


/**
 * Proxy to a SerialFieldTag
 */

public class SerialFieldTagProxy
	extends TagProxy
	implements SerialFieldTag {

	private Comparable comparable;
	
	public SerialFieldTagProxy(SerialFieldTag innerSerialFieldTag) {
		super (innerSerialFieldTag);
		this.comparable = new ComparableProxy(innerSerialFieldTag);
	}
	
	private SerialFieldTag getInnerSerialFieldTag() {
		return (SerialFieldTag)getInnerObject();
	}
	
	private Comparable getComparable() {
		return comparable;
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.SerialFieldTag#fieldTypeDoc()
	 */
	public ClassDoc fieldTypeDoc() {
		return FACTORY.createClassDocProxy(getInnerSerialFieldTag().fieldType());
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0) {
		return getComparable().compareTo(arg0);
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.SerialFieldTag#description()
	 */
	public String description() {
		return getInnerSerialFieldTag().description();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.SerialFieldTag#fieldName()
	 */
	public String fieldName() {
		return getInnerSerialFieldTag().fieldName();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.SerialFieldTag#fieldType()
	 */
	public String fieldType() {
		return getInnerSerialFieldTag().fieldType();
	}
}
