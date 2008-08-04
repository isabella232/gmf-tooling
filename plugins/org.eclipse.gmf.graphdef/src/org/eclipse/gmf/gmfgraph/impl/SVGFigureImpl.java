/**
 * <copyright>
 * </copyright>
 *
 * $Id: SVGFigureImpl.java,v 1.2 2008/08/04 12:45:55 dstadnik Exp $
 */
package org.eclipse.gmf.gmfgraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.SVGFigure;
import org.eclipse.gmf.gmfgraph.SVGProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SVG Figure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.SVGFigureImpl#getDocumentURI <em>Document URI</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.SVGFigureImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.SVGFigureImpl#isSafeRendering <em>Safe Rendering</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SVGFigureImpl extends RealFigureImpl implements SVGFigure {
	/**
	 * The default value of the '{@link #getDocumentURI() <em>Document URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentURI()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDocumentURI() <em>Document URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentURI()
	 * @generated
	 * @ordered
	 */
	protected String documentURI = DOCUMENT_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<SVGProperty> properties;

	/**
	 * The default value of the '{@link #isSafeRendering() <em>Safe Rendering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSafeRendering()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SAFE_RENDERING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSafeRendering() <em>Safe Rendering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSafeRendering()
	 * @generated
	 * @ordered
	 */
	protected boolean safeRendering = SAFE_RENDERING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SVGFigureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGraphPackage.eINSTANCE.getSVGFigure();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDocumentURI() {
		return documentURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentURI(String newDocumentURI) {
		String oldDocumentURI = documentURI;
		documentURI = newDocumentURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.SVG_FIGURE__DOCUMENT_URI, oldDocumentURI, documentURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SVGProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<SVGProperty>(SVGProperty.class, this, GMFGraphPackage.SVG_FIGURE__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSafeRendering() {
		return safeRendering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSafeRendering(boolean newSafeRendering) {
		boolean oldSafeRendering = safeRendering;
		safeRendering = newSafeRendering;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.SVG_FIGURE__SAFE_RENDERING, oldSafeRendering, safeRendering));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFGraphPackage.SVG_FIGURE__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGraphPackage.SVG_FIGURE__DOCUMENT_URI:
				return getDocumentURI();
			case GMFGraphPackage.SVG_FIGURE__PROPERTIES:
				return getProperties();
			case GMFGraphPackage.SVG_FIGURE__SAFE_RENDERING:
				return isSafeRendering() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GMFGraphPackage.SVG_FIGURE__DOCUMENT_URI:
				setDocumentURI((String)newValue);
				return;
			case GMFGraphPackage.SVG_FIGURE__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends SVGProperty>)newValue);
				return;
			case GMFGraphPackage.SVG_FIGURE__SAFE_RENDERING:
				setSafeRendering(((Boolean)newValue).booleanValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GMFGraphPackage.SVG_FIGURE__DOCUMENT_URI:
				setDocumentURI(DOCUMENT_URI_EDEFAULT);
				return;
			case GMFGraphPackage.SVG_FIGURE__PROPERTIES:
				getProperties().clear();
				return;
			case GMFGraphPackage.SVG_FIGURE__SAFE_RENDERING:
				setSafeRendering(SAFE_RENDERING_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GMFGraphPackage.SVG_FIGURE__DOCUMENT_URI:
				return DOCUMENT_URI_EDEFAULT == null ? documentURI != null : !DOCUMENT_URI_EDEFAULT.equals(documentURI);
			case GMFGraphPackage.SVG_FIGURE__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case GMFGraphPackage.SVG_FIGURE__SAFE_RENDERING:
				return safeRendering != SAFE_RENDERING_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (documentURI: ");
		result.append(documentURI);
		result.append(", safeRendering: ");
		result.append(safeRendering);
		result.append(')');
		return result.toString();
	}

} //SVGFigureImpl
