/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.ocldriven.toe;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>All Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.ocldriven.toe.AllHolder#getAll <em>All</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getAllHolder()
 * @model
 * @generated
 */
public interface AllHolder extends EObject {
	/**
	 * Returns the value of the '<em><b>All</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.ocldriven.toe.AllBase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.ocldriven.toe.TOEPackage#getAllHolder_All()
	 * @model containment="true"
	 * @generated
	 */
	EList<AllBase> getAll();

} // AllHolder
