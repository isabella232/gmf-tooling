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
 * A representation of the literals of the enumeration '<em><b>Provider Priority</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getProviderPriority()
 * @model
 * @generated
 */
public final class ProviderPriority extends AbstractEnumerator {
	/**
	 * The '<em><b>Lowest</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lowest</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWEST_LITERAL
	 * @model name="Lowest"
	 * @generated
	 * @ordered
	 */
	public static final int LOWEST = 0;

	/**
	 * The '<em><b>Low</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Low</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOW_LITERAL
	 * @model name="Low"
	 * @generated
	 * @ordered
	 */
	public static final int LOW = 1;

	/**
	 * The '<em><b>Medium</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Medium</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEDIUM_LITERAL
	 * @model name="Medium"
	 * @generated
	 * @ordered
	 */
	public static final int MEDIUM = 2;

	/**
	 * The '<em><b>High</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>High</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIGH_LITERAL
	 * @model name="High"
	 * @generated
	 * @ordered
	 */
	public static final int HIGH = 3;

	/**
	 * The '<em><b>Highest</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Highest</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIGHEST_LITERAL
	 * @model name="Highest"
	 * @generated
	 * @ordered
	 */
	public static final int HIGHEST = 4;

	/**
	 * The '<em><b>Lowest</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWEST
	 * @generated
	 * @ordered
	 */
	public static final ProviderPriority LOWEST_LITERAL = new ProviderPriority(LOWEST, "Lowest", "Lowest");

	/**
	 * The '<em><b>Low</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOW
	 * @generated
	 * @ordered
	 */
	public static final ProviderPriority LOW_LITERAL = new ProviderPriority(LOW, "Low", "Low");

	/**
	 * The '<em><b>Medium</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIUM
	 * @generated
	 * @ordered
	 */
	public static final ProviderPriority MEDIUM_LITERAL = new ProviderPriority(MEDIUM, "Medium", "Medium");

	/**
	 * The '<em><b>High</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGH
	 * @generated
	 * @ordered
	 */
	public static final ProviderPriority HIGH_LITERAL = new ProviderPriority(HIGH, "High", "High");

	/**
	 * The '<em><b>Highest</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGHEST
	 * @generated
	 * @ordered
	 */
	public static final ProviderPriority HIGHEST_LITERAL = new ProviderPriority(HIGHEST, "Highest", "Highest");

	/**
	 * An array of all the '<em><b>Provider Priority</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ProviderPriority[] VALUES_ARRAY =
		new ProviderPriority[] {
			LOWEST_LITERAL,
			LOW_LITERAL,
			MEDIUM_LITERAL,
			HIGH_LITERAL,
			HIGHEST_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Provider Priority</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Provider Priority</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProviderPriority get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProviderPriority result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Provider Priority</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProviderPriority getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProviderPriority result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Provider Priority</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProviderPriority get(int value) {
		switch (value) {
			case LOWEST: return LOWEST_LITERAL;
			case LOW: return LOW_LITERAL;
			case MEDIUM: return MEDIUM_LITERAL;
			case HIGH: return HIGH_LITERAL;
			case HIGHEST: return HIGHEST_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ProviderPriority(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ProviderPriority
