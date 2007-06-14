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

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.sketch.SketchLink#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.SketchLink#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.SketchLink#getLabels <em>Labels</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.SketchLink#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchLink()
 * @model
 * @generated
 */
public interface SketchLink extends SketchDiagramElement, SketchLinkEnd {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.sketch.SketchLinkEnd}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference list.
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchLink_Source()
	 * @model type="org.eclipse.gmf.sketch.SketchLinkEnd" required="true"
	 * @generated
	 */
	EList<SketchLinkEnd> getSource();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.sketch.SketchLinkEnd}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference list.
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchLink_Target()
	 * @model type="org.eclipse.gmf.sketch.SketchLinkEnd" required="true"
	 * @generated
	 */
	EList<SketchLinkEnd> getTarget();

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
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchLink_Labels()
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
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchLink_Type()
	 * @model
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.sketch.SketchLink#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

} // SketchLink
