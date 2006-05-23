/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.gmfgraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Figure Handle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Entry in the figure's hierarchy to reference from diagram element
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.gmfgraph.FigureHandle#getReferencingElements <em>Referencing Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigureHandle()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface FigureHandle extends EObject {
	/**
	 * Returns the value of the '<em><b>Referencing Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.gmfgraph.DiagramElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.gmfgraph.DiagramElement#getFigure <em>Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencing Elements</em>' reference list.
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigureHandle_ReferencingElements()
	 * @see org.eclipse.gmf.gmfgraph.DiagramElement#getFigure
	 * @model type="org.eclipse.gmf.gmfgraph.DiagramElement" opposite="figure"
	 * @generated
	 */
	EList getReferencingElements();

} // FigureHandle