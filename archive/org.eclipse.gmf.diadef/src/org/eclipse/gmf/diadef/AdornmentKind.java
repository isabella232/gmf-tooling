/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.diadef;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Adornment Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getAdornmentKind()
 * @model
 * @generated
 */
public final class AdornmentKind extends AbstractEnumerator {
	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE_LITERAL
	 * @model name="None"
	 * @generated
	 * @ordered
	 */
	public static final int NONE = 0;

	/**
	 * The '<em><b>Open Triangle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Open Triangle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPEN_TRIANGLE_LITERAL
	 * @model name="OpenTriangle"
	 * @generated
	 * @ordered
	 */
	public static final int OPEN_TRIANGLE = 1;

	/**
	 * The '<em><b>Filled Triangle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Filled Triangle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILLED_TRIANGLE_LITERAL
	 * @model name="FilledTriangle"
	 * @generated
	 * @ordered
	 */
	public static final int FILLED_TRIANGLE = 2;

	/**
	 * The '<em><b>Rhomb</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rhomb</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RHOMB_LITERAL
	 * @model name="Rhomb"
	 * @generated
	 * @ordered
	 */
	public static final int RHOMB = 3;

	/**
	 * The '<em><b>Filled Rhomb</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Filled Rhomb</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILLED_RHOMB_LITERAL
	 * @model name="FilledRhomb"
	 * @generated
	 * @ordered
	 */
	public static final int FILLED_RHOMB = 4;

	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @generated
	 * @ordered
	 */
	public static final AdornmentKind NONE_LITERAL = new AdornmentKind(NONE, "None");

	/**
	 * The '<em><b>Open Triangle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPEN_TRIANGLE
	 * @generated
	 * @ordered
	 */
	public static final AdornmentKind OPEN_TRIANGLE_LITERAL = new AdornmentKind(OPEN_TRIANGLE, "OpenTriangle");

	/**
	 * The '<em><b>Filled Triangle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILLED_TRIANGLE
	 * @generated
	 * @ordered
	 */
	public static final AdornmentKind FILLED_TRIANGLE_LITERAL = new AdornmentKind(FILLED_TRIANGLE, "FilledTriangle");

	/**
	 * The '<em><b>Rhomb</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RHOMB
	 * @generated
	 * @ordered
	 */
	public static final AdornmentKind RHOMB_LITERAL = new AdornmentKind(RHOMB, "Rhomb");

	/**
	 * The '<em><b>Filled Rhomb</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILLED_RHOMB
	 * @generated
	 * @ordered
	 */
	public static final AdornmentKind FILLED_RHOMB_LITERAL = new AdornmentKind(FILLED_RHOMB, "FilledRhomb");

	/**
	 * An array of all the '<em><b>Adornment Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AdornmentKind[] VALUES_ARRAY =
		new AdornmentKind[] {
			NONE_LITERAL,
			OPEN_TRIANGLE_LITERAL,
			FILLED_TRIANGLE_LITERAL,
			RHOMB_LITERAL,
			FILLED_RHOMB_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Adornment Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Adornment Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AdornmentKind get(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AdornmentKind result = VALUES_ARRAY[i];
			if (result.toString().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Adornment Kind</b></em>' literal with the specified value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AdornmentKind get(int value) {
		switch (value) {
			case NONE: return NONE_LITERAL;
			case OPEN_TRIANGLE: return OPEN_TRIANGLE_LITERAL;
			case FILLED_TRIANGLE: return FILLED_TRIANGLE_LITERAL;
			case RHOMB: return RHOMB_LITERAL;
			case FILLED_RHOMB: return FILLED_RHOMB_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AdornmentKind(int value, String name) {
		super(value, name);
	}

} //AdornmentKind
