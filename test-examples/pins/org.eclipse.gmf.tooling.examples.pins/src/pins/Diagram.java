/**
 */
package pins;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pins.Diagram#getGetPins <em>Get Pins</em>}</li>
 * </ul>
 * </p>
 *
 * @see pins.PinsPackage#getDiagram()
 * @model
 * @generated
 */
public interface Diagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Get Pins</b></em>' containment reference list.
	 * The list contents are of type {@link pins.Pin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Get Pins</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get Pins</em>' containment reference list.
	 * @see pins.PinsPackage#getDiagram_GetPins()
	 * @model containment="true"
	 * @generated
	 */
	EList<Pin> getGetPins();

} // Diagram
