/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Feature Model Facet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Model facet of a number of EStructuralFeatures
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.CompositeFeatureModelFacet#getMetaFeatures <em>Meta Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getCompositeFeatureModelFacet()
 * @model
 * @generated
 */
public interface CompositeFeatureModelFacet extends ModelFacet {
	/**
	 * Returns the value of the '<em><b>Meta Features</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Features</em>' reference list.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getCompositeFeatureModelFacet_MetaFeatures()
	 * @model type="org.eclipse.emf.codegen.ecore.genmodel.GenFeature" lower="2"
	 * @generated
	 */
	EList getMetaFeatures();

} // CompositeFeatureModelFacet
