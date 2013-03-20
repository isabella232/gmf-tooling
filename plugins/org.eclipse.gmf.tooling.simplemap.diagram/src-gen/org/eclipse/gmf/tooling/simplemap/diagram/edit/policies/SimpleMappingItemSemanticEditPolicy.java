/**
 * Copyright (c) 2010-2012 ISBAN S.L
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 		Ruben De Dios (ISBAN S.L)
 * 		Andrez Alvarez Mattos (ISBAN S.L)
 */
package org.eclipse.gmf.tooling.simplemap.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.tooling.simplemap.diagram.edit.commands.SimpleLinkMappingCreateCommand;
import org.eclipse.gmf.tooling.simplemap.diagram.edit.commands.SimpleTopNodeCreateCommand;
import org.eclipse.gmf.tooling.simplemap.diagram.providers.SimplemapElementTypes;

/**
 * @generated
 */
public class SimpleMappingItemSemanticEditPolicy extends SimplemapBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SimpleMappingItemSemanticEditPolicy() {
		super(SimplemapElementTypes.SimpleMapping_79);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (SimplemapElementTypes.SimpleTopNode_1001 == req.getElementType()) {
			return getGEFWrapper(new SimpleTopNodeCreateCommand(req));
		}
		if (SimplemapElementTypes.SimpleLinkMapping_1002 == req.getElementType()) {
			return getGEFWrapper(new SimpleLinkMappingCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
