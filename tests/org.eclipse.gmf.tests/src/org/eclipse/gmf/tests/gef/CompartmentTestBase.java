/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.gmf.tests.gef;

import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;

public abstract class CompartmentTestBase extends DiagramTestBase {
	private CompartmentEditPart myCompartmentA;
	private CompartmentEditPart myCompartmentB;
	
	public CompartmentTestBase(String name) {
		super(name);
	}

	protected final CompartmentEditPart getCompartmentEditPartA(){
		return myCompartmentA;
	}
	
	protected final CompartmentEditPart getCompartmentEditPartB(){
		return myCompartmentB;
	}
	
	protected final GenCompartment getGenCompartment(GenNode genNode){
		return (GenCompartment)genNode.getCompartments().get(0);
	}

	// TODO EditPartViewer[Source|Setup]
	protected void setUp() throws Exception {
		super.setUp();
		myCompartmentA = (CompartmentEditPart)findEditPart(getCompartmentsRTSetup().getNotationCompartmentA());
		myCompartmentB = (CompartmentEditPart)findEditPart(getCompartmentsRTSetup().getNotationCompartmentB());
	}
	
}
