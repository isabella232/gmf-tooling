/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.migration;

public abstract class AbstractImportsManager {

	private int placeholderIndex;

	AbstractImportsManager(StringBuilder stringBuilder) {
		this(stringBuilder.length());
	}

	AbstractImportsManager(int placeholder) {
		placeholderIndex = placeholder;
	}

	public int getPlaceholderIndex() {
		return placeholderIndex;
	}

}
