/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
import org.eclipse.gmf.gmfgraph.CustomAttribute;
import org.eclipse.gmf.gmfgraph.CustomAttributeOwner;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.Pin;
import org.eclipse.gmf.gmfgraph.PinOwner;
import org.eclipse.gmf.gmfgraph.RealFigure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Figure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.RealFigureImpl#getPins <em>Pins</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.RealFigureImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.RealFigureImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.RealFigureImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RealFigureImpl extends AbstractFigureImpl implements RealFigure {
	/**
	 * The cached value of the '{@link #getPins() <em>Pins</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPins()
	 * @generated
	 * @ordered
	 */
	protected EList<Pin> pins;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<CustomAttribute> attributes;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Figure> children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealFigureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGraphPackage.eINSTANCE.getRealFigure();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pin> getPins() {
		if (pins == null) {
			pins = new EObjectContainmentEList<Pin>(Pin.class, this, GMFGraphPackage.REAL_FIGURE__PINS);
		}
		return pins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CustomAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<CustomAttribute>(CustomAttribute.class, this, GMFGraphPackage.REAL_FIGURE__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.REAL_FIGURE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Figure> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<Figure>(Figure.class, this, GMFGraphPackage.REAL_FIGURE__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFGraphPackage.REAL_FIGURE__PINS:
				return ((InternalEList<?>)getPins()).basicRemove(otherEnd, msgs);
			case GMFGraphPackage.REAL_FIGURE__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case GMFGraphPackage.REAL_FIGURE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case GMFGraphPackage.REAL_FIGURE__PINS:
				return getPins();
			case GMFGraphPackage.REAL_FIGURE__ATTRIBUTES:
				return getAttributes();
			case GMFGraphPackage.REAL_FIGURE__NAME:
				return getName();
			case GMFGraphPackage.REAL_FIGURE__CHILDREN:
				return getChildren();
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
			case GMFGraphPackage.REAL_FIGURE__PINS:
				getPins().clear();
				getPins().addAll((Collection<? extends Pin>)newValue);
				return;
			case GMFGraphPackage.REAL_FIGURE__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends CustomAttribute>)newValue);
				return;
			case GMFGraphPackage.REAL_FIGURE__NAME:
				setName((String)newValue);
				return;
			case GMFGraphPackage.REAL_FIGURE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends Figure>)newValue);
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
			case GMFGraphPackage.REAL_FIGURE__PINS:
				getPins().clear();
				return;
			case GMFGraphPackage.REAL_FIGURE__ATTRIBUTES:
				getAttributes().clear();
				return;
			case GMFGraphPackage.REAL_FIGURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GMFGraphPackage.REAL_FIGURE__CHILDREN:
				getChildren().clear();
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
			case GMFGraphPackage.REAL_FIGURE__PINS:
				return pins != null && !pins.isEmpty();
			case GMFGraphPackage.REAL_FIGURE__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case GMFGraphPackage.REAL_FIGURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GMFGraphPackage.REAL_FIGURE__CHILDREN:
				return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == PinOwner.class) {
			switch (derivedFeatureID) {
				case GMFGraphPackage.REAL_FIGURE__PINS: return GMFGraphPackage.PIN_OWNER__PINS;
				default: return -1;
			}
		}
		if (baseClass == CustomAttributeOwner.class) {
			switch (derivedFeatureID) {
				case GMFGraphPackage.REAL_FIGURE__ATTRIBUTES: return GMFGraphPackage.CUSTOM_ATTRIBUTE_OWNER__ATTRIBUTES;
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
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == PinOwner.class) {
			switch (baseFeatureID) {
				case GMFGraphPackage.PIN_OWNER__PINS: return GMFGraphPackage.REAL_FIGURE__PINS;
				default: return -1;
			}
		}
		if (baseClass == CustomAttributeOwner.class) {
			switch (baseFeatureID) {
				case GMFGraphPackage.CUSTOM_ATTRIBUTE_OWNER__ATTRIBUTES: return GMFGraphPackage.REAL_FIGURE__ATTRIBUTES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //RealFigureImpl
