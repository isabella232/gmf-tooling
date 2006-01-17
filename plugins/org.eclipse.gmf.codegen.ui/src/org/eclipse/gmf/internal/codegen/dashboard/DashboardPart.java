/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    dstadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.dashboard;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

/**
 * @author dstadnik
 */
public class DashboardPart extends ViewPart {

	private FigureCanvas canvas;

	private ISelectionListener projectUpdater;

	private Map states;

	public void init(IViewSite site, IMemento memento) throws PartInitException {
		super.init(site, memento);
		states = DashboardPersistence.read(memento);
	}

	public void createPartControl(Composite parent) {
		canvas = new FigureCanvas(parent);
		DashboardFigure contents = new DashboardFigure(parent.getShell());
		canvas.setContents(contents);
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(projectUpdater = new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				updateActiveProject(selection);
			}
		});
		updateActiveProject(getSite().getWorkbenchWindow().getSelectionService().getSelection());
	}

	public void saveState(IMemento memento) {
		super.saveState(memento);
		if (canvas != null) {
			DashboardFigure contents = getDashboardFigure();
			if (contents.getProject() != null) {
				states.put(contents.getProject(), contents.getState());
			}
		}
		DashboardPersistence.write(memento, states);
	}

	public void dispose() {
		if (projectUpdater != null) {
			getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(projectUpdater);
			projectUpdater = null;
		}
		super.dispose();
	}

	public void setFocus() {
		if (canvas != null) {
			canvas.setFocus();
		}
	}

	protected DashboardFigure getDashboardFigure() {
		return (DashboardFigure) canvas.getContents();
	}

	protected void updateActiveProject(ISelection selection) {
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}
		DashboardFigure contents = getDashboardFigure();
		IProject activeProject = null;
		for (Iterator it = ((IStructuredSelection) selection).iterator(); it.hasNext();) {
			Object element = (Object) it.next();
			IProject project = null;
			if (element instanceof IResource) {
				project = ((IResource) element).getProject();
			} else if (element instanceof IAdaptable) {
				IResource resource = (IResource) ((IAdaptable) element).getAdapter(IResource.class);
				if (resource != null) {
					project = resource.getProject();
				}
			}
			if (project == null) {
				continue;
			}
			if (project.equals(contents.getProject())) {
				// if current active project is selected do not change it
				return;
			}
			if (activeProject == null) {
				// new active project is the first selected project
				activeProject = project;
			}
		}
		if (activeProject != null) {
			if (contents.getProject() != null) {
				states.put(contents.getProject(), contents.getState());
			}
			contents.setProjectAndState(activeProject, (DashboardState) states.get(activeProject));
		}
	}
}
