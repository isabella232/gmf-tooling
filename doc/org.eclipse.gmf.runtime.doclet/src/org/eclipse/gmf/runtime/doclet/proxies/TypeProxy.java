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

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Type;


/**
 * Proxy to a Type
 */

public class TypeProxy
	extends Proxy
	implements Type {

	public TypeProxy(Type innerType) {
		super (innerType);
	}
	
	private Type getInnerType() {
		return (Type)getInnerObject();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Type#asClassDoc()
	 */
	public ClassDoc asClassDoc() {
		return FACTORY.createClassDocProxy(getInnerType().asClassDoc());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Type#dimension()
	 */
	public String dimension() {
		return getInnerType().dimension();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Type#qualifiedTypeName()
	 */
	public String qualifiedTypeName() {
		return getInnerType().qualifiedTypeName();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Type#typeName()
	 */
	public String typeName() {
		return getInnerType().typeName();
	}
}
