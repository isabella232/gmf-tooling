/*
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.ecore.edit.policies;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.ecore.providers.EcoreElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EAnnotation_detailsItemSemanticEditPolicy extends EcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EcoreElementTypes.EStringToStringMapEntry_3008 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(EcorePackage.eINSTANCE.getEAnnotation_Details());
			}
			return getMSLWrapper(new CreateEStringToStringMapEntry_3008Command(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	private static class CreateEStringToStringMapEntry_3008Command extends CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateEStringToStringMapEntry_3008Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EcorePackage.eINSTANCE.getEAnnotation();
		};

		/**
		 * @generated
		 */
		protected EObject getElementToEdit() {
			EObject container = ((CreateElementRequest) getRequest()).getContainer();
			if (container instanceof View) {
				container = ((View) container).getElement();
			}
			return container;
		}
	}

}
