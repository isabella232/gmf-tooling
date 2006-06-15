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

import junit.framework.Assert;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.gmf.tests.setup.RTSetup;
import org.eclipse.gmf.tests.setup.RTSource;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration.ViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

/**
 * @author artem
 */
public abstract class GeneratedCanvasTest extends ConfiguredTestCase {

	private ViewerConfiguration myViewerConfiguration;
	private Composite myParentShell;
	private Bundle myGenProject;
	private RTSource myRTSource;

	public GeneratedCanvasTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		myGenProject = getSetup().getGenProject().getBundle();
		myRTSource = createCanvasInstance();
		myViewerConfiguration = createViewerConfiguration(myRTSource.getCanvas());
	}

	protected final RTSource getCanvasInstance() {
		return myRTSource;
	}

	protected RTSource createCanvasInstance() throws Exception {
		return new RTSetup().init(getSetup().getGenProject().getBundle(), getSetup().getGenModel());
	}

	protected final EditPart getDiagramEditPart() {
		return myViewerConfiguration.getViewer().getContents();
	}

	public ViewerConfiguration getViewerConfiguration() {
		return myViewerConfiguration;
	}
	
	protected Node createNode(GenCommonBase nodeType, View notationContainer) {
		final Object[] newObjHolder = new Object[1];

		Adapter adapter = new AdapterImpl() {
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				if (msg.getEventType() == Notification.ADD) {
					newObjHolder[0] = msg.getNewValue();
				}
			}

			public boolean isAdapterForType(Object type) {
				return true;
			}
		};
		Command cmd = getViewerConfiguration().getCreateNodeCommand(notationContainer, nodeType);
		Assert.assertNotNull("No command is available for request", cmd); //$NON-NLS-1$		
		notationContainer.eAdapters().add(adapter);
		try {
			execute(cmd);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Node creation failure: " + e.getLocalizedMessage()); //$NON-NLS-1$			
		} finally {
			notationContainer.eAdapters().remove(adapter);
		}
		assertTrue("Faile to create notation model Node", newObjHolder[0] instanceof Node); //$NON-NLS-1$
		return (Node) newObjHolder[0];
	}
	
	protected Edge createLink(GenLink linkType, View source, View target) {
		final Object[] newObjHolder = new Object[1];

		Adapter adapter = new AdapterImpl() {
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				if (msg.getEventType() == Notification.ADD && msg.getNewValue() instanceof Edge) {
					newObjHolder[0] = msg.getNewValue();
				}
			}

			public boolean isAdapterForType(Object type) {
				return true;
			}
		};
		Diagram diagram = getDiagram();
		diagram.eAdapters().add(adapter);
		try {
			Command targetCmd = getViewerConfiguration().getCreateLinkCommand(source, target, linkType);
			if (targetCmd == null || !targetCmd.canExecute()) {
				return null;
			}
			execute(targetCmd);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Edge creation failure: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			diagram.eAdapters().remove(adapter);
		}
		assertTrue("Faile to create notation model Edge", newObjHolder[0] instanceof Edge); //$NON-NLS-1$		
		return (Edge) newObjHolder[0];
	}

	protected Diagram getDiagram() {
		return (Diagram) getDiagramEditPart().getModel();
	}

	protected void tearDown() throws Exception {
		if (myParentShell != null) {
			myParentShell.dispose();
			myParentShell = null;
			myViewerConfiguration.dispose();
		}
		super.tearDown();
	}

	protected final EditPart findEditPart(View notationElement) {
		return myViewerConfiguration.findEditPart(notationElement);
	}

	protected final Class loadGeneratedClass(String qualifiedClassName) throws ClassNotFoundException {
		return myGenProject.loadClass(qualifiedClassName);
	}

	/**
	 * Use this instead of simple cmd.execute()
	 * @param cmd
	 */
	protected final void execute(Command cmd) {
		getCommandStack().execute(cmd);
	}

	protected final CommandStack getCommandStack() {
		return myViewerConfiguration.getViewer().getEditDomain().getCommandStack();
	}

	protected ViewerConfiguration createViewerConfiguration(Diagram canvas) throws Exception {
		myParentShell = new Shell(SWT.NONE);
		return getSetup().getGeneratorConfiguration().createViewerConfiguration(myParentShell, getSetup(), canvas);
	}
}
