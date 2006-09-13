/*
 * Copyright (c) 2005, 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import org.eclipse.gmf.tooldef.AbstractTool;
import org.eclipse.gmf.tooldef.ActionKind;
import org.eclipse.gmf.tooldef.BundleImage;
import org.eclipse.gmf.tooldef.ContextMenu;
import org.eclipse.gmf.tooldef.CreationTool;
import org.eclipse.gmf.tooldef.GMFToolFactory;
import org.eclipse.gmf.tooldef.ItemRef;
import org.eclipse.gmf.tooldef.MainMenu;
import org.eclipse.gmf.tooldef.MenuAction;
import org.eclipse.gmf.tooldef.Palette;
import org.eclipse.gmf.tooldef.ToolRegistry;

/**
 * @author artem
 *
 */
public class ToolDefSetup implements ToolDefSource {
	private final MainMenu myMainMenu;
	private final ContextMenu myNodeMenu;
	private final AbstractTool myNodeTool;
	private final AbstractTool myLinkTool;
	private ToolRegistry myRegistry;

	public ToolDefSetup() {
		myMainMenu = GMFToolFactory.eINSTANCE.createMainMenu();
		myMainMenu.setTitle("ToolDefSetup");
		myMainMenu.getItems().add(createAction("a1"));
		myMainMenu.getItems().add(GMFToolFactory.eINSTANCE.createSeparator());

		MenuAction shared = createAction("SharedA2");
		ItemRef ref = GMFToolFactory.eINSTANCE.createItemRef();
		ref.setItem(shared);
		myMainMenu.getItems().add(ref);

		myNodeMenu = GMFToolFactory.eINSTANCE.createContextMenu();
		myNodeMenu.getItems().add(createAction("a3"));
		ref = GMFToolFactory.eINSTANCE.createItemRef();
		ref.setItem(shared);
		myNodeMenu.getItems().add(ref);
		

		myNodeTool = createTool("Node1");
		myLinkTool = createTool("Link1");

		
		Palette p = GMFToolFactory.eINSTANCE.createPalette();
		p.getTools().add(myNodeTool);
		p.getTools().add(myLinkTool);

		myRegistry = GMFToolFactory.eINSTANCE.createToolRegistry();
		myRegistry.getSharedActions().add(shared);
		myRegistry.getAllMenus().add(myMainMenu);
		myRegistry.getAllMenus().add(myNodeMenu);
		myRegistry.setPalette(p);
	}

	private CreationTool createTool(String title) {
		CreationTool t = GMFToolFactory.eINSTANCE.createCreationTool();
		t.setTitle(title);
		return t;
	}

	private static MenuAction createAction(String name) {
		MenuAction a = GMFToolFactory.eINSTANCE.createMenuAction();
		BundleImage i = GMFToolFactory.eINSTANCE.createBundleImage();
		i.setBundle(null);
		i.setPath("/icons/obj16/" + name + ".gif");
		a.setIcon(i);
		a.setKind(ActionKind.CREATE_LITERAL);
		a.setTitle(name);
		return a;
	}

	public ToolRegistry getRegistry() {
		return myRegistry;
	}

	public MainMenu getMainMenu() {
		return myMainMenu;
	}

	public ContextMenu getNodeContextMenu() {
		return myNodeMenu;
	}

	public AbstractTool getNodeCreationTool() {
		return myNodeTool;
	}

	public AbstractTool getLinkCreationTool() {
		return myLinkTool;
	}

	public Palette getPalette() {
		return (Palette) myNodeTool.eContainer();
	}

}
