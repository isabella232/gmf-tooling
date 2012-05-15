/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.layers;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Enablement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.layers.LayerEnablement#getLayer <em>Layer</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.layers.LayerEnablement#isVisible <em>Visible</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.layers.LayersPackage#getLayerEnablement()
 * @model
 * @generated
 */
public interface LayerEnablement extends EObject {
	/**
	 * Returns the value of the '<em><b>Layer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer</em>' reference.
	 * @see #setLayer(Layer)
	 * @see org.eclipse.gmf.examples.layers.LayersPackage#getLayerEnablement_Layer()
	 * @model
	 * @generated
	 */
	Layer getLayer();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.layers.LayerEnablement#getLayer <em>Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer</em>' reference.
	 * @see #getLayer()
	 * @generated
	 */
	void setLayer(Layer value);

	/**
	 * Returns the value of the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible</em>' attribute.
	 * @see #setVisible(boolean)
	 * @see org.eclipse.gmf.examples.layers.LayersPackage#getLayerEnablement_Visible()
	 * @model
	 * @generated
	 */
	boolean isVisible();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.layers.LayerEnablement#isVisible <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible</em>' attribute.
	 * @see #isVisible()
	 * @generated
	 */
	void setVisible(boolean value);

} // LayerEnablement
