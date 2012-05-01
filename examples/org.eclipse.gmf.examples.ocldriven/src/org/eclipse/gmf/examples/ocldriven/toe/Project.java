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
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Project#isDepartmentWide <em>Department Wide</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getProjectTeam <em>Project Team</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getLead <em>Lead</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getContributions <em>Contributions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends AllBase {
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
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Department Wide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Department Wide</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Department Wide</em>' attribute.
	 * @see #setDepartmentWide(boolean)
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getProject_DepartmentWide()
	 * @model
	 * @generated
	 */
	boolean isDepartmentWide();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Project#isDepartmentWide <em>Department Wide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Department Wide</em>' attribute.
	 * @see #isDepartmentWide()
	 * @generated
	 */
	void setDepartmentWide(boolean value);

	/**
	 * Returns the value of the '<em><b>Project Team</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.ocldriven.toe.Employee}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Team</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Team</em>' reference list.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getProject_ProjectTeam()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Employee#getProjects
	 * @model opposite="projects"
	 * @generated
	 */
	EList<Employee> getProjectTeam();

	/**
	 * Returns the value of the '<em><b>Lead</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Manager#getLeads <em>Leads</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lead</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lead</em>' reference.
	 * @see #setLead(Manager)
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getProject_Lead()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Manager#getLeads
	 * @model opposite="leads"
	 * @generated
	 */
	Manager getLead();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getLead <em>Lead</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lead</em>' reference.
	 * @see #getLead()
	 * @generated
	 */
	void setLead(Manager value);

	/**
	 * Returns the value of the '<em><b>Contributions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.ocldriven.toe.Contribution}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributions</em>' reference list.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getProject_Contributions()
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Contribution#getProject
	 * @model opposite="project"
	 * @generated
	 */
	EList<Contribution> getContributions();

} // Project
