/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import junit.framework.Assert;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;

/**
 * Unit testcase base class with support for runtime-diagram editing. Expects LinksSessionSetup.
 */
public abstract class RuntimeDiagramTestBase extends GeneratedCanvasTest {

	protected RuntimeDiagramTestBase(String name) {
		super(name);
	}

	protected Diagram getDiagram() {
		return (Diagram) getDiagramEditPart().getModel();
	}

	protected DiaGenSource getGenModel() {
		return getSetup().getGenModel();
	}

	protected SessionSetup createDefaultSetup() {
		return LinksSessionSetup.newInstance();
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
		return newObjHolder[0] instanceof Node ? (Node) newObjHolder[0] : null;
	}

	protected boolean canStartLinkFrom(GenLink linkType, View source) {
		Command cmd = getViewerConfiguration().getStartLinkCommand(source, linkType);
		return cmd != null && cmd.canExecute();
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
		return newObjHolder[0] instanceof Edge ? (Edge) newObjHolder[0] : null;
	}

	/**
	 * Sets structural feature value of the business element associated with the
	 * given notation element.
	 * 
	 * @param view
	 *            the notation element encapsulating the bussiness object
	 *            containing the feature to be modified
	 * @param featureName
	 *            the name of the structural feature to set.
	 * @param value
	 *            the value to set
	 * @throws IllegalArgumentException
	 *             if the given name does not refer existing feature
	 */
	protected void setBusinessElementStructuralFeature(View view, String featureName, Object value) {
		Command command = getViewerConfiguration().getSetBusinessElementStructuralFeatureCommand(view, featureName, value);
		assertNotNull("Command is null", command);
		command.execute();
	}
}
