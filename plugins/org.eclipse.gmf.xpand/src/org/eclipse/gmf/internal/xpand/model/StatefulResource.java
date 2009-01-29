/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.model;

/**
 * This is a marker interface. Intention of this interface is to show that
 * implementing resource should be initialized with appropriate {@link Scope}
 * instance.
 */
public interface StatefulResource {

	/**
	 * Perform actual initialization
	 */
	void initialize(Scope scope);

	/**
	 * @return true if this instance was already initialized
	 */
	boolean isInitialized();

}
