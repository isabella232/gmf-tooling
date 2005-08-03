/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.diadef.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.diadef.DiagramDefinitionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.diadef.impl.CompartmentImpl#isCollapsible <em>Collapsible</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.impl.CompartmentImpl#isNeedsTitle <em>Needs Title</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompartmentImpl extends IdentityImpl implements Compartment {
	/**
	 * The default value of the '{@link #isCollapsible() <em>Collapsible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCollapsible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COLLAPSIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCollapsible() <em>Collapsible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCollapsible()
	 * @generated
	 * @ordered
	 */
	protected boolean collapsible = COLLAPSIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isNeedsTitle() <em>Needs Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNeedsTitle()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEEDS_TITLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNeedsTitle() <em>Needs Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNeedsTitle()
	 * @generated
	 * @ordered
	 */
	protected boolean needsTitle = NEEDS_TITLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DiagramDefinitionPackage.eINSTANCE.getCompartment();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCollapsible() {
		return collapsible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollapsible(boolean newCollapsible) {
		boolean oldCollapsible = collapsible;
		collapsible = newCollapsible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.COMPARTMENT__COLLAPSIBLE, oldCollapsible, collapsible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNeedsTitle() {
		return needsTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeedsTitle(boolean newNeedsTitle) {
		boolean oldNeedsTitle = needsTitle;
		needsTitle = newNeedsTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.COMPARTMENT__NEEDS_TITLE, oldNeedsTitle, needsTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DiagramDefinitionPackage.COMPARTMENT__NAME:
				return getName();
			case DiagramDefinitionPackage.COMPARTMENT__COLLAPSIBLE:
				return isCollapsible() ? Boolean.TRUE : Boolean.FALSE;
			case DiagramDefinitionPackage.COMPARTMENT__NEEDS_TITLE:
				return isNeedsTitle() ? Boolean.TRUE : Boolean.FALSE;
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
			case DiagramDefinitionPackage.COMPARTMENT__NAME:
				setName((String)newValue);
				return;
			case DiagramDefinitionPackage.COMPARTMENT__COLLAPSIBLE:
				setCollapsible(((Boolean)newValue).booleanValue());
				return;
			case DiagramDefinitionPackage.COMPARTMENT__NEEDS_TITLE:
				setNeedsTitle(((Boolean)newValue).booleanValue());
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
			case DiagramDefinitionPackage.COMPARTMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagramDefinitionPackage.COMPARTMENT__COLLAPSIBLE:
				setCollapsible(COLLAPSIBLE_EDEFAULT);
				return;
			case DiagramDefinitionPackage.COMPARTMENT__NEEDS_TITLE:
				setNeedsTitle(NEEDS_TITLE_EDEFAULT);
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
			case DiagramDefinitionPackage.COMPARTMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagramDefinitionPackage.COMPARTMENT__COLLAPSIBLE:
				return collapsible != COLLAPSIBLE_EDEFAULT;
			case DiagramDefinitionPackage.COMPARTMENT__NEEDS_TITLE:
				return needsTitle != NEEDS_TITLE_EDEFAULT;
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
		result.append(" (collapsible: ");
		result.append(collapsible);
		result.append(", needsTitle: ");
		result.append(needsTitle);
		result.append(')');
		return result.toString();
	}

} //CompartmentImpl
