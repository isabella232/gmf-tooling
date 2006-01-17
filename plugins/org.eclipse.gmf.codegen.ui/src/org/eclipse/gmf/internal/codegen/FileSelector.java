/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    dstadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

/**
 * File selection utility methods.
 * 
 * @author dstadnik
 */
public class FileSelector {

	public static IFile selectFile(Shell shell, String description, IFile selected) {
		ResourceSelectionDialog fsd = new ResourceSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), description);
		if (selected != null) {
			fsd.setInitialElementSelections(Collections.singletonList(selected));
		}
		if (fsd.open() == Window.OK) {
			Object[] result = fsd.getResult();
			if (result.length > 0 && result[0] instanceof IFile) {
				selected = (IFile) result[0];
			} else {
				selected = null;
			}
		}
		return selected;
	}
}
