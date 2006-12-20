/*
 *  Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.application;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @generated
 */
public class DiagramEditorPerspective implements IPerspectiveFactory {

	/**
	 * @generated
	 */
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.addPerspectiveShortcut(DiagramEditorWorkbenchAdvisor.PERSPECTIVE_ID);
		IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, 0.6f, layout.getEditorArea()); //$NON-NLS-1$
		right.addView(IPageLayout.ID_OUTLINE);
		IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.BOTTOM, 0.6f, "right"); //$NON-NLS-1$ //$NON-NLS-2$
		bottomRight.addView(IPageLayout.ID_PROP_SHEET);
	}
}
