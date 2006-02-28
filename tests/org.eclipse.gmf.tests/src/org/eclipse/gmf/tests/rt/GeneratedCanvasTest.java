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

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.GraphicsSource;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.gmf.tests.setup.RTSetup;
import org.eclipse.gmf.tests.setup.RTSource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

/**
 * @author artem
 */
public abstract class GeneratedCanvasTest extends ConfiguredTestCase {

	private EditPartViewer myViewer;
	private Composite myParentShell;
	private Bundle myGenProject;
	private RTSource myRTSource;

	public GeneratedCanvasTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		myGenProject = getSetup().getGenProject().getBundle();
		String epFactoryClassName = getSetup().getGenModel().getGenDiagram().getEditPartFactoryQualifiedClassName();
		Class epFactory = loadGeneratedClass(epFactoryClassName);
		assert EditPartFactory.class.isAssignableFrom(epFactory);
		myViewer = createViewer();
		myViewer.setEditPartFactory((EditPartFactory) epFactory.newInstance());

		myRTSource = createCanvasInstance();
		myViewer.setContents(myRTSource.getCanvas());
	}

	protected final RTSource getCanvasInstance() {
		return myRTSource;
	}

	protected RTSource createCanvasInstance() throws Exception {
		return new RTSetup().init(getSetup().getGenProject().getBundle(), getSetup().getGenModel());
	}

	protected final EditPart getDiagramEditPart() {
		return myViewer.getContents();
	}

	protected void tearDown() throws Exception {
		if (myParentShell != null) {
			myParentShell.dispose();
			myParentShell = null;
		}
		super.tearDown();
	}

	protected final EditPart findEditPart(View notationElement) {
		return (EditPart) myViewer.getEditPartRegistry().get(notationElement);
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
		return myViewer.getEditDomain().getCommandStack();
	}

	private EditPartViewer createViewer() {
		// make sure there's display for current thread
		Display.getDefault();
	
		FakeViewer gv = new FakeViewer();
		myParentShell = new Shell(SWT.NONE);
		gv.createControl(myParentShell);
		DiagramEditDomain ded = new DiagramEditDomain(null);
		gv.setEditDomain(ded);
		gv.getEditDomain().setCommandStack(new DiagramCommandStack(ded));
		return gv;
	}


	private static final class FakeViewer extends GraphicalViewerImpl implements IDiagramGraphicalViewer{
		
		private FakeViewer() {
			/*
			 * When extends DiagramGraphicalViewer, don't forget to 
			 * super.hookWorkspacePreferenceStore(new PreferenceStore());
			 */
		}

		public void setContents(Object contents) {
			GraphicalEditPart epart = (GraphicalEditPart)getEditPartFactory().createEditPart(null, contents);
			DiagramEventBroker.startListening(epart.getEditingDomain());
			super.setContents(epart);
		}
		
		protected LightweightSystem createLightweightSystem() {
			final UpdateManager NO_MANAGER = new UpdateManager() {
				public void addDirtyRegion(IFigure figure, int x, int y, int w, int h) {}
				public void addInvalidFigure(IFigure figure) {}
				public void performUpdate() {}
				public void performUpdate(Rectangle exposed) {}
				public void setGraphicsSource(GraphicsSource gs) {}
				public void setRoot(IFigure figure) {}
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
