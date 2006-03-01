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
public class EDataTypeItemSemanticEditPolicy extends EcoreBaseItemSemanticEditPolicy {

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
		if (EcoreElementTypes.EAnnotationReferences_3001 == req.getElementType()) {
			return req.getTarget() == null ? null : getCreateCompleteIncomingEAnnotation_References3001Command(req);
		}
		if (EcoreElementTypes.EReference_3002 == req.getElementType()) {
			return req.getTarget() == null ? null : getCreateCompleteIncomingEReference3002Command(req);
		}
		if (EcoreElementTypes.EReference_3003 == req.getElementType()) {
			return req.getTarget() == null ? null : getCreateCompleteIncomingEReference3003Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingEAnnotation_References3001Command(CreateRelationshipRequest req) {
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
	protected Command getCreateCompleteIncomingEReference3002Command(CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof EClass)) {
			return UnexecutableCommand.INSTANCE;
		}
		final EClass element = (EClass) req.getSource();
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(EcorePackage.eINSTANCE.getEClass_EStructuralFeatures());
		}
		return getMSLWrapper(new CreateIncomingEReference3002Command(req) {

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
	private static class CreateIncomingEReference3002Command extends CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingEReference3002Command(CreateRelationshipRequest req) {
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
				EcoreElementTypes.Initializers.EReference_3002.init(newElement);
			}
			return newElement;
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingEReference3003Command(CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof EClass)) {
			return UnexecutableCommand.INSTANCE;
		}
		final EClass element = (EClass) req.getSource();
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(EcorePackage.eINSTANCE.getEClass_EStructuralFeatures());
		}
		return getMSLWrapper(new CreateIncomingEReference3003Command(req) {

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
	private static class CreateIncomingEReference3003Command extends CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingEReference3003Command(CreateRelationshipRequest req) {
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
				EcoreElementTypes.Initializers.EReference_3003.init(newElement);
			}
			return newElement;
		}
	}
}
