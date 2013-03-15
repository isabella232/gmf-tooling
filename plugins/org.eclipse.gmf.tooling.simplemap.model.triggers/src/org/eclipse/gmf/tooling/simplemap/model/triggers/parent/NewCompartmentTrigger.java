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
package org.eclipse.gmf.tooling.simplemap.model.triggers.parent;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode;

class NewCompartmentTrigger extends NewElementTrigger {

	private SimpleCompartment newSimpleCompartment;

	private SimpleNode parent;

	public NewCompartmentTrigger(TransactionalEditingDomain domain, SimpleNode parent, SimpleCompartment newCompartment) {
		super(domain, newCompartment);

		this.newSimpleCompartment = newCompartment;
		this.parent = parent;
	}

	@Override
	public void executeTrigger() {

		Compartment newCompartment = GMFGraphFactory.eINSTANCE.createCompartment();

		newCompartment.setNeedsTitle(newSimpleCompartment.isNeedsTitle());

		updateCanvas(newCompartment);
		updateMapping(newCompartment);
	}

	private void updateCanvas(Compartment newCompartment) {

		//Obtenemos la figura del padre:
		FigureDescriptor parentFigureDesc = parent.getDiagramNode().getFigure();

		//Creamos el compartment:
		canvasFactory.createDefaultCompartmentWithoutLabel(parentFigureDesc, newCompartment);
		//canvasFactory.createDefaultCompartmentWithLabel(parentFigureDesc, newCompartment);
	}

	private void updateMapping(Compartment newCompartment) {
		CompartmentMapping compartmentMapping = GMFMapFactory.eINSTANCE.createCompartmentMapping();
		compartmentMapping.setCompartment(newCompartment);

		parent.getNodeReference().getChild().getCompartments().add(compartmentMapping);

		newSimpleCompartment.setCompartmentMapping(compartmentMapping);
	}

}
