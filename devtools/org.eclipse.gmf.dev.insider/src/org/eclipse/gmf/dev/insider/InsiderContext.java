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
package org.eclipse.gmf.dev.insider;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Context in which content builders work.
 * 
 * @author dstadnik
 */
public class InsiderContext {

	public InsiderContext() {}

	public InsiderContext(IFigure figure) {
		this();
		myFigure = figure;
	}

	public InsiderContext(IFigure figure, EditPart editPart) {
		this(figure);
		myEditPart = editPart;
	}

	public InsiderContext(IFigure figure, EditPart editPart, EditPartViewer viewer) {
		this(figure, editPart);
		myViewer = viewer;
	}

	public InsiderContext(IFigure figure, EditPart editPart, EditPartViewer viewer, IWorkbenchPart workbenchPart) {
		this(figure, editPart, viewer);
		myWorkbenchPart = workbenchPart;
	}

	public IFigure getFigure() {
		return myFigure;
	}

	public EditPart getEditPart() {
		return myEditPart;
	}

	public EditPartViewer getViewer() {
		return myViewer;
	}

	public IWorkbenchPart getWorkbenchPart() {
		return myWorkbenchPart;
	}

	private IFigure myFigure;
	private EditPart myEditPart;
	private EditPartViewer myViewer;
	private IWorkbenchPart myWorkbenchPart;
}
