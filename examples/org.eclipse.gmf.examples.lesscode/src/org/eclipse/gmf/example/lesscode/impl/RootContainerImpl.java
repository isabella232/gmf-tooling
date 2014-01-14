/**
 */
package org.eclipse.gmf.example.lesscode.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.example.lesscode.ElementBasedLink;
import org.eclipse.gmf.example.lesscode.LesscodePackage;
import org.eclipse.gmf.example.lesscode.MultiContainmentGroup;
import org.eclipse.gmf.example.lesscode.OneContainmentGroup;
import org.eclipse.gmf.example.lesscode.RootContainer;
import org.eclipse.gmf.example.lesscode.Subject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.example.lesscode.impl.RootContainerImpl#getRootSubjects <em>Root Subjects</em>}</li>
 *   <li>{@link org.eclipse.gmf.example.lesscode.impl.RootContainerImpl#getOneContainmentGroups <em>One Containment Groups</em>}</li>
 *   <li>{@link org.eclipse.gmf.example.lesscode.impl.RootContainerImpl#getMultiContainmentGroups <em>Multi Containment Groups</em>}</li>
 *   <li>{@link org.eclipse.gmf.example.lesscode.impl.RootContainerImpl#getElementBasedLinks <em>Element Based Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootContainerImpl extends EObjectImpl implements RootContainer {
	/**
	 * The cached value of the '{@link #getRootSubjects() <em>Root Subjects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootSubjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Subject> rootSubjects;

	/**
	 * The cached value of the '{@link #getOneContainmentGroups() <em>One Containment Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneContainmentGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<OneContainmentGroup> oneContainmentGroups;

	/**
	 * The cached value of the '{@link #getMultiContainmentGroups() <em>Multi Containment Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiContainmentGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<MultiContainmentGroup> multiContainmentGroups;

	/**
	 * The cached value of the '{@link #getElementBasedLinks() <em>Element Based Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementBasedLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementBasedLink> elementBasedLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LesscodePackage.Literals.ROOT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subject> getRootSubjects() {
		if (rootSubjects == null) {
			rootSubjects = new EObjectContainmentEList<Subject>(Subject.class, this, LesscodePackage.ROOT_CONTAINER__ROOT_SUBJECTS);
		}
		return rootSubjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OneContainmentGroup> getOneContainmentGroups() {
		if (oneContainmentGroups == null) {
			oneContainmentGroups = new EObjectContainmentEList<OneContainmentGroup>(OneContainmentGroup.class, this, LesscodePackage.ROOT_CONTAINER__ONE_CONTAINMENT_GROUPS);
		}
		return oneContainmentGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MultiContainmentGroup> getMultiContainmentGroups() {
		if (multiContainmentGroups == null) {
			multiContainmentGroups = new EObjectContainmentEList<MultiContainmentGroup>(MultiContainmentGroup.class, this, LesscodePackage.ROOT_CONTAINER__MULTI_CONTAINMENT_GROUPS);
		}
		return multiContainmentGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementBasedLink> getElementBasedLinks() {
		if (elementBasedLinks == null) {
			elementBasedLinks = new EObjectContainmentEList<ElementBasedLink>(ElementBasedLink.class, this, LesscodePackage.ROOT_CONTAINER__ELEMENT_BASED_LINKS);
		}
		return elementBasedLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LesscodePackage.ROOT_CONTAINER__ROOT_SUBJECTS:
				return ((InternalEList<?>)getRootSubjects()).basicRemove(otherEnd, msgs);
			case LesscodePackage.ROOT_CONTAINER__ONE_CONTAINMENT_GROUPS:
				return ((InternalEList<?>)getOneContainmentGroups()).basicRemove(otherEnd, msgs);
			case LesscodePackage.ROOT_CONTAINER__MULTI_CONTAINMENT_GROUPS:
				return ((InternalEList<?>)getMultiContainmentGroups()).basicRemove(otherEnd, msgs);
			case LesscodePackage.ROOT_CONTAINER__ELEMENT_BASED_LINKS:
				return ((InternalEList<?>)getElementBasedLinks()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LesscodePackage.ROOT_CONTAINER__ROOT_SUBJECTS:
				return getRootSubjects();
			case LesscodePackage.ROOT_CONTAINER__ONE_CONTAINMENT_GROUPS:
				return getOneContainmentGroups();
			case LesscodePackage.ROOT_CONTAINER__MULTI_CONTAINMENT_GROUPS:
				return getMultiContainmentGroups();
			case LesscodePackage.ROOT_CONTAINER__ELEMENT_BASED_LINKS:
				return getElementBasedLinks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LesscodePackage.ROOT_CONTAINER__ROOT_SUBJECTS:
				getRootSubjects().clear();
				getRootSubjects().addAll((Collection<? extends Subject>)newValue);
				return;
			case LesscodePackage.ROOT_CONTAINER__ONE_CONTAINMENT_GROUPS:
				getOneContainmentGroups().clear();
				getOneContainmentGroups().addAll((Collection<? extends OneContainmentGroup>)newValue);
				return;
			case LesscodePackage.ROOT_CONTAINER__MULTI_CONTAINMENT_GROUPS:
				getMultiContainmentGroups().clear();
				getMultiContainmentGroups().addAll((Collection<? extends MultiContainmentGroup>)newValue);
				return;
			case LesscodePackage.ROOT_CONTAINER__ELEMENT_BASED_LINKS:
				getElementBasedLinks().clear();
				getElementBasedLinks().addAll((Collection<? extends ElementBasedLink>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LesscodePackage.ROOT_CONTAINER__ROOT_SUBJECTS:
				getRootSubjects().clear();
				return;
			case LesscodePackage.ROOT_CONTAINER__ONE_CONTAINMENT_GROUPS:
				getOneContainmentGroups().clear();
				return;
			case LesscodePackage.ROOT_CONTAINER__MULTI_CONTAINMENT_GROUPS:
				getMultiContainmentGroups().clear();
				return;
			case LesscodePackage.ROOT_CONTAINER__ELEMENT_BASED_LINKS:
				getElementBasedLinks().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LesscodePackage.ROOT_CONTAINER__ROOT_SUBJECTS:
				return rootSubjects != null && !rootSubjects.isEmpty();
			case LesscodePackage.ROOT_CONTAINER__ONE_CONTAINMENT_GROUPS:
				return oneContainmentGroups != null && !oneContainmentGroups.isEmpty();
			case LesscodePackage.ROOT_CONTAINER__MULTI_CONTAINMENT_GROUPS:
				return multiContainmentGroups != null && !multiContainmentGroups.isEmpty();
			case LesscodePackage.ROOT_CONTAINER__ELEMENT_BASED_LINKS:
				return elementBasedLinks != null && !elementBasedLinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootContainerImpl
