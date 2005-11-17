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
package org.eclipse.gmf.dev.insider.internal.ui;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FreeformLayeredPane;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * @author dstadnik
 */
public class PresentationView extends ViewPart {

	public void createPartControl(Composite parent) {
		myContents = new FreeformLayeredPane();
		FreeformViewport viewPort = new FreeformViewport();
		viewPort.setContents(myContents);
		myControl = new FigureCanvas(parent);
		myControl.setContents(viewPort);
	}

	public void setFocus() {
		if (myControl != null && !myControl.isDisposed()) {
			myControl.setFocus();
		}
	}

	public FreeformLayeredPane getContents() {
		return myContents;
	}

	private FreeformLayeredPane myContents;
	private FigureCanvas myControl;
}
