/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Feature Label Model Facet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Model facet of a label based on a number of EStructuralFeatures
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.CompositeFeatureLabelModelFacet#getViewPattern <em>View Pattern</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.CompositeFeatureLabelModelFacet#getEditPattern <em>Edit Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getCompositeFeatureLabelModelFacet()
 * @model
 * @generated
 */
public interface CompositeFeatureLabelModelFacet extends CompositeFeatureModelFacet, LabelModelFacet {
	/**
	 * Returns the value of the '<em><b>View Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pattern for java.text.MessageFormat to produce label on diagram
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>View Pattern</em>' attribute.
	 * @see #setViewPattern(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getCompositeFeatureLabelModelFacet_ViewPattern()
	 * @model required="true"
	 * @generated
	 */
	String getViewPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.CompositeFeatureLabelModelFacet#getViewPattern <em>View Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Pattern</em>' attribute.
	 * @see #getViewPattern()
	 * @generated
	 */
	void setViewPattern(String value);

	/**
	 * Returns the value of the '<em><b>Edit Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pattern for java.text.MessageFormat to produce text for inplace editor; if not specified then viewPattern should be used
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Edit Pattern</em>' attribute.
	 * @see #setEditPattern(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getCompositeFeatureLabelModelFacet_EditPattern()
	 * @model
	 * @generated
	 */
	String getEditPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.CompositeFeatureLabelModelFacet#getEditPattern <em>Edit Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edit Pattern</em>' attribute.
	 * @see #getEditPattern()
	 * @generated
	 */
	void setEditPattern(String value);

} // CompositeFeatureLabelModelFacet
