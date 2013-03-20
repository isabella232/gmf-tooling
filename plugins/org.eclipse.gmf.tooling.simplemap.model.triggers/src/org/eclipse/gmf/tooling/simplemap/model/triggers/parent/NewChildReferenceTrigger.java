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
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildReference;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleParentNode;

public class NewChildReferenceTrigger extends NewElementTrigger {

	private SimpleParentNode parent;

	private SimpleChildReference newSimpleChildReference;

	public NewChildReferenceTrigger(TransactionalEditingDomain domain, SimpleParentNode parent, SimpleChildReference newSimpleChildReference) {
		super(domain, newSimpleChildReference);

		this.newSimpleChildReference = newSimpleChildReference;
		this.parent = parent;
	}

	@Override
	public void executeTrigger() {

		if (parent instanceof SimpleNode)
			updateMapping((SimpleNode) parent);

		if (parent instanceof SimpleCompartment) {
			SimpleNode parentNode = (SimpleNode) ((SimpleCompartment) parent).getParent();
			updateMapping(parentNode, ((SimpleCompartment) parent).getCompartmentMapping());
		}

	}

	/**
	 * El padre es un Top Node
	 * @param parentTopNode
	 * @param newNode
	 * @param newLabel
	 * @param newCreationTool
	 */
	private void updateMapping(SimpleNode parentNode) {
		updateMapping(parentNode, null);
	}

	/**
	 * El padre es un Compartment
	 * @param newLabel
	 * @param newCreationTool
	 */
	private void updateMapping(SimpleNode parentNode, CompartmentMapping compartment) {
		ChildReference newChildReference = GMFMapFactory.eINSTANCE.createChildReference();

		if (compartment != null)
			newChildReference.setCompartment(compartment);

		parentNode.getNodeReference().getChild().getChildren().add(newChildReference);

		newSimpleChildReference.setNodeReference(newChildReference);

	}

}
