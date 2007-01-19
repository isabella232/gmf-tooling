package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gef.requests.ReconnectRequest;

import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.runtime.lite.commands.ReconnectNotationalEdgeSourceCommand;

import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ReconnectRelationship4002SourceCommand extends CommandWrapper {
	/**
	 * @generated
	 */
	private Edge edge;
	/**
	 * @generated
	 */
	private View newSource;
	/**
	 * @generated
	 */
	private View oldSource;

	/**
	 * @generated
	 */
	public ReconnectRelationship4002SourceCommand(ReconnectRequest request) {
		this((Edge) request.getConnectionEditPart().getModel(), (View) request
				.getTarget().getModel());
	}

	/**
	 * @generated
	 */
	public ReconnectRelationship4002SourceCommand(Edge edge, View newSource) {
		this.edge = edge;
		this.newSource = newSource;
		this.oldSource = edge.getSource();
	}

	/**
	 * @generated
	 */
	protected boolean prepare() {
		if (!canReconnect()) {
			return false;
		}
		return super.prepare();
	}

	/**
	 * @generated
	 */
	private boolean canReconnect() {
		Map container = (Map) getRelationshipContainer(newSource.getElement(),
				MindmapPackage.eINSTANCE.getMap());
		if (container == null) {
			return false;
		}

		return true;
	}

	/**
	 * @generated
	 */
	protected Command createCommand() {
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(oldSource.getDiagram().getElement());
		CompoundCommand result = new CompoundCommand();
		result
				.append(new ReconnectNotationalEdgeSourceCommand(edge,
						newSource));
		EObject container = getRelationshipContainer(newSource.getElement(),
				MindmapPackage.eINSTANCE.getMap());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		EObject oldContainer = edge.getElement().eContainer();
		if (oldContainer == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (oldContainer != container) {
			result.append(RemoveCommand.create(editingDomain, edge.getElement()
					.eContainer(), MindmapPackage.eINSTANCE.getMap_Relations(),
					edge.getElement()));
			result.append(AddCommand.create(editingDomain, container,
					MindmapPackage.eINSTANCE.getMap_Relations(), edge
							.getElement()));
		}
		result.append(SetCommand.create(editingDomain, edge.getElement(),
				MindmapPackage.eINSTANCE.getRelationship_Source(), newSource
						.getElement()));
		return result;
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
