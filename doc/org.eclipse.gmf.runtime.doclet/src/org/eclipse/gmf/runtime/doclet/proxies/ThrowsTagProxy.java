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
import com.sun.javadoc.ThrowsTag;


/**
 * Proxy to a ThrowsTag
 */

public class ThrowsTagProxy
	extends TagProxy
	implements ThrowsTag {

	public ThrowsTagProxy(ThrowsTag innerThrowsTag) {
		super (innerThrowsTag);
	}
	
	private ThrowsTag getInnerThrowsTag() {
		return (ThrowsTag)getInnerObject();
	}


	/* (non-Javadoc)
	 * @see com.sun.javadoc.ThrowsTag#exception()
	 */
	public ClassDoc exception() {
		return FACTORY.createClassDocProxy(getInnerThrowsTag().exception());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ThrowsTag#exceptionComment()
	 */
	public String exceptionComment() {
		return getInnerThrowsTag().exceptionComment();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ThrowsTag#exceptionName()
	 */
	public String exceptionName() {
		return getInnerThrowsTag().exceptionName();
	}
}
