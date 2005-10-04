/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.LinkDecoration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Decoration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.LinkDecorationImpl#getFigureQualifiedClassName <em>Figure Qualified Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkDecorationImpl extends EObjectImpl implements LinkDecoration {
	/**
	 * The default value of the '{@link #getFigureQualifiedClassName() <em>Figure Qualified Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFigureQualifiedClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFigureQualifiedClassName() <em>Figure Qualified Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFigureQualifiedClassName()
	 * @generated
	 * @ordered
	 */
	protected String figureQualifiedClassName = FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkDecorationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getLinkDecoration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFigureQualifiedClassName() {
		return figureQualifiedClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFigureQualifiedClassName(String newFigureQualifiedClassName) {
		String oldFigureQualifiedClassName = figureQualifiedClassName;
		figureQualifiedClassName = newFigureQualifiedClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.LINK_DECORATION__FIGURE_QUALIFIED_CLASS_NAME, oldFigureQualifiedClassName, figureQualifiedClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFGenPackage.LINK_DECORATION__FIGURE_QUALIFIED_CLASS_NAME:
				return getFigureQualifiedClassName();
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
			case GMFGenPackage.LINK_DECORATION__FIGURE_QUALIFIED_CLASS_NAME:
				setFigureQualifiedClassName((String)newValue);
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
			case GMFGenPackage.LINK_DECORATION__FIGURE_QUALIFIED_CLASS_NAME:
				setFigureQualifiedClassName(FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT);
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
			case GMFGenPackage.LINK_DECORATION__FIGURE_QUALIFIED_CLASS_NAME:
				return FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT == null ? figureQualifiedClassName != null : !FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT.equals(figureQualifiedClassName);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (figureQualifiedClassName: ");
		result.append(figureQualifiedClassName);
		result.append(')');
		return result.toString();
	}

} //LinkDecorationImpl
