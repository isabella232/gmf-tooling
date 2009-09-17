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
package org.eclipse.gmf.graphdef.editor.edit.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

public class ResizableEditPolicy extends org.eclipse.gef.editpolicies.ResizableEditPolicy {

	@Override
	public void showSourceFeedback(Request request) {
		if (RequestConstants.REQ_DROP.equals(request.getType())) {
			showChangeBoundsFeedback((ChangeBoundsRequest) request);
		} else {
			super.showSourceFeedback(request);
		}
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		if (RequestConstants.REQ_DROP.equals(request.getType())) {
			eraseChangeBoundsFeedback((ChangeBoundsRequest) request);
		} else {
			super.eraseSourceFeedback(request);
		}
	}

}
