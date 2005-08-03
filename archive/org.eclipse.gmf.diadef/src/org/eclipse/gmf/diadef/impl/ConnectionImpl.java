/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.diadef.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.diadef.AdornmentKind;
import org.eclipse.gmf.diadef.Connection;
import org.eclipse.gmf.diadef.DiagramDefinitionPackage;
import org.eclipse.gmf.diadef.LineKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.diadef.impl.ConnectionImpl#getLineKind <em>Line Kind</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.impl.ConnectionImpl#getSourceAdornment <em>Source Adornment</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.impl.ConnectionImpl#getTargetAdornment <em>Target Adornment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionImpl extends DiagramElementImpl implements Connection {
	/**
	 * The default value of the '{@link #getLineKind() <em>Line Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineKind()
	 * @generated
	 * @ordered
	 */
	protected static final LineKind LINE_KIND_EDEFAULT = LineKind.SOLID_LITERAL;

	/**
	 * The cached value of the '{@link #getLineKind() <em>Line Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineKind()
	 * @generated
	 * @ordered
	 */
	protected LineKind lineKind = LINE_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceAdornment() <em>Source Adornment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceAdornment()
	 * @generated
	 * @ordered
	 */
	protected static final AdornmentKind SOURCE_ADORNMENT_EDEFAULT = AdornmentKind.NONE_LITERAL;

	/**
	 * The cached value of the '{@link #getSourceAdornment() <em>Source Adornment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceAdornment()
	 * @generated
	 * @ordered
	 */
	protected AdornmentKind sourceAdornment = SOURCE_ADORNMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetAdornment() <em>Target Adornment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAdornment()
	 * @generated
	 * @ordered
	 */
	protected static final AdornmentKind TARGET_ADORNMENT_EDEFAULT = AdornmentKind.NONE_LITERAL;

	/**
	 * The cached value of the '{@link #getTargetAdornment() <em>Target Adornment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAdornment()
	 * @generated
	 * @ordered
	 */
	protected AdornmentKind targetAdornment = TARGET_ADORNMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DiagramDefinitionPackage.eINSTANCE.getConnection();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineKind getLineKind() {
		return lineKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineKind(LineKind newLineKind) {
		LineKind oldLineKind = lineKind;
		lineKind = newLineKind == null ? LINE_KIND_EDEFAULT : newLineKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.CONNECTION__LINE_KIND, oldLineKind, lineKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdornmentKind getSourceAdornment() {
		return sourceAdornment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceAdornment(AdornmentKind newSourceAdornment) {
		AdornmentKind oldSourceAdornment = sourceAdornment;
		sourceAdornment = newSourceAdornment == null ? SOURCE_ADORNMENT_EDEFAULT : newSourceAdornment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.CONNECTION__SOURCE_ADORNMENT, oldSourceAdornment, sourceAdornment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdornmentKind getTargetAdornment() {
		return targetAdornment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetAdornment(AdornmentKind newTargetAdornment) {
		AdornmentKind oldTargetAdornment = targetAdornment;
		targetAdornment = newTargetAdornment == null ? TARGET_ADORNMENT_EDEFAULT : newTargetAdornment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.CONNECTION__TARGET_ADORNMENT, oldTargetAdornment, targetAdornment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DiagramDefinitionPackage.CONNECTION__PROPERTIES:
					return ((InternalEList)getProperties()).basicRemove(otherEnd, msgs);
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
			case DiagramDefinitionPackage.CONNECTION__NAME:
				return getName();
			case DiagramDefinitionPackage.CONNECTION__PROPERTIES:
				return getProperties();
			case DiagramDefinitionPackage.CONNECTION__NEEDS_TOOL:
				return isNeedsTool() ? Boolean.TRUE : Boolean.FALSE;
			case DiagramDefinitionPackage.CONNECTION__TOOL_GROUP_ID:
				return getToolGroupID();
			case DiagramDefinitionPackage.CONNECTION__SMALL_ICON_PATH:
				return getSmallIconPath();
			case DiagramDefinitionPackage.CONNECTION__LARGE_ICON_PATH:
				return getLargeIconPath();
			case DiagramDefinitionPackage.CONNECTION__LINE_KIND:
				return getLineKind();
			case DiagramDefinitionPackage.CONNECTION__SOURCE_ADORNMENT:
				return getSourceAdornment();
			case DiagramDefinitionPackage.CONNECTION__TARGET_ADORNMENT:
				return getTargetAdornment();
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
			case DiagramDefinitionPackage.CONNECTION__NAME:
				setName((String)newValue);
				return;
			case DiagramDefinitionPackage.CONNECTION__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection)newValue);
				return;
			case DiagramDefinitionPackage.CONNECTION__NEEDS_TOOL:
				setNeedsTool(((Boolean)newValue).booleanValue());
				return;
			case DiagramDefinitionPackage.CONNECTION__TOOL_GROUP_ID:
				setToolGroupID((String)newValue);
				return;
			case DiagramDefinitionPackage.CONNECTION__SMALL_ICON_PATH:
				setSmallIconPath((String)newValue);
				return;
			case DiagramDefinitionPackage.CONNECTION__LARGE_ICON_PATH:
				setLargeIconPath((String)newValue);
				return;
			case DiagramDefinitionPackage.CONNECTION__LINE_KIND:
				setLineKind((LineKind)newValue);
				return;
			case DiagramDefinitionPackage.CONNECTION__SOURCE_ADORNMENT:
				setSourceAdornment((AdornmentKind)newValue);
				return;
			case DiagramDefinitionPackage.CONNECTION__TARGET_ADORNMENT:
				setTargetAdornment((AdornmentKind)newValue);
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
			case DiagramDefinitionPackage.CONNECTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagramDefinitionPackage.CONNECTION__PROPERTIES:
				getProperties().clear();
				return;
			case DiagramDefinitionPackage.CONNECTION__NEEDS_TOOL:
				setNeedsTool(NEEDS_TOOL_EDEFAULT);
				return;
			case DiagramDefinitionPackage.CONNECTION__TOOL_GROUP_ID:
				setToolGroupID(TOOL_GROUP_ID_EDEFAULT);
				return;
			case DiagramDefinitionPackage.CONNECTION__SMALL_ICON_PATH:
				setSmallIconPath(SMALL_ICON_PATH_EDEFAULT);
				return;
			case DiagramDefinitionPackage.CONNECTION__LARGE_ICON_PATH:
				setLargeIconPath(LARGE_ICON_PATH_EDEFAULT);
				return;
			case DiagramDefinitionPackage.CONNECTION__LINE_KIND:
				setLineKind(LINE_KIND_EDEFAULT);
				return;
			case DiagramDefinitionPackage.CONNECTION__SOURCE_ADORNMENT:
				setSourceAdornment(SOURCE_ADORNMENT_EDEFAULT);
				return;
			case DiagramDefinitionPackage.CONNECTION__TARGET_ADORNMENT:
				setTargetAdornment(TARGET_ADORNMENT_EDEFAULT);
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
			case DiagramDefinitionPackage.CONNECTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagramDefinitionPackage.CONNECTION__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case DiagramDefinitionPackage.CONNECTION__NEEDS_TOOL:
				return needsTool != NEEDS_TOOL_EDEFAULT;
			case DiagramDefinitionPackage.CONNECTION__TOOL_GROUP_ID:
				return TOOL_GROUP_ID_EDEFAULT == null ? toolGroupID != null : !TOOL_GROUP_ID_EDEFAULT.equals(toolGroupID);
			case DiagramDefinitionPackage.CONNECTION__SMALL_ICON_PATH:
				return SMALL_ICON_PATH_EDEFAULT == null ? smallIconPath != null : !SMALL_ICON_PATH_EDEFAULT.equals(smallIconPath);
			case DiagramDefinitionPackage.CONNECTION__LARGE_ICON_PATH:
				return LARGE_ICON_PATH_EDEFAULT == null ? largeIconPath != null : !LARGE_ICON_PATH_EDEFAULT.equals(largeIconPath);
			case DiagramDefinitionPackage.CONNECTION__LINE_KIND:
				return lineKind != LINE_KIND_EDEFAULT;
			case DiagramDefinitionPackage.CONNECTION__SOURCE_ADORNMENT:
				return sourceAdornment != SOURCE_ADORNMENT_EDEFAULT;
			case DiagramDefinitionPackage.CONNECTION__TARGET_ADORNMENT:
				return targetAdornment != TARGET_ADORNMENT_EDEFAULT;
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
		result.append(" (lineKind: ");
		result.append(lineKind);
		result.append(", sourceAdornment: ");
		result.append(sourceAdornment);
		result.append(", targetAdornment: ");
		result.append(targetAdornment);
		result.append(')');
		return result.toString();
	}

} //ConnectionImpl
