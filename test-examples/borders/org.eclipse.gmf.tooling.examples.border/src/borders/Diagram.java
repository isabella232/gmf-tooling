/**
 */
package borders;

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
 *   <li>{@link borders.Diagram#getBorders <em>Borders</em>}</li>
 * </ul>
 * </p>
 *
 * @see borders.BordersPackage#getDiagram()
 * @model
 * @generated
 */
public interface Diagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Borders</b></em>' containment reference list.
	 * The list contents are of type {@link borders.Border}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Borders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Borders</em>' containment reference list.
	 * @see borders.BordersPackage#getDiagram_Borders()
	 * @model containment="true"
	 * @generated
	 */
	EList<Border> getBorders();

} // Diagram
