/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.sketch.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.sketch.SketchCompartment;
import org.eclipse.gmf.sketch.SketchLabel;
import org.eclipse.gmf.sketch.SketchNode;
import org.eclipse.gmf.sketch.SketchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchNodeImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchNodeImpl#getReferencedNodes <em>Referenced Nodes</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchNodeImpl#getCompartments <em>Compartments</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchNodeImpl#getLabels <em>Labels</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchNodeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchNodeImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchNodeImpl#isOnBorder <em>On Border</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SketchNodeImpl extends SketchDiagramElementImpl implements SketchNode {

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<SketchNode> nodes;

	/**
	 * The cached value of the '{@link #getReferencedNodes() <em>Referenced Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<SketchNode> referencedNodes;

	/**
	 * The cached value of the '{@link #getCompartments() <em>Compartments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartments()
	 * @generated
	 * @ordered
	 */
	protected EList<SketchCompartment> compartments;

	/**
	 * The cached value of the '{@link #getLabels() <em>Labels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<SketchLabel> labels;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClass type;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<EAttribute> attributes;

	/**
	 * The default value of the '{@link #isOnBorder() <em>On Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnBorder()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ON_BORDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOnBorder() <em>On Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnBorder()
	 * @generated
	 * @ordered
	 */
	protected boolean onBorder = ON_BORDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SketchNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SketchPackage.Literals.SKETCH_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SketchNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<SketchNode>(SketchNode.class, this, SketchPackage.SKETCH_NODE__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SketchNode> getReferencedNodes() {
		if (referencedNodes == null) {
			referencedNodes = new EObjectResolvingEList<SketchNode>(SketchNode.class, this, SketchPackage.SKETCH_NODE__REFERENCED_NODES);
		}
		return referencedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SketchCompartment> getCompartments() {
		if (compartments == null) {
			compartments = new EObjectContainmentEList<SketchCompartment>(SketchCompartment.class, this, SketchPackage.SKETCH_NODE__COMPARTMENTS);
		}
		return compartments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SketchLabel> getLabels() {
		if (labels == null) {
			labels = new EObjectContainmentEList<SketchLabel>(SketchLabel.class, this, SketchPackage.SKETCH_NODE__LABELS);
		}
		return labels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (EClass) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SketchPackage.SKETCH_NODE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EClass newType) {
		EClass oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SketchPackage.SKETCH_NODE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectResolvingEList<EAttribute>(EAttribute.class, this, SketchPackage.SKETCH_NODE__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOnBorder() {
		return onBorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnBorder(boolean newOnBorder) {
		boolean oldOnBorder = onBorder;
		onBorder = newOnBorder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SketchPackage.SKETCH_NODE__ON_BORDER, oldOnBorder, onBorder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SketchPackage.SKETCH_NODE__NODES:
			return ((InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
		case SketchPackage.SKETCH_NODE__COMPARTMENTS:
			return ((InternalEList<?>) getCompartments()).basicRemove(otherEnd, msgs);
		case SketchPackage.SKETCH_NODE__LABELS:
			return ((InternalEList<?>) getLabels()).basicRemove(otherEnd, msgs);
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
		case SketchPackage.SKETCH_NODE__NODES:
			return getNodes();
		case SketchPackage.SKETCH_NODE__REFERENCED_NODES:
			return getReferencedNodes();
		case SketchPackage.SKETCH_NODE__COMPARTMENTS:
			return getCompartments();
		case SketchPackage.SKETCH_NODE__LABELS:
			return getLabels();
		case SketchPackage.SKETCH_NODE__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
		case SketchPackage.SKETCH_NODE__ATTRIBUTES:
			return getAttributes();
		case SketchPackage.SKETCH_NODE__ON_BORDER:
			return isOnBorder() ? Boolean.TRUE : Boolean.FALSE;
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
		case SketchPackage.SKETCH_NODE__NODES:
			getNodes().clear();
			getNodes().addAll((Collection<? extends SketchNode>) newValue);
			return;
		case SketchPackage.SKETCH_NODE__REFERENCED_NODES:
			getReferencedNodes().clear();
			getReferencedNodes().addAll((Collection<? extends SketchNode>) newValue);
			return;
		case SketchPackage.SKETCH_NODE__COMPARTMENTS:
			getCompartments().clear();
			getCompartments().addAll((Collection<? extends SketchCompartment>) newValue);
			return;
		case SketchPackage.SKETCH_NODE__LABELS:
			getLabels().clear();
			getLabels().addAll((Collection<? extends SketchLabel>) newValue);
			return;
		case SketchPackage.SKETCH_NODE__TYPE:
			setType((EClass) newValue);
			return;
		case SketchPackage.SKETCH_NODE__ATTRIBUTES:
			getAttributes().clear();
			getAttributes().addAll((Collection<? extends EAttribute>) newValue);
			return;
		case SketchPackage.SKETCH_NODE__ON_BORDER:
			setOnBorder(((Boolean) newValue).booleanValue());
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
		case SketchPackage.SKETCH_NODE__NODES:
			getNodes().clear();
			return;
		case SketchPackage.SKETCH_NODE__REFERENCED_NODES:
			getReferencedNodes().clear();
			return;
		case SketchPackage.SKETCH_NODE__COMPARTMENTS:
			getCompartments().clear();
			return;
		case SketchPackage.SKETCH_NODE__LABELS:
			getLabels().clear();
			return;
		case SketchPackage.SKETCH_NODE__TYPE:
			setType((EClass) null);
			return;
		case SketchPackage.SKETCH_NODE__ATTRIBUTES:
			getAttributes().clear();
			return;
		case SketchPackage.SKETCH_NODE__ON_BORDER:
			setOnBorder(ON_BORDER_EDEFAULT);
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
		case SketchPackage.SKETCH_NODE__NODES:
			return nodes != null && !nodes.isEmpty();
		case SketchPackage.SKETCH_NODE__REFERENCED_NODES:
			return referencedNodes != null && !referencedNodes.isEmpty();
		case SketchPackage.SKETCH_NODE__COMPARTMENTS:
			return compartments != null && !compartments.isEmpty();
		case SketchPackage.SKETCH_NODE__LABELS:
			return labels != null && !labels.isEmpty();
		case SketchPackage.SKETCH_NODE__TYPE:
			return type != null;
		case SketchPackage.SKETCH_NODE__ATTRIBUTES:
			return attributes != null && !attributes.isEmpty();
		case SketchPackage.SKETCH_NODE__ON_BORDER:
			return onBorder != ON_BORDER_EDEFAULT;
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (onBorder: "); //$NON-NLS-1$
		result.append(onBorder);
		result.append(')');
		return result.toString();
	}

} //SketchNodeImpl
