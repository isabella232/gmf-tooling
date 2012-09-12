/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.ocldriven.toe;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution#getEmployee <em>Employee</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getContribution()
 * @model
 * @generated
 */
public interface Contribution extends AllBase {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getContribution_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Employee</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getContributions <em>Contributions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employee</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employee</em>' reference.
	 * @see #setEmployee(Employee)
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getContribution_Employee()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Employee#getContributions
	 * @model opposite="contributions"
	 * @generated
	 */
	Employee getEmployee();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution#getEmployee <em>Employee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Employee</em>' reference.
	 * @see #getEmployee()
	 * @generated
	 */
	void setEmployee(Employee value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getContributions <em>Contributions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getContribution_Project()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Project#getContributions
	 * @model opposite="contributions"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

} // Contribution
