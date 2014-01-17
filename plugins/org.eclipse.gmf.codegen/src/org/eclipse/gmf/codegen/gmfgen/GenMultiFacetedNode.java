/**
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Multi Faceted Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @since 2.111 
 * 	GenMultiFacetedNode can serve in both child-and top-level mode. 
 * 	It normally has multiple model facetes, every facet comes different creation command. 
 * 	It may be associated with multiple child-modes without any top-level mode, e.g for UML pins which are never top-level.
 * 	See bugzilla #403577 for details and explanations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenMultiFacetedNode#getDiagram <em>Diagram</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenMultiFacetedNode#isDesignWhenTopLevel <em>Design When Top Level</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenMultiFacetedNode#getAdditionalModelFacets <em>Additional Model Facets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenMultiFacetedNode()
 * @model
 * @generated
 */
public interface GenMultiFacetedNode extends GenChildNodeBase {
	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.GenDiagram#getMultiFacetedNodes <em>Multi Faceted Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram</em>' container reference.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenMultiFacetedNode_Diagram()
	 * @see org.eclipse.gmf.codegen.gmfgen.GenDiagram#getMultiFacetedNodes
	 * @model opposite="multiFacetedNodes" resolveProxies="false" required="true" transient="false" changeable="false"
	 * @generated
	 */
	GenDiagram getDiagram();

	/**
	 * Returns the value of the '<em><b>Design When Top Level</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * main modelFacet comes from GenNode and is associated with top-level mode. 
	 * 		This attribute allows to distinuish cases when top-level mode is present, but design-only, so without model facet
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Design When Top Level</em>' attribute.
	 * @see #setDesignWhenTopLevel(boolean)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenMultiFacetedNode_DesignWhenTopLevel()
	 * @model default="false"
	 * @generated
	 */
	boolean isDesignWhenTopLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenMultiFacetedNode#isDesignWhenTopLevel <em>Design When Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Design When Top Level</em>' attribute.
	 * @see #isDesignWhenTopLevel()
	 * @generated
	 */
	void setDesignWhenTopLevel(boolean value);

	/**
	 * Returns the value of the '<em><b>Additional Model Facets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.codegen.gmfgen.TypeNodeModelFacet}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.TypeNodeModelFacet#getMultiFacetedNode <em>Multi Faceted Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Model Facets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Model Facets</em>' containment reference list.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenMultiFacetedNode_AdditionalModelFacets()
	 * @see org.eclipse.gmf.codegen.gmfgen.TypeNodeModelFacet#getMultiFacetedNode
	 * @model opposite="multiFacetedNode" containment="true"
	 * @generated
	 */
	EList<TypeNodeModelFacet> getAdditionalModelFacets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All model facets, for toplevel- and child- modes
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	EList<TypeModelFacet> allModelFacets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	TypeNodeModelFacet findFacetForContainer(GenChildContainer container);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	TypeModelFacet findFacetForContainerOrDiagram(GenContainerBase container);

} // GenMultiFacetedNode
