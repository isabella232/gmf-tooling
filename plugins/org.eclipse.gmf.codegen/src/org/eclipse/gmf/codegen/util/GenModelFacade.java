/*
 * Copyright (c) 2005, 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.codegen.util;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

/**
 * EMF Model facade for xpand templates.
 * 
 * Temporary solution for https://bugs.eclipse.org/bugs/show_bug.cgi?id=167615
 * 
 * @author dstadnik
 */
public class GenModelFacade {

	private GenModelFacade() {
	}

	public static String getQualifiedPackageInterfaceName(GenPackage gp) {
		return gp.getQualifiedPackageInterfaceName();
	}

	public static String getClassifierAccessorName(GenClass gc) {
		return gc.getClassifierAccessorName();
	}

	public static String getFeatureAccessorName(GenFeature gf) {
		return gf.getFeatureAccessorName();
	}
}
