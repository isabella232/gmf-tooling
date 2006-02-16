package org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Schedule;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ScheduleItemSemanticEditPolicy extends
		EclipseconBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EclipseconElementTypes.TimeSlot_2001 == req.getElementType()) {
			Schedule container = (Schedule) (req.getContainer() instanceof View ? ((View) req
					.getContainer()).getElement()
					: req.getContainer());
			if (container.getSlices().size() >= 5) {
				return super.getCreateCommand(req);
			}
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(EclipseconPackage.eINSTANCE
						.getSchedule_Slices());
			}
			return getMSLWrapper(new CreateTimeSlot_2001Command(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	private static class CreateTimeSlot_2001Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateTimeSlot_2001Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EclipseconPackage.eINSTANCE.getSchedule();
		};

		/**
		 * @generated
		 */
		protected EObject getElementToEdit() {
			EObject container = ((CreateElementRequest) getRequest())
					.getContainer();
			if (container instanceof View) {
				container = ((View) container).getElement();
			}
			return container;
		}
	}

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
		return super.getCreateRelationshipCommand(req);
	}
}
