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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.sketch.SketchLabel;
import org.eclipse.gmf.sketch.SketchLink;
import org.eclipse.gmf.sketch.SketchLinkEnd;
import org.eclipse.gmf.sketch.SketchNode;
import org.eclipse.gmf.sketch.SketchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchLinkImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchLinkImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchLinkImpl#getLabels <em>Labels</em>}</li>
 *   <li>{@link org.eclipse.gmf.sketch.impl.SketchLinkImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SketchLinkImpl extends SketchDiagramElementImpl implements SketchLink {

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList<SketchLinkEnd> source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<SketchLinkEnd> target;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SketchLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SketchPackage.Literals.SKETCH_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SketchLinkEnd> getSource() {
		if (source == null) {
			source = new EObjectResolvingEList<SketchLinkEnd>(SketchLinkEnd.class, this, SketchPackage.SKETCH_LINK__SOURCE);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SketchLinkEnd> getTarget() {
		if (target == null) {
			target = new EObjectResolvingEList<SketchLinkEnd>(SketchLinkEnd.class, this, SketchPackage.SKETCH_LINK__TARGET);
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SketchLabel> getLabels() {
		if (labels == null) {
			labels = new EObjectContainmentEList<SketchLabel>(SketchLabel.class, this, SketchPackage.SKETCH_LINK__LABELS);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SketchPackage.SKETCH_LINK__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SketchPackage.SKETCH_LINK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SketchPackage.SKETCH_LINK__LABELS:
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
		case SketchPackage.SKETCH_LINK__SOURCE:
			return getSource();
		case SketchPackage.SKETCH_LINK__TARGET:
			return getTarget();
		case SketchPackage.SKETCH_LINK__LABELS:
			return getLabels();
		case SketchPackage.SKETCH_LINK__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
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
		case SketchPackage.SKETCH_LINK__SOURCE:
			getSource().clear();
			getSource().addAll((Collection<? extends SketchLinkEnd>) newValue);
			return;
		case SketchPackage.SKETCH_LINK__TARGET:
			getTarget().clear();
			getTarget().addAll((Collection<? extends SketchLinkEnd>) newValue);
			return;
		case SketchPackage.SKETCH_LINK__LABELS:
			getLabels().clear();
			getLabels().addAll((Collection<? extends SketchLabel>) newValue);
			return;
		case SketchPackage.SKETCH_LINK__TYPE:
			setType((EClass) newValue);
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
		case SketchPackage.SKETCH_LINK__SOURCE:
			getSource().clear();
			return;
		case SketchPackage.SKETCH_LINK__TARGET:
			getTarget().clear();
			return;
		case SketchPackage.SKETCH_LINK__LABELS:
			getLabels().clear();
			return;
		case SketchPackage.SKETCH_LINK__TYPE:
			setType((EClass) null);
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
		case SketchPackage.SKETCH_LINK__SOURCE:
			return source != null && !source.isEmpty();
		case SketchPackage.SKETCH_LINK__TARGET:
			return target != null && !target.isEmpty();
		case SketchPackage.SKETCH_LINK__LABELS:
			return labels != null && !labels.isEmpty();
		case SketchPackage.SKETCH_LINK__TYPE:
			return type != null;
		}
		return super.eIsSet(featureID);
	}

} //SketchLinkImpl
