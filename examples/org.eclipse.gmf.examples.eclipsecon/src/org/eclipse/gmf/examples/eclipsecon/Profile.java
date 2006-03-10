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
 * A representation of the model object '<em><b>Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Profile#getBio <em>Bio</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Profile#getEclipsezilla <em>Eclipsezilla</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getProfile()
 * @model
 * @generated
 */
public interface Profile extends EObject {
	/**
	 * Returns the value of the '<em><b>Bio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bio</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bio</em>' attribute.
	 * @see #setBio(String)
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getProfile_Bio()
	 * @model
	 * @generated
	 */
	String getBio();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.Profile#getBio <em>Bio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bio</em>' attribute.
	 * @see #getBio()
	 * @generated
	 */
	void setBio(String value);

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
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getProfile_Eclipsezilla()
	 * @model
	 * @generated
	 */
	Resource getEclipsezilla();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.Profile#getEclipsezilla <em>Eclipsezilla</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eclipsezilla</em>' reference.
	 * @see #getEclipsezilla()
	 * @generated
	 */
	void setEclipsezilla(Resource value);

} // Profile
