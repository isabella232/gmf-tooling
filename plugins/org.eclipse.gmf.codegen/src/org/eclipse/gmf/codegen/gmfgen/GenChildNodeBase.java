/**
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Child Node Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @since 2.111 
 * 	Node that may serve in a child-mode, that is to have a container other than diagram. See bugzilla #403577 for details and explanations. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenChildNodeBase#getContainers <em>Containers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenChildNodeBase()
 * @model abstract="true"
 * @generated
 */
public interface GenChildNodeBase extends GenNode {
	/**
	 * Returns the value of the '<em><b>Containers</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.codegen.gmfgen.GenChildContainer}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.GenChildContainer#getChildNodes <em>Child Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containers</em>' reference list.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenChildNodeBase_Containers()
	 * @see org.eclipse.gmf.codegen.gmfgen.GenChildContainer#getChildNodes
	 * @model opposite="childNodes" changeable="false"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='let cmps:OrderedSet(GenChildContainer)=containers->select(oclIsKindOf(GenCompartment)) in cmps->exists(oclAsType(GenCompartment).listLayout) implies not cmps->exists(not oclAsType(GenCompartment).listLayout)' description='Node is referenced from multiple containers with different \'List Layout\' value'"
	 * @generated
	 */
	EList<GenChildContainer> getContainers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	TypeModelFacet findFacetForContainer(GenChildContainer container);

} // GenChildNodeBase
