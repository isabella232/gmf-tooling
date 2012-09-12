/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.ocldriven.toe.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.examples.ocldriven.toe.Department;
import org.eclipse.gmf.examples.ocldriven.toe.Manager;
import org.eclipse.gmf.examples.ocldriven.toe.Project;
import org.eclipse.gmf.examples.ocldriven.toe.TOEPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ManagerImpl#getLeads <em>Leads</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ManagerImpl#getManagedDepartment <em>Managed Department</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ManagerImpl extends EmployeeImpl implements Manager {
	/**
	 * The cached value of the '{@link #getLeads() <em>Leads</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeads()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> leads;

	/**
	 * The cached value of the '{@link #getManagedDepartment() <em>Managed Department</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagedDepartment()
	 * @generated
	 * @ordered
	 */
	protected Department managedDepartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TOEPackage.Literals.MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Project> getLeads() {
		if (leads == null) {
			leads = new EObjectWithInverseResolvingEList<Project>(Project.class, this, TOEPackage.MANAGER__LEADS, TOEPackage.PROJECT__LEAD);
		}
		return leads;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Department getManagedDepartment() {
		if (managedDepartment != null && managedDepartment.eIsProxy()) {
			InternalEObject oldManagedDepartment = (InternalEObject)managedDepartment;
			managedDepartment = (Department)eResolveProxy(oldManagedDepartment);
			if (managedDepartment != oldManagedDepartment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TOEPackage.MANAGER__MANAGED_DEPARTMENT, oldManagedDepartment, managedDepartment));
			}
		}
		return managedDepartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Department basicGetManagedDepartment() {
		return managedDepartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetManagedDepartment(Department newManagedDepartment, NotificationChain msgs) {
		Department oldManagedDepartment = managedDepartment;
		managedDepartment = newManagedDepartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TOEPackage.MANAGER__MANAGED_DEPARTMENT, oldManagedDepartment, newManagedDepartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagedDepartment(Department newManagedDepartment) {
		if (newManagedDepartment != managedDepartment) {
			NotificationChain msgs = null;
			if (managedDepartment != null)
				msgs = ((InternalEObject)managedDepartment).eInverseRemove(this, TOEPackage.DEPARTMENT__MANAGER, Department.class, msgs);
			if (newManagedDepartment != null)
				msgs = ((InternalEObject)newManagedDepartment).eInverseAdd(this, TOEPackage.DEPARTMENT__MANAGER, Department.class, msgs);
			msgs = basicSetManagedDepartment(newManagedDepartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TOEPackage.MANAGER__MANAGED_DEPARTMENT, newManagedDepartment, newManagedDepartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TOEPackage.MANAGER__LEADS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLeads()).basicAdd(otherEnd, msgs);
			case TOEPackage.MANAGER__MANAGED_DEPARTMENT:
				if (managedDepartment != null)
					msgs = ((InternalEObject)managedDepartment).eInverseRemove(this, TOEPackage.DEPARTMENT__MANAGER, Department.class, msgs);
				return basicSetManagedDepartment((Department)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TOEPackage.MANAGER__LEADS:
				return ((InternalEList<?>)getLeads()).basicRemove(otherEnd, msgs);
			case TOEPackage.MANAGER__MANAGED_DEPARTMENT:
				return basicSetManagedDepartment(null, msgs);
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
			case TOEPackage.MANAGER__LEADS:
				return getLeads();
			case TOEPackage.MANAGER__MANAGED_DEPARTMENT:
				if (resolve) return getManagedDepartment();
				return basicGetManagedDepartment();
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
			case TOEPackage.MANAGER__LEADS:
				getLeads().clear();
				getLeads().addAll((Collection<? extends Project>)newValue);
				return;
			case TOEPackage.MANAGER__MANAGED_DEPARTMENT:
				setManagedDepartment((Department)newValue);
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
			case TOEPackage.MANAGER__LEADS:
				getLeads().clear();
				return;
			case TOEPackage.MANAGER__MANAGED_DEPARTMENT:
				setManagedDepartment((Department)null);
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
			case TOEPackage.MANAGER__LEADS:
				return leads != null && !leads.isEmpty();
			case TOEPackage.MANAGER__MANAGED_DEPARTMENT:
				return managedDepartment != null;
		}
		return super.eIsSet(featureID);
	}

} //ManagerImpl
