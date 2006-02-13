/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Label Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.NodeLabelMapping#isExternal <em>External</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.NodeLabelMapping#getNodeMapping <em>Node Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.mappings.GMFMapPackage#getNodeLabelMapping()
 * @model
 * @generated
 */
public interface NodeLabelMapping extends LabelMapping {
	/**
	 * Returns the value of the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External</em>' attribute.
	 * @see #setExternal(boolean)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getNodeLabelMapping_External()
	 * @model
	 * @generated
	 */
	boolean isExternal();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.NodeLabelMapping#isExternal <em>External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External</em>' attribute.
	 * @see #isExternal()
	 * @generated
	 */
	void setExternal(boolean value);

	/**
	 * Returns the value of the '<em><b>Node Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getLabelMappings <em>Label Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Mapping</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Mapping</em>' container reference.
	 * @see #setNodeMapping(AbstractNodeMapping)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getNodeLabelMapping_NodeMapping()
	 * @see org.eclipse.gmf.mappings.AbstractNodeMapping#getLabelMappings
	 * @model opposite="labelMappings" required="true"
	 * @generated
	 */
	AbstractNodeMapping getNodeMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.NodeLabelMapping#getNodeMapping <em>Node Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Mapping</em>' container reference.
	 * @see #getNodeMapping()
	 * @generated
	 */
	void setNodeMapping(AbstractNodeMapping value);

} // NodeLabelMapping
