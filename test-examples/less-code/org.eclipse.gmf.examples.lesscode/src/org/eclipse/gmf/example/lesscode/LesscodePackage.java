/**
 */
package org.eclipse.gmf.example.lesscode;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.example.lesscode.LesscodeFactory
 * @model kind="package"
 * @generated
 */
public interface LesscodePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "lesscode";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/gmf-tooling/bug403577";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "lesscode";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LesscodePackage eINSTANCE = org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.example.lesscode.impl.RootContainerImpl <em>Root Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.example.lesscode.impl.RootContainerImpl
	 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getRootContainer()
	 * @generated
	 */
	int ROOT_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Root Subjects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONTAINER__ROOT_SUBJECTS = 0;

	/**
	 * The feature id for the '<em><b>One Containment Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONTAINER__ONE_CONTAINMENT_GROUPS = 1;

	/**
	 * The feature id for the '<em><b>Multi Containment Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONTAINER__MULTI_CONTAINMENT_GROUPS = 2;

	/**
	 * The feature id for the '<em><b>Element Based Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONTAINER__ELEMENT_BASED_LINKS = 3;

	/**
	 * The number of structural features of the '<em>Root Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONTAINER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.example.lesscode.impl.WithSomeAttributesImpl <em>With Some Attributes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.example.lesscode.impl.WithSomeAttributesImpl
	 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getWithSomeAttributes()
	 * @generated
	 */
	int WITH_SOME_ATTRIBUTES = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_SOME_ATTRIBUTES__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_SOME_ATTRIBUTES__VALUE = 1;

	/**
	 * The number of structural features of the '<em>With Some Attributes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_SOME_ATTRIBUTES_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.example.lesscode.impl.ElementBasedLinkImpl <em>Element Based Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.example.lesscode.impl.ElementBasedLinkImpl
	 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getElementBasedLink()
	 * @generated
	 */
	int ELEMENT_BASED_LINK = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_BASED_LINK__NAME = WITH_SOME_ATTRIBUTES__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_BASED_LINK__VALUE = WITH_SOME_ATTRIBUTES__VALUE;

	/**
	 * The feature id for the '<em><b>Link Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_BASED_LINK__LINK_SOURCE = WITH_SOME_ATTRIBUTES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Link Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_BASED_LINK__LINK_TARGET = WITH_SOME_ATTRIBUTES_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Element Based Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_BASED_LINK_FEATURE_COUNT = WITH_SOME_ATTRIBUTES_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.example.lesscode.impl.SubjectImpl <em>Subject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.example.lesscode.impl.SubjectImpl
	 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getSubject()
	 * @generated
	 */
	int SUBJECT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__NAME = WITH_SOME_ATTRIBUTES__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__VALUE = WITH_SOME_ATTRIBUTES__VALUE;

	/**
	 * The feature id for the '<em><b>Recursive Containment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__RECURSIVE_CONTAINMENT = WITH_SOME_ATTRIBUTES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reference Based Link Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__REFERENCE_BASED_LINK_TARGET = WITH_SOME_ATTRIBUTES_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Subject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT_FEATURE_COUNT = WITH_SOME_ATTRIBUTES_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.example.lesscode.impl.OneContainmentGroupImpl <em>One Containment Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.example.lesscode.impl.OneContainmentGroupImpl
	 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getOneContainmentGroup()
	 * @generated
	 */
	int ONE_CONTAINMENT_GROUP = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE_CONTAINMENT_GROUP__NAME = WITH_SOME_ATTRIBUTES__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE_CONTAINMENT_GROUP__VALUE = WITH_SOME_ATTRIBUTES__VALUE;

	/**
	 * The feature id for the '<em><b>Subjects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE_CONTAINMENT_GROUP__SUBJECTS = WITH_SOME_ATTRIBUTES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>One Containment Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE_CONTAINMENT_GROUP_FEATURE_COUNT = WITH_SOME_ATTRIBUTES_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.example.lesscode.impl.MultiContainmentGroupImpl <em>Multi Containment Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.example.lesscode.impl.MultiContainmentGroupImpl
	 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getMultiContainmentGroup()
	 * @generated
	 */
	int MULTI_CONTAINMENT_GROUP = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_CONTAINMENT_GROUP__NAME = WITH_SOME_ATTRIBUTES__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_CONTAINMENT_GROUP__VALUE = WITH_SOME_ATTRIBUTES__VALUE;

	/**
	 * The feature id for the '<em><b>Subjects Type A</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_A = WITH_SOME_ATTRIBUTES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subjects Type B</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_B = WITH_SOME_ATTRIBUTES_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multi Containment Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_CONTAINMENT_GROUP_FEATURE_COUNT = WITH_SOME_ATTRIBUTES_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.example.lesscode.RootContainer <em>Root Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Container</em>'.
	 * @see org.eclipse.gmf.example.lesscode.RootContainer
	 * @generated
	 */
	EClass getRootContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.example.lesscode.RootContainer#getRootSubjects <em>Root Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Root Subjects</em>'.
	 * @see org.eclipse.gmf.example.lesscode.RootContainer#getRootSubjects()
	 * @see #getRootContainer()
	 * @generated
	 */
	EReference getRootContainer_RootSubjects();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.example.lesscode.RootContainer#getOneContainmentGroups <em>One Containment Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>One Containment Groups</em>'.
	 * @see org.eclipse.gmf.example.lesscode.RootContainer#getOneContainmentGroups()
	 * @see #getRootContainer()
	 * @generated
	 */
	EReference getRootContainer_OneContainmentGroups();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.example.lesscode.RootContainer#getMultiContainmentGroups <em>Multi Containment Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Multi Containment Groups</em>'.
	 * @see org.eclipse.gmf.example.lesscode.RootContainer#getMultiContainmentGroups()
	 * @see #getRootContainer()
	 * @generated
	 */
	EReference getRootContainer_MultiContainmentGroups();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.example.lesscode.RootContainer#getElementBasedLinks <em>Element Based Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element Based Links</em>'.
	 * @see org.eclipse.gmf.example.lesscode.RootContainer#getElementBasedLinks()
	 * @see #getRootContainer()
	 * @generated
	 */
	EReference getRootContainer_ElementBasedLinks();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.example.lesscode.ElementBasedLink <em>Element Based Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Based Link</em>'.
	 * @see org.eclipse.gmf.example.lesscode.ElementBasedLink
	 * @generated
	 */
	EClass getElementBasedLink();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.example.lesscode.ElementBasedLink#getLinkSource <em>Link Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link Source</em>'.
	 * @see org.eclipse.gmf.example.lesscode.ElementBasedLink#getLinkSource()
	 * @see #getElementBasedLink()
	 * @generated
	 */
	EReference getElementBasedLink_LinkSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.example.lesscode.ElementBasedLink#getLinkTarget <em>Link Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link Target</em>'.
	 * @see org.eclipse.gmf.example.lesscode.ElementBasedLink#getLinkTarget()
	 * @see #getElementBasedLink()
	 * @generated
	 */
	EReference getElementBasedLink_LinkTarget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.example.lesscode.WithSomeAttributes <em>With Some Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With Some Attributes</em>'.
	 * @see org.eclipse.gmf.example.lesscode.WithSomeAttributes
	 * @generated
	 */
	EClass getWithSomeAttributes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.example.lesscode.WithSomeAttributes#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.example.lesscode.WithSomeAttributes#getName()
	 * @see #getWithSomeAttributes()
	 * @generated
	 */
	EAttribute getWithSomeAttributes_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.example.lesscode.WithSomeAttributes#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.gmf.example.lesscode.WithSomeAttributes#getValue()
	 * @see #getWithSomeAttributes()
	 * @generated
	 */
	EAttribute getWithSomeAttributes_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.example.lesscode.Subject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subject</em>'.
	 * @see org.eclipse.gmf.example.lesscode.Subject
	 * @generated
	 */
	EClass getSubject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.example.lesscode.Subject#getRecursiveContainment <em>Recursive Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Recursive Containment</em>'.
	 * @see org.eclipse.gmf.example.lesscode.Subject#getRecursiveContainment()
	 * @see #getSubject()
	 * @generated
	 */
	EReference getSubject_RecursiveContainment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.example.lesscode.Subject#getReferenceBasedLinkTarget <em>Reference Based Link Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reference Based Link Target</em>'.
	 * @see org.eclipse.gmf.example.lesscode.Subject#getReferenceBasedLinkTarget()
	 * @see #getSubject()
	 * @generated
	 */
	EReference getSubject_ReferenceBasedLinkTarget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.example.lesscode.OneContainmentGroup <em>One Containment Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>One Containment Group</em>'.
	 * @see org.eclipse.gmf.example.lesscode.OneContainmentGroup
	 * @generated
	 */
	EClass getOneContainmentGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.example.lesscode.OneContainmentGroup#getSubjects <em>Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subjects</em>'.
	 * @see org.eclipse.gmf.example.lesscode.OneContainmentGroup#getSubjects()
	 * @see #getOneContainmentGroup()
	 * @generated
	 */
	EReference getOneContainmentGroup_Subjects();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.example.lesscode.MultiContainmentGroup <em>Multi Containment Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Containment Group</em>'.
	 * @see org.eclipse.gmf.example.lesscode.MultiContainmentGroup
	 * @generated
	 */
	EClass getMultiContainmentGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.example.lesscode.MultiContainmentGroup#getSubjectsTypeA <em>Subjects Type A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subjects Type A</em>'.
	 * @see org.eclipse.gmf.example.lesscode.MultiContainmentGroup#getSubjectsTypeA()
	 * @see #getMultiContainmentGroup()
	 * @generated
	 */
	EReference getMultiContainmentGroup_SubjectsTypeA();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.example.lesscode.MultiContainmentGroup#getSubjectsTypeB <em>Subjects Type B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subjects Type B</em>'.
	 * @see org.eclipse.gmf.example.lesscode.MultiContainmentGroup#getSubjectsTypeB()
	 * @see #getMultiContainmentGroup()
	 * @generated
	 */
	EReference getMultiContainmentGroup_SubjectsTypeB();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LesscodeFactory getLesscodeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.example.lesscode.impl.RootContainerImpl <em>Root Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.example.lesscode.impl.RootContainerImpl
		 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getRootContainer()
		 * @generated
		 */
		EClass ROOT_CONTAINER = eINSTANCE.getRootContainer();

		/**
		 * The meta object literal for the '<em><b>Root Subjects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CONTAINER__ROOT_SUBJECTS = eINSTANCE.getRootContainer_RootSubjects();

		/**
		 * The meta object literal for the '<em><b>One Containment Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CONTAINER__ONE_CONTAINMENT_GROUPS = eINSTANCE.getRootContainer_OneContainmentGroups();

		/**
		 * The meta object literal for the '<em><b>Multi Containment Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CONTAINER__MULTI_CONTAINMENT_GROUPS = eINSTANCE.getRootContainer_MultiContainmentGroups();

		/**
		 * The meta object literal for the '<em><b>Element Based Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CONTAINER__ELEMENT_BASED_LINKS = eINSTANCE.getRootContainer_ElementBasedLinks();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.example.lesscode.impl.ElementBasedLinkImpl <em>Element Based Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.example.lesscode.impl.ElementBasedLinkImpl
		 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getElementBasedLink()
		 * @generated
		 */
		EClass ELEMENT_BASED_LINK = eINSTANCE.getElementBasedLink();

		/**
		 * The meta object literal for the '<em><b>Link Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_BASED_LINK__LINK_SOURCE = eINSTANCE.getElementBasedLink_LinkSource();

		/**
		 * The meta object literal for the '<em><b>Link Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_BASED_LINK__LINK_TARGET = eINSTANCE.getElementBasedLink_LinkTarget();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.example.lesscode.impl.WithSomeAttributesImpl <em>With Some Attributes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.example.lesscode.impl.WithSomeAttributesImpl
		 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getWithSomeAttributes()
		 * @generated
		 */
		EClass WITH_SOME_ATTRIBUTES = eINSTANCE.getWithSomeAttributes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WITH_SOME_ATTRIBUTES__NAME = eINSTANCE.getWithSomeAttributes_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WITH_SOME_ATTRIBUTES__VALUE = eINSTANCE.getWithSomeAttributes_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.example.lesscode.impl.SubjectImpl <em>Subject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.example.lesscode.impl.SubjectImpl
		 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getSubject()
		 * @generated
		 */
		EClass SUBJECT = eINSTANCE.getSubject();

		/**
		 * The meta object literal for the '<em><b>Recursive Containment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBJECT__RECURSIVE_CONTAINMENT = eINSTANCE.getSubject_RecursiveContainment();

		/**
		 * The meta object literal for the '<em><b>Reference Based Link Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBJECT__REFERENCE_BASED_LINK_TARGET = eINSTANCE.getSubject_ReferenceBasedLinkTarget();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.example.lesscode.impl.OneContainmentGroupImpl <em>One Containment Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.example.lesscode.impl.OneContainmentGroupImpl
		 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getOneContainmentGroup()
		 * @generated
		 */
		EClass ONE_CONTAINMENT_GROUP = eINSTANCE.getOneContainmentGroup();

		/**
		 * The meta object literal for the '<em><b>Subjects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ONE_CONTAINMENT_GROUP__SUBJECTS = eINSTANCE.getOneContainmentGroup_Subjects();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.example.lesscode.impl.MultiContainmentGroupImpl <em>Multi Containment Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.example.lesscode.impl.MultiContainmentGroupImpl
		 * @see org.eclipse.gmf.example.lesscode.impl.LesscodePackageImpl#getMultiContainmentGroup()
		 * @generated
		 */
		EClass MULTI_CONTAINMENT_GROUP = eINSTANCE.getMultiContainmentGroup();

		/**
		 * The meta object literal for the '<em><b>Subjects Type A</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_A = eINSTANCE.getMultiContainmentGroup_SubjectsTypeA();

		/**
		 * The meta object literal for the '<em><b>Subjects Type B</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_B = eINSTANCE.getMultiContainmentGroup_SubjectsTypeB();

	}

} //LesscodePackage
