/**
 */
package org.eclipse.gmf.tooling.examples.links;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.links.LinksFactory
 * @model kind="package"
 * @generated
 */
public interface LinksPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "links";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "links";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LinksPackage eINSTANCE = org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.links.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.links.impl.RootImpl
	 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>Child AB Element Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__CHILD_AB_ELEMENT_LINKS = 0;

	/**
	 * The feature id for the '<em><b>Root Node As</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__ROOT_NODE_AS = 1;

	/**
	 * The feature id for the '<em><b>Root Node Bs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__ROOT_NODE_BS = 2;

	/**
	 * The feature id for the '<em><b>Root BA Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__ROOT_BA_LINKS = 3;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.links.impl.RootNodeAImpl <em>Root Node A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.links.impl.RootNodeAImpl
	 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getRootNodeA()
	 * @generated
	 */
	int ROOT_NODE_A = 1;

	/**
	 * The feature id for the '<em><b>Children Node A</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_NODE_A__CHILDREN_NODE_A = 0;

	/**
	 * The number of structural features of the '<em>Root Node A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_NODE_A_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Root Node A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_NODE_A_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.links.impl.RootNodeBImpl <em>Root Node B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.links.impl.RootNodeBImpl
	 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getRootNodeB()
	 * @generated
	 */
	int ROOT_NODE_B = 2;

	/**
	 * The feature id for the '<em><b>Children B</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_NODE_B__CHILDREN_B = 0;

	/**
	 * The feature id for the '<em><b>Root BA Feature Link</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_NODE_B__ROOT_BA_FEATURE_LINK = 1;

	/**
	 * The number of structural features of the '<em>Root Node B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_NODE_B_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Root Node B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_NODE_B_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.links.impl.ChildNodeAImpl <em>Child Node A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.links.impl.ChildNodeAImpl
	 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getChildNodeA()
	 * @generated
	 */
	int CHILD_NODE_A = 3;

	/**
	 * The feature id for the '<em><b>Child AB Feature Link</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_NODE_A__CHILD_AB_FEATURE_LINK = 0;

	/**
	 * The number of structural features of the '<em>Child Node A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_NODE_A_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Child Node A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_NODE_A_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.links.impl.ChildNodeBImpl <em>Child Node B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.links.impl.ChildNodeBImpl
	 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getChildNodeB()
	 * @generated
	 */
	int CHILD_NODE_B = 4;

	/**
	 * The number of structural features of the '<em>Child Node B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_NODE_B_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Child Node B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_NODE_B_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.links.impl.Child_AB_Element_LinkImpl <em>Child AB Element Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.links.impl.Child_AB_Element_LinkImpl
	 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getChild_AB_Element_Link()
	 * @generated
	 */
	int CHILD_AB_ELEMENT_LINK = 5;

	/**
	 * The feature id for the '<em><b>Source A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_AB_ELEMENT_LINK__SOURCE_A = 0;

	/**
	 * The feature id for the '<em><b>Target B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_AB_ELEMENT_LINK__TARGET_B = 1;

	/**
	 * The number of structural features of the '<em>Child AB Element Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_AB_ELEMENT_LINK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Child AB Element Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_AB_ELEMENT_LINK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.links.impl.Root_BA_Element_LinkImpl <em>Root BA Element Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.links.impl.Root_BA_Element_LinkImpl
	 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getRoot_BA_Element_Link()
	 * @generated
	 */
	int ROOT_BA_ELEMENT_LINK = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BA_ELEMENT_LINK__NAME = 0;

	/**
	 * The feature id for the '<em><b>B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BA_ELEMENT_LINK__B = 1;

	/**
	 * The feature id for the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BA_ELEMENT_LINK__A = 2;

	/**
	 * The number of structural features of the '<em>Root BA Element Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BA_ELEMENT_LINK_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Root BA Element Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BA_ELEMENT_LINK_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.links.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.links.Root#getChildABElementLinks <em>Child AB Element Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child AB Element Links</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Root#getChildABElementLinks()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_ChildABElementLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.links.Root#getRootNodeAs <em>Root Node As</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Root Node As</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Root#getRootNodeAs()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_RootNodeAs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.links.Root#getRootNodeBs <em>Root Node Bs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Root Node Bs</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Root#getRootNodeBs()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_RootNodeBs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.links.Root#getRootBALinks <em>Root BA Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Root BA Links</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Root#getRootBALinks()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_RootBALinks();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.links.RootNodeA <em>Root Node A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Node A</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.RootNodeA
	 * @generated
	 */
	EClass getRootNodeA();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.links.RootNodeA#getChildrenNodeA <em>Children Node A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children Node A</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.RootNodeA#getChildrenNodeA()
	 * @see #getRootNodeA()
	 * @generated
	 */
	EReference getRootNodeA_ChildrenNodeA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.links.RootNodeB <em>Root Node B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Node B</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.RootNodeB
	 * @generated
	 */
	EClass getRootNodeB();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.links.RootNodeB#getChildrenB <em>Children B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children B</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.RootNodeB#getChildrenB()
	 * @see #getRootNodeB()
	 * @generated
	 */
	EReference getRootNodeB_ChildrenB();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.tooling.examples.links.RootNodeB#getRoot_BA_Feature_Link <em>Root BA Feature Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root BA Feature Link</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.RootNodeB#getRoot_BA_Feature_Link()
	 * @see #getRootNodeB()
	 * @generated
	 */
	EReference getRootNodeB_Root_BA_Feature_Link();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.links.ChildNodeA <em>Child Node A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Node A</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.ChildNodeA
	 * @generated
	 */
	EClass getChildNodeA();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.tooling.examples.links.ChildNodeA#getChild_AB_Feature_Link <em>Child AB Feature Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Child AB Feature Link</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.ChildNodeA#getChild_AB_Feature_Link()
	 * @see #getChildNodeA()
	 * @generated
	 */
	EReference getChildNodeA_Child_AB_Feature_Link();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.links.ChildNodeB <em>Child Node B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Node B</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.ChildNodeB
	 * @generated
	 */
	EClass getChildNodeB();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link <em>Child AB Element Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child AB Element Link</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link
	 * @generated
	 */
	EClass getChild_AB_Element_Link();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link#getSource_A <em>Source A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source A</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link#getSource_A()
	 * @see #getChild_AB_Element_Link()
	 * @generated
	 */
	EReference getChild_AB_Element_Link_Source_A();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link#getTarget_B <em>Target B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target B</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link#getTarget_B()
	 * @see #getChild_AB_Element_Link()
	 * @generated
	 */
	EReference getChild_AB_Element_Link_Target_B();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link <em>Root BA Element Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root BA Element Link</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link
	 * @generated
	 */
	EClass getRoot_BA_Element_Link();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link#getName()
	 * @see #getRoot_BA_Element_Link()
	 * @generated
	 */
	EAttribute getRoot_BA_Element_Link_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>B</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link#getB()
	 * @see #getRoot_BA_Element_Link()
	 * @generated
	 */
	EReference getRoot_BA_Element_Link_B();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>A</em>'.
	 * @see org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link#getA()
	 * @see #getRoot_BA_Element_Link()
	 * @generated
	 */
	EReference getRoot_BA_Element_Link_A();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LinksFactory getLinksFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.links.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.links.impl.RootImpl
		 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Child AB Element Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__CHILD_AB_ELEMENT_LINKS = eINSTANCE.getRoot_ChildABElementLinks();

		/**
		 * The meta object literal for the '<em><b>Root Node As</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__ROOT_NODE_AS = eINSTANCE.getRoot_RootNodeAs();

		/**
		 * The meta object literal for the '<em><b>Root Node Bs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__ROOT_NODE_BS = eINSTANCE.getRoot_RootNodeBs();

		/**
		 * The meta object literal for the '<em><b>Root BA Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__ROOT_BA_LINKS = eINSTANCE.getRoot_RootBALinks();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.links.impl.RootNodeAImpl <em>Root Node A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.links.impl.RootNodeAImpl
		 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getRootNodeA()
		 * @generated
		 */
		EClass ROOT_NODE_A = eINSTANCE.getRootNodeA();

		/**
		 * The meta object literal for the '<em><b>Children Node A</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_NODE_A__CHILDREN_NODE_A = eINSTANCE.getRootNodeA_ChildrenNodeA();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.links.impl.RootNodeBImpl <em>Root Node B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.links.impl.RootNodeBImpl
		 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getRootNodeB()
		 * @generated
		 */
		EClass ROOT_NODE_B = eINSTANCE.getRootNodeB();

		/**
		 * The meta object literal for the '<em><b>Children B</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_NODE_B__CHILDREN_B = eINSTANCE.getRootNodeB_ChildrenB();

		/**
		 * The meta object literal for the '<em><b>Root BA Feature Link</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_NODE_B__ROOT_BA_FEATURE_LINK = eINSTANCE.getRootNodeB_Root_BA_Feature_Link();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.links.impl.ChildNodeAImpl <em>Child Node A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.links.impl.ChildNodeAImpl
		 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getChildNodeA()
		 * @generated
		 */
		EClass CHILD_NODE_A = eINSTANCE.getChildNodeA();

		/**
		 * The meta object literal for the '<em><b>Child AB Feature Link</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILD_NODE_A__CHILD_AB_FEATURE_LINK = eINSTANCE.getChildNodeA_Child_AB_Feature_Link();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.links.impl.ChildNodeBImpl <em>Child Node B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.links.impl.ChildNodeBImpl
		 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getChildNodeB()
		 * @generated
		 */
		EClass CHILD_NODE_B = eINSTANCE.getChildNodeB();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.links.impl.Child_AB_Element_LinkImpl <em>Child AB Element Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.links.impl.Child_AB_Element_LinkImpl
		 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getChild_AB_Element_Link()
		 * @generated
		 */
		EClass CHILD_AB_ELEMENT_LINK = eINSTANCE.getChild_AB_Element_Link();

		/**
		 * The meta object literal for the '<em><b>Source A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILD_AB_ELEMENT_LINK__SOURCE_A = eINSTANCE.getChild_AB_Element_Link_Source_A();

		/**
		 * The meta object literal for the '<em><b>Target B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILD_AB_ELEMENT_LINK__TARGET_B = eINSTANCE.getChild_AB_Element_Link_Target_B();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.links.impl.Root_BA_Element_LinkImpl <em>Root BA Element Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.links.impl.Root_BA_Element_LinkImpl
		 * @see org.eclipse.gmf.tooling.examples.links.impl.LinksPackageImpl#getRoot_BA_Element_Link()
		 * @generated
		 */
		EClass ROOT_BA_ELEMENT_LINK = eINSTANCE.getRoot_BA_Element_Link();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT_BA_ELEMENT_LINK__NAME = eINSTANCE.getRoot_BA_Element_Link_Name();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_BA_ELEMENT_LINK__B = eINSTANCE.getRoot_BA_Element_Link_B();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_BA_ELEMENT_LINK__A = eINSTANCE.getRoot_BA_Element_Link_A();

	}

} //LinksPackage
