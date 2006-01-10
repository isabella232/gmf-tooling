/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.gmfgraph.Child;
import org.eclipse.gmf.mappings.AbstractNodeMapping;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.GMFMapPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getDiagramNode <em>Diagram Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getCompartment <em>Compartment</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getParentNode <em>Parent Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildNodeMappingImpl extends AbstractNodeMappingImpl implements ChildNodeMapping {
	/**
	 * The cached value of the '{@link #getDiagramNode() <em>Diagram Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramNode()
	 * @generated
	 * @ordered
	 */
	protected Child diagramNode = null;

	/**
	 * The cached value of the '{@link #getCompartment() <em>Compartment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartment()
	 * @generated
	 * @ordered
	 */
	protected CompartmentMapping compartment = null;

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
	public Child getDiagramNode() {
		if (diagramNode != null && diagramNode.eIsProxy()) {
			InternalEObject oldDiagramNode = (InternalEObject)diagramNode;
			diagramNode = (Child)eResolveProxy(oldDiagramNode);
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
	public Child basicGetDiagramNode() {
		return diagramNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramNode(Child newDiagramNode) {
		Child oldDiagramNode = diagramNode;
		diagramNode = newDiagramNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE, oldDiagramNode, diagramNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentMapping getCompartment() {
		if (compartment != null && compartment.eIsProxy()) {
			InternalEObject oldCompartment = (InternalEObject)compartment;
			compartment = (CompartmentMapping)eResolveProxy(oldCompartment);
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
	public CompartmentMapping basicGetCompartment() {
		return compartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompartment(CompartmentMapping newCompartment, NotificationChain msgs) {
		CompartmentMapping oldCompartment = compartment;
		compartment = newCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT, oldCompartment, newCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompartment(CompartmentMapping newCompartment) {
		if (newCompartment != compartment) {
			NotificationChain msgs = null;
			if (compartment != null)
				msgs = ((InternalEObject)compartment).eInverseRemove(this, GMFMapPackage.COMPARTMENT_MAPPING__CHILD_NODES, CompartmentMapping.class, msgs);
			if (newCompartment != null)
				msgs = ((InternalEObject)newCompartment).eInverseAdd(this, GMFMapPackage.COMPARTMENT_MAPPING__CHILD_NODES, CompartmentMapping.class, msgs);
			msgs = basicSetCompartment(newCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT, newCompartment, newCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNodeMapping getParentNode() {
		if (eContainerFeatureID != GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE) return null;
		return (AbstractNodeMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				if (compartment != null)
					msgs = ((InternalEObject)compartment).eInverseRemove(this, GMFMapPackage.COMPARTMENT_MAPPING__CHILD_NODES, CompartmentMapping.class, msgs);
				return basicSetCompartment((CompartmentMapping)otherEnd, msgs);
			case GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				return basicSetCompartment(null, msgs);
			case GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE:
				return eBasicSetContainer(null, GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE:
				return eInternalContainer().eInverseRemove(this, GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS, AbstractNodeMapping.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				if (resolve) return getDiagramNode();
				return basicGetDiagramNode();
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				if (resolve) return getCompartment();
				return basicGetCompartment();
			case GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE:
				return getParentNode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				setDiagramNode((Child)newValue);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				setCompartment((CompartmentMapping)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				setDiagramNode((Child)null);
				return;
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				setCompartment((CompartmentMapping)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GMFMapPackage.CHILD_NODE_MAPPING__DIAGRAM_NODE:
				return diagramNode != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__COMPARTMENT:
				return compartment != null;
			case GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE:
				return getParentNode() != null;
		}
		return super.eIsSet(featureID);
	}

} //ChildNodeMappingImpl
