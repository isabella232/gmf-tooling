/**
 */
package org.eclipse.gmf.example.lesscode;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>One Containment Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.example.lesscode.OneContainmentGroup#getSubjects <em>Subjects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getOneContainmentGroup()
 * @model
 * @generated
 */
public interface OneContainmentGroup extends WithSomeAttributes {
	/**
	 * Returns the value of the '<em><b>Subjects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.example.lesscode.Subject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subjects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subjects</em>' containment reference list.
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getOneContainmentGroup_Subjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<Subject> getSubjects();

} // OneContainmentGroup
