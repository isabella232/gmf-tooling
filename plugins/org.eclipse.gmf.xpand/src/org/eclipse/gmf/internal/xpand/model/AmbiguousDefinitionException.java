/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.model;

public class AmbiguousDefinitionException extends Exception {

	private XpandDefinition definition1;

	private XpandDefinition definition2;
	
	public AmbiguousDefinitionException(XpandDefinition candidate1, XpandDefinition candidate2) {
		super("Ambiguous definitions " + candidate1.toString() + " and " + candidate2.toString());
		definition1 = candidate1;
		definition2 = candidate2;
	}

	public XpandDefinition getDefinition1() {
		return definition1;
	}

	public XpandDefinition getDefinition2() {
		return definition2;
	}

}
