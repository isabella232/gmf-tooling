/**
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 *
 * $Id: Map.java,v 1.1 2007/10/31 13:49:16 rgronback Exp $
 */
package org.eclipse.gmf.examples.mindmap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Map#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Map#getRootTopics <em>Root Topics</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Map#getRelations <em>Relations</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Map#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getMap()
 * @model
 * @generated
 */
public interface Map extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getMap_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Map#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Root Topics</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.Topic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Topics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Topics</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getMap_RootTopics()
	 * @model containment="true"
	 * @generated
	 */
	EList<Topic> getRootTopics();

	/**
	 * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.Relationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getMap_Relations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Relationship> getRelations();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getMap_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<Resource> getResources();

} // Map
