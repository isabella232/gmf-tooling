/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.codegen.gmfgen.DecoratedConnectionViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.LinkDecoration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decorated Connection Viewmap</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.DecoratedConnectionViewmapImpl#getFigureQualifiedClassName <em>Figure Qualified Class Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.DecoratedConnectionViewmapImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.DecoratedConnectionViewmapImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DecoratedConnectionViewmapImpl extends ViewmapImpl implements DecoratedConnectionViewmap {
	/**
	 * The default value of the '{@link #getFigureQualifiedClassName() <em>Figure Qualified Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFigureQualifiedClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT = "org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx";

	/**
	 * The cached value of the '{@link #getFigureQualifiedClassName() <em>Figure Qualified Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFigureQualifiedClassName()
	 * @generated
	 * @ordered
	 */
	protected String figureQualifiedClassName = FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected LinkDecoration source = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected LinkDecoration target = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecoratedConnectionViewmapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getDecoratedConnectionViewmap();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFigureQualifiedClassName() {
		return figureQualifiedClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFigureQualifiedClassName(String newFigureQualifiedClassName) {
		String oldFigureQualifiedClassName = figureQualifiedClassName;
		figureQualifiedClassName = newFigureQualifiedClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__FIGURE_QUALIFIED_CLASS_NAME, oldFigureQualifiedClassName, figureQualifiedClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkDecoration getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(LinkDecoration newSource, NotificationChain msgs) {
		LinkDecoration oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(LinkDecoration newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkDecoration getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(LinkDecoration newTarget, NotificationChain msgs) {
		LinkDecoration oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(LinkDecoration newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__ATTRIBUTES:
					return ((InternalEList)getAttributes()).basicRemove(otherEnd, msgs);
				case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__SOURCE:
					return basicSetSource(null, msgs);
				case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__TARGET:
					return basicSetTarget(null, msgs);
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
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__ATTRIBUTES:
				return getAttributes();
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__FIGURE_QUALIFIED_CLASS_NAME:
				return getFigureQualifiedClassName();
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__SOURCE:
				return getSource();
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__TARGET:
				return getTarget();
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
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection)newValue);
				return;
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__FIGURE_QUALIFIED_CLASS_NAME:
				setFigureQualifiedClassName((String)newValue);
				return;
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__SOURCE:
				setSource((LinkDecoration)newValue);
				return;
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__TARGET:
				setTarget((LinkDecoration)newValue);
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
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__ATTRIBUTES:
				getAttributes().clear();
				return;
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__FIGURE_QUALIFIED_CLASS_NAME:
				setFigureQualifiedClassName(FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__SOURCE:
				setSource((LinkDecoration)null);
				return;
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__TARGET:
				setTarget((LinkDecoration)null);
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
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__FIGURE_QUALIFIED_CLASS_NAME:
				return FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT == null ? figureQualifiedClassName != null : !FIGURE_QUALIFIED_CLASS_NAME_EDEFAULT.equals(figureQualifiedClassName);
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__SOURCE:
				return source != null;
			case GMFGenPackage.DECORATED_CONNECTION_VIEWMAP__TARGET:
				return target != null;
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
		result.append(" (figureQualifiedClassName: ");
		result.append(figureQualifiedClassName);
		result.append(')');
		return result.toString();
	}

} //DecoratedConnectionViewmapImpl
