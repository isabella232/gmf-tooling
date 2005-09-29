/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Link With Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenLinkWithClassImpl#getDomainMetaClass <em>Domain Meta Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenLinkWithClassImpl extends GenLinkImpl implements GenLinkWithClass {
	/**
	 * The cached value of the '{@link #getDomainMetaClass() <em>Domain Meta Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainMetaClass()
	 * @generated
	 * @ordered
	 */
	protected EClass domainMetaClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenLinkWithClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getGenLinkWithClass();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainMetaClass() {
		if (domainMetaClass != null && domainMetaClass.eIsProxy()) {
			EClass oldDomainMetaClass = domainMetaClass;
			domainMetaClass = (EClass)eResolveProxy((InternalEObject)domainMetaClass);
			if (domainMetaClass != oldDomainMetaClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_META_CLASS, oldDomainMetaClass, domainMetaClass));
			}
		}
		return domainMetaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetDomainMetaClass() {
		return domainMetaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainMetaClass(EClass newDomainMetaClass) {
		EClass oldDomainMetaClass = domainMetaClass;
		domainMetaClass = newDomainMetaClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_META_CLASS, oldDomainMetaClass, domainMetaClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initialize(EClass eClass) {
		setDomainMetaClass(eClass);
	}

	protected String getDefaultNotationViewFactoryClassName() {
		return getDomainMetaClass().getName() + "ViewFactory"; //$NON-NLS-1$
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFGenPackage.GEN_LINK_WITH_CLASS__DIAGRAM:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, GMFGenPackage.GEN_LINK_WITH_CLASS__DIAGRAM, msgs);
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
				case GMFGenPackage.GEN_LINK_WITH_CLASS__DIAGRAM:
					return eBasicSetContainer(null, GMFGenPackage.GEN_LINK_WITH_CLASS__DIAGRAM, msgs);
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
				case GMFGenPackage.GEN_LINK_WITH_CLASS__DIAGRAM:
					return eContainer.eInverseRemove(this, GMFGenPackage.GEN_DIAGRAM__LINKS, GenDiagram.class, msgs);
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
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DIAGRAM_RUN_TIME_CLASS:
				if (resolve) return getDiagramRunTimeClass();
				return basicGetDiagramRunTimeClass();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__VISUAL_ID:
				return new Integer(getVisualID());
			case GMFGenPackage.GEN_LINK_WITH_CLASS__EDIT_PART_CLASS_NAME:
				return getEditPartClassName();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__META_INFO_PROVIDER_CLASS_NAME:
				return getMetaInfoProviderClassName();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_NAME_FEATURE:
				if (resolve) return getDomainNameFeature();
				return basicGetDomainNameFeature();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__FOREGROUND_COLOR:
				return getForegroundColor();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__CONTAINMENT_META_FEATURE:
				if (resolve) return getContainmentMetaFeature();
				return basicGetContainmentMetaFeature();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__NOTATION_VIEW_FACTORY_CLASS_NAME:
				return getNotationViewFactoryClassName();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DIAGRAM:
				return getDiagram();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_LINK_TARGET_FEATURE:
				if (resolve) return getDomainLinkTargetFeature();
				return basicGetDomainLinkTargetFeature();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__LINE_STYLE:
				return getLineStyle();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__FIGURE_QUALIFIED_CLASS_NAME:
				return getFigureQualifiedClassName();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__SOURCE_DECORATION_FIGURE_QUALIFIED_CLASS_NAME:
				return getSourceDecorationFigureQualifiedClassName();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__TARGET_DECORATION_FIGURE_QUALIFIED_CLASS_NAME:
				return getTargetDecorationFigureQualifiedClassName();
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_META_CLASS:
				if (resolve) return getDomainMetaClass();
				return basicGetDomainMetaClass();
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
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DIAGRAM_RUN_TIME_CLASS:
				setDiagramRunTimeClass((GenClass)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__VISUAL_ID:
				setVisualID(((Integer)newValue).intValue());
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__EDIT_PART_CLASS_NAME:
				setEditPartClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__META_INFO_PROVIDER_CLASS_NAME:
				setMetaInfoProviderClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_NAME_FEATURE:
				setDomainNameFeature((EAttribute)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__FOREGROUND_COLOR:
				setForegroundColor((String)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__CONTAINMENT_META_FEATURE:
				setContainmentMetaFeature((EReference)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__NOTATION_VIEW_FACTORY_CLASS_NAME:
				setNotationViewFactoryClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_LINK_TARGET_FEATURE:
				setDomainLinkTargetFeature((EStructuralFeature)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__LINE_STYLE:
				setLineStyle((String)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__FIGURE_QUALIFIED_CLASS_NAME:
				setFigureQualifiedClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__SOURCE_DECORATION_FIGURE_QUALIFIED_CLASS_NAME:
				setSourceDecorationFigureQualifiedClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__TARGET_DECORATION_FIGURE_QUALIFIED_CLASS_NAME:
				setTargetDecorationFigureQualifiedClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_META_CLASS:
				setDomainMetaClass((EClass)newValue);
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
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DIAGRAM_RUN_TIME_CLASS:
				setDiagramRunTimeClass((GenClass)null);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__VISUAL_ID:
				setVisualID(VISUAL_ID_EDEFAULT);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__EDIT_PART_CLASS_NAME:
				setEditPartClassName(EDIT_PART_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__META_INFO_PROVIDER_CLASS_NAME:
				setMetaInfoProviderClassName(META_INFO_PROVIDER_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_NAME_FEATURE:
				setDomainNameFeature((EAttribute)null);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__FOREGROUND_COLOR:
				setForegroundColor(FOREGROUND_COLOR_EDEFAULT);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__CONTAINMENT_META_FEATURE:
				setContainmentMetaFeature((EReference)null);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__NOTATION_VIEW_FACTORY_CLASS_NAME:
				setNotationViewFactoryClassName(NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_LINK_TARGET_FEATURE:
				setDomainLinkTargetFeature((EStructuralFeature)null);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__LINE_STYLE:
				setLineStyle(LINE_STYLE_EDEFAULT);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__FIGURE_QUALIFIED_CLASS_NAME:
				setFigureQualifiedClassName(FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__SOURCE_DECORATION_FIGURE_QUALIFIED_CLASS_NAME:
				setSourceDecorationFigureQualifiedClassName(SOURCE_DECORATION_FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__TARGET_DECORATION_FIGURE_QUALIFIED_CLASS_NAME:
				setTargetDecorationFigureQualifiedClassName(TARGET_DECORATION_FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_META_CLASS:
				setDomainMetaClass((EClass)null);
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
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DIAGRAM_RUN_TIME_CLASS:
				return diagramRunTimeClass != null;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__VISUAL_ID:
				return visualID != VISUAL_ID_EDEFAULT;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__EDIT_PART_CLASS_NAME:
				return EDIT_PART_CLASS_NAME_EDEFAULT == null ? editPartClassName != null : !EDIT_PART_CLASS_NAME_EDEFAULT.equals(editPartClassName);
			case GMFGenPackage.GEN_LINK_WITH_CLASS__META_INFO_PROVIDER_CLASS_NAME:
				return META_INFO_PROVIDER_CLASS_NAME_EDEFAULT == null ? metaInfoProviderClassName != null : !META_INFO_PROVIDER_CLASS_NAME_EDEFAULT.equals(metaInfoProviderClassName);
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_NAME_FEATURE:
				return domainNameFeature != null;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__FOREGROUND_COLOR:
				return FOREGROUND_COLOR_EDEFAULT == null ? foregroundColor != null : !FOREGROUND_COLOR_EDEFAULT.equals(foregroundColor);
			case GMFGenPackage.GEN_LINK_WITH_CLASS__CONTAINMENT_META_FEATURE:
				return containmentMetaFeature != null;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__NOTATION_VIEW_FACTORY_CLASS_NAME:
				return NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT == null ? notationViewFactoryClassName != null : !NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT.equals(notationViewFactoryClassName);
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DIAGRAM:
				return getDiagram() != null;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_LINK_TARGET_FEATURE:
				return domainLinkTargetFeature != null;
			case GMFGenPackage.GEN_LINK_WITH_CLASS__LINE_STYLE:
				return LINE_STYLE_EDEFAULT == null ? lineStyle != null : !LINE_STYLE_EDEFAULT.equals(lineStyle);
			case GMFGenPackage.GEN_LINK_WITH_CLASS__FIGURE_QUALIFIED_CLASS_NAME:
				return FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT == null ? figureQualifiedClassName != null : !FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT.equals(figureQualifiedClassName);
			case GMFGenPackage.GEN_LINK_WITH_CLASS__SOURCE_DECORATION_FIGURE_QUALIFIED_CLASS_NAME:
				return SOURCE_DECORATION_FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT == null ? sourceDecorationFigureQualifiedClassName != null : !SOURCE_DECORATION_FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT.equals(sourceDecorationFigureQualifiedClassName);
			case GMFGenPackage.GEN_LINK_WITH_CLASS__TARGET_DECORATION_FIGURE_QUALIFIED_CLASS_NAME:
				return TARGET_DECORATION_FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT == null ? targetDecorationFigureQualifiedClassName != null : !TARGET_DECORATION_FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT.equals(targetDecorationFigureQualifiedClassName);
			case GMFGenPackage.GEN_LINK_WITH_CLASS__DOMAIN_META_CLASS:
				return domainMetaClass != null;
		}
		return eDynamicIsSet(eFeature);
	}

	public String getClassNamePrefix() {
		return getDomainMetaClass() == null ? "GenLink$" + hashCode() : getDomainMetaClass().getName();
	}

	public String getClassNameSuffux() {
		return "Link";
	}
} //GenLinkWithClassImpl
