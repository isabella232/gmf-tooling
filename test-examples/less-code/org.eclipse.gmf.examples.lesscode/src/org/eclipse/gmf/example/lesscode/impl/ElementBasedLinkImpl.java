/**
 */
package org.eclipse.gmf.example.lesscode.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmf.example.lesscode.ElementBasedLink;
import org.eclipse.gmf.example.lesscode.LesscodePackage;
import org.eclipse.gmf.example.lesscode.Subject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Based Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.example.lesscode.impl.ElementBasedLinkImpl#getLinkSource <em>Link Source</em>}</li>
 *   <li>{@link org.eclipse.gmf.example.lesscode.impl.ElementBasedLinkImpl#getLinkTarget <em>Link Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementBasedLinkImpl extends WithSomeAttributesImpl implements ElementBasedLink {
	/**
	 * The cached value of the '{@link #getLinkSource() <em>Link Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkSource()
	 * @generated
	 * @ordered
	 */
	protected Subject linkSource;

	/**
	 * The cached value of the '{@link #getLinkTarget() <em>Link Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkTarget()
	 * @generated
	 * @ordered
	 */
	protected Subject linkTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementBasedLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LesscodePackage.Literals.ELEMENT_BASED_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subject getLinkSource() {
		if (linkSource != null && linkSource.eIsProxy()) {
			InternalEObject oldLinkSource = (InternalEObject)linkSource;
			linkSource = (Subject)eResolveProxy(oldLinkSource);
			if (linkSource != oldLinkSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LesscodePackage.ELEMENT_BASED_LINK__LINK_SOURCE, oldLinkSource, linkSource));
			}
		}
		return linkSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subject basicGetLinkSource() {
		return linkSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkSource(Subject newLinkSource) {
		Subject oldLinkSource = linkSource;
		linkSource = newLinkSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LesscodePackage.ELEMENT_BASED_LINK__LINK_SOURCE, oldLinkSource, linkSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subject getLinkTarget() {
		if (linkTarget != null && linkTarget.eIsProxy()) {
			InternalEObject oldLinkTarget = (InternalEObject)linkTarget;
			linkTarget = (Subject)eResolveProxy(oldLinkTarget);
			if (linkTarget != oldLinkTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LesscodePackage.ELEMENT_BASED_LINK__LINK_TARGET, oldLinkTarget, linkTarget));
			}
		}
		return linkTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subject basicGetLinkTarget() {
		return linkTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkTarget(Subject newLinkTarget) {
		Subject oldLinkTarget = linkTarget;
		linkTarget = newLinkTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LesscodePackage.ELEMENT_BASED_LINK__LINK_TARGET, oldLinkTarget, linkTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LesscodePackage.ELEMENT_BASED_LINK__LINK_SOURCE:
				if (resolve) return getLinkSource();
				return basicGetLinkSource();
			case LesscodePackage.ELEMENT_BASED_LINK__LINK_TARGET:
				if (resolve) return getLinkTarget();
				return basicGetLinkTarget();
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
			case LesscodePackage.ELEMENT_BASED_LINK__LINK_SOURCE:
				setLinkSource((Subject)newValue);
				return;
			case LesscodePackage.ELEMENT_BASED_LINK__LINK_TARGET:
				setLinkTarget((Subject)newValue);
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
			case LesscodePackage.ELEMENT_BASED_LINK__LINK_SOURCE:
				setLinkSource((Subject)null);
				return;
			case LesscodePackage.ELEMENT_BASED_LINK__LINK_TARGET:
				setLinkTarget((Subject)null);
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
			case LesscodePackage.ELEMENT_BASED_LINK__LINK_SOURCE:
				return linkSource != null;
			case LesscodePackage.ELEMENT_BASED_LINK__LINK_TARGET:
				return linkTarget != null;
		}
		return super.eIsSet(featureID);
	}

} //ElementBasedLinkImpl
