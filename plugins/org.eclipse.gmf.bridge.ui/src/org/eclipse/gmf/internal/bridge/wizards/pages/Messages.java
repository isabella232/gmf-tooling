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
package org.eclipse.gmf.internal.bridge.wizards.pages;

import org.eclipse.osgi.util.NLS;

/**
 * @author artem
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.gmf.internal.bridge.wizards.pages.messages"; //$NON-NLS-1$

	private Messages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String wizardTitle;
	public static String newPageTitle;
	public static String newPageDesc;

	public static String inputPageTitle;
	public static String inputPageDesc;

	public static String ecoreSelector;
	public static String graphdefSelector;
	public static String tooldefSelector;

	public static String uriSelectorBrowse;
	public static String uriSelectorLoad;
	public static String uriSelectorWorkspace;
	public static String uriSelectorFilesystem;
	public static String useECore;
	public static String useBasic;

	public static String rootPageTitle;
	public static String rootPageDesc;
	public static String rootPageGroupTitle;

	public static String mapPageTitle;
	public static String mapPageDesc;
}
