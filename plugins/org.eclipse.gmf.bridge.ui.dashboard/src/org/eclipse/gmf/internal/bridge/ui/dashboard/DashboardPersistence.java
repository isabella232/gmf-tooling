/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.ui.dashboard;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gmf.bridge.ui.dashboard.DashboardState;
import org.eclipse.ui.IMemento;

/**
 * @author dstadnik
 */
public class DashboardPersistence {

	private static final String DS_ELEMENT = "dashboardState"; //$NON-NLS-1$

	private static final String PROJECT_KEY = "project"; //$NON-NLS-1$

	public static Map<IProject, DashboardState> read(IMemento memento) {
		Map<IProject, DashboardState> states = new HashMap<IProject, DashboardState>();
		for (IMemento stateMemento : memento.getChildren(DS_ELEMENT)) {
			String projectName = stateMemento.getString(PROJECT_KEY);
			if (projectName == null) {
				continue;
			}
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (!project.exists()) {
				continue;
			}
			states.put(project, new DashboardState(stateMemento));
		}
		return states;
	}

	public static void write(IMemento memento, Map<IProject, DashboardState> states) {
		for (IProject project : states.keySet()) {
			DashboardState state = states.get(project);
			IMemento stateMemento = memento.createChild(DS_ELEMENT);
			stateMemento.putString(PROJECT_KEY, project.getName());
			state.write(stateMemento);
		}
	}
}
