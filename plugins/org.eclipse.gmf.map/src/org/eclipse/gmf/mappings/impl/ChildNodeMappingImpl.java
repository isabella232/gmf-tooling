/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.diadef.Node;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.ElementInitializer;
import org.eclipse.gmf.mappings.GMFMapPackage;

import org.eclipse.gmf.mappings.NodeMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getCompartment <em>Compartment</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getDiagramNode <em>Diagram Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getDomainChildrenFeature <em>Domain Children Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getEditFeature <em>Edit Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getDomainMetaElement <em>Domain Meta Element</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getDomainSpecialization <em>Domain Specialization</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getDomainInitializer <em>Domain Initializer</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getParentNode <em>Parent Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildNodeMappingImpl extends EObjectImpl implements ChildNodeMapping {
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
	 * The cached value of the '{@link #getDiagramNode() <em>Diagram Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramNode()
	 * @generated
	 * @ordered
	 */
	protected Node diagramNode = null;

	/**
	 * The cached value of the '{@link #getDomainChildrenFeature() <em>Domain Children Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainChildrenFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature domainChildrenFeature = null;

	/**
	 * The cached value of the '{@link #getEditFeature() <em>Edit Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditFeature()
	 * @generated
	 * @ordered
	 */
	protected EAttribute editFeature = null;

	/**
	 * The cached value of the '{@link #getDomainMetaElement() <em>Domain Meta Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainMetaElement()
	 * @generated
	 * @ordered
	 */
	protected EClass domainMetaElement = null;

	/**
	 * The cached value of the '{@link #getDomainSpecialization() <em>Domain Specialization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainSpecialization()
	 * @generated
	 * @ordered
	 */
	protected Constraint domainSpecialization = null;

	/**
	 * The cached value of the '{@link #getDomainInitializer() <em>Domain Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainInitializer()
	 * @generated
	 * @ordered
	 */
	protected ElementInitializer domainInitializer = null;

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
	public Node getDiagramNode() {
		if (diagramNode != null && diagramNode.eIsProxy()) {
			Node oldDiagramNode = diagramNode;
			diagramNode = (Node)eResolveProxy((InternalEObject)diagramNode);
			if (diagramNode != oldDiagramNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE, oldDiagramNode, diagramNode));
			}
		}
		return diagramNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetDiagramNode() {
		return diagramNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramNode(Node newDiagramNode) {
		Node oldDiagramNode = diagramNode;
		diagramNode = newDiagramNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE, oldDiagramNode, diagramNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getDomainChildrenFeature() {
		if (domainChildrenFeature != null && domainChildrenFeature.eIsProxy()) {
			EStructuralFeature oldDomainChildrenFeature = domainChildrenFeature;
			domainChildrenFeature = (EStructuralFeature)eResolveProxy((InternalEObject)domainChildrenFeature);
			if (domainChildrenFeature != oldDomainChildrenFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_CHILDREN_FEATURE, oldDomainChildrenFeature, domainChildrenFeature));
			}
		}
		return domainChildrenFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetDomainChildrenFeature() {
		return domainChildrenFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainChildrenFeature(EStructuralFeature newDomainChildrenFeature) {
		EStructuralFeature oldDomainChildrenFeature = domainChildrenFeature;
		domainChildrenFeature = newDomainChildrenFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_CHILDREN_FEATURE, oldDomainChildrenFeature, domainChildrenFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEditFeature() {
		if (editFeature != null && editFeature.eIsProxy()) {
			EAttribute oldEditFeature = editFeature;
			editFeature = (EAttribute)eResolveProxy((InternalEObject)editFeature);
			if (editFeature != oldEditFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.CHILD_NODE_MAPPING__EDIT_FEATURE, oldEditFeature, editFeature));
			}
		}
		return editFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetEditFeature() {
		return editFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditFeature(EAttribute newEditFeature) {
		EAttribute oldEditFeature = editFeature;
		editFeature = newEditFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__EDIT_FEATURE, oldEditFeature, editFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainMetaElement() {
		if (domainMetaElement != null && domainMetaElement.eIsProxy()) {
			EClass oldDomainMetaElement = domainMetaElement;
			domainMetaElement = (EClass)eResolveProxy((InternalEObject)domainMetaElement);
			if (domainMetaElement != oldDomainMetaElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_META_ELEMENT, oldDomainMetaElement, domainMetaElement));
			}
		}
		return domainMetaElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetDomainMetaElement() {
		return domainMetaElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainMetaElement(EClass newDomainMetaElement) {
		EClass oldDomainMetaElement = domainMetaElement;
		domainMetaElement = newDomainMetaElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_META_ELEMENT, oldDomainMetaElement, domainMetaElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getDomainSpecialization() {
		return domainSpecialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomainSpecialization(Constraint newDomainSpecialization, NotificationChain msgs) {
		Constraint oldDomainSpecialization = domainSpecialization;
		domainSpecialization = newDomainSpecialization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_SPECIALIZATION, oldDomainSpecialization, newDomainSpecialization);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainSpecialization(Constraint newDomainSpecialization) {
		if (newDomainSpecialization != domainSpecialization) {
			NotificationChain msgs = null;
			if (domainSpecialization != null)
				msgs = ((InternalEObject)domainSpecialization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_SPECIALIZATION, null, msgs);
			if (newDomainSpecialization != null)
				msgs = ((InternalEObject)newDomainSpecialization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_SPECIALIZATION, null, msgs);
			msgs = basicSetDomainSpecialization(newDomainSpecialization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_SPECIALIZATION, newDomainSpecialization, newDomainSpecialization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementInitializer getDomainInitializer() {
		return domainInitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomainInitializer(ElementInitializer newDomainInitializer, NotificationChain msgs) {
		ElementInitializer oldDomainInitializer = domainInitializer;
		domainInitializer = newDomainInitializer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_INITIALIZER, oldDomainInitializer, newDomainInitializer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainInitializer(ElementInitializer newDomainInitializer) {
		if (newDomainInitializer != domainInitializer) {
			NotificationChain msgs = null;
			if (domainInitializer != null)
				msgs = ((InternalEObject)domainInitializer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_INITIALIZER, null, msgs);
			if (newDomainInitializer != null)
				msgs = ((InternalEObject)newDomainInitializer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_INITIALIZER, null, msgs);
			msgs = basicSetDomainInitializer(newDomainInitializer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_INITIALIZER, newDomainInitializer, newDomainInitializer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeMapping getParentNode() {
		if (eContainerFeatureID != GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE) return null;
		return (NodeMapping)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
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
					return eContainer.eInverseRemove(this, GMFMapPackage.NODE_MAPPING__CHILD_MAPPINGS, NodeMapping.class, msgs);
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
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				if (resolve) return getCompartment();
				return basicGetCompartment();
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				if (resolve) return getDiagramNode();
				return basicGetDiagramNode();
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_CHILDREN_FEATURE:
				if (resolve) return getDomainChildrenFeature();
				return basicGetDomainChildrenFeature();
			case GMFMapPackage.CHILD_NODE_MAPPING__EDIT_FEATURE:
				if (resolve) return getEditFeature();
				return basicGetEditFeature();
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_META_ELEMENT:
				if (resolve) return getDomainMetaElement();
				return basicGetDomainMetaElement();
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_SPECIALIZATION:
				return getDomainSpecialization();
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_INITIALIZER:
				return getDomainInitializer();
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
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				setCompartment((Compartment)newValue);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				setDiagramNode((Node)newValue);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_CHILDREN_FEATURE:
				setDomainChildrenFeature((EStructuralFeature)newValue);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__EDIT_FEATURE:
				setEditFeature((EAttribute)newValue);
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
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				setCompartment((Compartment)null);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				setDiagramNode((Node)null);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_CHILDREN_FEATURE:
				setDomainChildrenFeature((EStructuralFeature)null);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__EDIT_FEATURE:
				setEditFeature((EAttribute)null);
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
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				return compartment != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				return diagramNode != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_CHILDREN_FEATURE:
				return domainChildrenFeature != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__EDIT_FEATURE:
				return editFeature != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_META_ELEMENT:
				return domainMetaElement != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_SPECIALIZATION:
				return domainSpecialization != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__DOMAIN_INITIALIZER:
				return domainInitializer != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE:
				return getParentNode() != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //ChildNodeMappingImpl
