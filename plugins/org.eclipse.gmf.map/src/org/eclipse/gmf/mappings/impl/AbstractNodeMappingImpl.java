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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.mappings.AbstractNodeMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.ElementInitializer;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.Tool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getDomainMetaElement <em>Domain Meta Element</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getDomainSpecialization <em>Domain Specialization</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getDomainInitializer <em>Domain Initializer</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getContainmentFeature <em>Containment Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getEditFeature <em>Edit Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getChildMappings <em>Child Mappings</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getCompartmentMappings <em>Compartment Mappings</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getTool <em>Tool</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractNodeMappingImpl extends EObjectImpl implements AbstractNodeMapping {
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
	 * The cached value of the '{@link #getContainmentFeature() <em>Containment Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainmentFeature()
	 * @generated
	 * @ordered
	 */
	protected EReference containmentFeature = null;

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
	 * The cached value of the '{@link #getChildMappings() <em>Child Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildMappings()
	 * @generated
	 * @ordered
	 */
	protected EList childMappings = null;

	/**
	 * The cached value of the '{@link #getCompartmentMappings() <em>Compartment Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartmentMappings()
	 * @generated
	 * @ordered
	 */
	protected EList compartmentMappings = null;

	/**
	 * The cached value of the '{@link #getTool() <em>Tool</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTool()
	 * @generated
	 * @ordered
	 */
	protected Tool tool = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractNodeMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getAbstractNodeMapping();
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_META_ELEMENT, oldDomainMetaElement, domainMetaElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_META_ELEMENT, oldDomainMetaElement, domainMetaElement));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_SPECIALIZATION, oldDomainSpecialization, newDomainSpecialization);
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
				msgs = ((InternalEObject)domainSpecialization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_SPECIALIZATION, null, msgs);
			if (newDomainSpecialization != null)
				msgs = ((InternalEObject)newDomainSpecialization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_SPECIALIZATION, null, msgs);
			msgs = basicSetDomainSpecialization(newDomainSpecialization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_SPECIALIZATION, newDomainSpecialization, newDomainSpecialization));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_INITIALIZER, oldDomainInitializer, newDomainInitializer);
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
				msgs = ((InternalEObject)domainInitializer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_INITIALIZER, null, msgs);
			if (newDomainInitializer != null)
				msgs = ((InternalEObject)newDomainInitializer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_INITIALIZER, null, msgs);
			msgs = basicSetDomainInitializer(newDomainInitializer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_INITIALIZER, newDomainInitializer, newDomainInitializer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainmentFeature() {
		if (containmentFeature != null && containmentFeature.eIsProxy()) {
			EReference oldContainmentFeature = containmentFeature;
			containmentFeature = (EReference)eResolveProxy((InternalEObject)containmentFeature);
			if (containmentFeature != oldContainmentFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTAINMENT_FEATURE, oldContainmentFeature, containmentFeature));
			}
		}
		return containmentFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetContainmentFeature() {
		return containmentFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainmentFeature(EReference newContainmentFeature) {
		EReference oldContainmentFeature = containmentFeature;
		containmentFeature = newContainmentFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTAINMENT_FEATURE, oldContainmentFeature, containmentFeature));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE, oldEditFeature, editFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE, oldEditFeature, editFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getChildMappings() {
		if (childMappings == null) {
			childMappings = new EObjectContainmentWithInverseEList(ChildNodeMapping.class, this, GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS, GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE);
		}
		return childMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCompartmentMappings() {
		if (compartmentMappings == null) {
			compartmentMappings = new EObjectContainmentWithInverseEList(CompartmentMapping.class, this, GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS, GMFMapPackage.COMPARTMENT_MAPPING__PARENT_NODE_MAPPING);
		}
		return compartmentMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tool getTool() {
		return tool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTool(Tool newTool, NotificationChain msgs) {
		Tool oldTool = tool;
		tool = newTool;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL, oldTool, newTool);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTool(Tool newTool) {
		if (newTool != tool) {
			NotificationChain msgs = null;
			if (tool != null)
				msgs = ((InternalEObject)tool).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL, null, msgs);
			if (newTool != null)
				msgs = ((InternalEObject)newTool).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL, null, msgs);
			msgs = basicSetTool(newTool, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL, newTool, newTool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method was created to simplify transtofmation code.
	 * @return getDomainMetaElement() if specified or getContainmentFeature().getEReferenceType()
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClass getDomainMetaClass() {
		if (getDomainMetaElement() == null && getContainmentFeature() != null) {
			return getContainmentFeature().getEReferenceType();
		}
		return getDomainMetaElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
					return ((InternalEList)getChildMappings()).basicAdd(otherEnd, msgs);
				case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
					return ((InternalEList)getCompartmentMappings()).basicAdd(otherEnd, msgs);
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
				case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_SPECIALIZATION:
					return basicSetDomainSpecialization(null, msgs);
				case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_INITIALIZER:
					return basicSetDomainInitializer(null, msgs);
				case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
					return ((InternalEList)getChildMappings()).basicRemove(otherEnd, msgs);
				case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
					return ((InternalEList)getCompartmentMappings()).basicRemove(otherEnd, msgs);
				case GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL:
					return basicSetTool(null, msgs);
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
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_META_ELEMENT:
				if (resolve) return getDomainMetaElement();
				return basicGetDomainMetaElement();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_SPECIALIZATION:
				return getDomainSpecialization();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_INITIALIZER:
				return getDomainInitializer();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTAINMENT_FEATURE:
				if (resolve) return getContainmentFeature();
				return basicGetContainmentFeature();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE:
				if (resolve) return getEditFeature();
				return basicGetEditFeature();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
				return getChildMappings();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
				return getCompartmentMappings();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL:
				return getTool();
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
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_META_ELEMENT:
				setDomainMetaElement((EClass)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_SPECIALIZATION:
				setDomainSpecialization((Constraint)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_INITIALIZER:
				setDomainInitializer((ElementInitializer)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTAINMENT_FEATURE:
				setContainmentFeature((EReference)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE:
				setEditFeature((EAttribute)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
				getChildMappings().clear();
				getChildMappings().addAll((Collection)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
				getCompartmentMappings().clear();
				getCompartmentMappings().addAll((Collection)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL:
				setTool((Tool)newValue);
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
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_META_ELEMENT:
				setDomainMetaElement((EClass)null);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_SPECIALIZATION:
				setDomainSpecialization((Constraint)null);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_INITIALIZER:
				setDomainInitializer((ElementInitializer)null);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTAINMENT_FEATURE:
				setContainmentFeature((EReference)null);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE:
				setEditFeature((EAttribute)null);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
				getChildMappings().clear();
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
				getCompartmentMappings().clear();
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL:
				setTool((Tool)null);
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
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_META_ELEMENT:
				return domainMetaElement != null;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_SPECIALIZATION:
				return domainSpecialization != null;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__DOMAIN_INITIALIZER:
				return domainInitializer != null;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTAINMENT_FEATURE:
				return containmentFeature != null;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE:
				return editFeature != null;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
				return childMappings != null && !childMappings.isEmpty();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
				return compartmentMappings != null && !compartmentMappings.isEmpty();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL:
				return tool != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //AbstractNodeMappingImpl
