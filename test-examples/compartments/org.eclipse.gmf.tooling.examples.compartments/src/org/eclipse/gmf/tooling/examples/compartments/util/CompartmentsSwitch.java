/**
 */
package org.eclipse.gmf.tooling.examples.compartments.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.gmf.tooling.examples.compartments.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage
 * @generated
 */
public class CompartmentsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CompartmentsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentsSwitch() {
		if (modelPackage == null) {
			modelPackage = CompartmentsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CompartmentsPackage.CANVAS: {
				Canvas canvas = (Canvas)theEObject;
				T result = caseCanvas(canvas);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompartmentsPackage.TOP_NODE_A: {
				TopNodeA topNodeA = (TopNodeA)theEObject;
				T result = caseTopNodeA(topNodeA);
				if (result == null) result = caseTopNode(topNodeA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompartmentsPackage.TOP_NODE_B: {
				TopNodeB topNodeB = (TopNodeB)theEObject;
				T result = caseTopNodeB(topNodeB);
				if (result == null) result = caseTopNode(topNodeB);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompartmentsPackage.CHILD_OF_BE: {
				ChildOfB_E childOfB_E = (ChildOfB_E)theEObject;
				T result = caseChildOfB_E(childOfB_E);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompartmentsPackage.CHILD_OF_BG: {
				ChildOfB_G childOfB_G = (ChildOfB_G)theEObject;
				T result = caseChildOfB_G(childOfB_G);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompartmentsPackage.TOP_NODE: {
				TopNode topNode = (TopNode)theEObject;
				T result = caseTopNode(topNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompartmentsPackage.CHILD_OF_AC: {
				ChildOfA_C childOfA_C = (ChildOfA_C)theEObject;
				T result = caseChildOfA_C(childOfA_C);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompartmentsPackage.CHILD_OF_BF: {
				ChildOfB_F childOfB_F = (ChildOfB_F)theEObject;
				T result = caseChildOfB_F(childOfB_F);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompartmentsPackage.CHILD_OF_AFFIXED: {
				ChildOfAffixed childOfAffixed = (ChildOfAffixed)theEObject;
				T result = caseChildOfAffixed(childOfAffixed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompartmentsPackage.CHILD_OF_AD: {
				ChildOfA_D childOfA_D = (ChildOfA_D)theEObject;
				T result = caseChildOfA_D(childOfA_D);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Canvas</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Canvas</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCanvas(Canvas object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top Node A</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top Node A</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopNodeA(TopNodeA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top Node B</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top Node B</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopNodeB(TopNodeB object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Child Of BE</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Child Of BE</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChildOfB_E(ChildOfB_E object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Child Of BG</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Child Of BG</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChildOfB_G(ChildOfB_G object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopNode(TopNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Child Of AC</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Child Of AC</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChildOfA_C(ChildOfA_C object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Child Of BF</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Child Of BF</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChildOfB_F(ChildOfB_F object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Child Of Affixed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Child Of Affixed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChildOfAffixed(ChildOfAffixed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Child Of AD</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Child Of AD</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChildOfA_D(ChildOfA_D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CompartmentsSwitch
