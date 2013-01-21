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
package org.eclipse.gmf.tooling.simplemap.model.setting;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicSettingDelegate.Stateless;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage;

public class SimpleMappingSettingDelegate extends Stateless {

	public SimpleMappingSettingDelegate(EStructuralFeature arg0) {
		super(arg0);
	}

	@Override
	protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {

		if (eStructuralFeature.getEContainingClass() == SimplemappingsPackage.Literals.SIMPLE_MAPPING) {
			switch (eStructuralFeature.getEContainingClass().getEAllStructuralFeatures().indexOf(eStructuralFeature)) {
			case SimplemappingsPackage.SIMPLE_MAPPING__DOMAIN_MODEL:
				return getDomainModel((SimpleMapping) owner);
			case SimplemappingsPackage.SIMPLE_MAPPING__DOMAIN_META_ELEMENT:
				return getDomainMetaElement((SimpleMapping) owner);
			}

		}

		return null;
	}

	private Object getDomainMetaElement(SimpleMapping owner) {
		return owner.getMapping().getDiagram().getDomainMetaElement();

	}

	private Object getDomainModel(SimpleMapping owner) {
		return owner.getMapping().getDiagram().getDomainModel();
	}

	@Override
	protected boolean isSet(InternalEObject owner) {

		return false;
	}

}
