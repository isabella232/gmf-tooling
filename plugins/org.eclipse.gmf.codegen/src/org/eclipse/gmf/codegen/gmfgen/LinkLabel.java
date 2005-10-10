/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Label attached to link
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.LinkLabel#getDomainMetaFeature <em>Domain Meta Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.LinkLabel#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.LinkLabel#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.LinkLabel#getLink <em>Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getLinkLabel()
 * @model
 * @generated
 */
public interface LinkLabel extends EObject{
	/**
	 * Returns the value of the '<em><b>Domain Meta Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Meta Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Meta Feature</em>' reference.
	 * @see #setDomainMetaFeature(GenFeature)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getLinkLabel_DomainMetaFeature()
	 * @model required="true"
	 * @generated
	 */
	GenFeature getDomainMetaFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.LinkLabel#getDomainMetaFeature <em>Domain Meta Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Meta Feature</em>' reference.
	 * @see #getDomainMetaFeature()
	 * @generated
	 */
	void setDomainMetaFeature(GenFeature value);

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getLinkLabel_ReadOnly()
	 * @model
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.LinkLabel#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * relative position on link; ranges from 0 to 100 (percent)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(int)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getLinkLabel_Weight()
	 * @model default="50"
	 * @generated
	 */
	int getWeight();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.LinkLabel#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(int value);

	/**
	 * Returns the value of the '<em><b>Link</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.GenLink#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link</em>' container reference.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getLinkLabel_Link()
	 * @see org.eclipse.gmf.codegen.gmfgen.GenLink#getLabels
	 * @model opposite="labels" required="true" changeable="false"
	 * @generated
	 */
	GenLink getLink();

} // LinkLabel
