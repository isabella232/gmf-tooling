/**
 * Copyright (c) 2010-2012 ISBAN S.L
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 		Ruben De Dios (ISBAN S.L)
 * 		Andrez Alvarez Mattos (ISBAN S.L)
 */
package org.eclipse.gmf.tooling.simplemap.simplemappings;

import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.mappings.CompartmentMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment#getCompartmentMapping <em>Compartment Mapping</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment#getCompartment <em>Compartment</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment#getCompartmentLabel <em>Compartment Label</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment#isNeedsTitle <em>Needs Title</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage#getSimpleCompartment()
 * @model
 * @generated
 */
public interface SimpleCompartment extends SimpleParentNode, SimpleChildNode, SimpleMappingElementWithFigure {

	/**
	 * Returns the value of the '<em><b>Compartment Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartment Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartment Mapping</em>' reference.
	 * @see #setCompartmentMapping(CompartmentMapping)
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage#getSimpleCompartment_CompartmentMapping()
	 * @model derived="true"
	 * @generated
	 */
	CompartmentMapping getCompartmentMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment#getCompartmentMapping <em>Compartment Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compartment Mapping</em>' reference.
	 * @see #getCompartmentMapping()
	 * @generated
	 */
	void setCompartmentMapping(CompartmentMapping value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage#getSimpleCompartment_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Compartment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartment</em>' reference.
	 * @see #isSetCompartment()
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage#getSimpleCompartment_Compartment()
	 * @model unsettable="true" changeable="false" derived="true"
	 * @generated
	 */
	Compartment getCompartment();

	/**
	 * Returns whether the value of the '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment#getCompartment <em>Compartment</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Compartment</em>' reference is set.
	 * @see #getCompartment()
	 * @generated
	 */
	boolean isSetCompartment();

	/**
	 * Returns the value of the '<em><b>Compartment Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartment Label</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartment Label</em>' reference.
	 * @see #isSetCompartmentLabel()
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage#getSimpleCompartment_CompartmentLabel()
	 * @model unsettable="true" changeable="false" derived="true"
	 * @generated
	 */
	Label getCompartmentLabel();

	/**
	 * Returns whether the value of the '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment#getCompartmentLabel <em>Compartment Label</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Compartment Label</em>' reference is set.
	 * @see #getCompartmentLabel()
	 * @generated
	 */
	boolean isSetCompartmentLabel();

	/**
	 * Returns the value of the '<em><b>Needs Title</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Needs Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Needs Title</em>' attribute.
	 * @see #setNeedsTitle(boolean)
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage#getSimpleCompartment_NeedsTitle()
	 * @model default="true"
	 * @generated
	 */
	boolean isNeedsTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment#isNeedsTitle <em>Needs Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Needs Title</em>' attribute.
	 * @see #isNeedsTitle()
	 * @generated
	 */
	void setNeedsTitle(boolean value);

} // SimpleCompartment
