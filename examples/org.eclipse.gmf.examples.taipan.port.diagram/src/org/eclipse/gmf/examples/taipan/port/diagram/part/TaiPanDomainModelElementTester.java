/*
 *  Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.port.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

/**
 * @generated
 */
public class TaiPanDomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args, Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == TaiPanPackage.eINSTANCE.getAquatory()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getPort()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getBuilding()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getRoute()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getShip()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getItem()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getLargeItem()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getSmallItems()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getEmptyBox()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getWarship()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getOrder()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getEscortShipOrder()) {
			return true;
		}
		if (eClass == TaiPanPackage.eINSTANCE.getBesiegePortOrder()) {
			return true;
		}
		return false;
	}

}
