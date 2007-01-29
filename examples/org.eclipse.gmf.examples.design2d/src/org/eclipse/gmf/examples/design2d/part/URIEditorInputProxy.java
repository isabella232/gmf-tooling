/*
 *  Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.design2d.part;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.util.HashUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.MEditingDomainElement;

/**
 * @generated
 */
public class URIEditorInputProxy extends URIEditorInput implements MEditingDomainElement {

	/**
	 * @generated
	 */
	private final URIEditorInput delegate;

	/**
	 * @generated
	 */
	private final TransactionalEditingDomain domain;

	/**
	 * @generated
	 */
	public URIEditorInputProxy(URIEditorInput delegate, TransactionalEditingDomain domain) {
		super(delegate.getURI());
		this.delegate = delegate;
		this.domain = domain;
	}

	/**
	 * @generated
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return domain;
	}

	/**
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj instanceof URIEditorInputProxy) {
			URIEditorInputProxy another = (URIEditorInputProxy) obj;
			return eq(delegate.getURI(), another.getURI()) && eq(domain, another.domain);
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static boolean eq(Object obj1, Object obj2) {
		return obj1 == null ? obj2 == null : obj1.equals(obj2);
	}

	/**
	 * @generated
	 */
	public int hashCode() {
		return HashUtil.hash(HashUtil.hash(delegate), domain);
	}
}
