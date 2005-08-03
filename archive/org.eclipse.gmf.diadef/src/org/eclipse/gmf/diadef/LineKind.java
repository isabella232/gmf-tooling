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
 * A representation of the literals of the enumeration '<em><b>Line Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getLineKind()
 * @model
 * @generated
 */
public final class LineKind extends AbstractEnumerator {
	/**
	 * The '<em><b>SOLID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOLID</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOLID_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOLID = 0;

	/**
	 * The '<em><b>DOT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOT = 1;

	/**
	 * The '<em><b>DASH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DASH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DASH_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DASH = 2;

	/**
	 * The '<em><b>SOLID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOLID
	 * @generated
	 * @ordered
	 */
	public static final LineKind SOLID_LITERAL = new LineKind(SOLID, "SOLID");

	/**
	 * The '<em><b>DOT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOT
	 * @generated
	 * @ordered
	 */
	public static final LineKind DOT_LITERAL = new LineKind(DOT, "DOT");

	/**
	 * The '<em><b>DASH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DASH
	 * @generated
	 * @ordered
	 */
	public static final LineKind DASH_LITERAL = new LineKind(DASH, "DASH");

	/**
	 * An array of all the '<em><b>Line Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final LineKind[] VALUES_ARRAY =
		new LineKind[] {
			SOLID_LITERAL,
			DOT_LITERAL,
			DASH_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Line Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Line Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LineKind get(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LineKind result = VALUES_ARRAY[i];
			if (result.toString().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Line Kind</b></em>' literal with the specified value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LineKind get(int value) {
		switch (value) {
			case SOLID: return SOLID_LITERAL;
			case DOT: return DOT_LITERAL;
			case DASH: return DASH_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private LineKind(int value, String name) {
		super(value, name);
	}

} //LineKind
