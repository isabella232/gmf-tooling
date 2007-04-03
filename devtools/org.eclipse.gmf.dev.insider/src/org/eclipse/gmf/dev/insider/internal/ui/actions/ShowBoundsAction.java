/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev.insider.internal.ui.actions;

import org.eclipse.gmf.dev.insider.internal.ui.InsiderView;

/**
 * @author dstadnik
 */
public class ShowBoundsAction extends StatefulAction {

	public ShowBoundsAction(InsiderView view) {
		super("Bounds");
		myView = view;
	}

	protected String getKey() {
		return "bounds";
	}

	protected void saveState() {
		super.saveState();
		myView.setShowBounds(isChecked());
	}

	private InsiderView myView;
}
