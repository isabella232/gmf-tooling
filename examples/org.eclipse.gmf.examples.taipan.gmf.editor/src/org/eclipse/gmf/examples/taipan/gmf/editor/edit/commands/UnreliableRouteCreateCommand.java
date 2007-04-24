/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.TaiPanBaseItemSemanticEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

/**
 * @generated
 */
public class UnreliableRouteCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	private final Aquatory container;

	/**
	 * @generated
	 */
	public UnreliableRouteCreateCommand(CreateRelationshipRequest request) {
		super(request);
		source = request.getSource();
		target = request.getTarget();
		if (request.getContainmentFeature() == null) {
			setContainmentFeature(TaiPanPackage.eINSTANCE.getAquatory_Routes());
		}
		if (source != null) {
			container = (Aquatory) findLinkContainer(source, TaiPanPackage.eINSTANCE.getAquatory());
			super.setElementToEdit(container);
		} else {
			container = null;
		}
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && !(source instanceof Port)) {
			return false;
		}
		if (target != null && !(target instanceof Port)) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return TaiPanBaseItemSemanticEditPolicy.LinkConstraints.canCreateRoute_4003(getContainer(), getSource(), getTarget());
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		Route newElement = (Route) super.doDefaultElementCreation();
		if (newElement != null) {
			newElement.setSource(getSource());
			newElement.setDestination(getTarget());
			TaiPanElementTypes.Initializers.Route_4003.init(newElement);
		}
		return newElement;
	}

	/**
	 * Finds container element for the new link.
	 * Default implementation goes up by containment hierarchy starting from
	 * the specified element and returns the first element that is instance of
	 * the container class.
	 * 
	 * @generated
	 */
	protected EObject findLinkContainer(Object uelement, EClass containerClass) {
		if (uelement instanceof EObject) {
			EObject element = (EObject) uelement;
			for (; element != null; element = element.eContainer()) {
				if (containerClass.isSuperTypeOf(element.eClass())) {
					return element;
				}
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return TaiPanPackage.eINSTANCE.getAquatory();
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		return super.doExecuteWithResult(monitor, info);
	}

	/**
	 * @generated
	 */
	protected ConfigureRequest createConfigureRequest() {
		ConfigureRequest request = super.createConfigureRequest();
		request.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		request.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		return request;
	}

	/**
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected Port getSource() {
		return (Port) source;
	}

	/**
	 * @generated
	 */
	protected Port getTarget() {
		return (Port) target;
	}

	/**
	 * @generated
	 */
	public Aquatory getContainer() {
		return container;
	}
}
