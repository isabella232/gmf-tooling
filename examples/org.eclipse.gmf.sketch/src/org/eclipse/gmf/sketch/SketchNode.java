/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.sketch;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.sketch.SketchNode#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.SketchNode#getReferencedNodes <em>Referenced Nodes</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.SketchNode#getCompartments <em>Compartments</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.SketchNode#getLabels <em>Labels</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.SketchNode#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.SketchNode#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.SketchNode#isOnBorder <em>On Border</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchNode()
 * @model
 * @generated
 */
public interface SketchNode extends SketchDiagramElement, SketchLinkEnd {

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.sketch.SketchNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchNode_Nodes()
	 * @model type="org.eclipse.gmf.sketch.SketchNode" containment="true"
	 * @generated
	 */
	EList<SketchNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Referenced Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.sketch.SketchNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Nodes</em>' reference list.
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchNode_ReferencedNodes()
	 * @model type="org.eclipse.gmf.sketch.SketchNode"
	 * @generated
	 */
	EList<SketchNode> getReferencedNodes();

	/**
	 * Returns the value of the '<em><b>Compartments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.sketch.SketchCompartment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartments</em>' containment reference list.
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchNode_Compartments()
	 * @model type="org.eclipse.gmf.sketch.SketchCompartment" containment="true"
	 * @generated
	 */
	EList<SketchCompartment> getCompartments();

	/**
	 * Returns the value of the '<em><b>Labels</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.sketch.SketchLabel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Labels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Labels</em>' containment reference list.
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchNode_Labels()
	 * @model type="org.eclipse.gmf.sketch.SketchLabel" containment="true"
	 * @generated
	 */
	EList<SketchLabel> getLabels();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchNode_Type()
	 * @model
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.sketch.SketchNode#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchNode_Attributes()
	 * @model type="org.eclipse.emf.ecore.EAttribute"
	 * @generated
	 */
	EList<EAttribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>On Border</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Border</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Border</em>' attribute.
	 * @see #setOnBorder(boolean)
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchNode_OnBorder()
	 * @model
	 * @generated
	 */
	boolean isOnBorder();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.sketch.SketchNode#isOnBorder <em>On Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Border</em>' attribute.
	 * @see #isOnBorder()
	 * @generated
	 */
	void setOnBorder(boolean value);

} // SketchNode
