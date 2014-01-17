/**
 */
package org.eclipse.gmf.codegen.gmfgen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Node Model Facet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @since 2.111 
 * 	Node model facet, specific for GenMultiFacetedNode's. Every such facet holds its own knwoledge about creation commands.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.TypeNodeModelFacet#getMultiFacetedNode <em>Multi Faceted Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.TypeNodeModelFacet#getCreateCommandClassName <em>Create Command Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getTypeNodeModelFacet()
 * @model
 * @generated
 */
public interface TypeNodeModelFacet extends TypeModelFacet {
	/**
	 * Returns the value of the '<em><b>Multi Faceted Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.GenMultiFacetedNode#getAdditionalModelFacets <em>Additional Model Facets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Faceted Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Faceted Node</em>' container reference.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getTypeNodeModelFacet_MultiFacetedNode()
	 * @see org.eclipse.gmf.codegen.gmfgen.GenMultiFacetedNode#getAdditionalModelFacets
	 * @model opposite="additionalModelFacets" resolveProxies="false" required="true" transient="false" changeable="false"
	 * @generated
	 */
	GenMultiFacetedNode getMultiFacetedNode();

	/**
	 * Returns the value of the '<em><b>Create Command Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Command Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Command Class Name</em>' attribute.
	 * @see #setCreateCommandClassName(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getTypeNodeModelFacet_CreateCommandClassName()
	 * @model
	 * @generated
	 */
	String getCreateCommandClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.TypeNodeModelFacet#getCreateCommandClassName <em>Create Command Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Command Class Name</em>' attribute.
	 * @see #getCreateCommandClassName()
	 * @generated
	 */
	void setCreateCommandClassName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getCreateCommandQualifiedClassName();

} // TypeNodeModelFacet
