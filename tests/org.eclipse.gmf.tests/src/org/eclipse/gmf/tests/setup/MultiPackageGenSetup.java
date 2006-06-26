/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import java.util.Collection;

import junit.framework.Assert;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.internal.bridge.genmodel.BasicGenModelAccess;

/**
 * @author artem
 */
public class MultiPackageGenSetup extends DiaGenSetup {

	private final Collection myDomainPackages;

	public MultiPackageGenSetup(Collection domainPackages) {
		myDomainPackages = domainPackages;
	}

	protected GenModel initGenModel(EPackage domainModel) {
		BasicGenModelAccess gma = new BasicGenModelAccess(domainModel);
		IStatus gmaStatus = gma.createDummy(true, myDomainPackages);
		Assert.assertTrue("Need (fake) genModel for transformation to work", gmaStatus.isOK());
		return gma.model();
	}
}
