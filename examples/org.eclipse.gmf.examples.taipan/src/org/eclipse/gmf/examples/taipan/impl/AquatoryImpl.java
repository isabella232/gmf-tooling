/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aquatory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.taipan.impl.AquatoryImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.taipan.impl.AquatoryImpl#getShips <em>Ships</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.taipan.impl.AquatoryImpl#getRoutes <em>Routes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AquatoryImpl extends EObjectImpl implements Aquatory {

	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList ports = null;

	/**
	 * The cached value of the '{@link #getShips() <em>Ships</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShips()
	 * @generated
	 * @ordered
	 */
	protected EList ships = null;

	/**
	 * The cached value of the '{@link #getRoutes() <em>Routes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutes()
	 * @generated
	 * @ordered
	 */
	protected EList routes = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AquatoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TaiPanPackage.Literals.AQUATORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentEList(Port.class, this, TaiPanPackage.AQUATORY__PORTS);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getShips() {
		if (ships == null) {
			ships = new EObjectContainmentEList(Ship.class, this, TaiPanPackage.AQUATORY__SHIPS);
		}
		return ships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRoutes() {
		if (routes == null) {
			routes = new EObjectContainmentEList(Route.class, this, TaiPanPackage.AQUATORY__ROUTES);
		}
		return routes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TaiPanPackage.AQUATORY__PORTS:
			return ((InternalEList) getPorts()).basicRemove(otherEnd, msgs);
		case TaiPanPackage.AQUATORY__SHIPS:
			return ((InternalEList) getShips()).basicRemove(otherEnd, msgs);
		case TaiPanPackage.AQUATORY__ROUTES:
			return ((InternalEList) getRoutes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TaiPanPackage.AQUATORY__PORTS:
			return getPorts();
		case TaiPanPackage.AQUATORY__SHIPS:
			return getShips();
		case TaiPanPackage.AQUATORY__ROUTES:
			return getRoutes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TaiPanPackage.AQUATORY__PORTS:
			getPorts().clear();
			getPorts().addAll((Collection) newValue);
			return;
		case TaiPanPackage.AQUATORY__SHIPS:
			getShips().clear();
			getShips().addAll((Collection) newValue);
			return;
		case TaiPanPackage.AQUATORY__ROUTES:
			getRoutes().clear();
			getRoutes().addAll((Collection) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case TaiPanPackage.AQUATORY__PORTS:
			getPorts().clear();
			return;
		case TaiPanPackage.AQUATORY__SHIPS:
			getShips().clear();
			return;
		case TaiPanPackage.AQUATORY__ROUTES:
			getRoutes().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case TaiPanPackage.AQUATORY__PORTS:
			return ports != null && !ports.isEmpty();
		case TaiPanPackage.AQUATORY__SHIPS:
			return ships != null && !ships.isEmpty();
		case TaiPanPackage.AQUATORY__ROUTES:
			return routes != null && !routes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AquatoryImpl
