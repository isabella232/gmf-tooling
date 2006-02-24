/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenRuleContainerBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Rule Container Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenRuleContainerBaseImpl#getEditor <em>Editor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GenRuleContainerBaseImpl extends EObjectImpl implements GenRuleContainerBase {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenRuleContainerBaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getGenRuleContainerBase();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenEditorGenerator getEditor() {
		GenEditorGenerator editor = basicGetEditor();
		return editor != null && editor.eIsProxy() ? (GenEditorGenerator)eResolveProxy((InternalEObject)editor) : editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public GenEditorGenerator basicGetEditor() {
		for (EObject parent = this; parent != null; parent = parent.eContainer())
			if (GMFGenPackage.eINSTANCE.getGenEditorGenerator().isSuperTypeOf(parent.eClass()))
				return (GenEditorGenerator) parent;
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGenPackage.GEN_RULE_CONTAINER_BASE__EDITOR:
				if (resolve) return getEditor();
				return basicGetEditor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GMFGenPackage.GEN_RULE_CONTAINER_BASE__EDITOR:
				return basicGetEditor() != null;
		}
		return super.eIsSet(featureID);
	}

} //GenRuleContainerBaseImpl
