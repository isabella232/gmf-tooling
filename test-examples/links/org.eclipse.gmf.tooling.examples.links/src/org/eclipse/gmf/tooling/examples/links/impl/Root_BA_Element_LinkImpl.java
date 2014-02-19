/**
 */
package org.eclipse.gmf.tooling.examples.links.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.gmf.tooling.examples.links.LinksPackage;
import org.eclipse.gmf.tooling.examples.links.RootNodeA;
import org.eclipse.gmf.tooling.examples.links.RootNodeB;
import org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root BA Element Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.Root_BA_Element_LinkImpl#getB <em>B</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.Root_BA_Element_LinkImpl#getA <em>A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Root_BA_Element_LinkImpl extends MinimalEObjectImpl.Container implements Root_BA_Element_Link {
	/**
	 * The cached value of the '{@link #getB() <em>B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB()
	 * @generated
	 * @ordered
	 */
	protected RootNodeB b;

	/**
	 * The cached value of the '{@link #getA() <em>A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected RootNodeA a;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Root_BA_Element_LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LinksPackage.Literals.ROOT_BA_ELEMENT_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootNodeB getB() {
		if (b != null && b.eIsProxy()) {
			InternalEObject oldB = (InternalEObject)b;
			b = (RootNodeB)eResolveProxy(oldB);
			if (b != oldB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LinksPackage.ROOT_BA_ELEMENT_LINK__B, oldB, b));
			}
		}
		return b;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootNodeB basicGetB() {
		return b;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setB(RootNodeB newB) {
		RootNodeB oldB = b;
		b = newB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinksPackage.ROOT_BA_ELEMENT_LINK__B, oldB, b));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootNodeA getA() {
		if (a != null && a.eIsProxy()) {
			InternalEObject oldA = (InternalEObject)a;
			a = (RootNodeA)eResolveProxy(oldA);
			if (a != oldA) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LinksPackage.ROOT_BA_ELEMENT_LINK__A, oldA, a));
			}
		}
		return a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootNodeA basicGetA() {
		return a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setA(RootNodeA newA) {
		RootNodeA oldA = a;
		a = newA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinksPackage.ROOT_BA_ELEMENT_LINK__A, oldA, a));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LinksPackage.ROOT_BA_ELEMENT_LINK__B:
				if (resolve) return getB();
				return basicGetB();
			case LinksPackage.ROOT_BA_ELEMENT_LINK__A:
				if (resolve) return getA();
				return basicGetA();
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
			case LinksPackage.ROOT_BA_ELEMENT_LINK__B:
				setB((RootNodeB)newValue);
				return;
			case LinksPackage.ROOT_BA_ELEMENT_LINK__A:
				setA((RootNodeA)newValue);
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
			case LinksPackage.ROOT_BA_ELEMENT_LINK__B:
				setB((RootNodeB)null);
				return;
			case LinksPackage.ROOT_BA_ELEMENT_LINK__A:
				setA((RootNodeA)null);
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
			case LinksPackage.ROOT_BA_ELEMENT_LINK__B:
				return b != null;
			case LinksPackage.ROOT_BA_ELEMENT_LINK__A:
				return a != null;
		}
		return super.eIsSet(featureID);
	}

} //Root_BA_Element_LinkImpl
