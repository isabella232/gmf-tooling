/*
 * Copyright (c) 2005, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.common.migrate;

import java.util.ResourceBundle;

import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.internal.common.Activator;

public class Messages {

	public static String oldModelVersionLoadedMigrationRequired;
	public static String oldModelVersionLoadErrorMigrationMayBeRequired;	
	public static String modelLoadedWithProblems;
	
	static {
		// FIXME rename methods
		ResourceBundle rb = Platform.getResourceBundle(Platform.getBundle(Activator.getID()));
		oldModelVersionLoadedMigrationRequired = rb.getString("oldModelVersionWarn");
		oldModelVersionLoadErrorMigrationMayBeRequired = rb.getString("oldModelVersionErr");
		modelLoadedWithProblems = rb.getString("modelLoadedWithProblems");
	}

	private Messages() {
	}
}
