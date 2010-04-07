/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
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
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.RTSetup;
import org.eclipse.gmf.tests.setup.RTSource;
import org.eclipse.gmf.tests.setup.ViewerConfiguration;
import org.eclipse.gmf.tests.setup.ViewerConfiguration.Factory;
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
	private final Factory myViewerConfigFactory;

	public GeneratedCanvasTest(String name, ViewerConfiguration.Factory viewerConfigFactory) {
		super(name);
		myViewerConfigFactory = viewerConfigFactory;
	}

	protected ViewerConfiguration createViewerConfiguration() throws Exception {
		myParentShell = new Shell(SWT.NONE);
		return getViewerConfigurationFactory().createViewerConfiguration(myParentShell, getCanvasInstance().getCanvas(), getSetup());
	}

	protected final ViewerConfiguration.Factory getViewerConfigurationFactory() {
		return myViewerConfigFactory;
	}

	protected final RTSource getCanvasInstance() {
		if (myRTSource == null) {
			try {
				myRTSource = createCanvasInstance();
			} catch (Exception e) {
				fail(e.getClass().getName() + ": " + e.getMessage());
			}
		}
		return myRTSource;
	}

	protected RTSource createCanvasInstance() throws Exception {
		return new RTSetup().init(getSetup().getGeneratedPlugin(), getSetup().getGenModel());
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

	protected final DiaGenSource getGenModel() {
		return getSetup().getGenModel();
	}
}
