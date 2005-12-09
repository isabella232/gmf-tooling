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

import java.util.Collections;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.draw2d.GraphicsSource;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.GenProjectSetup;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;
import org.eclipse.gmf.tests.setup.RTSetup;
import org.eclipse.gmf.tests.setup.RTSource;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

/**
 * Unit testcase base class with support for runtime-diagram editing.
 */
public abstract class RuntimeDiagramTestBase extends ConfiguredTestCase {
	protected Bundle gmfEditorBundle;
	protected EditPart myDiagramEditPart;
	protected EditPartViewer myViewer;
	protected Composite myParentShell;

	protected RuntimeDiagramTestBase(String name) {
		super(name);
	}

	protected EditPart getDiagramEditPart() {
		return myDiagramEditPart;
	}

	protected Diagram getDiagram() {
		return myDiagramEditPart != null ? (Diagram) myDiagramEditPart.getModel() : null;
	}

	protected DiaGenSource getGenModel() {
		return getSetup().getGenModel();
	}

	protected SessionSetup createDefaultSetup() {
		return LinksSessionSetup.newInstance();
	}

	protected void setUp() throws Exception {
		super.setUp();

		assertNotNull("GenDiagram not initialized", getGenModel().getGenDiagram()); //$NON-NLS-1$

		GenProjectSetup genProject = new GenProjectSetup();
		genProject.init(SessionSetup.getRuntimeWorkspaceSetup(), getGenModel());

		this.gmfEditorBundle = genProject.getBundle();
		assertNotNull("GMF editor plugin bundle not initialized", gmfEditorBundle); //$NON-NLS-1$

		String epFactoryClassName = getGenModel().getGenDiagram().getEditPartFactoryQualifiedClassName();
		Class epFactory = this.gmfEditorBundle.loadClass(epFactoryClassName);

		assert EditPartFactory.class.isAssignableFrom(epFactory);
		myViewer = createViewer();
		myViewer.setEditPartFactory((EditPartFactory) epFactory.newInstance());

		RTSource rtDiagram = new RTSetup().init(this.gmfEditorBundle, getGenModel());

		myViewer.setContents(rtDiagram.getCanvas());
		myDiagramEditPart = (EditPart) myViewer.getEditPartRegistry().get(rtDiagram.getCanvas());
	}

	protected void tearDown() throws Exception {
		if (myParentShell != null) {
			myParentShell.dispose();
			myParentShell = null;
		}
		super.tearDown();
	}

	protected EditPart findEditPart(View notationElement) {
		return (EditPart) myViewer.getEditPartRegistry().get(notationElement);
	}

	protected Node createNode(IMetamodelType metamodelType, View notationContainer) {
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
		notationContainer.eAdapters().add(adapter);

		try {
			CreateViewAndElementRequest req = new CreateViewAndElementRequest(metamodelType, notationContainer, PreferencesHint.USE_DEFAULTS);
			Command cmd = findEditPart(notationContainer).getCommand(req);
			Assert.assertNotNull("No command is available for request", cmd); //$NON-NLS-1$		
			cmd.execute();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Node creation failure: " + e.getLocalizedMessage()); //$NON-NLS-1$			
		} finally {
			notationContainer.eAdapters().remove(adapter);
		}
		return newObjHolder[0] instanceof Node ? (Node) newObjHolder[0] : null;
	}

	protected boolean canStartLinkFrom(IMetamodelType metamodelType, View source) {
		CreateRelationshipRequest req = new CreateRelationshipRequest(source.getElement(), null, metamodelType);
		EditCommandRequestWrapper wrapper = new EditCommandRequestWrapper(req);
		Command cmd = findEditPart(source).getCommand(wrapper);
		return cmd != null && cmd.canExecute();
	}

	protected Edge createLink(IMetamodelType metamodelType, View source, View target) {
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
			CreateRelationshipRequest relationShipReq = new CreateRelationshipRequest(metamodelType);
			relationShipReq.setSource(source.getElement());
			if (target != null) {
				relationShipReq.setTarget(target.getElement());
			}

			ConnectionViewAndElementDescriptor desc = new ConnectionViewAndElementDescriptor(new CreateElementRequestAdapter(relationShipReq), PreferencesHint.USE_DEFAULTS);

			CreateConnectionViewAndElementRequest req = new CreateConnectionViewAndElementRequest(desc);
			req.setType(RequestConstants.REQ_CONNECTION_START);

			EditPart sourceEditPart = findEditPart(source);
			req.setSourceEditPart(sourceEditPart);
			// Note: initializes the sourceCommand in the request
			Command sourceCmd = sourceEditPart.getCommand(req);
			if (sourceCmd == null || !sourceCmd.canExecute()) {
				return null;
			}

			EditPart targetEditPart = target != null ? findEditPart(target) : null;
			if (targetEditPart != null) {
				req.setType(RequestConstants.REQ_CONNECTION_END);
				req.setTargetEditPart(targetEditPart);
				req.setLocation(new Point(0, 0));
				sourceEditPart.getCommand(req);
				Command targetCmd = targetEditPart.getCommand(req);
				if (targetCmd == null || !targetCmd.canExecute()) {
					return null;
				}
				targetCmd.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Edge creation failure: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			diagram.eAdapters().remove(adapter);
		}
		return newObjHolder[0] instanceof Edge ? (Edge) newObjHolder[0] : null;
	}

	private EditPartViewer createViewer() {
		Viewer gv = new Viewer();
		myParentShell = new Shell(SWT.NONE);
		gv.createControl(myParentShell);
		DiagramEditDomain ded = new DiagramEditDomain(null);
		gv.setEditDomain(ded);
		gv.getEditDomain().setCommandStack(new DiagramCommandStack(ded));
		return gv;
	}

	protected IMetamodelType getElementType(GenCommonBase genElement) {
		Class clazz = null;
		try {
			clazz = gmfEditorBundle.loadClass(getGenModel().getGenDiagram().getElementTypesQualifiedClassName());
		} catch (Exception e) {
			e.printStackTrace();
			fail("ElementTypes class not loaded. " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		String identifier = genElement.getUniqueIdentifier();
		try {
			Object type = clazz.getField(identifier).get(null);
			assert type instanceof IMetamodelType : IMetamodelType.class.getName() + ": metamodel type class required"; //$NON-NLS-1$ 
			return (IMetamodelType) type;
		} catch (NoSuchFieldException e) {
			fail("Metamodel type " + identifier + " is not registered"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (Exception e) {
			e.printStackTrace();
			fail("Can't access metamodel type " + identifier); //$NON-NLS-1$			
		}

		return null;
	}

	private static final class Viewer extends DiagramGraphicalViewer implements IDiagramGraphicalViewer {
		private Viewer() {
		}

		protected void createDefaultRoot() {
			setRootEditPart(new DiagramRootEditPart());
		}

		protected LightweightSystem createLightweightSystem() {
			final UpdateManager NO_MANAGER = new UpdateManager() {
				public void addDirtyRegion(IFigure figure, int x, int y, int w, int h) {
				}

				public void addInvalidFigure(IFigure figure) {
				}

				public void performUpdate() {
				}

				public void performUpdate(Rectangle exposed) {
				}

				public void setGraphicsSource(GraphicsSource gs) {
				}

				public void setRoot(IFigure figure) {
				}
			};

			return new LightweightSystem() {
				{
					setUpdateManager(NO_MANAGER);
				}

				public UpdateManager getUpdateManager() {
					return NO_MANAGER;
				}
			};
		}

		public IDiagramEditDomain getDiagramEditDomain() {
			return (IDiagramEditDomain) super.getEditDomain();
		}

		public List findEditPartsForElement(String elementIdStr, Class editPartClass) {
			return Collections.EMPTY_LIST;
		}

		public void registerEditPartForElement(String elementIdStr, EditPart ep) {
		}

		public void unregisterEditPartForElement(String elementIdStr, EditPart ep) {
		}
	}
}
