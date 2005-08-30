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

import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.SerialFieldTag;
import com.sun.javadoc.Type;


/**
 * Proxy to a FieldDoc
 */

public class FieldDocProxy
	extends MemberDocProxy
	implements FieldDoc {

	public FieldDocProxy(FieldDoc innerFieldDoc) {
		super (innerFieldDoc);
	}
	
	private FieldDoc getInnerFieldDoc() {
		return (FieldDoc)getInnerObject();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.FieldDoc#isTransient()
	 */
	public boolean isTransient() {
		return getInnerFieldDoc().isTransient();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.FieldDoc#isVolatile()
	 */
	public boolean isVolatile() {
		return getInnerFieldDoc().isVolatile();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.FieldDoc#serialFieldTags()
	 */
	public SerialFieldTag[] serialFieldTags() {
		return FACTORY.createSerialFieldTagProxies(getInnerFieldDoc().serialFieldTags());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.FieldDoc#type()
	 */
	public Type type() {
		return (Type)FACTORY.createTypeProxy(getInnerFieldDoc().type());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.FieldDoc#constantValue()
	 */
	public Object constantValue() {
		return getInnerFieldDoc().constantValue();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.FieldDoc#constantValueExpression()
	 */
	public String constantValueExpression() {
		return getInnerFieldDoc().constantValueExpression();
	}

}
