/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;

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
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getContainmentMetaFeature <em>Containment Meta Feature</em>}</li>
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
	 * @see #setDomainNameFeature(EAttribute)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenBaseElement_DomainNameFeature()
	 * @model
	 * @generated
	 */
	EAttribute getDomainNameFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getDomainNameFeature <em>Domain Name Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Name Feature</em>' reference.
	 * @see #getDomainNameFeature()
	 * @generated
	 */
	void setDomainNameFeature(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Foreground Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreground Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreground Color</em>' attribute.
	 * @see #setForegroundColor(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenBaseElement_ForegroundColor()
	 * @model
	 * @generated
	 */
	String getForegroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getForegroundColor <em>Foreground Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreground Color</em>' attribute.
	 * @see #getForegroundColor()
	 * @generated
	 */
	void setForegroundColor(String value);

	/**
	 * Returns the value of the '<em><b>Containment Meta Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment Meta Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment Meta Feature</em>' reference.
	 * @see #setContainmentMetaFeature(EReference)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenBaseElement_ContainmentMetaFeature()
	 * @model annotation="http://www.eclipse.org/gmf/2005/constraints ocl='containmentFeature.isContainment'"
	 * @generated
	 */
	EReference getContainmentMetaFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenBaseElement#getContainmentMetaFeature <em>Containment Meta Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment Meta Feature</em>' reference.
	 * @see #getContainmentMetaFeature()
	 * @generated
	 */
	void setContainmentMetaFeature(EReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasNameToEdit();

} // GenBaseElement
