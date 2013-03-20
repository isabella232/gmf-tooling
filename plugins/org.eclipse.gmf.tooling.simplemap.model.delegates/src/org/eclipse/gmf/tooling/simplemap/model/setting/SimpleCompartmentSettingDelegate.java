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
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage;

public class SimpleCompartmentSettingDelegate extends Stateless {

	public SimpleCompartmentSettingDelegate(EStructuralFeature arg0) {
		super(arg0);
	}

	@Override
	protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {

		if (eStructuralFeature.getEContainingClass() == SimplemappingsPackage.Literals.SIMPLE_COMPARTMENT) {
			switch (eStructuralFeature.getEContainingClass().getEAllStructuralFeatures().indexOf(eStructuralFeature)) {
			case SimplemappingsPackage.SIMPLE_COMPARTMENT__COMPARTMENT:
				return getCompartment((SimpleCompartment) owner);
			case SimplemappingsPackage.SIMPLE_COMPARTMENT__COMPARTMENT_LABEL:
				return getCompartmentLabel((SimpleCompartment) owner);
			case SimplemappingsPackage.SIMPLE_COMPARTMENT__NAME:
				return getCompartmentName((SimpleCompartment) owner);
			}

		}

		return null;
	}

	@Override
	protected void set(InternalEObject owner, Object newValue) {

		if (eStructuralFeature.getEContainingClass() == SimplemappingsPackage.Literals.SIMPLE_COMPARTMENT) {
			switch (eStructuralFeature.getEContainingClass().getEAllStructuralFeatures().indexOf(eStructuralFeature)) {
			case SimplemappingsPackage.SIMPLE_COMPARTMENT__NAME:
				setCompartmentName((SimpleCompartment) owner, (String) newValue);
			}

		}

	}

	private void setCompartmentName(SimpleCompartment owner, String newValue) {

		if (owner.getCompartment() == null)
			return;

		owner.getCompartment().setName(newValue);

	}

	private String getCompartmentName(SimpleCompartment owner) {

		if (owner.getCompartment() == null)
			return "";

		return owner.getCompartment().getName();
	}

	private Label getCompartmentLabel(SimpleCompartment owner) {

		Compartment canvasCompartment = getCompartment(owner);

		if (canvasCompartment != null && canvasCompartment.getAccessor() != null) {
			Figure compartmentFigure = canvasCompartment.getAccessor().getFigure();

			if (compartmentFigure instanceof RealFigure)
				for (Figure child : ((RealFigure) compartmentFigure).getChildren())
					if (child instanceof Label)
						return (Label) child;
		}

		return null;
	}

	private Compartment getCompartment(SimpleCompartment owner) {

		if (owner.getCompartmentMapping() != null)
			return owner.getCompartmentMapping().getCompartment();

		return null;
	}

	@Override
	protected boolean isSet(InternalEObject owner) {

		return false;
	}

}
