/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.gmfgraph;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Figure Marker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Anything you could combine visual representation from. Ordinary GEF figures, custom-defined or references to defined elsewhere.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.gmfgraph.FigureMarker#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigureMarker()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface FigureMarker extends Layoutable {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.gmfgraph.Figure#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigureMarker_Parent()
	 * @see org.eclipse.gmf.gmfgraph.Figure#getChildren
	 * @model opposite="children" resolveProxies="false" changeable="false"
	 * @generated
	 */
	Figure getParent();

} // FigureMarker
