/**
 */
package org.eclipse.gmf.tooling.examples.affixednode;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Canvas</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.Canvas#getBundles <em>Bundles</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.Canvas#getCommunications <em>Communications</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage#getCanvas()
 * @model
 * @generated
 */
public interface Canvas extends EObject {
	/**
	 * Returns the value of the '<em><b>Bundles</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.affixednode.Bundle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundles</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage#getCanvas_Bundles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Bundle> getBundles();

	/**
	 * Returns the value of the '<em><b>Communications</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.affixednode.Communication}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Communications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communications</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage#getCanvas_Communications()
	 * @model containment="true"
	 * @generated
	 */
	EList<Communication> getCommunications();

} // Canvas
