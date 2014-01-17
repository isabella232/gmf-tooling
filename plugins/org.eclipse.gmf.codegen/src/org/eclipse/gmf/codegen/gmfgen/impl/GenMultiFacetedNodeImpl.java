/**
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenMultiFacetedNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeNodeModelFacet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Multi Faceted Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenMultiFacetedNodeImpl#getDiagram <em>Diagram</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenMultiFacetedNodeImpl#getAdditionalModelFacets <em>Additional Model Facets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenMultiFacetedNodeImpl extends 
GenChildNodeBaseImpl implements GenMultiFacetedNode {
	/**
	 * The cached value of the '{@link #getAdditionalModelFacets() <em>Additional Model Facets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalModelFacets()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeNodeModelFacet> additionalModelFacets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenMultiFacetedNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getGenMultiFacetedNode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDiagram getDiagram() {
		if (eContainerFeatureID() != GMFGenPackage.GEN_MULTI_FACETED_NODE__DIAGRAM) return null;
		return (GenDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeNodeModelFacet> getAdditionalModelFacets() {
		if (additionalModelFacets == null) {
			additionalModelFacets = new EObjectContainmentWithInverseEList<TypeNodeModelFacet>(TypeNodeModelFacet.class, this, GMFGenPackage.GEN_MULTI_FACETED_NODE__ADDITIONAL_MODEL_FACETS, GMFGenPackage.TYPE_NODE_MODEL_FACET__MULTI_FACETED_NODE);
		}
		return additionalModelFacets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TypeModelFacet> allModelFacets() {
		BasicEList<TypeModelFacet> result = new BasicEList<TypeModelFacet>();
		if (getModelFacet() != null) {
			result.add(getModelFacet());
		}
		result.addAll(getAdditionalModelFacets());
		return new BasicEList.UnmodifiableEList<TypeModelFacet>(result.size(), result.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeNodeModelFacet findFacetForContainer(GenChildContainer container) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeModelFacet findFacetForContainerOrDiagram(GenContainerBase container) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFGenPackage.GEN_MULTI_FACETED_NODE__DIAGRAM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, GMFGenPackage.GEN_MULTI_FACETED_NODE__DIAGRAM, msgs);
			case GMFGenPackage.GEN_MULTI_FACETED_NODE__ADDITIONAL_MODEL_FACETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAdditionalModelFacets()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFGenPackage.GEN_MULTI_FACETED_NODE__DIAGRAM:
				return eBasicSetContainer(null, GMFGenPackage.GEN_MULTI_FACETED_NODE__DIAGRAM, msgs);
			case GMFGenPackage.GEN_MULTI_FACETED_NODE__ADDITIONAL_MODEL_FACETS:
				return ((InternalEList<?>)getAdditionalModelFacets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GMFGenPackage.GEN_MULTI_FACETED_NODE__DIAGRAM:
				return eInternalContainer().eInverseRemove(this, GMFGenPackage.GEN_DIAGRAM__MULTI_FACETED_NODES, GenDiagram.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGenPackage.GEN_MULTI_FACETED_NODE__DIAGRAM:
				return getDiagram();
			case GMFGenPackage.GEN_MULTI_FACETED_NODE__ADDITIONAL_MODEL_FACETS:
				return getAdditionalModelFacets();
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
			case GMFGenPackage.GEN_MULTI_FACETED_NODE__ADDITIONAL_MODEL_FACETS:
				getAdditionalModelFacets().clear();
				getAdditionalModelFacets().addAll((Collection<? extends TypeNodeModelFacet>)newValue);
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
			case GMFGenPackage.GEN_MULTI_FACETED_NODE__ADDITIONAL_MODEL_FACETS:
				getAdditionalModelFacets().clear();
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
			case GMFGenPackage.GEN_MULTI_FACETED_NODE__DIAGRAM:
				return getDiagram() != null;
			case GMFGenPackage.GEN_MULTI_FACETED_NODE__ADDITIONAL_MODEL_FACETS:
				return additionalModelFacets != null && !additionalModelFacets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GenMultiFacetedNodeImpl
