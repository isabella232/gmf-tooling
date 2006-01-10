/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getDomainMetaElement <em>Domain Meta Element</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getDomainSpecialization <em>Domain Specialization</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getDomainInitializer <em>Domain Initializer</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getContainmentFeature <em>Containment Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getEditFeature <em>Edit Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getChildMappings <em>Child Mappings</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getCompartmentMappings <em>Compartment Mappings</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getTool <em>Tool</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.mappings.GMFMapPackage#getAbstractNodeMapping()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2004/EmfaticAnnotationMap constraints='http://www.eclipse.org/gmf/2005/constraints' constraintsMeta='http://www.eclipse.org/gmf/2005/constraints/meta'"
 * @generated
 */
public interface AbstractNodeMapping extends EObject {
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
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getAbstractNodeMapping_DomainMetaElement()
	 * @model
	 * @generated
	 */
	EClass getDomainMetaElement();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getDomainMetaElement <em>Domain Meta Element</em>}' reference.
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
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getAbstractNodeMapping_DomainSpecialization()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='context' ocl='self.getDomainContext()'"
	 * @generated
	 */
	Constraint getDomainSpecialization();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getDomainSpecialization <em>Domain Specialization</em>}' containment reference.
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
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getAbstractNodeMapping_DomainInitializer()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='let i : FeatureSeqInitializer = domainInitializer.oclAsType( FeatureSeqInitializer) in i.oclIsUndefined() or i.initializers.feature.eContainingClass->forAll(c|c.isSuperTypeOf(domainMetaElement))'"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='context' ocl='self.getDomainContext()'"
	 * @generated
	 */
	ElementInitializer getDomainInitializer();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getDomainInitializer <em>Domain Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Initializer</em>' containment reference.
	 * @see #getDomainInitializer()
	 * @generated
	 */
	void setDomainInitializer(ElementInitializer value);

	/**
	 * Returns the value of the '<em><b>Containment Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment Feature</em>' reference.
	 * @see #setContainmentFeature(EReference)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getAbstractNodeMapping_ContainmentFeature()
	 * @model annotation="http://www.eclipse.org/gmf/2005/constraints ocl='containmentFeature.containment'"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='domainMetaElement.oclIsUndefined() or containmentFeature.eReferenceType.isSuperTypeOf(domainMetaElement)'"
	 * @generated
	 */
	EReference getContainmentFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getContainmentFeature <em>Containment Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment Feature</em>' reference.
	 * @see #getContainmentFeature()
	 * @generated
	 */
	void setContainmentFeature(EReference value);

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
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getAbstractNodeMapping_EditFeature()
	 * @model annotation="http://www.eclipse.org/gmf/2005/constraints ocl='editFeature.oclIsUndefined() or (not domainMetaElement.oclIsUndefined() and editFeature.eContainingClass.isSuperTypeOf(domainMetaElement)) or containmentFeature.eType.oclAsType(ecore::EClass).eAllAttributes->includes(editFeature)'"
	 * @generated
	 */
	EAttribute getEditFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getEditFeature <em>Edit Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edit Feature</em>' reference.
	 * @see #getEditFeature()
	 * @generated
	 */
	void setEditFeature(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Child Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.mappings.ChildNodeMapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.mappings.ChildNodeMapping#getParentNode <em>Parent Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Mappings</em>' containment reference list.
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getAbstractNodeMapping_ChildMappings()
	 * @see org.eclipse.gmf.mappings.ChildNodeMapping#getParentNode
	 * @model type="org.eclipse.gmf.mappings.ChildNodeMapping" opposite="parentNode" containment="true"
	 * @generated
	 */
	EList getChildMappings();

	/**
	 * Returns the value of the '<em><b>Compartment Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.mappings.CompartmentMapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.mappings.CompartmentMapping#getParentNodeMapping <em>Parent Node Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartment Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartment Mappings</em>' containment reference list.
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getAbstractNodeMapping_CompartmentMappings()
	 * @see org.eclipse.gmf.mappings.CompartmentMapping#getParentNodeMapping
	 * @model type="org.eclipse.gmf.mappings.CompartmentMapping" opposite="parentNodeMapping" containment="true"
	 * @generated
	 */
	EList getCompartmentMappings();

	/**
	 * Returns the value of the '<em><b>Tool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Way to create the node
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tool</em>' containment reference.
	 * @see #setTool(Tool)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getAbstractNodeMapping_Tool()
	 * @model containment="true"
	 * @generated
	 */
	Tool getTool();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getTool <em>Tool</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tool</em>' containment reference.
	 * @see #getTool()
	 * @generated
	 */
	void setTool(Tool value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EClass getDomainContext();

} // AbstractNodeMapping
