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
