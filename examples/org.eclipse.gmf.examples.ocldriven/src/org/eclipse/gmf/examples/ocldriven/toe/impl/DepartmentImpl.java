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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.examples.ocldriven.toe.Department;
import org.eclipse.gmf.examples.ocldriven.toe.Employee;
import org.eclipse.gmf.examples.ocldriven.toe.Manager;
import org.eclipse.gmf.examples.ocldriven.toe.TOEPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Department</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.DepartmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.DepartmentImpl#getSubDepartments <em>Sub Departments</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.DepartmentImpl#getEmployees <em>Employees</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.DepartmentImpl#getParentDepartment <em>Parent Department</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.DepartmentImpl#getManager <em>Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DepartmentImpl extends AllBaseImpl implements Department {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * The cached value of the '{@link #getSubDepartments() <em>Sub Departments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubDepartments()
	 * @generated
	 * @ordered
	 */
	protected EList<Department> subDepartments;

	/**
	 * The cached value of the '{@link #getEmployees() <em>Employees</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployees()
	 * @generated
	 * @ordered
	 */
	protected EList<Employee> employees;

	/**
	 * The cached value of the '{@link #getManager() <em>Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManager()
	 * @generated
	 * @ordered
	 */
	protected Manager manager;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DepartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TOEPackage.Literals.DEPARTMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TOEPackage.DEPARTMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Department> getSubDepartments() {
		if (subDepartments == null) {
			subDepartments = new EObjectContainmentWithInverseEList<Department>(Department.class, this, TOEPackage.DEPARTMENT__SUB_DEPARTMENTS, TOEPackage.DEPARTMENT__PARENT_DEPARTMENT);
		}
		return subDepartments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Employee> getEmployees() {
		if (employees == null) {
			employees = new EObjectContainmentWithInverseEList<Employee>(Employee.class, this, TOEPackage.DEPARTMENT__EMPLOYEES, TOEPackage.EMPLOYEE__DEPARTMENT);
		}
		return employees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Department getParentDepartment() {
		if (eContainerFeatureID() != TOEPackage.DEPARTMENT__PARENT_DEPARTMENT) return null;
		return (Department)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentDepartment(Department newParentDepartment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentDepartment, TOEPackage.DEPARTMENT__PARENT_DEPARTMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentDepartment(Department newParentDepartment) {
		if (newParentDepartment != eInternalContainer() || (eContainerFeatureID() != TOEPackage.DEPARTMENT__PARENT_DEPARTMENT && newParentDepartment != null)) {
			if (EcoreUtil.isAncestor(this, newParentDepartment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentDepartment != null)
				msgs = ((InternalEObject)newParentDepartment).eInverseAdd(this, TOEPackage.DEPARTMENT__SUB_DEPARTMENTS, Department.class, msgs);
			msgs = basicSetParentDepartment(newParentDepartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TOEPackage.DEPARTMENT__PARENT_DEPARTMENT, newParentDepartment, newParentDepartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Manager getManager() {
		if (manager != null && manager.eIsProxy()) {
			InternalEObject oldManager = (InternalEObject)manager;
			manager = (Manager)eResolveProxy(oldManager);
			if (manager != oldManager) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TOEPackage.DEPARTMENT__MANAGER, oldManager, manager));
			}
		}
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Manager basicGetManager() {
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetManager(Manager newManager, NotificationChain msgs) {
		Manager oldManager = manager;
		manager = newManager;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TOEPackage.DEPARTMENT__MANAGER, oldManager, newManager);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManager(Manager newManager) {
		if (newManager != manager) {
			NotificationChain msgs = null;
			if (manager != null)
				msgs = ((InternalEObject)manager).eInverseRemove(this, TOEPackage.MANAGER__MANAGED_DEPARTMENT, Manager.class, msgs);
			if (newManager != null)
				msgs = ((InternalEObject)newManager).eInverseAdd(this, TOEPackage.MANAGER__MANAGED_DEPARTMENT, Manager.class, msgs);
			msgs = basicSetManager(newManager, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TOEPackage.DEPARTMENT__MANAGER, newManager, newManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Department> allSubDepartments() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case TOEPackage.DEPARTMENT__SUB_DEPARTMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubDepartments()).basicAdd(otherEnd, msgs);
			case TOEPackage.DEPARTMENT__EMPLOYEES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEmployees()).basicAdd(otherEnd, msgs);
			case TOEPackage.DEPARTMENT__PARENT_DEPARTMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentDepartment((Department)otherEnd, msgs);
			case TOEPackage.DEPARTMENT__MANAGER:
				if (manager != null)
					msgs = ((InternalEObject)manager).eInverseRemove(this, TOEPackage.MANAGER__MANAGED_DEPARTMENT, Manager.class, msgs);
				return basicSetManager((Manager)otherEnd, msgs);
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
			case TOEPackage.DEPARTMENT__SUB_DEPARTMENTS:
				return ((InternalEList<?>)getSubDepartments()).basicRemove(otherEnd, msgs);
			case TOEPackage.DEPARTMENT__EMPLOYEES:
				return ((InternalEList<?>)getEmployees()).basicRemove(otherEnd, msgs);
			case TOEPackage.DEPARTMENT__PARENT_DEPARTMENT:
				return basicSetParentDepartment(null, msgs);
			case TOEPackage.DEPARTMENT__MANAGER:
				return basicSetManager(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TOEPackage.DEPARTMENT__PARENT_DEPARTMENT:
				return eInternalContainer().eInverseRemove(this, TOEPackage.DEPARTMENT__SUB_DEPARTMENTS, Department.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TOEPackage.DEPARTMENT__NAME:
				return getName();
			case TOEPackage.DEPARTMENT__SUB_DEPARTMENTS:
				return getSubDepartments();
			case TOEPackage.DEPARTMENT__EMPLOYEES:
				return getEmployees();
			case TOEPackage.DEPARTMENT__PARENT_DEPARTMENT:
				return getParentDepartment();
			case TOEPackage.DEPARTMENT__MANAGER:
				if (resolve) return getManager();
				return basicGetManager();
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
			case TOEPackage.DEPARTMENT__NAME:
				setName((String)newValue);
				return;
			case TOEPackage.DEPARTMENT__SUB_DEPARTMENTS:
				getSubDepartments().clear();
				getSubDepartments().addAll((Collection<? extends Department>)newValue);
				return;
			case TOEPackage.DEPARTMENT__EMPLOYEES:
				getEmployees().clear();
				getEmployees().addAll((Collection<? extends Employee>)newValue);
				return;
			case TOEPackage.DEPARTMENT__PARENT_DEPARTMENT:
				setParentDepartment((Department)newValue);
				return;
			case TOEPackage.DEPARTMENT__MANAGER:
				setManager((Manager)newValue);
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
			case TOEPackage.DEPARTMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TOEPackage.DEPARTMENT__SUB_DEPARTMENTS:
				getSubDepartments().clear();
				return;
			case TOEPackage.DEPARTMENT__EMPLOYEES:
				getEmployees().clear();
				return;
			case TOEPackage.DEPARTMENT__PARENT_DEPARTMENT:
				setParentDepartment((Department)null);
				return;
			case TOEPackage.DEPARTMENT__MANAGER:
				setManager((Manager)null);
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
			case TOEPackage.DEPARTMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TOEPackage.DEPARTMENT__SUB_DEPARTMENTS:
				return subDepartments != null && !subDepartments.isEmpty();
			case TOEPackage.DEPARTMENT__EMPLOYEES:
				return employees != null && !employees.isEmpty();
			case TOEPackage.DEPARTMENT__PARENT_DEPARTMENT:
				return getParentDepartment() != null;
			case TOEPackage.DEPARTMENT__MANAGER:
				return manager != null;
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

} //DepartmentImpl
