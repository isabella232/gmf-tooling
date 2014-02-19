/**
 */
package org.eclipse.gmf.tooling.examples.affixednode.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage;
import org.eclipse.gmf.tooling.examples.affixednode.Bundle;
import org.eclipse.gmf.tooling.examples.affixednode.Canvas;
import org.eclipse.gmf.tooling.examples.affixednode.Communication;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Canvas</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.impl.CanvasImpl#getBundles <em>Bundles</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.impl.CanvasImpl#getCommunications <em>Communications</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CanvasImpl extends MinimalEObjectImpl.Container implements Canvas {
	/**
	 * The cached value of the '{@link #getBundles() <em>Bundles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundles()
	 * @generated
	 * @ordered
	 */
	protected EList<Bundle> bundles;

	/**
	 * The cached value of the '{@link #getCommunications() <em>Communications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunications()
	 * @generated
	 * @ordered
	 */
	protected EList<Communication> communications;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CanvasImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AffixedNodePackage.Literals.CANVAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Bundle> getBundles() {
		if (bundles == null) {
			bundles = new EObjectContainmentEList<Bundle>(Bundle.class, this, AffixedNodePackage.CANVAS__BUNDLES);
		}
		return bundles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Communication> getCommunications() {
		if (communications == null) {
			communications = new EObjectContainmentEList<Communication>(Communication.class, this, AffixedNodePackage.CANVAS__COMMUNICATIONS);
		}
		return communications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AffixedNodePackage.CANVAS__BUNDLES:
				return ((InternalEList<?>)getBundles()).basicRemove(otherEnd, msgs);
			case AffixedNodePackage.CANVAS__COMMUNICATIONS:
				return ((InternalEList<?>)getCommunications()).basicRemove(otherEnd, msgs);
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
			case AffixedNodePackage.CANVAS__BUNDLES:
				return getBundles();
			case AffixedNodePackage.CANVAS__COMMUNICATIONS:
				return getCommunications();
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
			case AffixedNodePackage.CANVAS__BUNDLES:
				getBundles().clear();
				getBundles().addAll((Collection<? extends Bundle>)newValue);
				return;
			case AffixedNodePackage.CANVAS__COMMUNICATIONS:
				getCommunications().clear();
				getCommunications().addAll((Collection<? extends Communication>)newValue);
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
			case AffixedNodePackage.CANVAS__BUNDLES:
				getBundles().clear();
				return;
			case AffixedNodePackage.CANVAS__COMMUNICATIONS:
				getCommunications().clear();
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
			case AffixedNodePackage.CANVAS__BUNDLES:
				return bundles != null && !bundles.isEmpty();
			case AffixedNodePackage.CANVAS__COMMUNICATIONS:
				return communications != null && !communications.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CanvasImpl
