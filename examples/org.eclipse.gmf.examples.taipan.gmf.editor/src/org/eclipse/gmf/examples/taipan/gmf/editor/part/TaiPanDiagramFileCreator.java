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

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorFileCreator;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;

/**
 * @generated
 */
public class TaiPanDiagramFileCreator extends IDEEditorFileCreator {

	/**
	 * @generated
	 */
	private static TaiPanDiagramFileCreator INSTANCE = new TaiPanDiagramFileCreator();

	/**
	 * @generated
	 */
	public static DiagramFileCreator getInstance() {
		return INSTANCE;
	}

	/**
	 * @generated
	 */
	public String getExtension() {
		return ".taipan_diagram"; //$NON-NLS-1$
	}
}
