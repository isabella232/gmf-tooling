/**
 */
package org.eclipse.gmf.tooling.examples.svg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Playground</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.svg.Playground#getPlayers <em>Players</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.svg.Playground#getGoals <em>Goals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.svg.SvgPackage#getPlayground()
 * @model
 * @generated
 */
public interface Playground extends EObject {
	/**
	 * Returns the value of the '<em><b>Players</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.svg.Player}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Players</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Players</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.svg.SvgPackage#getPlayground_Players()
	 * @model containment="true" upper="12"
	 * @generated
	 */
	EList<Player> getPlayers();

	/**
	 * Returns the value of the '<em><b>Goals</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.svg.Goal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.svg.SvgPackage#getPlayground_Goals()
	 * @model containment="true" upper="2"
	 * @generated
	 */
	EList<Goal> getGoals();

} // Playground
