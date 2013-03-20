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
package org.eclipse.gmf.tooling.simplemap.model.edit.properties;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.gmf.tooling.simplemap.model.edit.IItemPropertyDescriptorProvider;
import org.eclipse.gmf.tooling.simplemap.simplemappings.util.SimplemappingsAdapterFactory;

public class SimpleMappingPropertiesAdapterFactory extends SimplemappingsAdapterFactory {

	private static Adapter simpleNodeProvider = new SimpleNodeItemPropertyDescriptorProvider();

	@Override
	public Adapter createSimpleTopNodeAdapter() {
		return simpleNodeProvider;
	}

	@Override
	public Adapter createSimpleNodeAdapter() {
		return simpleNodeProvider;
	}

	@Override
	public Adapter createSimpleLabelNodeAdapter() {
		return simpleNodeProvider;
	}

	@Override
	public Adapter createSimpleSubNodeAdapter() {
		return simpleNodeProvider;
	}

	@Override
	public Adapter createSimpleChildReferenceAdapter() {
		return simpleNodeProvider;
	}

	@Override
	public boolean isFactoryForType(Object object) {
		return object == IItemPropertyDescriptorProvider.class;
	}

	@Override
	public Adapter createSimpleMappingAdapter() {
		return simpleNodeProvider;
	}

}
