/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shape Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Mirrors attributes of {@link org.eclipse.draw2d.Shape} class
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ShapeAttributes#getLineWidth <em>Line Width</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ShapeAttributes#getLineStyle <em>Line Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getShapeAttributes()
 * @model
 * @generated
 */
public interface ShapeAttributes extends Attributes{
	/**
	 * Returns the value of the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Width</em>' attribute.
	 * @see #isSetLineWidth()
	 * @see #unsetLineWidth()
	 * @see #setLineWidth(int)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getShapeAttributes_LineWidth()
	 * @model unsettable="true"
	 * @generated
	 */
	int getLineWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ShapeAttributes#getLineWidth <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Width</em>' attribute.
	 * @see #isSetLineWidth()
	 * @see #unsetLineWidth()
	 * @see #getLineWidth()
	 * @generated
	 */
	void setLineWidth(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ShapeAttributes#getLineWidth <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLineWidth()
	 * @see #getLineWidth()
	 * @see #setLineWidth(int)
	 * @generated
	 */
	void unsetLineWidth();

	/**
	 * Returns whether the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ShapeAttributes#getLineWidth <em>Line Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Line Width</em>' attribute is set.
	 * @see #unsetLineWidth()
	 * @see #getLineWidth()
	 * @see #setLineWidth(int)
	 * @generated
	 */
	boolean isSetLineWidth();

	/**
	 * Returns the value of the '<em><b>Line Style</b></em>' attribute.
	 * The default value is <code>"LINE_SOLID"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * One of LINE_* constants defined in {@link org.eclipse.draw2d.Graphics}
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Line Style</em>' attribute.
	 * @see #setLineStyle(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getShapeAttributes_LineStyle()
	 * @model default="LINE_SOLID"
	 * @generated
	 */
	String getLineStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ShapeAttributes#getLineStyle <em>Line Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Style</em>' attribute.
	 * @see #getLineStyle()
	 * @generated
	 */
	void setLineStyle(String value);

} // ShapeAttributes
