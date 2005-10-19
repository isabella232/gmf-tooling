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
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getDomainNameFeature <em>Domain Name Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getContainmentMetaFeature <em>Containment Meta Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getViewmap <em>Viewmap</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getModelElementSelector <em>Model Element Selector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenBaseElement()
 * @model abstract="true"
 * @generated
 */
public interface GenBaseElement extends GenCommonBase{
	/**
	 * Returns the value of the '<em><b>Domain Name Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Name Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Name Feature</em>' reference.
	 * @see #setDomainNameFeature(GenFeature)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenBaseElement_DomainNameFeature()
	 * @model
	 * @generated
	 */
	GenFeature getDomainNameFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getDomainNameFeature <em>Domain Name Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Name Feature</em>' reference.
	 * @see #getDomainNameFeature()
	 * @generated
	 */
	void setDomainNameFeature(GenFeature value);

	/**
	 * Returns the value of the '<em><b>Containment Meta Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment Meta Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment Meta Feature</em>' reference.
	 * @see #setContainmentMetaFeature(GenFeature)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenBaseElement_ContainmentMetaFeature()
	 * @model annotation="http://www.eclipse.org/gmf/2005/constraints ocl='containmentMetaFeature.isContainment'"
	 * @generated
	 */
	GenFeature getContainmentMetaFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getContainmentMetaFeature <em>Containment Meta Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment Meta Feature</em>' reference.
	 * @see #getContainmentMetaFeature()
	 * @generated
	 */
	void setContainmentMetaFeature(GenFeature value);

	/**
	 * Returns the value of the '<em><b>Viewmap</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewmap</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewmap</em>' containment reference.
	 * @see #setViewmap(Viewmap)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenBaseElement_Viewmap()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Viewmap getViewmap();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getViewmap <em>Viewmap</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viewmap</em>' containment reference.
	 * @see #getViewmap()
	 * @generated
	 */
	void setViewmap(Viewmap value);

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasNameToEdit();

} // GenBaseElement
