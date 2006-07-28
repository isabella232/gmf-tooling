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

import java.util.Iterator;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.rt.GeneratedCanvasTest;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.RTSetup;
import org.eclipse.gmf.tests.setup.RTSource;

public abstract class DiagramTestBase extends GeneratedCanvasTest {
	private EditPart myNodeEditPartA;
	private EditPart myNodeEditPartB;

	public DiagramTestBase(String name) {
		super(name);
	}

	protected final EditPart getNodeEditPartA() {
		return myNodeEditPartA;
	}
	
	protected final EditPart getNodeEditPartB() {
		return myNodeEditPartB;
	}
	
	// TODO EditPartViewer[Source|Setup]
	protected void setUp() throws Exception {
		super.setUp();
		myNodeEditPartA = findEditPart(getCompartmentsRTSetup().getNodeA());
		myNodeEditPartB = findEditPart(getCompartmentsRTSetup().getNodeB());
	}
	
	protected RTSource createCanvasInstance() throws Exception {
		return new CompartmentsRTSetup().init(getSetup().getGenProject().getBundle(), getSetup().getGenModel());
	}

	protected final Node getNotation(EditPart editPart) {
		return (Node) editPart.getModel();
	}
	
	protected class CompartmentsRTSetup extends RTSetup {
		private Node myNotationCompartmentA;
		private Node myNotationCompartmentB;
		
		protected void initDiagramFileContents(DomainInstanceProducer instanceProducer, DiaGenSource genSource) {
			super.initDiagramFileContents(instanceProducer, genSource);
			myNotationCompartmentA = setupNotationCompartment(getNodeA(), genSource.getNodeA());
			myNotationCompartmentB = setupNotationCompartment(getNodeB(), genSource.getNodeB());
		}
		
		private Node setupNotationCompartment(Node notationParent, GenNode genParent){
			Node notationCompartment = NotationFactory.eINSTANCE.createNode();
			GenCompartment genCompartment = (GenCompartment) genParent.getCompartments().get(0);
			notationCompartment.setType(String.valueOf(genCompartment.getVisualID()));
			notationParent.getTransientChildren().add(notationCompartment);
			assertTrue(notationParent.getChildren().contains(notationCompartment));
			return notationCompartment;
		}
		
		public Node getNotationCompartmentA() {
			return myNotationCompartmentA;
		}
		
		public Node getNotationCompartmentB() {
			return myNotationCompartmentB;
		}
		
	} 
	
	protected CompartmentsRTSetup getCompartmentsRTSetup(){
		return (CompartmentsRTSetup)getCanvasInstance();
	}
	
	protected static View findChildView(View parentView, GenCommonBase childType){
		String notationType = String.valueOf(childType.getVisualID());
		for (Iterator children = parentView.getChildren().iterator(); children.hasNext();){
			View next = (View) children.next();
			if (notationType.equals(next.getType())){
				return next;
			}
		}
		return null;
	}
	
}
