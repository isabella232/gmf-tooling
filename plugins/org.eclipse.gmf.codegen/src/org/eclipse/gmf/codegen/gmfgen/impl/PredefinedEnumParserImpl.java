/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.PredefinedEnumParser;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predefined Enum Parser</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PredefinedEnumParserImpl extends GenParserImplementationImpl implements PredefinedEnumParser {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredefinedEnumParserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getPredefinedEnumParser();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedClassName() {
		final String className = "EnumParser";
		final String packageName = "org.eclipse.gmf.tooling.runtime.parsers";
		return packageName + '.' + className;
	}

} //PredefinedEnumParserImpl
