/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.diadef.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.diadef.Canvas;
import org.eclipse.gmf.diadef.Connection;
import org.eclipse.gmf.diadef.DiagramDefinitionPackage;
import org.eclipse.gmf.diadef.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Canvas</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.diadef.impl.CanvasImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.impl.CanvasImpl#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CanvasImpl extends CommonBaseImpl implements Canvas {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList nodes = null;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList links = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CanvasImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DiagramDefinitionPackage.eINSTANCE.getCanvas();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList(Node.class, this, DiagramDefinitionPackage.CANVAS__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList(Connection.class, this, DiagramDefinitionPackage.CANVAS__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DiagramDefinitionPackage.CANVAS__PROPERTIES:
					return ((InternalEList)getProperties()).basicRemove(otherEnd, msgs);
				case DiagramDefinitionPackage.CANVAS__NODES:
					return ((InternalEList)getNodes()).basicRemove(otherEnd, msgs);
				case DiagramDefinitionPackage.CANVAS__LINKS:
					return ((InternalEList)getLinks()).basicRemove(otherEnd, msgs);
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
			case DiagramDefinitionPackage.CANVAS__NAME:
				return getName();
			case DiagramDefinitionPackage.CANVAS__PROPERTIES:
				return getProperties();
			case DiagramDefinitionPackage.CANVAS__NODES:
				return getNodes();
			case DiagramDefinitionPackage.CANVAS__LINKS:
				return getLinks();
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
			case DiagramDefinitionPackage.CANVAS__NAME:
				setName((String)newValue);
				return;
			case DiagramDefinitionPackage.CANVAS__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection)newValue);
				return;
			case DiagramDefinitionPackage.CANVAS__NODES:
				getNodes().clear();
				getNodes().addAll((Collection)newValue);
				return;
			case DiagramDefinitionPackage.CANVAS__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection)newValue);
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
			case DiagramDefinitionPackage.CANVAS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagramDefinitionPackage.CANVAS__PROPERTIES:
				getProperties().clear();
				return;
			case DiagramDefinitionPackage.CANVAS__NODES:
				getNodes().clear();
				return;
			case DiagramDefinitionPackage.CANVAS__LINKS:
				getLinks().clear();
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
			case DiagramDefinitionPackage.CANVAS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagramDefinitionPackage.CANVAS__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case DiagramDefinitionPackage.CANVAS__NODES:
				return nodes != null && !nodes.isEmpty();
			case DiagramDefinitionPackage.CANVAS__LINKS:
				return links != null && !links.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //CanvasImpl
