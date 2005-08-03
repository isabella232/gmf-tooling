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
 * A representation of the literals of the enumeration '<em><b>Compartment Layout Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getCompartmentLayoutKind()
 * @model
 * @generated
 */
public final class CompartmentLayoutKind extends AbstractEnumerator {
	/**
	 * The '<em><b>BORDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BORDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BORDER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BORDER = 0;

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
	public static final int FLOW = 1;

	/**
	 * The '<em><b>SCROLL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCROLL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCROLL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCROLL = 2;

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
	public static final int TOOLBAR = 3;

	/**
	 * The '<em><b>XY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int XY = 4;

	/**
	 * The '<em><b>BORDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BORDER
	 * @generated
	 * @ordered
	 */
	public static final CompartmentLayoutKind BORDER_LITERAL = new CompartmentLayoutKind(BORDER, "BORDER");

	/**
	 * The '<em><b>FLOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOW
	 * @generated
	 * @ordered
	 */
	public static final CompartmentLayoutKind FLOW_LITERAL = new CompartmentLayoutKind(FLOW, "FLOW");

	/**
	 * The '<em><b>SCROLL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCROLL
	 * @generated
	 * @ordered
	 */
	public static final CompartmentLayoutKind SCROLL_LITERAL = new CompartmentLayoutKind(SCROLL, "SCROLL");

	/**
	 * The '<em><b>TOOLBAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOOLBAR
	 * @generated
	 * @ordered
	 */
	public static final CompartmentLayoutKind TOOLBAR_LITERAL = new CompartmentLayoutKind(TOOLBAR, "TOOLBAR");

	/**
	 * The '<em><b>XY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XY
	 * @generated
	 * @ordered
	 */
	public static final CompartmentLayoutKind XY_LITERAL = new CompartmentLayoutKind(XY, "XY");

	/**
	 * An array of all the '<em><b>Compartment Layout Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CompartmentLayoutKind[] VALUES_ARRAY =
		new CompartmentLayoutKind[] {
			BORDER_LITERAL,
			FLOW_LITERAL,
			SCROLL_LITERAL,
			TOOLBAR_LITERAL,
			XY_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Compartment Layout Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Compartment Layout Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompartmentLayoutKind get(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompartmentLayoutKind result = VALUES_ARRAY[i];
			if (result.toString().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Compartment Layout Kind</b></em>' literal with the specified value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompartmentLayoutKind get(int value) {
		switch (value) {
			case BORDER: return BORDER_LITERAL;
			case FLOW: return FLOW_LITERAL;
			case SCROLL: return SCROLL_LITERAL;
			case TOOLBAR: return TOOLBAR_LITERAL;
			case XY: return XY_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CompartmentLayoutKind(int value, String name) {
		super(value, name);
	}

} //CompartmentLayoutKind
