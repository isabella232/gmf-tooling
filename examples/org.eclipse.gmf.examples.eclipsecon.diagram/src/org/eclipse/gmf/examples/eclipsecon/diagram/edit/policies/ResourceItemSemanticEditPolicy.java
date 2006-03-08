package org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Handout;
import org.eclipse.gmf.examples.eclipsecon.Resource;
import org.eclipse.gmf.examples.eclipsecon.Tutorial;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;

/**
 * @generated
 */
public class ResourceItemSemanticEditPolicy extends
		EclipseconBaseItemSemanticEditPolicy {

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
		if (EclipseconElementTypes.Handout_3001 == req.getElementType()) {
			return req.getTarget() == null ? null
					: getCreateCompleteIncomingHandout3001Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingHandout3001Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof Tutorial)) {
			return UnexecutableCommand.INSTANCE;
		}
		final Tutorial element = (Tutorial) req.getSource();
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(EclipseconPackage.eINSTANCE
					.getTutorial_Handouts());
		}
		return getMSLWrapper(new CreateIncomingHandout3001Command(req) {

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
	private static class CreateIncomingHandout3001Command extends
			CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingHandout3001Command(CreateRelationshipRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EclipseconPackage.eINSTANCE.getTutorial();
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
			Handout newElement = (Handout) super.doDefaultElementCreation();
			if (newElement != null) {
				newElement.setEclipsezilla((Resource) getTarget());
			}
			return newElement;
		}
	}
}
