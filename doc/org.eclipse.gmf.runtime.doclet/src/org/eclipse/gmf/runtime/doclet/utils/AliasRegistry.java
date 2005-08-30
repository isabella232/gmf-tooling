/*
 *+------------------------------------------------------------------------+
 *| Licensed Materials - Property of IBM                                   |
 *| (C) Copyright IBM Corp. 2005.  All Rights Reserved.                    |
 *|                                                                        |
 *| US Government Users Restricted Rights - Use, duplication or disclosure |
 *| restricted by GSA ADP Schedule Contract with IBM Corp.                 |
 *+------------------------------------------------------------------------+
 */
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