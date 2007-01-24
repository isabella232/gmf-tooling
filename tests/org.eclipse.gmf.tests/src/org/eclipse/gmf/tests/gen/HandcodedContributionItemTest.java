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
package org.eclipse.gmf.tests.gen;

import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenActionFactoryContributionItem;
import org.eclipse.gmf.codegen.gmfgen.GenApplication;
import org.eclipse.gmf.codegen.gmfgen.GenMenuManager;

import junit.framework.TestCase;

/**
 * @author artem
 */
public class HandcodedContributionItemTest extends TestCase {

	/**
	 * @param name
	 */
	public HandcodedContributionItemTest(String name) {
		super(name);
	}

	public void testGetApplicationMethod() {
		GenApplication app = GMFGenFactory.eINSTANCE.createGenApplication();
		GenActionFactoryContributionItem item1 = GMFGenFactory.eINSTANCE.createGenActionFactoryContributionItem();
		item1.setName("aaa");
		app.getSharedContributionItems().add(item1);
		GenMenuManager menu = GMFGenFactory.eINSTANCE.createGenMenuManager();
		GenActionFactoryContributionItem item2 = GMFGenFactory.eINSTANCE.createGenActionFactoryContributionItem();
		item1.setName("bbb");
		menu.getItems().add(item2);
		app.setMainMenu(menu);
		assertEquals(app, menu.getApplication());
		assertNull(menu.getOwner());
		assertEquals(menu, item2.getOwner());
		assertEquals(app, item2.getApplication());
		assertEquals(app, item1.getApplication());
		assertNull(item1.getOwner());
	}
}
