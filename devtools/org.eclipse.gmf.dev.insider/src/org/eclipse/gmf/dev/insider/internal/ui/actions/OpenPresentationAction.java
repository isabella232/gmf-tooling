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

import org.eclipse.gmf.dev.insider.internal.View;
import org.eclipse.gmf.dev.insider.internal.ui.InsiderView;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class OpenPresentationAction extends Action {

	public OpenPresentationAction(InsiderView insiderView) {
		assert insiderView != null;
		myInsiderView = insiderView;
		setText("Open Presentation");
	}

	public void run() {
		IStructuredSelection selection = (IStructuredSelection) myInsiderView.getViewer().getSelection();
		if (selection.size() != 1) {
			return;
		}
		Object selected = selection.getFirstElement();
		View view = null;
		if (selected instanceof View) {
			view = (View) selected;
		} else if (selected instanceof Element) {
			// TODO : find view for the selected element
		}
		if (view != null) {
			myInsiderView.getPresentationController().open(view);
		}
	}

	private InsiderView myInsiderView;
}
