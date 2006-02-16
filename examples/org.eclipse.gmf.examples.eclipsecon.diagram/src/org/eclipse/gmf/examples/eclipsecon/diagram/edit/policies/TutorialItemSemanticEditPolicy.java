package org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gmf.examples.eclipsecon.Tutorial;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconElementTypes;

/**
 * @generated
 */
public class TutorialItemSemanticEditPolicy extends
		EclipseconBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getMSLWrapper(new DestroyElementCommand(req) {

			protected EObject getElementToDestroy() {
				View view = (View) getHost().getModel();
				EAnnotation annotation = view.getEAnnotation("Shortcutted"); //$NON-NLS-1$
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
			return req.getTarget() == null ? getCreateStartOutgoingHandout3001Command(req)
					: null;
		}
		if (EclipseconElementTypes.TutorialPresenters_3002 == req
				.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingTutorial_Presenters3002Command(req)
					: null;
		}
		if (EclipseconElementTypes.TutorialAssigned_3003 == req
				.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingTutorial_Assigned3003Command(req)
					: null;
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingHandout3001Command(
			CreateRelationshipRequest req) {
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingTutorial_Presenters3002Command(
			CreateRelationshipRequest req) {
		Tutorial element = (Tutorial) getSemanticElement();
		if (element.getPresenters().size() >= 2) {
			return UnexecutableCommand.INSTANCE;
		}

		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingTutorial_Assigned3003Command(
			CreateRelationshipRequest req) {
		Tutorial element = (Tutorial) getSemanticElement();
		if (element.getAssigned() != null) {
			return UnexecutableCommand.INSTANCE;
		}

		return new Command() {
		};
	}
}
