package org.eclipse.gmf.examples.mindmap.diagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ResourceCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public ResourceCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return MindmapPackage.eINSTANCE.getMap();
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
