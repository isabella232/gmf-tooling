/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.diadef;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.diadef.Node#getMaxWidth <em>Max Width</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.Node#getMaxHeight <em>Max Height</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.Node#getDefaultWidth <em>Default Width</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.Node#getDefaultHeight <em>Default Height</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.Node#getCompartments <em>Compartments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends DiagramElement {
	/**
	 * Returns the value of the '<em><b>Max Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Width</em>' attribute.
	 * @see #setMaxWidth(int)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getNode_MaxWidth()
	 * @model
	 * @generated
	 */
	int getMaxWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.Node#getMaxWidth <em>Max Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Width</em>' attribute.
	 * @see #getMaxWidth()
	 * @generated
	 */
	void setMaxWidth(int value);

	/**
	 * Returns the value of the '<em><b>Max Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Height</em>' attribute.
	 * @see #setMaxHeight(int)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getNode_MaxHeight()
	 * @model
	 * @generated
	 */
	int getMaxHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.Node#getMaxHeight <em>Max Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Height</em>' attribute.
	 * @see #getMaxHeight()
	 * @generated
	 */
	void setMaxHeight(int value);

	/**
	 * Returns the value of the '<em><b>Default Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Width</em>' attribute.
	 * @see #setDefaultWidth(int)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getNode_DefaultWidth()
	 * @model
	 * @generated
	 */
	int getDefaultWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.Node#getDefaultWidth <em>Default Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Width</em>' attribute.
	 * @see #getDefaultWidth()
	 * @generated
	 */
	void setDefaultWidth(int value);

	/**
	 * Returns the value of the '<em><b>Default Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Height</em>' attribute.
	 * @see #setDefaultHeight(int)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getNode_DefaultHeight()
	 * @model
	 * @generated
	 */
	int getDefaultHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.Node#getDefaultHeight <em>Default Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Height</em>' attribute.
	 * @see #getDefaultHeight()
	 * @generated
	 */
	void setDefaultHeight(int value);

	/**
	 * Returns the value of the '<em><b>Compartments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.diadef.Compartment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartments</em>' containment reference list.
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getNode_Compartments()
	 * @model type="org.eclipse.gmf.diadef.Compartment" containment="true"
	 * @generated
	 */
	EList getCompartments();

} // Node
