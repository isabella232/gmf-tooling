/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Visual Effect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenVisualEffect#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenVisualEffect#getPinKind <em>Pin Kind</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenVisualEffect#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenVisualEffect#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenVisualEffect#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenVisualEffect()
 * @model
 * @generated
 */
public interface GenVisualEffect extends CustomBehaviour {
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
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenVisualEffect_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenVisualEffect#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Pin Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pin Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pin Kind</em>' attribute.
	 * @see #setPinKind(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenVisualEffect_PinKind()
	 * @model
	 * @generated
	 */
	String getPinKind();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenVisualEffect#getPinKind <em>Pin Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pin Kind</em>' attribute.
	 * @see #getPinKind()
	 * @generated
	 */
	void setPinKind(String value);

	/**
	 * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Name</em>' attribute.
	 * @see #setOperationName(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenVisualEffect_OperationName()
	 * @model
	 * @generated
	 */
	String getOperationName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenVisualEffect#getOperationName <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Name</em>' attribute.
	 * @see #getOperationName()
	 * @generated
	 */
	void setOperationName(String value);

	/**
	 * Returns the value of the '<em><b>Operation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Type</em>' attribute.
	 * @see #setOperationType(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenVisualEffect_OperationType()
	 * @model
	 * @generated
	 */
	String getOperationType();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenVisualEffect#getOperationType <em>Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Type</em>' attribute.
	 * @see #getOperationType()
	 * @generated
	 */
	void setOperationType(String value);

	/**
	 * Returns the value of the '<em><b>Ocl Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Expression</em>' attribute.
	 * @see #setOclExpression(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenVisualEffect_OclExpression()
	 * @model
	 * @generated
	 */
	String getOclExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenVisualEffect#getOclExpression <em>Ocl Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression</em>' attribute.
	 * @see #getOclExpression()
	 * @generated
	 */
	void setOclExpression(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getOclExpressionString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EClassifier getOperationRuntimeType();

} // GenVisualEffect
