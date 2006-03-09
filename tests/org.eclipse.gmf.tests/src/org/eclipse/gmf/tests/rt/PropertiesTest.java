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
package org.eclipse.gmf.tests.rt;

import junit.framework.TestCase;

import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

public class PropertiesTest extends TestCase {

	public PropertiesTest(String name) {
		super(name);
	}

	public void testPropertiesOnBasicRT() {
		checkWithGenericAccess(NotationFactory.eINSTANCE.createNode());
	}

	protected void checkWithGenericAccess(View element) {
//		final String propName = "prop1";
//		final String propValue = "abc";
//		assert propValue != null;

		fail("what about custom properties in new runtime?");
//		assertNull("Property has value prior to being set", element.getProperty(propName));
//		element.setProperty(propName, propValue);
//		assertNotNull("Not possible to get rtProperty using our 'generic' API", element.getProperty(propName));
//		assertEquals("Invalid property value", element.getProperty(propName), propValue);
//		assertTrue("[TENTATIVE] Property in basic RT should be also accessible via map", element.getRunTimeProperties().containsKey(propName));
//		assertEquals("[TENTATIVE] Invalid value of the property accessed via map", element.getRunTimeProperties().get(propName), propValue);
//		assertEquals("[TENTATIVE] Property in basic RT accessible via map should have same value", element.getRunTimeProperties().get(propName), element.getProperty(propName));
//
//		element.setProperty(propName, null);
//		assertNull("Setting property value to null should remove it", element.getProperty(propName));
//		assertFalse("...and from map, too", element.getRunTimeProperties().containsKey(propName));
	}
}
