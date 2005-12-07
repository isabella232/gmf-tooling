/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings;

import org.eclipse.gmf.gmfgraph.Child;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDiagramNode <em>Diagram Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.ChildNodeMapping#getCompartment <em>Compartment</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.ChildNodeMapping#getParentNode <em>Parent Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping()
 * @model
 * @generated
 */
public interface ChildNodeMapping extends AbstractNodeMapping{
	/**
	 * Returns the value of the '<em><b>Diagram Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Node</em>' reference.
	 * @see #setDiagramNode(Child)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping_DiagramNode()
	 * @model required="true"
	 * @generated
	 */
	Child getDiagramNode();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDiagramNode <em>Diagram Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Node</em>' reference.
	 * @see #getDiagramNode()
	 * @generated
	 */
	void setDiagramNode(Child value);

	/**
	 * Returns the value of the '<em><b>Compartment</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.mappings.CompartmentMapping#getChildNodes <em>Child Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartment</em>' reference.
	 * @see #setCompartment(CompartmentMapping)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping_Compartment()
	 * @see org.eclipse.gmf.mappings.CompartmentMapping#getChildNodes
	 * @model opposite="childNodes" required="true"
	 * @generated
	 */
	CompartmentMapping getCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.ChildNodeMapping#getCompartment <em>Compartment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compartment</em>' reference.
	 * @see #getCompartment()
	 * @generated
	 */
	void setCompartment(CompartmentMapping value);

	/**
	 * Returns the value of the '<em><b>Parent Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getChildMappings <em>Child Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Node</em>' container reference.
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping_ParentNode()
	 * @see org.eclipse.gmf.mappings.AbstractNodeMapping#getChildMappings
	 * @model opposite="childMappings" required="true" changeable="false"
	 * @generated
	 */
	AbstractNodeMapping getParentNode();

} // ChildNodeMapping
