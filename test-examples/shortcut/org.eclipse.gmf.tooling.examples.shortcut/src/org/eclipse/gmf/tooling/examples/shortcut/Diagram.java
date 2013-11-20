/**
 */
package org.eclipse.gmf.tooling.examples.shortcut;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.shortcut.Diagram#getLinks <em>Links</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.shortcut.Diagram#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.shortcut.Diagram#getContainsShortcutsTo <em>Contains Shortcuts To</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.shortcut.Diagram#getShortcutsProvidedFor <em>Shortcuts Provided For</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage#getDiagram()
 * @model
 * @generated
 */
public interface Diagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.shortcut.DiagramLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage#getDiagram_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<DiagramLink> getLinks();

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.shortcut.DiagramNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage#getDiagram_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DiagramNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Contains Shortcuts To</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains Shortcuts To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains Shortcuts To</em>' attribute list.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage#getDiagram_ContainsShortcutsTo()
	 * @model
	 * @generated
	 */
	EList<String> getContainsShortcutsTo();

	/**
	 * Returns the value of the '<em><b>Shortcuts Provided For</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shortcuts Provided For</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shortcuts Provided For</em>' attribute list.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage#getDiagram_ShortcutsProvidedFor()
	 * @model
	 * @generated
	 */
	EList<String> getShortcutsProvidedFor();

} // Diagram
