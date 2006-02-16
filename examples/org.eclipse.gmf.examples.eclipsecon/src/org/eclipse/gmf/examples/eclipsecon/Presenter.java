/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Presenter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Presenter#getBio <em>Bio</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Presenter#getPhone <em>Phone</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getPresenter()
 * @model
 * @generated
 */
public interface Presenter extends Participant {
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
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getPresenter_Bio()
	 * @model
	 * @generated
	 */
	String getBio();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.Presenter#getBio <em>Bio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bio</em>' attribute.
	 * @see #getBio()
	 * @generated
	 */
	void setBio(String value);

	/**
	 * Returns the value of the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone</em>' attribute.
	 * @see #setPhone(int)
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getPresenter_Phone()
	 * @model
	 * @generated
	 */
	int getPhone();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.Presenter#getPhone <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone</em>' attribute.
	 * @see #getPhone()
	 * @generated
	 */
	void setPhone(int value);

} // Presenter
