/**
 */
package org.eclipse.gmf.example.lesscode;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.example.lesscode.Subject#getRecursiveContainment <em>Recursive Containment</em>}</li>
 *   <li>{@link org.eclipse.gmf.example.lesscode.Subject#getReferenceBasedLinkTarget <em>Reference Based Link Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getSubject()
 * @model
 * @generated
 */
public interface Subject extends WithSomeAttributes {
	/**
	 * Returns the value of the '<em><b>Recursive Containment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.example.lesscode.Subject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recursive Containment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recursive Containment</em>' containment reference list.
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getSubject_RecursiveContainment()
	 * @model containment="true"
	 * @generated
	 */
	EList<Subject> getRecursiveContainment();

	/**
	 * Returns the value of the '<em><b>Reference Based Link Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.example.lesscode.Subject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Based Link Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Based Link Target</em>' reference list.
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getSubject_ReferenceBasedLinkTarget()
	 * @model
	 * @generated
	 */
	EList<Subject> getReferenceBasedLinkTarget();

} // Subject
