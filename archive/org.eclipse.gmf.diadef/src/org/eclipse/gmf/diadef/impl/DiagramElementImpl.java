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
import org.eclipse.gmf.diadef.DiagramDefinitionPackage;
import org.eclipse.gmf.diadef.DiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.diadef.impl.DiagramElementImpl#isNeedsTool <em>Needs Tool</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.impl.DiagramElementImpl#getToolGroupID <em>Tool Group ID</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.impl.DiagramElementImpl#getSmallIconPath <em>Small Icon Path</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.impl.DiagramElementImpl#getLargeIconPath <em>Large Icon Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DiagramElementImpl extends CommonBaseImpl implements DiagramElement {
	/**
	 * The default value of the '{@link #isNeedsTool() <em>Needs Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNeedsTool()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEEDS_TOOL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isNeedsTool() <em>Needs Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNeedsTool()
	 * @generated
	 * @ordered
	 */
	protected boolean needsTool = NEEDS_TOOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getToolGroupID() <em>Tool Group ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToolGroupID()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOL_GROUP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToolGroupID() <em>Tool Group ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToolGroupID()
	 * @generated
	 * @ordered
	 */
	protected String toolGroupID = TOOL_GROUP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSmallIconPath() <em>Small Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmallIconPath()
	 * @generated
	 * @ordered
	 */
	protected static final String SMALL_ICON_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSmallIconPath() <em>Small Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmallIconPath()
	 * @generated
	 * @ordered
	 */
	protected String smallIconPath = SMALL_ICON_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLargeIconPath() <em>Large Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLargeIconPath()
	 * @generated
	 * @ordered
	 */
	protected static final String LARGE_ICON_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLargeIconPath() <em>Large Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLargeIconPath()
	 * @generated
	 * @ordered
	 */
	protected String largeIconPath = LARGE_ICON_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DiagramDefinitionPackage.eINSTANCE.getDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNeedsTool() {
		return needsTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeedsTool(boolean newNeedsTool) {
		boolean oldNeedsTool = needsTool;
		needsTool = newNeedsTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.DIAGRAM_ELEMENT__NEEDS_TOOL, oldNeedsTool, needsTool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToolGroupID() {
		return toolGroupID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToolGroupID(String newToolGroupID) {
		String oldToolGroupID = toolGroupID;
		toolGroupID = newToolGroupID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.DIAGRAM_ELEMENT__TOOL_GROUP_ID, oldToolGroupID, toolGroupID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSmallIconPathGen() {
		return smallIconPath;
	}

	/**
	 * Intentionally done for {@link #smallIconPath} only - to evaluate the approach of
	 * default value, whether it's reasonable or not. {@link #largeIconPath} is null by default
	 */
	public String getSmallIconPath() {
		String value = getSmallIconPathGen();
		if (value == null) {
			return "icons/small/" + getName() + ".gif";
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSmallIconPath(String newSmallIconPath) {
		String oldSmallIconPath = smallIconPath;
		smallIconPath = newSmallIconPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.DIAGRAM_ELEMENT__SMALL_ICON_PATH, oldSmallIconPath, smallIconPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLargeIconPath() {
		return largeIconPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLargeIconPath(String newLargeIconPath) {
		String oldLargeIconPath = largeIconPath;
		largeIconPath = newLargeIconPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.DIAGRAM_ELEMENT__LARGE_ICON_PATH, oldLargeIconPath, largeIconPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DiagramDefinitionPackage.DIAGRAM_ELEMENT__PROPERTIES:
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
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__NAME:
				return getName();
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__PROPERTIES:
				return getProperties();
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__NEEDS_TOOL:
				return isNeedsTool() ? Boolean.TRUE : Boolean.FALSE;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__TOOL_GROUP_ID:
				return getToolGroupID();
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__SMALL_ICON_PATH:
				return getSmallIconPath();
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__LARGE_ICON_PATH:
				return getLargeIconPath();
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
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection)newValue);
				return;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__NEEDS_TOOL:
				setNeedsTool(((Boolean)newValue).booleanValue());
				return;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__TOOL_GROUP_ID:
				setToolGroupID((String)newValue);
				return;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__SMALL_ICON_PATH:
				setSmallIconPath((String)newValue);
				return;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__LARGE_ICON_PATH:
				setLargeIconPath((String)newValue);
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
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__PROPERTIES:
				getProperties().clear();
				return;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__NEEDS_TOOL:
				setNeedsTool(NEEDS_TOOL_EDEFAULT);
				return;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__TOOL_GROUP_ID:
				setToolGroupID(TOOL_GROUP_ID_EDEFAULT);
				return;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__SMALL_ICON_PATH:
				setSmallIconPath(SMALL_ICON_PATH_EDEFAULT);
				return;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__LARGE_ICON_PATH:
				setLargeIconPath(LARGE_ICON_PATH_EDEFAULT);
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
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__NEEDS_TOOL:
				return needsTool != NEEDS_TOOL_EDEFAULT;
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__TOOL_GROUP_ID:
				return TOOL_GROUP_ID_EDEFAULT == null ? toolGroupID != null : !TOOL_GROUP_ID_EDEFAULT.equals(toolGroupID);
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__SMALL_ICON_PATH:
				return SMALL_ICON_PATH_EDEFAULT == null ? smallIconPath != null : !SMALL_ICON_PATH_EDEFAULT.equals(smallIconPath);
			case DiagramDefinitionPackage.DIAGRAM_ELEMENT__LARGE_ICON_PATH:
				return LARGE_ICON_PATH_EDEFAULT == null ? largeIconPath != null : !LARGE_ICON_PATH_EDEFAULT.equals(largeIconPath);
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
		result.append(" (needsTool: ");
		result.append(needsTool);
		result.append(", toolGroupID: ");
		result.append(toolGroupID);
		result.append(", smallIconPath: ");
		result.append(smallIconPath);
		result.append(", largeIconPath: ");
		result.append(largeIconPath);
		result.append(')');
		return result.toString();
	}

} //DiagramElementImpl
