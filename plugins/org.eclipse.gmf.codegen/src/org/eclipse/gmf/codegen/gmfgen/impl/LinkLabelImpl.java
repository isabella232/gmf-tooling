/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.LinkLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.LinkLabelImpl#getDomainMetaFeature <em>Domain Meta Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.LinkLabelImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.LinkLabelImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.LinkLabelImpl#getLink <em>Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkLabelImpl extends EObjectImpl implements LinkLabel {
	/**
	 * The cached value of the '{@link #getDomainMetaFeature() <em>Domain Meta Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainMetaFeature()
	 * @generated
	 * @ordered
	 */
	protected GenFeature domainMetaFeature = null;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean readOnly = READ_ONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final int WEIGHT_EDEFAULT = 50;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected int weight = WEIGHT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getLinkLabel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature getDomainMetaFeature() {
		if (domainMetaFeature != null && domainMetaFeature.eIsProxy()) {
			GenFeature oldDomainMetaFeature = domainMetaFeature;
			domainMetaFeature = (GenFeature)eResolveProxy((InternalEObject)domainMetaFeature);
			if (domainMetaFeature != oldDomainMetaFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.LINK_LABEL__DOMAIN_META_FEATURE, oldDomainMetaFeature, domainMetaFeature));
			}
		}
		return domainMetaFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature basicGetDomainMetaFeature() {
		return domainMetaFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainMetaFeature(GenFeature newDomainMetaFeature) {
		GenFeature oldDomainMetaFeature = domainMetaFeature;
		domainMetaFeature = newDomainMetaFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.LINK_LABEL__DOMAIN_META_FEATURE, oldDomainMetaFeature, domainMetaFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.LINK_LABEL__READ_ONLY, oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(int newWeight) {
		int oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.LINK_LABEL__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenLink getLink() {
		if (eContainerFeatureID != GMFGenPackage.LINK_LABEL__LINK) return null;
		return (GenLink)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFGenPackage.LINK_LABEL__LINK:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, GMFGenPackage.LINK_LABEL__LINK, msgs);
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
				case GMFGenPackage.LINK_LABEL__LINK:
					return eBasicSetContainer(null, GMFGenPackage.LINK_LABEL__LINK, msgs);
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
				case GMFGenPackage.LINK_LABEL__LINK:
					return eContainer.eInverseRemove(this, GMFGenPackage.GEN_LINK__LABELS, GenLink.class, msgs);
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
			case GMFGenPackage.LINK_LABEL__DOMAIN_META_FEATURE:
				if (resolve) return getDomainMetaFeature();
				return basicGetDomainMetaFeature();
			case GMFGenPackage.LINK_LABEL__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case GMFGenPackage.LINK_LABEL__WEIGHT:
				return new Integer(getWeight());
			case GMFGenPackage.LINK_LABEL__LINK:
				return getLink();
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
			case GMFGenPackage.LINK_LABEL__DOMAIN_META_FEATURE:
				setDomainMetaFeature((GenFeature)newValue);
				return;
			case GMFGenPackage.LINK_LABEL__READ_ONLY:
				setReadOnly(((Boolean)newValue).booleanValue());
				return;
			case GMFGenPackage.LINK_LABEL__WEIGHT:
				setWeight(((Integer)newValue).intValue());
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
			case GMFGenPackage.LINK_LABEL__DOMAIN_META_FEATURE:
				setDomainMetaFeature((GenFeature)null);
				return;
			case GMFGenPackage.LINK_LABEL__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case GMFGenPackage.LINK_LABEL__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
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
			case GMFGenPackage.LINK_LABEL__DOMAIN_META_FEATURE:
				return domainMetaFeature != null;
			case GMFGenPackage.LINK_LABEL__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case GMFGenPackage.LINK_LABEL__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case GMFGenPackage.LINK_LABEL__LINK:
				return getLink() != null;
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
		result.append(" (readOnly: ");
		result.append(readOnly);
		result.append(", weight: ");
		result.append(weight);
		result.append(')');
		return result.toString();
	}

} //LinkLabelImpl
