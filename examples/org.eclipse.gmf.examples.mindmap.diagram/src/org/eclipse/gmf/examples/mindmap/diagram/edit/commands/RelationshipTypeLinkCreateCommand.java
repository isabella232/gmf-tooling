package org.eclipse.gmf.examples.mindmap.diagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Relationship;
import org.eclipse.gmf.examples.mindmap.Topic;

import org.eclipse.gmf.examples.mindmap.diagram.providers.MindmapElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

/**
 * @generated
 */
public class RelationshipTypeLinkCreateCommand extends
		CreateRelationshipCommand {

	/**
	 * @generated
	 */
	private Map myContainer;

	/**
	 * @generated
	 */
	private Topic mySource;

	/**
	 * @generated
	 */
	private Topic myTarget;

	/**
	 * @generated
	 */
	public RelationshipTypeLinkCreateCommand(CreateRelationshipRequest req,
			Map container, Topic source, Topic target) {
		super(req);
		super.setElementToEdit(container);
		myContainer = container;
		mySource = source;
		myTarget = target;
	}

	/**
	 * @generated
	 */
	public Map getContainer() {
		return myContainer;
	}

	/**
	 * @generated
	 */
	public EObject getSource() {
		return mySource;
	}

	/**
	 * @generated
	 */
	public EObject getTarget() {
		return myTarget;
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
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		Relationship newElement = (Relationship) super
				.doDefaultElementCreation();
		if (newElement != null) {
			newElement.setTarget(myTarget);
			newElement.setSource(mySource);
			MindmapElementTypes.Initializers.Relationship_3002.init(newElement);
		}
		return newElement;
	}

}
