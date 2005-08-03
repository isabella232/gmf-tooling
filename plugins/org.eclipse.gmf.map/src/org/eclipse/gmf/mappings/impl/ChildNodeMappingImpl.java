/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.diadef.Node;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.GMFMapPackage;

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
 *   <li>{@link org.eclipse.gmf.mappings.impl.ChildNodeMappingImpl#getConditionalFeature <em>Conditional Feature</em>}</li>
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
	 * The cached value of the '{@link #getConditionalFeature() <em>Conditional Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionalFeature()
	 * @generated
	 * @ordered
	 */
	protected EAttribute conditionalFeature = null;

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
	public EAttribute getConditionalFeature() {
		if (conditionalFeature != null && conditionalFeature.eIsProxy()) {
			EAttribute oldConditionalFeature = conditionalFeature;
			conditionalFeature = (EAttribute)eResolveProxy((InternalEObject)conditionalFeature);
			if (conditionalFeature != oldConditionalFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.CHILD_NODE_MAPPING__CONDITIONAL_FEATURE, oldConditionalFeature, conditionalFeature));
			}
		}
		return conditionalFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetConditionalFeature() {
		return conditionalFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionalFeature(EAttribute newConditionalFeature) {
		EAttribute oldConditionalFeature = conditionalFeature;
		conditionalFeature = newConditionalFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CHILD_NODE_MAPPING__CONDITIONAL_FEATURE, oldConditionalFeature, conditionalFeature));
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
			case GMFMapPackage.CHILD_NODE_MAPPING__CONDITIONAL_FEATURE:
				if (resolve) return getConditionalFeature();
				return basicGetConditionalFeature();
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
			case GMFMapPackage.CHILD_NODE_MAPPING__CONDITIONAL_FEATURE:
				setConditionalFeature((EAttribute)newValue);
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
			case GMFMapPackage.CHILD_NODE_MAPPING__CONDITIONAL_FEATURE:
				setConditionalFeature((EAttribute)null);
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
			case GMFMapPackage.CHILD_NODE_MAPPING__CONDITIONAL_FEATURE:
				return conditionalFeature != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //ChildNodeMappingImpl
