/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */

package org.eclipse.gmf.examples.mindmap.rcp.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ResourceEditPart;
import org.eclipse.gmf.runtime.lite.edit.policies.ListLayoutEditPolicy;

/**
 * @generated
 */
public class ResourceLayoutEditPolicy extends ListLayoutEditPolicy {
	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}

	/**
	 * @generated
	 */
	protected EditPolicy createChildEditPolicy(EditPart child) {
		EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if (result != null) {
			return result;
		}
		if (((ResourceEditPart) getHost()).isExternalLabel(child)) {
			return new ResizableEditPolicy() {
				public EditPart getTargetEditPart(Request request) {
					if (RequestConstants.REQ_SELECTION
							.equals(request.getType())) {
						return ResourceLayoutEditPolicy.this.getHost();
					}
					return super.getTargetEditPart(request);
				}
			};
		}
		return super.createChildEditPolicy(child);
	}
}
