/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.sketch.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.sketch.SketchCompartment;
import org.eclipse.gmf.sketch.SketchNode;
import org.eclipse.gmf.sketch.SketchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchCompartmentImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchCompartmentImpl#getReferencedNodes <em>Referenced Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SketchCompartmentImpl extends SketchDiagramElementImpl implements SketchCompartment {

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<SketchNode> nodes;

	/**
	 * The cached value of the '{@link #getReferencedNodes() <em>Referenced Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<SketchNode> referencedNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SketchCompartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SketchPackage.Literals.SKETCH_COMPARTMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SketchNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<SketchNode>(SketchNode.class, this, SketchPackage.SKETCH_COMPARTMENT__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SketchNode> getReferencedNodes() {
		if (referencedNodes == null) {
			referencedNodes = new EObjectResolvingEList<SketchNode>(SketchNode.class, this, SketchPackage.SKETCH_COMPARTMENT__REFERENCED_NODES);
		}
		return referencedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SketchPackage.SKETCH_COMPARTMENT__NODES:
			return ((InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SketchPackage.SKETCH_COMPARTMENT__NODES:
			return getNodes();
		case SketchPackage.SKETCH_COMPARTMENT__REFERENCED_NODES:
			return getReferencedNodes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SketchPackage.SKETCH_COMPARTMENT__NODES:
			getNodes().clear();
			getNodes().addAll((Collection<? extends SketchNode>) newValue);
			return;
		case SketchPackage.SKETCH_COMPARTMENT__REFERENCED_NODES:
			getReferencedNodes().clear();
			getReferencedNodes().addAll((Collection<? extends SketchNode>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SketchPackage.SKETCH_COMPARTMENT__NODES:
			getNodes().clear();
			return;
		case SketchPackage.SKETCH_COMPARTMENT__REFERENCED_NODES:
			getReferencedNodes().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SketchPackage.SKETCH_COMPARTMENT__NODES:
			return nodes != null && !nodes.isEmpty();
		case SketchPackage.SKETCH_COMPARTMENT__REFERENCED_NODES:
			return referencedNodes != null && !referencedNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SketchCompartmentImpl
