/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.naming;

/**
 * @author artem
 */
public class DupedDispenser implements UniqueValueDispenser {

	/**
	 * @return always <code>true</code>
	 */
	public boolean isUnique(Object obj) {
		return true;
	}

	/**
	 * NO-OP
	 */
	public void remember(Object obj) {
	}
}
