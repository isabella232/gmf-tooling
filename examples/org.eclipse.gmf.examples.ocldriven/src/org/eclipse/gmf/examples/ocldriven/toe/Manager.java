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
 * A representation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Manager#getLeads <em>Leads</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Manager#getManagedDepartment <em>Managed Department</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getManager()
 * @model
 * @generated
 */
public interface Manager extends Employee {
	/**
	 * Returns the value of the '<em><b>Leads</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.ocldriven.toe.Project}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getLead <em>Lead</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leads</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leads</em>' reference list.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getManager_Leads()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Project#getLead
	 * @model opposite="lead"
	 * @generated
	 */
	EList<Project> getLeads();

	/**
	 * Returns the value of the '<em><b>Managed Department</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managed Department</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managed Department</em>' reference.
	 * @see #setManagedDepartment(Department)
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getManager_ManagedDepartment()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Department#getManager
	 * @model opposite="manager"
	 * @generated
	 */
	Department getManagedDepartment();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Manager#getManagedDepartment <em>Managed Department</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Managed Department</em>' reference.
	 * @see #getManagedDepartment()
	 * @generated
	 */
	void setManagedDepartment(Department value);

} // Manager
