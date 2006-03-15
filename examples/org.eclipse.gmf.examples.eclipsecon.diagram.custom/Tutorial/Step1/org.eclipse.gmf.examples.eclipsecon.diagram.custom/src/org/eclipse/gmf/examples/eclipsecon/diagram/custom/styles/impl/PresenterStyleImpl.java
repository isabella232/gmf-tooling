/**
 * <copyright>
 * </copyright>
 *
 * $Id: PresenterStyleImpl.java,v 1.1 2006/03/15 03:41:25 sshaw Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.StylesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Presenter Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.PresenterStyleImpl#getImageURL <em>Image URL</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.PresenterStyleImpl#getReview <em>Review</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PresenterStyleImpl extends EObjectImpl implements PresenterStyle {
/**
     * The default value of the '{@link #getImageURL() <em>Image URL</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImageURL()
     * @generated
     * @ordered
     */
    protected static final String IMAGE_URL_EDEFAULT = "";

/**
     * The cached value of the '{@link #getImageURL() <em>Image URL</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImageURL()
     * @generated
     * @ordered
     */
    protected String imageURL = IMAGE_URL_EDEFAULT;

/**
     * The default value of the '{@link #getReview() <em>Review</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReview()
     * @generated
     * @ordered
     */
    protected static final String REVIEW_EDEFAULT = "";

/**
     * The cached value of the '{@link #getReview() <em>Review</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReview()
     * @generated
     * @ordered
     */
    protected String review = REVIEW_EDEFAULT;

/**
     * The default value of the '{@link #getDisplayAsDefault() <em>Display As Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayAsDefault()
     * @generated
     * @ordered
     */
    protected static final Boolean DISPLAY_AS_DEFAULT_EDEFAULT = Boolean.TRUE;

    /**
     * The cached value of the '{@link #getDisplayAsDefault() <em>Display As Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDisplayAsDefault()
     * @generated
     * @ordered
     */
    protected Boolean displayAsDefault = DISPLAY_AS_DEFAULT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PresenterStyleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return StylesPackage.Literals.PRESENTER_STYLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImageURL(String newImageURL) {
        String oldImageURL = imageURL;
        imageURL = newImageURL;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StylesPackage.PRESENTER_STYLE__IMAGE_URL, oldImageURL, imageURL));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getReview() {
        return review;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReview(String newReview) {
        String oldReview = review;
        review = newReview;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StylesPackage.PRESENTER_STYLE__REVIEW, oldReview, review));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getDisplayAsDefault() {
        return displayAsDefault;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDisplayAsDefault(Boolean newDisplayAsDefault) {
        Boolean oldDisplayAsDefault = displayAsDefault;
        displayAsDefault = newDisplayAsDefault;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StylesPackage.PRESENTER_STYLE__DISPLAY_AS_DEFAULT, oldDisplayAsDefault, displayAsDefault));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case StylesPackage.PRESENTER_STYLE__IMAGE_URL:
                return getImageURL();
            case StylesPackage.PRESENTER_STYLE__REVIEW:
                return getReview();
            case StylesPackage.PRESENTER_STYLE__DISPLAY_AS_DEFAULT:
                return getDisplayAsDefault();
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
            case StylesPackage.PRESENTER_STYLE__IMAGE_URL:
                setImageURL((String)newValue);
                return;
            case StylesPackage.PRESENTER_STYLE__REVIEW:
                setReview((String)newValue);
                return;
            case StylesPackage.PRESENTER_STYLE__DISPLAY_AS_DEFAULT:
                setDisplayAsDefault((Boolean)newValue);
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
            case StylesPackage.PRESENTER_STYLE__IMAGE_URL:
                setImageURL(IMAGE_URL_EDEFAULT);
                return;
            case StylesPackage.PRESENTER_STYLE__REVIEW:
                setReview(REVIEW_EDEFAULT);
                return;
            case StylesPackage.PRESENTER_STYLE__DISPLAY_AS_DEFAULT:
                setDisplayAsDefault(DISPLAY_AS_DEFAULT_EDEFAULT);
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
            case StylesPackage.PRESENTER_STYLE__IMAGE_URL:
                return IMAGE_URL_EDEFAULT == null ? imageURL != null : !IMAGE_URL_EDEFAULT.equals(imageURL);
            case StylesPackage.PRESENTER_STYLE__REVIEW:
                return REVIEW_EDEFAULT == null ? review != null : !REVIEW_EDEFAULT.equals(review);
            case StylesPackage.PRESENTER_STYLE__DISPLAY_AS_DEFAULT:
                return DISPLAY_AS_DEFAULT_EDEFAULT == null ? displayAsDefault != null : !DISPLAY_AS_DEFAULT_EDEFAULT.equals(displayAsDefault);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (imageURL: ");
        result.append(imageURL);
        result.append(", review: ");
        result.append(review);
        result.append(", displayAsDefault: ");
        result.append(displayAsDefault);
        result.append(')');
        return result.toString();
    }

} //PresenterStyleImpl