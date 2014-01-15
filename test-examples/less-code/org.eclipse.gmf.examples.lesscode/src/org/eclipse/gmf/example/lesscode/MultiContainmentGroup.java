/**
 */
package org.eclipse.gmf.example.lesscode;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Containment Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.example.lesscode.MultiContainmentGroup#getSubjectsTypeA <em>Subjects Type A</em>}</li>
 *   <li>{@link org.eclipse.gmf.example.lesscode.MultiContainmentGroup#getSubjectsTypeB <em>Subjects Type B</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getMultiContainmentGroup()
 * @model
 * @generated
 */
public interface MultiContainmentGroup extends WithSomeAttributes {
	/**
	 * Returns the value of the '<em><b>Subjects Type A</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.example.lesscode.Subject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subjects Type A</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subjects Type A</em>' containment reference list.
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getMultiContainmentGroup_SubjectsTypeA()
	 * @model containment="true"
	 * @generated
	 */
	EList<Subject> getSubjectsTypeA();

	/**
	 * Returns the value of the '<em><b>Subjects Type B</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.example.lesscode.Subject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subjects Type B</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subjects Type B</em>' containment reference list.
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getMultiContainmentGroup_SubjectsTypeB()
	 * @model containment="true"
	 * @generated
	 */
	EList<Subject> getSubjectsTypeB();

} // MultiContainmentGroup
