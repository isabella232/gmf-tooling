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

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionEditPolicy;

/**
 * @generated
 */
public class TaiPanReferenceConnectionEditPolicy extends ConnectionEditPolicy {

	/**
	 * @generated
	 */
	protected boolean shouldDeleteSemantic() {
		return false;
	};

	/**
	 * @generated
	 */
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		CompoundCommand cmd = new CompoundCommand();
		cmd.add(super.createDeleteViewCommand(deleteRequest));
		cmd.add(createDeleteSemanticCommand(deleteRequest));
		return cmd;
	}
}
