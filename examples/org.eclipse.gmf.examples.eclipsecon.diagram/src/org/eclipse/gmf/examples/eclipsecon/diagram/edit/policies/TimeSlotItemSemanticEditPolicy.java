package org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.core.commands.ExecutionException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Tutorial;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconElementTypes;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;

import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * @generated
 */
public class TimeSlotItemSemanticEditPolicy extends
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

			protected CommandResult doExecuteWithResult(
					IProgressMonitor progressMonitor, IAdaptable info)
					throws ExecutionException {
				EObject eObject = getElementToDestroy();
				boolean removeFromResource = eObject.eContainer() == null;
				CommandResult result = super.doExecuteWithResult(
						progressMonitor, info);
				Resource resource = eObject.eResource();
				if (removeFromResource && resource != null) {
					resource.getContents().remove(eObject);
				}
				return result;
			}
		});
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (EclipseconElementTypes.TutorialAssigned_3002 == req
				.getElementType()) {
			return req.getTarget() == null ? null
					: getCreateCompleteIncomingTutorial_Assigned3002Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingTutorial_Assigned3002Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof Tutorial)) {
			return UnexecutableCommand.INSTANCE;
		}
		Tutorial element = (Tutorial) req.getSource();
		if (element.getAssigned() != null) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(req.getSource(),
				EclipseconPackage.eINSTANCE.getTutorial_Assigned(), req
						.getTarget());
		return getMSLWrapper(new SetValueCommand(setReq));
	}
}
