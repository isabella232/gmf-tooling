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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.gmf.internal.codegen.CodeGenUIPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
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

	private static final String ACTIVE_PROJECT_KEY = "activeProject";

	private static final String SYNC_SELECTION_KEY = "syncSelection";

	private FigureCanvas canvas;

	private DashboardMediator mediator;

	private ISelectionListener projectUpdater;

	private Map states;

	private String activeProjectName;

	private boolean syncSelection = true;

	public void init(IViewSite site, IMemento memento) throws PartInitException {
		super.init(site, memento);
		if (memento == null) {
			states = new HashMap();
		} else {
			states = DashboardPersistence.read(memento);
			activeProjectName = memento.getString(ACTIVE_PROJECT_KEY);
			String syncSelectionValue = memento.getString(SYNC_SELECTION_KEY);
			if (syncSelectionValue != null) {
				syncSelection = Boolean.valueOf(syncSelectionValue).booleanValue();
			}
		}
		IAction syncSelectionAction = new Action("Synchronize", IAction.AS_CHECK_BOX) {
		};
		syncSelectionAction.setToolTipText("Synchronize with workbench selection");
		ImageDescriptor synchImage = CodeGenUIPlugin.getDefault().getImageRegistry().getDescriptor(CodeGenUIPlugin.SYNC_IMAGE);
		if (synchImage != null) {
			syncSelectionAction.setImageDescriptor(synchImage);
		}
		syncSelectionAction.setChecked(syncSelection);
		syncSelectionAction.addPropertyChangeListener(new IPropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent event) {
				if (IAction.CHECKED.equals(event.getProperty())) {
					syncSelection = ((Boolean) event.getNewValue()).booleanValue();
					if (syncSelection) {
						updateActiveProject(getSite().getWorkbenchWindow().getSelectionService().getSelection());
					}
				}
			}
		});
		site.getActionBars().getToolBarManager().add(syncSelectionAction);
	}

	public void createPartControl(Composite parent) {
		canvas = new FigureCanvas(parent);
		mediator = new DashboardMediator(parent.getShell());
		DashboardFigure contents = new DashboardFigure();
		mediator.setView(contents);
		canvas.setContents(contents);
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(projectUpdater = new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				updateActiveProject(selection);
			}
		});
		if (syncSelection) {
			updateActiveProject(getSite().getWorkbenchWindow().getSelectionService().getSelection());
		}
		if (mediator.getProject() == null && activeProjectName != null) {
			IProject activeProject = ResourcesPlugin.getWorkspace().getRoot().getProject(activeProjectName);
			if (activeProject.exists()) {
				mediator.setProjectAndState(activeProject, (DashboardState) states.get(activeProject));
			}
		}
	}

	public void saveState(IMemento memento) {
		super.saveState(memento);
		if (mediator != null && mediator.getProject() != null) {
			states.put(mediator.getProject(), mediator.getState());
			memento.putString(ACTIVE_PROJECT_KEY, mediator.getProject().getName());
			if (!syncSelection) {
				memento.putString(SYNC_SELECTION_KEY, String.valueOf(syncSelection));
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

	protected void updateActiveProject(ISelection selection) {
		if (!syncSelection || !(selection instanceof IStructuredSelection)) {
			return;
		}
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
			if (project.equals(mediator.getProject())) {
				// if current active project is selected do not change it
				return;
			}
			if (activeProject == null) {
				// new active project is the first selected project
				activeProject = project;
			}
		}
		if (activeProject != null) {
			if (mediator.getProject() != null) {
				states.put(mediator.getProject(), mediator.getState());
			}
			mediator.setProjectAndState(activeProject, (DashboardState) states.get(activeProject));
		}
	}
}
