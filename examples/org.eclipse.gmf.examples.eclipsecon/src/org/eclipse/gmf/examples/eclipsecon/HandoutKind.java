/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Handout Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getHandoutKind()
 * @model
 * @generated
 */
public final class HandoutKind extends AbstractEnumerator {
	/**
	 * The '<em><b>PRINTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRINTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRINTED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRINTED = 0;

	/**
	 * The '<em><b>CD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CD = 0;

	/**
	 * The '<em><b>MEM KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MEM KEY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEM_KEY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEM_KEY = 0;

	/**
	 * The '<em><b>PRINTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRINTED
	 * @generated
	 * @ordered
	 */
	public static final HandoutKind PRINTED_LITERAL = new HandoutKind(PRINTED, "PRINTED", "PRINTED");

	/**
	 * The '<em><b>CD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CD
	 * @generated
	 * @ordered
	 */
	public static final HandoutKind CD_LITERAL = new HandoutKind(CD, "CD", "CD");

	/**
	 * The '<em><b>MEM KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEM_KEY
	 * @generated
	 * @ordered
	 */
	public static final HandoutKind MEM_KEY_LITERAL = new HandoutKind(MEM_KEY, "MEM_KEY", "MEM_KEY");

	/**
	 * An array of all the '<em><b>Handout Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final HandoutKind[] VALUES_ARRAY =
		new HandoutKind[] {
			PRINTED_LITERAL,
			CD_LITERAL,
			MEM_KEY_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Handout Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Handout Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HandoutKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HandoutKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Handout Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HandoutKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HandoutKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Handout Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HandoutKind get(int value) {
		switch (value) {
			case PRINTED: return PRINTED_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private HandoutKind(int value, String name, String literal) {
		super(value, name, literal);
	}

} //HandoutKind
