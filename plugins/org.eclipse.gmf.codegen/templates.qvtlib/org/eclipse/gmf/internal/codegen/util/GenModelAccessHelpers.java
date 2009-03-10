/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.util;

import java.io.IOException;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

/**
 * Logic comes from org.eclipse.gmf.internal.bridge.genmodel.BasicGenModelAccess, with few handy methods 
 * to access well-known genmodels
 * @author artem
 */
public class GenModelAccessHelpers {

	private ResourceSet myDefaultSet;

	@Operation(contextual = false, kind = Kind.HELPER)
	public GenModel loadGenModel(String nsURI) {
		return loadGenModel(nsURI, null);
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public GenModel loadGenModel(String nsURI, EObject context) {
		ResourceSet rs = getResourceSet(context);
		URI genModelFromExtPoint = EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(nsURI);
		if (genModelFromExtPoint != null) {
			return (GenModel) rs.getEObject(genModelFromExtPoint.appendFragment("/"), true); //$NON-NLS-1$
		}
		// try to guess .genmodel file location based on .ecore file location (if any)
		EPackage ecoreModel = rs.getPackageRegistry().getEPackage(nsURI);
		if (ecoreModel != null && ecoreModel.eResource() != null && ecoreModel.eResource().getURI() != null) {
			URI ecoreModelURI = ecoreModel.eResource().getURI();
			if (!ecoreModelURI.equals(nsURI)) { // owning resource points to some real stream
				// alternative: ecoreModelURI.isFile() || ecoreModelURI.isPlatform() || ecoreModelURI.isArchive()
				// e.g. smth we can try to access as a file
				URI genModelURI = ecoreModelURI.trimFileExtension().appendFileExtension("genmodel");
				if (!genModelURI.equals(ecoreModelURI)) {
					Resource genModelRes = rs.getResource(genModelURI, false);
					try {
						genModelRes.load(rs.getLoadOptions());
						if (genModelRes.getContents().size() > 0) {
							return (GenModel) genModelRes.getContents().get(0);
						}
					} catch (IOException ex) {
						// IGNORE
					}
				}
				// else FALLTHROUGH
			}
		}
		// final attempt - try nsURI as if it was file URI (e.g. platform:/plugin/...)
		URI genModelUri = URI.createURI(nsURI);
		return (GenModel) rs.getEObject(genModelUri.appendFragment("/"), true); //$NON-NLS-1$
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public GenModel loadEcoreGenModel() {
		return loadEcoreGenModel(null);
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public GenModel loadEcoreGenModel(EObject context) {
		URI genModelUri = URI.createURI("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.genmodel#/"); //$NON-NLS-1$
		return (GenModel) getResourceSet(context).getEObject(genModelUri, true);
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public GenModel loadNotationGenModel() {
		return loadNotationGenModel(null);
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public GenModel loadNotationGenModel(EObject context) {
		URI genModelUri = URI.createURI("platform:/plugin/org.eclipse.gmf.runtime.notation/model/notation.genmodel#/"); //$NON-NLS-1$		
		return (GenModel) getResourceSet(context).getEObject(genModelUri, true);
	}

	private ResourceSet getResourceSet(EObject context) {
		if (context == null || context.eResource() == null || context.eResource().getResourceSet() == null) {
			if (myDefaultSet == null) {
				myDefaultSet = new ResourceSetImpl();
			}
			return myDefaultSet;
		}
		return context.eResource().getResourceSet();
	}
}
