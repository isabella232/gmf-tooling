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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.gmf.gmfgraph.Pin;

import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.VisualEffectMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visual Effect Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.impl.VisualEffectMappingImpl#getDiagramPin <em>Diagram Pin</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.VisualEffectMappingImpl#getOclExpression <em>Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.VisualEffectMappingImpl#getParentNode <em>Parent Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VisualEffectMappingImpl extends EObjectImpl implements VisualEffectMapping {
	/**
	 * The cached value of the '{@link #getDiagramPin() <em>Diagram Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramPin()
	 * @generated
	 * @ordered
	 */
	protected Pin diagramPin;

	/**
	 * The default value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String OCL_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpression()
	 * @generated
	 * @ordered
	 */
	protected String oclExpression = OCL_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisualEffectMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getVisualEffectMapping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin getDiagramPin() {
		if (diagramPin != null && diagramPin.eIsProxy()) {
			InternalEObject oldDiagramPin = (InternalEObject)diagramPin;
			diagramPin = (Pin)eResolveProxy(oldDiagramPin);
			if (diagramPin != oldDiagramPin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.VISUAL_EFFECT_MAPPING__DIAGRAM_PIN, oldDiagramPin, diagramPin));
			}
		}
		return diagramPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin basicGetDiagramPin() {
		return diagramPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramPin(Pin newDiagramPin) {
		Pin oldDiagramPin = diagramPin;
		diagramPin = newDiagramPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.VISUAL_EFFECT_MAPPING__DIAGRAM_PIN, oldDiagramPin, diagramPin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOclExpression() {
		return oclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpression(String newOclExpression) {
		String oldOclExpression = oclExpression;
		oclExpression = newOclExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.VISUAL_EFFECT_MAPPING__OCL_EXPRESSION, oldOclExpression, oclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeMapping getParentNode() {
		if (eContainerFeatureID() != GMFMapPackage.VISUAL_EFFECT_MAPPING__PARENT_NODE) return null;
		return (NodeMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__PARENT_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, GMFMapPackage.VISUAL_EFFECT_MAPPING__PARENT_NODE, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__PARENT_NODE:
				return eBasicSetContainer(null, GMFMapPackage.VISUAL_EFFECT_MAPPING__PARENT_NODE, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__PARENT_NODE:
				return eInternalContainer().eInverseRemove(this, GMFMapPackage.NODE_MAPPING__VISUAL_EFFECTS, NodeMapping.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__DIAGRAM_PIN:
				if (resolve) return getDiagramPin();
				return basicGetDiagramPin();
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__OCL_EXPRESSION:
				return getOclExpression();
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__PARENT_NODE:
				return getParentNode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__DIAGRAM_PIN:
				setDiagramPin((Pin)newValue);
				return;
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__OCL_EXPRESSION:
				setOclExpression((String)newValue);
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
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__DIAGRAM_PIN:
				setDiagramPin((Pin)null);
				return;
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__OCL_EXPRESSION:
				setOclExpression(OCL_EXPRESSION_EDEFAULT);
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
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__DIAGRAM_PIN:
				return diagramPin != null;
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__OCL_EXPRESSION:
				return OCL_EXPRESSION_EDEFAULT == null ? oclExpression != null : !OCL_EXPRESSION_EDEFAULT.equals(oclExpression);
			case GMFMapPackage.VISUAL_EFFECT_MAPPING__PARENT_NODE:
				return getParentNode() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (oclExpression: ");
		result.append(oclExpression);
		result.append(')');
		return result.toString();
	}

} //VisualEffectMappingImpl
