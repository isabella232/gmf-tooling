/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.doclet.utils;

import java.util.HashMap;

/**
 * Registry of aliases. Maps alias to value.
 */

public class AliasRegistry {

	private HashMap aliasMap;

	public AliasRegistry() {
		this.aliasMap = new HashMap();
	}

	public void registerAlias(String alias, String value) {
		this.aliasMap.put(alias.trim(), value.trim());
	}

	public String getAliasValue(String alias) {
		return (String) this.aliasMap.get(alias);
	}

}