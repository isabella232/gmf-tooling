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

import com.sun.javadoc.MemberDoc;


/**
 * Proxy to a MemberDoc
 */

public class MemberDocProxy
	extends ProgramElementDocProxy
	implements MemberDoc {

	public MemberDocProxy(MemberDoc innerMemberDoc) {
		super (innerMemberDoc);
	}
	
	private MemberDoc getInnerMemberDoc() {
		return (MemberDoc)getInnerObject();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.MemberDoc#isSynthetic()
	 */
	public boolean isSynthetic() {
		return getInnerMemberDoc().isSynthetic();
	}

}
