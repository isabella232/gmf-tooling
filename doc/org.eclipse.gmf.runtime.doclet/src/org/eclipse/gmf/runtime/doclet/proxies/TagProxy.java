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

import com.sun.javadoc.Doc;
import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;


/**
 * Proxy to a Tag
 */

public class TagProxy
	extends Proxy
	implements Tag {

	public TagProxy(Tag innerTag) {
		super (innerTag);
	}
	
	private Tag getInnerTag() {
		return (Tag)getInnerObject();
	}


	/* (non-Javadoc)
	 * @see com.sun.javadoc.Tag#holder()
	 */
	public Doc holder() {
		return FACTORY.createDocProxy(getInnerTag().holder());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Tag#position()
	 */
	public SourcePosition position() {
		return getInnerTag().position();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Tag#firstSentenceTags()
	 */
	public Tag[] firstSentenceTags() {
		return FACTORY.createTagProxies(getInnerTag().firstSentenceTags());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Tag#inlineTags()
	 */
	public Tag[] inlineTags() {
		return FACTORY.createTagProxies(getInnerTag().inlineTags());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Tag#kind()
	 */
	public String kind() {
		return getInnerTag().kind();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Tag#name()
	 */
	public String name() {
		return getInnerTag().name();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Tag#text()
	 */
	public String text() {
		return getInnerTag().text();
	}
}
