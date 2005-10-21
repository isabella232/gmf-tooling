/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Model Facet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Model facet of an EStructuralFeature
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.FeatureModelFacet#getMetaFeature <em>Meta Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getFeatureModelFacet()
 * @model
 * @generated
 */
public interface FeatureModelFacet extends ModelFacet {
	/**
	 * Returns the value of the '<em><b>Meta Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Feature</em>' reference.
	 * @see #setMetaFeature(GenFeature)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getFeatureModelFacet_MetaFeature()
	 * @model required="true"
	 * @generated
	 */
	GenFeature getMetaFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.FeatureModelFacet#getMetaFeature <em>Meta Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Feature</em>' reference.
	 * @see #getMetaFeature()
	 * @generated
	 */
	void setMetaFeature(GenFeature value);

} // FeatureModelFacet
