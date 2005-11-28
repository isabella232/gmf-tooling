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
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.editor.FileDiagramEditorWithFlyoutPalette;
import org.eclipse.ui.IEditorInput;

/**
 * @generated
 */
public class TaiPanDiagramEditor extends FileDiagramEditorWithFlyoutPalette {

	/**
	 * @generated
	 */
	protected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {
		existingPaletteRoot = super.createPaletteRoot(existingPaletteRoot);
		TaiPanPaletteFactory.fillPalette(existingPaletteRoot, getDiagram());
		return existingPaletteRoot;
	}

	/**
	 * @generated
	 */
	protected void setDocumentProvider(IEditorInput input) {
		setDocumentProvider(new TaiPanDocumentProvider());
	}
}
