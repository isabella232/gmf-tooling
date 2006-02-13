/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.mappings.AbstractNodeMapping;
import org.eclipse.gmf.mappings.AppearanceSteward;
import org.eclipse.gmf.mappings.ChildNodeMapping;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.MenuOwner;
import org.eclipse.gmf.mappings.NodeLabelMapping;
import org.eclipse.gmf.mappings.ToolOwner;
import org.eclipse.gmf.tooldef.AbstractTool;
import org.eclipse.gmf.tooldef.ContextMenu;
import org.eclipse.gmf.tooldef.StyleSelector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getContextMenu <em>Context Menu</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getTool <em>Tool</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getAppearanceStyle <em>Appearance Style</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getEditFeature <em>Edit Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getLabelMappings <em>Label Mappings</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getChildMappings <em>Child Mappings</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.AbstractNodeMappingImpl#getCompartmentMappings <em>Compartment Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractNodeMappingImpl extends MappingEntryImpl implements AbstractNodeMapping {
	/**
	 * The cached value of the '{@link #getContextMenu() <em>Context Menu</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextMenu()
	 * @generated
	 * @ordered
	 */
	protected ContextMenu contextMenu = null;

	/**
	 * The cached value of the '{@link #getTool() <em>Tool</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTool()
	 * @generated
	 * @ordered
	 */
	protected AbstractTool tool = null;

	/**
	 * The cached value of the '{@link #getAppearanceStyle() <em>Appearance Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppearanceStyle()
	 * @generated
	 * @ordered
	 */
	protected StyleSelector appearanceStyle = null;

	/**
	 * The cached value of the '{@link #getEditFeature() <em>Edit Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditFeature()
	 * @generated
	 * @ordered
	 */
	protected EAttribute editFeature = null;

	/**
	 * The cached value of the '{@link #getLabelMappings() <em>Label Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelMappings()
	 * @generated
	 * @ordered
	 */
	protected EList labelMappings = null;

	/**
	 * The cached value of the '{@link #getChildMappings() <em>Child Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildMappings()
	 * @generated
	 * @ordered
	 */
	protected EList childMappings = null;

	/**
	 * The cached value of the '{@link #getCompartmentMappings() <em>Compartment Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartmentMappings()
	 * @generated
	 * @ordered
	 */
	protected EList compartmentMappings = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractNodeMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getAbstractNodeMapping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextMenu getContextMenu() {
		if (contextMenu != null && contextMenu.eIsProxy()) {
			InternalEObject oldContextMenu = (InternalEObject)contextMenu;
			contextMenu = (ContextMenu)eResolveProxy(oldContextMenu);
			if (contextMenu != oldContextMenu) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTEXT_MENU, oldContextMenu, contextMenu));
			}
		}
		return contextMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextMenu basicGetContextMenu() {
		return contextMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextMenu(ContextMenu newContextMenu) {
		ContextMenu oldContextMenu = contextMenu;
		contextMenu = newContextMenu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTEXT_MENU, oldContextMenu, contextMenu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTool getTool() {
		if (tool != null && tool.eIsProxy()) {
			InternalEObject oldTool = (InternalEObject)tool;
			tool = (AbstractTool)eResolveProxy(oldTool);
			if (tool != oldTool) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL, oldTool, tool));
			}
		}
		return tool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTool basicGetTool() {
		return tool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTool(AbstractTool newTool) {
		AbstractTool oldTool = tool;
		tool = newTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL, oldTool, tool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StyleSelector getAppearanceStyle() {
		if (appearanceStyle != null && appearanceStyle.eIsProxy()) {
			InternalEObject oldAppearanceStyle = (InternalEObject)appearanceStyle;
			appearanceStyle = (StyleSelector)eResolveProxy(oldAppearanceStyle);
			if (appearanceStyle != oldAppearanceStyle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.ABSTRACT_NODE_MAPPING__APPEARANCE_STYLE, oldAppearanceStyle, appearanceStyle));
			}
		}
		return appearanceStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StyleSelector basicGetAppearanceStyle() {
		return appearanceStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppearanceStyle(StyleSelector newAppearanceStyle) {
		StyleSelector oldAppearanceStyle = appearanceStyle;
		appearanceStyle = newAppearanceStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__APPEARANCE_STYLE, oldAppearanceStyle, appearanceStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEditFeature() {
		if (editFeature != null && editFeature.eIsProxy()) {
			InternalEObject oldEditFeature = (InternalEObject)editFeature;
			editFeature = (EAttribute)eResolveProxy(oldEditFeature);
			if (editFeature != oldEditFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE, oldEditFeature, editFeature));
			}
		}
		return editFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetEditFeature() {
		return editFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditFeature(EAttribute newEditFeature) {
		EAttribute oldEditFeature = editFeature;
		editFeature = newEditFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE, oldEditFeature, editFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLabelMappings() {
		if (labelMappings == null) {
			labelMappings = new EObjectContainmentWithInverseEList(NodeLabelMapping.class, this, GMFMapPackage.ABSTRACT_NODE_MAPPING__LABEL_MAPPINGS, GMFMapPackage.NODE_LABEL_MAPPING__NODE_MAPPING);
		}
		return labelMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getChildMappings() {
		if (childMappings == null) {
			childMappings = new EObjectContainmentWithInverseEList(ChildNodeMapping.class, this, GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS, GMFMapPackage.CHILD_NODE_MAPPING__PARENT_NODE);
		}
		return childMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCompartmentMappings() {
		if (compartmentMappings == null) {
			compartmentMappings = new EObjectContainmentWithInverseEList(CompartmentMapping.class, this, GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS, GMFMapPackage.COMPARTMENT_MAPPING__PARENT_NODE_MAPPING);
		}
		return compartmentMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method was created to simplify transtofmation code.
	 * @return getDomainMetaElement() if specified or getContainmentFeature().getEReferenceType()
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClass getDomainContext() {
		if (getDomainMetaElement() == null && getContainmentFeature() != null) {
			return getContainmentFeature().getEReferenceType();
		}
		return getDomainMetaElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__LABEL_MAPPINGS:
				return ((InternalEList)getLabelMappings()).basicAdd(otherEnd, msgs);
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
				return ((InternalEList)getChildMappings()).basicAdd(otherEnd, msgs);
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
				return ((InternalEList)getCompartmentMappings()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__LABEL_MAPPINGS:
				return ((InternalEList)getLabelMappings()).basicRemove(otherEnd, msgs);
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
				return ((InternalEList)getChildMappings()).basicRemove(otherEnd, msgs);
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
				return ((InternalEList)getCompartmentMappings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTEXT_MENU:
				if (resolve) return getContextMenu();
				return basicGetContextMenu();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL:
				if (resolve) return getTool();
				return basicGetTool();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__APPEARANCE_STYLE:
				if (resolve) return getAppearanceStyle();
				return basicGetAppearanceStyle();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE:
				if (resolve) return getEditFeature();
				return basicGetEditFeature();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__LABEL_MAPPINGS:
				return getLabelMappings();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
				return getChildMappings();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
				return getCompartmentMappings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTEXT_MENU:
				setContextMenu((ContextMenu)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL:
				setTool((AbstractTool)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__APPEARANCE_STYLE:
				setAppearanceStyle((StyleSelector)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE:
				setEditFeature((EAttribute)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__LABEL_MAPPINGS:
				getLabelMappings().clear();
				getLabelMappings().addAll((Collection)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
				getChildMappings().clear();
				getChildMappings().addAll((Collection)newValue);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
				getCompartmentMappings().clear();
				getCompartmentMappings().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTEXT_MENU:
				setContextMenu((ContextMenu)null);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL:
				setTool((AbstractTool)null);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__APPEARANCE_STYLE:
				setAppearanceStyle((StyleSelector)null);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE:
				setEditFeature((EAttribute)null);
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__LABEL_MAPPINGS:
				getLabelMappings().clear();
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
				getChildMappings().clear();
				return;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
				getCompartmentMappings().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTEXT_MENU:
				return contextMenu != null;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL:
				return tool != null;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__APPEARANCE_STYLE:
				return appearanceStyle != null;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__EDIT_FEATURE:
				return editFeature != null;
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__LABEL_MAPPINGS:
				return labelMappings != null && !labelMappings.isEmpty();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__CHILD_MAPPINGS:
				return childMappings != null && !childMappings.isEmpty();
			case GMFMapPackage.ABSTRACT_NODE_MAPPING__COMPARTMENT_MAPPINGS:
				return compartmentMappings != null && !compartmentMappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == MenuOwner.class) {
			switch (derivedFeatureID) {
				case GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTEXT_MENU: return GMFMapPackage.MENU_OWNER__CONTEXT_MENU;
				default: return -1;
			}
		}
		if (baseClass == ToolOwner.class) {
			switch (derivedFeatureID) {
				case GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL: return GMFMapPackage.TOOL_OWNER__TOOL;
				default: return -1;
			}
		}
		if (baseClass == AppearanceSteward.class) {
			switch (derivedFeatureID) {
				case GMFMapPackage.ABSTRACT_NODE_MAPPING__APPEARANCE_STYLE: return GMFMapPackage.APPEARANCE_STEWARD__APPEARANCE_STYLE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == MenuOwner.class) {
			switch (baseFeatureID) {
				case GMFMapPackage.MENU_OWNER__CONTEXT_MENU: return GMFMapPackage.ABSTRACT_NODE_MAPPING__CONTEXT_MENU;
				default: return -1;
			}
		}
		if (baseClass == ToolOwner.class) {
			switch (baseFeatureID) {
				case GMFMapPackage.TOOL_OWNER__TOOL: return GMFMapPackage.ABSTRACT_NODE_MAPPING__TOOL;
				default: return -1;
			}
		}
		if (baseClass == AppearanceSteward.class) {
			switch (baseFeatureID) {
				case GMFMapPackage.APPEARANCE_STEWARD__APPEARANCE_STYLE: return GMFMapPackage.ABSTRACT_NODE_MAPPING__APPEARANCE_STYLE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //AbstractNodeMappingImpl
