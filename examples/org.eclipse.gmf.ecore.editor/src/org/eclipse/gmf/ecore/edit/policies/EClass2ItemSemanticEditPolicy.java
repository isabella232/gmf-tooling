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

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gmf.ecore.providers.EcoreElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * @generated
 */
public class EClass2ItemSemanticEditPolicy extends EcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getMSLWrapper(new DestroyElementCommand(req) {

			protected EObject getElementToDestroy() {
				View view = (View) getHost().getModel();
				EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
				if (annotation != null) {
					return view;
				}
				return super.getElementToDestroy();
			}

		});
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (EcoreElementTypes.EAnnotationReferences_4001 == req.getElementType()) {
			return req.getTarget() == null ? null : getCreateCompleteIncomingEAnnotation_References4001Command(req);
		}
		if (EcoreElementTypes.EReference_4002 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingEReference4002Command(req) : getCreateCompleteIncomingEReference4002Command(req);
		}
		if (EcoreElementTypes.EReference_4003 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingEReference4003Command(req) : getCreateCompleteIncomingEReference4003Command(req);
		}
		if (EcoreElementTypes.EClassESuperTypes_4004 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingEClass_ESuperTypes4004Command(req) : getCreateCompleteIncomingEClass_ESuperTypes4004Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingEAnnotation_References4001Command(CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof EAnnotation)) {
			return UnexecutableCommand.INSTANCE;
		}
		EAnnotation element = (EAnnotation) req.getSource();
		if (element.getReferences().contains(req.getTarget())) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(req.getSource(), EcorePackage.eINSTANCE.getEAnnotation_References(), req.getTarget());
		return getMSLWrapper(new SetValueCommand(setReq));
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingEReference4002Command(CreateRelationshipRequest req) {
		if (!EcoreBaseItemSemanticEditPolicy.LinkConstraints.EReference_4002.canCreateLink(req, false)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingEReference4002Command(CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof EClass)) {
			return UnexecutableCommand.INSTANCE;
		}
		final EClass element = (EClass) req.getSource();
		if (!EcoreBaseItemSemanticEditPolicy.LinkConstraints.EReference_4002.canCreateLink(req, false)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(EcorePackage.eINSTANCE.getEClass_EStructuralFeatures());
		}
		return getMSLWrapper(new CreateIncomingEReference4002Command(req) {

			/**
			 * @generated
			 */
			protected EObject getElementToEdit() {
				return element;
			}
		});
	}

	/**
	 * @generated
	 */
	private static class CreateIncomingEReference4002Command extends CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingEReference4002Command(CreateRelationshipRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EcorePackage.eINSTANCE.getEClass();
		};

		/**
		 * @generated
		 */
		protected void setElementToEdit(EObject element) {
			throw new UnsupportedOperationException();
		}

		/**
		 * @generated
		 */
		protected EObject doDefaultElementCreation() {
			EReference newElement = (EReference) super.doDefaultElementCreation();
			if (newElement != null) {
				newElement.setEType((EClassifier) getTarget());
				EcoreElementTypes.Initializers.EReference_4002.init(newElement);
			}
			return newElement;
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingEReference4003Command(CreateRelationshipRequest req) {
		if (!EcoreBaseItemSemanticEditPolicy.LinkConstraints.EReference_4003.canCreateLink(req, false)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingEReference4003Command(CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof EClass)) {
			return UnexecutableCommand.INSTANCE;
		}
		final EClass element = (EClass) req.getSource();
		if (!EcoreBaseItemSemanticEditPolicy.LinkConstraints.EReference_4003.canCreateLink(req, false)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(EcorePackage.eINSTANCE.getEClass_EStructuralFeatures());
		}
		return getMSLWrapper(new CreateIncomingEReference4003Command(req) {

			/**
			 * @generated
			 */
			protected EObject getElementToEdit() {
				return element;
			}
		});
	}

	/**
	 * @generated
	 */
	private static class CreateIncomingEReference4003Command extends CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingEReference4003Command(CreateRelationshipRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EcorePackage.eINSTANCE.getEClass();
		};

		/**
		 * @generated
		 */
		protected void setElementToEdit(EObject element) {
			throw new UnsupportedOperationException();
		}

		/**
		 * @generated
		 */
		protected EObject doDefaultElementCreation() {
			EReference newElement = (EReference) super.doDefaultElementCreation();
			if (newElement != null) {
				newElement.setEType((EClassifier) getTarget());
				EcoreElementTypes.Initializers.EReference_4003.init(newElement);
			}
			return newElement;
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingEClass_ESuperTypes4004Command(CreateRelationshipRequest req) {
		if (!EcoreBaseItemSemanticEditPolicy.LinkConstraints.EClassESuperTypes_4004.canCreateLink(req, false)) {
			return UnexecutableCommand.INSTANCE;
		}

		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingEClass_ESuperTypes4004Command(CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof EClass)) {
			return UnexecutableCommand.INSTANCE;
		}
		EClass element = (EClass) req.getSource();
		if (element.getESuperTypes().contains(req.getTarget())) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!EcoreBaseItemSemanticEditPolicy.LinkConstraints.EClassESuperTypes_4004.canCreateLink(req, false)) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(req.getSource(), EcorePackage.eINSTANCE.getEClass_ESuperTypes(), req.getTarget());
		return getMSLWrapper(new SetValueCommand(setReq));
	}
}
