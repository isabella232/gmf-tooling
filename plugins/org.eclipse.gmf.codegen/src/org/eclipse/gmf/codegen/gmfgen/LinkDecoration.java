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
 * A representation of the model object '<em><b>Link Decoration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.LinkDecoration#getFigureQualifiedClassName <em>Figure Qualified Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getLinkDecoration()
 * @model
 * @generated
 */
public interface LinkDecoration extends EObject{
	/**
	 * Returns the value of the '<em><b>Figure Qualified Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Implementation of {@link org.eclipse.draw2d.RotatableDecoration}
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Figure Qualified Class Name</em>' attribute.
	 * @see #setFigureQualifiedClassName(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getLinkDecoration_FigureQualifiedClassName()
	 * @model
	 * @generated
	 */
	String getFigureQualifiedClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.LinkDecoration#getFigureQualifiedClassName <em>Figure Qualified Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Figure Qualified Class Name</em>' attribute.
	 * @see #getFigureQualifiedClassName()
	 * @generated
	 */
	void setFigureQualifiedClassName(String value);

} // LinkDecoration
