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
