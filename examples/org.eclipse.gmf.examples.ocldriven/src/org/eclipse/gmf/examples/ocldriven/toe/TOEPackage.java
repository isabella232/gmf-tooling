/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.ocldriven.toe;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEFactory
 * @model kind="package"
 * @generated
 */
public interface TOEPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "toe";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/examples/gmf/ocldriven/table-of-organization-and-equipment";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "toe";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TOEPackage eINSTANCE = org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.AllHolderImpl <em>All Holder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.AllHolderImpl
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getAllHolder()
	 * @generated
	 */
	int ALL_HOLDER = 0;

	/**
	 * The feature id for the '<em><b>All</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_HOLDER__ALL = 0;

	/**
	 * The number of structural features of the '<em>All Holder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_HOLDER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.AllBaseImpl <em>All Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.AllBaseImpl
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getAllBase()
	 * @generated
	 */
	int ALL_BASE = 1;

	/**
	 * The number of structural features of the '<em>All Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_BASE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.EmployeeImpl <em>Employee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.EmployeeImpl
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getEmployee()
	 * @generated
	 */
	int EMPLOYEE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NAME = ALL_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Salary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__SALARY = ALL_BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__PROJECTS = ALL_BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Department</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__DEPARTMENT = ALL_BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Contributions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__CONTRIBUTIONS = ALL_BASE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Employee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE_FEATURE_COUNT = ALL_BASE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ManagerImpl <em>Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.ManagerImpl
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getManager()
	 * @generated
	 */
	int MANAGER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER__NAME = EMPLOYEE__NAME;

	/**
	 * The feature id for the '<em><b>Salary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER__SALARY = EMPLOYEE__SALARY;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER__PROJECTS = EMPLOYEE__PROJECTS;

	/**
	 * The feature id for the '<em><b>Department</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER__DEPARTMENT = EMPLOYEE__DEPARTMENT;

	/**
	 * The feature id for the '<em><b>Contributions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER__CONTRIBUTIONS = EMPLOYEE__CONTRIBUTIONS;

	/**
	 * The feature id for the '<em><b>Leads</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER__LEADS = EMPLOYEE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Managed Department</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER__MANAGED_DEPARTMENT = EMPLOYEE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_FEATURE_COUNT = EMPLOYEE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ContributionImpl <em>Contribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.ContributionImpl
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getContribution()
	 * @generated
	 */
	int CONTRIBUTION = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__DESCRIPTION = ALL_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Employee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__EMPLOYEE = ALL_BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__PROJECT = ALL_BASE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_FEATURE_COUNT = ALL_BASE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.DepartmentImpl <em>Department</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.DepartmentImpl
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getDepartment()
	 * @generated
	 */
	int DEPARTMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__NAME = ALL_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Departments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__SUB_DEPARTMENTS = ALL_BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Employees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__EMPLOYEES = ALL_BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent Department</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__PARENT_DEPARTMENT = ALL_BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__MANAGER = ALL_BASE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Department</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT_FEATURE_COUNT = ALL_BASE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.ProjectImpl
	 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = ALL_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Department Wide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__DEPARTMENT_WIDE = ALL_BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Project Team</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__PROJECT_TEAM = ALL_BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Lead</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__LEAD = ALL_BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Contributions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CONTRIBUTIONS = ALL_BASE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = ALL_BASE_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.ocldriven.toe.AllHolder <em>All Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Holder</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.AllHolder
	 * @generated
	 */
	EClass getAllHolder();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.ocldriven.toe.AllHolder#getAll <em>All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>All</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.AllHolder#getAll()
	 * @see #getAllHolder()
	 * @generated
	 */
	EReference getAllHolder_All();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.ocldriven.toe.AllBase <em>All Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Base</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.AllBase
	 * @generated
	 */
	EClass getAllBase();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Employee</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Employee
	 * @generated
	 */
	EClass getEmployee();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Employee#getName()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getSalary <em>Salary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Salary</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Employee#getSalary()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_Salary();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Projects</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Employee#getProjects()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Projects();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getDepartment <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Department</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Employee#getDepartment()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Department();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.examples.ocldriven.toe.Employee#getContributions <em>Contributions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contributions</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Employee#getContributions()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Contributions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.ocldriven.toe.Manager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manager</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Manager
	 * @generated
	 */
	EClass getManager();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.examples.ocldriven.toe.Manager#getLeads <em>Leads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Leads</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Manager#getLeads()
	 * @see #getManager()
	 * @generated
	 */
	EReference getManager_Leads();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.ocldriven.toe.Manager#getManagedDepartment <em>Managed Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Managed Department</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Manager#getManagedDepartment()
	 * @see #getManager()
	 * @generated
	 */
	EReference getManager_ManagedDepartment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contribution</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Contribution
	 * @generated
	 */
	EClass getContribution();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Contribution#getDescription()
	 * @see #getContribution()
	 * @generated
	 */
	EAttribute getContribution_Description();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution#getEmployee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Employee</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Contribution#getEmployee()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_Employee();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.ocldriven.toe.Contribution#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Contribution#getProject()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_Project();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.ocldriven.toe.Department <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Department</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Department
	 * @generated
	 */
	EClass getDepartment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Department#getName()
	 * @see #getDepartment()
	 * @generated
	 */
	EAttribute getDepartment_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getSubDepartments <em>Sub Departments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Departments</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Department#getSubDepartments()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_SubDepartments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Employees</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Department#getEmployees()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_Employees();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getParentDepartment <em>Parent Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Department</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Department#getParentDepartment()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_ParentDepartment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.ocldriven.toe.Department#getManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Manager</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Department#getManager()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_Manager();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.ocldriven.toe.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.ocldriven.toe.Project#isDepartmentWide <em>Department Wide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Department Wide</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Project#isDepartmentWide()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_DepartmentWide();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getProjectTeam <em>Project Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Project Team</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Project#getProjectTeam()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_ProjectTeam();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getLead <em>Lead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lead</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Project#getLead()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Lead();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.examples.ocldriven.toe.Project#getContributions <em>Contributions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contributions</em>'.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.Project#getContributions()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Contributions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TOEFactory getTOEFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.AllHolderImpl <em>All Holder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.AllHolderImpl
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getAllHolder()
		 * @generated
		 */
		EClass ALL_HOLDER = eINSTANCE.getAllHolder();

		/**
		 * The meta object literal for the '<em><b>All</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALL_HOLDER__ALL = eINSTANCE.getAllHolder_All();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.AllBaseImpl <em>All Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.AllBaseImpl
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getAllBase()
		 * @generated
		 */
		EClass ALL_BASE = eINSTANCE.getAllBase();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.EmployeeImpl <em>Employee</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.EmployeeImpl
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getEmployee()
		 * @generated
		 */
		EClass EMPLOYEE = eINSTANCE.getEmployee();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__NAME = eINSTANCE.getEmployee_Name();

		/**
		 * The meta object literal for the '<em><b>Salary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__SALARY = eINSTANCE.getEmployee_Salary();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__PROJECTS = eINSTANCE.getEmployee_Projects();

		/**
		 * The meta object literal for the '<em><b>Department</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__DEPARTMENT = eINSTANCE.getEmployee_Department();

		/**
		 * The meta object literal for the '<em><b>Contributions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__CONTRIBUTIONS = eINSTANCE.getEmployee_Contributions();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ManagerImpl <em>Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.ManagerImpl
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getManager()
		 * @generated
		 */
		EClass MANAGER = eINSTANCE.getManager();

		/**
		 * The meta object literal for the '<em><b>Leads</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANAGER__LEADS = eINSTANCE.getManager_Leads();

		/**
		 * The meta object literal for the '<em><b>Managed Department</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANAGER__MANAGED_DEPARTMENT = eINSTANCE.getManager_ManagedDepartment();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ContributionImpl <em>Contribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.ContributionImpl
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getContribution()
		 * @generated
		 */
		EClass CONTRIBUTION = eINSTANCE.getContribution();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTION__DESCRIPTION = eINSTANCE.getContribution_Description();

		/**
		 * The meta object literal for the '<em><b>Employee</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTION__EMPLOYEE = eINSTANCE.getContribution_Employee();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTION__PROJECT = eINSTANCE.getContribution_Project();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.DepartmentImpl <em>Department</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.DepartmentImpl
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getDepartment()
		 * @generated
		 */
		EClass DEPARTMENT = eINSTANCE.getDepartment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPARTMENT__NAME = eINSTANCE.getDepartment_Name();

		/**
		 * The meta object literal for the '<em><b>Sub Departments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPARTMENT__SUB_DEPARTMENTS = eINSTANCE.getDepartment_SubDepartments();

		/**
		 * The meta object literal for the '<em><b>Employees</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPARTMENT__EMPLOYEES = eINSTANCE.getDepartment_Employees();

		/**
		 * The meta object literal for the '<em><b>Parent Department</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPARTMENT__PARENT_DEPARTMENT = eINSTANCE.getDepartment_ParentDepartment();

		/**
		 * The meta object literal for the '<em><b>Manager</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPARTMENT__MANAGER = eINSTANCE.getDepartment_Manager();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.ocldriven.toe.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.ProjectImpl
		 * @see org.eclipse.gmf.examples.ocldriven.toe.impl.TOEPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Department Wide</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__DEPARTMENT_WIDE = eINSTANCE.getProject_DepartmentWide();

		/**
		 * The meta object literal for the '<em><b>Project Team</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__PROJECT_TEAM = eINSTANCE.getProject_ProjectTeam();

		/**
		 * The meta object literal for the '<em><b>Lead</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__LEAD = eINSTANCE.getProject_Lead();

		/**
		 * The meta object literal for the '<em><b>Contributions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__CONTRIBUTIONS = eINSTANCE.getProject_Contributions();

	}

} //TOEPackage
