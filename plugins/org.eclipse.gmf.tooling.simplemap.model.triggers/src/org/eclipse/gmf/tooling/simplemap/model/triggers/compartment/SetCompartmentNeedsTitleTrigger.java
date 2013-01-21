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
package org.eclipse.gmf.tooling.simplemap.model.triggers.compartment;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.tooling.simplemap.model.triggers.AbstractTrigger;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment;

class SetCompartmentNeedsTitleTrigger extends AbstractTrigger {

	private SimpleCompartment simpleCompartment;

	private boolean needsTitle;

	public SetCompartmentNeedsTitleTrigger(TransactionalEditingDomain domain, SimpleCompartment compartment, boolean needsTitle) {
		super(domain);

		this.simpleCompartment = compartment;
		this.needsTitle = needsTitle;
	}

	@Override
	public void executeTrigger() {

		updateCanvas();
	}

	private void updateCanvas() {

		Compartment canvasCompartment = simpleCompartment.getCompartment();

		if (canvasCompartment != null)
			canvasCompartment.setNeedsTitle(needsTitle);

	}

}
