/**
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import java.util.Iterator;

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
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration.ViewerConfiguration;
import org.osgi.framework.Bundle;

/**
 * Provides default operations like creating nodes and links. The responsibility of creation of ViewerConfiguration is left to subclasses.
 */
public abstract class AbstractCanvasTest extends ConfiguredTestCase {
	private GeneratorConfiguration.ViewerConfiguration myViewerConfiguration;
	private Bundle myGenProject;

	public AbstractCanvasTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		myGenProject = getSetup().getGenProject().getBundle();
	}

	protected void tearDown() throws Exception {
		myViewerConfiguration = null;
		super.tearDown();
	}

	protected final EditPart findEditPart(View notationElement) {
		return getViewerConfiguration().findEditPart(notationElement);
	}
	
	protected final EditPart getDiagramEditPart() {
		return getViewerConfiguration().getViewer().getContents();
	}

	protected final Diagram getDiagram() {
		return (Diagram) getDiagramEditPart().getModel();
	}
	
	protected void setViewerConfiguration(ViewerConfiguration configuration) {
		myViewerConfiguration = configuration;
	}

	public ViewerConfiguration getViewerConfiguration() {
		if (myViewerConfiguration == null) {
			try {
				myViewerConfiguration = createViewerConfiguration();
			} catch (Exception e) {
				fail(e.getMessage());
			}
			assertNotNull("No viewer configuration", myViewerConfiguration);
		}
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

	protected static View findChildView(View parentView, GenCommonBase childType){
		String notationType = String.valueOf(childType.getVisualID());
		for (Iterator<?> children = parentView.getChildren().iterator(); children.hasNext();){
			View next = (View) children.next();
			if (notationType.equals(next.getType())){
				return next;
			}
		}
		return null;
	}

	protected final Class<?> loadGeneratedClass(String qualifiedClassName) throws ClassNotFoundException {
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
		return getViewerConfiguration().getViewer().getEditDomain().getCommandStack();
	}

	protected abstract GeneratorConfiguration.ViewerConfiguration createViewerConfiguration() throws Exception;
}
