package org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gmf.examples.eclipsecon.Conference;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconElementTypes;

import org.eclipse.gmf.runtime.emf.core.internal.util.Util;

import org.eclipse.gmf.runtime.emf.core.resources.IResourceHelper;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

/**
 * @generated
 */
public class ConferenceItemSemanticEditPolicy extends
		EclipseconBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EclipseconElementTypes.Presenter_1001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(EclipseconPackage.eINSTANCE
						.getConference_Attendees());
			}
			return getMSLWrapper(new CreatePresenter_1001Command(req));
		}
		if (EclipseconElementTypes.Tutorial_1002 == req.getElementType()) {
			Conference container = (Conference) (req.getContainer() instanceof View ? ((View) req
					.getContainer()).getElement()
					: req.getContainer());
			if (container.getTutorials().size() >= 20) {
				return super.getCreateCommand(req);
			}
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(EclipseconPackage.eINSTANCE
						.getConference_Tutorials());
			}
			return getMSLWrapper(new CreateTutorial_1002Command(req));
		}
		if (EclipseconElementTypes.Schedule_1003 == req.getElementType()) {
			Conference container = (Conference) (req.getContainer() instanceof View ? ((View) req
					.getContainer()).getElement()
					: req.getContainer());
			if (container.getDays().size() >= 2) {
				return super.getCreateCommand(req);
			}
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(EclipseconPackage.eINSTANCE
						.getConference_Days());
			}
			return getMSLWrapper(new CreateSchedule_1003Command(req));
		}
		if (EclipseconElementTypes.Resource_1004 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(EclipseconPackage.eINSTANCE
						.getConference_Eclipsezilla());
			}
			return getMSLWrapper(new CreateResource_1004Command(req));
		}
		if (EclipseconElementTypes.TimeSlot_1005 == req.getElementType()) {
			return getMSLWrapper(new CreateTimeSlot_1005Command(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	private static class CreatePresenter_1001Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreatePresenter_1001Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EclipseconPackage.eINSTANCE.getConference();
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
	private static class CreateTutorial_1002Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateTutorial_1002Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EclipseconPackage.eINSTANCE.getConference();
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
	private static class CreateSchedule_1003Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateSchedule_1003Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EclipseconPackage.eINSTANCE.getConference();
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
	private static class CreateResource_1004Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateResource_1004Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EclipseconPackage.eINSTANCE.getConference();
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
	private static class CreateTimeSlot_1005Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateTimeSlot_1005Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EclipseconPackage.eINSTANCE.getConference();
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

		/**
		 * @generated
		 */
		public boolean canExecute() {
			if (getEClass() != null) {
				return getEClass().isSuperTypeOf(getEClassToEdit());
			}
			return true;
		}

		/**
		 * @generated
		 */
		protected EReference getContainmentFeature() {
			return null;
		}

		/**
		 * @generated
		 */
		protected EObject doDefaultElementCreation() {
			// Uncomment to put "phantom" objects into the diagram file.		
			//Resource resource = ((CreateElementRequest) getRequest()).getContainer().eResource();
			//if (resource == null) {
			//	return null;
			//}
			Resource resource = getElementToEdit().eResource();
			EClass eClass = getElementType().getEClass();
			IResourceHelper helper = Util.getHelper(resource);
			EObject eObject;
			if (helper != null) {
				eObject = helper.create(eClass);
			} else {
				eObject = eClass.getEPackage().getEFactoryInstance().create(
						eClass);
			}
			resource.getContents().add(eObject);
			return eObject;
		}
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getMSLWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}
	}
}
