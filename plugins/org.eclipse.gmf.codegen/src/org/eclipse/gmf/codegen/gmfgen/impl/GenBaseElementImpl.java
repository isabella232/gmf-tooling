/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenBaseElement;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Base Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenBaseElementImpl#getDomainNameFeature <em>Domain Name Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenBaseElementImpl#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenBaseElementImpl#getContainmentMetaFeature <em>Containment Meta Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenBaseElementImpl#getNotationViewFactoryClassName <em>Notation View Factory Class Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenBaseElementImpl#getViewmap <em>Viewmap</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GenBaseElementImpl extends GenCommonBaseImpl implements GenBaseElement {
	/**
	 * The cached value of the '{@link #getDomainNameFeature() <em>Domain Name Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainNameFeature()
	 * @generated
	 * @ordered
	 */
	protected GenFeature domainNameFeature = null;

	/**
	 * The default value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected static final String FOREGROUND_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected String foregroundColor = FOREGROUND_COLOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContainmentMetaFeature() <em>Containment Meta Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainmentMetaFeature()
	 * @generated
	 * @ordered
	 */
	protected GenFeature containmentMetaFeature = null;

	/**
	 * The default value of the '{@link #getNotationViewFactoryClassName() <em>Notation View Factory Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotationViewFactoryClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotationViewFactoryClassName() <em>Notation View Factory Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotationViewFactoryClassName()
	 * @generated
	 * @ordered
	 */
	protected String notationViewFactoryClassName = NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getViewmap() <em>Viewmap</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewmap()
	 * @generated
	 * @ordered
	 */
	protected Viewmap viewmap = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenBaseElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getGenBaseElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature getDomainNameFeature() {
		if (domainNameFeature != null && domainNameFeature.eIsProxy()) {
			GenFeature oldDomainNameFeature = domainNameFeature;
			domainNameFeature = (GenFeature)eResolveProxy((InternalEObject)domainNameFeature);
			if (domainNameFeature != oldDomainNameFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.GEN_BASE_ELEMENT__DOMAIN_NAME_FEATURE, oldDomainNameFeature, domainNameFeature));
			}
		}
		return domainNameFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature basicGetDomainNameFeature() {
		return domainNameFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainNameFeature(GenFeature newDomainNameFeature) {
		GenFeature oldDomainNameFeature = domainNameFeature;
		domainNameFeature = newDomainNameFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_BASE_ELEMENT__DOMAIN_NAME_FEATURE, oldDomainNameFeature, domainNameFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getForegroundColor() {
		return foregroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForegroundColor(String newForegroundColor) {
		String oldForegroundColor = foregroundColor;
		foregroundColor = newForegroundColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_BASE_ELEMENT__FOREGROUND_COLOR, oldForegroundColor, foregroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature getContainmentMetaFeature() {
		if (containmentMetaFeature != null && containmentMetaFeature.eIsProxy()) {
			GenFeature oldContainmentMetaFeature = containmentMetaFeature;
			containmentMetaFeature = (GenFeature)eResolveProxy((InternalEObject)containmentMetaFeature);
			if (containmentMetaFeature != oldContainmentMetaFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.GEN_BASE_ELEMENT__CONTAINMENT_META_FEATURE, oldContainmentMetaFeature, containmentMetaFeature));
			}
		}
		return containmentMetaFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature basicGetContainmentMetaFeature() {
		return containmentMetaFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainmentMetaFeature(GenFeature newContainmentMetaFeature) {
		GenFeature oldContainmentMetaFeature = containmentMetaFeature;
		containmentMetaFeature = newContainmentMetaFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_BASE_ELEMENT__CONTAINMENT_META_FEATURE, oldContainmentMetaFeature, containmentMetaFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotationViewFactoryClassNameGen() {
		return notationViewFactoryClassName;
	}

	public String getNotationViewFactoryClassName() {
		String name = getNotationViewFactoryClassNameGen();
		if (name == null || name.trim().length() == 0) {
			name = getDefaultNotationViewFactoryClassName();
		}
		return name;
	}

	protected abstract String getDefaultNotationViewFactoryClassName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotationViewFactoryClassName(String newNotationViewFactoryClassName) {
		String oldNotationViewFactoryClassName = notationViewFactoryClassName;
		notationViewFactoryClassName = newNotationViewFactoryClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_BASE_ELEMENT__NOTATION_VIEW_FACTORY_CLASS_NAME, oldNotationViewFactoryClassName, notationViewFactoryClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Viewmap getViewmap() {
		return viewmap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetViewmap(Viewmap newViewmap, NotificationChain msgs) {
		Viewmap oldViewmap = viewmap;
		viewmap = newViewmap;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP, oldViewmap, newViewmap);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewmap(Viewmap newViewmap) {
		if (newViewmap != viewmap) {
			NotificationChain msgs = null;
			if (viewmap != null)
				msgs = ((InternalEObject)viewmap).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP, null, msgs);
			if (newViewmap != null)
				msgs = ((InternalEObject)newViewmap).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP, null, msgs);
			msgs = basicSetViewmap(newViewmap, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP, newViewmap, newViewmap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasNameToEdit() {
		return getDomainNameFeature() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP:
					return basicSetViewmap(null, msgs);
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
			case GMFGenPackage.GEN_BASE_ELEMENT__DIAGRAM_RUN_TIME_CLASS:
				if (resolve) return getDiagramRunTimeClass();
				return basicGetDiagramRunTimeClass();
			case GMFGenPackage.GEN_BASE_ELEMENT__VISUAL_ID:
				return new Integer(getVisualID());
			case GMFGenPackage.GEN_BASE_ELEMENT__EDIT_PART_CLASS_NAME:
				return getEditPartClassName();
			case GMFGenPackage.GEN_BASE_ELEMENT__META_INFO_PROVIDER_CLASS_NAME:
				return getMetaInfoProviderClassName();
			case GMFGenPackage.GEN_BASE_ELEMENT__DOMAIN_NAME_FEATURE:
				if (resolve) return getDomainNameFeature();
				return basicGetDomainNameFeature();
			case GMFGenPackage.GEN_BASE_ELEMENT__FOREGROUND_COLOR:
				return getForegroundColor();
			case GMFGenPackage.GEN_BASE_ELEMENT__CONTAINMENT_META_FEATURE:
				if (resolve) return getContainmentMetaFeature();
				return basicGetContainmentMetaFeature();
			case GMFGenPackage.GEN_BASE_ELEMENT__NOTATION_VIEW_FACTORY_CLASS_NAME:
				return getNotationViewFactoryClassName();
			case GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP:
				return getViewmap();
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
			case GMFGenPackage.GEN_BASE_ELEMENT__DIAGRAM_RUN_TIME_CLASS:
				setDiagramRunTimeClass((GenClass)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__VISUAL_ID:
				setVisualID(((Integer)newValue).intValue());
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__EDIT_PART_CLASS_NAME:
				setEditPartClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__META_INFO_PROVIDER_CLASS_NAME:
				setMetaInfoProviderClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__DOMAIN_NAME_FEATURE:
				setDomainNameFeature((GenFeature)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__FOREGROUND_COLOR:
				setForegroundColor((String)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__CONTAINMENT_META_FEATURE:
				setContainmentMetaFeature((GenFeature)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__NOTATION_VIEW_FACTORY_CLASS_NAME:
				setNotationViewFactoryClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP:
				setViewmap((Viewmap)newValue);
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
			case GMFGenPackage.GEN_BASE_ELEMENT__DIAGRAM_RUN_TIME_CLASS:
				setDiagramRunTimeClass((GenClass)null);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__VISUAL_ID:
				setVisualID(VISUAL_ID_EDEFAULT);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__EDIT_PART_CLASS_NAME:
				setEditPartClassName(EDIT_PART_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__META_INFO_PROVIDER_CLASS_NAME:
				setMetaInfoProviderClassName(META_INFO_PROVIDER_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__DOMAIN_NAME_FEATURE:
				setDomainNameFeature((GenFeature)null);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__FOREGROUND_COLOR:
				setForegroundColor(FOREGROUND_COLOR_EDEFAULT);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__CONTAINMENT_META_FEATURE:
				setContainmentMetaFeature((GenFeature)null);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__NOTATION_VIEW_FACTORY_CLASS_NAME:
				setNotationViewFactoryClassName(NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP:
				setViewmap((Viewmap)null);
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
			case GMFGenPackage.GEN_BASE_ELEMENT__DIAGRAM_RUN_TIME_CLASS:
				return diagramRunTimeClass != null;
			case GMFGenPackage.GEN_BASE_ELEMENT__VISUAL_ID:
				return visualID != VISUAL_ID_EDEFAULT;
			case GMFGenPackage.GEN_BASE_ELEMENT__EDIT_PART_CLASS_NAME:
				return EDIT_PART_CLASS_NAME_EDEFAULT == null ? editPartClassName != null : !EDIT_PART_CLASS_NAME_EDEFAULT.equals(editPartClassName);
			case GMFGenPackage.GEN_BASE_ELEMENT__META_INFO_PROVIDER_CLASS_NAME:
				return META_INFO_PROVIDER_CLASS_NAME_EDEFAULT == null ? metaInfoProviderClassName != null : !META_INFO_PROVIDER_CLASS_NAME_EDEFAULT.equals(metaInfoProviderClassName);
			case GMFGenPackage.GEN_BASE_ELEMENT__DOMAIN_NAME_FEATURE:
				return domainNameFeature != null;
			case GMFGenPackage.GEN_BASE_ELEMENT__FOREGROUND_COLOR:
				return FOREGROUND_COLOR_EDEFAULT == null ? foregroundColor != null : !FOREGROUND_COLOR_EDEFAULT.equals(foregroundColor);
			case GMFGenPackage.GEN_BASE_ELEMENT__CONTAINMENT_META_FEATURE:
				return containmentMetaFeature != null;
			case GMFGenPackage.GEN_BASE_ELEMENT__NOTATION_VIEW_FACTORY_CLASS_NAME:
				return NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT == null ? notationViewFactoryClassName != null : !NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT.equals(notationViewFactoryClassName);
			case GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP:
				return viewmap != null;
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
		result.append(" (foregroundColor: ");
		result.append(foregroundColor);
		result.append(", notationViewFactoryClassName: ");
		result.append(notationViewFactoryClassName);
		result.append(')');
		return result.toString();
	}

} //GenBaseElementImpl
