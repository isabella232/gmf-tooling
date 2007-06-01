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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.sketch.SketchCompartment#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.SketchCompartment#getReferencedNodes <em>Referenced Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchCompartment()
 * @model
 * @generated
 */
public interface SketchCompartment extends SketchDiagramElement {

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
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchCompartment_Nodes()
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
	 * @see org.eclipse.gmf.sketch.SketchPackage#getSketchCompartment_ReferencedNodes()
	 * @model type="org.eclipse.gmf.sketch.SketchNode"
	 * @generated
	 */
	EList<SketchNode> getReferencedNodes();

} // SketchCompartment
