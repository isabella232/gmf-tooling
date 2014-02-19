/**
 */
package org.eclipse.gmf.tooling.examples.links.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.gmf.tooling.examples.links.ChildNodeA;
import org.eclipse.gmf.tooling.examples.links.ChildNodeB;
import org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link;
import org.eclipse.gmf.tooling.examples.links.LinksPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child AB Element Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.Child_AB_Element_LinkImpl#getSource_A <em>Source A</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.Child_AB_Element_LinkImpl#getTarget_B <em>Target B</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Child_AB_Element_LinkImpl extends MinimalEObjectImpl.Container implements Child_AB_Element_Link {
	/**
	 * The cached value of the '{@link #getSource_A() <em>Source A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource_A()
	 * @generated
	 * @ordered
	 */
	protected ChildNodeA source_A;

	/**
	 * The cached value of the '{@link #getTarget_B() <em>Target B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget_B()
	 * @generated
	 * @ordered
	 */
	protected ChildNodeB target_B;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Child_AB_Element_LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LinksPackage.Literals.CHILD_AB_ELEMENT_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildNodeA getSource_A() {
		if (source_A != null && source_A.eIsProxy()) {
			InternalEObject oldSource_A = (InternalEObject)source_A;
			source_A = (ChildNodeA)eResolveProxy(oldSource_A);
			if (source_A != oldSource_A) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LinksPackage.CHILD_AB_ELEMENT_LINK__SOURCE_A, oldSource_A, source_A));
			}
		}
		return source_A;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildNodeA basicGetSource_A() {
		return source_A;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource_A(ChildNodeA newSource_A) {
		ChildNodeA oldSource_A = source_A;
		source_A = newSource_A;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinksPackage.CHILD_AB_ELEMENT_LINK__SOURCE_A, oldSource_A, source_A));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildNodeB getTarget_B() {
		if (target_B != null && target_B.eIsProxy()) {
			InternalEObject oldTarget_B = (InternalEObject)target_B;
			target_B = (ChildNodeB)eResolveProxy(oldTarget_B);
			if (target_B != oldTarget_B) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LinksPackage.CHILD_AB_ELEMENT_LINK__TARGET_B, oldTarget_B, target_B));
			}
		}
		return target_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildNodeB basicGetTarget_B() {
		return target_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget_B(ChildNodeB newTarget_B) {
		ChildNodeB oldTarget_B = target_B;
		target_B = newTarget_B;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinksPackage.CHILD_AB_ELEMENT_LINK__TARGET_B, oldTarget_B, target_B));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LinksPackage.CHILD_AB_ELEMENT_LINK__SOURCE_A:
				if (resolve) return getSource_A();
				return basicGetSource_A();
			case LinksPackage.CHILD_AB_ELEMENT_LINK__TARGET_B:
				if (resolve) return getTarget_B();
				return basicGetTarget_B();
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
			case LinksPackage.CHILD_AB_ELEMENT_LINK__SOURCE_A:
				setSource_A((ChildNodeA)newValue);
				return;
			case LinksPackage.CHILD_AB_ELEMENT_LINK__TARGET_B:
				setTarget_B((ChildNodeB)newValue);
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
			case LinksPackage.CHILD_AB_ELEMENT_LINK__SOURCE_A:
				setSource_A((ChildNodeA)null);
				return;
			case LinksPackage.CHILD_AB_ELEMENT_LINK__TARGET_B:
				setTarget_B((ChildNodeB)null);
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
			case LinksPackage.CHILD_AB_ELEMENT_LINK__SOURCE_A:
				return source_A != null;
			case LinksPackage.CHILD_AB_ELEMENT_LINK__TARGET_B:
				return target_B != null;
		}
		return super.eIsSet(featureID);
	}

} //Child_AB_Element_LinkImpl
