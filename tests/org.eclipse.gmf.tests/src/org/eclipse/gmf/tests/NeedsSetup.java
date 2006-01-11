/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests;

/**
 * Marker interface used in conjunction with {@link TestConfiguration} class.
 * Test that needs some configuration object (i.e. one which implements {@link TestConfiguration})
 * should add this interface to the <code>implements</code> list <b>AND</b>
 * define method named <em>configure</em> ({@link #METHOD_NAME}) taking its favourite
 * TestConfiguration subclass as a single argument.
 * 
 * @author artem
 */
public interface NeedsSetup {
	/**
	 * Name of the method to be invoked via reflection (value: <em>configure</em>)
	 */
	String METHOD_NAME = "configure";
}
