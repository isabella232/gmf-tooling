/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.policies.assistant;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.tools.AbstractTool;

public class SelectEditPartDragTracker extends AbstractTool implements DragTracker {

	private EditPart myEditPartToSelect;

	public SelectEditPartDragTracker(EditPart editPartToSelect) {
		myEditPartToSelect = editPartToSelect;
	}

	@Override
	protected String getCommandName() {
		return "SelectEditPart";
	}

	public boolean handleButtonUp(int button) {
		myEditPartToSelect.getViewer().select(myEditPartToSelect);
		return true;
	}
}
