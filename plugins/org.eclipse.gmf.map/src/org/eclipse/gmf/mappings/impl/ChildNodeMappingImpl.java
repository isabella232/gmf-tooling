/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.diadef.Node;
import org.eclipse.gmf.mappings.AbstractNodeMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.ElementInitializer;
import org.eclipse.gmf.mappings.GMFMapPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getCompartment <em>Compartment</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getParentNode <em>Parent Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildNodeMappingImpl extends AbstractNodeMappingImpl implements ChildNodeMapping {
	/**
	 * The cached value of the '{@link #getCompartment() <em>Compartment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartment()
	 * @generated
	 * @ordered
	 */
	protected Compartment compartment = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildNodeMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getChildNodeMapping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compartment getCompartment() {
		if (compartment != null && compartment.eIsProxy()) {
			Compartment oldCompartment = compartment;
			compartment = (Compartment)eResolveProxy((InternalEObject)compartment);
			if (compartment != oldCompartment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT, oldCompartment, compartment));
			}
		}
		return compartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compartment basicGetCompartment() {
		return compartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompartment(Compartment newCompartment) {
		Compartment oldCompartment = compartment;
		compartment = newCompartment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT, oldCompartment, compartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNodeMapping getParentNode() {
		if (eContainerFeatureID != GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE) return null;
		return (AbstractNodeMapping)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFMapPackage.CHILD_NODE_MAPPING__CHILD_MAPPINGS:
					return ((InternalEList)getChildMappings()).basicAdd(otherEnd, msgs);
				case GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_SPECIALIZATION:
					return basicSetDomainSpecialization(null, msgs);
				case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_INITIALIZER:
					return basicSetDomainInitializer(null, msgs);
				case GMFMapPackage.CHILD_NODE_MAPPING__CHILD_MAPPINGS:
					return ((InternalEList)getChildMappings()).basicRemove(otherEnd, msgs);
				case GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE:
					return eBasicSetContainer(null, GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE:
					return eContainer.eInverseRemove(this, GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS, AbstractNodeMapping.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				if (resolve) return getDiagramNode();
				return basicGetDiagramNode();
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_META_ELEMENT:
				if (resolve) return getDomainMetaElement();
				return basicGetDomainMetaElement();
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_SPECIALIZATION:
				return getDomainSpecialization();
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_INITIALIZER:
				return getDomainInitializer();
			case GMFMapPackage.CHILD_NODE_MAPPING__CONTAINMENT_FEATURE:
				if (resolve) return getContainmentFeature();
				return basicGetContainmentFeature();
			case GMFMapPackage.CHILD_NODE_MAPPING__EDIT_FEATURE:
				if (resolve) return getEditFeature();
				return basicGetEditFeature();
			case GMFMapPackage.CHILD_NODE_MAPPING__CHILD_MAPPINGS:
				return getChildMappings();
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				if (resolve) return getCompartment();
				return basicGetCompartment();
			case GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE:
				return getParentNode();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				setDiagramNode((Node)newValue);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_META_ELEMENT:
				setDomainMetaElement((EClass)newValue);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_SPECIALIZATION:
				setDomainSpecialization((Constraint)newValue);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_INITIALIZER:
				setDomainInitializer((ElementInitializer)newValue);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__CONTAINMENT_FEATURE:
				setContainmentFeature((EReference)newValue);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__EDIT_FEATURE:
				setEditFeature((EAttribute)newValue);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__CHILD_MAPPINGS:
				getChildMappings().clear();
				getChildMappings().addAll((Collection)newValue);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				setCompartment((Compartment)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				setDiagramNode((Node)null);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_META_ELEMENT:
				setDomainMetaElement((EClass)null);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_SPECIALIZATION:
				setDomainSpecialization((Constraint)null);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_INITIALIZER:
				setDomainInitializer((ElementInitializer)null);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__CONTAINMENT_FEATURE:
				setContainmentFeature((EReference)null);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__EDIT_FEATURE:
				setEditFeature((EAttribute)null);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__CHILD_MAPPINGS:
				getChildMappings().clear();
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				setCompartment((Compartment)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				return diagramNode != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_META_ELEMENT:
				return domainMetaElement != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_SPECIALIZATION:
				return domainSpecialization != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_INITIALIZER:
				return domainInitializer != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__CONTAINMENT_FEATURE:
				return containmentFeature != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__EDIT_FEATURE:
				return editFeature != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__CHILD_MAPPINGS:
				return childMappings != null && !childMappings.isEmpty();
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				return compartment != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE:
				return getParentNode() != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //ChildNodeMappingImpl
