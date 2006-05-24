/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.bridge.internal.trace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.bridge.internal.trace.TraceModel#getNodeTraces <em>Node Traces</em>}</li>
 *   <li>{@link org.eclipse.gmf.bridge.internal.trace.TraceModel#getChildNodeTraces <em>Child Node Traces</em>}</li>
 *   <li>{@link org.eclipse.gmf.bridge.internal.trace.TraceModel#getLinkTraces <em>Link Traces</em>}</li>
 *   <li>{@link org.eclipse.gmf.bridge.internal.trace.TraceModel#getToolGroupTraces <em>Tool Group Traces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.bridge.internal.trace.TracePackage#getTraceModel()
 * @model
 * @generated
 */
public interface TraceModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Traces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.bridge.internal.trace.GenNodeTrace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Traces</em>' containment reference list.
	 * @see org.eclipse.gmf.bridge.internal.trace.TracePackage#getTraceModel_NodeTraces()
	 * @model type="org.eclipse.gmf.bridge.internal.trace.GenNodeTrace" containment="true"
	 * @generated
	 */
	EList getNodeTraces();

	/**
	 * Returns the value of the '<em><b>Child Node Traces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.bridge.internal.trace.GenChildNodeTrace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Node Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Node Traces</em>' containment reference list.
	 * @see org.eclipse.gmf.bridge.internal.trace.TracePackage#getTraceModel_ChildNodeTraces()
	 * @model type="org.eclipse.gmf.bridge.internal.trace.GenChildNodeTrace" containment="true"
	 * @generated
	 */
	EList getChildNodeTraces();

	/**
	 * Returns the value of the '<em><b>Link Traces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.bridge.internal.trace.GenLinkTrace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Traces</em>' containment reference list.
	 * @see org.eclipse.gmf.bridge.internal.trace.TracePackage#getTraceModel_LinkTraces()
	 * @model type="org.eclipse.gmf.bridge.internal.trace.GenLinkTrace" containment="true"
	 * @generated
	 */
	EList getLinkTraces();

	/**
	 * Returns the value of the '<em><b>Tool Group Traces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.bridge.internal.trace.ToolGroupTrace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Group Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool Group Traces</em>' containment reference list.
	 * @see org.eclipse.gmf.bridge.internal.trace.TracePackage#getTraceModel_ToolGroupTraces()
	 * @model type="org.eclipse.gmf.bridge.internal.trace.ToolGroupTrace" containment="true"
	 * @generated
	 */
	EList getToolGroupTraces();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	GenNodeTrace getNodeTrace(int visualID);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	GenLinkTrace getLinkTrace(int visualID);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="org.eclipse.gmf.bridge.internal.trace.AbstractTrace"
	 * @generated
	 */
	EList getAllAbstractTraces();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void purgeUnprocessedTraces();

} // TraceModel