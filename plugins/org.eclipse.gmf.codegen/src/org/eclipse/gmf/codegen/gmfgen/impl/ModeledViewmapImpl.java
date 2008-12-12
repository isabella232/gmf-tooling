/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.ModeledViewmap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modeled Viewmap</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.ModeledViewmapImpl#getFigureModel <em>Figure Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModeledViewmapImpl extends ViewmapImpl implements ModeledViewmap {
	/**
	 * The cached value of the '{@link #getFigureModel() <em>Figure Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFigureModel()
	 * @generated
	 * @ordered
	 */
	protected EObject figureModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModeledViewmapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getModeledViewmap();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getFigureModel() {
		if (figureModel != null && figureModel.eIsProxy()) {
			InternalEObject oldFigureModel = (InternalEObject)figureModel;
			figureModel = eResolveProxy(oldFigureModel);
			if (figureModel != oldFigureModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.MODELED_VIEWMAP__FIGURE_MODEL, oldFigureModel, figureModel));
			}
		}
		return figureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetFigureModel() {
		return figureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFigureModel(EObject newFigureModel) {
		EObject oldFigureModel = figureModel;
		figureModel = newFigureModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.MODELED_VIEWMAP__FIGURE_MODEL, oldFigureModel, figureModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGenPackage.MODELED_VIEWMAP__FIGURE_MODEL:
				if (resolve) return getFigureModel();
				return basicGetFigureModel();
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
			case GMFGenPackage.MODELED_VIEWMAP__FIGURE_MODEL:
				setFigureModel((EObject)newValue);
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
			case GMFGenPackage.MODELED_VIEWMAP__FIGURE_MODEL:
				setFigureModel((EObject)null);
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
			case GMFGenPackage.MODELED_VIEWMAP__FIGURE_MODEL:
				return figureModel != null;
		}
		return super.eIsSet(featureID);
	}

} //ModeledViewmapImpl
