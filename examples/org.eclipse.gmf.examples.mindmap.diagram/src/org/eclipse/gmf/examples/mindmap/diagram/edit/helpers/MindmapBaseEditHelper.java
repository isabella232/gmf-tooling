/*******************************************************************************
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.gmf.examples.mindmap.diagram.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class MindmapBaseEditHelper extends AbstractEditHelper {

	protected ICommand getCreateCommand(CreateElementRequest req) {
		return null;
	}

	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return null;
	}

	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	protected ICommand getDestroyElementWithDependentsCommand(DestroyElementRequest req) {
		return null;
	}

	protected ICommand getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return null;
	}
}