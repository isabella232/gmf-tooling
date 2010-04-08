/*
 * Copyright (c) 2005, 2010 Borland Software Corporation and others
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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import junit.framework.TestCase;

/**
 * Marker annotation used in conjunction with {@link TestConfiguration} class.
 * Test (in fact, set of tests, {@link TestCase}) that needs some configuration object 
 * (i.e. one which implements {@link TestConfiguration}) should define method that 
 * takes its favorite TestConfiguration subclass as a single argument 
 * <b>AND</b> annotate this method with {@link NeedsSetup this annotation}.  
 * 
 * @author artem
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedsSetup {
}
