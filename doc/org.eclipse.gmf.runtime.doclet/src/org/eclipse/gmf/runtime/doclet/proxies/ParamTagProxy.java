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

import com.sun.javadoc.ParamTag;


/**
 * Proxy to a ParamTag
 */

public class ParamTagProxy
	extends TagProxy
	implements ParamTag {

	public ParamTagProxy(ParamTag innerParamTag) {
		super (innerParamTag);
	}
	
	private ParamTag getInnerParamTag() {
		return (ParamTag)getInnerObject();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ParamTag#parameterComment()
	 */
	public String parameterComment() {
		return getInnerParamTag().parameterComment();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ParamTag#parameterName()
	 */
	public String parameterName() {
		return getInnerParamTag().parameterName();
	}

}
