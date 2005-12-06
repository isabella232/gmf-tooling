/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.gmfgraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Size Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.gmfgraph.SizeStyle#getMaxSize <em>Max Size</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.SizeStyle#getMinSize <em>Min Size</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.SizeStyle#getPrefSize <em>Pref Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getSizeStyle()
 * @model
 * @generated
 */
public interface SizeStyle extends EObject {
	/**
	 * Returns the value of the '<em><b>Max Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Size</em>' containment reference.
	 * @see #setMaxSize(Point)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getSizeStyle_MaxSize()
	 * @model containment="true"
	 * @generated
	 */
	Point getMaxSize();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.SizeStyle#getMaxSize <em>Max Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Size</em>' containment reference.
	 * @see #getMaxSize()
	 * @generated
	 */
	void setMaxSize(Point value);

	/**
	 * Returns the value of the '<em><b>Min Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Size</em>' containment reference.
	 * @see #setMinSize(Point)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getSizeStyle_MinSize()
	 * @model containment="true"
	 * @generated
	 */
	Point getMinSize();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.SizeStyle#getMinSize <em>Min Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Size</em>' containment reference.
	 * @see #getMinSize()
	 * @generated
	 */
	void setMinSize(Point value);

	/**
	 * Returns the value of the '<em><b>Pref Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pref Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pref Size</em>' containment reference.
	 * @see #setPrefSize(Point)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getSizeStyle_PrefSize()
	 * @model containment="true"
	 * @generated
	 */
	Point getPrefSize();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.SizeStyle#getPrefSize <em>Pref Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pref Size</em>' containment reference.
	 * @see #getPrefSize()
	 * @generated
	 */
	void setPrefSize(Point value);

} // SizeStyle
