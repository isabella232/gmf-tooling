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
package org.eclipse.gmf.examples.taipan;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Escort Ship Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.taipan.EscortShipOrder#getShip <em>Ship</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.taipan.TaiPanPackage#getEscortShipOrder()
 * @model
 * @generated
 */
public interface EscortShipOrder extends Order {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Ship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ship</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ship</em>' reference.
	 * @see #setShip(Ship)
	 * @see org.eclipse.gmf.examples.taipan.TaiPanPackage#getEscortShipOrder_Ship()
	 * @model required="true"
	 * @generated
	 */
	Ship getShip();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.taipan.EscortShipOrder#getShip <em>Ship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ship</em>' reference.
	 * @see #getShip()
	 * @generated
	 */
	void setShip(Ship value);

} // EscortShipOrder
