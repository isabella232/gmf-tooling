/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.gmfgraph;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pin Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.gmfgraph.PinOwner#getPins <em>Pins</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getPinOwner()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PinOwner extends EObject {
	/**
	 * Returns the value of the '<em><b>Pins</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.gmfgraph.Pin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pins</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pins</em>' containment reference list.
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getPinOwner_Pins()
	 * @model containment="true"
	 * @generated
	 */
	EList<Pin> getPins();

} // PinOwner
