/**
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.TypeNodeModelFacet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Node Model Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.TypeNodeModelFacetImpl#getCreateCommandClassName <em>Create Command Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeNodeModelFacetImpl extends TypeModelFacetImpl implements TypeNodeModelFacet {
	/**
	 * The default value of the '{@link #getCreateCommandClassName() <em>Create Command Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateCommandClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATE_COMMAND_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreateCommandClassName() <em>Create Command Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateCommandClassName()
	 * @generated
	 * @ordered
	 */
	protected String createCommandClassName = CREATE_COMMAND_CLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeNodeModelFacetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getTypeNodeModelFacet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateCommandClassName() {
		return createCommandClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateCommandClassName(String newCreateCommandClassName) {
		String oldCreateCommandClassName = createCommandClassName;
		createCommandClassName = newCreateCommandClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.TYPE_NODE_MODEL_FACET__CREATE_COMMAND_CLASS_NAME, oldCreateCommandClassName, createCommandClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateCommandQualifiedClassName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGenPackage.TYPE_NODE_MODEL_FACET__CREATE_COMMAND_CLASS_NAME:
				return getCreateCommandClassName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GMFGenPackage.TYPE_NODE_MODEL_FACET__CREATE_COMMAND_CLASS_NAME:
				setCreateCommandClassName((String)newValue);
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
			case GMFGenPackage.TYPE_NODE_MODEL_FACET__CREATE_COMMAND_CLASS_NAME:
				setCreateCommandClassName(CREATE_COMMAND_CLASS_NAME_EDEFAULT);
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
			case GMFGenPackage.TYPE_NODE_MODEL_FACET__CREATE_COMMAND_CLASS_NAME:
				return CREATE_COMMAND_CLASS_NAME_EDEFAULT == null ? createCommandClassName != null : !CREATE_COMMAND_CLASS_NAME_EDEFAULT.equals(createCommandClassName);
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
		result.append(" (createCommandClassName: ");
		result.append(createCommandClassName);
		result.append(')');
		return result.toString();
	}

} //TypeNodeModelFacetImpl
