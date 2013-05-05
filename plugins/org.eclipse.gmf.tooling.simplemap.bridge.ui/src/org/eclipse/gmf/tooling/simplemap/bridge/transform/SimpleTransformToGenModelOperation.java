/**
 * Copyright (c) 2010-2012 ISBAN S.L
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 		Ruben De Dios (ISBAN S.L)
 * 		Andrez Alvarez Mattos (ISBAN S.L)
 */
package org.eclipse.gmf.tooling.simplemap.bridge.transform;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.internal.bridge.transform.TransformToGenModelOperation;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMapping;

public class SimpleTransformToGenModelOperation extends TransformToGenModelOperation {

	public SimpleTransformToGenModelOperation(ResourceSet rs) {
		super(rs);
	}

	@Override
	protected Mapping findMappingFromMappingModelRoot(EObject mappingModelRoot) {
		return mappingModelRoot instanceof SimpleMapping ? ((SimpleMapping) mappingModelRoot).getMapping() : null;
	}

}
