/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modeled Viewmap</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * NOTE: Provisional API. Allows to use arbitrary model element to keep information about a figure. May (but not necessarily will) point to e.g. GMFGraph model elements. It's up to template author to handle specific kinds of figure models
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ModeledViewmap#getFigureModel <em>Figure Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getModeledViewmap()
 * @model
 * @generated
 */
public interface ModeledViewmap extends Viewmap {
	/**
	 * Returns the value of the '<em><b>Figure Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Figure Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Figure Model</em>' reference.
	 * @see #setFigureModel(EObject)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getModeledViewmap_FigureModel()
	 * @model required="true"
	 * @generated
	 */
	EObject getFigureModel();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ModeledViewmap#getFigureModel <em>Figure Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Figure Model</em>' reference.
	 * @see #getFigureModel()
	 * @generated
	 */
	void setFigureModel(EObject value);

} // ModeledViewmap
