/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.gmfgraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.gmfgraph.ColorStyle;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.PolylineDecoration;
import org.eclipse.gmf.gmfgraph.SizeStyle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Polyline Decoration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PolylineDecorationImpl extends PolylineImpl implements PolylineDecoration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolylineDecorationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGraphPackage.eINSTANCE.getPolylineDecoration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFGraphPackage.POLYLINE_DECORATION__PARENT:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, GMFGraphPackage.POLYLINE_DECORATION__PARENT, msgs);
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
				case GMFGraphPackage.POLYLINE_DECORATION__CHILDREN:
					return ((InternalEList)getChildren()).basicRemove(otherEnd, msgs);
				case GMFGraphPackage.POLYLINE_DECORATION__PARENT:
					return eBasicSetContainer(null, GMFGraphPackage.POLYLINE_DECORATION__PARENT, msgs);
				case GMFGraphPackage.POLYLINE_DECORATION__COLOR_STYLE:
					return basicSetColorStyle(null, msgs);
				case GMFGraphPackage.POLYLINE_DECORATION__SIZE_STYLE:
					return basicSetSizeStyle(null, msgs);
				case GMFGraphPackage.POLYLINE_DECORATION__FONT_STYLE:
					return basicSetFontStyle(null, msgs);
				case GMFGraphPackage.POLYLINE_DECORATION__LOCATION:
					return basicSetLocation(null, msgs);
				case GMFGraphPackage.POLYLINE_DECORATION__SIZE:
					return basicSetSize(null, msgs);
				case GMFGraphPackage.POLYLINE_DECORATION__TEMPLATE:
					return ((InternalEList)getTemplate()).basicRemove(otherEnd, msgs);
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
				case GMFGraphPackage.POLYLINE_DECORATION__PARENT:
					return eContainer.eInverseRemove(this, GMFGraphPackage.FIGURE__CHILDREN, Figure.class, msgs);
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
			case GMFGraphPackage.POLYLINE_DECORATION__NAME:
				return getName();
			case GMFGraphPackage.POLYLINE_DECORATION__CHILDREN:
				return getChildren();
			case GMFGraphPackage.POLYLINE_DECORATION__PARENT:
				return getParent();
			case GMFGraphPackage.POLYLINE_DECORATION__COLOR_STYLE:
				return getColorStyle();
			case GMFGraphPackage.POLYLINE_DECORATION__SIZE_STYLE:
				return getSizeStyle();
			case GMFGraphPackage.POLYLINE_DECORATION__FONT_STYLE:
				return getFontStyle();
			case GMFGraphPackage.POLYLINE_DECORATION__LOCATION:
				return getLocation();
			case GMFGraphPackage.POLYLINE_DECORATION__SIZE:
				return getSize();
			case GMFGraphPackage.POLYLINE_DECORATION__LAYOUT_MANAGER:
				return getLayoutManager();
			case GMFGraphPackage.POLYLINE_DECORATION__OUTLINE:
				return isOutline() ? Boolean.TRUE : Boolean.FALSE;
			case GMFGraphPackage.POLYLINE_DECORATION__FILL:
				return isFill() ? Boolean.TRUE : Boolean.FALSE;
			case GMFGraphPackage.POLYLINE_DECORATION__LINE_WIDTH:
				return new Integer(getLineWidth());
			case GMFGraphPackage.POLYLINE_DECORATION__LINE_KIND:
				return getLineKind();
			case GMFGraphPackage.POLYLINE_DECORATION__XOR_FILL:
				return isXorFill() ? Boolean.TRUE : Boolean.FALSE;
			case GMFGraphPackage.POLYLINE_DECORATION__XOR_OUTLINE:
				return isXorOutline() ? Boolean.TRUE : Boolean.FALSE;
			case GMFGraphPackage.POLYLINE_DECORATION__RESOLVED_CHILDREN:
				return getResolvedChildren();
			case GMFGraphPackage.POLYLINE_DECORATION__TEMPLATE:
				return getTemplate();
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
			case GMFGraphPackage.POLYLINE_DECORATION__NAME:
				setName((String)newValue);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection)newValue);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__COLOR_STYLE:
				setColorStyle((ColorStyle)newValue);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__SIZE_STYLE:
				setSizeStyle((SizeStyle)newValue);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__FONT_STYLE:
				setFontStyle((FontStyle)newValue);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__LOCATION:
				setLocation((Point)newValue);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__SIZE:
				setSize((Point)newValue);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__LAYOUT_MANAGER:
				setLayoutManager((String)newValue);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__OUTLINE:
				setOutline(((Boolean)newValue).booleanValue());
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__FILL:
				setFill(((Boolean)newValue).booleanValue());
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__LINE_WIDTH:
				setLineWidth(((Integer)newValue).intValue());
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__LINE_KIND:
				setLineKind((LineKind)newValue);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__XOR_FILL:
				setXorFill(((Boolean)newValue).booleanValue());
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__XOR_OUTLINE:
				setXorOutline(((Boolean)newValue).booleanValue());
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__TEMPLATE:
				getTemplate().clear();
				getTemplate().addAll((Collection)newValue);
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
			case GMFGraphPackage.POLYLINE_DECORATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__CHILDREN:
				getChildren().clear();
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__COLOR_STYLE:
				setColorStyle((ColorStyle)null);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__SIZE_STYLE:
				setSizeStyle((SizeStyle)null);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__FONT_STYLE:
				setFontStyle((FontStyle)null);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__LOCATION:
				setLocation((Point)null);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__SIZE:
				setSize((Point)null);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__LAYOUT_MANAGER:
				setLayoutManager(LAYOUT_MANAGER_EDEFAULT);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__OUTLINE:
				setOutline(OUTLINE_EDEFAULT);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__FILL:
				setFill(FILL_EDEFAULT);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__LINE_WIDTH:
				setLineWidth(LINE_WIDTH_EDEFAULT);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__LINE_KIND:
				setLineKind(LINE_KIND_EDEFAULT);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__XOR_FILL:
				setXorFill(XOR_FILL_EDEFAULT);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__XOR_OUTLINE:
				setXorOutline(XOR_OUTLINE_EDEFAULT);
				return;
			case GMFGraphPackage.POLYLINE_DECORATION__TEMPLATE:
				getTemplate().clear();
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
			case GMFGraphPackage.POLYLINE_DECORATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GMFGraphPackage.POLYLINE_DECORATION__CHILDREN:
				return children != null && !children.isEmpty();
			case GMFGraphPackage.POLYLINE_DECORATION__PARENT:
				return getParent() != null;
			case GMFGraphPackage.POLYLINE_DECORATION__COLOR_STYLE:
				return colorStyle != null;
			case GMFGraphPackage.POLYLINE_DECORATION__SIZE_STYLE:
				return sizeStyle != null;
			case GMFGraphPackage.POLYLINE_DECORATION__FONT_STYLE:
				return fontStyle != null;
			case GMFGraphPackage.POLYLINE_DECORATION__LOCATION:
				return location != null;
			case GMFGraphPackage.POLYLINE_DECORATION__SIZE:
				return size != null;
			case GMFGraphPackage.POLYLINE_DECORATION__LAYOUT_MANAGER:
				return LAYOUT_MANAGER_EDEFAULT == null ? layoutManager != null : !LAYOUT_MANAGER_EDEFAULT.equals(layoutManager);
			case GMFGraphPackage.POLYLINE_DECORATION__OUTLINE:
				return outline != OUTLINE_EDEFAULT;
			case GMFGraphPackage.POLYLINE_DECORATION__FILL:
				return fill != FILL_EDEFAULT;
			case GMFGraphPackage.POLYLINE_DECORATION__LINE_WIDTH:
				return lineWidth != LINE_WIDTH_EDEFAULT;
			case GMFGraphPackage.POLYLINE_DECORATION__LINE_KIND:
				return lineKind != LINE_KIND_EDEFAULT;
			case GMFGraphPackage.POLYLINE_DECORATION__XOR_FILL:
				return xorFill != XOR_FILL_EDEFAULT;
			case GMFGraphPackage.POLYLINE_DECORATION__XOR_OUTLINE:
				return xorOutline != XOR_OUTLINE_EDEFAULT;
			case GMFGraphPackage.POLYLINE_DECORATION__RESOLVED_CHILDREN:
				return !getResolvedChildren().isEmpty();
			case GMFGraphPackage.POLYLINE_DECORATION__TEMPLATE:
				return template != null && !template.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //PolylineDecorationImpl
