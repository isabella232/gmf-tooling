/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.bridge.internal.trace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.gmf.codegen.gmfgen.GenNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Node Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.bridge.internal.trace.GenNodeTrace#getNodeLabelTraces <em>Node Label Traces</em>}</li>
 *   <li>{@link org.eclipse.gmf.bridge.internal.trace.GenNodeTrace#getCompartmentTraces <em>Compartment Traces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.bridge.internal.trace.TracePackage#getGenNodeTrace()
 * @model
 * @generated
 */
public interface GenNodeTrace extends MatchingTrace {
	/**
	 * Returns the value of the '<em><b>Node Label Traces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.bridge.internal.trace.GenNodeLabelTrace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Label Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Label Traces</em>' containment reference list.
	 * @see org.eclipse.gmf.bridge.internal.trace.TracePackage#getGenNodeTrace_NodeLabelTraces()
	 * @model type="org.eclipse.gmf.bridge.internal.trace.GenNodeLabelTrace" containment="true"
	 * @generated
	 */
	EList getNodeLabelTraces();

	/**
	 * Returns the value of the '<em><b>Compartment Traces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.bridge.internal.trace.GenCompartmentTrace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartment Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartment Traces</em>' containment reference list.
	 * @see org.eclipse.gmf.bridge.internal.trace.TracePackage#getGenNodeTrace_CompartmentTraces()
	 * @model type="org.eclipse.gmf.bridge.internal.trace.GenCompartmentTrace" containment="true"
	 * @generated
	 */
	EList getCompartmentTraces();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setContext(GenNode genNode);

} // GenNodeTrace