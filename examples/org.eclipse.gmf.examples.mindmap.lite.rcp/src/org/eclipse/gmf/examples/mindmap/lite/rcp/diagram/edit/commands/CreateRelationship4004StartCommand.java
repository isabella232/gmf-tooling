package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.runtime.lite.commands.VetoCommand;

import org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class CreateRelationship4004StartCommand extends VetoCommand {
	/**
	 * @generated
	 */
	private View source;

	/**
	 * @generated
	 */
	public CreateRelationship4004StartCommand(
			CreateConnectionRequestEx requestEx) {
		//Until the mouse button is pressed, the source of the connection is in request.getTargetEditPart(), not in request.getSourceEditPart().
		source = (View) requestEx.getTargetEditPart().getModel();
	}

	/**
	 * @generated
	 */
	protected boolean shouldExecute() {
		if (source == null) {
			return false;
		}
		Map container = (Map) getRelationshipContainer(source.getElement(),
				MindmapPackage.eINSTANCE.getMap());
		if (container == null) {
			return false;
		}

		return true;
	}

	/**
	 * Finds container element for the relationship of the specified type.
	 * Default implementation goes up by containment hierarchy starting from
	 * the specified element and returns the first element that is instance of
	 * the specified container class.
	 * 
	 * @generated
	 */
	protected EObject getRelationshipContainer(EObject element,
			EClass containerClass) {
		for (; element != null; element = element.eContainer()) {
			if (containerClass.isSuperTypeOf(element.eClass())) {
				return element;
			}
		}
		return null;
	}
}
