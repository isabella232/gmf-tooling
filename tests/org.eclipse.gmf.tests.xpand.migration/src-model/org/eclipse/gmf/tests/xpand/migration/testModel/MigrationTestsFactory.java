/**
 * Copyright (c) 2008, 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *
 * $Id$
 */
package org.eclipse.gmf.tests.xpand.migration.testModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage
 * @generated
 */
public interface MigrationTestsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MigrationTestsFactory eINSTANCE = org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container</em>'.
	 * @generated
	 */
	Container createContainer();

	/**
	 * Returns a new object of class '<em>Child</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child</em>'.
	 * @generated
	 */
	Child createChild();

	/**
	 * Returns a new object of class '<em>Sub Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Container</em>'.
	 * @generated
	 */
	SubContainer createSubContainer();

	/**
	 * Returns a new object of class '<em>Default Attribute Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Attribute Container</em>'.
	 * @generated
	 */
	DefaultAttributeContainer createDefaultAttributeContainer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MigrationTestsPackage getMigrationTestsPackage();

} //MigrationTestsFactory
