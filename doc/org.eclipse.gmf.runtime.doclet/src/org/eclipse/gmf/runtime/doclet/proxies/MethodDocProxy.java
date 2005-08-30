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
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Type;


/**
 * Proxy to a MethodDoc
 */

public class MethodDocProxy
	extends ExecutableMemberDocProxy
	implements MethodDoc {

	public MethodDocProxy(MethodDoc innerMethodDoc) {
		super (innerMethodDoc);
	}
	
	private MethodDoc getInnerMethodDoc() {
		return (MethodDoc)getInnerObject();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.MethodDoc#isAbstract()
	 */
	public boolean isAbstract() {
		return getInnerMethodDoc().isAbstract();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.MethodDoc#overriddenClass()
	 */
	public ClassDoc overriddenClass() {
		return FACTORY.createClassDocProxy(getInnerMethodDoc().overriddenClass());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.MethodDoc#overriddenMethod()
	 */
	public MethodDoc overriddenMethod() {
		return FACTORY.createMethodDocProxy(getInnerMethodDoc().overriddenMethod());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.MethodDoc#returnType()
	 */
	public Type returnType() {
		return (Type)FACTORY.createTypeProxy(getInnerMethodDoc().returnType());
	}

}
