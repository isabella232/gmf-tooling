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
