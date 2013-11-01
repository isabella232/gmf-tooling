/**
 */
package org.eclipse.gmf.tooling.examples.affixednode.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage;
import org.eclipse.gmf.tooling.examples.affixednode.Bundle;
import org.eclipse.gmf.tooling.examples.affixednode.IncomingCommunicator;
import org.eclipse.gmf.tooling.examples.affixednode.OutcomingCommunicator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bundle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.impl.BundleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.impl.BundleImpl#getOutcomingCommunicator <em>Outcoming Communicator</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.impl.BundleImpl#getIncomingCommunicator <em>Incoming Communicator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BundleImpl extends MinimalEObjectImpl.Container implements Bundle {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutcomingCommunicator() <em>Outcoming Communicator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutcomingCommunicator()
	 * @generated
	 * @ordered
	 */
	protected OutcomingCommunicator outcomingCommunicator;

	/**
	 * The cached value of the '{@link #getIncomingCommunicator() <em>Incoming Communicator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingCommunicator()
	 * @generated
	 * @ordered
	 */
	protected IncomingCommunicator incomingCommunicator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AffixedNodePackage.Literals.BUNDLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AffixedNodePackage.BUNDLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutcomingCommunicator getOutcomingCommunicator() {
		return outcomingCommunicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutcomingCommunicator(OutcomingCommunicator newOutcomingCommunicator, NotificationChain msgs) {
		OutcomingCommunicator oldOutcomingCommunicator = outcomingCommunicator;
		outcomingCommunicator = newOutcomingCommunicator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AffixedNodePackage.BUNDLE__OUTCOMING_COMMUNICATOR, oldOutcomingCommunicator, newOutcomingCommunicator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutcomingCommunicator(OutcomingCommunicator newOutcomingCommunicator) {
		if (newOutcomingCommunicator != outcomingCommunicator) {
			NotificationChain msgs = null;
			if (outcomingCommunicator != null)
				msgs = ((InternalEObject)outcomingCommunicator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AffixedNodePackage.BUNDLE__OUTCOMING_COMMUNICATOR, null, msgs);
			if (newOutcomingCommunicator != null)
				msgs = ((InternalEObject)newOutcomingCommunicator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AffixedNodePackage.BUNDLE__OUTCOMING_COMMUNICATOR, null, msgs);
			msgs = basicSetOutcomingCommunicator(newOutcomingCommunicator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AffixedNodePackage.BUNDLE__OUTCOMING_COMMUNICATOR, newOutcomingCommunicator, newOutcomingCommunicator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncomingCommunicator getIncomingCommunicator() {
		return incomingCommunicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncomingCommunicator(IncomingCommunicator newIncomingCommunicator, NotificationChain msgs) {
		IncomingCommunicator oldIncomingCommunicator = incomingCommunicator;
		incomingCommunicator = newIncomingCommunicator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AffixedNodePackage.BUNDLE__INCOMING_COMMUNICATOR, oldIncomingCommunicator, newIncomingCommunicator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncomingCommunicator(IncomingCommunicator newIncomingCommunicator) {
		if (newIncomingCommunicator != incomingCommunicator) {
			NotificationChain msgs = null;
			if (incomingCommunicator != null)
				msgs = ((InternalEObject)incomingCommunicator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AffixedNodePackage.BUNDLE__INCOMING_COMMUNICATOR, null, msgs);
			if (newIncomingCommunicator != null)
				msgs = ((InternalEObject)newIncomingCommunicator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AffixedNodePackage.BUNDLE__INCOMING_COMMUNICATOR, null, msgs);
			msgs = basicSetIncomingCommunicator(newIncomingCommunicator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AffixedNodePackage.BUNDLE__INCOMING_COMMUNICATOR, newIncomingCommunicator, newIncomingCommunicator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AffixedNodePackage.BUNDLE__OUTCOMING_COMMUNICATOR:
				return basicSetOutcomingCommunicator(null, msgs);
			case AffixedNodePackage.BUNDLE__INCOMING_COMMUNICATOR:
				return basicSetIncomingCommunicator(null, msgs);
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
			case AffixedNodePackage.BUNDLE__NAME:
				return getName();
			case AffixedNodePackage.BUNDLE__OUTCOMING_COMMUNICATOR:
				return getOutcomingCommunicator();
			case AffixedNodePackage.BUNDLE__INCOMING_COMMUNICATOR:
				return getIncomingCommunicator();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AffixedNodePackage.BUNDLE__NAME:
				setName((String)newValue);
				return;
			case AffixedNodePackage.BUNDLE__OUTCOMING_COMMUNICATOR:
				setOutcomingCommunicator((OutcomingCommunicator)newValue);
				return;
			case AffixedNodePackage.BUNDLE__INCOMING_COMMUNICATOR:
				setIncomingCommunicator((IncomingCommunicator)newValue);
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
			case AffixedNodePackage.BUNDLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AffixedNodePackage.BUNDLE__OUTCOMING_COMMUNICATOR:
				setOutcomingCommunicator((OutcomingCommunicator)null);
				return;
			case AffixedNodePackage.BUNDLE__INCOMING_COMMUNICATOR:
				setIncomingCommunicator((IncomingCommunicator)null);
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
			case AffixedNodePackage.BUNDLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AffixedNodePackage.BUNDLE__OUTCOMING_COMMUNICATOR:
				return outcomingCommunicator != null;
			case AffixedNodePackage.BUNDLE__INCOMING_COMMUNICATOR:
				return incomingCommunicator != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //BundleImpl
