/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.bridge.internal.trace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import org.eclipse.gmf.bridge.internal.trace.GenNodeLabelTrace;
import org.eclipse.gmf.bridge.internal.trace.TracePackage;

import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Node Label Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class GenNodeLabelTraceImpl extends MatchingTraceImpl implements GenNodeLabelTrace {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenNodeLabelTraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TracePackage.Literals.GEN_NODE_LABEL_TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setContext(GenNodeLabel genNodeLabel) {
		setQueryText("true");
	}

	public Query createQuery() {
		return QueryFactory.eINSTANCE.createQuery(getQueryText(), GMFGenPackage.eINSTANCE.getGenNodeLabel());
	}
	
} //GenNodeLabelTraceImpl