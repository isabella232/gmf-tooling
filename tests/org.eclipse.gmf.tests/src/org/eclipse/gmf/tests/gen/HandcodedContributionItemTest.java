/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
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
import org.eclipse.gmf.codegen.gmfgen.GenContributionItem;
import org.eclipse.gmf.codegen.gmfgen.GenCustomAction;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenMenuManager;
import org.eclipse.gmf.codegen.gmfgen.GenSharedContributionItem;
import org.eclipse.gmf.codegen.gmfgen.GenToolBarManager;

import junit.framework.TestCase;

/**
 * @author artem
 */
public class HandcodedContributionItemTest extends TestCase {

	public HandcodedContributionItemTest(String name) {
		super(name);
	}

	public void testGetEditorGenMethod() {
		GenEditorGenerator editorGen = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		GenApplication app = GMFGenFactory.eINSTANCE.createGenApplication();
		editorGen.setApplication(app);
		final GenActionFactoryContributionItem item1 = GMFGenFactory.eINSTANCE.createGenActionFactoryContributionItem();
		item1.setName("aaa");
		app.getSharedContributionItems().add(item1);
		GenMenuManager menu = GMFGenFactory.eINSTANCE.createGenMenuManager();
		final GenSharedContributionItem item2 = GMFGenFactory.eINSTANCE.createGenSharedContributionItem();
		item2.setActualItem(item1);
		menu.getItems().add(item2);
		GenMenuManager subMenu = GMFGenFactory.eINSTANCE.createGenMenuManager();
		final GenCustomAction item3 = GMFGenFactory.eINSTANCE.createGenCustomAction();
		item3.setName("bbb");
		subMenu.getItems().add(item3);
		menu.getItems().add(subMenu);
		GenToolBarManager toolbarManager = GMFGenFactory.eINSTANCE.createGenToolBarManager();
		GenContributionItem toolbarItem1;
		GenContributionItem nestedToolbarMenu;
		toolbarManager.getItems().add(toolbarItem1 = GMFGenFactory.eINSTANCE.createGenCommandAction());
		toolbarManager.getItems().add(nestedToolbarMenu = GMFGenFactory.eINSTANCE.createGenMenuManager());
		
		app.setMainMenu(menu);
		app.setMainToolBar(toolbarManager);

		assertEquals(editorGen, menu.getEditorGen());
		assertEquals(app, menu.getEditorGen().getApplication());
		assertNull(menu.getOwner());
		assertNull(item1.getOwner());
		assertEquals(menu, item2.getOwner());
		assertEquals(editorGen, item2.getOwner().getEditorGen());
		assertEquals(editorGen, item3.getOwner().getEditorGen());
		assertEquals(editorGen, toolbarManager.getEditorGen());
		assertEquals(toolbarManager, toolbarItem1.getOwner());
		assertEquals(editorGen, toolbarItem1.getOwner().getEditorGen());
		assertEquals(editorGen, nestedToolbarMenu.getOwner().getEditorGen());
		assertEquals(subMenu, item3.getOwner());
		assertEquals(menu, subMenu.getOwner());
	}
}
