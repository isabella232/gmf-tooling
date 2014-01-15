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
import org.eclipse.gmf.example.lesscode.MultiContainmentGroup;
import org.eclipse.gmf.example.lesscode.Subject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Containment Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.example.lesscode.impl.MultiContainmentGroupImpl#getSubjectsTypeA <em>Subjects Type A</em>}</li>
 *   <li>{@link org.eclipse.gmf.example.lesscode.impl.MultiContainmentGroupImpl#getSubjectsTypeB <em>Subjects Type B</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiContainmentGroupImpl extends WithSomeAttributesImpl implements MultiContainmentGroup {
	/**
	 * The cached value of the '{@link #getSubjectsTypeA() <em>Subjects Type A</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubjectsTypeA()
	 * @generated
	 * @ordered
	 */
	protected EList<Subject> subjectsTypeA;

	/**
	 * The cached value of the '{@link #getSubjectsTypeB() <em>Subjects Type B</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubjectsTypeB()
	 * @generated
	 * @ordered
	 */
	protected EList<Subject> subjectsTypeB;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiContainmentGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LesscodePackage.Literals.MULTI_CONTAINMENT_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subject> getSubjectsTypeA() {
		if (subjectsTypeA == null) {
			subjectsTypeA = new EObjectContainmentEList<Subject>(Subject.class, this, LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_A);
		}
		return subjectsTypeA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subject> getSubjectsTypeB() {
		if (subjectsTypeB == null) {
			subjectsTypeB = new EObjectContainmentEList<Subject>(Subject.class, this, LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_B);
		}
		return subjectsTypeB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_A:
				return ((InternalEList<?>)getSubjectsTypeA()).basicRemove(otherEnd, msgs);
			case LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_B:
				return ((InternalEList<?>)getSubjectsTypeB()).basicRemove(otherEnd, msgs);
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
			case LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_A:
				return getSubjectsTypeA();
			case LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_B:
				return getSubjectsTypeB();
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
			case LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_A:
				getSubjectsTypeA().clear();
				getSubjectsTypeA().addAll((Collection<? extends Subject>)newValue);
				return;
			case LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_B:
				getSubjectsTypeB().clear();
				getSubjectsTypeB().addAll((Collection<? extends Subject>)newValue);
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
			case LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_A:
				getSubjectsTypeA().clear();
				return;
			case LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_B:
				getSubjectsTypeB().clear();
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
			case LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_A:
				return subjectsTypeA != null && !subjectsTypeA.isEmpty();
			case LesscodePackage.MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_B:
				return subjectsTypeB != null && !subjectsTypeB.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MultiContainmentGroupImpl
