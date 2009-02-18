/*
 * Copyright (c) 2006, 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.ecore.edit.commands.EStringToStringMapEntryCreateCommand;
import org.eclipse.gmf.ecore.providers.EcoreElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class EAnnotationDetailsItemSemanticEditPolicy extends EcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EAnnotationDetailsItemSemanticEditPolicy() {
		super(EcoreElementTypes.EAnnotation_2003);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EcoreElementTypes.EStringToStringMapEntry_3008 == req.getElementType()) {
			return getGEFWrapper(new EStringToStringMapEntryCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
