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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.LinkEntry;
import org.eclipse.gmf.codegen.gmfgen.NodeEntry;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tool Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.ToolGroupImpl#getNodeTools <em>Node Tools</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.ToolGroupImpl#getLinkTools <em>Link Tools</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.ToolGroupImpl#getPalette <em>Palette</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToolGroupImpl extends EntryBaseImpl implements ToolGroup {
	/**
	 * The cached value of the '{@link #getNodeTools() <em>Node Tools</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeTools()
	 * @generated
	 * @ordered
	 */
	protected EList nodeTools = null;

	/**
	 * The cached value of the '{@link #getLinkTools() <em>Link Tools</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkTools()
	 * @generated
	 * @ordered
	 */
	protected EList linkTools = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getToolGroup();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNodeTools() {
		if (nodeTools == null) {
			nodeTools = new EObjectContainmentWithInverseEList(NodeEntry.class, this, GMFGenPackage.TOOL_GROUP__NODE_TOOLS, GMFGenPackage.NODE_ENTRY__GROUP);
		}
		return nodeTools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLinkTools() {
		if (linkTools == null) {
			linkTools = new EObjectContainmentWithInverseEList(LinkEntry.class, this, GMFGenPackage.TOOL_GROUP__LINK_TOOLS, GMFGenPackage.LINK_ENTRY__GROUP);
		}
		return linkTools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Palette getPalette() {
		if (eContainerFeatureID != GMFGenPackage.TOOL_GROUP__PALETTE) return null;
		return (Palette)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFGenPackage.TOOL_GROUP__NODE_TOOLS:
					return ((InternalEList)getNodeTools()).basicAdd(otherEnd, msgs);
				case GMFGenPackage.TOOL_GROUP__LINK_TOOLS:
					return ((InternalEList)getLinkTools()).basicAdd(otherEnd, msgs);
				case GMFGenPackage.TOOL_GROUP__PALETTE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, GMFGenPackage.TOOL_GROUP__PALETTE, msgs);
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
				case GMFGenPackage.TOOL_GROUP__NODE_TOOLS:
					return ((InternalEList)getNodeTools()).basicRemove(otherEnd, msgs);
				case GMFGenPackage.TOOL_GROUP__LINK_TOOLS:
					return ((InternalEList)getLinkTools()).basicRemove(otherEnd, msgs);
				case GMFGenPackage.TOOL_GROUP__PALETTE:
					return eBasicSetContainer(null, GMFGenPackage.TOOL_GROUP__PALETTE, msgs);
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
				case GMFGenPackage.TOOL_GROUP__PALETTE:
					return eContainer.eInverseRemove(this, GMFGenPackage.PALETTE__GROUPS, Palette.class, msgs);
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
			case GMFGenPackage.TOOL_GROUP__ORDER:
				return new Integer(getOrder());
			case GMFGenPackage.TOOL_GROUP__TITLE_KEY:
				return getTitleKey();
			case GMFGenPackage.TOOL_GROUP__DESCRIPTION_KEY:
				return getDescriptionKey();
			case GMFGenPackage.TOOL_GROUP__LARGE_ICON_PATH:
				return getLargeIconPath();
			case GMFGenPackage.TOOL_GROUP__SMALL_ICON_PATH:
				return getSmallIconPath();
			case GMFGenPackage.TOOL_GROUP__NODE_TOOLS:
				return getNodeTools();
			case GMFGenPackage.TOOL_GROUP__LINK_TOOLS:
				return getLinkTools();
			case GMFGenPackage.TOOL_GROUP__PALETTE:
				return getPalette();
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
			case GMFGenPackage.TOOL_GROUP__ORDER:
				setOrder(((Integer)newValue).intValue());
				return;
			case GMFGenPackage.TOOL_GROUP__TITLE_KEY:
				setTitleKey((String)newValue);
				return;
			case GMFGenPackage.TOOL_GROUP__DESCRIPTION_KEY:
				setDescriptionKey((String)newValue);
				return;
			case GMFGenPackage.TOOL_GROUP__LARGE_ICON_PATH:
				setLargeIconPath((String)newValue);
				return;
			case GMFGenPackage.TOOL_GROUP__SMALL_ICON_PATH:
				setSmallIconPath((String)newValue);
				return;
			case GMFGenPackage.TOOL_GROUP__NODE_TOOLS:
				getNodeTools().clear();
				getNodeTools().addAll((Collection)newValue);
				return;
			case GMFGenPackage.TOOL_GROUP__LINK_TOOLS:
				getLinkTools().clear();
				getLinkTools().addAll((Collection)newValue);
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
			case GMFGenPackage.TOOL_GROUP__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case GMFGenPackage.TOOL_GROUP__TITLE_KEY:
				setTitleKey(TITLE_KEY_EDEFAULT);
				return;
			case GMFGenPackage.TOOL_GROUP__DESCRIPTION_KEY:
				setDescriptionKey(DESCRIPTION_KEY_EDEFAULT);
				return;
			case GMFGenPackage.TOOL_GROUP__LARGE_ICON_PATH:
				setLargeIconPath(LARGE_ICON_PATH_EDEFAULT);
				return;
			case GMFGenPackage.TOOL_GROUP__SMALL_ICON_PATH:
				setSmallIconPath(SMALL_ICON_PATH_EDEFAULT);
				return;
			case GMFGenPackage.TOOL_GROUP__NODE_TOOLS:
				getNodeTools().clear();
				return;
			case GMFGenPackage.TOOL_GROUP__LINK_TOOLS:
				getLinkTools().clear();
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
			case GMFGenPackage.TOOL_GROUP__ORDER:
				return order != ORDER_EDEFAULT;
			case GMFGenPackage.TOOL_GROUP__TITLE_KEY:
				return TITLE_KEY_EDEFAULT == null ? titleKey != null : !TITLE_KEY_EDEFAULT.equals(titleKey);
			case GMFGenPackage.TOOL_GROUP__DESCRIPTION_KEY:
				return DESCRIPTION_KEY_EDEFAULT == null ? descriptionKey != null : !DESCRIPTION_KEY_EDEFAULT.equals(descriptionKey);
			case GMFGenPackage.TOOL_GROUP__LARGE_ICON_PATH:
				return LARGE_ICON_PATH_EDEFAULT == null ? largeIconPath != null : !LARGE_ICON_PATH_EDEFAULT.equals(largeIconPath);
			case GMFGenPackage.TOOL_GROUP__SMALL_ICON_PATH:
				return SMALL_ICON_PATH_EDEFAULT == null ? smallIconPath != null : !SMALL_ICON_PATH_EDEFAULT.equals(smallIconPath);
			case GMFGenPackage.TOOL_GROUP__NODE_TOOLS:
				return nodeTools != null && !nodeTools.isEmpty();
			case GMFGenPackage.TOOL_GROUP__LINK_TOOLS:
				return linkTools != null && !linkTools.isEmpty();
			case GMFGenPackage.TOOL_GROUP__PALETTE:
				return getPalette() != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //ToolGroupImpl
