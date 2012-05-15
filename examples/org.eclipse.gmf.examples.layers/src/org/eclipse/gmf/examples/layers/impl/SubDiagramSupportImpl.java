/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.layers.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.examples.layers.Layer;
import org.eclipse.gmf.examples.layers.LayerEnablement;
import org.eclipse.gmf.examples.layers.LayersFactory;
import org.eclipse.gmf.examples.layers.LayersPackage;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.examples.layers.SubDiagramSupport;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Diagram Support</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.layers.impl.SubDiagramSupportImpl#getLayers <em>Layers</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.layers.impl.SubDiagramSupportImpl#getMainDiagram <em>Main Diagram</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.layers.impl.SubDiagramSupportImpl#getSubDiagrams <em>Sub Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubDiagramSupportImpl extends EObjectImpl implements SubDiagramSupport {

	/**
	 * The cached value of the '{@link #getLayers() <em>Layers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayers()
	 * @generated
	 * @ordered
	 */
	protected EList<Layer> layers;

	/**
	 * The cached value of the '{@link #getMainDiagram() <em>Main Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainDiagram()
	 * @generated
	 * @ordered
	 */
	protected SubDiagramSpec mainDiagram;

	/**
	 * The cached value of the '{@link #getSubDiagrams() <em>Sub Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<SubDiagramSpec> subDiagrams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubDiagramSupportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.SUB_DIAGRAM_SUPPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Layer> getLayers() {
		if (layers == null) {
			layers = new EObjectContainmentEList<Layer>(Layer.class, this, LayersPackage.SUB_DIAGRAM_SUPPORT__LAYERS);
		}
		return layers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubDiagramSpec getMainDiagram() {
		return mainDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMainDiagram(SubDiagramSpec newMainDiagram, NotificationChain msgs) {
		SubDiagramSpec oldMainDiagram = mainDiagram;
		mainDiagram = newMainDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayersPackage.SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM, oldMainDiagram, newMainDiagram);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainDiagram(SubDiagramSpec newMainDiagram) {
		if (newMainDiagram != mainDiagram) {
			NotificationChain msgs = null;
			if (mainDiagram != null)
				msgs = ((InternalEObject)mainDiagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayersPackage.SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM, null, msgs);
			if (newMainDiagram != null)
				msgs = ((InternalEObject)newMainDiagram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayersPackage.SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM, null, msgs);
			msgs = basicSetMainDiagram(newMainDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM, newMainDiagram, newMainDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubDiagramSpec> getSubDiagrams() {
		if (subDiagrams == null) {
			subDiagrams = new EObjectContainmentEList<SubDiagramSpec>(SubDiagramSpec.class, this, LayersPackage.SUB_DIAGRAM_SUPPORT__SUB_DIAGRAMS);
		}
		return subDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<SubDiagramSpec> getAllDiagrams() {
		BasicEList<SubDiagramSpec> result = new BasicEList<SubDiagramSpec>();
		if (getMainDiagram() != null){
			result.add(getMainDiagram());
		}
		result.addAll(getSubDiagrams());
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SubDiagramSpec findDiagramSpec(Diagram diagram) {
		if (diagram == null) {
			return null;
		}
		if (getMainDiagram() != null && getMainDiagram().getDiagram() == diagram) {
			return getMainDiagram();
		}
		for (SubDiagramSpec next : getSubDiagrams()) {
			if (next.getDiagram() == diagram) {
				return next;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void ensureAllSubDiagramsHaveEnablementForAllLayers() {
		List<SubDiagramSpec> allDiagrams = new ArrayList<SubDiagramSpec>(getSubDiagrams().size() + 1);
		if (getMainDiagram() != null) {
			allDiagrams.add(getMainDiagram());
		}
		allDiagrams.addAll(getSubDiagrams());

		for (Layer nextLayer : getLayers()) {
			for (SubDiagramSpec nextDiagram : allDiagrams) {
				LayerEnablement enablement = nextDiagram.findLayerEnablement(nextLayer);
				if (enablement == null) {
					enablement = LayersFactory.eINSTANCE.createLayerEnablement();
					enablement.setLayer(nextLayer);
					enablement.setVisible(false);
					nextDiagram.getDiagramLayers().add(enablement);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.SUB_DIAGRAM_SUPPORT__LAYERS:
				return ((InternalEList<?>)getLayers()).basicRemove(otherEnd, msgs);
			case LayersPackage.SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM:
				return basicSetMainDiagram(null, msgs);
			case LayersPackage.SUB_DIAGRAM_SUPPORT__SUB_DIAGRAMS:
				return ((InternalEList<?>)getSubDiagrams()).basicRemove(otherEnd, msgs);
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
			case LayersPackage.SUB_DIAGRAM_SUPPORT__LAYERS:
				return getLayers();
			case LayersPackage.SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM:
				return getMainDiagram();
			case LayersPackage.SUB_DIAGRAM_SUPPORT__SUB_DIAGRAMS:
				return getSubDiagrams();
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
			case LayersPackage.SUB_DIAGRAM_SUPPORT__LAYERS:
				getLayers().clear();
				getLayers().addAll((Collection<? extends Layer>)newValue);
				return;
			case LayersPackage.SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM:
				setMainDiagram((SubDiagramSpec)newValue);
				return;
			case LayersPackage.SUB_DIAGRAM_SUPPORT__SUB_DIAGRAMS:
				getSubDiagrams().clear();
				getSubDiagrams().addAll((Collection<? extends SubDiagramSpec>)newValue);
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
			case LayersPackage.SUB_DIAGRAM_SUPPORT__LAYERS:
				getLayers().clear();
				return;
			case LayersPackage.SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM:
				setMainDiagram((SubDiagramSpec)null);
				return;
			case LayersPackage.SUB_DIAGRAM_SUPPORT__SUB_DIAGRAMS:
				getSubDiagrams().clear();
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
			case LayersPackage.SUB_DIAGRAM_SUPPORT__LAYERS:
				return layers != null && !layers.isEmpty();
			case LayersPackage.SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM:
				return mainDiagram != null;
			case LayersPackage.SUB_DIAGRAM_SUPPORT__SUB_DIAGRAMS:
				return subDiagrams != null && !subDiagrams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SubDiagramSupportImpl
