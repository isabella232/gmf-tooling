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
package org.eclipse.gmf.tests.setup;

import org.eclipse.gmf.tooldef.AbstractTool;
import org.eclipse.gmf.tooldef.ContextMenu;
import org.eclipse.gmf.tooldef.MainMenu;
import org.eclipse.gmf.tooldef.Palette;
import org.eclipse.gmf.tooldef.ToolRegistry;

/**
 * @author artem
 *
 */
public interface ToolDefSource {

	ToolRegistry getRegistry();
	MainMenu getMainMenu();
	ContextMenu getNodeContextMenu();
	AbstractTool getNodeCreationTool();
	AbstractTool getLinkCreationTool();
	Palette getPalette();
}
