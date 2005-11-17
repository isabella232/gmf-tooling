/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev.insider.internal.ui.actions;

import org.eclipse.gmf.dev.insider.internal.ui.InsiderView;

/**
 * @author dstadnik
 */
public class ShowSimpleTypesAction extends StatefulAction {

	public ShowSimpleTypesAction(InsiderView view) {
		super("Simple Types");
		myView = view;
	}

	protected String getKey() {
		return "simpleTypes";
	}

	protected void saveState() {
		super.saveState();
		myView.setShowSimpleTypes(isChecked());
	}

	private InsiderView myView;
}
