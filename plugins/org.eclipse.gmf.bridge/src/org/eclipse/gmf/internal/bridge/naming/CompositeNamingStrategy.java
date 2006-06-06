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
package org.eclipse.gmf.internal.bridge.naming;

import org.eclipse.gmf.common.NamesDispenser;


/**
 * Will utilize original strategies uniquenessDispensers unless 
 * {@link #setNamesDispenser(UniqueValueDispenser)} is expicitly invoked.
 * @author artem
 */
public abstract class CompositeNamingStrategy implements NamingStrategy {

	private final NamingStrategy[] myStrategies;
	private NamesDispenser myCache = null;

	public CompositeNamingStrategy(NamingStrategy[] strategies) {
		myStrategies = strategies;
	}

	/**
	 * Once set, all comprised strategies will use it. 
	 */
	public void setNamesDispenser(NamesDispenser dispenser) {
		myCache = dispenser;
		for (int i = 0; i < myStrategies.length; i++) {
			myStrategies[i].setNamesDispenser(dispenser);
		}
	}

	/**
	 * @return value previously passed to {@link #setNamesDispenser(UniqueValueDispenser)}, or <code>null</code> otherwise.
	 */
	public NamesDispenser getNamesDispenser() {
		return myCache;
	}

}
