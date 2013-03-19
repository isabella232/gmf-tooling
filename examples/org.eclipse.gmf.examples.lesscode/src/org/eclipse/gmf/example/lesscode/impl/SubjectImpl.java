/**
 */
package org.eclipse.gmf.example.lesscode.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.example.lesscode.LesscodePackage;
import org.eclipse.gmf.example.lesscode.Subject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subject</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.example.lesscode.impl.SubjectImpl#getRecursiveContainment <em>Recursive Containment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubjectImpl extends WithSomeAttributesImpl implements Subject {
	/**
	 * The cached value of the '{@link #getRecursiveContainment() <em>Recursive Containment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecursiveContainment()
	 * @generated
	 * @ordered
	 */
	protected EList<Subject> recursiveContainment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LesscodePackage.Literals.SUBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subject> getRecursiveContainment() {
		if (recursiveContainment == null) {
			recursiveContainment = new EObjectContainmentEList<Subject>(Subject.class, this, LesscodePackage.SUBJECT__RECURSIVE_CONTAINMENT);
		}
		return recursiveContainment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LesscodePackage.SUBJECT__RECURSIVE_CONTAINMENT:
				return ((InternalEList<?>)getRecursiveContainment()).basicRemove(otherEnd, msgs);
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
			case LesscodePackage.SUBJECT__RECURSIVE_CONTAINMENT:
				return getRecursiveContainment();
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
			case LesscodePackage.SUBJECT__RECURSIVE_CONTAINMENT:
				getRecursiveContainment().clear();
				getRecursiveContainment().addAll((Collection<? extends Subject>)newValue);
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
			case LesscodePackage.SUBJECT__RECURSIVE_CONTAINMENT:
				getRecursiveContainment().clear();
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
			case LesscodePackage.SUBJECT__RECURSIVE_CONTAINMENT:
				return recursiveContainment != null && !recursiveContainment.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SubjectImpl
