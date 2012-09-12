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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.examples.ocldriven.toe.Contribution;
import org.eclipse.gmf.examples.ocldriven.toe.Department;
import org.eclipse.gmf.examples.ocldriven.toe.Employee;
import org.eclipse.gmf.examples.ocldriven.toe.Project;
import org.eclipse.gmf.examples.ocldriven.toe.TOEPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.EmployeeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.EmployeeImpl#getSalary <em>Salary</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.EmployeeImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.EmployeeImpl#getDepartment <em>Department</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.EmployeeImpl#getContributions <em>Contributions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmployeeImpl extends AllBaseImpl implements Employee {
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
	 * The default value of the '{@link #getSalary() <em>Salary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalary()
	 * @generated
	 * @ordered
	 */
	protected static final int SALARY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSalary() <em>Salary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalary()
	 * @generated
	 * @ordered
	 */
	protected int salary = SALARY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> projects;

	/**
	 * The cached value of the '{@link #getContributions() <em>Contributions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributions()
	 * @generated
	 * @ordered
	 */
	protected EList<Contribution> contributions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmployeeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TOEPackage.Literals.EMPLOYEE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TOEPackage.EMPLOYEE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSalary(int newSalary) {
		int oldSalary = salary;
		salary = newSalary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TOEPackage.EMPLOYEE__SALARY, oldSalary, salary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Project> getProjects() {
		if (projects == null) {
			projects = new EObjectWithInverseResolvingEList.ManyInverse<Project>(Project.class, this, TOEPackage.EMPLOYEE__PROJECTS, TOEPackage.PROJECT__PROJECT_TEAM);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Department getDepartment() {
		if (eContainerFeatureID() != TOEPackage.EMPLOYEE__DEPARTMENT) return null;
		return (Department)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDepartment(Department newDepartment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDepartment, TOEPackage.EMPLOYEE__DEPARTMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartment(Department newDepartment) {
		if (newDepartment != eInternalContainer() || (eContainerFeatureID() != TOEPackage.EMPLOYEE__DEPARTMENT && newDepartment != null)) {
			if (EcoreUtil.isAncestor(this, newDepartment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDepartment != null)
				msgs = ((InternalEObject)newDepartment).eInverseAdd(this, TOEPackage.DEPARTMENT__EMPLOYEES, Department.class, msgs);
			msgs = basicSetDepartment(newDepartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TOEPackage.EMPLOYEE__DEPARTMENT, newDepartment, newDepartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contribution> getContributions() {
		if (contributions == null) {
			contributions = new EObjectWithInverseResolvingEList<Contribution>(Contribution.class, this, TOEPackage.EMPLOYEE__CONTRIBUTIONS, TOEPackage.CONTRIBUTION__EMPLOYEE);
		}
		return contributions;
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
			case TOEPackage.EMPLOYEE__PROJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProjects()).basicAdd(otherEnd, msgs);
			case TOEPackage.EMPLOYEE__DEPARTMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDepartment((Department)otherEnd, msgs);
			case TOEPackage.EMPLOYEE__CONTRIBUTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContributions()).basicAdd(otherEnd, msgs);
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
			case TOEPackage.EMPLOYEE__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
			case TOEPackage.EMPLOYEE__DEPARTMENT:
				return basicSetDepartment(null, msgs);
			case TOEPackage.EMPLOYEE__CONTRIBUTIONS:
				return ((InternalEList<?>)getContributions()).basicRemove(otherEnd, msgs);
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
			case TOEPackage.EMPLOYEE__DEPARTMENT:
				return eInternalContainer().eInverseRemove(this, TOEPackage.DEPARTMENT__EMPLOYEES, Department.class, msgs);
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
			case TOEPackage.EMPLOYEE__NAME:
				return getName();
			case TOEPackage.EMPLOYEE__SALARY:
				return getSalary();
			case TOEPackage.EMPLOYEE__PROJECTS:
				return getProjects();
			case TOEPackage.EMPLOYEE__DEPARTMENT:
				return getDepartment();
			case TOEPackage.EMPLOYEE__CONTRIBUTIONS:
				return getContributions();
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
			case TOEPackage.EMPLOYEE__NAME:
				setName((String)newValue);
				return;
			case TOEPackage.EMPLOYEE__SALARY:
				setSalary((Integer)newValue);
				return;
			case TOEPackage.EMPLOYEE__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends Project>)newValue);
				return;
			case TOEPackage.EMPLOYEE__DEPARTMENT:
				setDepartment((Department)newValue);
				return;
			case TOEPackage.EMPLOYEE__CONTRIBUTIONS:
				getContributions().clear();
				getContributions().addAll((Collection<? extends Contribution>)newValue);
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
			case TOEPackage.EMPLOYEE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TOEPackage.EMPLOYEE__SALARY:
				setSalary(SALARY_EDEFAULT);
				return;
			case TOEPackage.EMPLOYEE__PROJECTS:
				getProjects().clear();
				return;
			case TOEPackage.EMPLOYEE__DEPARTMENT:
				setDepartment((Department)null);
				return;
			case TOEPackage.EMPLOYEE__CONTRIBUTIONS:
				getContributions().clear();
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
			case TOEPackage.EMPLOYEE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TOEPackage.EMPLOYEE__SALARY:
				return salary != SALARY_EDEFAULT;
			case TOEPackage.EMPLOYEE__PROJECTS:
				return projects != null && !projects.isEmpty();
			case TOEPackage.EMPLOYEE__DEPARTMENT:
				return getDepartment() != null;
			case TOEPackage.EMPLOYEE__CONTRIBUTIONS:
				return contributions != null && !contributions.isEmpty();
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
		result.append(", salary: ");
		result.append(salary);
		result.append(')');
		return result.toString();
	}

} //EmployeeImpl
