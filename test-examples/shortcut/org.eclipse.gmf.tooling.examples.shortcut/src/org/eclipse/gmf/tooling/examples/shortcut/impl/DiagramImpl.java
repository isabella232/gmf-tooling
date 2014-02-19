/**
 */
package org.eclipse.gmf.tooling.examples.shortcut.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.tooling.examples.shortcut.Diagram;
import org.eclipse.gmf.tooling.examples.shortcut.DiagramLink;
import org.eclipse.gmf.tooling.examples.shortcut.DiagramNode;
import org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramImpl#getContainsShortcutsTo <em>Contains Shortcuts To</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramImpl#getShortcutsProvidedFor <em>Shortcuts Provided For</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramImpl extends MinimalEObjectImpl.Container implements Diagram {
	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramLink> links;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramNode> nodes;

	/**
	 * The cached value of the '{@link #getContainsShortcutsTo() <em>Contains Shortcuts To</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainsShortcutsTo()
	 * @generated
	 * @ordered
	 */
	protected EList<String> containsShortcutsTo;

	/**
	 * The cached value of the '{@link #getShortcutsProvidedFor() <em>Shortcuts Provided For</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortcutsProvidedFor()
	 * @generated
	 * @ordered
	 */
	protected EList<String> shortcutsProvidedFor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShortcutPackage.Literals.DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiagramLink> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<DiagramLink>(DiagramLink.class, this, ShortcutPackage.DIAGRAM__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiagramNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<DiagramNode>(DiagramNode.class, this, ShortcutPackage.DIAGRAM__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getContainsShortcutsTo() {
		if (containsShortcutsTo == null) {
			containsShortcutsTo = new EDataTypeUniqueEList<String>(String.class, this, ShortcutPackage.DIAGRAM__CONTAINS_SHORTCUTS_TO);
		}
		return containsShortcutsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getShortcutsProvidedFor() {
		if (shortcutsProvidedFor == null) {
			shortcutsProvidedFor = new EDataTypeUniqueEList<String>(String.class, this, ShortcutPackage.DIAGRAM__SHORTCUTS_PROVIDED_FOR);
		}
		return shortcutsProvidedFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ShortcutPackage.DIAGRAM__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case ShortcutPackage.DIAGRAM__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
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
			case ShortcutPackage.DIAGRAM__LINKS:
				return getLinks();
			case ShortcutPackage.DIAGRAM__NODES:
				return getNodes();
			case ShortcutPackage.DIAGRAM__CONTAINS_SHORTCUTS_TO:
				return getContainsShortcutsTo();
			case ShortcutPackage.DIAGRAM__SHORTCUTS_PROVIDED_FOR:
				return getShortcutsProvidedFor();
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
			case ShortcutPackage.DIAGRAM__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends DiagramLink>)newValue);
				return;
			case ShortcutPackage.DIAGRAM__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends DiagramNode>)newValue);
				return;
			case ShortcutPackage.DIAGRAM__CONTAINS_SHORTCUTS_TO:
				getContainsShortcutsTo().clear();
				getContainsShortcutsTo().addAll((Collection<? extends String>)newValue);
				return;
			case ShortcutPackage.DIAGRAM__SHORTCUTS_PROVIDED_FOR:
				getShortcutsProvidedFor().clear();
				getShortcutsProvidedFor().addAll((Collection<? extends String>)newValue);
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
			case ShortcutPackage.DIAGRAM__LINKS:
				getLinks().clear();
				return;
			case ShortcutPackage.DIAGRAM__NODES:
				getNodes().clear();
				return;
			case ShortcutPackage.DIAGRAM__CONTAINS_SHORTCUTS_TO:
				getContainsShortcutsTo().clear();
				return;
			case ShortcutPackage.DIAGRAM__SHORTCUTS_PROVIDED_FOR:
				getShortcutsProvidedFor().clear();
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
			case ShortcutPackage.DIAGRAM__LINKS:
				return links != null && !links.isEmpty();
			case ShortcutPackage.DIAGRAM__NODES:
				return nodes != null && !nodes.isEmpty();
			case ShortcutPackage.DIAGRAM__CONTAINS_SHORTCUTS_TO:
				return containsShortcutsTo != null && !containsShortcutsTo.isEmpty();
			case ShortcutPackage.DIAGRAM__SHORTCUTS_PROVIDED_FOR:
				return shortcutsProvidedFor != null && !shortcutsProvidedFor.isEmpty();
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
		result.append(" (containsShortcutsTo: ");
		result.append(containsShortcutsTo);
		result.append(", shortcutsProvidedFor: ");
		result.append(shortcutsProvidedFor);
		result.append(')');
		return result.toString();
	}

} //DiagramImpl
