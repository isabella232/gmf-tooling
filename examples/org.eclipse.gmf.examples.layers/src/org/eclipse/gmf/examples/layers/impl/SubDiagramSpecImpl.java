/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.layers.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.examples.layers.Layer;
import org.eclipse.gmf.examples.layers.LayerEnablement;
import org.eclipse.gmf.examples.layers.LayersPackage;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Diagram Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.layers.impl.SubDiagramSpecImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.layers.impl.SubDiagramSpecImpl#isShowing <em>Showing</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.layers.impl.SubDiagramSpecImpl#getDiagramLayers <em>Diagram Layers</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.layers.impl.SubDiagramSpecImpl#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubDiagramSpecImpl extends EObjectImpl implements SubDiagramSpec {

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
	 * The default value of the '{@link #isShowing() <em>Showing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOWING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isShowing() <em>Showing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowing()
	 * @generated
	 * @ordered
	 */
	protected boolean showing = SHOWING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDiagramLayers() <em>Diagram Layers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramLayers()
	 * @generated
	 * @ordered
	 */
	protected EList<LayerEnablement> diagramLayers;

	/**
	 * The cached value of the '{@link #getDiagram() <em>Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram diagram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubDiagramSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.SUB_DIAGRAM_SPEC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.SUB_DIAGRAM_SPEC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShowing() {
		return showing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowing(boolean newShowing) {
		boolean oldShowing = showing;
		showing = newShowing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.SUB_DIAGRAM_SPEC__SHOWING, oldShowing, showing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LayerEnablement> getDiagramLayers() {
		if (diagramLayers == null) {
			diagramLayers = new EObjectContainmentEList<LayerEnablement>(LayerEnablement.class, this, LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM_LAYERS);
		}
		return diagramLayers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getDiagram() {
		if (diagram != null && diagram.eIsProxy()) {
			InternalEObject oldDiagram = (InternalEObject)diagram;
			diagram = (Diagram)eResolveProxy(oldDiagram);
			if (diagram != oldDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM, oldDiagram, diagram));
			}
		}
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram basicGetDiagram() {
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagram(Diagram newDiagram) {
		Diagram oldDiagram = diagram;
		diagram = newDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM, oldDiagram, diagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LayerEnablement findLayerEnablement(Layer layer) {
		if (layer == null) {
			return null;
		}
		for (LayerEnablement next : getDiagramLayers()) {
			if (next.getLayer() == layer) {
				return next;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM_LAYERS:
				return ((InternalEList<?>)getDiagramLayers()).basicRemove(otherEnd, msgs);
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
			case LayersPackage.SUB_DIAGRAM_SPEC__NAME:
				return getName();
			case LayersPackage.SUB_DIAGRAM_SPEC__SHOWING:
				return isShowing();
			case LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM_LAYERS:
				return getDiagramLayers();
			case LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM:
				if (resolve) return getDiagram();
				return basicGetDiagram();
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
			case LayersPackage.SUB_DIAGRAM_SPEC__NAME:
				setName((String)newValue);
				return;
			case LayersPackage.SUB_DIAGRAM_SPEC__SHOWING:
				setShowing((Boolean)newValue);
				return;
			case LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM_LAYERS:
				getDiagramLayers().clear();
				getDiagramLayers().addAll((Collection<? extends LayerEnablement>)newValue);
				return;
			case LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM:
				setDiagram((Diagram)newValue);
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
			case LayersPackage.SUB_DIAGRAM_SPEC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LayersPackage.SUB_DIAGRAM_SPEC__SHOWING:
				setShowing(SHOWING_EDEFAULT);
				return;
			case LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM_LAYERS:
				getDiagramLayers().clear();
				return;
			case LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM:
				setDiagram((Diagram)null);
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
			case LayersPackage.SUB_DIAGRAM_SPEC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LayersPackage.SUB_DIAGRAM_SPEC__SHOWING:
				return showing != SHOWING_EDEFAULT;
			case LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM_LAYERS:
				return diagramLayers != null && !diagramLayers.isEmpty();
			case LayersPackage.SUB_DIAGRAM_SPEC__DIAGRAM:
				return diagram != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", showing: ");
		result.append(showing);
		result.append(')');
		return result.toString();
	}

} //SubDiagramSpecImpl
