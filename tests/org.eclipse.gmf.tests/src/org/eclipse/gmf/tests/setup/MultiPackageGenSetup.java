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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.internal.bridge.genmodel.BasicGenModelAccess;

/**
 * @author artem
 */
public class MultiPackageGenSetup extends DiaGenSetup {

	private final Collection<EPackage> myDomainPackages;

	public MultiPackageGenSetup(Collection<EPackage> domainPackages) {
		myDomainPackages = domainPackages;
	}

	protected GenModel initGenModel(EPackage domainModel) {
		HashSet<EPackage> allPacks = new HashSet<EPackage>(myDomainPackages);
		// TODO override method in crossReferencer to get only EClasses
		Map m = EcoreUtil.ExternalCrossReferencer.find(domainModel);
		for (Iterator it = m.keySet().iterator(); it.hasNext(); ) {
			Object next = it.next();
			if (next instanceof EClass) {
				allPacks.add(((EClass) next).getEPackage());
			}
		}
		BasicGenModelAccess gma = new BasicGenModelAccess(domainModel);
		IStatus gmaStatus = gma.createDummy(allPacks);
		Assert.assertTrue("Need (fake) genModel for transformation to work", gmaStatus.isOK());
		return gma.model();
	}
}
