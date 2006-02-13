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

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.gmf.mappings.AbstractNodeMapping;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.NodeLabelMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Label Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.impl.NodeLabelMappingImpl#isExternal <em>External</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.NodeLabelMappingImpl#getNodeMapping <em>Node Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeLabelMappingImpl extends LabelMappingImpl implements NodeLabelMapping {
	/**
	 * The default value of the '{@link #isExternal() <em>External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExternal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTERNAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExternal() <em>External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExternal()
	 * @generated
	 * @ordered
	 */
	protected boolean external = EXTERNAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeLabelMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getNodeLabelMapping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExternal() {
		return external;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternal(boolean newExternal) {
		boolean oldExternal = external;
		external = newExternal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.NODE_LABEL_MAPPING__EXTERNAL, oldExternal, external));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNodeMapping getNodeMapping() {
		if (eContainerFeatureID != GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING) return null;
		return (AbstractNodeMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeMapping(AbstractNodeMapping newNodeMapping) {
		if (newNodeMapping != eInternalContainer() || (eContainerFeatureID != GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING && newNodeMapping != null)) {
			if (EcoreUtil.isAncestor(this, newNodeMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNodeMapping != null)
				msgs = ((InternalEObject)newNodeMapping).eInverseAdd(this, GMFMapPackage.ABSTRACT_NODE_MAPPING__LABEL_MAPPINGS, AbstractNodeMapping.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newNodeMapping, GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING, newNodeMapping, newNodeMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING, msgs);
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
			case GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING:
				return eBasicSetContainer(null, GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING, msgs);
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
			case GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING:
				return eInternalContainer().eInverseRemove(this, GMFMapPackage.ABSTRACT_NODE_MAPPING__LABEL_MAPPINGS, AbstractNodeMapping.class, msgs);
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
			case GMFMapPackage.NODE_LABEL_MAPPING__EXTERNAL:
				return isExternal() ? Boolean.TRUE : Boolean.FALSE;
			case GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING:
				return getNodeMapping();
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
			case GMFMapPackage.NODE_LABEL_MAPPING__EXTERNAL:
				setExternal(((Boolean)newValue).booleanValue());
				return;
			case GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING:
				setNodeMapping((AbstractNodeMapping)newValue);
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
			case GMFMapPackage.NODE_LABEL_MAPPING__EXTERNAL:
				setExternal(EXTERNAL_EDEFAULT);
				return;
			case GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING:
				setNodeMapping((AbstractNodeMapping)null);
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
			case GMFMapPackage.NODE_LABEL_MAPPING__EXTERNAL:
				return external != EXTERNAL_EDEFAULT;
			case GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING:
				return getNodeMapping() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (external: ");
		result.append(external);
		result.append(')');
		return result.toString();
	}

} //NodeLabelMappingImpl
