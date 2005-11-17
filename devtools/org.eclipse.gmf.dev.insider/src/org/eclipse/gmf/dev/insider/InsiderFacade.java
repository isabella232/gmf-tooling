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
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.dev.insider.internal.InsiderAccess;
import org.eclipse.gmf.dev.insider.internal.View;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Entry point for the Insider clients.
 * 
 * @author dstadnik
 */
public class InsiderFacade {

	private InsiderFacade() {}

	/**
	 * Create snapshot of the specified context.
	 * @return <code>true</code> if snapshot was made.
	 */
	public static boolean memorize(InsiderContext context, String descrition) {
		if (context == null) {
			return false;
		}
		View view = InsiderAccess.getViewFactory().createView(context);
		if (view == null) {
			return false;
		}
		if (descrition != null) {
			view.setDescription(descrition);
		}
		// trace {
		//StringWriter writer = new StringWriter();
		//view.serialize(writer);
		//System.out.println(writer.getBuffer());
		// }
		InsiderAccess.getViewManager().add(view);
		return true;
	}

	/**
	 * Create snapshot of the specified figure.
	 * @return <code>true</code> if snapshot was made.
	 */
	public static boolean memorize(IFigure figure, String description) {
		if (figure == null) {
			return false;
		}
		InsiderContext context = new InsiderContext(figure);
		return memorize(context, description);
	}

	/**
	 * Create snapshot of the specified edit part.
	 * @return <code>true</code> if snapshot was made.
	 */
	public static boolean memorize(EditPart editPart, String description) {
		if (editPart == null) {
			return false;
		}
		IFigure figure = null;
		if (editPart instanceof GraphicalEditPart) {
			figure = ((GraphicalEditPart) editPart).getFigure();
		}
		InsiderContext context = new InsiderContext(figure, editPart);
		return memorize(context, description);
	}

	/**
	 * Create snapshot of the GEF editor.
	 * @return <code>true</code> if snapshot was made.
	 */
	public static boolean memorize(EditPartViewer viewer, String description) {
		if (viewer == null) {
			return false;
		}
		IFigure figure = null;
		EditPart root = viewer.getRootEditPart();
		if (root instanceof GraphicalEditPart) {
			figure = ((GraphicalEditPart) root).getFigure();
			while (figure.getParent() != null) {
				figure = figure.getParent();
			}
		}
		InsiderContext context = new InsiderContext(figure, root, viewer);
		return memorize(context, description);
	}

	/**
	 * Create snapshot of the GEF editor
	 * hosted by the specified workbench part.
	 * @return <code>true</code> if snapshot was made.
	 */
	public static boolean memorize(IWorkbenchPart part, String description) {
		if (part == null) {
			return false;
		}
		Object viewer = part.getAdapter(EditPartViewer.class);
		if (viewer instanceof EditPartViewer) {
			memorize((EditPartViewer) viewer, description);
		}
		viewer = part.getAdapter(GraphicalViewer.class);
		if (viewer instanceof GraphicalViewer) {
			memorize((GraphicalViewer) viewer, description);
		}
		return false;
	}

	/**
	 * Create snapshot of the GEF editor view
	 * hosted by the active editor part.
	 * @return <code>true</code> if snapshot was made.
	 */
	public static boolean memorizeActiveEditor(String description) {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return false;
		}
		IWorkbenchPage page = window.getActivePage();
		if (page == null) {
			return false;
		}
		return memorize(page.getActiveEditor(), description);
	}
}
