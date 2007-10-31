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

package org.eclipse.gmf.examples.mindmap.rcp.edit.commands;

import org.eclipse.gmf.examples.mindmap.rcp.view.factories.DomainElementInitializer;
import org.eclipse.gmf.runtime.lite.commands.VetoCommand;
import org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class CreateTopic_Subtopics4001StartCommand extends VetoCommand {
	/**
	 * @generated
	 */
	private View source;

	/**
	 * @generated
	 */
	public CreateTopic_Subtopics4001StartCommand(
			CreateConnectionRequestEx requestEx) {
		//Until the mouse button is pressed, the source of the connection is in request.getTargetEditPart(), not in request.getSourceEditPart().
		source = (View) requestEx.getTargetEditPart().getModel();
	}

	/**
	 * @generated
	 */
	protected boolean shouldExecute() {
		if (source == null) {
			return false;
		}
		if (!DomainElementInitializer.LinkConstraints
				.canExistTopicSubtopics_4001(source.getElement(), null)) {
			return false;
		}
		return true;
	}
}
