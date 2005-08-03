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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.diadef.DiagramDefinitionPackage;
import org.eclipse.gmf.diadef.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.diadef.impl.NodeImpl#getMaxWidth <em>Max Width</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.impl.NodeImpl#getMaxHeight <em>Max Height</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.impl.NodeImpl#getDefaultWidth <em>Default Width</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.impl.NodeImpl#getDefaultHeight <em>Default Height</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.impl.NodeImpl#getCompartments <em>Compartments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends DiagramElementImpl implements Node {
	/**
	 * The default value of the '{@link #getMaxWidth() <em>Max Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxWidth() <em>Max Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxWidth()
	 * @generated
	 * @ordered
	 */
	protected int maxWidth = MAX_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxHeight() <em>Max Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxHeight() <em>Max Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxHeight()
	 * @generated
	 * @ordered
	 */
	protected int maxHeight = MAX_HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultWidth() <em>Default Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDefaultWidth() <em>Default Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultWidth()
	 * @generated
	 * @ordered
	 */
	protected int defaultWidth = DEFAULT_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultHeight() <em>Default Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDefaultHeight() <em>Default Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultHeight()
	 * @generated
	 * @ordered
	 */
	protected int defaultHeight = DEFAULT_HEIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCompartments() <em>Compartments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartments()
	 * @generated
	 * @ordered
	 */
	protected EList compartments = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DiagramDefinitionPackage.eINSTANCE.getNode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxWidth() {
		return maxWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxWidth(int newMaxWidth) {
		int oldMaxWidth = maxWidth;
		maxWidth = newMaxWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.NODE__MAX_WIDTH, oldMaxWidth, maxWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxHeight() {
		return maxHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxHeight(int newMaxHeight) {
		int oldMaxHeight = maxHeight;
		maxHeight = newMaxHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.NODE__MAX_HEIGHT, oldMaxHeight, maxHeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefaultWidth() {
		return defaultWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultWidth(int newDefaultWidth) {
		int oldDefaultWidth = defaultWidth;
		defaultWidth = newDefaultWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.NODE__DEFAULT_WIDTH, oldDefaultWidth, defaultWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefaultHeight() {
		return defaultHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultHeight(int newDefaultHeight) {
		int oldDefaultHeight = defaultHeight;
		defaultHeight = newDefaultHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramDefinitionPackage.NODE__DEFAULT_HEIGHT, oldDefaultHeight, defaultHeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCompartments() {
		if (compartments == null) {
			compartments = new EObjectContainmentEList(Compartment.class, this, DiagramDefinitionPackage.NODE__COMPARTMENTS);
		}
		return compartments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DiagramDefinitionPackage.NODE__PROPERTIES:
					return ((InternalEList)getProperties()).basicRemove(otherEnd, msgs);
				case DiagramDefinitionPackage.NODE__COMPARTMENTS:
					return ((InternalEList)getCompartments()).basicRemove(otherEnd, msgs);
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
			case DiagramDefinitionPackage.NODE__NAME:
				return getName();
			case DiagramDefinitionPackage.NODE__PROPERTIES:
				return getProperties();
			case DiagramDefinitionPackage.NODE__NEEDS_TOOL:
				return isNeedsTool() ? Boolean.TRUE : Boolean.FALSE;
			case DiagramDefinitionPackage.NODE__TOOL_GROUP_ID:
				return getToolGroupID();
			case DiagramDefinitionPackage.NODE__SMALL_ICON_PATH:
				return getSmallIconPath();
			case DiagramDefinitionPackage.NODE__LARGE_ICON_PATH:
				return getLargeIconPath();
			case DiagramDefinitionPackage.NODE__MAX_WIDTH:
				return new Integer(getMaxWidth());
			case DiagramDefinitionPackage.NODE__MAX_HEIGHT:
				return new Integer(getMaxHeight());
			case DiagramDefinitionPackage.NODE__DEFAULT_WIDTH:
				return new Integer(getDefaultWidth());
			case DiagramDefinitionPackage.NODE__DEFAULT_HEIGHT:
				return new Integer(getDefaultHeight());
			case DiagramDefinitionPackage.NODE__COMPARTMENTS:
				return getCompartments();
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
			case DiagramDefinitionPackage.NODE__NAME:
				setName((String)newValue);
				return;
			case DiagramDefinitionPackage.NODE__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection)newValue);
				return;
			case DiagramDefinitionPackage.NODE__NEEDS_TOOL:
				setNeedsTool(((Boolean)newValue).booleanValue());
				return;
			case DiagramDefinitionPackage.NODE__TOOL_GROUP_ID:
				setToolGroupID((String)newValue);
				return;
			case DiagramDefinitionPackage.NODE__SMALL_ICON_PATH:
				setSmallIconPath((String)newValue);
				return;
			case DiagramDefinitionPackage.NODE__LARGE_ICON_PATH:
				setLargeIconPath((String)newValue);
				return;
			case DiagramDefinitionPackage.NODE__MAX_WIDTH:
				setMaxWidth(((Integer)newValue).intValue());
				return;
			case DiagramDefinitionPackage.NODE__MAX_HEIGHT:
				setMaxHeight(((Integer)newValue).intValue());
				return;
			case DiagramDefinitionPackage.NODE__DEFAULT_WIDTH:
				setDefaultWidth(((Integer)newValue).intValue());
				return;
			case DiagramDefinitionPackage.NODE__DEFAULT_HEIGHT:
				setDefaultHeight(((Integer)newValue).intValue());
				return;
			case DiagramDefinitionPackage.NODE__COMPARTMENTS:
				getCompartments().clear();
				getCompartments().addAll((Collection)newValue);
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
			case DiagramDefinitionPackage.NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagramDefinitionPackage.NODE__PROPERTIES:
				getProperties().clear();
				return;
			case DiagramDefinitionPackage.NODE__NEEDS_TOOL:
				setNeedsTool(NEEDS_TOOL_EDEFAULT);
				return;
			case DiagramDefinitionPackage.NODE__TOOL_GROUP_ID:
				setToolGroupID(TOOL_GROUP_ID_EDEFAULT);
				return;
			case DiagramDefinitionPackage.NODE__SMALL_ICON_PATH:
				setSmallIconPath(SMALL_ICON_PATH_EDEFAULT);
				return;
			case DiagramDefinitionPackage.NODE__LARGE_ICON_PATH:
				setLargeIconPath(LARGE_ICON_PATH_EDEFAULT);
				return;
			case DiagramDefinitionPackage.NODE__MAX_WIDTH:
				setMaxWidth(MAX_WIDTH_EDEFAULT);
				return;
			case DiagramDefinitionPackage.NODE__MAX_HEIGHT:
				setMaxHeight(MAX_HEIGHT_EDEFAULT);
				return;
			case DiagramDefinitionPackage.NODE__DEFAULT_WIDTH:
				setDefaultWidth(DEFAULT_WIDTH_EDEFAULT);
				return;
			case DiagramDefinitionPackage.NODE__DEFAULT_HEIGHT:
				setDefaultHeight(DEFAULT_HEIGHT_EDEFAULT);
				return;
			case DiagramDefinitionPackage.NODE__COMPARTMENTS:
				getCompartments().clear();
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
			case DiagramDefinitionPackage.NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagramDefinitionPackage.NODE__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case DiagramDefinitionPackage.NODE__NEEDS_TOOL:
				return needsTool != NEEDS_TOOL_EDEFAULT;
			case DiagramDefinitionPackage.NODE__TOOL_GROUP_ID:
				return TOOL_GROUP_ID_EDEFAULT == null ? toolGroupID != null : !TOOL_GROUP_ID_EDEFAULT.equals(toolGroupID);
			case DiagramDefinitionPackage.NODE__SMALL_ICON_PATH:
				return SMALL_ICON_PATH_EDEFAULT == null ? smallIconPath != null : !SMALL_ICON_PATH_EDEFAULT.equals(smallIconPath);
			case DiagramDefinitionPackage.NODE__LARGE_ICON_PATH:
				return LARGE_ICON_PATH_EDEFAULT == null ? largeIconPath != null : !LARGE_ICON_PATH_EDEFAULT.equals(largeIconPath);
			case DiagramDefinitionPackage.NODE__MAX_WIDTH:
				return maxWidth != MAX_WIDTH_EDEFAULT;
			case DiagramDefinitionPackage.NODE__MAX_HEIGHT:
				return maxHeight != MAX_HEIGHT_EDEFAULT;
			case DiagramDefinitionPackage.NODE__DEFAULT_WIDTH:
				return defaultWidth != DEFAULT_WIDTH_EDEFAULT;
			case DiagramDefinitionPackage.NODE__DEFAULT_HEIGHT:
				return defaultHeight != DEFAULT_HEIGHT_EDEFAULT;
			case DiagramDefinitionPackage.NODE__COMPARTMENTS:
				return compartments != null && !compartments.isEmpty();
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
		result.append(" (maxWidth: ");
		result.append(maxWidth);
		result.append(", maxHeight: ");
		result.append(maxHeight);
		result.append(", defaultWidth: ");
		result.append(defaultWidth);
		result.append(", defaultHeight: ");
		result.append(defaultHeight);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
