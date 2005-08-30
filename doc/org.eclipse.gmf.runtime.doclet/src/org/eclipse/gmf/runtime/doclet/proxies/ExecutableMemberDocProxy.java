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
import com.sun.javadoc.ExecutableMemberDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.ThrowsTag;


/**
 * Proxy to an ExecutableMemberDoc
 */

public class ExecutableMemberDocProxy
	extends MemberDocProxy
	implements ExecutableMemberDoc {

	public ExecutableMemberDocProxy(ExecutableMemberDoc innerExecutableMemberDoc) {
		super (innerExecutableMemberDoc);
	}
	
	private ExecutableMemberDoc getInnerExecutableMemberDoc() {
		return (ExecutableMemberDoc)getInnerObject();
	}
	
	/* (non-Javadoc)
	 * @see com.sun.javadoc.ExecutableMemberDoc#isNative()
	 */
	public boolean isNative() {
		return getInnerExecutableMemberDoc().isNative();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ExecutableMemberDoc#isSynchronized()
	 */
	public boolean isSynchronized() {
		return getInnerExecutableMemberDoc().isSynchronized();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ExecutableMemberDoc#thrownExceptions()
	 */
	public ClassDoc[] thrownExceptions() {
		return FACTORY.createClassDocProxies(getInnerExecutableMemberDoc().thrownExceptions());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ExecutableMemberDoc#paramTags()
	 */
	public ParamTag[] paramTags() {
		return getInnerExecutableMemberDoc().paramTags();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ExecutableMemberDoc#parameters()
	 */
	public Parameter[] parameters() {
		return FACTORY.createParameterProxies(getInnerExecutableMemberDoc().parameters());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ExecutableMemberDoc#throwsTags()
	 */
	public ThrowsTag[] throwsTags() {
		return FACTORY.createThrowsTagProxies(getInnerExecutableMemberDoc().throwsTags());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ExecutableMemberDoc#flatSignature()
	 */
	public String flatSignature() {
		return getInnerExecutableMemberDoc().flatSignature();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ExecutableMemberDoc#signature()
	 */
	public String signature() {
		return getInnerExecutableMemberDoc().signature();
	}

}
