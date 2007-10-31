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

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.lite.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.lite.commands.RemoveNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ThreadComponentEditPolicy extends ComponentEditPolicy {
	/**
	 * @generated
	 */
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(getDiagramNode().getDiagram().getElement());
		CompoundCommand cc = new CompoundCommand();
		cc.append(createDomainModelRemoveCommand(editingDomain));
		cc.append(new RemoveNotationalElementCommand((View) getDiagramNode()
				.eContainer(), getDiagramNode()));
		return new WrappingCommand(editingDomain, cc);
	}

	/**
	 * @generated
	 */
	private org.eclipse.emf.common.command.Command createDomainModelRemoveCommand(
			TransactionalEditingDomain editingDomain) {
		return DestroyElementCommand.create(editingDomain, getDiagramNode()
				.getElement());
	}

	/**
	 * @generated
	 */
	protected Node getDiagramNode() {
		return (Node) getHost().getModel();
	}
}
