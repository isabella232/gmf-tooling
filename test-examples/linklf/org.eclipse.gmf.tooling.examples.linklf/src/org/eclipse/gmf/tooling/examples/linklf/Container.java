/**
 */
package org.eclipse.gmf.tooling.examples.linklf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklf.Container#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklf.Container#getPorst <em>Porst</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.linklf.LinklfPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends CanvasElementContainer {
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
	 * @see org.eclipse.gmf.tooling.examples.linklf.LinklfPackage#getContainer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.linklf.Container#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Porst</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.linklf.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Porst</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Porst</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.linklf.LinklfPackage#getContainer_Porst()
	 * @model containment="true"
	 * @generated
	 */
	EList<Port> getPorst();

} // Container
