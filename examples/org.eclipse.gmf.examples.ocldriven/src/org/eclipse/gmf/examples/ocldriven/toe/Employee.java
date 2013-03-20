/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.ocldriven.toe;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getSalary <em>Salary</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getDepartment <em>Department</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getContributions <em>Contributions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getEmployee()
 * @model
 * @generated
 */
public interface Employee extends AllBase {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getEmployee_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Salary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Salary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Salary</em>' attribute.
	 * @see #setSalary(int)
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getEmployee_Salary()
	 * @model
	 * @generated
	 */
	int getSalary();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getSalary <em>Salary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Salary</em>' attribute.
	 * @see #getSalary()
	 * @generated
	 */
	void setSalary(int value);

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.ocldriven.toe.Project}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getProjectTeam <em>Project Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' reference list.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getEmployee_Projects()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Project#getProjectTeam
	 * @model opposite="projectTeam"
	 * @generated
	 */
	EList<Project> getProjects();

	/**
	 * Returns the value of the '<em><b>Department</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Department</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Department</em>' container reference.
	 * @see #setDepartment(Department)
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getEmployee_Department()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Department#getEmployees
	 * @model opposite="employees" transient="false"
	 * @generated
	 */
	Department getDepartment();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getDepartment <em>Department</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Department</em>' container reference.
	 * @see #getDepartment()
	 * @generated
	 */
	void setDepartment(Department value);

	/**
	 * Returns the value of the '<em><b>Contributions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.ocldriven.toe.Contribution}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution#getEmployee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributions</em>' reference list.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getEmployee_Contributions()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Contribution#getEmployee
	 * @model opposite="employee"
	 * @generated
	 */
	EList<Contribution> getContributions();

} // Employee
