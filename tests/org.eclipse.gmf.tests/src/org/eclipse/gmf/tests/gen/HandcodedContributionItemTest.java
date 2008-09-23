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

import junit.framework.TestCase;

import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenActionFactoryContributionItem;
import org.eclipse.gmf.codegen.gmfgen.GenApplication;
import org.eclipse.gmf.codegen.gmfgen.GenContextMenu;
import org.eclipse.gmf.codegen.gmfgen.GenContributionItem;
import org.eclipse.gmf.codegen.gmfgen.GenCustomAction;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenMenuManager;
import org.eclipse.gmf.codegen.gmfgen.GenSharedContributionItem;
import org.eclipse.gmf.codegen.gmfgen.GenToolBarManager;

/**
 * @author artem
 */
public class HandcodedContributionItemTest extends TestCase {

	public HandcodedContributionItemTest(String name) {
		super(name);
	}

	public void testGetEditorGenMethod() {
		GenApplication app = GMFGenFactory.eINSTANCE.createGenApplication();
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
		//
		GenToolBarManager toolbarManager = GMFGenFactory.eINSTANCE.createGenToolBarManager();
		GenContributionItem toolbarItem1;
		GenMenuManager nestedToolbarMenu;
		GenToolBarManager nestedToolbarToolbar; // useless concept, but doesn't hurt to check
		toolbarManager.getItems().add(toolbarItem1 = GMFGenFactory.eINSTANCE.createGenCommandAction());
		toolbarManager.getItems().add(nestedToolbarMenu = GMFGenFactory.eINSTANCE.createGenMenuManager());
		toolbarManager.getItems().add(nestedToolbarToolbar = GMFGenFactory.eINSTANCE.createGenToolBarManager());
		//
		GenContextMenu contextMenu = GMFGenFactory.eINSTANCE.createGenContextMenu();
		GenContributionItem contextMenuItem1;
		GenMenuManager nestedContextMenu;
		contextMenu.getItems().add(contextMenuItem1 = GMFGenFactory.eINSTANCE.createGenCommandAction());
		contextMenu.getItems().add(nestedContextMenu = GMFGenFactory.eINSTANCE.createGenMenuManager());
		//
		GenEditorGenerator editorGen = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		editorGen.setApplication(app);
		app.setMainMenu(menu);
		app.setMainToolBar(toolbarManager);
		editorGen.getContextMenus().add(contextMenu);
		//
		assertEquals(editorGen, menu.getEditorGen());
		assertEquals(app, menu.getEditorGen().getApplication());
		assertNull(menu.getOwner());
		assertNull(item1.getOwner());
		assertEquals(menu, item2.getOwner());
		assertEquals(editorGen, item2.getOwner().getEditorGen());
		assertEquals(editorGen, item3.getOwner().getEditorGen());
		assertEquals(subMenu, item3.getOwner());
		assertEquals(menu, subMenu.getOwner());
		//
		assertEquals(editorGen, toolbarManager.getEditorGen());
		assertEquals(toolbarManager, toolbarItem1.getOwner());
		assertEquals(editorGen, toolbarItem1.getOwner().getEditorGen());
		assertEquals(editorGen, nestedToolbarMenu.getEditorGen());
		assertEquals(editorGen, nestedToolbarToolbar.getEditorGen());
		// 
		assertEquals(editorGen, contextMenu.getEditorGen());
		assertEquals(contextMenu, contextMenuItem1.getOwner());
		assertEquals(contextMenu, nestedContextMenu.getOwner());
		assertEquals(editorGen, nestedContextMenu.getEditorGen());
	}
}
