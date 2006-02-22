/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getChildMappings <em>Child Mappings</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.AbstractNodeMapping#getCompartmentMappings <em>Compartment Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.mappings.GMFMapPackage#getAbstractNodeMapping()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='not (domainMetaElement.oclIsUndefined()  and containmentFeature.oclIsUndefined())' description='Either domain meta element or containment feature must be set in node mapping'"
 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='not domainMetaElement.oclIsUndefined() implies containmentFeature.oclIsUndefined() or containmentFeature.eReferenceType.isSuperTypeOf(domainMetaElement)' description='\'Domain Element\' must be the same or extend the type referenced by \'Containment Feature\''"
 * @generated
 */
public interface AbstractNodeMapping extends MappingEntry, MenuOwner, ToolOwner, AppearanceSteward {
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

} // AbstractNodeMapping
