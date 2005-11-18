/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Compartment Placement Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getCompartmentPlacementKind()
 * @model
 * @generated
 */
public final class CompartmentPlacementKind extends AbstractEnumerator {
	/**
	 * The '<em><b>FLOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLOW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOW = 0;

	/**
	 * The '<em><b>TOOLBAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOOLBAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOOLBAR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOOLBAR = 1;

	/**
	 * The '<em><b>FLOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOW
	 * @generated
	 * @ordered
	 */
	public static final CompartmentPlacementKind FLOW_LITERAL = new CompartmentPlacementKind(FLOW, "FLOW", "FLOW");

	/**
	 * The '<em><b>TOOLBAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOOLBAR
	 * @generated
	 * @ordered
	 */
	public static final CompartmentPlacementKind TOOLBAR_LITERAL = new CompartmentPlacementKind(TOOLBAR, "TOOLBAR", "TOOLBAR");

	/**
	 * An array of all the '<em><b>Compartment Placement Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CompartmentPlacementKind[] VALUES_ARRAY =
		new CompartmentPlacementKind[] {
			FLOW_LITERAL,
			TOOLBAR_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Compartment Placement Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Compartment Placement Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompartmentPlacementKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompartmentPlacementKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Compartment Placement Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompartmentPlacementKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompartmentPlacementKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Compartment Placement Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompartmentPlacementKind get(int value) {
		switch (value) {
			case FLOW: return FLOW_LITERAL;
			case TOOLBAR: return TOOLBAR_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CompartmentPlacementKind(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CompartmentPlacementKind
