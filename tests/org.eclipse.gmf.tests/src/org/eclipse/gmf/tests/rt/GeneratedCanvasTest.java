/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.RTSetup;
import org.eclipse.gmf.tests.setup.RTSource;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration.ViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * @author artem
 */
public abstract class GeneratedCanvasTest extends AbstractCanvasTest {

	private Composite myParentShell;
	private RTSource myRTSource;
	private EditPart myNodeEditPartA;
	private EditPart myNodeEditPartB;
	private CompartmentEditPart myCompartmentA;
	private CompartmentEditPart myCompartmentB;

	public GeneratedCanvasTest(String name) {
		super(name);
	}

	protected GeneratorConfiguration.ViewerConfiguration createViewerConfiguration() throws Exception {
		return createViewerConfiguration(getCanvasInstance().getCanvas());
	}

	protected final RTSource getCanvasInstance() {
		if (myRTSource == null) {
			try {
				myRTSource = createCanvasInstance();
			} catch (Exception e) {
				fail(e.getMessage());
			}
		}
		return myRTSource;
	}

	protected RTSource createCanvasInstance() throws Exception {
		return new RTSetup().init(getSetup().getGenProject().getBundle(), getSetup().getGenModel());
	}

	protected void tearDown() throws Exception {
		if (myParentShell != null) {
			myParentShell.dispose();
			myParentShell = null;
		}
		super.tearDown();
	}

	protected final EditPart getNodeEditPartA() {
		if (myNodeEditPartA == null) {
			myNodeEditPartA = findEditPart(getCanvasInstance().getNodeA());
		}
		return myNodeEditPartA;
	}

	protected final EditPart getNodeEditPartB() {
		if (myNodeEditPartB == null) {
			myNodeEditPartB = findEditPart(getCanvasInstance().getNodeB());
		}
		return myNodeEditPartB;
	}
	
	protected final CompartmentEditPart getCompartmentEditPartA() {
		if (myCompartmentA == null) {
			myCompartmentA = (CompartmentEditPart)findEditPart(getCanvasInstance().getNodeACompartment());
		}
		return myCompartmentA;
	}

	protected final CompartmentEditPart getCompartmentEditPartB() {
		if (myCompartmentB == null) {
			myCompartmentB = (CompartmentEditPart)findEditPart(getCanvasInstance().getNodeBCompartment());
		}
		return myCompartmentB;
	}
	
	protected final Node getNotation(EditPart editPart) {
		return (Node) editPart.getModel();
	}
	
	protected ViewerConfiguration createViewerConfiguration(Diagram canvas) throws Exception {
		myParentShell = new Shell(SWT.NONE);
		return getSetup().getGeneratorConfiguration().createViewerConfiguration(myParentShell, getSetup(), canvas);
	}
}
