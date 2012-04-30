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

import org.eclipse.gmf.examples.ocldriven.toe.Contribution;
import org.eclipse.gmf.examples.ocldriven.toe.Employee;
import org.eclipse.gmf.examples.ocldriven.toe.Manager;
import org.eclipse.gmf.examples.ocldriven.toe.Project;
import org.eclipse.gmf.examples.ocldriven.toe.TOEPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ProjectImpl#isDepartmentWide <em>Department Wide</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ProjectImpl#getProjectTeam <em>Project Team</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ProjectImpl#getLead <em>Lead</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ProjectImpl#getContributions <em>Contributions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectImpl extends AllBaseImpl implements Project {
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
	 * The default value of the '{@link #isDepartmentWide() <em>Department Wide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepartmentWide()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEPARTMENT_WIDE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDepartmentWide() <em>Department Wide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepartmentWide()
	 * @generated
	 * @ordered
	 */
	protected boolean departmentWide = DEPARTMENT_WIDE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProjectTeam() <em>Project Team</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectTeam()
	 * @generated
	 * @ordered
	 */
	protected EList<Employee> projectTeam;

	/**
	 * The cached value of the '{@link #getLead() <em>Lead</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLead()
	 * @generated
	 * @ordered
	 */
	protected Manager lead;

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
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TOEPackage.Literals.PROJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TOEPackage.PROJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDepartmentWide() {
		return departmentWide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartmentWide(boolean newDepartmentWide) {
		boolean oldDepartmentWide = departmentWide;
		departmentWide = newDepartmentWide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TOEPackage.PROJECT__DEPARTMENT_WIDE, oldDepartmentWide, departmentWide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Employee> getProjectTeam() {
		if (projectTeam == null) {
			projectTeam = new EObjectWithInverseResolvingEList.ManyInverse<Employee>(Employee.class, this, TOEPackage.PROJECT__PROJECT_TEAM, TOEPackage.EMPLOYEE__PROJECTS);
		}
		return projectTeam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Manager getLead() {
		if (lead != null && lead.eIsProxy()) {
			InternalEObject oldLead = (InternalEObject)lead;
			lead = (Manager)eResolveProxy(oldLead);
			if (lead != oldLead) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TOEPackage.PROJECT__LEAD, oldLead, lead));
			}
		}
		return lead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Manager basicGetLead() {
		return lead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLead(Manager newLead, NotificationChain msgs) {
		Manager oldLead = lead;
		lead = newLead;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TOEPackage.PROJECT__LEAD, oldLead, newLead);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLead(Manager newLead) {
		if (newLead != lead) {
			NotificationChain msgs = null;
			if (lead != null)
				msgs = ((InternalEObject)lead).eInverseRemove(this, TOEPackage.MANAGER__LEADS, Manager.class, msgs);
			if (newLead != null)
				msgs = ((InternalEObject)newLead).eInverseAdd(this, TOEPackage.MANAGER__LEADS, Manager.class, msgs);
			msgs = basicSetLead(newLead, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TOEPackage.PROJECT__LEAD, newLead, newLead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contribution> getContributions() {
		if (contributions == null) {
			contributions = new EObjectWithInverseResolvingEList<Contribution>(Contribution.class, this, TOEPackage.PROJECT__CONTRIBUTIONS, TOEPackage.CONTRIBUTION__PROJECT);
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
			case TOEPackage.PROJECT__PROJECT_TEAM:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProjectTeam()).basicAdd(otherEnd, msgs);
			case TOEPackage.PROJECT__LEAD:
				if (lead != null)
					msgs = ((InternalEObject)lead).eInverseRemove(this, TOEPackage.MANAGER__LEADS, Manager.class, msgs);
				return basicSetLead((Manager)otherEnd, msgs);
			case TOEPackage.PROJECT__CONTRIBUTIONS:
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
			case TOEPackage.PROJECT__PROJECT_TEAM:
				return ((InternalEList<?>)getProjectTeam()).basicRemove(otherEnd, msgs);
			case TOEPackage.PROJECT__LEAD:
				return basicSetLead(null, msgs);
			case TOEPackage.PROJECT__CONTRIBUTIONS:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TOEPackage.PROJECT__NAME:
				return getName();
			case TOEPackage.PROJECT__DEPARTMENT_WIDE:
				return isDepartmentWide();
			case TOEPackage.PROJECT__PROJECT_TEAM:
				return getProjectTeam();
			case TOEPackage.PROJECT__LEAD:
				if (resolve) return getLead();
				return basicGetLead();
			case TOEPackage.PROJECT__CONTRIBUTIONS:
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
			case TOEPackage.PROJECT__NAME:
				setName((String)newValue);
				return;
			case TOEPackage.PROJECT__DEPARTMENT_WIDE:
				setDepartmentWide((Boolean)newValue);
				return;
			case TOEPackage.PROJECT__PROJECT_TEAM:
				getProjectTeam().clear();
				getProjectTeam().addAll((Collection<? extends Employee>)newValue);
				return;
			case TOEPackage.PROJECT__LEAD:
				setLead((Manager)newValue);
				return;
			case TOEPackage.PROJECT__CONTRIBUTIONS:
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
			case TOEPackage.PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TOEPackage.PROJECT__DEPARTMENT_WIDE:
				setDepartmentWide(DEPARTMENT_WIDE_EDEFAULT);
				return;
			case TOEPackage.PROJECT__PROJECT_TEAM:
				getProjectTeam().clear();
				return;
			case TOEPackage.PROJECT__LEAD:
				setLead((Manager)null);
				return;
			case TOEPackage.PROJECT__CONTRIBUTIONS:
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
			case TOEPackage.PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TOEPackage.PROJECT__DEPARTMENT_WIDE:
				return departmentWide != DEPARTMENT_WIDE_EDEFAULT;
			case TOEPackage.PROJECT__PROJECT_TEAM:
				return projectTeam != null && !projectTeam.isEmpty();
			case TOEPackage.PROJECT__LEAD:
				return lead != null;
			case TOEPackage.PROJECT__CONTRIBUTIONS:
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
		result.append(", departmentWide: ");
		result.append(departmentWide);
		result.append(')');
		return result.toString();
	}

} //ProjectImpl
