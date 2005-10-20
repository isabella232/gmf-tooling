/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 *   <li>{@link org.eclipse.gmf.mappings.ChildNodeMapping#getEditFeature <em>Edit Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDomainMetaElement <em>Domain Meta Element</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDomainSpecialization <em>Domain Specialization</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDomainInitializer <em>Domain Initializer</em>}</li>
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
	 * Returns the value of the '<em><b>Edit Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edit Feature</em>' reference.
	 * @see #setEditFeature(EAttribute)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping_EditFeature()
	 * @model
	 * @generated
	 */
	EAttribute getEditFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.ChildNodeMapping#getEditFeature <em>Edit Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edit Feature</em>' reference.
	 * @see #getEditFeature()
	 * @generated
	 */
	void setEditFeature(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Domain Meta Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Meta Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Meta Element</em>' reference.
	 * @see #setDomainMetaElement(EClass)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping_DomainMetaElement()
	 * @model
	 * @generated
	 */
	EClass getDomainMetaElement();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDomainMetaElement <em>Domain Meta Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Meta Element</em>' reference.
	 * @see #getDomainMetaElement()
	 * @generated
	 */
	void setDomainMetaElement(EClass value);

	/**
	 * Returns the value of the '<em><b>Domain Specialization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specializes further the domain meta element EClass associated with this mapping and should be evaluated in this EClass context
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Specialization</em>' containment reference.
	 * @see #setDomainSpecialization(Constraint)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping_DomainSpecialization()
	 * @model containment="true"
	 * @generated
	 */
	Constraint getDomainSpecialization();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDomainSpecialization <em>Domain Specialization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Specialization</em>' containment reference.
	 * @see #getDomainSpecialization()
	 * @generated
	 */
	void setDomainSpecialization(Constraint value);

	/**
	 * Returns the value of the '<em><b>Domain Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Initializer for the domain model element associated with mapping
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Initializer</em>' containment reference.
	 * @see #setDomainInitializer(ElementInitializer)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getChildNodeMapping_DomainInitializer()
	 * @model containment="true"
	 * @generated
	 */
	ElementInitializer getDomainInitializer();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.ChildNodeMapping#getDomainInitializer <em>Domain Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Initializer</em>' containment reference.
	 * @see #getDomainInitializer()
	 * @generated
	 */
	void setDomainInitializer(ElementInitializer value);

} // ChildNodeMapping
