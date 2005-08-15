/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests;

import java.util.Calendar;
import java.util.Collections;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author artem
 *
 */
public class Utils {

	/**
	 * Create in-memory genmodel for provided (in-memory) domain model
	 * @param aModel source model
	 * @return initilized genModel, ready to run code generation
	 */
	public static GenModel createGenModel(EPackage aModel, String pluginID) {
        GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
        genModel.initialize(Collections.singleton(aModel));
        GenPackage genPackage = (GenPackage) genModel.getGenPackages().get(0);
        genModel.setModelName(aModel.getName() + "Gen");
        genModel.setModelPluginID(pluginID);
        genModel.setModelDirectory("/" + pluginID + "/src/");
        genModel.setEditDirectory(genModel.getModelDirectory());
        Resource r = new ResourceSetImpl().createResource(URI.createGenericURI("uri","fake/sample.genmodel", null));
        r.getContents().add(genModel);
        
        assert genModel.eResource() != null;

        // need different prefix to avoid name collisions with code generated for domain model
        genPackage.setPrefix(aModel.getName() + "Gen");
        return genModel;
	}

	public static GenModel loadGenModel(String nsURI) {
		URI modelURI = (URI) EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(nsURI);
		Resource r = new ResourceSetImpl().getResource(modelURI, true);
		return (GenModel) r.getContents().get(0);
	}

	public static GenClass findGenClass(GenModel genModel, String className) {
		for (TreeIterator it = genModel.eAllContents(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof GenClassifier == false) {
				continue;
			}
			if (next instanceof GenClass) {
				GenClass rc = (GenClass) next;
				if (rc.getName().equals(className)) {
					return rc;
				}
			}
			it.prune();
		}
		return null;
	}

	public static GenClass findGenClass(GenModel genModel, EClass domainClass) {
		return findGenClass(genModel, domainClass.getName());
	}

	public static String createUniquePluginID() {
		Calendar c = Calendar.getInstance();
		return "sample.d" + c.get(Calendar.DAY_OF_YEAR)+ ".h" + c.get(Calendar.HOUR_OF_DAY) + ".m" + c.get(Calendar.MINUTE);
	}
}
