/**
 */
package org.eclipse.gmf.tooling.examples.affixednode.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage;
import org.eclipse.gmf.tooling.examples.affixednode.Communication;
import org.eclipse.gmf.tooling.examples.affixednode.IncomingCommunicator;
import org.eclipse.gmf.tooling.examples.affixednode.OutcomingCommunicator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.impl.CommunicationImpl#getOutcomingCommunicator <em>Outcoming Communicator</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.impl.CommunicationImpl#getIncomingCommunicator <em>Incoming Communicator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicationImpl extends MinimalEObjectImpl.Container implements Communication {
	/**
	 * The cached value of the '{@link #getOutcomingCommunicator() <em>Outcoming Communicator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutcomingCommunicator()
	 * @generated
	 * @ordered
	 */
	protected OutcomingCommunicator outcomingCommunicator;

	/**
	 * The cached value of the '{@link #getIncomingCommunicator() <em>Incoming Communicator</em>}' reference.
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
	protected CommunicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AffixedNodePackage.Literals.COMMUNICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutcomingCommunicator getOutcomingCommunicator() {
		if (outcomingCommunicator != null && outcomingCommunicator.eIsProxy()) {
			InternalEObject oldOutcomingCommunicator = (InternalEObject)outcomingCommunicator;
			outcomingCommunicator = (OutcomingCommunicator)eResolveProxy(oldOutcomingCommunicator);
			if (outcomingCommunicator != oldOutcomingCommunicator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AffixedNodePackage.COMMUNICATION__OUTCOMING_COMMUNICATOR, oldOutcomingCommunicator, outcomingCommunicator));
			}
		}
		return outcomingCommunicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutcomingCommunicator basicGetOutcomingCommunicator() {
		return outcomingCommunicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutcomingCommunicator(OutcomingCommunicator newOutcomingCommunicator) {
		OutcomingCommunicator oldOutcomingCommunicator = outcomingCommunicator;
		outcomingCommunicator = newOutcomingCommunicator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AffixedNodePackage.COMMUNICATION__OUTCOMING_COMMUNICATOR, oldOutcomingCommunicator, outcomingCommunicator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncomingCommunicator getIncomingCommunicator() {
		if (incomingCommunicator != null && incomingCommunicator.eIsProxy()) {
			InternalEObject oldIncomingCommunicator = (InternalEObject)incomingCommunicator;
			incomingCommunicator = (IncomingCommunicator)eResolveProxy(oldIncomingCommunicator);
			if (incomingCommunicator != oldIncomingCommunicator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AffixedNodePackage.COMMUNICATION__INCOMING_COMMUNICATOR, oldIncomingCommunicator, incomingCommunicator));
			}
		}
		return incomingCommunicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncomingCommunicator basicGetIncomingCommunicator() {
		return incomingCommunicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncomingCommunicator(IncomingCommunicator newIncomingCommunicator) {
		IncomingCommunicator oldIncomingCommunicator = incomingCommunicator;
		incomingCommunicator = newIncomingCommunicator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AffixedNodePackage.COMMUNICATION__INCOMING_COMMUNICATOR, oldIncomingCommunicator, incomingCommunicator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AffixedNodePackage.COMMUNICATION__OUTCOMING_COMMUNICATOR:
				if (resolve) return getOutcomingCommunicator();
				return basicGetOutcomingCommunicator();
			case AffixedNodePackage.COMMUNICATION__INCOMING_COMMUNICATOR:
				if (resolve) return getIncomingCommunicator();
				return basicGetIncomingCommunicator();
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
			case AffixedNodePackage.COMMUNICATION__OUTCOMING_COMMUNICATOR:
				setOutcomingCommunicator((OutcomingCommunicator)newValue);
				return;
			case AffixedNodePackage.COMMUNICATION__INCOMING_COMMUNICATOR:
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
			case AffixedNodePackage.COMMUNICATION__OUTCOMING_COMMUNICATOR:
				setOutcomingCommunicator((OutcomingCommunicator)null);
				return;
			case AffixedNodePackage.COMMUNICATION__INCOMING_COMMUNICATOR:
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
			case AffixedNodePackage.COMMUNICATION__OUTCOMING_COMMUNICATOR:
				return outcomingCommunicator != null;
			case AffixedNodePackage.COMMUNICATION__INCOMING_COMMUNICATOR:
				return incomingCommunicator != null;
		}
		return super.eIsSet(featureID);
	}

} //CommunicationImpl
