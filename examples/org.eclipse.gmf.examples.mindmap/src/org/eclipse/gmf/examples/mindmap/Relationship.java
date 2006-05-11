/**
 * <copyright>
 * </copyright>
 *
 * $Id: Relationship.java,v 1.1 2006/05/11 01:47:59 rgronback Exp $
 */
package org.eclipse.gmf.examples.mindmap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Relationship#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Relationship#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Relationship#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Relationship#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getRelationship()
 * @model
 * @generated
 */
public interface Relationship extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getRelationship_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Relationship#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Topic)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getRelationship_Source()
	 * @model required="true"
	 * @generated
	 */
	Topic getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Relationship#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Topic value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Topic)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getRelationship_Target()
	 * @model required="true"
	 * @generated
	 */
	Topic getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Relationship#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Topic value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gmf.examples.mindmap.RelationshipType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.gmf.examples.mindmap.RelationshipType
	 * @see #setType(RelationshipType)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getRelationship_Type()
	 * @model
	 * @generated
	 */
	RelationshipType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Relationship#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.gmf.examples.mindmap.RelationshipType
	 * @see #getType()
	 * @generated
	 */
	void setType(RelationshipType value);

} // Relationship