/**
 * Copyright (c) 2007 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.codegen.util;

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EClassifier;

public class GenModelUtils {
	
	public static final String getGetAccessor(GenFeature feature) {
		return feature.getGetAccessor();
	}
	
	public static final GenClassifier findGenClassifier(GenModel genModel, EClassifier eClassifier) {
		return genModel.findGenClassifier(eClassifier);
	}

}
