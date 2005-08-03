/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.diadef.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.ChildNodeMapping#getCompartment <em>Compartment</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDiagramNode <em>Diagram Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDomainChildrenFeature <em>Domain Children Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.ChildNodeMapping#getConditionalFeature <em>Conditional Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping()
 * @model
 * @generated
 */
public interface ChildNodeMapping extends EObject{
	/**
	 * Returns the value of the '<em><b>Compartment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartment</em>' reference.
	 * @see #setCompartment(Compartment)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping_Compartment()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='eContainer.diagramNode.compartments->includes(self.compartment)'"
	 * @generated
	 */
	Compartment getCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.ChildNodeMapping#getCompartment <em>Compartment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compartment</em>' reference.
	 * @see #getCompartment()
	 * @generated
	 */
	void setCompartment(Compartment value);

	/**
	 * Returns the value of the '<em><b>Diagram Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Node</em>' reference.
	 * @see #setDiagramNode(Node)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping_DiagramNode()
	 * @model required="true"
	 * @generated
	 */
	Node getDiagramNode();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDiagramNode <em>Diagram Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Node</em>' reference.
	 * @see #getDiagramNode()
	 * @generated
	 */
	void setDiagramNode(Node value);

	/**
	 * Returns the value of the '<em><b>Domain Children Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Children Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Children Feature</em>' reference.
	 * @see #setDomainChildrenFeature(EStructuralFeature)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping_DomainChildrenFeature()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='eContainer.domainMetaElement.eAllAttributes->includes(domainChildrenFeature)'"
	 * @generated
	 */
	EStructuralFeature getDomainChildrenFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDomainChildrenFeature <em>Domain Children Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Children Feature</em>' reference.
	 * @see #getDomainChildrenFeature()
	 * @generated
	 */
	void setDomainChildrenFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Conditional Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. EcorePackage.getEClass_EReferences for domainChildrenFeature with EcorePackage.getEReference_Containment for conditionalFeature
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conditional Feature</em>' reference.
	 * @see #setConditionalFeature(EAttribute)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping_ConditionalFeature()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='domainChildrenFeature.eClass.eAllAttributes->includes(conditionalFeature) and conditionalFeature.eType == EcorePackage.getEBoolean'"
	 * @generated
	 */
	EAttribute getConditionalFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.ChildNodeMapping#getConditionalFeature <em>Conditional Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conditional Feature</em>' reference.
	 * @see #getConditionalFeature()
	 * @generated
	 */
	void setConditionalFeature(EAttribute value);

} // ChildNodeMapping
