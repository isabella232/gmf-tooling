/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Label Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.LinkLabelMapping#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.LinkLabelMapping#getLinkMapping <em>Link Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.mappings.GMFMapPackage#getLinkLabelMapping()
 * @model
 * @generated
 */
public interface LinkLabelMapping extends LabelMapping {
	/**
	 * Returns the value of the '<em><b>Alignment</b></em>' attribute.
	 * The default value is <code>"MIDDLE"</code>.
	 * The literals are from the enumeration {@link org.eclipse.gmf.mappings.LinkLabelAlignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alignment</em>' attribute.
	 * @see org.eclipse.gmf.mappings.LinkLabelAlignment
	 * @see #setAlignment(LinkLabelAlignment)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getLinkLabelMapping_Alignment()
	 * @model default="MIDDLE"
	 * @generated
	 */
	LinkLabelAlignment getAlignment();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.LinkLabelMapping#getAlignment <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alignment</em>' attribute.
	 * @see org.eclipse.gmf.mappings.LinkLabelAlignment
	 * @see #getAlignment()
	 * @generated
	 */
	void setAlignment(LinkLabelAlignment value);

	/**
	 * Returns the value of the '<em><b>Link Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.mappings.LinkMapping#getLabelMappings <em>Label Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Mapping</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Mapping</em>' container reference.
	 * @see #setLinkMapping(LinkMapping)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getLinkLabelMapping_LinkMapping()
	 * @see org.eclipse.gmf.mappings.LinkMapping#getLabelMappings
	 * @model opposite="labelMappings" required="true"
	 * @generated
	 */
	LinkMapping getLinkMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.LinkLabelMapping#getLinkMapping <em>Link Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Mapping</em>' container reference.
	 * @see #getLinkMapping()
	 * @generated
	 */
	void setLinkMapping(LinkMapping value);

} // LinkLabelMapping
