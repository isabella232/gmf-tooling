/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.LinkEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.LinkEntryImpl#getGenLink <em>Gen Link</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.LinkEntryImpl#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkEntryImpl extends ToolEntryImpl implements LinkEntry {
	/**
	 * The cached value of the '{@link #getGenLink() <em>Gen Link</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenLink()
	 * @generated
	 * @ordered
	 */
	protected EList genLink = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getLinkEntry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getGenLink() {
		if (genLink == null) {
			genLink = new EObjectResolvingEList(GenLink.class, this, GMFGenPackage.LINK_ENTRY__GEN_LINK);
		}
		return genLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolGroup getGroup() {
		if (eContainerFeatureID != GMFGenPackage.LINK_ENTRY__GROUP) return null;
		return (ToolGroup)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFGenPackage.LINK_ENTRY__GROUP:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, GMFGenPackage.LINK_ENTRY__GROUP, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFGenPackage.LINK_ENTRY__GROUP:
					return eBasicSetContainer(null, GMFGenPackage.LINK_ENTRY__GROUP, msgs);
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
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case GMFGenPackage.LINK_ENTRY__GROUP:
					return eContainer.eInverseRemove(this, GMFGenPackage.TOOL_GROUP__LINK_TOOLS, ToolGroup.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFGenPackage.LINK_ENTRY__ORDER:
				return new Integer(getOrder());
			case GMFGenPackage.LINK_ENTRY__TITLE_KEY:
				return getTitleKey();
			case GMFGenPackage.LINK_ENTRY__DESCRIPTION_KEY:
				return getDescriptionKey();
			case GMFGenPackage.LINK_ENTRY__LARGE_ICON_PATH:
				return getLargeIconPath();
			case GMFGenPackage.LINK_ENTRY__SMALL_ICON_PATH:
				return getSmallIconPath();
			case GMFGenPackage.LINK_ENTRY__CREATE_METHOD_NAME:
				return getCreateMethodName();
			case GMFGenPackage.LINK_ENTRY__DEFAULT:
				return isDefault() ? Boolean.TRUE : Boolean.FALSE;
			case GMFGenPackage.LINK_ENTRY__GEN_LINK:
				return getGenLink();
			case GMFGenPackage.LINK_ENTRY__GROUP:
				return getGroup();
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
			case GMFGenPackage.LINK_ENTRY__ORDER:
				setOrder(((Integer)newValue).intValue());
				return;
			case GMFGenPackage.LINK_ENTRY__TITLE_KEY:
				setTitleKey((String)newValue);
				return;
			case GMFGenPackage.LINK_ENTRY__DESCRIPTION_KEY:
				setDescriptionKey((String)newValue);
				return;
			case GMFGenPackage.LINK_ENTRY__LARGE_ICON_PATH:
				setLargeIconPath((String)newValue);
				return;
			case GMFGenPackage.LINK_ENTRY__SMALL_ICON_PATH:
				setSmallIconPath((String)newValue);
				return;
			case GMFGenPackage.LINK_ENTRY__CREATE_METHOD_NAME:
				setCreateMethodName((String)newValue);
				return;
			case GMFGenPackage.LINK_ENTRY__DEFAULT:
				setDefault(((Boolean)newValue).booleanValue());
				return;
			case GMFGenPackage.LINK_ENTRY__GEN_LINK:
				getGenLink().clear();
				getGenLink().addAll((Collection)newValue);
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
			case GMFGenPackage.LINK_ENTRY__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case GMFGenPackage.LINK_ENTRY__TITLE_KEY:
				setTitleKey(TITLE_KEY_EDEFAULT);
				return;
			case GMFGenPackage.LINK_ENTRY__DESCRIPTION_KEY:
				setDescriptionKey(DESCRIPTION_KEY_EDEFAULT);
				return;
			case GMFGenPackage.LINK_ENTRY__LARGE_ICON_PATH:
				setLargeIconPath(LARGE_ICON_PATH_EDEFAULT);
				return;
			case GMFGenPackage.LINK_ENTRY__SMALL_ICON_PATH:
				setSmallIconPath(SMALL_ICON_PATH_EDEFAULT);
				return;
			case GMFGenPackage.LINK_ENTRY__CREATE_METHOD_NAME:
				setCreateMethodName(CREATE_METHOD_NAME_EDEFAULT);
				return;
			case GMFGenPackage.LINK_ENTRY__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case GMFGenPackage.LINK_ENTRY__GEN_LINK:
				getGenLink().clear();
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
			case GMFGenPackage.LINK_ENTRY__ORDER:
				return order != ORDER_EDEFAULT;
			case GMFGenPackage.LINK_ENTRY__TITLE_KEY:
				return TITLE_KEY_EDEFAULT == null ? titleKey != null : !TITLE_KEY_EDEFAULT.equals(titleKey);
			case GMFGenPackage.LINK_ENTRY__DESCRIPTION_KEY:
				return DESCRIPTION_KEY_EDEFAULT == null ? descriptionKey != null : !DESCRIPTION_KEY_EDEFAULT.equals(descriptionKey);
			case GMFGenPackage.LINK_ENTRY__LARGE_ICON_PATH:
				return LARGE_ICON_PATH_EDEFAULT == null ? largeIconPath != null : !LARGE_ICON_PATH_EDEFAULT.equals(largeIconPath);
			case GMFGenPackage.LINK_ENTRY__SMALL_ICON_PATH:
				return SMALL_ICON_PATH_EDEFAULT == null ? smallIconPath != null : !SMALL_ICON_PATH_EDEFAULT.equals(smallIconPath);
			case GMFGenPackage.LINK_ENTRY__CREATE_METHOD_NAME:
				return CREATE_METHOD_NAME_EDEFAULT == null ? createMethodName != null : !CREATE_METHOD_NAME_EDEFAULT.equals(createMethodName);
			case GMFGenPackage.LINK_ENTRY__DEFAULT:
				return default_ != DEFAULT_EDEFAULT;
			case GMFGenPackage.LINK_ENTRY__GEN_LINK:
				return genLink != null && !genLink.isEmpty();
			case GMFGenPackage.LINK_ENTRY__GROUP:
				return getGroup() != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //LinkEntryImpl
