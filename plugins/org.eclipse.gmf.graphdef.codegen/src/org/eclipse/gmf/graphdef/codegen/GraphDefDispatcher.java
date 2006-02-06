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
package org.eclipse.gmf.graphdef.codegen;

import org.eclipse.gmf.common.codegen.ImportAssistant;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.util.GMFGraphSwitch;
import org.eclipse.gmf.internal.codegen.dispatch.DispatcherImpl;
import org.eclipse.gmf.internal.codegen.dispatch.EmitterFactory;
import org.eclipse.gmf.internal.codegen.dispatch.KeyMap;

/**
 * @author artem
 */
public class GraphDefDispatcher extends DispatcherImpl {
	private final ImportAssistant myImportManager;
	private final GMFGraphSwitch myFqnSwitch;

	public GraphDefDispatcher(EmitterFactory factory, KeyMap keyMap, ImportAssistant importManager, GMFGraphSwitch fqnSwitch) {
		super(factory, keyMap);
		myImportManager = importManager;
		myFqnSwitch = fqnSwitch;
	}

	public ImportAssistant getImportManager() {
		return myImportManager;
	}

	public GMFGraphSwitch getFQNSwitch() {
		return myFqnSwitch;
	}


	public Args create(Figure figure, String figureVarName) {
		return new Args(this, figure, figureVarName);
	}

	public static class Args {
		private final Figure myFigure;
		private final String myFigureVarName;
		private final GraphDefDispatcher myOwner;

		public Args(GraphDefDispatcher owner, Figure figure, String figureVarName) {
			myOwner = owner;
			myFigure = figure;
			myFigureVarName = figureVarName;
		}

		public Figure getFigure() {
			return myFigure;
		}

		public String getVariableName() {
			return myFigureVarName;
		}

		public GraphDefDispatcher getDispatcher() {
			return myOwner;
		}
	}
}
