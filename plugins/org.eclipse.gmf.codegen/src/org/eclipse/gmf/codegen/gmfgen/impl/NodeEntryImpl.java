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
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.NodeEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.NodeEntryImpl#getGenNode <em>Gen Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.NodeEntryImpl#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeEntryImpl extends ToolEntryImpl implements NodeEntry {
	/**
	 * The cached value of the '{@link #getGenNode() <em>Gen Node</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenNode()
	 * @generated
	 * @ordered
	 */
	protected EList genNode = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getNodeEntry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getGenNode() {
		if (genNode == null) {
			genNode = new EObjectResolvingEList(GenNode.class, this, GMFGenPackage.NODE_ENTRY__GEN_NODE);
		}
		return genNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolGroup getGroup() {
		if (eContainerFeatureID != GMFGenPackage.NODE_ENTRY__GROUP) return null;
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
				case GMFGenPackage.NODE_ENTRY__GROUP:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, GMFGenPackage.NODE_ENTRY__GROUP, msgs);
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
				case GMFGenPackage.NODE_ENTRY__GROUP:
					return eBasicSetContainer(null, GMFGenPackage.NODE_ENTRY__GROUP, msgs);
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
				case GMFGenPackage.NODE_ENTRY__GROUP:
					return eContainer.eInverseRemove(this, GMFGenPackage.TOOL_GROUP__NODE_TOOLS, ToolGroup.class, msgs);
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
			case GMFGenPackage.NODE_ENTRY__ORDER:
				return new Integer(getOrder());
			case GMFGenPackage.NODE_ENTRY__TITLE_KEY:
				return getTitleKey();
			case GMFGenPackage.NODE_ENTRY__DESCRIPTION_KEY:
				return getDescriptionKey();
			case GMFGenPackage.NODE_ENTRY__LARGE_ICON_PATH:
				return getLargeIconPath();
			case GMFGenPackage.NODE_ENTRY__SMALL_ICON_PATH:
				return getSmallIconPath();
			case GMFGenPackage.NODE_ENTRY__CREATE_METHOD_NAME:
				return getCreateMethodName();
			case GMFGenPackage.NODE_ENTRY__DEFAULT:
				return isDefault() ? Boolean.TRUE : Boolean.FALSE;
			case GMFGenPackage.NODE_ENTRY__GEN_NODE:
				return getGenNode();
			case GMFGenPackage.NODE_ENTRY__GROUP:
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
			case GMFGenPackage.NODE_ENTRY__ORDER:
				setOrder(((Integer)newValue).intValue());
				return;
			case GMFGenPackage.NODE_ENTRY__TITLE_KEY:
				setTitleKey((String)newValue);
				return;
			case GMFGenPackage.NODE_ENTRY__DESCRIPTION_KEY:
				setDescriptionKey((String)newValue);
				return;
			case GMFGenPackage.NODE_ENTRY__LARGE_ICON_PATH:
				setLargeIconPath((String)newValue);
				return;
			case GMFGenPackage.NODE_ENTRY__SMALL_ICON_PATH:
				setSmallIconPath((String)newValue);
				return;
			case GMFGenPackage.NODE_ENTRY__CREATE_METHOD_NAME:
				setCreateMethodName((String)newValue);
				return;
			case GMFGenPackage.NODE_ENTRY__DEFAULT:
				setDefault(((Boolean)newValue).booleanValue());
				return;
			case GMFGenPackage.NODE_ENTRY__GEN_NODE:
				getGenNode().clear();
				getGenNode().addAll((Collection)newValue);
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
			case GMFGenPackage.NODE_ENTRY__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case GMFGenPackage.NODE_ENTRY__TITLE_KEY:
				setTitleKey(TITLE_KEY_EDEFAULT);
				return;
			case GMFGenPackage.NODE_ENTRY__DESCRIPTION_KEY:
				setDescriptionKey(DESCRIPTION_KEY_EDEFAULT);
				return;
			case GMFGenPackage.NODE_ENTRY__LARGE_ICON_PATH:
				setLargeIconPath(LARGE_ICON_PATH_EDEFAULT);
				return;
			case GMFGenPackage.NODE_ENTRY__SMALL_ICON_PATH:
				setSmallIconPath(SMALL_ICON_PATH_EDEFAULT);
				return;
			case GMFGenPackage.NODE_ENTRY__CREATE_METHOD_NAME:
				setCreateMethodName(CREATE_METHOD_NAME_EDEFAULT);
				return;
			case GMFGenPackage.NODE_ENTRY__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case GMFGenPackage.NODE_ENTRY__GEN_NODE:
				getGenNode().clear();
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
			case GMFGenPackage.NODE_ENTRY__ORDER:
				return order != ORDER_EDEFAULT;
			case GMFGenPackage.NODE_ENTRY__TITLE_KEY:
				return TITLE_KEY_EDEFAULT == null ? titleKey != null : !TITLE_KEY_EDEFAULT.equals(titleKey);
			case GMFGenPackage.NODE_ENTRY__DESCRIPTION_KEY:
				return DESCRIPTION_KEY_EDEFAULT == null ? descriptionKey != null : !DESCRIPTION_KEY_EDEFAULT.equals(descriptionKey);
			case GMFGenPackage.NODE_ENTRY__LARGE_ICON_PATH:
				return LARGE_ICON_PATH_EDEFAULT == null ? largeIconPath != null : !LARGE_ICON_PATH_EDEFAULT.equals(largeIconPath);
			case GMFGenPackage.NODE_ENTRY__SMALL_ICON_PATH:
				return SMALL_ICON_PATH_EDEFAULT == null ? smallIconPath != null : !SMALL_ICON_PATH_EDEFAULT.equals(smallIconPath);
			case GMFGenPackage.NODE_ENTRY__CREATE_METHOD_NAME:
				return CREATE_METHOD_NAME_EDEFAULT == null ? createMethodName != null : !CREATE_METHOD_NAME_EDEFAULT.equals(createMethodName);
			case GMFGenPackage.NODE_ENTRY__DEFAULT:
				return default_ != DEFAULT_EDEFAULT;
			case GMFGenPackage.NODE_ENTRY__GEN_NODE:
				return genNode != null && !genNode.isEmpty();
			case GMFGenPackage.NODE_ENTRY__GROUP:
				return getGroup() != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //NodeEntryImpl
