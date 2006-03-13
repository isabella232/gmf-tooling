/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.TextSelectionEditPolicy;

/**
 * @generated
 */
public class ConstrainedToolbarLayoutEditPolicy extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy {

	/**
	 * @generated
	 */
	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
			if (child instanceof ITextAwareEditPart)
				return new TextSelectionEditPolicy();
		}
		return super.createChildEditPolicy(child);
	}
}
