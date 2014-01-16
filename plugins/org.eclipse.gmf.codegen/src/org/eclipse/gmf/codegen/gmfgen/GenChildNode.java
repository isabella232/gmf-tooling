/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Child Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenChildNode#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenChildNode()
 * @model annotation="http://www.eclipse.org/gmf/2005/constraints ocl='not modelFacet.oclIsUndefined() implies not modelFacet.containmentMetaFeature.oclIsUndefined()' description='Child node must specify \'Containment Meta Feature\''"
 * @generated
 */
public interface GenChildNode extends GenChildNodeBase {
	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.GenDiagram#getChildNodes <em>Child Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram</em>' container reference.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenChildNode_Diagram()
	 * @see org.eclipse.gmf.codegen.gmfgen.GenDiagram#getChildNodes
	 * @model opposite="childNodes" resolveProxies="false" required="true" transient="false" changeable="false"
	 * @generated
	 */
	GenDiagram getDiagram();

} // GenChildNode
