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

import com.sun.javadoc.Parameter;
import com.sun.javadoc.Type;


/**
 * Proxy to a Parameter
 */

public class ParameterProxy
	extends Proxy
	implements Parameter {

	public ParameterProxy(Parameter innerParameter) {
		super (innerParameter);
	}
	
	private Parameter getInnerParameter() {
		return (Parameter)getInnerObject();
	}
	
	/* (non-Javadoc)
	 * @see com.sun.javadoc.Parameter#type()
	 */
	public Type type() {
		return (Type)FACTORY.createTypeProxy(getInnerParameter().type());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Parameter#name()
	 */
	public String name() {
		return getInnerParameter().name();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Parameter#typeName()
	 */
	public String typeName() {
		return getInnerParameter().typeName();
	}

}
