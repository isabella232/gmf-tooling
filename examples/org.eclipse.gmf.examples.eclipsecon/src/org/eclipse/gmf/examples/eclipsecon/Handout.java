/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Handout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Handout#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Handout#getEclipsezilla <em>Eclipsezilla</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getHandout()
 * @model
 * @generated
 */
public interface Handout extends EObject {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gmf.examples.eclipsecon.HandoutKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.gmf.examples.eclipsecon.HandoutKind
	 * @see #setKind(HandoutKind)
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getHandout_Kind()
	 * @model
	 * @generated
	 */
	HandoutKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.Handout#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.gmf.examples.eclipsecon.HandoutKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(HandoutKind value);

	/**
	 * Returns the value of the '<em><b>Eclipsezilla</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eclipsezilla</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eclipsezilla</em>' reference.
	 * @see #setEclipsezilla(Resource)
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getHandout_Eclipsezilla()
	 * @model
	 * @generated
	 */
	Resource getEclipsezilla();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.Handout#getEclipsezilla <em>Eclipsezilla</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eclipsezilla</em>' reference.
	 * @see #getEclipsezilla()
	 * @generated
	 */
	void setEclipsezilla(Resource value);

} // Handout
