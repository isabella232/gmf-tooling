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
 * A representation of the model object '<em><b>Department</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getSubDepartments <em>Sub Departments</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getEmployees <em>Employees</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getParentDepartment <em>Parent Department</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getManager <em>Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getDepartment()
 * @model
 * @generated
 */
public interface Department extends AllBase {
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
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getDepartment_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Sub Departments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.ocldriven.toe.Department}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getParentDepartment <em>Parent Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Departments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Departments</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getDepartment_SubDepartments()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Department#getParentDepartment
	 * @model opposite="parentDepartment" containment="true"
	 * @generated
	 */
	EList<Department> getSubDepartments();

	/**
	 * Returns the value of the '<em><b>Employees</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.ocldriven.toe.Employee}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getDepartment <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employees</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getDepartment_Employees()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Employee#getDepartment
	 * @model opposite="department" containment="true"
	 * @generated
	 */
	EList<Employee> getEmployees();

	/**
	 * Returns the value of the '<em><b>Parent Department</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getSubDepartments <em>Sub Departments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Department</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Department</em>' container reference.
	 * @see #setParentDepartment(Department)
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getDepartment_ParentDepartment()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Department#getSubDepartments
	 * @model opposite="subDepartments" transient="false"
	 * @generated
	 */
	Department getParentDepartment();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getParentDepartment <em>Parent Department</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Department</em>' container reference.
	 * @see #getParentDepartment()
	 * @generated
	 */
	void setParentDepartment(Department value);

	/**
	 * Returns the value of the '<em><b>Manager</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Manager#getManagedDepartment <em>Managed Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager</em>' reference.
	 * @see #setManager(Manager)
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getDepartment_Manager()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Manager#getManagedDepartment
	 * @model opposite="managedDepartment" required="true"
	 * @generated
	 */
	Manager getManager();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getManager <em>Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager</em>' reference.
	 * @see #getManager()
	 * @generated
	 */
	void setManager(Manager value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Department> allSubDepartments();

} // Department
