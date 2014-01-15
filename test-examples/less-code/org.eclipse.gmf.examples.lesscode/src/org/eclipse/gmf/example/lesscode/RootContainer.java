/**
 */
package org.eclipse.gmf.example.lesscode;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.example.lesscode.RootContainer#getRootSubjects <em>Root Subjects</em>}</li>
 *   <li>{@link org.eclipse.gmf.example.lesscode.RootContainer#getOneContainmentGroups <em>One Containment Groups</em>}</li>
 *   <li>{@link org.eclipse.gmf.example.lesscode.RootContainer#getMultiContainmentGroups <em>Multi Containment Groups</em>}</li>
 *   <li>{@link org.eclipse.gmf.example.lesscode.RootContainer#getElementBasedLinks <em>Element Based Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getRootContainer()
 * @model
 * @generated
 */
public interface RootContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Root Subjects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.example.lesscode.Subject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Subjects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Subjects</em>' containment reference list.
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getRootContainer_RootSubjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<Subject> getRootSubjects();

	/**
	 * Returns the value of the '<em><b>One Containment Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.example.lesscode.OneContainmentGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Containment Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Containment Groups</em>' containment reference list.
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getRootContainer_OneContainmentGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<OneContainmentGroup> getOneContainmentGroups();

	/**
	 * Returns the value of the '<em><b>Multi Containment Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.example.lesscode.MultiContainmentGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Containment Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Containment Groups</em>' containment reference list.
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getRootContainer_MultiContainmentGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<MultiContainmentGroup> getMultiContainmentGroups();

	/**
	 * Returns the value of the '<em><b>Element Based Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.example.lesscode.ElementBasedLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Based Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Based Links</em>' containment reference list.
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getRootContainer_ElementBasedLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementBasedLink> getElementBasedLinks();

} // RootContainer
