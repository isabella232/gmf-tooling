/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.gmf.tests.setup.ViewerConfiguration;

/**
 * Provides default operations like creating nodes and links. 
 * The responsibility of creation of ViewerConfiguration is left to subclasses.
 * 
 * Despite the fact it extends ConfiguredTestCase, it doesn't utilize session configs,
 * instead, its subclasses do ({@link GeneratedCanvasTest}).
 */
public abstract class AbstractCanvasTest extends ConfiguredTestCase {
	private ViewerConfiguration myViewerConfiguration;

	public AbstractCanvasTest(String name) {
		super(name);
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
	
	public ViewerConfiguration getViewerConfiguration() {
		if (myViewerConfiguration == null) {
			try {
				myViewerConfiguration = createViewerConfiguration();
			} catch (Exception e) {
				fail(e.getClass().getName() + ": " + e.getMessage());
			}
			assertNotNull("No viewer configuration", myViewerConfiguration);
		}
		return myViewerConfiguration;
	}

	protected Node createTopNode(GenCommonBase nodeType) {
		return createNode(nodeType, getDiagram());
	}

	protected Node createNode(GenCommonBase nodeType, View notationContainer) {
 		CreateListener createListener = new CreateListener(NotationPackage.eINSTANCE.getView());
		Command cmd = getViewerConfiguration().getCreateNodeCommand(notationContainer, nodeType);
		Assert.assertNotNull("No command is available for request", cmd); //$NON-NLS-1$		
		notationContainer.eAdapters().add(createListener);
		try {
			execute(cmd);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Node creation failure: " + e.getLocalizedMessage()); //$NON-NLS-1$			
		} finally {
			notationContainer.eAdapters().remove(createListener);
		}
		assertTrue("Failed to create notation model Node", createListener.getCreatedChild() instanceof Node); //$NON-NLS-1$
		Node createdNode = (Node) createListener.getCreatedChild();
		assertTrue("Node was not created", createdNode.eContainer() == notationContainer);
		assertEquals("Incorrect node type used", String.valueOf(nodeType.getVisualID()), createdNode.getType());
		return createdNode;
	}
	
	protected Edge createLink(GenLink linkType, View source, View target) {
 		CreateListener createListener = new CreateListener(NotationPackage.eINSTANCE.getEdge());
		Diagram diagram = getDiagram();
		diagram.eAdapters().add(createListener);
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
			diagram.eAdapters().remove(createListener);
		}
		assertTrue("Failed to create notation model Edge", createListener.getCreatedChild() instanceof Edge); //$NON-NLS-1$		
		return (Edge) createListener.getCreatedChild();
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

	protected abstract ViewerConfiguration createViewerConfiguration() throws Exception;

	protected static class CreateListener extends AdapterImpl {
		private EObject myCreatedChild;
		private EClass myChildClass;
		public CreateListener(EClass expectedChildClass) {
			myChildClass = expectedChildClass;
		}
		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			if (msg.getEventType() != Notification.ADD) {
				return;
			}
			if (myCreatedChild != null) {
				return;
			}
			if (myChildClass != null && myChildClass.isInstance(msg.getNewValue())) {
				myCreatedChild = (EObject) msg.getNewValue();
			}
		}
		public boolean isAdapterForType(Object type) {
			return true;
		}
		public EObject getCreatedChild() {
			return myCreatedChild;
		}
	}
}
