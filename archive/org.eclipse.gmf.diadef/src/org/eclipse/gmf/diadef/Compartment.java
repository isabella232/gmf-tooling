/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.diadef;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.diadef.Compartment#isCollapsible <em>Collapsible</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.Compartment#isNeedsTitle <em>Needs Title</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getCompartment()
 * @model
 * @generated
 */
public interface Compartment extends Identity{
	/**
	 * Returns the value of the '<em><b>Collapsible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collapsible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collapsible</em>' attribute.
	 * @see #setCollapsible(boolean)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getCompartment_Collapsible()
	 * @model
	 * @generated
	 */
	boolean isCollapsible();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.Compartment#isCollapsible <em>Collapsible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collapsible</em>' attribute.
	 * @see #isCollapsible()
	 * @generated
	 */
	void setCollapsible(boolean value);

	/**
	 * Returns the value of the '<em><b>Needs Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Needs Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Needs Title</em>' attribute.
	 * @see #setNeedsTitle(boolean)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getCompartment_NeedsTitle()
	 * @model
	 * @generated
	 */
	boolean isNeedsTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.Compartment#isNeedsTitle <em>Needs Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Needs Title</em>' attribute.
	 * @see #isNeedsTitle()
	 * @generated
	 */
	void setNeedsTitle(boolean value);

} // Compartment
