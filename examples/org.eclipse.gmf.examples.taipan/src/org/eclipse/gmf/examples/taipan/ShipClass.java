/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.taipan;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ship Class</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.taipan.TaiPanPackage#getShipClass()
 * @model
 * @generated
 */
public enum ShipClass implements Enumerator {
	/**
	 * The '<em><b>TRIBAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIBAL_VALUE
	 * @generated
	 * @ordered
	 */
	TRIBAL(0, "TRIBAL", "TRIBAL"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>AMPHION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AMPHION_VALUE
	 * @generated
	 * @ordered
	 */
	AMPHION(1, "AMPHION", "AMPHION"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>FRIGAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRIGAT_VALUE
	 * @generated
	 * @ordered
	 */
	FRIGAT(2, "FRIGAT", "FRIGAT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>BATTLESHIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BATTLESHIP_VALUE
	 * @generated
	 * @ordered
	 */
	BATTLESHIP(3, "BATTLESHIP", "BATTLESHIP"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>CRUISER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CRUISER_VALUE
	 * @generated
	 * @ordered
	 */
	CRUISER(4, "CRUISER", "CRUISER"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>TRIBAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRIBAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRIBAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIBAL_VALUE = 0;

	/**
	 * The '<em><b>AMPHION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AMPHION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AMPHION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AMPHION_VALUE = 1;

	/**
	 * The '<em><b>FRIGAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FRIGAT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRIGAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRIGAT_VALUE = 2;

	/**
	 * The '<em><b>BATTLESHIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BATTLESHIP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BATTLESHIP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BATTLESHIP_VALUE = 3;

	/**
	 * The '<em><b>CRUISER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CRUISER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CRUISER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CRUISER_VALUE = 4;

	/**
	 * An array of all the '<em><b>Ship Class</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ShipClass[] VALUES_ARRAY = new ShipClass[] { TRIBAL, AMPHION, FRIGAT, BATTLESHIP, CRUISER, };

	/**
	 * A public read-only list of all the '<em><b>Ship Class</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ShipClass> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ship Class</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ShipClass get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ShipClass result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ship Class</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ShipClass getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ShipClass result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ship Class</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ShipClass get(int value) {
		switch (value) {
		case TRIBAL_VALUE:
			return TRIBAL;
		case AMPHION_VALUE:
			return AMPHION;
		case FRIGAT_VALUE:
			return FRIGAT;
		case BATTLESHIP_VALUE:
			return BATTLESHIP;
		case CRUISER_VALUE:
			return CRUISER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ShipClass(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //ShipClass
