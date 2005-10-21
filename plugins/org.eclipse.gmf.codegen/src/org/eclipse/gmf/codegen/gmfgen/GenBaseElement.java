/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Base Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * would be better to call this one GenBaseDiagramElement, as it is for elements placed on the canvas
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getModelElementSelector <em>Model Element Selector</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getModelElementInitializer <em>Model Element Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenBaseElement()
 * @model abstract="true"
 * @generated
 */
public interface GenBaseElement extends GenCommonBase{
	/**
	 * Returns the value of the '<em><b>Model Element Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Selector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element Selector</em>' containment reference.
	 * @see #setModelElementSelector(ModelElementSelector)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenBaseElement_ModelElementSelector()
	 * @model containment="true"
	 * @generated
	 */
	ModelElementSelector getModelElementSelector();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getModelElementSelector <em>Model Element Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element Selector</em>' containment reference.
	 * @see #getModelElementSelector()
	 * @generated
	 */
	void setModelElementSelector(ModelElementSelector value);

	/**
	 * Returns the value of the '<em><b>Model Element Initializer</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.GenElementInitializer#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Initializer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element Initializer</em>' containment reference.
	 * @see #setModelElementInitializer(GenElementInitializer)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenBaseElement_ModelElementInitializer()
	 * @see org.eclipse.gmf.codegen.gmfgen.GenElementInitializer#getElement
	 * @model opposite="element" containment="true"
	 * @generated
	 */
	GenElementInitializer getModelElementInitializer();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getModelElementInitializer <em>Model Element Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element Initializer</em>' containment reference.
	 * @see #getModelElementInitializer()
	 * @generated
	 */
	void setModelElementInitializer(GenElementInitializer value);

} // GenBaseElement
