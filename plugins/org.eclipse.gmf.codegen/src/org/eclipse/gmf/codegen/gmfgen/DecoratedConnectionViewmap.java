/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decorated Connection Viewmap</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.DecoratedConnectionViewmap#getFigureQualifiedClassName <em>Figure Qualified Class Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.DecoratedConnectionViewmap#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.DecoratedConnectionViewmap#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getDecoratedConnectionViewmap()
 * @model
 * @generated
 */
public interface DecoratedConnectionViewmap extends Viewmap, FigureViewmap {
	/**
	 * Returns the value of the '<em><b>Figure Qualified Class Name</b></em>' attribute.
	 * The default value is <code>"org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Shall be instance of {@link org.eclipse.draw2d.PolylineConnection}
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Figure Qualified Class Name</em>' attribute.
	 * @see #setFigureQualifiedClassName(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getDecoratedConnectionViewmap_FigureQualifiedClassName()
	 * @model default="org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx"
	 * @generated
	 */
	String getFigureQualifiedClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.DecoratedConnectionViewmap#getFigureQualifiedClassName <em>Figure Qualified Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Figure Qualified Class Name</em>' attribute.
	 * @see #getFigureQualifiedClassName()
	 * @generated
	 */
	void setFigureQualifiedClassName(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(LinkDecoration)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getDecoratedConnectionViewmap_Source()
	 * @model containment="true"
	 * @generated
	 */
	LinkDecoration getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.DecoratedConnectionViewmap#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(LinkDecoration value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(LinkDecoration)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getDecoratedConnectionViewmap_Target()
	 * @model containment="true"
	 * @generated
	 */
	LinkDecoration getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.DecoratedConnectionViewmap#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(LinkDecoration value);

} // DecoratedConnectionViewmap
