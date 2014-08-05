/**
 */
package org.eclipse.gmf.tooling.examples.linklabels.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmf.tooling.examples.linklabels.CanvasElement;
import org.eclipse.gmf.tooling.examples.linklabels.LabeledLink;
import org.eclipse.gmf.tooling.examples.linklabels.LinklabelsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Labeled Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklabels.impl.LabeledLinkImpl#getSemanticLabel <em>Semantic Label</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklabels.impl.LabeledLinkImpl#getFixedLabel <em>Fixed Label</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklabels.impl.LabeledLinkImpl#getOclLabel <em>Ocl Label</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklabels.impl.LabeledLinkImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklabels.impl.LabeledLinkImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LabeledLinkImpl extends CanvasElementImpl implements LabeledLink {
	/**
	 * The default value of the '{@link #getSemanticLabel() <em>Semantic Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemanticLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String SEMANTIC_LABEL_EDEFAULT = "Semantic";

	/**
	 * The cached value of the '{@link #getSemanticLabel() <em>Semantic Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemanticLabel()
	 * @generated
	 * @ordered
	 */
	protected String semanticLabel = SEMANTIC_LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getFixedLabel() <em>Fixed Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String FIXED_LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFixedLabel() <em>Fixed Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedLabel()
	 * @generated
	 * @ordered
	 */
	protected String fixedLabel = FIXED_LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getOclLabel() <em>Ocl Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String OCL_LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOclLabel() <em>Ocl Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclLabel()
	 * @generated
	 * @ordered
	 */
	protected String oclLabel = OCL_LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected CanvasElement source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected CanvasElement target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabeledLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LinklabelsPackage.Literals.LABELED_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemanticLabel() {
		return semanticLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticLabel(String newSemanticLabel) {
		String oldSemanticLabel = semanticLabel;
		semanticLabel = newSemanticLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinklabelsPackage.LABELED_LINK__SEMANTIC_LABEL, oldSemanticLabel, semanticLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFixedLabel() {
		return fixedLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedLabel(String newFixedLabel) {
		String oldFixedLabel = fixedLabel;
		fixedLabel = newFixedLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinklabelsPackage.LABELED_LINK__FIXED_LABEL, oldFixedLabel, fixedLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOclLabel() {
		return oclLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclLabel(String newOclLabel) {
		String oldOclLabel = oclLabel;
		oclLabel = newOclLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinklabelsPackage.LABELED_LINK__OCL_LABEL, oldOclLabel, oclLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CanvasElement getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (CanvasElement)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LinklabelsPackage.LABELED_LINK__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CanvasElement basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(CanvasElement newSource) {
		CanvasElement oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinklabelsPackage.LABELED_LINK__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CanvasElement getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (CanvasElement)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LinklabelsPackage.LABELED_LINK__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CanvasElement basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(CanvasElement newTarget) {
		CanvasElement oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinklabelsPackage.LABELED_LINK__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LinklabelsPackage.LABELED_LINK__SEMANTIC_LABEL:
				return getSemanticLabel();
			case LinklabelsPackage.LABELED_LINK__FIXED_LABEL:
				return getFixedLabel();
			case LinklabelsPackage.LABELED_LINK__OCL_LABEL:
				return getOclLabel();
			case LinklabelsPackage.LABELED_LINK__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case LinklabelsPackage.LABELED_LINK__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case LinklabelsPackage.LABELED_LINK__SEMANTIC_LABEL:
				setSemanticLabel((String)newValue);
				return;
			case LinklabelsPackage.LABELED_LINK__FIXED_LABEL:
				setFixedLabel((String)newValue);
				return;
			case LinklabelsPackage.LABELED_LINK__OCL_LABEL:
				setOclLabel((String)newValue);
				return;
			case LinklabelsPackage.LABELED_LINK__SOURCE:
				setSource((CanvasElement)newValue);
				return;
			case LinklabelsPackage.LABELED_LINK__TARGET:
				setTarget((CanvasElement)newValue);
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
			case LinklabelsPackage.LABELED_LINK__SEMANTIC_LABEL:
				setSemanticLabel(SEMANTIC_LABEL_EDEFAULT);
				return;
			case LinklabelsPackage.LABELED_LINK__FIXED_LABEL:
				setFixedLabel(FIXED_LABEL_EDEFAULT);
				return;
			case LinklabelsPackage.LABELED_LINK__OCL_LABEL:
				setOclLabel(OCL_LABEL_EDEFAULT);
				return;
			case LinklabelsPackage.LABELED_LINK__SOURCE:
				setSource((CanvasElement)null);
				return;
			case LinklabelsPackage.LABELED_LINK__TARGET:
				setTarget((CanvasElement)null);
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
			case LinklabelsPackage.LABELED_LINK__SEMANTIC_LABEL:
				return SEMANTIC_LABEL_EDEFAULT == null ? semanticLabel != null : !SEMANTIC_LABEL_EDEFAULT.equals(semanticLabel);
			case LinklabelsPackage.LABELED_LINK__FIXED_LABEL:
				return FIXED_LABEL_EDEFAULT == null ? fixedLabel != null : !FIXED_LABEL_EDEFAULT.equals(fixedLabel);
			case LinklabelsPackage.LABELED_LINK__OCL_LABEL:
				return OCL_LABEL_EDEFAULT == null ? oclLabel != null : !OCL_LABEL_EDEFAULT.equals(oclLabel);
			case LinklabelsPackage.LABELED_LINK__SOURCE:
				return source != null;
			case LinklabelsPackage.LABELED_LINK__TARGET:
				return target != null;
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
		result.append(" (semanticLabel: ");
		result.append(semanticLabel);
		result.append(", fixedLabel: ");
		result.append(fixedLabel);
		result.append(", oclLabel: ");
		result.append(oclLabel);
		result.append(')');
		return result.toString();
	}

} //LabeledLinkImpl
