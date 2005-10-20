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
import org.eclipse.gmf.codegen.gmfgen.GenElementInitializer;
import org.eclipse.gmf.codegen.gmfgen.ModelElementSelector;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Base Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenBaseElementImpl#getDomainNameFeature <em>Domain Name Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenBaseElementImpl#getContainmentMetaFeature <em>Containment Meta Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenBaseElementImpl#getViewmap <em>Viewmap</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenBaseElementImpl#getModelElementSelector <em>Model Element Selector</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenBaseElementImpl#getModelElementInitializer <em>Model Element Initializer</em>}</li>
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
	 * The cached value of the '{@link #getContainmentMetaFeature() <em>Containment Meta Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainmentMetaFeature()
	 * @generated
	 * @ordered
	 */
	protected GenFeature containmentMetaFeature = null;

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
	 * The cached value of the '{@link #getModelElementSelector() <em>Model Element Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElementSelector()
	 * @generated
	 * @ordered
	 */
	protected ModelElementSelector modelElementSelector = null;

	/**
	 * The cached value of the '{@link #getModelElementInitializer() <em>Model Element Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElementInitializer()
	 * @generated
	 * @ordered
	 */
	protected GenElementInitializer modelElementInitializer = null;

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
	 * @generated
	 */
	public ModelElementSelector getModelElementSelector() {
		return modelElementSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelElementSelector(ModelElementSelector newModelElementSelector, NotificationChain msgs) {
		ModelElementSelector oldModelElementSelector = modelElementSelector;
		modelElementSelector = newModelElementSelector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_SELECTOR, oldModelElementSelector, newModelElementSelector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElementSelector(ModelElementSelector newModelElementSelector) {
		if (newModelElementSelector != modelElementSelector) {
			NotificationChain msgs = null;
			if (modelElementSelector != null)
				msgs = ((InternalEObject)modelElementSelector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_SELECTOR, null, msgs);
			if (newModelElementSelector != null)
				msgs = ((InternalEObject)newModelElementSelector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_SELECTOR, null, msgs);
			msgs = basicSetModelElementSelector(newModelElementSelector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_SELECTOR, newModelElementSelector, newModelElementSelector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenElementInitializer getModelElementInitializer() {
		return modelElementInitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelElementInitializer(GenElementInitializer newModelElementInitializer, NotificationChain msgs) {
		GenElementInitializer oldModelElementInitializer = modelElementInitializer;
		modelElementInitializer = newModelElementInitializer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_INITIALIZER, oldModelElementInitializer, newModelElementInitializer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElementInitializer(GenElementInitializer newModelElementInitializer) {
		if (newModelElementInitializer != modelElementInitializer) {
			NotificationChain msgs = null;
			if (modelElementInitializer != null)
				msgs = ((InternalEObject)modelElementInitializer).eInverseRemove(this, GMFGenPackage.GEN_ELEMENT_INITIALIZER__ELEMENT, GenElementInitializer.class, msgs);
			if (newModelElementInitializer != null)
				msgs = ((InternalEObject)newModelElementInitializer).eInverseAdd(this, GMFGenPackage.GEN_ELEMENT_INITIALIZER__ELEMENT, GenElementInitializer.class, msgs);
			msgs = basicSetModelElementInitializer(newModelElementInitializer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_INITIALIZER, newModelElementInitializer, newModelElementInitializer));
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_INITIALIZER:
					if (modelElementInitializer != null)
						msgs = ((InternalEObject)modelElementInitializer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_INITIALIZER, null, msgs);
					return basicSetModelElementInitializer((GenElementInitializer)otherEnd, msgs);
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
				case GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP:
					return basicSetViewmap(null, msgs);
				case GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_SELECTOR:
					return basicSetModelElementSelector(null, msgs);
				case GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_INITIALIZER:
					return basicSetModelElementInitializer(null, msgs);
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
			case GMFGenPackage.GEN_BASE_ELEMENT__NOTATION_VIEW_FACTORY_CLASS_NAME:
				return getNotationViewFactoryClassName();
			case GMFGenPackage.GEN_BASE_ELEMENT__DOMAIN_NAME_FEATURE:
				if (resolve) return getDomainNameFeature();
				return basicGetDomainNameFeature();
			case GMFGenPackage.GEN_BASE_ELEMENT__CONTAINMENT_META_FEATURE:
				if (resolve) return getContainmentMetaFeature();
				return basicGetContainmentMetaFeature();
			case GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP:
				return getViewmap();
			case GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_SELECTOR:
				return getModelElementSelector();
			case GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_INITIALIZER:
				return getModelElementInitializer();
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
			case GMFGenPackage.GEN_BASE_ELEMENT__NOTATION_VIEW_FACTORY_CLASS_NAME:
				setNotationViewFactoryClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__DOMAIN_NAME_FEATURE:
				setDomainNameFeature((GenFeature)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__CONTAINMENT_META_FEATURE:
				setContainmentMetaFeature((GenFeature)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP:
				setViewmap((Viewmap)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_SELECTOR:
				setModelElementSelector((ModelElementSelector)newValue);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_INITIALIZER:
				setModelElementInitializer((GenElementInitializer)newValue);
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
			case GMFGenPackage.GEN_BASE_ELEMENT__NOTATION_VIEW_FACTORY_CLASS_NAME:
				setNotationViewFactoryClassName(NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__DOMAIN_NAME_FEATURE:
				setDomainNameFeature((GenFeature)null);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__CONTAINMENT_META_FEATURE:
				setContainmentMetaFeature((GenFeature)null);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP:
				setViewmap((Viewmap)null);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_SELECTOR:
				setModelElementSelector((ModelElementSelector)null);
				return;
			case GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_INITIALIZER:
				setModelElementInitializer((GenElementInitializer)null);
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
			case GMFGenPackage.GEN_BASE_ELEMENT__NOTATION_VIEW_FACTORY_CLASS_NAME:
				return NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT == null ? notationViewFactoryClassName != null : !NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT.equals(notationViewFactoryClassName);
			case GMFGenPackage.GEN_BASE_ELEMENT__DOMAIN_NAME_FEATURE:
				return domainNameFeature != null;
			case GMFGenPackage.GEN_BASE_ELEMENT__CONTAINMENT_META_FEATURE:
				return containmentMetaFeature != null;
			case GMFGenPackage.GEN_BASE_ELEMENT__VIEWMAP:
				return viewmap != null;
			case GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_SELECTOR:
				return modelElementSelector != null;
			case GMFGenPackage.GEN_BASE_ELEMENT__MODEL_ELEMENT_INITIALIZER:
				return modelElementInitializer != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //GenBaseElementImpl
