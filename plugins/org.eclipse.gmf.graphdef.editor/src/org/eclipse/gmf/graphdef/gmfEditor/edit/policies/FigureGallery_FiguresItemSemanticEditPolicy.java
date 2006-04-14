package org.eclipse.gmf.graphdef.gmfEditor.edit.policies;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.gmfgraph.GMFGraphPackage;

import org.eclipse.gmf.graphdef.gmfEditor.providers.GMFGraphElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class FigureGallery_FiguresItemSemanticEditPolicy extends GMFGraphBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (GMFGraphElementTypes.Rectangle_2001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigureGallery_Figures());
			}
			return getMSLWrapper(new CreateRectangle_2001Command(req));
		}
		if (GMFGraphElementTypes.Ellipse_2006 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigureGallery_Figures());
			}
			return getMSLWrapper(new CreateEllipse_2006Command(req));
		}
		if (GMFGraphElementTypes.RoundedRectangle_2007 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigureGallery_Figures());
			}
			return getMSLWrapper(new CreateRoundedRectangle_2007Command(req));
		}
		if (GMFGraphElementTypes.Polyline_2008 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigureGallery_Figures());
			}
			return getMSLWrapper(new CreatePolyline_2008Command(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	private static class CreateRectangle_2001Command extends CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateRectangle_2001Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return GMFGraphPackage.eINSTANCE.getFigureGallery();
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

	/**
	 * @generated
	 */
	private static class CreateEllipse_2006Command extends CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateEllipse_2006Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return GMFGraphPackage.eINSTANCE.getFigureGallery();
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

	/**
	 * @generated
	 */
	private static class CreateRoundedRectangle_2007Command extends CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateRoundedRectangle_2007Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return GMFGraphPackage.eINSTANCE.getFigureGallery();
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

	/**
	 * @generated
	 */
	private static class CreatePolyline_2008Command extends CreateElementCommand {

		/**
		 * @generated
		 */
		public CreatePolyline_2008Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return GMFGraphPackage.eINSTANCE.getFigureGallery();
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
